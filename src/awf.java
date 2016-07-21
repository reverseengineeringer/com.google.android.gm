import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.setupwizardlib.SetupWizardLayout;

public class awf
  extends WebViewClient
{
  private static final String a = cvl.a;
  private final cya b;
  private final WebView c;
  private final FragmentManager d;
  
  public awf(cya paramcya, FragmentManager paramFragmentManager)
  {
    b = paramcya;
    c = ((WebView)paramcya.findViewById(are.az));
    d = paramFragmentManager;
  }
  
  private final void a(boolean paramBoolean)
  {
    if ((b instanceof cxq))
    {
      ((cxq)b).a(paramBoolean);
      return;
    }
    ((SetupWizardLayout)b).setProgressBarShown(paramBoolean);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    cvm.a(a, "OAuth: onPageFinished: %s", new Object[] { paramString });
    a(false);
    c.setVisibility(0);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    cvm.a(a, "OAuth: onPageStarted: %s", new Object[] { paramString });
    a(true);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    for (paramInt = arh.bS;; paramInt = arh.aY)
    {
      paramWebView = d.findFragmentByTag("connection-error-dialog");
      if (paramWebView != null) {
        ((DialogFragment)paramWebView).dismiss();
      }
      paramWebView = new awa();
      paramString1 = new Bundle(1);
      paramString1.putInt("title", paramInt);
      paramWebView.setArguments(paramString1);
      paramWebView.show(d, "connection-error-dialog");
      return;
    }
  }
}

/* Location:
 * Qualified Name:     awf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */