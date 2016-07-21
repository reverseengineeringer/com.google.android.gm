import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

public final class dwx
  extends ckt
{
  private final eiz c;
  private final String d;
  
  public dwx(Context paramContext, eiz parameiz, String paramString)
  {
    super(paramContext);
    c = parameiz;
    d = paramString;
  }
  
  public final Loader<hel<String, btn>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new dxr(b, c, d, a);
  }
}

/* Location:
 * Qualified Name:     dwx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */