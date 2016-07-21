package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecb;
import emj;
import java.util.List;

public class QuerySpecification
  implements SafeParcelable
{
  public static final ecb CREATOR = new ecb();
  final int a;
  public final boolean b;
  public final List<String> c;
  public final List<Section> d;
  public final boolean e;
  public final int f;
  public final int g;
  public final boolean h;
  public final int i;
  
  public QuerySpecification(int paramInt1, boolean paramBoolean1, List<String> paramList, List<Section> paramList1, boolean paramBoolean2, int paramInt2, int paramInt3, boolean paramBoolean3, int paramInt4)
  {
    a = paramInt1;
    b = paramBoolean1;
    c = paramList;
    d = paramList1;
    e = paramBoolean2;
    f = paramInt2;
    g = paramInt3;
    h = paramBoolean3;
    i = paramInt4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, false);
    emj.b(paramParcel, 3, d, false);
    emj.a(paramParcel, 4, e);
    emj.b(paramParcel, 5, f);
    emj.b(paramParcel, 6, g);
    emj.a(paramParcel, 7, h);
    emj.b(paramParcel, 8, i);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.QuerySpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */