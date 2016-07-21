import android.content.res.Configuration;
import android.content.res.Resources;

public final class epc
{
  public static boolean a(Resources paramResources)
  {
    if (paramResources == null) {}
    label81:
    label86:
    label89:
    for (;;)
    {
      return false;
      int i;
      if ((getConfigurationscreenLayout & 0xF) > 3)
      {
        i = 1;
        if ((!epf.a(11)) || (i == 0))
        {
          paramResources = paramResources.getConfiguration();
          if (!epf.a(13)) {
            break label86;
          }
          if (((screenLayout & 0xF) > 3) || (smallestScreenWidthDp < 600)) {
            break label81;
          }
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label89;
        }
        return true;
        i = 0;
        break;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
}

/* Location:
 * Qualified Name:     epc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */