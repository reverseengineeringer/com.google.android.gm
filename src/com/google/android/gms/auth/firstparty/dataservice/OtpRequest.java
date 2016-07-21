package com.google.android.gms.auth.firstparty.dataservice;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import efb;
import emj;
import enz;

public class OtpRequest
  implements SafeParcelable
{
  public static final efb CREATOR = new efb();
  final int a;
  public final String b;
  public final AppDescription c;
  public final byte[] d;
  public final boolean e;
  
  public OtpRequest(int paramInt, String paramString, AppDescription paramAppDescription, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    a = paramInt;
    b = paramString;
    d = paramArrayOfByte;
    c = ((AppDescription)enz.a(paramAppDescription, "Caller's app description cannot be null!"));
    e = paramBoolean;
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
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.a(paramParcel, 4, d, false);
    emj.a(paramParcel, 5, e);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.dataservice.OtpRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */