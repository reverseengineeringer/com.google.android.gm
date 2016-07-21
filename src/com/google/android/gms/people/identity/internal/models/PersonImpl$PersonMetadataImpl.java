package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.Person.PersonMetadata;
import emj;
import fuy;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonImpl$PersonMetadataImpl
  implements SafeParcelable, Person.PersonMetadata
{
  public static final fuy CREATOR = new fuy();
  final Set<Integer> a;
  final int b;
  List<String> c;
  List<String> d;
  List<String> e;
  List<String> f;
  List<String> g;
  List<String> h;
  String i;
  String j;
  List<String> k;
  String l;
  PersonImpl.ProfileOwnerStatsImpl m;
  boolean n;
  boolean o;
  boolean p;
  
  public PersonImpl$PersonMetadataImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonImpl$PersonMetadataImpl(Set<Integer> paramSet, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, List<String> paramList5, List<String> paramList6, String paramString1, String paramString2, List<String> paramList7, String paramString3, PersonImpl.ProfileOwnerStatsImpl paramProfileOwnerStatsImpl, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a = paramSet;
    b = paramInt;
    c = paramList1;
    d = paramList2;
    e = paramList3;
    f = paramList4;
    g = paramList5;
    h = paramList6;
    i = paramString1;
    j = paramString2;
    k = paramList7;
    l = paramString3;
    m = paramProfileOwnerStatsImpl;
    n = paramBoolean1;
    o = paramBoolean2;
    p = paramBoolean3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = emj.a(paramParcel, 20293);
    Set localSet = a;
    if (localSet.contains(Integer.valueOf(1))) {
      emj.b(paramParcel, 1, b);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      emj.a(paramParcel, 2, c, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      emj.a(paramParcel, 5, f, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      emj.a(paramParcel, 6, g, true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      emj.a(paramParcel, 7, h, true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      emj.a(paramParcel, 8, i, true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      emj.a(paramParcel, 9, j, true);
    }
    if (localSet.contains(Integer.valueOf(10))) {
      emj.a(paramParcel, 10, k, true);
    }
    if (localSet.contains(Integer.valueOf(11))) {
      emj.a(paramParcel, 11, l, true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      emj.a(paramParcel, 12, m, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      emj.a(paramParcel, 13, n);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      emj.a(paramParcel, 14, o);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      emj.a(paramParcel, 15, p);
    }
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonImpl.PersonMetadataImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */