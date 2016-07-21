package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fgq;

public class Operator
  implements SafeParcelable
{
  public static final Parcelable.Creator<Operator> CREATOR = new fgq();
  public static final Operator a = new Operator("=");
  public static final Operator b = new Operator("<");
  public static final Operator c = new Operator("<=");
  public static final Operator d = new Operator(">");
  public static final Operator e = new Operator(">=");
  public static final Operator f = new Operator("and");
  public static final Operator g = new Operator("or");
  public static final Operator h = new Operator("not");
  public static final Operator i = new Operator("contains");
  public final String j;
  final int k;
  
  public Operator(int paramInt, String paramString)
  {
    k = paramInt;
    j = paramString;
  }
  
  private Operator(String paramString)
  {
    this(1, paramString);
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
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (Operator)paramObject;
        if (j != null) {
          break;
        }
      } while (j == null);
      return false;
    } while (j.equals(j));
    return false;
  }
  
  public int hashCode()
  {
    if (j == null) {}
    for (int m = 0;; m = j.hashCode()) {
      return m + 31;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, k);
    emj.a(paramParcel, 1, j, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.Operator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */