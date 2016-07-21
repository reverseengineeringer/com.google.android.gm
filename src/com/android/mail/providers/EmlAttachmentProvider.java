package com.android.mail.providers;

import android.app.DownloadManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import buj;
import chh;
import cvl;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmlAttachmentProvider
  extends ContentProvider
{
  static Uri a;
  private static final String b = cvl.a;
  private static final UriMatcher c = new UriMatcher(-1);
  private static boolean d = false;
  private DownloadManager e;
  private Map<Uri, List<Uri>> f;
  private Map<Uri, Attachment> g;
  
  /* Error */
  private final int a(Uri paramUri, ContentValues paramContentValues)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 49
    //   3: invokevirtual 55	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   6: astore 7
    //   8: aload_2
    //   9: ldc 57
    //   11: invokevirtual 55	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   14: astore_2
    //   15: aload 7
    //   17: ifnonnull +9 -> 26
    //   20: aload_2
    //   21: ifnonnull +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_2
    //   27: ifnull +44 -> 71
    //   30: aload_2
    //   31: invokevirtual 63	java/lang/Integer:intValue	()I
    //   34: istore_3
    //   35: iload_3
    //   36: iconst_1
    //   37: if_icmpne +39 -> 76
    //   40: iconst_1
    //   41: istore_3
    //   42: aload_0
    //   43: getfield 65	com/android/mail/providers/EmlAttachmentProvider:g	Ljava/util/Map;
    //   46: aload_1
    //   47: invokeinterface 71 2 0
    //   52: checkcast 73	com/android/mail/providers/Attachment
    //   55: astore 11
    //   57: iload_3
    //   58: ifeq +11 -> 69
    //   61: aload 11
    //   63: invokevirtual 76	com/android/mail/providers/Attachment:f	()Z
    //   66: ifeq +15 -> 81
    //   69: iconst_0
    //   70: ireturn
    //   71: iconst_0
    //   72: istore_3
    //   73: goto -38 -> 35
    //   76: iconst_0
    //   77: istore_3
    //   78: goto -36 -> 42
    //   81: aload_0
    //   82: aload_1
    //   83: invokespecial 79	com/android/mail/providers/EmlAttachmentProvider:b	(Landroid/net/Uri;)Ljava/lang/String;
    //   86: astore 10
    //   88: aload 11
    //   90: iconst_1
    //   91: putfield 82	com/android/mail/providers/Attachment:g	I
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial 79	com/android/mail/providers/EmlAttachmentProvider:b	(Landroid/net/Uri;)Ljava/lang/String;
    //   99: astore 9
    //   101: aconst_null
    //   102: astore 8
    //   104: aconst_null
    //   105: astore 7
    //   107: new 84	java/io/FileInputStream
    //   110: dup
    //   111: aload 10
    //   113: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   116: astore_2
    //   117: new 89	java/io/FileOutputStream
    //   120: dup
    //   121: aload 9
    //   123: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   126: astore 8
    //   128: invokestatic 96	android/os/SystemClock:elapsedRealtime	()J
    //   131: lstore 5
    //   133: sipush 4096
    //   136: newarray <illegal type>
    //   138: astore 7
    //   140: iconst_0
    //   141: istore_3
    //   142: aload_2
    //   143: aload 7
    //   145: invokevirtual 102	java/io/InputStream:read	([B)I
    //   148: istore 4
    //   150: iload 4
    //   152: iconst_m1
    //   153: if_icmpeq +152 -> 305
    //   156: aload 8
    //   158: aload 7
    //   160: iconst_0
    //   161: iload 4
    //   163: invokevirtual 108	java/io/OutputStream:write	([BII)V
    //   166: invokestatic 96	android/os/SystemClock:elapsedRealtime	()J
    //   169: lload 5
    //   171: lsub
    //   172: ldc2_w 109
    //   175: lcmp
    //   176: ifle +121 -> 297
    //   179: new 45	java/io/IOException
    //   182: dup
    //   183: ldc 112
    //   185: invokespecial 113	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   188: athrow
    //   189: astore 7
    //   191: getstatic 27	com/android/mail/providers/EmlAttachmentProvider:b	Ljava/lang/String;
    //   194: aload 7
    //   196: ldc 115
    //   198: iconst_1
    //   199: anewarray 117	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload 9
    //   206: aastore
    //   207: invokestatic 122	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   210: pop
    //   211: new 124	java/io/File
    //   214: dup
    //   215: aload 9
    //   217: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   220: invokevirtual 128	java/io/File:delete	()Z
    //   223: pop
    //   224: aload_2
    //   225: invokevirtual 131	java/io/InputStream:close	()V
    //   228: aload 8
    //   230: invokevirtual 132	java/io/OutputStream:close	()V
    //   233: aload_0
    //   234: invokevirtual 136	com/android/mail/providers/EmlAttachmentProvider:getContext	()Landroid/content/Context;
    //   237: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   240: aload_1
    //   241: invokestatic 145	com/android/mail/providers/EmlAttachmentProvider:a	(Landroid/net/Uri;)Landroid/net/Uri;
    //   244: aconst_null
    //   245: iconst_0
    //   246: invokevirtual 151	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;Z)V
    //   249: iconst_1
    //   250: ireturn
    //   251: astore_1
    //   252: getstatic 27	com/android/mail/providers/EmlAttachmentProvider:b	Ljava/lang/String;
    //   255: ldc -103
    //   257: iconst_1
    //   258: anewarray 117	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload 10
    //   265: aastore
    //   266: invokestatic 156	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   269: pop
    //   270: iconst_0
    //   271: ireturn
    //   272: astore_1
    //   273: getstatic 27	com/android/mail/providers/EmlAttachmentProvider:b	Ljava/lang/String;
    //   276: ldc -103
    //   278: iconst_1
    //   279: anewarray 117	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload 9
    //   286: aastore
    //   287: invokestatic 156	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   290: pop
    //   291: aload_2
    //   292: invokevirtual 131	java/io/InputStream:close	()V
    //   295: iconst_0
    //   296: ireturn
    //   297: iload 4
    //   299: iload_3
    //   300: iadd
    //   301: istore_3
    //   302: goto -160 -> 142
    //   305: aload 11
    //   307: invokevirtual 160	com/android/mail/providers/Attachment:l	()Ljava/lang/String;
    //   310: invokestatic 165	cvr:a	(Ljava/lang/String;)Z
    //   313: ifeq +37 -> 350
    //   316: aload 9
    //   318: invokestatic 171	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   321: astore 7
    //   323: aload 7
    //   325: invokevirtual 174	java/lang/String:length	()I
    //   328: ifeq +151 -> 479
    //   331: ldc -80
    //   333: aload 7
    //   335: invokevirtual 180	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   338: astore 7
    //   340: aload 11
    //   342: aload 7
    //   344: invokestatic 186	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   347: putfield 189	com/android/mail/providers/Attachment:i	Landroid/net/Uri;
    //   350: aload 11
    //   352: getfield 191	com/android/mail/providers/Attachment:c	Ljava/lang/String;
    //   355: astore 7
    //   357: aload_0
    //   358: getfield 193	com/android/mail/providers/EmlAttachmentProvider:e	Landroid/app/DownloadManager;
    //   361: aload 11
    //   363: getfield 191	com/android/mail/providers/Attachment:c	Ljava/lang/String;
    //   366: aload 7
    //   368: iconst_1
    //   369: aload 11
    //   371: invokevirtual 160	com/android/mail/providers/Attachment:l	()Ljava/lang/String;
    //   374: aload 9
    //   376: iload_3
    //   377: i2l
    //   378: iconst_0
    //   379: invokevirtual 199	android/app/DownloadManager:addCompletedDownload	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JZ)J
    //   382: pop2
    //   383: new 201	android/content/Intent
    //   386: dup
    //   387: ldc -53
    //   389: invokespecial 204	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   392: astore 11
    //   394: aload 9
    //   396: invokestatic 171	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   399: astore 7
    //   401: aload 7
    //   403: invokevirtual 174	java/lang/String:length	()I
    //   406: ifeq +107 -> 513
    //   409: ldc -80
    //   411: aload 7
    //   413: invokevirtual 180	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   416: astore 7
    //   418: aload 11
    //   420: aload 7
    //   422: invokestatic 186	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   425: invokevirtual 208	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   428: pop
    //   429: aload_0
    //   430: invokevirtual 136	com/android/mail/providers/EmlAttachmentProvider:getContext	()Landroid/content/Context;
    //   433: aload 11
    //   435: invokevirtual 212	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   438: new 124	java/io/File
    //   441: dup
    //   442: aload 10
    //   444: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   447: invokevirtual 128	java/io/File:delete	()Z
    //   450: pop
    //   451: goto -227 -> 224
    //   454: astore_1
    //   455: aload 8
    //   457: astore 7
    //   459: aload_2
    //   460: ifnull +7 -> 467
    //   463: aload_2
    //   464: invokevirtual 131	java/io/InputStream:close	()V
    //   467: aload 7
    //   469: ifnull +8 -> 477
    //   472: aload 7
    //   474: invokevirtual 132	java/io/OutputStream:close	()V
    //   477: aload_1
    //   478: athrow
    //   479: new 167	java/lang/String
    //   482: dup
    //   483: ldc -80
    //   485: invokespecial 213	java/lang/String:<init>	(Ljava/lang/String;)V
    //   488: astore 7
    //   490: goto -150 -> 340
    //   493: astore 7
    //   495: getstatic 27	com/android/mail/providers/EmlAttachmentProvider:b	Ljava/lang/String;
    //   498: aload 7
    //   500: ldc -41
    //   502: iconst_0
    //   503: anewarray 117	java/lang/Object
    //   506: invokestatic 122	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   509: pop
    //   510: goto -127 -> 383
    //   513: new 167	java/lang/String
    //   516: dup
    //   517: ldc -80
    //   519: invokespecial 213	java/lang/String:<init>	(Ljava/lang/String;)V
    //   522: astore 7
    //   524: goto -106 -> 418
    //   527: astore_1
    //   528: goto -233 -> 295
    //   531: astore_2
    //   532: goto -304 -> 228
    //   535: astore_2
    //   536: goto -303 -> 233
    //   539: astore_2
    //   540: goto -73 -> 467
    //   543: astore_2
    //   544: goto -67 -> 477
    //   547: astore_1
    //   548: aload 8
    //   550: astore_2
    //   551: goto -92 -> 459
    //   554: astore_1
    //   555: goto -96 -> 459
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	this	EmlAttachmentProvider
    //   0	558	1	paramUri	Uri
    //   0	558	2	paramContentValues	ContentValues
    //   34	343	3	i	int
    //   148	153	4	j	int
    //   131	39	5	l	long
    //   6	153	7	localObject1	Object
    //   189	6	7	localIOException	java.io.IOException
    //   321	168	7	localObject2	Object
    //   493	6	7	localIllegalArgumentException	IllegalArgumentException
    //   522	1	7	str1	String
    //   102	447	8	localFileOutputStream	java.io.FileOutputStream
    //   99	296	9	str2	String
    //   86	357	10	str3	String
    //   55	379	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   128	140	189	java/io/IOException
    //   142	150	189	java/io/IOException
    //   156	189	189	java/io/IOException
    //   305	340	189	java/io/IOException
    //   340	350	189	java/io/IOException
    //   350	383	189	java/io/IOException
    //   383	418	189	java/io/IOException
    //   418	451	189	java/io/IOException
    //   479	490	189	java/io/IOException
    //   495	510	189	java/io/IOException
    //   513	524	189	java/io/IOException
    //   107	117	251	java/io/FileNotFoundException
    //   117	128	272	java/io/FileNotFoundException
    //   128	140	454	finally
    //   142	150	454	finally
    //   156	189	454	finally
    //   191	224	454	finally
    //   305	340	454	finally
    //   340	350	454	finally
    //   350	383	454	finally
    //   383	418	454	finally
    //   418	451	454	finally
    //   479	490	454	finally
    //   495	510	454	finally
    //   513	524	454	finally
    //   350	383	493	java/lang/IllegalArgumentException
    //   291	295	527	java/io/IOException
    //   224	228	531	java/io/IOException
    //   228	233	535	java/io/IOException
    //   463	467	539	java/io/IOException
    //   472	477	543	java/io/IOException
    //   107	117	547	finally
    //   252	270	547	finally
    //   117	128	554	finally
    //   273	291	554	finally
  }
  
  private static Uri a(Uri paramUri)
  {
    paramUri = paramUri.getPathSegments();
    return a.buildUpon().appendPath("attachments").appendPath((String)paramUri.get(1)).appendPath((String)paramUri.get(2)).build();
  }
  
  public static Uri a(Uri paramUri, String paramString)
  {
    if (paramUri == null) {
      return null;
    }
    return a.buildUpon().appendPath("attachmentByCid").appendPath(Integer.toString(paramUri.hashCode())).appendPath(paramString).build();
  }
  
  private final String a()
  {
    return getContext().getCacheDir().getAbsolutePath().concat("/eml");
  }
  
  private final void a(MatrixCursor paramMatrixCursor, Uri paramUri, List<String> paramList)
  {
    paramUri = (Attachment)g.get(paramUri);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (paramUri.l().startsWith(str)) {
          a(paramMatrixCursor, paramUri);
        }
      }
      return;
    }
    a(paramMatrixCursor, paramUri);
  }
  
  private static void a(MatrixCursor paramMatrixCursor, Attachment paramAttachment)
  {
    paramMatrixCursor = paramMatrixCursor.newRow().add(c).add(Integer.valueOf(d)).add(e).add(paramAttachment.l()).add(Integer.valueOf(f)).add(Integer.valueOf(g)).add(Integer.valueOf(h)).add(i).add(j).add(m);
    if (paramAttachment.i()) {}
    for (int i = 1;; i = 0)
    {
      paramMatrixCursor.add(Integer.valueOf(i)).add(Integer.valueOf(k)).add(Integer.valueOf(l)).add(b);
      return;
    }
  }
  
  private final void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  private final String b(Uri paramUri)
  {
    Attachment localAttachment = (Attachment)g.get(paramUri);
    int i;
    Object localObject;
    if (g == 1)
    {
      i = 1;
      if (i == 0) {
        break label123;
      }
      localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
      label40:
      if (i == 0) {
        break label131;
      }
      paramUri = (Uri)localObject;
    }
    for (;;)
    {
      localObject = new File(paramUri);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = String.valueOf(c);
      return String.valueOf(paramUri).length() + 1 + String.valueOf(localObject).length() + paramUri + "/" + (String)localObject;
      i = 0;
      break;
      label123:
      localObject = a();
      break label40;
      label131:
      localObject = String.valueOf(localObject);
      paramUri = String.valueOf(paramUri.getEncodedPath());
      if (paramUri.length() != 0) {
        paramUri = ((String)localObject).concat(paramUri);
      } else {
        paramUri = new String((String)localObject);
      }
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    switch (c.match(paramUri))
    {
    default: 
      return 0;
    }
    paramString = (List)f.remove(paramUri);
    paramArrayOfString = paramString.iterator();
    while (paramArrayOfString.hasNext())
    {
      Uri localUri = (Uri)paramArrayOfString.next();
      g.remove(localUri);
    }
    paramArrayOfString = String.valueOf(a());
    paramUri = String.valueOf(Uri.encode((String)paramUri.getPathSegments().get(1)));
    a(new File(String.valueOf(paramArrayOfString).length() + 1 + String.valueOf(paramUri).length() + paramArrayOfString + "/" + paramUri));
    return paramString.size();
  }
  
  public String getType(Uri paramUri)
  {
    switch (c.match(paramUri))
    {
    default: 
      return null;
    }
    return ((Attachment)g.get(paramUri)).l();
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Uri localUri = a(paramUri);
    if (g.put(paramUri, new Attachment(paramContentValues)) == null)
    {
      List localList = (List)f.get(localUri);
      paramContentValues = localList;
      if (localList == null)
      {
        paramContentValues = new ArrayList();
        f.put(localUri, paramContentValues);
      }
      paramContentValues.add(paramUri);
    }
    return paramUri;
  }
  
  public boolean onCreate()
  {
    String str = getContext().getResources().getString(buj.bw);
    a = new Uri.Builder().scheme("content").authority(str).build();
    if (!d)
    {
      d = true;
      c.addURI(str, "attachments/*/*", 0);
      c.addURI(str, "attachment/*/*/#", 1);
      c.addURI(str, "attachmentByCid/*/*/*", 2);
    }
    e = ((DownloadManager)getContext().getSystemService("download"));
    f = new HashMap();
    g = new HashMap();
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    paramUri = b(paramUri);
    int i;
    if ("rwt".equals(paramString)) {
      i = 1006632960;
    }
    for (;;)
    {
      return ParcelFileDescriptor.open(new File(paramUri), i);
      if ("rw".equals(paramString)) {
        i = 939524096;
      } else {
        i = 268435456;
      }
    }
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i = c.match(paramUri);
    paramArrayOfString1 = new MatrixCursor(chh.o);
    paramString1 = getContext().getContentResolver();
    switch (i)
    {
    }
    Object localObject;
    do
    {
      while (!paramString2.hasNext())
      {
        do
        {
          return paramArrayOfString1;
          paramArrayOfString2 = paramUri.getQueryParameters("contentType");
          paramUri = paramUri.buildUpon().clearQuery().build();
          paramString2 = ((List)f.get(paramUri)).iterator();
          while (paramString2.hasNext()) {
            a(paramArrayOfString1, (Uri)paramString2.next(), paramArrayOfString2);
          }
          paramArrayOfString1.setNotificationUri(paramString1, paramUri);
          return paramArrayOfString1;
          a(paramArrayOfString1, (Attachment)g.get(paramUri));
          paramArrayOfString1.setNotificationUri(paramString1, a(paramUri));
          return paramArrayOfString1;
          paramArrayOfString2 = a(paramUri);
          paramUri = (String)paramUri.getPathSegments().get(3);
          paramString2 = (List)f.get(paramArrayOfString2);
        } while (paramString2 == null);
        paramString2 = paramString2.iterator();
      }
      localObject = (Uri)paramString2.next();
      localObject = (Attachment)g.get(localObject);
    } while (!TextUtils.equals(paramUri, b));
    a(paramArrayOfString1, (Attachment)localObject);
    paramArrayOfString1.setNotificationUri(paramString1, paramArrayOfString2);
    return paramArrayOfString1;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    switch (c.match(paramUri))
    {
    default: 
      return 0;
    }
    return a(paramUri, paramContentValues);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.EmlAttachmentProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */