package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.PersonReference;
import emj;
import fuz;
import java.util.HashSet;
import java.util.Set;

public class PersonReferenceImpl
  implements SafeParcelable, PersonReference
{
  public static final fuz CREATOR = new fuz();
  final Set<Integer> a;
  final int b;
  String c;
  String d;
  ImageReferenceImpl e;
  
  public PersonReferenceImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonReferenceImpl(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, ImageReferenceImpl paramImageReferenceImpl)
  {
    a = paramSet;
    b = paramInt;
    c = paramString1;
    d = paramString2;
    e = paramImageReferenceImpl;
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
      emj.a(paramParcel, 2, c, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, paramInt, true);
    }
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonReferenceImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */