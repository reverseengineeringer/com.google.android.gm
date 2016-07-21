package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eme;
import emj;
import emn;
import java.util.Set;

public class AuthAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new emn();
  final int a;
  final IBinder b;
  final Scope[] c;
  
  public AuthAccountRequest(int paramInt, IBinder paramIBinder, Scope[] paramArrayOfScope)
  {
    a = paramInt;
    b = paramIBinder;
    c = paramArrayOfScope;
  }
  
  public AuthAccountRequest(eme parameme, Set<Scope> paramSet)
  {
    this(1, parameme.asBinder(), (Scope[])paramSet.toArray(new Scope[paramSet.size()]));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, paramInt);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.AuthAccountRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */