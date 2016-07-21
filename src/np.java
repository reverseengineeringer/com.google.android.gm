import android.os.Build.VERSION;
import java.util.Locale;

public final class np
{
  public static final nq a;
  public static final Locale b;
  static String c;
  static String d;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17) {}
    for (a = new nr();; a = new nq())
    {
      b = new Locale("", "");
      c = "Arab";
      d = "Hebr";
      return;
    }
  }
}

/* Location:
 * Qualified Name:     np
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */