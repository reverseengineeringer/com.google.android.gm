package com.google.android.gms.people.identity.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fwh;

public final class AccountToken
  implements SafeParcelable
{
  public static final fwh CREATOR = new fwh();
  final int a;
  final String b;
  final String c;
  
  public AccountToken(int paramInt, String paramString1, String paramString2)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
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
 * Qualified Name:     com.google.android.gms.people.identity.internal.AccountToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */