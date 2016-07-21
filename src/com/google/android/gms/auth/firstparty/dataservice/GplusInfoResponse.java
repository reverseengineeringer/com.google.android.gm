package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efa;
import emj;

public class GplusInfoResponse
  implements SafeParcelable
{
  public static final efa CREATOR = new efa();
  final int a;
  boolean b;
  String c;
  String d;
  String e;
  boolean f;
  boolean g;
  String h;
  String i;
  String j;
  
  public GplusInfoResponse(int paramInt, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, String paramString4, String paramString5, String paramString6)
  {
    a = paramInt;
    b = paramBoolean1;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = paramBoolean2;
    g = paramBoolean3;
    h = paramString4;
    i = paramString5;
    j = paramString6;
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
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f);
    emj.a(paramParcel, 7, g);
    emj.a(paramParcel, 8, h, false);
    emj.a(paramParcel, 9, i, false);
    emj.a(paramParcel, 10, j, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.GplusInfoResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */