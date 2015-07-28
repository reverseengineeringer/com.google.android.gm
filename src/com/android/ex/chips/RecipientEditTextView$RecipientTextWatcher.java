package com.android.ex.chips;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView.Validator;
import android.widget.MultiAutoCompleteTextView.Tokenizer;

class RecipientEditTextView$RecipientTextWatcher
  implements TextWatcher
{
  private RecipientEditTextView$RecipientTextWatcher(RecipientEditTextView paramRecipientEditTextView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 0;
    int j;
    if (TextUtils.isEmpty(paramEditable))
    {
      paramEditable = this$0.getSpannable();
      RecipientChip[] arrayOfRecipientChip = (RecipientChip[])paramEditable.getSpans(0, this$0.getText().length(), RecipientChip.class);
      j = arrayOfRecipientChip.length;
      while (i < j)
      {
        paramEditable.removeSpan(arrayOfRecipientChip[i]);
        i += 1;
      }
      if (RecipientEditTextView.access$1000(this$0) != null) {
        paramEditable.removeSpan(RecipientEditTextView.access$1000(this$0));
      }
    }
    label92:
    label242:
    label253:
    do
    {
      do
      {
        do
        {
          break label92;
          do
          {
            return;
          } while (RecipientEditTextView.access$1100(this$0));
          if ((RecipientEditTextView.access$400(this$0) != null) && (RecipientEditTextView.access$1200(this$0, RecipientEditTextView.access$400(this$0))))
          {
            this$0.setCursorVisible(true);
            this$0.setSelection(this$0.getText().length());
            RecipientEditTextView.access$1300(this$0);
          }
        } while (paramEditable.length() <= 1);
        if (this$0.getSelectionEnd() == 0)
        {
          i = 0;
          j = this$0.length() - 1;
          if (i == j) {
            break label242;
          }
        }
        for (i = paramEditable.charAt(i);; i = paramEditable.charAt(j))
        {
          if ((i != 59) && (i != 44)) {
            break label253;
          }
          RecipientEditTextView.access$1400(this$0);
          return;
          i = this$0.getSelectionEnd() - 1;
          break;
        }
      } while ((i != 32) || (this$0.isPhoneQuery()));
      paramEditable = this$0.getText().toString();
      i = RecipientEditTextView.access$1500(this$0).findTokenStart(paramEditable, this$0.getSelectionEnd());
      paramEditable = paramEditable.substring(i, RecipientEditTextView.access$1500(this$0).findTokenEnd(paramEditable, i));
    } while ((TextUtils.isEmpty(paramEditable)) || (RecipientEditTextView.access$1600(this$0) == null) || (!RecipientEditTextView.access$1600(this$0).isValid(paramEditable)));
    RecipientEditTextView.access$1400(this$0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt3)
    {
      paramInt1 = this$0.getSelectionStart();
      paramCharSequence = (RecipientChip[])this$0.getSpannable().getSpans(paramInt1, paramInt1, RecipientChip.class);
      if (paramCharSequence.length > 0)
      {
        localEditable = this$0.getText();
        paramInt3 = RecipientEditTextView.access$1500(this$0).findTokenStart(localEditable, paramInt1);
        paramInt2 = RecipientEditTextView.access$1500(this$0).findTokenEnd(localEditable, paramInt3) + 1;
        paramInt1 = paramInt2;
        if (paramInt2 > localEditable.length()) {
          paramInt1 = localEditable.length();
        }
        localEditable.delete(paramInt3, paramInt1);
        this$0.getSpannable().removeSpan(paramCharSequence[0]);
      }
    }
    while (paramInt3 <= paramInt2)
    {
      Editable localEditable;
      return;
    }
    RecipientEditTextView.access$1700(this$0);
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.RecipientTextWatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */