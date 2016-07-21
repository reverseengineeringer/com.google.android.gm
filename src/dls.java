import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;

public final class dls
  extends dlb<hle, dlt>
{
  private static final String e = cvl.a;
  
  dls(Context paramContext, dkq paramdkq, dlt paramdlt)
  {
    super(paramContext, paramdkq, paramdlt);
  }
  
  public final dlc<hle> a(Bundle paramBundle)
  {
    return new dlu(b, c, (Account)paramBundle.getParcelable("gmailAccount"), paramBundle.getString("thirdPartyEmail"));
  }
}

/* Location:
 * Qualified Name:     dls
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */