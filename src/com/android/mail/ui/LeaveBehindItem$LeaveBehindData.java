package com.android.mail.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.mail.providers.Conversation;

public class LeaveBehindItem$LeaveBehindData
  implements Parcelable
{
  public final Parcelable.Creator<LeaveBehindData> CREATOR = new Parcelable.Creator()
  {
    public LeaveBehindItem.LeaveBehindData createFromParcel(Parcel paramAnonymousParcel)
    {
      return new LeaveBehindItem.LeaveBehindData(this$0, paramAnonymousParcel, null);
    }
    
    public LeaveBehindItem.LeaveBehindData[] newArray(int paramAnonymousInt)
    {
      return new LeaveBehindItem.LeaveBehindData[paramAnonymousInt];
    }
  };
  Conversation data;
  ToastBarOperation op;
  
  private LeaveBehindItem$LeaveBehindData(LeaveBehindItem paramLeaveBehindItem, Parcel paramParcel)
  {
    this(paramLeaveBehindItem, (Conversation)paramParcel.readParcelable(null), (ToastBarOperation)paramParcel.readParcelable(null));
  }
  
  public LeaveBehindItem$LeaveBehindData(LeaveBehindItem paramLeaveBehindItem, Conversation paramConversation, ToastBarOperation paramToastBarOperation)
  {
    op = paramToastBarOperation;
    data = paramConversation;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(op, 0);
    paramParcel.writeParcelable(data, 0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.LeaveBehindItem.LeaveBehindData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */