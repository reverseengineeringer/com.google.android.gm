import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

class wb
  implements wc
{
  public Drawable a(CompoundButton paramCompoundButton)
  {
    return we.a(paramCompoundButton);
  }
  
  public void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    if ((paramCompoundButton instanceof yx)) {
      ((yx)paramCompoundButton).a(paramColorStateList);
    }
  }
  
  public void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    if ((paramCompoundButton instanceof yx)) {
      ((yx)paramCompoundButton).a(paramMode);
    }
  }
}

/* Location:
 * Qualified Name:     wb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */