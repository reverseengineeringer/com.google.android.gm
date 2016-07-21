import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import com.android.setupwizardlib.SetupWizardLayout;
import com.google.android.gm.gmailify.GmailifyOptInActivity;

public final class dli
  extends djz
{
  static final String f = cvl.a;
  WebView g;
  private LoaderManager.LoaderCallbacks<String> h = new dlj(this);
  
  public dli()
  {
    super(dga.P, "4-pair_oauth");
  }
  
  public final SetupWizardLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    g = ((WebView)paramLayoutInflater.findViewById(dfy.bq));
    g.setWebViewClient(new dmd(paramLayoutInflater, this, getArguments().getString("domainWhitelist")));
    paramViewGroup = g.getSettings();
    paramViewGroup.setSaveFormData(false);
    paramViewGroup.setJavaScriptEnabled(true);
    paramViewGroup.setSupportZoom(true);
    paramViewGroup.setBlockNetworkImage(false);
    cxa.a(g, getActivity());
    if ((getActivity() instanceof GmailifyOptInActivity)) {
      g.addJavascriptInterface(new dlk(this), "AndroidGmail");
    }
    if (getResourcesgetConfigurationorientation == 2)
    {
      paramViewGroup = c;
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(8);
      }
    }
    for (;;)
    {
      getLoaderManager().initLoader(3, getArguments(), h);
      return paramLayoutInflater;
      d.setVisibility(4);
    }
  }
  
  final CharSequence a()
  {
    return getString(dge.de);
  }
  
  protected final int b()
  {
    return dga.I;
  }
  
  public final void c(String paramString)
  {
    if ((paramString != null) && ((getActivity() instanceof GmailifyOptInActivity))) {
      getActivityi = paramString;
    }
    i();
  }
  
  final String f()
  {
    return null;
  }
  
  final boolean g()
  {
    return false;
  }
  
  public final void k()
  {
    cvm.c(f, "Gmailify: OAuth denied", new Object[0]);
    a(dge.cX, new Object[0]);
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
  }
}

/* Location:
 * Qualified Name:     dli
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */