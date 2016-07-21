package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.SuggestSpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gbn;

public class QuerySuggestCall$Request
  implements SafeParcelable
{
  public static final gbn CREATOR = new gbn();
  public String a;
  public String b;
  public String[] c;
  public int d;
  public SuggestSpecification e;
  final int f;
  
  public QuerySuggestCall$Request()
  {
    f = 1;
  }
  
  public QuerySuggestCall$Request(int paramInt1, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt2, SuggestSpecification paramSuggestSpecification)
  {
    f = paramInt1;
    a = paramString1;
    b = paramString2;
    c = paramArrayOfString;
    d = paramInt2;
    e = paramSuggestSpecification;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, f);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.queries.QuerySuggestCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */