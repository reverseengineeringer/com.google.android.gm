import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.provider.Account;

public final class avi
  extends ats
{
  public final boolean h()
  {
    return true;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Activity localActivity = getActivity();
    paramBundle = getString(arh.G);
    if (localActivity != null) {
      paramBundle = lb.d;
    }
    paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.u, paramBundle, true);
    ((TextView)paramLayoutInflater.findViewById(are.aF)).setText(arh.H);
    i();
    b(4);
    return paramLayoutInflater;
  }
}

/* Location:
 * Qualified Name:     avi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */