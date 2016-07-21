package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eer;
import emj;

public class GetAndAdvanceOtpCounterResponse
  implements SafeParcelable
{
  public static final eer CREATOR = new eer();
  final int a;
  public final Long b;
  
  public GetAndAdvanceOtpCounterResponse(int paramInt, Long paramLong)
  {
    a = paramInt;
    b = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.GetAndAdvanceOtpCounterResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */