package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Conversation$1
  implements Parcelable.Creator<Conversation>
{
  public Conversation createFromParcel(Parcel paramParcel)
  {
    return new Conversation(paramParcel, null);
  }
  
  public Conversation[] newArray(int paramInt)
  {
    return new Conversation[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Conversation.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */