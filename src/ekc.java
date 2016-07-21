import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class ekc
  extends ekh
{
  private final Map<eit, ejd> c;
  
  public ekc(Map<eit, ejd> paramMap)
  {
    super(paramMap);
    Map localMap;
    c = localMap;
  }
  
  public final void a()
  {
    int i = eih.a(a.c);
    Object localObject;
    if (i != 0)
    {
      localObject = new ConnectionResult(i, null);
      a.a.a(new ekd(this, a, (ConnectionResult)localObject));
    }
    for (;;)
    {
      return;
      if (a.e) {
        a.d.n();
      }
      localObject = c.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        eit localeit = (eit)((Iterator)localObject).next();
        localeit.a((ejd)c.get(localeit));
      }
    }
  }
}

/* Location:
 * Qualified Name:     ekc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */