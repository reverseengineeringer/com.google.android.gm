package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eds;
import emj;

public class ProxyResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyResponse> CREATOR = new eds();
  final int a;
  public final int b;
  public final PendingIntent c;
  public final int d;
  final Bundle e;
  public final byte[] f;
  
  public ProxyResponse(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, int paramInt3, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    a = paramInt1;
    b = paramInt2;
    d = paramInt3;
    e = paramBundle;
    f = paramArrayOfByte;
    c = paramPendingIntent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, paramInt, false);
    emj.b(paramParcel, 3, d);
    emj.a(paramParcel, 4, e);
    emj.a(paramParcel, 5, f, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */