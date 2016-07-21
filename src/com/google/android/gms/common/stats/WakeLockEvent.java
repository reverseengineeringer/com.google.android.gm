package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import eou;
import java.util.List;

public final class WakeLockEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new eou();
  final int a;
  final long b;
  int c;
  final String d;
  final int e;
  final List<String> f;
  final String g;
  final long h;
  int i;
  final String j;
  final String k;
  final float l;
  private long m;
  
  public WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat)
  {
    a = paramInt1;
    b = paramLong1;
    c = paramInt2;
    d = paramString1;
    j = paramString3;
    e = paramInt3;
    m = -1L;
    f = paramList;
    g = paramString2;
    h = paramLong2;
    i = paramInt4;
    k = paramString4;
    l = paramFloat;
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
    emj.b(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, false);
    emj.a(paramParcel, 8, h);
    emj.a(paramParcel, 10, j, false);
    emj.b(paramParcel, 11, c);
    emj.a(paramParcel, 12, g, false);
    emj.a(paramParcel, 13, k, false);
    emj.b(paramParcel, 14, i);
    float f1 = l;
    emj.a(paramParcel, 15, 4);
    paramParcel.writeFloat(f1);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */