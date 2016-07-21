package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import enz;
import fcr;
import ffg;
import fja;
import fmq;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new fja();
  final int a;
  public final String b;
  final long c;
  final long d;
  final int e;
  private volatile String f = null;
  private volatile String g = null;
  
  public DriveId(int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2)
  {
    a = paramInt1;
    b = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      enz.b(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L) {}
      }
      else
      {
        bool1 = true;
      }
      enz.b(bool1);
      c = paramLong1;
      d = paramLong2;
      e = paramInt2;
      return;
    }
  }
  
  private DriveId(String paramString) {}
  
  public static DriveId a(String paramString)
  {
    enz.a(paramString);
    return new DriveId(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriveId)) {}
    do
    {
      do
      {
        return false;
        paramObject = (DriveId)paramObject;
        if (d != d)
        {
          ffg.b("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
          return false;
        }
        if ((c == -1L) && (c == -1L)) {
          return b.equals(b);
        }
        if ((b != null) && (b != null)) {
          break;
        }
      } while (c != c);
      return true;
    } while (c != c);
    if (b.equals(b)) {
      return true;
    }
    ffg.b("DriveId", "Unexpected unequal resourceId for same DriveId object.");
    return false;
  }
  
  public int hashCode()
  {
    if (c == -1L) {
      return b.hashCode();
    }
    return (String.valueOf(d) + String.valueOf(c)).hashCode();
  }
  
  public String toString()
  {
    fcr localfcr;
    if (f == null)
    {
      localfcr = new fcr();
      a = a;
      if (b != null) {
        break label97;
      }
    }
    label97:
    for (String str = "";; str = b)
    {
      b = str;
      c = c;
      d = d;
      e = e;
      str = Base64.encodeToString(fmq.a(localfcr), 10);
      f = ("DriveId:" + str);
      return f;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.b(paramParcel, 5, e);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.DriveId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */