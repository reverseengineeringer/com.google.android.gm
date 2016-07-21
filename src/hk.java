import android.app.Notification;
import android.os.Parcelable;
import java.util.ArrayList;

class hk
  extends hr
{
  public Notification a(hf paramhf)
  {
    hv localhv = new hv(a, B, b, c, h, f, i, d, e, g, o, p, q, k, l, j, n, v, C, x, r, s, t);
    gz.a(localhv, u);
    gz.a(localhv, m);
    return localhv.b();
  }
  
  public final ArrayList<Parcelable> a(ha[] paramArrayOfha)
  {
    Object localObject;
    if (paramArrayOfha == null)
    {
      localObject = null;
      return (ArrayList<Parcelable>)localObject;
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfha.length);
    int j = paramArrayOfha.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(hu.a(paramArrayOfha[i]));
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     hk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */