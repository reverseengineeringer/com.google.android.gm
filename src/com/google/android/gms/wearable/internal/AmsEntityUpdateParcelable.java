package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import gha;

public class AmsEntityUpdateParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<AmsEntityUpdateParcelable> CREATOR = new gha();
  final int a;
  byte b;
  final byte c;
  final String d;
  
  public AmsEntityUpdateParcelable(int paramInt, byte paramByte1, byte paramByte2, String paramString)
  {
    b = paramByte1;
    a = paramInt;
    c = paramByte2;
    d = paramString;
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
      paramObject = (AmsEntityUpdateParcelable)paramObject;
      if (b != b) {
        return false;
      }
      if (a != a) {
        return false;
      }
      if (c != c) {
        return false;
      }
    } while (d.equals(d));
    return false;
  }
  
  public int hashCode()
  {
    return ((a * 31 + b) * 31 + c) * 31 + d.hashCode();
  }
  
  public String toString()
  {
    return "AmsEntityUpdateParcelable{mVersionCode=" + a + ", mEntityId=" + b + ", mAttributeId=" + c + ", mValue='" + d + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */