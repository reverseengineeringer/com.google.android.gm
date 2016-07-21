package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gcb;

public class GoogleNowAuthState
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new gcb();
  final int a;
  String b;
  String c;
  long d;
  
  public GoogleNowAuthState(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "mAuthCode = " + b + "\nmAccessToken = " + c + "\nmNextAllowedTimeMillis = " + d;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.a(paramParcel, 3, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.GoogleNowAuthState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */