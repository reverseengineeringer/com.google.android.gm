import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.android.setupwizardlib.SetupWizardLayout;

public final class avy
  extends ats
  implements LoaderManager.LoaderCallbacks<Bundle>, awe
{
  private static final String c = cvl.a;
  atn a;
  public Bundle b;
  private WebView d;
  private bcb e;
  private String f;
  private String g;
  private Handler h = new avz(this);
  
  public static avy a(String paramString1, String paramString2)
  {
    avy localavy = new avy();
    Bundle localBundle = new Bundle(2);
    localBundle.putString("fallback_email_address", paramString1);
    localBundle.putString("provider", paramString2);
    localavy.setArguments(localBundle);
    return localavy;
  }
  
  public final cya a()
  {
    return l;
  }
  
  public final void a(String paramString)
  {
    f = paramString;
    Bundle localBundle = new Bundle();
    localBundle.putString("provider", e.a);
    localBundle.putString("authentication_code", paramString);
    getLoaderManager().initLoader(1, localBundle, this);
    b("get_authorized_code", e.a);
  }
  
  public final void b(String paramString1, String paramString2)
  {
    but localbut = buo.a();
    localbut.b(g);
    localbut.a("oauth", paramString1, paramString2, 0L);
  }
  
  public final bcb c()
  {
    return e;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getActivity();
    a = ((atn)getActivity());
    if (b == null)
    {
      CookieSyncManager.createInstance((Context)localObject);
      CookieManager.getInstance().removeAllCookie();
      d.getSettings().setSavePassword(false);
      d.clearFormData();
    }
    d.setWebViewClient(new awd(this));
    d.getSettings().setJavaScriptEnabled(true);
    String str = getArguments().getString("provider");
    e = awj.a((Context)localObject).c(str);
    localObject = awu.a(str).a(e, g).toString();
    d.loadUrl((String)localObject);
    if (paramBundle != null)
    {
      f = paramBundle.getString("authentication_code");
      if (f != null) {
        a(f);
      }
      if ((!((atu)getActivity()).a()) && (l != null)) {
        if (!(l instanceof SetupWizardLayout)) {
          break label236;
        }
      }
    }
    label236:
    for (paramBundle = ((SetupWizardLayout)l).getNavigationBar();; paramBundle = null)
    {
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      b("create_oauth_fragment", e.a);
      return;
      f = null;
      break;
    }
  }
  
  public final Loader<Bundle> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 1)
    {
      String str = paramBundle.getString("provider");
      paramBundle = paramBundle.getString("authentication_code");
      return new awc(getActivity(), str, paramBundle);
    }
    return null;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    g = getArguments().getString("fallback_email_address");
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.q, arh.ar, false);
    l.findViewById(are.aQ).setPadding(0, 0, 0, 0);
    b(8);
    d = ((WebView)paramLayoutInflater.findViewById(are.az));
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
  }
  
  public final void onLoaderReset(Loader<Bundle> paramLoader) {}
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("authentication_code", f);
  }
}

/* Location:
 * Qualified Name:     avy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */