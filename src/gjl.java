import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.Iterator;

public class gjl
  extends WebViewClient
{
  private static final String a = gjl.class.getSimpleName();
  private static final hfd<String> b = new hfe().c("https://www.google.com/insights/consumersurveys/").c("https://www.google.com/maps/preview/log204").c("https://clients4.google.com/insights/consumersurveys/").c("https://csi.gstatic.com/").c("https://ssl.gstatic.com/").c("https://www.gstatic.com/").c("data:").a();
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
    if (!paramString.startsWith("data:"))
    {
      paramWebView = String.valueOf(paramString);
      if (paramWebView.length() != 0) {
        "loading resource: ".concat(paramWebView);
      }
    }
    else
    {
      return;
    }
    new String("loading resource: ");
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    Log.e(a, String.valueOf(paramString1).length() + 3 + String.valueOf(paramString2).length() + paramString1 + " : " + paramString2);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    hji localhji = b.a();
    String str;
    int j;
    do
    {
      if (!localhji.hasNext()) {
        break label220;
      }
      str = (String)localhji.next();
      if (paramString.equals(str)) {
        break;
      }
      hbe.a(str);
      hbe.a(paramString);
      j = Math.min(str.length(), paramString.length());
      i = 0;
      while ((i < j) && (str.charAt(i) == paramString.charAt(i))) {
        i += 1;
      }
      if (!hbw.a(str, i - 1))
      {
        j = i;
        if (!hbw.a(paramString, i - 1)) {}
      }
      else
      {
        j = i - 1;
      }
    } while (!str.subSequence(0, j).toString().equals(str));
    label220:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        return super.shouldInterceptRequest(paramWebView, paramString);
      }
      paramWebView = String.valueOf(paramString);
      if (paramWebView.length() != 0) {
        "Blocking resource: ".concat(paramWebView);
      }
      for (;;)
      {
        return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
        new String("Blocking resource: ");
      }
    }
  }
}

/* Location:
 * Qualified Name:     gjl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */