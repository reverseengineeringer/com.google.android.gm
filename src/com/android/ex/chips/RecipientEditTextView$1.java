package com.android.ex.chips;

class RecipientEditTextView$1
  implements Runnable
{
  RecipientEditTextView$1(RecipientEditTextView paramRecipientEditTextView) {}
  
  public void run()
  {
    if (RecipientEditTextView.access$000(this$0) == null)
    {
      RecipientEditTextView.access$002(this$0, new RecipientEditTextView.RecipientTextWatcher(this$0, null));
      this$0.addTextChangedListener(RecipientEditTextView.access$000(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */