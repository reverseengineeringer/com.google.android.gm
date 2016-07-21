import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;

public class axd
  extends awr
{
  static String g = null;
  private static final Charset k = new cyu().charsetForName("X-RFC-3501");
  String h;
  String i;
  boolean j;
  private final ConcurrentLinkedQueue<axb> l = new ConcurrentLinkedQueue();
  
  public axd(Context paramContext, Account paramAccount)
  {
    b = paramContext;
    c = paramAccount;
    paramAccount = paramAccount.d(paramContext);
    if (paramAccount == null) {
      throw new bdi(3, "No HostAuth in ImapStore?");
    }
    d = new ayd(paramContext, "IMAP", paramAccount);
    String[] arrayOfString = paramAccount.j();
    e = arrayOfString[0];
    f = arrayOfString[1];
    if (paramAccount.a(paramContext) != null) {}
    for (;;)
    {
      j = bool;
      h = h;
      return;
      bool = false;
    }
  }
  
  private static int a(axr paramaxr)
  {
    int m = 0;
    while (m < d.size())
    {
      Object localObject = paramaxr.c(m);
      localObject = (Integer)Mailbox.W.get(((axy)localObject).e());
      if (localObject != null) {
        return ((Integer)localObject).intValue();
      }
      m += 1;
    }
    return -1;
  }
  
  private final axc a(long paramLong, String paramString, char paramChar, boolean paramBoolean, Mailbox paramMailbox, int paramInt)
  {
    axc localaxc = (axc)a(paramString);
    if (paramMailbox.h()) {
      b = paramMailbox.d();
    }
    g = paramLong;
    i = paramChar;
    paramChar = paramString.lastIndexOf(paramChar);
    if (paramChar > 0) {}
    for (String str = paramString.substring(paramChar + '\001');; str = paramString)
    {
      c = str;
      if (paramBoolean) {
        o = 24;
      }
      n = true;
      d = paramString;
      h = paramInt;
      if (b == null)
      {
        b = paramMailbox.d();
        r = 8;
        paramMailbox.h(b);
      }
      a = paramMailbox;
      return localaxc;
    }
  }
  
  private final axc a(Context paramContext, long paramLong, String paramString, char paramChar, boolean paramBoolean, int paramInt)
  {
    if (paramInt == -1) {
      if (!TextUtils.isEmpty(paramString))
      {
        Integer localInteger = (Integer)Mailbox.V.get(paramString);
        if (localInteger != null) {
          paramInt = localInteger.intValue();
        }
      }
    }
    for (;;)
    {
      return a(paramLong, paramString, paramChar, paramBoolean, Mailbox.a(paramContext, paramLong, paramString), paramInt);
      paramInt = 1;
    }
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 32	axd:g	Ljava/lang/String;
    //   6: ifnonnull +336 -> 342
    //   9: aload_0
    //   10: ldc -56
    //   12: invokevirtual 206	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 208	android/telephony/TelephonyManager
    //   18: astore 4
    //   20: aload_0
    //   21: invokevirtual 211	android/content/Context:getPackageName	()Ljava/lang/String;
    //   24: astore_2
    //   25: getstatic 216	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   28: astore 6
    //   30: getstatic 219	android/os/Build$VERSION:CODENAME	Ljava/lang/String;
    //   33: astore 8
    //   35: getstatic 224	android/os/Build:MODEL	Ljava/lang/String;
    //   38: astore 9
    //   40: getstatic 227	android/os/Build:ID	Ljava/lang/String;
    //   43: astore 7
    //   45: getstatic 230	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   48: astore_3
    //   49: aload 4
    //   51: invokevirtual 233	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   54: astore 4
    //   56: ldc -21
    //   58: invokestatic 241	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   61: ldc -13
    //   63: invokevirtual 247	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   66: astore 5
    //   68: aload 5
    //   70: aload_2
    //   71: invokestatic 250	axd:a	(Ljava/util/regex/Matcher;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_2
    //   75: aload 5
    //   77: aload 6
    //   79: invokestatic 250	axd:a	(Ljava/util/regex/Matcher;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 6
    //   84: aload 5
    //   86: aload 8
    //   88: invokestatic 250	axd:a	(Ljava/util/regex/Matcher;Ljava/lang/String;)Ljava/lang/String;
    //   91: astore 8
    //   93: aload 5
    //   95: aload 9
    //   97: invokestatic 250	axd:a	(Ljava/util/regex/Matcher;Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 9
    //   102: aload 5
    //   104: aload 7
    //   106: invokestatic 250	axd:a	(Ljava/util/regex/Matcher;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 7
    //   111: aload 5
    //   113: aload_3
    //   114: invokestatic 250	axd:a	(Ljava/util/regex/Matcher;Ljava/lang/String;)Ljava/lang/String;
    //   117: astore_3
    //   118: aload 5
    //   120: aload 4
    //   122: invokestatic 250	axd:a	(Ljava/util/regex/Matcher;Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 4
    //   127: new 252	java/lang/StringBuilder
    //   130: dup
    //   131: ldc -2
    //   133: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: astore 5
    //   138: aload 5
    //   140: aload_2
    //   141: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 5
    //   147: ldc_w 263
    //   150: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 5
    //   156: ldc_w 265
    //   159: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 5
    //   165: ldc_w 267
    //   168: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 6
    //   174: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifeq +245 -> 422
    //   180: aload 5
    //   182: ldc_w 269
    //   185: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 7
    //   191: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifne +20 -> 214
    //   197: aload 5
    //   199: ldc_w 271
    //   202: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 5
    //   208: aload 7
    //   210: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 5
    //   216: ldc_w 263
    //   219: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_3
    //   224: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   227: ifne +28 -> 255
    //   230: aload 5
    //   232: ldc_w 273
    //   235: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 5
    //   241: aload_3
    //   242: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 5
    //   248: ldc_w 263
    //   251: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc_w 275
    //   258: aload 8
    //   260: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +37 -> 300
    //   266: aload 9
    //   268: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   271: ifne +29 -> 300
    //   274: aload 5
    //   276: ldc_w 281
    //   279: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 5
    //   285: aload 9
    //   287: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 5
    //   293: ldc_w 263
    //   296: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 4
    //   302: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   305: ifne +29 -> 334
    //   308: aload 5
    //   310: ldc_w 283
    //   313: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 5
    //   319: aload 4
    //   321: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 5
    //   327: ldc_w 263
    //   330: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload 5
    //   336: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: putstatic 32	axd:g	Ljava/lang/String;
    //   342: ldc 2
    //   344: monitorexit
    //   345: new 252	java/lang/StringBuilder
    //   348: dup
    //   349: getstatic 32	axd:g	Ljava/lang/String;
    //   352: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   355: astore_2
    //   356: aload_0
    //   357: invokestatic 291	aqv:a	(Landroid/content/Context;)Laqv;
    //   360: invokevirtual 293	aqv:a	()Ljava/lang/String;
    //   363: astore_0
    //   364: ldc_w 295
    //   367: invokestatic 301	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   370: astore_3
    //   371: aload_3
    //   372: aload_1
    //   373: invokevirtual 305	java/lang/String:getBytes	()[B
    //   376: invokevirtual 309	java/security/MessageDigest:update	([B)V
    //   379: aload_3
    //   380: aload_0
    //   381: invokevirtual 305	java/lang/String:getBytes	()[B
    //   384: invokevirtual 309	java/security/MessageDigest:update	([B)V
    //   387: aload_3
    //   388: invokevirtual 312	java/security/MessageDigest:digest	()[B
    //   391: iconst_2
    //   392: invokestatic 318	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   395: astore_0
    //   396: aload_2
    //   397: ldc_w 320
    //   400: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_2
    //   405: aload_0
    //   406: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_2
    //   411: bipush 34
    //   413: invokevirtual 323	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: areturn
    //   422: aload 5
    //   424: aload 6
    //   426: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: goto -241 -> 189
    //   433: astore_0
    //   434: ldc 2
    //   436: monitorexit
    //   437: aload_0
    //   438: athrow
    //   439: astore_0
    //   440: getstatic 327	bbw:a	Ljava/lang/String;
    //   443: ldc_w 329
    //   446: iconst_0
    //   447: anewarray 331	java/lang/Object
    //   450: invokestatic 336	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   453: pop
    //   454: goto -37 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	paramContext	Context
    //   0	457	1	paramString	String
    //   24	394	2	localObject1	Object
    //   48	340	3	localObject2	Object
    //   18	302	4	localObject3	Object
    //   66	357	5	localObject4	Object
    //   28	397	6	str1	String
    //   43	166	7	str2	String
    //   33	226	8	str3	String
    //   38	248	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   3	189	433	finally
    //   189	214	433	finally
    //   214	255	433	finally
    //   255	300	433	finally
    //   300	334	433	finally
    //   334	342	433	finally
    //   342	345	433	finally
    //   422	430	433	finally
    //   434	437	433	finally
    //   356	417	439	java/security/NoSuchAlgorithmException
  }
  
  private static String a(Matcher paramMatcher, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramMatcher.reset(paramString).replaceAll("");
  }
  
  static String a(bdg[] paramArrayOfbdg)
  {
    int m = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = paramArrayOfbdg.length;
    int n = 0;
    while (m < i1)
    {
      bdg localbdg = paramArrayOfbdg[m];
      if (n != 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(f);
      n = 1;
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(Context paramContext, HashMap<String, axc> paramHashMap)
  {
    Iterator localIterator = paramHashMap.values().iterator();
    Mailbox localMailbox;
    int m;
    ContentResolver localContentResolver;
    String[] arrayOfString;
    while (localIterator.hasNext())
    {
      axc localaxc = (axc)localIterator.next();
      localMailbox = a;
      if (!localMailbox.h())
      {
        localMailbox.h(paramContext);
        b = localMailbox.d();
      }
      else
      {
        Object[] arrayOfObject = localMailbox.d();
        if (!Arrays.equals(b, arrayOfObject))
        {
          m = h;
          switch (m)
          {
          }
          do
          {
            localMailbox.a(paramContext, localMailbox.e());
            b = arrayOfObject;
            break;
            localContentResolver = paramContext.getContentResolver();
            arrayOfString = new String[3];
            arrayOfString[0] = String.valueOf(g);
            arrayOfString[1] = String.valueOf(m);
            arrayOfString[2] = String.valueOf(localMailbox.c());
            paramHashMap = localContentResolver.query(Mailbox.a, Mailbox.B, "accountKey=? AND type=? AND NOT _id=?", arrayOfString, null);
          } while (paramHashMap == null);
        }
      }
    }
    for (;;)
    {
      try
      {
        ContentValues localContentValues = new ContentValues(1);
        localContentValues.put("mailboxKey", Long.valueOf(localMailbox.c()));
        if (!paramHashMap.moveToNext()) {
          break label463;
        }
        switch (m)
        {
        case 4: 
        case 5: 
          cvm.f(cvm.a, "Messages in system folder of type %d should be moved to %s.", new Object[] { Integer.valueOf(m), localMailbox });
          break;
        case 3: 
          
        }
      }
      finally
      {
        paramHashMap.close();
      }
      tmp340_337[0] = String.valueOf(paramHashMap.getInt(0));
      int n = localContentResolver.update(beb.a, localContentValues, "mailboxKey=?", tmp340_337);
      cvm.c(cvm.a, "%d messages moved from folder/%d to %s", new Object[] { Integer.valueOf(n), Integer.valueOf(paramHashMap.getInt(0)), localMailbox });
      continue;
      n = localContentResolver.delete(beb.a, "accountKey=? AND mailboxKey=?", new String[] { String.valueOf(g), String.valueOf(paramHashMap.getInt(0)) });
      cvm.c(cvm.a, "%d messages moved to system \\Trash", new Object[] { Integer.valueOf(n) });
      continue;
      label463:
      paramHashMap.close();
      localContentResolver.delete(Mailbox.a, "accountKey=? AND type=? AND NOT _id=?", arrayOfString);
      break;
      return;
    }
  }
  
  private static void a(HashMap<String, axc> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    String str1;
    Mailbox localMailbox;
    long l1;
    label95:
    Object localObject;
    if (localIterator.hasNext())
    {
      str1 = (String)localIterator.next();
      localMailbox = geta;
      int m = d.lastIndexOf(i);
      l1 = -1L;
      if (m == -1) {
        break label175;
      }
      str1 = str1.substring(0, m);
      if (!"INBOX".equalsIgnoreCase(str1)) {
        break label172;
      }
      str1 = "INBOX";
      localObject = (axc)paramHashMap.get(str1);
      if (localObject == null)
      {
        localObject = null;
        label114:
        str2 = str1;
        if (localObject != null)
        {
          l1 = D;
          o |= 0x3;
        }
      }
    }
    label172:
    label175:
    for (String str2 = str1;; str2 = null)
    {
      f = l1;
      e = str2;
      break;
      localObject = a;
      break label114;
      return;
      break label95;
    }
  }
  
  static String b(String paramString1, String paramString2)
  {
    if ("INBOX".equalsIgnoreCase(paramString1)) {
      return paramString1;
    }
    if (paramString2 != null)
    {
      paramString2 = String.valueOf(paramString2);
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() != 0) {
        paramString1 = paramString2.concat(paramString1);
      }
    }
    for (;;)
    {
      paramString1 = k.encode(paramString1);
      paramString2 = new byte[paramString1.limit()];
      paramString1.get(paramString2);
      return bhn.a(bhn.b, paramString2);
      paramString1 = new String(paramString2);
    }
  }
  
  static String c(String paramString1, String paramString2)
  {
    String str = k.decode(ByteBuffer.wrap(bhn.a(bhn.b, paramString1))).toString();
    paramString1 = str;
    if (paramString2 != null)
    {
      paramString1 = str;
      if (str.startsWith(paramString2)) {
        paramString1 = str.substring(paramString2.length());
      }
    }
    return paramString1;
  }
  
  public final bdb a(String paramString)
  {
    return new axc(this, paramString);
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    try
    {
      localObject1 = b.getContentResolver().query(Mailbox.a, new String[] { "localOnly" }, "accountKey=? AND _id=?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, null);
      if (localObject1 != null) {}
      try
      {
        int m;
        if (((Cursor)localObject1).moveToNext())
        {
          if (((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex("localOnly")) != 1) {
            break label145;
          }
          m = 1;
          if (m == 0) {
            break label151;
          }
          b.getContentResolver().delete(Mailbox.a, "accountKey=? AND _id=?", new String[] { String.valueOf(c.D), String.valueOf(paramLong2) });
        }
        for (;;)
        {
          if (localObject1 != null) {
            ((Cursor)localObject1).close();
          }
          return;
          label145:
          m = 0;
          break;
          label151:
          localObject3 = new ContentValues(1);
          ((ContentValues)localObject3).put("isDeleted", Integer.valueOf(1));
          b.getContentResolver().update(Mailbox.a, (ContentValues)localObject3, "accountKey=? AND _id=?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
        }
        if (localObject3 == null) {
          break label235;
        }
      }
      finally
      {
        localObject3 = localObject1;
        localObject1 = localObject4;
      }
    }
    finally
    {
      Object localObject1;
      label235:
      Object localObject3 = null;
    }
    ((Cursor)localObject3).close();
    throw ((Throwable)localObject1);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2)
  {
    localObject1 = ab, paramLong1, paramString, '\000', true, 1).a;
    Context localContext = b;
    ContentValues localContentValues1;
    if (true != w)
    {
      localContentValues1 = new ContentValues(3);
      localContentValues1.put("localOnly", Integer.valueOf(1));
      localContentValues1.putNull("previousName");
      localContentValues1.put("parentKey", Long.valueOf(paramLong2));
      f = paramLong2;
      if (f == -1L) {}
    }
    try
    {
      paramString = localContext.getContentResolver().query(Mailbox.a, Mailbox.R, "accountKey=? AND _id=?", new String[] { String.valueOf(paramLong1), String.valueOf(f) }, null);
      if (paramString != null) {}
      try
      {
        if (paramString.moveToNext())
        {
          int m = paramString.getInt(paramString.getColumnIndex("flags"));
          if ((m & 0x3) != 3)
          {
            ContentValues localContentValues2 = new ContentValues(1);
            localContentValues2.put("flags", Integer.valueOf(m | 0x3));
            localContext.getContentResolver().update(Mailbox.a, localContentValues2, "accountKey=? AND _id=?", new String[] { String.valueOf(paramLong1), String.valueOf(f) });
          }
        }
        for (;;)
        {
          if (paramString != null) {
            paramString.close();
          }
          ((Mailbox)localObject1).a(localContext, localContentValues1);
          w = true;
          return;
          cvm.d(bbw.a, "Parent folder does not exist", new Object[0]);
        }
        if (localObject1 == null) {
          break label302;
        }
      }
      finally
      {
        localObject1 = paramString;
        paramString = (String)localObject2;
      }
    }
    finally
    {
      localObject1 = null;
    }
    ((Cursor)localObject1).close();
    label302:
    throw paramString;
  }
  
  final void a(axb paramaxb)
  {
    if (paramaxb != null)
    {
      paramaxb.c();
      l.add(paramaxb);
    }
  }
  
  public final boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      return false;
    }
    return true;
  }
  
  /* Error */
  public final bdb[] b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 600	axd:g	()Laxb;
    //   4: astore 6
    //   6: new 353	java/util/HashMap
    //   9: dup
    //   10: invokespecial 601	java/util/HashMap:<init>	()V
    //   13: astore 7
    //   15: aload 6
    //   17: ldc_w 603
    //   20: iconst_0
    //   21: invokevirtual 606	axb:b	(Ljava/lang/String;Z)Ljava/util/List;
    //   24: pop
    //   25: ldc_w 608
    //   28: astore 5
    //   30: aload_0
    //   31: getfield 91	axd:h	Ljava/lang/String;
    //   34: ifnull +64 -> 98
    //   37: ldc_w 610
    //   40: invokestatic 499	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   43: astore 5
    //   45: aload_0
    //   46: getfield 91	axd:h	Ljava/lang/String;
    //   49: astore 8
    //   51: new 252	java/lang/StringBuilder
    //   54: dup
    //   55: aload 5
    //   57: invokestatic 499	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   60: invokevirtual 502	java/lang/String:length	()I
    //   63: iconst_2
    //   64: iadd
    //   65: aload 8
    //   67: invokestatic 499	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 502	java/lang/String:length	()I
    //   73: iadd
    //   74: invokespecial 611	java/lang/StringBuilder:<init>	(I)V
    //   77: aload 5
    //   79: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 8
    //   84: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 613
    //   90: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore 5
    //   98: aload 6
    //   100: aload 5
    //   102: iconst_0
    //   103: invokevirtual 606	axb:b	(Ljava/lang/String;Z)Ljava/util/List;
    //   106: invokeinterface 616 1 0
    //   111: astore 5
    //   113: iconst_0
    //   114: istore_3
    //   115: aload 5
    //   117: invokeinterface 368 1 0
    //   122: ifeq +161 -> 283
    //   125: aload 5
    //   127: invokeinterface 372 1 0
    //   132: checkcast 618	axu
    //   135: astore 8
    //   137: aload 8
    //   139: iconst_0
    //   140: ldc_w 620
    //   143: invokevirtual 623	axu:a	(ILjava/lang/String;)Z
    //   146: ifeq +351 -> 497
    //   149: aload 8
    //   151: iconst_3
    //   152: invokevirtual 624	axu:c	(I)Laxy;
    //   155: astore 9
    //   157: aload 9
    //   159: invokevirtual 626	axy:g	()Z
    //   162: ifne -47 -> 115
    //   165: aload 9
    //   167: invokevirtual 117	axy:e	()Ljava/lang/String;
    //   170: aload_0
    //   171: getfield 91	axd:h	Ljava/lang/String;
    //   174: invokestatic 628	axd:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 9
    //   179: ldc_w 484
    //   182: aload 9
    //   184: invokevirtual 488	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   187: ifne -72 -> 115
    //   190: aload 8
    //   192: iconst_1
    //   193: invokevirtual 631	axu:b	(I)Laxr;
    //   196: astore 10
    //   198: aload 10
    //   200: ldc_w 633
    //   203: invokevirtual 635	axr:a	(Ljava/lang/String;)Z
    //   206: ifne +302 -> 508
    //   209: iconst_1
    //   210: istore 4
    //   212: aload 10
    //   214: invokestatic 637	axd:a	(Laxr;)I
    //   217: istore_2
    //   218: aload 8
    //   220: iconst_2
    //   221: invokevirtual 624	axu:c	(I)Laxy;
    //   224: invokevirtual 117	axy:e	()Ljava/lang/String;
    //   227: astore 8
    //   229: aload 8
    //   231: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifne +266 -> 500
    //   237: aload 8
    //   239: iconst_0
    //   240: invokevirtual 641	java/lang/String:charAt	(I)C
    //   243: istore_1
    //   244: aload 7
    //   246: aload 9
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 44	axd:b	Landroid/content/Context;
    //   253: aload_0
    //   254: getfield 48	axd:c	Lcom/android/emailcommon/provider/Account;
    //   257: getfield 556	com/android/emailcommon/provider/Account:D	J
    //   260: aload 9
    //   262: iload_1
    //   263: iload 4
    //   265: iload_2
    //   266: invokespecial 564	axd:a	(Landroid/content/Context;JLjava/lang/String;CZI)Laxc;
    //   269: invokevirtual 644	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   272: pop
    //   273: iload_2
    //   274: iconst_m1
    //   275: if_icmpeq +222 -> 497
    //   278: iconst_1
    //   279: istore_3
    //   280: goto +225 -> 505
    //   283: invokestatic 649	buo:a	()Lbut;
    //   286: ldc_w 651
    //   289: ldc_w 653
    //   292: iload_3
    //   293: invokestatic 656	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   296: lconst_0
    //   297: invokeinterface 661 6 0
    //   302: aload_0
    //   303: getfield 44	axd:b	Landroid/content/Context;
    //   306: aload_0
    //   307: getfield 48	axd:c	Lcom/android/emailcommon/provider/Account;
    //   310: getfield 556	com/android/emailcommon/provider/Account:D	J
    //   313: iconst_0
    //   314: invokestatic 664	com/android/emailcommon/provider/Mailbox:b	(Landroid/content/Context;JI)Lcom/android/emailcommon/provider/Mailbox;
    //   317: astore 5
    //   319: aload 5
    //   321: ifnonnull +73 -> 394
    //   324: new 56	bdi
    //   327: dup
    //   328: bipush 28
    //   330: ldc_w 666
    //   333: iconst_1
    //   334: anewarray 331	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload_0
    //   340: getfield 48	axd:c	Lcom/android/emailcommon/provider/Account;
    //   343: getfield 556	com/android/emailcommon/provider/Account:D	J
    //   346: invokestatic 423	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   349: aastore
    //   350: invokestatic 670	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   353: invokespecial 61	bdi:<init>	(ILjava/lang/String;)V
    //   356: athrow
    //   357: astore 5
    //   359: aload 6
    //   361: invokevirtual 672	axb:b	()V
    //   364: new 56	bdi
    //   367: dup
    //   368: iconst_1
    //   369: ldc_w 674
    //   372: aload 5
    //   374: invokespecial 677	bdi:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   377: athrow
    //   378: astore 5
    //   380: aload 6
    //   382: ifnull +9 -> 391
    //   385: aload_0
    //   386: aload 6
    //   388: invokevirtual 679	axd:a	(Laxb;)V
    //   391: aload 5
    //   393: athrow
    //   394: aload 7
    //   396: ldc_w 484
    //   399: aload_0
    //   400: aload_0
    //   401: getfield 48	axd:c	Lcom/android/emailcommon/provider/Account;
    //   404: getfield 556	com/android/emailcommon/provider/Account:D	J
    //   407: aload 5
    //   409: getfield 169	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   412: iconst_0
    //   413: iconst_1
    //   414: aload 5
    //   416: aload 5
    //   418: getfield 171	com/android/emailcommon/provider/Mailbox:h	I
    //   421: invokespecial 195	axd:a	(JLjava/lang/String;CZLcom/android/emailcommon/provider/Mailbox;I)Laxc;
    //   424: invokevirtual 644	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   427: pop
    //   428: aload 7
    //   430: invokestatic 681	axd:a	(Ljava/util/HashMap;)V
    //   433: aload_0
    //   434: getfield 44	axd:b	Landroid/content/Context;
    //   437: aload 7
    //   439: invokestatic 683	axd:a	(Landroid/content/Context;Ljava/util/HashMap;)V
    //   442: aload 7
    //   444: invokevirtual 357	java/util/HashMap:values	()Ljava/util/Collection;
    //   447: aload 7
    //   449: invokevirtual 684	java/util/HashMap:size	()I
    //   452: anewarray 686	bdb
    //   455: invokeinterface 690 2 0
    //   460: checkcast 692	[Lbdb;
    //   463: astore 5
    //   465: aload 6
    //   467: ifnull +9 -> 476
    //   470: aload_0
    //   471: aload 6
    //   473: invokevirtual 679	axd:a	(Laxb;)V
    //   476: aload 5
    //   478: areturn
    //   479: astore 5
    //   481: aload 6
    //   483: invokevirtual 588	axb:c	()V
    //   486: aconst_null
    //   487: astore 6
    //   489: aload 5
    //   491: athrow
    //   492: astore 5
    //   494: goto -114 -> 380
    //   497: goto +8 -> 505
    //   500: iconst_0
    //   501: istore_1
    //   502: goto -258 -> 244
    //   505: goto -390 -> 115
    //   508: iconst_0
    //   509: istore 4
    //   511: goto -299 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	axd
    //   243	259	1	c	char
    //   217	59	2	m	int
    //   114	179	3	bool1	boolean
    //   210	300	4	bool2	boolean
    //   28	292	5	localObject1	Object
    //   357	16	5	localIOException	IOException
    //   378	39	5	localMailbox	Mailbox
    //   463	14	5	arrayOfbdb	bdb[]
    //   479	11	5	localbcs	bcs
    //   492	1	5	localObject2	Object
    //   4	484	6	localaxb	axb
    //   13	435	7	localHashMap	HashMap
    //   49	189	8	localObject3	Object
    //   155	106	9	localObject4	Object
    //   196	17	10	localaxr	axr
    // Exception table:
    //   from	to	target	type
    //   6	25	357	java/io/IOException
    //   30	98	357	java/io/IOException
    //   98	113	357	java/io/IOException
    //   115	209	357	java/io/IOException
    //   212	244	357	java/io/IOException
    //   244	273	357	java/io/IOException
    //   283	319	357	java/io/IOException
    //   324	357	357	java/io/IOException
    //   394	465	357	java/io/IOException
    //   6	25	378	finally
    //   30	98	378	finally
    //   98	113	378	finally
    //   115	209	378	finally
    //   212	244	378	finally
    //   244	273	378	finally
    //   283	319	378	finally
    //   324	357	378	finally
    //   359	378	378	finally
    //   394	465	378	finally
    //   481	486	378	finally
    //   6	25	479	bcs
    //   30	98	479	bcs
    //   98	113	479	bcs
    //   115	209	479	bcs
    //   212	244	479	bcs
    //   244	273	479	bcs
    //   283	319	479	bcs
    //   324	357	479	bcs
    //   394	465	479	bcs
    //   489	492	492	finally
  }
  
  public final Bundle c()
  {
    m = -1;
    localBundle = new Bundle();
    localaxb = new axb(this);
    try
    {
      localaxb.a();
      localaxb.b();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localBundle.putString("validate_error_message", localIOException.getMessage());
        m = 1;
        localaxb.c();
      }
    }
    finally
    {
      localaxb.c();
    }
    localBundle.putInt("validate_result_code", m);
    return localBundle;
  }
  
  public final void e()
  {
    for (;;)
    {
      axb localaxb = (axb)l.poll();
      if (localaxb == null) {
        break;
      }
      localaxb.b();
    }
  }
  
  final boolean f()
  {
    return (TextUtils.isEmpty(i)) && (!TextUtils.isEmpty(h));
  }
  
  final axb g()
  {
    for (;;)
    {
      axb localaxb2 = (axb)l.poll();
      if (localaxb2 != null) {}
      try
      {
        localaxb2.a(this);
        localaxb2.b("NOOP", false);
        axb localaxb1 = localaxb2;
        if (localaxb2 == null) {
          localaxb1 = new axb(this);
        }
        return localaxb1;
      }
      catch (bdi localbdi)
      {
        localaxb2.b();
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
}

/* Location:
 * Qualified Name:     axd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */