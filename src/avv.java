import android.content.Context;
import android.os.AsyncTask;
import com.android.email.activity.setup.HeadlessAccountSettingsLoader;
import com.android.emailcommon.provider.Account;

public final class avv
  extends AsyncTask<Long, Void, Account>
{
  private final Context b;
  private final String c;
  
  public avv(HeadlessAccountSettingsLoader paramHeadlessAccountSettingsLoader, Context paramContext, String paramString)
  {
    b = paramContext;
    c = paramString;
  }
}

/* Location:
 * Qualified Name:     avv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */