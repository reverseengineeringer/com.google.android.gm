import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;

public final class ago
  extends EditText
  implements rb
{
  private agj a = agj.a();
  private agf b = new agf(this, a);
  private ahg c;
  
  public ago(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, aca.C);
  }
  
  private ago(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(amm.a(paramContext), paramAttributeSet, paramInt);
    b.a(paramAttributeSet, paramInt);
    c = ahg.a(this);
    c.a(paramAttributeSet, paramInt);
    c.a();
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (b != null) {
      b.a(paramColorStateList);
    }
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (b != null) {
      b.a(paramMode);
    }
  }
  
  public final ColorStateList c()
  {
    if (b != null) {
      return b.a();
    }
    return null;
  }
  
  public final PorterDuff.Mode d()
  {
    if (b != null) {
      return b.b();
    }
    return null;
  }
  
  protected final void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (b != null) {
      b.c();
    }
    if (c != null) {
      c.a();
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (b != null) {
      b.b(null);
    }
  }
  
  public final void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (b != null) {
      b.a(paramInt);
    }
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
 * Qualified Name:     ago
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */