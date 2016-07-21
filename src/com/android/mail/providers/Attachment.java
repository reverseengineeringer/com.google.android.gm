package com.android.mail.providers;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bco;
import bcu;
import bdi;
import bdn;
import bna;
import cfz;
import cvl;
import cvm;
import cvr;
import cxa;
import hgd;
import idc;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Attachment
  implements Parcelable
{
  public static final Parcelable.Creator<Attachment> CREATOR = new cfz();
  public static final String a = cvl.a;
  public String b;
  public String c;
  public int d;
  public Uri e;
  public int f;
  public int g;
  public int h;
  public Uri i;
  public Uri j;
  public int k;
  public int l;
  public String m;
  public boolean n;
  public boolean o;
  private String p;
  private String q;
  private transient Uri r;
  private boolean s;
  
  public Attachment() {}
  
  public Attachment(ContentValues paramContentValues)
  {
    c = paramContentValues.getAsString("_display_name");
    d = paramContentValues.getAsInteger("_size").intValue();
    e = d(paramContentValues.getAsString("uri"));
    p = paramContentValues.getAsString("contentType");
    f = paramContentValues.getAsInteger("state").intValue();
    g = paramContentValues.getAsInteger("destination").intValue();
    h = paramContentValues.getAsInteger("downloadedSize").intValue();
    i = d(paramContentValues.getAsString("contentUri"));
    j = d(paramContentValues.getAsString("thumbnailUri"));
    m = paramContentValues.getAsString("providerData");
    s = paramContentValues.getAsBoolean("supportsDownloadAgain").booleanValue();
    k = paramContentValues.getAsInteger("type").intValue();
    l = paramContentValues.getAsInteger("flags").intValue();
    b = paramContentValues.getAsString("contentId");
    n = paramContentValues.getAsBoolean("hasPreview").booleanValue();
  }
  
  public Attachment(Context paramContext, bdn parambdn, Uri paramUri, String paramString1, String paramString2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        c = bco.a(bco.b(parambdn.b()), "name");
        if (c == null) {
          c = bco.a(bco.b(parambdn.c()), "filename");
        }
        p = cvr.a(c, parambdn.e());
        e = EmlAttachmentProvider.a.buildUpon().appendPath("attachment").appendPath(Integer.toString(paramUri.hashCode())).appendPath(paramString1).appendPath(paramString2).build();
        i = e;
        j = e;
        f = 3;
        m = null;
        s = false;
        g = 0;
        if (paramBoolean)
        {
          i1 = 1;
          k = i1;
          b = paramString2;
          l = 0;
          n = false;
          paramContext = paramContext.getContentResolver();
          paramContext.insert(e, p());
          try
          {
            parambdn = parambdn.a().g_();
            paramUri = paramContext.openOutputStream(e, "rwt");
            d = idc.a(parambdn, paramUri);
            h = d;
            parambdn.close();
            paramUri.close();
            paramContext.insert(e, p());
            return;
          }
          catch (IOException parambdn)
          {
            cvm.e(a, parambdn, "Error in writing attachment to cache", new Object[0]);
            continue;
          }
        }
        int i1 = 0;
      }
      catch (bdi paramContext)
      {
        cvm.e(a, paramContext, "Error parsing eml attachment", new Object[0]);
        return;
      }
    }
  }
  
  public Attachment(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    c = paramCursor.getString(paramCursor.getColumnIndex("_display_name"));
    d = paramCursor.getInt(paramCursor.getColumnIndex("_size"));
    e = Uri.parse(paramCursor.getString(paramCursor.getColumnIndex("uri")));
    p = paramCursor.getString(paramCursor.getColumnIndex("contentType"));
    f = paramCursor.getInt(paramCursor.getColumnIndex("state"));
    g = paramCursor.getInt(paramCursor.getColumnIndex("destination"));
    h = paramCursor.getInt(paramCursor.getColumnIndex("downloadedSize"));
    i = d(paramCursor.getString(paramCursor.getColumnIndex("contentUri")));
    j = d(paramCursor.getString(paramCursor.getColumnIndex("thumbnailUri")));
    m = paramCursor.getString(paramCursor.getColumnIndex("providerData"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("supportsDownloadAgain")) == 1)
    {
      bool1 = true;
      s = bool1;
      k = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      l = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      b = paramCursor.getString(paramCursor.getColumnIndex("contentId"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("hasPreview")) != 1) {
        break label310;
      }
    }
    label310:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      n = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public Attachment(Parcel paramParcel)
  {
    c = paramParcel.readString();
    d = paramParcel.readInt();
    e = ((Uri)paramParcel.readParcelable(null));
    p = paramParcel.readString();
    f = paramParcel.readInt();
    g = paramParcel.readInt();
    h = paramParcel.readInt();
    i = ((Uri)paramParcel.readParcelable(null));
    j = ((Uri)paramParcel.readParcelable(null));
    m = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      s = bool1;
      k = paramParcel.readInt();
      l = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label165;
      }
      bool1 = true;
      label139:
      n = bool1;
      if (paramParcel.readInt() != 1) {
        break label170;
      }
    }
    label165:
    label170:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      o = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label139;
    }
  }
  
  public Attachment(JSONObject paramJSONObject)
  {
    c = paramJSONObject.optString("_display_name", null);
    d = paramJSONObject.optInt("_size");
    e = a(paramJSONObject, "uri");
    p = paramJSONObject.optString("contentType", null);
    f = paramJSONObject.optInt("state");
    g = paramJSONObject.optInt("destination");
    h = paramJSONObject.optInt("downloadedSize");
    i = a(paramJSONObject, "contentUri");
    j = a(paramJSONObject, "thumbnailUri");
    m = paramJSONObject.optString("providerData");
    s = paramJSONObject.optBoolean("supportsDownloadAgain", true);
    k = paramJSONObject.optInt("type");
    l = paramJSONObject.optInt("flags");
    b = paramJSONObject.optString("contentId");
    n = paramJSONObject.optBoolean("hasPreview", false);
  }
  
  private static Uri a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optString(paramString, null);
    if (paramJSONObject == null) {
      return null;
    }
    return Uri.parse(paramJSONObject);
  }
  
  private static String a(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.toString();
    }
    return null;
  }
  
  public static String a(Collection<? extends Attachment> paramCollection)
  {
    if (paramCollection == null) {
      return null;
    }
    localJSONArray = new JSONArray();
    try
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        localJSONArray.put(((Attachment)paramCollection.next()).a());
      }
      return localJSONArray.toString();
    }
    catch (JSONException paramCollection)
    {
      throw new IllegalArgumentException(paramCollection);
    }
  }
  
  public static List<Attachment> a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      while (paramCursor.moveToNext()) {
        localArrayList.add(new Attachment(paramCursor));
      }
    }
    finally
    {
      paramCursor.close();
    }
    return localList;
  }
  
  public static ArrayList<Attachment> c(String paramString)
  {
    localArrayList = new ArrayList();
    if (paramString != null) {
      try
      {
        paramString = new JSONArray(paramString);
        int i1 = 0;
        while (i1 < paramString.length())
        {
          localArrayList.add(new Attachment(paramString.getJSONObject(i1)));
          i1 += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        throw new IllegalArgumentException(paramString);
      }
    }
  }
  
  private static Uri d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  private final ContentValues p()
  {
    ContentValues localContentValues = new ContentValues(12);
    localContentValues.put("_display_name", c);
    localContentValues.put("_size", Integer.valueOf(d));
    localContentValues.put("uri", e.toString());
    localContentValues.put("contentType", p);
    localContentValues.put("state", Integer.valueOf(f));
    localContentValues.put("destination", Integer.valueOf(g));
    localContentValues.put("downloadedSize", Integer.valueOf(h));
    localContentValues.put("contentUri", i.toString());
    localContentValues.put("thumbnailUri", j.toString());
    localContentValues.put("providerData", m);
    localContentValues.put("supportsDownloadAgain", Boolean.valueOf(s));
    localContentValues.put("type", Integer.valueOf(k));
    localContentValues.put("flags", Integer.valueOf(l));
    localContentValues.put("contentId", b);
    localContentValues.put("hasPreview", Boolean.valueOf(n));
    return localContentValues;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("_display_name", c);
    localJSONObject.put("_size", d);
    localJSONObject.put("uri", a(e));
    localJSONObject.put("contentType", p);
    localJSONObject.put("state", f);
    localJSONObject.put("destination", g);
    localJSONObject.put("downloadedSize", h);
    localJSONObject.put("contentUri", a(i));
    localJSONObject.put("thumbnailUri", a(j));
    localJSONObject.put("providerData", m);
    localJSONObject.put("supportsDownloadAgain", s);
    localJSONObject.put("type", k);
    localJSONObject.put("flags", l);
    localJSONObject.put("contentId", b);
    localJSONObject.put("hasPreview", n);
    return localJSONObject;
  }
  
  public final void a(int paramInt)
  {
    f = paramInt;
    if ((paramInt == 1) || (paramInt == 0)) {
      h = 0;
    }
  }
  
  public final void a(String paramString)
  {
    if (!TextUtils.equals(p, paramString))
    {
      q = null;
      p = paramString;
    }
  }
  
  public final boolean b()
  {
    return f == 3;
  }
  
  public boolean b(String paramString)
  {
    if (!TextUtils.equals(c, paramString))
    {
      q = null;
      c = paramString;
      return true;
    }
    return false;
  }
  
  public final boolean c()
  {
    return (!f()) && (!cvr.a(l())) && ((l & 0x200) == 0);
  }
  
  public final boolean d()
  {
    return (b()) && (i != null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean e()
  {
    return (f == 2) || (f == 5);
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
      paramObject = (Attachment)paramObject;
      if (g != g) {
        return false;
      }
      if (h != h) {
        return false;
      }
      if (d != d) {
        return false;
      }
      if (f != f) {
        return false;
      }
      if (s != s) {
        return false;
      }
      if (k != k) {
        return false;
      }
      if (p != null)
      {
        if (p.equals(p)) {}
      }
      else {
        while (p != null) {
          return false;
        }
      }
      if (i != null)
      {
        if (i.equals(i)) {}
      }
      else {
        while (i != null) {
          return false;
        }
      }
      if (c != null)
      {
        if (c.equals(c)) {}
      }
      else {
        while (c != null) {
          return false;
        }
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
      if (m != null)
      {
        if (m.equals(m)) {}
      }
      else {
        while (m != null) {
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
      if (e != null)
      {
        if (e.equals(e)) {}
      }
      else {
        while (e != null) {
          return false;
        }
      }
    } while (n == n);
    return false;
  }
  
  public final boolean f()
  {
    return (f == 3) && (g == 1);
  }
  
  public final boolean g()
  {
    return ((f == 2) || (f == 5)) && (d > 0) && (h > 0) && (h <= d);
  }
  
  public final boolean h()
  {
    return (f == 1) || (f == 3);
  }
  
  public int hashCode()
  {
    int i10 = 1;
    int i1;
    int i2;
    label33:
    int i11;
    int i3;
    label54:
    int i4;
    label70:
    int i12;
    int i13;
    int i14;
    int i5;
    label104:
    int i6;
    label120:
    int i15;
    int i7;
    label142:
    int i8;
    label152:
    int i9;
    label168:
    int i16;
    if (b != null)
    {
      i1 = b.hashCode();
      if (c == null) {
        break label276;
      }
      i2 = c.hashCode();
      i11 = d;
      if (e == null) {
        break label281;
      }
      i3 = e.hashCode();
      if (p == null) {
        break label286;
      }
      i4 = p.hashCode();
      i12 = f;
      i13 = g;
      i14 = h;
      if (i == null) {
        break label292;
      }
      i5 = i.hashCode();
      if (j == null) {
        break label298;
      }
      i6 = j.hashCode();
      i15 = k;
      if (m == null) {
        break label304;
      }
      i7 = m.hashCode();
      if (!s) {
        break label310;
      }
      i8 = 1;
      if (b == null) {
        break label316;
      }
      i9 = b.hashCode();
      i16 = l;
      if (!n) {
        break label322;
      }
    }
    for (;;)
    {
      return ((i9 + (i8 + (i7 + ((i6 + (i5 + ((((i4 + (i3 + ((i2 + i1 * 31) * 31 + i11) * 31) * 31) * 31 + i12) * 31 + i13) * 31 + i14) * 31) * 31) * 31 + i15) * 31) * 31) * 31) * 31 + i16) * 31 + i10;
      i1 = 0;
      break;
      label276:
      i2 = 0;
      break label33;
      label281:
      i3 = 0;
      break label54;
      label286:
      i4 = 0;
      break label70;
      label292:
      i5 = 0;
      break label104;
      label298:
      i6 = 0;
      break label120;
      label304:
      i7 = 0;
      break label142;
      label310:
      i8 = 0;
      break label152;
      label316:
      i9 = 0;
      break label168;
      label322:
      i10 = 0;
    }
  }
  
  public final boolean i()
  {
    return (s) && ((l & 0x200) == 0);
  }
  
  public final boolean j()
  {
    return (n) || (bna.a(l()));
  }
  
  public final Uri k()
  {
    Uri localUri;
    if (cxa.b(r))
    {
      if (!cxa.b(e)) {
        break label52;
      }
      if (!cxa.b(i)) {
        break label44;
      }
      localUri = Uri.EMPTY;
    }
    for (;;)
    {
      r = localUri;
      return r;
      label44:
      localUri = i;
      continue;
      label52:
      localUri = e.buildUpon().clearQuery().build();
    }
  }
  
  public final String l()
  {
    if (TextUtils.isEmpty(q)) {
      q = cvr.a(c, p);
    }
    return q;
  }
  
  public final boolean m()
  {
    return k != 0;
  }
  
  public String n()
  {
    String str1;
    String str2;
    label22:
    String str5;
    int i1;
    String str6;
    String str3;
    if (b == null)
    {
      str1 = "";
      if (c != null) {
        break label144;
      }
      str2 = "";
      str5 = l();
      i1 = d;
      str6 = l();
      if (i == null) {
        break label161;
      }
      str3 = "SERVER_ATTACHMENT";
      label51:
      if (i == null) {
        break label169;
      }
    }
    label144:
    label161:
    label169:
    for (String str4 = i.toString();; str4 = "")
    {
      return TextUtils.join("|", hgd.a(new String[] { str1, str2, str5, String.valueOf(i1), str6, str3, str4, "", String.valueOf(k) }));
      str1 = b;
      break;
      str2 = c.replaceAll("[|\n]", "");
      break label22;
      str3 = "LOCAL_FILE";
      break label51;
    }
  }
  
  public final boolean o()
  {
    return (l & 0x200) == 0;
  }
  
  public String toString()
  {
    try
    {
      JSONObject localJSONObject = a();
      localJSONObject.put("partId", b);
      boolean bool = TextUtils.isEmpty(m);
      if (!bool) {}
      try
      {
        localJSONObject.put("providerData", new JSONObject(m));
        return localJSONObject.toString(4);
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          cvm.e(a, localJSONException2, "JSONException when adding provider data", new Object[0]);
        }
      }
      return super.toString();
    }
    catch (JSONException localJSONException1)
    {
      cvm.e(a, localJSONException1, "JSONException in toString", new Object[0]);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i2 = 1;
    paramParcel.writeString(c);
    paramParcel.writeInt(d);
    paramParcel.writeParcelable(e, paramInt);
    paramParcel.writeString(p);
    paramParcel.writeInt(f);
    paramParcel.writeInt(g);
    paramParcel.writeInt(h);
    paramParcel.writeParcelable(i, paramInt);
    paramParcel.writeParcelable(j, paramInt);
    paramParcel.writeString(m);
    int i1;
    if (s)
    {
      i1 = 1;
      paramParcel.writeInt(i1);
      paramParcel.writeInt(k);
      paramParcel.writeInt(paramInt);
      if (!n) {
        break label148;
      }
      paramInt = 1;
      label122:
      paramParcel.writeInt(paramInt);
      if (!o) {
        break label153;
      }
    }
    label148:
    label153:
    for (paramInt = i2;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      i1 = 0;
      break;
      paramInt = 0;
      break label122;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Attachment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */