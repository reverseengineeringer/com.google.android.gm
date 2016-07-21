import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;

public final class bxz
  implements View.OnCreateContextMenuListener
{
  private static final int c = buc.cv;
  private static final int d = buc.aN;
  final Context a;
  public CharSequence b;
  
  public bxz(Context paramContext)
  {
    a = paramContext;
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (!TextUtils.isEmpty(b))
    {
      new MenuInflater(a).inflate(buf.g, paramContextMenu);
      paramContextMenu.setHeaderTitle(b);
      paramView = paramContextMenu.findItem(c);
      paramContextMenuInfo = String.valueOf("mailto:");
      String str = String.valueOf(b);
      paramView.setIntent(new Intent("android.intent.action.VIEW", Uri.parse(String.valueOf(paramContextMenuInfo).length() + 0 + String.valueOf(str).length() + paramContextMenuInfo + str)));
      paramContextMenu.findItem(d).setOnMenuItemClickListener(new bya(this, b));
    }
  }
}

/* Location:
 * Qualified Name:     bxz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */