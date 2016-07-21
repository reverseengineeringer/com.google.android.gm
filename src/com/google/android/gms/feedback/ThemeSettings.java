package com.google.android.gms.feedback;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fjr;

public class ThemeSettings
  implements SafeParcelable
{
  public static final Parcelable.Creator<ThemeSettings> CREATOR = new fjr();
  final int a;
  public int b;
  public int c;
  
  public ThemeSettings()
  {
    this(1, 0, 0);
  }
  
  public ThemeSettings(int paramInt1, int paramInt2, int paramInt3)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.feedback.ThemeSettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */