import android.content.res.Configuration;
import android.content.res.Resources;
import android.webkit.WebSettings;

public final class ctx
{
  public static void a(Resources paramResources, WebSettings paramWebSettings)
  {
    float f = getConfigurationfontScale;
    int i = paramResources.getInteger(bud.b);
    int j = paramResources.getInteger(bud.e);
    paramWebSettings.setTextZoom((int)(f * (i * paramWebSettings.getTextZoom() / j)));
  }
}

/* Location:
 * Qualified Name:     ctx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */