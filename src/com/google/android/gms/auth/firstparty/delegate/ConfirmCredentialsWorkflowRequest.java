package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efw;
import emj;

public class ConfirmCredentialsWorkflowRequest
  implements SafeParcelable
{
  public static final efw CREATOR = new efw();
  final int a;
  @Deprecated
  String b;
  AppDescription c;
  Bundle d;
  Account e;
  AccountAuthenticatorResponse f;
  
  public ConfirmCredentialsWorkflowRequest()
  {
    a = 3;
    d = new Bundle();
  }
  
  public ConfirmCredentialsWorkflowRequest(int paramInt, String paramString, AppDescription paramAppDescription, Bundle paramBundle, Account paramAccount, AccountAuthenticatorResponse paramAccountAuthenticatorResponse)
  {
    a = paramInt;
    b = paramString;
    c = paramAppDescription;
    d = paramBundle;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString))) {}
    for (e = new Account(paramString, "com.google");; e = paramAccount)
    {
      f = paramAccountAuthenticatorResponse;
      return;
    }
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
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.delegate.ConfirmCredentialsWorkflowRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */