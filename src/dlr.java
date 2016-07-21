import android.app.LoaderManager;
import android.os.Bundle;
import android.view.View;
import com.android.setupwizardlib.SetupWizardLayout;
import com.google.android.gm.gmailify.GmailifyOptInActivity;
import com.google.android.gm.utils.WebViewUrl;

public final class dlr
  extends dka
  implements dlt
{
  private static final String f = cvl.a;
  
  public dlr()
  {
    super(dga.K, "3-start");
  }
  
  final CharSequence a()
  {
    return getString(dge.dm);
  }
  
  public final void a(String paramString, long paramLong, boolean paramBoolean)
  {
    cvm.b(f, "Gmailify: third-party address ready for Plain password flow", new Object[0]);
    ((SetupWizardLayout)getView()).hideProgressBar();
    Object localObject = getActivity();
    if ((localObject instanceof GmailifyOptInActivity))
    {
      localObject = (GmailifyOptInActivity)localObject;
      f = paramString;
      g = paramLong;
      h = paramBoolean;
    }
    i();
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    cvm.b(f, "Gmailify: third-party address ready for OAuth flow", new Object[0]);
    ((SetupWizardLayout)getView()).hideProgressBar();
    Object localObject = getActivity();
    if ((localObject instanceof GmailifyOptInActivity))
    {
      localObject = (GmailifyOptInActivity)localObject;
      e = new WebViewUrl(paramString1, true, paramString2);
      h = paramBoolean;
    }
    i();
  }
  
  public final void b(int paramInt)
  {
    cvm.d(f, "Cannot start Gmailify: error %d", new Object[] { Integer.valueOf(paramInt) });
    a(dge.cS, new Object[0]);
  }
  
  final String f()
  {
    return getString(dge.dl, new Object[] { h() });
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new Bundle(2);
    paramView.putString("thirdPartyEmail", h());
    paramView.putParcelable("gmailAccount", getArguments().getParcelable("gmail-account"));
    paramBundle = new dls(getActivity(), dkp.a(), this);
    getLoaderManager().initLoader(1, paramView, paramBundle);
  }
}

/* Location:
 * Qualified Name:     dlr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */