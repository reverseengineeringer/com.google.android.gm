import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class di
  extends ImageButton
{
  public int d = getVisibility();
  
  public di(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public di(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public di(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  final void a(int paramInt, boolean paramBoolean)
  {
    super.setVisibility(paramInt);
    if (paramBoolean) {
      d = paramInt;
    }
  }
  
  public void setVisibility(int paramInt)
  {
    a(paramInt, true);
  }
}

/* Location:
 * Qualified Name:     di
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */