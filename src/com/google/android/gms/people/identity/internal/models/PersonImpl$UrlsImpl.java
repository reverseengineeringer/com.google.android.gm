package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.Person.Urls;
import emj;
import fvj;
import java.util.HashSet;
import java.util.Set;

public class PersonImpl$UrlsImpl
  implements SafeParcelable, Person.Urls
{
  public static final fvj CREATOR = new fvj();
  final Set<Integer> a;
  final int b;
  PersonImpl.MetadataImpl c;
  String d;
  String e;
  String f;
  
  public PersonImpl$UrlsImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonImpl$UrlsImpl(Set<Integer> paramSet, int paramInt, PersonImpl.MetadataImpl paramMetadataImpl, String paramString1, String paramString2, String paramString3)
  {
    a = paramSet;
    b = paramInt;
    c = paramMetadataImpl;
    d = paramString1;
    e = paramString2;
    f = paramString3;
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
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      emj.a(paramParcel, 5, f, true);
    }
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonImpl.UrlsImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */