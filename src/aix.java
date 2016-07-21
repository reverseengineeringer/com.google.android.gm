import android.util.Pair;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class aix<K, V>
  extends ArrayList<Pair<K, V>>
{
  private final Class<K> a;
  private final Class<V> b;
  
  private aix(Class<K> paramClass, Class<V> paramClass1)
  {
    a = paramClass;
    b = paramClass1;
  }
  
  public static <K, V> aix<K, V> a(Class<K> paramClass, Class<V> paramClass1)
  {
    return new aix(paramClass, paramClass1);
  }
  
  public final aje<K, V> a()
  {
    int j = size();
    Object[] arrayOfObject1 = (Object[])Array.newInstance(a, j);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(b, j);
    int i = 0;
    while (i < j)
    {
      arrayOfObject1[i] = getfirst;
      arrayOfObject2[i] = getsecond;
      i += 1;
    }
    return new aje(arrayOfObject1, arrayOfObject2);
  }
  
  public final void a(K paramK, V paramV)
  {
    add(Pair.create(paramK, paramV));
  }
}

/* Location:
 * Qualified Name:     aix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */