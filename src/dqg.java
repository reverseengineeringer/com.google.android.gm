import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dqg
  implements Serializable
{
  static final long serialVersionUID = 1L;
  public long a;
  public long b;
  public Set<String> c;
  public Set<String> d;
  private transient BitSet e = new BitSet();
  
  public static void a(JSONObject paramJSONObject, String paramString, Collection<String> paramCollection)
  {
    if (paramJSONObject.has(paramString))
    {
      paramJSONObject = paramJSONObject.getJSONArray(paramString);
      int i = 0;
      int j = paramJSONObject.length();
      while (i < j)
      {
        paramCollection.add(paramJSONObject.getString(i));
        i += 1;
      }
    }
  }
  
  private final BitSet i()
  {
    if (e == null) {
      e = new BitSet();
    }
    return e;
  }
  
  private final void readObject(ObjectInputStream paramObjectInputStream)
  {
    a = paramObjectInputStream.readLong();
    b = paramObjectInputStream.readLong();
    c = hio.a((String[])paramObjectInputStream.readObject());
    d = hio.a((String[])paramObjectInputStream.readObject());
  }
  
  private final void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeLong(a);
    paramObjectOutputStream.writeLong(b);
    paramObjectOutputStream.writeObject((String[])c.toArray(new String[c.size()]));
    paramObjectOutputStream.writeObject((String[])d.toArray(new String[d.size()]));
  }
  
  public final long a()
  {
    try
    {
      long l = a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(long paramLong)
  {
    try
    {
      if (paramLong != a)
      {
        i().set(1);
        a = paramLong;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(Collection<String> paramCollection)
  {
    try
    {
      paramCollection = new HashSet(paramCollection);
      if (!paramCollection.equals(c))
      {
        i().set(3);
        c = paramCollection;
      }
      return;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public final long b()
  {
    try
    {
      long l = b;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(long paramLong)
  {
    try
    {
      if (paramLong != b)
      {
        i().set(2);
        b = paramLong;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(Collection<String> paramCollection)
  {
    try
    {
      paramCollection = new HashSet(paramCollection);
      if (!paramCollection.equals(d))
      {
        i().set(4);
        d = paramCollection;
      }
      return;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public final List<String> c()
  {
    try
    {
      hef localhef = hef.a((String[])c.toArray(new String[c.size()]));
      return localhef;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final List<String> d()
  {
    try
    {
      hef localhef = hef.a((String[])d.toArray(new String[d.size()]));
      return localhef;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final boolean e()
  {
    try
    {
      boolean bool = i().get(1);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final boolean f()
  {
    try
    {
      boolean bool = i().get(2);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final boolean g()
  {
    try
    {
      boolean bool = i().get(3);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final boolean h()
  {
    try
    {
      boolean bool = i().get(4);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String toString()
  {
    String str1 = null;
    long l1 = a;
    long l2 = b;
    String str2;
    if (c == null)
    {
      localObject = null;
      str2 = String.valueOf(localObject);
      if (d != null) {
        break label170;
      }
    }
    label170:
    for (Object localObject = str1;; localObject = Arrays.asList(new Set[] { d }))
    {
      localObject = String.valueOf(localObject);
      str1 = String.valueOf(i());
      return String.valueOf(str2).length() + 142 + String.valueOf(localObject).length() + String.valueOf(str1).length() + "Settings{mConversationAgeDays=" + l1 + ", mMaxAttachmentSizeMb=" + l2 + ", mLabelsIncluded=" + str2 + ", mLabelsPartial=" + (String)localObject + ", mDirtyBits=" + str1 + "}";
      localObject = Arrays.asList(new Set[] { c });
      break;
    }
  }
}

/* Location:
 * Qualified Name:     dqg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */