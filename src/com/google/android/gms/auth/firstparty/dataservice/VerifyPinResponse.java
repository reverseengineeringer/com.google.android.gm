package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efq;
import emj;

public class VerifyPinResponse
  implements SafeParcelable
{
  public static final efq CREATOR = new efq();
  final int a;
  public final int b;
  public final String c;
  
  public VerifyPinResponse(int paramInt1, int paramInt2, String paramString)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.VerifyPinResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */