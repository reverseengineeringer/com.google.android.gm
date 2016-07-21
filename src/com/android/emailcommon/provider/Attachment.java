package com.android.emailcommon.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bdr;
import bdv;
import cvm;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class Attachment
  extends bdv
  implements Parcelable
{
  public static final Parcelable.Creator<Attachment> CREATOR = new bdr();
  public static Uri a;
  public static Uri b;
  public static Uri c;
  public static String d;
  public static String e;
  public static boolean f;
  public static String g = "attachmentDelete";
  public static final String[] h = { "_id", "fileName", "mimeType", "size", "contentId", "contentUri", "cachedFile", "messageKey", "location", "encoding", "content", "flags", "content_bytes", "accountKey", "uiState", "uiDestination", "uiDownloadedSize", "fileReference" };
  public String i;
  public String j;
  public long k;
  public String l;
  public String m;
  public String n;
  public long o;
  public String p;
  public String q;
  public String r;
  public int s;
  public byte[] t;
  public long u;
  public int v;
  public int w;
  public int x;
  public String y;
  
  public Attachment()
  {
    C = a;
  }
  
  public Attachment(Parcel paramParcel)
  {
    C = a;
    D = paramParcel.readLong();
    i = paramParcel.readString();
    j = paramParcel.readString();
    k = paramParcel.readLong();
    l = paramParcel.readString();
    m = paramParcel.readString();
    n = paramParcel.readString();
    o = paramParcel.readLong();
    p = paramParcel.readString();
    q = paramParcel.readString();
    r = paramParcel.readString();
    s = paramParcel.readInt();
    u = paramParcel.readLong();
    int i1 = paramParcel.readInt();
    if (i1 == -1) {
      t = null;
    }
    for (;;)
    {
      v = paramParcel.readInt();
      w = paramParcel.readInt();
      x = paramParcel.readInt();
      y = paramParcel.readString();
      return;
      t = new byte[i1];
      paramParcel.readByteArray(t);
    }
  }
  
  public static Attachment a(Context paramContext, long paramLong)
  {
    return (Attachment)bdv.a(paramContext, Attachment.class, a, h, paramLong);
  }
  
  public static void a()
  {
    String str = String.valueOf(bdv.H);
    a = Uri.parse(String.valueOf(str).length() + 11 + str + "/attachment");
    b = bdv.H.buildUpon().appendEncodedPath(g).build();
    str = String.valueOf(bdv.H);
    c = Uri.parse(String.valueOf(str).length() + 19 + str + "/attachment/message");
    e = String.valueOf(bdv.E).concat(".attachmentprovider");
    str = String.valueOf(e);
    if (str.length() != 0) {}
    for (str = "content://".concat(str);; str = new String("content://"))
    {
      d = str;
      f = str.equals("content://com.android.email.attachmentprovider");
      return;
    }
  }
  
  public static Attachment[] b(Context paramContext, long paramLong)
  {
    Object localObject1 = ContentUris.withAppendedId(c, paramLong);
    paramContext = paramContext.getContentResolver().query((Uri)localObject1, h, null, null, null);
    try
    {
      int i2 = paramContext.getCount();
      localObject1 = new Attachment[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        paramContext.moveToNext();
        Attachment localAttachment = new Attachment();
        localAttachment.a(paramContext);
        localObject1[i1] = localAttachment;
        i1 += 1;
      }
      return (Attachment[])localObject1;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public final InputStream a(Context paramContext)
  {
    if (t != null) {
      return new ByteArrayInputStream(t);
    }
    String str = n;
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = d();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = Uri.parse((String)localObject);
      try
      {
        paramContext = paramContext.getContentResolver().openInputStream((Uri)localObject);
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        cvm.e(cvm.a, "FileNotFound on %s", new Object[] { toString() });
      }
    }
    return null;
  }
  
  public final void a(Cursor paramCursor)
  {
    C = a;
    D = paramCursor.getLong(0);
    i = paramCursor.getString(1);
    j = paramCursor.getString(2);
    k = paramCursor.getLong(3);
    l = paramCursor.getString(4);
    m = paramCursor.getString(5);
    n = paramCursor.getString(6);
    o = paramCursor.getLong(7);
    p = paramCursor.getString(8);
    q = paramCursor.getString(9);
    r = paramCursor.getString(10);
    s = paramCursor.getInt(11);
    t = paramCursor.getBlob(12);
    u = paramCursor.getLong(13);
    v = paramCursor.getInt(14);
    w = paramCursor.getInt(15);
    x = paramCursor.getInt(16);
    y = paramCursor.getString(17);
  }
  
  public final String d()
  {
    if (m == null) {
      return null;
    }
    if ((!f) && (m.startsWith("content://com.android.email.attachmentprovider")))
    {
      int i1 = m.indexOf('/', 10);
      if (i1 > 0)
      {
        str1 = d;
        String str2 = String.valueOf(m.substring(i1));
        return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "/" + str2;
      }
      String str1 = String.valueOf(m);
      if (str1.length() != 0) {}
      for (str1 = "Improper contentUri format: ".concat(str1);; str1 = new String("Improper contentUri format: "))
      {
        cvm.e("Attachment", str1, new Object[0]);
        return m;
      }
    }
    return m;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final ContentValues e()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fileName", i);
    localContentValues.put("mimeType", j);
    localContentValues.put("size", Long.valueOf(k));
    localContentValues.put("contentId", l);
    localContentValues.put("contentUri", m);
    localContentValues.put("cachedFile", n);
    localContentValues.put("messageKey", Long.valueOf(o));
    localContentValues.put("location", p);
    localContentValues.put("encoding", q);
    localContentValues.put("content", r);
    localContentValues.put("flags", Integer.valueOf(s));
    localContentValues.put("content_bytes", t);
    localContentValues.put("accountKey", Long.valueOf(u));
    localContentValues.put("uiState", Integer.valueOf(v));
    localContentValues.put("uiDestination", Integer.valueOf(w));
    localContentValues.put("uiDownloadedSize", Integer.valueOf(x));
    localContentValues.put("fileReference", y);
    return localContentValues;
  }
  
  public final String toString()
  {
    String str1 = i;
    String str2 = j;
    long l1 = k;
    String str3 = l;
    String str4 = m;
    String str5 = n;
    long l2 = o;
    String str6 = p;
    String str7 = q;
    int i1 = s;
    int i2 = System.identityHashCode(t);
    long l3 = u;
    int i3 = v;
    int i4 = w;
    int i5 = x;
    String str8 = y;
    return String.valueOf(str1).length() + 143 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + "[" + str1 + ", " + str2 + ", " + l1 + ", " + str3 + ", " + str4 + ", " + str5 + ", " + l2 + ", " + str6 + ", " + str7 + ", " + i1 + ", " + i2 + ", " + l3 + "," + i3 + "," + i4 + "," + i5 + "," + str8 + "]";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(D);
    paramParcel.writeString(i);
    paramParcel.writeString(j);
    paramParcel.writeLong(k);
    paramParcel.writeString(l);
    paramParcel.writeString(m);
    paramParcel.writeString(n);
    paramParcel.writeLong(o);
    paramParcel.writeString(p);
    paramParcel.writeString(q);
    paramParcel.writeString(r);
    paramParcel.writeInt(s);
    paramParcel.writeLong(u);
    if (t == null) {
      paramParcel.writeInt(-1);
    }
    for (;;)
    {
      paramParcel.writeInt(v);
      paramParcel.writeInt(w);
      paramParcel.writeInt(x);
      paramParcel.writeString(y);
      return;
      paramParcel.writeInt(t.length);
      paramParcel.writeByteArray(t);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.Attachment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */