package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import fzn;

public class GetCurrentExperimentIdsCall$Response
  implements SafeParcelable, ejk
{
  public static final fzn CREATOR = new fzn();
  public Status a;
  public int[] b;
  final int c;
  
  public GetCurrentExperimentIdsCall$Response()
  {
    c = 1;
  }
  
  public GetCurrentExperimentIdsCall$Response(int paramInt, Status paramStatus, int[] paramArrayOfInt)
  {
    c = paramInt;
    a = paramStatus;
    b = paramArrayOfInt;
  }
  
  public final Status a()
  {
    return a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.global.GetCurrentExperimentIdsCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */