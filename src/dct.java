import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ToggleButton;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;

public final class dct
  implements ViewTreeObserver.OnScrollChangedListener
{
  public dct(RichTextToolbar paramRichTextToolbar) {}
  
  public final void onScrollChanged()
  {
    RichTextToolbar localRichTextToolbar = a;
    if ((k != null) && ((k instanceof ToggleButton))) {
      ((ToggleButton)k).setChecked(false);
    }
  }
}

/* Location:
 * Qualified Name:     dct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */