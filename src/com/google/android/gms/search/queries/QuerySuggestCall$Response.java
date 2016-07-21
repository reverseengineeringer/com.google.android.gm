package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.SuggestionResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import gbo;

public class QuerySuggestCall$Response
  implements SafeParcelable, ejk
{
  public static final gbo CREATOR = new gbo();
  public Status a;
  public SuggestionResults b;
  final int c;
  
  public QuerySuggestCall$Response()
  {
    c = 1;
  }
  
  public QuerySuggestCall$Response(int paramInt, Status paramStatus, SuggestionResults paramSuggestionResults)
  {
    c = paramInt;
    a = paramStatus;
    b = paramSuggestionResults;
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
 * Qualified Name:     com.google.android.gms.search.queries.QuerySuggestCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */