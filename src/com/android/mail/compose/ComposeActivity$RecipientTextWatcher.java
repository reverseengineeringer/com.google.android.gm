package com.android.mail.compose;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.util.Rfc822Token;
import com.android.ex.chips.RecipientEditTextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class ComposeActivity$RecipientTextWatcher
  implements TextWatcher
{
  private HashMap<String, Integer> mContent = new HashMap();
  private TextWatcher mListener;
  private RecipientEditTextView mView;
  
  public ComposeActivity$RecipientTextWatcher(ComposeActivity paramComposeActivity, RecipientEditTextView paramRecipientEditTextView, TextWatcher paramTextWatcher)
  {
    mView = paramRecipientEditTextView;
    mListener = paramTextWatcher;
  }
  
  private boolean hasChanged()
  {
    String[] arrayOfString = tokenizeRecips(this$0.getAddressesFromList(mView));
    int j = arrayOfString.length;
    int i = 0;
    Object localObject = mContent.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      i += ((Integer)((Map.Entry)((Iterator)localObject).next()).getValue()).intValue();
    }
    if (j != i) {
      return true;
    }
    j = arrayOfString.length;
    i = 0;
    while (i < j)
    {
      localObject = arrayOfString[i];
      if (!mContent.containsKey(localObject)) {
        return true;
      }
      int k = ((Integer)mContent.get(localObject)).intValue() - 1;
      if (k < 0) {
        return true;
      }
      mContent.put(localObject, Integer.valueOf(k));
      i += 1;
    }
    return false;
  }
  
  private String[] tokenizeRecips(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfString[i] = android.text.util.Rfc822Tokenizer.tokenize(paramArrayOfString[i])[0].getAddress();
      i += 1;
    }
    return arrayOfString;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (hasChanged()) {
      mListener.afterTextChanged(paramEditable);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = tokenizeRecips(this$0.getAddressesFromList(mView));
    paramInt2 = paramCharSequence.length;
    paramInt1 = 0;
    if (paramInt1 < paramInt2)
    {
      Object localObject = paramCharSequence[paramInt1];
      if (!mContent.containsKey(localObject)) {
        mContent.put(localObject, Integer.valueOf(1));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        mContent.put(localObject, Integer.valueOf(((Integer)mContent.get(localObject)).intValue() + 1));
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivity.RecipientTextWatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */