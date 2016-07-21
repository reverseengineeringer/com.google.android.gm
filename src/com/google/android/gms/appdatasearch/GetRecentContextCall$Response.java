package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebo;
import ejk;
import emj;
import java.util.List;

public class GetRecentContextCall$Response
  implements SafeParcelable, ejk
{
  public static final ebo CREATOR = new ebo();
  public Status a;
  public List<UsageInfo> b;
  public String[] c;
  final int d;
  
  public GetRecentContextCall$Response()
  {
    d = 1;
  }
  
  public GetRecentContextCall$Response(int paramInt, Status paramStatus, List<UsageInfo> paramList, String[] paramArrayOfString)
  {
    d = paramInt;
    a = paramStatus;
    b = paramList;
    c = paramArrayOfString;
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
    emj.b(paramParcel, 1000, d);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.b(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GetRecentContextCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */