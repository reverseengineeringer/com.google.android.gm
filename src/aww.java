import android.net.Uri.Builder;

public final class aww
  extends awu
{
  public final Uri.Builder a(bcb parambcb, String paramString)
  {
    Uri.Builder localBuilder = super.a(parambcb, paramString);
    localBuilder.appendQueryParameter("scope", i);
    localBuilder.appendQueryParameter("state", l);
    if (paramString != null) {
      localBuilder.appendQueryParameter("login_hint", paramString);
    }
    return localBuilder;
  }
}

/* Location:
 * Qualified Name:     aww
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */