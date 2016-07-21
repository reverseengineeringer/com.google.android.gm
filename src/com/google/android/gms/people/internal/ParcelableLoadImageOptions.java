package com.google.android.gms.people.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enx;
import eny;
import frf;
import fxa;

public class ParcelableLoadImageOptions
  implements SafeParcelable
{
  public static final fxa CREATOR = new fxa();
  final int a;
  final int b;
  final int c;
  final boolean d;
  
  public ParcelableLoadImageOptions(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
    d = paramBoolean;
  }
  
  public static ParcelableLoadImageOptions a(frf paramfrf)
  {
    frf localfrf = paramfrf;
    if (paramfrf == null) {
      localfrf = frf.a;
    }
    return new ParcelableLoadImageOptions(1, b, c, d);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return enx.a(this).a("imageSize", Integer.valueOf(b)).a("avatarOptions", Integer.valueOf(c)).a("useLargePictureForCp2Images", Boolean.valueOf(d)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, 2, c);
    emj.a(paramParcel, 3, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.internal.ParcelableLoadImageOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */