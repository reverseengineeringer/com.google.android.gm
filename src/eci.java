import android.os.Bundle;
import com.google.android.gms.appdatasearch.SearchResults;
import java.util.HashMap;
import java.util.Map;

public final class eci
{
  public final int a;
  private final ecj c;
  
  eci(SearchResults paramSearchResults, int paramInt, ecj paramecj)
  {
    c = paramecj;
    a = paramInt;
  }
  
  public final String a(String paramString)
  {
    Object localObject2 = c.b[b.i[a]];
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = c.b;
      int i = b.i[a];
      localObject2 = new HashMap();
      localObject1[i] = localObject2;
    }
    for (;;)
    {
      Object localObject3 = (eck)((Map)localObject2).get(paramString);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = b.f[b.i[a]].getIntArray(paramString);
        localObject3 = b.g[b.i[a]].getByteArray(paramString);
        if ((localObject1 != null) && (localObject3 != null)) {
          break label151;
        }
        localObject1 = null;
      }
      while (localObject1 == null)
      {
        return null;
        label151:
        localObject1 = new eck((int[])localObject1, (byte[])localObject3);
        ((Map)localObject2).put(paramString, localObject1);
      }
      return ((eck)localObject1).a(a);
    }
  }
}

/* Location:
 * Qualified Name:     eci
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */