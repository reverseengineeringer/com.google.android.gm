import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class aij
{
  public static final Rect a = new Rect();
  private static Class<?> b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      b = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
  }
  
  static PorterDuff.Mode a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return null;
      return PorterDuff.Mode.SRC_OVER;
      return PorterDuff.Mode.SRC_IN;
      return PorterDuff.Mode.SRC_ATOP;
      return PorterDuff.Mode.MULTIPLY;
      return PorterDuff.Mode.SCREEN;
    } while (Build.VERSION.SDK_INT < 11);
    return PorterDuff.Mode.valueOf("ADD");
  }
  
  public static Rect a(Drawable paramDrawable)
  {
    if (b != null) {}
    for (;;)
    {
      Object localObject;
      Rect localRect;
      int j;
      int i;
      try
      {
        paramDrawable = kn.f(paramDrawable);
        localObject = paramDrawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(paramDrawable, new Object[0]);
        if (localObject == null) {
          break label215;
        }
        localRect = new Rect();
        Field[] arrayOfField = b.getFields();
        int k = arrayOfField.length;
        j = 0;
        paramDrawable = localRect;
        if (j >= k) {
          break label219;
        }
        paramDrawable = arrayOfField[j];
        str = paramDrawable.getName();
        i = -1;
        switch (str.hashCode())
        {
        case 3317767: 
          if (!str.equals("left")) {
            break label263;
          }
          i = 0;
        }
      }
      catch (Exception paramDrawable)
      {
        String str;
        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
      }
      if (str.equals("top"))
      {
        i = 1;
        break label263;
        if (str.equals("right"))
        {
          i = 2;
          break label263;
          if (str.equals("bottom"))
          {
            i = 3;
            break label263;
            left = paramDrawable.getInt(localObject);
            break label296;
            label215:
            paramDrawable = a;
            label219:
            return paramDrawable;
            top = paramDrawable.getInt(localObject);
            break label296;
            right = paramDrawable.getInt(localObject);
            break label296;
            bottom = paramDrawable.getInt(localObject);
            break label296;
          }
        }
      }
      label263:
      switch (i)
      {
      }
      label296:
      j += 1;
    }
  }
  
  static void b(Drawable paramDrawable)
  {
    int[] arrayOfInt;
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())))
    {
      arrayOfInt = paramDrawable.getState();
      if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
        break label52;
      }
      paramDrawable.setState(amj.e);
    }
    for (;;)
    {
      paramDrawable.setState(arrayOfInt);
      return;
      label52:
      paramDrawable.setState(amj.h);
    }
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    for (;;)
    {
      if ((paramDrawable instanceof LayerDrawable)) {
        return Build.VERSION.SDK_INT >= 16;
      }
      if ((paramDrawable instanceof InsetDrawable)) {
        return Build.VERSION.SDK_INT >= 14;
      }
      if ((paramDrawable instanceof StateListDrawable)) {
        return Build.VERSION.SDK_INT >= 8;
      }
      if ((paramDrawable instanceof GradientDrawable)) {
        return Build.VERSION.SDK_INT >= 14;
      }
      if ((paramDrawable instanceof DrawableContainer))
      {
        paramDrawable = paramDrawable.getConstantState();
        if (!(paramDrawable instanceof DrawableContainer.DrawableContainerState)) {
          break;
        }
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        int i = 0;
        while (i < j)
        {
          if (!c(paramDrawable[i])) {
            return false;
          }
          i += 1;
        }
      }
      if ((paramDrawable instanceof kx))
      {
        paramDrawable = ((kx)paramDrawable).a();
      }
      else if ((paramDrawable instanceof acq))
      {
        paramDrawable = m;
      }
      else
      {
        if (!(paramDrawable instanceof ScaleDrawable)) {
          break;
        }
        paramDrawable = ((ScaleDrawable)paramDrawable).getDrawable();
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     aij
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */