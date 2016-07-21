import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class aeh
  implements aej, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  static final int a = ach.m;
  final LayoutInflater b;
  final adu c;
  final boolean d;
  public View e;
  public ajn f;
  public aek g;
  public boolean h;
  public int i = 0;
  private final Context j;
  private final aei k;
  private final int l;
  private final int m;
  private final int n;
  private ViewTreeObserver o;
  private ViewGroup p;
  private boolean q;
  private int r;
  
  public aeh(Context paramContext, adu paramadu, View paramView)
  {
    this(paramContext, paramadu, paramView, false, aca.H);
  }
  
  public aeh(Context paramContext, adu paramadu, View paramView, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramadu, paramView, paramBoolean, paramInt, 0);
  }
  
  public aeh(Context paramContext, adu paramadu, View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    j = paramContext;
    b = LayoutInflater.from(paramContext);
    c = paramadu;
    k = new aei(this, c);
    d = paramBoolean;
    m = paramInt1;
    n = 0;
    Resources localResources = paramContext.getResources();
    l = Math.max(getDisplayMetricswidthPixels / 2, localResources.getDimensionPixelSize(acd.c));
    e = paramView;
    paramadu.a(this, paramContext);
  }
  
  public final void a(adu paramadu, boolean paramBoolean)
  {
    if (paramadu != c) {}
    do
    {
      return;
      f();
    } while (g == null);
    g.a(paramadu, paramBoolean);
  }
  
  public final void a(Context paramContext, adu paramadu) {}
  
  public final void a(Parcelable paramParcelable) {}
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(aep paramaep)
  {
    aeh localaeh;
    int i1;
    if (paramaep.hasVisibleItems())
    {
      localaeh = new aeh(j, paramaep, e);
      g = g;
      int i2 = paramaep.size();
      i1 = 0;
      if (i1 >= i2) {
        break label120;
      }
      MenuItem localMenuItem = paramaep.getItem(i1);
      if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {}
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      if (localaeh.e())
      {
        if (g != null) {
          g.a_(paramaep);
        }
        return true;
        i1 += 1;
        break;
      }
      return false;
    }
  }
  
  public final int b()
  {
    return 0;
  }
  
  public final void b(boolean paramBoolean)
  {
    q = false;
    if (k != null) {
      k.notifyDataSetChanged();
    }
  }
  
  public final boolean b(ady paramady)
  {
    return false;
  }
  
  public final void c()
  {
    if (!e()) {
      throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }
  }
  
  public final boolean c(ady paramady)
  {
    return false;
  }
  
  public final Parcelable d()
  {
    return null;
  }
  
  public final boolean e()
  {
    int i4 = 0;
    f = new ajn(j, null, m, n);
    f.a(this);
    f.o = this;
    f.a(k);
    f.c();
    View localView = e;
    int i1;
    int i2;
    if (localView != null)
    {
      if (o == null) {}
      for (i1 = 1;; i1 = 0)
      {
        o = localView.getViewTreeObserver();
        if (i1 != 0) {
          o.addOnGlobalLayoutListener(this);
        }
        f.n = localView;
        f.k = i;
        if (!q)
        {
          aei localaei = k;
          int i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
          int i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
          int i7 = localaei.getCount();
          i2 = 0;
          int i3 = 0;
          localView = null;
          i1 = i4;
          i4 = i1;
          if (i2 < i7)
          {
            i4 = localaei.getItemViewType(i2);
            if (i4 == i3) {
              break label340;
            }
            i3 = i4;
            localView = null;
            label199:
            if (p == null) {
              p = new FrameLayout(j);
            }
            localView = localaei.getView(i2, localView, p);
            localView.measure(i5, i6);
            i4 = localView.getMeasuredWidth();
            if (i4 < l) {
              break;
            }
            i4 = l;
          }
          r = i4;
          q = true;
        }
        f.a(r);
        f.e();
        f.b();
        f.f.setOnKeyListener(this);
        return true;
      }
    }
    return false;
    if (i4 > i1) {
      i1 = i4;
    }
    for (;;)
    {
      i2 += 1;
      break;
      label340:
      break label199;
    }
  }
  
  public final void f()
  {
    if (g()) {
      f.d();
    }
  }
  
  public final boolean g()
  {
    return (f != null) && (f.e.isShowing());
  }
  
  public void onDismiss()
  {
    f = null;
    c.close();
    if (o != null)
    {
      if (!o.isAlive()) {
        o = e.getViewTreeObserver();
      }
      o.removeGlobalOnLayoutListener(this);
      o = null;
    }
  }
  
  public void onGlobalLayout()
  {
    if (g())
    {
      View localView = e;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      f();
    }
    label28:
    while (!g()) {
      return;
    }
    f.b();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = k;
    a.a(paramAdapterView.a(paramInt), null, 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      f();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     aeh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */