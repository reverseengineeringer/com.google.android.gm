package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import ghf;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<CapabilityInfoParcelable> CREATOR = new ghf();
  final int a;
  final String b;
  final List<NodeParcelable> c;
  private final Object d = new Object();
  private Set<Object> e;
  
  public CapabilityInfoParcelable(int paramInt, String paramString, List<NodeParcelable> paramList)
  {
    a = paramInt;
    b = paramString;
    c = paramList;
    e = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (CapabilityInfoParcelable)paramObject;
      if (a != a) {
        return false;
      }
      if (b != null)
      {
        if (b.equals(b)) {}
      }
      else {
        while (b != null) {
          return false;
        }
      }
      if (c == null) {
        break;
      }
    } while (c.equals(c));
    for (;;)
    {
      return false;
      if (c == null) {
        break;
      }
    }
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = a;
    if (b != null) {}
    for (int i = b.hashCode();; i = 0)
    {
      if (c != null) {
        j = c.hashCode();
      }
      return (i + k * 31) * 31 + j;
    }
  }
  
  public String toString()
  {
    return "CapabilityInfo{" + b + ", " + c + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.b(paramParcel, 3, c, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.CapabilityInfoParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */