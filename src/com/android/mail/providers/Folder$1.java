package com.android.mail.providers;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Folder$1
  implements Parcelable.Creator<Folder>
{
  public Folder createFromParcel(Parcel paramParcel)
  {
    return new Folder(paramParcel);
  }
  
  public Folder[] newArray(int paramInt)
  {
    return new Folder[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Folder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */