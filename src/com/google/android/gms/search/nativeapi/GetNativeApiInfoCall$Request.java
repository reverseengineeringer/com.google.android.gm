package com.google.android.gms.search.nativeapi;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gav;

public class GetNativeApiInfoCall$Request
  implements SafeParcelable
{
  public static final gav CREATOR = new gav();
  final int a;
  
  public GetNativeApiInfoCall$Request()
  {
    a = 1;
  }
  
  public GetNativeApiInfoCall$Request(int paramInt)
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
 * Qualified Name:     com.google.android.gms.search.nativeapi.GetNativeApiInfoCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */