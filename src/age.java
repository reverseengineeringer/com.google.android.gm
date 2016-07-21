import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class age
  extends AutoCompleteTextView
  implements rb
{
  private static final int[] a = { 16843126 };
  private agj b = agj.a();
  private agf c;
  private ahg d;
  
  public age(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public age(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, aca.q);
  }
  
  public age(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(amm.a(paramContext), paramAttributeSet, paramInt);
    paramContext = amp.a(getContext(), paramAttributeSet, a, paramInt);
    if (paramContext.e(0)) {
      setDropDownBackgroundDrawable(paramContext.a(0));
    }
    a.recycle();
    c = new agf(this, b);
    c.a(paramAttributeSet, paramInt);
    d = ahg.a(this);
    d.a(paramAttributeSet, paramInt);
    d.a();
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (c != null) {
      c.a(paramColorStateList);
    }
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (c != null) {
      c.a(paramMode);
    }
  }
  
  public final ColorStateList c()
  {
    if (c != null) {
      return c.a();
    }
    return null;
  }
  
  public final PorterDuff.Mode d()
  {
    if (c != null) {
      return c.b();
    }
    return null;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (c != null) {
      c.c();
    }
    if (d != null) {
      d.a();
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (c != null) {
      c.b(null);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (c != null) {
      c.a(paramInt);
    }
  }
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    if (b != null)
    {
      setDropDownBackgroundDrawable(b.a(getContext(), paramInt, false));
      return;
    }
    super.setDropDownBackgroundResource(paramInt);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (d != null) {
      d.a(paramContext, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     age
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */