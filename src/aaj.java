import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class aaj
{
  static int a = -1;
  public static boolean b = false;
  
  public static aaj a(Activity paramActivity, aai paramaai)
  {
    return a(paramActivity, paramActivity.getWindow(), paramaai);
  }
  
  static aaj a(Context paramContext, Window paramWindow, aai paramaai)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23) {
      return new aaq(paramContext, paramWindow, paramaai);
    }
    if (i >= 14) {
      return new aao(paramContext, paramWindow, paramaai);
    }
    if (i >= 11) {
      return new aan(paramContext, paramWindow, paramaai);
    }
    return new AppCompatDelegateImplV7(paramContext, paramWindow, paramaai);
  }
  
  public abstract acz a(ada paramada);
  
  public abstract View a(int paramInt);
  
  public abstract zc a();
  
  public abstract void a(Configuration paramConfiguration);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(Toolbar paramToolbar);
  
  public abstract void a(View paramView);
  
  public abstract void a(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void a(CharSequence paramCharSequence);
  
  public abstract MenuInflater b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(Bundle paramBundle);
  
  public abstract void b(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void c();
  
  public abstract boolean c(int paramInt);
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract zj h();
  
  public abstract void i();
  
  public abstract boolean j();
}

/* Location:
 * Qualified Name:     aaj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */