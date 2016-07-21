package com.google.android.gms.auth.firstparty.delegate;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efy;
import emj;

public class TokenWorkflowRequest
  implements SafeParcelable
{
  public static final efy CREATOR = new efy();
  final int a;
  String b;
  @Deprecated
  String c;
  Bundle d;
  FACLConfig e;
  PACLConfig f;
  boolean g;
  AppDescription h;
  Account i;
  AccountAuthenticatorResponse j;
  
  public TokenWorkflowRequest()
  {
    a = 2;
    d = new Bundle();
  }
  
  public TokenWorkflowRequest(int paramInt, String paramString1, String paramString2, Bundle paramBundle, FACLConfig paramFACLConfig, PACLConfig paramPACLConfig, boolean paramBoolean, AppDescription paramAppDescription, Account paramAccount, AccountAuthenticatorResponse paramAccountAuthenticatorResponse)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramBundle;
    e = paramFACLConfig;
    f = paramPACLConfig;
    g = paramBoolean;
    h = paramAppDescription;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString2))) {}
    for (i = new Account(paramString2, "com.google");; i = paramAccount)
    {
      j = paramAccountAuthenticatorResponse;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int k = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.a(paramParcel, 7, g);
    emj.a(paramParcel, 8, h, paramInt, false);
    emj.a(paramParcel, 9, i, paramInt, false);
    emj.a(paramParcel, 10, j, paramInt, false);
    emj.b(paramParcel, k);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.delegate.TokenWorkflowRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */