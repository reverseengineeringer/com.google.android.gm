package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import emj;
import fhh;
import java.util.List;

public class ParcelableChangeInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableChangeInfo> CREATOR = new fhh();
  final int a;
  final long b;
  final List<ParcelableEvent> c;
  
  public ParcelableChangeInfo(int paramInt, long paramLong, List<ParcelableEvent> paramList)
  {
    a = paramInt;
    b = paramLong;
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
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, 3, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */