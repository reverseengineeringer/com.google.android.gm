package com.android.mail.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import com.android.mail.providers.Conversation;
import com.android.mail.ui.toastbar.ToastBarOperation;
import cor;

public class LeaveBehindData
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<LeaveBehindData> CREATOR = new cor();
  public final Conversation a;
  public final ToastBarOperation b;
  public final int c;
  
  public LeaveBehindData(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    a = ((Conversation)paramParcel.readParcelable(paramClassLoader));
    b = ((ToastBarOperation)paramParcel.readParcelable(paramClassLoader));
    c = paramParcel.readInt();
  }
  
  public LeaveBehindData(Conversation paramConversation, ToastBarOperation paramToastBarOperation, int paramInt)
  {
    a = paramConversation;
    b = paramToastBarOperation;
    c = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(a, 0);
    paramParcel.writeParcelable(b, 0);
    paramParcel.writeInt(c);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.LeaveBehindData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */