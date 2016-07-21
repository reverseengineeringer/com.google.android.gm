import android.net.Uri.Builder;

public final class awy
  extends awu
{
  public final Uri.Builder a(bcb parambcb, String paramString)
  {
    Uri.Builder localBuilder = super.a(parambcb, paramString);
    localBuilder.appendQueryParameter("scope", i);
    if (paramString != null) {
      localBuilder.appendQueryParameter("login_hint", paramString);
    }
    return localBuilder;
  }
}

/* Location:
 * Qualified Name:     awy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */