import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

public final class cf
  implements TextWatcher
{
  public cf(TextInputLayout paramTextInputLayout) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    a.a(true);
    if (a.e) {
      a.a(paramEditable.length());
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     cf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */