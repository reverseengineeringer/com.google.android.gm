package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edr;
import emj;

public class ProxyRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyRequest> CREATOR = new edr();
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 7;
  final int j;
  public final String k;
  public final int l;
  public final long m;
  public final byte[] n;
  Bundle o;
  
  public ProxyRequest(int paramInt1, String paramString, int paramInt2, long paramLong, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    j = paramInt1;
    k = paramString;
    l = paramInt2;
    m = paramLong;
    n = paramArrayOfByte;
    o = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ProxyRequest[ url: " + k + ", method: " + l + " ]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, k, false);
    emj.b(paramParcel, 1000, j);
    emj.b(paramParcel, 2, l);
    emj.a(paramParcel, 3, m);
    emj.a(paramParcel, 4, n, false);
    emj.a(paramParcel, 5, o);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */