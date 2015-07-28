package com.android.ex.chips;

import android.text.Spannable;
import java.util.Comparator;

class RecipientEditTextView$6
  implements Comparator<RecipientChip>
{
  RecipientEditTextView$6(RecipientEditTextView paramRecipientEditTextView, Spannable paramSpannable) {}
  
  public int compare(RecipientChip paramRecipientChip1, RecipientChip paramRecipientChip2)
  {
    int i = val$spannable.getSpanStart(paramRecipientChip1);
    int j = val$spannable.getSpanStart(paramRecipientChip2);
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */