import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.android.setupwizardlib.SetupWizardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class dmd
  extends awf
{
  private static final String a = cvl.a;
  private final Fragment b;
  private final Matcher c;
  private final Matcher d;
  
  public dmd(SetupWizardLayout paramSetupWizardLayout, Fragment paramFragment, String paramString)
  {
    super(paramSetupWizardLayout, paramFragment.getFragmentManager());
    b = paramFragment;
    paramFragment = String.valueOf(paramString);
    if (paramFragment.length() != 0) {}
    for (paramFragment = "https://".concat(paramFragment);; paramFragment = new String("https://"))
    {
      c = Pattern.compile(paramFragment, 2).matcher("");
      d = Pattern.compile(ghz.a(paramSetupWizardLayout.getContext().getContentResolver(), "gmail_g6y_domain_whitelist", "mail\\.google\\.com|accounts\\.google(?:\\.com?)?\\.\\w{2,3}"), 2).matcher("");
      return;
    }
  }
  
  public final void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    String str = a;
    if (paramWebResourceResponse == null) {}
    for (int i = 0;; i = paramWebResourceResponse.getStatusCode())
    {
      cvm.d(str, "Gmailify: WebView HTTP %d", new Object[] { Integer.valueOf(i) });
      super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      if ((b instanceof dkv)) {
        ((dkv)b).a(dge.cS, new Object[0]);
      }
      return;
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    cvm.a(a, "Gmailify Loading %s", new Object[] { paramString });
    Uri localUri = Uri.parse(paramString);
    String str = localUri.getAuthority();
    d.reset(str);
    if (d.matches()) {
      return false;
    }
    c.reset(paramString);
    if (c.matches()) {
      return false;
    }
    if ((b.getActivity() instanceof dkd))
    {
      paramString = (dkd)b.getActivity();
      buo.a().a(paramString.a(), "open_browser", str, 0L);
      cvm.d(a, "Gmailify: Open %s in browser", new Object[] { str });
    }
    return dfh.a(paramWebView.getContext(), localUri, true);
  }
}

/* Location:
 * Qualified Name:     dmd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */