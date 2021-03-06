package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eeq;
import emj;

public class ConfirmCredentialsRequest
  implements SafeParcelable
{
  public static final eeq CREATOR = new eeq();
  final int a;
  AccountCredentials b;
  CaptchaSolution c;
  
  public ConfirmCredentialsRequest()
  {
    a = 1;
  }
  
  public ConfirmCredentialsRequest(int paramInt, AccountCredentials paramAccountCredentials, CaptchaSolution paramCaptchaSolution)
  {
    a = paramInt;
    b = paramAccountCredentials;
    c = paramCaptchaSolution;
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
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.ConfirmCredentialsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */