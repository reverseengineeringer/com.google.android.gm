package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.SearchResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import gbk;

public class GlobalQueryCall$Response
  implements SafeParcelable, ejk
{
  public static final gbk CREATOR = new gbk();
  public Status a;
  public SearchResults b;
  final int c;
  
  public GlobalQueryCall$Response()
  {
    c = 1;
  }
  
  public GlobalQueryCall$Response(int paramInt, Status paramStatus, SearchResults paramSearchResults)
  {
    c = paramInt;
    a = paramStatus;
    b = paramSearchResults;
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
 * Qualified Name:     com.google.android.gms.search.queries.GlobalQueryCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */