package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gfa;
import java.util.List;

public class GetAllCapabilitiesResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetAllCapabilitiesResponse> CREATOR = new gfa();
  public final int a;
  public final int b;
  final List<CapabilityInfoParcelable> c;
  
  public GetAllCapabilitiesResponse(int paramInt1, int paramInt2, List<CapabilityInfoParcelable> paramList)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, 3, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */