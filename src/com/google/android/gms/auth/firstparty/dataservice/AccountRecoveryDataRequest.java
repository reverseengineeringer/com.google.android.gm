package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eec;
import emj;
import enz;

public class AccountRecoveryDataRequest
  implements SafeParcelable
{
  public static final eec CREATOR = new eec();
  private static final String g = "[" + AccountRecoveryDataRequest.class.getSimpleName() + "]";
  final int a;
  @Deprecated
  public final String b;
  public final boolean c;
  public final AppDescription d;
  public final String e;
  public final Account f;
  
  public AccountRecoveryDataRequest(int paramInt, String paramString1, boolean paramBoolean, AppDescription paramAppDescription, String paramString2, Account paramAccount)
  {
    b = enz.a(paramString1, g + " accountName cannot be empty or null!");
    enz.a(paramString2, g + " requestDescription cannot be empty or null!");
    a = paramInt;
    c = paramBoolean;
    d = ((AppDescription)enz.a(paramAppDescription));
    e = paramString2;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1))) {}
    for (f = new Account(paramString1, "com.google");; f = paramAccount)
    {
      enz.a(f);
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
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryDataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */