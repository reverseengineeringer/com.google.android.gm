import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class dwi
  implements dwd
{
  final Set<dwd> a = new HashSet();
  
  public final void a(Context paramContext, Bundle paramBundle)
  {
    Iterator localIterator = a.iterator();
    if (localIterator.hasNext())
    {
      dwd localdwd = (dwd)localIterator.next();
      if (paramBundle == null) {}
      for (Bundle localBundle = null;; localBundle = new Bundle(paramBundle))
      {
        localdwd.a(paramContext, localBundle);
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     dwi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */