import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.RatingBar;

public final class agw
  extends RatingBar
{
  private agv a = new agv(this, b);
  private agj b = agj.a();
  
  public agw(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, aca.J);
  }
  
  private agw(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a.a(paramAttributeSet, paramInt);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      Bitmap localBitmap = a.b;
      if (localBitmap != null) {
        setMeasuredDimension(rg.a(localBitmap.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     agw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */