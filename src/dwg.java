import android.content.Context;
import android.content.RestrictionEntry;
import android.os.AsyncTask;
import android.os.Bundle;
import java.util.List;

final class dwg
  implements dwc
{
  dwg(dwf paramdwf) {}
  
  public final void a(Context paramContext, List<RestrictionEntry> paramList, Bundle paramBundle, Class<? extends Context> paramClass)
  {
    if (paramList == null) {
      return;
    }
    a.b.a(paramContext, paramBundle);
    new dwh(a, paramContext, paramBundle, paramClass).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}

/* Location:
 * Qualified Name:     dwg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */