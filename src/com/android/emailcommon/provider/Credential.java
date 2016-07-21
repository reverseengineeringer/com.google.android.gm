package com.android.emailcommon.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.BaseColumns;
import android.text.TextUtils;
import bdt;
import bdu;
import bdv;
import cvm;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class Credential
  extends bdv
  implements Parcelable, BaseColumns
{
  public static final Parcelable.Creator<Credential> CREATOR = new bdt();
  public static Uri a;
  public static final Credential b = new Credential("", "", "");
  public String c;
  public String d;
  public String e;
  public long f;
  
  public Credential()
  {
    C = a;
  }
  
  public Credential(Parcel paramParcel)
  {
    C = a;
    D = paramParcel.readLong();
    c = paramParcel.readString();
    d = paramParcel.readString();
    e = paramParcel.readString();
    f = paramParcel.readLong();
  }
  
  private Credential(String paramString1, String paramString2, String paramString3)
  {
    C = a;
    D = -1L;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = 0L;
  }
  
  public static Credential a(Context paramContext, long paramLong)
  {
    return (Credential)bdv.a(paramContext, Credential.class, a, bdu.a, paramLong);
  }
  
  protected static Credential a(JSONObject paramJSONObject)
  {
    try
    {
      Credential localCredential = new Credential();
      c = paramJSONObject.getString("provider");
      d = paramJSONObject.optString("accessToken");
      e = paramJSONObject.optString("refreshToken");
      f = paramJSONObject.optInt("expiration", 0);
      return localCredential;
    }
    catch (JSONException paramJSONObject)
    {
      cvm.b(cvm.a, paramJSONObject, "Exception while deserializing Credential", new Object[0]);
    }
    return null;
  }
  
  public static void a()
  {
    String str = String.valueOf(bdv.H);
    a = Uri.parse(String.valueOf(str).length() + 11 + str + "/credential");
  }
  
  public final void a(Cursor paramCursor)
  {
    C = a;
    D = paramCursor.getLong(0);
    c = paramCursor.getString(1);
    d = paramCursor.getString(2);
    e = paramCursor.getString(3);
    f = paramCursor.getLong(4);
  }
  
  protected final JSONObject d()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("provider", c);
      localJSONObject.putOpt("accessToken", d);
      localJSONObject.putOpt("refreshToken", e);
      localJSONObject.put("expiration", f);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      cvm.b(cvm.a, localJSONException, "Exception while serializing Credential", new Object[0]);
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final ContentValues e()
  {
    ContentValues localContentValues = new ContentValues();
    if (TextUtils.isEmpty(c)) {
      cvm.f(cvm.a, "Credential being saved with no provider", new Object[0]);
    }
    localContentValues.put("provider", c);
    localContentValues.put("accessToken", d);
    localContentValues.put("refreshToken", e);
    localContentValues.put("expiration", Long.valueOf(f));
    return localContentValues;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Credential)) {}
    do
    {
      return false;
      paramObject = (Credential)paramObject;
    } while ((!TextUtils.equals(c, c)) || (!TextUtils.equals(d, d)) || (!TextUtils.equals(e, e)) || (f != f));
    return true;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { d, e, Long.valueOf(f) });
  }
  
  public String toString()
  {
    return d().toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(D);
    paramParcel.writeString(c);
    paramParcel.writeString(d);
    paramParcel.writeString(e);
    paramParcel.writeLong(f);
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.Credential
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */