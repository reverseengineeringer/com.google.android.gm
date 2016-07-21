package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Button;
import cys;

public class NavigationBarButton
  extends Button
{
  public NavigationBarButton(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public NavigationBarButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private final void a()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      Drawable[] arrayOfDrawable = getCompoundDrawablesRelative();
      int i = 0;
      while (i < arrayOfDrawable.length)
      {
        if (arrayOfDrawable[i] != null) {
          arrayOfDrawable[i] = cys.a(arrayOfDrawable[i]);
        }
        i += 1;
      }
      setCompoundDrawablesRelativeWithIntrinsicBounds(arrayOfDrawable[0], arrayOfDrawable[1], arrayOfDrawable[2], arrayOfDrawable[3]);
    }
  }
  
  private final void b()
  {
    ColorStateList localColorStateList = getTextColors();
    if (localColorStateList != null)
    {
      Drawable[] arrayOfDrawable = new Drawable[6];
      Object localObject = getCompoundDrawables();
      arrayOfDrawable[0] = localObject[0];
      arrayOfDrawable[1] = localObject[1];
      arrayOfDrawable[2] = localObject[2];
      arrayOfDrawable[3] = localObject[3];
      if (Build.VERSION.SDK_INT >= 17)
      {
        localObject = getCompoundDrawablesRelative();
        arrayOfDrawable[4] = localObject[0];
        arrayOfDrawable[5] = localObject[2];
      }
      int i = 0;
      while (i < 6)
      {
        localObject = arrayOfDrawable[i];
        if ((localObject instanceof cys))
        {
          localObject = (cys)localObject;
          a = localColorStateList;
          if (((cys)localObject).a()) {
            ((cys)localObject).invalidateSelf();
          }
        }
        i += 1;
      }
      invalidate();
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    Object localObject = paramDrawable1;
    if (paramDrawable1 != null) {
      localObject = cys.a(paramDrawable1);
    }
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 != null) {
      paramDrawable1 = cys.a(paramDrawable2);
    }
    paramDrawable2 = paramDrawable3;
    if (paramDrawable3 != null) {
      paramDrawable2 = cys.a(paramDrawable3);
    }
    paramDrawable3 = paramDrawable4;
    if (paramDrawable4 != null) {
      paramDrawable3 = cys.a(paramDrawable4);
    }
    super.setCompoundDrawables((Drawable)localObject, paramDrawable1, paramDrawable2, paramDrawable3);
    b();
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    Object localObject = paramDrawable1;
    if (paramDrawable1 != null) {
      localObject = cys.a(paramDrawable1);
    }
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 != null) {
      paramDrawable1 = cys.a(paramDrawable2);
    }
    paramDrawable2 = paramDrawable3;
    if (paramDrawable3 != null) {
      paramDrawable2 = cys.a(paramDrawable3);
    }
    paramDrawable3 = paramDrawable4;
    if (paramDrawable4 != null) {
      paramDrawable3 = cys.a(paramDrawable4);
    }
    super.setCompoundDrawablesRelative((Drawable)localObject, paramDrawable1, paramDrawable2, paramDrawable3);
    b();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
    b();
  }
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.NavigationBarButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */