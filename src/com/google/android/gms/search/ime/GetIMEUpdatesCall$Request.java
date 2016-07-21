package com.google.android.gms.search.ime;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gaj;

public class GetIMEUpdatesCall$Request
  implements SafeParcelable
{
  public static final gaj CREATOR = new gaj();
  public int a;
  public byte[] b;
  final int c;
  
  public GetIMEUpdatesCall$Request()
  {
    c = 1;
  }
  
  public GetIMEUpdatesCall$Request(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    c = paramInt1;
    a = paramInt2;
    b = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.ime.GetIMEUpdatesCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */