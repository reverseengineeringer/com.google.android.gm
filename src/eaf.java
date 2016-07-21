import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gm.welcome.ChangeAddressActivity;
import java.util.Set;
import java.util.regex.Matcher;

public final class eaf
  extends WebViewClient
{
  public eaf(ChangeAddressActivity paramChangeAddressActivity) {}
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    a.i.setVisibility(8);
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    a.i.setVisibility(8);
    dri.e(ChangeAddressActivity.a, "Error #%1$d for %3$s: %2$s", new Object[] { Integer.valueOf(paramInt), paramString1, a.b });
    paramWebView = new Intent();
    paramWebView.putExtra("error", paramInt);
    a.setResult(2, paramWebView);
    a.finish();
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    dri.b(ChangeAddressActivity.a, "Loading URL %s", new Object[] { paramString });
    paramWebView = Uri.parse(paramString);
    paramString = ChangeAddressActivity.a(paramWebView);
    if (paramString.equals(a.e)) {
      a.a();
    }
    do
    {
      return true;
      if (!a.f.contains(paramString))
      {
        ChangeAddressActivity localChangeAddressActivity = a;
        h.reset(paramString);
        if (!h.matches()) {}
      }
      else
      {
        return false;
      }
    } while (paramString.startsWith("mailto"));
    paramWebView = new Intent("android.intent.action.VIEW", paramWebView);
    a.startActivity(paramWebView);
    return true;
  }
}

/* Location:
 * Qualified Name:     eaf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */