package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import enz;

public abstract class WriteAwareParcelable
  implements Parcelable
{
  private volatile transient boolean a = false;
  
  public abstract void a(Parcel paramParcel, int paramInt);
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!a) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool);
      a = true;
      a(paramParcel, paramInt);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.WriteAwareParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */