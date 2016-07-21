import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class ag
  extends ViewGroup.MarginLayoutParams
{
  public ad a;
  public boolean b = false;
  public int c = 0;
  public int d = 0;
  public int e = -1;
  public int f = -1;
  public View g;
  public View h;
  public boolean i;
  public boolean j;
  public boolean k;
  public final Rect l = new Rect();
  Object m;
  
  public ag()
  {
    super(-2, -2);
  }
  
  public ag(ag paramag)
  {
    super(paramag);
  }
  
  public ag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, j.E);
    c = localTypedArray.getInteger(j.F, 0);
    f = localTypedArray.getResourceId(j.G, -1);
    d = localTypedArray.getInteger(j.H, 0);
    e = localTypedArray.getInteger(j.J, -1);
    b = localTypedArray.hasValue(j.I);
    if (b) {
      a = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(j.I));
    }
    localTypedArray.recycle();
  }
  
  public ag(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public ag(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public final void a(ad paramad)
  {
    if (a != paramad)
    {
      a = paramad;
      m = null;
      b = true;
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return (paramView2 == h) || ((a != null) && (a.a_(paramView2)));
  }
}

/* Location:
 * Qualified Name:     ag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */