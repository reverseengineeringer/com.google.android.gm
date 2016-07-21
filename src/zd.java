import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class zd
  extends ViewGroup.MarginLayoutParams
{
  public int a = 0;
  
  public zd(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    a = 8388627;
  }
  
  public zd(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ack.u);
    a = paramContext.getInt(ack.v, 0);
    paramContext.recycle();
  }
  
  public zd(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public zd(zd paramzd)
  {
    super(paramzd);
    a = a;
  }
}

/* Location:
 * Qualified Name:     zd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */