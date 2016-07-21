import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.provider.CalendarContract.Attendees;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.ExtendedProperties;
import android.provider.CalendarContract.Reminders;
import android.provider.CalendarContract.SyncState;
import android.provider.SyncStateContract.Helpers;
import android.text.TextUtils;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public final class bnz
  extends bnx
{
  static final String[] f = { "_id", "_sync_id" };
  static final String[] g = { "_id" };
  private static final String[] t = { "_id" };
  private static final bnw u = new bnw(ContentProviderOperation.newInsert(Uri.EMPTY));
  private final TimeZone h = TimeZone.getTimeZone("UTC");
  private final TimeZone i = TimeZone.getDefault();
  private final long n;
  private final android.accounts.Account o;
  private final Uri p;
  private final Uri q;
  private final String[] r = new String[1];
  private final boa s;
  
  public bnz(Context paramContext, ContentResolver paramContentResolver, InputStream paramInputStream, Mailbox paramMailbox, com.android.emailcommon.provider.Account paramAccount, android.accounts.Account paramAccount1, long paramLong)
  {
    super(paramContext, paramContentResolver, paramInputStream, paramMailbox, paramAccount);
    o = paramAccount1;
    n = paramLong;
    paramContext = bnq.c;
    p = a(CalendarContract.Attendees.CONTENT_URI, b.d, paramContext);
    q = a(CalendarContract.Events.CONTENT_URI, b.d, paramContext);
    s = new boa(paramContentResolver, p, q, a(CalendarContract.Reminders.CONTENT_URI, b.d, paramContext), a(CalendarContract.ExtendedProperties.CONTENT_URI, b.d, paramContext));
  }
  
  public static Uri a(Uri paramUri, String paramString1, String paramString2)
  {
    return paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", paramString1).appendQueryParameter("account_type", paramString2).build();
  }
  
  private static void a(ContentResolver paramContentResolver, String paramString, ArrayList<bnw> paramArrayList, ContentProviderResult[] paramArrayOfContentProviderResult, int paramInt)
  {
    if (paramArrayList.isEmpty()) {
      return;
    }
    try
    {
      paramContentResolver = a(paramContentResolver, paramString, paramArrayList, paramInt);
      System.arraycopy(paramContentResolver, 0, paramArrayOfContentProviderResult, paramInt, paramContentResolver.length);
      return;
    }
    catch (OperationApplicationException paramContentResolver) {}
  }
  
  private final void a(ContentValues paramContentValues, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong1 < 0L) {
      return;
    }
    if (paramLong2 < 0L) {
      paramLong2 = 1800000L + paramLong1;
    }
    for (;;)
    {
      long l2 = paramLong2;
      long l1 = paramLong1;
      if (paramInt != 0)
      {
        l1 = bsx.a(paramLong1, i);
        l2 = bsx.a(paramLong2, i);
        paramContentValues.put("sync_data1", paramContentValues.getAsString("eventTimezone"));
        paramContentValues.put("eventTimezone", h.getID());
      }
      if ((paramContentValues.containsKey("originalInstanceTime")) && (paramContentValues.containsKey("originalAllDay")))
      {
        Object localObject = paramContentValues.getAsInteger("originalAllDay");
        if ((localObject != null) && (((Integer)localObject).intValue() != 0))
        {
          paramLong1 = paramContentValues.getAsLong("originalInstanceTime").longValue();
          localObject = new GregorianCalendar(h);
          ((GregorianCalendar)localObject).setTimeInMillis(bsx.a(paramLong1, i));
          ((GregorianCalendar)localObject).set(11, 0);
          ((GregorianCalendar)localObject).set(12, 0);
          ((GregorianCalendar)localObject).set(13, 0);
          paramContentValues.put("originalInstanceTime", Long.valueOf(((GregorianCalendar)localObject).getTimeInMillis()));
        }
      }
      paramContentValues.put("dtstart", Long.valueOf(l1));
      if (paramContentValues.containsKey("rrule"))
      {
        if (paramInt != 0)
        {
          paramLong1 = (l2 - l1) / 86400000L;
          paramContentValues.put("duration", 22 + "P" + paramLong1 + "D");
          return;
        }
        paramLong1 = (l2 - l1) / 60000L;
        paramContentValues.put("duration", 22 + "P" + paramLong1 + "M");
        return;
      }
      paramContentValues.put("dtend", Long.valueOf(l2));
      paramContentValues.put("lastDate", Long.valueOf(l2));
      return;
    }
  }
  
  private static void a(ContentValues paramContentValues, String paramString)
  {
    if (bnq.b)
    {
      paramString = new StringBuilder(String.valueOf(paramString).length() + 37 + "Event invalid, " + paramString + ", skipping: Columns = ");
      paramContentValues = paramContentValues.valueSet().iterator();
      while (paramContentValues.hasNext())
      {
        paramString.append((String)((Map.Entry)paramContentValues.next()).getKey());
        paramString.append('/');
      }
      paramString.toString();
    }
  }
  
  private static void a(boa paramboa, long paramLong, String paramString1, String paramString2)
  {
    ContentValues localContentValues;
    if ((paramString1 != null) || (paramString2 != null))
    {
      localContentValues = new ContentValues();
      if (paramString1 != null) {
        localContentValues.put("attendeeName", paramString1);
      }
      if (paramString2 != null) {
        localContentValues.put("attendeeEmail", paramString2);
      }
      localContentValues.put("attendeeRelationship", Integer.valueOf(2));
      localContentValues.put("attendeeType", Integer.valueOf(1));
      localContentValues.put("attendeeStatus", Integer.valueOf(1));
      if (paramLong < 0L) {
        paramboa.a(localContentValues);
      }
    }
    else
    {
      return;
    }
    paramboa.a(localContentValues, paramLong);
  }
  
  private final void a(boa paramboa, ContentValues paramContentValues, ArrayList<ContentValues> paramArrayList, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Map<String, String> paramMap)
  {
    while (b(276) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 275: 
        Object localObject3 = new ContentValues();
        ((ContentValues)localObject3).put("calendar_id", Long.valueOf(n));
        ((ContentValues)localObject3).put("organizer", paramContentValues.getAsString("organizer"));
        ((ContentValues)localObject3).put("title", paramContentValues.getAsString("title"));
        ((ContentValues)localObject3).put("description", paramContentValues.getAsString("description"));
        ((ContentValues)localObject3).put("originalAllDay", paramContentValues.getAsInteger("allDay"));
        ((ContentValues)localObject3).put("allDay", paramContentValues.getAsInteger("allDay"));
        ((ContentValues)localObject3).put("eventLocation", paramContentValues.getAsString("eventLocation"));
        ((ContentValues)localObject3).put("accessLevel", paramContentValues.getAsString("accessLevel"));
        ((ContentValues)localObject3).put("eventTimezone", paramContentValues.getAsString("eventTimezone"));
        ((ContentValues)localObject3).put("hasAttendeeData", Integer.valueOf(0));
        int j = 0;
        ((ContentValues)localObject3).put("original_sync_id", paramContentValues.getAsString("_sync_id"));
        Object localObject1 = "_noStartTime";
        long l1 = paramLong2;
        long l2 = paramLong1;
        int k = paramInt2;
        while (b(275) != 3)
        {
          long l3;
          switch (l)
          {
          default: 
            i();
            break;
          case 300: 
            m();
            break;
          case 278: 
          case 1133: 
            String str = g();
            try
            {
              ((ContentValues)localObject3).put("originalInstanceTime", Long.valueOf(bhn.a(str)));
              localObject1 = str;
            }
            catch (ParseException localParseException1)
            {
              cvm.d("Exchange", "Parse error for CALENDAR_EXCEPTION_START_TIME tag.", new Object[] { localParseException1 });
            }
            break;
          case 277: 
            if (h() == 1) {
              ((ContentValues)localObject3).put("eventStatus", Integer.valueOf(2));
            }
            break;
          case 262: 
            j = h();
            ((ContentValues)localObject3).put("allDay", Integer.valueOf(j));
            break;
          case 1098: 
            ((ContentValues)localObject3).put("description", p());
            break;
          case 267: 
            ((ContentValues)localObject3).put("description", g());
            break;
          case 295: 
            try
            {
              l3 = bhn.a(g());
              l2 = l3;
            }
            catch (ParseException localParseException2)
            {
              cvm.d("Exchange", "Parse error for CALENDAR_START_TIME tag.", new Object[] { localParseException2 });
            }
            break;
          case 274: 
            try
            {
              l3 = bhn.a(g());
              l1 = l3;
            }
            catch (ParseException localParseException3)
            {
              cvm.d("Exchange", "Parse error for CALENDAR_END_TIME tag.", new Object[] { localParseException3 });
            }
            break;
          case 279: 
            ((ContentValues)localObject3).put("eventLocation", g());
            break;
          case 283: 
            localObject2 = k();
            if (localObject2 != null) {
              ((ContentValues)localObject3).put("rrule", (String)localObject2);
            }
            break;
          case 294: 
            ((ContentValues)localObject3).put("title", g());
            break;
          case 293: 
            ((ContentValues)localObject3).put("accessLevel", Integer.valueOf(d(h())));
            break;
          case 269: 
            k = h();
          }
        }
        Object localObject2 = String.valueOf(paramContentValues.getAsString("_sync_id"));
        localObject1 = String.valueOf(localObject2).length() + 1 + String.valueOf(localObject1).length() + (String)localObject2 + "_" + (String)localObject1;
        ((ContentValues)localObject3).put("_sync_id", (String)localObject1);
        if (paramMap.containsKey(localObject1)) {
          ((ContentValues)localObject3).put("_id", (String)paramMap.get(localObject1));
        }
        a((ContentValues)localObject3, l2, l1, j);
        if (a((ContentValues)localObject3))
        {
          int i1 = a;
          paramboa.a(new bnw(ContentProviderOperation.newInsert(c).withValues((ContentValues)localObject3)));
          if (paramArrayList != null)
          {
            localObject1 = paramArrayList.iterator();
            j = 0;
            for (;;)
            {
              m = j;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (ContentValues)((Iterator)localObject1).next();
              localObject3 = ((ContentValues)localObject2).getAsString("attendeeEmail");
              if (b.d.equalsIgnoreCase((String)localObject3))
              {
                ((ContentValues)localObject2).put("attendeeStatus", Integer.valueOf(bsx.a(k)));
                paramboa.a((ContentValues)localObject2, i1);
              }
              else if (paramboa.size() < 500)
              {
                paramboa.a((ContentValues)localObject2, i1);
              }
              else
              {
                j = 1;
              }
            }
          }
          int m = 0;
          if (paramInt1 > 0) {
            paramboa.a(paramInt1, i1);
          }
          if (m != 0) {
            cvm.b("Exchange", "Attendees redacted in this exception", new Object[0]);
          }
        }
        break;
      }
    }
  }
  
  private final void a(boa paramboa, String paramString, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("calendar_id", Long.valueOf(n));
    localContentValues.put("_sync_id", paramString);
    localContentValues.put("hasAttendeeData", Integer.valueOf(1));
    localContentValues.put("sync_data2", "0");
    HashMap localHashMap = new HashMap();
    long l3 = -1L;
    Object localObject3 = new ArrayList();
    int i1 = -1;
    int i5 = 0;
    int j = -1;
    int k = -1;
    String str2 = null;
    Object localObject2 = null;
    int i3 = 0;
    String str1 = null;
    Object localObject1 = null;
    int i4 = 1;
    int m = 1;
    int i2 = 0;
    long l1 = -1L;
    Object localObject4 = null;
    long l4 = -1L;
    Object localObject5;
    long l2;
    for (;;)
    {
      if (b(29) == 3) {
        break label1633;
      }
      if ((!paramBoolean) || (m == 0)) {
        break label589;
      }
      localObject5 = b(paramString);
      long l5 = -1L;
      l2 = l5;
      if (localObject5 != null) {
        l2 = l5;
      }
      try
      {
        if (((Cursor)localObject5).moveToFirst()) {
          l2 = ((Cursor)localObject5).getLong(0);
        }
        if (localObject5 != null) {
          ((Cursor)localObject5).close();
        }
        if (l2 <= 0L) {
          break label569;
        }
        if (l == 273) {
          str1 = g();
        }
      }
      finally
      {
        if (localObject5 != null) {
          ((Cursor)localObject5).close();
        }
      }
    }
    paramboa.a(new bnw(ContentProviderOperation.newDelete(p).withSelection("event_id=? AND attendeeRelationship!=2", r)));
    m = j;
    j = k;
    k = m;
    l1 = l2;
    for (;;)
    {
      int i6;
      label569:
      label589:
      label686:
      label774:
      label789:
      String str3;
      switch (l)
      {
      default: 
        i();
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
        k = a;
        paramboa.a(l2, paramString, localHashMap);
        j = paramboa.b(u);
        localContentValues.put("_id", Long.valueOf(l2));
        continue;
        m = paramboa.b(u);
        k = j;
        j = m;
        continue;
        if (m != 0)
        {
          m = paramboa.b(u);
          k = j;
          j = m;
        }
        break;
      case 262: 
        m = h();
        i2 = m;
        if (m != 0)
        {
          i2 = m;
          if (localObject4 != null)
          {
            GregorianCalendar localGregorianCalendar = new GregorianCalendar(i);
            localGregorianCalendar.setTimeInMillis(l4);
            localObject5 = String.valueOf(((TimeZone)localObject4).getID());
            if (((String)localObject5).length() == 0) {
              break label774;
            }
            localObject5 = "All-day event arrived in: ".concat((String)localObject5);
            if (localGregorianCalendar.get(11) == 0)
            {
              i2 = m;
              if (localGregorianCalendar.get(12) == 0) {}
            }
            else
            {
              i2 = 0;
              localObject5 = String.valueOf(i.getID());
              if (((String)localObject5).length() == 0) {
                break label789;
              }
            }
          }
        }
        for (localObject5 = "Not an all-day event locally: ".concat((String)localObject5);; localObject5 = new String("Not an all-day event locally: "))
        {
          localContentValues.put("allDay", Integer.valueOf(i2));
          m = 0;
          i6 = j;
          j = k;
          k = i6;
          break;
          localObject5 = new String("All-day event arrived in: ");
          break label686;
        }
      case 300: 
        m();
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 263: 
        localObject3 = n();
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 1098: 
        localContentValues.put("description", p());
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 267: 
        localContentValues.put("description", g());
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 261: 
        localObject5 = g();
        localObject4 = bsx.a((String)localObject5);
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = i;
        }
        localContentValues.put("eventTimezone", ((TimeZone)localObject1).getID());
        i6 = j;
        m = 0;
        localObject4 = localObject1;
        localObject1 = localObject5;
        j = k;
        k = i6;
        break;
      case 295: 
        try
        {
          l2 = bhn.a(g());
          l4 = l2;
          m = 0;
          i6 = j;
          j = k;
          k = i6;
        }
        catch (ParseException localParseException1)
        {
          cvm.d("Exchange", "Parse error for CALENDAR_START_TIME tag.", new Object[] { localParseException1 });
          m = 0;
          i6 = j;
          j = k;
          k = i6;
        }
        break;
      case 274: 
        try
        {
          l2 = bhn.a(g());
          l3 = l2;
          m = 0;
          i6 = j;
          j = k;
          k = i6;
        }
        catch (ParseException localParseException2)
        {
          cvm.d("Exchange", "Parse error for CALENDAR_END_TIME tag.", new Object[] { localParseException2 });
          m = 0;
          i6 = j;
          j = k;
          k = i6;
        }
        break;
      case 276: 
        a(paramboa, l1, (String)localObject2, str2);
        a(paramboa, localContentValues, (ArrayList)localObject3, i1, i4, l4, l3, localHashMap);
        i5 = 1;
        i6 = j;
        m = 0;
        j = k;
        k = i6;
        break;
      case 279: 
        localContentValues.put("eventLocation", g());
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 1120: 
        b(localContentValues);
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 283: 
        str3 = k();
        m = i1;
        if (str3 != null)
        {
          localContentValues.put("rrule", str3);
          m = 0;
          i6 = j;
          j = k;
          k = i6;
        }
        break;
      case 281: 
        str2 = g();
        localContentValues.put("organizer", str2);
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 294: 
        localContentValues.put("title", g());
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 293: 
        localContentValues.put("accessLevel", Integer.valueOf(d(h())));
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 282: 
        localObject2 = g();
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 292: 
        if (!this.m) {}
        for (i6 = 1;; i6 = 0)
        {
          i1 = h();
          m = i1;
          if (i6 == 0) {
            break label2318;
          }
          paramboa.a(i1, b);
          localContentValues.put("hasAlarm", Integer.valueOf(1));
          m = 0;
          i6 = j;
          j = k;
          k = i6;
          break;
        }
      case 296: 
        localContentValues.put("sync_data2", g());
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 273: 
        str1 = g();
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 280: 
        paramboa.a("meeting_status", g());
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 269: 
        i4 = h();
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 310: 
        i3 = h();
        m = 0;
        i6 = j;
        j = k;
        k = i6;
        break;
      case 270: 
        str3 = l();
        m = i1;
        if (str3.length() > 0)
        {
          paramboa.a("categories", str3);
          m = 0;
          i6 = j;
          j = k;
          k = i6;
          break;
          label1633:
          a(localContentValues, l4, l3, i2);
          localContentValues.put("availability", Integer.valueOf(bsx.d(i4)));
          if (i5 == 0) {
            a(paramboa, l1, (String)localObject2, str2);
          }
          boolean bool = b.d.equals(str2);
          m = ((ArrayList)localObject3).size();
          if (m > 50) {
            if (l1 < 0L)
            {
              paramboa.a("attendeesRedacted", "1");
              if (bool) {
                paramboa.a("upsyncProhibited", "1");
              }
              if (bool) {
                localContentValues.put("organizer", "upload_disallowed@uploadisdisallowed.aaa");
              }
              localContentValues.put("hasAttendeeData", "0");
              cvm.b("Exchange", "Maximum number of attendees exceeded; redacting", new Object[0]);
              label1777:
              if (k >= 0)
              {
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  if (l1 >= 0L) {
                    break label2205;
                  }
                  paramboa.a("tziString", (String)localObject1);
                }
                label1806:
                if (str1 != null) {
                  paramboa.a("dtstamp", str1);
                }
                if (!a(localContentValues)) {
                  break label2219;
                }
                paramboa.set(k, new bnw(ContentProviderOperation.newInsert(q).withValues(localContentValues)));
              }
            }
          }
          for (;;)
          {
            paramString = new bnw(ContentProviderOperation.newDelete(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, Long.MAX_VALUE)));
            e = true;
            paramboa.add(paramString);
            return;
            paramboa.a("attendeesRedacted", "1", l1);
            if (!bool) {
              break;
            }
            paramboa.a("upsyncProhibited", "1", l1);
            break;
            if (m <= 0) {
              break label1777;
            }
            paramString = new StringBuilder();
            localObject2 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ContentValues)((Iterator)localObject2).next();
              localObject4 = ((ContentValues)localObject3).getAsString("attendeeEmail");
              paramString.append((String)localObject4);
              paramString.append("\\");
              if (b.d.equalsIgnoreCase((String)localObject4))
              {
                if (i3 == 0) {
                  break label2076;
                }
                m = bsx.b(i3);
                label2013:
                ((ContentValues)localObject3).put("attendeeStatus", Integer.valueOf(m));
                if ((str2 == null) || (!str2.equalsIgnoreCase((String)localObject4)))
                {
                  if (l1 >= 0L) {
                    break label2096;
                  }
                  paramboa.a("userAttendeeStatus", Integer.toString(m));
                }
              }
              for (;;)
              {
                if (l1 >= 0L) {
                  break label2113;
                }
                paramboa.a((ContentValues)localObject3);
                break;
                label2076:
                if (!paramBoolean)
                {
                  m = 0;
                  break label2013;
                }
                m = bsx.a(i4);
                break label2013;
                label2096:
                paramboa.a("userAttendeeStatus", Integer.toString(m), l1);
              }
              label2113:
              paramboa.a((ContentValues)localObject3, l1);
            }
            if (l1 < 0L)
            {
              paramboa.a("attendees", paramString.toString());
              paramboa.a("attendeesRedacted", "0");
              paramboa.a("upsyncProhibited", "0");
              break label1777;
            }
            paramboa.a("attendees", paramString.toString(), l1);
            paramboa.a("attendeesRedacted", "0", l1);
            paramboa.a("upsyncProhibited", "0", l1);
            break label1777;
            label2205:
            paramboa.a("tziString", (String)localObject1, l1);
            break label1806;
            label2219:
            i1 = a - k;
            new StringBuilder(38).append("Removing ").append(i1).append(" inserts from mOps").toString();
            m = 0;
            while (m < i1)
            {
              paramboa.remove(k);
              m += 1;
            }
            a = k;
            if (j >= 0)
            {
              paramboa.remove(j);
              paramboa.remove(j);
              a = j;
            }
          }
        }
        label2318:
        int i7 = 0;
        i6 = j;
        i1 = m;
        m = i7;
        j = k;
        k = i6;
        break;
        m = k;
        k = j;
        j = m;
      }
    }
  }
  
  private final boolean a(ContentValues paramContentValues)
  {
    boolean bool = paramContentValues.containsKey("originalInstanceTime");
    if (!paramContentValues.containsKey("dtstart")) {
      a(paramContentValues, "DTSTART missing");
    }
    String str;
    do
    {
      do
      {
        return false;
        if ((!bool) && (!paramContentValues.containsKey("sync_data2")))
        {
          a(paramContentValues, "_SYNC_DATA missing");
          return false;
        }
        if ((!bool) && (!paramContentValues.containsKey("dtend")) && (!paramContentValues.containsKey("duration")))
        {
          a(paramContentValues, "DTEND/DURATION missing");
          return false;
        }
        if ((bool) && (!paramContentValues.containsKey("dtend")))
        {
          a(paramContentValues, "Exception missing DTEND");
          return false;
        }
        if (!paramContentValues.containsKey("rrule")) {
          break;
        }
        str = paramContentValues.getAsString("duration");
      } while (str == null);
      if (!paramContentValues.containsKey("allDay")) {
        break;
      }
      paramContentValues = paramContentValues.getAsInteger("allDay");
    } while ((paramContentValues != null) && (paramContentValues.intValue() != 0) && (!str.endsWith("D")));
    return true;
  }
  
  protected static ContentProviderResult[] a(ContentResolver paramContentResolver, String paramString, ArrayList<bnw> paramArrayList)
  {
    try
    {
      ContentProviderResult[] arrayOfContentProviderResult1 = a(paramContentResolver, paramString, paramArrayList, 0);
      return arrayOfContentProviderResult1;
    }
    catch (TransactionTooLargeException localTransactionTooLargeException)
    {
      ArrayList localArrayList = new ArrayList();
      ContentProviderResult[] arrayOfContentProviderResult2 = new ContentProviderResult[paramArrayList.size()];
      paramArrayList = paramArrayList.iterator();
      int j = 0;
      int k = 0;
      if (paramArrayList.hasNext())
      {
        bnw localbnw = (bnw)paramArrayList.next();
        if (e)
        {
          a(paramContentResolver, paramString, localArrayList, arrayOfContentProviderResult2, j);
          localArrayList.clear();
          j = k + 1;
        }
        for (;;)
        {
          k += 1;
          break;
          localArrayList.add(localbnw);
        }
      }
      k = localArrayList.size();
      if ((k > 0) && ((k != 1) || (!get0e))) {
        a(paramContentResolver, paramString, localArrayList, arrayOfContentProviderResult2, j);
      }
      return arrayOfContentProviderResult2;
    }
    catch (RemoteException paramContentResolver)
    {
      throw paramContentResolver;
    }
    catch (OperationApplicationException paramContentResolver) {}
    return null;
  }
  
  private static ContentProviderResult[] a(ContentResolver paramContentResolver, String paramString, ArrayList<bnw> paramArrayList, int paramInt)
  {
    if (paramArrayList.isEmpty()) {
      return new ContentProviderResult[0];
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      paramArrayList = (bnw)localIterator.next();
      if (a != null) {}
      ContentProviderOperation.Builder localBuilder;
      for (paramArrayList = a;; paramArrayList = localBuilder.build())
      {
        localArrayList.add(paramArrayList);
        break;
        if (b == null) {
          throw new IllegalArgumentException("Operation must have CPO.Builder");
        }
        localBuilder = b;
        if (c != null) {
          localBuilder.withValueBackReference(c, d - paramInt);
        }
      }
    }
    return b(paramContentResolver, paramString, localArrayList);
  }
  
  private final Cursor b(String paramString)
  {
    return d.query(CalendarContract.Events.CONTENT_URI, t, "_sync_id=? AND original_sync_id ISNULL AND calendar_id=?", new String[] { paramString, Long.toString(n) }, null);
  }
  
  private final void b(ContentValues paramContentValues)
  {
    int j = 0;
    String[] arrayOfString = new String[6];
    while (b(1120) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 1104: 
        arrayOfString[0] = g();
        break;
      case 1122: 
        arrayOfString[1] = g();
        break;
      case 1123: 
        arrayOfString[2] = g();
        break;
      case 1124: 
        arrayOfString[3] = g();
        break;
      case 1126: 
        arrayOfString[4] = g();
        break;
      case 1125: 
        arrayOfString[5] = g();
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    while (j < 6)
    {
      if (arrayOfString[j] != null)
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(arrayOfString[j]);
      }
      j += 1;
    }
    paramContentValues.put("eventLocation", localStringBuilder.toString());
  }
  
  private static ContentProviderResult[] b(ContentResolver paramContentResolver, String paramString, ArrayList<ContentProviderOperation> paramArrayList)
  {
    if (!paramArrayList.isEmpty()) {
      try
      {
        paramContentResolver = paramContentResolver.applyBatch(paramString, paramArrayList);
        return paramContentResolver;
      }
      catch (IllegalArgumentException paramContentResolver)
      {
        cvm.e("Exchange", "Error executing operation; provider is disabled.", new Object[] { paramContentResolver });
      }
    }
    return new ContentProviderResult[0];
  }
  
  private static int d(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 3;
    case 2: 
      return 2;
    }
    return 1;
  }
  
  private final String k()
  {
    int j = -1;
    String str = null;
    int k = -1;
    int m = -1;
    int i1 = -1;
    int i2 = -1;
    int i3 = -1;
    int i4 = -1;
    while (b(283) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 284: 
        i4 = h();
        break;
      case 287: 
        i2 = h();
        break;
      case 286: 
        i3 = h();
        break;
      case 288: 
        i1 = h();
        break;
      case 289: 
        m = h();
        break;
      case 290: 
        k = h();
        break;
      case 291: 
        j = h();
        break;
      case 285: 
        str = g();
      }
    }
    return bsx.a(i4, i3, i2, i1, m, k, j, str);
  }
  
  private final String l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (b(270) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 271: 
        localStringBuilder.append(g());
        localStringBuilder.append("\\");
      }
    }
    return localStringBuilder.toString();
  }
  
  private final void m()
  {
    while (b(300) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 299: 
        a(299);
      }
    }
  }
  
  private final ArrayList<ContentValues> n()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    while (b(263) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 264: 
        ContentValues localContentValues = o();
        int k = j + 1;
        j = k;
        if (k <= 51)
        {
          localArrayList.add(localContentValues);
          j = k;
        }
        break;
      }
    }
    return localArrayList;
  }
  
  private final ContentValues o()
  {
    ContentValues localContentValues = new ContentValues();
    while (b(264) != 3)
    {
      int j;
      switch (l)
      {
      default: 
        i();
        break;
      case 265: 
        localContentValues.put("attendeeEmail", g());
        break;
      case 266: 
        localContentValues.put("attendeeName", g());
        break;
      case 297: 
        j = h();
        if (j == 2) {
          j = 4;
        }
        for (;;)
        {
          localContentValues.put("attendeeStatus", Integer.valueOf(j));
          break;
          if (j == 3) {
            j = 1;
          } else if (j == 4) {
            j = 2;
          } else if (j == 5) {
            j = 3;
          } else {
            j = 0;
          }
        }
      case 298: 
        switch (h())
        {
        default: 
          j = 0;
        }
        for (;;)
        {
          localContentValues.put("attendeeType", Integer.valueOf(j));
          break;
          j = 1;
          continue;
          j = 2;
        }
      }
    }
    localContentValues.put("attendeeRelationship", Integer.valueOf(1));
    return localContentValues;
  }
  
  private final String p()
  {
    String str = null;
    while (b(1098) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 1099: 
        str = g();
      }
    }
    if (str == null) {
      return "";
    }
    return str.replace("\r\n", "\n");
  }
  
  private final void q()
  {
    String str2 = null;
    String str1 = null;
    while (b(8) != 3) {
      switch (l)
      {
      default: 
        i();
        break;
      case 13: 
        str1 = g();
        break;
      case 14: 
        str2 = g();
      }
    }
    if ((str1 != null) && (str2 != null)) {
      new StringBuilder(String.valueOf(str1).length() + 35 + String.valueOf(str2).length()).append("Changed event ").append(str1).append(" failed with status: ").append(str2).toString();
    }
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 22
    //   3: invokevirtual 356	bnz:b	(I)I
    //   6: iconst_3
    //   7: if_icmpeq +315 -> 322
    //   10: aload_0
    //   11: getfield 360	bnz:l	I
    //   14: bipush 7
    //   16: if_icmpne +77 -> 93
    //   19: aload_0
    //   20: getfield 127	bnz:s	Lboa;
    //   23: astore_2
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_0
    //   27: bipush 7
    //   29: invokevirtual 356	bnz:b	(I)I
    //   32: iconst_3
    //   33: if_icmpeq -33 -> 0
    //   36: aload_0
    //   37: getfield 360	bnz:l	I
    //   40: lookupswitch	default:+28->68, 13:+35->75, 29:+43->83
    //   68: aload_0
    //   69: invokevirtual 362	bnz:i	()V
    //   72: goto -46 -> 26
    //   75: aload_0
    //   76: invokevirtual 387	bnz:g	()Ljava/lang/String;
    //   79: astore_1
    //   80: goto -54 -> 26
    //   83: aload_0
    //   84: aload_2
    //   85: aload_1
    //   86: iconst_0
    //   87: invokespecial 713	bnz:a	(Lboa;Ljava/lang/String;Z)V
    //   90: goto -64 -> 26
    //   93: aload_0
    //   94: getfield 360	bnz:l	I
    //   97: bipush 9
    //   99: if_icmpne +99 -> 198
    //   102: aload_0
    //   103: getfield 127	bnz:s	Lboa;
    //   106: astore_2
    //   107: aload_0
    //   108: bipush 9
    //   110: invokevirtual 356	bnz:b	(I)I
    //   113: iconst_3
    //   114: if_icmpeq -114 -> 0
    //   117: aload_0
    //   118: getfield 360	bnz:l	I
    //   121: tableswitch	default:+19->140, 13:+26->147
    //   140: aload_0
    //   141: invokevirtual 362	bnz:i	()V
    //   144: goto -37 -> 107
    //   147: aload_0
    //   148: invokevirtual 387	bnz:g	()Ljava/lang/String;
    //   151: astore_3
    //   152: aload_0
    //   153: aload_3
    //   154: invokespecial 480	bnz:b	(Ljava/lang/String;)Landroid/database/Cursor;
    //   157: astore_1
    //   158: aload_1
    //   159: invokeinterface 485 1 0
    //   164: ifeq +16 -> 180
    //   167: aload_2
    //   168: aload_1
    //   169: iconst_0
    //   170: invokeinterface 489 2 0
    //   175: aload_3
    //   176: aconst_null
    //   177: invokevirtual 507	boa:a	(JLjava/lang/String;Ljava/util/Map;)V
    //   180: aload_1
    //   181: invokeinterface 492 1 0
    //   186: goto -79 -> 107
    //   189: astore_2
    //   190: aload_1
    //   191: invokeinterface 492 1 0
    //   196: aload_2
    //   197: athrow
    //   198: aload_0
    //   199: getfield 360	bnz:l	I
    //   202: bipush 8
    //   204: if_icmpne +111 -> 315
    //   207: aload_0
    //   208: getfield 127	bnz:s	Lboa;
    //   211: astore_3
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_0
    //   215: bipush 8
    //   217: invokevirtual 356	bnz:b	(I)I
    //   220: iconst_3
    //   221: if_icmpeq -221 -> 0
    //   224: aload_0
    //   225: getfield 360	bnz:l	I
    //   228: lookupswitch	default:+28->256, 13:+35->263, 29:+43->271
    //   256: aload_0
    //   257: invokevirtual 362	bnz:i	()V
    //   260: goto -46 -> 214
    //   263: aload_0
    //   264: invokevirtual 387	bnz:g	()Ljava/lang/String;
    //   267: astore_1
    //   268: goto -54 -> 214
    //   271: aload_1
    //   272: invokestatic 288	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   275: astore_2
    //   276: aload_2
    //   277: invokevirtual 291	java/lang/String:length	()I
    //   280: ifeq +21 -> 301
    //   283: ldc_w 715
    //   286: aload_2
    //   287: invokevirtual 515	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   290: astore_2
    //   291: aload_0
    //   292: aload_3
    //   293: aload_1
    //   294: iconst_1
    //   295: invokespecial 713	bnz:a	(Lboa;Ljava/lang/String;Z)V
    //   298: goto -84 -> 214
    //   301: new 27	java/lang/String
    //   304: dup
    //   305: ldc_w 715
    //   308: invokespecial 520	java/lang/String:<init>	(Ljava/lang/String;)V
    //   311: astore_2
    //   312: goto -21 -> 291
    //   315: aload_0
    //   316: invokevirtual 362	bnz:i	()V
    //   319: goto -319 -> 0
    //   322: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	bnz
    //   25	269	1	localObject1	Object
    //   23	145	2	localboa	boa
    //   189	8	2	localObject2	Object
    //   275	37	2	str	String
    //   151	142	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   158	180	189	finally
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 6
    //   3: invokevirtual 356	bnz:b	(I)I
    //   6: iconst_3
    //   7: if_icmpeq +366 -> 373
    //   10: aload_0
    //   11: getfield 360	bnz:l	I
    //   14: bipush 7
    //   16: if_icmpne +334 -> 350
    //   19: iconst_m1
    //   20: istore_1
    //   21: new 183	android/content/ContentValues
    //   24: dup
    //   25: invokespecial 328	android/content/ContentValues:<init>	()V
    //   28: astore 7
    //   30: aconst_null
    //   31: astore 6
    //   33: aconst_null
    //   34: astore 5
    //   36: aload_0
    //   37: bipush 7
    //   39: invokevirtual 356	bnz:b	(I)I
    //   42: iconst_3
    //   43: if_icmpeq +98 -> 141
    //   46: aload_0
    //   47: getfield 360	bnz:l	I
    //   50: tableswitch	default:+26->76, 12:+42->92, 13:+33->83, 14:+51->101
    //   76: aload_0
    //   77: invokevirtual 362	bnz:i	()V
    //   80: goto -44 -> 36
    //   83: aload_0
    //   84: invokevirtual 387	bnz:g	()Ljava/lang/String;
    //   87: astore 5
    //   89: goto -53 -> 36
    //   92: aload_0
    //   93: invokevirtual 387	bnz:g	()Ljava/lang/String;
    //   96: astore 6
    //   98: goto -62 -> 36
    //   101: aload_0
    //   102: invokevirtual 405	bnz:h	()I
    //   105: istore_2
    //   106: iload_2
    //   107: istore_1
    //   108: iload_2
    //   109: iconst_1
    //   110: if_icmpeq -74 -> 36
    //   113: new 256	java/lang/StringBuilder
    //   116: dup
    //   117: bipush 52
    //   119: invokespecial 259	java/lang/StringBuilder:<init>	(I)V
    //   122: ldc_w 717
    //   125: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: iload_2
    //   129: invokevirtual 607	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: pop
    //   136: iload_2
    //   137: istore_1
    //   138: goto -102 -> 36
    //   141: aload 6
    //   143: ifnull -143 -> 0
    //   146: aload 5
    //   148: ifnonnull +226 -> 374
    //   151: new 256	java/lang/StringBuilder
    //   154: dup
    //   155: bipush 16
    //   157: invokespecial 259	java/lang/StringBuilder:<init>	(I)V
    //   160: ldc_w 719
    //   163: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload_1
    //   167: invokevirtual 607	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 5
    //   175: aload_0
    //   176: getfield 79	bnz:r	[Ljava/lang/String;
    //   179: iconst_0
    //   180: aload 6
    //   182: aastore
    //   183: aload_0
    //   184: getfield 668	bnz:d	Landroid/content/ContentResolver;
    //   187: getstatic 112	android/provider/CalendarContract$Events:CONTENT_URI	Landroid/net/Uri;
    //   190: getstatic 31	bnz:t	[Ljava/lang/String;
    //   193: ldc_w 721
    //   196: aload_0
    //   197: getfield 79	bnz:r	[Ljava/lang/String;
    //   200: aconst_null
    //   201: invokevirtual 676	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   204: astore 8
    //   206: aload 8
    //   208: invokeinterface 485 1 0
    //   213: ifeq +115 -> 328
    //   216: aload 7
    //   218: ldc 33
    //   220: aload 5
    //   222: invokevirtual 191	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload 7
    //   227: ldc_w 469
    //   230: aload 6
    //   232: invokevirtual 191	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 8
    //   237: iconst_0
    //   238: invokeinterface 489 2 0
    //   243: lstore_3
    //   244: aload_0
    //   245: getfield 127	bnz:s	Lboa;
    //   248: new 39	bnw
    //   251: dup
    //   252: aload_0
    //   253: getfield 114	bnz:q	Landroid/net/Uri;
    //   256: lload_3
    //   257: invokestatic 582	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   260: invokestatic 724	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   263: aload 7
    //   265: invokevirtual 444	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   268: invokespecial 54	bnw:<init>	(Landroid/content/ContentProviderOperation$Builder;)V
    //   271: invokevirtual 447	boa:a	(Lbnw;)Z
    //   274: pop
    //   275: new 256	java/lang/StringBuilder
    //   278: dup
    //   279: aload 6
    //   281: invokestatic 288	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   284: invokevirtual 291	java/lang/String:length	()I
    //   287: bipush 31
    //   289: iadd
    //   290: aload 5
    //   292: invokestatic 288	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   295: invokevirtual 291	java/lang/String:length	()I
    //   298: iadd
    //   299: invokespecial 259	java/lang/StringBuilder:<init>	(I)V
    //   302: ldc_w 726
    //   305: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 6
    //   310: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc_w 728
    //   316: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload 5
    //   321: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: pop
    //   328: aload 8
    //   330: invokeinterface 492 1 0
    //   335: goto -335 -> 0
    //   338: astore 5
    //   340: aload 8
    //   342: invokeinterface 492 1 0
    //   347: aload 5
    //   349: athrow
    //   350: aload_0
    //   351: getfield 360	bnz:l	I
    //   354: bipush 8
    //   356: if_icmpne +10 -> 366
    //   359: aload_0
    //   360: invokespecial 730	bnz:q	()V
    //   363: goto -363 -> 0
    //   366: aload_0
    //   367: invokevirtual 362	bnz:i	()V
    //   370: goto -370 -> 0
    //   373: return
    //   374: goto -199 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	bnz
    //   20	147	1	j	int
    //   105	32	2	k	int
    //   243	14	3	l	long
    //   34	286	5	str1	String
    //   338	10	5	localObject	Object
    //   31	278	6	str2	String
    //   28	236	7	localContentValues	ContentValues
    //   204	137	8	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   206	328	338	finally
  }
  
  public final void c()
  {
    String str = a.j;
    s.a(new bnw(SyncStateContract.Helpers.newSetOperation(a(CalendarContract.SyncState.CONTENT_URI, b.d, bnq.c), o, a.j.getBytes())));
    try
    {
      a(d, "com.android.calendar", s);
      bqk.a(c, b);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IOException("Remote exception caught; will retry");
    }
  }
  
  protected final void e()
  {
    cvm.d("Exchange", "Wiping calendar folder %s", new Object[] { a });
    bqu.a(c, b.d, a.d);
  }
}

/* Location:
 * Qualified Name:     bnz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */