import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.Attachment;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public final class aqt
{
  public static bdg a(Context paramContext, beb parambeb)
  {
    bcl localbcl = new bcl();
    Object localObject1;
    label91:
    boolean bool;
    label131:
    label241:
    bcn localbcn;
    if (o == null)
    {
      localObject1 = "";
      localbcl.b("Subject", bco.a((String)localObject1, 9));
      localObject1 = Address.h(X);
      if (localObject1.length > 0)
      {
        localObject1 = localObject1[0];
        if (localObject1 == null) {
          break label657;
        }
        localbcl.b("From", bco.b(((Address)localObject1).b(), 6));
        a = new Address[] { localObject1 };
      }
      localbcl.a(new Date(n));
      f = x;
      localObject1 = bda.a;
      if (r != 3) {
        break label666;
      }
      bool = true;
      localbcl.a((bda)localObject1, bool);
      localbcl.a(bda.b, p);
      localbcl.a(bda.d, s);
      localbcl.a(bdh.a, Address.h(Y));
      localbcl.a(bdh.b, Address.h(Z));
      localbcl.a(bdh.c, Address.h(aa));
      localObject1 = Address.h(ab);
      if ((localObject1 != null) && (localObject1.length != 0)) {
        break label671;
      }
      localbcl.d("Reply-to");
      b = null;
      g = new Date(y);
      localbcl.b("Message-ID", P);
      localbcl.b("Content-Type", "multipart/mixed");
      localbcn = new bcn();
      localbcn.a("mixed");
      localbcl.a(localbcn);
    }
    for (;;)
    {
      try
      {
        a(localbcn, "text/html", bds.d(paramContext, D));
      }
      catch (RuntimeException localRuntimeException1)
      {
        try
        {
          a(localbcn, "text/plain", bds.c(paramContext, D));
          parambeb = ContentUris.withAppendedId(Attachment.c, D);
          localObject2 = paramContext.getContentResolver().query(parambeb, Attachment.h, null, null, null);
          if (localObject2 != null)
          {
            try
            {
              if (!((Cursor)localObject2).moveToNext()) {
                continue;
              }
              localAttachment = new Attachment();
              localAttachment.a((Cursor)localObject2);
              try
              {
                if (t == null) {
                  continue;
                }
                parambeb = new ByteArrayInputStream(t);
                Object localObject3 = j;
                long l = k;
                localObject1 = l;
                String str3 = i;
                if (parambeb == null) {
                  continue;
                }
                localObject3 = new bci(new bct(parambeb), (String)localObject3);
                ((bci)localObject3).b("Content-Transfer-Encoding", "base64");
                if (TextUtils.isEmpty(str3)) {
                  break label913;
                }
                parambeb = String.valueOf(str3).length() + 12 + "filename=\"" + str3 + "\";";
                str3 = String.valueOf(Long.valueOf(l));
                ((bci)localObject3).b("Content-Disposition", String.valueOf(parambeb).length() + 18 + String.valueOf(str3).length() + "attachment;\n " + parambeb + "size=" + str3);
                if (localObject1 != null) {
                  ((bci)localObject3).b("Content-ID", (String)localObject1);
                }
                localbcn.a((bcv)localObject3);
              }
              catch (FileNotFoundException parambeb)
              {
                cvm.e(cvm.a, "File Not Found error on %s while upsyncing message", new Object[] { n });
              }
              continue;
            }
            finally
            {
              if (localObject2 != null) {
                ((Cursor)localObject2).close();
              }
            }
            localObject1 = o;
            break;
            label657:
            a = null;
            break label91;
            label666:
            bool = false;
            break label131;
            label671:
            localbcl.b("Reply-to", bco.b(Address.b((Address[])localObject1), 10));
            b = ((Address[])localObject1);
            break label241;
            localRuntimeException1 = localRuntimeException1;
            localObject2 = bbw.a;
            String str1 = String.valueOf(localRuntimeException1.toString());
            if (str1.length() != 0)
            {
              str1 = "Exception while reading html body ".concat(str1);
              cvm.b((String)localObject2, str1, new Object[0]);
              continue;
            }
            str1 = new String("Exception while reading html body ");
            continue;
          }
        }
        catch (RuntimeException localRuntimeException2)
        {
          Attachment localAttachment;
          Object localObject2 = bbw.a;
          String str2 = String.valueOf(localRuntimeException2.toString());
          if (str2.length() != 0)
          {
            str2 = "Exception while reading text body ".concat(str2);
            cvm.b((String)localObject2, str2, new Object[0]);
            continue;
          }
          str2 = new String("Exception while reading text body ");
          continue;
          str2 = n;
          parambeb = str2;
          if (TextUtils.isEmpty(str2)) {
            parambeb = localAttachment.d();
          }
          if (TextUtils.isEmpty(parambeb))
          {
            parambeb = null;
            continue;
          }
          parambeb = Uri.parse(parambeb);
          parambeb = paramContext.getContentResolver().openInputStream(parambeb);
          continue;
          cvm.e(cvm.a, "Could not open attachment file for upsync", new Object[0]);
          continue;
          if (localObject2 != null) {
            ((Cursor)localObject2).close();
          }
          return localbcl;
        }
      }
      label913:
      parambeb = "";
    }
  }
  
  private static Attachment a(bdn parambdn)
  {
    long l2 = 0L;
    Object localObject2 = bco.a(bco.b(parambdn.b()), "name");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = bco.a(bco.b(parambdn.c()), "filename");
    }
    localObject2 = parambdn.c();
    long l1 = l2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = bco.a((String)localObject2, "size");
      l1 = l2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    try
    {
      l1 = Long.parseLong((String)localObject2);
      localObject2 = parambdn.a("X-Android-Attachment-StoreData");
      if (localObject2 != null)
      {
        localObject2 = localObject2[0];
        Attachment localAttachment = new Attachment();
        j = bgt.a((String)localObject1, parambdn.e());
        i = ((String)localObject1);
        k = l1;
        l = parambdn.d();
        m = null;
        p = ((String)localObject2);
        q = "B";
        return localAttachment;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        cvm.b(cvm.a, localNumberFormatException, "Could not decode size \"%s\" from attachment part", new Object[] { Long.valueOf(0L) });
        l1 = l2;
        continue;
        Object localObject3 = null;
      }
    }
  }
  
  /* Error */
  private static void a(Context paramContext, beb parambeb, bdn parambdn)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aload_2
    //   4: invokestatic 394	aqt:a	(Lbdn;)Lcom/android/emailcommon/provider/Attachment;
    //   7: astore 13
    //   9: aload 13
    //   11: aload_1
    //   12: getfield 159	beb:D	J
    //   15: putfield 396	com/android/emailcommon/provider/Attachment:o	J
    //   18: aload 13
    //   20: aload_1
    //   21: getfield 399	beb:V	J
    //   24: putfield 402	com/android/emailcommon/provider/Attachment:u	J
    //   27: getstatic 176	com/android/emailcommon/provider/Attachment:c	Landroid/net/Uri;
    //   30: aload_1
    //   31: getfield 159	beb:D	J
    //   34: invokestatic 182	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   37: astore 12
    //   39: aload_0
    //   40: invokevirtual 188	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   43: aload 12
    //   45: getstatic 191	com/android/emailcommon/provider/Attachment:h	[Ljava/lang/String;
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: invokevirtual 197	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 12
    //   56: iconst_0
    //   57: istore 4
    //   59: iload 4
    //   61: istore_3
    //   62: aload 12
    //   64: invokeinterface 203 1 0
    //   69: ifeq +95 -> 164
    //   72: new 173	com/android/emailcommon/provider/Attachment
    //   75: dup
    //   76: invokespecial 204	com/android/emailcommon/provider/Attachment:<init>	()V
    //   79: astore 14
    //   81: aload 14
    //   83: aload 12
    //   85: invokevirtual 207	com/android/emailcommon/provider/Attachment:a	(Landroid/database/Cursor;)V
    //   88: aload 14
    //   90: getfield 228	com/android/emailcommon/provider/Attachment:i	Ljava/lang/String;
    //   93: aload 13
    //   95: getfield 228	com/android/emailcommon/provider/Attachment:i	Ljava/lang/String;
    //   98: invokestatic 406	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   101: ifeq -42 -> 59
    //   104: aload 14
    //   106: getfield 219	com/android/emailcommon/provider/Attachment:j	Ljava/lang/String;
    //   109: aload 13
    //   111: getfield 219	com/android/emailcommon/provider/Attachment:j	Ljava/lang/String;
    //   114: invokestatic 406	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   117: ifeq -58 -> 59
    //   120: aload 14
    //   122: getfield 225	com/android/emailcommon/provider/Attachment:l	Ljava/lang/String;
    //   125: aload 13
    //   127: getfield 225	com/android/emailcommon/provider/Attachment:l	Ljava/lang/String;
    //   130: invokestatic 406	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   133: ifeq -74 -> 59
    //   136: aload 14
    //   138: getfield 381	com/android/emailcommon/provider/Attachment:p	Ljava/lang/String;
    //   141: aload 13
    //   143: getfield 381	com/android/emailcommon/provider/Attachment:p	Ljava/lang/String;
    //   146: invokestatic 406	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   149: ifeq -90 -> 59
    //   152: aload 13
    //   154: aload 14
    //   156: getfield 407	com/android/emailcommon/provider/Attachment:D	J
    //   159: putfield 407	com/android/emailcommon/provider/Attachment:D	J
    //   162: iconst_1
    //   163: istore_3
    //   164: aload 12
    //   166: invokeinterface 308 1 0
    //   171: iload_3
    //   172: ifne +10 -> 182
    //   175: aload 13
    //   177: aload_0
    //   178: invokevirtual 410	com/android/emailcommon/provider/Attachment:h	(Landroid/content/Context;)Landroid/net/Uri;
    //   181: pop
    //   182: aload_1
    //   183: getfield 399	beb:V	J
    //   186: lstore 5
    //   188: aload_2
    //   189: invokeinterface 413 1 0
    //   194: ifnull +199 -> 393
    //   197: aload 13
    //   199: getfield 407	com/android/emailcommon/provider/Attachment:D	J
    //   202: lstore 7
    //   204: aload_0
    //   205: lload 5
    //   207: invokestatic 416	bgt:a	(Landroid/content/Context;J)Ljava/io/File;
    //   210: astore 12
    //   212: aload 12
    //   214: invokevirtual 421	java/io/File:isDirectory	()Z
    //   217: ifne +32 -> 249
    //   220: aload 12
    //   222: invokevirtual 424	java/io/File:mkdirs	()Z
    //   225: ifne +24 -> 249
    //   228: new 426	java/io/IOException
    //   231: dup
    //   232: ldc_w 428
    //   235: invokespecial 429	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   238: athrow
    //   239: astore_0
    //   240: aload 12
    //   242: invokeinterface 308 1 0
    //   247: aload_0
    //   248: athrow
    //   249: aload_0
    //   250: lload 5
    //   252: lload 7
    //   254: invokestatic 432	bgt:a	(Landroid/content/Context;JJ)Ljava/io/File;
    //   257: astore 12
    //   259: aload_2
    //   260: invokeinterface 413 1 0
    //   265: invokeinterface 438 1 0
    //   270: astore_2
    //   271: new 440	java/io/FileOutputStream
    //   274: dup
    //   275: aload 12
    //   277: invokespecial 443	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   280: astore 12
    //   282: aload_2
    //   283: aload 12
    //   285: invokestatic 448	idc:b	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   288: lstore 9
    //   290: aload_2
    //   291: ifnull +7 -> 298
    //   294: aload_2
    //   295: invokevirtual 451	java/io/InputStream:close	()V
    //   298: aload 12
    //   300: invokevirtual 452	java/io/FileOutputStream:close	()V
    //   303: lload 5
    //   305: lload 7
    //   307: invokestatic 455	bgt:a	(JJ)Landroid/net/Uri;
    //   310: invokevirtual 456	android/net/Uri:toString	()Ljava/lang/String;
    //   313: astore 11
    //   315: aload 13
    //   317: lload 9
    //   319: putfield 222	com/android/emailcommon/provider/Attachment:k	J
    //   322: aload 13
    //   324: aload 11
    //   326: putfield 379	com/android/emailcommon/provider/Attachment:m	Ljava/lang/String;
    //   329: new 458	android/content/ContentValues
    //   332: dup
    //   333: iconst_3
    //   334: invokespecial 459	android/content/ContentValues:<init>	(I)V
    //   337: astore_2
    //   338: aload_2
    //   339: ldc_w 361
    //   342: lload 9
    //   344: invokestatic 280	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   347: invokevirtual 463	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   350: aload_2
    //   351: ldc_w 465
    //   354: aload 11
    //   356: invokevirtual 467	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: aload_2
    //   360: ldc_w 469
    //   363: iconst_3
    //   364: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: invokevirtual 477	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   370: getstatic 479	com/android/emailcommon/provider/Attachment:a	Landroid/net/Uri;
    //   373: lload 7
    //   375: invokestatic 182	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   378: astore 11
    //   380: aload_0
    //   381: invokevirtual 188	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   384: aload 11
    //   386: aload_2
    //   387: aconst_null
    //   388: aconst_null
    //   389: invokevirtual 483	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   392: pop
    //   393: aload_1
    //   394: getfield 487	beb:aA	Ljava/util/ArrayList;
    //   397: ifnonnull +14 -> 411
    //   400: aload_1
    //   401: new 489	java/util/ArrayList
    //   404: dup
    //   405: invokespecial 490	java/util/ArrayList:<init>	()V
    //   408: putfield 487	beb:aA	Ljava/util/ArrayList;
    //   411: aload_1
    //   412: getfield 487	beb:aA	Ljava/util/ArrayList;
    //   415: aload 13
    //   417: invokevirtual 494	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   420: pop
    //   421: aload_1
    //   422: iconst_1
    //   423: putfield 496	beb:t	Z
    //   426: return
    //   427: astore_0
    //   428: aconst_null
    //   429: astore_1
    //   430: aload_1
    //   431: ifnull +7 -> 438
    //   434: aload_1
    //   435: invokevirtual 451	java/io/InputStream:close	()V
    //   438: aload 11
    //   440: ifnull +8 -> 448
    //   443: aload 11
    //   445: invokevirtual 452	java/io/FileOutputStream:close	()V
    //   448: aload_0
    //   449: athrow
    //   450: astore_0
    //   451: aload_2
    //   452: astore_1
    //   453: goto -23 -> 430
    //   456: astore_0
    //   457: aload 12
    //   459: astore 11
    //   461: aload_2
    //   462: astore_1
    //   463: goto -33 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	paramContext	Context
    //   0	466	1	parambeb	beb
    //   0	466	2	parambdn	bdn
    //   61	111	3	i	int
    //   57	3	4	j	int
    //   186	118	5	l1	long
    //   202	172	7	l2	long
    //   288	55	9	l3	long
    //   1	459	11	localObject1	Object
    //   37	421	12	localObject2	Object
    //   7	409	13	localAttachment1	Attachment
    //   79	76	14	localAttachment2	Attachment
    // Exception table:
    //   from	to	target	type
    //   62	162	239	finally
    //   259	271	427	finally
    //   271	282	450	finally
    //   282	290	456	finally
  }
  
  public static void a(Context paramContext, beb parambeb, ArrayList<bdn> paramArrayList)
  {
    aA = null;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a(paramContext, parambeb, (bdn)paramArrayList.next());
    }
  }
  
  private static void a(bcn parambcn, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    parambcn.a(new bci(new bcq(paramString2), paramString1));
  }
  
  public static boolean a(beb parambeb, bdg parambdg, long paramLong1, long paramLong2)
  {
    Address[] arrayOfAddress1 = parambdg.i();
    Address[] arrayOfAddress2 = parambdg.a(bdh.a);
    Address[] arrayOfAddress3 = parambdg.a(bdh.b);
    Address[] arrayOfAddress4 = parambdg.a(bdh.c);
    Address[] arrayOfAddress5 = parambdg.j();
    String str = parambdg.h();
    Date localDate = parambdg.g();
    Object localObject = g;
    if ((arrayOfAddress1 != null) && (arrayOfAddress1.length > 0)) {
      m = arrayOfAddress1[0].c();
    }
    if (localDate != null)
    {
      n = localDate.getTime();
      if (str != null) {
        o = str;
      }
      p = parambdg.b(bda.b);
      if (parambdg.b(bda.c)) {
        u |= 0x40000;
      }
      str = parambdg.m();
      if ((r != 1) && (r != 5))
      {
        if (!TextUtils.isEmpty(m)) {
          break label384;
        }
        r = 0;
      }
    }
    for (;;)
    {
      s = parambdg.b(bda.d);
      x = f;
      if (localObject != null) {
        y = ((Date)localObject).getTime();
      }
      localObject = parambdg.k();
      if (localObject != null) {
        P = ((String)localObject);
      }
      if (str != null)
      {
        cvm.b(cvm.a, "Threading: message%d receives inReplyTo", new Object[] { Long.valueOf(D) });
        R = str;
      }
      localObject = parambdg.n();
      if (localObject != null) {
        S = ((String)localObject);
      }
      Q = parambdg.l();
      U = paramLong2;
      V = paramLong1;
      if ((arrayOfAddress1 != null) && (arrayOfAddress1.length > 0)) {
        X = Address.a(arrayOfAddress1);
      }
      Y = Address.a(arrayOfAddress2);
      Z = Address.a(arrayOfAddress3);
      aa = Address.a(arrayOfAddress4);
      ab = Address.a(arrayOfAddress5);
      return true;
      if (localObject == null) {
        break;
      }
      cvm.d(bbw.a, "No sentDate, falling back to internalDate", new Object[0]);
      n = ((Date)localObject).getTime();
      break;
      label384:
      if (r == 6) {
        r = 1;
      } else {
        r = 2;
      }
    }
  }
  
  public static void b(Context paramContext, beb parambeb, ArrayList<bdn> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      bdn localbdn = (bdn)paramArrayList.next();
      String str1 = bco.a(bco.b(localbdn.c()), null);
      String str2 = localbdn.e();
      if ((!TextUtils.isEmpty(str1)) && (!bco.b(str2, "text/*"))) {
        a(paramContext, parambeb, localbdn);
      }
    }
  }
}

/* Location:
 * Qualified Name:     aqt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */