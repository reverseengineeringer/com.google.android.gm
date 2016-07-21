package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebv;
import emj;

public class PIMEUpdate
  implements SafeParcelable
{
  public static final ebv CREATOR = new ebv();
  final int a;
  final byte[] b;
  final byte[] c;
  public final int d;
  public final String e;
  public final String f;
  public final boolean g;
  final Bundle h;
  public final long i;
  public final long j;
  public final Account k;
  
  public PIMEUpdate(int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, String paramString1, String paramString2, boolean paramBoolean, Bundle paramBundle, long paramLong1, long paramLong2, Account paramAccount)
  {
    a = paramInt1;
    b = paramArrayOfByte1;
    c = paramArrayOfByte2;
    d = paramInt2;
    e = paramString1;
    f = paramString2;
    g = paramBoolean;
    h = paramBundle;
    i = paramLong1;
    j = paramLong2;
    k = paramAccount;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.b(paramParcel, 3, d);
    emj.a(paramParcel, 4, e, false);
    emj.a(paramParcel, 5, f, false);
    emj.a(paramParcel, 6, g);
    emj.a(paramParcel, 8, h);
    emj.a(paramParcel, 9, i);
    emj.a(paramParcel, 10, j);
    emj.a(paramParcel, 11, k, paramInt, false);
    emj.b(paramParcel, m);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.PIMEUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */