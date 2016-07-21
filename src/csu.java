import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;

public final class csu
  extends csr
{
  Account d = null;
  cfg e;
  cod f;
  Folder g;
  int h = -1;
  private LoaderManager j;
  private boolean k;
  private final LoaderManager.LoaderCallbacks<ccy<Folder>> l = new csw(this);
  
  public csu(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(LoaderManager paramLoaderManager, Bundle paramBundle)
  {
    j = paramLoaderManager;
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    k = false;
    if ((j != null) && (paramFolder != null) && ((p & 0x10) > 0))
    {
      k = true;
      j.initLoader(8, null, l);
    }
  }
  
  public final void i()
  {
    e.b(h);
    super.i();
  }
  
  public final boolean n()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (h > 0)
    {
      bool1 = bool2;
      if (h != e.d.getInt("last-seen-outbox-count", 0)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean o()
  {
    return k;
  }
  
  protected final View.OnClickListener r()
  {
    return new csv(this);
  }
}

/* Location:
 * Qualified Name:     csu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */