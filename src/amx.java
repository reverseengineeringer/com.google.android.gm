import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public final class amx
  implements ahw
{
  Toolbar a;
  CharSequence b;
  Window.Callback c;
  boolean d;
  private int e;
  private View f;
  private Spinner g;
  private View h;
  private Drawable i;
  private Drawable j;
  private Drawable k;
  private boolean l;
  private CharSequence m;
  private CharSequence n;
  private ActionMenuPresenter o;
  private int p = 0;
  private final agj q;
  private int r = 0;
  private Drawable s;
  
  public amx(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, aci.a, ace.k);
  }
  
  private amx(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    a = paramToolbar;
    b = l;
    m = m;
    boolean bool;
    int i1;
    if (b != null)
    {
      bool = true;
      l = bool;
      k = paramToolbar.e();
      if (!paramBoolean) {
        break label585;
      }
      paramToolbar = amp.a(paramToolbar.getContext(), null, ack.b, aca.c);
      Object localObject = paramToolbar.c(ack.s);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        b((CharSequence)localObject);
      }
      localObject = paramToolbar.c(ack.q);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        c((CharSequence)localObject);
      }
      localObject = paramToolbar.a(ack.o);
      if (localObject != null) {
        b((Drawable)localObject);
      }
      localObject = paramToolbar.a(ack.n);
      if ((k == null) && (localObject != null)) {
        a((Drawable)localObject);
      }
      localObject = paramToolbar.a(ack.m);
      if (localObject != null) {
        c((Drawable)localObject);
      }
      b(paramToolbar.a(ack.i, 0));
      i1 = paramToolbar.e(ack.h, 0);
      if (i1 != 0)
      {
        a(LayoutInflater.from(a.getContext()).inflate(i1, a, false));
        b(e | 0x10);
      }
      i1 = paramToolbar.d(ack.k, 0);
      if (i1 > 0)
      {
        localObject = a.getLayoutParams();
        height = i1;
        a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      int i2 = paramToolbar.b(ack.g, -1);
      i1 = paramToolbar.b(ack.f, -1);
      if ((i2 >= 0) || (i1 >= 0))
      {
        localObject = a;
        i2 = Math.max(i2, 0);
        i1 = Math.max(i1, 0);
        k.a(i2, i1);
      }
      i1 = paramToolbar.e(ack.t, 0);
      if (i1 != 0) {
        a.a(a.getContext(), i1);
      }
      i1 = paramToolbar.e(ack.r, 0);
      if (i1 != 0)
      {
        localObject = a;
        Context localContext = a.getContext();
        i = i1;
        if (b != null) {
          b.setTextAppearance(localContext, i1);
        }
      }
      i1 = paramToolbar.e(ack.p, 0);
      if (i1 != 0) {
        a.a(i1);
      }
      a.recycle();
    }
    for (;;)
    {
      q = agj.a();
      if (paramInt1 != r)
      {
        r = paramInt1;
        if (TextUtils.isEmpty(a.d())) {
          e(r);
        }
      }
      n = a.d();
      paramToolbar = q.a(a.getContext(), paramInt2, false);
      if (s != paramToolbar)
      {
        s = paramToolbar;
        v();
      }
      a.a(new amy(this));
      return;
      bool = false;
      break;
      label585:
      i1 = 11;
      if (a.e() != null) {
        i1 = 15;
      }
      e = i1;
    }
  }
  
  private final void d(CharSequence paramCharSequence)
  {
    b = paramCharSequence;
    if ((e & 0x8) != 0) {
      a.a(paramCharSequence);
    }
  }
  
  private final void s()
  {
    Drawable localDrawable = null;
    if ((e & 0x2) != 0)
    {
      if ((e & 0x1) == 0) {
        break label49;
      }
      if (j == null) {
        break label41;
      }
      localDrawable = j;
    }
    for (;;)
    {
      a.a(localDrawable);
      return;
      label41:
      localDrawable = i;
      continue;
      label49:
      localDrawable = i;
    }
  }
  
  private final void t()
  {
    if (g == null)
    {
      g = new agz(a.getContext(), null, aca.i);
      amu localamu = new amu((byte)0);
      g.setLayoutParams(localamu);
    }
  }
  
  private final void u()
  {
    Toolbar localToolbar;
    int i1;
    if ((e & 0x4) != 0)
    {
      if (!TextUtils.isEmpty(n)) {
        break label53;
      }
      localToolbar = a;
      i1 = r;
      if (i1 == 0) {
        break label48;
      }
    }
    label48:
    for (CharSequence localCharSequence = localToolbar.getContext().getText(i1);; localCharSequence = null)
    {
      localToolbar.c(localCharSequence);
      return;
    }
    label53:
    a.c(n);
  }
  
  private final void v()
  {
    Toolbar localToolbar;
    if ((e & 0x4) != 0)
    {
      localToolbar = a;
      if (k == null) {
        break label32;
      }
    }
    label32:
    for (Drawable localDrawable = k;; localDrawable = s)
    {
      localToolbar.b(localDrawable);
      return;
    }
  }
  
  public final ViewGroup a()
  {
    return a;
  }
  
  public final tg a(int paramInt, long paramLong)
  {
    tg localtg = rg.q(a);
    if (paramInt == 0) {}
    for (float f1 = 1.0F;; f1 = 0.0F) {
      return localtg.a(f1).a(paramLong).a(new amz(this, paramInt));
    }
  }
  
  public final void a(int paramInt)
  {
    a(q.a(a.getContext(), 17170445, false));
  }
  
  public final void a(aek paramaek, adv paramadv)
  {
    Toolbar localToolbar = a;
    r = paramaek;
    s = paramadv;
    if (a != null) {
      a.a(paramaek, paramadv);
    }
  }
  
  public final void a(als paramals)
  {
    if ((f != null) && (f.getParent() == a)) {
      a.removeView(f);
    }
    f = paramals;
    if ((paramals != null) && (p == 2))
    {
      a.addView(f, 0);
      amu localamu = (amu)f.getLayoutParams();
      width = -2;
      height = -2;
      a = 8388691;
      c = true;
    }
  }
  
  public final void a(Drawable paramDrawable)
  {
    i = paramDrawable;
    s();
  }
  
  public final void a(Menu paramMenu, aek paramaek)
  {
    if (o == null)
    {
      o = new ActionMenuPresenter(a.getContext());
      o.h = acf.g;
    }
    o.f = paramaek;
    paramaek = a;
    paramMenu = (adu)paramMenu;
    ActionMenuPresenter localActionMenuPresenter = o;
    if ((paramMenu != null) || (a != null))
    {
      paramaek.f();
      adu localadu = a.a;
      if (localadu != paramMenu)
      {
        if (localadu != null)
        {
          localadu.b(p);
          localadu.b(q);
        }
        if (q == null) {
          q = new amt(paramaek);
        }
        l = true;
        if (paramMenu == null) {
          break label185;
        }
        paramMenu.a(localActionMenuPresenter, g);
        paramMenu.a(q, g);
      }
    }
    for (;;)
    {
      a.a(h);
      a.a(localActionMenuPresenter);
      p = localActionMenuPresenter;
      return;
      label185:
      localActionMenuPresenter.a(g, null);
      q.a(g, null);
      localActionMenuPresenter.b(true);
      q.b(true);
    }
  }
  
  public final void a(View paramView)
  {
    if ((h != null) && ((e & 0x10) != 0)) {
      a.removeView(h);
    }
    h = paramView;
    if ((paramView != null) && ((e & 0x10) != 0)) {
      a.addView(h);
    }
  }
  
  public final void a(Window.Callback paramCallback)
  {
    c = paramCallback;
  }
  
  public final void a(SpinnerAdapter paramSpinnerAdapter, AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    t();
    g.setAdapter(paramSpinnerAdapter);
    g.setOnItemSelectedListener(paramOnItemSelectedListener);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    if (!l) {
      d(paramCharSequence);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Toolbar localToolbar = a;
    t = paramBoolean;
    localToolbar.requestLayout();
  }
  
  public final Context b()
  {
    return a.getContext();
  }
  
  public final void b(int paramInt)
  {
    int i1 = e ^ paramInt;
    e = paramInt;
    if (i1 != 0)
    {
      if ((i1 & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          break label115;
        }
        v();
        u();
      }
      if ((i1 & 0x3) != 0) {
        s();
      }
      if ((i1 & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label126;
        }
        a.a(b);
        a.b(m);
      }
    }
    for (;;)
    {
      if (((i1 & 0x10) != 0) && (h != null))
      {
        if ((paramInt & 0x10) == 0) {
          break label145;
        }
        a.addView(h);
      }
      return;
      label115:
      a.b(null);
      break;
      label126:
      a.a(null);
      a.b(null);
    }
    label145:
    a.removeView(h);
  }
  
  public final void b(Drawable paramDrawable)
  {
    j = paramDrawable;
    s();
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    l = true;
    d(paramCharSequence);
  }
  
  public final void c(int paramInt)
  {
    int i1 = p;
    if (paramInt != i1)
    {
      switch (i1)
      {
      }
      for (;;)
      {
        p = paramInt;
        switch (paramInt)
        {
        default: 
          throw new IllegalArgumentException("Invalid navigation mode " + paramInt);
          if ((g != null) && (g.getParent() == a))
          {
            a.removeView(g);
            continue;
            if ((f != null) && (f.getParent() == a)) {
              a.removeView(f);
            }
          }
          break;
        }
      }
      t();
      a.addView(g, 0);
    }
    do
    {
      return;
    } while (f == null);
    a.addView(f, 0);
    amu localamu = (amu)f.getLayoutParams();
    width = -2;
    height = -2;
    a = 8388691;
  }
  
  public final void c(Drawable paramDrawable)
  {
    k = paramDrawable;
    v();
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    m = paramCharSequence;
    if ((e & 0x8) != 0) {
      a.b(paramCharSequence);
    }
  }
  
  public final boolean c()
  {
    Toolbar localToolbar = a;
    return (q != null) && (q.b != null);
  }
  
  public final void d()
  {
    a.c();
  }
  
  public final void d(int paramInt)
  {
    if (g == null) {
      throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }
    g.setSelection(paramInt);
  }
  
  public final CharSequence e()
  {
    return a.l;
  }
  
  public final void e(int paramInt)
  {
    if (paramInt == 0) {}
    for (String str = null;; str = a.getContext().getString(paramInt))
    {
      n = str;
      u();
      return;
    }
  }
  
  public final void f(int paramInt)
  {
    a.setVisibility(paramInt);
  }
  
  public final boolean f()
  {
    Toolbar localToolbar = a;
    return (localToolbar.getVisibility() == 0) && (a != null) && (a.b);
  }
  
  public final boolean g()
  {
    return a.a();
  }
  
  public final boolean h()
  {
    Object localObject = a;
    if (a != null)
    {
      localObject = a;
      if (c != null)
      {
        localObject = c;
        if ((o != null) || (((ActionMenuPresenter)localObject).i()))
        {
          i1 = 1;
          if (i1 == 0) {
            break label62;
          }
        }
      }
      label62:
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label67;
        }
        return true;
        i1 = 0;
        break;
      }
    }
    label67:
    return false;
  }
  
  public final boolean i()
  {
    return a.b();
  }
  
  public final boolean j()
  {
    Object localObject = a;
    if (a != null)
    {
      localObject = a;
      if ((c != null) && (c.f())) {}
      for (int i1 = 1; i1 != 0; i1 = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void k()
  {
    d = true;
  }
  
  public final void l()
  {
    Toolbar localToolbar = a;
    if (a != null) {
      a.c();
    }
  }
  
  public final int m()
  {
    return e;
  }
  
  public final int n()
  {
    return p;
  }
  
  public final int o()
  {
    if (g != null) {
      return g.getSelectedItemPosition();
    }
    return 0;
  }
  
  public final int p()
  {
    return a.getHeight();
  }
  
  public final int q()
  {
    return a.getVisibility();
  }
  
  public final Menu r()
  {
    Toolbar localToolbar = a;
    localToolbar.f();
    if (a.a == null)
    {
      adu localadu = (adu)a.b();
      if (q == null) {
        q = new amt(localToolbar);
      }
      a.c.l = true;
      localadu.a(q, g);
    }
    return a.b();
  }
}

/* Location:
 * Qualified Name:     amx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */