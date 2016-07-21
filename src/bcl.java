import com.android.emailcommon.mail.Address;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bcl
  extends bdg
{
  private static final Random p = new Random();
  private static final SimpleDateFormat q = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
  private static final Pattern r = Pattern.compile("^<?([^>]+)>?$");
  private static final Pattern s = Pattern.compile("\r?\n");
  public Address[] a;
  public Address[] b;
  public int c;
  public boolean d = true;
  private bcj i;
  private Address[] j;
  private Address[] k;
  private Address[] l;
  private Date m;
  private bcu n;
  private boolean o = false;
  
  public bcl()
  {
    i = null;
  }
  
  public bcl(InputStream paramInputStream)
  {
    a(paramInputStream);
  }
  
  private final String e(String paramString)
  {
    return p().a(paramString);
  }
  
  private final bcj p()
  {
    if (i == null) {
      i = new bcj();
    }
    return i;
  }
  
  public final bcu a()
  {
    return n;
  }
  
  public final void a(int paramInt, Address[] paramArrayOfAddress)
  {
    if (paramInt == bdh.a)
    {
      if ((paramArrayOfAddress == null) || (paramArrayOfAddress.length == 0))
      {
        d("To");
        j = null;
        return;
      }
      b("To", bco.b(Address.b(paramArrayOfAddress), 4));
      j = paramArrayOfAddress;
      return;
    }
    if (paramInt == bdh.b)
    {
      if ((paramArrayOfAddress == null) || (paramArrayOfAddress.length == 0))
      {
        d("CC");
        k = null;
        return;
      }
      b("CC", bco.b(Address.b(paramArrayOfAddress), 4));
      k = paramArrayOfAddress;
      return;
    }
    if (paramInt == bdh.c)
    {
      if ((paramArrayOfAddress == null) || (paramArrayOfAddress.length == 0))
      {
        d("BCC");
        l = null;
        return;
      }
      b("BCC", bco.b(Address.b(paramArrayOfAddress), 5));
      l = paramArrayOfAddress;
      return;
    }
    throw new bdi(28, "Unrecognized recipient type.");
  }
  
  public final void a(bcu parambcu)
  {
    n = parambcu;
    if ((parambcu instanceof bdj))
    {
      parambcu = (bdj)parambcu;
      e = this;
      b("Content-Type", parambcu.a());
      b("MIME-Version", "1.0");
    }
    while (!(parambcu instanceof bcq)) {
      return;
    }
    b("Content-Type", String.format("%s;\n charset=utf-8", new Object[] { e() }));
    b("Content-Transfer-Encoding", "base64");
  }
  
  public void a(InputStream paramInputStream)
  {
    boolean bool = true;
    pa.clear();
    o = true;
    a = null;
    j = null;
    k = null;
    l = null;
    b = null;
    m = null;
    n = null;
    iea localiea = new iea();
    b = new bcm(this);
    a = new ieb(new idw(paramInputStream));
    localiea.a(a);
    if (!c) {}
    for (;;)
    {
      d = bool;
      return;
      bool = false;
    }
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(paramOutputStream), 1024);
    k();
    p().a(paramOutputStream);
    localBufferedWriter.write("\r\n");
    localBufferedWriter.flush();
    if (n != null) {
      n.a(paramOutputStream);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    p().a(paramString1, paramString2);
  }
  
  public final void a(Date paramDate)
  {
    b("Date", q.format(paramDate));
    m = paramDate;
  }
  
  public final Address[] a(int paramInt)
  {
    if (paramInt == bdh.a)
    {
      if (j == null) {
        j = Address.d(bco.a(e("To")));
      }
      return j;
    }
    if (paramInt == bdh.b)
    {
      if (k == null) {
        k = Address.d(bco.a(e("CC")));
      }
      return k;
    }
    if (paramInt == bdh.c)
    {
      if (l == null) {
        l = Address.d(bco.a(e("BCC")));
      }
      return l;
    }
    throw new bdi(28, "Unrecognized recipient type.");
  }
  
  public final String[] a(String paramString)
  {
    return p().b(paramString);
  }
  
  public final String b()
  {
    String str2 = e("Content-Type");
    String str1 = str2;
    if (str2 == null) {
      str1 = "text/plain";
    }
    return str1;
  }
  
  public final void b(String paramString1, String paramString2)
  {
    p().b(paramString1, paramString2);
  }
  
  public final String c()
  {
    return e("Content-Disposition");
  }
  
  public final void c(String paramString)
  {
    b("Message-ID", paramString);
  }
  
  public final String d()
  {
    String str = e("Content-ID");
    if (str == null) {
      return null;
    }
    return r.matcher(str).replaceAll("$1");
  }
  
  public final void d(String paramString)
  {
    p().c(paramString);
    if ("Message-ID".equalsIgnoreCase(paramString)) {
      o = true;
    }
  }
  
  public final String e()
  {
    return bco.a(b(), null);
  }
  
  public final int f()
  {
    return c;
  }
  
  public final Date g()
  {
    if (m == null) {}
    for (;;)
    {
      try
      {
        str1 = String.valueOf(bco.b(e("Date")));
        if (str1.length() == 0) {
          continue;
        }
        str1 = "Date: ".concat(str1);
        m = aa;
      }
      catch (Exception localException1)
      {
        String str1;
        cvm.a(cvm.a, "Message missing Date header", new Object[0]);
        continue;
        str2 = new String("Date: ");
        continue;
      }
      if (m == null) {}
      try
      {
        str1 = String.valueOf(bco.b(e("Delivery-date")));
        if (str1.length() == 0) {
          continue;
        }
        str1 = "Date: ".concat(str1);
        m = aa;
      }
      catch (Exception localException2)
      {
        String str2;
        cvm.a(cvm.a, "Message also missing Delivery-Date header", new Object[0]);
        continue;
      }
      return m;
      str1 = new String("Date: ");
    }
  }
  
  public final InputStream g_()
  {
    return null;
  }
  
  public final String h()
  {
    return bco.b(e("Subject"));
  }
  
  public final Address[] i()
  {
    if (a == null)
    {
      String str2 = bco.a(e("From"));
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (str2.length() != 0) {}
      }
      else
      {
        str1 = bco.a(e("Sender"));
      }
      a = Address.d(str1);
    }
    return a;
  }
  
  public final Address[] j()
  {
    if (b == null) {
      b = Address.d(bco.a(e("Reply-to")));
    }
    return b;
  }
  
  public final String k()
  {
    String str = e("Message-ID");
    Object localObject = str;
    if (str == null)
    {
      localObject = str;
      if (!o)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<");
        int i1 = 0;
        while (i1 < 24)
        {
          ((StringBuilder)localObject).append("0123456789abcdefghijklmnopqrstuv".charAt(p.nextInt() & 0x1F));
          i1 += 1;
        }
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(Long.toString(System.currentTimeMillis()));
        ((StringBuilder)localObject).append("@email.android.com>");
        localObject = ((StringBuilder)localObject).toString();
        b("Message-ID", (String)localObject);
      }
    }
    return (String)localObject;
  }
  
  public final String l()
  {
    return e("X-Android-Message-ID");
  }
  
  public final String m()
  {
    return e("In-Reply-To");
  }
  
  public final String n()
  {
    return e("References");
  }
}

/* Location:
 * Qualified Name:     bcl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */