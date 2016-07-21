import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.provider.Account;

public final class avh
  extends ats
  implements awi
{
  private String a;
  private TextView b;
  
  public static avh c(int paramInt)
  {
    avh localavh = new avh();
    Bundle localBundle = new Bundle(1);
    localBundle.putInt("CheckSettingsProgressFragment.Mode", paramInt);
    localavh.setArguments(localBundle);
    return localavh;
  }
  
  public final void a(String paramString)
  {
    a = paramString;
    if (b != null) {
      b.setText(a);
    }
  }
  
  public final boolean h()
  {
    return true;
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = getArguments().getInt("CheckSettingsProgressFragment.Mode");
    Object localObject;
    switch (i)
    {
    case 3: 
    default: 
      localObject = getActivity();
      if (localObject != null) {
        localObject = lb.d;
      }
      break;
    }
    for (;;)
    {
      paramLayoutInflater = a(paramLayoutInflater, paramViewGroup, arf.u, (String)localObject, true);
      b = ((TextView)paramLayoutInflater.findViewById(are.aF));
      if (paramBundle != null) {
        a(paramBundle.getString("CheckSettingsProgressFragment.Progress"));
      }
      if (a == null)
      {
        i = aro.a(i);
        a(aro.a(getActivity(), i));
      }
      i();
      b(4);
      return paramLayoutInflater;
      localObject = getString(arh.al);
      continue;
      localObject = getString(arh.aF);
      continue;
      localObject = getString(arh.q);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("CheckSettingsProgressFragment.Progress", a);
  }
}

/* Location:
 * Qualified Name:     avh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */