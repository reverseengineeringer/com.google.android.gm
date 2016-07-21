import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.CompoundButton;

class wd
  extends wb
{
  public final void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    paramCompoundButton.setButtonTintList(paramColorStateList);
  }
  
  public final void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    paramCompoundButton.setButtonTintMode(paramMode);
  }
}

/* Location:
 * Qualified Name:     wd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */