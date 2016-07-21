import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class hct<K, V>
  extends hcb<K, V>
{
  private static final long serialVersionUID = 0L;
  transient int c = 3;
  
  public hct()
  {
    super(new HashMap());
  }
  
  private final void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    c = 3;
    int k = paramObjectInputStream.readInt();
    Object localObject = hhk.c();
    a = ((Map)localObject);
    b = 0;
    localObject = ((Map)localObject).values().iterator();
    if (((Iterator)localObject).hasNext())
    {
      Collection localCollection = (Collection)((Iterator)localObject).next();
      if (!localCollection.isEmpty()) {}
      for (boolean bool = true;; bool = false)
      {
        hbe.a(bool);
        i = b;
        b = (localCollection.size() + i);
        break;
      }
    }
    int i = 0;
    while (i < k)
    {
      localObject = b(paramObjectInputStream.readObject());
      int m = paramObjectInputStream.readInt();
      int j = 0;
      while (j < m)
      {
        ((Collection)localObject).add(paramObjectInputStream.readObject());
        j += 1;
      }
      i += 1;
    }
  }
  
  private final void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(b().size());
    Iterator localIterator = b().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(((Map.Entry)localObject).getKey());
      paramObjectOutputStream.writeInt(((Collection)((Map.Entry)localObject).getValue()).size());
      localObject = ((Collection)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramObjectOutputStream.writeObject(((Iterator)localObject).next());
      }
    }
  }
  
  final List<V> a()
  {
    return new ArrayList(c);
  }
}

/* Location:
 * Qualified Name:     hct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */