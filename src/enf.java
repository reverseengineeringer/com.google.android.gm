import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

final class enf
{
  private final String a;
  private final ComponentName b;
  
  public enf(ComponentName paramComponentName)
  {
    a = null;
    b = ((ComponentName)enz.a(paramComponentName));
  }
  
  public enf(String paramString)
  {
    a = enz.a(paramString);
    b = null;
  }
  
  public final Intent a()
  {
    if (a != null) {
      return new Intent(a).setPackage("com.google.android.gms");
    }
    return new Intent().setComponent(b);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof enf)) {
        return false;
      }
      paramObject = (enf)paramObject;
    } while ((enx.a(a, a)) && (enx.a(b, b)));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { a, b });
  }
  
  public final String toString()
  {
    if (a == null) {
      return b.flattenToString();
    }
    return a;
  }
}

/* Location:
 * Qualified Name:     enf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */