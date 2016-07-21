import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class cbl
  implements View.OnKeyListener
{
  cbl(cbk paramcbk) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.hasModifiers(4096)) && (paramInt == 66) && (paramKeyEvent.getAction() == 1))
    {
      a.m();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     cbl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */