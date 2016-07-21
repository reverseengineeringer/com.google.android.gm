package android.support.v7.widget;

import aca;
import agi;
import agj;
import amm;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import jr;
import yx;

public class AppCompatRadioButton
  extends RadioButton
  implements yx
{
  private agj a = agj.a();
  private agi b = new agi(this, a);
  
  public AppCompatRadioButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, aca.I);
  }
  
  public AppCompatRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(amm.a(paramContext), paramAttributeSet, paramInt);
    b.a(paramAttributeSet, paramInt);
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
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    int i = j;
    if (b != null) {
      i = b.a(j);
    }
    return i;
  }
  
  public void setButtonDrawable(int paramInt)
  {
    if (a != null) {}
    for (Drawable localDrawable = a.a(getContext(), paramInt, false);; localDrawable = jr.a(getContext(), paramInt))
    {
      setButtonDrawable(localDrawable);
      return;
    }
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    if (b != null) {
      b.a();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatRadioButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */