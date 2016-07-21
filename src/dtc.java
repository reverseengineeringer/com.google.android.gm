import android.accounts.Account;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TimingLogger;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.Promotion;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class dtc
  implements dth
{
  dtc(drp paramdrp) {}
  
  private final void a(dtu paramdtu, long paramLong1, long paramLong2, int paramInt)
  {
    TimingLogger localTimingLogger = new TimingLogger(drp.b, "addOrUpdateMessageNoNotifyWithoutWritingOperations");
    a.r.a(a.A);
    ContentValues localContentValues;
    try
    {
      localContentValues = new ContentValues();
      localContentValues.put("messageId", Long.valueOf(c));
      localContentValues.put("conversation", Long.valueOf(d));
      localContentValues.put("fromAddress", f);
      localContentValues.put("toAddresses", TextUtils.join("\n", g));
      localContentValues.put("ccAddresses", TextUtils.join("\n", h));
      localContentValues.put("bccAddresses", TextUtils.join("\n", i));
      localContentValues.put("replyToAddresses", TextUtils.join("\n", j));
      localContentValues.put("dateSentMs", Long.valueOf(k));
      localContentValues.put("dateReceivedMs", Long.valueOf(l));
      localContentValues.put("subject", m);
      localContentValues.put("listInfo", p);
      localContentValues.put("personalLevel", Integer.valueOf(q));
      localContentValues.put("clientCreated", Integer.valueOf(paramInt));
      localContentValues.put("snippet", n);
      if (paramLong1 == 0L) {
        break label1903;
      }
      localContentValues.put("_id", Long.valueOf(paramLong1));
    }
    finally
    {
      a.r.d();
      localTimingLogger.addSplit("post body");
      localTimingLogger.dumpToLog();
    }
    localContentValues.put("synced", Integer.valueOf(i));
    localContentValues.put("queryId", Long.valueOf(paramLong2));
    localTimingLogger.addSplit("pre body");
    if (s != null)
    {
      if (ghz.a(a.k.getContentResolver(), "gmail_db_compression_type", 1) != 0) {
        break label1255;
      }
      localContentValues.put("body", s);
      localContentValues.putNull("bodyCompressed");
    }
    label384:
    boolean bool;
    label633:
    label715:
    long l1;
    for (;;)
    {
      if (!TextUtils.isEmpty(t)) {
        localContentValues.put("stylesheet", t);
      }
      if (!TextUtils.isEmpty(u)) {
        localContentValues.put("stylesheetRestrictor", u);
      }
      localTimingLogger.addSplit("body");
      if (!v) {
        break label1916;
      }
      i = 1;
      localContentValues.put("bodyEmbedsExternalResources", Integer.valueOf(i));
      if (!TextUtils.isEmpty(B)) {
        localContentValues.put("customFromAddress", B);
      }
      if (A != 0L) {
        localContentValues.put("refMessageId", Long.valueOf(A));
      }
      if (H != null) {
        localContentValues.put("refAdEventId", H);
      }
      localContentValues.put("spamDisplayedReasonType", Integer.valueOf(C));
      if (E >= 0) {
        localContentValues.put("showSendersFullEmailAddress", Integer.valueOf(E));
      }
      if (D >= 0) {
        localContentValues.put("showForgedFromMeWarning", Integer.valueOf(D));
      }
      if (F != 0) {
        localContentValues.put("deliveryChannel", Integer.valueOf(F));
      }
      if (G != null) {
        localContentValues.put("referencesRfc822MessageIds", G);
      }
      if (I != null) {
        localContentValues.put("permalink", I);
      }
      localContentValues.put("clipped", Integer.valueOf(J));
      if (K != null) {
        localContentValues.put("unsubscribeSenderName", K);
      }
      if (L != null) {
        localContentValues.put("unsubscribeSenderIdentifier", L);
      }
      if (M == null) {
        break label1922;
      }
      bool = true;
      localContentValues.put("hasEvent", Boolean.valueOf(bool));
      if (bool)
      {
        localContentValues.put("eventTitle", M.a);
        localContentValues.put("startTime", Long.valueOf(M.b));
        localContentValues.put("endTime", Long.valueOf(M.c));
        if (!M.d) {
          break label1928;
        }
        i = 1;
        localContentValues.put("allDay", Integer.valueOf(i));
        localContentValues.put("location", M.e);
        localContentValues.put("organizer", M.f);
        if (M.g != null) {
          localContentValues.put("attendees", TextUtils.join("\n", M.g));
        }
        localContentValues.put("icalMethod", Integer.valueOf(M.h));
        localContentValues.put("eventId", M.i);
        localContentValues.put("calendarId", M.j);
        localContentValues.put("responder", M.k);
        localContentValues.put("responseStatus", Integer.valueOf(M.l));
      }
      l1 = a.X.f();
      localObject2 = GmailProvider.a(a.l.name, d, c, r);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        break label1900;
      }
      localObject2 = r;
      label929:
      if (((List)localObject2).size() == 0) {
        break label1943;
      }
      localObject1 = GmailAttachment.a((List)localObject2);
      if ((paramLong1 != 0L) || (paramLong2 != 0L)) {
        break label1897;
      }
      if ((a.x == null) || (!a.x.a(a.l.name))) {
        break label1934;
      }
      i = 1;
      label997:
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        GmailAttachment localGmailAttachment = (GmailAttachment)((Iterator)localObject2).next();
        Uri localUri = dpy.a(a.l.name, c, localGmailAttachment, 1);
        bool = cvr.a(a.k, localUri, localGmailAttachment.l());
        buo.a().a("sync_attachment", cxa.e(localGmailAttachment.l()), null, d);
        if ((localGmailAttachment.l().startsWith("image/")) && (paramInt == 0) && (!o.contains(Long.valueOf(l1)))) {
          a.w.a(d, c, localGmailAttachment, 0, false, true, 1);
        }
        if ((paramInt == 0) && (!o.contains(Long.valueOf(l1))) && ((i != 0) || (r == 1)) && (bool)) {
          a.w.a(d, c, localGmailAttachment, 1, false, true, 0);
        }
      }
      label1249:
      i = 0;
      break;
      label1255:
      i = ghz.a(a.k.getContentResolver(), "gmail_db_compression_threshold", 100);
      if (s.length() < i)
      {
        localContentValues.put("body", s);
        localContentValues.putNull("bodyCompressed");
      }
      else
      {
        try
        {
          localObject1 = s.getBytes("UTF-8");
          localContentValues.put("bodyCompressed", dvg.b((byte[])localObject1, localObject1.length));
          localContentValues.putNull("body");
        }
        catch (UnsupportedEncodingException paramdtu)
        {
          throw new IllegalStateException("UTF-8 not supported");
        }
      }
    }
    label1357:
    localContentValues.put("joinedAttachmentInfos", (String)localObject1);
    paramLong1 = 0L;
    paramInt = 0;
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = a;
    long l2 = c;
    localObject2 = ((drp)localObject2).b(new String[] { "conversation", "queryId", "joinedAttachmentInfos", "clientCreated" }, l2);
    for (;;)
    {
      try
      {
        if (((Cursor)localObject2).moveToNext())
        {
          paramLong1 = ((Cursor)localObject2).getLong(0);
          if (((Cursor)localObject2).getInt(1) != 0) {
            break label1951;
          }
          paramInt = 1;
          localObject1 = ((Cursor)localObject2).getString(2);
          i = ((Cursor)localObject2).getInt(3);
          if (i != 1) {
            break label1957;
          }
          i = 1;
        }
        ((Cursor)localObject2).close();
        if (paramLong1 == 0L) {
          break label1732;
        }
        if ((i != 0) && (localObject1 != null))
        {
          if (!o.contains(Long.valueOf(l1))) {
            drp.a((String)localObject1, a.k.getContentResolver());
          }
        }
        else
        {
          if ((paramLong2 != 0L) && (paramInt != 0))
          {
            dri.b(drp.b, "Message %d already synced. Keep it that way", new Object[] { Long.valueOf(c) });
            localContentValues.put("queryId", Integer.valueOf(0));
            localContentValues.put("synced", Boolean.valueOf(true));
          }
          dri.b(drp.b, "Updating message %d. queryId=%d", new Object[] { Long.valueOf(c), Long.valueOf(paramLong2) });
          paramInt = a.p.update("messages", localContentValues, "messageId=?", new String[] { Long.toString(c) });
          if (paramInt == 1) {
            break label1798;
          }
          throw new SQLException(46 + "surprising number of rows updated: " + paramInt);
        }
      }
      finally
      {
        ((Cursor)localObject2).close();
      }
      drp.a(localContentValues, (String)localObject1, a.k.getContentResolver());
      continue;
      label1732:
      dri.b(drp.b, "Inserting message %d. queryId=%d", new Object[] { Long.valueOf(c), Long.valueOf(paramLong2) });
      if (a.p.insert("messages", null, localContentValues) == -1L) {
        throw new SQLException("error inserting message");
      }
      label1798:
      if ((s != null) && (paramLong2 == 0L)) {
        a.I = true;
      }
      a.o.a(c, o);
      if ((paramLong1 != 0L) && (paramLong1 != d)) {
        drp.a(a, paramLong1, 3, false);
      }
      a.r.c();
      a.r.d();
      localTimingLogger.addSplit("post body");
      localTimingLogger.dumpToLog();
      return;
      label1897:
      break label1357;
      label1900:
      break label929;
      label1903:
      if (paramLong2 != 0L) {
        break label1249;
      }
      i = 1;
      break;
      label1916:
      i = 0;
      break label384;
      label1922:
      bool = false;
      break label633;
      label1928:
      i = 0;
      break label715;
      label1934:
      i = 0;
      break label997;
      break label1357;
      label1943:
      localObject1 = "";
      break label1357;
      label1951:
      paramInt = 0;
      continue;
      label1957:
      i = 0;
    }
  }
  
  private final long i(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = a.p.compileStatement("SELECT MAX(messageId) FROM messages WHERE conversation=? and queryId = 0 and clientCreated = 0");
    try
    {
      localSQLiteStatement.bindLong(1, paramLong);
      paramLong = localSQLiteStatement.simpleQueryForLong();
      localSQLiteStatement.close();
      return paramLong;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      localSQLiteDoneException = localSQLiteDoneException;
      localSQLiteStatement.close();
      return 0L;
    }
    finally
    {
      localObject = finally;
      localSQLiteStatement.close();
      throw ((Throwable)localObject);
    }
  }
  
  public final int a(dtl paramdtl, dtd paramdtd, long paramLong)
  {
    Object localObject1;
    int i21;
    int n;
    int m;
    int k;
    int j;
    int i;
    long l1;
    Object localObject2;
    long l2;
    int i1;
    int i2;
    long l4;
    long l5;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    if (a)
    {
      duf localduf = a.n;
      drp localdrp = a;
      localObject1 = new SQLiteQueryBuilder();
      ((SQLiteQueryBuilder)localObject1).setTables("operations");
      localObject1 = ((SQLiteQueryBuilder)localObject1).query(c, duf.b, null, null, null, null, "_id", "50");
      int i3 = ((Cursor)localObject1).getColumnIndexOrThrow("_id");
      int i4 = ((Cursor)localObject1).getColumnIndexOrThrow("action");
      int i5 = ((Cursor)localObject1).getColumnIndexOrThrow("message_messageId");
      int i6 = ((Cursor)localObject1).getColumnIndexOrThrow("value1");
      int i7 = ((Cursor)localObject1).getColumnIndexOrThrow("value2");
      int i8 = ((Cursor)localObject1).getColumnIndexOrThrow("value3");
      int i9 = ((Cursor)localObject1).getColumnIndexOrThrow("value4");
      int i10 = ((Cursor)localObject1).getColumnIndexOrThrow("value5");
      int i11 = ((Cursor)localObject1).getColumnIndexOrThrow("value6");
      int i12 = ((Cursor)localObject1).getColumnIndexOrThrow("value7");
      int i13 = ((Cursor)localObject1).getColumnIndexOrThrow("value8");
      int i14 = ((Cursor)localObject1).getColumnIndexOrThrow("value9");
      int i15 = ((Cursor)localObject1).getColumnIndexOrThrow("value10");
      int i16 = ((Cursor)localObject1).getColumnIndexOrThrow("value11");
      int i17 = ((Cursor)localObject1).getColumnIndexOrThrow("value12");
      int i18 = ((Cursor)localObject1).getColumnIndexOrThrow("numAttempts");
      int i19 = ((Cursor)localObject1).getColumnIndexOrThrow("nextTimeToAttempt");
      int i20 = ((Cursor)localObject1).getColumnIndexOrThrow("delay");
      i21 = ghz.a(d.getContentResolver(), "gmail_max_attachment_size_bytes", 20971520);
      n = 0;
      m = 0;
      k = 0;
      j = 0;
      i = 0;
      for (;;)
      {
        if (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(i3);
          localObject2 = ((Cursor)localObject1).getString(i4);
          l2 = ((Cursor)localObject1).getLong(i5);
          i1 = ((Cursor)localObject1).getInt(i18);
          long l3 = ((Cursor)localObject1).getLong(i19);
          i2 = ((Cursor)localObject1).getInt(i20);
          l4 = ((Cursor)localObject1).getLong(i6);
          l5 = ((Cursor)localObject1).getLong(i7);
          localObject3 = ((Cursor)localObject1).getString(i8);
          localObject4 = ((Cursor)localObject1).getString(i9);
          str1 = ((Cursor)localObject1).getString(i10);
          str2 = ((Cursor)localObject1).getString(i11);
          str3 = ((Cursor)localObject1).getString(i12);
          str4 = ((Cursor)localObject1).getString(i13);
          str5 = ((Cursor)localObject1).getString(i14);
          str6 = ((Cursor)localObject1).getString(i15);
          str7 = ((Cursor)localObject1).getString(i16);
          str8 = ((Cursor)localObject1).getString(i17);
          if (localduf.a(paramLong, l1, new dug((String)localObject2, l2, l4, l5, (String)localObject3, (String)localObject4, str1, str2, str3, str4, str5, str6, str7, str8, i1, i2, l3), paramdtd, l2, (String)localObject2, localdrp))
          {
            if ("messageLabelAdded".equals(localObject2))
            {
              paramdtl.a(l1, l2, l4);
              i1 = m;
              i2 = k;
              m = i;
              k = j;
              j = i2;
              i = i1;
            }
            for (;;)
            {
              n += 1;
              i1 = k;
              i2 = m;
              m = i;
              k = j;
              j = i1;
              i = i2;
              break;
              if ("messageLabelRemoved".equals(localObject2))
              {
                paramdtl.b(l1, l2, l4);
                i1 = j;
                i2 = i;
                i = m;
                j = k;
                k = i1;
                m = i2;
              }
              else if ("conversationLabelAdded".equals(localObject2))
              {
                paramdtl.a(l1, l2, l4, true);
                i1 = j;
                i2 = i;
                i = m;
                j = k;
                k = i1;
                m = i2;
              }
              else
              {
                if (!"conversationLabelRemoved".equals(localObject2)) {
                  break label811;
                }
                paramdtl.a(l1, l2, l4, false);
                i1 = j;
                i2 = i;
                i = m;
                j = k;
                k = i1;
                m = i2;
              }
            }
            label811:
            if (("messageSaved".equals(localObject2)) || ("messageSent".equals(localObject2)))
            {
              if ("messageSent".equals(localObject2)) {
                localdrp.a(l2, X.o());
              }
              localObject3 = localdrp.b(l2, true);
              if (localObject3 == null)
              {
                dri.e(duf.a, "Cannot find message with id = %d for operations!", new Object[] { Long.valueOf(l2) });
                c.delete("operations", 27 + "_id == " + l1, null);
                continue;
              }
              k = s.length() + k;
              localObject4 = ((dtu)localObject3).a();
              if (localObject4 == null) {
                break label1845;
              }
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext()) {
                k = nextd + k;
              }
            }
          }
        }
      }
    }
    label1818:
    label1845:
    for (;;)
    {
      if ((m == 0) || (k <= i21))
      {
        paramdtl.a(l1, (dtu)localObject3, l2, e, "messageSaved".equals(localObject2));
        i2 = 1;
        m = j;
        i1 = i;
        i = i2;
        j = k;
        k = m;
        m = i1;
        break;
        if ("messageExpunged".equals(localObject2))
        {
          paramdtl.a(l1, l2);
          i1 = j;
          i2 = i;
          i = m;
          j = k;
          k = i1;
          m = i2;
          break;
        }
        if ("emptySpam".equals(localObject2))
        {
          if (i != 0) {
            break label1818;
          }
          paramdtl.a(l1, 0, l4, (int)l5);
          i = m;
          m = j;
          i1 = 1;
          j = k;
          k = m;
          m = i1;
          break;
        }
        if ("emptyTrash".equals(localObject2))
        {
          if (j != 0) {
            break label1818;
          }
          paramdtl.a(l1, 1, l4, (int)l5);
          j = m;
          i1 = 1;
          m = i;
          i = j;
          j = k;
          k = i1;
          break;
        }
        if ("resetUnseenCount".equals(localObject2))
        {
          paramdtl.a(l1, l4, (String)localObject3);
          i1 = j;
          i2 = i;
          i = m;
          j = k;
          k = i1;
          m = i2;
          break;
        }
        boolean bool;
        if ("configureSectionedInbox".equals(localObject2))
        {
          localObject2 = ((String)localObject3).split(",");
          localObject3 = new hfe();
          i2 = localObject2.length;
          i1 = 0;
          while (i1 < i2)
          {
            ((hfe)localObject3).c(Integer.valueOf(Integer.parseInt(localObject2[i1])));
            i1 += 1;
          }
          localObject2 = ((hfe)localObject3).a();
          if (l4 == 1L) {}
          for (bool = true;; bool = false)
          {
            paramdtl.a(l1, (Set)localObject2, bool);
            i1 = j;
            i2 = i;
            i = m;
            j = k;
            k = i1;
            m = i2;
            break;
          }
        }
        if ("adAction".equals(localObject2))
        {
          i1 = (int)l4;
          if (l5 == 2L) {}
          for (bool = true;; bool = false)
          {
            paramdtl.a(l1, i1, (String)localObject3, (String)localObject4, str1, str2, bool, str3, str4, str5, str6, str7, str8);
            i1 = j;
            i2 = i;
            i = m;
            j = k;
            k = i1;
            m = i2;
            break;
          }
        }
        if ("prefChange".equals(localObject2))
        {
          if (l4 != 0L) {}
          for (bool = true;; bool = false)
          {
            paramdtl.a(l1, (String)localObject3, (String)localObject4, bool);
            i1 = j;
            i2 = i;
            i = m;
            j = k;
            k = i1;
            m = i2;
            break;
          }
        }
        if ("promoEvent".equals(localObject2))
        {
          paramdtl.a(l1, l4, (int)l5);
          i1 = j;
          i2 = i;
          i = m;
          j = k;
          k = i1;
          m = i2;
          break;
        }
        if ("organicEvent".equals(localObject2))
        {
          paramdtl.a(l1, duh.a(l4, l5, (String)localObject3, (String)localObject4, str1, str2, str3, str4, str5, str6, str7));
          i1 = j;
          i2 = i;
          i = m;
          j = k;
          k = i1;
          m = i2;
          break;
        }
        if ("eventRsvp".equals(localObject2))
        {
          paramdtl.a(l1, (int)l4, (String)localObject3, (String)localObject4);
          i1 = j;
          i2 = i;
          i = m;
          j = k;
          k = i1;
          m = i2;
          break;
        }
        paramdtl = String.valueOf(localObject2);
        if (paramdtl.length() != 0) {}
        for (paramdtl = "Unknown action: ".concat(paramdtl);; paramdtl = new String("Unknown action: ")) {
          throw new RuntimeException(paramdtl);
        }
      }
      ((Cursor)localObject1).close();
      return n;
      return a.n.a(paramdtl, a, paramdtd, paramLong);
      i1 = j;
      i2 = i;
      i = m;
      j = k;
      k = i1;
      m = i2;
      break;
    }
  }
  
  public final Cursor a(String[] paramArrayOfString, long paramLong)
  {
    drp localdrp = a;
    dmt.a();
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("messages LEFT OUTER JOIN message_labels \nON messages.messageId = message_labels.message_messageId \nLEFT OUTER JOIN labels \nON message_labels.labels_id=labels._id LEFT OUTER JOIN unsubscribed_senders \nON messages.unsubscribeSenderIdentifier = unsubscribed_senders.senderIdentifier ");
    localSQLiteQueryBuilder.appendWhere("messages.conversation=?");
    localSQLiteQueryBuilder.setProjectionMap(drp.T);
    String[] arrayOfString = localdrp.a(paramArrayOfString, "messageLabels", new String[] { Long.toString(paramLong) });
    paramArrayOfString = localSQLiteQueryBuilder.query(p, paramArrayOfString, null, arrayOfString, "messages.messageId", null, "messages.messageId");
    dmt.b();
    if (paramArrayOfString == null)
    {
      dri.e(drp.b, "null cursor for %s", new Object[] { localSQLiteQueryBuilder });
      return null;
    }
    return new dpq(paramArrayOfString, "body");
  }
  
  public final InputStream a(GmailAttachment paramGmailAttachment)
  {
    if (!hbw.b(v))
    {
      dri.b(drp.b, "Loading cached attachment: %s", new Object[] { v });
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(v);
        return localFileInputStream;
      }
      catch (IOException localIOException)
      {
        dri.d(drp.b, localIOException, "Failed to load cached attachment %s. Will attempt original URI %s", new Object[] { v, i });
      }
    }
    try
    {
      dri.b(drp.b, "Loading attachment URI: %s", new Object[] { i });
      if (i == null) {
        throw new FileNotFoundException("null contentUri");
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      dri.d(drp.b, localFileNotFoundException, "Failed to attach %s due to a FileNotFoundException. Since the cached file has already been tried, this file cannotbe attached. Notify the user.", new Object[] { i });
      throw localFileNotFoundException;
      InputStream localInputStream = a.k.getContentResolver().openInputStream(i);
      return localInputStream;
    }
    catch (SecurityException localSecurityException)
    {
      dri.d(drp.b, localSecurityException, "Failed to attach %s due to a SecurityException. Since the cached file has already been tried, this file cannot be attached. Notify the user.", new Object[] { i });
      throw localSecurityException;
    }
  }
  
  public final ArrayList<dtq> a(dtd paramdtd)
  {
    Object localObject1;
    if ((paramdtd == null) || (a))
    {
      long l = new Date().getTime();
      localObject1 = "select conversations_to_fetch._id as _id,   max(\n    case when not clientCreated then messages.messageId else 0 end)\n    as highestMessageId,   max(messages.clientCreated) as hasClientCreatedMessages from   conversations_to_fetch left outer join messages on   messages.conversation = conversations_to_fetch._id   and messages.queryId = 0 where nextAttemptDateMs < ?group by conversations_to_fetch._id order by conversations_to_fetch._id desc limit 50";
      paramdtd = new String[1];
      paramdtd[0] = String.valueOf(l);
    }
    String str;
    for (;;)
    {
      paramdtd = a.p.rawQuery((String)localObject1, paramdtd);
      int i = paramdtd.getColumnIndexOrThrow("_id");
      int j = paramdtd.getColumnIndexOrThrow("highestMessageId");
      try
      {
        localObject1 = new ArrayList();
        while (paramdtd.moveToNext()) {
          ((ArrayList)localObject1).add(new dtq(paramdtd.getLong(i), paramdtd.getLong(j)));
        }
        str = "select send_without_sync_conversations_to_fetch._id as _id,   max(\n    case when not clientCreated then messages.messageId else 0 end)\n    as highestMessageId,   max(messages.clientCreated) as hasClientCreatedMessages from   send_without_sync_conversations_to_fetch left outer join messages on   messages.conversation = send_without_sync_conversations_to_fetch._id   and messages.queryId = 0 group by send_without_sync_conversations_to_fetch._id order by send_without_sync_conversations_to_fetch._id desc limit 50";
      }
      finally
      {
        paramdtd.close();
      }
      paramdtd = null;
    }
    paramdtd.close();
    return str;
  }
  
  public final void a()
  {
    a.p.delete("blocked_senders", null, null);
  }
  
  public final void a(long paramLong)
  {
    dun.a(a.p, paramLong);
  }
  
  public final void a(long paramLong, int paramInt)
  {
    a.r.a(a.A);
    try
    {
      drp.a(a, paramLong, paramInt, false);
      a.r.c();
      return;
    }
    finally
    {
      a.r.d();
    }
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    if (i(paramLong1) < paramLong2)
    {
      dri.a(drp.b, "  device is lower than server. Will check conversation", new Object[0]);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_id", Long.valueOf(paramLong1));
      a.p.replace("send_without_sync_conversations_to_fetch", null, localContentValues);
    }
  }
  
  /* Error */
  public final void a(long paramLong1, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	dtc:a	Ldrp;
    //   4: getfield 36	drp:r	Lduy;
    //   7: aload_0
    //   8: getfield 12	dtc:a	Ldrp;
    //   11: getfield 40	drp:A	Ldqv;
    //   14: invokevirtual 45	duy:a	(Ldvb;)V
    //   17: aload_0
    //   18: getfield 12	dtc:a	Ldrp;
    //   21: getfield 607	drp:n	Lduf;
    //   24: lload_1
    //   25: invokevirtual 953	duf:b	(J)I
    //   28: istore 7
    //   30: iload 7
    //   32: iconst_m1
    //   33: if_icmpeq +23 -> 56
    //   36: invokestatic 403	buo:a	()Lbut;
    //   39: ldc_w 955
    //   42: ldc_w 957
    //   45: iload 7
    //   47: invokestatic 959	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   50: lconst_0
    //   51: invokeinterface 417 6 0
    //   56: aload_0
    //   57: getfield 12	dtc:a	Ldrp;
    //   60: aconst_null
    //   61: lload_1
    //   62: invokevirtual 482	drp:b	([Ljava/lang/String;J)Landroid/database/Cursor;
    //   65: astore 13
    //   67: aload 13
    //   69: invokeinterface 487 1 0
    //   74: ifne +42 -> 116
    //   77: getstatic 27	drp:b	Ljava/lang/String;
    //   80: ldc_w 961
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: lload_1
    //   90: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   93: aastore
    //   94: invokestatic 963	dri:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   97: pop
    //   98: aload 13
    //   100: invokeinterface 502 1 0
    //   105: aload_0
    //   106: getfield 12	dtc:a	Ldrp;
    //   109: getfield 36	drp:r	Lduy;
    //   112: invokevirtual 447	duy:d	()V
    //   115: return
    //   116: aload 13
    //   118: aload 13
    //   120: ldc -106
    //   122: invokeinterface 632 2 0
    //   127: invokeinterface 491 2 0
    //   132: lstore 8
    //   134: aload 13
    //   136: aload 13
    //   138: ldc 68
    //   140: invokeinterface 632 2 0
    //   145: invokeinterface 491 2 0
    //   150: lstore 10
    //   152: aload_0
    //   153: getfield 12	dtc:a	Ldrp;
    //   156: aload 13
    //   158: iconst_1
    //   159: invokevirtual 966	drp:a	(Landroid/database/Cursor;Z)Ldtu;
    //   162: astore 12
    //   164: aload 12
    //   166: lload_3
    //   167: putfield 56	dtu:c	J
    //   170: aload 12
    //   172: lload 5
    //   174: putfield 71	dtu:d	J
    //   177: aload 13
    //   179: invokeinterface 502 1 0
    //   184: aload_0
    //   185: getfield 12	dtc:a	Ldrp;
    //   188: getfield 438	drp:w	Ldpa;
    //   191: astore 13
    //   193: aload 12
    //   195: getfield 56	dtu:c	J
    //   198: lstore_3
    //   199: new 47	android/content/ContentValues
    //   202: dup
    //   203: invokespecial 48	android/content/ContentValues:<init>	()V
    //   206: astore 14
    //   208: aload 14
    //   210: ldc_w 968
    //   213: lload_3
    //   214: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   217: invokevirtual 66	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   220: aload 13
    //   222: getfield 969	dpa:c	Landroid/database/sqlite/SQLiteDatabase;
    //   225: ldc_w 971
    //   228: aload 14
    //   230: ldc_w 973
    //   233: iconst_1
    //   234: anewarray 421	java/lang/String
    //   237: dup
    //   238: iconst_0
    //   239: lload_1
    //   240: invokestatic 910	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   243: aastore
    //   244: invokevirtual 531	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   247: pop
    //   248: aload_0
    //   249: getfield 12	dtc:a	Ldrp;
    //   252: getfield 607	drp:n	Lduf;
    //   255: astore 13
    //   257: aload 12
    //   259: getfield 56	dtu:c	J
    //   262: lstore_3
    //   263: new 47	android/content/ContentValues
    //   266: dup
    //   267: invokespecial 48	android/content/ContentValues:<init>	()V
    //   270: astore 14
    //   272: aload 14
    //   274: ldc_w 636
    //   277: lload_3
    //   278: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   281: invokevirtual 66	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   284: aload 13
    //   286: getfield 619	duf:c	Landroid/database/sqlite/SQLiteDatabase;
    //   289: ldc_w 612
    //   292: aload 14
    //   294: new 535	java/lang/StringBuilder
    //   297: dup
    //   298: bipush 40
    //   300: invokespecial 538	java/lang/StringBuilder:<init>	(I)V
    //   303: ldc_w 975
    //   306: invokevirtual 544	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: lload_1
    //   310: invokevirtual 722	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   313: invokevirtual 549	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: aconst_null
    //   317: invokevirtual 531	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   320: pop
    //   321: lload 10
    //   323: lconst_0
    //   324: lcmp
    //   325: ifeq +38 -> 363
    //   328: aload_0
    //   329: getfield 12	dtc:a	Ldrp;
    //   332: getfield 568	drp:o	Ldrj;
    //   335: iconst_1
    //   336: anewarray 58	java/lang/Long
    //   339: dup
    //   340: iconst_0
    //   341: lload_1
    //   342: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   345: aastore
    //   346: invokestatic 980	hgd:a	([Ljava/lang/Object;)Ljava/util/ArrayList;
    //   349: invokevirtual 983	drj:a	(Ljava/util/List;)V
    //   352: aload_0
    //   353: getfield 12	dtc:a	Ldrp;
    //   356: lload 10
    //   358: iconst_3
    //   359: iconst_1
    //   360: invokestatic 576	drp:a	(Ldrp;JIZ)V
    //   363: aload_0
    //   364: getfield 12	dtc:a	Ldrp;
    //   367: getfield 329	drp:X	Ldqc;
    //   370: invokevirtual 985	dqc:m	()J
    //   373: lstore_1
    //   374: aload 12
    //   376: getfield 428	dtu:o	Ljava/util/Set;
    //   379: lload_1
    //   380: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   383: invokeinterface 434 2 0
    //   388: ifeq +96 -> 484
    //   391: aload 12
    //   393: getfield 428	dtu:o	Ljava/util/Set;
    //   396: lload_1
    //   397: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   400: invokeinterface 988 2 0
    //   405: pop
    //   406: aload 12
    //   408: getfield 428	dtu:o	Ljava/util/Set;
    //   411: aload_0
    //   412: getfield 12	dtc:a	Ldrp;
    //   415: getfield 329	drp:X	Ldqc;
    //   418: invokevirtual 706	dqc:o	()J
    //   421: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   424: invokeinterface 988 2 0
    //   429: pop
    //   430: aload 12
    //   432: getfield 428	dtu:o	Ljava/util/Set;
    //   435: aload_0
    //   436: getfield 12	dtc:a	Ldrp;
    //   439: getfield 329	drp:X	Ldqc;
    //   442: invokevirtual 990	dqc:p	()J
    //   445: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   448: invokeinterface 988 2 0
    //   453: pop
    //   454: aload 12
    //   456: getfield 428	dtu:o	Ljava/util/Set;
    //   459: aload_0
    //   460: getfield 12	dtc:a	Ldrp;
    //   463: getfield 568	drp:o	Ldrj;
    //   466: ldc_w 992
    //   469: invokevirtual 995	drj:b	(Ljava/lang/String;)Ldrk;
    //   472: getfield 999	drk:a	J
    //   475: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   478: invokeinterface 1000 2 0
    //   483: pop
    //   484: aload_0
    //   485: aload 12
    //   487: lload 8
    //   489: lconst_0
    //   490: iconst_1
    //   491: invokespecial 1002	dtc:a	(Ldtu;JJI)V
    //   494: aload_0
    //   495: getfield 12	dtc:a	Ldrp;
    //   498: aload 12
    //   500: getfield 71	dtu:d	J
    //   503: iconst_3
    //   504: iconst_1
    //   505: invokestatic 576	drp:a	(Ldrp;JIZ)V
    //   508: aload_0
    //   509: getfield 12	dtc:a	Ldrp;
    //   512: getfield 36	drp:r	Lduy;
    //   515: invokevirtual 578	duy:c	()V
    //   518: aload_0
    //   519: getfield 12	dtc:a	Ldrp;
    //   522: getfield 36	drp:r	Lduy;
    //   525: invokevirtual 447	duy:d	()V
    //   528: return
    //   529: astore 12
    //   531: aload 13
    //   533: invokeinterface 502 1 0
    //   538: aload 12
    //   540: athrow
    //   541: astore 12
    //   543: aload_0
    //   544: getfield 12	dtc:a	Ldrp;
    //   547: getfield 36	drp:r	Lduy;
    //   550: invokevirtual 447	duy:d	()V
    //   553: aload 12
    //   555: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	dtc
    //   0	556	1	paramLong1	long
    //   0	556	3	paramLong2	long
    //   0	556	5	paramLong3	long
    //   28	18	7	i	int
    //   132	356	8	l1	long
    //   150	207	10	l2	long
    //   162	337	12	localdtu	dtu
    //   529	10	12	localObject1	Object
    //   541	13	12	localObject2	Object
    //   65	467	13	localObject3	Object
    //   206	87	14	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   67	98	529	finally
    //   116	177	529	finally
    //   17	30	541	finally
    //   36	56	541	finally
    //   56	67	541	finally
    //   98	105	541	finally
    //   177	321	541	finally
    //   328	363	541	finally
    //   363	484	541	finally
    //   484	518	541	finally
    //   531	541	541	finally
  }
  
  /* Error */
  public final void a(long paramLong, dtd paramdtd)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	dtc:a	Ldrp;
    //   4: getfield 36	drp:r	Lduy;
    //   7: aload_0
    //   8: getfield 12	dtc:a	Ldrp;
    //   11: getfield 40	drp:A	Ldqv;
    //   14: invokevirtual 45	duy:a	(Ldvb;)V
    //   17: aload_3
    //   18: getfield 604	dtd:a	Z
    //   21: ifeq +80 -> 101
    //   24: aload_0
    //   25: getfield 12	dtc:a	Ldrp;
    //   28: getfield 517	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   31: ldc_w 1005
    //   34: ldc_w 1007
    //   37: iconst_1
    //   38: anewarray 421	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: lload_1
    //   44: invokestatic 525	java/lang/Long:toString	(J)Ljava/lang/String;
    //   47: aastore
    //   48: invokevirtual 726	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   51: pop
    //   52: aload_0
    //   53: getfield 12	dtc:a	Ldrp;
    //   56: getfield 517	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   59: ldc_w 1005
    //   62: ldc_w 1009
    //   65: iconst_1
    //   66: anewarray 421	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: lload_1
    //   72: invokestatic 525	java/lang/Long:toString	(J)Ljava/lang/String;
    //   75: aastore
    //   76: invokevirtual 726	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   79: pop
    //   80: aload_0
    //   81: getfield 12	dtc:a	Ldrp;
    //   84: getfield 36	drp:r	Lduy;
    //   87: invokevirtual 578	duy:c	()V
    //   90: aload_0
    //   91: getfield 12	dtc:a	Ldrp;
    //   94: getfield 36	drp:r	Lduy;
    //   97: invokevirtual 447	duy:d	()V
    //   100: return
    //   101: aload_0
    //   102: getfield 12	dtc:a	Ldrp;
    //   105: getfield 517	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   108: ldc_w 947
    //   111: ldc_w 1007
    //   114: iconst_1
    //   115: anewarray 421	java/lang/String
    //   118: dup
    //   119: iconst_0
    //   120: lload_1
    //   121: invokestatic 525	java/lang/Long:toString	(J)Ljava/lang/String;
    //   124: aastore
    //   125: invokevirtual 726	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   128: pop
    //   129: aload_0
    //   130: getfield 12	dtc:a	Ldrp;
    //   133: getfield 517	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   136: ldc_w 947
    //   139: ldc_w 1009
    //   142: iconst_1
    //   143: anewarray 421	java/lang/String
    //   146: dup
    //   147: iconst_0
    //   148: lload_1
    //   149: invokestatic 525	java/lang/Long:toString	(J)Ljava/lang/String;
    //   152: aastore
    //   153: invokevirtual 726	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   156: pop
    //   157: goto -77 -> 80
    //   160: astore_3
    //   161: aload_0
    //   162: getfield 12	dtc:a	Ldrp;
    //   165: getfield 36	drp:r	Lduy;
    //   168: invokevirtual 447	duy:d	()V
    //   171: aload_3
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	dtc
    //   0	173	1	paramLong	long
    //   0	173	3	paramdtd	dtd
    // Exception table:
    //   from	to	target	type
    //   17	80	160	finally
    //   80	90	160	finally
    //   101	157	160	finally
  }
  
  public final void a(long paramLong, String paramString)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    if ("dup".equals(paramString))
    {
      dri.d(drp.b, "Deleting message %d", new Object[] { Long.valueOf(paramLong) });
      paramString = a.p.rawQuery("SELECT conversation FROM messages WHERE messageId=?", arrayOfString);
      try
      {
        if (paramString.moveToFirst()) {
          a(paramString.getLong(0), hgd.a(new Long[] { Long.valueOf(paramLong) }), 4);
        }
        for (;;)
        {
          return;
          dri.e(drp.b, "Handling server 'dup' response. Missing message: %d", new Object[] { Long.valueOf(paramLong) });
        }
        if (paramString == null) {
          break label202;
        }
      }
      finally
      {
        paramString.close();
      }
    }
    dri.b(drp.b, "Handling server error response for not updated message (messageId: %d): %s", new Object[] { Long.valueOf(paramLong), paramString });
    if (paramString.contains(">")) {}
    for (Object localObject2 = paramString.substring(0, 2);; localObject2 = paramString)
    {
      buo.a().a("errors", "sync_message_not_updated", (String)localObject2, 0L);
      label202:
      localObject2 = new ContentValues(1);
      ((ContentValues)localObject2).put("error", paramString);
      a.p.update("messages", (ContentValues)localObject2, "messageId=?", arrayOfString);
      a.a(paramLong, "server_rejection");
      a.v.f(paramLong);
      return;
    }
  }
  
  public final void a(long paramLong, List<Long> paramList, int paramInt)
  {
    a.r.a(a.A);
    try
    {
      a.o.a(paramList);
      drp.a(a, paramLong, paramInt, false);
      a.r.c();
      return;
    }
    finally
    {
      a.r.d();
    }
  }
  
  public final void a(long paramLong, List<Long> paramList, drk paramdrk, boolean paramBoolean, int paramInt)
  {
    a.r.a(a.A);
    int i = 0;
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label165;
        }
        long l = ((Long)paramList.next()).longValue();
        if (DatabaseUtils.longForQuery(a.p, "SELECT COUNT(*) FROM messages WHERE messageId=?", new String[] { String.valueOf(l) }) <= 0L) {
          break label159;
        }
        j = 1;
        if (j == 0) {
          break label156;
        }
        a.o.a(l, paramdrk, paramBoolean, 0);
        i = 1;
      }
      finally
      {
        a.r.d();
      }
      drp.a(a, paramLong, paramInt, false);
      a.r.c();
      a.r.d();
      return;
      label156:
      continue;
      label159:
      int j = 0;
      continue;
      label165:
      if (i == 0) {
        if (paramInt != 2) {}
      }
    }
  }
  
  public final void a(Advertisement paramAdvertisement)
  {
    if ((e == null) || (e.isEmpty())) {
      throw new IllegalArgumentException("Received invalid Advertisement");
    }
    a.r.a(a.A);
    try
    {
      a.p.insertWithOnConflict("ads", null, dos.b(paramAdvertisement), 5);
      a.r.c();
      return;
    }
    finally
    {
      a.r.d();
    }
  }
  
  public final void a(Promotion paramPromotion)
  {
    SQLiteDatabase localSQLiteDatabase = a.p;
    ContentValues localContentValues = new ContentValues(12);
    localContentValues.put("_id", Long.valueOf(a));
    localContentValues.put("priority", Integer.valueOf(b));
    localContentValues.put("startTime", Long.valueOf(c));
    localContentValues.put("expirationTime", Long.valueOf(d));
    localContentValues.put("titleText", e);
    localContentValues.put("bodyText", f);
    localContentValues.put("bodyHtml", g);
    localContentValues.put("positiveButtonText", h);
    localContentValues.put("negativeButtonText", i);
    localContentValues.put("buttonUrl", j);
    localContentValues.put("rawImageData", k);
    localContentValues.put("minBuildSdk", Integer.valueOf(l));
    localSQLiteDatabase.insertWithOnConflict("promotions", null, localContentValues, 5);
  }
  
  public final void a(drk paramdrk)
  {
    a.r.a(a.A);
    try
    {
      a.o.c(paramdrk);
      a.o.l();
      a.r.c();
      return;
    }
    finally
    {
      a.r.d();
    }
  }
  
  public final void a(drk paramdrk, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    a.o.a(paramdrk, paramInt1, paramInt2, paramInt3, paramInt4, paramString);
  }
  
  public final void a(drk paramdrk, String paramString1, String paramString2, String paramString3)
  {
    a.r.a(a.A);
    try
    {
      a.o.a(paramdrk, paramString1, paramString2, Integer.MAX_VALUE, paramString3);
      a.o.l();
      a.r.c();
      return;
    }
    finally
    {
      a.r.d();
    }
  }
  
  public final void a(dtp paramdtp)
  {
    dri.a(drp.b, "Got conversation header with MainSync: %s", new Object[] { paramdtp });
    a.a(paramdtp, 0L, null);
  }
  
  public final void a(dtu paramdtu, long paramLong)
  {
    dri.b(drp.b, "addOrUpdateMessage: %s", new Object[] { paramdtu });
    a.r.a(a.A);
    for (;;)
    {
      drj localdrj;
      long l;
      try
      {
        if (DatabaseUtils.longForQuery(a.p, "SELECT COUNT(*) FROM operations WHERE message_messageId=? AND action IN (?, ?) AND value2=?", new String[] { Long.toString(c), "messageSaved", "messageSent", Long.toString(d) }) != 0L) {
          break label296;
        }
        a(paramdtu, 0L, paramLong, 0);
        Iterator localIterator = o.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Long)localIterator.next();
        localdrj = a.o;
        paramLong = ((Long)localObject).longValue();
        l = l;
        if (!b.inTransaction()) {
          throw new IllegalStateException("Must be in transaction");
        }
      }
      finally
      {
        a.r.d();
      }
      Object localObject = Long.toString(paramLong);
      String str = Long.toString(l);
      b.execSQL("UPDATE labels SET lastMessageTimestamp = ? WHERE _id = ? AND lastMessageTimestamp < ?", new String[] { str, localObject, str });
    }
    a.o.l();
    for (;;)
    {
      paramdtu = Long.toString(c);
      a.p.delete("messages_to_fetch", "_id=?", new String[] { paramdtu });
      a.r.c();
      a.r.d();
      return;
      label296:
      dri.c(drp.b, "addOrUpdateMessage ignoring message %d because of a pending save/send operation", new Object[] { Long.valueOf(c) });
    }
  }
  
  public final void a(String paramString)
  {
    a.c(paramString);
  }
  
  public final void a(String paramString, long paramLong)
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("senderIdentifier", paramString);
    localContentValues.put("creationTimeMs", Long.valueOf(paramLong));
    a.p.replace("unsubscribed_senders", null, localContentValues);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a.o.a(paramString1, paramString2, false);
  }
  
  public final void a(String paramString1, String paramString2, long paramLong)
  {
    ContentValues localContentValues = new ContentValues(3);
    localContentValues.put("senderIdentifier", paramString1.toLowerCase(Locale.ENGLISH));
    localContentValues.put("displayName", paramString2);
    localContentValues.put("creationTimeMs", Long.valueOf(paramLong));
    a.p.replace("blocked_senders", null, localContentValues);
  }
  
  public final void a(Map<Long, dtk> paramMap)
  {
    a.r.a(a.A);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    try
    {
      localObject1 = new HashMap(paramMap);
      paramMap = ((Map)localObject1).keySet();
      localObject2 = a.o.b().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (drk)((Iterator)localObject2).next();
        if ((!((Map)localObject1).containsKey(Long.valueOf(a))) && (!drj.d(a))) {
          a.o.c((drk)localObject3);
        }
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
    }
    finally
    {
      a.r.d();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = a.o.c(((Long)((Map.Entry)localObject3).getKey()).longValue());
      localObject3 = (dtk)((Map.Entry)localObject3).getValue();
      if ((drj.h(a)) || (drj.d(a)))
      {
        long l = a;
        paramMap = a;
        throw new IllegalArgumentException(String.valueOf(paramMap).length() + 55 + "Server label appears to be local: " + l + "/" + paramMap);
      }
      a.o.a((drk)localObject2, a, b, f, g);
      a((drk)localObject2, c, d, e, f, g);
    }
    a.o.l();
    a.m();
    a.r.c();
    a.r.d();
    a.a(paramMap);
  }
  
  public final void a(Map<String, String> paramMap, boolean paramBoolean)
  {
    int i;
    if (!a.r.a.inTransaction())
    {
      i = 1;
      if (i != 0) {
        a.r.a(a.A);
      }
      a.q.beginTransactionNonExclusive();
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = paramMap.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label308;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = (String)((Map.Entry)localObject2).getKey();
        if (("labelsIncluded".equals(localObject3)) || ("labelsPartial".equals(localObject3)) || ("conversationAgeDays".equals(localObject3))) {
          break label472;
        }
        if (!"maxAttachmentSize".equals(localObject3)) {
          break label257;
        }
      }
      finally
      {
        ContentValues localContentValues;
        if (i == 0) {
          continue;
        }
        a.r.d();
        a.q.endTransaction();
      }
      if (j != 0)
      {
        localObject3 = a;
        str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        localContentValues = new ContentValues();
        localContentValues.put("name", str);
        localContentValues.put("value", (String)localObject2);
        q.replace("internal_sync_settings", null, localContentValues);
        continue;
        i = 0;
        break;
        label257:
        j = 0;
        continue;
      }
      Object localObject3 = a;
      String str = (String)((Map.Entry)localObject2).getKey();
      Object localObject2 = (String)((Map.Entry)localObject2).getValue();
      drp.a(p, str, (String)localObject2);
      continue;
      label308:
      if (i != 0) {
        a.r.c();
      }
      a.q.setTransactionSuccessful();
      if (i != 0) {
        a.r.d();
      }
      a.q.endTransaction();
      if (a.m != null)
      {
        a.o.d = a.m.a("serverVersion");
        if (paramBoolean) {
          a.t();
        }
      }
      if (paramBoolean)
      {
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("syncRationale", "3");
        a.p.update("conversations", (ContentValues)localObject1, "queryId = 0", null);
        a.J();
      }
      if (paramMap.containsKey("lowestMessageIdInDuration")) {
        a.G();
      }
      return;
      label472:
      int j = 1;
    }
  }
  
  public final void a(Set<Integer> paramSet)
  {
    dri.b(drp.b, "deleting starred ads", new Object[0]);
    if ((paramSet == null) || (paramSet.size() <= 0)) {}
    HashSet localHashSet;
    do
    {
      return;
      String str1 = String.format("starred = 1 AND tab IN (%s)", new Object[] { TextUtils.join(", ", paramSet) });
      localHashSet = new HashSet();
      a.r.a(a.A);
      try
      {
        paramSet = a.p.query("ads", drp.f, str1, null, null, null, null, null);
        if (paramSet != null) {
          paramSet.close();
        }
      }
      finally
      {
        try
        {
          while (paramSet.moveToNext())
          {
            localHashSet.add(paramSet.getString(0));
            continue;
            a.r.d();
          }
        }
        finally
        {
          paramSet.close();
        }
      }
      a.p.delete("ads", str2, null);
      a.r.c();
      a.r.d();
    } while (localHashSet.isEmpty());
    dos.a(a.k, a.l, localHashSet);
  }
  
  public final void a(boolean paramBoolean)
  {
    drj localdrj = a.o;
    HashMap localHashMap = new HashMap();
    localHashMap.put("temp_roe", String.valueOf(paramBoolean));
    localdrj.a(localHashMap, false);
  }
  
  public final drk b(long paramLong)
  {
    return a.o.b(paramLong);
  }
  
  public final String b(drk paramdrk)
  {
    drj localdrj = a.o;
    return drj.b(paramdrk);
  }
  
  public final void b()
  {
    a.p.delete("unsubscribed_senders", null, null);
  }
  
  /* Error */
  public final void b(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 12	dtc:a	Ldrp;
    //   7: getfield 517	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   10: ldc_w 1361
    //   13: invokevirtual 589	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   16: astore 7
    //   18: aload 7
    //   20: iconst_1
    //   21: lload_1
    //   22: invokevirtual 595	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   25: aload 7
    //   27: invokevirtual 1364	android/database/sqlite/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   30: astore 6
    //   32: aload 7
    //   34: invokevirtual 599	android/database/sqlite/SQLiteStatement:close	()V
    //   37: aload 6
    //   39: ifnull +135 -> 174
    //   42: aload 6
    //   44: invokestatic 763	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   47: iconst_2
    //   48: if_icmpne +126 -> 174
    //   51: aload_0
    //   52: getfield 12	dtc:a	Ldrp;
    //   55: getfield 36	drp:r	Lduy;
    //   58: aload_0
    //   59: getfield 12	dtc:a	Ldrp;
    //   62: getfield 40	drp:A	Ldqv;
    //   65: invokevirtual 45	duy:a	(Ldvb;)V
    //   68: aload_0
    //   69: getfield 12	dtc:a	Ldrp;
    //   72: lload_1
    //   73: iconst_3
    //   74: iconst_0
    //   75: invokestatic 576	drp:a	(Ldrp;JIZ)V
    //   78: aload_0
    //   79: getfield 12	dtc:a	Ldrp;
    //   82: getfield 36	drp:r	Lduy;
    //   85: invokevirtual 578	duy:c	()V
    //   88: aload_0
    //   89: getfield 12	dtc:a	Ldrp;
    //   92: getfield 36	drp:r	Lduy;
    //   95: invokevirtual 447	duy:d	()V
    //   98: new 47	android/content/ContentValues
    //   101: dup
    //   102: invokespecial 48	android/content/ContentValues:<init>	()V
    //   105: astore 6
    //   107: aload 6
    //   109: ldc -106
    //   111: lload_1
    //   112: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   115: invokevirtual 66	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   118: aload_0
    //   119: getfield 12	dtc:a	Ldrp;
    //   122: getfield 517	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   125: ldc_w 1005
    //   128: aconst_null
    //   129: aload 6
    //   131: invokevirtual 950	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   134: pop2
    //   135: return
    //   136: astore 6
    //   138: aload 7
    //   140: invokevirtual 599	android/database/sqlite/SQLiteStatement:close	()V
    //   143: aconst_null
    //   144: astore 6
    //   146: goto -109 -> 37
    //   149: astore 6
    //   151: aload 7
    //   153: invokevirtual 599	android/database/sqlite/SQLiteStatement:close	()V
    //   156: aload 6
    //   158: athrow
    //   159: astore 6
    //   161: aload_0
    //   162: getfield 12	dtc:a	Ldrp;
    //   165: getfield 36	drp:r	Lduy;
    //   168: invokevirtual 447	duy:d	()V
    //   171: aload 6
    //   173: athrow
    //   174: aload_0
    //   175: lload_1
    //   176: invokespecial 941	dtc:i	(J)J
    //   179: lload_3
    //   180: lcmp
    //   181: ifge +55 -> 236
    //   184: getstatic 27	drp:b	Ljava/lang/String;
    //   187: ldc_w 943
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 945	dri:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   197: pop
    //   198: new 47	android/content/ContentValues
    //   201: dup
    //   202: invokespecial 48	android/content/ContentValues:<init>	()V
    //   205: astore 6
    //   207: aload 6
    //   209: ldc -106
    //   211: lload_1
    //   212: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   215: invokevirtual 66	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   218: aload_0
    //   219: getfield 12	dtc:a	Ldrp;
    //   222: getfield 517	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   225: ldc_w 1005
    //   228: aconst_null
    //   229: aload 6
    //   231: invokevirtual 950	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   234: pop2
    //   235: return
    //   236: lconst_0
    //   237: aload_0
    //   238: getfield 12	dtc:a	Ldrp;
    //   241: getfield 517	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   244: ldc_w 1366
    //   247: iconst_1
    //   248: anewarray 421	java/lang/String
    //   251: dup
    //   252: iconst_0
    //   253: lload_3
    //   254: invokestatic 525	java/lang/Long:toString	(J)Ljava/lang/String;
    //   257: aastore
    //   258: invokestatic 1063	android/database/DatabaseUtils:longForQuery	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   261: lcmp
    //   262: ifeq +60 -> 322
    //   265: iload 5
    //   267: ifne +61 -> 328
    //   270: getstatic 27	drp:b	Ljava/lang/String;
    //   273: ldc_w 1368
    //   276: iconst_0
    //   277: anewarray 4	java/lang/Object
    //   280: invokestatic 512	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   283: pop
    //   284: new 47	android/content/ContentValues
    //   287: dup
    //   288: invokespecial 48	android/content/ContentValues:<init>	()V
    //   291: astore 6
    //   293: aload 6
    //   295: ldc -106
    //   297: lload_3
    //   298: invokestatic 62	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   301: invokevirtual 66	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   304: aload_0
    //   305: getfield 12	dtc:a	Ldrp;
    //   308: getfield 517	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   311: ldc_w 1170
    //   314: aconst_null
    //   315: aload 6
    //   317: invokevirtual 559	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   320: pop2
    //   321: return
    //   322: iconst_0
    //   323: istore 5
    //   325: goto -60 -> 265
    //   328: getstatic 27	drp:b	Ljava/lang/String;
    //   331: iconst_2
    //   332: invokestatic 1371	dri:a	(Ljava/lang/String;I)Z
    //   335: ifeq -200 -> 135
    //   338: getstatic 27	drp:b	Ljava/lang/String;
    //   341: ldc_w 1373
    //   344: iconst_0
    //   345: anewarray 4	java/lang/Object
    //   348: invokestatic 512	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   351: pop
    //   352: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	dtc
    //   0	353	1	paramLong1	long
    //   0	353	3	paramLong2	long
    //   1	323	5	i	int
    //   30	100	6	localObject1	Object
    //   136	1	6	localSQLiteDoneException	SQLiteDoneException
    //   144	1	6	localObject2	Object
    //   149	8	6	localObject3	Object
    //   159	13	6	localObject4	Object
    //   205	111	6	localContentValues	ContentValues
    //   16	136	7	localSQLiteStatement	SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   18	32	136	android/database/sqlite/SQLiteDoneException
    //   18	32	149	finally
    //   68	88	159	finally
  }
  
  public final void b(String paramString)
  {
    a.p.delete("blocked_senders", "senderIdentifier=?", new String[] { paramString.toLowerCase(Locale.ENGLISH) });
  }
  
  public final void b(Map<String, dtj> paramMap)
  {
    drj localdrj = a.o;
    String str1 = a.l.name;
    try
    {
      b.beginTransactionNonExclusive();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        Object localObject = new ContentValues();
        ((ContentValues)localObject).put(dyx.b, (String)paramMap.getKey());
        ((ContentValues)localObject).put(dyx.c, getValuea);
        ((ContentValues)localObject).put(dyx.a, getValueb);
        ((ContentValues)localObject).put("_id", Integer.valueOf(Integer.parseInt((String)paramMap.getKey())));
        b.insertWithOnConflict("custom_label_color_prefs", null, (ContentValues)localObject, 5);
        String str2 = (String)paramMap.getKey();
        dtj localdtj = (dtj)paramMap.getValue();
        localObject = (ConcurrentHashMap)dyx.e.get(str1);
        paramMap = (Map<String, dtj>)localObject;
        if (localObject == null)
        {
          paramMap = new ConcurrentHashMap();
          dyx.e.put(str1, paramMap);
        }
        paramMap.put(str2, new String[] { b, a });
      }
    }
    finally
    {
      b.endTransaction();
    }
    b.endTransaction();
  }
  
  public final void b(Map<String, dti> paramMap, boolean paramBoolean)
  {
    drj localdrj = a.o;
    String str = a.l.name;
    for (;;)
    {
      try
      {
        b.beginTransactionNonExclusive();
        if (paramBoolean)
        {
          b.delete("custom_from_prefs", null, null);
          dyr.i.remove(str);
        }
        Iterator localIterator = paramMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("name", getValuea);
        localContentValues.put("is_default", getValued);
        if (TextUtils.isEmpty(getValuec))
        {
          paramMap = (String)localEntry.getKey();
          localContentValues.put("reply_to", paramMap);
          localContentValues.put("address", getValueb);
          localContentValues.put("_id", (String)localEntry.getKey());
          b.insertWithOnConflict("custom_from_prefs", null, localContentValues, 5);
        }
        else
        {
          paramMap = getValuec;
        }
      }
      finally
      {
        b.endTransaction();
      }
    }
    b.setTransactionSuccessful();
    dyr.a(GmailProvider.b(str), localdrj.c());
    b.endTransaction();
  }
  
  public final void b(Set<Long> paramSet)
  {
    a.a(paramSet);
  }
  
  public final void b(boolean paramBoolean)
  {
    drj localdrj = a.o;
    HashMap localHashMap = new HashMap();
    localHashMap.put("temp_roe_ot", String.valueOf(paramBoolean));
    localdrj.a(localHashMap, false);
  }
  
  public final drk c(long paramLong)
  {
    return a.o.a(paramLong);
  }
  
  public final void c()
  {
    a.r.a(a.A);
  }
  
  public final void c(long paramLong1, long paramLong2)
  {
    a.p.execSQL("DELETE FROM messages WHERE conversation=? AND messageId>=?", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  public final void c(String paramString)
  {
    drj localdrj = a.o;
    l = paramString;
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("domainTitle", paramString);
    try
    {
      b.beginTransactionNonExclusive();
      b.delete("dasher_info", null, null);
      b.insertWithOnConflict("dasher_info", null, localContentValues, 5);
      b.setTransactionSuccessful();
      return;
    }
    finally
    {
      b.endTransaction();
    }
  }
  
  public final void c(Map<String, String> paramMap)
  {
    a.o.a(paramMap, false);
  }
  
  public final void c(boolean paramBoolean)
  {
    drj localdrj = a.o;
    HashMap localHashMap = new HashMap();
    localHashMap.put("temp_rroe", String.valueOf(paramBoolean));
    localdrj.a(localHashMap, false);
  }
  
  public final void d()
  {
    a.r.c();
    a.r.d();
  }
  
  public final void d(long paramLong)
  {
    a.p.delete("messages_to_fetch", "_id=?", new String[] { Long.toString(paramLong) });
  }
  
  public final void d(String paramString)
  {
    Object localObject = a.o;
    if (g.containsKey(paramString))
    {
      g.remove(paramString);
      b.delete("server_preferences", "name = ?", new String[] { paramString });
      return;
    }
    localObject = drj.a;
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "Trying to delete a pref that is not present: ".concat(paramString);; paramString = new String("Trying to delete a pref that is not present: "))
    {
      dri.d((String)localObject, paramString, new Object[0]);
      return;
    }
  }
  
  public final void d(Map<String, byte[]> paramMap)
  {
    a.o.a(paramMap);
  }
  
  public final String e(String paramString)
  {
    return a.o.f(paramString);
  }
  
  public final void e(long paramLong)
  {
    a.p.delete("operations", "_id <= ?", new String[] { Long.toString(paramLong) });
  }
  
  public final boolean e()
  {
    return a.p.yieldIfContendedSafely();
  }
  
  public final void f()
  {
    if (a.m == null) {
      return;
    }
    a.r.a(a.A);
    for (;;)
    {
      int i;
      int j;
      try
      {
        dri.a(drp.b, "updateNotificationLabels: Updating notification labels", new Object[0]);
        ArrayList localArrayList1 = new ArrayList();
        Object localObject1 = hgd.a(a.m.c());
        ((List)localObject1).addAll(Arrays.asList(a.m.d()));
        long l1 = a.X.g();
        hfd localhfd = hfd.b(Long.valueOf(a.X.k()));
        ArrayList localArrayList2 = new ArrayList();
        a.y.clear();
        boolean bool = dmv.a().a(a.k, null, "notification-requires-us", false);
        long l2 = a.o.c("^us").a;
        Iterator localIterator = ((List)localObject1).iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          localObject1 = (String)localIterator.next();
          if (drd.c.contains(localObject1)) {
            continue;
          }
          dri.a(drp.b, "updateNotificationLabels:   Adding: %s", new Object[] { localObject1 });
          Object localObject3 = a.o.c((String)localObject1);
          long l3 = a;
          localObject1 = a;
          y.put(Long.valueOf(a), Boolean.valueOf(false));
          localObject3 = dpy.k(drj.a((drk)localObject3));
          if (o.a((String)localObject3) != null)
          {
            j = 0;
            if (bool)
            {
              localObject1 = hfd.a(Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2));
              long l4 = a.a(l3).a;
              localArrayList2.add(Long.valueOf(l4));
              localArrayList1.add(new drm(l3, l4, (Set)localObject1, localhfd));
              i = j | i;
            }
          }
          else
          {
            o.c((String)localObject3);
            j = 1;
            continue;
          }
          localObject1 = hfd.a(Long.valueOf(l3), Long.valueOf(l1));
          continue;
        }
        localObject1 = TextUtils.join(",", localArrayList2);
        a.p.delete("conversation_labels", String.valueOf(localObject1).length() + 93 + "labels_id IN (SELECT _id FROM labels WHERE canonicalName LIKE '^^unseen-%' AND _id NOT IN (" + (String)localObject1 + "))", null);
        if (a.p.delete("labels", String.valueOf(localObject1).length() + 49 + "canonicalName LIKE '^^unseen-%' AND _id NOT IN (" + (String)localObject1 + ")", null) > 0)
        {
          j = 1;
          break label615;
          a.o.l();
          a.o.e = localArrayList1;
          a.r.c();
        }
        else
        {
          j = 0;
        }
      }
      finally
      {
        a.r.d();
      }
      label615:
      if (i == 0) {
        if (j == 0) {}
      }
    }
  }
  
  public final void f(long paramLong)
  {
    a.n.a(paramLong);
  }
  
  public final void f(String paramString)
  {
    drj localdrj = a.o;
    Object localObject = a.l.name;
    paramString = paramString.replace("/customfrom/", "");
    Uri localUri = GmailProvider.b((String)localObject);
    localObject = (ArrayList)dyr.i.get(localUri);
    if (localObject != null) {}
    try
    {
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        cha localcha = (cha)localIterator.next();
        if (b.equals(paramString)) {
          ((ArrayList)localObject).remove(localcha);
        }
      }
      dyr.i.put(localUri, localObject);
      b.delete("custom_from_prefs", "_id= ?", new String[] { paramString });
      return;
    }
    finally {}
  }
  
  public final ArrayList<Long> g()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = a.p.rawQuery("select _id from messages_to_fetch", null);
    try
    {
      if (localCursor.moveToNext()) {
        localArrayList.add(Long.valueOf(localCursor.getLong(0)));
      }
      return localArrayList1;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public final void g(long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("dirty", Integer.valueOf(1));
    if (a.p.update("conversations", localContentValues, "_id=?", new String[] { Long.toString(paramLong) }) == 0) {
      dri.e(drp.b, "Failed to mark conversation as dirty", new Object[0]);
    }
  }
  
  public final ArrayList<Long> h()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = a.p.rawQuery("SELECT DISTINCT _id FROM conversations WHERE dirty=1", null);
    try
    {
      if (localCursor.moveToNext()) {
        localArrayList.add(Long.valueOf(localCursor.getLong(0)));
      }
      return localArrayList1;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public final void h(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    long l3 = DatabaseUtils.longForQuery(a.p, "SELECT numAttempts FROM conversations_to_fetch WHERE _id=?", arrayOfString);
    long l2 = a.m.a("conversationAgeDays");
    long l1;
    if (l2 > 0L)
    {
      l1 = l2;
      if (l2 <= 7L) {}
    }
    else
    {
      l1 = 7L;
    }
    if (l3 > l1 + 4L)
    {
      dri.c(drp.b, "Giving up on conversation %d after %d attempts", new Object[] { Long.valueOf(paramLong), Long.valueOf(l3) });
      a.p.delete("conversations_to_fetch", "_id=?", arrayOfString);
    }
    int i;
    do
    {
      return;
      i = Math.min(1 << (int)l3, 24);
      l1 = new Date().getTime() + i * 60 * 60 * 1000;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("nextAttemptDateMs", Long.valueOf(l1));
      localContentValues.put("numAttempts", Long.valueOf(l3 + 1L));
      a.p.update("conversations_to_fetch", localContentValues, "_id=?", arrayOfString);
    } while (!dri.a(drp.b, 4));
    dri.c(drp.b, "Delayed sync of conversation %d by %d hours till after %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), new Date(l1) });
  }
  
  public final boolean i()
  {
    return a.o.a("temp_roe", false);
  }
  
  public final boolean j()
  {
    return a.o.a("temp_roe_ot", false);
  }
  
  public final boolean k()
  {
    return a.o.a("temp_rroe", false);
  }
  
  public final boolean l()
  {
    return a.o.a("temp_tls_ii", false);
  }
  
  public final boolean m()
  {
    return a.o.a("temp_tls_oi", false);
  }
  
  public final boolean n()
  {
    return a.o.a("temp_fz_ii", false);
  }
  
  public final boolean o()
  {
    return a.o.a("temp_fz_oi", false);
  }
  
  public final String p()
  {
    return a.l.name;
  }
}

/* Location:
 * Qualified Name:     dtc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */