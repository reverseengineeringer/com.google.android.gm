import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class wn
  extends ViewGroup.MarginLayoutParams
{
  public int a = 0;
  public float b;
  public boolean c;
  public int d;
  
  public wn()
  {
    super(-1, -1);
  }
  
  public wn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.a);
    a = paramContext.getInt(0, 0);
    paramContext.recycle();
  }
  
  public wn(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public wn(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public wn(wn paramwn)
  {
    super(paramwn);
    a = a;
  }
}

/* Location:
 * Qualified Name:     wn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */