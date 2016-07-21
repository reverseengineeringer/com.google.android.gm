package com.google.android.gms.search.corpora;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fza;

public class RequestIndexingCall$Request
  implements SafeParcelable
{
  public static final fza CREATOR = new fza();
  public String a;
  public String b;
  public long c;
  final int d;
  
  public RequestIndexingCall$Request()
  {
    d = 1;
  }
  
  public RequestIndexingCall$Request(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    d = paramInt;
    a = paramString1;
    b = paramString2;
    c = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, d);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.corpora.RequestIndexingCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */