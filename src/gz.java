import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public final class gz
{
  static final hj a = new hm();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      a = new hl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      a = new hk();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new hr();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      a = new hq();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new hp();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new ho();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      a = new hn();
      return;
    }
  }
  
  static void a(gx paramgx, ArrayList<ha> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      paramgx.a((ha)paramArrayList.next());
    }
  }
  
  static void a(gy paramgy, hs paramhs)
  {
    if (paramhs != null)
    {
      if (!(paramhs instanceof he)) {
        break label37;
      }
      paramhs = (he)paramhs;
      id.a(paramgy, e, g, f, a);
    }
    label37:
    do
    {
      return;
      if ((paramhs instanceof hi))
      {
        paramhs = (hi)paramhs;
        id.a(paramgy, e, g, f, a);
        return;
      }
    } while (!(paramhs instanceof hd));
    paramhs = (hd)paramhs;
    id.a(paramgy, e, g, f, a, b, c);
  }
}

/* Location:
 * Qualified Name:     gz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */