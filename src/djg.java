import android.app.Activity;
import android.content.res.Resources;
import com.android.mail.ui.toastbar.ActionableToastBar;

public final class djg
{
  private final Resources a;
  private final ActionableToastBar b;
  
  public djg(Activity paramActivity)
  {
    a = paramActivity.getResources();
    b = ((ActionableToastBar)paramActivity.findViewById(dfy.cr));
  }
  
  public final void a(boolean paramBoolean, ctd paramctd)
  {
    String str;
    if (paramBoolean) {
      str = a.getString(dge.fp);
    }
    for (int i = dge.bZ;; i = 0)
    {
      b.a(paramctd, str, i, true, true, null);
      return;
      str = a.getString(dge.fo);
    }
  }
}

/* Location:
 * Qualified Name:     djg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */