package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import ffu;
import java.util.ArrayList;
import java.util.List;

public class ParentDriveIdSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParentDriveIdSet> CREATOR = new ffu();
  final int a;
  final List<PartialDriveId> b;
  
  public ParentDriveIdSet()
  {
    this(1, new ArrayList());
  }
  
  public ParentDriveIdSet(int paramInt, List<PartialDriveId> paramList)
  {
    a = paramInt;
    b = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.ParentDriveIdSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */