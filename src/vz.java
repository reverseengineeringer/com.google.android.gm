import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class vz
{
  public static final wc a = new wb();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      a = new wa();
      return;
    }
    if (i >= 21)
    {
      a = new wd();
      return;
    }
  }
  
  public static Drawable a(CompoundButton paramCompoundButton)
  {
    return a.a(paramCompoundButton);
  }
}

/* Location:
 * Qualified Name:     vz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */