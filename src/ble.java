import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.android.ex.editstyledtext.EditStyledText;

public final class ble
  implements MenuItem.OnMenuItemClickListener
{
  public ble(EditStyledText paramEditStyledText) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return a.onTextContextMenuItem(paramMenuItem.getItemId());
  }
}

/* Location:
 * Qualified Name:     ble
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */