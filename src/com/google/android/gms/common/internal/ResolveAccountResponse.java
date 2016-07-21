package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emf;
import emj;
import eob;

public class ResolveAccountResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new eob();
  final int a;
  public IBinder b;
  public ConnectionResult c;
  public boolean d;
  public boolean e;
  
  public ResolveAccountResponse()
  {
    this(new ConnectionResult(8, null));
  }
  
  public ResolveAccountResponse(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    a = paramInt;
    b = paramIBinder;
    c = paramConnectionResult;
    d = paramBoolean1;
    e = paramBoolean2;
  }
  
  private ResolveAccountResponse(ConnectionResult paramConnectionResult)
  {
    this(1, null, paramConnectionResult, false, false);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ResolveAccountResponse)) {
        return false;
      }
      paramObject = (ResolveAccountResponse)paramObject;
    } while ((c.equals(c)) && (emf.a(b).equals(emf.a(b))));
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */