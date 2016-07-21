package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import emj;
import fcs;
import java.util.List;

public class OnChangesResponse
  extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnChangesResponse> CREATOR = new fcs();
  final int a;
  final DataHolder b;
  final List<DriveId> c;
  final ChangeSequenceNumber d;
  final boolean e;
  
  public OnChangesResponse(int paramInt, DataHolder paramDataHolder, List<DriveId> paramList, ChangeSequenceNumber paramChangeSequenceNumber, boolean paramBoolean)
  {
    a = paramInt;
    b = paramDataHolder;
    c = paramList;
    d = paramChangeSequenceNumber;
    e = paramBoolean;
  }
  
  protected final void a(Parcel paramParcel, int paramInt)
  {
    paramInt |= 0x1;
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.a(paramParcel, 5, e);
    emj.b(paramParcel, i);
  }
  
  public int describeContents()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.OnChangesResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */