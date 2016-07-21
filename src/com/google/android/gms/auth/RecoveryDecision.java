package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eda;
import emj;

public class RecoveryDecision
  implements SafeParcelable
{
  public static final eda CREATOR = new eda();
  final int a;
  public PendingIntent b;
  public boolean c;
  public boolean d;
  public boolean e;
  public PendingIntent f;
  
  public RecoveryDecision()
  {
    a = 1;
  }
  
  public RecoveryDecision(int paramInt, PendingIntent paramPendingIntent1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PendingIntent paramPendingIntent2)
  {
    a = paramInt;
    b = paramPendingIntent1;
    c = paramBoolean1;
    d = paramBoolean2;
    e = paramBoolean3;
    f = paramPendingIntent2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.RecoveryDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */