import android.util.Log;

public final class fqf
  implements frt
{
  public final ejh<ejk> a(eiz parameiz, String paramString1, String paramString2)
  {
    if (Log.isLoggable("PeopleClientCall", 3)) {
      fxb.a("requestSync", new Object[] { paramString1, paramString2 });
    }
    return parameiz.a(new fqg(this, parameiz, paramString1, paramString2, 0L, false, false));
  }
}

/* Location:
 * Qualified Name:     fqf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */