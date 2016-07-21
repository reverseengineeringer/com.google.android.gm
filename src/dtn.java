import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.net.http.AndroidHttpClient;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.Promotion;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import com.google.android.gm.welcome.WelcomeTourActivity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.Adler32;
import java.util.zip.Inflater;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.CharArrayBuffer;

public final class dtn
{
  static final Set<String> a = hio.a(new String[] { "^r" });
  static final Set<String> b = hio.a(new String[] { "^i", "^f", "^iim" });
  static final String c = null;
  public static final String[] d;
  static final String g = cvl.a;
  static final String[] m = { "M", "L", "C", "A", "U", "u", "S", "Z", "z" };
  private static final Pattern o = dpy.d;
  private static final Object r;
  public Set<Integer> e = new HashSet();
  volatile boolean f;
  final dth h;
  dvd i;
  final Map<String, String> j;
  final Context k;
  final ContentResolver l;
  long[] n;
  private long p = 0L;
  private final Set<Long> q = new HashSet();
  private Map<String, String> s;
  private boolean t = false;
  
  static
  {
    d = new String[] { "messageId", "body" };
    r = new Object();
  }
  
  public dtn(dth paramdth, dvd paramdvd, Map<String, String> paramMap, Context paramContext, boolean paramBoolean)
  {
    h = paramdth;
    i = paramdvd;
    k = paramContext;
    l = paramContext.getContentResolver();
    j = paramMap;
    s = new HashMap();
    a();
    if (!j.containsKey("startSyncNeeded")) {
      a("startSyncNeeded", false);
    }
    if (!j.containsKey("needConfigSuggestion")) {
      a("needConfigSuggestion", false);
    }
    if (!j.containsKey("unackedSentOperations")) {
      a("unackedSentOperations", false);
    }
    if (!j.containsKey("nextUnackedSentOp")) {
      a("nextUnackedSentOp", 0L);
    }
    if (!j.containsKey("errorCountNextUnackedSentOp")) {
      a("errorCountNextUnackedSentOp", 0L);
    }
    if (!j.containsKey("nextUnackedOpWriteTime")) {
      a("nextUnackedOpWriteTime", 0L);
    }
    if (!j.containsKey("serverVersion")) {
      a("serverVersion", 0L);
    }
    if (!j.containsKey("clientOpToAck")) {
      a("clientOpToAck", 0L);
    }
    if (!j.containsKey("clientId")) {
      a("clientId", 0L);
    }
    if (!j.containsKey("configDirty")) {
      a("configDirty", true);
    }
    if (!j.containsKey("conversationAgeDays")) {
      a("conversationAgeDays", dpy.a(k));
    }
    if (!j.containsKey("maxAttachmentSize")) {
      a("maxAttachmentSize", 0L);
    }
    if (!j.containsKey("highestProcessedServerOperationId")) {
      a("highestProcessedServerOperationId", 0L);
    }
    if (!j.containsKey("lowestBackwardConversationId")) {
      a("lowestBackwardConversationId", 0L);
    }
    if (!j.containsKey("highestBackwardConversationId")) {
      a("highestBackwardConversationId", 0L);
    }
    if (!j.containsKey("moreForwardSyncNeeded")) {
      a("moreForwardSyncNeeded", false);
    }
    if (!j.containsKey("labelsIncluded")) {
      a("labelsIncluded", a);
    }
    if (!j.containsKey("labelsPartial")) {
      a("labelsPartial", b);
    }
    if (!j.containsKey("labelsAll")) {
      d("labelsAll", "");
    }
    if (!j.containsKey("messageSequenceNumber")) {
      a("messageSequenceNumber", 0L);
    }
    if (paramBoolean)
    {
      a("configDirty", true);
      a(null, null, null);
      g();
    }
  }
  
  private static long a(gzb paramgzb, dtr paramdtr)
  {
    dmt.a();
    paramdtr.f();
    for (;;)
    {
      try
      {
        if ((a & 0x4) != 0)
        {
          i1 = 1;
          if (i1 != 0) {
            paramdtr.a(d);
          }
          if ((e != null) && (e.length != 0)) {
            paramdtr.a(e);
          }
          gzc[] arrayOfgzc = c;
          int i3 = arrayOfgzc.length;
          i1 = 0;
          if (i1 < i3)
          {
            gzc localgzc = arrayOfgzc[i1];
            dtp localdtp = new dtp();
            a = b;
            b = c;
            j = dpy.a(g);
            c = h;
            d = i;
            k = j;
            g = d;
            h = e;
            i = f;
            n = new HashSet();
            int[] arrayOfInt = l;
            int i4 = arrayOfInt.length;
            int i2 = 0;
            if (i2 < i4)
            {
              int i5 = arrayOfInt[i2];
              n.add(Long.valueOf(i5));
              i2 += 1;
              continue;
            }
            f = dpo.a(k);
            l = m;
            a(o, localdtp);
            if ((a & 0x400) != 0)
            {
              i2 = 1;
              if (i2 != 0) {
                m = p;
              }
              if ((a & 0x800) != 0)
              {
                i2 = 1;
                if (i2 != 0) {
                  p = q;
                }
                if (dri.a(g, 2)) {
                  dri.b(g, "Conversation: %s", new Object[] { localdtp.toString() });
                }
                paramdtr.a(localdtp);
                i1 += 1;
              }
            }
            else
            {
              i2 = 0;
              continue;
            }
            i2 = 0;
            continue;
          }
          paramdtr.g();
          dmt.c();
          return b;
        }
      }
      finally
      {
        paramdtr.g();
      }
      int i1 = 0;
    }
  }
  
  private final dts a(gye paramgye, dtt paramdtt, dua paramdua, long paramLong, dtd paramdtd)
  {
    dmt.a();
    long l2 = b;
    int i1;
    long l1;
    label32:
    dts localdts;
    int i2;
    if ((a & 0x4) != 0)
    {
      i1 = 1;
      if (i1 == 0) {
        break label161;
      }
      l1 = d;
      if (e.length > 0)
      {
        i1 = e[0];
        if (i1 != 0) {
          dyb.a(l2, i1);
        }
      }
      i1 = b(c);
      dri.a(g, "handleConversationProto: conversationId: %d, SyncRationale: %s", new Object[] { Long.valueOf(l2), Integer.valueOf(i1) });
      i1 = 1;
      localdts = new dts();
      h.c();
      i2 = 0;
    }
    label161:
    Object localObject2;
    label216:
    label384:
    label430:
    label559:
    Object localObject1;
    int i4;
    int i3;
    for (;;)
    {
      dpw localdpw;
      try
      {
        localdpw = new dpw();
        boolean bool = f;
        if (bool)
        {
          return localdts;
          i1 = 0;
          break;
          l1 = 0L;
          break label32;
        }
        try
        {
          localObject2 = paramdtt.a();
          a += ((gyh)localObject2).d();
          if (localObject2 != null) {
            break label430;
          }
          dri.d(g, "handleConversationProto: End of stream while reading next chunk part. conversationId: %d", new Object[] { Long.valueOf(l2) });
          h.a(l2, 3);
          if (i1 != 0)
          {
            h.a(l2, paramdtd);
            if ((l1 != 0L) && (l1 != l2)) {
              h.a(l1, paramdtd);
            }
            if (q.contains(Long.valueOf(l2)))
            {
              dri.d(g, "handleConversationProto: Dirty conversation %d synced successfully. Marking as dirty in DB", new Object[] { Long.valueOf(l2) });
              h.g(l2);
              q.remove(Long.valueOf(l2));
            }
          }
          h.d();
          dmt.c();
          return localdts;
        }
        catch (OutOfMemoryError paramgye)
        {
          if (!f().contains(Long.valueOf(l2))) {
            break label384;
          }
        }
        throw paramgye;
      }
      finally
      {
        h.d();
      }
      i2 = 1;
      i1 = 0;
      dri.d(g, "handleConversationProto: Chunk to big to fit in memory. marking conversation %d as dirty", new Object[] { Long.valueOf(l2) });
      q.add(Long.valueOf(l2));
      continue;
      paramgye = j;
      if (paramgye == null) {
        break label739;
      }
      if (i2 == 0)
      {
        try
        {
          paramgye = a(j, l2, localdpw);
          if (s != null) {
            break label559;
          }
          i2 = 1;
          i1 = 0;
          dri.d(g, "handleConversationProto: Could not deflate message %d. marking conversation %d as dirty", new Object[] { Long.valueOf(c), Long.valueOf(l2) });
          q.add(Long.valueOf(l2));
        }
        catch (dpr paramgye)
        {
          dri.e(g, paramgye, "Corrupted data while creating dictionary. Deleting corrupted messages and retrying conversation fetch", new Object[0]);
          h.c(l2, a);
          i1 = 0;
        }
        continue;
        localObject1 = o.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Long)((Iterator)localObject1).next();
          localObject2 = h.c(((Long)localObject2).longValue());
          if ((localObject2 != null) && (Advertisement.c.containsKey(b))) {
            e.add((Integer)Advertisement.c.get(b));
          }
        }
        dri.a(g, "handleConversationProto: message: %s", new Object[] { paramgye });
        h.a(paramgye, paramLong);
        if (paramdua != null) {
          paramdua.a();
        }
        b += 1;
        i4 = i2;
        i3 = i1;
        label718:
        h.e();
        i1 = i3;
        i2 = i4;
      }
    }
    label739:
    paramgye = q;
    if (paramgye != null)
    {
      localObject1 = null;
      paramgye = null;
      i3 = i2;
    }
    label1284:
    for (;;)
    {
      try
      {
        localObject2 = a(q, l2);
        Object localObject3;
        if (localObject2 == null)
        {
          i1 = 1;
          i4 = 1;
          int i5 = 0;
          paramgye = (gye)localObject2;
          i3 = i1;
          localObject1 = localObject2;
          dri.d(g, "handleConversationProto: Could not deflate conversation %d. marking conversation as dirty", new Object[] { Long.valueOf(l2) });
          paramgye = (gye)localObject2;
          i3 = i1;
          localObject1 = localObject2;
          q.add(Long.valueOf(l2));
          i2 = i4;
          i1 = i5;
          if (localObject2 == null) {
            break;
          }
          a.close();
          i2 = i4;
          i1 = i5;
          break;
          paramgye = (gye)localObject2;
          i3 = i2;
          localObject1 = localObject2;
          localObject3 = a(j, l2, null);
          paramgye = (gye)localObject2;
          i3 = i2;
          localObject1 = localObject2;
          h.a((dtu)localObject3, paramLong);
          if (paramdua != null)
          {
            paramgye = (gye)localObject2;
            i3 = i2;
            localObject1 = localObject2;
            paramdua.a();
          }
          paramgye = (gye)localObject2;
          i3 = i2;
          localObject1 = localObject2;
          b += 1;
        }
        paramgye = (gye)localObject2;
        i3 = i2;
        localObject1 = localObject2;
        try
        {
          localObject3 = ((dtt)localObject2).a();
          if (localObject3 == null) {
            break label1284;
          }
          paramgye = (gye)localObject2;
          i3 = i2;
          localObject1 = localObject2;
          if (!f) {
            continue;
          }
          paramgye = (gye)localObject2;
          i3 = i2;
          localObject1 = localObject2;
          dri.a(g, "sync cancelled while processing messages for conversation: %d", new Object[] { Long.valueOf(l2) });
          i1 = 0;
        }
        catch (IOException localIOException)
        {
          i4 = 1;
          i2 = 1;
          i1 = 0;
          paramgye = (gye)localObject2;
          i3 = i4;
          localObject1 = localObject2;
          dri.d(g, localIOException, "handleConversationProto: Could not deflate conversation %d.marking conversation as dirty", new Object[] { Long.valueOf(l2) });
          paramgye = (gye)localObject2;
          i3 = i4;
          localObject1 = localObject2;
          q.add(Long.valueOf(l2));
          continue;
        }
        i3 = i1;
        i4 = i2;
        if (localObject2 == null) {
          break label718;
        }
        a.close();
        i3 = i1;
        i4 = i2;
        break label718;
      }
      catch (dpr localdpr)
      {
        localObject1 = paramgye;
        dri.e(g, localdpr, "Corrupted data while creating dictionary. Deleting corrupted messages and retrying conversation fetch", new Object[0]);
        localObject1 = paramgye;
        h.c(l2, a);
        i4 = 0;
        i2 = i3;
        i1 = i4;
        if (paramgye == null) {
          break;
        }
        a.close();
        i2 = i3;
        i1 = i4;
        break;
      }
      finally
      {
        if (localObject1 != null) {
          a.close();
        }
      }
      if (k != null)
      {
        dri.a(g, "handleConversationProto: end conversation", new Object[0]);
        break label216;
      }
      dri.e(g, "Unexpected chunk in conversation", new Object[0]);
      break label216;
    }
  }
  
  private final dts a(gyf paramgyf, dtt paramdtt, dua paramdua, long paramLong)
  {
    long l1 = a;
    h.c();
    paramgyf = new dts();
    int i1 = 0;
    try
    {
      Object localObject;
      for (;;)
      {
        boolean bool = f;
        if (bool) {
          return paramgyf;
        }
        localObject = paramdtt.a();
        if (localObject == null)
        {
          dri.d(g, "handleMessageProto: End of stream while reading next chunk part. conversationId: %d", new Object[] { Long.valueOf(l1) });
          return paramgyf;
        }
        a += ((gyh)localObject).d();
        if (j == null) {
          break;
        }
        b += 1;
        if (i1 == 0)
        {
          localObject = a(j, l1, new dpw());
          if (s == null)
          {
            q.add(Long.valueOf(l1));
            dri.d(g, "handleMessageProto: Could not deflate message %d. marking conversation %d  as dirty", new Object[] { Long.valueOf(c), Long.valueOf(l1) });
            i1 = 1;
          }
          else
          {
            dri.a(g, "handleMessageProto: message: %s", new Object[] { localObject });
            h.a((dtu)localObject, paramLong);
            h.a(d, 3);
            if (paramdua != null) {
              paramdua.a();
            }
            if (q.contains(Long.valueOf(l1)))
            {
              dri.d(g, "handleMessageProto: Message %d synced successfully. Marking conversation %d as dirty in DB", new Object[] { Long.valueOf(c), Long.valueOf(l1) });
              h.g(l1);
              q.remove(Long.valueOf(l1));
            }
            h.e();
          }
        }
      }
      if (l != null) {
        break label388;
      }
    }
    finally
    {
      h.d();
    }
    throw new IllegalArgumentException("Unexpected chunk in conversation");
    label388:
    h.d();
    return paramgyf;
  }
  
  private final dtt a(gyw paramgyw, long paramLong)
  {
    a(7);
    long l1 = c;
    Object localObject = new dpw();
    try
    {
      a((dpw)localObject, b, paramLong, true);
      long l2 = b.getValue();
      if (l1 != l2)
      {
        dri.e(g, "Dictionary checksum mismatch for conversation %d. Expected %x but was %x", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Long.valueOf(l2) });
        a(8);
        return null;
      }
    }
    catch (OutOfMemoryError paramgyw)
    {
      dri.e(g, paramgyw, "Out of memory while creating dictionary for conversation %d", new Object[] { Long.valueOf(paramLong) });
      return null;
    }
    paramgyw = a;
    localObject = new dvh(a.toByteArray());
    return new dtt(new dvi(new ByteArrayInputStream(paramgyw), (Inflater)localObject));
  }
  
  private final dtu a(gyu paramgyu, long paramLong, dpw paramdpw)
  {
    dtu localdtu = new dtu();
    a = h.p();
    c = b;
    d = paramLong;
    f = a(c);
    k = d;
    l = e;
    m = f;
    n = g;
    p = "";
    q = dpy.a(h);
    v = i;
    int i1;
    if ((a & 0x1000) != 0)
    {
      i1 = 1;
      if (i1 == 0) {
        break label218;
      }
    }
    int[] arrayOfInt;
    int i2;
    label218:
    for (paramLong = Long.parseLong(t, 16);; paramLong = 0L)
    {
      A = paramLong;
      arrayOfInt = p;
      i2 = arrayOfInt.length;
      i1 = 0;
      while (i1 < i2)
      {
        paramLong = arrayOfInt[i1];
        o.add(Long.valueOf(paramLong));
        h.b(paramLong);
        i1 += 1;
      }
      i1 = 0;
      break;
    }
    g = a(j);
    h = a(k);
    i = a(l);
    j = a(m);
    label319:
    label338:
    GmailAttachment localGmailAttachment;
    if ((a & 0x200) != 0)
    {
      i1 = 1;
      if (i1 == 0) {
        break label554;
      }
      s = a(r, s, c, d, paramdpw);
      a(0);
      paramdpw = q;
      int i3 = paramdpw.length;
      i1 = 0;
      if (i1 >= i3) {
        break label587;
      }
      arrayOfInt = paramdpw[i1];
      localGmailAttachment = new GmailAttachment();
      r = 0;
      p = d;
      q = c;
      b = b;
      localGmailAttachment.b(c);
      localGmailAttachment.a(d);
      d = f;
      localGmailAttachment.e(e);
      if (ghz.a(l, "gmail-attachment-respect-visibility-type", 1) == 0) {
        break label566;
      }
      i2 = 1;
      label455:
      if (i2 == 0) {
        break label578;
      }
      if ((a & 0x20) == 0) {
        break label572;
      }
      i2 = 1;
      label474:
      if (i2 == 0) {
        break label578;
      }
      localGmailAttachment.b(g);
    }
    for (;;)
    {
      if (dri.a(g, 2)) {
        dri.a(g, "readMessageFromProto: attachment = %s", new Object[] { localGmailAttachment.n() });
      }
      r.add(localGmailAttachment);
      a(3);
      i1 += 1;
      break label338;
      i1 = 0;
      break;
      label554:
      s = n;
      break label319;
      label566:
      i2 = 0;
      break label455;
      label572:
      i2 = 0;
      break label474;
      label578:
      localGmailAttachment.b(0);
    }
    label587:
    if ((a & 0x2000) != 0)
    {
      i1 = 1;
      if (i1 == 0) {
        break label1218;
      }
      C = u;
      label615:
      if ((a & 0x10000) == 0) {
        break label1227;
      }
      i1 = 1;
      label629:
      if (i1 == 0) {
        break label1239;
      }
      if (!x) {
        break label1233;
      }
      i1 = 1;
      label644:
      E = i1;
      label651:
      if ((a & 0x40000) == 0) {
        break label1248;
      }
      i1 = 1;
      label665:
      if (i1 == 0) {
        break label1260;
      }
      if (!y) {
        break label1254;
      }
      i1 = 1;
      label680:
      D = i1;
      label687:
      if ((a & 0x4000) == 0) {
        break label1269;
      }
      i1 = 1;
      label701:
      if (i1 != 0) {
        F = v;
      }
      if ((a & 0x8000) == 0) {
        break label1275;
      }
      i1 = 1;
      label729:
      if (i1 != 0) {
        G = w;
      }
      if ((a & 0x80000) == 0) {
        break label1281;
      }
      i1 = 1;
      label757:
      if (i1 != 0) {
        I = z;
      }
      if ((a & 0x100) == 0) {
        break label1287;
      }
      i1 = 1;
      label785:
      if (i1 != 0)
      {
        if (!o) {
          break label1293;
        }
        i1 = 1;
        label800:
        J = i1;
      }
      if ((a & 0x400000) == 0) {
        break label1299;
      }
      i1 = 1;
      label821:
      if (i1 != 0) {
        K = A;
      }
      if ((a & 0x800000) == 0) {
        break label1305;
      }
      i1 = 1;
      label849:
      if (i1 != 0) {
        L = B;
      }
      if (D == null) {
        break label1365;
      }
      paramgyu = D;
      paramdpw = new dtv();
      if ((a & 0x1) == 0) {
        break label1311;
      }
      i1 = 1;
      label896:
      if (i1 != 0) {
        a = b;
      }
      if ((a & 0x2) == 0) {
        break label1317;
      }
      i1 = 1;
      label922:
      if (i1 != 0) {
        b = c;
      }
      if ((a & 0x4) == 0) {
        break label1323;
      }
      i1 = 1;
      label948:
      if (i1 != 0) {
        c = d;
      }
      if ((a & 0x8) == 0) {
        break label1329;
      }
      i1 = 1;
      label975:
      if (i1 != 0) {
        d = e;
      }
      if ((a & 0x10) == 0) {
        break label1335;
      }
      i1 = 1;
      label1002:
      if (i1 != 0) {
        e = f;
      }
      if (g != null) {
        f = a(g);
      }
      if (h != null) {
        g = a(h);
      }
      if ((a & 0x20) == 0) {
        break label1341;
      }
      i1 = 1;
      label1067:
      if (i1 != 0) {
        h = i;
      }
      if ((a & 0x40) == 0) {
        break label1347;
      }
      i1 = 1;
      label1094:
      if (i1 != 0) {
        i = j;
      }
      if ((a & 0x80) == 0) {
        break label1353;
      }
      i1 = 1;
      label1122:
      if (i1 != 0) {
        j = k;
      }
      if (l != null) {
        k = a(l);
      }
      if ((a & 0x100) == 0) {
        break label1359;
      }
      i1 = 1;
      label1169:
      if (i1 != 0) {
        l = m;
      }
    }
    label1218:
    label1227:
    label1233:
    label1239:
    label1248:
    label1254:
    label1260:
    label1269:
    label1275:
    label1281:
    label1287:
    label1293:
    label1299:
    label1305:
    label1311:
    label1317:
    label1323:
    label1329:
    label1335:
    label1341:
    label1347:
    label1353:
    label1359:
    label1365:
    for (M = paramdpw;; M = null)
    {
      dri.b(g, "readMessageFromProto: %s", new Object[] { localdtu });
      return localdtu;
      i1 = 0;
      break;
      C = -1;
      break label615;
      i1 = 0;
      break label629;
      i1 = 0;
      break label644;
      E = -1;
      break label651;
      i1 = 0;
      break label665;
      i1 = 0;
      break label680;
      D = -1;
      break label687;
      i1 = 0;
      break label701;
      i1 = 0;
      break label729;
      i1 = 0;
      break label757;
      i1 = 0;
      break label785;
      i1 = 0;
      break label800;
      i1 = 0;
      break label821;
      i1 = 0;
      break label849;
      i1 = 0;
      break label896;
      i1 = 0;
      break label922;
      i1 = 0;
      break label948;
      i1 = 0;
      break label975;
      i1 = 0;
      break label1002;
      i1 = 0;
      break label1067;
      i1 = 0;
      break label1094;
      i1 = 0;
      break label1122;
      i1 = 0;
      break label1169;
    }
  }
  
  private static String a(gwq paramgwq)
  {
    String str2 = b;
    if ((a & 0x2) != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      String str1 = str2;
      if (i1 != 0)
      {
        paramgwq = c;
        str1 = String.valueOf(paramgwq).length() + 5 + String.valueOf(str2).length() + "\"" + paramgwq + "\" <" + str2 + ">";
      }
      return str1;
    }
  }
  
  private static String a(String paramString, char paramChar)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i2 = 0;
    int i1 = 0;
    if (i2 < paramString.length())
    {
      char c1 = paramString.charAt(i2);
      if ((i1 != 0) && (c1 != '\\'))
      {
        localStringBuilder.append(c1);
        i1 = 0;
      }
      for (;;)
      {
        i2 += 1;
        break;
        if ((c1 == '\\') && (paramString.charAt(i2 + 1) == paramChar)) {
          i1 = 1;
        } else {
          localStringBuilder.append(c1);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private final String a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, dpw paramdpw)
  {
    // Byte code:
    //   0: invokestatic 216	dmt:a	()V
    //   3: aload_0
    //   4: bipush 7
    //   6: invokevirtual 550	dtn:a	(I)V
    //   9: new 861	java/util/zip/Inflater
    //   12: dup
    //   13: invokespecial 862	java/util/zip/Inflater:<init>	()V
    //   16: astore 13
    //   18: aload 13
    //   20: aload_1
    //   21: invokevirtual 865	java/util/zip/Inflater:setInput	([B)V
    //   24: aload 13
    //   26: invokestatic 870	dvg:a	(Ljava/util/zip/Inflater;)Ljava/io/ByteArrayOutputStream;
    //   29: invokevirtual 582	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   32: astore 12
    //   34: aload 12
    //   36: astore 11
    //   38: aload 12
    //   40: arraylength
    //   41: ifne +137 -> 178
    //   44: aload 12
    //   46: astore 11
    //   48: aload 13
    //   50: invokevirtual 873	java/util/zip/Inflater:needsDictionary	()Z
    //   53: ifeq +125 -> 178
    //   56: aload 8
    //   58: getfield 576	dpw:a	Ljava/io/ByteArrayOutputStream;
    //   61: invokevirtual 876	java/io/ByteArrayOutputStream:size	()I
    //   64: ifne +14 -> 78
    //   67: aload_0
    //   68: aload 8
    //   70: lload 4
    //   72: lload 6
    //   74: iconst_0
    //   75: invokespecial 557	dtn:a	(Ldpw;JJZ)V
    //   78: aload 8
    //   80: getfield 560	dpw:b	Ljava/util/zip/Adler32;
    //   83: invokevirtual 565	java/util/zip/Adler32:getValue	()J
    //   86: lstore 9
    //   88: lload_2
    //   89: lload 9
    //   91: lcmp
    //   92: ifeq +56 -> 148
    //   95: getstatic 87	dtn:g	Ljava/lang/String;
    //   98: ldc_w 878
    //   101: iconst_4
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: lload 4
    //   109: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: lload 6
    //   117: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: lload_2
    //   124: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aastore
    //   128: dup
    //   129: iconst_3
    //   130: lload 9
    //   132: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: aastore
    //   136: invokestatic 526	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   139: pop
    //   140: aload_0
    //   141: bipush 8
    //   143: invokevirtual 550	dtn:a	(I)V
    //   146: aconst_null
    //   147: areturn
    //   148: aload 13
    //   150: aload 8
    //   152: getfield 576	dpw:a	Ljava/io/ByteArrayOutputStream;
    //   155: invokevirtual 582	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   158: invokevirtual 881	java/util/zip/Inflater:setDictionary	([B)V
    //   161: aload 13
    //   163: invokestatic 870	dvg:a	(Ljava/util/zip/Inflater;)Ljava/io/ByteArrayOutputStream;
    //   166: invokevirtual 582	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   169: astore 11
    //   171: aload 8
    //   173: aload 11
    //   175: invokevirtual 883	dpw:a	([B)V
    //   178: new 45	java/lang/String
    //   181: dup
    //   182: aload 11
    //   184: ldc_w 885
    //   187: invokespecial 888	java/lang/String:<init>	([BLjava/lang/String;)V
    //   190: astore 8
    //   192: getstatic 87	dtn:g	Ljava/lang/String;
    //   195: ldc_w 890
    //   198: iconst_3
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload 8
    //   206: invokevirtual 834	java/lang/String:length	()I
    //   209: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: aload_1
    //   216: arraylength
    //   217: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   220: aastore
    //   221: dup
    //   222: iconst_2
    //   223: aload 8
    //   225: invokevirtual 834	java/lang/String:length	()I
    //   228: i2f
    //   229: aload_1
    //   230: arraylength
    //   231: i2f
    //   232: fdiv
    //   233: invokestatic 895	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   236: aastore
    //   237: invokestatic 376	dri:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   240: pop
    //   241: invokestatic 897	dmt:b	()V
    //   244: aload 8
    //   246: areturn
    //   247: astore_1
    //   248: getstatic 87	dtn:g	Ljava/lang/String;
    //   251: aload_1
    //   252: ldc_w 899
    //   255: iconst_1
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: lload 4
    //   263: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   266: aastore
    //   267: invokestatic 444	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   270: pop
    //   271: aload_0
    //   272: bipush 8
    //   274: invokevirtual 550	dtn:a	(I)V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_1
    //   280: new 901	java/lang/IllegalStateException
    //   283: dup
    //   284: ldc_w 903
    //   287: invokespecial 904	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   290: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	dtn
    //   0	291	1	paramArrayOfByte	byte[]
    //   0	291	2	paramLong1	long
    //   0	291	4	paramLong2	long
    //   0	291	6	paramLong3	long
    //   0	291	8	paramdpw	dpw
    //   86	45	9	l1	long
    //   36	147	11	arrayOfByte1	byte[]
    //   32	13	12	arrayOfByte2	byte[]
    //   16	146	13	localInflater	Inflater
    // Exception table:
    //   from	to	target	type
    //   24	34	247	java/util/zip/DataFormatException
    //   38	44	247	java/util/zip/DataFormatException
    //   48	78	247	java/util/zip/DataFormatException
    //   78	88	247	java/util/zip/DataFormatException
    //   95	146	247	java/util/zip/DataFormatException
    //   148	178	247	java/util/zip/DataFormatException
    //   178	192	279	java/io/UnsupportedEncodingException
  }
  
  private static List<String> a(gwq[] paramArrayOfgwq)
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = paramArrayOfgwq.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localArrayList.add(a(paramArrayOfgwq[i1]));
      i1 += 1;
    }
    return localArrayList;
  }
  
  private final void a(long paramLong)
  {
    dri.a(g, "Received handled client operation id from server", new Object[0]);
    h.e(paramLong);
    a("unackedSentOperations", false);
    a("clientOpToAck", paramLong);
  }
  
  private static void a(Context paramContext, dth paramdth, boolean paramBoolean, Uri paramUri, String paramString1, String paramString2)
  {
    if (!TextUtils.equals(paramdth.e(paramString1), paramString2))
    {
      if (paramString2 != null) {
        break label61;
      }
      paramdth.d(paramString1);
    }
    for (;;)
    {
      if (paramBoolean) {
        GmailProvider.b(paramContext, paramdth.p());
      }
      if (paramUri != null) {
        paramContext.getContentResolver().query(paramUri, null, null, null, null);
      }
      return;
      label61:
      paramdth.a(paramString1, paramString2);
    }
  }
  
  private final void a(dpw paramdpw, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Cursor localCursor = h.a(d, paramLong2);
    if (localCursor == null)
    {
      dri.e(g, "Could not init dictionary for conv: %d, message: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return;
    }
    try
    {
      do
      {
        paramdpw.a(a(localCursor));
        if (!localCursor.moveToNext()) {
          break;
        }
      } while (localCursor.getLong(0) != paramLong1);
      if (paramBoolean) {
        paramdpw.a(a(localCursor));
      }
      return;
      return;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  private final void a(drk paramdrk, String paramString1, String paramString2)
  {
    if (paramdrk != null)
    {
      a("startSyncNeeded", true);
      h.a(paramdrk, paramString1, paramString2, "SHOW");
      paramString2 = hgd.a(new String[] { "labelsIncluded", "labelsPartial", "labelsAll" });
      paramdrk = h.b(paramdrk);
      if (paramdrk != null)
      {
        paramString2 = paramString2.iterator();
        while (paramString2.hasNext())
        {
          String str = (String)paramString2.next();
          Set localSet = f(str);
          if (localSet.contains(paramdrk))
          {
            localSet.remove(paramdrk);
            localSet.add(paramString1);
            a(str, localSet);
          }
        }
      }
    }
    a(1);
  }
  
  /* Error */
  private final void a(gyg paramgyg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 121	dtn:h	Ldth;
    //   6: invokeinterface 382 1 0
    //   11: aload_1
    //   12: getfield 978	gyg:c	Lgwp;
    //   15: ifnull +308 -> 323
    //   18: new 240	dtp
    //   21: dup
    //   22: invokespecial 241	dtp:<init>	()V
    //   25: astore 10
    //   27: aload_1
    //   28: getfield 978	gyg:c	Lgwp;
    //   31: astore 11
    //   33: aload 11
    //   35: getfield 981	gwp:b	J
    //   38: lstore 6
    //   40: aload 10
    //   42: lload 6
    //   44: putfield 247	dtp:a	J
    //   47: aload 10
    //   49: aload 11
    //   51: getfield 982	gwp:c	J
    //   54: putfield 250	dtp:b	J
    //   57: aload 10
    //   59: aload 11
    //   61: getfield 983	gwp:d	J
    //   64: putfield 271	dtp:g	J
    //   67: aload 10
    //   69: aload 11
    //   71: getfield 984	gwp:e	Ljava/lang/String;
    //   74: putfield 275	dtp:h	Ljava/lang/String;
    //   77: aload 10
    //   79: aload 11
    //   81: getfield 985	gwp:f	Ljava/lang/String;
    //   84: putfield 279	dtp:i	Ljava/lang/String;
    //   87: aload 10
    //   89: aload 11
    //   91: getfield 986	gwp:g	I
    //   94: invokestatic 255	dpy:a	(I)I
    //   97: putfield 257	dtp:j	I
    //   100: aload 10
    //   102: aload 11
    //   104: getfield 987	gwp:h	J
    //   107: putfield 260	dtp:c	J
    //   110: aload 10
    //   112: aload 11
    //   114: getfield 988	gwp:i	I
    //   117: putfield 264	dtp:d	I
    //   120: aload 10
    //   122: aload 11
    //   124: getfield 989	gwp:j	Z
    //   127: putfield 268	dtp:k	Z
    //   130: aload 10
    //   132: aload 11
    //   134: getfield 990	gwp:k	Lgzn;
    //   137: invokestatic 303	dpo:a	(Lgzn;)[B
    //   140: putfield 306	dtp:f	[B
    //   143: aload 11
    //   145: getfield 992	gwp:m	[I
    //   148: aload 10
    //   150: invokestatic 315	dtn:a	([ILdtp;)V
    //   153: aload 10
    //   155: new 110	java/util/HashSet
    //   158: dup
    //   159: invokespecial 111	java/util/HashSet:<init>	()V
    //   162: putfield 281	dtp:n	Ljava/util/Set;
    //   165: aload 11
    //   167: getfield 993	gwp:l	[I
    //   170: astore 12
    //   172: aload 12
    //   174: arraylength
    //   175: istore 4
    //   177: iconst_0
    //   178: istore_2
    //   179: iload_2
    //   180: iload 4
    //   182: if_icmpge +33 -> 215
    //   185: aload 12
    //   187: iload_2
    //   188: iaload
    //   189: istore 5
    //   191: aload 10
    //   193: getfield 281	dtp:n	Ljava/util/Set;
    //   196: iload 5
    //   198: i2l
    //   199: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   202: invokeinterface 295 2 0
    //   207: pop
    //   208: iload_2
    //   209: iconst_1
    //   210: iadd
    //   211: istore_2
    //   212: goto -33 -> 179
    //   215: aload 11
    //   217: getfield 994	gwp:a	I
    //   220: sipush 512
    //   223: iand
    //   224: ifeq +94 -> 318
    //   227: iload_3
    //   228: istore_2
    //   229: iload_2
    //   230: ifeq +13 -> 243
    //   233: aload 10
    //   235: aload 11
    //   237: getfield 996	gwp:n	Z
    //   240: putfield 323	dtp:p	Z
    //   243: aload_0
    //   244: getfield 121	dtn:h	Ldth;
    //   247: aload 10
    //   249: invokeinterface 997 2 0
    //   254: aload_1
    //   255: getfield 998	gyg:b	J
    //   258: lstore 8
    //   260: getstatic 87	dtn:g	Ljava/lang/String;
    //   263: ldc_w 1000
    //   266: iconst_2
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: lload 6
    //   274: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: lload 8
    //   282: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   285: aastore
    //   286: invokestatic 376	dri:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   289: pop
    //   290: aload_0
    //   291: getfield 121	dtn:h	Ldth;
    //   294: lload 6
    //   296: lload 8
    //   298: invokeinterface 1002 5 0
    //   303: aload_0
    //   304: getfield 121	dtn:h	Ldth;
    //   307: invokeinterface 389 1 0
    //   312: aload_0
    //   313: iconst_2
    //   314: invokevirtual 550	dtn:a	(I)V
    //   317: return
    //   318: iconst_0
    //   319: istore_2
    //   320: goto -91 -> 229
    //   323: aload_1
    //   324: getfield 1003	gyg:a	J
    //   327: lstore 6
    //   329: goto -75 -> 254
    //   332: astore_1
    //   333: aload_0
    //   334: getfield 121	dtn:h	Ldth;
    //   337: invokeinterface 389 1 0
    //   342: aload_1
    //   343: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	dtn
    //   0	344	1	paramgyg	gyg
    //   178	142	2	i1	int
    //   1	227	3	i2	int
    //   175	8	4	i3	int
    //   189	8	5	i4	int
    //   38	290	6	l1	long
    //   258	39	8	l2	long
    //   25	223	10	localdtp	dtp
    //   31	205	11	localgwp	gwp
    //   170	16	12	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   11	177	332	finally
    //   191	208	332	finally
    //   215	227	332	finally
    //   233	243	332	finally
    //   243	254	332	finally
    //   254	303	332	finally
    //   323	329	332	finally
  }
  
  private final void a(gza paramgza)
  {
    h.c();
    try
    {
      paramgza = a;
      int i2 = paramgza.length;
      int i1 = 0;
      while (i1 < i2)
      {
        gwv localgwv = paramgza[i1];
        h.a(new Promotion(localgwv));
        i1 += 1;
      }
      h.d();
      dmv.a().a(k, h.p(), "should-sync-all-promos", Boolean.valueOf(false));
      return;
    }
    finally
    {
      h.d();
    }
  }
  
  private final void a(gzd paramgzd, dua paramdua)
  {
    h.c();
    int i1;
    label71:
    label137:
    label254:
    label330:
    label395:
    label434:
    label473:
    int i2;
    for (;;)
    {
      try
      {
        if ((a & 0x10) == 0) {
          break label1486;
        }
        i1 = 1;
        if (i1 != 0)
        {
          localObject1 = g;
          if (!((String)localObject1).isEmpty())
          {
            localObject1 = b((String)localObject1, false);
            h.b((Map)localObject1, true);
          }
          if ((a & 0x20) == 0) {
            break label1491;
          }
          i1 = 1;
          if (i1 != 0)
          {
            localObject1 = hdu.a("bx_rf", h);
            h.c((Map)localObject1);
          }
        }
        if (TextUtils.isEmpty(f)) {
          h.b(d(f));
        }
        if ((a & 0x800) == 0) {
          break label1496;
        }
        i1 = 1;
        if (i1 != 0)
        {
          localObject1 = l;
          if ((((String)localObject1).isEmpty()) || (((String)localObject1).equals("null"))) {
            h.c(hdu.a("sx_rt", ""));
          }
        }
        else
        {
          if ((a & 0x1000) == 0) {
            break label599;
          }
          i1 = 1;
          if (i1 != 0)
          {
            localObject1 = m;
            if ((!((String)localObject1).isEmpty()) && (!((String)localObject1).equals("null"))) {
              break label604;
            }
            h.c(hdu.a("sx_dn", ""));
          }
          if ((a & 0x40) == 0) {
            break label1501;
          }
          i1 = 1;
          if (i1 != 0) {
            h.c(new hen().b("sx_ioe", i).b("sx_iosc", k).b("sx_ioss", j).b("bx_ioao", n).b());
          }
          if ((a & 0x4000) == 0) {
            break label1506;
          }
          i1 = 1;
          if (i1 != 0) {
            h.c(hdu.a("bx_pie", o));
          }
          if (p != null) {
            h.d(hdu.a("sx_piac", hlt.a(p)));
          }
          if ((a & 0x8000) == 0) {
            break label1511;
          }
          i1 = 1;
          if (i1 != 0) {
            h.c(hdu.a("bx_pia", String.valueOf(q)));
          }
          if ((a & 0x10000) == 0) {
            break label1516;
          }
          i1 = 1;
          if (i1 != 0) {
            h.c(hdu.a("bx_piuf", String.valueOf(r)));
          }
          if ((a & 0x20000) == 0) {
            break label1521;
          }
          i1 = 1;
          if (i1 != 0) {
            h.c(t);
          }
          if ((!dmn.a(k)) || (u == null)) {
            break label845;
          }
          localObject1 = new hen();
          localObject2 = u.a;
          i2 = localObject2.length;
          i1 = 0;
          if (i1 >= i2) {
            break;
          }
          localObject3 = localObject2[i1];
          ((hen)localObject1).b(a, b);
          i1 += 1;
          continue;
        }
        h.c(hdu.a("sx_rt", localObject1));
        continue;
        i1 = 0;
      }
      finally
      {
        h.d();
      }
      label599:
      continue;
      label604:
      h.c(hdu.a("sx_dn", localObject1));
    }
    Object localObject2 = dnm.a(k, h.p());
    e.putLong("hats-survey-start-timestamp", Calendar.getInstance().getTimeInMillis()).apply();
    Object localObject1 = ((hen)localObject1).b();
    localObject2 = e;
    Object localObject3 = new hfe();
    Iterator localIterator = ((Map)localObject1).keySet().iterator();
    Object localObject4;
    while (localIterator.hasNext())
    {
      localObject4 = (String)localIterator.next();
      try
      {
        ((hfe)localObject3).c(String.format("%s%c%s", new Object[] { URLEncoder.encode((String)localObject4, "utf-8"), Character.valueOf('='), URLEncoder.encode((String)((Map)localObject1).get(localObject4), "utf-8") }));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        cvm.e(cfg.f, localUnsupportedEncodingException, "Error encoding key-value pair: %s=%s", new Object[] { localObject4, ((Map)localObject1).get(localObject4) });
      }
    }
    ((SharedPreferences.Editor)localObject2).putStringSet("hats-survey-additional-params", ((hfe)localObject3).a());
    ((SharedPreferences.Editor)localObject2).apply();
    label845:
    label858:
    label888:
    label918:
    label957:
    label1006:
    label1018:
    int i3;
    label1032:
    label1044:
    int i4;
    if ((a & 0x40000) != 0)
    {
      i1 = 1;
      if (i1 != 0) {
        h.a(v);
      }
      if ((a & 0x800000) == 0) {
        break label1538;
      }
      i1 = 1;
      if (i1 != 0) {
        h.b(w);
      }
      if ((a & 0x1000000) == 0) {
        break label1543;
      }
      i1 = 1;
      if (i1 != 0) {
        h.c(x);
      }
      localObject2 = new HashMap();
      localObject3 = e;
      int i5 = localObject3.length;
      i1 = 0;
      if (i1 < i5)
      {
        localIterator = localObject3[i1];
        localObject4 = h.b(b);
        if (localObject4 != null)
        {
          if ((a & 0x80) == 0) {
            break label1548;
          }
          i2 = 1;
          if (i2 == 0) {
            break label1554;
          }
          i2 = i;
          if ((a & 0x20) == 0) {
            break label1560;
          }
          i3 = 1;
          if (i3 == 0) {
            break label1566;
          }
          i3 = g;
          if ((a & 0x40) == 0) {
            break label1574;
          }
          i4 = 1;
          label1058:
          if (i4 == 0) {
            break label1580;
          }
          localObject1 = h;
          label1070:
          ((Map)localObject2).put(localObject4, new dtk(c, d, e, f, i2, i3, (String)localObject1));
        }
      }
      else
      {
        if ((e.length > 0) && (paramdua != null)) {
          paramdua.b();
        }
        a((Map)localObject2, paramdua);
        h.a();
        h.b();
        if (s.length > 0)
        {
          paramdua = new HashMap();
          localObject1 = s;
          i2 = localObject1.length;
          i1 = 0;
        }
      }
    }
    for (;;)
    {
      if (i1 < i2)
      {
        localObject3 = localObject1[i1];
        localObject2 = a;
        localObject3 = b;
        if ((localObject2 != null) && (localObject3 != null))
        {
          if (((String)localObject2).startsWith("/blocked-sender/")) {
            a(((String)localObject2).replaceFirst("/blocked-sender/", ""), (String)localObject3);
          } else if (((String)localObject2).startsWith("/unsubscribe_sender_list/")) {
            b(c((String)localObject2), (String)localObject3);
          } else if ((dkn.a()) && (((String)localObject2).startsWith("/gmailify-status/"))) {
            c(((String)localObject2).substring(17), (String)localObject3);
          } else {
            paramdua.put(localObject2, localObject3);
          }
        }
        else {
          dri.d(g, "StartSyncInfoProto: received invalid pref from server", new Object[0]);
        }
      }
      else
      {
        h.c(paramdua);
        long l1 = d;
        long l2 = c;
        long l3 = b;
        dri.a(g, "handleStartSyncInfoValues: highestServerOperation: %d highestServerConversation: %d handledClientOperation: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
        if (b("startSyncNeeded"))
        {
          a("startSyncNeeded", false);
          if (a("highestProcessedServerOperationId") == 0L) {
            a("highestProcessedServerOperationId", l1);
          }
          a("lowestBackwardConversationId", 1L + l2);
          a("highestBackwardConversationId", l2);
        }
        a(l3);
        g();
        h.d();
        return;
        label1486:
        i1 = 0;
        break;
        label1491:
        i1 = 0;
        break label71;
        label1496:
        i1 = 0;
        break label137;
        label1501:
        i1 = 0;
        break label254;
        label1506:
        i1 = 0;
        break label330;
        label1511:
        i1 = 0;
        break label395;
        label1516:
        i1 = 0;
        break label434;
        label1521:
        i1 = 0;
        break label473;
        i1 += 1;
        break label957;
        i1 = 0;
        break label858;
        label1538:
        i1 = 0;
        break label888;
        label1543:
        i1 = 0;
        break label918;
        label1548:
        i2 = 0;
        break label1006;
        label1554:
        i2 = -1;
        break label1018;
        label1560:
        i3 = 0;
        break label1032;
        label1566:
        i3 = Integer.MAX_VALUE;
        break label1044;
        label1574:
        i4 = 0;
        break label1058;
        label1580:
        localObject1 = "SHOW";
        break label1070;
      }
      i1 += 1;
    }
  }
  
  private final void a(gzh paramgzh, dtd paramdtd)
  {
    int i1;
    if ((a & 0x1) != 0) {
      i1 = 1;
    }
    for (;;)
    {
      long l1;
      if (i1 != 0)
      {
        l1 = b;
        if (l1 == 0L) {
          h.a("Received operationId of 0 as last-examined-server-op. Wiping.");
        }
        dri.b(g, "last-examined-server-operation operationId: %d", new Object[] { Long.valueOf(l1) });
        a("highestProcessedServerOperationId", l1);
        g();
      }
      if ((a & 0x2) != 0)
      {
        i1 = 1;
        label86:
        if (i1 != 0)
        {
          l1 = c;
          dri.a(g, "lowest-backward-convesation-id conversationid: %d", new Object[] { Long.valueOf(l1) });
          a("lowestBackwardConversationId", l1);
        }
        if ((a & 0x10) == 0) {
          break label404;
        }
        i1 = 1;
        label139:
        if (i1 != 0)
        {
          l1 = g;
          dri.a(g, "%s messageSequenceNumber: %d", new Object[] { "messageSequenceNumber", Long.valueOf(l1) });
          a("messageSequenceNumber", l1);
          g();
        }
        if (!a) {
          break label409;
        }
        a("moreForwardSyncNeeded", d);
        label207:
        paramdtd = new HashSet();
        h.c();
      }
      try
      {
        gzi[] arrayOfgzi = f;
        int i5 = arrayOfgzi.length;
        i1 = 0;
        label237:
        if (i1 < i5)
        {
          paramgzh = arrayOfgzi[i1];
          drk localdrk = h.c(b);
          int i6 = c;
          int i7 = d;
          int i2;
          label289:
          label300:
          int i3;
          label313:
          label324:
          int i4;
          if ((a & 0x20) != 0)
          {
            i2 = 1;
            if (i2 == 0) {
              break label426;
            }
            i2 = g;
            if ((a & 0x8) == 0) {
              break label432;
            }
            i3 = 1;
            if (i3 == 0) {
              break label438;
            }
            i3 = e;
            if ((a & 0x10) == 0) {
              break label446;
            }
            i4 = 1;
            label337:
            if (i4 == 0) {
              break label452;
            }
          }
          label404:
          label409:
          label426:
          label432:
          label438:
          label446:
          label452:
          for (paramgzh = f;; paramgzh = "SHOW")
          {
            if (localdrk != null)
            {
              h.a(localdrk, i6, i7, i2, i3, paramgzh);
              paramdtd.add(Long.valueOf(a));
            }
            i1 += 1;
            break label237;
            i1 = 0;
            break;
            i1 = 0;
            break label86;
            i1 = 0;
            break label139;
            a("moreForwardSyncNeeded", false);
            break label207;
            i2 = 0;
            break label289;
            i2 = -1;
            break label300;
            i3 = 0;
            break label313;
            i3 = Integer.MAX_VALUE;
            break label324;
            i4 = 0;
            break label337;
          }
        }
        h.d();
        h.b(paramdtd);
        return;
      }
      finally
      {
        h.d();
      }
    }
  }
  
  private final void a(gzk paramgzk, dtd paramdtd)
  {
    h.c();
    for (;;)
    {
      int i2;
      int i1;
      long l1;
      long l2;
      long l3;
      try
      {
        Object localObject = b;
        i2 = localObject.length;
        i1 = 0;
        if (i1 < i2)
        {
          str = localObject[i1];
          l1 = a;
          str = b;
          dri.d(g, "Message %d not handled because: %s", new Object[] { Long.valueOf(l1), str });
          h.a(l1, str);
          i1 += 1;
          continue;
        }
        i1 = 0;
        localObject = c;
        int i3 = localObject.length;
        i2 = 0;
        if (i2 >= i3) {
          break label298;
        }
        String str = localObject[i2];
        l1 = a;
        if ((a) || (l1 != f)) {
          break label383;
        }
        i1 = 1;
        l2 = b;
        l3 = c;
        if (t)
        {
          t = false;
          throw new IOException("Faked by mFakeIoExceptionWhenHandlingMessageSavedOrSent");
        }
      }
      finally
      {
        h.d();
      }
      dri.b(g, "message id changed from %d to %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      h.a(l1, l2, l3);
      if ((!a) && ((e == l3) || (e == l1)) && (f == l1))
      {
        h.a(l3, l2);
        break label386;
        label298:
        if ((a & 0x1) != 0)
        {
          i2 = 1;
          if ((i2 == 0) || (!a)) {
            break label351;
          }
          a(d);
        }
        for (g = true;; g = true)
        {
          label351:
          do
          {
            h.d();
            return;
            i2 = 0;
            break;
          } while ((a) || (i1 == 0));
          h.f(f);
        }
        label383:
        continue;
      }
      label386:
      i2 += 1;
    }
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        dri.b(g, "prefValue: %s", new Object[] { paramString2 });
        Object localObject = Base64.decode(paramString2, 8);
        gwo localgwo = (gwo)hlt.a(new gwo(), (byte[])localObject, localObject.length);
        if ((a & 0x1) != 0)
        {
          i1 = 1;
          if (i1 == 0) {
            break label163;
          }
          localObject = b;
          if ((a & 0x2) != 0)
          {
            i1 = 1;
            if (i1 == 0) {
              break label157;
            }
            l1 = c;
            h.a(paramString1, (String)localObject, l1);
          }
        }
        else
        {
          i1 = 0;
          continue;
        }
        int i1 = 0;
        continue;
        l1 = 0L;
      }
      catch (IOException localIOException)
      {
        h.a(paramString1, "", 0L);
        dri.d(g, localIOException, "Unable to parse SENDER_BLOCKED_PREF value %s", new Object[] { paramString2 });
        return;
      }
      label157:
      continue;
      label163:
      String str = "";
      continue;
      str = "";
      long l1 = 0L;
    }
  }
  
  private final void a(Map<drk, dtk> paramMap, dua paramdua)
  {
    dri.b(g, "handleLabelsValues: receiving set of %d labels", new Object[] { Integer.valueOf(paramMap.size()) });
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      drk localdrk = (drk)((Map.Entry)localObject).getKey();
      localObject = (dtk)((Map.Entry)localObject).getValue();
      localHashMap.put(Long.valueOf(a), localObject);
      localHashSet.add(a);
    }
    h.a(localHashMap);
    a(null, null, localHashSet);
    g();
    if (paramdua != null) {
      paramdua.b();
    }
  }
  
  private final void a(Set<String> paramSet1, Set<String> paramSet2, Set<String> paramSet3)
  {
    Set localSet2 = f("labelsIncluded");
    Set localSet3 = f("labelsPartial");
    if (a(localSet2, paramSet2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (a(localSet3, paramSet2)) {
        bool1 = true;
      }
      if (b(localSet2, paramSet3)) {
        bool1 = true;
      }
      boolean bool2 = bool1;
      if (b(localSet3, paramSet3)) {
        bool2 = true;
      }
      if (paramSet3 == null)
      {
        bool1 = bool2;
        if (j.containsKey("labelsAll"))
        {
          Set localSet1 = f("labelsAll");
          boolean bool3 = bool2;
          if (paramSet1 != null) {
            bool3 = bool2 | localSet1.addAll(paramSet1);
          }
          bool1 = bool3;
          paramSet3 = localSet1;
          if (paramSet2 != null)
          {
            bool1 = bool3 | localSet1.removeAll(paramSet2);
            paramSet3 = localSet1;
          }
        }
      }
      while ((paramSet3 == null) || (paramSet3.size() == 0))
      {
        return;
        bool1 = true;
      }
      paramSet1 = drd.a.iterator();
      label175:
      if (paramSet1.hasNext())
      {
        paramSet2 = (String)paramSet1.next();
        if ((paramSet3.contains(paramSet2)) || (drj.h(paramSet2)))
        {
          bool2 = true;
          label214:
          if (!bool2) {
            break label428;
          }
          boolean bool4 = localSet2.add(paramSet2);
          bool1 = localSet3.remove(paramSet2) | bool1 | bool4;
        }
      }
      label338:
      label428:
      for (;;)
      {
        break label175;
        bool2 = false;
        break label214;
        paramSet1 = drd.b.iterator();
        while (paramSet1.hasNext())
        {
          paramSet2 = (String)paramSet1.next();
          if ((paramSet3.contains(paramSet2)) || (drj.h(paramSet2))) {}
          for (bool2 = true;; bool2 = false)
          {
            if ((!bool2) || (localSet2.contains(paramSet2))) {
              break label338;
            }
            bool1 |= localSet3.add(paramSet2);
            break;
          }
        }
        if (!bool1) {
          break;
        }
        if (dri.a(g, 4)) {
          dri.c(g, "checkLabelsSets changed the label sets to: included(%s), partial(%s), all(%s)", new Object[] { dri.a(localSet2), dri.a(localSet3), dri.a(paramSet3) });
        }
        a("labelsIncluded", localSet2);
        a("labelsPartial", localSet3);
        a("labelsAll", paramSet3);
        h.f();
        return;
      }
    }
  }
  
  static void a(HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramHttpResponse.getEntity();
    if (((HttpEntity)localObject1).getContentLength() < 2147483647L)
    {
      paramHttpResponse = new InputStreamReader(AndroidHttpClient.getUngzippedContent((HttpEntity)localObject1), "UTF-8");
      int i2 = (int)((HttpEntity)localObject1).getContentLength();
      int i1 = i2;
      if (i2 < 0) {
        i1 = 4096;
      }
      localObject1 = new CharArrayBuffer(i1);
      try
      {
        char[] arrayOfChar = new char['Ѐ'];
        long l1 = SystemClock.elapsedRealtime();
        do
        {
          i1 = paramHttpResponse.read(arrayOfChar);
          if (i1 == -1) {
            break;
          }
          ((CharArrayBuffer)localObject1).append(arrayOfChar, 0, i1);
        } while (SystemClock.elapsedRealtime() - l1 <= 3600000L);
        ((CharArrayBuffer)localObject1).append("\nRead timed out...");
        paramHttpResponse.close();
        dri.c(g, "Html Response from html content = %s", new Object[] { localObject1 });
        return;
      }
      finally
      {
        paramHttpResponse.close();
      }
    }
    dri.c(g, "Response too large to print", new Object[0]);
  }
  
  private static void a(int[] paramArrayOfInt, dtp paramdtp)
  {
    if (paramArrayOfInt.length > 0)
    {
      o = paramArrayOfInt[0];
      dri.c(cvl.a, "handleCalendarPromotion. type=%d", new Object[] { Integer.valueOf(o) });
      if (paramArrayOfInt.length != 1) {
        dri.d(g, "Something is wrong. There should be only one promotion type.", new Object[0]);
      }
    }
  }
  
  private final void a(gwi[] paramArrayOfgwi, String paramString, int paramInt)
  {
    if (paramArrayOfgwi == null) {}
    for (;;)
    {
      return;
      int i2 = paramArrayOfgwi.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Advertisement localAdvertisement = new Advertisement(paramArrayOfgwi[i1], paramInt, paramString);
        dri.c(g, "Received Ad with event id: %s", new Object[] { e });
        h.a(localAdvertisement);
        i1 += 1;
      }
    }
  }
  
  private final boolean a(String paramString, long paramLong)
  {
    return d(paramString, Long.toString(paramLong));
  }
  
  private final boolean a(String paramString, Set<String> paramSet)
  {
    paramSet = paramSet.toArray();
    Arrays.sort(paramSet);
    return d(paramString, TextUtils.join(" ", paramSet));
  }
  
  private static <E> boolean a(Set<E> paramSet1, Set<E> paramSet2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramSet2 == null) {
      return bool2;
    }
    paramSet1 = paramSet1.iterator();
    for (;;)
    {
      bool2 = bool1;
      if (!paramSet1.hasNext()) {
        break;
      }
      if (paramSet2.contains(paramSet1.next()))
      {
        paramSet1.remove();
        bool1 = true;
      }
    }
  }
  
  private static byte[] a(Cursor paramCursor)
  {
    try
    {
      paramCursor = paramCursor.getString(1).getBytes("UTF-8");
      return paramCursor;
    }
    catch (UnsupportedEncodingException paramCursor)
    {
      throw new IllegalStateException("UTF-8 not supported");
    }
  }
  
  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(36 + "Unknown proto rationale: " + paramInt);
    case 0: 
      return 2;
    case 1: 
      return 1;
    }
    return 0;
  }
  
  private final dtt b(HttpResponse paramHttpResponse)
  {
    int i2 = 1;
    int i1 = paramHttpResponse.getStatusLine().getStatusCode();
    if (paramHttpResponse.getEntity() == null) {
      throw new dty(48 + "No response body received. Status is " + i1);
    }
    if (i1 != 200) {
      throw new dty(39 + "Error returned from server: " + i1);
    }
    dtt localdtt = new dtt(AndroidHttpClient.getUngzippedContent(paramHttpResponse.getEntity()));
    paramHttpResponse = localdtt.a();
    if (paramHttpResponse == null) {
      throw new dty("End of stream while reading next chunk part");
    }
    gyz localgyz = a;
    Object localObject;
    label225:
    int i3;
    if (dri.a(g, 2))
    {
      localObject = g;
      paramHttpResponse = String.valueOf(new String(Base64.encode(hlt.a(localgyz), 2)));
      if (paramHttpResponse.length() != 0)
      {
        paramHttpResponse = "ResponsePreamble: ".concat(paramHttpResponse);
        dri.a((String)localObject, paramHttpResponse, new Object[0]);
        localObject = g;
        paramHttpResponse = String.valueOf(localgyz.toString());
        if (paramHttpResponse.length() == 0) {
          break label320;
        }
        paramHttpResponse = "ResponsePreamble: ".concat(paramHttpResponse);
        dri.a((String)localObject, paramHttpResponse, new Object[0]);
      }
    }
    else
    {
      i3 = c;
      a("serverVersion", i3);
      if ((a & 0x4) == 0) {
        break label334;
      }
    }
    label320:
    label334:
    for (i1 = 1;; i1 = 0)
    {
      if ((i1 == 0) || (!d)) {
        break label339;
      }
      throw new IOException(String.format(Locale.ENGLISH, "The server (version %d) does not support the protocol version that we used", new Object[] { Integer.valueOf(i3) }));
      paramHttpResponse = new String("ResponsePreamble: ");
      break;
      paramHttpResponse = new String("ResponsePreamble: ");
      break label225;
    }
    label339:
    if ((a & 0x8) != 0) {}
    for (i1 = 1; (i1 != 0) && (e); i1 = 0) {
      throw new dty("Abuse error reported");
    }
    i1 = g;
    if (i1 != 0)
    {
      long l1 = SystemClock.elapsedRealtime();
      p = (i1 + l1);
    }
    paramHttpResponse = f;
    dth localdth;
    label486:
    label499:
    Uri localUri;
    if (!TextUtils.isEmpty(paramHttpResponse))
    {
      localObject = h;
      paramHttpResponse = String.valueOf(paramHttpResponse);
      if (paramHttpResponse.length() != 0)
      {
        paramHttpResponse = "Received mustWipe error from server: ".concat(paramHttpResponse);
        ((dth)localObject).a(paramHttpResponse);
      }
    }
    else
    {
      b = b;
      localObject = k;
      localdth = h;
      if ((a & 0x40) == 0) {
        break label596;
      }
      i1 = 1;
      if (i1 == 0) {
        break label601;
      }
      paramHttpResponse = String.valueOf(h);
      a((Context)localObject, localdth, true, null, "temp_adie", paramHttpResponse);
      localObject = k;
      localdth = h;
      localUri = GmailProvider.f(h.p());
      if ((a & 0x80) == 0) {
        break label606;
      }
      i1 = i2;
      label552:
      if (i1 == 0) {
        break label611;
      }
    }
    label596:
    label601:
    label606:
    label611:
    for (paramHttpResponse = String.valueOf(i);; paramHttpResponse = null)
    {
      a((Context)localObject, localdth, false, localUri, "bx_tmpod", paramHttpResponse);
      return localdtt;
      paramHttpResponse = new String("Received mustWipe error from server: ");
      break;
      i1 = 0;
      break label486;
      paramHttpResponse = null;
      break label499;
      i1 = 0;
      break label552;
    }
  }
  
  private final duw b(HttpResponse paramHttpResponse, dua paramdua, long paramLong, dtd paramdtd, dqu paramdqu)
  {
    dtt localdtt = b(paramHttpResponse);
    if (b < 25)
    {
      i1 = b;
      throw new IllegalArgumentException(56 + "Attempt to use protos for a version-" + i1 + " response");
    }
    duw localduw = new duw();
    paramHttpResponse = null;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    label347:
    label362:
    label411:
    label439:
    int i4;
    boolean bool;
    label712:
    int i2;
    label770:
    label776:
    label782:
    label879:
    label983:
    Object localObject4;
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        if (f) {
          break;
        }
        localObject2 = localdtt.a();
        if (localObject2 == null) {
          break;
        }
        if (dri.a(g, 2))
        {
          localObject3 = g;
          localObject1 = String.valueOf(new String(Base64.encode(hlt.a((hlt)localObject2), 2)));
          if (((String)localObject1).length() != 0)
          {
            localObject1 = "HttpResponseChunk: ".concat((String)localObject1);
            dri.a((String)localObject3, (String)localObject1, new Object[0]);
            localObject3 = g;
            localObject1 = String.valueOf(((gyh)localObject2).toString());
            if (((String)localObject1).length() == 0) {
              break label347;
            }
            localObject1 = "HttpResponseChunk: ".concat((String)localObject1);
            dri.a((String)localObject3, (String)localObject1, new Object[0]);
          }
        }
        else
        {
          if (b == null) {
            break label411;
          }
          localObject2 = b;
          l1 = a;
          localObject1 = hio.a(b);
          localObject2 = hio.a(c);
          i1 = i();
          l2 = a("serverVersion");
          if (i1 <= l2) {
            break label362;
          }
          dri.d(g, "Ignoring config info from server because server version is %d but gservices says that the min server version is %d", new Object[] { Long.valueOf(l2), Integer.valueOf(i1) });
          a("needConfigSuggestion", false);
          a |= 0x1;
          continue;
        }
        localObject1 = new String("HttpResponseChunk: ");
      }
      finally
      {
        a.close();
      }
      continue;
      localObject1 = new String("HttpResponseChunk: ");
      continue;
      a(TextUtils.join(" ", (Iterable)localObject1), TextUtils.join(" ", (Iterable)localObject2), Long.valueOf(l1), Long.valueOf(0L));
      a("needConfigSuggestion", false);
      a("configDirty", true);
      continue;
      if (c != null)
      {
        localObject1 = c;
        if ((a & 0x1) == 0) {
          break label3167;
        }
        i1 = 1;
        if (i1 == 0) {
          throw new dty("ConfigAccepted Proto is missing a client_id value");
        }
        l1 = b;
        dri.b(g, "handleConfigAcceptedValues: %d", new Object[] { Long.valueOf(l1) });
        l2 = a("clientId");
        if ((l2 != 0L) && (l1 != l2)) {
          throw new IllegalStateException("Client id is already set but response has different id");
        }
        a("clientId", l1);
        a("configDirty", false);
        a("startSyncNeeded", true);
        a("highestBackwardConversationId", 0L);
        a("lowestBackwardConversationId", 0L);
        g();
        a |= 0x2;
      }
      else if (d != null)
      {
        a(d, paramdua);
        a |= 0x4;
        g = true;
      }
      else if (e != null)
      {
        a(e, paramdtd);
        a |= 0x8;
      }
      else
      {
        if (f != null)
        {
          localObject2 = f;
          h.c();
          int i3 = 0;
          for (;;)
          {
            try
            {
              if (b == null) {
                break label983;
              }
              localObject3 = b;
              i4 = a;
              if (i4 != 0) {
                break label770;
              }
              bool = true;
            }
            finally
            {
              h.d();
            }
            if ((bool) || (i1 != 0) || (i2 != 0)) {
              break;
            }
            throw new IllegalArgumentException(32 + "unknown change code: " + i4);
            bool = false;
            break label3173;
            i1 = 0;
            break label3182;
            i2 = 0;
          }
          localObject1 = null;
          if ((bool) || (i1 != 0)) {
            localObject1 = h.b(c);
          }
          l1 = b;
          i4 = b(d);
          localObject3 = hku.a(e);
          if ((bool) || (i1 != 0))
          {
            if (localObject1 != null) {
              h.a(l1, (List)localObject3, (drk)localObject1, bool, i4);
            }
            a(1);
            i1 = i3;
          }
          for (;;)
          {
            a("highestProcessedServerOperationId", a);
            g();
            if (paramdua != null) {
              paramdua.b();
            }
            h.d();
            if (i1 != 0) {
              GmailProvider.b(k, h.p());
            }
            a |= 0x10;
            break;
            if (i2 == 0) {
              break label879;
            }
            h.a(l1, (List)localObject3, i4);
            break label879;
            if (c != null)
            {
              localObject4 = c;
              localObject1 = h.b(a);
              localObject3 = b;
              localObject4 = c;
              if (localObject1 != null)
              {
                a("startSyncNeeded", true);
                h.a((drk)localObject1, (String)localObject3, (String)localObject4, "SHOW");
                a(hio.a(new String[] { localObject3 }), null, null);
                g();
              }
              a(1);
              i1 = i3;
            }
            else if (d != null)
            {
              localObject1 = d;
              a(h.b(a), b, c);
              i1 = i3;
            }
            else if (e != null)
            {
              localObject1 = h.c(e.a);
              if (localObject1 != null)
              {
                localObject3 = h.b((drk)localObject1);
                h.a((drk)localObject1);
                if (localObject3 != null) {
                  a(null, hio.a(new String[] { localObject3 }), null);
                }
                g();
              }
              a(1);
              i1 = i3;
            }
            else if (f != null)
            {
              a(f);
              i1 = i3;
            }
            else if (g != null)
            {
              localObject3 = g;
              localObject4 = b;
              if ((a & 0x4) == 0) {
                break label3206;
              }
              i1 = 1;
              if (i1 == 0) {
                break label3212;
              }
              bool = d;
              break label3194;
              for (;;)
              {
                label1315:
                dri.a(g, "MainSync: Custom preference name: %s value: %s", new Object[] { localObject4, localObject1 });
                if (!((String)localObject4).equals("sx_clcp")) {
                  break label1412;
                }
                dri.a(g, "MainSync: Custom Color: %s", new Object[] { localObject1 });
                i1 = i3;
                if (((String)localObject1).isEmpty()) {
                  break;
                }
                h.b(d((String)localObject1));
                i1 = i3;
                break;
                label1402:
                localObject1 = c;
              }
              label1412:
              if (((String)localObject4).equals("bx_rf"))
              {
                i1 = i3;
                if (!((String)localObject1).isEmpty())
                {
                  localObject1 = hdu.a("bx_rf", String.valueOf(localObject1));
                  h.c((Map)localObject1);
                  i1 = i3;
                }
              }
              else if (((String)localObject4).startsWith("/customfrom/"))
              {
                if (!bool)
                {
                  h.b(b((String)localObject1, true), false);
                  i1 = i3;
                }
                else
                {
                  dri.a(g, "Deleting preference %s", new Object[] { localObject4 });
                  h.f((String)localObject4);
                  i1 = i3;
                }
              }
              else
              {
                if (((String)localObject4).equals("sx_rt"))
                {
                  if (localObject1 == null) {
                    break label3218;
                  }
                  if (((String)localObject1).isEmpty()) {
                    break label3218;
                  }
                  for (;;)
                  {
                    label1569:
                    localObject1 = hdu.a("sx_rt", localObject1);
                    h.c((Map)localObject1);
                    i1 = i3;
                    break;
                    localObject1 = String.valueOf(localObject1);
                  }
                }
                if (((String)localObject4).equals("sx_dn"))
                {
                  if (localObject1 == null) {
                    break label3225;
                  }
                  if (((String)localObject1).isEmpty()) {
                    break label3225;
                  }
                  for (;;)
                  {
                    label1634:
                    localObject1 = hdu.a("sx_dn", localObject1);
                    h.c((Map)localObject1);
                    i1 = i3;
                    break;
                    localObject1 = String.valueOf(localObject1);
                  }
                }
                if (((String)localObject4).equals("sx_ioe"))
                {
                  i1 = i3;
                  if (localObject1 != null)
                  {
                    i1 = i3;
                    if (!bool)
                    {
                      localObject1 = hdu.a("sx_ioe", localObject1);
                      h.c((Map)localObject1);
                      a("startSyncNeeded", true);
                      i1 = i3;
                    }
                  }
                }
                else if (((String)localObject4).equals("sx_iosc"))
                {
                  i1 = i3;
                  if (localObject1 != null)
                  {
                    i1 = i3;
                    if (!bool)
                    {
                      localObject1 = hdu.a("sx_iosc", localObject1);
                      h.c((Map)localObject1);
                      i1 = i3;
                    }
                  }
                }
                else if (((String)localObject4).equals("bx_ioao"))
                {
                  i1 = i3;
                  if (localObject1 != null)
                  {
                    i1 = i3;
                    if (!bool)
                    {
                      localObject1 = hdu.a("bx_ioao", localObject1);
                      h.c((Map)localObject1);
                      i1 = i3;
                    }
                  }
                }
                else if (((String)localObject4).equals("bx_pie"))
                {
                  i1 = i3;
                  if (localObject1 != null)
                  {
                    i1 = i3;
                    if (!bool)
                    {
                      dri.c(g, "Received updated %s: %s", new Object[] { "bx_pie", localObject1 });
                      localObject1 = hdu.a("bx_pie", localObject1);
                      h.c((Map)localObject1);
                      i1 = i3;
                    }
                  }
                }
                else if (((String)localObject4).equals("sx_piac"))
                {
                  i1 = i3;
                  if (!bool)
                  {
                    localObject1 = e;
                    if (localObject1 != null)
                    {
                      dri.c(g, "Received updated %s: %s", new Object[] { "sx_piac", localObject1 });
                      localObject1 = new hen().b("sx_piac", localObject1).b();
                      h.d((Map)localObject1);
                      i1 = i3;
                    }
                    else
                    {
                      dri.f(g, "sx_piac was null", new Object[0]);
                      i1 = i3;
                    }
                  }
                }
                else if (((String)localObject4).equals("bx_piuf"))
                {
                  i1 = i3;
                  if (localObject1 != null)
                  {
                    i1 = i3;
                    if (!bool)
                    {
                      localObject3 = Boolean.valueOf((String)localObject1);
                      dri.a(g, "ForwardSync: personal inbox user flipped: %s", new Object[] { localObject3 });
                      i1 = i3;
                      if (((Boolean)localObject3).booleanValue())
                      {
                        h.a("ShouldShowSectionedInboxOOBE", (String)localObject1);
                        i1 = i3;
                      }
                    }
                  }
                }
                else if (((String)localObject4).startsWith("/blocked-sender/"))
                {
                  dri.a(g, "Updating SENDER_BLOCKED_PREF %s", new Object[] { localObject4 });
                  localObject3 = ((String)localObject4).replaceFirst("/blocked-sender/", "");
                  if (bool)
                  {
                    h.b((String)localObject3);
                    i1 = i3;
                  }
                  else
                  {
                    a((String)localObject3, (String)localObject1);
                    i1 = i3;
                  }
                }
                else if (((String)localObject4).startsWith("/unsubscribe_sender_list/"))
                {
                  dri.a(g, "Updating SENDER_UNSUBSCRIBED_PREF %s", new Object[] { localObject4 });
                  b(c((String)localObject4), (String)localObject1);
                  i1 = i3;
                }
                else if ((dkn.a()) && (((String)localObject4).startsWith("/gmailify-status/")))
                {
                  dri.a(g, "Updating G6Y_ACCOUNT_PREF %s", new Object[] { localObject4 });
                  localObject3 = ((String)localObject4).substring(17);
                  if (bool)
                  {
                    dnm.a(k, h.p()).f();
                    i1 = i3;
                  }
                  else
                  {
                    c((String)localObject3, (String)localObject1);
                    i1 = i3;
                  }
                }
                else
                {
                  if (bool) {
                    h.d((String)localObject4);
                  }
                  for (;;)
                  {
                    i1 = i3;
                    if (!"bx_eid".equals(localObject4)) {
                      break;
                    }
                    i1 = 1;
                    break;
                    h.a((String)localObject4, (String)localObject1);
                  }
                }
              }
            }
            else if (h != null)
            {
              h.a(new Promotion(h.a));
              i1 = i3;
            }
            else if (i != null)
            {
              h.a(i.a);
              i1 = i3;
            }
            else
            {
              dri.f(g, "No forward sync operation found", new Object[0]);
              i1 = i3;
            }
          }
        }
        if (g != null)
        {
          a(g);
          a |= 0x20;
        }
        else if (h != null)
        {
          localObject1 = a(h, localdtt, paramdua, paramLong, paramdtd);
          a |= 0x40;
          if (paramdqu != null)
          {
            paramdqu.c(b);
            f += 1;
          }
        }
        else if (i != null)
        {
          localObject1 = a(i, localdtt, paramdua, paramLong);
          a |= 0x80;
          if (paramdqu != null) {
            paramdqu.c(b);
          }
        }
        else
        {
          if (m != null)
          {
            l1 = m.a;
            h.c();
          }
          try
          {
            h.a(l1, 2);
            h.a(l1, new dtd());
            h.d();
            a |= 0x100;
          }
          finally
          {
            h.d();
          }
          l1 = n.a;
          h.d(l1);
          a |= 0x200;
        }
      }
    }
    if (o != null)
    {
      paramHttpResponse = o;
      a |= 0x400;
      if ((a & 0x8) == 0) {
        break label3232;
      }
    }
    label3121:
    label3161:
    label3167:
    label3173:
    label3182:
    label3194:
    label3206:
    label3212:
    label3216:
    label3218:
    label3225:
    label3232:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        a("lowestMessageIdInDuration", e);
        g();
      }
      h();
      break;
      if (r != null)
      {
        localObject3 = r;
        h.c();
      }
      for (;;)
      {
        try
        {
          if (b == null) {
            break label3161;
          }
          localObject1 = b.a;
          if (c != null)
          {
            localObject2 = c.a;
            if (localObject2 != null)
            {
              localObject4 = g;
              localObject2 = String.valueOf(localObject2);
              if (((String)localObject2).length() == 0) {
                continue;
              }
              localObject2 = "Ads targetting info: ".concat((String)localObject2);
              dri.b((String)localObject4, (String)localObject2, new Object[0]);
            }
          }
          a(a, (String)localObject1, 0);
          a(e, (String)localObject1, 1);
          a(f, (String)localObject1, 2);
          a(g, (String)localObject1, 3);
          a(d, (String)localObject1, 4);
          h.d();
          a |= 0x800;
          break;
          localObject2 = new String("Ads targetting info: ");
          continue;
          if (s == null) {
            break label3121;
          }
        }
        finally
        {
          h.d();
        }
        a(s);
        a |= 0x1000;
        break;
        throw new dty("No protobuf found inside response chunk");
        if ((!f) && (paramHttpResponse != null)) {
          a(paramHttpResponse, paramdtd);
        }
        a.close();
        return localduw;
        localObject1 = null;
      }
      i1 = 0;
      break label439;
      if (i4 != 1) {
        break label776;
      }
      i1 = 1;
      if (i4 != 2) {
        break label782;
      }
      i2 = 1;
      break label712;
      for (;;)
      {
        if (!bool) {
          break label3216;
        }
        localObject1 = "";
        break label1315;
        i1 = 0;
        break;
        bool = false;
      }
      break label1402;
      localObject1 = "";
      break label1569;
      localObject1 = "";
      break label1634;
    }
  }
  
  private static Map<String, dti> b(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (!paramBoolean) {
      paramString = TextUtils.split(paramString, "(?<!\\\\)#");
    }
    for (;;)
    {
      int i2 = paramString.length;
      int i1 = 0;
      label26:
      if (i1 < i2)
      {
        String str = paramString[i1];
        String[] arrayOfString = TextUtils.split(a(str, '#'), "(?<!\\\\),");
        Object localObject;
        if ((arrayOfString.length < 4) || (TextUtils.isEmpty(arrayOfString[3]))) {
          localObject = arrayOfString[1];
        }
        try
        {
          for (;;)
          {
            localObject = new dti(a(arrayOfString[0], ','), arrayOfString[1], arrayOfString[2], (String)localObject);
            if (arrayOfString[1].contains("@")) {
              localHashMap.put(arrayOfString[1], localObject);
            }
            i1 += 1;
            break label26;
            localObject = new String[1];
            localObject[0] = paramString;
            paramString = (String)localObject;
            break;
            localObject = arrayOfString[3];
          }
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            dri.a(g, "Unexpected Custom from preference received: %s", new Object[] { str });
          }
        }
      }
    }
    return localHashMap;
  }
  
  private final void b(String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        dri.b(g, "prefValue: %s", new Object[] { paramString2 });
        Object localObject = Base64.decode(paramString2, 8);
        localObject = (gzr)hlt.a(new gzr(), (byte[])localObject, localObject.length);
        int i1;
        if ((a & 0x1) != 0)
        {
          i1 = 1;
          if (i1 != 0)
          {
            l1 = b;
            h.a(paramString1, l1);
          }
        }
        else
        {
          i1 = 0;
          continue;
        }
        long l1 = 0L;
      }
      catch (IOException localIOException)
      {
        h.a(paramString1, 0L);
        dri.d(g, localIOException, "Unable to parse SENDER_UNSUBSCRIBED_PREF value %s", new Object[] { paramString2 });
        return;
      }
    }
  }
  
  private static <E> boolean b(Set<E> paramSet1, Set<E> paramSet2)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramSet2 == null) {
      return bool2;
    }
    paramSet1 = paramSet1.iterator();
    for (;;)
    {
      bool2 = bool1;
      if (!paramSet1.hasNext()) {
        break;
      }
      if (!paramSet2.contains(paramSet1.next()))
      {
        paramSet1.remove();
        bool1 = true;
      }
    }
  }
  
  private static String c(String paramString)
  {
    return paramString.substring(paramString.indexOf(":") + 1);
  }
  
  private final void c(String paramString1, String paramString2)
  {
    dnm localdnm = dnm.a(k, h.p());
    long l1 = 0L;
    String str1 = "";
    String str2 = "";
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        dri.b(g, "prefValue: %s", new Object[] { paramString2 });
        localObject = Base64.decode(paramString2, 8);
        gws localgws = (gws)hlt.a(new gws(), (byte[])localObject, localObject.length);
        if ((a & 0x2) == 0) {
          break label360;
        }
        i1 = 1;
        if (i1 == 0) {
          break label338;
        }
        i1 = c;
        if ((a & 0x1) == 0) {
          break label365;
        }
        i2 = 1;
        if (i2 != 0) {
          l1 = b;
        }
        if ((a & 0x4) == 0) {
          break label371;
        }
        i2 = 1;
        if (i2 != 0) {
          str1 = d;
        }
        if ((a & 0x8) == 0) {
          break label377;
        }
        i2 = 1;
        if (i2 != 0)
        {
          bool1 = e;
          if ((a & 0x10) == 0) {
            break label383;
          }
          i2 = 1;
          i3 = i1;
          l2 = l1;
          localObject = str1;
          bool2 = bool1;
          if (i2 != 0)
          {
            str2 = f;
            bool2 = bool1;
            localObject = str1;
            l2 = l1;
            i3 = i1;
          }
          localdnm.a(paramString1, i3, l2, (String)localObject, bool2, str2);
          if ((i3 == 1) || (TextUtils.isEmpty((CharSequence)localObject)))
          {
            dkn.a(k, paramString1);
            return;
          }
          dkn.a(k, paramString1, h.p(), localdnm.e(i3), (String)localObject, bool2, str2);
          return;
        }
      }
      catch (IOException localIOException)
      {
        dri.d(g, localIOException, "Unable to parse g6y account pref value %s", new Object[] { paramString2 });
        localdnm.d(paramString1);
        return;
      }
      boolean bool1 = false;
      continue;
      label338:
      int i1 = 0;
      continue;
      boolean bool2 = false;
      int i3 = 0;
      long l2 = l1;
      Object localObject = localIOException;
      continue;
      label360:
      i1 = 0;
      continue;
      label365:
      int i2 = 0;
      continue;
      label371:
      i2 = 0;
      continue;
      label377:
      i2 = 0;
      continue;
      label383:
      i2 = 0;
    }
  }
  
  private static Map<String, dtj> d(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = TextUtils.split(paramString, ",");
    int i2 = arrayOfString1.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        String[] arrayOfString2 = TextUtils.split(arrayOfString1[i1], ":");
        try
        {
          dtj localdtj = new dtj(arrayOfString2[1], arrayOfString2[2]);
          localHashMap.put(arrayOfString2[0], localdtj);
          i1 += 1;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            dri.a(g, "Unexpected Custom Color preference received: %s", new Object[] { paramString });
          }
        }
      }
    }
    return localHashMap;
  }
  
  private final boolean d(String paramString1, String paramString2)
  {
    if ((!j.containsKey(paramString1)) || (!((String)j.get(paramString1)).equals(paramString2)))
    {
      j.put(paramString1, paramString2);
      s.put(paramString1, paramString2);
      return true;
    }
    return false;
  }
  
  private final String e(String paramString)
  {
    if (j.containsKey(paramString)) {
      return (String)j.get(paramString);
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "missing setting: ".concat(paramString);; paramString = new String("missing setting: ")) {
      throw new IllegalStateException(paramString);
    }
  }
  
  private final Set<String> f(String paramString)
  {
    return hio.a(TextUtils.split(e(paramString), dpy.d));
  }
  
  private final void h()
  {
    ??? = h.e("ix_awtsv");
    int i1;
    Integer localInteger;
    Object localObject3;
    Object localObject4;
    if (??? == null)
    {
      i1 = -1;
      localInteger = Integer.valueOf(i1);
      localObject3 = WelcomeTourActivity.a;
      localObject4 = h.p();
      if (??? != null) {
        break label226;
      }
      ??? = "not set";
      dri.a((String)localObject3, "Checking welcome tour status after sync for %s - account pref was %s ", new Object[] { localObject4, ??? });
      localObject3 = dmv.a();
    }
    for (;;)
    {
      synchronized (r)
      {
        localObject4 = new ddy(k).b(new String[] { "mail", "gmailrenameeligible" }).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          if (!((String)((Iterator)localObject4).next()).equals(h.p())) {
            continue;
          }
          i1 = 1;
          if ((i1 != 0) && (localInteger.intValue() <= 0))
          {
            ((dmv)localObject3).a(k, true);
            dri.d(WelcomeTourActivity.a, "Forcing display of welcome tour for rename eligible account %s ", new Object[] { h.p() });
          }
          ((dmv)localObject3).a(k, localInteger.intValue());
          return;
          i1 = Integer.parseInt((String)???);
          break;
          label226:
          ??? = localInteger;
        }
      }
      i1 = 0;
    }
  }
  
  private final int i()
  {
    String str = ghz.a(l, "gmail_config_info_min_server_version");
    if (str == null) {
      return 0;
    }
    try
    {
      int i1 = Integer.valueOf(str).intValue();
      return i1;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0;
  }
  
  public final long a(drk paramdrk)
  {
    long l2 = Long.MAX_VALUE;
    long l1 = 0L;
    Set localSet1 = f("labelsIncluded");
    Set localSet2 = f("labelsPartial");
    String str = h.b(paramdrk);
    if (a("clientId") == 0L) {}
    while ((paramdrk != null) && (drj.d(a))) {
      return 0L;
    }
    if (str != null) {
      if (!localSet1.contains(str)) {}
    }
    for (;;)
    {
      if (j.containsKey("lowestBackwardConversationId")) {
        l2 = a("lowestBackwardConversationId");
      }
      return Math.max(l1, l2);
      if (localSet2.contains(str))
      {
        if (j.containsKey("lowestMessageIdInDuration")) {
          l1 = a("lowestMessageIdInDuration") - 1L;
        } else {
          l1 = Long.MAX_VALUE;
        }
      }
      else {
        l1 = Long.MAX_VALUE;
      }
    }
  }
  
  public final long a(String paramString)
  {
    if (j.containsKey(paramString)) {
      return Long.parseLong((String)j.get(paramString));
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "missing setting: ".concat(paramString);; paramString = new String("missing setting: ")) {
      throw new IllegalStateException(paramString);
    }
  }
  
  final long a(HttpResponse paramHttpResponse, dtr paramdtr)
  {
    dtt localdtt = b(paramHttpResponse);
    for (;;)
    {
      try
      {
        paramHttpResponse = localdtt.a();
        if ((paramHttpResponse != null) && (p != null))
        {
          long l1 = a(p, paramdtr);
          return l1;
        }
        paramdtr = g;
        if (paramHttpResponse != null)
        {
          paramHttpResponse = "null protoBuf";
          dri.d(paramdtr, "handleQueryResponseProto: No query result found inside response chunk. reason: %s", new Object[] { paramHttpResponse });
          throw new dty("No query result found inside response chunk");
        }
      }
      finally
      {
        a.close();
      }
      paramHttpResponse = "missing query result";
    }
  }
  
  public final dut a(dtd paramdtd)
  {
    ArrayList localArrayList;
    return a(false, paramdtd, localArrayList, null, false);
  }
  
  public final dut a(boolean paramBoolean1, dtd paramdtd, ArrayList<dtq> paramArrayList, dqu paramdqu, boolean paramBoolean2)
  {
    for (;;)
    {
      l1 = SystemClock.elapsedRealtime();
      if (l1 >= p) {
        break;
      }
      try
      {
        l1 = p - l1;
        dri.c(g, "Sync waiting for %d ms", new Object[] { Long.valueOf(l1) });
        Thread.sleep(l1);
      }
      catch (InterruptedException localInterruptedException) {}
    }
    f = false;
    int i1;
    if (b("needConfigSuggestion"))
    {
      paramdtd = i;
      paramArrayList = l;
      i1 = b();
      paramdqu = dvd.a();
      c = new gxd();
      cvm.b("Gmail", "getSyncConfigSuggestion: GetConfigInfo", new Object[0]);
      return new dut(paramdtd.a(paramArrayList, i1, 0L, paramdqu, true), 0);
    }
    long l3 = a("clientId");
    boolean bool = b("configDirty");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((l3 == 0L) || ((bool) && (!b)))
    {
      paramArrayList = g;
      if (l3 == 0L) {}
      for (paramdtd = "clientId is 0";; paramdtd = "config is dirty")
      {
        dri.c(paramArrayList, "Creating sync config request because %s", new Object[] { paramdtd });
        l1 = l3;
        if (l3 == 0L) {
          l1 = System.currentTimeMillis();
        }
        paramdtd = i;
        paramArrayList = l;
        i1 = b();
        paramdqu = f("labelsIncluded");
        localObject1 = f("labelsPartial");
        l2 = a("conversationAgeDays");
        localObject2 = dvd.a();
        d = new gxa();
        localObject3 = d;
        b = ((int)l2);
        a |= 0x1;
        c = ((String[])paramdqu.toArray(hlw.f));
        d = ((String[])((Set)localObject1).toArray(hlw.f));
        cvm.b("Gmail", "getSyncConfigRequest: conversationAgeDays: %d, labelsIncluded: %s, labelsPartial: %s", new Object[] { Long.valueOf(l2), paramdqu, localObject1 });
        return new dut(paramdtd.a(paramArrayList, i1, l1, (gww)localObject2, true), 1);
      }
    }
    long l4 = a("highestProcessedServerOperationId");
    long l2 = a("highestBackwardConversationId");
    long l1 = a("lowestBackwardConversationId");
    if ((b("startSyncNeeded")) || (b("unackedSentOperations")) || (paramBoolean2))
    {
      if (l2 >= l1) {
        break label1693;
      }
      l1 = 0L;
      l2 = 0L;
    }
    label1224:
    label1239:
    label1371:
    label1454:
    label1514:
    label1625:
    label1631:
    label1645:
    label1651:
    label1657:
    label1693:
    for (;;)
    {
      if (paramBoolean2) {
        dri.c(g, "Force Start sync", new Object[0]);
      }
      paramdtd = i;
      paramArrayList = l;
      i1 = b();
      long l5 = a("clientOpToAck");
      localObject1 = dnr.a(k, h.p());
      localObject2 = dvd.a();
      e = new gxh();
      localObject3 = e;
      b = l4;
      a |= 0x1;
      c = l2;
      a |= 0x2;
      d = l1;
      a |= 0x4;
      e = l5;
      a |= 0x8;
      f = true;
      a |= 0x10;
      g = true;
      a |= 0x20;
      h = true;
      a |= 0x40;
      i = true;
      a |= 0x100;
      j = true;
      a |= 0x400;
      k = true;
      a |= 0x800;
      if (dmn.a(b))
      {
        l = true;
        a |= 0x1000;
      }
      n = true;
      a |= 0x4000;
      o = true;
      a |= 0x8000;
      if (dkn.a())
      {
        p = true;
        a |= 0x10000;
      }
      Object localObject4 = Locale.getDefault();
      localObject4 = String.format(Locale.ENGLISH, "%s-%s", new Object[] { ((Locale)localObject4).getLanguage(), ((Locale)localObject4).getCountry() });
      if (localObject4 == null) {
        throw new NullPointerException();
      }
      m = ((String)localObject4);
      a |= 0x2000;
      j = d.a();
      l = dvd.a(paramdqu, (dnr)localObject1);
      dvd.a((gww)localObject2, paramdqu);
      cvm.c("Gmail", "getStartSyncRequest: handledServerOpId: %d, upperFetchedConvoId: %d, lowerFetchedConvoId: %d, ackedClientOp: %d", new Object[] { Long.valueOf(l4), Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l5) });
      return new dut(paramdtd.a(paramArrayList, i1, l3, (gww)localObject2, true), 2);
      localObject3 = f();
      if (b)
      {
        paramArrayList = new ArrayList();
        localObject1 = new ArrayList();
        if (dri.a(g, 2))
        {
          localObject4 = g;
          localObject2 = String.valueOf(Arrays.toString(paramArrayList.toArray()));
          if (((String)localObject2).length() == 0) {
            break label1224;
          }
        }
      }
      for (localObject2 = "highestMessageIds: ".concat((String)localObject2);; localObject2 = new String("highestMessageIds: "))
      {
        dri.a((String)localObject4, (String)localObject2, new Object[0]);
        paramBoolean2 = dmv.a().g(k, h.p());
        bool = dyb.a(k, h.p());
        localObject4 = i.a(l, l1, l4, a("clientOpToAck"), paramArrayList, (ArrayList)localObject1, (ArrayList)localObject3, paramBoolean2, bool, paramdtd, paramdqu, dnr.a(k, h.p()));
        if (!f) {
          break label1239;
        }
        return null;
        if (paramArrayList != null) {}
        for (;;)
        {
          localObject1 = h.g();
          break;
          paramArrayList = h.a(paramdtd);
        }
      }
      paramdqu = h;
      dtx localdtx = new dtx(this);
      int i3 = h.a(localdtx, paramdtd, System.currentTimeMillis() / 1000L);
      c = ((gxj[])a.toArray(gxj.b()));
      ArrayList localArrayList = b;
      localObject2 = i.a(l, b(), l3, (gww)localObject4, false);
      if (ghz.a(l, "gmail_use_multipart_protobuf", 1) != 0)
      {
        i1 = 1;
        if (i1 == 0) {
          break label1631;
        }
        if ((b == null) || (b.size() <= 0)) {
          break label1625;
        }
        i1 = 1;
        if ((i1 == 0) || (localArrayList == null)) {
          break label1631;
        }
        localArrayList.add(new ddi("PROTOBUFDATA", new dtw(this, "PROTOBUFDATA", ((gww)localObject4).d(), hlt.a((hlt)localObject4)), null));
        ((HttpPost)localObject2).setEntity(new ddn((ddq[])localArrayList.toArray(new ddq[localArrayList.size()])));
        l2 = c.length;
        localObject4 = n;
        localObject4[5] = (l2 + localObject4[5]);
        if ((l1 == 0L) && (paramArrayList.size() == 0) && (!b("moreForwardSyncNeeded")) && (((ArrayList)localObject1).size() == 0)) {
          break label1645;
        }
        i1 = 1;
        if (c.length == 0) {
          break label1651;
        }
      }
      for (int i2 = 1;; i2 = 0)
      {
        if ((i2 == 0) && ((b) || (i1 == 0)) && (!paramBoolean1)) {
          break label1657;
        }
        a("moreForwardSyncNeeded", true);
        if (c.length != 0) {
          a("unackedSentOperations", true);
        }
        g();
        paramdtd = new dut((HttpUriRequest)localObject2, 3);
        b.c = new duu(paramArrayList.size(), ((ArrayList)localObject1).size(), ((ArrayList)localObject3).size(), i3);
        return paramdtd;
        i1 = 0;
        break;
        i1 = 0;
        break label1371;
        dvd.a(l, (gww)localObject4, (HttpPost)localObject2);
        break label1454;
        i1 = 0;
        break label1514;
      }
      dri.c(g, 51 + "lowestBackward conversation id " + l1, new Object[0]);
      return null;
    }
  }
  
  final duw a(HttpResponse paramHttpResponse, dua paramdua, long paramLong, dtd paramdtd, dqu paramdqu)
  {
    if (paramHttpResponse == null) {
      throw new IOException("null HttpResponse in MailSync.handleResponse");
    }
    Object localObject = paramHttpResponse.getFirstHeader("Content-Type");
    if (localObject == null) {
      throw new IOException("Missing Content-Type header");
    }
    localObject = ((Header)localObject).getValue();
    if (((String)localObject).startsWith("application/vnd.google-x-gms-proto")) {
      return b(paramHttpResponse, paramdua, paramLong, paramdtd, paramdqu);
    }
    if (((String)localObject).startsWith("text/html"))
    {
      int i1 = paramHttpResponse.getStatusLine().getStatusCode();
      buo.a().a("errors", "sync_http_response_code", Integer.toString(i1), 0L);
      if (dri.a(g, 2)) {
        a(paramHttpResponse);
      }
      throw new IOException(79 + "Server returned unhandled response content type (text/html status: " + i1 + ")");
    }
    paramHttpResponse = String.valueOf(localObject);
    if (paramHttpResponse.length() != 0) {}
    for (paramHttpResponse = "Unknown response content type: ".concat(paramHttpResponse);; paramHttpResponse = new String("Unknown response content type: ")) {
      throw new IOException(paramHttpResponse);
    }
  }
  
  public final void a()
  {
    n = new long[m.length];
  }
  
  final void a(int paramInt)
  {
    long[] arrayOfLong = n;
    arrayOfLong[paramInt] += 1L;
  }
  
  public final boolean a(String paramString1, String paramString2, Long paramLong1, Long paramLong2)
  {
    if (paramString1 != null) {
      paramString1 = hfd.a(TextUtils.split(paramString1, o));
    }
    for (boolean bool1 = a("labelsIncluded", paramString1) | false;; bool1 = false)
    {
      if (paramString2 != null) {
        paramString2 = hfd.a(TextUtils.split(paramString2, o));
      }
      for (boolean bool2 = bool1 | a("labelsPartial", paramString2);; bool2 = bool1)
      {
        bool1 = bool2;
        if (paramLong1 != null) {
          bool1 = bool2 | a("conversationAgeDays", paramLong1.longValue());
        }
        bool2 = bool1;
        if (paramLong2 != null) {
          bool2 = bool1 | a("maxAttachmentSize", paramLong2.longValue());
        }
        if ((bool2 | a("needConfigSuggestion", false)))
        {
          dri.c(g, "config changed locally to changed the label sets to: included(%s), partial(%s)", new Object[] { dri.a(paramString1), dri.a(paramString2) });
          a("configDirty", true);
          a(null, null, null);
          g();
          return true;
        }
        return false;
        paramString2 = null;
      }
      paramString1 = null;
    }
  }
  
  final boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l1 = 1L;; l1 = 0L) {
      return d(paramString, Long.toString(l1));
    }
  }
  
  public final int b()
  {
    int i1 = (int)a("serverVersion");
    if (i1 == 0) {
      return 25;
    }
    if (i1 < 25)
    {
      dri.d(g, "Server version (%d) is too old to talk to. Minimum supported version is %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(25) });
      return 25;
    }
    return Math.min(i1, 25);
  }
  
  final boolean b(String paramString)
  {
    if (j.containsKey(paramString)) {
      return Long.parseLong((String)j.get(paramString)) != 0L;
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "missing setting: ".concat(paramString);; paramString = new String("missing setting: ")) {
      throw new IllegalStateException(paramString);
    }
  }
  
  public final String[] c()
  {
    return TextUtils.split(e("labelsIncluded"), o);
  }
  
  public final String[] d()
  {
    return TextUtils.split(e("labelsPartial"), o);
  }
  
  public final void e()
  {
    q.clear();
  }
  
  final ArrayList<Long> f()
  {
    ArrayList localArrayList = h.h();
    localArrayList.addAll(q);
    return localArrayList;
  }
  
  final void g()
  {
    if ((s.containsKey("labelsIncluded")) || (s.containsKey("labelsPartial")) || (s.containsKey("conversationAgeDays")) || (s.containsKey("maxAttachmentSize"))) {}
    for (boolean bool = true;; bool = false)
    {
      Map localMap = s;
      s = new HashMap();
      h.a(localMap, bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     dtn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */