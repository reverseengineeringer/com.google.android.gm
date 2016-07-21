package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fej;

public class DisconnectRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DisconnectRequest> CREATOR = new fej();
  final int a;
  
  public DisconnectRequest()
  {
    this(1);
  }
  
  public DisconnectRequest(int paramInt)
  {
    a = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.DisconnectRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */