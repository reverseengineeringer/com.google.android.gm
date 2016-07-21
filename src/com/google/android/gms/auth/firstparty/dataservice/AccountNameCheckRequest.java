package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edz;
import emj;

public class AccountNameCheckRequest
  implements SafeParcelable
{
  public static final edz CREATOR = new edz();
  final int a;
  @Deprecated
  String b;
  String c;
  String d;
  AppDescription e;
  CaptchaSolution f;
  Account g;
  
  public AccountNameCheckRequest()
  {
    a = 2;
  }
  
  public AccountNameCheckRequest(int paramInt, String paramString1, String paramString2, String paramString3, AppDescription paramAppDescription, CaptchaSolution paramCaptchaSolution, Account paramAccount)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramAppDescription;
    f = paramCaptchaSolution;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1)))
    {
      g = new Account(paramString1, "com.google");
      return;
    }
    g = paramAccount;
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
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.a(paramParcel, 7, g, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.AccountNameCheckRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */