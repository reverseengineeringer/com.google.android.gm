package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Settings$1
  implements Parcelable.Creator<Settings>
{
  public Settings createFromParcel(Parcel paramParcel)
  {
    return new Settings(paramParcel);
  }
  
  public Settings[] newArray(int paramInt)
  {
    return new Settings[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Settings.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */