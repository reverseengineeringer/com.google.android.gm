package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import emj;
import fbx;
import java.util.List;
import java.util.Set;

public class GetChangesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetChangesRequest> CREATOR = new fbx();
  final int a;
  final ChangeSequenceNumber b;
  final int c;
  final List<DriveSpace> d;
  private final Set<DriveSpace> e;
  
  public GetChangesRequest(int paramInt1, ChangeSequenceNumber paramChangeSequenceNumber, int paramInt2, List<DriveSpace> paramList) {}
  
  private GetChangesRequest(int paramInt1, ChangeSequenceNumber paramChangeSequenceNumber, int paramInt2, List<DriveSpace> paramList, Set<DriveSpace> paramSet)
  {
    a = paramInt1;
    b = paramChangeSequenceNumber;
    c = paramInt2;
    d = paramList;
    e = paramSet;
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
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, 4, d, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.GetChangesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */