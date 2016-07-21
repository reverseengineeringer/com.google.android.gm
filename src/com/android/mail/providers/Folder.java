package com.android.mail.providers;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.text.TextUtils;
import android.util.StateSet;
import android.widget.ImageView;
import bub;
import buj;
import ccx;
import ccz;
import cgi;
import cgj;
import chh;
import cus;
import cvl;
import cvm;
import hbc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Folder
  implements Parcelable, Comparable<Folder>
{
  private static final String A;
  public static final Parcelable.ClassLoaderCreator<Folder> CREATOR = new cgj();
  private static final int[] D = { 16843518 };
  public static final ccx<Folder> y;
  @Deprecated
  private static final Pattern z = Pattern.compile("\\^\\*\\^");
  private int B;
  private int C;
  public int a;
  public String b;
  public cus c;
  public String d;
  public int e;
  public boolean f;
  public int g;
  public Uri h;
  public Uri i;
  public int j;
  public int k;
  public int l;
  public Uri m;
  public int n;
  public int o;
  public int p;
  public int q;
  public String r;
  public String s;
  public Uri t;
  public String u;
  public Uri v;
  public long w;
  public String x;
  
  static
  {
    A = cvl.a;
    y = new cgi();
  }
  
  private Folder()
  {
    d = "Uninitialized!";
  }
  
  public Folder(int paramInt1, String paramString1, Uri paramUri1, String paramString2, int paramInt2, boolean paramBoolean, int paramInt3, Uri paramUri2, Uri paramUri3, int paramInt4, int paramInt5, int paramInt6, Uri paramUri4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, String paramString3, String paramString4, Uri paramUri5, String paramString5, Uri paramUri6, long paramLong, String paramString6)
  {
    a = paramInt1;
    b = paramString1;
    c = new cus(paramUri1);
    d = paramString2;
    e = paramInt2;
    f = paramBoolean;
    g = paramInt3;
    h = paramUri2;
    i = paramUri3;
    j = paramInt4;
    k = paramInt5;
    l = paramInt6;
    m = paramUri4;
    n = paramInt7;
    o = paramInt8;
    p = paramInt9;
    q = paramInt10;
    r = paramString3;
    s = paramString4;
    if (!TextUtils.isEmpty(paramString3)) {
      B = Integer.parseInt(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      C = Integer.parseInt(paramString4);
    }
    t = paramUri5;
    u = paramString5;
    w = paramLong;
    v = paramUri6;
    x = paramString6;
  }
  
  public Folder(Cursor paramCursor)
  {
    a = paramCursor.getInt(0);
    b = paramCursor.getString(1);
    c = new cus(Uri.parse(paramCursor.getString(2)));
    d = paramCursor.getString(3);
    e = paramCursor.getInt(5);
    if (paramCursor.getInt(4) == 1)
    {
      f = bool;
      g = paramCursor.getInt(6);
      localObject = paramCursor.getString(7);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label461;
      }
      localObject = Uri.parse((String)localObject);
      label124:
      h = ((Uri)localObject);
      localObject = paramCursor.getString(8);
      if ((!f) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label467;
      }
      localObject = Uri.parse((String)localObject);
      label162:
      i = ((Uri)localObject);
      j = paramCursor.getInt(9);
      k = paramCursor.getInt(10);
      l = paramCursor.getInt(11);
      localObject = paramCursor.getString(12);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label473;
      }
      localObject = Uri.parse((String)localObject);
      label229:
      m = ((Uri)localObject);
      n = paramCursor.getInt(13);
      o = paramCursor.getInt(14);
      p = paramCursor.getInt(15);
      q = paramCursor.getInt(16);
      r = paramCursor.getString(18);
      s = paramCursor.getString(19);
      if (!TextUtils.isEmpty(r)) {
        B = Integer.parseInt(r);
      }
      if (!TextUtils.isEmpty(s)) {
        C = Integer.parseInt(s);
      }
      localObject = paramCursor.getString(20);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label479;
      }
      localObject = Uri.parse((String)localObject);
      label374:
      t = ((Uri)localObject);
      u = paramCursor.getString(21);
      w = paramCursor.getLong(22);
      localObject = paramCursor.getString(23);
      if (localObject != null) {
        break label485;
      }
    }
    label461:
    label467:
    label473:
    label479:
    label485:
    for (Object localObject = Uri.EMPTY;; localObject = Uri.parse((String)localObject))
    {
      v = ((Uri)localObject);
      int i1 = paramCursor.getColumnIndex("unreadSenders");
      if (i1 == -1) {
        break label495;
      }
      x = paramCursor.getString(i1);
      return;
      bool = false;
      break;
      localObject = null;
      break label124;
      localObject = null;
      break label162;
      localObject = null;
      break label229;
      localObject = null;
      break label374;
    }
    label495:
    x = null;
  }
  
  public Folder(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    a = paramParcel.readInt();
    b = paramParcel.readString();
    c = new cus((Uri)paramParcel.readParcelable(paramClassLoader));
    d = paramParcel.readString();
    e = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      f = bool;
      g = paramParcel.readInt();
      h = ((Uri)paramParcel.readParcelable(paramClassLoader));
      i = ((Uri)paramParcel.readParcelable(paramClassLoader));
      j = paramParcel.readInt();
      k = paramParcel.readInt();
      l = paramParcel.readInt();
      m = ((Uri)paramParcel.readParcelable(paramClassLoader));
      n = paramParcel.readInt();
      o = paramParcel.readInt();
      p = paramParcel.readInt();
      q = paramParcel.readInt();
      r = paramParcel.readString();
      s = paramParcel.readString();
      if (!TextUtils.isEmpty(r)) {
        B = Integer.parseInt(r);
      }
      if (!TextUtils.isEmpty(s)) {
        C = Integer.parseInt(s);
      }
      t = ((Uri)paramParcel.readParcelable(paramClassLoader));
      u = paramParcel.readString();
      v = ((Uri)paramParcel.readParcelable(paramClassLoader));
      w = paramParcel.readLong();
      v = ((Uri)paramParcel.readParcelable(paramClassLoader));
      x = paramParcel.readString();
      return;
    }
  }
  
  public static ccz<Folder> a(Account paramAccount, boolean paramBoolean, String paramString1, String paramString2, Context paramContext)
  {
    if (paramBoolean)
    {
      localObject1 = paramContext.getString(buj.dj);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    for (Object localObject1 = Uri.parse((String)localObject1).buildUpon();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (l != null) {
          localObject2 = l.buildUpon();
        }
      }
      if (localObject2 == null) {
        return null;
      }
      ((Uri.Builder)localObject2).appendQueryParameter("query", paramString1);
      ((Uri.Builder)localObject2).appendQueryParameter("query_identifier", paramString2);
      return new ccz(paramContext, ((Uri.Builder)localObject2).build(), chh.i, y);
    }
  }
  
  @Deprecated
  public static Folder a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Folder localFolder = new Folder();
    int i1 = paramString.indexOf("^*^");
    if (i1 != -1)
    {
      i1 = Integer.valueOf(paramString.substring(0, i1)).intValue();
      paramString = TextUtils.split(paramString, z);
      if (paramString.length < 20)
      {
        cvm.e(A, "split.length %d", new Object[] { Integer.valueOf(paramString.length) });
        return null;
      }
    }
    else
    {
      return null;
    }
    a = i1;
    c = new cus(b(paramString[1]));
    d = paramString[2];
    if (Integer.parseInt(paramString[3]) != 0) {}
    for (;;)
    {
      f = bool;
      e = Integer.parseInt(paramString[4]);
      g = Integer.parseInt(paramString[5]);
      h = b(paramString[6]);
      i = b(paramString[7]);
      k = Integer.parseInt(paramString[8]);
      l = Integer.parseInt(paramString[9]);
      m = b(paramString[10]);
      n = Integer.parseInt(paramString[11]);
      o = Integer.parseInt(paramString[12]);
      p = Integer.parseInt(paramString[13]);
      q = Integer.parseInt(paramString[14]);
      r = paramString[15];
      s = paramString[16];
      if (!TextUtils.isEmpty(r)) {
        B = Integer.parseInt(r);
      }
      if (!TextUtils.isEmpty(s)) {
        C = Integer.parseInt(s);
      }
      t = b(paramString[17]);
      u = paramString[18];
      v = b(paramString[19]);
      x = null;
      return localFolder;
      bool = false;
    }
  }
  
  public static HashMap<Uri, Folder> a(List<Folder> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Folder localFolder = (Folder)paramList.next();
      localHashMap.put(c.a(), localFolder);
    }
    return localHashMap;
  }
  
  public static void a(Folder paramFolder, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    int i1 = q;
    if ((i1 == bub.w) && (f)) {
      i1 = bub.af;
    }
    for (;;)
    {
      if (i1 > 0)
      {
        Drawable localDrawable1 = paramImageView.getResources().getDrawable(i1);
        if (localDrawable1 != null)
        {
          if (paramFolder.a(16384))
          {
            localDrawable1.mutate().setColorFilter(paramFolder.b(16777215), PorterDuff.Mode.MULTIPLY);
            paramFolder = localDrawable1;
          }
          for (;;)
          {
            paramImageView.setImageDrawable(paramFolder);
            return;
            paramFolder = new StateListDrawable();
            Drawable localDrawable2 = paramImageView.getResources().getDrawable(i1);
            localDrawable2.mutate().setColorFilter(-16777216, PorterDuff.Mode.MULTIPLY);
            paramFolder.addState(D, localDrawable2);
            paramFolder.addState(StateSet.WILD_CARD, localDrawable1);
          }
        }
        paramImageView.setImageDrawable(null);
        return;
      }
      cvm.e(cvm.a, "No icon returned for folder %s", new Object[] { paramFolder });
      return;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public static boolean a(Folder paramFolder)
  {
    return (paramFolder == null) || (Uri.EMPTY.equals(v));
  }
  
  private static Uri b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  public static String[] b(List<Folder> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new String[0];
    }
    String[] arrayOfString = new String[paramList.size()];
    paramList = paramList.iterator();
    int i1 = 0;
    while (paramList.hasNext())
    {
      arrayOfString[i1] = nextc.toString();
      i1 += 1;
    }
    return arrayOfString;
  }
  
  private final String c()
  {
    if ((b != null) && (b.length() > 0) && (b.charAt(0) == '^')) {
      return b;
    }
    return "unknown";
  }
  
  public static boolean e(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  public final boolean a()
  {
    return !d(1);
  }
  
  public final boolean a(int paramInt)
  {
    return (e & paramInt) != 0;
  }
  
  public final int b(int paramInt)
  {
    if (!TextUtils.isEmpty(r)) {
      paramInt = B;
    }
    return paramInt;
  }
  
  public final String b()
  {
    if (d(8192)) {
      return "all_inboxes";
    }
    String str;
    if (d(1024))
    {
      str = String.valueOf(c());
      if (str.length() != 0) {
        return "inbox_section:".concat(str);
      }
      return new String("inbox_section:");
    }
    if (d(8194))
    {
      str = String.valueOf(c());
      if (str.length() != 0) {
        return "inbox:".concat(str);
      }
      return new String("inbox:");
    }
    if (d(4)) {
      return "draft";
    }
    if (a(128)) {
      return "important";
    }
    if (d(8)) {
      return "outbox";
    }
    if (d(16)) {
      return "sent";
    }
    if (d(64)) {
      return "spam";
    }
    if (d(128)) {
      return "starred";
    }
    if (d(16384)) {
      return "flagged";
    }
    if (d(32)) {
      return "trash";
    }
    if (d(2048)) {
      return "unread";
    }
    if (d(4096)) {
      return "search";
    }
    if (d(512)) {
      return "all_mail";
    }
    if (a())
    {
      str = String.valueOf(c());
      if (str.length() != 0) {
        return "other:".concat(str);
      }
      return new String("other:");
    }
    return "user_folder";
  }
  
  public final int c(int paramInt)
  {
    if (!TextUtils.isEmpty(s)) {
      paramInt = C;
    }
    return paramInt;
  }
  
  public final boolean d(int paramInt)
  {
    return a(p, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Folder))) {
      return false;
    }
    return hbc.a(c, c);
  }
  
  public int hashCode()
  {
    if (c == null) {
      return 0;
    }
    return c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("{id=");
    localStringBuilder.append(a);
    if (cvm.a(A, 3))
    {
      localStringBuilder.append(", uri=");
      localStringBuilder.append(c);
      localStringBuilder.append(", name=");
      localStringBuilder.append(d);
      localStringBuilder.append(", count=");
      localStringBuilder.append(l);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(a);
    paramParcel.writeString(b);
    Uri localUri;
    if (c != null)
    {
      localUri = c.b;
      paramParcel.writeParcelable(localUri, 0);
      paramParcel.writeString(d);
      paramParcel.writeInt(e);
      if (!f) {
        break label231;
      }
    }
    label231:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(g);
      paramParcel.writeParcelable(h, 0);
      paramParcel.writeParcelable(i, 0);
      paramParcel.writeInt(j);
      paramParcel.writeInt(k);
      paramParcel.writeInt(l);
      paramParcel.writeParcelable(m, 0);
      paramParcel.writeInt(n);
      paramParcel.writeInt(o);
      paramParcel.writeInt(p);
      paramParcel.writeInt(q);
      paramParcel.writeString(r);
      paramParcel.writeString(s);
      paramParcel.writeParcelable(t, 0);
      paramParcel.writeString(u);
      paramParcel.writeParcelable(v, 0);
      paramParcel.writeLong(w);
      paramParcel.writeParcelable(v, 0);
      paramParcel.writeString(x);
      return;
      localUri = null;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Folder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */