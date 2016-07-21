package com.google.android.gtalkservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gig;

public final class ConnectionError
  implements Parcelable
{
  public static final Parcelable.Creator<ConnectionError> CREATOR = new gig();
  private int a;
  
  public ConnectionError(Parcel paramParcel)
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
    case 9: 
    default: 
      return "NO ERROR";
    case 1: 
      return "NO NETWORK";
    case 2: 
      return "CONNECTION FAILED";
    case 3: 
      return "UNKNOWN HOST";
    case 4: 
      return "AUTH FAILED";
    case 5: 
      return "AUTH EXPIRED";
    case 6: 
      return "HEARTBEAT TIMEOUT";
    case 7: 
      return "SERVER FAILED";
    case 8: 
      return "SERVER REJECT - RATE LIMIT";
    }
    return "UNKNOWN";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gtalkservice.ConnectionError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */