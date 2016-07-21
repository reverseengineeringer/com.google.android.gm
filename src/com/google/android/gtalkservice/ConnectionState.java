package com.google.android.gtalkservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gih;

public final class ConnectionState
  implements Parcelable
{
  public static final Parcelable.Creator<ConnectionState> CREATOR = new gih();
  private volatile int a;
  
  public ConnectionState(Parcel paramParcel)
  {
    a = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    switch (a)
    {
    default: 
      return "IDLE";
    case 1: 
      return "RECONNECTION_SCHEDULED";
    case 2: 
      return "CONNECTING";
    case 3: 
      return "AUTHENTICATED";
    }
    return "ONLINE";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gtalkservice.ConnectionState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */