import android.net.Uri;
import android.webkit.WebView;

final class awd
  extends awf
{
  private static final String a = cvl.a;
  private awe b;
  
  awd(awe paramawe)
  {
    super(paramawe.a(), paramawe.getFragmentManager());
    b = paramawe;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool2 = false;
    paramWebView = Uri.parse(paramString);
    bcb localbcb = b.c();
    cvm.b(a, "provider.redirect=%s, url=%s", new Object[] { h, paramString });
    boolean bool1;
    if (paramString.startsWith(h))
    {
      paramString = paramWebView.getQueryParameter("error");
      if (paramString != null)
      {
        b.b("load_error", paramString);
        bool1 = true;
      }
    }
    do
    {
      do
      {
        return bool1;
        b.a(paramWebView.getQueryParameter("code"));
        break;
        bool1 = bool2;
      } while (m == null);
      paramWebView = paramWebView.getHost();
      bool1 = bool2;
    } while (paramWebView.matches(m));
    buo.a().a("oauth", "whitelist_blocked", paramWebView, 0L);
    return true;
  }
}

/* Location:
 * Qualified Name:     awd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */