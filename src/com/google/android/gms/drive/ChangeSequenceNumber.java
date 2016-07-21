package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enz;
import fcq;
import fiy;
import fmq;

public class ChangeSequenceNumber
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChangeSequenceNumber> CREATOR = new fiy();
  final int a;
  final long b;
  final long c;
  final long d;
  private volatile String e = null;
  
  public ChangeSequenceNumber(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 != -1L)
    {
      bool1 = true;
      enz.b(bool1);
      if (paramLong2 == -1L) {
        break label92;
      }
      bool1 = true;
      label40:
      enz.b(bool1);
      if (paramLong3 == -1L) {
        break label98;
      }
    }
    label92:
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      enz.b(bool1);
      a = paramInt;
      b = paramLong1;
      c = paramLong2;
      d = paramLong3;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label40;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ChangeSequenceNumber)) {}
    do
    {
      return false;
      paramObject = (ChangeSequenceNumber)paramObject;
    } while ((c != c) || (d != d) || (b != b));
    return true;
  }
  
  public int hashCode()
  {
    return (String.valueOf(b) + String.valueOf(c) + String.valueOf(d)).hashCode();
  }
  
  public String toString()
  {
    if (e == null)
    {
      Object localObject = new fcq();
      a = a;
      b = b;
      c = c;
      d = d;
      localObject = Base64.encodeToString(fmq.a((fmq)localObject), 10);
      e = ("ChangeSequenceNumber:" + (String)localObject);
    }
    return e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.ChangeSequenceNumber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */