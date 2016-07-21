package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eez;
import emj;

public class GplusInfoRequest
  implements SafeParcelable
{
  public static final eez CREATOR = new eez();
  final int a;
  String b;
  CaptchaSolution c;
  Account d;
  
  public GplusInfoRequest()
  {
    a = 2;
  }
  
  public GplusInfoRequest(int paramInt, String paramString, CaptchaSolution paramCaptchaSolution, Account paramAccount)
  {
    a = paramInt;
    b = paramString;
    c = paramCaptchaSolution;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)))
    {
      d = new Account(paramString, "com.google");
      return;
    }
    d = paramAccount;
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
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.GplusInfoRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */