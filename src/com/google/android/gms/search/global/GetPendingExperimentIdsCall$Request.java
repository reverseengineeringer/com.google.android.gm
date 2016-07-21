package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fzs;

public class GetPendingExperimentIdsCall$Request
  implements SafeParcelable
{
  public static final fzs CREATOR = new fzs();
  final int a;
  
  public GetPendingExperimentIdsCall$Request()
  {
    a = 1;
  }
  
  public GetPendingExperimentIdsCall$Request(int paramInt)
  {
    a = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.global.GetPendingExperimentIdsCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */