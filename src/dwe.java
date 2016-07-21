import android.content.Context;
import android.os.Bundle;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public final class dwe
  implements dwd
{
  private static final String a = cvl.a;
  
  public final void a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (paramContext = Collections.emptySet();; paramContext = paramBundle.keySet())
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        paramBundle = (String)paramContext.next();
        cvm.b(a, "Key %s is present", new Object[] { paramBundle });
      }
    }
  }
}

/* Location:
 * Qualified Name:     dwe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */