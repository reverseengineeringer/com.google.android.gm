import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import java.util.ArrayList;

public final class amt
  implements aej
{
  adu a;
  public ady b;
  
  amt(Toolbar paramToolbar) {}
  
  public final void a(adu paramadu, boolean paramBoolean) {}
  
  public final void a(Context paramContext, adu paramadu)
  {
    if ((a != null) && (b != null)) {
      a.b(b);
    }
    a = paramadu;
  }
  
  public final void a(Parcelable paramParcelable) {}
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(aep paramaep)
  {
    return false;
  }
  
  public final int b()
  {
    return 0;
  }
  
  public final void b(boolean paramBoolean)
  {
    int k = 0;
    int j;
    int m;
    int i;
    if (b != null)
    {
      j = k;
      if (a != null)
      {
        m = a.size();
        i = 0;
      }
    }
    for (;;)
    {
      j = k;
      if (i < m)
      {
        if (a.getItem(i) == b) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          c(b);
        }
        return;
      }
      i += 1;
    }
  }
  
  public final boolean b(ady paramady)
  {
    Object localObject = c;
    if (e == null)
    {
      e = new ImageButton(((Toolbar)localObject).getContext(), null, aca.O);
      e.setImageDrawable(c);
      e.setContentDescription(d);
      amu localamu = new amu();
      a = (j & 0x70 | 0x800003);
      b = 2;
      e.setLayoutParams(localamu);
      e.setOnClickListener(new ams((Toolbar)localObject));
    }
    if (c.e.getParent() != c) {
      c.addView(c.e);
    }
    c.f = paramady.getActionView();
    b = paramady;
    if (c.f.getParent() != c)
    {
      localObject = new amu();
      a = (c.j & 0x70 | 0x800003);
      b = 2;
      c.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
      c.addView(c.f);
    }
    c.h();
    c.requestLayout();
    paramady.d(true);
    if ((c.f instanceof adb)) {
      ((adb)c.f).a();
    }
    return true;
  }
  
  public final boolean c(ady paramady)
  {
    if ((c.f instanceof adb)) {
      ((adb)c.f).b();
    }
    c.removeView(c.f);
    c.removeView(c.e);
    c.f = null;
    Toolbar localToolbar = c;
    int i = n.size() - 1;
    while (i >= 0)
    {
      localToolbar.addView((View)n.get(i));
      i -= 1;
    }
    n.clear();
    b = null;
    c.requestLayout();
    paramady.d(false);
    return true;
  }
  
  public final Parcelable d()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     amt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */