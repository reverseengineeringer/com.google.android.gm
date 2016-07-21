import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class ux
{
  private static final uy b = new vd();
  public final Object a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      b = new vb();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      b = new uz();
      return;
    }
  }
  
  public ux()
  {
    a = b.a(this);
  }
  
  public ux(Object paramObject)
  {
    a = paramObject;
  }
  
  public static List<uk> a(String paramString, int paramInt)
  {
    return null;
  }
  
  public static uk b()
  {
    return null;
  }
  
  public uk a(int paramInt)
  {
    return null;
  }
  
  public boolean a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ux
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */