import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;

public final class fwz
  extends elq
  implements fyb
{
  public fwz(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public final String b()
  {
    return c("account_name");
  }
  
  public final String c()
  {
    String str2 = c("display_name");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = c("account_name");
    }
    return str1;
  }
  
  public final String d()
  {
    return c("page_gaia_id");
  }
  
  @Deprecated
  public final String e()
  {
    return c("page_gaia_id");
  }
  
  public final String f()
  {
    return fxc.a.a(c("avatar"));
  }
  
  public final int g()
  {
    return b("last_sync_status");
  }
  
  public final int h()
  {
    return b("is_dasher");
  }
  
  public final String i()
  {
    return fxc.a.a(c("cover_photo_url"));
  }
}

/* Location:
 * Qualified Name:     fwz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */