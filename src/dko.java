import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gm.gmailify.GmailifyOptInActivity;

public final class dko
  extends dki
  implements View.OnClickListener, cjr
{
  dkg i;
  
  protected final void a()
  {
    super.a();
    ((dkf)a).a(null);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = getActivityd;
    a = new dkf(getActivity(), b, paramViewGroup);
    if (i != null) {
      ((dkf)a).a(i);
    }
    return paramLayoutInflater;
  }
}

/* Location:
 * Qualified Name:     dko
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */