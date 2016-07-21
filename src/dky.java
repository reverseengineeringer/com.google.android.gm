import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.android.setupwizardlib.SetupWizardLayout;

public final class dky
  extends dkv
{
  WebView f;
  private LoaderManager.LoaderCallbacks<String> g = new dkz(this);
  
  public dky()
  {
    super(dga.c, "fix_error");
  }
  
  public final SetupWizardLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    f = ((WebView)paramLayoutInflater.findViewById(dfy.bq));
    f.setWebViewClient(new dmd(paramLayoutInflater, this, getArguments().getString("domainWhitelist")));
    paramViewGroup = f.getSettings();
    paramViewGroup.setSaveFormData(false);
    paramViewGroup.setJavaScriptEnabled(true);
    paramViewGroup.setSupportZoom(true);
    paramViewGroup.setBlockNetworkImage(false);
    cxa.a(f, getActivity());
    paramViewGroup = getActivity();
    paramBundle = getArguments().getString("thirdPartyEmail");
    f.addJavascriptInterface(new dla(paramViewGroup, paramBundle), "AndroidGmail");
    c.setVisibility(8);
    getLoaderManager().initLoader(3, getArguments(), g);
    return paramLayoutInflater;
  }
  
  final CharSequence a()
  {
    return getString(dge.dd);
  }
  
  protected final int b()
  {
    return dga.I;
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
  }
}

/* Location:
 * Qualified Name:     dky
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */