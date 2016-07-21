package com.android.emailcommon.provider;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bel;

public class RecipientAvailability
  implements Parcelable
{
  public static final Parcelable.Creator<RecipientAvailability> CREATOR = new bel();
  public int a;
  public String b;
  public String c;
  public String d;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecipientAvailability{type=").append(a).append(" emailAddress=").append(b).append(" displayName=").append(c).append(" mergedFreeBusy=").append(d).append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
    paramParcel.writeString(b);
    paramParcel.writeString(c);
    paramParcel.writeString(d);
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.RecipientAvailability
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */