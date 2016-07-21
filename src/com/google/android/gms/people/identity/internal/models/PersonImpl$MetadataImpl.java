package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.Person.Metadata;
import emj;
import fuq;
import java.util.HashSet;
import java.util.Set;

public class PersonImpl$MetadataImpl
  implements SafeParcelable, Person.Metadata
{
  public static final fuq CREATOR = new fuq();
  final Set<Integer> a;
  final int b;
  String c;
  String d;
  String e;
  String f;
  boolean g;
  boolean h;
  boolean i;
  boolean j;
  int k;
  
  public PersonImpl$MetadataImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonImpl$MetadataImpl(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt2)
  {
    a = paramSet;
    b = paramInt1;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = paramString4;
    g = paramBoolean1;
    h = paramBoolean2;
    i = paramBoolean3;
    j = paramBoolean4;
    k = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
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
      emj.a(paramParcel, 6, g);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      emj.a(paramParcel, 7, h);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      emj.a(paramParcel, 8, i);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      emj.a(paramParcel, 9, j);
    }
    if (localSet.contains(Integer.valueOf(10))) {
      emj.b(paramParcel, 10, k);
    }
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonImpl.MetadataImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */