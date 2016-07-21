import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

public abstract class cte
  extends LinearLayout
{
  private static final Interpolator a = new vq();
  private static final Interpolator b = new vs();
  public boolean c = true;
  public boolean d;
  boolean e;
  long f;
  private boolean g;
  private final Runnable h = new ctf(this);
  private final Handler i = new Handler();
  
  public cte(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public cte(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public cte(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void a(cte paramcte, MotionEvent paramMotionEvent)
  {
    int m = 0;
    int k;
    if ((paramMotionEvent.getAction() == 0) && (paramcte != null) && (!paramcte.g()) && (!e) && (!paramcte.h()))
    {
      k = m;
      if (paramcte.f() != -1L)
      {
        int[] arrayOfInt = new int[2];
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        paramcte.getLocationOnScreen(arrayOfInt);
        if ((f1 <= arrayOfInt[0]) || (f1 >= arrayOfInt[0] + paramcte.getWidth()) || (f2 <= arrayOfInt[1]) || (f2 >= arrayOfInt[1] + paramcte.getHeight())) {
          break label142;
        }
      }
    }
    label142:
    for (int j = 1;; j = 0)
    {
      k = m;
      if (j == 0) {
        k = 1;
      }
      if (k != 0) {
        break;
      }
      return;
    }
    paramcte.a(true);
  }
  
  public void a()
  {
    if (e) {
      return;
    }
    c(false);
  }
  
  public void a(boolean paramBoolean)
  {
    float f1 = d();
    if ((c) || (f1 == 0.0F)) {
      c = true;
    }
    do
    {
      return;
      f = 0L;
      i.removeCallbacks(h);
    } while (c);
    c = true;
    c(paramBoolean);
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    float f1 = d();
    if ((!c) || (f1 == 0.0F)) {
      c = false;
    }
    long l;
    do
    {
      return;
      i.removeCallbacks(h);
      if (c)
      {
        c = false;
        c(true);
      }
      l = f();
    } while ((!paramBoolean) || (l == -1L));
    i.postDelayed(h, l);
  }
  
  public void c() {}
  
  public final void c(boolean paramBoolean)
  {
    if (!g) {
      return;
    }
    e |= paramBoolean;
    if (!c)
    {
      if (e)
      {
        animate().setDuration(300L).setInterpolator(a).translationY(0.0F).setListener(new ctg(this));
        return;
      }
      setTranslationY(0.0F);
      return;
    }
    if (d)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
      int j = getMeasuredHeight();
      f1 = bottomMargin + j;
      if (e)
      {
        animate().translationY(f1).setInterpolator(b).setDuration(150L).setListener(new cth(this));
        return;
      }
      setTranslationY(f1);
      c();
      return;
    }
    float f1 = d();
    if (e)
    {
      animate().setDuration(150L).setInterpolator(b).translationY(f1).setListener(new cti(this));
      return;
    }
    setTranslationY(f1);
  }
  
  public abstract float d();
  
  public abstract long e();
  
  public abstract long f();
  
  public final boolean g()
  {
    return (c) || (d);
  }
  
  public boolean h()
  {
    long l = e();
    return (l == -1L) || (System.currentTimeMillis() - f < l);
  }
  
  public final void i()
  {
    d = false;
    b();
    c(true);
  }
  
  public void onDetachedFromWindow()
  {
    i.removeCallbacks(h);
    super.onDetachedFromWindow();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    g = true;
    a();
  }
}

/* Location:
 * Qualified Name:     cte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */