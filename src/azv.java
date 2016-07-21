import android.content.Context;
import android.os.Handler;
import java.util.HashMap;
import java.util.Map;

public class azv
{
  public static final String a = cvl.a;
  private static azv f = null;
  public final Handler b;
  boolean c = false;
  public final Map<Long, Boolean> d = new HashMap();
  final Context e;
  
  private azv(Context paramContext)
  {
    e = paramContext;
    b = new Handler(e.getMainLooper());
    cwr.a(new azw(this));
  }
  
  public static azv a(Context paramContext)
  {
    try
    {
      if (f == null) {
        f = new azv(paramContext.getApplicationContext());
      }
      return f;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     azv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */