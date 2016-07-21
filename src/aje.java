import android.support.v7.widget.GridLayout;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public final class aje<K, V>
{
  public final int[] a;
  public final K[] b;
  public final V[] c;
  
  aje(K[] paramArrayOfK, V[] paramArrayOfV)
  {
    a = a(paramArrayOfK);
    b = a(paramArrayOfK, a);
    c = a(paramArrayOfV, a);
  }
  
  private static <K> int[] a(K[] paramArrayOfK)
  {
    int j = paramArrayOfK.length;
    int[] arrayOfInt = new int[j];
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < j)
    {
      K ? = paramArrayOfK[i];
      Integer localInteger2 = (Integer)localHashMap.get(?);
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null)
      {
        localInteger1 = Integer.valueOf(localHashMap.size());
        localHashMap.put(?, localInteger1);
      }
      arrayOfInt[i] = localInteger1.intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static <K> K[] a(K[] paramArrayOfK, int[] paramArrayOfInt)
  {
    int j = paramArrayOfK.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfK.getClass().getComponentType(), GridLayout.a(paramArrayOfInt) + 1);
    int i = 0;
    while (i < j)
    {
      arrayOfObject[paramArrayOfInt[i]] = paramArrayOfK[i];
      i += 1;
    }
    return arrayOfObject;
  }
  
  public final V a(int paramInt)
  {
    return (V)c[a[paramInt]];
  }
}

/* Location:
 * Qualified Name:     aje
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */