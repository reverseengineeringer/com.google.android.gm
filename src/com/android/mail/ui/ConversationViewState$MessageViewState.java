package com.android.mail.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cms;

public class ConversationViewState$MessageViewState
  implements Parcelable
{
  public static final Parcelable.Creator<MessageViewState> CREATOR = new cms();
  public boolean a;
  public Integer b;
  public boolean c;
  public int d;
  
  public ConversationViewState$MessageViewState() {}
  
  public ConversationViewState$MessageViewState(Parcel paramParcel)
  {
    int i;
    Integer localInteger;
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      a = bool1;
      i = paramParcel.readInt();
      if (i != -1) {
        break label69;
      }
      localInteger = null;
      label34:
      b = localInteger;
      if (paramParcel.readInt() == 0) {
        break label78;
      }
    }
    label69:
    label78:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      c = bool1;
      d = paramParcel.readInt();
      return;
      bool1 = false;
      break;
      localInteger = Integer.valueOf(i);
      break label34;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    if (a)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (b != null) {
        break label58;
      }
      paramInt = -1;
      label25:
      paramParcel.writeInt(paramInt);
      if (!c) {
        break label69;
      }
    }
    label58:
    label69:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(d);
      return;
      paramInt = 0;
      break;
      paramInt = b.intValue();
      break label25;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewState.MessageViewState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */