package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eep;
import emj;

public class ClearTokenResponse
  implements SafeParcelable
{
  public static final eep CREATOR = new eep();
  final int a;
  final String b;
  
  public ClearTokenResponse(int paramInt, String paramString)
  {
    a = paramInt;
    b = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.ClearTokenResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */