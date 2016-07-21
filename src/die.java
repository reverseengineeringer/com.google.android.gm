import android.app.Fragment;
import android.app.LoaderManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;

public final class die
  extends Fragment
{
  static final String a = cvl.a;
  String b;
  String c;
  String d;
  cmn e;
  private WebView f;
  private boolean g;
  private final dig h = new dig(this);
  private final Handler i = new Handler();
  
  public final WebView a()
  {
    if (g) {
      return f;
    }
    return null;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getArguments();
    b = paramBundle.getString("permalink");
    c = paramBundle.getString("account-name");
    d = paramBundle.getString("server-message-id");
    paramBundle = a();
    WebSettings localWebSettings = paramBundle.getSettings();
    localWebSettings.setSaveFormData(false);
    localWebSettings.setJavaScriptEnabled(false);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setDisplayZoomControls(false);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
    cxa.a(paramBundle, getActivity());
    paramBundle.setWebViewClient(new dif(this));
    if (b != null)
    {
      e.a(true, null);
      getLoaderManager().initLoader(0, null, h);
    }
    ((zh)getActivity()).f().a().d();
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (f != null) {
      f.destroy();
    }
    paramLayoutInflater = paramLayoutInflater.inflate(dga.z, paramViewGroup, false);
    f = ((WebView)paramLayoutInflater.findViewById(dfy.cv));
    g = true;
    e = new cmn(this, i);
    e.a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    if (f != null)
    {
      f.destroy();
      f = null;
    }
    super.onDestroy();
  }
  
  public final void onDestroyView()
  {
    g = false;
    super.onDestroyView();
  }
  
  public final void onStart()
  {
    super.onStart();
    f.onResume();
  }
  
  public final void onStop()
  {
    f.onPause();
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     die
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */