import android.content.Context;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

public final class btd
{
  public final Context a;
  public final String b;
  public long c;
  public final boolean d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  public final List<bte> h = new ArrayList();
  public int i;
  public boolean j;
  private final long k;
  
  public btd(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a = paramContext;
    b = paramString;
    k = SystemClock.elapsedRealtime();
    d = false;
    e = paramBoolean1;
    i = 0;
    f = paramBoolean2;
    g = paramBoolean3;
  }
  
  public final long a()
  {
    return c - k;
  }
}

/* Location:
 * Qualified Name:     btd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */