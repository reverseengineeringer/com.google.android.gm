import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ToggleButton;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;

public final class dcs
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public dcs(RichTextToolbar paramRichTextToolbar) {}
  
  public final void onGlobalLayout()
  {
    RichTextToolbar localRichTextToolbar = a;
    if ((k != null) && ((k instanceof ToggleButton))) {
      ((ToggleButton)k).setChecked(false);
    }
  }
}

/* Location:
 * Qualified Name:     dcs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */