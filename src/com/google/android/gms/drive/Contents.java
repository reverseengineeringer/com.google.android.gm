package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fiz;

public class Contents
  implements SafeParcelable
{
  public static final Parcelable.Creator<Contents> CREATOR = new fiz();
  final int a;
  public final ParcelFileDescriptor b;
  public final int c;
  public final int d;
  public final DriveId e;
  public final boolean f;
  final String g;
  
  public Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, boolean paramBoolean, String paramString)
  {
    a = paramInt1;
    b = paramParcelFileDescriptor;
    c = paramInt2;
    d = paramInt3;
    e = paramDriveId;
    f = paramBoolean;
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
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.a(paramParcel, 7, f);
    emj.a(paramParcel, 8, g, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.Contents
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */