package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.Person.ProfileOwnerStats;
import emj;
import fvc;
import java.util.HashSet;
import java.util.Set;

public class PersonImpl$ProfileOwnerStatsImpl
  implements SafeParcelable, Person.ProfileOwnerStats
{
  public static final fvc CREATOR = new fvc();
  final Set<Integer> a;
  final int b;
  long c;
  long d;
  
  public PersonImpl$ProfileOwnerStatsImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonImpl$ProfileOwnerStatsImpl(Set<Integer> paramSet, int paramInt, long paramLong1, long paramLong2)
  {
    a = paramSet;
    b = paramInt;
    c = paramLong1;
    d = paramLong2;
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
      emj.a(paramParcel, 2, c);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d);
    }
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonImpl.ProfileOwnerStatsImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */