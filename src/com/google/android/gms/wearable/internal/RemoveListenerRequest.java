package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gft;
import gfu;
import ggi;

public class RemoveListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new ggi();
  final int a;
  public final gft b;
  
  public RemoveListenerRequest(int paramInt, IBinder paramIBinder)
  {
    a = paramInt;
    if (paramIBinder != null)
    {
      b = gfu.a(paramIBinder);
      return;
    }
    b = null;
  }
  
  public RemoveListenerRequest(gft paramgft)
  {
    a = 1;
    b = paramgft;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    if (b == null) {}
    for (IBinder localIBinder = null;; localIBinder = b.asBinder())
    {
      emj.a(paramParcel, 2, localIBinder);
      emj.b(paramParcel, paramInt);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.RemoveListenerRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */