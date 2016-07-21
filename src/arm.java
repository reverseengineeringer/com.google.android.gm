import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class arm
  extends ats
{
  public boolean a;
  public boolean b;
  public boolean c;
  public String[] d;
  public String e;
  public mx f;
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String[] paramArrayOfString, String paramString)
  {
    Bundle localBundle = new Bundle(5);
    localBundle.putBoolean("supportsGoogleAccounts", paramBoolean1);
    localBundle.putBoolean("isSetupWizardFlow", paramBoolean2);
    localBundle.putBoolean("isFirstLanding", paramBoolean3);
    localBundle.putStringArray("tapAndGoEmails", paramArrayOfString);
    localBundle.putString("lastAddedEmail", paramString);
    return localBundle;
  }
  
  protected abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  protected abstract void a();
  
  protected abstract void a(View paramView, LayoutInflater paramLayoutInflater);
  
  public abstract void a(String paramString, int paramInt);
  
  protected abstract void b(View paramView, LayoutInflater paramLayoutInflater);
  
  public abstract void c();
  
  protected abstract void c_();
  
  protected final boolean d()
  {
    return bam.c(getActivity().getApplicationContext(), getString(arh.ck));
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f = mx.a();
    a = getArguments().getBoolean("supportsGoogleAccounts");
    b = getArguments().getBoolean("isSetupWizardFlow");
    c = getArguments().getBoolean("isFirstLanding");
    d = getArguments().getStringArray("tapAndGoEmails");
    e = getArguments().getString("lastAddedEmail");
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = a(paramLayoutInflater, paramViewGroup);
    if (b) {
      a(paramViewGroup, paramLayoutInflater);
    }
    for (;;)
    {
      c_();
      a(p, o);
      return paramViewGroup;
      b(paramViewGroup, paramLayoutInflater);
    }
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    c_();
  }
}

/* Location:
 * Qualified Name:     arm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */