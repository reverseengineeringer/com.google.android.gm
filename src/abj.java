import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.SpinnerAdapter;
import java.util.ArrayList;

public final class abj
  extends zc
{
  ahw a;
  boolean b;
  public Window.Callback c;
  ads d;
  private boolean e;
  private boolean f;
  private ArrayList<ze> g = new ArrayList();
  private final Runnable h = new abk(this);
  private final amv i = new abl(this);
  
  public abj(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    a = new amx(paramToolbar, false);
    c = new abp(this, paramCallback);
    a.a(c);
    o = i;
    a.a(paramCharSequence);
  }
  
  public final void a()
  {
    a.a(17170445);
  }
  
  public final void a(int paramInt)
  {
    switch (a.n())
    {
    default: 
      throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }
    a.d(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int j = a.m();
    a.b(j & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
  }
  
  public final void a(Drawable paramDrawable)
  {
    a.b(paramDrawable);
  }
  
  public final void a(View paramView, zd paramzd)
  {
    if (paramView != null) {
      paramView.setLayoutParams(paramzd);
    }
    a.a(paramView);
  }
  
  public final void a(SpinnerAdapter paramSpinnerAdapter, zf paramzf)
  {
    a.a(paramSpinnerAdapter, new abi(paramzf));
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    a.b(paramCharSequence);
  }
  
  public final void a(ze paramze)
  {
    g.add(paramze);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 2;; j = 0)
    {
      a(j, 2);
      return;
    }
  }
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = q();
    int j;
    if (localMenu != null)
    {
      if (paramKeyEvent == null) {
        break label56;
      }
      j = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(j).getKeyboardType() == 1) {
        break label61;
      }
    }
    label56:
    label61:
    for (boolean bool = true;; bool = false)
    {
      localMenu.setQwertyMode(bool);
      localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      return true;
      j = -1;
      break;
    }
  }
  
  public final void b()
  {
    a.a(null);
  }
  
  public final void b(int paramInt)
  {
    ahw localahw = a;
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = a.b().getText(paramInt);; localCharSequence = null)
    {
      localahw.b(localCharSequence);
      return;
    }
  }
  
  public final void b(Drawable paramDrawable)
  {
    a.c(paramDrawable);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    a.c(paramCharSequence);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 4;; j = 0)
    {
      a(j, 4);
      return;
    }
  }
  
  public final void c()
  {
    a(0, 1);
  }
  
  public final void c(int paramInt)
  {
    ahw localahw = a;
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = a.b().getText(paramInt);; localCharSequence = null)
    {
      localahw.c(localCharSequence);
      return;
    }
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    a.a(paramCharSequence);
  }
  
  public final void c(boolean paramBoolean) {}
  
  public final void d()
  {
    a(0, 8);
  }
  
  public final void d(int paramInt)
  {
    if (paramInt == 2) {
      throw new IllegalArgumentException("Tabs not supported in this configuration");
    }
    a.c(paramInt);
  }
  
  public final void d(boolean paramBoolean) {}
  
  public final void e()
  {
    a(16, 16);
  }
  
  public final void e(int paramInt)
  {
    a.e(paramInt);
  }
  
  public final void e(boolean paramBoolean)
  {
    if (paramBoolean == f) {}
    for (;;)
    {
      return;
      f = paramBoolean;
      int k = g.size();
      int j = 0;
      while (j < k)
      {
        ((ze)g.get(j)).a(paramBoolean);
        j += 1;
      }
    }
  }
  
  public final CharSequence f()
  {
    return a.e();
  }
  
  public final int g()
  {
    return a.m();
  }
  
  public final int h()
  {
    return a.p();
  }
  
  public final void i()
  {
    a.f(0);
  }
  
  public final void j()
  {
    a.f(8);
  }
  
  public final boolean k()
  {
    return a.q() == 0;
  }
  
  public final Context l()
  {
    return a.b();
  }
  
  public final boolean m()
  {
    a.a().removeCallbacks(h);
    rg.a(a.a(), h);
    return true;
  }
  
  public final boolean n()
  {
    if (a.c())
    {
      a.d();
      return true;
    }
    return false;
  }
  
  public final boolean o()
  {
    ViewGroup localViewGroup = a.a();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  final void p()
  {
    a.a().removeCallbacks(h);
  }
  
  final Menu q()
  {
    if (!e)
    {
      a.a(new abm(this), new abn(this));
      e = true;
    }
    return a.r();
  }
}

/* Location:
 * Qualified Name:     abj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */