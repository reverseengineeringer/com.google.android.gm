import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;

public final class als
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator k = new DecelerateInterpolator();
  Runnable a;
  ajh b;
  public boolean c;
  int d;
  int e;
  int f;
  public tg g;
  public final alw h = new alw(this);
  private Spinner i;
  private int j;
  
  public als(Context paramContext)
  {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
    paramContext = acy.a(paramContext);
    c(paramContext.b());
    e = paramContext.c();
    paramContext = new ajh(getContext(), null, aca.d);
    g = true;
    paramContext.c(17);
    paramContext.setLayoutParams(new aji(-2, -1));
    b = paramContext;
    addView(b, new ViewGroup.LayoutParams(-2, -1));
  }
  
  private final boolean a()
  {
    return (i != null) && (i.getParent() == this);
  }
  
  private final boolean b()
  {
    if (!a()) {
      return false;
    }
    removeView(i);
    addView(b, new ViewGroup.LayoutParams(-2, -1));
    a(i.getSelectedItemPosition());
    return false;
  }
  
  private final void c(int paramInt)
  {
    f = paramInt;
    requestLayout();
  }
  
  public final void a(int paramInt)
  {
    j = paramInt;
    int n = b.getChildCount();
    int m = 0;
    if (m < n)
    {
      View localView = b.getChildAt(m);
      if (m == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          b(paramInt);
        }
        m += 1;
        break;
      }
    }
    if ((i != null) && (paramInt >= 0)) {
      i.setSelection(paramInt);
    }
  }
  
  public final void b(int paramInt)
  {
    View localView = b.getChildAt(paramInt);
    if (a != null) {
      removeCallbacks(a);
    }
    a = new alt(this, localView);
    post(a);
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (a != null) {
      post(a);
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = acy.a(getContext());
    c(paramConfiguration.b());
    e = paramConfiguration.c();
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (a != null) {
      removeCallbacks(a);
    }
  }
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a.e();
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int m = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (m == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int n = b.getChildCount();
      if ((n <= 1) || ((m != 1073741824) && (m != Integer.MIN_VALUE))) {
        break label327;
      }
      if (n <= 2) {
        break label314;
      }
      d = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label68:
      d = Math.min(d, e);
      label83:
      m = View.MeasureSpec.makeMeasureSpec(f, 1073741824);
      if ((bool) || (!c)) {
        break label335;
      }
      label105:
      if (paramInt2 == 0) {
        break label348;
      }
      b.measure(0, m);
      if (b.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label340;
      }
      if (!a())
      {
        if (i == null)
        {
          agz localagz = new agz(getContext(), null, aca.i);
          localagz.setLayoutParams(new aji(-2, -1));
          localagz.setOnItemSelectedListener(this);
          i = localagz;
        }
        removeView(b);
        addView(i, new ViewGroup.LayoutParams(-2, -1));
        if (i.getAdapter() == null) {
          i.setAdapter(new alu(this));
        }
        if (a != null)
        {
          removeCallbacks(a);
          a = null;
        }
        i.setSelection(j);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, m);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        a(j);
      }
      return;
      bool = false;
      break;
      label314:
      d = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label68;
      label327:
      d = -1;
      break label83;
      label335:
      paramInt2 = 0;
      break label105;
      label340:
      b();
      continue;
      label348:
      b();
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}

/* Location:
 * Qualified Name:     als
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */