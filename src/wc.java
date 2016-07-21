import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

public abstract interface wc
{
  public abstract Drawable a(CompoundButton paramCompoundButton);
  
  public abstract void a(CompoundButton paramCompoundButton, ColorStateList paramColorStateList);
  
  public abstract void a(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode);
}

/* Location:
 * Qualified Name:     wc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */