package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edb;
import emj;
import java.util.List;

public class RecoveryReadResponse
  implements SafeParcelable
{
  public static final edb CREATOR = new edb();
  final int a;
  public String b;
  public String c;
  public String d;
  public List<Country> e;
  public String f;
  public String g;
  public String h;
  
  public RecoveryReadResponse()
  {
    a = 1;
  }
  
  public RecoveryReadResponse(int paramInt, String paramString1, String paramString2, String paramString3, List<Country> paramList, String paramString4, String paramString5, String paramString6)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramList;
    f = paramString4;
    g = paramString5;
    h = paramString6;
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
    emj.b(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.a(paramParcel, 8, h, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.RecoveryReadResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */