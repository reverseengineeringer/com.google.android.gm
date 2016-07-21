package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eea;
import emj;
import java.util.List;

public class AccountNameCheckResponse
  implements SafeParcelable
{
  public static final eea CREATOR = new eea();
  final int a;
  String b;
  List<String> c;
  String d;
  CaptchaChallenge e;
  
  public AccountNameCheckResponse(int paramInt, String paramString1, List<String> paramList, String paramString2, CaptchaChallenge paramCaptchaChallenge)
  {
    a = paramInt;
    b = paramString1;
    c = paramList;
    d = paramString2;
    e = paramCaptchaChallenge;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.AccountNameCheckResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */