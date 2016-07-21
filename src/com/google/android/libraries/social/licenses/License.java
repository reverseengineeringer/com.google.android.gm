package com.google.android.libraries.social.licenses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import gnv;

public final class License
  implements Parcelable, Comparable<License>
{
  public static final Parcelable.Creator<License> CREATOR = new gnv();
  final String a;
  public final long b;
  public final int c;
  public final String d;
  
  public License(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readLong();
    c = paramParcel.readInt();
    d = paramParcel.readString();
  }
  
  public License(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    a = paramString1;
    b = paramLong;
    c = paramInt;
    d = paramString2;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return a;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeLong(b);
    paramParcel.writeInt(c);
    paramParcel.writeString(d);
  }
}

/* Location:
 * Qualified Name:     com.google.android.libraries.social.licenses.License
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */