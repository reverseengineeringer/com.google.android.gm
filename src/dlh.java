import android.app.Activity;
import android.app.LoaderManager;
import android.os.Bundle;
import com.google.android.gm.gmailify.GmailifyOptInActivity;

public final class dlh
  extends djz
{
  private static final String f = cvl.a;
  
  public dlh()
  {
    super(dga.K, "4a-pair_plain");
  }
  
  private final String l()
  {
    return getArguments().getString("gmail-address");
  }
  
  final CharSequence a()
  {
    return getString(dge.dg);
  }
  
  public final void c(String paramString)
  {
    cvm.b(f, "Gmailify: accounts paired successfully", new Object[0]);
    i();
  }
  
  public final String f()
  {
    return getString(dge.df, new Object[] { h(), l() });
  }
  
  public final void k()
  {
    cvm.c(f, "Gmailify: plain auth error", new Object[0]);
    a(dge.cY, new Object[0]);
  }
  
  public final void onResume()
  {
    super.onResume();
    dlf localdlf = new dlf(getActivity(), dkp.a(), this);
    Bundle localBundle = new Bundle(5);
    localBundle.putString("thirdPartyAddress", h());
    Activity localActivity = getActivity();
    if ((localActivity instanceof GmailifyOptInActivity))
    {
      localBundle.putString("thirdPartyPassword", c);
      localBundle.putString("gmailAddress", l());
      localBundle.putString("token", getArguments().getString("token"));
      localBundle.putLong("tokenTime", getArguments().getLong("tokenTime"));
      getLoaderManager().initLoader(2, localBundle, localdlf);
      return;
    }
    throw new ClassCastException("Cannot get the password if the parent activity is not GmailifyOptInActivity");
  }
}

/* Location:
 * Qualified Name:     dlh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */