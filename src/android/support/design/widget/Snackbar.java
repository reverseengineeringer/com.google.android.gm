package android.support.design.widget;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import b;
import bj;
import bp;
import bq;
import bv;
import bx;
import by;
import java.lang.ref.WeakReference;
import p;
import rg;
import tg;

public final class Snackbar
{
  public static final Handler a = new Handler(Looper.getMainLooper(), new bj());
  public final ViewGroup b;
  public final Snackbar.SnackbarLayout c;
  public final bx d;
  private final AccessibilityManager e;
  
  public final void a()
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      rg.b(c, c.getHeight());
      rg.q(c).c(0.0F).a(p.b).a(250L).a(new bp(this)).b();
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(c.getContext(), b.c);
    localAnimation.setInterpolator(p.b);
    localAnimation.setDuration(250L);
    localAnimation.setAnimationListener(new bq(this));
    c.startAnimation(localAnimation);
  }
  
  public final void b()
  {
    bv localbv = bv.a();
    bx localbx = d;
    synchronized (a)
    {
      if (localbv.d(localbx)) {
        localbv.b(b);
      }
      return;
    }
  }
  
  public final void c()
  {
    bv localbv = bv.a();
    bx localbx = d;
    synchronized (a)
    {
      if (localbv.d(localbx))
      {
        b = null;
        if ((c != null) && (c != null))
        {
          b = c;
          c = null;
          if ((bx)b.a.get() == null) {
            b = null;
          }
        }
      }
      ??? = c.getParent();
      if ((??? instanceof ViewGroup)) {
        ((ViewGroup)???).removeView(c);
      }
      return;
    }
  }
  
  public final boolean d()
  {
    return !e.isEnabled();
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */