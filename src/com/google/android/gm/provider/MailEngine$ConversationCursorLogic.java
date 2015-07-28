package com.google.android.gm.provider;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gsf.Gservices;
import com.google.common.collect.Lists;
import java.util.List;

class MailEngine$ConversationCursorLogic
  extends MailEngine.NetworkCursorLogic
  implements MailSync.ConversationSink
{
  private final boolean mBackwardsCompatMode;
  private int mFetchThreshold = 0;
  private final GmailQuery mGmailQuery;
  boolean mIsActiveNetworkCursor;
  private final MailCore.Label mLabel;
  private int mLimit;
  private final int mMaxResults = Gservices.getInt(MailEngine.access$2300(this$0).getContentResolver(), "gmail_live_max_results", 22);
  long mMaxUnsyncedMessageId;
  private boolean mNeedToPurgeConversations = false;
  private volatile long mNextHighestMessageId;
  private final String mQuery;
  private boolean mReceivedServerResults = false;
  private final boolean mSearchQuery;
  private final String mSqlFmt;
  private final int mThresholdMax = Gservices.getInt(MailEngine.access$2300(this$0).getContentResolver(), "gmail_live_threshold_max", 100);
  private final int mThresholdStep = Gservices.getInt(MailEngine.access$2300(this$0).getContentResolver(), "gmail_live_threshold_step", 10);
  
  public MailEngine$ConversationCursorLogic(MailEngine paramMailEngine, String paramString, boolean paramBoolean1, Integer paramInteger, boolean paramBoolean2)
  {
    super(paramMailEngine);
    mBackwardsCompatMode = paramBoolean2;
    mIsActiveNetworkCursor = paramBoolean1;
    if (paramBoolean1)
    {
      mNeedToPurgeConversations = true;
      if (mMailCore.getLabelOrNull("^i") != null)
      {
        MailEngine.access$3702(paramMailEngine, paramString);
        MailEngine.access$4002(paramMailEngine, this);
      }
    }
    mQuery = paramString;
    mLabel = mMailCore.getLabelOrNull(labelNameFromQuery(mQuery));
    mMaxUnsyncedMessageId = mMailSync.getMaxUnsyncedMessageIdForLabel(mLabel);
    mNextHighestMessageId = mMaxUnsyncedMessageId;
    if (mLabel != null)
    {
      paramMailEngine = "conversation_labels.conversation_id IN\n(SELECT DISTINCT conversation_labels.conversation_id\n   FROM conversation_labels\n WHERE conversation_labels.labels_id = ?\n ORDER BY conversation_labels.sortMessageId DESC\n LIMIT ?)\n   AND conversation_labels.labels_id = ? \n   AND (((conversations.maxMessageId >= ?           OR conversations.maxMessageId = 0)\n        AND conversation_labels.queryId = 0)\n     OR (conversations.maxMessageId < ?\n        AND conversation_labels.queryId = ?))";
      mGmailQuery = null;
      mSearchQuery = false;
      setLimit(paramInteger);
      setSelectionArgs();
      mSqlFmt = ("SELECT conversation_labels.*, conversations.*, conversations.queryId = 0 AS synced, (SELECT group_concat((labels._id || '^*^' || labels.canonicalName || '^*^' || \n(CASE labels.canonicalName    WHEN '^f' THEN ?    WHEN '^^out' THEN ?    WHEN '^i' THEN ?    WHEN '^r' THEN ?    WHEN '^b' THEN ?    WHEN '^all' THEN ?    WHEN '^u' THEN ?    WHEN '^k' THEN ?    WHEN '^s' THEN ?    WHEN '^t' THEN ?    WHEN '^g' THEN ?    WHEN '^io_im' THEN ?    WHEN '^iim' THEN ?    ELSE labels.name END)  || '^*^' || labels.color || '^*^' || labels.hidden),    '^**^') FROM labels JOIN conversation_labels  ON conversation_labels.labels_id = labels._id  AND conversation_labels.conversation_id = conversations._id AND conversation_labels.isZombie = 0) AS conversationLabels   FROM conversation_labels\n  LEFT OUTER JOIN conversations\n  ON conversation_labels.conversation_id = conversations._id\n  AND conversation_labels.queryId = conversations.queryId\nWHERE\n  (" + paramMailEngine + ")\n" + "  AND isZombie = 0\n" + "GROUP BY conversations._id\nORDER BY conversation_labels.sortMessageId DESC\n" + "LIMIT ?");
      return;
    }
    paramBoolean1 = paramMailEngine.isFullTextSearchEnabled();
    mSearchQuery = true;
    mGmailQuery = new GmailQuery(mMailCore, access$800name, mQuery, paramBoolean1);
    paramMailEngine = mGmailQuery.getQueryLikeClause();
    if ((!mBackwardsCompatMode) && (!TextUtils.isEmpty(paramMailEngine))) {}
    for (paramMailEngine = "conversation_labels.queryId = ? OR  (conversation_labels.queryId = 0 AND (" + paramMailEngine + "))";; paramMailEngine = "conversation_labels.queryId = ?") {
      break;
    }
  }
  
  private void clearMatchingNotifications()
  {
    if (mLabel != null) {
      this$0.clearNewUnreadMailForNotificationLabelIfNeeded(mLabel);
    }
  }
  
  private String[] getConversationQueryArgs(Context paramContext, MailCore.Label paramLabel, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLabel != null) {
      return QueryUtils.argListWithLabelNames(paramContext, new String[] { Long.toString(id), Integer.toString(paramInt), Long.toString(id), Long.toString(paramLong1), Long.toString(paramLong1), Long.toString(paramLong2), Integer.toString(paramInt) });
    }
    paramLabel = Lists.newArrayList(new String[] { Long.toString(paramLong2) });
    if (!mBackwardsCompatMode) {
      paramLabel.addAll(mGmailQuery.getQueryBindArgs());
    }
    paramLabel.add(Integer.toString(paramInt));
    return QueryUtils.argListWithLabelNames(paramContext, (String[])paramLabel.toArray(new String[paramLabel.size()]));
  }
  
  private int getLimit()
  {
    return mLimit;
  }
  
  private String labelNameFromQuery(String paramString)
  {
    if (paramString.startsWith("label:")) {
      return paramString.substring("label:".length());
    }
    return null;
  }
  
  private void maybeFetchMoreResults(int paramInt, MailEngine.NetworkCursor paramNetworkCursor)
  {
    if (!isActiveNetworkCursor()) {}
    do
    {
      int i;
      do
      {
        return;
        i = paramNetworkCursor.getCount();
      } while ((getIsInErrorState()) || ((paramInt + 1 < i - mFetchThreshold) && ((!mSearchQuery) || (mReceivedServerResults))) || (i >= 2500) || (mNextHighestMessageId <= 0L) || (mFetcherThread != null));
      if (mThresholdMax > 0) {
        LogUtils.v("Gmail", "Prefetching live mail: maxResults: %d pos: %d count: %d threshold: %d", new Object[] { Integer.valueOf(mMaxResults), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(mFetchThreshold) });
      }
    } while (!startThread());
    notifyDataSetChanges();
  }
  
  private void maybeSheduleSync()
  {
    if (!isActiveNetworkCursor()) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!ContentResolver.isSyncPending(MailEngine.access$800(this$0), "gmail-ls"));
      i = Gservices.getInt(MailEngine.access$2300(this$0).getContentResolver(), "gmail-sync-thread-interval", 1800000);
    } while (SystemClock.elapsedRealtime() - MailEngine.access$4100(this$0) <= i);
    MailEngine.access$4102(this$0, SystemClock.elapsedRealtime());
    startSyncThread();
  }
  
  private void notifyDataSetChanges()
  {
    boolean bool = false;
    MailEngine.access$3500(this$0, false);
    UiProvider.broadcastAccountChangeNotification(MailEngine.access$2300(this$0), access$800this$0).name);
    if (mLabel != null) {}
    for (String str = mLabel.canonicalName;; str = null)
    {
      if (mLabel == null) {
        bool = true;
      }
      UiProvider.broadcastAccountFolderChangeNotification(MailEngine.access$2300(this$0), access$800this$0).name, bool, str);
      return;
    }
  }
  
  private void setLimit(Integer paramInteger)
  {
    if (paramInteger != null) {}
    for (int i = paramInteger.intValue();; i = 2500)
    {
      mLimit = i;
      return;
    }
  }
  
  private void setSelectionArgs()
  {
    setSelectionArguments(getConversationQueryArgs(MailEngine.access$2300(this$0), mLabel, mMaxUnsyncedMessageId, mQueryId, getLimit()));
  }
  
  public void configure(MailEngine.NetworkCursor paramNetworkCursor)
  {
    maybeFetchMoreResults(paramNetworkCursor.getPosition(), paramNetworkCursor);
    maybeSheduleSync();
  }
  
  public void finalizeSink()
  {
    this$0.mTransaction.setTransactionSuccessful();
    this$0.mTransaction.endTransaction();
  }
  
  public Bundle getExtras()
  {
    Bundle localBundle = super.getExtras();
    if ((mSearchQuery) && (!mReceivedServerResults))
    {
      Gmail.CursorStatus localCursorStatus = Gmail.CursorStatus.valueOf(localBundle.getString("status"));
      if (((!mBackwardsCompatMode) && (localCursorStatus == Gmail.CursorStatus.LOADING)) || (localCursorStatus == Gmail.CursorStatus.LOADED)) {
        localBundle.putString("status", Gmail.CursorStatus.SEARCHING.toString());
      }
    }
    localBundle.putBoolean("active_network_query", isActiveNetworkCursor());
    if (mLabel != null) {
      localBundle.putString("label_canonical_name", mLabel.canonicalName);
    }
    return localBundle;
  }
  
  public String getQuery()
  {
    return mQuery;
  }
  
  public String getSql()
  {
    return mSqlFmt;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return true;
  }
  
  public void handleConversation(MailSync.Conversation paramConversation)
  {
    mNextHighestMessageId = (this$0.handleConversation(paramConversation, mQueryId, mLabel) - 1L);
  }
  
  public boolean isActiveNetworkCursor()
  {
    return (TextUtils.equals(getQuery(), MailEngine.access$3700(this$0))) && (mIsActiveNetworkCursor);
  }
  
  public boolean isCursorComplete()
  {
    return mNextHighestMessageId <= 0L;
  }
  
  public void onMove(int paramInt1, int paramInt2, MailEngine.NetworkCursor paramNetworkCursor)
  {
    maybeFetchMoreResults(paramInt2, paramNetworkCursor);
  }
  
  public void prepareSink()
  {
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    this$0.mTransaction.suppressUiNotifications();
  }
  
  void purgeConversationsIfNeeded()
  {
    if (mNeedToPurgeConversations)
    {
      mNeedToPurgeConversations = false;
      if (MailEngine.sConversationPurgeTask != null) {
        MailEngine.sConversationPurgeTask.cancel(false);
      }
      MailEngine.sConversationPurgeTask = new PurgeStaleConversationsTask(mQueryId);
      MailEngine.sConversationPurgeTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }
  }
  
  public void requery(MailEngine.NetworkCursor paramNetworkCursor, boolean paramBoolean)
  {
    long l2 = this$0.mMailSync.getMaxUnsyncedMessageIdForLabel(mLabel);
    if (mMaxUnsyncedMessageId != l2)
    {
      long l1 = l2;
      if (mMaxUnsyncedMessageId < l2) {
        l1 = mMaxUnsyncedMessageId;
      }
      mMaxUnsyncedMessageId = l1;
      setSelectionArguments(getConversationQueryArgs(MailEngine.access$2300(this$0), mLabel, mMaxUnsyncedMessageId, mQueryId, getLimit()));
    }
    if (paramBoolean) {
      clearMatchingNotifications();
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   4: invokestatic 510	com/google/android/gm/provider/MailEngine:access$4300	(Lcom/google/android/gm/provider/MailEngine;)V
    //   7: lconst_0
    //   8: lstore_1
    //   9: iconst_0
    //   10: istore 5
    //   12: iconst_0
    //   13: istore 6
    //   15: ldc_w 298
    //   18: iconst_3
    //   19: invokestatic 514	com/google/android/gm/provider/LogUtils:isLoggable	(Ljava/lang/String;I)Z
    //   22: ifeq +30 -> 52
    //   25: invokestatic 336	android/os/SystemClock:elapsedRealtime	()J
    //   28: lstore_1
    //   29: aload_0
    //   30: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   33: invokestatic 518	com/google/android/gm/provider/MailEngine:access$3100	(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Thread;
    //   36: ifnull +220 -> 256
    //   39: iconst_1
    //   40: istore 5
    //   42: aload_0
    //   43: getfield 296	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   46: ifnull +216 -> 262
    //   49: iconst_1
    //   50: istore 6
    //   52: aload_0
    //   53: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   56: invokestatic 522	com/google/android/gm/provider/MailEngine:access$3200	(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    //   59: astore 7
    //   61: aload 7
    //   63: monitorenter
    //   64: ldc_w 298
    //   67: iconst_3
    //   68: invokestatic 514	com/google/android/gm/provider/LogUtils:isLoggable	(Ljava/lang/String;I)Z
    //   71: ifeq +54 -> 125
    //   74: invokestatic 336	android/os/SystemClock:elapsedRealtime	()J
    //   77: lload_1
    //   78: lsub
    //   79: lstore_3
    //   80: lload_3
    //   81: ldc2_w 523
    //   84: lcmp
    //   85: ifle +40 -> 125
    //   88: ldc_w 298
    //   91: ldc_w 526
    //   94: iconst_3
    //   95: anewarray 302	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: lload_3
    //   101: invokestatic 529	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: iload 5
    //   109: invokestatic 534	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: iload 6
    //   117: invokestatic 534	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   120: aastore
    //   121: invokestatic 537	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   124: pop
    //   125: aload_0
    //   126: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   129: iconst_0
    //   130: invokestatic 541	com/google/android/gm/provider/MailEngine:access$4402	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   138: aconst_null
    //   139: iconst_1
    //   140: new 543	com/google/android/gm/provider/MailEngine$SyncInfo
    //   143: dup
    //   144: invokespecial 544	com/google/android/gm/provider/MailEngine$SyncInfo:<init>	()V
    //   147: aconst_null
    //   148: aconst_null
    //   149: invokestatic 548	com/google/android/gm/provider/MailEngine:access$3300	(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;ZLcom/google/android/gm/provider/MailEngine$SyncInfo;Landroid/content/SyncResult;Landroid/os/Bundle;)Z
    //   152: pop
    //   153: aload 7
    //   155: monitorexit
    //   156: ldc_w 298
    //   159: iconst_3
    //   160: invokestatic 514	com/google/android/gm/provider/LogUtils:isLoggable	(Ljava/lang/String;I)Z
    //   163: ifeq +38 -> 201
    //   166: invokestatic 336	android/os/SystemClock:elapsedRealtime	()J
    //   169: lload_1
    //   170: lsub
    //   171: lstore_1
    //   172: lload_1
    //   173: ldc2_w 523
    //   176: lcmp
    //   177: ifle +24 -> 201
    //   180: ldc_w 298
    //   183: ldc_w 550
    //   186: iconst_1
    //   187: anewarray 302	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: lload_1
    //   193: invokestatic 529	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   196: aastore
    //   197: invokestatic 537	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   200: pop
    //   201: aload_0
    //   202: invokevirtual 553	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:runInternal	()V
    //   205: aload_0
    //   206: iconst_0
    //   207: putfield 556	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mErrorOccurred	Z
    //   210: aload_0
    //   211: getstatic 562	com/google/android/gm/provider/Gmail$CursorError:NO_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   214: putfield 565	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   217: aload_0
    //   218: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   221: iconst_0
    //   222: invokestatic 569	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   225: aload_0
    //   226: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   229: iconst_1
    //   230: invokestatic 572	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   233: pop
    //   234: aload_0
    //   235: invokespecial 318	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:notifyDataSetChanges	()V
    //   238: aload_0
    //   239: getfield 576	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThreadLock	Ljava/lang/Object;
    //   242: astore 7
    //   244: aload 7
    //   246: monitorenter
    //   247: aload_0
    //   248: aconst_null
    //   249: putfield 296	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   252: aload 7
    //   254: monitorexit
    //   255: return
    //   256: iconst_0
    //   257: istore 5
    //   259: goto -217 -> 42
    //   262: iconst_0
    //   263: istore 6
    //   265: goto -213 -> 52
    //   268: astore 8
    //   270: aload 7
    //   272: monitorexit
    //   273: aload 8
    //   275: athrow
    //   276: astore 7
    //   278: ldc_w 298
    //   281: ldc_w 578
    //   284: iconst_1
    //   285: anewarray 302	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: aload 7
    //   292: invokevirtual 581	java/io/IOException:getMessage	()Ljava/lang/String;
    //   295: aastore
    //   296: invokestatic 584	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   299: pop
    //   300: aload_0
    //   301: iconst_1
    //   302: putfield 556	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mErrorOccurred	Z
    //   305: aload_0
    //   306: getstatic 587	com/google/android/gm/provider/Gmail$CursorError:IO_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   309: putfield 565	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   312: aload_0
    //   313: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   316: iconst_1
    //   317: invokestatic 569	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   320: aload_0
    //   321: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   324: iconst_1
    //   325: invokestatic 572	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   328: pop
    //   329: goto -95 -> 234
    //   332: astore 7
    //   334: ldc_w 298
    //   337: ldc_w 589
    //   340: iconst_1
    //   341: anewarray 302	java/lang/Object
    //   344: dup
    //   345: iconst_0
    //   346: aload 7
    //   348: invokevirtual 590	com/google/android/gm/provider/MailEngine$AuthenticationException:getMessage	()Ljava/lang/String;
    //   351: aastore
    //   352: invokestatic 584	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   355: pop
    //   356: aload_0
    //   357: iconst_1
    //   358: putfield 556	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mErrorOccurred	Z
    //   361: aload_0
    //   362: getstatic 593	com/google/android/gm/provider/Gmail$CursorError:AUTH_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   365: putfield 565	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   368: aload_0
    //   369: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   372: iconst_2
    //   373: invokestatic 569	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   376: aload_0
    //   377: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   380: iconst_1
    //   381: invokestatic 572	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   384: pop
    //   385: goto -151 -> 234
    //   388: astore 7
    //   390: ldc_w 298
    //   393: ldc_w 595
    //   396: iconst_1
    //   397: anewarray 302	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: aload 7
    //   404: invokevirtual 596	com/google/android/gm/provider/MailSync$ResponseParseException:getMessage	()Ljava/lang/String;
    //   407: aastore
    //   408: invokestatic 584	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   411: pop
    //   412: aload_0
    //   413: iconst_1
    //   414: putfield 556	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mErrorOccurred	Z
    //   417: aload_0
    //   418: getstatic 599	com/google/android/gm/provider/Gmail$CursorError:PARSE_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   421: putfield 565	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   424: aload_0
    //   425: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   428: iconst_5
    //   429: invokestatic 569	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   432: aload_0
    //   433: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   436: iconst_1
    //   437: invokestatic 572	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   440: pop
    //   441: goto -207 -> 234
    //   444: astore 7
    //   446: ldc_w 298
    //   449: ldc_w 601
    //   452: iconst_1
    //   453: anewarray 302	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: aload 7
    //   460: invokevirtual 602	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   463: aastore
    //   464: invokestatic 584	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   467: pop
    //   468: aload_0
    //   469: iconst_1
    //   470: putfield 556	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mErrorOccurred	Z
    //   473: aload_0
    //   474: getstatic 605	com/google/android/gm/provider/Gmail$CursorError:DB_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   477: putfield 565	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   480: aload_0
    //   481: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   484: iconst_5
    //   485: invokestatic 569	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   488: aload_0
    //   489: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   492: iconst_1
    //   493: invokestatic 572	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   496: pop
    //   497: goto -263 -> 234
    //   500: astore 7
    //   502: aload_0
    //   503: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   506: iconst_1
    //   507: invokestatic 572	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   510: pop
    //   511: aload 7
    //   513: athrow
    //   514: astore 8
    //   516: aload 7
    //   518: monitorexit
    //   519: aload 8
    //   521: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	522	0	this	ConversationCursorLogic
    //   8	185	1	l1	long
    //   79	22	3	l2	long
    //   10	248	5	bool1	boolean
    //   13	251	6	bool2	boolean
    //   276	15	7	localIOException	java.io.IOException
    //   332	15	7	localAuthenticationException	MailEngine.AuthenticationException
    //   388	15	7	localResponseParseException	MailSync.ResponseParseException
    //   444	15	7	localSQLiteException	android.database.sqlite.SQLiteException
    //   500	17	7	localObject2	Object
    //   268	6	8	localObject3	Object
    //   514	6	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   64	80	268	finally
    //   88	125	268	finally
    //   125	156	268	finally
    //   270	273	268	finally
    //   0	7	276	java/io/IOException
    //   15	39	276	java/io/IOException
    //   42	49	276	java/io/IOException
    //   52	64	276	java/io/IOException
    //   156	172	276	java/io/IOException
    //   180	201	276	java/io/IOException
    //   201	225	276	java/io/IOException
    //   273	276	276	java/io/IOException
    //   0	7	332	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   15	39	332	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   42	49	332	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   52	64	332	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   156	172	332	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   180	201	332	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   201	225	332	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   273	276	332	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   0	7	388	com/google/android/gm/provider/MailSync$ResponseParseException
    //   15	39	388	com/google/android/gm/provider/MailSync$ResponseParseException
    //   42	49	388	com/google/android/gm/provider/MailSync$ResponseParseException
    //   52	64	388	com/google/android/gm/provider/MailSync$ResponseParseException
    //   156	172	388	com/google/android/gm/provider/MailSync$ResponseParseException
    //   180	201	388	com/google/android/gm/provider/MailSync$ResponseParseException
    //   201	225	388	com/google/android/gm/provider/MailSync$ResponseParseException
    //   273	276	388	com/google/android/gm/provider/MailSync$ResponseParseException
    //   0	7	444	android/database/sqlite/SQLiteException
    //   15	39	444	android/database/sqlite/SQLiteException
    //   42	49	444	android/database/sqlite/SQLiteException
    //   52	64	444	android/database/sqlite/SQLiteException
    //   156	172	444	android/database/sqlite/SQLiteException
    //   180	201	444	android/database/sqlite/SQLiteException
    //   201	225	444	android/database/sqlite/SQLiteException
    //   273	276	444	android/database/sqlite/SQLiteException
    //   0	7	500	finally
    //   15	39	500	finally
    //   42	49	500	finally
    //   52	64	500	finally
    //   156	172	500	finally
    //   180	201	500	finally
    //   201	225	500	finally
    //   273	276	500	finally
    //   278	320	500	finally
    //   334	376	500	finally
    //   390	432	500	finally
    //   446	488	500	finally
    //   247	255	514	finally
    //   516	519	514	finally
  }
  
  /* Error */
  protected void runInternal()
    throws java.io.IOException, MailEngine.AuthenticationException, MailSync.ResponseParseException
  {
    // Byte code:
    //   0: invokestatic 610	com/google/android/gm/provider/Gmail:isRunningICSOrLater	()Z
    //   3: ifeq +23 -> 26
    //   6: aload_0
    //   7: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   10: invokestatic 171	com/google/android/gm/provider/MailEngine:access$800	(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;
    //   13: getfield 176	android/accounts/Account:name	Ljava/lang/String;
    //   16: invokestatic 616	com/google/android/common/GoogleTrafficStats:getDomainType	(Ljava/lang/String;)I
    //   19: ldc_w 617
    //   22: ior
    //   23: invokestatic 623	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   26: aload_0
    //   27: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   30: iconst_2
    //   31: iconst_1
    //   32: invokestatic 627	com/google/android/gm/provider/MailEngine:access$400	(Lcom/google/android/gm/provider/MailEngine;IZ)V
    //   35: aload_0
    //   36: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   39: getfield 113	com/google/android/gm/provider/MailEngine:mMailSync	Lcom/google/android/gm/provider/MailSync;
    //   42: aload_0
    //   43: getfield 103	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mQuery	Ljava/lang/String;
    //   46: aload_0
    //   47: getfield 123	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mNextHighestMessageId	J
    //   50: aload_0
    //   51: getfield 67	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mMaxResults	I
    //   54: iconst_5
    //   55: invokevirtual 631	com/google/android/gm/provider/MailSync:newQueryRequest	(Ljava/lang/String;JII)Lorg/apache/http/client/methods/HttpUriRequest;
    //   58: astore_1
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 77	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mFetchThreshold	I
    //   64: aload_0
    //   65: getfield 71	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mThresholdStep	I
    //   68: iadd
    //   69: aload_0
    //   70: getfield 75	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mThresholdMax	I
    //   73: invokestatic 637	java/lang/Math:min	(II)I
    //   76: putfield 77	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mFetchThreshold	I
    //   79: aload_0
    //   80: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   83: aload_1
    //   84: invokestatic 641	com/google/android/gm/provider/MailEngine:access$4200	(Lcom/google/android/gm/provider/MailEngine;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   87: astore_1
    //   88: aload_0
    //   89: monitorenter
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   95: getfield 113	com/google/android/gm/provider/MailEngine:mMailSync	Lcom/google/android/gm/provider/MailSync;
    //   98: aload_1
    //   99: aload_0
    //   100: invokevirtual 645	com/google/android/gm/provider/MailSync:handleQueryResponse	(Lorg/apache/http/HttpResponse;Lcom/google/android/gm/provider/MailSync$ConversationSink;)J
    //   103: putfield 123	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mNextHighestMessageId	J
    //   106: aload_0
    //   107: iconst_1
    //   108: putfield 45	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:mReceivedServerResults	Z
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: invokeinterface 651 1 0
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +9 -> 130
    //   124: aload_1
    //   125: invokeinterface 656 1 0
    //   130: aload_0
    //   131: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   134: iconst_2
    //   135: iconst_0
    //   136: invokestatic 627	com/google/android/gm/provider/MailEngine:access$400	(Lcom/google/android/gm/provider/MailEngine;IZ)V
    //   139: invokestatic 610	com/google/android/gm/provider/Gmail:isRunningICSOrLater	()Z
    //   142: ifeq +13 -> 155
    //   145: ldc_w 617
    //   148: iconst_1
    //   149: invokestatic 660	android/net/TrafficStats:incrementOperationCount	(II)V
    //   152: invokestatic 663	android/net/TrafficStats:clearThreadStatsTag	()V
    //   155: return
    //   156: astore_2
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: astore_2
    //   162: aload_1
    //   163: invokeinterface 651 1 0
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +9 -> 179
    //   173: aload_1
    //   174: invokeinterface 656 1 0
    //   179: aload_2
    //   180: athrow
    //   181: astore_1
    //   182: aload_0
    //   183: getfield 40	com/google/android/gm/provider/MailEngine$ConversationCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   186: iconst_2
    //   187: iconst_0
    //   188: invokestatic 627	com/google/android/gm/provider/MailEngine:access$400	(Lcom/google/android/gm/provider/MailEngine;IZ)V
    //   191: invokestatic 610	com/google/android/gm/provider/Gmail:isRunningICSOrLater	()Z
    //   194: ifeq +13 -> 207
    //   197: ldc_w 617
    //   200: iconst_1
    //   201: invokestatic 660	android/net/TrafficStats:incrementOperationCount	(II)V
    //   204: invokestatic 663	android/net/TrafficStats:clearThreadStatsTag	()V
    //   207: aload_1
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	ConversationCursorLogic
    //   58	116	1	localObject1	Object
    //   181	27	1	localObject2	Object
    //   156	4	2	localObject3	Object
    //   161	19	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   90	113	156	finally
    //   157	159	156	finally
    //   88	90	161	finally
    //   159	161	161	finally
    //   26	88	181	finally
    //   113	120	181	finally
    //   124	130	181	finally
    //   162	169	181	finally
    //   173	179	181	finally
    //   179	181	181	finally
  }
  
  protected final void startSyncThread()
  {
    if ((MailEngine.access$3100(this$0) == null) && (mFetcherThread == null) && (!MailEngine.access$3600(this$0))) {
      synchronized (MailEngine.access$3400(this$0))
      {
        if (MailEngine.access$3100(this$0) == null)
        {
          MailEngine.access$3102(this$0, new Thread(new MailEngine.SyncThread(this$0)));
          MailEngine.access$3100(this$0).start();
        }
        return;
      }
    }
  }
  
  class PurgeStaleConversationsTask
    extends AsyncTask<Void, Void, Void>
  {
    private final long mCurrentQueryId;
    
    public PurgeStaleConversationsTask(long paramLong)
    {
      mCurrentQueryId = paramLong;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      this$0.mTransaction.beginTransactionNonExclusive();
      try
      {
        paramVarArgs = new String[1];
        paramVarArgs[0] = Long.toString(mCurrentQueryId);
        this$0.mDb.delete("conversations", "queryId != 0 AND queryId != ?", paramVarArgs);
        this$0.mDb.delete("conversation_labels", "queryId != 0 AND queryId != ?", paramVarArgs);
        this$0.mTransaction.setTransactionSuccessful();
        return null;
      }
      finally
      {
        this$0.mTransaction.endTransaction();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.ConversationCursorLogic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */