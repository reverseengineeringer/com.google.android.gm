package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import eoo;

public final class ConnectionEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ConnectionEvent> CREATOR = new eoo();
  final int a;
  final long b;
  int c;
  final String d;
  final String e;
  final String f;
  final String g;
  final String h;
  final String i;
  final long j;
  final long k;
  private long l;
  
  public ConnectionEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    a = paramInt1;
    b = paramLong1;
    c = paramInt2;
    d = paramString1;
    e = paramString2;
    f = paramString3;
    g = paramString4;
    l = -1L;
    h = paramString5;
    i = paramString6;
    j = paramLong2;
    k = paramLong3;
  }
  
  public ConnectionEvent(long paramLong1, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong2, long paramLong3)
  {
    this(1, paramLong1, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong2, paramLong3);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 7, g, false);
    emj.a(paramParcel, 8, h, false);
    emj.a(paramParcel, 10, j);
    emj.a(paramParcel, 11, k);
    emj.b(paramParcel, 12, c);
    emj.a(paramParcel, 13, i, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.ConnectionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */