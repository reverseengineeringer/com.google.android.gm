package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egs;
import emj;

public class AccountChangeEventsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new egs();
  final int a;
  public int b;
  @Deprecated
  public String c;
  Account d;
  
  public AccountChangeEventsRequest()
  {
    a = 1;
  }
  
  public AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString, Account paramAccount)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramString;
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
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */