package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efs;
import emj;
import enz;

public class WebSetupConfigRequest
  implements SafeParcelable
{
  public static final efs CREATOR = new efs();
  final int a;
  public final AppDescription b;
  
  public WebSetupConfigRequest(int paramInt, AppDescription paramAppDescription)
  {
    a = paramInt;
    b = ((AppDescription)enz.a(paramAppDescription));
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
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.WebSetupConfigRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */