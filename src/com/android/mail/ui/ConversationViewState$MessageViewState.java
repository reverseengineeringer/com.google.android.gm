package com.android.mail.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ConversationViewState$MessageViewState
  implements Parcelable
{
  public static Parcelable.Creator<MessageViewState> CREATOR = new Parcelable.Creator()
  {
    public ConversationViewState.MessageViewState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ConversationViewState.MessageViewState(paramAnonymousParcel, null);
    }
    
    public ConversationViewState.MessageViewState[] newArray(int paramAnonymousInt)
    {
      return new ConversationViewState.MessageViewState[paramAnonymousInt];
    }
  };
  public Integer expansionState;
  public boolean read;
  
  public ConversationViewState$MessageViewState() {}
  
  private ConversationViewState$MessageViewState(Parcel paramParcel)
  {
    boolean bool;
    int i;
    if (paramParcel.readInt() != 0)
    {
      bool = true;
      read = bool;
      i = paramParcel.readInt();
      if (i != -1) {
        break label41;
      }
    }
    label41:
    for (paramParcel = null;; paramParcel = Integer.valueOf(i))
    {
      expansionState = paramParcel;
      return;
      bool = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (read)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (expansionState != null) {
        break label34;
      }
    }
    label34:
    for (paramInt = -1;; paramInt = expansionState.intValue())
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewState.MessageViewState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */