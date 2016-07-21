import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class ff
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  int a = 0;
  int b = 0;
  boolean c = true;
  public boolean d = true;
  int e = -1;
  Dialog f;
  boolean g;
  boolean h;
  boolean i;
  
  public final void a()
  {
    super.a();
    if ((!i) && (!h)) {
      h = true;
    }
  }
  
  public final void a(Activity paramActivity)
  {
    super.a(paramActivity);
    if (!i) {
      h = false;
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (G == 0) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      if (paramBundle != null)
      {
        a = paramBundle.getInt("android:style", 0);
        b = paramBundle.getInt("android:theme", 0);
        c = paramBundle.getBoolean("android:cancelable", true);
        d = paramBundle.getBoolean("android:showsDialog", d);
        e = paramBundle.getInt("android:backStackId", -1);
      }
      return;
    }
  }
  
  public void a(fq paramfq, String paramString)
  {
    h = false;
    i = true;
    paramfq = paramfq.a();
    paramfq.a(this, paramString);
    paramfq.b();
  }
  
  public Dialog b()
  {
    return new Dialog(f(), b);
  }
  
  public final LayoutInflater b(Bundle paramBundle)
  {
    if (!d) {
      return super.b(paramBundle);
    }
    f = b();
    if (f != null)
    {
      paramBundle = f;
      switch (a)
      {
      }
      for (;;)
      {
        return (LayoutInflater)f.getContext().getSystemService("layout_inflater");
        paramBundle.getWindow().addFlags(24);
        paramBundle.requestWindowFeature(1);
      }
    }
    return (LayoutInflater)C.c.getSystemService("layout_inflater");
  }
  
  public final void c(Bundle paramBundle)
  {
    super.c(paramBundle);
    if (!d) {}
    do
    {
      do
      {
        return;
        View localView = R;
        if (localView != null)
        {
          if (localView.getParent() != null) {
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
          }
          f.setContentView(localView);
        }
        f.setOwnerActivity(f());
        f.setCancelable(c);
        f.setOnCancelListener(this);
        f.setOnDismissListener(this);
      } while (paramBundle == null);
      paramBundle = paramBundle.getBundle("android:savedDialogState");
    } while (paramBundle == null);
    f.onRestoreInstanceState(paramBundle);
  }
  
  public final void d()
  {
    super.d();
    if (f != null) {
      f.hide();
    }
  }
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (f != null)
    {
      Bundle localBundle = f.onSaveInstanceState();
      if (localBundle != null) {
        paramBundle.putBundle("android:savedDialogState", localBundle);
      }
    }
    if (a != 0) {
      paramBundle.putInt("android:style", a);
    }
    if (b != 0) {
      paramBundle.putInt("android:theme", b);
    }
    if (!c) {
      paramBundle.putBoolean("android:cancelable", c);
    }
    if (!d) {
      paramBundle.putBoolean("android:showsDialog", d);
    }
    if (e != -1) {
      paramBundle.putInt("android:backStackId", e);
    }
  }
  
  public final void e()
  {
    super.e();
    if (f != null)
    {
      g = true;
      f.dismiss();
      f = null;
    }
  }
  
  public final void n_()
  {
    super.n_();
    if (f != null)
    {
      g = false;
      f.show();
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((!g) && (!h))
    {
      h = true;
      i = false;
      if (f != null)
      {
        f.dismiss();
        f = null;
      }
      g = true;
      if (e >= 0)
      {
        B.a(e);
        e = -1;
      }
    }
    else
    {
      return;
    }
    paramDialogInterface = B.a();
    paramDialogInterface.a(this);
    paramDialogInterface.c();
  }
}

/* Location:
 * Qualified Name:     ff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */