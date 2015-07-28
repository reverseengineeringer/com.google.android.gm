package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Account$1
  implements Parcelable.Creator<Account>
{
  public Account createFromParcel(Parcel paramParcel)
  {
    return new Account(paramParcel);
  }
  
  public Account[] newArray(int paramInt)
  {
    return new Account[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Account.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */