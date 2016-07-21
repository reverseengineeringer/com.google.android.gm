import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class pq
{
  public static final pr a = new ps();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new pu();
      return;
    }
    if (i >= 11)
    {
      a = new pt();
      return;
    }
  }
  
  public static void a(LayoutInflater paramLayoutInflater, pz parampz)
  {
    a.a(paramLayoutInflater, parampz);
  }
}

/* Location:
 * Qualified Name:     pq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */