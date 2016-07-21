package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fhj;

public class ParcelableIndexReference
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new fhj();
  final int a;
  final String b;
  final int c;
  final boolean d;
  final int e;
  
  public ParcelableIndexReference(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    a = paramInt1;
    b = paramString;
    c = paramInt2;
    d = paramBoolean;
    e = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.b(paramParcel, 5, e);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.ParcelableIndexReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */