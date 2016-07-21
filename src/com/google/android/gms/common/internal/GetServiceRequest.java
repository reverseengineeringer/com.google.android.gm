package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eih;
import emf;
import emj;
import emk;
import emq;

public class GetServiceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new emq();
  final int a;
  final int b;
  int c;
  public String d;
  public IBinder e;
  public Scope[] f;
  public Bundle g;
  public Account h;
  
  public GetServiceRequest(int paramInt)
  {
    a = 2;
    c = eih.a;
    b = paramInt;
  }
  
  public GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
    d = paramString;
    if (paramInt1 < 2)
    {
      paramString = null;
      if (paramIBinder != null) {
        paramString = emk.a(emf.a(paramIBinder));
      }
    }
    for (h = paramString;; h = paramAccount)
    {
      f = paramArrayOfScope;
      g = paramBundle;
      return;
      e = paramIBinder;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, paramInt);
    emj.a(paramParcel, 7, g);
    emj.a(paramParcel, 8, h, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.GetServiceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */