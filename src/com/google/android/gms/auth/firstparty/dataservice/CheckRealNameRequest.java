package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import eem;
import emj;

public class CheckRealNameRequest
  implements SafeParcelable
{
  public static final eem CREATOR = new eem();
  final int a;
  AppDescription b;
  String c;
  String d;
  
  public CheckRealNameRequest()
  {
    a = 1;
  }
  
  public CheckRealNameRequest(int paramInt, AppDescription paramAppDescription, String paramString1, String paramString2)
  {
    a = paramInt;
    b = paramAppDescription;
    c = paramString1;
    d = paramString2;
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
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.CheckRealNameRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */