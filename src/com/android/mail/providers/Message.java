package com.android.mail.providers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import bcl;
import bco;
import bdg;
import bdh;
import bdn;
import bgu;
import bgv;
import cgv;
import com.android.emailcommon.mail.Address;
import con;
import cux;
import cxa;
import hbc;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message
  implements Parcelable, con
{
  public static final Parcelable.Creator<Message> CREATOR = new cgv();
  private static final Pattern a;
  public static Pattern c = Pattern.compile("<img\\s+[^>]*src=", 10);
  public boolean A;
  public boolean B;
  public boolean C;
  public boolean D;
  public int E = 1;
  public String F;
  public int G;
  public String H;
  public Uri I;
  public Uri J;
  public String K;
  public int L;
  public int M;
  public int N;
  public int O;
  public String P;
  public boolean Q;
  public boolean R;
  public String S;
  public Event T;
  public int U;
  public int V;
  public int W;
  public String X;
  public boolean Y;
  public String Z;
  public long aa;
  public long ab;
  public int ac;
  public int ad;
  public boolean ae;
  public String af;
  public String ag;
  public Uri ah;
  public int ai;
  public long aj;
  public long ak;
  public transient ArrayList<Attachment> al = null;
  private transient String[] am = null;
  private transient String[] an = null;
  private transient String[] ao = null;
  private transient String[] ap = null;
  private transient String[] aq = null;
  private String b;
  public long d;
  public String e;
  public Uri f;
  public Uri g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public long n;
  public String o;
  public String p;
  public String q;
  public String r;
  public boolean s;
  public Uri t;
  public int u;
  public boolean v;
  public boolean w;
  public Uri x;
  public Uri y;
  public long z;
  
  static
  {
    a = Pattern.compile("^<?([^>]+)>?$");
  }
  
  public Message() {}
  
  public Message(Context paramContext, bcl parambcl, Uri paramUri)
  {
    a(Address.b(parambcl.i()));
    b(Address.b(parambcl.a(bdh.a)));
    c(Address.b(parambcl.a(bdh.b)));
    d(Address.b(parambcl.a(bdh.c)));
    e(Address.b(parambcl.j()));
    h = parambcl.h();
    Object localObject1 = parambcl.g();
    Object localObject2 = g;
    if (localObject1 != null) {
      n = ((Date)localObject1).getTime();
    }
    Object localObject3;
    for (;;)
    {
      A = false;
      u = 0;
      N = 0;
      D = false;
      K = null;
      z = 0L;
      O = 0;
      P = null;
      w = false;
      Q = false;
      R = false;
      U = 0;
      V = 0;
      W = 0;
      X = null;
      Y = false;
      ae = false;
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      bco.a(parambcl, (ArrayList)localObject1, (ArrayList)localObject2);
      localObject3 = bgu.a((ArrayList)localObject1);
      i = c;
      p = a;
      o = cux.a(b);
      al = new ArrayList();
      parambcl = parambcl.k();
      localObject2 = ((ArrayList)localObject2).iterator();
      int i1 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bdn)((Iterator)localObject2).next();
        al.add(new Attachment(paramContext, (bdn)localObject3, paramUri, parambcl, Integer.toString(i1), false));
        i1 += 1;
      }
      if (localObject2 != null) {
        n = ((Date)localObject2).getTime();
      } else {
        n = System.currentTimeMillis();
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bdn)((Iterator)localObject1).next();
      localObject3 = ((bdn)localObject2).a("Content-ID");
      if ((localObject3 != null) && (localObject3.length == 1))
      {
        localObject3 = a.matcher(localObject3[0]).replaceAll("$1");
        al.add(new Attachment(paramContext, (bdn)localObject2, paramUri, parambcl, (String)localObject3, true));
      }
    }
    boolean bool;
    if (!al.isEmpty())
    {
      bool = true;
      w = bool;
      if (!w) {
        break label569;
      }
    }
    label569:
    for (paramContext = EmlAttachmentProvider.a.buildUpon().appendPath("attachments").appendPath(Integer.toString(paramUri.hashCode())).appendPath(parambcl).build();; paramContext = null)
    {
      x = paramContext;
      y = EmlAttachmentProvider.a(paramUri, parambcl);
      return;
      bool = false;
      break;
    }
  }
  
  public Message(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    for (;;)
    {
      try
      {
        d = paramCursor.getLong(0);
        e = paramCursor.getString(1);
        Object localObject1 = paramCursor.getString(2);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = Uri.parse((String)localObject1);
          f = ((Uri)localObject1);
          localObject1 = paramCursor.getString(3);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1055;
          }
          localObject1 = Uri.parse((String)localObject1);
          g = ((Uri)localObject1);
          h = paramCursor.getString(4);
          i = paramCursor.getString(5);
          j = paramCursor.getString(6);
          k = paramCursor.getString(7);
          l = paramCursor.getString(8);
          m = paramCursor.getString(9);
          b = paramCursor.getString(10);
          n = paramCursor.getLong(11);
          o = paramCursor.getString(12);
          p = paramCursor.getString(13);
          q = paramCursor.getString(14);
          r = paramCursor.getString(15);
          if (paramCursor.getInt(16) == 0) {
            break label1061;
          }
          bool1 = true;
          s = bool1;
          localObject1 = paramCursor.getString(17);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1066;
          }
          localObject1 = Uri.parse((String)localObject1);
          t = ((Uri)localObject1);
          u = paramCursor.getInt(18);
          if (paramCursor.getInt(19) == 0) {
            break label1072;
          }
          bool1 = true;
          v = bool1;
          if (paramCursor.getInt(20) == 0) {
            break label1077;
          }
          bool1 = true;
          w = bool1;
          localObject1 = paramCursor.getString(21);
          if ((!w) || (TextUtils.isEmpty((CharSequence)localObject1))) {
            break label1082;
          }
          localObject1 = Uri.parse((String)localObject1);
          x = ((Uri)localObject1);
          localObject1 = paramCursor.getString(22);
          if ((!w) || (TextUtils.isEmpty((CharSequence)localObject1))) {
            break label1088;
          }
          localObject1 = Uri.parse((String)localObject1);
          y = ((Uri)localObject1);
          z = paramCursor.getLong(23);
          if (paramCursor.getInt(24) == 0) {
            break label1094;
          }
          bool1 = true;
          A = bool1;
          if (paramCursor.getInt(25) == 0) {
            break label1099;
          }
          bool1 = true;
          B = bool1;
          if (paramCursor.getInt(26) == 0) {
            break label1104;
          }
          bool1 = true;
          C = bool1;
          if (paramCursor.getInt(27) == 0) {
            break label1109;
          }
          bool1 = true;
          D = bool1;
          G = paramCursor.getInt(28);
          H = paramCursor.getString(29);
          localObject1 = paramCursor.getString(31);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1114;
          }
          localObject1 = Uri.parse((String)localObject1);
          I = ((Uri)localObject1);
          J = cxa.f(paramCursor.getString(32));
          K = paramCursor.getString(33);
          L = paramCursor.getInt(34);
          M = paramCursor.getInt(35);
          N = paramCursor.getInt(36);
          O = paramCursor.getInt(37);
          P = paramCursor.getString(38);
          if (paramCursor.getInt(39) == 0) {
            break label1120;
          }
          bool1 = true;
          Q = bool1;
          if (paramCursor.getInt(40) == 0) {
            break label1125;
          }
          bool1 = true;
          R = bool1;
          S = paramCursor.getString(41);
          U = paramCursor.getInt(54);
          V = paramCursor.getInt(55);
          if (paramCursor.getInt(57) == 0) {
            break label1130;
          }
          bool1 = true;
          Y = bool1;
          E = paramCursor.getInt(paramCursor.getColumnIndex("priority"));
          F = paramCursor.getString(paramCursor.getColumnIndex("eventUid"));
          Z = paramCursor.getString(60);
          aa = paramCursor.getLong(61);
          ab = paramCursor.getLong(62);
          ac = paramCursor.getInt(63);
          ad = paramCursor.getInt(65);
          if ((d()) || (e())) {
            T = new Event(paramCursor);
          }
          if (paramCursor.getInt(64) == 0) {
            break label1135;
          }
          bool1 = bool2;
          ae = bool1;
          ag = paramCursor.getString(67);
          af = paramCursor.getString(66);
          String str = paramCursor.getString(68);
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = Uri.parse(str);
          }
          ah = ((Uri)localObject1);
          ai = paramCursor.getInt(69);
          aj = paramCursor.getLong(70);
          ak = paramCursor.getLong(71);
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        int i1 = paramCursor.getCount();
        throw new IllegalStateException(58 + "Failed to create Message from cursor with " + i1 + " rows", localIllegalStateException);
      }
      Object localObject2 = null;
      continue;
      label1055:
      localObject2 = null;
      continue;
      label1061:
      boolean bool1 = false;
      continue;
      label1066:
      localObject2 = null;
      continue;
      label1072:
      bool1 = false;
      continue;
      label1077:
      bool1 = false;
      continue;
      label1082:
      localObject2 = null;
      continue;
      label1088:
      localObject2 = null;
      continue;
      label1094:
      bool1 = false;
      continue;
      label1099:
      bool1 = false;
      continue;
      label1104:
      bool1 = false;
      continue;
      label1109:
      bool1 = false;
      continue;
      label1114:
      localObject2 = null;
      continue;
      label1120:
      bool1 = false;
      continue;
      label1125:
      bool1 = false;
      continue;
      label1130:
      bool1 = false;
      continue;
      label1135:
      bool1 = false;
    }
  }
  
  public Message(Parcel paramParcel)
  {
    d = paramParcel.readLong();
    e = paramParcel.readString();
    f = ((Uri)paramParcel.readParcelable(null));
    g = ((Uri)paramParcel.readParcelable(null));
    h = paramParcel.readString();
    i = paramParcel.readString();
    j = paramParcel.readString();
    k = paramParcel.readString();
    l = paramParcel.readString();
    m = paramParcel.readString();
    b = paramParcel.readString();
    n = paramParcel.readLong();
    o = paramParcel.readString();
    p = paramParcel.readString();
    q = paramParcel.readString();
    r = paramParcel.readString();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      s = bool1;
      t = ((Uri)paramParcel.readParcelable(null));
      u = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label572;
      }
      bool1 = true;
      label220:
      v = bool1;
      if (paramParcel.readInt() == 0) {
        break label577;
      }
      bool1 = true;
      label234:
      w = bool1;
      x = ((Uri)paramParcel.readParcelable(null));
      z = paramParcel.readLong();
      if (paramParcel.readInt() == 0) {
        break label582;
      }
      bool1 = true;
      label268:
      A = bool1;
      G = paramParcel.readInt();
      H = paramParcel.readString();
      I = ((Uri)paramParcel.readParcelable(null));
      J = ((Uri)paramParcel.readParcelable(null));
      K = paramParcel.readString();
      L = paramParcel.readInt();
      M = paramParcel.readInt();
      N = paramParcel.readInt();
      O = paramParcel.readInt();
      P = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label587;
      }
      bool1 = true;
      label370:
      Q = bool1;
      if (paramParcel.readInt() == 0) {
        break label592;
      }
      bool1 = true;
      label384:
      R = bool1;
      if (d()) {
        T = ((Event)paramParcel.readParcelable(getClass().getClassLoader()));
      }
      U = paramParcel.readInt();
      V = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {
        break label597;
      }
      bool1 = true;
      label439:
      Y = bool1;
      E = paramParcel.readInt();
      F = paramParcel.readString();
      Z = paramParcel.readString();
      aa = paramParcel.readLong();
      ab = paramParcel.readLong();
      ac = paramParcel.readInt();
      ad = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label602;
      }
    }
    label572:
    label577:
    label582:
    label587:
    label592:
    label597:
    label602:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ae = bool1;
      ag = paramParcel.readString();
      af = paramParcel.readString();
      ah = ((Uri)paramParcel.readParcelable(null));
      ai = paramParcel.readInt();
      aj = paramParcel.readLong();
      ak = paramParcel.readLong();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label220;
      bool1 = false;
      break label234;
      bool1 = false;
      break label268;
      bool1 = false;
      break label370;
      bool1 = false;
      break label384;
      bool1 = false;
      break label439;
    }
  }
  
  public static String[] a(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      arrayOfString[i1] = Address.a(paramArrayOfString[i1]);
      i1 += 1;
    }
    return arrayOfString;
  }
  
  public static boolean b(Message paramMessage)
  {
    return c(paramMessage) > 204800;
  }
  
  public static int c(Message paramMessage)
  {
    int i2 = 0;
    if (paramMessage == null) {
      return 0;
    }
    if (o != null) {}
    for (int i1 = o.length();; i1 = 0)
    {
      if (p != null) {
        i2 = p.length();
      }
      return i2 + i1;
    }
  }
  
  public static String[] f(String paramString)
  {
    int i1 = 0;
    if (TextUtils.isEmpty(paramString)) {
      return new String[0];
    }
    paramString = Rfc822Tokenizer.tokenize(paramString);
    String[] arrayOfString = new String[paramString.length];
    while (i1 < paramString.length)
    {
      arrayOfString[i1] = paramString[i1].toString();
      i1 += 1;
    }
    return arrayOfString;
  }
  
  public static boolean g(String paramString)
  {
    return (paramString != null) && (paramString.length() > 204800);
  }
  
  public final void a(String paramString)
  {
    try
    {
      j = paramString;
      am = null;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean a(Message paramMessage)
  {
    return (paramMessage != null) && (TextUtils.equals(j, j)) && (N == N) && (D == D) && (B == B) && (TextUtils.equals(k, k)) && (TextUtils.equals(l, l)) && (TextUtils.equals(m, m)) && (TextUtils.equals(h, h)) && (TextUtils.equals(o, o)) && (TextUtils.equals(p, p)) && (TextUtils.equals(q, q)) && (TextUtils.equals(r, r)) && (hbc.a(x, x)) && (hbc.a(l(), paramMessage.l())) && (hbc.a(T, T)) && (TextUtils.equals(K, K)) && (R == R) && (E == E) && (hbc.a(F, F)) && (ad == ad);
  }
  
  public final void b(String paramString)
  {
    try
    {
      k = paramString;
      an = null;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final int c(boolean paramBoolean)
  {
    int i3;
    if (paramBoolean) {
      i3 = l().size();
    }
    ArrayList localArrayList;
    int i4;
    int i2;
    int i1;
    do
    {
      return i3;
      localArrayList = l();
      i4 = localArrayList.size();
      i2 = 0;
      i1 = 0;
      i3 = i1;
    } while (i2 >= i4);
    if (!((Attachment)localArrayList.get(i2)).m()) {
      i1 += 1;
    }
    for (;;)
    {
      i2 += 1;
      break;
    }
  }
  
  public final ContentValues c()
  {
    Object localObject2 = null;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("conversationId", Long.valueOf(d));
    localContentValues.put("serverMessageId", e);
    label239:
    int i1;
    if (f != null)
    {
      localObject1 = f.toString();
      localContentValues.put("messageUri", (String)localObject1);
      localContentValues.put("subject", h);
      localContentValues.put("snippet", i);
      localContentValues.put("fromAddress", j);
      localContentValues.put("toAddresses", k);
      localContentValues.put("ccAddresses", l);
      localContentValues.put("bccAddresses", m);
      localContentValues.put("replyToAddress", b);
      localContentValues.put("dateReceivedMs", Long.valueOf(n));
      localContentValues.put("bodyHtml", o);
      localContentValues.put("bodyText", p);
      localContentValues.put("stylesheet", q);
      localContentValues.put("stylesheetRestrictor", r);
      localContentValues.put("bodyEmbedsExternalResources", Boolean.valueOf(s));
      if (t == null) {
        break label720;
      }
      localObject1 = t.toString();
      localContentValues.put("refMessageId", (String)localObject1);
      localContentValues.put("draftType", Integer.valueOf(u));
      if (!v) {
        break label725;
      }
      i1 = 1;
      label272:
      localContentValues.put("appendRefMessageContent", Integer.valueOf(i1));
      localContentValues.put("hasAttachments", Boolean.valueOf(w));
      if (x == null) {
        break label730;
      }
      localObject1 = x.toString();
      label314:
      localContentValues.put("attachmentListUri", (String)localObject1);
      localContentValues.put("messageFlags", Long.valueOf(z));
      localContentValues.put("alwaysShowImages", Boolean.valueOf(A));
      localContentValues.put("quotedTextStartPos", Integer.valueOf(G));
      localContentValues.put("attachments", H);
      if (J == null) {
        break label735;
      }
    }
    label720:
    label725:
    label730:
    label735:
    for (Object localObject1 = J.toString();; localObject1 = null)
    {
      localContentValues.put("eventIntentUri", (String)localObject1);
      localContentValues.put("spamWarningString", K);
      localContentValues.put("spamWarningLevel", Integer.valueOf(L));
      localContentValues.put("spamWarningLinkType", Integer.valueOf(M));
      localContentValues.put("sendingState", Integer.valueOf(N));
      localContentValues.put("clipped", Integer.valueOf(O));
      localContentValues.put("permalink", P);
      localContentValues.put("senderExcludedFromBlockOption", Boolean.valueOf(Q));
      localContentValues.put("senderBlocked", Boolean.valueOf(R));
      localContentValues.put("priority", Integer.valueOf(E));
      localContentValues.put("eventUid", F);
      localContentValues.put("meetingResponseComment", Z);
      localContentValues.put("proposedStartTime", Long.valueOf(aa));
      localContentValues.put("proposedEndTime", Long.valueOf(ab));
      localContentValues.put("meetingResponse", Integer.valueOf(ac));
      localContentValues.put("showUnauthWarning", Boolean.valueOf(ae));
      localContentValues.put("spamReason", ag);
      localContentValues.put("meetingInfo", af);
      localObject1 = localObject2;
      if (ah != null) {
        localObject1 = ah.toString();
      }
      localContentValues.put("proposeTimeFromMailRefMessageUri", (String)localObject1);
      localContentValues.put("proposeTimeFromMailRsvp", Integer.valueOf(ai));
      localContentValues.put("proposeTimeFromMailProposedStartTime", Long.valueOf(aj));
      localContentValues.put("proposeTimeFromMailProposedEndTime", Long.valueOf(ak));
      return localContentValues;
      localObject1 = null;
      break;
      localObject1 = null;
      break label239;
      i1 = 0;
      break label272;
      localObject1 = null;
      break label314;
    }
  }
  
  public final void c(String paramString)
  {
    try
    {
      l = paramString;
      ao = null;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void d(String paramString)
  {
    try
    {
      m = paramString;
      ap = null;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean d()
  {
    return (z & 0x10) == 16L;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(String paramString)
  {
    try
    {
      b = paramString;
      aq = null;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean e()
  {
    return (ad == 3) && ((aa != 0L) || (ab != 0L)) && (aa <= ab);
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || ((paramObject != null) && ((paramObject instanceof Message)) && (hbc.a(f, f)));
  }
  
  public final boolean f()
  {
    if ((e()) && (T != null) && (T.h == null))
    {
      long l1 = aa;
      if (ab - l1 >= 86400000L) {}
      for (int i1 = 1; i1 == 0; i1 = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final String[] g()
  {
    try
    {
      if (am == null) {
        am = f(j);
      }
      String[] arrayOfString = am;
      return arrayOfString;
    }
    finally {}
  }
  
  public final String[] h()
  {
    try
    {
      if (an == null) {
        an = f(k);
      }
      String[] arrayOfString = an;
      return arrayOfString;
    }
    finally {}
  }
  
  public int hashCode()
  {
    if (f == null) {
      return 0;
    }
    return f.hashCode();
  }
  
  public final String[] i()
  {
    try
    {
      if (ao == null) {
        ao = f(l);
      }
      String[] arrayOfString = ao;
      return arrayOfString;
    }
    finally {}
  }
  
  public final String[] j()
  {
    try
    {
      if (ap == null) {
        ap = f(m);
      }
      String[] arrayOfString = ap;
      return arrayOfString;
    }
    finally {}
  }
  
  public final String[] k()
  {
    try
    {
      if (aq == null) {
        aq = f(b);
      }
      String[] arrayOfString = aq;
      return arrayOfString;
    }
    finally {}
  }
  
  public final ArrayList<Attachment> l()
  {
    if (al == null) {
      if (H == null) {
        break label30;
      }
    }
    label30:
    for (al = Attachment.c(H);; al = new ArrayList()) {
      return al;
    }
  }
  
  public final boolean m()
  {
    return s;
  }
  
  public final String n()
  {
    Object localObject = "";
    if (!TextUtils.isEmpty(o)) {
      localObject = o;
    }
    while (TextUtils.isEmpty(p)) {
      return (String)localObject;
    }
    localObject = new SpannableString(p);
    Linkify.addLinks((Spannable)localObject, 2);
    return Html.toHtml((Spanned)localObject);
  }
  
  public final long o()
  {
    return d;
  }
  
  public final boolean p()
  {
    return u != 0;
  }
  
  public final Integer q()
  {
    if ((w) && (x != null)) {
      return Integer.valueOf(x.hashCode());
    }
    return null;
  }
  
  public final int r()
  {
    if ((K != null) && (L != 4) && (L != 5)) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return 1;
    }
    if (ae) {
      return 2;
    }
    return 0;
  }
  
  public String toString()
  {
    long l1 = d;
    return 33 + "[message id=" + l1 + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1 = 1;
    paramParcel.writeLong(d);
    paramParcel.writeString(e);
    paramParcel.writeParcelable(f, 0);
    paramParcel.writeParcelable(g, 0);
    paramParcel.writeString(h);
    paramParcel.writeString(i);
    paramParcel.writeString(j);
    paramParcel.writeString(k);
    paramParcel.writeString(l);
    paramParcel.writeString(m);
    paramParcel.writeString(b);
    paramParcel.writeLong(n);
    paramParcel.writeString(o);
    paramParcel.writeString(p);
    paramParcel.writeString(q);
    paramParcel.writeString(r);
    if (s)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelable(t, 0);
      paramParcel.writeInt(u);
      if (!v) {
        break label507;
      }
      paramInt = 1;
      label172:
      paramParcel.writeInt(paramInt);
      if (!w) {
        break label512;
      }
      paramInt = 1;
      label186:
      paramParcel.writeInt(paramInt);
      paramParcel.writeParcelable(x, 0);
      paramParcel.writeLong(z);
      if (!A) {
        break label517;
      }
      paramInt = 1;
      label217:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(G);
      paramParcel.writeString(Attachment.a(l()));
      paramParcel.writeParcelable(I, 0);
      paramParcel.writeParcelable(J, 0);
      paramParcel.writeString(K);
      paramParcel.writeInt(L);
      paramParcel.writeInt(M);
      paramParcel.writeInt(N);
      paramParcel.writeInt(O);
      paramParcel.writeString(P);
      if (!Q) {
        break label522;
      }
      paramInt = 1;
      label316:
      paramParcel.writeInt(paramInt);
      if (!R) {
        break label527;
      }
      paramInt = 1;
      label330:
      paramParcel.writeInt(paramInt);
      if (d()) {
        paramParcel.writeParcelable(T, 0);
      }
      paramParcel.writeInt(U);
      paramParcel.writeInt(V);
      if (!Y) {
        break label532;
      }
      paramInt = 1;
      label376:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(E);
      paramParcel.writeString(F);
      paramParcel.writeString(Z);
      paramParcel.writeLong(aa);
      paramParcel.writeLong(ab);
      paramParcel.writeInt(ac);
      paramParcel.writeInt(ad);
      if (!ae) {
        break label537;
      }
    }
    label507:
    label512:
    label517:
    label522:
    label527:
    label532:
    label537:
    for (paramInt = i1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(ag);
      paramParcel.writeString(af);
      paramParcel.writeParcelable(ah, 0);
      paramParcel.writeInt(ai);
      paramParcel.writeLong(aj);
      paramParcel.writeLong(ak);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label172;
      paramInt = 0;
      break label186;
      paramInt = 0;
      break label217;
      paramInt = 0;
      break label316;
      paramInt = 0;
      break label330;
      paramInt = 0;
      break label376;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Message
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */