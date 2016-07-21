import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class aam
  extends adl
{
  aam(aak paramaak, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (a.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (a.a(paramKeyEvent.getKeyCode(), paramKeyEvent));
  }
  
  public void onContentChanged() {}
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if ((paramInt == 0) && (!(paramMenu instanceof adu))) {
      return false;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    super.onMenuOpened(paramInt, paramMenu);
    a.e(paramInt);
    return true;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
    a.d(paramInt);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    adu localadu;
    boolean bool1;
    if ((paramMenu instanceof adu))
    {
      localadu = (adu)paramMenu;
      if ((paramInt != 0) || (localadu != null)) {
        break label34;
      }
      bool1 = false;
    }
    label34:
    boolean bool2;
    do
    {
      return bool1;
      localadu = null;
      break;
      if (localadu != null) {
        l = true;
      }
      bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
      bool1 = bool2;
    } while (localadu == null);
    l = false;
    return bool2;
  }
}

/* Location:
 * Qualified Name:     aam
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */