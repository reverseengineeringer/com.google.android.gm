import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.people.accountswitcherview.ExpanderView;
import com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView;

public final class fti
  implements ftn
{
  public fti(SelectedAccountNavigationView paramSelectedAccountNavigationView) {}
  
  public final ftm a(View paramView)
  {
    ftm localftm = new ftm();
    e = paramView;
    f = paramView.findViewById(fsu.f);
    i = paramView.findViewById(fsu.g);
    o = ((ImageView)i);
    j = ((TextView)paramView.findViewById(fsu.b));
    k = ((TextView)paramView.findViewById(fsu.a));
    n = ((ImageView)paramView.findViewById(fsu.l));
    g = ((ExpanderView)paramView.findViewById(fsu.c));
    h = paramView.findViewById(fsu.d);
    d = paramView.findViewById(fsu.t);
    B = a.findViewById(fsu.e);
    if (a.o)
    {
      l = paramView.findViewById(fsu.h);
      p = ((ImageView)paramView.findViewById(fsu.i));
      m = paramView.findViewById(fsu.j);
      q = ((ImageView)paramView.findViewById(fsu.k));
      if ((p == null) && ((l instanceof ImageView))) {
        p = ((ImageView)l);
      }
      if ((q == null) && ((m instanceof ImageView))) {
        q = ((ImageView)m);
      }
      u = paramView.findViewById(fsu.q);
      y = ((ImageView)u);
      v = ((ImageView)paramView.findViewById(fsu.r));
      r = paramView.findViewById(fsu.s);
      s = ((TextView)paramView.findViewById(fsu.p));
      t = ((TextView)paramView.findViewById(fsu.o));
      w = paramView.findViewById(fsu.m);
      z = ((ImageView)w);
      x = paramView.findViewById(fsu.n);
      A = ((ImageView)x);
    }
    return localftm;
  }
}

/* Location:
 * Qualified Name:     fti
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */