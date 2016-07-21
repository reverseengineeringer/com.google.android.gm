package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;
import emj;
import gfh;

@Deprecated
public class GetConfigResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetConfigResponse> CREATOR = new gfh();
  public final int a;
  public final int b;
  public final ConnectionConfiguration c;
  
  public GetConfigResponse(int paramInt1, int paramInt2, ConnectionConfiguration paramConnectionConfiguration)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramConnectionConfiguration;
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
 * Qualified Name:     com.google.android.gms.wearable.internal.GetConfigResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */