package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egi;
import emj;

public class FACLConfig
  implements SafeParcelable
{
  public static final egi CREATOR = new egi();
  private static final String h = "[" + FACLConfig.class.getSimpleName() + "]";
  final int a;
  boolean b;
  String c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  
  public FACLConfig(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    a = paramInt;
    b = paramBoolean1;
    c = paramString;
    d = paramBoolean2;
    e = paramBoolean3;
    f = paramBoolean4;
    g = paramBoolean5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f);
    emj.a(paramParcel, 7, g);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.FACLConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */