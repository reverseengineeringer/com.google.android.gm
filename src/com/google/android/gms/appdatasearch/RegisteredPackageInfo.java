package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecg;
import emj;

public class RegisteredPackageInfo
  implements SafeParcelable
{
  public static final ecg CREATOR = new ecg();
  final int a;
  public final String b;
  public final long c;
  public final boolean d;
  public final long e;
  
  public RegisteredPackageInfo(int paramInt, String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    a = paramInt;
    b = paramString;
    c = paramLong1;
    d = paramBoolean;
    e = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.a(paramParcel, 3, d);
    emj.a(paramParcel, 4, e);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.RegisteredPackageInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */