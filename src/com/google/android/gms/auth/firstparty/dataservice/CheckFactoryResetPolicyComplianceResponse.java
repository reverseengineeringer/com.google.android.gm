package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eel;
import emj;

public class CheckFactoryResetPolicyComplianceResponse
  implements SafeParcelable
{
  public static final eel CREATOR = new eel();
  final int a;
  public final boolean b;
  
  public CheckFactoryResetPolicyComplianceResponse(int paramInt, boolean paramBoolean)
  {
    a = paramInt;
    b = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.CheckFactoryResetPolicyComplianceResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */