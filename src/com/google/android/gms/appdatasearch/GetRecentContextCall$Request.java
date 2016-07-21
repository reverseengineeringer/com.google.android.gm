package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebn;
import emj;

public class GetRecentContextCall$Request
  implements SafeParcelable
{
  public static final ebn CREATOR = new ebn();
  final int a;
  public final Account b;
  public final boolean c;
  public final boolean d;
  public final boolean e;
  public final String f;
  
  public GetRecentContextCall$Request()
  {
    this((byte)0);
  }
  
  private GetRecentContextCall$Request(byte paramByte)
  {
    this(1, null, false, false, false, null);
  }
  
  public GetRecentContextCall$Request(int paramInt, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    a = paramInt;
    b = paramAccount;
    c = paramBoolean1;
    d = paramBoolean2;
    e = paramBoolean3;
    f = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.a(paramParcel, 3, d);
    emj.a(paramParcel, 4, e);
    emj.a(paramParcel, 5, f, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GetRecentContextCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */