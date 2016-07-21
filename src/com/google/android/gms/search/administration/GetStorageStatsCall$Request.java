package com.google.android.gms.search.administration;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fyp;

public class GetStorageStatsCall$Request
  implements SafeParcelable
{
  public static final fyp CREATOR = new fyp();
  final int a;
  
  public GetStorageStatsCall$Request()
  {
    a = 1;
  }
  
  public GetStorageStatsCall$Request(int paramInt)
  {
    a = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.administration.GetStorageStatsCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */