package com.google.android.gm.provider;

import com.google.android.gm.LabelOperations;

class UiProvider$ConversationLabelOperation
  extends LabelOperations
{
  final String mAccount;
  final long mConversationId;
  
  private UiProvider$ConversationLabelOperation(UiProvider paramUiProvider, String paramString, long paramLong)
  {
    mAccount = paramString;
    mConversationId = paramLong;
  }
  
  private void performOperation()
  {
    UiProvider localUiProvider = this$0;
    String str1 = Long.toString(mConversationId);
    String str2 = mAccount;
    UiProvider.access$400(localUiProvider, new String[] { str1 }, str2, this);
  }
  
  protected LabelOperations createNewInstance()
  {
    return new ConversationLabelOperation(this$0, mAccount, mConversationId);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.UiProvider.ConversationLabelOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */