package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gfg;

public class GetCloudSyncSettingResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetCloudSyncSettingResponse> CREATOR = new gfg();
  public final int a;
  public final int b;
  public final boolean c;
  
  public GetCloudSyncSettingResponse(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramBoolean;
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
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */