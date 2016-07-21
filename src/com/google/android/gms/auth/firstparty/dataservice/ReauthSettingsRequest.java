package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efi;
import emj;

public class ReauthSettingsRequest
  implements SafeParcelable
{
  public static final efi CREATOR = new efi();
  final int a;
  @Deprecated
  public final String b;
  public final boolean c;
  public final Account d;
  public String e;
  
  public ReauthSettingsRequest(int paramInt, String paramString1, boolean paramBoolean, Account paramAccount, String paramString2)
  {
    a = paramInt;
    b = paramString1;
    c = paramBoolean;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString1))) {}
    for (d = new Account(paramString1, "com.google");; d = paramAccount)
    {
      e = paramString2;
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
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.ReauthSettingsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */