package com.android.emailcommon.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.BaseColumns;
import bdv;
import bei;
import bhl;
import bhn;
import cvm;

public final class Policy
  extends bdv
  implements Parcelable, BaseColumns
{
  public static final Parcelable.Creator<Policy> CREATOR = new bei();
  public static Uri a;
  public static final String[] x = { "_id", "passwordMode", "passwordMinLength", "passwordExpirationDays", "passwordHistory", "passwordComplexChars", "passwordMaxFails", "maxScreenLockTime", "requireRemoteWipe", "requireEncryption", "requireEncryptionExternal", "requireManualSyncRoaming", "dontAllowCamera", "dontAllowAttachments", "dontAllowHtml", "maxAttachmentSize", "maxTextTruncationSize", "maxHTMLTruncationSize", "maxEmailLookback", "maxCalendarLookback", "passwordRecoveryEnabled", "protocolPoliciesEnforced", "protocolPoliciesUnsupported" };
  public static final Policy y = new Policy();
  private static final String[] z = { "_id", "size", "flags" };
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  public boolean o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public boolean u;
  public String v;
  public String w;
  
  public Policy()
  {
    C = a;
    b = 0;
    i = true;
  }
  
  public Policy(Parcel paramParcel)
  {
    C = a;
    D = paramParcel.readLong();
    b = paramParcel.readInt();
    c = paramParcel.readInt();
    d = paramParcel.readInt();
    f = paramParcel.readInt();
    e = paramParcel.readInt();
    g = paramParcel.readInt();
    h = paramParcel.readInt();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      i = bool1;
      if (paramParcel.readInt() != 1) {
        break label259;
      }
      bool1 = true;
      label102:
      j = bool1;
      if (paramParcel.readInt() != 1) {
        break label264;
      }
      bool1 = true;
      label117:
      k = bool1;
      if (paramParcel.readInt() != 1) {
        break label269;
      }
      bool1 = true;
      label132:
      l = bool1;
      if (paramParcel.readInt() != 1) {
        break label274;
      }
      bool1 = true;
      label147:
      m = bool1;
      if (paramParcel.readInt() != 1) {
        break label279;
      }
      bool1 = true;
      label162:
      n = bool1;
      if (paramParcel.readInt() != 1) {
        break label284;
      }
      bool1 = true;
      label177:
      o = bool1;
      p = paramParcel.readInt();
      q = paramParcel.readInt();
      r = paramParcel.readInt();
      s = paramParcel.readInt();
      t = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label289;
      }
    }
    label259:
    label264:
    label269:
    label274:
    label279:
    label284:
    label289:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      u = bool1;
      v = paramParcel.readString();
      w = paramParcel.readString();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label102;
      bool1 = false;
      break label117;
      bool1 = false;
      break label132;
      bool1 = false;
      break label147;
      bool1 = false;
      break label162;
      bool1 = false;
      break label177;
    }
  }
  
  public static Policy a(Context paramContext, long paramLong)
  {
    return a(paramContext, paramLong, null);
  }
  
  public static Policy a(Context paramContext, long paramLong, ContentObserver paramContentObserver)
  {
    return (Policy)bdv.a(paramContext, Policy.class, a, x, paramLong, paramContentObserver);
  }
  
  public static void a()
  {
    String str = String.valueOf(bdv.H);
    a = Uri.parse(String.valueOf(str).length() + 7 + str + "/policy");
  }
  
  public static void a(Context paramContext, Account paramAccount, Policy paramPolicy)
  {
    paramContext = paramContext.getContentResolver();
    paramAccount = paramContext.query(Attachment.a, z, "accountKey=?", new String[] { Long.toString(D) }, null);
    ContentValues localContentValues = new ContentValues();
    for (;;)
    {
      int i1;
      int i4;
      int i3;
      int i2;
      try
      {
        if (!n) {
          break label143;
        }
        i1 = 0;
        if (!paramAccount.moveToNext()) {
          break label188;
        }
        i4 = paramAccount.getInt(2);
        i3 = paramAccount.getInt(1);
        if ((i4 & 0x200) == 0) {
          break label165;
        }
        i2 = 1;
      }
      finally
      {
        label93:
        long l1;
        paramAccount.close();
      }
      l1 = paramAccount.getLong(0);
      localContentValues.put("flags", Integer.valueOf(i2));
      paramContext.update(ContentUris.withAppendedId(Attachment.a, l1), localContentValues, null, null);
      continue;
      label143:
      if (p > 0)
      {
        i1 = p;
      }
      else
      {
        i1 = Integer.MAX_VALUE;
        continue;
        label165:
        i2 = 0;
        break label195;
        label171:
        i3 = 0;
        label188:
        label195:
        do
        {
          i2 = i4 & 0xFDFF;
          break label93;
          paramAccount.close();
          return;
          if (i3 <= i1) {
            break label171;
          }
          i3 = 1;
          if (i3 == i2) {
            break;
          }
        } while (i3 == 0);
        i2 = i4 | 0x200;
      }
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString, int paramInt)
  {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(":");
    paramStringBuilder.append(paramInt);
    paramStringBuilder.append(" ");
  }
  
  public static long b(Context paramContext, long paramLong)
  {
    return bhn.a(paramContext, Account.a, Account.B, "policyKey=?", new String[] { Long.toString(paramLong) }, null, Long.valueOf(-1L)).longValue();
  }
  
  public final void a(Cursor paramCursor)
  {
    boolean bool2 = true;
    C = a;
    D = paramCursor.getLong(0);
    b = paramCursor.getInt(1);
    c = paramCursor.getInt(2);
    d = paramCursor.getInt(6);
    f = paramCursor.getInt(4);
    e = paramCursor.getInt(3);
    g = paramCursor.getInt(5);
    h = paramCursor.getInt(7);
    if (paramCursor.getInt(8) == 1)
    {
      bool1 = true;
      i = bool1;
      if (paramCursor.getInt(9) != 1) {
        break label341;
      }
      bool1 = true;
      label132:
      j = bool1;
      if (paramCursor.getInt(10) != 1) {
        break label346;
      }
      bool1 = true;
      label151:
      k = bool1;
      if (paramCursor.getInt(11) != 1) {
        break label351;
      }
      bool1 = true;
      label170:
      l = bool1;
      if (paramCursor.getInt(12) != 1) {
        break label356;
      }
      bool1 = true;
      label189:
      m = bool1;
      if (paramCursor.getInt(13) != 1) {
        break label361;
      }
      bool1 = true;
      label208:
      n = bool1;
      if (paramCursor.getInt(14) != 1) {
        break label366;
      }
      bool1 = true;
      label227:
      o = bool1;
      p = paramCursor.getInt(15);
      q = paramCursor.getInt(16);
      r = paramCursor.getInt(17);
      s = paramCursor.getInt(18);
      t = paramCursor.getInt(19);
      if (paramCursor.getInt(20) != 1) {
        break label371;
      }
    }
    label341:
    label346:
    label351:
    label356:
    label361:
    label366:
    label371:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      u = bool1;
      v = paramCursor.getString(21);
      w = paramCursor.getString(22);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label132;
      bool1 = false;
      break label151;
      bool1 = false;
      break label170;
      bool1 = false;
      break label189;
      bool1 = false;
      break label208;
      bool1 = false;
      break label227;
    }
  }
  
  protected final Uri b()
  {
    return a;
  }
  
  public final void d()
  {
    if (b == 0)
    {
      d = 0;
      h = 0;
      c = 0;
      g = 0;
      f = 0;
      e = 0;
    }
    do
    {
      return;
      if ((b != 1) && (b != 2) && (b != 3)) {
        throw new IllegalArgumentException("password mode");
      }
    } while ((b != 1) && (b != 3));
    g = 0;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final ContentValues e()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("passwordMode", Integer.valueOf(b));
    localContentValues.put("passwordMinLength", Integer.valueOf(c));
    localContentValues.put("passwordMaxFails", Integer.valueOf(d));
    localContentValues.put("passwordHistory", Integer.valueOf(f));
    localContentValues.put("passwordExpirationDays", Integer.valueOf(e));
    localContentValues.put("passwordComplexChars", Integer.valueOf(g));
    localContentValues.put("maxScreenLockTime", Integer.valueOf(h));
    localContentValues.put("requireRemoteWipe", Boolean.valueOf(i));
    localContentValues.put("requireEncryption", Boolean.valueOf(j));
    localContentValues.put("requireEncryptionExternal", Boolean.valueOf(k));
    localContentValues.put("requireManualSyncRoaming", Boolean.valueOf(l));
    localContentValues.put("dontAllowCamera", Boolean.valueOf(m));
    localContentValues.put("dontAllowAttachments", Boolean.valueOf(n));
    localContentValues.put("dontAllowHtml", Boolean.valueOf(o));
    localContentValues.put("maxAttachmentSize", Integer.valueOf(p));
    localContentValues.put("maxTextTruncationSize", Integer.valueOf(q));
    localContentValues.put("maxHTMLTruncationSize", Integer.valueOf(r));
    localContentValues.put("maxEmailLookback", Integer.valueOf(s));
    localContentValues.put("maxCalendarLookback", Integer.valueOf(t));
    localContentValues.put("passwordRecoveryEnabled", Boolean.valueOf(u));
    localContentValues.put("protocolPoliciesEnforced", v);
    localContentValues.put("protocolPoliciesUnsupported", w);
    return localContentValues;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Policy)) {}
    do
    {
      return false;
      paramObject = (Policy)paramObject;
    } while ((j != j) || (k != k) || (i != i) || (h != h) || (g != g) || (e != e) || (f != f) || (d != d) || (c != c) || (b != b) || (m != m) || (l != l) || (n != n) || (o != o) || (p != p) || (q != q) || (r != r) || (s != s) || (t != t) || (u != u) || (!bhl.b(v, v)) || (!bhl.b(w, w)));
    return true;
  }
  
  public final int f()
  {
    int i1 = 393216;
    switch (b)
    {
    default: 
      i1 = 0;
    }
    do
    {
      return i1;
      return 131072;
      if (Build.VERSION.SDK_INT >= 21) {
        return 196608;
      }
      cvm.d(cvm.a, "Requested COMPLEX_NUMERIC password on pre-L device", new Object[0]);
      return 393216;
    } while (g != 0);
    return 327680;
  }
  
  public final Uri h(Context paramContext)
  {
    d();
    return super.h(paramContext);
  }
  
  public final int hashCode()
  {
    int i3 = 1;
    int i1;
    int i2;
    if (j)
    {
      i1 = 1;
      if (!k) {
        break label97;
      }
      i2 = 1;
      label20:
      if (!i) {
        break label102;
      }
    }
    for (;;)
    {
      return i1 + (i2 << 1) + (i3 << 2) + (h << 3) + (g << 6) + (e << 12) + (f << 15) + (d << 18) + (c << 22) + (b << 26);
      i1 = 0;
      break;
      label97:
      i2 = 0;
      break label20;
      label102:
      i3 = 0;
    }
  }
  
  public final long j()
  {
    long l2 = e * 86400000L;
    long l1 = l2;
    if (l2 > 0L) {
      l1 = l2 + 120000L;
    }
    return l1;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    if (equals(y))
    {
      localStringBuilder.append("No policies]");
      return localStringBuilder.toString();
    }
    if (b == 0) {
      localStringBuilder.append("Pwd none ");
    }
    for (;;)
    {
      if (j) {
        localStringBuilder.append("encrypt ");
      }
      if (k) {
        localStringBuilder.append("encryptsd ");
      }
      if (m) {
        localStringBuilder.append("nocamera ");
      }
      if (n) {
        localStringBuilder.append("noatts ");
      }
      if (l) {
        localStringBuilder.append("nopushroam ");
      }
      if (p > 0) {
        a(localStringBuilder, "attmax", p);
      }
      localStringBuilder.append("]");
      break;
      a(localStringBuilder, "Pwd numeric", b);
      a(localStringBuilder, "len", c);
      a(localStringBuilder, "cmpx", g);
      a(localStringBuilder, "expy", e);
      a(localStringBuilder, "hist", f);
      a(localStringBuilder, "fail", d);
      a(localStringBuilder, "idle", h);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeLong(D);
    paramParcel.writeInt(b);
    paramParcel.writeInt(c);
    paramParcel.writeInt(d);
    paramParcel.writeInt(f);
    paramParcel.writeInt(e);
    paramParcel.writeInt(g);
    paramParcel.writeInt(h);
    if (i)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!j) {
        break label240;
      }
      paramInt = 1;
      label89:
      paramParcel.writeInt(paramInt);
      if (!k) {
        break label245;
      }
      paramInt = 1;
      label103:
      paramParcel.writeInt(paramInt);
      if (!l) {
        break label250;
      }
      paramInt = 1;
      label117:
      paramParcel.writeInt(paramInt);
      if (!m) {
        break label255;
      }
      paramInt = 1;
      label131:
      paramParcel.writeInt(paramInt);
      if (!n) {
        break label260;
      }
      paramInt = 1;
      label145:
      paramParcel.writeInt(paramInt);
      if (!o) {
        break label265;
      }
      paramInt = 1;
      label159:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(p);
      paramParcel.writeInt(q);
      paramParcel.writeInt(r);
      paramParcel.writeInt(s);
      paramParcel.writeInt(t);
      if (!u) {
        break label270;
      }
    }
    label240:
    label245:
    label250:
    label255:
    label260:
    label265:
    label270:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(v);
      paramParcel.writeString(w);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label89;
      paramInt = 0;
      break label103;
      paramInt = 0;
      break label117;
      paramInt = 0;
      break label131;
      paramInt = 0;
      break label145;
      paramInt = 0;
      break label159;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.emailcommon.provider.Policy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */