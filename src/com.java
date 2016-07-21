import android.content.Context;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class com
  extends cjm
{
  public static final int a = 1;
  public static String f;
  private static final String g = cvl.a;
  private static final Pattern h = Pattern.compile("(<\\s*img\\s+(?:[^>]*\\s+)?)src(\\s*=[\\s'\"]*http)", 10);
  private static boolean i;
  private static String j;
  private static String k;
  private static String l;
  private boolean m = false;
  private StringBuilder n;
  private String o;
  private int p;
  private int q;
  private int r;
  private int s;
  
  public com(Context paramContext)
  {
    super(paramContext);
    if (!i)
    {
      i = true;
      f = a(bui.j);
      j = a(bui.e);
      k = a(bui.c);
      l = a(bui.b);
    }
  }
  
  public static String a(con paramcon)
  {
    String str = String.valueOf("m");
    long l1 = paramcon.o();
    return String.valueOf(str).length() + 20 + str + l1;
  }
  
  public static String a(String paramString)
  {
    return paramString.substring(a);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (cxd.a())
    {
      localObject = new StringBuilder("<div style=\"display: table; width: 100%;\">");
      if (paramBoolean) {
        ((StringBuilder)localObject).append("<div class=\"mail-message-toggle mail-elided-text\" dir=\"auto\"></div><div style=\"display: none;\">");
      }
      ((StringBuilder)localObject).append(paramString);
      if (paramBoolean) {
        ((StringBuilder)localObject).append("</div>");
      }
      localObject = "</div>";
    }
    do
    {
      return (String)localObject;
      localObject = paramString;
    } while (!paramBoolean);
    return "<div class=\"mail-message-toggle mail-elided-text\" dir=\"auto\"></div><div style=\"display: none;\">" + paramString + "</div>";
  }
  
  public final String a()
  {
    return super.a();
  }
  
  public final String a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (!e) {
      throw new IllegalStateException("must call startConversation first");
    }
    if (paramBoolean1) {}
    for (String str = "initial-load";; str = "")
    {
      a(l, new Object[] { Integer.valueOf(paramInt1), str, TextUtils.htmlEncode(b.getString(buj.ch)), TextUtils.htmlEncode(b.getString(buj.eO)), TextUtils.htmlEncode(b.getString(buj.cx)), TextUtils.htmlEncode(b.getString(buj.cE)), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4), Boolean.valueOf(cxd.c()), TextUtils.htmlEncode(b.getString(buj.bX, new Object[] { b.getString(buj.p) })) });
      e = false;
      cvm.b(g, "rendered conversation of %d bytes, buffer capacity=%d", new Object[] { Integer.valueOf(d.length() << 1), Integer.valueOf(d.capacity() << 1) });
      return super.a();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (e) {
      throw new IllegalStateException("Should not call start conversation until end conversation has been called");
    }
    c();
    if (cxd.c()) {}
    for (String str = "img[blocked-src] { border: 1px solid #CCCCCC; }";; str = "")
    {
      a(k, new Object[] { Integer.valueOf(paramInt1), str, "", Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      e = true;
      return;
    }
  }
  
  public final void a(con paramcon, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    String str1;
    String str2;
    if (paramBoolean1)
    {
      str1 = "block";
      if (!paramBoolean1) {
        break label184;
      }
      str2 = "expanded";
      label16:
      if (!paramBoolean2) {
        break label191;
      }
    }
    label184:
    label191:
    for (String str3 = "mail-show-images";; str3 = "")
    {
      String str5 = paramcon.n();
      String str4 = str5;
      if (!paramBoolean2)
      {
        str4 = str5;
        if (paramcon.m()) {
          str4 = h.matcher(str5).replaceAll("$1src='blocked' blocked-src$2");
        }
      }
      str3 = str3 + ' ' + "";
      n.append("");
      a(j, new Object[] { a(paramcon), str2, Integer.valueOf(paramInt1), str3, str1, a(str4, paramcon.e()), str1, Integer.valueOf(paramInt2) });
      return;
      str1 = "none";
      break;
      str2 = "";
      break label16;
    }
  }
  
  public final void b()
  {
    super.b();
    n = null;
    o = null;
    p = 0;
    q = 0;
    r = 0;
    s = 0;
  }
  
  public final void c()
  {
    super.c();
    m = false;
    n = new StringBuilder(32768);
    o = null;
    p = 0;
    q = 0;
    r = 0;
    s = 0;
  }
}

/* Location:
 * Qualified Name:     com
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */