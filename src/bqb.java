import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.android.emailcommon.provider.Account;

public abstract class bqb
  extends bqc
{
  public final Uri a;
  
  protected bqb(Context paramContext, Account paramAccount)
  {
    super(paramContext, paramAccount);
    paramContext = bdv.H.buildUpon();
    long l = D;
    a = paramContext.appendEncodedPath(46 + "vacationResponderSettings/" + l).build();
  }
}

/* Location:
 * Qualified Name:     bqb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */