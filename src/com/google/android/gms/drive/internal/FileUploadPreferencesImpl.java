package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fbw;

public final class FileUploadPreferencesImpl
  implements SafeParcelable
{
  public static final Parcelable.Creator<FileUploadPreferencesImpl> CREATOR = new fbw();
  final int a;
  int b;
  int c;
  boolean d;
  
  public FileUploadPreferencesImpl(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
    d = paramBoolean;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.FileUploadPreferencesImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */