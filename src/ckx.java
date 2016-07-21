import android.app.Activity;
import android.content.AsyncTaskLoader;
import android.net.Uri;
import com.android.mail.providers.Account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ckx
  extends AsyncTaskLoader<bwg>
{
  private static final ArrayList<ckx> h = new ArrayList();
  private final Uri a;
  private final bwg b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private final String g;
  
  public ckx(Activity paramActivity, Account paramAccount, Uri paramUri, String paramString, boolean paramBoolean)
  {
    super(paramActivity);
    a = paramUri;
    g = paramString;
    if (paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = paramAccount.a(262144L))
    {
      b = new bwg(paramActivity, a, paramBoolean, paramString);
      return;
    }
  }
  
  private final bwg a()
  {
    if (!c)
    {
      b.c();
      c = true;
    }
    return b;
  }
  
  public final void onReset()
  {
    if (!e)
    {
      bwg localbwg = b;
      localbwg.close();
      e.clear();
      g.clear();
      c = null;
      d = true;
    }
  }
  
  protected final void onStartLoading()
  {
    if (d)
    {
      d = false;
      b.c();
    }
    for (;;)
    {
      forceLoad();
      bwg localbwg = b;
      m = false;
      localbwg.d();
      return;
      if (f) {
        f = false;
      }
    }
  }
  
  protected final void onStopLoading()
  {
    cancelLoad();
    b.m = true;
  }
}

/* Location:
 * Qualified Name:     ckx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */