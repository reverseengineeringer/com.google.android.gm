package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.Person.Birthdays;
import emj;
import fvk;
import java.util.HashSet;
import java.util.Set;

public class PersonImpl$BirthdaysImpl
  implements SafeParcelable, Person.Birthdays
{
  public static final fvk CREATOR = new fvk();
  final Set<Integer> a;
  final int b;
  PersonImpl.MetadataImpl c;
  String d;
  
  public PersonImpl$BirthdaysImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonImpl$BirthdaysImpl(Set<Integer> paramSet, int paramInt, PersonImpl.MetadataImpl paramMetadataImpl, String paramString)
  {
    a = paramSet;
    b = paramInt;
    c = paramMetadataImpl;
    d = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    Set localSet = a;
    if (localSet.contains(Integer.valueOf(1))) {
      emj.b(paramParcel, 1, b);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      emj.a(paramParcel, 2, c, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonImpl.BirthdaysImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */