import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v7.widget.ShareActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

public final class alz
  implements MenuItem.OnMenuItemClickListener
{
  public alz(ShareActionProvider paramShareActionProvider) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = afo.a(a.c, a.d).b(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      String str = paramMenuItem.getAction();
      if (("android.intent.action.SEND".equals(str)) || ("android.intent.action.SEND_MULTIPLE".equals(str)))
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label82;
        }
        paramMenuItem.addFlags(134742016);
      }
    }
    for (;;)
    {
      a.c.startActivity(paramMenuItem);
      return true;
      label82:
      paramMenuItem.addFlags(524288);
    }
  }
}

/* Location:
 * Qualified Name:     alz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */