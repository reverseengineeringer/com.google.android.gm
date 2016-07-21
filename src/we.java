import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

final class we
{
  private static Field a;
  private static boolean b;
  
  static Drawable a(CompoundButton paramCompoundButton)
  {
    if (!b) {}
    try
    {
      Field localField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      a = localField;
      localField.setAccessible(true);
      b = true;
      if (a != null) {
        try
        {
          paramCompoundButton = (Drawable)a.get(paramCompoundButton);
          return paramCompoundButton;
        }
        catch (IllegalAccessException paramCompoundButton)
        {
          a = null;
        }
      }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     we
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */