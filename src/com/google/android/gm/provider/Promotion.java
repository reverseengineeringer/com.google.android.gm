package com.google.android.gm.provider;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import dum;
import gwv;
import java.util.Locale;

public class Promotion
  implements Parcelable
{
  public static final Parcelable.Creator<Promotion> CREATOR = new dum();
  public final long a;
  public final int b;
  public final long c;
  public final long d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  public final byte[] k;
  public final int l;
  
  public Promotion(Cursor paramCursor)
  {
    a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    b = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
    c = paramCursor.getLong(paramCursor.getColumnIndex("startTime"));
    d = paramCursor.getLong(paramCursor.getColumnIndex("expirationTime"));
    e = paramCursor.getString(paramCursor.getColumnIndex("titleText"));
    f = paramCursor.getString(paramCursor.getColumnIndex("bodyText"));
    g = paramCursor.getString(paramCursor.getColumnIndex("bodyHtml"));
    h = paramCursor.getString(paramCursor.getColumnIndex("positiveButtonText"));
    i = paramCursor.getString(paramCursor.getColumnIndex("negativeButtonText"));
    j = paramCursor.getString(paramCursor.getColumnIndex("buttonUrl"));
    k = paramCursor.getBlob(paramCursor.getColumnIndex("rawImageData"));
    l = paramCursor.getInt(paramCursor.getColumnIndex("minBuildSdk"));
  }
  
  public Promotion(Parcel paramParcel)
  {
    a = paramParcel.readLong();
    b = paramParcel.readInt();
    c = paramParcel.readLong();
    d = paramParcel.readLong();
    e = paramParcel.readString();
    f = paramParcel.readString();
    g = paramParcel.readString();
    h = paramParcel.readString();
    i = paramParcel.readString();
    j = paramParcel.readString();
    k = paramParcel.createByteArray();
    l = paramParcel.readInt();
  }
  
  public Promotion(gwv paramgwv)
  {
    a = a;
    b = b;
    c = c;
    d = d;
    e = e;
    f = f;
    g = g;
    h = i;
    i = j;
    j = h;
    k = k;
    l = l;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Promotion)) {
      return a == a;
    }
    return super.equals(paramObject);
  }
  
  public int hashCode()
  {
    return (int)a;
  }
  
  public String toString()
  {
    return String.format(Locale.ENGLISH, "Promotion [id=%d]", new Object[] { Long.valueOf(a) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(a);
    paramParcel.writeInt(b);
    paramParcel.writeLong(c);
    paramParcel.writeLong(d);
    paramParcel.writeString(e);
    paramParcel.writeString(f);
    paramParcel.writeString(g);
    paramParcel.writeString(h);
    paramParcel.writeString(i);
    paramParcel.writeString(j);
    paramParcel.writeByteArray(k);
    paramParcel.writeInt(l);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Promotion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */