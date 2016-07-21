import android.os.Bundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class fga<T>
  implements ffi<T>
{
  public final String a;
  private final Set<String> b;
  private final Set<String> c;
  private final int d;
  
  public fga(String paramString, int paramInt)
  {
    a = ((String)enz.a(paramString, "fieldName"));
    b = Collections.singleton(paramString);
    c = Collections.emptySet();
    d = paramInt;
  }
  
  public fga(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    a = ((String)enz.a(paramString, "fieldName"));
    b = Collections.unmodifiableSet(new HashSet(paramCollection1));
    c = Collections.unmodifiableSet(new HashSet(paramCollection2));
    d = paramInt;
  }
  
  public final T a(Bundle paramBundle)
  {
    enz.a(paramBundle, "bundle");
    if (paramBundle.get(a) != null) {
      return (T)b(paramBundle);
    }
    return null;
  }
  
  public final String a()
  {
    return a;
  }
  
  public abstract void a(Bundle paramBundle, T paramT);
  
  public final void a(T paramT, Bundle paramBundle)
  {
    enz.a(paramBundle, "bundle");
    if (paramT == null)
    {
      paramBundle.putString(a, null);
      return;
    }
    a(paramBundle, paramT);
  }
  
  public abstract T b(Bundle paramBundle);
  
  public String toString()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     fga
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */