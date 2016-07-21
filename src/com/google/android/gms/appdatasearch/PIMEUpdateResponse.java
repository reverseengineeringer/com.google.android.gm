package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebw;
import emj;

public class PIMEUpdateResponse
  implements SafeParcelable
{
  public static final ebw CREATOR = new ebw();
  final int a;
  final String b;
  public final byte[] c;
  public final PIMEUpdate[] d;
  
  public PIMEUpdateResponse(int paramInt, String paramString, byte[] paramArrayOfByte, PIMEUpdate[] paramArrayOfPIMEUpdate)
  {
    a = paramInt;
    b = paramString;
    c = paramArrayOfByte;
    d = paramArrayOfPIMEUpdate;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.a(paramParcel, 3, d, paramInt);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.PIMEUpdateResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */