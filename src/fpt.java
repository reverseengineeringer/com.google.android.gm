import android.util.Log;
import com.google.android.gms.people.model.AvatarReference;

public final class fpt
  implements fre
{
  public final ejh<frh> a(eiz parameiz, AvatarReference paramAvatarReference, frf paramfrf)
  {
    if (Log.isLoggable("PeopleClientCall", 3)) {
      fxb.a("loadByReference", new Object[] { paramAvatarReference, paramfrf });
    }
    return parameiz.a(new fpw(this, parameiz, paramAvatarReference, paramfrf));
  }
  
  public final ejh<frh> a()
  {
    String str1;
    String str2;
    if (Log.isLoggable("PeopleClientCall", 3)) {
      fxb.a("loadOwnerCoverPhoto", new Object[] { str1, str2 });
    }
    eiz localeiz;
    return localeiz.a(new fpv(this, localeiz, str1, str2));
  }
  
  public final ejh<frh> a(eiz parameiz, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (Log.isLoggable("PeopleClientCall", 3)) {
      fxb.a("loadOwnerAvatar", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    return parameiz.a(new fpu(this, parameiz, paramString1, paramString2, paramInt1, paramInt2));
  }
}

/* Location:
 * Qualified Name:     fpt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */