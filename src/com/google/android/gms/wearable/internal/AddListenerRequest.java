package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gft;
import gfu;
import ggc;
import ggw;

public class AddListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddListenerRequest> CREATOR = new ggc();
  final int a;
  public final gft b;
  public final IntentFilter[] c;
  public final String d;
  public final String e;
  
  public AddListenerRequest(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    a = paramInt;
    if (paramIBinder != null) {}
    for (b = gfu.a(paramIBinder);; b = null)
    {
      c = paramArrayOfIntentFilter;
      d = paramString1;
      e = paramString2;
      return;
    }
  }
  
  public AddListenerRequest(ggw paramggw)
  {
    a = 1;
    b = paramggw;
    c = i;
    d = j;
    e = k;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    if (b == null) {}
    for (IBinder localIBinder = null;; localIBinder = b.asBinder())
    {
      emj.a(paramParcel, 2, localIBinder);
      emj.a(paramParcel, 3, c, paramInt);
      emj.a(paramParcel, 4, d, false);
      emj.a(paramParcel, 5, e, false);
      emj.b(paramParcel, i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.AddListenerRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */