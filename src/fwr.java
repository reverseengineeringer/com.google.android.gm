import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.people.model.AvatarReference;

public final class fwr
  extends elq
  implements fxz
{
  private final Bundle d;
  private final fxy e;
  
  public fwr(fxy paramfxy, DataHolder paramDataHolder, int paramInt, Bundle paramBundle)
  {
    super(paramDataHolder, paramInt);
    d = paramBundle;
    e = paramfxy;
  }
  
  public final String b()
  {
    return c("owner_account");
  }
  
  public final String c()
  {
    return c("person_key");
  }
  
  public final String d()
  {
    return c("gaia_id");
  }
  
  public final String e()
  {
    return c("contact_id");
  }
  
  public final long f()
  {
    return a("cp2_contact_id");
  }
  
  public final long g()
  {
    return a("cp2_data_id");
  }
  
  public final String h()
  {
    return c("display_name");
  }
  
  public final String i()
  {
    return c("value");
  }
  
  public final AvatarReference j()
  {
    String str = c("avatar_location");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return new AvatarReference(b("avatar_source"), str);
  }
}

/* Location:
 * Qualified Name:     fwr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */