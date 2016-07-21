import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class agr
  extends ImageView
  implements rb
{
  private agf a;
  private agq b;
  
  public agr(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public agr(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(amm.a(paramContext), paramAttributeSet, paramInt);
    paramContext = agj.a();
    a = new agf(this, paramContext);
    a.a(paramAttributeSet, paramInt);
    b = new agq(this, paramContext);
    b.a(paramAttributeSet, paramInt);
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    if (a != null) {
      a.a(paramColorStateList);
    }
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (a != null) {
      a.a(paramMode);
    }
  }
  
  public final ColorStateList c()
  {
    if (a != null) {
      return a.a();
    }
    return null;
  }
  
  public final PorterDuff.Mode d()
  {
    if (a != null) {
      return a.b();
    }
    return null;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (a != null) {
      a.c();
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (a != null) {
      a.b(null);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (a != null) {
      a.a(paramInt);
    }
  }
  
  public void setImageResource(int paramInt)
  {
    b.a(paramInt);
  }
}

/* Location:
 * Qualified Name:     agr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */