package com.google.android.gms.search.nativeapi;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.NativeApiInfo;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import gau;

public class GetNativeApiInfoCall$Response
  implements SafeParcelable, ejk
{
  public static final gau CREATOR = new gau();
  public Status a;
  public NativeApiInfo b;
  final int c;
  
  public GetNativeApiInfoCall$Response()
  {
    c = 1;
  }
  
  public GetNativeApiInfoCall$Response(int paramInt, Status paramStatus, NativeApiInfo paramNativeApiInfo)
  {
    c = paramInt;
    a = paramStatus;
    b = paramNativeApiInfo;
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
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.nativeapi.GetNativeApiInfoCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */