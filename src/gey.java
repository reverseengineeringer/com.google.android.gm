import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class gey
  extends elq
  implements gdt
{
  private final int d;
  
  public gey(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    d = paramInt2;
  }
  
  public final Uri b()
  {
    return Uri.parse(c("path"));
  }
  
  public final byte[] c()
  {
    DataHolder localDataHolder = a;
    int i = b;
    int j = c;
    localDataHolder.a("data", i);
    return d[j].getBlob(i, c.getInt("data"));
  }
  
  public final String toString()
  {
    boolean bool = Log.isLoggable("DataItem", 3);
    Object localObject1 = c();
    Object localObject3 = new HashMap(d);
    int i = 0;
    while (i < d)
    {
      localObject2 = new gew(a, b + i);
      if (((gew)localObject2).c("asset_key") != null) {
        ((Map)localObject3).put(((gew)localObject2).c("asset_key"), localObject2);
      }
      i += 1;
    }
    Object localObject2 = new StringBuilder("DataItemInternal{ ");
    ((StringBuilder)localObject2).append("uri=" + b());
    Object localObject4 = new StringBuilder(", dataSz=");
    if (localObject1 == null) {}
    for (localObject1 = "null";; localObject1 = Integer.valueOf(localObject1.length))
    {
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", numAssets=" + ((Map)localObject3).size());
      if ((!bool) || (((Map)localObject3).isEmpty())) {
        break label325;
      }
      ((StringBuilder)localObject2).append(", assets=[");
      localObject3 = ((Map)localObject3).entrySet().iterator();
      for (localObject1 = ""; ((Iterator)localObject3).hasNext(); localObject1 = ", ")
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        ((StringBuilder)localObject2).append((String)localObject1 + (String)((Map.Entry)localObject4).getKey() + ": " + ((gdu)((Map.Entry)localObject4).getValue()).b());
      }
    }
    ((StringBuilder)localObject2).append("]");
    label325:
    ((StringBuilder)localObject2).append(" }");
    return ((StringBuilder)localObject2).toString();
  }
}

/* Location:
 * Qualified Name:     gey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */