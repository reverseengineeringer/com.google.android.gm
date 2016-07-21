import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class aer
  extends ViewGroup
{
  public final aes a = new aes(this);
  public final Context b;
  public ActionMenuView c;
  public ActionMenuPresenter d;
  public int e;
  public tg f;
  private boolean g;
  private boolean h;
  
  aer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  aer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public aer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(aca.a, paramAttributeSet, true)) && (resourceId != 0))
    {
      b = new ContextThemeWrapper(paramContext, resourceId);
      return;
    }
    b = paramContext;
  }
  
  public static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  public static int a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, Integer.MIN_VALUE), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() + 0);
  }
  
  public static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 = (paramInt3 - j) / 2 + paramInt2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    }
    for (;;)
    {
      paramInt1 = i;
      if (paramBoolean) {
        paramInt1 = -i;
      }
      return paramInt1;
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    }
  }
  
  public tg a(int paramInt, long paramLong)
  {
    if (f != null) {
      f.a();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        rg.c(this, 0.0F);
      }
      localtg = rg.q(this).a(1.0F);
      localtg.a(paramLong);
      localtg.a(a.a(localtg, paramInt));
      return localtg;
    }
    tg localtg = rg.q(this).a(0.0F);
    localtg.a(paramLong);
    localtg.a(a.a(localtg, paramInt));
    return localtg;
  }
  
  public void a(int paramInt)
  {
    e = paramInt;
    requestLayout();
  }
  
  public boolean a()
  {
    if (d != null) {
      return d.e();
    }
    return false;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = getContext().obtainStyledAttributes(null, ack.b, aca.c, 0);
    a(paramConfiguration.getLayoutDimension(ack.k, 0));
    paramConfiguration.recycle();
    if (d != null)
    {
      paramConfiguration = d;
      if (!k) {
        j = b.getResources().getInteger(acg.a);
      }
      if (c != null) {
        c.a(true);
      }
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = qk.a(paramMotionEvent);
    if (i == 9) {
      h = false;
    }
    if (!h)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        h = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      h = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = qk.a(paramMotionEvent);
    if (i == 0) {
      g = false;
    }
    if (!g)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        g = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      g = false;
    }
    return true;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      if (f != null) {
        f.a();
      }
      super.setVisibility(paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     aer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */