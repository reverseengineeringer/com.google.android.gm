package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efd;
import emj;

public class PasswordCheckRequest
  implements SafeParcelable
{
  public static final efd CREATOR = new efd();
  final int a;
  String b;
  String c;
  String d;
  String e;
  AppDescription f;
  
  public PasswordCheckRequest(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, AppDescription paramAppDescription)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
    f = paramAppDescription;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.PasswordCheckRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */