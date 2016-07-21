package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import edq;
import emj;

public class ProxyGrpcRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyGrpcRequest> CREATOR = new edq();
  final int a;
  public final String b;
  public final int c;
  public final long d;
  public final byte[] e;
  public final String f;
  
  public ProxyGrpcRequest(int paramInt1, String paramString1, int paramInt2, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    a = paramInt1;
    b = paramString1;
    c = paramInt2;
    d = paramLong;
    e = paramArrayOfByte;
    f = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, 2, c);
    emj.a(paramParcel, 3, d);
    emj.a(paramParcel, 4, e, false);
    emj.a(paramParcel, 5, f, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyGrpcRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */