package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gfb;

public class GetCapabilityResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetCapabilityResponse> CREATOR = new gfb();
  public final int a;
  public final int b;
  public final CapabilityInfoParcelable c;
  
  public GetCapabilityResponse(int paramInt1, int paramInt2, CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramCapabilityInfoParcelable;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetCapabilityResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */