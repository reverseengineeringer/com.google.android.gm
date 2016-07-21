import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import com.android.ex.chips.RecipientEditTextView;
import java.util.ArrayList;

public final class bkm
  implements TextWatcher
{
  public bkm(RecipientEditTextView paramRecipientEditTextView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    int i = 0;
    Object localObject;
    int j;
    if (TextUtils.isEmpty(paramEditable))
    {
      paramEditable = a.getText();
      localObject = (bkq[])paramEditable.getSpans(0, a.getText().length(), bkq.class);
      j = localObject.length;
      while (i < j)
      {
        paramEditable.removeSpan(localObject[i]);
        i += 1;
      }
      if (a.o != null) {
        paramEditable.removeSpan(a.o);
      }
      a.e();
    }
    label292:
    label294:
    label306:
    label489:
    label498:
    for (;;)
    {
      return;
      localObject = a;
      if ((r > 0) || ((w != null) && (w.size() > 0))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label292;
        }
        if (a.m != null)
        {
          if (a.d(a.m)) {
            break;
          }
          a.setCursorVisible(true);
          a.setSelection(a.getText().length());
          a.e();
        }
        if (paramEditable.length() <= 1) {
          break;
        }
        if (!a.a(paramEditable)) {
          break label294;
        }
        paramEditable = a;
        if (e == null) {
          break;
        }
        localObject = paramEditable.getText();
        i = paramEditable.getSelectionEnd();
        j = e.findTokenStart((CharSequence)localObject, i);
        if (paramEditable.a(j, i)) {
          paramEditable.a(j, i, (Editable)localObject);
        }
        paramEditable.setSelection(paramEditable.getText().length());
        return;
      }
      continue;
      if (a.getSelectionEnd() == 0)
      {
        i = 0;
        j = a.length() - 1;
        if (i == j) {
          break label489;
        }
      }
      for (i = paramEditable.charAt(i);; i = paramEditable.charAt(j))
      {
        if ((i != 32) || (a.g())) {
          break label498;
        }
        paramEditable = a.getText().toString();
        i = a.e.findTokenStart(paramEditable, a.getSelectionEnd());
        paramEditable = paramEditable.substring(i, a.e.findTokenEnd(paramEditable, i));
        if (!a.b(paramEditable)) {
          break;
        }
        paramEditable = a;
        if (e == null) {
          break;
        }
        localObject = paramEditable.getText();
        i = paramEditable.getSelectionEnd();
        j = e.findTokenStart((CharSequence)localObject, i);
        if (paramEditable.a(j, i)) {
          paramEditable.a(j, i, (Editable)localObject);
        }
        paramEditable.setSelection(paramEditable.getText().length());
        return;
        i = a.getSelectionEnd() - 1;
        break label306;
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 - paramInt3 == 1)
    {
      paramInt1 = a.getSelectionStart();
      paramCharSequence = (bkq[])a.getText().getSpans(paramInt1, paramInt1, bkq.class);
      if (paramCharSequence.length > 0)
      {
        paramCharSequence = paramCharSequence[0];
        localEditable = a.getText();
        paramInt3 = localEditable.getSpanStart(paramCharSequence);
        paramInt2 = localEditable.getSpanEnd(paramCharSequence) + 1;
        paramInt1 = paramInt2;
        if (paramInt2 > localEditable.length()) {
          paramInt1 = localEditable.length();
        }
        if (a.C != null) {
          a.C.b(paramCharSequence.g());
        }
        localEditable.removeSpan(paramCharSequence);
      }
    }
    do
    {
      localEditable.delete(paramInt3, paramInt1);
      do
      {
        return;
      } while ((paramInt3 <= paramInt2) || (a.m == null) || (!a.d(a.m)) || (!a.a(paramCharSequence)));
      paramCharSequence = a;
    } while (e == null);
    Editable localEditable = paramCharSequence.getText();
    paramInt1 = paramCharSequence.getSelectionEnd();
    paramInt2 = e.findTokenStart(localEditable, paramInt1);
    if (paramCharSequence.a(paramInt2, paramInt1)) {
      paramCharSequence.a(paramInt2, paramInt1, localEditable);
    }
    paramCharSequence.setSelection(paramCharSequence.getText().length());
  }
}

/* Location:
 * Qualified Name:     bkm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */