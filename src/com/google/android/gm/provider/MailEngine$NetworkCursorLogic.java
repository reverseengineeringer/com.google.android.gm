package com.google.android.gm.provider;

import android.os.Bundle;
import java.io.IOException;

abstract class MailEngine$NetworkCursorLogic
  implements Runnable
{
  protected volatile Gmail.CursorError mError;
  protected volatile boolean mErrorOccurred;
  protected volatile Thread mFetcherThread;
  protected Object mFetcherThreadLock = new Object();
  final long mQueryId;
  private String[] mSelectionArgs = null;
  
  public MailEngine$NetworkCursorLogic(MailEngine paramMailEngine)
  {
    long l = MailEngine.sNextQueryId;
    MailEngine.sNextQueryId = 1L + l;
    mQueryId = l;
    mFetcherThread = null;
    mErrorOccurred = false;
    mError = Gmail.CursorError.NO_ERROR;
  }
  
  protected final void clearErrorState()
  {
    mErrorOccurred = false;
    mError = Gmail.CursorError.NO_ERROR;
  }
  
  public Bundle getExtras()
  {
    Gmail.CursorStatus localCursorStatus;
    if (mFetcherThread != null) {
      localCursorStatus = Gmail.CursorStatus.LOADING;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("status", localCursorStatus.toString());
      localBundle.putString("error", mError.toString());
      return localBundle;
      if (mErrorOccurred) {
        localCursorStatus = Gmail.CursorStatus.ERROR;
      } else if (isCursorComplete()) {
        localCursorStatus = Gmail.CursorStatus.COMPLETE;
      } else {
        localCursorStatus = Gmail.CursorStatus.LOADED;
      }
    }
  }
  
  protected final boolean getIsInErrorState()
  {
    return mErrorOccurred;
  }
  
  public String[] getSelectionArgs()
  {
    return mSelectionArgs;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return false;
  }
  
  public boolean isCursorComplete()
  {
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    for (;;)
    {
      Bundle localBundle;
      try
      {
        String str = paramBundle.getString("command");
        localBundle = new Bundle();
        if (!"retry".equals(str)) {
          break label131;
        }
        boolean bool = paramBundle.getBoolean("force_refresh", false);
        if ((!getIsInErrorState()) && (!bool))
        {
          LogUtils.i("Gmail", "Mail cursor told to retry, but not in error state", new Object[0]);
          localBundle.putString("commandResponse", "ok");
          return localBundle;
        }
        if (mFetcherThread != null)
        {
          LogUtils.i("Gmail", "Mail cursor told to retry, but already fetching", new Object[0]);
          continue;
        }
        LogUtils.i("Gmail", "Mail cursor told to retry, retrying", new Object[0]);
      }
      finally {}
      clearErrorState();
      startThread();
      MailEngine.access$3500(this$0, false);
      continue;
      label131:
      localBundle.putString("commandResponse", "unknownCommand");
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 158	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:runInternal	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 43	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mErrorOccurred	Z
    //   9: aload_0
    //   10: getstatic 48	com/google/android/gm/provider/Gmail$CursorError:NO_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   13: putfield 50	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   16: aload_0
    //   17: getfield 27	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   20: iconst_0
    //   21: invokestatic 162	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   24: getstatic 166	com/google/android/gm/provider/MailEngine:NETWORK_CURSOR_LOGIC_FETCHER_THREADS	Ljava/util/Set;
    //   27: astore_1
    //   28: aload_1
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   34: ifnull +16 -> 50
    //   37: getstatic 166	com/google/android/gm/provider/MailEngine:NETWORK_CURSOR_LOGIC_FETCHER_THREADS	Ljava/util/Set;
    //   40: aload_0
    //   41: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   44: invokeinterface 171 2 0
    //   49: pop
    //   50: aload_1
    //   51: monitorexit
    //   52: aload_0
    //   53: getfield 27	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   56: iconst_0
    //   57: invokestatic 144	com/google/android/gm/provider/MailEngine:access$3500	(Lcom/google/android/gm/provider/MailEngine;Z)V
    //   60: aload_0
    //   61: getfield 32	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThreadLock	Ljava/lang/Object;
    //   64: astore_1
    //   65: aload_1
    //   66: monitorenter
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   72: aload_1
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: ldc 119
    //   78: ldc -83
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_1
    //   87: invokevirtual 176	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 127	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   94: pop
    //   95: aload_0
    //   96: iconst_1
    //   97: putfield 43	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mErrorOccurred	Z
    //   100: aload_0
    //   101: getstatic 179	com/google/android/gm/provider/Gmail$CursorError:IO_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   104: putfield 50	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   107: aload_0
    //   108: getfield 27	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   111: iconst_1
    //   112: invokestatic 162	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   115: goto -91 -> 24
    //   118: astore_1
    //   119: ldc 119
    //   121: ldc -75
    //   123: iconst_1
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_1
    //   130: invokevirtual 182	com/google/android/gm/provider/MailEngine$AuthenticationException:getMessage	()Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 127	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   137: pop
    //   138: aload_0
    //   139: iconst_1
    //   140: putfield 43	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mErrorOccurred	Z
    //   143: aload_0
    //   144: getstatic 185	com/google/android/gm/provider/Gmail$CursorError:AUTH_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   147: putfield 50	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   150: aload_0
    //   151: getfield 27	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   154: iconst_2
    //   155: invokestatic 162	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   158: goto -134 -> 24
    //   161: astore_1
    //   162: ldc 119
    //   164: ldc -69
    //   166: iconst_1
    //   167: anewarray 4	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_1
    //   173: invokevirtual 188	com/google/android/gm/provider/MailSync$ResponseParseException:getMessage	()Ljava/lang/String;
    //   176: aastore
    //   177: invokestatic 127	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   180: pop
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 43	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mErrorOccurred	Z
    //   186: aload_0
    //   187: getstatic 191	com/google/android/gm/provider/Gmail$CursorError:PARSE_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   190: putfield 50	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   193: aload_0
    //   194: getfield 27	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   197: iconst_5
    //   198: invokestatic 162	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   201: goto -177 -> 24
    //   204: astore_1
    //   205: ldc 119
    //   207: ldc -63
    //   209: iconst_1
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_1
    //   216: invokevirtual 194	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   219: aastore
    //   220: invokestatic 127	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   223: pop
    //   224: aload_0
    //   225: iconst_1
    //   226: putfield 43	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mErrorOccurred	Z
    //   229: aload_0
    //   230: getstatic 197	com/google/android/gm/provider/Gmail$CursorError:DB_ERROR	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   233: putfield 50	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mError	Lcom/google/android/gm/provider/Gmail$CursorError;
    //   236: aload_0
    //   237: getfield 27	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   240: iconst_5
    //   241: invokestatic 162	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   244: goto -220 -> 24
    //   247: astore_2
    //   248: aload_1
    //   249: monitorexit
    //   250: aload_2
    //   251: athrow
    //   252: astore_2
    //   253: aload_1
    //   254: monitorexit
    //   255: aload_2
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	NetworkCursorLogic
    //   75	12	1	localIOException	IOException
    //   118	12	1	localAuthenticationException	MailEngine.AuthenticationException
    //   161	12	1	localResponseParseException	MailSync.ResponseParseException
    //   204	50	1	localSQLiteException	android.database.sqlite.SQLiteException
    //   247	4	2	localObject2	Object
    //   252	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	24	75	java/io/IOException
    //   0	24	118	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   0	24	161	com/google/android/gm/provider/MailSync$ResponseParseException
    //   0	24	204	android/database/sqlite/SQLiteException
    //   30	50	247	finally
    //   50	52	247	finally
    //   248	250	247	finally
    //   67	74	252	finally
    //   253	255	252	finally
  }
  
  protected abstract void runInternal()
    throws IOException, MailEngine.AuthenticationException, MailSync.ResponseParseException;
  
  protected void setSelectionArguments(String[] paramArrayOfString)
  {
    mSelectionArgs = paramArrayOfString;
  }
  
  /* Error */
  protected final boolean startThread()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   4: ifnonnull +113 -> 117
    //   7: aload_0
    //   8: getfield 32	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThreadLock	Ljava/lang/Object;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   18: ifnonnull +69 -> 87
    //   21: aload_0
    //   22: getfield 27	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   25: invokestatic 203	com/google/android/gm/provider/MailEngine:access$3600	(Lcom/google/android/gm/provider/MailEngine;)Z
    //   28: ifne +59 -> 87
    //   31: aload_0
    //   32: new 205	java/lang/Thread
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 208	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   40: putfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   43: aload_0
    //   44: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   47: invokevirtual 211	java/lang/Thread:start	()V
    //   50: aload_1
    //   51: monitorexit
    //   52: getstatic 166	com/google/android/gm/provider/MailEngine:NETWORK_CURSOR_LOGIC_FETCHER_THREADS	Ljava/util/Set;
    //   55: astore_1
    //   56: aload_1
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   62: ifnull +16 -> 78
    //   65: getstatic 166	com/google/android/gm/provider/MailEngine:NETWORK_CURSOR_LOGIC_FETCHER_THREADS	Ljava/util/Set;
    //   68: aload_0
    //   69: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   72: invokeinterface 214 2 0
    //   77: pop
    //   78: aload_1
    //   79: monitorexit
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_2
    //   83: aload_1
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: aload_1
    //   88: monitorexit
    //   89: getstatic 166	com/google/android/gm/provider/MailEngine:NETWORK_CURSOR_LOGIC_FETCHER_THREADS	Ljava/util/Set;
    //   92: astore_1
    //   93: aload_1
    //   94: monitorenter
    //   95: aload_0
    //   96: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   99: ifnull +16 -> 115
    //   102: getstatic 166	com/google/android/gm/provider/MailEngine:NETWORK_CURSOR_LOGIC_FETCHER_THREADS	Ljava/util/Set;
    //   105: aload_0
    //   106: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   109: invokeinterface 214 2 0
    //   114: pop
    //   115: aload_1
    //   116: monitorexit
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_2
    //   120: aload_1
    //   121: monitorexit
    //   122: aload_2
    //   123: athrow
    //   124: astore_2
    //   125: getstatic 166	com/google/android/gm/provider/MailEngine:NETWORK_CURSOR_LOGIC_FETCHER_THREADS	Ljava/util/Set;
    //   128: astore_1
    //   129: aload_1
    //   130: monitorenter
    //   131: aload_0
    //   132: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   135: ifnull +16 -> 151
    //   138: getstatic 166	com/google/android/gm/provider/MailEngine:NETWORK_CURSOR_LOGIC_FETCHER_THREADS	Ljava/util/Set;
    //   141: aload_0
    //   142: getfield 41	com/google/android/gm/provider/MailEngine$NetworkCursorLogic:mFetcherThread	Ljava/lang/Thread;
    //   145: invokeinterface 214 2 0
    //   150: pop
    //   151: aload_1
    //   152: monitorexit
    //   153: aload_2
    //   154: athrow
    //   155: astore_2
    //   156: aload_1
    //   157: monitorexit
    //   158: aload_2
    //   159: athrow
    //   160: astore_2
    //   161: aload_1
    //   162: monitorexit
    //   163: aload_2
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	NetworkCursorLogic
    //   82	4	2	localObject2	Object
    //   119	4	2	localObject3	Object
    //   124	30	2	localObject4	Object
    //   155	4	2	localObject5	Object
    //   160	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   58	78	82	finally
    //   78	80	82	finally
    //   83	85	82	finally
    //   14	52	119	finally
    //   87	89	119	finally
    //   120	122	119	finally
    //   7	14	124	finally
    //   122	124	124	finally
    //   95	115	155	finally
    //   115	117	155	finally
    //   156	158	155	finally
    //   131	151	160	finally
    //   151	153	160	finally
    //   161	163	160	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.NetworkCursorLogic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */