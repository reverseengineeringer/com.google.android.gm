package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import emj;
import fgy;
import java.util.List;

public class ParcelableEventList
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEventList> CREATOR = new fgy();
  final int a;
  final List<ParcelableEvent> b;
  final DataHolder c;
  final boolean d;
  final List<String> e;
  final ParcelableChangeInfo f;
  
  public ParcelableEventList(int paramInt, List<ParcelableEvent> paramList, DataHolder paramDataHolder, boolean paramBoolean, List<String> paramList1, ParcelableChangeInfo paramParcelableChangeInfo)
  {
    a = paramInt;
    b = paramList;
    c = paramDataHolder;
    d = paramBoolean;
    e = paramList1;
    f = paramParcelableChangeInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.ParcelableEventList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */