import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class bya
  implements MenuItem.OnMenuItemClickListener
{
  private final CharSequence b;
  
  public bya(bxz parambxz, CharSequence paramCharSequence)
  {
    b = paramCharSequence;
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = a;
    CharSequence localCharSequence = b;
    ((ClipboardManager)a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, localCharSequence));
    return true;
  }
}

/* Location:
 * Qualified Name:     bya
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */