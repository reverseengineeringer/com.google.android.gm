package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fzv;

public class SetExperimentIdsCall$Request
  implements SafeParcelable
{
  public static final fzv CREATOR = new fzv();
  public byte[] a;
  public boolean b;
  final int c;
  
  public SetExperimentIdsCall$Request()
  {
    c = 1;
  }
  
  public SetExperimentIdsCall$Request(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    c = paramInt;
    a = paramArrayOfByte;
    b = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.global.SetExperimentIdsCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */