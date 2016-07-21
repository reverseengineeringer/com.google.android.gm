import android.graphics.Paint;
import android.os.Build.VERSION;
import android.view.View;

public final class rg
{
  public static final rt a = new rh();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      a = new rs();
      return;
    }
    if (i >= 21)
    {
      a = new rr();
      return;
    }
    if (i >= 19)
    {
      a = new rq();
      return;
    }
    if (i >= 17)
    {
      a = new ro();
      return;
    }
    if (i >= 16)
    {
      a = new rn();
      return;
    }
    if (i >= 15)
    {
      a = new rl();
      return;
    }
    if (i >= 14)
    {
      a = new rm();
      return;
    }
    if (i >= 11)
    {
      a = new rk();
      return;
    }
    if (i >= 9)
    {
      a = new rj();
      return;
    }
    if (i >= 7)
    {
      a = new ri();
      return;
    }
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(View paramView)
  {
    return a.a(paramView);
  }
  
  public static tz a(View paramView, tz paramtz)
  {
    return a.a(paramView, paramtz);
  }
  
  public static void a(View paramView, float paramFloat)
  {
    a.a(paramView, paramFloat);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a.b(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void a(View paramView, int paramInt, Paint paramPaint)
  {
    a.a(paramView, paramInt, paramPaint);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    a.a(paramView, paramRunnable);
  }
  
  public static void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    a.a(paramView, paramRunnable, paramLong);
  }
  
  public static void a(View paramView, ol paramol)
  {
    a.a(paramView, paramol);
  }
  
  public static void a(View paramView, qu paramqu)
  {
    a.a(paramView, paramqu);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    a.c(paramView, paramBoolean);
  }
  
  public static boolean a(View paramView, int paramInt)
  {
    return a.a(paramView, paramInt);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    a.b(paramView, paramFloat);
  }
  
  public static boolean b(View paramView)
  {
    return a.c(paramView);
  }
  
  public static boolean b(View paramView, int paramInt)
  {
    return a.b(paramView, paramInt);
  }
  
  public static void c(View paramView)
  {
    a.d(paramView);
  }
  
  public static void c(View paramView, float paramFloat)
  {
    a.c(paramView, paramFloat);
  }
  
  public static void c(View paramView, int paramInt)
  {
    a.c(paramView, paramInt);
  }
  
  public static int d(View paramView)
  {
    return a.e(paramView);
  }
  
  public static void d(View paramView, float paramFloat)
  {
    a.d(paramView, paramFloat);
  }
  
  public static void d(View paramView, int paramInt)
  {
    a.d(paramView, paramInt);
  }
  
  public static float e(View paramView)
  {
    return a.f(paramView);
  }
  
  public static void e(View paramView, float paramFloat)
  {
    a.e(paramView, paramFloat);
  }
  
  public static void e(View paramView, int paramInt)
  {
    a.g(paramView, paramInt);
  }
  
  public static int f(View paramView)
  {
    return a.g(paramView);
  }
  
  public static void f(View paramView, float paramFloat)
  {
    a.f(paramView, paramFloat);
  }
  
  public static void f(View paramView, int paramInt)
  {
    a.f(paramView, paramInt);
  }
  
  public static int g(View paramView)
  {
    return a.h(paramView);
  }
  
  public static int h(View paramView)
  {
    return a.k(paramView);
  }
  
  public static int i(View paramView)
  {
    return a.l(paramView);
  }
  
  public static void j(View paramView)
  {
    a.e(paramView, 1);
  }
  
  public static int k(View paramView)
  {
    return a.m(paramView);
  }
  
  public static int l(View paramView)
  {
    return a.n(paramView);
  }
  
  public static float m(View paramView)
  {
    return a.p(paramView);
  }
  
  public static float n(View paramView)
  {
    return a.q(paramView);
  }
  
  public static int o(View paramView)
  {
    return a.s(paramView);
  }
  
  public static int p(View paramView)
  {
    return a.t(paramView);
  }
  
  public static tg q(View paramView)
  {
    return a.u(paramView);
  }
  
  public static int r(View paramView)
  {
    return a.v(paramView);
  }
  
  public static void s(View paramView)
  {
    a.w(paramView);
  }
  
  public static boolean t(View paramView)
  {
    return a.z(paramView);
  }
  
  public static void u(View paramView)
  {
    a.a(paramView, true);
  }
  
  public static void v(View paramView)
  {
    a.b(paramView, false);
  }
  
  public static boolean w(View paramView)
  {
    return a.G(paramView);
  }
  
  public static float x(View paramView)
  {
    return a.H(paramView);
  }
  
  public static boolean y(View paramView)
  {
    return a.I(paramView);
  }
}

/* Location:
 * Qualified Name:     rg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */