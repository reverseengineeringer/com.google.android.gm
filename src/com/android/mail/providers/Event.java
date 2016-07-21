package com.android.mail.providers;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cgg;
import cgh;
import hbc;
import java.util.Arrays;

public class Event
  implements Parcelable
{
  public static final Parcelable.Creator<Event> CREATOR = new cgg();
  public final String a;
  public final long b;
  public final long c;
  public final boolean d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final int i;
  public final String j;
  public final int k;
  public final String l;
  
  public Event(Cursor paramCursor)
  {
    a = paramCursor.getString(42);
    b = paramCursor.getLong(43);
    c = paramCursor.getLong(44);
    if (paramCursor.getInt(45) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      e = paramCursor.getString(46);
      f = paramCursor.getString(47);
      g = paramCursor.getString(48);
      h = paramCursor.getString(49);
      i = paramCursor.getInt(50);
      j = paramCursor.getString(51);
      k = paramCursor.getInt(52);
      l = paramCursor.getString(53);
      return;
    }
  }
  
  public Event(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = paramParcel.readLong();
    c = paramParcel.readLong();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      e = paramParcel.readString();
      f = paramParcel.readString();
      g = paramParcel.readString();
      h = paramParcel.readString();
      i = paramParcel.readInt();
      j = paramParcel.readString();
      k = paramParcel.readInt();
      l = paramParcel.readString();
      return;
    }
  }
  
  public Event(cgh paramcgh)
  {
    a = a;
    b = b;
    c = c;
    d = d;
    e = e;
    f = f;
    g = g;
    h = h;
    i = i;
    j = j;
    k = k;
    l = l;
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
      if (!(paramObject instanceof Event)) {
        break;
      }
      paramObject = (Event)paramObject;
    } while ((hbc.a(a, a)) && (b == b) && (c == c) && (d == d) && (hbc.a(e, e)) && (hbc.a(f, f)) && (hbc.a(g, g)) && (hbc.a(h, h)) && (i == i) && (hbc.a(j, j)) && (k == k) && (hbc.a(l, l)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { a, Long.valueOf(b), Long.valueOf(c), Boolean.valueOf(d), e, f, g, h, Integer.valueOf(i), j, Integer.valueOf(k), l });
  }
  
  public String toString()
  {
    return "title: " + a + ", startTime: " + b + ", endTime: " + c + ", allDay: " + d + ", location: " + e + ", organizer: " + f + ", attendees: " + g + ", rrule: " + h + ", icalMethod: " + i + ", responder: " + j + ", responderStatus: " + k + ", syncId: " + l;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeLong(b);
    paramParcel.writeLong(c);
    if (d) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(e);
      paramParcel.writeString(f);
      paramParcel.writeString(g);
      paramParcel.writeString(h);
      paramParcel.writeInt(i);
      paramParcel.writeString(j);
      paramParcel.writeInt(k);
      paramParcel.writeString(l);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Event
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */