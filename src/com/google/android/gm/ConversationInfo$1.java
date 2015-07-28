package com.google.android.gm;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gm.provider.LabelManager;

final class ConversationInfo$1
  implements Parcelable.Creator<ConversationInfo>
{
  public ConversationInfo createFromParcel(Parcel paramParcel)
  {
    return new ConversationInfo(paramParcel.readLong(), paramParcel.readLong(), paramParcel.readLong(), paramParcel.readLong(), LabelManager.parseLabelQueryResult(paramParcel.readString()));
  }
  
  public ConversationInfo[] newArray(int paramInt)
  {
    return new ConversationInfo[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ConversationInfo.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */