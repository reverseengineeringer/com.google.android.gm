package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;
import emj;
import fdb;

public class OnListEntriesResponse
  extends WriteAwareParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new fdb();
  final int a;
  final DataHolder b;
  final boolean c;
  
  public OnListEntriesResponse(int paramInt, DataHolder paramDataHolder, boolean paramBoolean)
  {
    a = paramInt;
    b = paramDataHolder;
    c = paramBoolean;
  }
  
  protected final void a(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, i);
  }
  
  public int describeContents()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.OnListEntriesResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */