package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import emj;
import fcp;
import java.util.List;

public class LoadRealtimeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new fcp();
  final int a;
  final DriveId b;
  final boolean c;
  final List<String> d;
  final boolean e;
  final DataHolder f;
  final String g;
  
  public LoadRealtimeRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean1, List<String> paramList, boolean paramBoolean2, DataHolder paramDataHolder, String paramString)
  {
    a = paramInt;
    b = paramDriveId;
    c = paramBoolean1;
    d = paramList;
    e = paramBoolean2;
    f = paramDataHolder;
    g = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.a(paramParcel, 7, g, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.LoadRealtimeRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */