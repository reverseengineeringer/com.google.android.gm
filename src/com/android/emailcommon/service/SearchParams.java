package com.android.emailcommon.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import bgi;
import hbc;
import java.util.Arrays;
import java.util.Date;

public class SearchParams
  implements Parcelable
{
  public static final Parcelable.Creator<SearchParams> CREATOR = new bgi();
  public final long a;
  public boolean b = true;
  public final String c;
  public final Date d;
  public final Date e;
  public int f = 10;
  public int g = 0;
  public long h;
  
  public SearchParams(long paramLong1, String paramString, long paramLong2)
  {
    a = paramLong1;
    c = paramString;
    d = null;
    e = null;
    h = paramLong2;
  }
  
  public SearchParams(Parcel paramParcel)
  {
    a = paramParcel.readLong();
    boolean bool;
    if (paramParcel.readInt() == 1)
    {
      bool = true;
      b = bool;
      c = paramParcel.readString();
      f = paramParcel.readInt();
      g = paramParcel.readInt();
      paramParcel = paramParcel.readSparseArray(getClass().getClassLoader());
      if (paramParcel.get(0) == null) {
        break label145;
      }
    }
    label145:
    for (d = new Date(((Long)paramParcel.get(0)).longValue());; d = null)
    {
      if (paramParcel.get(1) == null) {
        break label153;
      }
      e = new Date(((Long)paramParcel.get(1)).longValue());
      return;
      bool = false;
      break;
    }
    label153:
    e = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof SearchParams))) {
        return false;
      }
      paramObject = (SearchParams)paramObject;
    } while ((a == a) && (b == b) && (c.equals(c)) && (hbc.a(d, d)) && (hbc.a(e, e)) && (f == f) && (g == g));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Long.valueOf(a), c, d, e, Integer.valueOf(f), Integer.valueOf(g) });
  }
  
  public String toString()
  {
    long l = a;
    String str1 = c;
    int i = g;
    int j = f;
    String str2 = String.valueOf(d);
    String str3 = String.valueOf(e);
    return String.valueOf(str1).length() + 68 + String.valueOf(str2).length() + String.valueOf(str3).length() + "[SearchParams " + l + ":" + str1 + " (" + i + ", " + j + ") {" + str2 + ", " + str3 + "}]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(a);
    if (b) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(c);
      paramParcel.writeInt(f);
      paramParcel.writeInt(g);
      SparseArray localSparseArray = new SparseArray(2);
      if (d != null) {
        localSparseArray.put(0, Long.valueOf(d.getTime()));
      }
      if (e != null) {
        localSparseArray.put(1, Long.valueOf(e.getTime()));
      }
      paramParcel.writeSparseArray(localSparseArray);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.service.SearchParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */