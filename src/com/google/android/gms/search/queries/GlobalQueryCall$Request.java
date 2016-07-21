package com.google.android.gms.search.queries;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.GlobalSearchQuerySpecification;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gbj;

public class GlobalQueryCall$Request
  implements SafeParcelable
{
  public static final gbj CREATOR = new gbj();
  public String a;
  public int b;
  public int c;
  public GlobalSearchQuerySpecification d;
  final int e;
  
  public GlobalQueryCall$Request()
  {
    e = 1;
  }
  
  public GlobalQueryCall$Request(int paramInt1, String paramString, int paramInt2, int paramInt3, GlobalSearchQuerySpecification paramGlobalSearchQuerySpecification)
  {
    e = paramInt1;
    a = paramString;
    b = paramInt2;
    c = paramInt3;
    d = paramGlobalSearchQuerySpecification;
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
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.queries.GlobalQueryCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */