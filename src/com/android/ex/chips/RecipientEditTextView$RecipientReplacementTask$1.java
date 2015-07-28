package com.android.ex.chips;

import android.text.Editable;
import android.text.SpannableString;
import java.util.ArrayList;
import java.util.Iterator;

class RecipientEditTextView$RecipientReplacementTask$1
  implements Runnable
{
  RecipientEditTextView$RecipientReplacementTask$1(RecipientEditTextView.RecipientReplacementTask paramRecipientReplacementTask, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    Editable localEditable = this$1.this$0.getText();
    int i = 0;
    Iterator localIterator = val$originalRecipients.iterator();
    while (localIterator.hasNext())
    {
      RecipientChip localRecipientChip = (RecipientChip)localIterator.next();
      int j = localEditable.getSpanStart(localRecipientChip);
      if (j != -1)
      {
        int k = localEditable.getSpanEnd(localRecipientChip);
        localEditable.removeSpan(localRecipientChip);
        localRecipientChip = (RecipientChip)val$replacements.get(i);
        SpannableString localSpannableString = new SpannableString(this$1.this$0.createAddressText(localRecipientChip.getEntry()).trim());
        localSpannableString.setSpan(localRecipientChip, 0, localSpannableString.length(), 33);
        localEditable.replace(j, k, localSpannableString);
        localRecipientChip.setOriginalText(localSpannableString.toString());
      }
      i += 1;
    }
    val$originalRecipients.clear();
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.RecipientReplacementTask.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */