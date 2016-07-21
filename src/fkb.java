import android.os.Bundle;
import android.os.Parcel;
import java.util.Iterator;
import java.util.Set;

public class fkb
{
  public int c;
  public String d;
  public String e;
  public boolean f;
  public boolean g;
  public boolean h;
  public Bundle i;
  
  protected void a()
  {
    if (d != null) {}
    Bundle localBundle;
    int j;
    for (boolean bool = true;; bool = false)
    {
      enz.b(bool, "Must provide an endpoint for this task by calling setService(ComponentName).");
      fjs.a(e);
      if (!g) {
        return;
      }
      localBundle = i;
      if (localBundle == null) {
        return;
      }
      localObject1 = Parcel.obtain();
      localBundle.writeToParcel((Parcel)localObject1, 0);
      j = ((Parcel)localObject1).dataSize();
      if (j <= 10240) {
        break;
      }
      ((Parcel)localObject1).recycle();
      throw new IllegalArgumentException("Extras exceeding maximum size(10240 bytes): " + j);
    }
    ((Parcel)localObject1).recycle();
    Object localObject1 = localBundle.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = localBundle.get((String)((Iterator)localObject1).next());
      if (((localObject2 instanceof Integer)) || ((localObject2 instanceof Long)) || ((localObject2 instanceof Double)) || ((localObject2 instanceof String)) || ((localObject2 instanceof Boolean))) {}
      for (j = 1; j == 0; j = 0) {
        throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
      }
    }
  }
}

/* Location:
 * Qualified Name:     fkb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */