package com.android.mail.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ConversationViewState$1
  implements Parcelable.Creator<ConversationViewState>
{
  public ConversationViewState createFromParcel(Parcel paramParcel)
  {
    return new ConversationViewState(paramParcel, null);
  }
  
  public ConversationViewState[] newArray(int paramInt)
  {
    return new ConversationViewState[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewState.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */