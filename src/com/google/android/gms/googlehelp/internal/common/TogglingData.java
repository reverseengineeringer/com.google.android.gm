package com.google.android.gms.googlehelp.internal.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import flb;

public class TogglingData
  implements SafeParcelable
{
  public static final Parcelable.Creator<TogglingData> CREATOR = new flb();
  final int a;
  String b;
  String c;
  public String d;
  
  private TogglingData()
  {
    a = 1;
  }
  
  public TogglingData(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
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
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.googlehelp.internal.common.TogglingData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */