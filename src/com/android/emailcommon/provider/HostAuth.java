package com.android.emailcommon.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bdv;
import bdy;
import cvm;
import java.net.URI;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class HostAuth
  extends bdv
  implements Parcelable
{
  public static final Parcelable.Creator<HostAuth> CREATOR = new bdy();
  public static Uri a;
  public static final String[] m = { "_id", "protocol", "address", "port", "flags", "login", "password", "domain", "certAlias", "credentialKey" };
  public String b;
  public String c;
  public int d;
  public int e;
  public String f;
  public String g;
  public String h;
  public String i = null;
  public byte[] j = null;
  public long k;
  public transient Credential l;
  
  public HostAuth()
  {
    C = a;
    d = -1;
    k = -1L;
  }
  
  public HostAuth(Parcel paramParcel)
  {
    C = a;
    D = paramParcel.readLong();
    b = paramParcel.readString();
    c = paramParcel.readString();
    d = paramParcel.readInt();
    e = paramParcel.readInt();
    f = paramParcel.readString();
    g = paramParcel.readString();
    h = paramParcel.readString();
    i = paramParcel.readString();
    if ((e & 0x10) != 0)
    {
      k = paramParcel.readLong();
      l = new Credential(paramParcel);
      if (l.equals(Credential.b)) {
        l = null;
      }
      return;
    }
    k = -1L;
  }
  
  public static HostAuth a(Context paramContext, long paramLong)
  {
    return (HostAuth)bdv.a(paramContext, HostAuth.class, a, m, paramLong);
  }
  
  protected static HostAuth a(JSONObject paramJSONObject)
  {
    try
    {
      HostAuth localHostAuth = new HostAuth();
      b = paramJSONObject.getString("protocol");
      c = paramJSONObject.getString("address");
      d = paramJSONObject.getInt("port");
      e = paramJSONObject.getInt("flags");
      f = paramJSONObject.getString("login");
      g = paramJSONObject.optString("password");
      h = paramJSONObject.optString("domain");
      i = paramJSONObject.optString("certAlias");
      paramJSONObject = paramJSONObject.optJSONObject("credential");
      if (paramJSONObject != null) {
        l = Credential.a(paramJSONObject);
      }
      return localHostAuth;
    }
    catch (JSONException paramJSONObject)
    {
      cvm.b(cvm.a, paramJSONObject, "Exception while deserializing HostAuth", new Object[0]);
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("flag");
    if ((paramInt & 0x1) != 0) {
      localStringBuilder.append("_ssl");
    }
    if ((paramInt & 0x2) != 0) {
      localStringBuilder.append("_tls");
    }
    if ((paramInt & 0x4) != 0) {
      localStringBuilder.append("_authenticate");
    }
    if ((paramInt & 0x8) != 0) {
      localStringBuilder.append("_trustAll");
    }
    if ((paramInt & 0x10) != 0) {
      localStringBuilder.append("_oauth");
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    String str = String.valueOf(bdv.H);
    a = Uri.parse(String.valueOf(str).length() + 9 + str + "/hostauth");
  }
  
  private final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    int n = 1;
    b = paramString1;
    e &= 0xFFFFFFF4;
    e |= paramInt2 & 0x1B;
    if ((paramInt2 & 0x3) != 0) {}
    for (paramInt2 = 1; (paramInt2 == 0) && (!TextUtils.isEmpty(paramString3)); paramInt2 = 0) {
      throw new IllegalArgumentException("Can't use client alias on non-secure connections");
    }
    c = paramString2;
    d = paramInt1;
    if (d == -1)
    {
      if ((e & 0x1) == 0) {
        break label134;
      }
      paramInt1 = n;
      if ("smtp".equals(b)) {
        if (paramInt1 == 0) {
          break label139;
        }
      }
    }
    label134:
    label139:
    for (paramInt1 = 465;; paramInt1 = 587)
    {
      d = paramInt1;
      i = paramString3;
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return Uri.parse(paramString).getScheme().split("\\+")[0];
  }
  
  public final Credential a(Context paramContext)
  {
    if ((l == null) && (k >= 0L)) {
      l = Credential.a(paramContext, k);
    }
    return l;
  }
  
  public final void a(Cursor paramCursor)
  {
    C = a;
    D = paramCursor.getLong(0);
    b = paramCursor.getString(1);
    c = paramCursor.getString(2);
    d = paramCursor.getInt(3);
    e = paramCursor.getInt(4);
    f = paramCursor.getString(5);
    g = paramCursor.getString(6);
    h = paramCursor.getString(7);
    i = paramCursor.getString(8);
    k = paramCursor.getLong(9);
    if (k != -1L) {
      e |= 0x10;
    }
  }
  
  public final void a(String paramString)
  {
    f = paramString;
    if (TextUtils.isEmpty(f))
    {
      e &= 0xFFFFFFFB;
      return;
    }
    e |= 0x4;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    f = paramString1;
    g = paramString2;
    if (TextUtils.isEmpty(f))
    {
      e &= 0xFFFFFFFB;
      return;
    }
    e |= 0x4;
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramInt1, paramInt2, null);
  }
  
  public final Credential b(Context paramContext)
  {
    e |= 0x10;
    if (l == null) {
      if (k < 0L) {
        break label44;
      }
    }
    label44:
    for (l = Credential.a(paramContext, k);; l = new Credential()) {
      return l;
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject1 = null;
    URI localURI = new URI(paramString);
    paramString = localURI.getPath();
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = paramString.substring(1);; paramString = null)
    {
      h = paramString;
      paramString = localURI.getUserInfo();
      String str;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split(":", 2);
        str = paramString[0];
        if (paramString.length > 1) {
          paramString = paramString[1];
        }
      }
      for (;;)
      {
        a(str, paramString);
        paramString = localURI.getScheme();
        str = localURI.getHost();
        int i1 = localURI.getPort();
        String[] arrayOfString = paramString.split("\\+");
        localURI = arrayOfString[0];
        paramString = paramString.split("\\+");
        Object localObject2;
        int n;
        if (paramString.length >= 2)
        {
          localObject2 = paramString[1];
          if ("ssl".equals(localObject2))
          {
            n = 1;
            if ((paramString.length < 3) || (!"trustallcerts".equals(paramString[2]))) {
              break label248;
            }
            n |= 0x8;
          }
        }
        for (;;)
        {
          if (arrayOfString.length > 3) {
            paramString = arrayOfString[3];
          }
          for (;;)
          {
            a(localURI, str, i1, n, paramString);
            return;
            if (!"tls".equals(localObject2)) {
              break label251;
            }
            n = 2;
            break;
            paramString = (String)localObject1;
            if (arrayOfString.length > 2)
            {
              paramString = (String)localObject1;
              if (!"trustallcerts".equals(arrayOfString[2]))
              {
                i = arrayOfString[2];
                paramString = (String)localObject1;
              }
            }
          }
          label248:
          continue;
          label251:
          n = 0;
          break;
          n = 0;
        }
        paramString = null;
        continue;
        paramString = null;
        str = null;
      }
    }
  }
  
  public final void d()
  {
    l = null;
    k = -1L;
    e &= 0xFFFFFFEF;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final ContentValues e()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("protocol", b);
    localContentValues.put("address", c);
    localContentValues.put("port", Integer.valueOf(d));
    localContentValues.put("flags", Integer.valueOf(e));
    localContentValues.put("login", f);
    localContentValues.put("password", g);
    localContentValues.put("domain", h);
    localContentValues.put("certAlias", i);
    localContentValues.put("credentialKey", Long.valueOf(k));
    localContentValues.put("accountKey", Integer.valueOf(0));
    return localContentValues;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof HostAuth)) {}
    do
    {
      return false;
      paramObject = (HostAuth)paramObject;
    } while ((d != d) || (D != D) || (e != e) || (!TextUtils.equals(b, b)) || (!TextUtils.equals(c, c)) || (!TextUtils.equals(f, f)) || (!TextUtils.equals(g, g)) || (!TextUtils.equals(h, h)) || (!TextUtils.equals(i, i)));
    return true;
  }
  
  protected final JSONObject f()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("protocol", b);
      localJSONObject.put("address", c);
      localJSONObject.put("port", d);
      localJSONObject.put("flags", e);
      localJSONObject.put("login", f);
      localJSONObject.putOpt("password", g);
      localJSONObject.putOpt("domain", h);
      localJSONObject.putOpt("certAlias", i);
      if (l != null) {
        localJSONObject.putOpt("credential", l.d());
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      cvm.b(cvm.a, localJSONException, "Exception while serializing HostAuth", new Object[0]);
    }
    return null;
  }
  
  public int hashCode()
  {
    int n = 29;
    if (g != null) {
      n = g.hashCode() + 29;
    }
    int i1 = n;
    if (i != null) {
      i1 = n + (i.hashCode() << 8);
    }
    return (i1 << 8) + e;
  }
  
  public final String[] j()
  {
    if (f != null) {}
    for (String str = f.trim();; str = null) {
      return new String[] { str, g };
    }
  }
  
  public final boolean k()
  {
    return (e & 0x1) != 0;
  }
  
  public final boolean l()
  {
    return (e & 0x8) != 0;
  }
  
  public String toString()
  {
    return String.format(Locale.ENGLISH, "[port: %d \nid: %d \nflags: %d \nprotocol: %s \naddress: %s \nlogin: %s \ndomain: %s \ncertificate alias: %s]", new Object[] { Integer.valueOf(d), Long.valueOf(D), Integer.valueOf(e), b, c, f, h, i });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(D);
    paramParcel.writeString(b);
    paramParcel.writeString(c);
    paramParcel.writeInt(d);
    paramParcel.writeInt(e);
    paramParcel.writeString(f);
    paramParcel.writeString(g);
    paramParcel.writeString(h);
    paramParcel.writeString(i);
    if ((e & 0x10) != 0)
    {
      paramParcel.writeLong(k);
      if (l == null) {
        Credential.b.writeToParcel(paramParcel, paramInt);
      }
    }
    else
    {
      return;
    }
    l.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.HostAuth
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */