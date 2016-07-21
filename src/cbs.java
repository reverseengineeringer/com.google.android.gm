import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class cbs
  implements View.OnClickListener
{
  cbs(cbk paramcbk) {}
  
  public final void onClick(View paramView)
  {
    cbk.o();
    a.A.requestFocus();
    a.A.setSelection(a.A.getText().length());
  }
}

/* Location:
 * Qualified Name:     cbs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */