import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.setupwizardlib.SetupWizardLayout;

public abstract class dka
  extends dkv
  implements dld
{
  private static final String f = cvl.a;
  
  protected dka(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public SetupWizardLayout a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(dfy.aQ);
    if (paramViewGroup == null) {
      cvm.b(f, "R.id.gmailify_progress_text not found", new Object[0]);
    }
    for (;;)
    {
      paramLayoutInflater.showProgressBar();
      return paramLayoutInflater;
      paramViewGroup.setText(f());
    }
  }
  
  public final void a(Exception paramException)
  {
    cvm.e(f, paramException, "Gmailify", new Object[0]);
    a(dge.cT, new Object[0]);
  }
  
  abstract String f();
  
  boolean g()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     dka
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */