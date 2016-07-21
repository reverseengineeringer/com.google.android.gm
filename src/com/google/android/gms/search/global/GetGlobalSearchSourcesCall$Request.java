package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fzq;

public class GetGlobalSearchSourcesCall$Request
  implements SafeParcelable
{
  public static final fzq CREATOR = new fzq();
  public boolean a;
  final int b;
  
  public GetGlobalSearchSourcesCall$Request()
  {
    b = 1;
  }
  
  public GetGlobalSearchSourcesCall$Request(int paramInt, boolean paramBoolean)
  {
    b = paramInt;
    a = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, b);
    emj.a(paramParcel, 1, a);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.global.GetGlobalSearchSourcesCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */