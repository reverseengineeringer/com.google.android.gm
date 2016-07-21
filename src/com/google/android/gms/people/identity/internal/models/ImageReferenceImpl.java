package com.google.android.gms.people.identity.internal.models;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.people.identity.models.ImageReference;
import emj;
import ful;
import java.util.HashSet;
import java.util.Set;

public class ImageReferenceImpl
  implements SafeParcelable, ImageReference
{
  public static final ful CREATOR = new ful();
  final Set<Integer> a;
  final int b;
  int c;
  String d;
  byte[] e;
  
  public ImageReferenceImpl()
  {
    a = new HashSet();
    b = 1;
  }
  
  public ImageReferenceImpl(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    a = paramSet;
    b = paramInt1;
    c = paramInt2;
    d = paramString;
    e = paramArrayOfByte;
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
      emj.b(paramParcel, 2, c);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      emj.a(paramParcel, 3, d, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      emj.a(paramParcel, 4, e, true);
    }
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.identity.internal.models.ImageReferenceImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */