package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eed;
import emj;

public class AccountRecoveryGuidance
  implements SafeParcelable
{
  public static final eed CREATOR = new eed();
  final int a;
  @Deprecated
  public final String b;
  public final boolean c;
  public final boolean d;
  public final boolean e;
  public final Account f;
  
  public AccountRecoveryGuidance(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Account paramAccount)
  {
    a = paramInt;
    b = paramString;
    c = paramBoolean1;
    d = paramBoolean2;
    e = paramBoolean3;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)))
    {
      f = new Account(paramString, "com.google");
      return;
    }
    f = paramAccount;
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
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryGuidance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */