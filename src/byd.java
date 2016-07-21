import android.app.LoaderManager;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.android.emailcommon.mail.Address;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class byd
  extends cjl
{
  public byd(byc parambyc)
  {
    super(null);
  }
  
  public final void onPageFinished(WebView paramWebView, String arg2)
  {
    if (!a.isAdded())
    {
      cvm.b(byc.a, "ignoring EMLVF.onPageFinished, url=%s fragment=%s", new Object[] { ???, a });
      return;
    }
    a.g.a(null);
    paramWebView = new HashSet();
    synchronized (a.l)
    {
      hef localhef = hef.a(a.l.values());
      ??? = localhef.iterator();
      if (???.hasNext()) {
        paramWebView.add(nexta);
      }
    }
    ??? = a.b();
    a = paramWebView;
    a.getLoaderManager().restartLoader(1, Bundle.EMPTY, ???);
  }
  
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    WebResourceResponse localWebResourceResponse = a(Uri.parse(paramString), a.f);
    if (localWebResourceResponse != null) {
      return localWebResourceResponse;
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}

/* Location:
 * Qualified Name:     byd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */