package com.google.android.gms.auth.frp;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egp;
import emj;

public class UnlockFactoryResetProtectionRequest
  implements SafeParcelable
{
  public static final egp CREATOR = new egp();
  final int a;
  public final String b;
  public final String c;
  public final String d;
  
  public UnlockFactoryResetProtectionRequest(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.frp.UnlockFactoryResetProtectionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */