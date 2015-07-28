package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Message$1
  implements Parcelable.Creator<Message>
{
  public Message createFromParcel(Parcel paramParcel)
  {
    return new Message(paramParcel, null);
  }
  
  public Message[] newArray(int paramInt)
  {
    return new Message[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Message.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */