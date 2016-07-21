package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eef;
import emj;

public class AccountRecoveryUpdateRequest
  implements SafeParcelable
{
  public static final eef CREATOR = new eef();
  final int a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final boolean f;
  public final AppDescription g;
  public final Account h;
  
  public AccountRecoveryUpdateRequest(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppDescription paramAppDescription, Account paramAccount)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
    f = paramBoolean;
    g = paramAppDescription;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1)))
    {
      h = new Account(paramString1, "com.google");
      return;
    }
    h = paramAccount;
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
    emj.a(paramParcel, 6, f);
    emj.a(paramParcel, 7, g, paramInt, false);
    emj.a(paramParcel, 8, h, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryUpdateRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */