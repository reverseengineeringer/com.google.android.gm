package com.android.mail.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.mail.providers.Conversation;

final class ConversationSelectionSet$1
  implements Parcelable.Creator<ConversationSelectionSet>
{
  public ConversationSelectionSet createFromParcel(Parcel paramParcel)
  {
    ConversationSelectionSet localConversationSelectionSet = new ConversationSelectionSet();
    paramParcel = paramParcel.readParcelableArray(Conversation.class.getClassLoader());
    int j = paramParcel.length;
    int i = 0;
    while (i < j)
    {
      Conversation localConversation = (Conversation)paramParcel[i];
      ConversationSelectionSet.access$000(localConversationSelectionSet, Long.valueOf(id), localConversation);
      i += 1;
    }
    return localConversationSelectionSet;
  }
  
  public ConversationSelectionSet[] newArray(int paramInt)
  {
    return new ConversationSelectionSet[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationSelectionSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */