package com.android.ex.chips;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListPopupWindow;

class RecipientEditTextView$7
  implements AdapterView.OnItemClickListener
{
  RecipientEditTextView$7(RecipientEditTextView paramRecipientEditTextView, RecipientChip paramRecipientChip, ListPopupWindow paramListPopupWindow) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    RecipientEditTextView.access$900(this$0, val$currentChip);
    val$popup.dismiss();
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */