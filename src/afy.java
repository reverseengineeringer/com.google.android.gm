import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.support.v7.widget.ActivityChooserView;
import android.widget.FrameLayout;
import android.widget.ImageView;

public final class afy
  extends DataSetObserver
{
  public afy(ActivityChooserView paramActivityChooserView) {}
  
  public final void onChanged()
  {
    super.onChanged();
    ActivityChooserView localActivityChooserView = a;
    if (a.getCount() > 0)
    {
      d.setEnabled(true);
      int i = a.a.a();
      int j = a.a.c();
      if ((i != 1) && ((i <= 1) || (j <= 0))) {
        break label186;
      }
      f.setVisibility(0);
      Object localObject = a.a.b();
      PackageManager localPackageManager = localActivityChooserView.getContext().getPackageManager();
      g.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
      if (m != 0)
      {
        localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = localActivityChooserView.getContext().getString(m, new Object[] { localObject });
        f.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      if (f.getVisibility() != 0) {
        break label198;
      }
      b.setBackgroundDrawable(c);
      return;
      d.setEnabled(false);
      break;
      label186:
      f.setVisibility(8);
    }
    label198:
    b.setBackgroundDrawable(null);
  }
}

/* Location:
 * Qualified Name:     afy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */