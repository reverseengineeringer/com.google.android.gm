import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public final class agh
  extends CheckedTextView
{
  private static final int[] a = { 16843016 };
  private agj b;
  private ahg c = ahg.a(this);
  
  public agh(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private agh(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(amm.a(paramContext), paramAttributeSet, 16843720);
    c.a(paramAttributeSet, 16843720);
    c.a();
    b = agj.a();
    paramContext = amp.a(getContext(), paramAttributeSet, a, 16843720);
    setCheckMarkDrawable(paramContext.a(0));
    a.recycle();
  }
  
  protected final void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (c != null) {
      c.a();
    }
  }
  
  public final void setCheckMarkDrawable(int paramInt)
  {
    if (b != null)
    {
      setCheckMarkDrawable(b.a(getContext(), paramInt, false));
      return;
    }
    super.setCheckMarkDrawable(paramInt);
  }
  
  public final void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (c != null) {
      c.a(paramContext, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     agh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */