package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egm;
import emj;

public class PlusProfileCreationResponse
  implements SafeParcelable
{
  public static final egm CREATOR = new egm();
  final int a;
  String b;
  
  public PlusProfileCreationResponse(int paramInt, String paramString)
  {
    a = paramInt;
    b = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.PlusProfileCreationResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */