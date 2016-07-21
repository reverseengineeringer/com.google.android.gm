import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.android.email.provider.EmailProvider;

public final class aza
  implements ComponentCallbacks
{
  public aza(EmailProvider paramEmailProvider, Configuration paramConfiguration) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Configuration.needNewResources(a.updateFrom(paramConfiguration), 4)) {
      b.b(268435456L);
    }
  }
  
  public final void onLowMemory() {}
}

/* Location:
 * Qualified Name:     aza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */