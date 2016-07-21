package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efg;
import emj;

public class PinSettings
  implements SafeParcelable
{
  public static final efg CREATOR = new efg();
  final int a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final int f;
  
  public PinSettings(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    a = paramInt1;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
    f = paramInt2;
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
    emj.b(paramParcel, 5, f);
    emj.a(paramParcel, 6, e, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.PinSettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */