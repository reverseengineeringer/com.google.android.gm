import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.provider.CalendarContract.Attendees;
import android.provider.CalendarContract.ExtendedProperties;
import android.text.TextUtils;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.Mailbox;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bqq
  extends bqo
{
  private static final String[] m = { "serverId" };
  private final beb n;
  
  public bqq(Context paramContext, com.android.emailcommon.provider.Account paramAccount, beb parambeb, int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    super(paramContext, paramAccount, Integer.valueOf(paramInt), paramLong1, paramLong2, paramString, bhn.b(paramContext, ContentUris.withAppendedId(Mailbox.a, U), m, null, null), x, null);
    n = parambeb;
  }
  
  protected final int c(int paramInt)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      cvm.e("Exchange", "Bad response value: %d", new Object[] { Integer.valueOf(paramInt) });
      i = -1;
    case 1: 
      return i;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  protected final void j()
  {
    Object localObject1;
    int i;
    Object localObject3;
    Object localObject5;
    String str1;
    String str2;
    if (n.ac != null)
    {
      localObject1 = new bdl(n.ac);
      if (!"0".equals(((bdl)localObject1).a("RESPONSE")))
      {
        i = a;
        localObject2 = Address.d(((bdl)localObject1).a("ORGMAIL"));
        if (localObject2.length == 1)
        {
          localObject3 = 0a;
          localObject5 = ((bdl)localObject1).a("DTSTAMP");
          str1 = ((bdl)localObject1).a("DTSTART");
          str2 = ((bdl)localObject1).a("DTEND");
          if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            break label153;
          }
          cvm.d("Exchange", "blank dtStamp %s dtStart %s dtEnd %s", new Object[] { localObject5, str1, str2 });
        }
      }
    }
    return;
    label153:
    Object localObject4 = new ContentValues(6);
    Object localObject2 = new Entity((ContentValues)localObject4);
    ((ContentValues)localObject4).put("DTSTAMP", bsx.b((String)localObject5));
    try
    {
      ((ContentValues)localObject4).put("dtstart", Long.valueOf(bhn.b(str1)));
      ((ContentValues)localObject4).put("dtend", Long.valueOf(bhn.b(str2)));
      ((ContentValues)localObject4).put("eventLocation", ((bdl)localObject1).a("LOC"));
      ((ContentValues)localObject4).put("title", ((bdl)localObject1).a("TITLE"));
      ((ContentValues)localObject4).put("title", ((bdl)localObject1).a("TITLE"));
      ((ContentValues)localObject4).put("organizer", (String)localObject3);
      localObject4 = new ContentValues(2);
      ((ContentValues)localObject4).put("attendeeRelationship", Integer.valueOf(1));
      ((ContentValues)localObject4).put("attendeeEmail", g.d);
      ((Entity)localObject2).addSubValue(CalendarContract.Attendees.CONTENT_URI, (ContentValues)localObject4);
      localObject4 = new ContentValues(2);
      ((ContentValues)localObject4).put("attendeeRelationship", Integer.valueOf(2));
      ((ContentValues)localObject4).put("attendeeEmail", (String)localObject3);
      ((Entity)localObject2).addSubValue(CalendarContract.Attendees.CONTENT_URI, (ContentValues)localObject4);
      if ((b != null) && (c != null))
      {
        localObject3 = new HashMap();
        ((Map)localObject3).put("proposedStartTime", String.valueOf(b));
        ((Map)localObject3).put("proposedEndTime", String.valueOf(c));
        ((Map)localObject3).put("meetingRequestComment", d);
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          localObject5 = new ContentValues(2);
          ((ContentValues)localObject5).put("name", (String)((Map.Entry)localObject4).getKey());
          ((ContentValues)localObject5).put("value", (String)((Map.Entry)localObject4).getValue());
          ((Entity)localObject2).addSubValue(CalendarContract.ExtendedProperties.CONTENT_URI, (ContentValues)localObject5);
        }
      }
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        cvm.d("Exchange", "Parse error for DTSTART/DTEND tags.", new Object[] { localParseException });
      }
      if (d != null)
      {
        localObject3 = new ContentValues(2);
        ((ContentValues)localObject3).put("name", "meetingRequestComment");
        ((ContentValues)localObject3).put("value", d);
        ((Entity)localObject2).addSubValue(CalendarContract.ExtendedProperties.CONTENT_URI, (ContentValues)localObject3);
      }
      switch (i)
      {
      case 2: 
      default: 
        i = 256;
      }
    }
    for (;;)
    {
      localObject1 = bsx.a(f, (Entity)localObject2, i, ((bdl)localObject1).a("UID"), g);
      if (localObject1 == null) {
        break;
      }
      localObject2 = g;
      long l2 = Mailbox.a(f, D, 4);
      long l1 = l2;
      if (l2 == -1L)
      {
        cvm.b("Exchange", "No outbox for account %d, creating it", new Object[] { Long.valueOf(D) });
        localObject3 = Mailbox.a(D, 4);
        ((Mailbox)localObject3).h(f);
        l1 = D;
      }
      U = l1;
      V = D;
      ((beb)localObject1).h(f);
      a(new android.accounts.Account(d, bnq.c), l1);
      return;
      i = 64;
      continue;
      i = 128;
    }
  }
}

/* Location:
 * Qualified Name:     bqq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */