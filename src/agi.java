import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;

public final class agi
{
  private final CompoundButton a;
  private final agj b;
  private ColorStateList c = null;
  private PorterDuff.Mode d = null;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  
  public agi(CompoundButton paramCompoundButton, agj paramagj)
  {
    a = paramCompoundButton;
    b = paramagj;
  }
  
  private final void b()
  {
    Drawable localDrawable = vz.a(a);
    if ((localDrawable != null) && ((e) || (f)))
    {
      localDrawable = kn.e(localDrawable).mutate();
      if (e) {
        kn.a(localDrawable, c);
      }
      if (f) {
        kn.a(localDrawable, d);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(a.getDrawableState());
      }
      a.setButtonDrawable(localDrawable);
    }
  }
  
  public final int a(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = vz.a(a);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  public final void a()
  {
    if (g)
    {
      g = false;
      return;
    }
    g = true;
    b();
  }
  
  public final void a(ColorStateList paramColorStateList)
  {
    c = paramColorStateList;
    e = true;
    b();
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    d = paramMode;
    f = true;
    b();
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = a.getContext().obtainStyledAttributes(paramAttributeSet, ack.as, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(ack.at))
      {
        paramInt = paramAttributeSet.getResourceId(ack.at, 0);
        if (paramInt != 0) {
          a.setButtonDrawable(b.a(a.getContext(), paramInt, false));
        }
      }
      CompoundButton localCompoundButton;
      Object localObject2;
      if (paramAttributeSet.hasValue(ack.au))
      {
        localCompoundButton = a;
        localObject2 = paramAttributeSet.getColorStateList(ack.au);
        vz.a.a(localCompoundButton, (ColorStateList)localObject2);
      }
      if (paramAttributeSet.hasValue(ack.av))
      {
        localCompoundButton = a;
        localObject2 = aij.a(paramAttributeSet.getInt(ack.av, -1));
        vz.a.a(localCompoundButton, (PorterDuff.Mode)localObject2);
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     agi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */