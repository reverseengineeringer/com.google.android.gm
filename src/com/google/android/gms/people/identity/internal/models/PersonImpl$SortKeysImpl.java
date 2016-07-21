package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.Person.SortKeys;
import emj;
import fvh;
import java.util.HashSet;
import java.util.Set;

public class PersonImpl$SortKeysImpl
  implements SafeParcelable, Person.SortKeys
{
  public static final fvh CREATOR = new fvh();
  final Set<Integer> a;
  final int b;
  String c;
  String d;
  
  public PersonImpl$SortKeysImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonImpl$SortKeysImpl(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2)
  {
    a = paramSet;
    b = paramInt;
    c = paramString1;
    d = paramString2;
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
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonImpl.SortKeysImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */