import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.android.mail.providers.Folder;

public final class csm
  extends csr
{
  private final cfm d;
  private boolean e;
  
  public csm(Context paramContext)
  {
    super(paramContext);
    d = cfm.a(paramContext);
    a(getResources().getString(buj.cT));
  }
  
  private final boolean u()
  {
    if ((!d.e()) && (!c.isEmpty()))
    {
      if (d.d.getInt("long-press-to-select-tip-shown", 0) > 0) {}
      for (int i = 1; i == 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    e = u();
  }
  
  public final void g()
  {
    if (e) {
      i();
    }
  }
  
  public final void i()
  {
    if (e)
    {
      Object localObject = d;
      e.putInt("long-press-to-select-tip-shown", 1).apply();
      localObject = b;
      Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
      localIntent.setPackage(((Context)localObject).getPackageName());
      ((Context)localObject).startService(localIntent);
      e = false;
      buo.a().a("list_swipe", "long_press_tip", null, 0L);
    }
    super.i();
  }
  
  public final boolean n()
  {
    e = u();
    return e;
  }
  
  public final boolean o()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     csm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */