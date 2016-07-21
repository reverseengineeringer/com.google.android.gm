import android.widget.PopupWindow;
import java.lang.reflect.Field;

final class xs
{
  static Field a;
  
  static
  {
    try
    {
      Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
      a = localField;
      localField.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
  }
}

/* Location:
 * Qualified Name:     xs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */