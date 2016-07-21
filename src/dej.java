import android.app.Activity;
import android.app.Fragment;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.widget.LinearLayout;

public abstract class dej<T>
  extends Fragment
{
  public deo<T> a;
  public eiz b;
  public DataSetObserver c;
  public LinearLayout d;
  private final del e = new del(this);
  
  public abstract void a();
  
  public abstract ejl<frc> b();
  
  public final void c()
  {
    if ((b.e()) && (a != null))
    {
      frb localfrb = new frb();
      b = false;
      frm.e.a(b, localfrb).a(b());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b = dekgetActivity"state-resolving-people-error"getSimpleNamef;
  }
  
  public void onPause()
  {
    try
    {
      getActivity().unregisterReceiver(e);
      super.onPause();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public void onResume()
  {
    super.onResume();
    getActivity().registerReceiver(e, e.a);
  }
  
  public void onStart()
  {
    super.onStart();
    if ((a != null) && (c != null)) {
      a.registerDataSetObserver(c);
    }
    if ((b != null) && (!b.e()) && (!b.f())) {
      b.b();
    }
  }
  
  public void onStop()
  {
    if ((b != null) && ((b.e()) || (b.f()))) {
      b.d();
    }
    if ((a != null) && (c != null)) {
      a.unregisterDataSetObserver(c);
    }
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     dej
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */