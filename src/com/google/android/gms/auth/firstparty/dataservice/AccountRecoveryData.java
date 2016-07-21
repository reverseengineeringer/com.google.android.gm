package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.Country;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eeb;
import emj;
import java.util.Collections;
import java.util.List;

public class AccountRecoveryData
  implements SafeParcelable
{
  public static final eeb CREATOR = new eeb();
  public final int a;
  public final AccountRecoveryGuidance b;
  public final String c;
  public final String d;
  @Deprecated
  public final String e;
  public final String f;
  public final String g;
  public final List<Country> h;
  public final String i;
  public final String j;
  public final Account k;
  
  public AccountRecoveryData(int paramInt, AccountRecoveryGuidance paramAccountRecoveryGuidance, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<Country> paramList, String paramString6, String paramString7, Account paramAccount)
  {
    a = paramInt;
    b = paramAccountRecoveryGuidance;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = paramString4;
    g = paramString5;
    if (paramList == null) {}
    for (paramAccountRecoveryGuidance = Collections.EMPTY_LIST;; paramAccountRecoveryGuidance = Collections.unmodifiableList(paramList))
    {
      h = paramAccountRecoveryGuidance;
      i = paramString6;
      j = paramString7;
      if ((paramAccount != null) || (TextUtils.isEmpty(paramString3))) {
        break;
      }
      k = new Account(paramString3, "com.google");
      return;
    }
    k = paramAccount;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.b(paramParcel, 8, h, false);
    emj.a(paramParcel, 9, i, false);
    emj.a(paramParcel, 10, j, false);
    emj.a(paramParcel, 11, k, paramInt, false);
    emj.b(paramParcel, m);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */