package com.android.mail.compose;

import android.content.Context;

public class ComposeActivity$SendOrSaveTask
  implements Runnable
{
  private final Context mContext;
  public final ComposeActivity.SendOrSaveCallback mSendOrSaveCallback;
  public final ComposeActivity.SendOrSaveMessage mSendOrSaveMessage;
  
  public ComposeActivity$SendOrSaveTask(Context paramContext, ComposeActivity.SendOrSaveMessage paramSendOrSaveMessage, ComposeActivity.SendOrSaveCallback paramSendOrSaveCallback)
  {
    mContext = paramContext;
    mSendOrSaveCallback = paramSendOrSaveCallback;
    mSendOrSaveMessage = paramSendOrSaveMessage;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mSendOrSaveMessage	Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;
    //   4: astore 6
    //   6: aload 6
    //   8: getfield 34	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mAccount	Lcom/android/mail/providers/ReplyFromAccount;
    //   11: astore 5
    //   13: aload_0
    //   14: getfield 24	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mSendOrSaveCallback	Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    //   17: invokeinterface 40 1 0
    //   22: astore 7
    //   24: aload 7
    //   26: ifnull +240 -> 266
    //   29: aload 7
    //   31: getfield 46	com/android/mail/providers/Message:id	J
    //   34: lstore_1
    //   35: lload_1
    //   36: lstore_3
    //   37: aload 5
    //   39: aload 6
    //   41: getfield 34	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mAccount	Lcom/android/mail/providers/ReplyFromAccount;
    //   44: invokevirtual 50	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   47: ifne +75 -> 122
    //   50: lload_1
    //   51: lstore_3
    //   52: lload_1
    //   53: ldc2_w 51
    //   56: lcmp
    //   57: ifeq +65 -> 122
    //   60: aload_0
    //   61: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
    //   64: invokevirtual 58	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   67: astore 8
    //   69: new 60	android/content/ContentValues
    //   72: dup
    //   73: invokespecial 61	android/content/ContentValues:<init>	()V
    //   76: astore 9
    //   78: aload 9
    //   80: ldc 63
    //   82: lload_1
    //   83: invokestatic 69	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   86: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   89: aload 5
    //   91: getfield 79	com/android/mail/providers/ReplyFromAccount:account	Lcom/android/mail/providers/Account;
    //   94: getfield 85	com/android/mail/providers/Account:expungeMessageUri	Landroid/net/Uri;
    //   97: ifnull +21 -> 118
    //   100: aload 8
    //   102: aload 5
    //   104: getfield 79	com/android/mail/providers/ReplyFromAccount:account	Lcom/android/mail/providers/Account;
    //   107: getfield 85	com/android/mail/providers/Account:expungeMessageUri	Landroid/net/Uri;
    //   110: aload 9
    //   112: aconst_null
    //   113: aconst_null
    //   114: invokevirtual 91	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: pop
    //   118: ldc2_w 51
    //   121: lstore_3
    //   122: lload_3
    //   123: ldc2_w 51
    //   126: lcmp
    //   127: ifeq +156 -> 283
    //   130: aload 6
    //   132: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
    //   135: ldc 63
    //   137: lload_3
    //   138: invokestatic 69	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   144: aload_0
    //   145: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
    //   148: invokevirtual 58	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   151: astore 8
    //   153: aload 6
    //   155: getfield 99	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mSave	Z
    //   158: ifeq +115 -> 273
    //   161: aload 7
    //   163: getfield 103	com/android/mail/providers/Message:saveUri	Ljava/lang/String;
    //   166: astore 5
    //   168: aload 8
    //   170: aload 5
    //   172: invokestatic 109	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   175: aload 6
    //   177: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
    //   180: aconst_null
    //   181: aconst_null
    //   182: invokevirtual 91	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   185: pop
    //   186: aload 6
    //   188: getfield 99	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mSave	Z
    //   191: ifne +63 -> 254
    //   194: aload_0
    //   195: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
    //   198: aload 6
    //   200: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
    //   203: ldc 111
    //   205: invokevirtual 115	android/content/ContentValues:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   208: checkcast 117	java/lang/String
    //   211: invokestatic 123	com/android/mail/providers/UIProvider:incrementRecipientsTimesContacted	(Landroid/content/Context;Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
    //   218: aload 6
    //   220: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
    //   223: ldc 125
    //   225: invokevirtual 115	android/content/ContentValues:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   228: checkcast 117	java/lang/String
    //   231: invokestatic 123	com/android/mail/providers/UIProvider:incrementRecipientsTimesContacted	(Landroid/content/Context;Ljava/lang/String;)V
    //   234: aload_0
    //   235: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
    //   238: aload 6
    //   240: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
    //   243: ldc 127
    //   245: invokevirtual 115	android/content/ContentValues:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   248: checkcast 117	java/lang/String
    //   251: invokestatic 123	com/android/mail/providers/UIProvider:incrementRecipientsTimesContacted	(Landroid/content/Context;Ljava/lang/String;)V
    //   254: aload_0
    //   255: getfield 24	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mSendOrSaveCallback	Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    //   258: aload_0
    //   259: iconst_1
    //   260: invokeinterface 131 3 0
    //   265: return
    //   266: ldc2_w 51
    //   269: lstore_1
    //   270: goto -235 -> 35
    //   273: aload 7
    //   275: getfield 134	com/android/mail/providers/Message:sendUri	Ljava/lang/String;
    //   278: astore 5
    //   280: goto -112 -> 168
    //   283: aload_0
    //   284: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
    //   287: invokevirtual 58	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   290: astore 7
    //   292: aload 6
    //   294: getfield 99	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mSave	Z
    //   297: ifeq +100 -> 397
    //   300: aload 5
    //   302: getfield 79	com/android/mail/providers/ReplyFromAccount:account	Lcom/android/mail/providers/Account;
    //   305: getfield 137	com/android/mail/providers/Account:saveDraftUri	Landroid/net/Uri;
    //   308: astore 5
    //   310: aload 7
    //   312: aload 5
    //   314: aload 6
    //   316: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
    //   319: invokevirtual 141	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   322: astore 5
    //   324: aload 6
    //   326: getfield 99	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mSave	Z
    //   329: ifeq -143 -> 186
    //   332: aload 5
    //   334: ifnull -148 -> 186
    //   337: aload 7
    //   339: aload 5
    //   341: getstatic 145	com/android/mail/providers/UIProvider:MESSAGE_PROJECTION	[Ljava/lang/String;
    //   344: aconst_null
    //   345: aconst_null
    //   346: aconst_null
    //   347: invokevirtual 149	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   350: astore 5
    //   352: aload 5
    //   354: ifnull -168 -> 186
    //   357: aload 5
    //   359: invokeinterface 155 1 0
    //   364: ifeq +23 -> 387
    //   367: aload_0
    //   368: getfield 24	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mSendOrSaveCallback	Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    //   371: aload 6
    //   373: new 42	com/android/mail/providers/Message
    //   376: dup
    //   377: aload 5
    //   379: invokespecial 158	com/android/mail/providers/Message:<init>	(Landroid/database/Cursor;)V
    //   382: invokeinterface 162 3 0
    //   387: aload 5
    //   389: invokeinterface 165 1 0
    //   394: goto -208 -> 186
    //   397: aload 5
    //   399: getfield 79	com/android/mail/providers/ReplyFromAccount:account	Lcom/android/mail/providers/Account;
    //   402: getfield 168	com/android/mail/providers/Account:sendMessageUri	Landroid/net/Uri;
    //   405: astore 5
    //   407: goto -97 -> 310
    //   410: astore 6
    //   412: aload 5
    //   414: invokeinterface 165 1 0
    //   419: aload 6
    //   421: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	SendOrSaveTask
    //   34	236	1	l1	long
    //   36	102	3	l2	long
    //   11	402	5	localObject1	Object
    //   4	368	6	localSendOrSaveMessage	ComposeActivity.SendOrSaveMessage
    //   410	10	6	localObject2	Object
    //   22	316	7	localObject3	Object
    //   67	102	8	localContentResolver	android.content.ContentResolver
    //   76	35	9	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   357	387	410	finally
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivity.SendOrSaveTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */