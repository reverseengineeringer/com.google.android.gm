import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLException;

public final class aye
{
  private static final String b = cvl.a;
  private static final Map<String, String> h = new hen().b("8BITMIME", "8bitmime").b("SIZE", "size").b("CHUNKING", "chunking").b("BINARYMIME", "binarymime").b("CHECKPOINT", "checkpoint").b("PIPELINING", "pipelining").b("STARTTLS", "starttls").b("BURL", "burl").b("UTF8SMTP", "utf8smtp").b("SMTPUTF8", "smtputf8").b("RRVS", "rrvs").b();
  public ayd a;
  private final Context c;
  private final Account d;
  private final String e;
  private final String f;
  private boolean g;
  
  public aye(Context paramContext, Account paramAccount)
  {
    c = paramContext;
    d = paramAccount;
    paramAccount = paramAccount.c(paramContext);
    a = new ayd(paramContext, "SMTP", paramAccount);
    String[] arrayOfString = paramAccount.j();
    e = arrayOfString[0];
    f = arrayOfString[1];
    if (paramAccount.a(paramContext) != null) {
      g = true;
    }
  }
  
  private final ayf a(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      a.a(paramString1, paramString2);
    }
    paramString1 = a.a(true);
    if (paramString1.length() < 3) {
      throw new bdi(27, "Invalid SMTP response", new Throwable());
    }
    paramString2 = new ArrayList(1);
    paramString2.add(paramString1);
    while ((paramString1.length() >= 4) && (paramString1.charAt(3) == '-'))
    {
      paramString1 = a.a(true);
      paramString2.add(paramString1);
    }
    paramString1 = ayf.a(paramString2);
    int i = a;
    if ((i >= 530) && (i <= 539))
    {
      cvm.a(b, "SMTP command failed with auth failure %d", new Object[] { Integer.valueOf(i) });
      if (g) {}
      for (i = 24;; i = 5) {
        throw new bcs(i, paramString1.toString());
      }
    }
    if ((i >= 400) && (i <= 499))
    {
      cvm.a(b, "SMTP command temporarily failed with code %d", new Object[] { Integer.valueOf(i) });
      throw new bdi(19, paramString1.toString());
    }
    if ((i >= 500) && (i <= 599))
    {
      cvm.a(b, "SMTP command permanently failed with code %d", new Object[] { Integer.valueOf(i) });
      throw new bdi(20, paramString1.toString());
    }
    return paramString1;
  }
  
  private final void a(long paramLong, boolean paramBoolean)
  {
    int j = 0;
    beb localbeb = beb.a(c, paramLong);
    if (localbeb == null) {
      throw new bdi(28, 59 + "Trying to send non-existent message id=" + paramLong);
    }
    if ((!paramBoolean) && (ak > System.currentTimeMillis())) {
      throw new bdi(-1);
    }
    a.f();
    a();
    Object localObject3 = Address.f(X);
    Object localObject2 = Address.h(Y);
    Object localObject1 = Address.h(Z);
    Address[] arrayOfAddress = Address.h(aa);
    try
    {
      String str = String.valueOf("MAIL FROM:<");
      localObject3 = String.valueOf(a);
      str = String.valueOf(str).length() + 1 + String.valueOf(localObject3).length() + str + (String)localObject3 + ">";
      a(str, str);
      int k = localObject2.length;
      int i = 0;
      while (i < k)
      {
        localObject3 = localObject2[i];
        str = String.valueOf("RCPT TO:<");
        localObject3 = String.valueOf(a.trim());
        str = String.valueOf(str).length() + 1 + String.valueOf(localObject3).length() + str + (String)localObject3 + ">";
        a(str, str);
        i += 1;
      }
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        str = localObject1[i];
        localObject2 = String.valueOf("RCPT TO:<");
        str = String.valueOf(a.trim());
        localObject2 = String.valueOf(localObject2).length() + 1 + String.valueOf(str).length() + (String)localObject2 + str + ">";
        a((String)localObject2, (String)localObject2);
        i += 1;
      }
      k = arrayOfAddress.length;
      i = j;
      while (i < k)
      {
        localObject2 = arrayOfAddress[i];
        localObject1 = String.valueOf("RCPT TO:<");
        localObject2 = String.valueOf(a.trim());
        localObject1 = String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length() + (String)localObject1 + (String)localObject2 + ">";
        a((String)localObject1, (String)localObject1);
        i += 1;
      }
      a("DATA", "DATA");
      bcp.a(c, localbeb, new bgx(a.d), false, false, null);
      a("\r\n.", "\r\n.");
      a(d.d, "success", Long.toString(aj));
      return;
    }
    catch (IOException localIOException)
    {
      throw new bdi(1, "Unable to send message", localIOException);
    }
  }
  
  private static void a(ayf paramayf)
  {
    but localbut = buo.a();
    if (!localbut.a("smtp_capabilities", 20)) {
      return;
    }
    Object localObject1 = h.keySet().iterator();
    boolean bool;
    String str1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!TextUtils.isEmpty(paramayf.a((String)localObject2))) {}
      for (bool = true;; bool = false)
      {
        str1 = Boolean.toString(bool);
        localbut.a("smtp_capabilities", (String)h.get(localObject2), str1, 0L);
        cvm.a(cvm.a, "Server supports capability %s: %s", new Object[] { localObject2, str1 });
        break;
      }
    }
    paramayf = paramayf.a("AUTH");
    localObject1 = new StringBuilder();
    Object localObject2 = axm.a;
    int j = localObject2.length;
    int i = 0;
    if (i < j)
    {
      str1 = localObject2[i];
      if ((paramayf != null) && (paramayf.contains(str1))) {}
      for (bool = true;; bool = false)
      {
        String str2 = Boolean.toString(bool);
        ((StringBuilder)localObject1).append(String.format(Locale.US, "%s=%s ", new Object[] { str1, str2 }));
        i += 1;
        break;
      }
    }
    paramayf = ((StringBuilder)localObject1).toString();
    cvm.a(cvm.a, "Server supports auth types: %s", new Object[] { paramayf });
    localbut.a(12, paramayf);
    localbut.a("smtp_capabilities", "auth", null, 0L);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    but localbut = buo.a();
    localbut.b(paramString1);
    localbut.a("smtp_send", paramString2, paramString3, 0L);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    a(paramString1, paramString2, String.valueOf(paramInt));
    paramString1 = cui.c(cui.b(paramString1));
    paramString1 = String.format(Locale.US, "%s://%s (%s)", new Object[] { paramString4, paramString1, paramString2 });
    buo.a().a("smtp_error", paramString1, paramString3, 0L);
  }
  
  private final String b()
  {
    if (a == null) {
      return "";
    }
    switch (a.e)
    {
    default: 
      return "unknown";
    case 0: 
      return "smtp";
    case 1: 
      return "smtp+tls";
    }
    return "smtp+starttls";
  }
  
  private final void b(String paramString1, String paramString2)
  {
    paramString2 = Base64.encode((String.valueOf(paramString1).length() + 20 + String.valueOf(paramString2).length() + "user=" + paramString1 + "\001auth=Bearer " + paramString2 + "\001\001").getBytes(), 2);
    paramString1 = String.valueOf("AUTH XOAUTH2 ");
    paramString2 = String.valueOf(new String(paramString2));
    if (paramString2.length() != 0) {}
    for (paramString1 = paramString1.concat(paramString2);; paramString1 = new String(paramString1))
    {
      a(paramString1, "AUTH XOAUTH2 /redacted/");
      return;
    }
  }
  
  public final void a()
  {
    Object localObject7 = null;
    for (;;)
    {
      Object localObject4;
      Object localObject6;
      ContentValues localContentValues;
      String str;
      int i;
      int j;
      int k;
      try
      {
        a.c();
        a(null, null);
        Object localObject1 = a;
        long l;
        if (((ayd)localObject1).e())
        {
          localObject1 = b.getLocalAddress();
          if (localObject1 == null) {
            break label1145;
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append('[');
          if ((localObject1 instanceof Inet6Address)) {
            ((StringBuilder)localObject4).append("IPv6:");
          }
          ((StringBuilder)localObject4).append(((InetAddress)localObject1).getHostAddress());
          ((StringBuilder)localObject4).append(']');
          localObject1 = ((StringBuilder)localObject4).toString();
          localObject4 = String.valueOf("EHLO ");
          localObject6 = String.valueOf(localObject1);
          if (((String)localObject6).length() == 0) {
            continue;
          }
          localObject4 = ((String)localObject4).concat((String)localObject6);
          localObject6 = a((String)localObject4, (String)localObject4);
          if (!a.b()) {
            break label1142;
          }
          if (((ayf)localObject6).a("STARTTLS") == null) {
            break label616;
          }
          a("STARTTLS", "STARTTLS");
          a.d();
          localObject4 = String.valueOf("EHLO ");
          localObject1 = String.valueOf(localObject1);
          if (((String)localObject1).length() == 0) {
            break label602;
          }
          localObject1 = ((String)localObject4).concat((String)localObject1);
          localObject6 = a((String)localObject1, (String)localObject1);
          a((ayf)localObject6);
          localContentValues = new ContentValues();
          l = d.r;
          TextUtils.isEmpty(((ayf)localObject6).a("8BITMIME"));
          TextUtils.isEmpty(((ayf)localObject6).a("BINARYMIME"));
          if (l != d.r) {
            localContentValues.put("sendingCapabilities", Long.valueOf(d.r));
          }
          str = ((ayf)localObject6).a("SIZE");
          if (!TextUtils.isEmpty(str))
          {
            boolean bool = str.startsWith("SIZE");
            if (!bool) {}
          }
        }
        for (;;)
        {
          try
          {
            l = Long.parseLong(str.substring(5));
            localObject1 = Long.valueOf(l);
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException1)
          {
            Object localObject2;
            localObject3 = null;
            cvm.d(b, localIndexOutOfBoundsException1, "Cannot parse ehlo-line '%s'", new Object[] { str });
            continue;
            if ((localObject3 == null) && (d.q != 20971520L))
            {
              d.q = 20971520L;
              i = 1;
              continue;
              localObject3 = e;
              Object localObject5 = aws.a();
              localObject6 = ((aws)localObject5).a(c, d);
              try
              {
                b((String)localObject3, (String)localObject6);
                if ((localContentValues.keySet().size() <= 0) || (d.D < 0L)) {
                  return;
                }
                d.a(c, localContentValues);
                return;
              }
              catch (bcs localbcs)
              {
                b((String)localObject3, ((aws)localObject5).b(c, d));
                continue;
              }
              if ((e != null) && (e.length() > 0) && (f != null) && (f.length() > 0))
              {
                if (j != 0)
                {
                  localObject3 = e;
                  localObject5 = f;
                  localObject5 = Base64.encode((String.valueOf(localObject3).length() + 2 + String.valueOf(localObject5).length() + "\000" + (String)localObject3 + "\000" + (String)localObject5).getBytes(), 2);
                  localObject3 = String.valueOf("AUTH PLAIN ");
                  localObject5 = String.valueOf(new String((byte[])localObject5));
                  if (((String)localObject5).length() != 0)
                  {
                    localObject3 = ((String)localObject3).concat((String)localObject5);
                    a((String)localObject3, "AUTH PLAIN /redacted/");
                    continue;
                  }
                  localObject3 = new String((String)localObject3);
                  continue;
                }
                if (i != 0)
                {
                  localObject3 = e;
                  localObject5 = f;
                  a("AUTH LOGIN", "AUTH LOGIN");
                  a(Base64.encodeToString(((String)localObject3).getBytes(), 2), "/username redacted/");
                  a(Base64.encodeToString(((String)localObject5).getBytes(), 2), "/password redacted/");
                  continue;
                }
                cvm.e(b, "No valid authentication mechanism found.", new Object[0]);
                throw new bdi(3);
              }
              cvm.a(b, "Proceeding with unauthenticated SMTP connection", new Object[0]);
              continue;
            }
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            localObject3 = null;
            continue;
          }
          try
          {
            if (((Long)localObject1).longValue() != 0L) {
              continue;
            }
            localObject1 = Long.valueOf(-1L);
            if ((localObject1 == null) || (d.q == ((Long)localObject1).longValue())) {
              continue;
            }
            d.q = ((Long)localObject1).longValue();
            i = 1;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException2) {}catch (NumberFormatException localNumberFormatException2)
          {
            continue;
            i = 0;
            continue;
          }
        }
        if (i != 0) {
          localContentValues.put("maxAttachmentSize", (Long)localObject1);
        }
        localObject1 = ((ayf)localObject6).a("AUTH");
        if ((localObject1 == null) || (!((String)localObject1).contains("LOGIN"))) {
          break label1153;
        }
        i = 1;
        if ((localObject1 == null) || (!((String)localObject1).contains("PLAIN"))) {
          break label1158;
        }
        j = 1;
        if ((localObject1 == null) || (!((String)localObject1).contains("XOAUTH2"))) {
          break label1163;
        }
        k = 1;
        if (!g) {
          break label836;
        }
        if (k != 0) {
          break label738;
        }
        cvm.e(b, "OAuth requested, but not supported.", new Object[0]);
        throw new bdi(18);
      }
      catch (SSLException localSSLException)
      {
        cvm.d(b, localSSLException, "SSLException", new Object[0]);
        throw new bcw(localSSLException.getMessage(), localSSLException);
        localObject2 = null;
        continue;
        localObject4 = new String((String)localObject4);
        continue;
      }
      catch (IOException localIOException)
      {
        cvm.d(b, localIOException, "IOException", new Object[0]);
        throw new bdi(1, "SmtpSender.open", localIOException);
      }
      label602:
      Object localObject3 = new String((String)localObject4);
      continue;
      label616:
      cvm.d(b, "STARTTLS not supported but required", new Object[0]);
      throw new bdi(2);
      if (((Long)localObject3).longValue() < 0L)
      {
        cvm.d(b, "Max send size must be positive or zero, but was %d", new Object[] { localObject3 });
        localObject3 = localObject7;
      }
      else
      {
        label738:
        label836:
        label1142:
        continue;
        label1145:
        localObject3 = "localhost";
        continue;
        label1153:
        i = 0;
        continue;
        label1158:
        j = 0;
        continue;
        label1163:
        k = 0;
      }
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	aye:c	Landroid/content/Context;
    //   4: invokestatic 603	bbz:a	(Landroid/content/Context;)Lbbx;
    //   7: astore 14
    //   9: aload_0
    //   10: getfield 89	aye:c	Landroid/content/Context;
    //   13: aload_0
    //   14: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   17: getfield 570	com/android/emailcommon/provider/Account:D	J
    //   20: iconst_4
    //   21: invokestatic 608	com/android/emailcommon/provider/Mailbox:a	(Landroid/content/Context;JI)J
    //   24: lstore 6
    //   26: lload 6
    //   28: ldc2_w 511
    //   31: lcmp
    //   32: ifne +4 -> 36
    //   35: return
    //   36: aload_0
    //   37: getfield 89	aye:c	Landroid/content/Context;
    //   40: invokevirtual 614	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   43: astore 15
    //   45: aload 15
    //   47: getstatic 617	beb:a	Landroid/net/Uri;
    //   50: getstatic 620	beb:k	[Ljava/lang/String;
    //   53: ldc_w 622
    //   56: iconst_1
    //   57: anewarray 129	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: lload 6
    //   64: invokestatic 292	java/lang/Long:toString	(J)Ljava/lang/String;
    //   67: aastore
    //   68: aconst_null
    //   69: invokevirtual 628	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 13
    //   74: aconst_null
    //   75: astore 11
    //   77: aload 11
    //   79: astore 10
    //   81: aload 13
    //   83: invokeinterface 633 1 0
    //   88: istore_2
    //   89: iload_2
    //   90: ifgt +11 -> 101
    //   93: aload 13
    //   95: invokeinterface 636 1 0
    //   100: return
    //   101: aload 11
    //   103: astore 10
    //   105: aload_0
    //   106: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   109: aload_0
    //   110: getfield 89	aye:c	Landroid/content/Context;
    //   113: invokestatic 641	awr:a	(Lcom/android/emailcommon/provider/Account;Landroid/content/Context;)Lawr;
    //   116: pop
    //   117: aload 11
    //   119: astore 10
    //   121: invokestatic 643	awr:a	()Z
    //   124: pop
    //   125: aload 11
    //   127: astore 10
    //   129: aload_0
    //   130: getfield 89	aye:c	Landroid/content/Context;
    //   133: aload_0
    //   134: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   137: getfield 570	com/android/emailcommon/provider/Account:D	J
    //   140: iconst_5
    //   141: invokestatic 646	com/android/emailcommon/provider/Mailbox:b	(Landroid/content/Context;JI)Lcom/android/emailcommon/provider/Mailbox;
    //   144: astore 12
    //   146: aload 11
    //   148: astore 10
    //   150: new 483	android/content/ContentValues
    //   153: dup
    //   154: invokespecial 484	android/content/ContentValues:<init>	()V
    //   157: astore 16
    //   159: aload 11
    //   161: astore 10
    //   163: aload 16
    //   165: ldc_w 648
    //   168: aload 12
    //   170: getfield 649	com/android/emailcommon/provider/Mailbox:D	J
    //   173: invokestatic 492	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: invokevirtual 496	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   179: aload 11
    //   181: astore 10
    //   183: aload 16
    //   185: ldc_w 651
    //   188: iconst_0
    //   189: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: invokevirtual 654	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   195: aload 11
    //   197: astore 10
    //   199: aload 16
    //   201: ldc_w 656
    //   204: iconst_0
    //   205: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: invokevirtual 654	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   211: iconst_0
    //   212: istore_2
    //   213: aconst_null
    //   214: astore 10
    //   216: aload 13
    //   218: invokeinterface 659 1 0
    //   223: ifeq +751 -> 974
    //   226: aload 16
    //   228: ldc_w 661
    //   231: invokevirtual 664	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   234: aload 13
    //   236: iconst_0
    //   237: invokeinterface 668 2 0
    //   242: lstore 6
    //   244: aload_0
    //   245: lload 6
    //   247: iload_1
    //   248: invokespecial 670	aye:a	(JZ)V
    //   251: getstatic 672	beb:c	Landroid/net/Uri;
    //   254: lload 6
    //   256: invokestatic 678	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   259: astore 11
    //   261: aload_0
    //   262: getfield 89	aye:c	Landroid/content/Context;
    //   265: astore 12
    //   267: aload_0
    //   268: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   271: getfield 570	com/android/emailcommon/provider/Account:D	J
    //   274: lstore 8
    //   276: aload 12
    //   278: lload 6
    //   280: invokestatic 683	bgt:b	(Landroid/content/Context;J)V
    //   283: aload_0
    //   284: getfield 89	aye:c	Landroid/content/Context;
    //   287: lload 6
    //   289: invokestatic 201	beb:a	(Landroid/content/Context;J)Lbeb;
    //   292: astore 12
    //   294: aload 12
    //   296: getfield 686	beb:u	I
    //   299: iconst_2
    //   300: iand
    //   301: ifeq +19 -> 320
    //   304: aload_0
    //   305: getfield 89	aye:c	Landroid/content/Context;
    //   308: aload_0
    //   309: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   312: getfield 570	com/android/emailcommon/provider/Account:D	J
    //   315: lload 6
    //   317: invokestatic 689	bgt:b	(Landroid/content/Context;JJ)V
    //   320: aload 16
    //   322: ldc_w 661
    //   325: aload 12
    //   327: getfield 686	beb:u	I
    //   330: ldc_w 690
    //   333: iand
    //   334: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   337: invokevirtual 654	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   340: aload 15
    //   342: aload 11
    //   344: aload 16
    //   346: aconst_null
    //   347: aconst_null
    //   348: invokevirtual 694	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   351: pop
    //   352: iconst_0
    //   353: istore_2
    //   354: goto -138 -> 216
    //   357: astore 11
    //   359: aload 11
    //   361: getfield 696	bdi:d	I
    //   364: istore 4
    //   366: getstatic 27	aye:b	Ljava/lang/String;
    //   369: aload 11
    //   371: ldc_w 698
    //   374: iconst_2
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: iload 4
    //   382: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: aastore
    //   386: dup
    //   387: iconst_1
    //   388: lload 6
    //   390: invokestatic 492	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   393: aastore
    //   394: invokestatic 532	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   397: pop
    //   398: aload 11
    //   400: instanceof 181
    //   403: ifeq +60 -> 463
    //   406: aload 14
    //   408: ifnull +55 -> 463
    //   411: aload 11
    //   413: checkcast 181	bcs
    //   416: astore 11
    //   418: aload 14
    //   420: aload_0
    //   421: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   424: getfield 570	com/android/emailcommon/provider/Account:D	J
    //   427: iconst_0
    //   428: invokeinterface 701 4 0
    //   433: aload_0
    //   434: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   437: getfield 282	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   440: aload 11
    //   442: invokevirtual 703	bcs:a	()Ljava/lang/String;
    //   445: aload 11
    //   447: invokevirtual 704	bcs:getMessage	()Ljava/lang/String;
    //   450: iconst_0
    //   451: aload_0
    //   452: invokespecial 706	aye:b	()Ljava/lang/String;
    //   455: invokestatic 708	aye:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   458: iconst_1
    //   459: istore_2
    //   460: goto -244 -> 216
    //   463: aload 11
    //   465: instanceof 710
    //   468: ifeq +87 -> 555
    //   471: aload 14
    //   473: aload_0
    //   474: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   477: invokeinterface 713 2 0
    //   482: aload_0
    //   483: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   486: getfield 282	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   489: aload 11
    //   491: invokevirtual 714	bdi:a	()Ljava/lang/String;
    //   494: aload 11
    //   496: invokevirtual 715	bdi:getMessage	()Ljava/lang/String;
    //   499: iconst_0
    //   500: aload_0
    //   501: invokespecial 706	aye:b	()Ljava/lang/String;
    //   504: invokestatic 708	aye:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   507: goto -291 -> 216
    //   510: astore 11
    //   512: aload 11
    //   514: instanceof 181
    //   517: ifeq +491 -> 1008
    //   520: aload 14
    //   522: ifnull +486 -> 1008
    //   525: aload 14
    //   527: aload_0
    //   528: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   531: getfield 570	com/android/emailcommon/provider/Account:D	J
    //   534: iconst_0
    //   535: invokeinterface 701 4 0
    //   540: aload 13
    //   542: invokeinterface 636 1 0
    //   547: aload 10
    //   549: ifnull -514 -> 35
    //   552: aload 10
    //   554: athrow
    //   555: iload 4
    //   557: iconst_m1
    //   558: if_icmpeq +413 -> 971
    //   561: aload 11
    //   563: astore 10
    //   565: aload_0
    //   566: getfield 89	aye:c	Landroid/content/Context;
    //   569: lload 6
    //   571: invokestatic 201	beb:a	(Landroid/content/Context;J)Lbeb;
    //   574: astore 17
    //   576: iload 4
    //   578: bipush 19
    //   580: if_icmpeq +452 -> 1032
    //   583: iload 4
    //   585: iconst_1
    //   586: if_icmpne +287 -> 873
    //   589: goto +443 -> 1032
    //   592: aload 11
    //   594: astore 10
    //   596: aload 17
    //   598: getfield 287	beb:aj	I
    //   601: i2l
    //   602: ldc2_w 716
    //   605: lcmp
    //   606: ifge +200 -> 806
    //   609: aload 11
    //   611: astore 10
    //   613: getstatic 353	cvm:a	Ljava/lang/String;
    //   616: aload 11
    //   618: ldc_w 719
    //   621: iconst_0
    //   622: anewarray 4	java/lang/Object
    //   625: invokestatic 721	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   628: pop
    //   629: aload 11
    //   631: astore 10
    //   633: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   636: lstore 6
    //   638: aload 11
    //   640: astore 10
    //   642: ldc2_w 722
    //   645: aload 17
    //   647: getfield 287	beb:aj	I
    //   650: i2d
    //   651: invokestatic 729	java/lang/Math:pow	(DD)D
    //   654: d2l
    //   655: lstore 8
    //   657: aload 11
    //   659: astore 10
    //   661: aload_0
    //   662: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   665: getfield 282	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   668: aload 12
    //   670: aload 11
    //   672: invokevirtual 715	bdi:getMessage	()Ljava/lang/String;
    //   675: aload 17
    //   677: getfield 287	beb:aj	I
    //   680: aload_0
    //   681: invokespecial 706	aye:b	()Ljava/lang/String;
    //   684: invokestatic 708	aye:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   687: lload 6
    //   689: lload 8
    //   691: ldc2_w 730
    //   694: lmul
    //   695: ladd
    //   696: lstore 6
    //   698: aload 11
    //   700: astore 10
    //   702: aload 17
    //   704: getfield 287	beb:aj	I
    //   707: istore 5
    //   709: iload_1
    //   710: ifeq +256 -> 966
    //   713: iconst_0
    //   714: istore_3
    //   715: aload 11
    //   717: astore 10
    //   719: new 483	android/content/ContentValues
    //   722: dup
    //   723: iconst_2
    //   724: invokespecial 732	android/content/ContentValues:<init>	(I)V
    //   727: astore 12
    //   729: aload 11
    //   731: astore 10
    //   733: aload 12
    //   735: ldc_w 651
    //   738: iload_3
    //   739: iload 5
    //   741: iadd
    //   742: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   745: invokevirtual 654	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   748: aload 11
    //   750: astore 10
    //   752: aload 12
    //   754: ldc_w 656
    //   757: lload 6
    //   759: invokestatic 492	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   762: invokevirtual 496	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   765: aload 11
    //   767: astore 10
    //   769: aload_0
    //   770: getfield 89	aye:c	Landroid/content/Context;
    //   773: invokevirtual 614	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   776: aload 17
    //   778: invokevirtual 735	beb:g	()Landroid/net/Uri;
    //   781: aload 12
    //   783: aconst_null
    //   784: aconst_null
    //   785: invokevirtual 694	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   788: pop
    //   789: aload 11
    //   791: astore 10
    //   793: iload 4
    //   795: iconst_1
    //   796: if_icmpne +175 -> 971
    //   799: aload 11
    //   801: astore 10
    //   803: aload 11
    //   805: athrow
    //   806: aload 11
    //   808: astore 10
    //   810: getstatic 353	cvm:a	Ljava/lang/String;
    //   813: aload 11
    //   815: ldc_w 737
    //   818: iconst_0
    //   819: anewarray 4	java/lang/Object
    //   822: invokestatic 721	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   825: pop
    //   826: aload 11
    //   828: astore 10
    //   830: aload_0
    //   831: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   834: getfield 282	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   837: aload 12
    //   839: invokestatic 253	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   842: ldc_w 739
    //   845: invokevirtual 437	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   848: aload 11
    //   850: invokevirtual 715	bdi:getMessage	()Ljava/lang/String;
    //   853: aload 17
    //   855: getfield 287	beb:aj	I
    //   858: aload_0
    //   859: invokespecial 706	aye:b	()Ljava/lang/String;
    //   862: invokestatic 708	aye:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   865: ldc2_w 740
    //   868: lstore 6
    //   870: goto -172 -> 698
    //   873: iload 4
    //   875: bipush 20
    //   877: if_icmpne +62 -> 939
    //   880: aload 11
    //   882: astore 10
    //   884: getstatic 353	cvm:a	Ljava/lang/String;
    //   887: aload 11
    //   889: ldc_w 743
    //   892: iconst_0
    //   893: anewarray 4	java/lang/Object
    //   896: invokestatic 721	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   899: pop
    //   900: aload 11
    //   902: astore 10
    //   904: aload_0
    //   905: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   908: getfield 282	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   911: ldc_w 745
    //   914: aload 11
    //   916: invokevirtual 715	bdi:getMessage	()Ljava/lang/String;
    //   919: aload 17
    //   921: getfield 287	beb:aj	I
    //   924: aload_0
    //   925: invokespecial 706	aye:b	()Ljava/lang/String;
    //   928: invokestatic 708	aye:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   931: ldc2_w 740
    //   934: lstore 6
    //   936: goto -238 -> 698
    //   939: aload 11
    //   941: astore 10
    //   943: getstatic 353	cvm:a	Ljava/lang/String;
    //   946: aload 11
    //   948: ldc_w 747
    //   951: iconst_0
    //   952: anewarray 4	java/lang/Object
    //   955: invokestatic 721	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   958: pop
    //   959: aload 11
    //   961: astore 10
    //   963: goto -747 -> 216
    //   966: iconst_1
    //   967: istore_3
    //   968: goto -253 -> 715
    //   971: goto -755 -> 216
    //   974: aload 14
    //   976: ifnull +22 -> 998
    //   979: iload_2
    //   980: ifne +18 -> 998
    //   983: aload 14
    //   985: aload_0
    //   986: getfield 91	aye:d	Lcom/android/emailcommon/provider/Account;
    //   989: getfield 570	com/android/emailcommon/provider/Account:D	J
    //   992: iconst_0
    //   993: invokeinterface 749 4 0
    //   998: aload 13
    //   1000: invokeinterface 636 1 0
    //   1005: goto -458 -> 547
    //   1008: aload 11
    //   1010: getfield 696	bdi:d	I
    //   1013: iconst_1
    //   1014: if_icmpne -474 -> 540
    //   1017: aload 11
    //   1019: athrow
    //   1020: astore 10
    //   1022: aload 13
    //   1024: invokeinterface 636 1 0
    //   1029: aload 10
    //   1031: athrow
    //   1032: iload 4
    //   1034: iconst_1
    //   1035: if_icmpne +16 -> 1051
    //   1038: ldc_w 751
    //   1041: astore 12
    //   1043: goto -451 -> 592
    //   1046: astore 11
    //   1048: goto -536 -> 512
    //   1051: ldc_w 753
    //   1054: astore 12
    //   1056: goto -464 -> 592
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1059	0	this	aye
    //   0	1059	1	paramBoolean	boolean
    //   88	892	2	i	int
    //   714	254	3	j	int
    //   364	672	4	k	int
    //   707	35	5	m	int
    //   24	911	6	l1	long
    //   274	416	8	l2	long
    //   79	883	10	localObject1	Object
    //   1020	10	10	localObject2	Object
    //   75	268	11	localUri	android.net.Uri
    //   357	55	11	localbdi1	bdi
    //   416	79	11	localbcs	bcs
    //   510	508	11	localbdi2	bdi
    //   1046	1	11	localbdi3	bdi
    //   144	911	12	localObject3	Object
    //   72	951	13	localCursor	android.database.Cursor
    //   7	977	14	localbbx	bbx
    //   43	298	15	localContentResolver	android.content.ContentResolver
    //   157	188	16	localContentValues	ContentValues
    //   574	346	17	localbeb	beb
    // Exception table:
    //   from	to	target	type
    //   244	251	357	bdi
    //   216	244	510	bdi
    //   251	320	510	bdi
    //   320	352	510	bdi
    //   359	406	510	bdi
    //   411	458	510	bdi
    //   463	507	510	bdi
    //   983	998	510	bdi
    //   81	89	1020	finally
    //   105	117	1020	finally
    //   121	125	1020	finally
    //   129	146	1020	finally
    //   150	159	1020	finally
    //   163	179	1020	finally
    //   183	195	1020	finally
    //   199	211	1020	finally
    //   216	244	1020	finally
    //   244	251	1020	finally
    //   251	320	1020	finally
    //   320	352	1020	finally
    //   359	406	1020	finally
    //   411	458	1020	finally
    //   463	507	1020	finally
    //   512	520	1020	finally
    //   525	540	1020	finally
    //   565	576	1020	finally
    //   596	609	1020	finally
    //   613	629	1020	finally
    //   633	638	1020	finally
    //   642	657	1020	finally
    //   661	687	1020	finally
    //   702	709	1020	finally
    //   719	729	1020	finally
    //   733	748	1020	finally
    //   752	765	1020	finally
    //   769	789	1020	finally
    //   803	806	1020	finally
    //   810	826	1020	finally
    //   830	865	1020	finally
    //   884	900	1020	finally
    //   904	931	1020	finally
    //   943	959	1020	finally
    //   983	998	1020	finally
    //   1008	1020	1020	finally
    //   81	89	1046	bdi
    //   105	117	1046	bdi
    //   121	125	1046	bdi
    //   129	146	1046	bdi
    //   150	159	1046	bdi
    //   163	179	1046	bdi
    //   183	195	1046	bdi
    //   199	211	1046	bdi
    //   565	576	1046	bdi
    //   596	609	1046	bdi
    //   613	629	1046	bdi
    //   633	638	1046	bdi
    //   642	657	1046	bdi
    //   661	687	1046	bdi
    //   702	709	1046	bdi
    //   719	729	1046	bdi
    //   733	748	1046	bdi
    //   752	765	1046	bdi
    //   769	789	1046	bdi
    //   803	806	1046	bdi
    //   810	826	1046	bdi
    //   830	865	1046	bdi
    //   884	900	1046	bdi
    //   904	931	1046	bdi
    //   943	959	1046	bdi
  }
}

/* Location:
 * Qualified Name:     aye
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */