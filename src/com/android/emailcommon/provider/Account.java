package com.android.emailcommon.provider;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.ContentObserver;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import bdp;
import bdv;
import cvm;
import hbc;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class Account
  extends bdv
  implements Parcelable
{
  public static final Parcelable.Creator<Account> CREATOR = new bdp();
  public static Uri a;
  public static Uri b;
  public static final String[] y = { "_id", "displayName", "emailAddress", "syncKey", "syncLookback", "syncInterval", "hostAuthKeyRecv", "hostAuthKeySend", "flags", "senderName", "ringtoneUri", "protocolVersion", "securitySyncKey", "signature", "policyKey", "pingDuration", "maxAttachmentSize", "sendingCapabilities", "accountCreationHistory" };
  public static final String[] z = { "_id", "flags" };
  @Deprecated
  private String P;
  public String c;
  public String d;
  public String e;
  public int f;
  public int g;
  public long h;
  public long i;
  public int j;
  public String k;
  public String l;
  public String m;
  public String n;
  public long o;
  public long p;
  public long q;
  public long r;
  public String s;
  public transient HostAuth t;
  public transient HostAuth u;
  public transient Policy v;
  public transient AccountDirtyFlags w;
  public transient boolean x;
  
  public Account()
  {
    C = a;
    P = RingtoneManager.getDefaultUri(2).toString();
    g = -1;
    f = -1;
    j = 0;
  }
  
  public Account(Parcel paramParcel)
  {
    C = a;
    D = paramParcel.readLong();
    c = paramParcel.readString();
    d = paramParcel.readString();
    e = paramParcel.readString();
    f = paramParcel.readInt();
    g = paramParcel.readInt();
    h = paramParcel.readLong();
    i = paramParcel.readLong();
    j = paramParcel.readInt();
    paramParcel.readString();
    k = paramParcel.readString();
    P = paramParcel.readString();
    l = paramParcel.readString();
    paramParcel.readInt();
    m = paramParcel.readString();
    n = paramParcel.readString();
    o = paramParcel.readLong();
    q = paramParcel.readLong();
    r = paramParcel.readLong();
    s = paramParcel.readString();
    t = null;
    if (paramParcel.readByte() == 1) {
      t = new HostAuth(paramParcel);
    }
    u = null;
    if (paramParcel.readByte() == 1) {
      u = new HostAuth(paramParcel);
    }
  }
  
  private static long a(Uri paramUri)
  {
    return Long.parseLong((String)paramUri.getPathSegments().get(1));
  }
  
  public static Account a(Context paramContext)
  {
    Cursor localCursor = paramContext.getContentResolver().query(a, y, null, null, null);
    try
    {
      while (localCursor.moveToNext())
      {
        Account localAccount = (Account)a(paramContext, localCursor, Account.class);
        if (localAccount != null)
        {
          int i1 = j;
          if ((i1 & 0x10000) != 0) {
            return localAccount;
          }
        }
      }
      return null;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  public static Account a(Context paramContext, long paramLong)
  {
    return a(paramContext, paramLong, null);
  }
  
  public static Account a(Context paramContext, long paramLong, ContentObserver paramContentObserver)
  {
    return (Account)bdv.a(paramContext, Account.class, a, y, paramLong, paramContentObserver);
  }
  
  public static Account a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }
  
  public static Account a(Context paramContext, String paramString, ContentObserver paramContentObserver)
  {
    Object localObject = null;
    Cursor localCursor = paramContext.getContentResolver().query(a, new String[] { "_id" }, "emailAddress=?", new String[] { paramString }, null);
    if (localCursor != null) {}
    try
    {
      boolean bool = localCursor.moveToFirst();
      if (!bool)
      {
        paramContext = (Context)localObject;
        if (localCursor != null)
        {
          localCursor.close();
          paramContext = (Context)localObject;
        }
        return paramContext;
      }
      paramString = a(paramContext, localCursor.getLong(localCursor.getColumnIndex("_id")), paramContentObserver);
      paramContext = paramString;
      return paramString;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  private static Account a(JSONObject paramJSONObject)
  {
    try
    {
      Account localAccount = new Account();
      c = paramJSONObject.optString("displayName");
      d = paramJSONObject.getString("emailAddress");
      f = paramJSONObject.getInt("syncLookback");
      g = paramJSONObject.getInt("syncInterval");
      t = HostAuth.a(paramJSONObject.getJSONObject("hostAuthRecv"));
      Object localObject = paramJSONObject.optJSONObject("hostAuthSend");
      if (localObject != null) {
        u = HostAuth.a((JSONObject)localObject);
      }
      j = paramJSONObject.getInt("flags");
      k = paramJSONObject.optString("senderName");
      l = paramJSONObject.optString("protocolVersion");
      n = paramJSONObject.optString("signature");
      p = paramJSONObject.optInt("pingDuration", 0);
      localObject = paramJSONObject.optString("maxAttachmentSize", null);
      if (localObject != null) {
        q = Long.parseLong((String)localObject);
      }
      localObject = paramJSONObject.optString("sendingCapabilities", null);
      if (localObject != null) {
        r = Long.parseLong((String)localObject);
      }
      s = paramJSONObject.optString("accountCreationHistory", null);
      return localAccount;
    }
    catch (JSONException paramJSONObject)
    {
      cvm.b(cvm.a, paramJSONObject, "Exception while deserializing Account", new Object[0]);
    }
    return null;
  }
  
  public static void a()
  {
    String str = String.valueOf(bdv.H);
    a = Uri.parse(String.valueOf(str).length() + 8 + str + "/account");
    str = String.valueOf(bdv.I);
    b = Uri.parse(String.valueOf(str).length() + 8 + str + "/account");
  }
  
  public static long b(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getContentResolver().query(a, B, null, null, null);
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        if (!paramContext.moveToFirst()) {
          break label127;
        }
        l1 = -1L;
        long l2 = paramContext.getLong(0);
        if (l2 == paramLong)
        {
          paramLong = l2;
          if (paramContext != null)
          {
            paramContext.close();
            paramLong = l2;
          }
          return paramLong;
        }
        if (l1 != -1L) {
          break label124;
        }
        l1 = l2;
        boolean bool = paramContext.moveToNext();
        if (!bool)
        {
          paramLong = l1;
          return l1;
        }
      }
      finally
      {
        if (paramContext != null) {
          paramContext.close();
        }
      }
      continue;
      label124:
      continue;
      label127:
      long l1 = -1L;
    }
  }
  
  public static Account b(String paramString)
  {
    try
    {
      paramString = a(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      cvm.b(cvm.a, paramString, "Could not parse json for account", new Object[0]);
    }
    return null;
  }
  
  public static String c(Context paramContext, long paramLong)
  {
    String str = null;
    Account localAccount = a(paramContext, paramLong, null);
    if (localAccount != null) {
      str = localAccount.f(paramContext);
    }
    return str;
  }
  
  public static void g(Context paramContext)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    paramContext = localContentResolver.query(a, z, "policyKey IS NOT NULL AND policyKey!=0", null, null);
    try
    {
      while (paramContext.moveToNext())
      {
        int i1 = paramContext.getInt(1);
        if ((i1 & 0x20) != 0)
        {
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("flags", Integer.valueOf(i1 & 0xFFFFFFDF));
          long l1 = paramContext.getLong(0);
          localContentResolver.update(ContentUris.withAppendedId(a, l1), localContentValues, null, null);
        }
      }
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public final android.accounts.Account a(String paramString)
  {
    return new android.accounts.Account(d, paramString);
  }
  
  public final void a(int paramInt)
  {
    j &= 0xFFFFFFF3;
    j |= paramInt << 2 & 0xC;
  }
  
  public final void a(Cursor paramCursor)
  {
    D = paramCursor.getLong(0);
    C = a;
    c = paramCursor.getString(1);
    d = paramCursor.getString(2);
    e = paramCursor.getString(3);
    f = paramCursor.getInt(4);
    g = paramCursor.getInt(5);
    h = paramCursor.getLong(6);
    i = paramCursor.getLong(7);
    j = paramCursor.getInt(8);
    k = paramCursor.getString(9);
    P = paramCursor.getString(10);
    l = paramCursor.getString(11);
    m = paramCursor.getString(12);
    n = paramCursor.getString(13);
    o = paramCursor.getLong(14);
    p = paramCursor.getLong(15);
    q = paramCursor.getLong(16);
    r = paramCursor.getLong(17);
    s = paramCursor.getString(18);
  }
  
  protected final Uri b()
  {
    return a;
  }
  
  public final void b(Context paramContext)
  {
    paramContext = paramContext.getContentResolver().query(g(), y, null, null, null);
    try
    {
      paramContext.moveToFirst();
      a(paramContext);
      return;
    }
    finally
    {
      if (paramContext != null) {
        paramContext.close();
      }
    }
  }
  
  public final long c()
  {
    return D;
  }
  
  public final HostAuth c(Context paramContext)
  {
    if (u == null) {
      if (i == 0L) {
        break label33;
      }
    }
    label33:
    for (u = HostAuth.a(paramContext, i);; u = new HostAuth()) {
      return u;
    }
  }
  
  public final int d()
  {
    return (j & 0xC) >> 2;
  }
  
  public final HostAuth d(Context paramContext)
  {
    if (t == null) {
      if (h == 0L) {
        break label33;
      }
    }
    label33:
    for (t = HostAuth.a(paramContext, h);; t = new HostAuth()) {
      return t;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final ContentValues e()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("displayName", c);
    localContentValues.put("emailAddress", d);
    localContentValues.put("syncKey", e);
    localContentValues.put("syncLookback", Integer.valueOf(f));
    localContentValues.put("syncInterval", Integer.valueOf(g));
    localContentValues.put("hostAuthKeyRecv", Long.valueOf(h));
    localContentValues.put("hostAuthKeySend", Long.valueOf(i));
    localContentValues.put("flags", Integer.valueOf(j));
    localContentValues.put("senderName", k);
    localContentValues.put("ringtoneUri", P);
    localContentValues.put("protocolVersion", l);
    localContentValues.put("securitySyncKey", m);
    localContentValues.put("signature", n);
    localContentValues.put("policyKey", Long.valueOf(o));
    localContentValues.put("pingDuration", Long.valueOf(p));
    localContentValues.put("maxAttachmentSize", Long.valueOf(q));
    localContentValues.put("sendingCapabilities", Long.valueOf(r));
    localContentValues.put("accountCreationHistory", s);
    return localContentValues;
  }
  
  public final AccountDirtyFlags e(Context paramContext)
  {
    if (w == null) {
      if (D == 0L) {
        break label33;
      }
    }
    label33:
    for (w = AccountDirtyFlags.a(paramContext, D);; w = new AccountDirtyFlags()) {
      return w;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Account)) {
        return false;
      }
      paramObject = (Account)paramObject;
    } while ((hbc.a(Long.valueOf(D), Long.valueOf(D))) && (hbc.a(C, C)) && (hbc.a(c, c)) && (hbc.a(d, d)) && (hbc.a(e, e)) && (hbc.a(Integer.valueOf(f), Integer.valueOf(f))) && (hbc.a(Integer.valueOf(g), Integer.valueOf(g))) && (h == h) && (i == i) && (j == j) && (hbc.a(k, k)) && (hbc.a(P, P)) && (hbc.a(l, l)) && (hbc.a(m, m)) && (hbc.a(n, n)) && (o == o) && (p == p) && (q == q) && (r == r) && (hbc.a(s, s)) && (hbc.a(t, t)) && (hbc.a(u, u)) && (hbc.a(v, v)) && (x == x));
    return false;
  }
  
  public final String f(Context paramContext)
  {
    paramContext = d(paramContext);
    if (paramContext != null) {
      return b;
    }
    return null;
  }
  
  public final JSONObject f()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("displayName", c);
      localJSONObject.put("emailAddress", d);
      localJSONObject.put("syncLookback", f);
      localJSONObject.put("syncInterval", g);
      localJSONObject.put("hostAuthRecv", t.f());
      if (u != null) {
        localJSONObject.put("hostAuthSend", u.f());
      }
      localJSONObject.put("flags", j);
      localJSONObject.putOpt("senderName", k);
      localJSONObject.putOpt("protocolVersion", l);
      localJSONObject.putOpt("signature", n);
      localJSONObject.put("pingDuration", p);
      localJSONObject.put("maxAttachmentSize", String.valueOf(q));
      localJSONObject.put("sendingCapabilities", String.valueOf(r));
      localJSONObject.put("accountCreationHistory", s);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      cvm.b(cvm.a, localJSONException, "Exception while serializing Account", new Object[0]);
    }
    return null;
  }
  
  public final Uri h(Context paramContext)
  {
    if (h()) {
      throw new UnsupportedOperationException();
    }
    if ((t == null) && (u == null) && (v != null)) {
      return super.h(paramContext);
    }
    ArrayList localArrayList = new ArrayList();
    int i3;
    int i2;
    int i1;
    Object localObject1;
    Object localObject2;
    if (t != null) {
      if (t.l != null)
      {
        localArrayList.add(ContentProviderOperation.newInsert(t.l.C).withValues(t.l.e()).build());
        i3 = 1;
        i2 = 0;
        i1 = i3 + 1;
        localObject1 = ContentProviderOperation.newInsert(t.C);
        ((ContentProviderOperation.Builder)localObject1).withValues(t.e());
        if (i2 >= 0)
        {
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("credentialKey", Integer.valueOf(0));
          ((ContentProviderOperation.Builder)localObject1).withValueBackReferences((ContentValues)localObject2);
        }
        localArrayList.add(((ContentProviderOperation.Builder)localObject1).build());
      }
    }
    for (;;)
    {
      int i4;
      if (u != null) {
        if (u.l != null) {
          if ((t.l != null) && (t.l.equals(u.l)))
          {
            i4 = i1 + 1;
            localObject1 = ContentProviderOperation.newInsert(u.C);
            ((ContentProviderOperation.Builder)localObject1).withValues(u.e());
            if (i2 >= 0)
            {
              localObject2 = new ContentValues();
              ((ContentValues)localObject2).put("credentialKey", Integer.valueOf(i2));
              ((ContentProviderOperation.Builder)localObject1).withValueBackReferences((ContentValues)localObject2);
            }
            localArrayList.add(((ContentProviderOperation.Builder)localObject1).build());
            i2 = i1;
            i1 = i4;
          }
        }
      }
      for (;;)
      {
        if ((i3 >= 0) || (i2 >= 0))
        {
          localObject2 = new ContentValues();
          if (i3 >= 0) {
            ((ContentValues)localObject2).put("hostAuthKeyRecv", Integer.valueOf(i3));
          }
          localObject1 = localObject2;
          if (i2 >= 0) {
            ((ContentValues)localObject2).put("hostAuthKeySend", Integer.valueOf(i2));
          }
        }
        for (localObject1 = localObject2;; localObject1 = null)
        {
          localObject2 = ContentProviderOperation.newInsert(C);
          ((ContentProviderOperation.Builder)localObject2).withValues(e());
          if (localObject1 != null) {
            ((ContentProviderOperation.Builder)localObject2).withValueBackReferences((ContentValues)localObject1);
          }
          localArrayList.add(((ContentProviderOperation.Builder)localObject2).build());
          try
          {
            paramContext = paramContext.getContentResolver().applyBatch(bdv.F, localArrayList);
            long l1;
            if (i3 >= 0)
            {
              l1 = a(uri);
              h = l1;
              t.D = l1;
            }
            if (i2 >= 0)
            {
              l1 = a(uri);
              i = l1;
              u.D = l1;
            }
            paramContext = uri;
            D = a(paramContext);
            return paramContext;
          }
          catch (RemoteException paramContext)
          {
            cvm.e(cvm.a, paramContext, "Account.save: Error while inserting account row", new Object[0]);
            return null;
          }
          catch (OperationApplicationException paramContext)
          {
            continue;
          }
          localArrayList.add(ContentProviderOperation.newInsert(u.l.C).withValues(u.l.e()).build());
          i4 = i1 + 1;
          i2 = i1;
          i1 = i4;
          break;
        }
        i2 = -1;
        break;
        i2 = -1;
      }
      i2 = -1;
      i3 = 0;
      break;
      i2 = -1;
      i3 = -1;
      i1 = 0;
    }
  }
  
  public final int hashCode()
  {
    throw new UnsupportedOperationException();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    if ((t != null) && (t.b != null))
    {
      localStringBuilder.append(t.b);
      localStringBuilder.append(':');
    }
    if (c != null) {
      localStringBuilder.append(c);
    }
    localStringBuilder.append(':');
    if (d != null) {
      localStringBuilder.append(d);
    }
    localStringBuilder.append(':');
    if (k != null) {
      localStringBuilder.append(k);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(D);
    paramParcel.writeString(c);
    paramParcel.writeString(d);
    paramParcel.writeString(e);
    paramParcel.writeInt(f);
    paramParcel.writeInt(g);
    paramParcel.writeLong(h);
    paramParcel.writeLong(i);
    paramParcel.writeInt(j);
    paramParcel.writeString("");
    paramParcel.writeString(k);
    paramParcel.writeString(P);
    paramParcel.writeString(l);
    paramParcel.writeInt(0);
    paramParcel.writeString(m);
    paramParcel.writeString(n);
    paramParcel.writeLong(o);
    paramParcel.writeLong(q);
    paramParcel.writeLong(r);
    paramParcel.writeString(s);
    if (t != null)
    {
      paramParcel.writeByte((byte)1);
      t.writeToParcel(paramParcel, paramInt);
    }
    while (u != null)
    {
      paramParcel.writeByte((byte)1);
      u.writeToParcel(paramParcel, paramInt);
      return;
      paramParcel.writeByte((byte)0);
    }
    paramParcel.writeByte((byte)0);
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.Account
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */