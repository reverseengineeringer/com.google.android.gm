import android.content.res.Resources;
import android.content.res.TypedArray;

public class buz
  implements buy
{
  private final TypedArray a;
  private final int b;
  private final int c;
  
  public buz(Resources paramResources)
  {
    this(paramResources, btw.d);
  }
  
  public buz(Resources paramResources, int paramInt)
  {
    a = paramResources.obtainTypedArray(paramInt);
    b = a.length();
    c = paramResources.getColor(btz.w);
  }
  
  public int a(String paramString)
  {
    if (b > 0)
    {
      int i = Math.abs(paramString.hashCode());
      int j = b;
      return a.getColor(i % j, c);
    }
    return c;
  }
}

/* Location:
 * Qualified Name:     buz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */