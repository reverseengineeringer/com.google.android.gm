package com.google.android.gms.search.global;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import fzy;

public class SetIncludeInGlobalSearchCall$Response
  implements SafeParcelable, ejk
{
  public static final fzy CREATOR = new fzy();
  public Status a;
  final int b;
  
  public SetIncludeInGlobalSearchCall$Response()
  {
    b = 1;
  }
  
  public SetIncludeInGlobalSearchCall$Response(int paramInt, Status paramStatus)
  {
    b = paramInt;
    a = paramStatus;
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
    emj.b(paramParcel, 1000, b);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.global.SetIncludeInGlobalSearchCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */