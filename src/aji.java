import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class aji
  extends ViewGroup.MarginLayoutParams
{
  public float g;
  public int h = -1;
  
  public aji(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    g = 0.0F;
  }
  
  public aji(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ack.bg);
    g = paramContext.getFloat(ack.bi, 0.0F);
    h = paramContext.getInt(ack.bh, -1);
    paramContext.recycle();
  }
  
  public aji(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}

/* Location:
 * Qualified Name:     aji
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */