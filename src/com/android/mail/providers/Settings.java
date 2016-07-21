package com.android.mail.providers;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import che;
import cvl;
import cvm;
import cxa;
import hbc;
import hbw;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class Settings
  implements Parcelable
{
  private static final Settings B;
  public static final Parcelable.Creator<Settings> CREATOR = new che();
  public static final Settings a;
  private static final String x = cvl.a;
  private int A;
  public final String b;
  public final int c;
  public final int d;
  public final boolean e;
  public final boolean f;
  public final boolean g;
  public final int h;
  public final Uri i;
  public final String j;
  public final boolean k;
  public final long l;
  public final int m;
  public final boolean n;
  public final boolean o;
  public final Uri p;
  public final int q;
  public final int r;
  public final boolean s;
  public final boolean t;
  public final boolean u;
  public final boolean v;
  public final Uri w;
  private final int y;
  private Integer z = null;
  
  static
  {
    Settings localSettings = new Settings();
    a = localSettings;
    B = localSettings;
  }
  
  private Settings()
  {
    b = "";
    y = 3;
    c = 0;
    d = 1;
    e = false;
    f = false;
    g = false;
    i = Uri.EMPTY;
    j = "";
    k = false;
    l = 0L;
    m = 0;
    n = false;
    o = false;
    p = Uri.EMPTY;
    h = -1;
    w = Uri.EMPTY;
    q = 1;
    r = -1;
    s = false;
    t = false;
    u = false;
    v = false;
  }
  
  public Settings(Cursor paramCursor)
  {
    b = hbw.a(paramCursor.getString(paramCursor.getColumnIndex("signature")));
    y = paramCursor.getInt(paramCursor.getColumnIndex("auto_advance"));
    c = paramCursor.getInt(paramCursor.getColumnIndex("reply_behavior"));
    d = paramCursor.getInt(paramCursor.getColumnIndex("conversation_list_icon"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("confirm_delete")) != 0)
    {
      bool1 = true;
      e = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("confirm_archive")) == 0) {
        break label506;
      }
      bool1 = true;
      label129:
      f = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("confirm_send")) == 0) {
        break label511;
      }
      bool1 = true;
      label153:
      g = bool1;
      i = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("default_inbox")));
      j = hbw.a(paramCursor.getString(paramCursor.getColumnIndex("default_inbox_name")));
      if (paramCursor.getInt(paramCursor.getColumnIndex("force_reply_from_default")) == 0) {
        break label516;
      }
      bool1 = true;
      label219:
      k = bool1;
      l = paramCursor.getLong(paramCursor.getColumnIndex("max_attachment_size"));
      m = paramCursor.getInt(paramCursor.getColumnIndex("swipe"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("importance_markers_enabled")) == 0) {
        break label521;
      }
      bool1 = true;
      label279:
      n = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("show_chevrons_enabled")) == 0) {
        break label526;
      }
      bool1 = true;
      label303:
      o = bool1;
      p = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("setup_intent_uri")));
      h = paramCursor.getInt(paramCursor.getColumnIndex("conversation_view_mode"));
      w = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("move_to_inbox")));
      q = paramCursor.getInt(paramCursor.getColumnIndex("show_images"));
      r = paramCursor.getInt(paramCursor.getColumnIndex("welcome_tour_shown_version"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("temp_tls_ii")) == 0) {
        break label531;
      }
      bool1 = true;
      label423:
      s = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("temp_tls_oi")) == 0) {
        break label536;
      }
      bool1 = true;
      label447:
      t = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("temp_fz_ii")) == 0) {
        break label541;
      }
      bool1 = true;
      label471:
      u = bool1;
      if (paramCursor.getInt(paramCursor.getColumnIndex("temp_fz_oi")) == 0) {
        break label546;
      }
    }
    label506:
    label511:
    label516:
    label521:
    label526:
    label531:
    label536:
    label541:
    label546:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      v = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label129;
      bool1 = false;
      break label153;
      bool1 = false;
      break label219;
      bool1 = false;
      break label279;
      bool1 = false;
      break label303;
      bool1 = false;
      break label423;
      bool1 = false;
      break label447;
      bool1 = false;
      break label471;
    }
  }
  
  public Settings(Parcel paramParcel)
  {
    b = paramParcel.readString();
    y = paramParcel.readInt();
    c = paramParcel.readInt();
    d = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      e = bool1;
      if (paramParcel.readInt() == 0) {
        break label270;
      }
      bool1 = true;
      label66:
      f = bool1;
      if (paramParcel.readInt() == 0) {
        break label275;
      }
      bool1 = true;
      label80:
      g = bool1;
      i = cxa.f(paramParcel.readString());
      j = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label280;
      }
      bool1 = true;
      label113:
      k = bool1;
      l = paramParcel.readLong();
      m = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label285;
      }
      bool1 = true;
      label143:
      n = bool1;
      if (paramParcel.readInt() == 0) {
        break label290;
      }
      bool1 = true;
      label157:
      o = bool1;
      p = cxa.f(paramParcel.readString());
      h = paramParcel.readInt();
      w = cxa.f(paramParcel.readString());
      q = paramParcel.readInt();
      r = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label295;
      }
      bool1 = true;
      label217:
      s = bool1;
      if (paramParcel.readInt() == 0) {
        break label300;
      }
      bool1 = true;
      label231:
      t = bool1;
      if (paramParcel.readInt() == 0) {
        break label305;
      }
      bool1 = true;
      label245:
      u = bool1;
      if (paramParcel.readInt() == 0) {
        break label310;
      }
    }
    label270:
    label275:
    label280:
    label285:
    label290:
    label295:
    label300:
    label305:
    label310:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      v = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label66;
      bool1 = false;
      break label80;
      bool1 = false;
      break label113;
      bool1 = false;
      break label143;
      bool1 = false;
      break label157;
      bool1 = false;
      break label217;
      bool1 = false;
      break label231;
      bool1 = false;
      break label245;
    }
  }
  
  private Settings(JSONObject paramJSONObject)
  {
    b = paramJSONObject.optString("signature", Bb);
    y = paramJSONObject.optInt("auto_advance", B.b());
    c = paramJSONObject.optInt("reply_behavior", Bc);
    d = paramJSONObject.optInt("conversation_list_icon", Bd);
    e = paramJSONObject.optBoolean("confirm_delete", Be);
    f = paramJSONObject.optBoolean("confirm_archive", Bf);
    g = paramJSONObject.optBoolean("confirm_send", Bg);
    i = cxa.f(paramJSONObject.optString("default_inbox"));
    j = paramJSONObject.optString("default_inbox_name", Bj);
    k = paramJSONObject.optBoolean("force_reply_from_default", Bk);
    l = paramJSONObject.optLong("max_attachment_size", Bl);
    m = paramJSONObject.optInt("swipe", Bm);
    n = paramJSONObject.optBoolean("importance_markers_enabled", Bn);
    o = paramJSONObject.optBoolean("show_chevrons_enabled", Bo);
    p = cxa.f(paramJSONObject.optString("setup_intent_uri"));
    h = paramJSONObject.optInt("conversation_view_mode", -1);
    w = cxa.f(paramJSONObject.optString("move_to_inbox"));
    q = paramJSONObject.optInt("show_images", Bq);
    r = paramJSONObject.optInt("welcome_tour_shown_version", Br);
    s = paramJSONObject.optBoolean("temp_tls_ii", false);
    t = paramJSONObject.optBoolean("temp_tls_oi", false);
    u = paramJSONObject.optBoolean("temp_fz_ii", false);
    v = paramJSONObject.optBoolean("temp_fz_oi", false);
  }
  
  public static Uri a(Settings paramSettings)
  {
    if (paramSettings == null) {
      return Bi;
    }
    paramSettings = i;
    Uri localUri = Bi;
    if (paramSettings == null) {
      paramSettings = localUri;
    }
    for (;;)
    {
      return (Uri)paramSettings;
    }
  }
  
  public static Settings a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    return new Settings(paramJSONObject);
  }
  
  public static int b(Settings paramSettings)
  {
    if (paramSettings != null) {
      return m;
    }
    return Bm;
  }
  
  public final JSONObject a()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          Object localObject1 = b;
          Object localObject3 = Bb;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = localObject3;
          localJSONObject.put("signature", localObject1);
          localJSONObject.put("auto_advance", b());
          localJSONObject.put("reply_behavior", c);
          localJSONObject.put("conversation_list_icon", d);
          localJSONObject.put("confirm_delete", e);
          localJSONObject.put("confirm_archive", f);
          localJSONObject.put("confirm_send", g);
          localObject1 = i;
          localObject3 = Bi;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = localObject3;
          localJSONObject.put("default_inbox", localObject1);
          localObject1 = j;
          localObject3 = Bj;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = localObject3;
          localJSONObject.put("default_inbox_name", localObject1);
          localJSONObject.put("force_reply_from_default", k);
          localJSONObject.put("max_attachment_size", l);
          localJSONObject.put("swipe", m);
          localJSONObject.put("importance_markers_enabled", n);
          localJSONObject.put("show_chevrons_enabled", o);
          localJSONObject.put("setup_intent_uri", p);
          localJSONObject.put("conversation_view_mode", h);
          localObject1 = w;
          localObject3 = Bw;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = localObject3;
          localJSONObject.put("move_to_inbox", localObject1);
          localJSONObject.put("show_images", q);
          localJSONObject.put("welcome_tour_shown_version", r);
          localJSONObject.put("temp_tls_ii", s);
          localJSONObject.put("temp_tls_oi", t);
          localJSONObject.put("temp_fz_ii", u);
          localJSONObject.put("temp_fz_oi", v);
        }
        catch (JSONException localJSONException)
        {
          cvm.f(x, localJSONException, "Could not serialize settings", new Object[0]);
          continue;
        }
        return localJSONObject;
      }
      finally {}
      continue;
      continue;
    }
  }
  
  public final int b()
  {
    if (z != null) {
      return z.intValue();
    }
    return y;
  }
  
  public final long c()
  {
    if (l == -1L) {
      return 26214400L;
    }
    if (l <= 0L) {
      return 20971520L;
    }
    return Math.min(l, 26214400L);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    cvm.b(x, "Settings.equals(%s)", new Object[] { paramObject });
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
      paramObject = (Settings)paramObject;
      boolean bool;
      if (z != null) {
        bool = z.equals(z);
      }
      while ((!TextUtils.equals(b, b)) || (y != y) || (!bool) || (c != c) || (d != d) || (e != e) || (f != f) || (g != g) || (!hbc.a(i, i)) || (k != k) || (l != l) || (m != m) || (n != n) || (o != o) || (!hbc.a(p, p)) || (h != h) || (!hbc.a(w, w)) || (r != r) || (s != s) || (t != t) || (u != u) || (v != v))
      {
        return false;
        if (z == null) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    if (A == 0) {
      A = Arrays.hashCode(new Object[] { b, Integer.valueOf(y), z, Integer.valueOf(c), Integer.valueOf(d), Boolean.valueOf(e), Boolean.valueOf(f), Boolean.valueOf(g), i, Boolean.valueOf(k), Long.valueOf(l), Integer.valueOf(m), Boolean.valueOf(n), Boolean.valueOf(o), p, Integer.valueOf(h), w, Integer.valueOf(r), Boolean.valueOf(s), Boolean.valueOf(t), Boolean.valueOf(u), Boolean.valueOf(v) });
    }
    return A;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    Object localObject1 = b;
    Object localObject2 = Bb;
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(b());
      paramParcel.writeInt(c);
      paramParcel.writeInt(d);
      if (!e) {
        break label370;
      }
      paramInt = 1;
      label67:
      paramParcel.writeInt(paramInt);
      if (!f) {
        break label375;
      }
      paramInt = 1;
      label81:
      paramParcel.writeInt(paramInt);
      if (!g) {
        break label380;
      }
      paramInt = 1;
      label95:
      paramParcel.writeInt(paramInt);
      localObject1 = i;
      localObject2 = Bi;
      if (localObject1 != null) {
        break label385;
      }
      localObject1 = localObject2;
      label123:
      paramParcel.writeString(localObject1.toString());
      localObject1 = j;
      localObject2 = Bj;
      if (localObject1 != null) {
        break label388;
      }
      localObject1 = localObject2;
      label155:
      paramParcel.writeString((String)localObject1);
      if (!k) {
        break label391;
      }
      paramInt = 1;
      label173:
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(l);
      paramParcel.writeInt(m);
      if (!n) {
        break label396;
      }
      paramInt = 1;
      label203:
      paramParcel.writeInt(paramInt);
      if (!o) {
        break label401;
      }
      paramInt = 1;
      label217:
      paramParcel.writeInt(paramInt);
      localObject1 = p;
      localObject2 = Bp;
      if (localObject1 != null) {
        break label406;
      }
      localObject1 = localObject2;
      label245:
      paramParcel.writeString(localObject1.toString());
      paramParcel.writeInt(h);
      localObject1 = w;
      localObject2 = Bw;
      if (localObject1 != null) {
        break label409;
      }
      localObject1 = localObject2;
      label285:
      paramParcel.writeString(localObject1.toString());
      paramParcel.writeInt(q);
      paramParcel.writeInt(r);
      if (!s) {
        break label412;
      }
      paramInt = 1;
      label319:
      paramParcel.writeInt(paramInt);
      if (!t) {
        break label417;
      }
      paramInt = 1;
      label333:
      paramParcel.writeInt(paramInt);
      if (!u) {
        break label422;
      }
      paramInt = 1;
      label347:
      paramParcel.writeInt(paramInt);
      if (!v) {
        break label427;
      }
    }
    label370:
    label375:
    label380:
    label385:
    label388:
    label391:
    label396:
    label401:
    label406:
    label409:
    label412:
    label417:
    label422:
    label427:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      break;
      paramInt = 0;
      break label67;
      paramInt = 0;
      break label81;
      paramInt = 0;
      break label95;
      break label123;
      break label155;
      paramInt = 0;
      break label173;
      paramInt = 0;
      break label203;
      paramInt = 0;
      break label217;
      break label245;
      break label285;
      paramInt = 0;
      break label319;
      paramInt = 0;
      break label333;
      paramInt = 0;
      break label347;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Settings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */