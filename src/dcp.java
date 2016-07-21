import android.graphics.Rect;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ActionMode.Callback2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.apps.work.common.richedittext.RichEditText;

public final class dcp
  extends ActionMode.Callback2
{
  private dco b;
  
  public dcp(RichEditText paramRichEditText, ActionMode.Callback paramCallback)
  {
    b = new dco(paramRichEditText, paramCallback);
  }
  
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return b.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return b.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public final void onDestroyActionMode(ActionMode paramActionMode)
  {
    b.onDestroyActionMode(paramActionMode);
  }
  
  public final void onGetContentRect(ActionMode paramActionMode, View paramView, Rect paramRect)
  {
    ActionMode.Callback localCallback = b.a;
    if ((localCallback instanceof ActionMode.Callback2)) {
      ((ActionMode.Callback2)localCallback).onGetContentRect(paramActionMode, paramView, paramRect);
    }
  }
  
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return b.onPrepareActionMode(paramActionMode, paramMenu);
  }
}

/* Location:
 * Qualified Name:     dcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */