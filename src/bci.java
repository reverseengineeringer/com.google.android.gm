import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bci
  extends bcv
{
  private static final Pattern d = Pattern.compile("^<?([^>]+)>?$");
  private static final Pattern e = Pattern.compile("\r?\n");
  public bcj a = new bcj();
  public bcu b;
  public int c;
  
  public bci()
  {
    this((byte)0);
  }
  
  private bci(byte paramByte)
  {
    this(null, null);
  }
  
  public bci(bcu parambcu, String paramString)
  {
    if (paramString != null) {
      b("Content-Type", paramString);
    }
    a(parambcu);
  }
  
  private final String c(String paramString)
  {
    return a.a(paramString);
  }
  
  public final bcu a()
  {
    return b;
  }
  
  public final void a(bcu parambcu)
  {
    b = parambcu;
    if ((parambcu instanceof bdj))
    {
      parambcu = (bdj)parambcu;
      e = this;
      b("Content-Type", parambcu.a());
    }
    while (!(parambcu instanceof bcq)) {
      return;
    }
    String str1 = String.format("%s;\n charset=utf-8", new Object[] { e() });
    String str2 = bco.a(b(), "name");
    parambcu = str1;
    if (str2 != null)
    {
      parambcu = String.valueOf(str1);
      str1 = String.valueOf(String.format(";\n name=\"%s\"", new Object[] { str2 }));
      if (str1.length() == 0) {
        break label124;
      }
    }
    label124:
    for (parambcu = parambcu.concat(str1);; parambcu = new String(parambcu))
    {
      b("Content-Type", parambcu);
      b("Content-Transfer-Encoding", "base64");
      return;
    }
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(paramOutputStream), 1024);
    a.a(paramOutputStream);
    localBufferedWriter.write("\r\n");
    localBufferedWriter.flush();
    if (b != null) {
      b.a(paramOutputStream);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a.a(paramString1, paramString2);
  }
  
  public final String[] a(String paramString)
  {
    return a.b(paramString);
  }
  
  public final String b()
  {
    String str2 = c("Content-Type");
    String str1 = str2;
    if (str2 == null) {
      str1 = "text/plain";
    }
    return str1;
  }
  
  public final void b(String paramString1, String paramString2)
  {
    a.b(paramString1, paramString2);
  }
  
  public final boolean b(String paramString)
  {
    return e().equals(paramString);
  }
  
  public final String c()
  {
    String str2 = c("Content-Disposition");
    String str1 = str2;
    if (str2 == null) {
      str1 = null;
    }
    return str1;
  }
  
  public final String d()
  {
    String str = c("Content-ID");
    if (str == null) {
      return null;
    }
    return d.matcher(str).replaceAll("$1");
  }
  
  public final String e()
  {
    return bco.a(b(), null);
  }
  
  public final int f()
  {
    return c;
  }
}

/* Location:
 * Qualified Name:     bci
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */