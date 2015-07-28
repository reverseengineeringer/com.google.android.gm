package com.google.android.gm.provider;

import android.database.MatrixCursor;
import com.google.android.gm.provider.uiprovider.AccountState;
import com.google.android.gm.provider.uiprovider.ConversationState;
import java.util.Map;

class UiProvider$AttachmentCursor
  extends MatrixCursor
{
  private final String mAccount;
  private final long mConversationId;
  private final long mMessageId;
  
  public UiProvider$AttachmentCursor(UiProvider paramUiProvider, String paramString, long paramLong1, long paramLong2, String[] paramArrayOfString, int paramInt)
  {
    super(paramArrayOfString, paramInt);
    mAccount = paramString;
    mConversationId = paramLong1;
    mMessageId = paramLong2;
  }
  
  public void close()
  {
    synchronized ()
    {
      Object localObject1 = (AccountState)UiProvider.access$500().get(mAccount);
      if (localObject1 != null)
      {
        localObject1 = ((AccountState)localObject1).getConversationState(mConversationId);
        if (localObject1 != null) {
          ((ConversationState)localObject1).handleCursorClose(this);
        }
      }
      super.close();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.UiProvider.AttachmentCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */