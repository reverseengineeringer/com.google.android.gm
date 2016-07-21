import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class atj
  implements TextView.OnEditorActionListener
{
  atj(ati paramati) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      paramTextView = (atu)a.getActivity();
      if ((paramTextView != null) && (bbn.a(a.c())))
      {
        paramTextView.e_();
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     atj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */