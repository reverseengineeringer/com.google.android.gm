package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gff;

public class GetCloudSyncOptInStatusResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetCloudSyncOptInStatusResponse> CREATOR = new gff();
  public final int a;
  public final int b;
  public final boolean c;
  public final boolean d;
  
  public GetCloudSyncOptInStatusResponse(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramBoolean1;
    d = paramBoolean2;
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
    emj.a(paramParcel, 4, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */