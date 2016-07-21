package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.Person.Organizations;
import emj;
import fuw;
import java.util.HashSet;
import java.util.Set;

public class PersonImpl$OrganizationsImpl
  implements SafeParcelable, Person.Organizations
{
  public static final fuw CREATOR = new fuw();
  final Set<Integer> a;
  final int b;
  PersonImpl.MetadataImpl c;
  boolean d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  String m;
  String n;
  String o;
  
  public PersonImpl$OrganizationsImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonImpl$OrganizationsImpl(Set<Integer> paramSet, int paramInt, PersonImpl.MetadataImpl paramMetadataImpl, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    a = paramSet;
    b = paramInt;
    c = paramMetadataImpl;
    d = paramBoolean;
    e = paramString1;
    f = paramString2;
    g = paramString3;
    h = paramString4;
    i = paramString5;
    j = paramString6;
    k = paramString7;
    l = paramString8;
    m = paramString9;
    n = paramString10;
    o = paramString11;
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
      emj.a(paramParcel, 2, c, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d);
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
      emj.a(paramParcel, 12, m, true);
    }
    if (localSet.contains(Integer.valueOf(13))) {
      emj.a(paramParcel, 13, n, true);
    }
    if (localSet.contains(Integer.valueOf(14))) {
      emj.a(paramParcel, 14, o, true);
    }
    emj.b(paramParcel, i1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonImpl.OrganizationsImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */