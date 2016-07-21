import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

final class hgy<K, V>
  extends hgm<K, V>
{
  private static final long serialVersionUID = 3L;
  
  hgy(hgz paramhgz1, hgz paramhgz2, has<Object> paramhas1, has<Object> paramhas2, int paramInt, ConcurrentMap<K, V> paramConcurrentMap)
  {
    super(paramhgz1, paramhgz2, paramhas1, paramhas2, paramInt, paramConcurrentMap);
  }
  
  private final void readObject(ObjectInputStream paramObjectInputStream)
  {
    boolean bool2 = true;
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    Object localObject1 = new hgi();
    label49:
    Object localObject2;
    if (b == -1)
    {
      bool1 = true;
      hbe.a(bool1, "initial capacity was already set to %s", b);
      if (i < 0) {
        break label305;
      }
      bool1 = true;
      hbe.a(bool1);
      b = i;
      localObject2 = a;
      if (d != null) {
        break label310;
      }
      bool1 = true;
      label75:
      hbe.b(bool1, "Key strength was already set to %s", d);
      d = ((hgz)hbe.a(localObject2));
      if (localObject2 != hgz.a) {
        a = true;
      }
      localObject2 = b;
      if (e != null) {
        break label315;
      }
      bool1 = true;
      label129:
      hbe.b(bool1, "Value strength was already set to %s", e);
      e = ((hgz)hbe.a(localObject2));
      if (localObject2 != hgz.a) {
        a = true;
      }
      localObject2 = c;
      if (f != null) {
        break label320;
      }
      bool1 = true;
      label183:
      hbe.b(bool1, "key equivalence was already set to %s", f);
      f = ((has)hbe.a(localObject2));
      a = true;
      i = e;
      if (c != -1) {
        break label325;
      }
      bool1 = true;
      label229:
      hbe.a(bool1, "concurrency level was already set to %s", c);
      if (i <= 0) {
        break label330;
      }
    }
    label305:
    label310:
    label315:
    label320:
    label325:
    label330:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hbe.a(bool1);
      c = i;
      f = ((hgi)localObject1).d();
      for (;;)
      {
        localObject1 = paramObjectInputStream.readObject();
        if (localObject1 == null) {
          break;
        }
        localObject2 = paramObjectInputStream.readObject();
        f.put(localObject1, localObject2);
      }
      bool1 = false;
      break;
      bool1 = false;
      break label49;
      bool1 = false;
      break label75;
      bool1 = false;
      break label129;
      bool1 = false;
      break label183;
      bool1 = false;
      break label229;
    }
  }
  
  private final Object readResolve()
  {
    return f;
  }
  
  private final void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(f.size());
    Iterator localIterator = f.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
    paramObjectOutputStream.writeObject(null);
  }
}

/* Location:
 * Qualified Name:     hgy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */