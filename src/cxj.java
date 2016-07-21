import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.RemoteViews;
import com.android.mail.providers.Account;

public final class cxj
  extends AsyncTask<Void, Void, Boolean>
{
  private Context a;
  private RemoteViews b;
  private int c;
  private Account d;
  private int e;
  private int f;
  private Uri g;
  private Uri h;
  private String i;
  
  public cxj(Context paramContext, RemoteViews paramRemoteViews, int paramInt1, Account paramAccount, int paramInt2, int paramInt3, Uri paramUri1, Uri paramUri2, String paramString)
  {
    a = paramContext;
    b = paramRemoteViews;
    c = paramInt1;
    d = paramAccount;
    e = paramInt2;
    f = paramInt3;
    g = paramUri1;
    h = paramUri2;
    i = paramString;
  }
}

/* Location:
 * Qualified Name:     cxj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */