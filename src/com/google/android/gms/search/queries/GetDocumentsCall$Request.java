package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gbf;

public class GetDocumentsCall$Request
  implements SafeParcelable
{
  public static final gbf CREATOR = new gbf();
  public String a;
  public String b;
  public String[] c;
  public QuerySpecification d;
  final int e;
  
  public GetDocumentsCall$Request()
  {
    e = 1;
  }
  
  public GetDocumentsCall$Request(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, QuerySpecification paramQuerySpecification)
  {
    e = paramInt;
    a = paramString1;
    b = paramString2;
    c = paramArrayOfString;
    d = paramQuerySpecification;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, e);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.queries.GetDocumentsCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */