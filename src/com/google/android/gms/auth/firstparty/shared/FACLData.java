package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egj;
import emj;

public class FACLData
  implements SafeParcelable
{
  public static final egj CREATOR = new egj();
  final int a;
  FACLConfig b;
  String c;
  boolean d;
  String e;
  
  public FACLData(int paramInt, FACLConfig paramFACLConfig, String paramString1, boolean paramBoolean, String paramString2)
  {
    a = paramInt;
    b = paramFACLConfig;
    c = paramString1;
    d = paramBoolean;
    e = paramString2;
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
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.FACLData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */