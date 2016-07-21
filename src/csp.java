import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.android.mail.providers.Folder;

public final class csp
  extends csr
{
  public static final String d = cvl.a;
  com.android.mail.providers.Account e = null;
  cfg f;
  Activity g;
  int h = 0;
  private Folder j = null;
  private final cfm k;
  
  public csp(Context paramContext)
  {
    super(paramContext);
    k = cfm.a(paramContext);
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    j = paramFolder;
  }
  
  public final void i()
  {
    Object localObject;
    switch (h)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      buo.a().a("list_swipe", "sync_disabled_tip", (String)localObject, 0L);
      super.i();
      return;
      localObject = k;
      int i = d.getInt("num-of-dismisses-auto-sync-off", 0);
      e.putInt("num-of-dismisses-auto-sync-off", i + 1).apply();
      localObject = "auto_sync_off";
      continue;
      localObject = f;
      i = d.getInt("num-of-dismisses-account-sync-off", 0);
      e.putInt("num-of-dismisses-account-sync-off", i + 1).apply();
      localObject = "account_sync_off";
    }
  }
  
  public final boolean n()
  {
    if ((e == null) || (e.G == null)) {}
    label17:
    label77:
    do
    {
      do
      {
        return false;
      } while ((j == null) || (j.g <= 0));
      Object localObject2 = k;
      Object localObject1 = e;
      cfg localcfg = f;
      int i;
      if (!ContentResolver.getMasterSyncAutomatically())
      {
        localcfg.c();
        cvm.c(d, "getMasterSyncAutomatically() return false", new Object[0]);
        i = 1;
        if (h != i)
        {
          h = i;
          localObject1 = getResources();
          switch (h)
          {
          }
        }
      }
      for (;;)
      {
        if (h != 0) {
          cvm.c(d, "Sync is off with reason %d", new Object[] { Integer.valueOf(h) });
        }
        switch (h)
        {
        default: 
          return false;
        case 1: 
          if (k.d.getInt("num-of-dismisses-auto-sync-off", 0) != 0) {
            break label17;
          }
          return true;
          if (d.getInt("num-of-dismisses-auto-sync-off", 0) != 0) {
            e.putInt("num-of-dismisses-auto-sync-off", 0).apply();
          }
          localObject2 = ((com.android.mail.providers.Account)localObject1).c();
          if ((!TextUtils.isEmpty(G)) && (!ContentResolver.getSyncAutomatically((android.accounts.Account)localObject2, G)))
          {
            i = 2;
            break label77;
          }
          localcfg.c();
          i = 0;
          break label77;
          a(((Resources)localObject1).getString(buj.J));
          continue;
          localObject1 = new SpannableString(Html.fromHtml(((Resources)localObject1).getString(buj.d)));
          cwt.a((Spannable)localObject1, null);
          a((CharSequence)localObject1);
        }
      }
    } while (f.d.getInt("num-of-dismisses-account-sync-off", 0) != 0);
    return true;
  }
  
  public final boolean o()
  {
    return false;
  }
  
  protected final View.OnClickListener r()
  {
    return new csq(this);
  }
}

/* Location:
 * Qualified Name:     csp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */