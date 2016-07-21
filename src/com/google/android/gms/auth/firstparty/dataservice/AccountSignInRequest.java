package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eej;
import emj;

public class AccountSignInRequest
  implements SafeParcelable
{
  public static final eej CREATOR = new eej();
  final int a;
  AppDescription b;
  boolean c;
  boolean d;
  CaptchaSolution e;
  AccountCredentials f;
  
  public AccountSignInRequest()
  {
    a = 1;
  }
  
  public AccountSignInRequest(int paramInt, AppDescription paramAppDescription, boolean paramBoolean1, boolean paramBoolean2, CaptchaSolution paramCaptchaSolution, AccountCredentials paramAccountCredentials)
  {
    a = paramInt;
    b = paramAppDescription;
    c = paramBoolean1;
    d = paramBoolean2;
    e = paramCaptchaSolution;
    f = paramAccountCredentials;
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
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.AccountSignInRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */