package com.google.android.gm.provider;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.text.TextUtils;
import ccx;
import com.android.mail.providers.Folder;
import con;
import cvl;
import dot;
import dou;
import dov;
import dow;
import dri;
import gwi;
import hbw;
import hen;
import hgd;
import hkt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Advertisement
  implements Parcelable, con
{
  public static final Parcelable.ClassLoaderCreator<Advertisement> CREATOR = new dow();
  public static final ccx<Advertisement> O;
  public static final String a = cvl.a;
  public static final Set<Integer> b = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) }));
  public static final Map<String, Integer> c = new hen().b("^sq_ig_i_promo", Integer.valueOf(0)).b("^sq_ig_i_social", Integer.valueOf(1)).b("^sq_ig_i_group", Integer.valueOf(3)).b("^sq_ig_i_notification", Integer.valueOf(2)).b("^sq_ig_i_personal", Integer.valueOf(4)).b();
  public final String A;
  public final Advertisement.AdvertisementOptions B;
  public String C;
  public final Advertisement.AppInstallAdData D;
  public final String E;
  public int F;
  public long G;
  public long H;
  public long I;
  public long J;
  public final String K;
  public final int L;
  public final int M;
  public final String N;
  public final int d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  public final Bitmap k;
  public final String l;
  public final long m;
  public final int n;
  public final String o;
  public boolean p;
  public int q;
  public final String r;
  public final String s;
  public final String t;
  public int u;
  public final String v;
  public final String w;
  public final String x;
  public final String y;
  public final List<String> z;
  
  static
  {
    O = new dot();
  }
  
  public Advertisement(Cursor paramCursor)
  {
    d = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
    e = paramCursor.getString(paramCursor.getColumnIndex("event_id"));
    f = paramCursor.getString(paramCursor.getColumnIndex("advertiser_name"));
    g = paramCursor.getString(paramCursor.getColumnIndex("title"));
    h = paramCursor.getString(paramCursor.getColumnIndex("line1"));
    i = paramCursor.getString(paramCursor.getColumnIndex("visible_url"));
    j = paramCursor.getString(paramCursor.getColumnIndex("redirect_url"));
    k = a(paramCursor.getBlob(paramCursor.getColumnIndex("advertiser_image_data")));
    int i1 = paramCursor.getColumnIndex("body");
    label244:
    Object localObject;
    if (i1 == -1)
    {
      l = null;
      m = paramCursor.getLong(paramCursor.getColumnIndex("expiration"));
      n = paramCursor.getInt(paramCursor.getColumnIndex("reason"));
      o = paramCursor.getString(paramCursor.getColumnIndex("apm_extra_targeting_data"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("starred")) != 1) {
        break label695;
      }
      p = bool;
      q = paramCursor.getInt(paramCursor.getColumnIndex("view_status"));
      r = paramCursor.getString(paramCursor.getColumnIndex("view"));
      s = paramCursor.getString(paramCursor.getColumnIndex("slot"));
      t = paramCursor.getString(paramCursor.getColumnIndex("apm_xsrf_token"));
      u = paramCursor.getInt(paramCursor.getColumnIndex("delete_status"));
      v = paramCursor.getString(paramCursor.getColumnIndex("wta_data"));
      w = paramCursor.getString(paramCursor.getColumnIndex("view_url"));
      x = paramCursor.getString(paramCursor.getColumnIndex("click_url"));
      y = paramCursor.getString(paramCursor.getColumnIndex("interaction_url"));
      localObject = paramCursor.getString(paramCursor.getColumnIndex("body_view_urls"));
      if ((localObject != null) && (!((String)localObject).isEmpty())) {
        break label700;
      }
      localObject = new ArrayList();
    }
    for (;;)
    {
      z = ((List)localObject);
      A = paramCursor.getString(paramCursor.getColumnIndex("obfuscated_data"));
      B = new Advertisement.AdvertisementOptions(paramCursor);
      C = paramCursor.getString(paramCursor.getColumnIndex("click_id"));
      D = new Advertisement.AppInstallAdData(paramCursor);
      E = paramCursor.getString(paramCursor.getColumnIndex("dismiss_survey_data"));
      F = -1;
      G = paramCursor.getLong(paramCursor.getColumnIndex("last_shown_timestamp"));
      H = paramCursor.getLong(paramCursor.getColumnIndex("last_clicked_timestamp"));
      I = paramCursor.getLong(paramCursor.getColumnIndex("last_starred_timestamp"));
      J = -1L;
      K = paramCursor.getString(paramCursor.getColumnIndex("wta_get_url"));
      L = paramCursor.getInt(paramCursor.getColumnIndex("wta_tooltip_type"));
      M = paramCursor.getInt(paramCursor.getColumnIndex("tab"));
      N = paramCursor.getString(paramCursor.getColumnIndex("ad_client_dedup_id_data"));
      return;
      l = paramCursor.getString(i1);
      break;
      label695:
      bool = false;
      break label244;
      label700:
      localObject = ((String)localObject).split(",");
      if (localObject.length == 0) {
        localObject = null;
      } else {
        localObject = new ArrayList(Arrays.asList((Object[])localObject));
      }
    }
  }
  
  public Advertisement(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    d = paramParcel.readInt();
    e = paramParcel.readString();
    f = paramParcel.readString();
    g = paramParcel.readString();
    h = paramParcel.readString();
    i = paramParcel.readString();
    j = paramParcel.readString();
    k = ((Bitmap)paramParcel.readParcelable(null));
    l = paramParcel.readString();
    m = paramParcel.readLong();
    n = paramParcel.readInt();
    o = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      p = bool;
      q = paramParcel.readInt();
      r = paramParcel.readString();
      s = paramParcel.readString();
      t = paramParcel.readString();
      u = paramParcel.readInt();
      v = paramParcel.readString();
      w = paramParcel.readString();
      x = paramParcel.readString();
      y = paramParcel.readString();
      z = new ArrayList();
      paramParcel.readStringList(z);
      A = paramParcel.readString();
      B = ((Advertisement.AdvertisementOptions)paramParcel.readParcelable(paramClassLoader));
      C = paramParcel.readString();
      D = ((Advertisement.AppInstallAdData)paramParcel.readParcelable(paramClassLoader));
      E = paramParcel.readString();
      F = paramParcel.readInt();
      G = paramParcel.readLong();
      H = paramParcel.readLong();
      I = paramParcel.readLong();
      J = paramParcel.readLong();
      K = paramParcel.readString();
      L = paramParcel.readInt();
      M = paramParcel.readInt();
      N = paramParcel.readString();
      return;
    }
  }
  
  public Advertisement(gwi paramgwi, int paramInt, String paramString)
  {
    this(paramgwi, paramInt, paramString, (byte)0);
  }
  
  private Advertisement(gwi paramgwi, int paramInt, String paramString, byte paramByte)
  {
    d = -1;
    e = b;
    f = c;
    g = d;
    h = e;
    i = f;
    j = g;
    k = a(h);
    l = i;
    long l1;
    if ((a & 0x100) != 0)
    {
      paramByte = 1;
      if (paramByte == 0) {
        break label395;
      }
      l1 = j;
      label104:
      m = l1;
      if ((a & 0x200) == 0) {
        break label401;
      }
      paramByte = 1;
      label124:
      if (paramByte == 0) {
        break label407;
      }
      paramByte = k;
      label135:
      n = paramByte;
      o = l;
      p = false;
      q = 0;
      r = m;
      s = n;
      t = paramString;
      u = 0;
      v = o;
      w = p;
      x = q;
      y = r;
      z = Arrays.asList(s);
      A = t;
      B = new Advertisement.AdvertisementOptions(paramgwi);
      C = null;
      D = new Advertisement.AppInstallAdData(paramgwi);
      if (w.length <= 0) {
        break label425;
      }
      paramString = w;
      if (paramString.length != 0) {
        break label413;
      }
      paramString = Collections.emptyList();
      label287:
      paramString = TextUtils.join(",", paramString);
      label295:
      E = paramString;
      F = -1;
      G = -1L;
      H = -1L;
      I = -1L;
      J = -1L;
      K = hbw.a(x);
      if ((a & 0x80000) == 0) {
        break label430;
      }
    }
    label395:
    label401:
    label407:
    label413:
    label425:
    label430:
    for (paramByte = 1;; paramByte = 0)
    {
      if (paramByte != 0) {
        i1 = y;
      }
      L = i1;
      M = paramInt;
      N = a(paramgwi);
      return;
      paramByte = 0;
      break;
      l1 = 0L;
      break label104;
      paramByte = 0;
      break label124;
      paramByte = 0;
      break label135;
      paramString = new hkt(paramString);
      break label287;
      paramString = null;
      break label295;
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    }
    return 4;
  }
  
  public static int a(Folder paramFolder)
  {
    if (paramFolder == null) {
      return -1;
    }
    paramFolder = GmailProvider.a(paramFolder);
    label64:
    int i1;
    switch (paramFolder.hashCode())
    {
    default: 
      i1 = -1;
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        return -1;
      case 0: 
        return 0;
        if (!paramFolder.equals("^sq_ig_i_promo")) {
          break label64;
        }
        i1 = 0;
        continue;
        if (!paramFolder.equals("^sq_ig_i_social")) {
          break label64;
        }
        i1 = 1;
        continue;
        if (!paramFolder.equals("^sq_ig_i_notification")) {
          break label64;
        }
        i1 = 2;
        continue;
        if (!paramFolder.equals("^sq_ig_i_group")) {
          break label64;
        }
        i1 = 3;
        continue;
        if (!paramFolder.equals("^sq_ig_i_personal")) {
          break label64;
        }
        i1 = 4;
      }
    }
    return 1;
    return 2;
    return 3;
    return 4;
  }
  
  private static Bitmap a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private static String a(gwi paramgwi)
  {
    ArrayList localArrayList = new ArrayList(z.length);
    paramgwi = z;
    int i2 = paramgwi.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localArrayList.add(paramgwi[i1]);
      i1 += 1;
    }
    return TextUtils.join(",", hgd.a(localArrayList, new dou()));
  }
  
  public final Uri a(Uri paramUri)
  {
    Uri localUri = paramUri;
    if (!TextUtils.isEmpty(C)) {
      localUri = paramUri.buildUpon().appendQueryParameter("ci", C).build();
    }
    return localUri;
  }
  
  public final List<String> a()
  {
    if (N == null) {
      return new ArrayList();
    }
    return hgd.a(Arrays.asList(N.split(",")), new dov(this));
  }
  
  public final int[] b()
  {
    if (E == null) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = E.split(",");
    } while (arrayOfString.length == 0);
    int[] arrayOfInt = new int[arrayOfString.length];
    int i1 = 0;
    String str2;
    for (;;)
    {
      if (i1 >= arrayOfString.length) {
        break label118;
      }
      try
      {
        arrayOfInt[i1] = Integer.parseInt(arrayOfString[i1]);
        i1 += 1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        str2 = a;
        str1 = String.valueOf(E);
        if (str1.length() == 0) {}
      }
    }
    for (String str1 = "NumberFormatException when parsing dismiss survey options:".concat(str1);; str1 = new String("NumberFormatException when parsing dismiss survey options:"))
    {
      dri.e(str2, str1, new Object[0]);
      arrayOfInt[i1] = -1;
      break;
    }
    label118:
    return arrayOfInt;
  }
  
  public final int c()
  {
    switch (L)
    {
    default: 
      dri.e(a, "Unknown WtaTooltipType: %d.", new Object[] { Integer.valueOf(L) });
      return 1;
    }
    return L;
  }
  
  public final int d()
  {
    try
    {
      if (a(M) != 4) {
        return a(M);
      }
      dri.e(a, "Primary Tab is disabled Tab", new Object[0]);
      return 0;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      dri.e(a, "Invalid Tab: %d", new Object[] { Integer.valueOf(M) });
    }
    return 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean e()
  {
    return false;
  }
  
  public final boolean m()
  {
    return false;
  }
  
  public final String n()
  {
    return l;
  }
  
  public final long o()
  {
    return d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append(" {Ad eventId: ").append(e);
    localStringBuilder.append(", advertiserName: ").append(f);
    localStringBuilder.append(", title: ").append(g);
    localStringBuilder.append(", line1: ").append(h);
    localStringBuilder.append(", visibleUrl: ").append(i);
    localStringBuilder.append(", redirectUrl: ").append(j);
    localStringBuilder.append(", expiration: ").append(m);
    localStringBuilder.append(", reason: ").append(n);
    localStringBuilder.append(", apmExtraTargetingData: ").append(o);
    localStringBuilder.append(", starred: ").append(p);
    localStringBuilder.append(", viewStatus: ").append(q);
    localStringBuilder.append(", view: ").append(r);
    localStringBuilder.append(", slot: ").append(s);
    localStringBuilder.append(", apmXsrfToken: ").append(t);
    localStringBuilder.append(", deleteStatus: ").append(u);
    localStringBuilder.append(", wtaData: ").append(v);
    localStringBuilder.append(", viewUrl: ").append(w);
    localStringBuilder.append(", clickUrl: ").append(x);
    localStringBuilder.append(", interactionUrl: ").append(y);
    localStringBuilder.append(", bodyViewUrls: ").append(z);
    localStringBuilder.append(", obfuscatedData: ").append(A);
    localStringBuilder.append(", advertisementOptions: ").append(B.toString());
    localStringBuilder.append(", reportToBow: ").append(B.b);
    localStringBuilder.append(", sendAdBody: ").append(B.c);
    localStringBuilder.append(", showBodyFeedbackSurvey: ").append(B.d);
    localStringBuilder.append(", clickId: ").append(C);
    localStringBuilder.append(", appInstallAdData: ").append(D.toString());
    localStringBuilder.append(", dismissSurveyData: ").append(E);
    localStringBuilder.append(", dismissSurveyAnswer: ").append(F);
    localStringBuilder.append(", lastShownTimestamp: ").append(G);
    localStringBuilder.append(", lastClickedTimestamp: ").append(H);
    localStringBuilder.append(", lastStarredTimestamp: ").append(I);
    localStringBuilder.append(", lastDismissedTimestamp: ").append(J);
    localStringBuilder.append(", wtaGetUrl: ").append(K);
    localStringBuilder.append(", wtaTooltipType: ").append(L);
    localStringBuilder.append(", tab: ").append(M);
    localStringBuilder.append(", adClientDedupId: ").append(N);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(d);
    paramParcel.writeString(e);
    paramParcel.writeString(f);
    paramParcel.writeString(g);
    paramParcel.writeString(h);
    paramParcel.writeString(i);
    paramParcel.writeString(j);
    paramParcel.writeParcelable(k, 0);
    paramParcel.writeString(l);
    paramParcel.writeLong(m);
    paramParcel.writeInt(n);
    paramParcel.writeString(o);
    if (p) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(q);
      paramParcel.writeString(r);
      paramParcel.writeString(s);
      paramParcel.writeString(t);
      paramParcel.writeInt(u);
      paramParcel.writeString(v);
      paramParcel.writeString(w);
      paramParcel.writeString(x);
      paramParcel.writeString(y);
      paramParcel.writeStringList(z);
      paramParcel.writeString(A);
      paramParcel.writeParcelable(B, 0);
      paramParcel.writeString(C);
      paramParcel.writeParcelable(D, 0);
      paramParcel.writeString(E);
      paramParcel.writeInt(F);
      paramParcel.writeLong(G);
      paramParcel.writeLong(H);
      paramParcel.writeLong(I);
      paramParcel.writeLong(J);
      paramParcel.writeString(K);
      paramParcel.writeInt(L);
      paramParcel.writeInt(M);
      paramParcel.writeString(N);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Advertisement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */