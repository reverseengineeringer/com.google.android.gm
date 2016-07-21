import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.Entity.NamedContentValues;
import android.content.EntityIterator;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.CalendarContract.Attendees;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.EventsEntity;
import android.provider.CalendarContract.ExtendedProperties;
import android.text.TextUtils;
import android.util.Base64;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Attachment;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public final class bsx
{
  public static HashMap<TimeZone, String> a;
  static final String[] b = { "DAILY", "WEEKLY", "MONTHLY", "MONTHLY", "", "YEARLY", "YEARLY" };
  static final String[] c = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };
  static final String[] d = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
  static final int e = new GregorianCalendar().get(1);
  static final TimeZone f = TimeZone.getTimeZone("GMT");
  private static HashMap<String, TimeZone> g = new HashMap();
  private static final TimeZone h;
  
  static
  {
    a = new HashMap();
    h = TimeZone.getTimeZone("UTC");
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2: 
      return 1;
    }
    return 4;
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int j = i + 1;
    return (paramArrayOfByte[i] & 0xFF) << 8 | paramInt & 0xFF | (paramArrayOfByte[j] & 0xFF) << 16 | (paramArrayOfByte[(j + 1)] & 0xFF) << 24;
  }
  
  public static long a(long paramLong, TimeZone paramTimeZone)
  {
    return a(paramLong, paramTimeZone, h);
  }
  
  private static long a(long paramLong, TimeZone paramTimeZone1, TimeZone paramTimeZone2)
  {
    paramTimeZone1 = new GregorianCalendar(paramTimeZone1);
    paramTimeZone1.setTimeInMillis(paramLong);
    paramTimeZone2 = new GregorianCalendar(paramTimeZone2);
    paramTimeZone2.set(paramTimeZone1.get(1), paramTimeZone1.get(2), paramTimeZone1.get(5), 0, 0, 0);
    paramTimeZone2.set(14, 0);
    return paramTimeZone2.getTimeInMillis();
  }
  
  private static long a(long paramLong, GregorianCalendar[] paramArrayOfGregorianCalendar)
  {
    int j = paramArrayOfGregorianCalendar.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfGregorianCalendar[i].getTimeInMillis();
      if (l > paramLong) {
        return l;
      }
      i += 1;
    }
    return 0L;
  }
  
  public static long a(Context paramContext, ContentResolver paramContentResolver, Account paramAccount, Mailbox paramMailbox)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("calendar_displayName", c);
    localContentValues.put("account_name", d);
    localContentValues.put("account_type", bnq.c);
    localContentValues.put("sync_events", Integer.valueOf(1));
    localContentValues.put("_sync_id", d);
    localContentValues.put("visible", Integer.valueOf(1));
    localContentValues.put("canOrganizerRespond", Integer.valueOf(0));
    localContentValues.put("canModifyTimeZone", Integer.valueOf(0));
    localContentValues.put("maxReminders", Integer.valueOf(1));
    localContentValues.put("allowedReminders", "0,1");
    localContentValues.put("allowedAttendeeTypes", "0,1,2");
    localContentValues.put("allowedAvailability", "0,1,2");
    localContentValues.put("calendar_color", Integer.valueOf(new ben(paramContext).a(D)));
    localContentValues.put("calendar_timezone", Calendar.getInstance().getTimeZone().toString());
    localContentValues.put("calendar_access_level", Integer.valueOf(700));
    localContentValues.put("ownerAccount", d);
    if (TextUtils.equals(c, d)) {
      localContentValues.put("isPrimary", Integer.valueOf(1));
    }
    for (;;)
    {
      paramContext = CalendarContract.Calendars.CONTENT_URI;
      paramAccount = d;
      String str = bnq.c;
      paramContext = paramContentResolver.insert(paramContext.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", paramAccount).appendQueryParameter("account_type", str).build(), localContentValues);
      if (paramContext == null) {
        break;
      }
      paramContext = (String)paramContext.getPathSegments().get(1);
      p = paramContext;
      return Long.parseLong(paramContext);
      localContentValues.put("isPrimary", Integer.valueOf(0));
    }
    return -1L;
  }
  
  private static long a(TimeZone paramTimeZone, bsz parambsz)
  {
    paramTimeZone = new GregorianCalendar(paramTimeZone);
    paramTimeZone.set(1, e);
    paramTimeZone.set(2, b);
    paramTimeZone.set(7, c);
    paramTimeZone.set(8, d);
    paramTimeZone.set(11, f);
    paramTimeZone.set(12, g);
    paramTimeZone.set(13, 0);
    return paramTimeZone.getTimeInMillis();
  }
  
  public static beb a(Context paramContext, long paramLong, int paramInt, String paramString, Account paramAccount)
  {
    return a(paramContext, paramLong, paramInt, paramString, paramAccount, null);
  }
  
  public static beb a(Context paramContext, long paramLong, int paramInt, String paramString1, Account paramAccount, String paramString2)
  {
    Object localObject = paramContext.getContentResolver();
    Cursor localCursor = ((ContentResolver)localObject).query(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, paramLong), null, null, null, null);
    if (localCursor == null) {
      return null;
    }
    localObject = CalendarContract.EventsEntity.newEntityIterator(localCursor, (ContentResolver)localObject);
    try
    {
      if (((EntityIterator)localObject).hasNext())
      {
        paramContext = a(paramContext, (Entity)((EntityIterator)localObject).next(), paramInt, paramString1, paramAccount, paramString2);
        return paramContext;
      }
      return null;
    }
    finally
    {
      ((EntityIterator)localObject).close();
    }
  }
  
  public static beb a(Context paramContext, Entity paramEntity, int paramInt, String paramString, Account paramAccount)
  {
    return a(paramContext, paramEntity, paramInt, paramString, paramAccount, null);
  }
  
  private static beb a(Context paramContext, Entity paramEntity, int paramInt, String paramString1, Account paramAccount, String paramString2)
  {
    ContentValues localContentValues = paramEntity.getEntityValues();
    ArrayList localArrayList = paramEntity.getSubValues();
    boolean bool2 = localContentValues.containsKey("originalInstanceTime");
    beb localbeb = new beb();
    u = paramInt;
    n = System.currentTimeMillis();
    Object localObject1 = null;
    Object localObject2 = localArrayList.iterator();
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject5;
    if (((Iterator)localObject2).hasNext())
    {
      paramEntity = (Entity.NamedContentValues)((Iterator)localObject2).next();
      if (uri.equals(CalendarContract.ExtendedProperties.CONTENT_URI))
      {
        paramEntity = values;
        localObject5 = paramEntity.getAsString("name");
        i = -1;
        switch (((String)localObject5).hashCode())
        {
        default: 
          label152:
          switch (i)
          {
          }
          break;
        }
      }
      for (paramEntity = (Entity)localObject1;; paramEntity = paramEntity.getAsString("value"))
      {
        localObject1 = paramEntity;
        break;
        if (!((String)localObject5).equals("proposedStartTime")) {
          break label152;
        }
        i = 0;
        break label152;
        if (!((String)localObject5).equals("proposedEndTime")) {
          break label152;
        }
        i = 1;
        break label152;
        if (!((String)localObject5).equals("meetingRequestComment")) {
          break label152;
        }
        i = 2;
        break label152;
        localObject4 = paramEntity.getAsLong("value");
        break;
        localObject3 = paramEntity.getAsLong("value");
        break;
      }
    }
    int m;
    int j;
    if ((localObject4 != null) && (localObject3 != null))
    {
      m = 1;
      if ((paramInt & 0x10) == 0) {
        break label1311;
      }
      paramEntity = "REQUEST";
      j = 0;
    }
    btj localbtj;
    Object localObject6;
    int k;
    label540:
    long l1;
    label658:
    boolean bool1;
    label709:
    label770:
    label816:
    label862:
    label924:
    label1082:
    label1148:
    label1311:
    label1454:
    label1523:
    label1603:
    label1628:
    int n;
    for (;;)
    {
      long l3;
      long l2;
      GregorianCalendar[] arrayOfGregorianCalendar;
      try
      {
        localbtj = new btj();
        localbtj.a("BEGIN", "VCALENDAR");
        localbtj.a("METHOD", paramEntity);
        localbtj.a("PRODID", "AndroidEmail");
        localbtj.a("VERSION", "2.0");
        localObject6 = f;
        k = 0;
        if (!localContentValues.containsKey("allDay")) {
          break label2685;
        }
        localObject2 = localContentValues.getAsInteger("allDay");
        if ((localObject2 != null) && (((Integer)localObject2).intValue() == 1))
        {
          i = 1;
          break label2696;
          if ((j != 0) || (i != 0) || ((!localContentValues.containsKey("rrule")) && (!localContentValues.containsKey("original_sync_id")))) {
            break label2674;
          }
          localObject6 = TimeZone.getDefault();
          k = ((TimeZone)localObject6).getRawOffset() / 60000;
          localObject2 = e(k);
          localbtj.a("BEGIN", "VTIMEZONE");
          localbtj.a("TZID", ((TimeZone)localObject6).getID());
          localbtj.a("X-LIC-LOCATION", ((TimeZone)localObject6).getDisplayName());
          if (((TimeZone)localObject6).useDaylightTime()) {
            continue;
          }
          a(localbtj, (String)localObject2);
          localObject2 = String.valueOf(((TimeZone)localObject6).getID());
          if (((String)localObject2).length() == 0) {
            break label1700;
          }
          localObject2 = ";TZID=".concat((String)localObject2);
          break label2713;
          localbtj.a("BEGIN", "VEVENT");
          localObject6 = paramString1;
          if (paramString1 == null) {
            localObject6 = localContentValues.getAsString("sync_data2");
          }
          if (localObject6 != null) {
            localbtj.a("UID", (String)localObject6);
          }
          if (!localContentValues.containsKey("DTSTAMP")) {
            break label1715;
          }
          localbtj.a("DTSTAMP", localContentValues.getAsString("DTSTAMP"));
          l3 = localContentValues.getAsLong("dtstart").longValue();
          if (localContentValues.containsKey("duration")) {
            break label1732;
          }
          if (!localContentValues.containsKey("dtend")) {
            break label2668;
          }
          l1 = localContentValues.getAsLong("dtend").longValue();
          if (m == 0) {
            break label1833;
          }
          if (((Long)localObject4).longValue() != 0L)
          {
            paramString1 = String.valueOf(localObject5);
            if (paramString1.length() == 0) {
              break label1777;
            }
            paramString1 = "DTSTART".concat(paramString1);
            l2 = ((Long)localObject4).longValue();
            if (i != 0) {
              break label2828;
            }
            bool1 = true;
            localbtj.a(paramString1, a(l2, (TimeZone)localObject2, bool1));
          }
          if (((Long)localObject3).longValue() != 0L)
          {
            paramString1 = String.valueOf(localObject5);
            if (paramString1.length() == 0) {
              break label1791;
            }
            paramString1 = "DTEND".concat(paramString1);
            l2 = ((Long)localObject3).longValue();
            if (i != 0) {
              break label2834;
            }
            bool1 = true;
            localbtj.a(paramString1, a(l2, (TimeZone)localObject2, bool1));
          }
          if (l3 != 0L)
          {
            paramString1 = String.valueOf(localObject5);
            if (paramString1.length() == 0) {
              break label1805;
            }
            paramString1 = "X-MS-OLK-ORIGINALSTART".concat(paramString1);
            break label2724;
            localbtj.a(paramString1, a(l3, (TimeZone)localObject2, bool1));
          }
          if (l1 != 0L)
          {
            paramString1 = String.valueOf(localObject5);
            if (paramString1.length() == 0) {
              break label1819;
            }
            paramString1 = "X-MS-OLK-ORIGINALEND".concat(paramString1);
            break label2735;
            localbtj.a(paramString1, a(l1, (TimeZone)localObject2, bool1));
          }
          if (localContentValues.containsKey("eventLocation")) {
            localbtj.a("LOCATION", localContentValues.getAsString("eventLocation"));
          }
          paramString1 = localContentValues.getAsString("sync_data4");
          if (paramString1 != null) {
            break label2665;
          }
          paramString1 = "0";
          break label2746;
          localObject4 = paramContext.getResources();
          localObject3 = localContentValues.getAsString("title");
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localbtj.a("SUMMARY", (String)localObject2);
          if (i != 0) {
            break label2103;
          }
          o = ((String)localObject2);
          if (localObject1 != null) {
            localbtj.a("COMMENT", (String)localObject1);
          }
          localObject2 = new StringBuilder();
          if ((!bool2) || (j != 0)) {
            break label2802;
          }
          localObject3 = new Date(localContentValues.getAsLong("originalInstanceTime").longValue());
          localObject3 = DateFormat.getDateInstance().format((Date)localObject3);
          if (i != bnu.n) {
            break label2127;
          }
          ((StringBuilder)localObject2).append(((Resources)localObject4).getString(bnu.e, new Object[] { localObject3 }));
          ((StringBuilder)localObject2).append("\n\n");
          break label2802;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localbtj.a("DESCRIPTION", (String)localObject1);
          }
          ax = ((String)localObject1);
          ay = ((String)localObject1);
          if (j == 0)
          {
            if (localContentValues.containsKey("allDay"))
            {
              if (localContentValues.getAsInteger("allDay").intValue() != 0) {
                break label2903;
              }
              paramContext = "FALSE";
              localbtj.a("X-MICROSOFT-CDO-ALLDAYEVENT", paramContext);
            }
            paramContext = localContentValues.getAsString("rrule");
            if (paramContext != null) {
              localbtj.a("RRULE", paramContext);
            }
          }
          localObject3 = new ArrayList();
          localObject4 = localArrayList.iterator();
          paramContext = null;
          localObject1 = null;
          if (!((Iterator)localObject4).hasNext()) {
            break label2208;
          }
          localObject5 = (Entity.NamedContentValues)((Iterator)localObject4).next();
          localObject2 = uri;
          localObject5 = values;
          if (!((Uri)localObject2).equals(CalendarContract.Attendees.CONTENT_URI)) {
            continue;
          }
          localObject6 = ((ContentValues)localObject5).getAsInteger("attendeeRelationship");
          localObject2 = ((ContentValues)localObject5).getAsString("attendeeEmail");
          if ((localObject6 == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            continue;
          }
          if (((Integer)localObject6).intValue() != 2) {
            break label2166;
          }
          localObject1 = ((ContentValues)localObject5).getAsString("attendeeName");
          paramContext = (Context)localObject2;
          continue;
          m = 0;
          break;
          if ((paramInt & 0x20) != 0)
          {
            paramEntity = "CANCEL";
            j = 0;
            continue;
          }
          if (m != 0)
          {
            paramEntity = "COUNTER";
            j = 1;
            continue;
          }
          paramEntity = "REPLY";
          j = 1;
          continue;
        }
        i = 0;
        break label2696;
        localObject5 = new GregorianCalendar[3];
        arrayOfGregorianCalendar = new GregorianCalendar[3];
        if (!a((TimeZone)localObject6, (GregorianCalendar[])localObject5, arrayOfGregorianCalendar))
        {
          a(localbtj, (String)localObject2);
          continue;
        }
        localbsy1 = a((GregorianCalendar[])localObject5);
      }
      catch (IOException paramContext)
      {
        cvm.d("Exchange", "IOException in createMessageForEntity", new Object[0]);
        return null;
      }
      bsy localbsy1;
      bsy localbsy2 = a(arrayOfGregorianCalendar);
      String str = e(k + ((TimeZone)localObject6).getDSTSavings() / 60000);
      if ((localbsy1 == null) || (localbsy2 == null)) {
        break label2810;
      }
      k = 1;
      localbtj.a("BEGIN", "DAYLIGHT");
      localbtj.a("TZOFFSETFROM", (String)localObject2);
      localbtj.a("TZOFFSETTO", str);
      localbtj.a("DTSTART", c(localObject5[0].getTimeInMillis(), (TimeZone)localObject6));
      if (k == 0) {
        break label2816;
      }
      localbtj.a("RRULE", localbsy1.toString());
      localbtj.a("END", "DAYLIGHT");
      localbtj.a("BEGIN", "STANDARD");
      localbtj.a("TZOFFSETFROM", str);
      localbtj.a("TZOFFSETTO", (String)localObject2);
      localbtj.a("DTSTART", c(arrayOfGregorianCalendar[0].getTimeInMillis(), (TimeZone)localObject6));
      if (k == 0) {
        break label2822;
      }
      localbtj.a("RRULE", localbsy2.toString());
      localbtj.a("END", "STANDARD");
      localbtj.a("END", "VTIMEZONE");
      continue;
      while (n < 3)
      {
        localbtj.a("RDATE", c(localObject5[n].getTimeInMillis(), (TimeZone)localObject6));
        n += 1;
      }
      label1664:
      while (k < 3)
      {
        localbtj.a("RDATE", c(arrayOfGregorianCalendar[k].getTimeInMillis(), (TimeZone)localObject6));
        k += 1;
      }
      label1700:
      localObject2 = new String(";TZID=");
      break label2713;
      label1715:
      localbtj.a("DTSTAMP", a(System.currentTimeMillis()));
      continue;
      label1732:
      l1 = 3600000L;
      paramString1 = new anu();
      try
      {
        paramString1.a(localContentValues.getAsString("duration"));
        l2 = paramString1.a();
        l1 = l2;
      }
      catch (ant paramString1)
      {
        for (;;)
        {
          continue;
          paramAccount = "ORGANIZER";
        }
      }
      l1 += l3;
      continue;
      label1777:
      paramString1 = new String("DTSTART");
      continue;
      label1791:
      paramString1 = new String("DTEND");
      continue;
      label1805:
      paramString1 = new String("X-MS-OLK-ORIGINALSTART");
      break label2724;
      label1819:
      paramString1 = new String("X-MS-OLK-ORIGINALEND");
      break label2735;
      label1833:
      if (l3 != 0L)
      {
        paramString1 = String.valueOf(localObject5);
        if (paramString1.length() != 0)
        {
          paramString1 = "DTSTART".concat(paramString1);
          break label2852;
          label1864:
          localbtj.a(paramString1, a(l3, (TimeZone)localObject2, bool1));
        }
      }
      else
      {
        if (bool2)
        {
          l2 = localContentValues.getAsLong("originalInstanceTime").longValue();
          paramString1 = String.valueOf(localObject5);
          if (paramString1.length() == 0) {
            break label1999;
          }
          paramString1 = "RECURRENCE-ID".concat(paramString1);
          break label2863;
          label1921:
          localbtj.a(paramString1, a(l2, (TimeZone)localObject2, bool1));
        }
        if (l1 == 0L) {
          continue;
        }
        paramString1 = String.valueOf(localObject5);
        if (paramString1.length() == 0) {
          break label2013;
        }
        paramString1 = "DTEND".concat(paramString1);
        break label2874;
        label1967:
        localbtj.a(paramString1, a(l1, (TimeZone)localObject2, bool1));
        continue;
      }
      paramString1 = new String("DTSTART");
      break label2852;
      label1999:
      paramString1 = new String("RECURRENCE-ID");
      break label2863;
      label2013:
      paramString1 = new String("DTEND");
      break label2874;
      if (paramString1.equals("0")) {
        break label2796;
      }
      i = bnu.s;
      continue;
      i = bnu.k;
      continue;
      if (m != 0)
      {
        i = bnu.o;
      }
      else
      {
        i = bnu.p;
        continue;
        if (m != 0)
        {
          i = bnu.o;
        }
        else
        {
          i = bnu.r;
          continue;
          i = bnu.n;
          continue;
          label2103:
          o = ((Resources)localObject4).getString(i, new Object[] { localObject2 });
          continue;
          label2127:
          ((StringBuilder)localObject2).append(((Resources)localObject4).getString(bnu.f, new Object[] { localObject3 }));
          continue;
          label2153:
          localObject1 = a(paramContext, localContentValues, (StringBuilder)localObject2);
          continue;
          label2166:
          localObject5 = ((ContentValues)localObject5).getAsString("attendeeName");
          if ((paramString2 == null) || (((String)localObject2).equalsIgnoreCase(paramString2))) {
            a(localbtj, (ArrayList)localObject3, (String)localObject5, (String)localObject2, paramInt, paramAccount);
          }
        }
      }
    }
    label2208:
    if ((((ArrayList)localObject3).isEmpty()) && (paramString2 != null)) {
      a(localbtj, (ArrayList)localObject3, null, paramString2, paramInt, paramAccount);
    }
    if (paramContext != null)
    {
      if (localObject1 == null) {
        break label2657;
      }
      paramAccount = String.valueOf("ORGANIZER");
      paramString2 = String.valueOf(btj.a((String)localObject1));
      paramAccount = String.valueOf(paramAccount).length() + 4 + String.valueOf(paramString2).length() + paramAccount + ";CN=" + paramString2;
      paramString2 = String.valueOf(paramContext);
      if (paramString2.length() == 0) {
        break label2377;
      }
      paramString2 = "MAILTO:".concat(paramString2);
      localbtj.a(paramAccount, paramString2);
      if (j != 0) {
        if (localObject1 != null) {
          break label2392;
        }
      }
    }
    label2377:
    label2392:
    for (paramContext = new Address(paramContext);; paramContext = new Address(paramContext, (String)localObject1))
    {
      ((ArrayList)localObject3).add(paramContext);
      if (!((ArrayList)localObject3).isEmpty()) {
        break label2406;
      }
      return null;
      paramString2 = new String("MAILTO:");
      break;
    }
    label2406:
    paramContext = new Address[((ArrayList)localObject3).size()];
    int i = 0;
    paramAccount = ((ArrayList)localObject3).iterator();
    while (paramAccount.hasNext())
    {
      paramContext[i] = ((Address)paramAccount.next());
      i += 1;
    }
    Y = Address.b(paramContext);
    localbtj.a("CLASS", "PUBLIC");
    if (paramInt == 32) {}
    for (paramContext = "CANCELLED";; paramContext = "CONFIRMED")
    {
      localbtj.a("STATUS", paramContext);
      localbtj.a("TRANSP", "OPAQUE");
      localbtj.a("PRIORITY", "5");
      localbtj.a("SEQUENCE", paramString1);
      localbtj.a("END", "VEVENT");
      localbtj.a("END", "VCALENDAR");
      paramString1 = new Attachment();
      t = localbtj.a();
      paramContext = String.valueOf(paramEntity);
      if (paramContext.length() != 0) {}
      for (paramContext = "text/calendar; method=".concat(paramContext);; paramContext = new String("text/calendar; method="))
      {
        j = paramContext;
        i = "invite.ics";
        k = t.length;
        s = 1;
        aA = new ArrayList();
        aA.add(paramString1);
        return localbeb;
      }
      label2657:
      label2665:
      break label2746;
      label2668:
      l1 = 0L;
      break label658;
      label2674:
      localObject5 = localObject2;
      localObject2 = localObject6;
      break label540;
      label2685:
      label2696:
      do
      {
        i = k;
        localObject2 = "";
        break;
        k = i;
      } while (i == 0);
      localObject2 = ";VALUE=DATE";
      break;
      label2713:
      localObject5 = localObject2;
      localObject2 = localObject6;
      break label540;
      label2724:
      if (i == 0)
      {
        bool1 = true;
        break label816;
        label2735:
        if (i != 0) {
          break label2846;
        }
        bool1 = true;
        break label862;
        label2746:
        switch (paramInt)
        {
        }
        label2796:
        i = 0;
        break label924;
        label2802:
        if (m == 0) {
          break label2153;
        }
        break label1082;
        label2810:
        k = 0;
        break label1454;
        label2816:
        n = 1;
        break label1628;
        break label1523;
        label2822:
        k = 1;
        break label1664;
        break label1603;
        label2828:
        bool1 = false;
        break label709;
        label2834:
        bool1 = false;
        break label770;
      }
      bool1 = false;
      break label816;
      label2846:
      bool1 = false;
      break label862;
      label2852:
      if (i == 0)
      {
        bool1 = true;
        break label1864;
        label2863:
        if (i != 0) {
          break label2891;
        }
        bool1 = true;
        break label1921;
        label2874:
        if (i != 0) {
          break label2897;
        }
        bool1 = true;
        break label1967;
      }
      bool1 = false;
      break label1864;
      label2891:
      bool1 = false;
      break label1921;
      label2897:
      bool1 = false;
      break label1967;
      label2903:
      paramContext = "TRUE";
      break label1148;
    }
  }
  
  private static bsy a(GregorianCalendar[] paramArrayOfGregorianCalendar)
  {
    GregorianCalendar localGregorianCalendar = paramArrayOfGregorianCalendar[0];
    if (localGregorianCalendar == null) {
      return null;
    }
    int n = localGregorianCalendar.get(2);
    int i1 = localGregorianCalendar.get(5);
    int i2 = localGregorianCalendar.get(7);
    int m = localGregorianCalendar.get(8);
    int i3 = localGregorianCalendar.getActualMaximum(8);
    int k = 0;
    int i = 0;
    int j = 1;
    if (j < paramArrayOfGregorianCalendar.length)
    {
      localGregorianCalendar = paramArrayOfGregorianCalendar[j];
      if (localGregorianCalendar == null) {
        return null;
      }
      if (localGregorianCalendar.get(2) != n) {
        return null;
      }
      if (i2 == localGregorianCalendar.get(7))
      {
        if (k != 0) {
          return null;
        }
        i = localGregorianCalendar.get(8);
        if (m != i) {
          if (((m < 0) || (m == i3)) && (i == localGregorianCalendar.getActualMaximum(8)))
          {
            m = -1;
            i = 1;
          }
        }
      }
      for (;;)
      {
        j += 1;
        break;
        return null;
        i = 1;
        continue;
        if (i1 != localGregorianCalendar.get(5)) {
          break label188;
        }
        if (i != 0) {
          return null;
        }
        k = 1;
      }
      label188:
      return null;
    }
    if (k != 0) {
      return new bsy(n + 1, i1);
    }
    return new bsy(n + 1, i2, m);
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString)
  {
    if ((paramInt1 < 0) || (paramInt1 >= b.length)) {}
    do
    {
      return null;
      localObject = b[paramInt1];
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Object localObject = String.valueOf(localObject);
    if (((String)localObject).length() != 0)
    {
      localObject = "FREQ=".concat((String)localObject);
      localObject = new StringBuilder((String)localObject);
      if (paramInt2 > 0) {
        ((StringBuilder)localObject).append(18 + ";COUNT=" + paramInt2);
      }
      if (paramInt3 > 0) {
        ((StringBuilder)localObject).append(21 + ";INTERVAL=" + paramInt3);
      }
      switch (paramInt1)
      {
      case 4: 
      default: 
        label172:
        if (paramString != null)
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() == 0) {
            break label499;
          }
        }
        break;
      }
    }
    label499:
    for (paramString = ";UNTIL=".concat(paramString);; paramString = new String(";UNTIL="))
    {
      ((StringBuilder)localObject).append(paramString);
      if (bnq.b)
      {
        paramString = bbw.a;
        String str = String.valueOf(localObject);
        cvm.b(paramString, String.valueOf(str).length() + 15 + "Created rrule: " + str, new Object[0]);
      }
      return ((StringBuilder)localObject).toString();
      localObject = new String("FREQ=");
      break;
      if (paramInt4 <= 0) {
        break label172;
      }
      a((StringBuilder)localObject, paramInt4, paramInt6);
      break label172;
      if (paramInt5 <= 0) {
        break label172;
      }
      a((StringBuilder)localObject, paramInt5);
      break label172;
      if (paramInt4 == 127)
      {
        ((StringBuilder)localObject).append(";BYMONTHDAY=-1");
        break label172;
      }
      if (((paramInt6 == 5) || (paramInt6 == 1)) && ((paramInt4 == 62) || (paramInt4 == 65)))
      {
        b((StringBuilder)localObject, paramInt4, paramInt6);
        break label172;
      }
      if (paramInt4 <= 0) {
        break label172;
      }
      a((StringBuilder)localObject, paramInt4, paramInt6);
      break label172;
      if (paramInt5 > 0) {
        a((StringBuilder)localObject, paramInt5);
      }
      if (paramInt7 <= 0) {
        break label172;
      }
      ((StringBuilder)localObject).append(20 + ";BYMONTH=" + paramInt7);
      break label172;
      if (paramInt4 > 0) {
        a((StringBuilder)localObject, paramInt4, paramInt6);
      }
      if (paramInt5 > 0) {
        a((StringBuilder)localObject, paramInt5);
      }
      if (paramInt7 <= 0) {
        break label172;
      }
      ((StringBuilder)localObject).append(20 + ";BYMONTH=" + paramInt7);
      break label172;
    }
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, f, true);
  }
  
  private static String a(long paramLong, TimeZone paramTimeZone, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(paramTimeZone);
    localGregorianCalendar.setTimeInMillis(paramLong);
    localStringBuilder.append(localGregorianCalendar.get(1));
    localStringBuilder.append(f(localGregorianCalendar.get(2) + 1));
    localStringBuilder.append(f(localGregorianCalendar.get(5)));
    if (paramBoolean)
    {
      localStringBuilder.append('T');
      localStringBuilder.append(f(localGregorianCalendar.get(11)));
      localStringBuilder.append(f(localGregorianCalendar.get(12)));
      localStringBuilder.append(f(localGregorianCalendar.get(13)));
      if (paramTimeZone == f) {
        localStringBuilder.append('Z');
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, ContentValues paramContentValues, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = paramStringBuilder;
    if (paramStringBuilder == null) {
      localStringBuilder = new StringBuilder();
    }
    paramStringBuilder = paramContext.getResources();
    int i;
    if (paramContentValues.containsKey("allDay"))
    {
      paramContext = paramContentValues.getAsInteger("allDay");
      if ((paramContext != null) && (paramContext.intValue() == 1)) {
        i = 1;
      }
    }
    for (;;)
    {
      int j;
      label76:
      long l;
      if ((!paramContentValues.containsKey("original_sync_id")) && (paramContentValues.containsKey("rrule")))
      {
        j = 1;
        if (paramContentValues.containsKey("dtstart"))
        {
          l = paramContentValues.getAsLong("dtstart").longValue();
          if (i == 0) {
            break label261;
          }
          paramContext = new Date(b(l, TimeZone.getDefault()));
          paramContext = DateFormat.getDateInstance().format(paramContext);
          if (j == 0) {
            break label254;
          }
        }
      }
      label254:
      for (i = bnu.m;; i = bnu.l)
      {
        localStringBuilder.append(paramStringBuilder.getString(i, new Object[] { paramContext }));
        if (paramContentValues.containsKey("eventLocation"))
        {
          paramContext = paramContentValues.getAsString("eventLocation");
          if (!TextUtils.isEmpty(paramContext))
          {
            localStringBuilder.append("\n");
            localStringBuilder.append(paramStringBuilder.getString(bnu.u, new Object[] { paramContext }));
          }
        }
        paramContext = paramContentValues.getAsString("description");
        if (paramContext != null)
        {
          localStringBuilder.append("\n--\n");
          localStringBuilder.append(paramContext);
        }
        return localStringBuilder.toString();
        i = 0;
        break;
        j = 0;
        break label76;
      }
      label261:
      paramContext = DateFormat.getDateTimeInstance().format(new Date(l));
      if (j != 0) {}
      for (i = bnu.q;; i = bnu.t) {
        break;
      }
      i = 0;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return String.format("%s-%s", new Object[] { paramString1, paramString2 });
  }
  
  public static String a(GregorianCalendar paramGregorianCalendar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramGregorianCalendar.get(1));
    localStringBuilder.append('-');
    localStringBuilder.append(f(paramGregorianCalendar.get(2) + 1));
    localStringBuilder.append('-');
    localStringBuilder.append(f(paramGregorianCalendar.get(5)));
    return localStringBuilder.toString();
  }
  
  public static String a(TimeZone paramTimeZone)
  {
    byte[] arrayOfByte = new byte['¬'];
    a(arrayOfByte, 0, -paramTimeZone.getRawOffset() / 60000);
    GregorianCalendar[] arrayOfGregorianCalendar1;
    GregorianCalendar[] arrayOfGregorianCalendar2;
    if (paramTimeZone.useDaylightTime())
    {
      arrayOfGregorianCalendar1 = new GregorianCalendar[3];
      arrayOfGregorianCalendar2 = new GregorianCalendar[3];
      if (a(paramTimeZone, arrayOfGregorianCalendar1, arrayOfGregorianCalendar2))
      {
        bsy localbsy1 = a(arrayOfGregorianCalendar1);
        bsy localbsy2 = a(arrayOfGregorianCalendar2);
        if ((localbsy1 == null) || (a != 1) || (localbsy2 == null) || (a != 1)) {
          break label172;
        }
        a(arrayOfByte, 68, localbsy2, c(arrayOfGregorianCalendar2[0]), b(arrayOfGregorianCalendar2[0]));
        a(arrayOfByte, 152, localbsy1, c(arrayOfGregorianCalendar1[0]), b(arrayOfGregorianCalendar1[0]));
      }
    }
    for (;;)
    {
      a(arrayOfByte, 168, -paramTimeZone.getDSTSavings() / 60000);
      return new String(Base64.encode(arrayOfByte, 2));
      label172:
      long l2 = System.currentTimeMillis();
      long l1 = a(l2, arrayOfGregorianCalendar2);
      l2 = a(l2, arrayOfGregorianCalendar1);
      if ((l1 != 0L) && (l2 != 0L))
      {
        a(arrayOfByte, 68, l1);
        a(arrayOfByte, 152, l2);
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 32)
    {
      int j = b(paramArrayOfByte, i * 2 + 4);
      if (j == 0) {
        break;
      }
      localStringBuilder.append((char)j);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static GregorianCalendar a(TimeZone paramTimeZone, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l1 = paramLong2;
    while (l1 - paramLong1 > 60000L)
    {
      long l2 = (paramLong1 + l1) / 2L + 1L;
      if (paramTimeZone.inDaylightTime(new Date(l2)) != paramBoolean) {
        l1 = l2;
      } else {
        paramLong1 = l2;
      }
    }
    if (l1 == paramLong2) {
      return null;
    }
    paramTimeZone = new GregorianCalendar(paramTimeZone);
    paramTimeZone.setTimeInMillis(paramLong1);
    return paramTimeZone;
  }
  
  public static TimeZone a(String paramString)
  {
    Object localObject = (TimeZone)g.get(paramString);
    if (localObject != null)
    {
      if (bnq.b)
      {
        paramString = String.valueOf(((TimeZone)localObject).getID());
        if (paramString.length() == 0) {
          break label58;
        }
      }
      label58:
      for (paramString = " Using cached TimeZone ".concat(paramString);; paramString = new String(" Using cached TimeZone "))
      {
        cvm.b("Exchange", paramString, new Object[0]);
        return (TimeZone)localObject;
      }
    }
    TimeZone localTimeZone = a(paramString, 60000);
    localObject = localTimeZone;
    if (localTimeZone == null)
    {
      localObject = String.valueOf(paramString);
      if (((String)localObject).length() == 0) {
        break label133;
      }
    }
    label133:
    for (localObject = "TimeZone not found using default: ".concat((String)localObject);; localObject = new String("TimeZone not found using default: "))
    {
      cvm.b("Exchange", (String)localObject, new Object[0]);
      localObject = TimeZone.getDefault();
      g.put(paramString, localObject);
      return (TimeZone)localObject;
    }
  }
  
  private static TimeZone a(String paramString, int paramInt)
  {
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    String[] arrayOfString = TimeZone.getAvailableIDs(a(arrayOfByte, 0) * -1 * 60000);
    if (arrayOfString.length > 0)
    {
      bsz localbsz1 = c(arrayOfByte, 68);
      Object localObject2;
      int i;
      label87:
      Object localObject1;
      if (localbsz1 == null)
      {
        localObject2 = TimeZone.getDefault();
        if (!((TimeZone)localObject2).useDaylightTime())
        {
          paramString = ((TimeZone)localObject2).getID();
          i = arrayOfString.length;
          paramInt = 0;
          if (paramInt < i) {
            if (paramString.equals(arrayOfString[paramInt]))
            {
              paramInt = 1;
              if (paramInt == 0) {
                break label170;
              }
              localObject1 = localObject2;
              if (bnq.b)
              {
                paramString = String.valueOf(((TimeZone)localObject2).getID());
                if (paramString.length() == 0) {
                  break label156;
                }
                paramString = "TimeZone without DST found to be default: ".concat(paramString);
                label125:
                cvm.b("Exchange", paramString, new Object[0]);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      label156:
      label170:
      label268:
      int j;
      label457:
      do
      {
        return (TimeZone)localObject1;
        paramInt += 1;
        break;
        paramInt = 0;
        break label87;
        paramString = new String("TimeZone without DST found to be default: ");
        break label125;
        i = arrayOfString.length;
        paramInt = 0;
        for (;;)
        {
          if (paramInt >= i) {
            break label268;
          }
          localObject2 = TimeZone.getTimeZone(arrayOfString[paramInt]);
          if (!((TimeZone)localObject2).useDaylightTime())
          {
            localObject1 = localObject2;
            if (!bnq.b) {
              break;
            }
            paramString = String.valueOf(((TimeZone)localObject2).getID());
            if (paramString.length() != 0) {}
            for (paramString = "TimeZone without DST found by offset: ".concat(paramString);; paramString = new String("TimeZone without DST found by offset: "))
            {
              cvm.b("Exchange", paramString, new Object[0]);
              return (TimeZone)localObject2;
            }
          }
          paramInt += 1;
        }
        return null;
        bsz localbsz2 = c(arrayOfByte, 152);
        long l1 = a(arrayOfByte, 168) * -1 * 60000;
        j = arrayOfString.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label457;
          }
          localObject2 = TimeZone.getTimeZone(arrayOfString[i]);
          long l2 = a((TimeZone)localObject2, localbsz2);
          localObject1 = new Date(l2 - paramInt);
          Date localDate = new Date(l2 + paramInt);
          if ((!((TimeZone)localObject2).inDaylightTime((Date)localObject1)) && (((TimeZone)localObject2).inDaylightTime(localDate)))
          {
            l2 = a((TimeZone)localObject2, localbsz1);
            localObject1 = new Date(l2 - (paramInt + l1));
            localDate = new Date(l2 + paramInt);
            if ((((TimeZone)localObject2).inDaylightTime((Date)localObject1)) && (!((TimeZone)localObject2).inDaylightTime(localDate)))
            {
              localObject1 = localObject2;
              if (l1 == ((TimeZone)localObject2).getDSTSavings()) {
                break;
              }
            }
          }
          i += 1;
        }
        i = 0;
        j = 0;
        if ((f == f) || (paramInt != 60000)) {
          break label585;
        }
        paramString = a(paramString, 14400000);
        i = 1;
        paramInt = j;
        localObject1 = paramString;
      } while (!bnq.b);
      if (paramInt != 0) {
        localObject1 = "name";
      }
      for (;;)
      {
        localObject2 = String.valueOf(paramString.getID());
        cvm.b("Exchange", String.valueOf(localObject1).length() + 47 + String.valueOf(localObject2).length() + "No TimeZone with correct DST settings; using " + (String)localObject1 + ": " + (String)localObject2, new Object[0]);
        return paramString;
        label585:
        paramString = a(arrayOfByte);
        if (!paramString.isEmpty())
        {
          paramString = TimeZone.getTimeZone(paramString);
          if (paramString != null)
          {
            paramInt = 1;
            break;
          }
          paramString = TimeZone.getTimeZone(arrayOfString[0]);
          paramInt = j;
          break;
        }
        paramString = TimeZone.getTimeZone(arrayOfString[0]);
        paramInt = j;
        break;
        if (i != 0) {
          localObject1 = "lenient";
        } else {
          localObject1 = "first";
        }
      }
    }
    return null;
  }
  
  private static void a(btj parambtj, String paramString)
  {
    parambtj.a("BEGIN", "STANDARD");
    parambtj.a("TZOFFSETFROM", paramString);
    parambtj.a("TZOFFSETTO", paramString);
    parambtj.a("DTSTART", a(0L));
    parambtj.a("END", "STANDARD");
    parambtj.a("END", "VTIMEZONE");
  }
  
  private static void a(btj parambtj, ArrayList<Address> paramArrayList, String paramString1, String paramString2, int paramInt, Account paramAccount)
  {
    if ((paramInt & 0x30) != 0)
    {
      paramAccount = "ATTENDEE;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE";
      if ((paramInt & 0x20) != 0) {
        paramAccount = "ATTENDEE;ROLE=REQ-PARTICIPANT";
      }
      localObject = paramAccount;
      if (paramString1 != null)
      {
        paramAccount = String.valueOf(paramAccount);
        localObject = String.valueOf(btj.a(paramString1));
        localObject = String.valueOf(paramAccount).length() + 4 + String.valueOf(localObject).length() + paramAccount + ";CN=" + (String)localObject;
      }
      paramAccount = String.valueOf(paramString2);
      if (paramAccount.length() != 0)
      {
        paramAccount = "MAILTO:".concat(paramAccount);
        parambtj.a((String)localObject, paramAccount);
        if (paramString1 != null) {
          break label164;
        }
        parambtj = new Address(paramString2);
        paramArrayList.add(parambtj);
      }
    }
    label164:
    while (!paramString2.equalsIgnoreCase(d)) {
      for (;;)
      {
        Object localObject;
        return;
        paramAccount = new String("MAILTO:");
        continue;
        parambtj = new Address(paramString2, paramString1);
      }
    }
    paramArrayList = null;
    switch (paramInt)
    {
    default: 
      label228:
      if (paramArrayList != null)
      {
        paramAccount = paramArrayList;
        if (paramString1 != null)
        {
          paramArrayList = String.valueOf(paramArrayList);
          paramString1 = String.valueOf(btj.a(paramString1));
          paramAccount = String.valueOf(paramArrayList).length() + 4 + String.valueOf(paramString1).length() + paramArrayList + ";CN=" + paramString1;
        }
        paramArrayList = String.valueOf(paramString2);
        if (paramArrayList.length() == 0) {
          break label344;
        }
      }
      break;
    }
    label344:
    for (paramArrayList = "MAILTO:".concat(paramArrayList);; paramArrayList = new String("MAILTO:"))
    {
      parambtj.a(paramAccount, paramArrayList);
      return;
      paramArrayList = "ATTENDEE;ROLE=REQ-PARTICIPANT;PARTSTAT=ACCEPTED";
      break label228;
      paramArrayList = "ATTENDEE;ROLE=REQ-PARTICIPANT;PARTSTAT=DECLINED";
      break label228;
      paramArrayList = "ATTENDEE;ROLE=REQ-PARTICIPANT;PARTSTAT=TENTATIVE";
      break label228;
      break;
    }
  }
  
  public static void a(String paramString, long paramLong, TimeZone paramTimeZone, bpi parambpi)
  {
    Object localObject1;
    int i;
    if (bnq.b)
    {
      localObject1 = String.valueOf(paramString);
      if (((String)localObject1).length() != 0)
      {
        localObject1 = "RRULE: ".concat((String)localObject1);
        cvm.b("Exchange", (String)localObject1, new Object[0]);
      }
    }
    else
    {
      localObject1 = b(paramString, "FREQ=");
      if (localObject1 != null)
      {
        i = -1;
        switch (((String)localObject1).hashCode())
        {
        default: 
          label108:
          switch (i)
          {
          }
          break;
        }
      }
    }
    for (;;)
    {
      return;
      localObject1 = new String("RRULE: ");
      break;
      if (!((String)localObject1).equals("DAILY")) {
        break label108;
      }
      i = 0;
      break label108;
      if (!((String)localObject1).equals("WEEKLY")) {
        break label108;
      }
      i = 1;
      break label108;
      if (!((String)localObject1).equals("MONTHLY")) {
        break label108;
      }
      i = 2;
      break label108;
      if (!((String)localObject1).equals("YEARLY")) {
        break label108;
      }
      i = 3;
      break label108;
      parambpi.a(283);
      parambpi.b(284, "0");
      a(paramString, parambpi);
      parambpi.b();
      return;
      parambpi.a(283);
      parambpi.b(284, "1");
      a(paramString, parambpi);
      paramString = b(paramString, "BYDAY=");
      if (paramString != null)
      {
        parambpi.b(288, d(paramString));
        if (paramString.startsWith("-1")) {
          parambpi.b(290, "5");
        }
      }
      for (;;)
      {
        parambpi.b();
        return;
        i = paramString.charAt(0);
        if ((i >= 49) && (i <= 52))
        {
          parambpi.b(290, paramString.substring(0, 1));
          continue;
          paramString = new GregorianCalendar(paramTimeZone);
          paramString.setTimeInMillis(paramLong);
          parambpi.b(288, Integer.toString(1 << paramString.get(7) - 1));
        }
      }
      localObject1 = b(paramString, "BYMONTHDAY=");
      if (localObject1 != null)
      {
        parambpi.a(283);
        if (((String)localObject1).equals("-1"))
        {
          parambpi.b(284, "3");
          a(paramString, parambpi);
          parambpi.b(288, "127");
        }
        for (;;)
        {
          parambpi.b();
          return;
          parambpi.b(284, "2");
          a(paramString, parambpi);
          parambpi.b(289, (String)localObject1);
        }
      }
      localObject1 = b(paramString, "BYDAY=");
      Object localObject2 = b(paramString, "BYSETPOS=");
      if (localObject1 != null)
      {
        parambpi.a(283);
        parambpi.b(284, "3");
        a(paramString, parambpi);
        if (localObject2 != null) {
          a((String)localObject1, (String)localObject2, parambpi);
        }
        for (;;)
        {
          parambpi.b();
          return;
          b((String)localObject1, parambpi);
        }
      }
      parambpi.a(283);
      localObject1 = new GregorianCalendar();
      ((GregorianCalendar)localObject1).setTimeInMillis(paramLong);
      ((GregorianCalendar)localObject1).setTimeZone(paramTimeZone);
      paramTimeZone = Integer.toString(((GregorianCalendar)localObject1).get(5));
      parambpi.b(284, "2");
      a(paramString, parambpi);
      parambpi.b(289, paramTimeZone);
      parambpi.b();
      return;
      localObject1 = b(paramString, "BYMONTH=");
      localObject2 = b(paramString, "BYMONTHDAY=");
      String str = b(paramString, "BYDAY=");
      if ((localObject1 == null) && (localObject2 == null))
      {
        localObject2 = new GregorianCalendar();
        ((GregorianCalendar)localObject2).setTimeInMillis(paramLong);
        ((GregorianCalendar)localObject2).setTimeZone(paramTimeZone);
        localObject1 = Integer.toString(((GregorianCalendar)localObject2).get(2) + 1);
      }
      for (paramTimeZone = Integer.toString(((GregorianCalendar)localObject2).get(5)); (localObject1 != null) && ((paramTimeZone != null) || (str != null)); paramTimeZone = (TimeZone)localObject2)
      {
        parambpi.a(283);
        if (str == null)
        {
          localObject2 = "5";
          parambpi.b(284, (String)localObject2);
          a(paramString, parambpi);
          parambpi.b(291, (String)localObject1);
          if (paramTimeZone == null) {
            break label843;
          }
          parambpi.b(289, paramTimeZone);
        }
        for (;;)
        {
          parambpi.b();
          return;
          localObject2 = "6";
          break;
          label843:
          b(str, parambpi);
        }
      }
    }
  }
  
  private static void a(String paramString, bpi parambpi)
  {
    Object localObject = b(paramString, "COUNT=");
    if (localObject != null) {
      parambpi.b(286, (String)localObject);
    }
    localObject = b(paramString, "INTERVAL=");
    if (localObject != null) {
      parambpi.b(287, (String)localObject);
    }
    localObject = b(paramString, "UNTIL=");
    if (localObject != null) {}
    try
    {
      paramString = new GregorianCalendar(TimeZone.getDefault());
      paramString.setTimeInMillis(bhn.a((String)localObject));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.get(1));
      ((StringBuilder)localObject).append(f(paramString.get(2) + 1));
      ((StringBuilder)localObject).append(f(paramString.get(5)));
      ((StringBuilder)localObject).append("T000000Z");
      parambpi.b(285, ((StringBuilder)localObject).toString());
      return;
    }
    catch (ParseException paramString)
    {
      cvm.d("Exchange", "Parse error for CALENDAR_RECURRENCE_UNTIL tag.", new Object[] { paramString });
    }
  }
  
  private static void a(String paramString1, String paramString2, bpi parambpi)
  {
    int i = paramString2.charAt(0);
    if (i == 45) {
      i = 5;
    }
    for (;;)
    {
      parambpi.b(290, Integer.toString(i));
      parambpi.b(288, d(paramString1));
      return;
      i -= 48;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 127) {
      i = -1;
    }
    paramStringBuilder.append(23 + ";BYMONTHDAY=" + i);
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    int j = 0;
    paramStringBuilder.append(";BYDAY=");
    int k = 0;
    int i = paramInt1;
    paramInt1 = k;
    if (paramInt1 < 7)
    {
      k = j;
      if ((i & 0x1) == 1)
      {
        if (j != 0) {
          paramStringBuilder.append(',');
        }
        if (paramInt2 > 0) {
          if (paramInt2 != 5) {
            break label95;
          }
        }
      }
      label95:
      for (j = -1;; j = paramInt2)
      {
        paramStringBuilder.append(j);
        paramStringBuilder.append(c[paramInt1]);
        k = 1;
        i >>= 1;
        paramInt1 += 1;
        j = k;
        break;
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 1;
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 & 0xFF));
    paramInt1 = i + 1;
    paramArrayOfByte[i] = ((byte)(paramInt2 >> 8 & 0xFF));
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 24 & 0xFF));
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeZone.getDefault());
    localGregorianCalendar.setTimeInMillis(30000L + paramLong);
    b(paramArrayOfByte, paramInt + 2, localGregorianCalendar.get(2) + 1);
    b(paramArrayOfByte, paramInt + 4, localGregorianCalendar.get(7) - 1);
    int j = localGregorianCalendar.get(8);
    int i = j;
    if (j < 0) {
      i = 5;
    }
    b(paramArrayOfByte, paramInt + 6, i);
    b(paramArrayOfByte, paramInt + 8, c(localGregorianCalendar));
    b(paramArrayOfByte, paramInt + 10, b(localGregorianCalendar));
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, bsy parambsy, int paramInt2, int paramInt3)
  {
    b(paramArrayOfByte, paramInt1 + 2, d);
    b(paramArrayOfByte, paramInt1 + 4, b - 1);
    if (c < 0) {}
    for (int i = 5;; i = c)
    {
      b(paramArrayOfByte, paramInt1 + 6, i);
      b(paramArrayOfByte, paramInt1 + 8, paramInt2);
      b(paramArrayOfByte, paramInt1 + 10, paramInt3);
      return;
    }
  }
  
  public static boolean a(ContentValues paramContentValues, String paramString)
  {
    paramContentValues = paramContentValues.getAsInteger(paramString);
    return (paramContentValues != null) && (paramContentValues.intValue() != 0);
  }
  
  private static boolean a(TimeZone paramTimeZone, GregorianCalendar[] paramArrayOfGregorianCalendar1, GregorianCalendar[] paramArrayOfGregorianCalendar2)
  {
    int j = paramArrayOfGregorianCalendar1.length;
    if (paramArrayOfGregorianCalendar2.length != j) {
      return false;
    }
    int i = 0;
    if (i < j)
    {
      GregorianCalendar localGregorianCalendar = new GregorianCalendar(paramTimeZone);
      localGregorianCalendar.set(e + i, 0, 1, 0, 0, 0);
      long l1 = localGregorianCalendar.getTimeInMillis();
      long l2 = 21600000L + (31536000000L + l1);
      boolean bool2 = paramTimeZone.inDaylightTime(new Date(l1));
      localGregorianCalendar = a(paramTimeZone, l1, l2, bool2);
      if (localGregorianCalendar == null) {
        return false;
      }
      if (bool2)
      {
        paramArrayOfGregorianCalendar2[i] = localGregorianCalendar;
        if (bool2) {
          break label144;
        }
      }
      label144:
      for (boolean bool1 = true;; bool1 = false)
      {
        localGregorianCalendar = a(paramTimeZone, l1, l2, bool1);
        if (localGregorianCalendar != null) {
          break label150;
        }
        return false;
        paramArrayOfGregorianCalendar1[i] = localGregorianCalendar;
        break;
      }
      label150:
      if (bool2) {
        paramArrayOfGregorianCalendar1[i] = localGregorianCalendar;
      }
      for (;;)
      {
        i += 1;
        break;
        paramArrayOfGregorianCalendar2[i] = localGregorianCalendar;
      }
    }
    return true;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 5: 
      return 3;
    case 3: 
      return 1;
    case 2: 
      return 4;
    }
    return 2;
  }
  
  private static int b(GregorianCalendar paramGregorianCalendar)
  {
    int j = paramGregorianCalendar.get(12);
    int i = j;
    if (j == 59) {
      i = 0;
    }
    return i;
  }
  
  private static int b(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | i & 0xFF;
  }
  
  public static long b(long paramLong, TimeZone paramTimeZone)
  {
    return a(paramLong, h, paramTimeZone);
  }
  
  public static String b(String paramString)
  {
    String str1 = String.valueOf(paramString.substring(0, 4));
    String str2 = String.valueOf(paramString.substring(5, 7));
    String str3 = String.valueOf(paramString.substring(8, 13));
    String str4 = String.valueOf(paramString.substring(14, 16));
    paramString = String.valueOf(paramString.substring(17, 19));
    return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(paramString).length() + str1 + str2 + str3 + str4 + paramString + "Z";
  }
  
  private static String b(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    if (i < 0) {
      return null;
    }
    int m = paramString1.length();
    int k = paramString2.length() + i;
    for (int j = k;; j = i)
    {
      i = j + 1;
      if ((paramString1.charAt(j) == ';') || (i == m))
      {
        j = i;
        if (i == m) {
          j = i + 1;
        }
        return paramString1.substring(k, j - 1);
      }
    }
  }
  
  private static void b(String paramString, bpi parambpi)
  {
    int i = paramString.charAt(0);
    if (i == 45) {
      i = 5;
    }
    for (paramString = paramString.substring(2);; paramString = paramString.substring(1))
    {
      parambpi.b(290, Integer.toString(i));
      parambpi.b(288, d(paramString));
      return;
      i -= 48;
    }
  }
  
  private static void b(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    a(paramStringBuilder, paramInt1, 0);
    paramStringBuilder.append(";BYSETPOS=");
    if (paramInt2 == 5) {}
    for (Object localObject = "-1";; localObject = Integer.valueOf(paramInt2))
    {
      paramStringBuilder.append(localObject);
      return;
    }
  }
  
  private static void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 8 & 0xFF));
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 0: 
      return 2;
    }
    return 0;
  }
  
  private static int c(GregorianCalendar paramGregorianCalendar)
  {
    int j = paramGregorianCalendar.get(11) + 1;
    int i = j;
    if (j == 24) {
      i = 0;
    }
    return i;
  }
  
  private static bsz c(byte[] paramArrayOfByte, int paramInt)
  {
    bsz localbsz = new bsz();
    a = Integer.toString(b(paramArrayOfByte, paramInt + 0));
    int i = b(paramArrayOfByte, paramInt + 2);
    if (i == 0) {
      return null;
    }
    b = (i - 1);
    c = (b(paramArrayOfByte, paramInt + 4) + 1);
    i = b(paramArrayOfByte, paramInt + 6);
    if (i == 5) {}
    for (d = -1;; d = i)
    {
      i = b(paramArrayOfByte, paramInt + 8);
      f = i;
      paramInt = b(paramArrayOfByte, paramInt + 10);
      g = paramInt;
      e = (i * 3600000 + paramInt * 60000);
      return localbsz;
    }
  }
  
  private static String c(long paramLong, TimeZone paramTimeZone)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramTimeZone = new GregorianCalendar(paramTimeZone);
    paramTimeZone.setTimeInMillis(paramLong);
    localStringBuilder.append(paramTimeZone.get(1));
    localStringBuilder.append(f(paramTimeZone.get(2) + 1));
    localStringBuilder.append(f(paramTimeZone.get(5)));
    localStringBuilder.append('T');
    localStringBuilder.append(f(c(paramTimeZone)));
    localStringBuilder.append(f(b(paramTimeZone)));
    localStringBuilder.append(f(0));
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    int i = 0;
    Object localObject = new StringBuilder();
    try
    {
      byte[] arrayOfByte = Base64.decode(paramString, 0);
      String str = new String(arrayOfByte);
      int j = str.indexOf("vCal-Uid");
      if (j > 0) {
        return str.substring(j + 12, str.length() - 1);
      }
      j = arrayOfByte.length;
      while (i < j)
      {
        bhn.a((StringBuilder)localObject, arrayOfByte[i]);
        i += 1;
      }
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (RuntimeException localRuntimeException) {}
    return paramString;
  }
  
  public static int d(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 2;
    case 2: 
      return 0;
    }
    return 1;
  }
  
  private static String d(String paramString)
  {
    int k = 0;
    String[] arrayOfString = c;
    int n = arrayOfString.length;
    int j = 1;
    int i = 0;
    while (i < n)
    {
      int m = k;
      if (paramString.contains(arrayOfString[i])) {
        m = k | j;
      }
      j <<= 1;
      i += 1;
      k = m;
    }
    return Integer.toString(k);
  }
  
  private static String e(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt / 60;
    if (i < 0)
    {
      localStringBuilder.append('-');
      i = 0 - i;
    }
    for (;;)
    {
      paramInt %= 60;
      if (i < 10) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(i);
      if (paramInt < 10) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
      localStringBuilder.append('+');
    }
  }
  
  private static String f(int paramInt)
  {
    if (paramInt <= 12) {
      return d[paramInt];
    }
    return Integer.toString(paramInt);
  }
}

/* Location:
 * Qualified Name:     bsx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */