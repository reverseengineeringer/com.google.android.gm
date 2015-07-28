package com.google.android.gm.provider;

import android.accounts.AccountManager;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.google.android.common.http.UrlRules;
import com.google.android.common.http.UrlRules.Rule;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AttachmentManager
{
  public static String ATTACHMENT_FROM = "attachment_from_sender";
  private static final String[] ATTACHMENT_NAME_STATUS_PROJECTION = { "filename", "status" };
  private static final String[] ATTACHMENT_PROJECTION = { "attachments._id", "messages_conversation", "messages_messageId", "messages_partId", "desiredRendition", "saveToSd", "filename", "mimeType", "fromAddress" };
  private static final Map<Long, String> sAccountsMap = Maps.newHashMap();
  private static Random sRandom = new Random(SystemClock.uptimeMillis());
  private final String mAccount;
  private final AccountManager mAccountManager;
  private final ContentResolver mContentResolver;
  private final Context mContext;
  private final SQLiteDatabase mDb;
  private final DownloadManager mDownloadManager;
  private final RestrictedMailEngine mRestrictedMailEngine;
  private final Urls mUrls;
  private long mUsedSpace;
  
  public AttachmentManager(Context paramContext, String paramString, SQLiteDatabase paramSQLiteDatabase, Urls paramUrls, RestrictedMailEngine paramRestrictedMailEngine)
  {
    mContext = paramContext;
    mAccount = paramString;
    mDb = paramSQLiteDatabase;
    mUrls = paramUrls;
    mRestrictedMailEngine = paramRestrictedMailEngine;
    mContentResolver = mContext.getContentResolver();
    mDownloadManager = ((DownloadManager)mContext.getSystemService("download"));
    mAccountManager = AccountManager.get(mContext);
    mUsedSpace = getUsedSpacePerAccount(paramString);
    mRestrictedMailEngine.postBackgroundTask(new Runnable()
    {
      public void run()
      {
        purgeOldAttachments();
      }
    });
    mRestrictedMailEngine.enqueueAttachmentDownloadTask();
  }
  
  public static boolean canDownloadAttachment(Context paramContext, Gmail.Attachment paramAttachment)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {}
    do
    {
      return false;
      if ((localNetworkInfo.getType() != 0) && (localNetworkInfo.isConnected())) {
        return true;
      }
    } while ((localNetworkInfo.getType() != 0) || (!localNetworkInfo.isConnected()));
    paramContext = DownloadManager.getMaxBytesOverMobile(paramContext);
    if ((paramContext == null) || (size <= paramContext.longValue())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  /* Error */
  private void copyAttachment(long paramLong1, long paramLong2, long paramLong3, String paramString1, Gmail.AttachmentRendition paramAttachmentRendition, boolean paramBoolean, String paramString2, long paramLong4, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: iload 9
    //   2: ifeq +237 -> 239
    //   5: getstatic 196	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   8: invokestatic 200	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   11: invokevirtual 206	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   14: astore 22
    //   16: aload 22
    //   18: aload 10
    //   20: invokestatic 210	com/google/android/gm/provider/AttachmentManager:getUniqueFileName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 23
    //   25: lload 11
    //   27: invokestatic 214	com/google/android/gm/provider/AttachmentManager:isDownloadIdValid	(J)Z
    //   30: ifeq +222 -> 252
    //   33: new 216	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   36: dup
    //   37: aload_0
    //   38: getfield 122	com/google/android/gm/provider/AttachmentManager:mDownloadManager	Landroid/app/DownloadManager;
    //   41: lload 11
    //   43: invokevirtual 220	android/app/DownloadManager:openDownloadedFile	(J)Landroid/os/ParcelFileDescriptor;
    //   46: invokespecial 223	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   49: astore 22
    //   51: new 225	java/io/FileOutputStream
    //   54: dup
    //   55: aload 23
    //   57: invokespecial 228	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   60: astore 24
    //   62: invokestatic 231	android/os/SystemClock:elapsedRealtime	()J
    //   65: lstore 20
    //   67: sipush 4096
    //   70: newarray <illegal type>
    //   72: astore 13
    //   74: iconst_0
    //   75: istore 18
    //   77: aload 22
    //   79: aload 13
    //   81: invokevirtual 237	java/io/InputStream:read	([B)I
    //   84: istore 19
    //   86: iload 19
    //   88: iconst_m1
    //   89: if_icmpeq +271 -> 360
    //   92: aload 24
    //   94: aload 13
    //   96: iconst_0
    //   97: iload 19
    //   99: invokevirtual 241	java/io/FileOutputStream:write	([BII)V
    //   102: iload 9
    //   104: ifne +15 -> 119
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 136	com/google/android/gm/provider/AttachmentManager:mUsedSpace	J
    //   112: iload 19
    //   114: i2l
    //   115: ladd
    //   116: putfield 136	com/google/android/gm/provider/AttachmentManager:mUsedSpace	J
    //   119: invokestatic 231	android/os/SystemClock:elapsedRealtime	()J
    //   122: lload 20
    //   124: lsub
    //   125: ldc2_w 242
    //   128: lcmp
    //   129: ifle +221 -> 350
    //   132: new 189	java/io/IOException
    //   135: dup
    //   136: ldc -11
    //   138: invokespecial 246	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   141: athrow
    //   142: astore 10
    //   144: ldc -8
    //   146: aload 10
    //   148: ldc -6
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 23
    //   158: aastore
    //   159: invokestatic 256	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   162: pop
    //   163: new 202	java/io/File
    //   166: dup
    //   167: aload 23
    //   169: invokespecial 257	java/io/File:<init>	(Ljava/lang/String;)V
    //   172: invokevirtual 260	java/io/File:delete	()Z
    //   175: pop
    //   176: aload_0
    //   177: lload_1
    //   178: lload_3
    //   179: lload 5
    //   181: aload 7
    //   183: aload 8
    //   185: iload 9
    //   187: sipush 1000
    //   190: aconst_null
    //   191: invokespecial 264	com/google/android/gm/provider/AttachmentManager:onAttachmentDownloadFinished	(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V
    //   194: lload 11
    //   196: invokestatic 214	com/google/android/gm/provider/AttachmentManager:isDownloadIdValid	(J)Z
    //   199: ifeq +19 -> 218
    //   202: aload_0
    //   203: getfield 122	com/google/android/gm/provider/AttachmentManager:mDownloadManager	Landroid/app/DownloadManager;
    //   206: iconst_1
    //   207: newarray <illegal type>
    //   209: dup
    //   210: iconst_0
    //   211: lload 11
    //   213: lastore
    //   214: invokevirtual 268	android/app/DownloadManager:remove	([J)I
    //   217: pop
    //   218: aload 22
    //   220: ifnull +8 -> 228
    //   223: aload 22
    //   225: invokevirtual 271	java/io/InputStream:close	()V
    //   228: aload 24
    //   230: ifnull +8 -> 238
    //   233: aload 24
    //   235: invokevirtual 272	java/io/FileOutputStream:close	()V
    //   238: return
    //   239: aload_0
    //   240: aload_0
    //   241: getfield 98	com/google/android/gm/provider/AttachmentManager:mAccount	Ljava/lang/String;
    //   244: invokespecial 276	com/google/android/gm/provider/AttachmentManager:getCacheDir	(Ljava/lang/String;)Ljava/lang/String;
    //   247: astore 22
    //   249: goto -233 -> 16
    //   252: new 278	java/io/FileInputStream
    //   255: dup
    //   256: aload 13
    //   258: invokestatic 281	com/google/android/gm/provider/AttachmentManager:getPathFromUri	(Ljava/lang/String;)Ljava/lang/String;
    //   261: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   264: astore 22
    //   266: goto -215 -> 51
    //   269: astore 10
    //   271: ldc -8
    //   273: ldc_w 284
    //   276: iconst_2
    //   277: anewarray 4	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: lload 11
    //   284: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   287: aastore
    //   288: dup
    //   289: iconst_1
    //   290: aload 13
    //   292: aastore
    //   293: invokestatic 291	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   296: pop
    //   297: aload_0
    //   298: lload_1
    //   299: lload_3
    //   300: lload 5
    //   302: aload 7
    //   304: aload 8
    //   306: iload 9
    //   308: sipush 404
    //   311: aconst_null
    //   312: invokespecial 264	com/google/android/gm/provider/AttachmentManager:onAttachmentDownloadFinished	(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V
    //   315: return
    //   316: astore 10
    //   318: ldc -8
    //   320: ldc_w 293
    //   323: iconst_0
    //   324: anewarray 4	java/lang/Object
    //   327: invokestatic 291	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   330: pop
    //   331: aload_0
    //   332: lload_1
    //   333: lload_3
    //   334: lload 5
    //   336: aload 7
    //   338: aload 8
    //   340: iload 9
    //   342: sipush 200
    //   345: aconst_null
    //   346: invokespecial 264	com/google/android/gm/provider/AttachmentManager:onAttachmentDownloadFinished	(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V
    //   349: return
    //   350: iload 18
    //   352: iload 19
    //   354: iadd
    //   355: istore 18
    //   357: goto -280 -> 77
    //   360: new 295	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 298
    //   370: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 23
    //   375: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: astore 25
    //   383: aload_0
    //   384: lload_1
    //   385: lload_3
    //   386: lload 5
    //   388: aload 7
    //   390: aload 8
    //   392: iload 9
    //   394: sipush 200
    //   397: aload 25
    //   399: invokespecial 264	com/google/android/gm/provider/AttachmentManager:onAttachmentDownloadFinished	(JJJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZILjava/lang/String;)V
    //   402: iload 9
    //   404: ifeq -210 -> 194
    //   407: aload 15
    //   409: ifnonnull +84 -> 493
    //   412: aload 16
    //   414: astore 13
    //   416: aload 13
    //   418: astore 15
    //   420: aload 13
    //   422: ifnonnull +7 -> 429
    //   425: aload 10
    //   427: astore 15
    //   429: aload 10
    //   431: invokestatic 311	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   434: ifne +78 -> 512
    //   437: aload_0
    //   438: getfield 122	com/google/android/gm/provider/AttachmentManager:mDownloadManager	Landroid/app/DownloadManager;
    //   441: aload 10
    //   443: aload 15
    //   445: iconst_1
    //   446: aload 14
    //   448: aload 23
    //   450: iload 18
    //   452: i2l
    //   453: iconst_0
    //   454: invokevirtual 315	android/app/DownloadManager:addCompletedDownload	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JZ)J
    //   457: pop2
    //   458: new 317	android/content/Intent
    //   461: dup
    //   462: ldc_w 319
    //   465: invokespecial 320	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   468: astore 10
    //   470: aload 10
    //   472: aload 25
    //   474: invokestatic 326	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   477: invokevirtual 330	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   480: pop
    //   481: aload_0
    //   482: getfield 96	com/google/android/gm/provider/AttachmentManager:mContext	Landroid/content/Context;
    //   485: aload 10
    //   487: invokevirtual 334	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   490: goto -296 -> 194
    //   493: aload 17
    //   495: iconst_1
    //   496: anewarray 4	java/lang/Object
    //   499: dup
    //   500: iconst_0
    //   501: aload 15
    //   503: aastore
    //   504: invokestatic 338	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   507: astore 13
    //   509: goto -93 -> 416
    //   512: aload 23
    //   514: invokestatic 326	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   517: invokevirtual 341	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   520: astore 10
    //   522: goto -85 -> 437
    //   525: astore 10
    //   527: ldc -8
    //   529: aload 10
    //   531: ldc_w 343
    //   534: iconst_0
    //   535: anewarray 4	java/lang/Object
    //   538: invokestatic 256	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   541: pop
    //   542: goto -84 -> 458
    //   545: astore 7
    //   547: ldc -8
    //   549: ldc_w 293
    //   552: iconst_0
    //   553: anewarray 4	java/lang/Object
    //   556: invokestatic 291	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   559: pop
    //   560: goto -342 -> 218
    //   563: astore 7
    //   565: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	AttachmentManager
    //   0	566	1	paramLong1	long
    //   0	566	3	paramLong2	long
    //   0	566	5	paramLong3	long
    //   0	566	7	paramString1	String
    //   0	566	8	paramAttachmentRendition	Gmail.AttachmentRendition
    //   0	566	9	paramBoolean	boolean
    //   0	566	10	paramString2	String
    //   0	566	11	paramLong4	long
    //   0	566	13	paramString3	String
    //   0	566	14	paramString4	String
    //   0	566	15	paramString5	String
    //   0	566	16	paramString6	String
    //   0	566	17	paramString7	String
    //   75	376	18	i	int
    //   84	271	19	j	int
    //   65	58	20	l	long
    //   14	251	22	localObject	Object
    //   23	490	23	str1	String
    //   60	174	24	localFileOutputStream	java.io.FileOutputStream
    //   381	92	25	str2	String
    // Exception table:
    //   from	to	target	type
    //   62	74	142	java/io/IOException
    //   77	86	142	java/io/IOException
    //   92	102	142	java/io/IOException
    //   107	119	142	java/io/IOException
    //   119	142	142	java/io/IOException
    //   360	402	142	java/io/IOException
    //   429	437	142	java/io/IOException
    //   437	458	142	java/io/IOException
    //   458	490	142	java/io/IOException
    //   493	509	142	java/io/IOException
    //   512	522	142	java/io/IOException
    //   527	542	142	java/io/IOException
    //   25	51	269	java/io/FileNotFoundException
    //   51	62	269	java/io/FileNotFoundException
    //   252	266	269	java/io/FileNotFoundException
    //   25	51	316	java/lang/NullPointerException
    //   51	62	316	java/lang/NullPointerException
    //   252	266	316	java/lang/NullPointerException
    //   429	437	525	java/lang/IllegalArgumentException
    //   437	458	525	java/lang/IllegalArgumentException
    //   512	522	525	java/lang/IllegalArgumentException
    //   194	218	545	java/lang/NullPointerException
    //   223	228	563	java/io/IOException
    //   233	238	563	java/io/IOException
  }
  
  private void deleteAttachment(long paramLong1, long paramLong2, String paramString)
  {
    if (paramString != null) {
      new File(getPathFromUri(paramString)).delete();
    }
    paramString = new ContentValues();
    paramString.put("status", Integer.valueOf(-1));
    paramString.put("downloadId", Integer.valueOf(-1));
    mDb.update("attachments", paramString, "_id = ?", new String[] { Long.toString(paramLong2) });
    notifyChanged(paramLong1);
  }
  
  public static String getAccountFromDownloadId(long paramLong)
  {
    return (String)sAccountsMap.remove(Long.valueOf(paramLong));
  }
  
  private String getCacheDir(String paramString)
  {
    return mContext.getCacheDir().getAbsolutePath().concat("/").concat(paramString);
  }
  
  static String getPathFromUri(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("file://")) {
      str = paramString.substring(7);
    }
    return str;
  }
  
  private static String getUniqueFileName(String paramString1, String paramString2)
  {
    int i = paramString2.lastIndexOf('.');
    String str1 = "";
    Object localObject = paramString2;
    if (i != -1)
    {
      str1 = paramString2.substring(i);
      localObject = paramString2.substring(0, i);
    }
    paramString2 = (String)localObject;
    if (((String)localObject).indexOf(File.separatorChar) != -1) {
      paramString2 = ((String)localObject).replace(File.separatorChar, '_');
    }
    localObject = new File(paramString1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    while (((File)localObject).isDirectory())
    {
      localObject = paramString1;
      if (!paramString1.endsWith(File.separator)) {
        localObject = paramString1.concat(File.separator);
      }
      paramString1 = (String)localObject + paramString2 + str1;
      if (new File(paramString1).exists()) {
        break;
      }
      return paramString1;
    }
    return null;
    String str2 = paramString2 + "-";
    int j = 1;
    i = 1;
    for (;;)
    {
      if (i >= 1000000000) {
        break label276;
      }
      int k = 0;
      for (;;)
      {
        if (k >= 9) {
          break label268;
        }
        paramString2 = (String)localObject + str2 + j + str1;
        paramString1 = paramString2;
        if (!new File(paramString2).exists()) {
          break;
        }
        j += sRandom.nextInt(i) + 1;
        k += 1;
      }
      label268:
      i *= 10;
    }
    label276:
    return null;
  }
  
  private long getUsedSpacePerAccount(String paramString)
  {
    long l1 = 0L;
    paramString = new File(getCacheDir(paramString));
    long l2 = l1;
    if (paramString.listFiles() != null)
    {
      paramString = paramString.listFiles();
      int j = paramString.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l1 += paramString[i].length();
        i += 1;
      }
    }
    return l2;
  }
  
  private static boolean isDownloadIdValid(long paramLong)
  {
    return paramLong != -1L;
  }
  
  public static boolean isDownloadStillPresent(String paramString)
  {
    return new File(getPathFromUri(paramString)).exists();
  }
  
  private boolean isLowSpace()
  {
    boolean bool2 = false;
    File localFile = mContext.getCacheDir();
    long l1 = localFile.getTotalSpace();
    long l2 = localFile.getUsableSpace();
    try
    {
      int i = mAccountManager.getAccounts().length;
      long l3 = ((float)l1 * 0.25F / i);
      if (mUsedSpace >= l3)
      {
        mUsedSpace = 0L;
        mUsedSpace = getUsedSpacePerAccount(mAccount);
      }
      boolean bool1 = bool2;
      if ((float)l2 < (float)l1 * 0.25F)
      {
        bool1 = bool2;
        if (mUsedSpace >= l3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (NullPointerException localNullPointerException)
    {
      LogUtils.e("Gmail", "This maybe called from tests where we don't have Account Manager.", new Object[0]);
    }
    return false;
  }
  
  public static boolean isStatusError(int paramInt)
  {
    return paramInt > 200;
  }
  
  public static boolean isStatusPaused(int paramInt)
  {
    return paramInt == 193;
  }
  
  public static boolean isStatusPending(int paramInt)
  {
    return paramInt == 190;
  }
  
  public static boolean isStatusRunning(int paramInt)
  {
    return paramInt == 192;
  }
  
  public static boolean isStatusSuccess(int paramInt)
  {
    return paramInt == 200;
  }
  
  public static boolean isStatusValid(int paramInt)
  {
    return paramInt != -1;
  }
  
  private Cursor newAttachmentCursor(long paramLong, String paramString, Gmail.AttachmentRendition paramAttachmentRendition, boolean paramBoolean, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = mDb;
    String str = Long.toString(paramLong);
    paramAttachmentRendition = paramAttachmentRendition.toString();
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L) {
      return localSQLiteDatabase.query("attachments", paramArrayOfString, "messages_messageId = ? AND messages_partId = ? AND desiredRendition = ? AND saveToSd = ?", new String[] { str, paramString, paramAttachmentRendition, Long.toString(paramLong) }, null, null, null);
    }
  }
  
  private void notifyChanged(long paramLong)
  {
    mContext.getContentResolver().notifyChange(Gmail.getAttachmentsForConversationUri(mAccount, paramLong), null, false);
    UiProvider.notifyAttachmentChanged(mAccount, paramLong);
  }
  
  private void onAttachmentDownloadFinished(long paramLong1, long paramLong2, long paramLong3, String paramString1, Gmail.AttachmentRendition paramAttachmentRendition, boolean paramBoolean, int paramInt, String paramString2)
  {
    updateAttachmentEntry(paramLong1, paramInt, paramString2);
    if (paramAttachmentRendition == Gmail.AttachmentRendition.BEST)
    {
      int i;
      if (paramBoolean)
      {
        i = 1;
        if (!isStatusSuccess(paramInt)) {
          break label63;
        }
      }
      label63:
      for (int j = 3;; j = 1)
      {
        UiProvider.onAttachmentDownloadFinished(mAccount, paramLong2, paramLong3, paramString1, i, j, paramInt, paramString2);
        return;
        i = 0;
        break;
      }
    }
    LogUtils.d("Gmail", "Dropping download finished, as this is an thumbnail attachment.  %d/%d/%d/%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong1), paramString1 });
  }
  
  private void purgeAttachmentEntries(List<Long> paramList)
  {
    int j = paramList.size();
    if (j > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_id IN (");
      int i = 0;
      while (i < j)
      {
        if (i > 0) {
          localStringBuilder.append(", ");
        }
        Long localLong = (Long)paramList.get(i);
        localStringBuilder.append("'" + localLong.toString() + "'");
        i += 1;
      }
      localStringBuilder.append(')');
      mDb.delete("attachments", localStringBuilder.toString(), null);
    }
  }
  
  private void purgeInvalidAttachments()
  {
    ArrayList localArrayList1 = Lists.newArrayList();
    ArrayList localArrayList2 = Lists.newArrayList();
    Object localObject1 = mDb;
    Object localObject3 = Integer.toString(190);
    String str1 = Integer.toString(192);
    String str2 = Integer.toString(193);
    String str3 = Integer.toString(200);
    localObject3 = ((SQLiteDatabase)localObject1).query("attachments", new String[] { "_id", "filename", "saveToSd" }, "status NOT IN (?, ?, ?, ?)", new String[] { localObject3, str1, str2, str3 }, null, null, null);
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject3).moveToNext()) {
          break;
        }
        long l = ((Cursor)localObject3).getLong(0);
        localObject1 = ((Cursor)localObject3).getString(1);
        int i;
        if (((Cursor)localObject3).getInt(2) != 0)
        {
          i = 1;
          localArrayList1.add(Long.valueOf(l));
          if (i != 0) {
            localObject1 = null;
          }
          localArrayList2.add(localObject1);
        }
        else
        {
          i = 0;
        }
      }
      finally
      {
        ((Cursor)localObject3).close();
      }
    }
    ((Cursor)localObject3).close();
    purgeOldAttachmentFiles(localArrayList2);
    purgeAttachmentEntries(localArrayList1);
  }
  
  /* Error */
  private void purgeInvalidDownloadingAttachments()
  {
    // Byte code:
    //   0: invokestatic 550	com/google/common/collect/Lists:newArrayList	()Ljava/util/ArrayList;
    //   3: astore 7
    //   5: invokestatic 550	com/google/common/collect/Lists:newArrayList	()Ljava/util/ArrayList;
    //   8: astore 8
    //   10: aload_0
    //   11: getfield 100	com/google/android/gm/provider/AttachmentManager:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 6
    //   16: sipush 192
    //   19: invokestatic 552	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   22: astore 9
    //   24: aload 6
    //   26: ldc_w 361
    //   29: iconst_4
    //   30: anewarray 44	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc_w 554
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc_w 359
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: ldc 46
    //   49: aastore
    //   50: dup
    //   51: iconst_3
    //   52: ldc 62
    //   54: aastore
    //   55: ldc_w 586
    //   58: iconst_1
    //   59: anewarray 44	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload 9
    //   66: aastore
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 483	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore 9
    //   75: aload 9
    //   77: invokeinterface 561 1 0
    //   82: ifeq +197 -> 279
    //   85: aload 9
    //   87: iconst_0
    //   88: invokeinterface 565 2 0
    //   93: lstore_2
    //   94: aload 9
    //   96: iconst_1
    //   97: invokeinterface 565 2 0
    //   102: lstore 4
    //   104: new 588	android/app/DownloadManager$Query
    //   107: dup
    //   108: invokespecial 589	android/app/DownloadManager$Query:<init>	()V
    //   111: iconst_1
    //   112: newarray <illegal type>
    //   114: dup
    //   115: iconst_0
    //   116: lload 4
    //   118: lastore
    //   119: invokevirtual 593	android/app/DownloadManager$Query:setFilterById	([J)Landroid/app/DownloadManager$Query;
    //   122: astore 6
    //   124: aload_0
    //   125: getfield 122	com/google/android/gm/provider/AttachmentManager:mDownloadManager	Landroid/app/DownloadManager;
    //   128: aload 6
    //   130: invokevirtual 596	android/app/DownloadManager:query	(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    //   133: astore 6
    //   135: aload 6
    //   137: ifnull -62 -> 75
    //   140: aload 6
    //   142: invokeinterface 561 1 0
    //   147: ifeq +57 -> 204
    //   150: aload 6
    //   152: aload 6
    //   154: ldc 48
    //   156: invokeinterface 600 2 0
    //   161: invokeinterface 571 2 0
    //   166: istore_1
    //   167: iload_1
    //   168: iconst_1
    //   169: if_icmpeq +13 -> 182
    //   172: iload_1
    //   173: iconst_2
    //   174: if_icmpeq +8 -> 182
    //   177: iload_1
    //   178: iconst_4
    //   179: if_icmpne +25 -> 204
    //   182: aload 6
    //   184: invokeinterface 578 1 0
    //   189: goto -114 -> 75
    //   192: astore 6
    //   194: aload 9
    //   196: invokeinterface 578 1 0
    //   201: aload 6
    //   203: athrow
    //   204: aload 6
    //   206: invokeinterface 578 1 0
    //   211: aload 9
    //   213: iconst_2
    //   214: invokeinterface 568 2 0
    //   219: astore 6
    //   221: aload 9
    //   223: iconst_3
    //   224: invokeinterface 571 2 0
    //   229: ifeq +45 -> 274
    //   232: iconst_1
    //   233: istore_1
    //   234: aload 7
    //   236: lload_2
    //   237: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   240: invokevirtual 577	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   243: pop
    //   244: iload_1
    //   245: ifeq +6 -> 251
    //   248: aconst_null
    //   249: astore 6
    //   251: aload 8
    //   253: aload 6
    //   255: invokevirtual 577	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   258: pop
    //   259: goto -184 -> 75
    //   262: astore 7
    //   264: aload 6
    //   266: invokeinterface 578 1 0
    //   271: aload 7
    //   273: athrow
    //   274: iconst_0
    //   275: istore_1
    //   276: goto -42 -> 234
    //   279: aload 9
    //   281: invokeinterface 578 1 0
    //   286: aload_0
    //   287: aload 8
    //   289: invokespecial 581	com/google/android/gm/provider/AttachmentManager:purgeOldAttachmentFiles	(Ljava/util/List;)V
    //   292: aload_0
    //   293: aload 7
    //   295: invokespecial 583	com/google/android/gm/provider/AttachmentManager:purgeAttachmentEntries	(Ljava/util/List;)V
    //   298: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	AttachmentManager
    //   166	110	1	i	int
    //   93	144	2	l1	long
    //   102	15	4	l2	long
    //   14	169	6	localObject1	Object
    //   192	13	6	localObject2	Object
    //   219	46	6	str	String
    //   3	232	7	localArrayList1	ArrayList
    //   262	32	7	localList	List
    //   8	280	8	localArrayList2	ArrayList
    //   22	258	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   75	135	192	finally
    //   182	189	192	finally
    //   204	232	192	finally
    //   234	244	192	finally
    //   251	259	192	finally
    //   264	274	192	finally
    //   140	167	262	finally
  }
  
  private void purgeOldAttachmentFiles(List<String> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (str != null) {
          new File(getPathFromUri(str)).delete();
        }
      }
    }
  }
  
  private static String requestDescription(long paramLong1, long paramLong2, String paramString, Gmail.AttachmentRendition paramAttachmentRendition, boolean paramBoolean)
  {
    return "conversationId = " + paramLong1 + ", messageId = " + paramLong2 + ", partId = " + paramString + ", rendition = " + paramAttachmentRendition.toString() + ", saveToSd = " + Boolean.toString(paramBoolean);
  }
  
  private void resetAttachment(long paramLong1, long paramLong2, String paramString)
  {
    if (paramString != null) {
      new File(getPathFromUri(paramString)).delete();
    }
    paramString = new ContentValues();
    paramString.put("status", Integer.valueOf(190));
    paramString.put("downloadId", Integer.valueOf(-1));
    mDb.update("attachments", paramString, "_id = ?", new String[] { Long.toString(paramLong2) });
    notifyChanged(paramLong1);
  }
  
  private void startAttachmentDownloadInDownloadManager(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (mDb.isDbLockedByCurrentThread()) {
      LogUtils.wtf("Gmail", "SQLiteDatabase lock held beforecalling startAttachmentDownloadInDownloadManager", new Object[0]);
    }
    Object localObject1 = mDb;
    Object localObject3 = Long.toString(paramLong1);
    localCursor = ((SQLiteDatabase)localObject1).query("attachments", new String[] { "messages_conversation", "messages_messageId", "messages_partId", "originExtras", "downloadedRendition", "saveToSd", "filename", "automatic" }, "_id = ?", new String[] { localObject3 }, null, null, null);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToNext())
        {
          LogUtils.e("Gmail", "Cannot find attachment %d", new Object[] { Long.valueOf(paramLong1) });
          return;
        }
        l1 = localCursor.getLong(0);
        l2 = localCursor.getLong(1);
        str1 = localCursor.getString(2);
        localObject1 = localCursor.getString(3);
        localObject3 = Gmail.AttachmentRendition.valueOf(localCursor.getString(4));
        if (localCursor.getInt(5) != 0)
        {
          bool = true;
          str2 = localCursor.getString(6);
          str1 = requestDescription(l1, l2, str1, (Gmail.AttachmentRendition)localObject3, bool);
          if (localObject3 == Gmail.AttachmentRendition.SIMPLE) {
            continue;
          }
          bool = true;
          localURI = mUrls.getFetchAttachmentUri(mRestrictedMailEngine.getRequestVersion(), (String)localObject1, 256, bool);
          localObject1 = null;
        }
      }
      finally
      {
        long l1;
        long l2;
        String str1;
        boolean bool;
        String str2;
        URI localURI;
        localCursor.close();
      }
      try
      {
        localObject3 = mRestrictedMailEngine.getAuthToken();
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        continue;
      }
      if (localObject1 != null) {
        continue;
      }
      LogUtils.e("Gmail", "Authentication failed for attachment %d, %s", new Object[] { Long.valueOf(paramLong1), str1 });
      localCursor.close();
      return;
      bool = false;
      continue;
      bool = false;
    }
    localObject1 = Urls.getCookieString(mAccount, (String)localObject1);
    localObject3 = localURI.toString();
    localObject3 = UrlRules.getRules(mContentResolver).matchRule((String)localObject3).apply((String)localObject3);
    if (localObject3 == null)
    {
      LogUtils.w("Gmail", "Abandon download of %s because it is blocked by rules.", new Object[] { localURI });
      localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("status", Integer.valueOf(1000));
      mDb.update("attachments", (ContentValues)localObject1, "_id = ? OR _id = ?", new String[] { Long.toString(paramLong1), Long.toString(paramLong2) });
    }
    for (;;)
    {
      notifyChanged(l1);
      localCursor.close();
      return;
      localObject1 = new DownloadManager.Request(Uri.parse((String)localObject3)).addRequestHeader("Cookie", (String)localObject1).setTitle(str2).setVisibleInDownloadsUi(false);
      if (paramLong2 == -1L) {
        ((DownloadManager.Request)localObject1).setNotificationVisibility(2);
      }
      if (paramBoolean) {
        ((DownloadManager.Request)localObject1).setAllowedNetworkTypes(2);
      }
      l2 = mDownloadManager.enqueue((DownloadManager.Request)localObject1);
      sAccountsMap.put(Long.valueOf(l2), mAccount);
      localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("downloadId", Long.valueOf(l2));
      ((ContentValues)localObject1).put("status", Integer.valueOf(192));
      mDb.update("attachments", (ContentValues)localObject1, "_id = ? OR _id = ?", new String[] { Long.toString(paramLong1), Long.toString(paramLong2) });
      LogUtils.d("Gmail", "ATTACHMENT: start downloading attachment %d dlid=%d, %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l2), str1 });
    }
  }
  
  private void updateAttachmentEntry(long paramLong, int paramInt, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("downloadId", Integer.valueOf(-1));
    if (paramString != null) {
      localContentValues.put("filename", paramString);
    }
    localContentValues.put("status", Integer.valueOf(paramInt));
    mDb.update("attachments", localContentValues, "_id = ?", new String[] { Long.toString(paramLong) });
  }
  
  public int cancelDownloadRequest(long paramLong1, long paramLong2, String paramString, Gmail.AttachmentRendition paramAttachmentRendition, boolean paramBoolean)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "cancelDownloadRequest: %s", new Object[] { requestDescription(paramLong1, paramLong2, paramString, paramAttachmentRendition, paramBoolean) });
    }
    paramString = newAttachmentCursor(paramLong2, paramString, paramAttachmentRendition, paramBoolean, new String[] { "_id", "downloadId", "automatic", "status", "filename" });
    try
    {
      if (paramString.moveToNext())
      {
        paramLong2 = paramString.getLong(0);
        long l = paramString.getLong(1);
        if (paramString.getInt(2) != 0) {}
        for (;;)
        {
          paramString.getInt(3);
          paramAttachmentRendition = paramString.getString(4);
          if ((mDownloadManager != null) && (isDownloadIdValid(l))) {
            mDownloadManager.remove(new long[] { l });
          }
          deleteAttachment(paramLong1, paramLong2, paramAttachmentRendition);
          return 1;
        }
      }
      return 0;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void enqueueAttachment(long paramLong1, long paramLong2, Gmail.Attachment paramAttachment, Gmail.AttachmentRendition paramAttachmentRendition, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    long l = recordAttachmentInDb(paramLong1, paramLong2, paramAttachment, paramAttachmentRendition, 0L, paramBoolean1, paramBoolean2, paramInt);
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "enqueueAttachment attachmentId: %d: %s", new Object[] { Long.valueOf(l), requestDescription(paramLong1, paramLong2, partId, paramAttachmentRendition, paramBoolean1) });
    }
    notifyChanged(paramLong1);
  }
  
  public void handleDownloadManagerIntent(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_download_id", -1L);
    if (l == -1L)
    {
      LogUtils.e("Gmail", "Received notification from DownloadManager with invalid download id", new Object[0]);
      return;
    }
    Object localObject = new DownloadManager.Query().setFilterById(new long[] { l });
    localObject = mDownloadManager.query((DownloadManager.Query)localObject);
    if (localObject == null)
    {
      LogUtils.e("Gmail", "null cursor from DownloadManager", new Object[0]);
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        j = ((Cursor)localObject).getColumnIndex("status");
        i = ((Cursor)localObject).getColumnIndex("reason");
        int k;
        if (((Cursor)localObject).moveToNext())
        {
          k = ((Cursor)localObject).getInt(j);
          i = ((Cursor)localObject).getInt(i);
          j = 0;
        }
        switch (k)
        {
        case 8: 
          paramIntent = paramIntent.getStringArrayListExtra(ATTACHMENT_FROM);
          onDownloadCompletedByDownloadManager(l, i, (String)paramIntent.get(0), (String)paramIntent.get(1));
          return;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
      int i = 200;
      continue;
      continue;
      i = j;
    }
  }
  
  /* Error */
  public void maybeStartNextAttachmentDownload()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 794	com/google/android/gm/provider/AttachmentManager:isLowSpace	()Z
    //   4: ifeq +17 -> 21
    //   7: ldc -8
    //   9: ldc_w 796
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 799	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   19: pop
    //   20: return
    //   21: iconst_0
    //   22: istore_2
    //   23: aload_0
    //   24: getfield 100	com/google/android/gm/provider/AttachmentManager:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 6
    //   29: sipush 192
    //   32: invokestatic 552	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   35: astore 7
    //   37: aload 6
    //   39: ldc_w 361
    //   42: iconst_1
    //   43: anewarray 44	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc_w 359
    //   51: aastore
    //   52: ldc_w 586
    //   55: iconst_1
    //   56: anewarray 44	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: aload 7
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 483	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore 6
    //   72: iload_2
    //   73: istore_1
    //   74: aload 6
    //   76: invokeinterface 802 1 0
    //   81: ifle +240 -> 321
    //   84: invokestatic 808	com/google/common/collect/Sets:newHashSet	()Ljava/util/HashSet;
    //   87: astore 7
    //   89: aload 6
    //   91: invokeinterface 561 1 0
    //   96: ifeq +37 -> 133
    //   99: aload 7
    //   101: aload 6
    //   103: iconst_0
    //   104: invokeinterface 565 2 0
    //   109: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   112: invokeinterface 811 2 0
    //   117: pop
    //   118: goto -29 -> 89
    //   121: astore 7
    //   123: aload 6
    //   125: invokeinterface 578 1 0
    //   130: aload 7
    //   132: athrow
    //   133: new 588	android/app/DownloadManager$Query
    //   136: dup
    //   137: invokespecial 589	android/app/DownloadManager$Query:<init>	()V
    //   140: iconst_2
    //   141: invokevirtual 815	android/app/DownloadManager$Query:setFilterByStatus	(I)Landroid/app/DownloadManager$Query;
    //   144: astore 8
    //   146: aload_0
    //   147: getfield 122	com/google/android/gm/provider/AttachmentManager:mDownloadManager	Landroid/app/DownloadManager;
    //   150: aload 8
    //   152: invokevirtual 596	android/app/DownloadManager:query	(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    //   155: astore 8
    //   157: aload 8
    //   159: ifnonnull +24 -> 183
    //   162: ldc -8
    //   164: ldc_w 780
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 291	com/google/android/gm/provider/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   174: pop
    //   175: aload 6
    //   177: invokeinterface 578 1 0
    //   182: return
    //   183: aload 8
    //   185: ldc_w 554
    //   188: invokeinterface 600 2 0
    //   193: istore_1
    //   194: aload 8
    //   196: invokeinterface 561 1 0
    //   201: ifeq +61 -> 262
    //   204: aload 8
    //   206: iload_1
    //   207: invokeinterface 565 2 0
    //   212: lstore_3
    //   213: aload 7
    //   215: lload_3
    //   216: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   219: invokeinterface 818 2 0
    //   224: ifeq -30 -> 194
    //   227: ldc -8
    //   229: ldc_w 820
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: lload_3
    //   239: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   242: aastore
    //   243: invokestatic 519	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   246: pop
    //   247: aload 8
    //   249: invokeinterface 578 1 0
    //   254: aload 6
    //   256: invokeinterface 578 1 0
    //   261: return
    //   262: aload 8
    //   264: invokeinterface 578 1 0
    //   269: new 588	android/app/DownloadManager$Query
    //   272: dup
    //   273: invokespecial 589	android/app/DownloadManager$Query:<init>	()V
    //   276: iconst_4
    //   277: invokevirtual 815	android/app/DownloadManager$Query:setFilterByStatus	(I)Landroid/app/DownloadManager$Query;
    //   280: astore 7
    //   282: aload_0
    //   283: getfield 122	com/google/android/gm/provider/AttachmentManager:mDownloadManager	Landroid/app/DownloadManager;
    //   286: aload 7
    //   288: invokevirtual 596	android/app/DownloadManager:query	(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    //   291: astore 7
    //   293: iload_2
    //   294: istore_1
    //   295: aload 7
    //   297: ifnull +24 -> 321
    //   300: aload 7
    //   302: invokeinterface 802 1 0
    //   307: istore_1
    //   308: iload_1
    //   309: ifle +218 -> 527
    //   312: iconst_1
    //   313: istore_1
    //   314: aload 7
    //   316: invokeinterface 578 1 0
    //   321: aload 6
    //   323: invokeinterface 578 1 0
    //   328: aload_0
    //   329: getfield 100	com/google/android/gm/provider/AttachmentManager:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   332: ldc_w 361
    //   335: iconst_2
    //   336: anewarray 44	java/lang/String
    //   339: dup
    //   340: iconst_0
    //   341: ldc_w 554
    //   344: aastore
    //   345: dup
    //   346: iconst_1
    //   347: ldc_w 651
    //   350: aastore
    //   351: ldc_w 822
    //   354: iconst_1
    //   355: anewarray 44	java/lang/String
    //   358: dup
    //   359: iconst_0
    //   360: ldc_w 824
    //   363: aastore
    //   364: aconst_null
    //   365: aconst_null
    //   366: ldc_w 826
    //   369: invokevirtual 483	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   372: astore 6
    //   374: aload 6
    //   376: invokeinterface 561 1 0
    //   381: ifeq +118 -> 499
    //   384: aload 6
    //   386: iconst_0
    //   387: invokeinterface 565 2 0
    //   392: lstore_3
    //   393: aload 6
    //   395: iconst_1
    //   396: invokeinterface 568 2 0
    //   401: invokestatic 658	com/google/android/gm/provider/Gmail$AttachmentRendition:valueOf	(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    //   404: getstatic 663	com/google/android/gm/provider/Gmail$AttachmentRendition:SIMPLE	Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    //   407: if_acmpeq +51 -> 458
    //   410: iconst_1
    //   411: istore 5
    //   413: goto +102 -> 515
    //   416: aload_0
    //   417: lload_3
    //   418: ldc2_w 449
    //   421: iload 5
    //   423: invokespecial 828	com/google/android/gm/provider/AttachmentManager:startAttachmentDownloadInDownloadManager	(JJZ)V
    //   426: aload 6
    //   428: invokeinterface 578 1 0
    //   433: return
    //   434: astore 7
    //   436: aload 8
    //   438: invokeinterface 578 1 0
    //   443: aload 7
    //   445: athrow
    //   446: astore 8
    //   448: aload 7
    //   450: invokeinterface 578 1 0
    //   455: aload 8
    //   457: athrow
    //   458: iconst_0
    //   459: istore 5
    //   461: goto +54 -> 515
    //   464: ldc -8
    //   466: ldc_w 830
    //   469: iconst_1
    //   470: anewarray 4	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: lload_3
    //   476: invokestatic 288	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   479: aastore
    //   480: invokestatic 519	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   483: pop
    //   484: goto -58 -> 426
    //   487: astore 7
    //   489: aload 6
    //   491: invokeinterface 578 1 0
    //   496: aload 7
    //   498: athrow
    //   499: ldc -8
    //   501: ldc_w 832
    //   504: iconst_0
    //   505: anewarray 4	java/lang/Object
    //   508: invokestatic 519	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   511: pop
    //   512: goto -86 -> 426
    //   515: iload 5
    //   517: ifeq -101 -> 416
    //   520: iload_1
    //   521: ifne -57 -> 464
    //   524: goto -108 -> 416
    //   527: iconst_0
    //   528: istore_1
    //   529: goto -215 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	AttachmentManager
    //   73	456	1	i	int
    //   22	272	2	j	int
    //   212	264	3	l	long
    //   411	105	5	bool	boolean
    //   27	463	6	localObject1	Object
    //   35	65	7	localObject2	Object
    //   121	93	7	localObject3	Object
    //   280	35	7	localObject4	Object
    //   434	15	7	localObject5	Object
    //   487	10	7	localObject6	Object
    //   144	293	8	localObject7	Object
    //   446	10	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   74	89	121	finally
    //   89	118	121	finally
    //   133	157	121	finally
    //   162	175	121	finally
    //   247	254	121	finally
    //   262	293	121	finally
    //   314	321	121	finally
    //   436	446	121	finally
    //   448	458	121	finally
    //   183	194	434	finally
    //   194	247	434	finally
    //   300	308	446	finally
    //   374	410	487	finally
    //   416	426	487	finally
    //   464	484	487	finally
    //   499	512	487	finally
  }
  
  void onDownloadCompletedByDownloadManager(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Cursor localCursor = mDb.query("attachments, messages", ATTACHMENT_PROJECTION, "downloadId = ? AND attachments.messages_messageId = messages.messageId", new String[] { Long.toString(paramLong) }, null, null, "saveToSd DESC");
    for (;;)
    {
      long l1;
      long l2;
      long l3;
      String str1;
      Gmail.AttachmentRendition localAttachmentRendition;
      boolean bool;
      try
      {
        if (localCursor.getCount() == 0) {
          LogUtils.e("Gmail", "No attachments found with downloadId %d", new Object[] { Long.valueOf(paramLong) });
        }
        if (!localCursor.moveToNext()) {
          break;
        }
        l1 = localCursor.getLong(0);
        l2 = localCursor.getLong(1);
        l3 = localCursor.getLong(2);
        str1 = localCursor.getString(3);
        localAttachmentRendition = Gmail.AttachmentRendition.valueOf(localCursor.getString(4));
        if (localCursor.getInt(5) != 0)
        {
          bool = true;
          LogUtils.d("Gmail", "Download finished with status %d for download %d. %s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), requestDescription(l2, l3, str1, localAttachmentRendition, bool) });
          if (!localCursor.isFirst()) {
            break label337;
          }
          String str2 = localCursor.getString(6);
          String str3 = localCursor.getString(7);
          String str4 = localCursor.getString(8);
          if (!isStatusSuccess(paramInt)) {
            break label289;
          }
          copyAttachment(l1, l2, l3, str1, localAttachmentRendition, bool, str2, paramLong, null, str3, str4, paramString1, paramString2);
          notifyChanged(l2);
          continue;
        }
        bool = false;
      }
      finally
      {
        localCursor.close();
      }
      continue;
      label289:
      LogUtils.e("Gmail", "Download id %d failed with status %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      onAttachmentDownloadFinished(l1, l2, l3, str1, localAttachmentRendition, bool, paramInt, null);
      continue;
      label337:
      updateAttachmentEntry(l1, paramInt, null);
    }
    localCursor.close();
    mRestrictedMailEngine.enqueueAttachmentDownloadTask();
  }
  
  public ParcelFileDescriptor openAttachment(long paramLong1, long paramLong2, Gmail.Attachment paramAttachment, Gmail.AttachmentRendition paramAttachmentRendition, boolean paramBoolean, String paramString)
    throws FileNotFoundException
  {
    String str = requestDescription(paramLong1, paramLong2, partId, paramAttachmentRendition, paramBoolean);
    LogUtils.d("Gmail", "AttachmentManager.openAttachment: %s", new Object[] { str });
    paramString = null;
    try
    {
      paramAttachment = newAttachmentCursor(paramLong2, partId, paramAttachmentRendition, paramBoolean, ATTACHMENT_NAME_STATUS_PROJECTION);
      paramString = paramAttachment;
      if (!paramAttachment.moveToNext()) {
        break label220;
      }
      paramString = paramAttachment;
      if (!isStatusSuccess(paramAttachment.getInt(1)))
      {
        paramString = paramAttachment;
        throw new FileNotFoundException("Download not complete or not successful.");
      }
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
    }
    paramString = paramAttachment;
    paramAttachmentRendition = getPathFromUri(paramAttachment.getString(0));
    paramString = paramAttachment;
    paramLong1 = Binder.clearCallingIdentity();
    try
    {
      LogUtils.d("Gmail", "Opening attachment %s", new Object[] { paramAttachmentRendition });
      paramAttachmentRendition = ParcelFileDescriptor.open(new File(paramAttachmentRendition), 268435456);
      paramString = paramAttachment;
      Binder.restoreCallingIdentity(paramLong1);
      if (paramAttachment != null) {
        paramAttachment.close();
      }
      return paramAttachmentRendition;
    }
    finally
    {
      paramString = paramAttachment;
      Binder.restoreCallingIdentity(paramLong1);
      paramString = paramAttachment;
    }
    label220:
    paramString = paramAttachment;
    LogUtils.e("Gmail", "Attachment is not requested %s", new Object[] { str });
    paramString = paramAttachment;
    throw new FileNotFoundException("Attachment not requested.");
  }
  
  void purgeOldAttachments()
  {
    LogUtils.d("Gmail", "Purging old attachments.", new Object[0]);
    if (mDb.isDbLockedByCurrentThread()) {
      throw new IllegalStateException("Db should not be locked");
    }
    purgeInvalidAttachments();
    purgeInvalidDownloadingAttachments();
  }
  
  public Cursor queryAndStartDownloadingAttachment(long paramLong1, long paramLong2, Gmail.Attachment paramAttachment, Gmail.AttachmentRendition paramAttachmentRendition, boolean paramBoolean, String[] paramArrayOfString)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "queryAndStartDownloadingAttachment for %s", new Object[] { requestDescription(paramLong1, paramLong2, partId, paramAttachmentRendition, paramBoolean) });
    }
    Object localObject1 = mDb;
    Object localObject2 = Long.toString(paramLong2);
    Object localObject3 = partId;
    Object localObject4 = paramAttachmentRendition.toString();
    localObject1 = ((SQLiteDatabase)localObject1).query("attachments", new String[] { "_id", "downloadId", "status", "filename", "saveToSd" }, "messages_messageId = ? AND messages_partId = ? AND desiredRendition = ? ", new String[] { localObject2, localObject3, localObject4 }, null, null, null);
    localObject2 = new Long[2];
    localObject2[0] = Long.valueOf(-1L);
    localObject2[1] = Long.valueOf(-1L);
    localObject3 = new long[2];
    Object tmp164_162 = localObject3;
    tmp164_162[0] = -1L;
    Object tmp170_164 = tmp164_162;
    tmp170_164[1] = -1L;
    tmp170_164;
    localObject4 = new int[2];
    Object tmp184_182 = localObject4;
    tmp184_182[0] = -1;
    Object tmp188_184 = tmp184_182;
    tmp188_184[1] = -1;
    tmp188_184;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = null;
    arrayOfString[1] = null;
    int i;
    try
    {
      while (((Cursor)localObject1).moveToNext())
      {
        i = ((Cursor)localObject1).getInt(4);
        tmp164_162[i] = Long.valueOf(((Cursor)localObject1).getLong(0));
        tmp170_164[i] = ((Cursor)localObject1).getLong(1);
        tmp184_182[i] = ((Cursor)localObject1).getInt(2);
        arrayOfString[i] = ((Cursor)localObject1).getString(3);
      }
      i = 0;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
    while (i < 2)
    {
      if ((!isStatusSuccess(tmp184_182[i])) || (!isDownloadStillPresent(arrayOfString[i]))) {
        arrayOfString[i] = null;
      }
      i += 1;
    }
    if (paramBoolean)
    {
      i = 1;
      j = 0;
      label363:
      if (j > i) {
        break label439;
      }
      if (tmp164_162[j].longValue() == -1L) {
        if (j == 0) {
          break label433;
        }
      }
    }
    label433:
    for (boolean bool = true;; bool = false)
    {
      tmp164_162[j] = Long.valueOf(recordAttachmentInDb(paramLong1, paramLong2, paramAttachment, paramAttachmentRendition, -1L, bool, false, 0));
      j += 1;
      break label363;
      i = 0;
      break;
    }
    label439:
    if ((!isStatusValid(tmp184_182[0])) && (!isStatusValid(tmp184_182[1])))
    {
      LogUtils.d("Gmail", "AttachmentManager.queryAndStartDownloadingAttachment() starting new download", new Object[0]);
      l1 = tmp164_162[0].longValue();
      l2 = tmp164_162[1].longValue();
      if (!canDownloadAttachment(mContext, paramAttachment))
      {
        bool = true;
        startAttachmentDownloadInDownloadManager(l1, l2, bool);
      }
    }
    for (;;)
    {
      notifyChanged(paramLong1);
      return newAttachmentCursor(paramLong2, partId, paramAttachmentRendition, paramBoolean, paramArrayOfString);
      bool = false;
      break;
      if ((arrayOfString[0] == null) && (arrayOfString[1] == null)) {
        break label627;
      }
      LogUtils.d("Gmail", "AttachmentManager.queryAndStartDownloadingAttachment() file exists either on cache or sd card, will copy if needed", new Object[0]);
      if (arrayOfString[i] == null) {
        copyAttachment(tmp164_162[i].longValue(), paramLong1, paramLong2, partId, paramAttachmentRendition, paramBoolean, name, -1L, arrayOfString[(1 - i)], contentType, null, null, null);
      }
    }
    label627:
    LogUtils.d("Gmail", "AttachmentManager.queryAndStartDownloadingAttachment() refetch attachment", new Object[0]);
    int j = 0;
    while (j <= i)
    {
      localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("filename", name);
      ((ContentValues)localObject1).put("automatic", Integer.valueOf(0));
      mDb.update("attachments", (ContentValues)localObject1, "_id = ?", new String[] { Long.toString(tmp164_162[j].longValue()) });
      j += 1;
    }
    long l1 = tmp164_162[0].longValue();
    long l2 = tmp164_162[1].longValue();
    if (!canDownloadAttachment(mContext, paramAttachment)) {}
    for (bool = true;; bool = false)
    {
      startAttachmentDownloadInDownloadManager(l1, l2, bool);
      break;
    }
  }
  
  public Cursor queryForConversation(long paramLong, String[] paramArrayOfString)
  {
    return mDb.query("attachments", paramArrayOfString, "messages_conversation = ? AND desiredRendition = ?", new String[] { Long.toString(paramLong), Gmail.AttachmentRendition.BEST.toString() }, null, null, null);
  }
  
  long recordAttachmentInDb(long paramLong1, long paramLong2, Gmail.Attachment paramAttachment, Gmail.AttachmentRendition paramAttachmentRendition, long paramLong3, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("messages_conversation", Long.valueOf(paramLong1));
    localContentValues.put("messages_messageId", Long.valueOf(paramLong2));
    localContentValues.put("messages_partId", partId);
    localContentValues.put("originExtras", originExtras);
    localContentValues.put("desiredRendition", paramAttachmentRendition.toString());
    localContentValues.put("downloadedRendition", paramAttachmentRendition.toString());
    localContentValues.put("downloadId", Long.valueOf(paramLong3));
    int i;
    if (paramBoolean2)
    {
      i = 1;
      localContentValues.put("automatic", Integer.valueOf(i));
      localContentValues.put("priority", Integer.valueOf(paramInt));
      if (!paramBoolean1) {
        break label206;
      }
    }
    label206:
    for (paramInt = 1;; paramInt = 0)
    {
      localContentValues.put("saveToSd", Integer.valueOf(paramInt));
      localContentValues.put("filename", name);
      localContentValues.put("status", Integer.valueOf(190));
      localContentValues.put("mimeType", contentType);
      return mDb.insertWithOnConflict("attachments", null, localContentValues, 4);
      i = 0;
      break;
    }
  }
  
  public int resetAttachmentRequest(long paramLong1, long paramLong2, String paramString, Gmail.AttachmentRendition paramAttachmentRendition, boolean paramBoolean)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "resetAttachmentRequest: %s", new Object[] { requestDescription(paramLong1, paramLong2, paramString, paramAttachmentRendition, paramBoolean) });
    }
    paramString = newAttachmentCursor(paramLong2, paramString, paramAttachmentRendition, paramBoolean, new String[] { "_id", "downloadId", "filename" });
    try
    {
      if (paramString.moveToNext())
      {
        paramLong2 = paramString.getLong(0);
        long l = paramString.getLong(1);
        paramAttachmentRendition = paramString.getString(2);
        if ((mDownloadManager != null) && (isDownloadIdValid(l))) {
          mDownloadManager.remove(new long[] { l });
        }
        resetAttachment(paramLong1, paramLong2, paramAttachmentRendition);
        return 1;
      }
      return 0;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void updateMessageId(long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("messages_messageId", Long.valueOf(paramLong2));
    String str = Long.toString(paramLong1);
    mDb.update("attachments", localContentValues, "messages_messageId = ?", new String[] { str });
  }
  
  public static abstract interface RestrictedMailEngine
  {
    public abstract void enqueueAttachmentDownloadTask();
    
    public abstract String getAuthToken()
      throws Exception;
    
    public abstract int getRequestVersion();
    
    public abstract void postBackgroundTask(Runnable paramRunnable);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.AttachmentManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */