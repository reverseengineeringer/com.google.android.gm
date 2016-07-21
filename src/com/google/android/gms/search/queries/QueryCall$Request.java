package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gbl;

public class QueryCall$Request
  implements SafeParcelable
{
  public static final gbl CREATOR = new gbl();
  public String a;
  public String b;
  public String[] c;
  public int d;
  public int e;
  public QuerySpecification f;
  final int g;
  
  public QueryCall$Request()
  {
    g = 1;
  }
  
  public QueryCall$Request(int paramInt1, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt2, int paramInt3, QuerySpecification paramQuerySpecification)
  {
    g = paramInt1;
    a = paramString1;
    b = paramString2;
    c = paramArrayOfString;
    d = paramInt2;
    e = paramInt3;
    f = paramQuerySpecification;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, g);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, 4, d);
    emj.b(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.queries.QueryCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */