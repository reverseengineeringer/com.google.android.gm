package com.android.emailcommon.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bdx;

public class ExchangeOofSettings
  implements Parcelable
{
  public static final Parcelable.Creator<ExchangeOofSettings> CREATOR = new bdx();
  public int a;
  public long b;
  public long c;
  public boolean d;
  public boolean e;
  public int f;
  public String g;
  public boolean h;
  public int i;
  public String j;
  public boolean k;
  public int l;
  public String m;
  
  public ExchangeOofSettings() {}
  
  public ExchangeOofSettings(ContentValues paramContentValues)
  {
    a = d(paramContentValues.getAsInteger("eas_oof_state").intValue());
    b = paramContentValues.getAsLong("eas_oof_start").longValue();
    c = paramContentValues.getAsLong("eas_oof_end").longValue();
    d = paramContentValues.getAsBoolean("is_dirty").booleanValue();
    e = paramContentValues.getAsBoolean("eas_oof_internal_enabled").booleanValue();
    f = c(paramContentValues.getAsInteger("eas_oof_internal_message_type").intValue());
    g = paramContentValues.getAsString("eas_oof_internal_message");
    h = paramContentValues.getAsBoolean("eas_oof_external_known_enabled").booleanValue();
    i = c(paramContentValues.getAsInteger("eas_oof_external_known_message_type").intValue());
    j = paramContentValues.getAsString("eas_oof_external_known_message");
    k = paramContentValues.getAsBoolean("eas_oof_external_unknown_enabled").booleanValue();
    l = c(paramContentValues.getAsInteger("eas_oof_external_unknown_message_type").intValue());
    m = paramContentValues.getAsString("eas_oof_external_unknown_message");
  }
  
  public ExchangeOofSettings(Cursor paramCursor)
  {
    a = d(paramCursor.getInt(paramCursor.getColumnIndex("eas_oof_state")));
    b = paramCursor.getLong(paramCursor.getColumnIndex("eas_oof_start"));
    c = paramCursor.getLong(paramCursor.getColumnIndex("eas_oof_end"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("is_dirty")) != 0)
    {
      bool1 = true;
      d = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("eas_oof_internal_enabled")) == 0) {
        break label282;
      }
      bool1 = true;
      label106:
      e = bool1;
      f = c(paramCursor.getInt(paramCursor.getColumnIndex("eas_oof_internal_message_type")));
      g = paramCursor.getString(paramCursor.getColumnIndex("eas_oof_internal_message"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("eas_oof_external_known_enabled")) == 0) {
        break label287;
      }
      bool1 = true;
      label169:
      h = bool1;
      i = c(paramCursor.getInt(paramCursor.getColumnIndex("eas_oof_external_known_message_type")));
      j = paramCursor.getString(paramCursor.getColumnIndex("eas_oof_external_known_message"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("eas_oof_external_unknown_enabled")) == 0) {
        break label292;
      }
    }
    label282:
    label287:
    label292:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k = bool1;
      l = c(paramCursor.getInt(paramCursor.getColumnIndex("eas_oof_external_unknown_message_type")));
      m = paramCursor.getString(paramCursor.getColumnIndex("eas_oof_external_unknown_message"));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label106;
      bool1 = false;
      break label169;
    }
  }
  
  public ExchangeOofSettings(Parcel paramParcel)
  {
    a = d(paramParcel.readInt());
    b = paramParcel.readLong();
    c = paramParcel.readLong();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      d = bool1;
      if (paramParcel.readInt() == 0) {
        break label152;
      }
      bool1 = true;
      label56:
      e = bool1;
      f = c(paramParcel.readInt());
      g = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label157;
      }
      bool1 = true;
      label89:
      h = bool1;
      i = c(paramParcel.readInt());
      j = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label162;
      }
    }
    label152:
    label157:
    label162:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      k = bool1;
      l = c(paramParcel.readInt());
      m = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label56;
      bool1 = false;
      break label89;
    }
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    String str = paramString.toLowerCase();
    int n = -1;
    switch (str.hashCode())
    {
    default: 
      switch (n)
      {
      case 0: 
      default: 
        paramString = String.valueOf(paramString);
        if (paramString.length() == 0) {}
        break;
      }
      break;
    }
    for (paramString = "Invalid BodyType: ".concat(paramString);; paramString = new String("Invalid BodyType: "))
    {
      throw new IllegalArgumentException(paramString);
      if (!str.equals("text")) {
        break;
      }
      n = 0;
      break;
      if (!str.equals("html")) {
        break;
      }
      n = 1;
      break;
      return 1;
    }
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "TEXT";
    }
    return "HTML";
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2);
  }
  
  private static int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(42 + "Invalid message type provided: " + paramInt);
    }
    return paramInt;
  }
  
  private static int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(39 + "Invalid oof state provided: " + paramInt);
    }
    return paramInt;
  }
  
  public final ContentValues a()
  {
    ContentValues localContentValues = new ContentValues(13);
    localContentValues.put("eas_oof_state", Integer.valueOf(a));
    localContentValues.put("eas_oof_start", Long.valueOf(b));
    localContentValues.put("eas_oof_end", Long.valueOf(c));
    localContentValues.put("is_dirty", Boolean.valueOf(d));
    localContentValues.put("eas_oof_internal_enabled", Boolean.valueOf(e));
    localContentValues.put("eas_oof_internal_message_type", Integer.valueOf(f));
    localContentValues.put("eas_oof_internal_message", g);
    localContentValues.put("eas_oof_external_known_enabled", Boolean.valueOf(h));
    localContentValues.put("eas_oof_external_known_message_type", Integer.valueOf(i));
    localContentValues.put("eas_oof_external_known_message", j);
    localContentValues.put("eas_oof_external_unknown_enabled", Boolean.valueOf(k));
    localContentValues.put("eas_oof_external_unknown_message_type", Integer.valueOf(l));
    localContentValues.put("eas_oof_external_unknown_message", m);
    return localContentValues;
  }
  
  public final boolean b()
  {
    return a != 0;
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
      if (!(paramObject instanceof ExchangeOofSettings)) {
        return false;
      }
      paramObject = (ExchangeOofSettings)paramObject;
      if (a != a) {
        return false;
      }
      if (b != b) {
        return false;
      }
      if (c != c) {
        return false;
      }
      if (d != d) {
        return false;
      }
      if (e != e) {
        return false;
      }
      if (f != f) {
        return false;
      }
      if (h != h) {
        return false;
      }
      if (i != i) {
        return false;
      }
      if (k != k) {
        return false;
      }
      if (l != l) {
        return false;
      }
      if (g != null)
      {
        if (g.equals(g)) {}
      }
      else {
        while (g != null) {
          return false;
        }
      }
      if (j != null)
      {
        if (j.equals(j)) {}
      }
      else {
        while (j != null) {
          return false;
        }
      }
      if (m == null) {
        break;
      }
    } while (m.equals(m));
    while (m != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int i5 = 1;
    int i6 = 0;
    int i7 = a;
    int i8 = (int)(b ^ b >>> 32);
    int i9 = (int)(c ^ c >>> 32);
    int n;
    int i1;
    label60:
    int i10;
    int i2;
    label81:
    int i3;
    label91:
    int i11;
    int i4;
    if (d)
    {
      n = 1;
      if (!e) {
        break label219;
      }
      i1 = 1;
      i10 = f;
      if (g == null) {
        break label224;
      }
      i2 = g.hashCode();
      if (!h) {
        break label229;
      }
      i3 = 1;
      i11 = i;
      if (j == null) {
        break label235;
      }
      i4 = j.hashCode();
      label113:
      if (!k) {
        break label241;
      }
    }
    for (;;)
    {
      int i12 = l;
      if (m != null) {
        i6 = m.hashCode();
      }
      return (((i4 + ((i3 + (i2 + ((i1 + (n + ((i7 * 31 + i8) * 31 + i9) * 31) * 31) * 31 + i10) * 31) * 31) * 31 + i11) * 31) * 31 + i5) * 31 + i12) * 31 + i6;
      n = 0;
      break;
      label219:
      i1 = 0;
      break label60;
      label224:
      i2 = 0;
      break label81;
      label229:
      i3 = 0;
      break label91;
      label235:
      i4 = 0;
      break label113;
      label241:
      i5 = 0;
    }
  }
  
  public String toString()
  {
    int n = a;
    long l1 = b;
    long l2 = c;
    boolean bool1 = d;
    boolean bool2 = e;
    int i1 = f;
    String str1 = g;
    boolean bool3 = h;
    int i2 = i;
    String str2 = j;
    boolean bool4 = k;
    int i3 = l;
    String str3 = m;
    return String.valueOf(str1).length() + 371 + String.valueOf(str2).length() + String.valueOf(str3).length() + "ExchangeOofSettings{state=" + n + ", start=" + l1 + ", end=" + l2 + ", isDirty=" + bool1 + ", internalEnabled=" + bool2 + ", internalMessageType=" + i1 + ", internalMessage='" + str1 + "', externalKnownEnabled=" + bool3 + ", externalKnownMessageType=" + i2 + ", externalKnownMessage='" + str2 + "', externalUnknownEnabled=" + bool4 + ", externalUnknownMessageType=" + i3 + ", externalUnknownMessage='" + str3 + "'}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int n = 1;
    paramParcel.writeInt(a);
    paramParcel.writeLong(b);
    paramParcel.writeLong(c);
    if (d)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!e) {
        break label136;
      }
      paramInt = 1;
      label49:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(f);
      paramParcel.writeString(g);
      if (!h) {
        break label141;
      }
      paramInt = 1;
      label79:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(i);
      paramParcel.writeString(j);
      if (!k) {
        break label146;
      }
    }
    label136:
    label141:
    label146:
    for (paramInt = n;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(l);
      paramParcel.writeString(m);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label49;
      paramInt = 0;
      break label79;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.ExchangeOofSettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */