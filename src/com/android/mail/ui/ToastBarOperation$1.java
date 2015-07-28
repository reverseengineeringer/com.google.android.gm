package com.android.mail.ui;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ToastBarOperation$1
  implements Parcelable.Creator<ToastBarOperation>
{
  public ToastBarOperation createFromParcel(Parcel paramParcel)
  {
    return new ToastBarOperation(paramParcel);
  }
  
  public ToastBarOperation[] newArray(int paramInt)
  {
    return new ToastBarOperation[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ToastBarOperation.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */