import android.util.Log;

public final class fpl
  implements fqv
{
  public final ejh<fqy> a(eiz parameiz, String paramString, fqw paramfqw)
  {
    enz.a(paramfqw);
    if (Log.isLoggable("PeopleClientCall", 3)) {
      fxb.a("loadAutocompleteList", new Object[] { paramString, paramfqw });
    }
    return parameiz.a(new fpm(this, parameiz, paramString, paramfqw));
  }
}

/* Location:
 * Qualified Name:     fpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */