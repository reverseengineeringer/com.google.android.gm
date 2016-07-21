package com.google.android.gms.identity.accounts.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enz;
import fly;

public final class AccountData
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountData> CREATOR = new fly();
  final int a;
  public final String b;
  final String c;
  
  public AccountData(int paramInt, String paramString1, String paramString2)
  {
    enz.a(paramString1, "Account name must not be empty.");
    a = paramInt;
    b = paramString1;
    c = paramString2;
  }
  
  private AccountData(String paramString)
  {
    this(1, paramString, null);
  }
  
  public static AccountData a(String paramString)
  {
    enz.a(paramString, "Account name must not be empty.");
    return new AccountData(paramString);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.accounts.api.AccountData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */