import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;

public final class u
  extends LinearLayout.LayoutParams
{
  public int a = 1;
  public Interpolator b;
  
  public u()
  {
    super(-1, -2);
  }
  
  public u(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, j.j);
    a = paramAttributeSet.getInt(j.k, 0);
    if (paramAttributeSet.hasValue(j.l)) {
      b = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(j.l, 0));
    }
    paramAttributeSet.recycle();
  }
  
  public u(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public u(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public u(LinearLayout.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}

/* Location:
 * Qualified Name:     u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */