package com.android.ex.chips;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListPopupWindow;

class RecipientEditTextView$4
  implements AdapterView.OnItemClickListener
{
  RecipientEditTextView$4(RecipientEditTextView paramRecipientEditTextView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    RecipientEditTextView.access$300(this$0).setOnItemClickListener(null);
    this$0.replaceChip(RecipientEditTextView.access$400(this$0), ((RecipientAlternatesAdapter)paramAdapterView.getAdapter()).getRecipientEntry(paramInt));
    paramAdapterView = Message.obtain(RecipientEditTextView.access$500(this$0), RecipientEditTextView.access$600());
    obj = RecipientEditTextView.access$300(this$0);
    RecipientEditTextView.access$500(this$0).sendMessageDelayed(paramAdapterView, 300L);
    this$0.clearComposingText();
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */