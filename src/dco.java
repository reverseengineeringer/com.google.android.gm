import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.apps.work.common.richedittext.RichEditText;

public final class dco
  implements ActionMode.Callback
{
  ActionMode.Callback a;
  
  public dco(RichEditText paramRichEditText, ActionMode.Callback paramCallback)
  {
    a = paramCallback;
  }
  
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramMenuItem.getItemId() == 1) && (b.b != null))
    {
      dcm localdcm = b.b;
      if (!b.b.b())
      {
        bool1 = true;
        localdcm.b(bool1);
        if (b.b.b()) {
          paramActionMode.invalidate();
        }
        b.a(paramActionMode);
        b.b.c();
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        bool1 = bool2;
        if (!a.onActionItemClicked(paramActionMode, paramMenuItem)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    boolean bool = false;
    if (b.b != null)
    {
      MenuItem localMenuItem = paramMenu.add(0, 1, 0, dcj.l);
      if (b.e)
      {
        i = dcg.a;
        localMenuItem.setIcon(i).setShowAsAction(6);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((a.onCreateActionMode(paramActionMode, paramMenu)) || (i != 0)) {
        bool = true;
      }
      return bool;
      i = dcg.b;
      break;
    }
  }
  
  public final void onDestroyActionMode(ActionMode paramActionMode)
  {
    a.onDestroyActionMode(paramActionMode);
    b.d = null;
    if (b.b != null) {
      b.b.a();
    }
  }
  
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    boolean bool2 = false;
    MenuItem localMenuItem = paramMenu.findItem(1);
    boolean bool1;
    int i;
    if (localMenuItem != null) {
      if ((b.b != null) && (!b.b.b()))
      {
        bool1 = true;
        if (localMenuItem.isVisible() == bool1) {
          break label107;
        }
        i = 1;
        label59:
        if (i != 0) {
          localMenuItem.setVisible(bool1);
        }
      }
    }
    for (;;)
    {
      if (!a.onPrepareActionMode(paramActionMode, paramMenu))
      {
        bool1 = bool2;
        if (i == 0) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
      break;
      label107:
      i = 0;
      break label59;
      i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     dco
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */