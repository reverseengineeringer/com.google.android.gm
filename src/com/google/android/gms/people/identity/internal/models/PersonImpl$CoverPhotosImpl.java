package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.Person.CoverPhotos;
import emj;
import fvm;
import java.util.HashSet;
import java.util.Set;

public class PersonImpl$CoverPhotosImpl
  implements SafeParcelable, Person.CoverPhotos
{
  public static final fvm CREATOR = new fvm();
  final Set<Integer> a;
  final int b;
  int c;
  String d;
  ImageReferenceImpl e;
  int f;
  boolean g;
  
  public PersonImpl$CoverPhotosImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public PersonImpl$CoverPhotosImpl(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, ImageReferenceImpl paramImageReferenceImpl, int paramInt3, boolean paramBoolean)
  {
    a = paramSet;
    b = paramInt1;
    c = paramInt2;
    d = paramString;
    e = paramImageReferenceImpl;
    f = paramInt3;
    g = paramBoolean;
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
      emj.b(paramParcel, 2, c);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      emj.b(paramParcel, 5, f);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      emj.a(paramParcel, 6, g);
    }
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.PersonImpl.CoverPhotosImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */