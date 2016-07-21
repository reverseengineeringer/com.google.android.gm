package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;
import emj;
import gfi;

public class GetConfigsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetConfigsResponse> CREATOR = new gfi();
  public final int a;
  public final int b;
  public final ConnectionConfiguration[] c;
  
  public GetConfigsResponse(int paramInt1, int paramInt2, ConnectionConfiguration[] paramArrayOfConnectionConfiguration)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramArrayOfConnectionConfiguration;
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
    emj.a(paramParcel, 3, c, paramInt);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetConfigsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */