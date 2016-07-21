package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edc;
import emj;

public class RecoveryWriteRequest
  implements SafeParcelable
{
  public static final edc CREATOR = new edc();
  final int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public boolean f;
  
  public RecoveryWriteRequest()
  {
    a = 1;
  }
  
  public RecoveryWriteRequest(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
    f = paramBoolean;
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
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.RecoveryWriteRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */