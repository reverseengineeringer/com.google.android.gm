import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.mail.providers.Attachment;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class dtx
  implements dtl
{
  final List<gxj> a = new ArrayList();
  ArrayList<ddq> b = null;
  
  dtx(dtn paramdtn) {}
  
  private final void a(dtu paramdtu, Exception paramException, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = "com.google.android.gm.intent.ACTION_POST_SAVE_ERROR";; localObject = "com.google.android.gm.intent.ACTION_POST_SEND_ERROR")
    {
      localObject = new Intent((String)localObject);
      ((Intent)localObject).putExtra("account", c.h.p());
      ((Intent)localObject).putExtra("extraMessageSubject", m);
      ((Intent)localObject).putExtra("extraConversationId", d);
      c.k.sendBroadcast((Intent)localObject, "com.google.android.gm.permission.BROADCAST_INTERNAL");
      buo.a().a("errors", "read_cached_attachment", paramException.getMessage(), 0L);
      return;
    }
  }
  
  private final void a(gxp paramgxp, dtu paramdtu, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = r.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      GmailAttachment localGmailAttachment = (GmailAttachment)localIterator.next();
      switch (r)
      {
      default: 
        i = r;
        throw new IllegalArgumentException(27 + "Unknown origin: " + i);
      case 0: 
        localArrayList1.add(localGmailAttachment.r());
        break;
      case 1: 
        long l;
        label185:
        int j;
        if (hbw.b(b))
        {
          l = c;
          str = 32 + l + "-" + i;
          i += 1;
          if (ghz.a(c.l, "gmail_use_multipart_protobuf", 1) == 0) {
            break label352;
          }
          j = 1;
          Object localObject1 = null;
          if (j == 0) {
            break label424;
          }
        }
        Object localObject2;
        try
        {
          localObject2 = new ddi(str, new dto(c, c, localGmailAttachment), localGmailAttachment.l());
          if (b == null) {
            b = new ArrayList();
          }
          b.add(localObject2);
          localObject2 = new gxq();
          if (str != null) {
            break label585;
          }
          throw new NullPointerException();
          l = c;
          str = String.valueOf(b);
          str = String.valueOf(str).length() + 21 + l + "-" + str;
          break label185;
          label352:
          j = 0;
        }
        catch (IOException localIOException1)
        {
          dri.e(dtn.g, localIOException1, "IO error while reading attachment: %s", new Object[] { str });
          a(paramdtu, localIOException1, paramBoolean);
          continue;
        }
        catch (SecurityException localSecurityException1)
        {
          dri.e(dtn.g, localSecurityException1, "SecurityException while reading attachment: %s", new Object[] { str });
          a(paramdtu, localSecurityException1, paramBoolean);
        }
        continue;
        try
        {
          label424:
          InputStream localInputStream = c.h.a(localGmailAttachment);
          localObject2 = new ByteArrayOutputStream();
          byte[] arrayOfByte2 = new byte['Ѐ'];
          l = SystemClock.elapsedRealtime();
          do
          {
            int k = localInputStream.read(arrayOfByte2);
            if (k < 0) {
              break;
            }
            ((ByteArrayOutputStream)localObject2).write(arrayOfByte2, 0, k);
          } while (SystemClock.elapsedRealtime() - l <= 3600000L);
          throw new IOException("Timed out reading attachment");
        }
        catch (IOException localIOException2)
        {
          dri.e(dtn.g, localIOException2, "IO error while reading attachment: %s", new Object[] { str });
          a(paramdtu, localIOException2, paramBoolean);
          continue;
          byte[] arrayOfByte1 = ((ByteArrayOutputStream)localObject2).toByteArray();
        }
        catch (SecurityException localSecurityException2)
        {
          dri.e(dtn.g, localSecurityException2, "Security exception while reading attachment: %s", new Object[] { str });
          a(paramdtu, localSecurityException2, paramBoolean);
        }
        continue;
        label585:
        b = str;
        a |= 0x1;
        String str = c;
        if (!TextUtils.isEmpty(str))
        {
          if (str == null) {
            throw new NullPointerException();
          }
          c = str;
          a |= 0x2;
        }
        str = localGmailAttachment.l();
        if (str == null) {
          throw new NullPointerException();
        }
        d = str;
        a |= 0x4;
        if (j == 0)
        {
          if (localSecurityException2 == null) {
            throw new NullPointerException();
          }
          e = localSecurityException2;
          a |= 0x8;
        }
        localArrayList2.add(localObject2);
      }
    }
    i = ((String[])localArrayList1.toArray(hlw.f));
    j = ((gxq[])localArrayList2.toArray(gxq.b()));
  }
  
  private static boolean a(long paramLong)
  {
    return paramLong == 0L;
  }
  
  private final gxj b(long paramLong)
  {
    gxj localgxj = new gxj();
    b = paramLong;
    a |= 0x1;
    a.add(localgxj);
    return localgxj;
  }
  
  public final void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    dri.a(dtn.g, "MailSync posting operation %d (emptySpamOrTrash): folderType=%d messageSequenceNumber=%d maxCount=%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) });
    Object localObject = b(paramLong1);
    i = new gxl();
    localObject = i;
    b = paramInt1;
    a |= 0x1;
    c = paramLong2;
    a |= 0x2;
    d = paramInt2;
    a |= 0x4;
  }
  
  public final void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    dri.a(dtn.g, "MailSync posting operation %d (event rsvp): eventId: %s, calendarId: %s, responseStatus: %s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2, Integer.valueOf(paramInt) });
    Object localObject = b(paramLong);
    o = new gxm();
    localObject = o;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramString1 == null) {
        throw new NullPointerException();
      }
      b = paramString1;
      a |= 0x1;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2 == null) {
        throw new NullPointerException();
      }
      c = paramString2;
      a |= 0x2;
    }
    d = paramInt;
    a |= 0x4;
  }
  
  public final void a(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    dri.a(dtn.g, "Ad uphill sync for id: %s, type: %d, durationSinceLastAction: %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString9 });
    Object localObject = b(paramLong);
    j = new gxn();
    localObject = j;
    b = paramInt;
    a |= 0x1;
    g = paramBoolean;
    a |= 0x20;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramString1 == null) {
        throw new NullPointerException();
      }
      c = paramString1;
      a |= 0x2;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2 == null) {
        throw new NullPointerException();
      }
      e = paramString2;
      a |= 0x8;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      if (paramString3 == null) {
        throw new NullPointerException();
      }
      d = paramString3;
      a |= 0x4;
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      if (paramString4 == null) {
        throw new NullPointerException();
      }
      f = paramString4;
      a |= 0x10;
    }
    if (!TextUtils.isEmpty(paramString5))
    {
      if (paramString5 == null) {
        throw new NullPointerException();
      }
      h = paramString5;
      a |= 0x40;
    }
    if (!TextUtils.isEmpty(paramString6))
    {
      if (paramString6 == null) {
        throw new NullPointerException();
      }
      i = paramString6;
      a |= 0x80;
    }
    if (paramString7 != null) {}
    try
    {
      paramInt = Integer.valueOf(paramString7).intValue();
      if (paramInt >= 0)
      {
        j = paramInt;
        a |= 0x100;
      }
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        dri.e(dtn.g, "adAction has invalid dismissSurveyAnswer %s", new Object[] { paramString7 });
      }
      k = paramString8;
      a |= 0x800;
      if (TextUtils.isEmpty(paramString9)) {
        break label487;
      }
      try
      {
        paramLong = Long.valueOf(paramString9).longValue();
        if (paramLong > 0L)
        {
          l = paramLong;
          a |= 0x1000;
        }
      }
      catch (NumberFormatException paramString1)
      {
        for (;;)
        {
          try
          {
            label487:
            m = Integer.valueOf(paramString10).intValue();
            a |= 0x2000;
            return;
          }
          catch (NumberFormatException paramString1)
          {
            dri.e(dtn.g, "adAction has invalid tab %s", new Object[] { paramString10 });
          }
          paramString1 = paramString1;
          dri.e(dtn.g, "adAction has invalid durationSinceLastAction %s", new Object[] { paramString9 });
        }
      }
      if (TextUtils.isEmpty(paramString10)) {
        break label522;
      }
    }
    if (!TextUtils.isEmpty(paramString8)) {
      if (paramString8 == null) {
        throw new NullPointerException();
      }
    }
    label522:
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    gxj localgxj = b(paramLong1);
    f = paramLong2;
    a |= 0x2;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (dri.a(dtn.g, 2)) {
      dri.a(dtn.g, "MailSync posting operation %d (promo event): promoId: %d, promoActionType: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    }
    Object localObject = b(paramLong1);
    m = new gya();
    localObject = m;
    b = paramLong2;
    a |= 0x1;
    c = paramInt;
    a |= 0x2;
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (a(paramLong3)) {}
    Object localObject;
    String str;
    do
    {
      return;
      localObject = b(paramLong1);
      c = new gxo();
      localObject = c;
      ((gxo)localObject).a(true);
      ((gxo)localObject).a(paramLong2);
      if (!drj.d(paramLong3)) {
        break;
      }
      str = (String)dpy.i.get(Long.valueOf(paramLong3));
    } while (TextUtils.isEmpty(str));
    if (str == null) {
      throw new NullPointerException();
    }
    b = str;
    a |= 0x8;
    return;
    ((gxo)localObject).a((int)paramLong3);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if (a(paramLong3)) {}
    Object localObject;
    String str;
    do
    {
      return;
      localObject = b(paramLong1);
      d = new gxk();
      localObject = d;
      d = paramBoolean;
      a |= 0x4;
      b = paramLong2;
      a |= 0x1;
      if (!drj.d(paramLong3)) {
        break;
      }
      str = (String)dpy.i.get(Long.valueOf(paramLong3));
    } while (TextUtils.isEmpty(str));
    if (str == null) {
      throw new NullPointerException();
    }
    e = str;
    a |= 0x8;
    return;
    c = ((int)paramLong3);
    a |= 0x2;
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString)
  {
    dri.a(dtn.g, "MailSync posting operation %d (resetUnseenCount):  messageSequenceNumber=%d query=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
    Object localObject = b(paramLong1);
    g = new gyb();
    localObject = g;
    c = paramLong2;
    a |= 0x2;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      b = paramString;
      a |= 0x1;
    }
  }
  
  public final void a(long paramLong1, dtu paramdtu, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    dri.a(dtn.g, "MailSync posting operation %d (messageSavedOrSent)", new Object[] { Long.valueOf(paramLong1) });
    Object localObject = b(paramLong1);
    e = new gxp();
    gxp localgxp = e;
    k = paramBoolean;
    a |= 0x80;
    b = paramLong2;
    a |= 0x1;
    c = paramLong3;
    a |= 0x2;
    if (H != null)
    {
      localObject = H;
      if (localObject == null) {
        throw new NullPointerException();
      }
      p = ((String)localObject);
      a |= 0x2000;
    }
    if (!TextUtils.isEmpty(H))
    {
      localObject = dos.a(c.k, a).a(dpy.o, H);
      if (localObject == null) {
        break label429;
      }
      String str;
      try
      {
        if (!((Cursor)localObject).moveToFirst()) {
          break label429;
        }
        i = ((Cursor)localObject).getColumnIndex("send_body");
        int j = ((Cursor)localObject).getColumnIndex("body");
        if ((i == -1) || (j == -1) || (((Cursor)localObject).getInt(i) != 1)) {
          break label321;
        }
        str = ((Cursor)localObject).getString(j);
        if (TextUtils.isEmpty(str)) {
          break label321;
        }
        if (str == null) {
          throw new NullPointerException();
        }
      }
      finally
      {
        if (localObject != null) {
          ((Cursor)localObject).close();
        }
      }
      q = str;
      a |= 0x4000;
      label321:
      int i = ((Cursor)localObject).getColumnIndex("click_id");
      if (i != -1)
      {
        str = ((Cursor)localObject).getString(i);
        if (!TextUtils.isEmpty(str))
        {
          if (str == null) {
            throw new NullPointerException();
          }
          s = str;
          a |= 0x10000;
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
      localObject = TextUtils.join(", ", g);
      if (localObject != null) {
        break;
      }
      throw new NullPointerException();
      label429:
      dri.e(dtn.g, "Failed to find an entry for ad event id: %s", new Object[] { H });
    }
    d = ((String)localObject);
    a |= 0x4;
    localObject = TextUtils.join(", ", h);
    if (localObject == null) {
      throw new NullPointerException();
    }
    e = ((String)localObject);
    a |= 0x8;
    localObject = TextUtils.join(", ", i);
    if (localObject == null) {
      throw new NullPointerException();
    }
    f = ((String)localObject);
    a |= 0x10;
    if (m != null) {}
    for (localObject = m; localObject == null; localObject = "") {
      throw new NullPointerException();
    }
    g = ((String)localObject);
    a |= 0x20;
    if (s != null) {}
    for (localObject = s; localObject == null; localObject = "") {
      throw new NullPointerException();
    }
    h = ((String)localObject);
    a |= 0x40;
    if ((z) && (x))
    {
      localgxp.a(true);
      m = ((int)y);
      a |= 0x400;
      if (w)
      {
        l = true;
        a |= 0x200;
      }
    }
    while (!TextUtils.isEmpty(B))
    {
      n = true;
      a |= 0x800;
      localObject = B;
      if (localObject == null)
      {
        throw new NullPointerException();
        localgxp.a(false);
      }
      else
      {
        o = ((String)localObject);
        a |= 0x1000;
        dri.a(dtn.g, "Uphill Sync operation with custom from address: %s", new Object[] { B });
      }
    }
    a(localgxp, paramdtu, paramBoolean);
    dri.a(dtn.g, "messageSavedOrSent: message = %s", new Object[] { localgxp });
  }
  
  public final void a(long paramLong, duh paramduh)
  {
    if (dri.a(dtn.g, 2)) {
      dri.a(dtn.g, "MailSync posting operation %d (organic event): %s", new Object[] { Long.valueOf(paramLong), paramduh.toString() });
    }
    gxj localgxj = b(paramLong);
    gxr localgxr = new gxr();
    d = i;
    a |= 0x1;
    if (b == 1L) {
      if (e == null) {
        dri.e(duh.a, "Invalid switch to tab organic event", new Object[0]);
      }
    }
    for (;;)
    {
      n = localgxr;
      return;
      Object localObject = new gxx();
      b = c;
      a |= 0x1;
      c = d;
      a |= 0x2;
      d = new gxy[e.size()];
      int i = 0;
      while (i < e.size())
      {
        gxy[] arrayOfgxy = d;
        dui localdui = (dui)e.get(i);
        gxy localgxy = new gxy();
        b = a;
        a |= 0x1;
        d = c;
        a |= 0x4;
        c = b;
        a |= 0x2;
        arrayOfgxy[i] = localgxy;
        i += 1;
      }
      b = ((gxx)localObject);
      continue;
      if (b == 2L)
      {
        if ((f == null) || (g == null) || (h == null))
        {
          dri.e(duh.a, "Invalid mail clicked organic event", new Object[0]);
        }
        else
        {
          localObject = new gxt();
          b = c;
          a |= 0x1;
          c = d;
          a |= 0x2;
          d = f.longValue();
          a |= 0x4;
          e = g.intValue();
          a |= 0x8;
          f = h.booleanValue();
          a |= 0x10;
          c = ((gxt)localObject);
        }
      }
      else if (b == 3L)
      {
        if ((f == null) || (l == null))
        {
          dri.e(duh.a, "Invalid external clicked organic event", new Object[0]);
        }
        else
        {
          localObject = new gxs();
          b = c;
          a |= 0x1;
          c = f.longValue();
          a |= 0x2;
          paramduh = l;
          if (paramduh == null) {
            throw new NullPointerException();
          }
          d = paramduh;
          a |= 0x4;
          e = ((gxs)localObject);
        }
      }
      else if (b == 4L)
      {
        if ((e == null) || (j == null) || (k == null)) {
          dri.e(duh.a, "Invalid mail dismissed organic event", new Object[0]);
        } else {
          f = paramduh.b();
        }
      }
      else if (b == 5L)
      {
        if ((f == null) || (j == null))
        {
          dri.e(duh.a, "Invalid mail closed organic event", new Object[0]);
        }
        else
        {
          localObject = new gxu();
          b = c;
          a |= 0x1;
          c = f.longValue();
          a |= 0x2;
          d = j.intValue();
          a |= 0x4;
          g = ((gxu)localObject);
        }
      }
      else {
        dri.e(duh.a, "Unknown organic event type: %s", new Object[] { Long.valueOf(b) });
      }
    }
  }
  
  public final void a(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    dri.a(dtn.g, "MailSync posting operation %d (Pref change): name: %s, stringValue: %s, isDelete=%b", new Object[] { Long.valueOf(paramLong), paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    Object localObject = b(paramLong);
    k = new gxz();
    localObject = k;
    if (paramString1 == null) {
      throw new NullPointerException();
    }
    b = paramString1;
    a |= 0x1;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2 == null) {
        throw new NullPointerException();
      }
      c = paramString2;
      a |= 0x2;
    }
    d = paramBoolean;
    a |= 0x4;
  }
  
  public final void a(long paramLong, Set<Integer> paramSet, boolean paramBoolean)
  {
    dri.a(dtn.g, "MailSync posting operation %d (configureSectionedInbox):  sections=%s showStarredInPersonal=%b", new Object[] { Long.valueOf(paramLong), paramSet, Boolean.valueOf(paramBoolean) });
    Object localObject = b(paramLong);
    h = new gzs();
    localObject = h;
    b = hks.a(paramSet);
    c = paramBoolean;
    a |= 0x1;
  }
  
  public final void b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (a(paramLong3)) {
      return;
    }
    Object localObject = b(paramLong1);
    c = new gxo();
    localObject = c;
    ((gxo)localObject).a(false);
    ((gxo)localObject).a(paramLong2);
    ((gxo)localObject).a((int)paramLong3);
  }
}

/* Location:
 * Qualified Name:     dtx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */