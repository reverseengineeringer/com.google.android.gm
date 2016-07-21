import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.Entity.NamedContentValues;
import android.content.EntityIterator;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.provider.CalendarContract.Attendees;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.EventsEntity;
import android.provider.CalendarContract.ExtendedProperties;
import android.provider.CalendarContract.Reminders;
import android.text.TextUtils;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.UUID;

public final class bqu
  extends bqv
{
  static final String[] a = { "original_id", "_id" };
  private static final String[] b = { "_id" };
  private final android.accounts.Account c;
  private final long d;
  private final String e;
  private final ArrayList<Long> f;
  private final ArrayList<Long> g;
  private final ArrayList<beb> h;
  
  /* Error */
  public bqu(Context paramContext, com.android.emailcommon.provider.Account paramAccount, Mailbox paramMailbox)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 36	bqv:<init>	()V
    //   4: aload_0
    //   5: new 38	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 39	java/util/ArrayList:<init>	()V
    //   12: putfield 41	bqu:f	Ljava/util/ArrayList;
    //   15: aload_0
    //   16: new 38	java/util/ArrayList
    //   19: dup
    //   20: invokespecial 39	java/util/ArrayList:<init>	()V
    //   23: putfield 43	bqu:g	Ljava/util/ArrayList;
    //   26: aload_0
    //   27: new 38	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 39	java/util/ArrayList:<init>	()V
    //   34: putfield 45	bqu:h	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: aload_3
    //   39: getfield 49	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   42: putfield 51	bqu:e	Ljava/lang/String;
    //   45: getstatic 55	bnq:c	Ljava/lang/String;
    //   48: astore 8
    //   50: aload_0
    //   51: new 57	android/accounts/Account
    //   54: dup
    //   55: aload_2
    //   56: getfield 60	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   59: aload 8
    //   61: invokespecial 63	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: putfield 65	bqu:c	Landroid/accounts/Account;
    //   67: aload_1
    //   68: invokevirtual 71	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   71: astore 7
    //   73: aload 7
    //   75: getstatic 77	android/provider/CalendarContract$Calendars:CONTENT_URI	Landroid/net/Uri;
    //   78: getstatic 27	bqu:b	[Ljava/lang/String;
    //   81: ldc 79
    //   83: iconst_3
    //   84: anewarray 23	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: aload_2
    //   90: getfield 60	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload 8
    //   98: aastore
    //   99: dup
    //   100: iconst_2
    //   101: aload_3
    //   102: getfield 49	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   105: aastore
    //   106: aconst_null
    //   107: invokevirtual 85	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   110: astore 6
    //   112: aload 6
    //   114: ifnonnull +11 -> 125
    //   117: aload_0
    //   118: ldc2_w 86
    //   121: putfield 89	bqu:d	J
    //   124: return
    //   125: aload 6
    //   127: invokeinterface 95 1 0
    //   132: ifeq +23 -> 155
    //   135: aload_0
    //   136: aload 6
    //   138: iconst_0
    //   139: invokeinterface 99 2 0
    //   144: putfield 89	bqu:d	J
    //   147: aload 6
    //   149: invokeinterface 102 1 0
    //   154: return
    //   155: aload 7
    //   157: getstatic 77	android/provider/CalendarContract$Calendars:CONTENT_URI	Landroid/net/Uri;
    //   160: getstatic 27	bqu:b	[Ljava/lang/String;
    //   163: ldc 104
    //   165: iconst_2
    //   166: anewarray 23	java/lang/String
    //   169: dup
    //   170: iconst_0
    //   171: aload_2
    //   172: getfield 60	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload 8
    //   180: aastore
    //   181: aconst_null
    //   182: invokevirtual 85	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   185: astore 8
    //   187: aload 8
    //   189: ifnull +131 -> 320
    //   192: aload 8
    //   194: invokeinterface 95 1 0
    //   199: ifeq +113 -> 312
    //   202: aload 8
    //   204: iconst_0
    //   205: invokeinterface 99 2 0
    //   210: lstore 4
    //   212: new 106	android/content/ContentValues
    //   215: dup
    //   216: invokespecial 107	android/content/ContentValues:<init>	()V
    //   219: astore 9
    //   221: aload 9
    //   223: ldc 109
    //   225: aload_3
    //   226: getfield 49	com/android/emailcommon/provider/Mailbox:d	Ljava/lang/String;
    //   229: invokevirtual 112	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload 7
    //   234: getstatic 77	android/provider/CalendarContract$Calendars:CONTENT_URI	Landroid/net/Uri;
    //   237: aload_2
    //   238: invokestatic 115	bqu:a	(Landroid/net/Uri;Lcom/android/emailcommon/provider/Account;)Landroid/net/Uri;
    //   241: lload 4
    //   243: invokestatic 121	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   246: aload 9
    //   248: aconst_null
    //   249: aconst_null
    //   250: invokevirtual 125	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   253: pop
    //   254: aload 8
    //   256: invokeinterface 102 1 0
    //   261: lload 4
    //   263: lconst_0
    //   264: lcmp
    //   265: iflt +32 -> 297
    //   268: aload_0
    //   269: lload 4
    //   271: putfield 89	bqu:d	J
    //   274: goto -127 -> 147
    //   277: astore_1
    //   278: aload 6
    //   280: invokeinterface 102 1 0
    //   285: aload_1
    //   286: athrow
    //   287: astore_1
    //   288: aload 8
    //   290: invokeinterface 102 1 0
    //   295: aload_1
    //   296: athrow
    //   297: aload_0
    //   298: aload_1
    //   299: aload 7
    //   301: aload_2
    //   302: aload_3
    //   303: invokestatic 130	bsx:a	(Landroid/content/Context;Landroid/content/ContentResolver;Lcom/android/emailcommon/provider/Account;Lcom/android/emailcommon/provider/Mailbox;)J
    //   306: putfield 89	bqu:d	J
    //   309: goto -162 -> 147
    //   312: ldc2_w 86
    //   315: lstore 4
    //   317: goto -63 -> 254
    //   320: ldc2_w 86
    //   323: lstore 4
    //   325: goto -64 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	bqu
    //   0	328	1	paramContext	Context
    //   0	328	2	paramAccount	com.android.emailcommon.provider.Account
    //   0	328	3	paramMailbox	Mailbox
    //   210	114	4	l	long
    //   110	169	6	localCursor	Cursor
    //   71	229	7	localContentResolver	ContentResolver
    //   48	241	8	localObject	Object
    //   219	28	9	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   125	147	277	finally
    //   155	187	277	finally
    //   254	261	277	finally
    //   268	274	277	finally
    //   288	297	277	finally
    //   297	309	277	finally
    //   192	254	287	finally
  }
  
  private static int a(ContentValues paramContentValues, String paramString)
  {
    paramContentValues = paramContentValues.getAsInteger(paramString);
    if (paramContentValues == null) {
      return 0;
    }
    return paramContentValues.intValue();
  }
  
  private static Uri a(Uri paramUri, com.android.emailcommon.provider.Account paramAccount)
  {
    return a(bnq.c, paramUri, d);
  }
  
  private static Uri a(String paramString1, Uri paramUri, String paramString2)
  {
    return paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", paramString2).appendQueryParameter("account_type", paramString1).build();
  }
  
  private static String a(ContentValues paramContentValues)
  {
    paramContentValues = paramContentValues.getAsString("sync_data4");
    if (paramContentValues != null) {
      try
      {
        paramContentValues = Integer.toString(Integer.parseInt(paramContentValues) + 1);
        return paramContentValues;
      }
      catch (NumberFormatException paramContentValues) {}
    }
    return "0";
  }
  
  private final void a(Context paramContext, Entity paramEntity, com.android.emailcommon.provider.Account paramAccount, long paramLong, String paramString, Long paramLong1)
  {
    ContentValues localContentValues = paramEntity.getEntityValues();
    Integer localInteger = localContentValues.getAsInteger("selfAttendeeStatus");
    if ((localInteger == null) || ((localInteger.intValue() != 1) && (localInteger.intValue() != 4) && (localInteger.intValue() != 2))) {
      return;
    }
    Object localObject1 = null;
    Iterator localIterator = paramEntity.getSubValues().iterator();
    long l = -1L;
    Long localLong = null;
    paramEntity = null;
    label70:
    Object localObject2;
    String str;
    int i;
    if (localIterator.hasNext())
    {
      localObject2 = (Entity.NamedContentValues)localIterator.next();
      if (uri.equals(CalendarContract.ExtendedProperties.CONTENT_URI))
      {
        localObject2 = values;
        str = ((ContentValues)localObject2).getAsString("name");
        i = -1;
      }
      switch (str.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          label164:
          localObject2 = localObject1;
          localObject1 = paramEntity;
          paramEntity = (Entity)localObject2;
        }
        break;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramEntity;
      paramEntity = (Entity)localObject2;
      break label70;
      if (!str.equals("userAttendeeStatus")) {
        break label164;
      }
      i = 0;
      break label164;
      if (!str.equals("proposedStartTime")) {
        break label164;
      }
      i = 1;
      break label164;
      if (!str.equals("proposedEndTime")) {
        break label164;
      }
      i = 2;
      break label164;
      paramEntity = ((ContentValues)localObject2).getAsInteger("value");
      localObject2 = ((ContentValues)localObject2).getAsLong("_id");
      if ((localObject2 != null) && (((Long)localObject2).longValue() >= 0L))
      {
        l = ((Long)localObject2).longValue();
        break label70;
        localLong = ((ContentValues)localObject2).getAsLong("value");
        break label70;
        localObject2 = ((ContentValues)localObject2).getAsLong("value");
        localObject1 = paramEntity;
        paramEntity = (Entity)localObject2;
        continue;
        int j;
        if (!localInteger.equals(paramEntity))
        {
          j = 1;
          label347:
          if ((localLong == null) || (localLong.longValue() <= 0L) || (localObject1 == null) || (((Long)localObject1).longValue() <= 0L)) {
            break label561;
          }
          i = 1;
          label380:
          if ((j == 0) && (i == 0)) {
            break;
          }
          int k = 0;
          i = k;
          switch (localInteger.intValue())
          {
          default: 
            i = k;
          case 3: 
            label436:
            if (j != 0)
            {
              paramEntity = new ContentValues(1);
              paramEntity.put("value", String.valueOf(localInteger));
              localObject1 = paramContext.getContentResolver();
              if (l < 0L) {
                break label590;
              }
              ((ContentResolver)localObject1).update(a(ContentUris.withAppendedId(CalendarContract.ExtendedProperties.CONTENT_URI, l), paramAccount), paramEntity, null, null);
            }
            break;
          }
        }
        for (;;)
        {
          bqp.a(paramContext, paramAccount, localContentValues, e, paramLong1);
          paramContext = bsx.a(paramContext, paramLong, i, paramString, paramAccount);
          if (paramContext == null) {
            break;
          }
          cvm.b("Exchange", "Queuing invitation reply to %s", new Object[] { Y });
          h.add(paramContext);
          return;
          j = 0;
          break label347;
          label561:
          i = 0;
          break label380;
          i = 64;
          break label436;
          i = 128;
          break label436;
          i = 256;
          break label436;
          label590:
          paramEntity.put("event_id", Long.valueOf(paramLong));
          paramEntity.put("name", "userAttendeeStatus");
          ((ContentResolver)localObject1).insert(a(CalendarContract.ExtendedProperties.CONTENT_URI, paramAccount), paramEntity);
        }
      }
      localObject2 = paramEntity;
      paramEntity = (Entity)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private static void a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    try
    {
      if (paramContext.getPackageManager().checkPermission("android.permission.READ_CALENDAR", paramContext.getPackageName()) == 0)
      {
        bus.a("calendar_wipe", "enabled");
        paramContext.getContentResolver().delete(paramUri, paramString, paramArrayOfString);
        return;
      }
      cvm.d("Exchange", "unable to wipe calendar, permission disabled", new Object[0]);
      bus.a("calendar_wipe", "disabled");
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      cvm.e("Exchange", "CalendarProvider disabled; unable to wipe account.", new Object[0]);
    }
  }
  
  private final void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount, double paramDouble, bpi parambpi)
  {
    ContentResolver localContentResolver1 = paramContext.getContentResolver();
    String str = Long.toString(d);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = str;
    int j;
    ContentResolver localContentResolver2;
    ArrayList localArrayList;
    Object localObject;
    long l;
    int i;
    label212:
    label218:
    Cursor localCursor;
    if (paramDouble < 16.0D)
    {
      j = 1;
      localContentResolver2 = paramContext.getContentResolver();
      localArrayList = new ArrayList();
      localObject = localContentResolver2.query(CalendarContract.Events.CONTENT_URI, a, "dirty=1 AND original_id NOTNULL AND calendar_id=?", arrayOfString, null);
      if (localObject == null) {}
    }
    else
    {
      do
      {
        for (;;)
        {
          try
          {
            ContentValues localContentValues = new ContentValues(1);
            if (j != 0) {
              localContentValues.put("sync_data8", "1");
            }
            if (!((Cursor)localObject).moveToNext()) {
              break label298;
            }
            l = ((Cursor)localObject).getLong(0);
            i = 0;
            if (j == 0) {
              break label218;
            }
            if (localContentResolver2.update(a(CalendarContract.Events.CONTENT_URI, paramAccount), localContentValues, "_id=? AND original_sync_id ISNULL AND calendar_id=?", new String[] { Long.toString(l), str }) != 0) {
              break label212;
            }
            i = 1;
            if (i == 0) {
              continue;
            }
            localArrayList.add(Long.valueOf(((Cursor)localObject).getLong(1)));
            continue;
            j = 0;
          }
          finally
          {
            ((Cursor)localObject).close();
          }
          break;
          i = 0;
        }
        localCursor = localContentResolver2.query(a(CalendarContract.Events.CONTENT_URI, paramAccount), a, "_id=? AND original_sync_id ISNULL AND calendar_id=?", new String[] { Long.toString(l), str }, null);
      } while (localCursor == null);
    }
    for (;;)
    {
      label298:
      try
      {
        i = localCursor.getCount();
        if (i != 0) {
          break label524;
        }
        i = 1;
        localCursor.close();
      }
      finally
      {
        localCursor.close();
      }
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        l = ((Long)((Iterator)localObject).next()).longValue();
        cvm.b("Exchange", "Deleted orphaned exception: %d", new Object[] { Long.valueOf(l) });
        localContentResolver2.delete(a(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, l), paramAccount), null, null);
      }
      if (paramDouble < 16.0D) {}
      for (localObject = localContentResolver1.query(a(CalendarContract.Events.CONTENT_URI, paramAccount), null, "(dirty=1 OR sync_data8= 1) AND original_id ISNULL AND calendar_id=?", arrayOfString, null); localObject == null; localObject = localContentResolver1.query(a(CalendarContract.Events.CONTENT_URI, paramAccount), null, "(dirty=1 OR sync_data8= 1) AND calendar_id=?", arrayOfString, null)) {
        return;
      }
      localObject = CalendarContract.EventsEntity.newEntityIterator((Cursor)localObject, localContentResolver1);
      boolean bool = true;
      try
      {
        while (((EntityIterator)localObject).hasNext()) {
          if (a(parambpi, paramContext, paramAccount, (Entity)((EntityIterator)localObject).next(), str, bool, paramDouble)) {
            bool = false;
          }
        }
        if (!bool) {
          parambpi.b();
        }
        return;
      }
      finally
      {
        ((EntityIterator)localObject).close();
      }
      label524:
      i = 0;
    }
  }
  
  private final void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount, Entity paramEntity, ContentValues paramContentValues, boolean paramBoolean, long paramLong, String paramString, double paramDouble)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    String str1 = null;
    long l = -1L;
    Object localObject1 = paramEntity.getSubValues().iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Entity.NamedContentValues)((Iterator)localObject1).next();
      String str2;
      int i;
      if (uri.equals(CalendarContract.ExtendedProperties.CONTENT_URI))
      {
        localObject2 = values;
        str2 = ((ContentValues)localObject2).getAsString("name");
        i = -1;
        switch (str2.hashCode())
        {
        default: 
          label100:
          switch (i)
          {
          }
          break;
        }
      }
      for (;;)
      {
        break;
        if (!str2.equals("attendees")) {
          break label100;
        }
        i = 0;
        break label100;
        str1 = ((ContentValues)localObject2).getAsString("value");
        l = ((ContentValues)localObject2).getAsLong("_id").longValue();
      }
    }
    if ((paramBoolean) && (a(paramContentValues, "dirty") == 1))
    {
      if (paramDouble < 16.0D) {}
      for (paramContentValues = bsx.a(paramContext, paramLong, 16, paramString, paramAccount);; paramContentValues = null)
      {
        if (paramContentValues != null)
        {
          cvm.b("Exchange", "Queueing invitation to %s", new Object[] { Y });
          h.add(paramContentValues);
        }
        paramContentValues = new ArrayList();
        if (str1 == null) {
          break;
        }
        localObject1 = new StringTokenizer(str1, "\\");
        while (((StringTokenizer)localObject1).hasMoreTokens()) {
          paramContentValues.add(((StringTokenizer)localObject1).nextToken());
        }
      }
      localObject1 = new StringBuilder();
      paramEntity = paramEntity.getSubValues().iterator();
      while (paramEntity.hasNext())
      {
        localObject2 = (Entity.NamedContentValues)paramEntity.next();
        if (uri.equals(CalendarContract.Attendees.CONTENT_URI))
        {
          localObject2 = values.getAsString("attendeeEmail");
          paramContentValues.remove(localObject2);
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("\\");
        }
      }
      paramEntity = new ContentValues();
      paramEntity.put("value", ((StringBuilder)localObject1).toString());
      if (str1 != null) {
        localContentResolver.update(a(ContentUris.withAppendedId(CalendarContract.ExtendedProperties.CONTENT_URI, l), paramAccount), paramEntity, null, null);
      }
      for (;;)
      {
        paramEntity = paramContentValues.iterator();
        while (paramEntity.hasNext())
        {
          paramContentValues = bsx.a(paramContext, paramLong, 32, paramString, paramAccount, (String)paramEntity.next());
          if (paramContentValues != null)
          {
            cvm.b("Exchange", "Queueing cancellation to removed attendee %s", new Object[] { Y });
            h.add(paramContentValues);
          }
        }
        paramEntity.put("name", "attendees");
        paramEntity.put("event_id", Long.valueOf(paramLong));
        localContentResolver.insert(a(CalendarContract.ExtendedProperties.CONTENT_URI, paramAccount), paramEntity);
      }
    }
    if (!paramBoolean) {
      a(paramContext, paramEntity, paramAccount, paramLong, paramString, null);
    }
  }
  
  private final void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount, Entity paramEntity, String paramString)
  {
    paramContext = bsx.a(paramContext, paramEntity, 128, paramString, paramAccount);
    if (paramContext != null)
    {
      cvm.b("Exchange", "Queueing declined response to %s", new Object[] { Y });
      h.add(paramContext);
    }
  }
  
  private static void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount, Entity paramEntity, String paramString, double paramDouble, bpi parambpi)
  {
    paramContext = paramContext.getContentResolver();
    ContentValues localContentValues = paramEntity.getEntityValues();
    int j;
    boolean bool1;
    boolean bool2;
    Object localObject2;
    Object localObject1;
    int i;
    label83:
    int k;
    label113:
    long l1;
    label200:
    label287:
    Object localObject3;
    label401:
    label420:
    long l4;
    if (paramString == null)
    {
      j = 1;
      bool1 = localContentValues.containsKey("_sync_id");
      bool2 = bsx.a(localContentValues, "allDay");
      localObject2 = TimeZone.getDefault();
      if ((j != 0) && (paramDouble < 16.0D))
      {
        localObject1 = localContentValues.getAsInteger("deleted");
        if ((localObject1 == null) || (((Integer)localObject1).intValue() != 1)) {
          break label893;
        }
        i = 1;
        localObject1 = localContentValues.getAsInteger("eventStatus");
        if ((localObject1 == null) || (!((Integer)localObject1).equals(Integer.valueOf(2)))) {
          break label899;
        }
        k = 1;
        if ((i == 0) && (k == 0)) {
          break label905;
        }
        parambpi.b(277, "1");
        if ((i != 0) && (k == 0))
        {
          l1 = localContentValues.getAsLong("_id").longValue();
          localObject1 = new ContentValues(1);
          ((ContentValues)localObject1).put("eventStatus", Integer.valueOf(2));
          paramContext.update(a(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, l1), paramAccount), (ContentValues)localObject1, null, null);
        }
        localObject1 = localContentValues.getAsLong("originalInstanceTime");
        if (localObject1 != null)
        {
          paramContext = (Context)localObject1;
          if (bsx.a(localContentValues, "originalAllDay")) {
            paramContext = Long.valueOf(bsx.b(((Long)localObject1).longValue(), (TimeZone)localObject2));
          }
          parambpi.b(278, bsx.a(paramContext.longValue()));
        }
      }
      if ((j == 0) && ((paramDouble < 16.0D) || (!bool2)))
      {
        if (!bool2) {
          break label919;
        }
        paramContext = "sync_data1";
        localObject1 = localContentValues.getAsString(paramContext);
        paramContext = (Context)localObject1;
        if (localObject1 == null) {
          paramContext = ((TimeZone)localObject2).getID();
        }
        localObject3 = TimeZone.getTimeZone(paramContext);
        localObject1 = (String)bsx.a.get(localObject3);
        if (localObject1 == null) {
          break label926;
        }
        paramContext = (Context)localObject1;
        if (bnq.b)
        {
          paramContext = String.valueOf(((TimeZone)localObject3).getDisplayName());
          cvm.b("Exchange", String.valueOf(paramContext).length() + 31 + "TZI string for " + paramContext + " found in cache.", new Object[0]);
          paramContext = (Context)localObject1;
        }
        parambpi.b(261, paramContext);
      }
      if (!bool2) {
        break label945;
      }
      paramContext = "1";
      parambpi.b(262, paramContext);
      l4 = localContentValues.getAsLong("dtstart").longValue();
      if (!localContentValues.containsKey("dtend")) {
        break label951;
      }
      l1 = localContentValues.getAsLong("dtend").longValue();
    }
    for (;;)
    {
      long l3 = l1;
      long l2 = l4;
      if (bool2)
      {
        l3 = l1;
        l2 = l4;
        if (paramDouble < 16.0D)
        {
          l2 = bsx.b(l4, (TimeZone)localObject2);
          l3 = bsx.b(l1, (TimeZone)localObject2);
        }
      }
      parambpi.b(295, bsx.a(l2));
      parambpi.b(274, bsx.a(l3));
      if (paramDouble < 16.0D) {
        parambpi.b(273, bsx.a(System.currentTimeMillis()));
      }
      localObject1 = localContentValues.getAsString("eventLocation");
      if (paramDouble < 16.0D)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramContext = (Context)localObject1;
          if (paramDouble < 12.0D) {
            paramContext = bhn.c((String)localObject1);
          }
          parambpi.b(279, paramContext);
        }
        label622:
        parambpi.a(localContentValues, "title", 294);
        if (paramDouble < 12.0D) {
          break label1044;
        }
        parambpi.a(1098);
        parambpi.b(1094, "1");
        parambpi.a(localContentValues, "description", 1099);
        parambpi.b();
        label684:
        if (j == 0)
        {
          if ((paramDouble < 16.0D) && ((paramDouble >= 12.0D) || (!bool1))) {
            parambpi.a(localContentValues, "organizer", 281);
          }
          paramContext = localContentValues.getAsString("rrule");
          if (paramContext != null) {
            bsx.a(paramContext, l2, (TimeZone)localObject2, parambpi);
          }
        }
        localObject1 = paramEntity.getSubValues();
        localObject2 = ((ArrayList)localObject1).iterator();
        i = -1;
        for (;;)
        {
          label764:
          if (((Iterator)localObject2).hasNext())
          {
            paramEntity = (Entity.NamedContentValues)((Iterator)localObject2).next();
            paramContext = uri;
            paramEntity = values;
            if (paramContext.equals(CalendarContract.ExtendedProperties.CONTENT_URI))
            {
              paramContext = paramEntity.getAsString("name");
              paramEntity = paramEntity.getAsString("value");
              if ((TextUtils.isEmpty(paramEntity)) || (!paramContext.equals("categories"))) {
                continue;
              }
              paramContext = new StringTokenizer(paramEntity, "\\");
              if (paramContext.countTokens() <= 0) {
                continue;
              }
              parambpi.a(270);
              for (;;)
              {
                if (paramContext.hasMoreTokens())
                {
                  parambpi.b(271, paramContext.nextToken());
                  continue;
                  j = 0;
                  break;
                  label893:
                  i = 0;
                  break label83;
                  label899:
                  k = 0;
                  break label113;
                  label905:
                  parambpi.b(277, "0");
                  break label200;
                  label919:
                  paramContext = "eventTimezone";
                  break label287;
                  label926:
                  paramContext = bsx.a((TimeZone)localObject3);
                  bsx.a.put(localObject3, paramContext);
                  break label401;
                  label945:
                  paramContext = "0";
                  break label420;
                  label951:
                  l2 = 3600000L;
                  l1 = l2;
                  if (localContentValues.containsKey("duration")) {
                    paramContext = new anu();
                  }
                }
              }
            }
          }
        }
      }
      try
      {
        paramContext.a(localContentValues.getAsString("duration"));
        l1 = paramContext.a();
        l1 += l4;
        continue;
        parambpi.a(1120);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          parambpi.b(1104, (String)localObject1);
        }
        parambpi.b();
        break label622;
        label1044:
        parambpi.a(localContentValues, "description", 267);
        break label684;
        parambpi.b();
        break label764;
        if (paramContext.equals(CalendarContract.Reminders.CONTENT_URI))
        {
          paramEntity = paramEntity.getAsInteger("minutes");
          if (paramEntity != null)
          {
            paramContext = paramEntity;
            if (paramEntity.intValue() < 0) {
              paramContext = Integer.valueOf(30);
            }
            if (paramContext.intValue() > i)
            {
              i = paramContext.intValue();
              break label764;
              if (i >= 0) {
                parambpi.b(292, Integer.toString(i));
              }
              if (paramString != null)
              {
                if (paramDouble < 16.0D) {
                  parambpi.b(296, paramString);
                }
              }
              else
              {
                localObject3 = ((ArrayList)localObject1).iterator();
                paramEntity = null;
                i = 0;
                paramContext = null;
              }
              for (;;)
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break label1416;
                }
                localObject1 = (Entity.NamedContentValues)((Iterator)localObject3).next();
                paramString = uri;
                localObject1 = values;
                j = i;
                if (paramString.equals(CalendarContract.Attendees.CONTENT_URI))
                {
                  localObject2 = ((ContentValues)localObject1).getAsInteger("attendeeRelationship");
                  paramString = ((ContentValues)localObject1).getAsString("attendeeEmail");
                  j = i;
                  if (localObject2 != null)
                  {
                    j = i;
                    if (!TextUtils.isEmpty(paramString))
                    {
                      if (((Integer)localObject2).intValue() == 2)
                      {
                        paramEntity = ((ContentValues)localObject1).getAsString("attendeeName");
                        paramContext = paramString;
                        continue;
                        if (j != 0) {
                          break;
                        }
                        parambpi.b(316, paramString);
                        break;
                      }
                      j = i;
                      if (i == 0)
                      {
                        parambpi.a(263);
                        j = 1;
                      }
                      parambpi.a(264);
                      localObject2 = ((ContentValues)localObject1).getAsString("attendeeName");
                      localObject1 = localObject2;
                      if (localObject2 == null) {
                        localObject1 = paramString;
                      }
                      parambpi.b(266, (String)localObject1);
                      parambpi.b(265, paramString);
                      if (paramDouble >= 12.0D) {
                        parambpi.b(298, "1");
                      }
                      parambpi.b();
                    }
                  }
                }
                i = j;
              }
              label1416:
              if (i != 0) {
                parambpi.b();
              }
              parambpi.b(269, Integer.toString(bsx.c(localContentValues.getAsInteger("availability").intValue())));
              paramString = paramContext;
              if (paramContext == null)
              {
                paramString = paramContext;
                if (localContentValues.containsKey("organizer")) {
                  paramString = localContentValues.getAsString("organizer");
                }
              }
              if (d.equalsIgnoreCase(paramString)) {
                if (i != 0)
                {
                  paramContext = "1";
                  parambpi.b(280, paramContext);
                  label1511:
                  if ((paramEntity != null) && (paramDouble < 16.0D) && ((paramDouble >= 12.0D) || (!bool1))) {
                    parambpi.b(282, paramEntity);
                  }
                  paramContext = localContentValues.getAsInteger("accessLevel");
                  if (paramContext == null) {
                    break label1659;
                  }
                  switch (paramContext.intValue())
                  {
                  default: 
                    i = 0;
                  }
                }
              }
              for (;;)
              {
                parambpi.b(293, Integer.toString(i));
                return;
                paramContext = "0";
                break;
                parambpi.b(280, "3");
                break label1511;
                i = 0;
                continue;
                i = 1;
                continue;
                i = 2;
                continue;
                i = 3;
              }
              label1659:
              parambpi.b(293, "1");
              return;
            }
          }
        }
      }
      catch (ant paramContext)
      {
        for (;;)
        {
          l1 = l2;
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, a(bnq.c, CalendarContract.Calendars.CONTENT_URI, paramString), null, null);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, a(bnq.c, CalendarContract.Calendars.CONTENT_URI, paramString1), "_sync_id=?", new String[] { paramString2 });
  }
  
  private final void a(bpi parambpi, Context paramContext, com.android.emailcommon.provider.Account paramAccount, Entity paramEntity, ContentValues paramContentValues, String paramString1, String paramString2, String paramString3, boolean paramBoolean, double paramDouble)
  {
    if (paramDouble >= 16.0D) {
      cvm.f("Exchange", "We should not use exceptions tag under CHANGE command in EAS 16", new Object[0]);
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = paramContext.getContentResolver();
      paramString1 = ((ContentResolver)localObject1).query(a(CalendarContract.Events.CONTENT_URI, paramAccount), null, "original_sync_id=? AND calendar_id=?", new String[] { paramString1, paramString3 }, null);
    } while (paramString1 == null);
    paramString1 = CalendarContract.EventsEntity.newEntityIterator(paramString1, (ContentResolver)localObject1);
    int i = 1;
    label80:
    if (paramString1.hasNext())
    {
      paramString3 = (Entity)paramString1.next();
      if (i == 0) {
        break label616;
      }
      parambpi.a(276);
      i = 0;
    }
    label566:
    label616:
    for (;;)
    {
      parambpi.a(275);
      a(paramContext, paramAccount, paramString3, null, paramDouble, parambpi);
      localObject1 = paramString3.getEntityValues();
      long l = ((ContentValues)localObject1).getAsLong("_id").longValue();
      if (a((ContentValues)localObject1, "dirty") == 1)
      {
        int k;
        if ((a((ContentValues)localObject1, "deleted") == 1) || (a((ContentValues)localObject1, "eventStatus") == 2))
        {
          k = 32;
          j = k;
          if (!paramBoolean)
          {
            ((ContentValues)localObject1).put("organizer", paramContentValues.getAsString("organizer"));
            a(paramContext, paramAccount, paramString3, paramString2);
          }
        }
        HashSet localHashSet;
        Entity.NamedContentValues localNamedContentValues;
        for (int j = k;; j = 16)
        {
          g.add(Long.valueOf(l));
          ((ContentValues)localObject1).put("sync_data4", paramContentValues.getAsString("sync_data4"));
          if (paramContentValues.containsKey("eventLocation")) {
            ((ContentValues)localObject1).put("eventLocation", paramContentValues.getAsString("eventLocation"));
          }
          if (!paramBoolean) {
            break label566;
          }
          localObject2 = bsx.a(paramContext, paramString3, j, paramString2, paramAccount);
          if (localObject2 != null)
          {
            cvm.b("Exchange", "Queueing exception update to %s", new Object[] { Y });
            h.add(localObject2);
          }
          localObject2 = new Entity((ContentValues)localObject1);
          localHashSet = new HashSet();
          localIterator = paramString3.getSubValues().iterator();
          while (localIterator.hasNext())
          {
            localNamedContentValues = (Entity.NamedContentValues)localIterator.next();
            if (uri.equals(CalendarContract.Attendees.CONTENT_URI)) {
              localHashSet.add(values.getAsString("attendeeEmail"));
            }
          }
        }
        Iterator localIterator = paramEntity.getSubValues().iterator();
        while (localIterator.hasNext())
        {
          localNamedContentValues = (Entity.NamedContentValues)localIterator.next();
          if ((uri.equals(CalendarContract.Attendees.CONTENT_URI)) && (!localHashSet.contains(values.getAsString("attendeeEmail")))) {
            ((Entity)localObject2).addSubValue(uri, values);
          }
        }
        Object localObject2 = bsx.a(paramContext, (Entity)localObject2, 32, paramString2, paramAccount);
        if (localObject2 != null)
        {
          cvm.b("Exchange", "Queueing cancellation for removed attendees", new Object[0]);
          h.add(localObject2);
        }
      }
      parambpi.b();
      if (!paramBoolean) {
        a(paramContext, paramString3, paramAccount, l, paramString2, Long.valueOf(((ContentValues)localObject1).getAsLong("dtstart").longValue()));
      }
      break label80;
      if (i != 0) {
        break;
      }
      parambpi.b();
      return;
    }
  }
  
  private final boolean a(bpi parambpi, Context paramContext, com.android.emailcommon.provider.Account paramAccount, Entity paramEntity, String paramString, boolean paramBoolean, double paramDouble)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    ContentValues localContentValues = paramEntity.getEntityValues();
    Object localObject1 = paramEntity.getSubValues().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Entity.NamedContentValues)((Iterator)localObject1).next();
      if (uri.equals(CalendarContract.ExtendedProperties.CONTENT_URI))
      {
        localObject2 = values;
        if ((((ContentValues)localObject2).getAsString("name").equals("upsyncProhibited")) && ("1".equals(((ContentValues)localObject2).getAsString("value"))))
        {
          g.add(localContentValues.getAsLong("_id"));
          return false;
        }
      }
    }
    Object localObject2 = localContentValues.getAsString("organizer");
    if ((localObject2 == null) || (!localContentValues.containsKey("dtstart")) || ((!localContentValues.containsKey("duration")) && (!localContentValues.containsKey("dtend")))) {
      return false;
    }
    localObject1 = localContentValues.getAsString("_sync_id");
    int i;
    if (localContentValues.getAsLong("original_id") != null)
    {
      i = 1;
      if ((paramDouble < 16.0D) || (i == 0)) {
        break label561;
      }
      localObject3 = localContentValues.getAsLong("originalInstanceTime");
      if (localObject3 == null) {
        break label545;
      }
      localObject1 = localContentValues.getAsString("original_sync_id");
    }
    Object localObject4;
    boolean bool1;
    boolean bool2;
    long l;
    label545:
    label561:
    for (Object localObject3 = bsx.a(((Long)localObject3).longValue());; localObject3 = null)
    {
      if (paramBoolean)
      {
        parambpi.a(22);
        cvm.b("Exchange", "Sending Calendar changes to the server", new Object[0]);
      }
      paramBoolean = ((String)localObject2).equalsIgnoreCase(d);
      localObject4 = localContentValues.getAsString("sync_data2");
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        localObject2 = localObject4;
        if (i == 0) {
          localObject2 = UUID.randomUUID().toString();
        }
      }
      bool1 = Integer.valueOf(1).equals(localContentValues.getAsInteger("deleted"));
      bool2 = Integer.valueOf(2).equals(localContentValues.getAsInteger("eventStatus"));
      l = localContentValues.getAsLong("_id").longValue();
      if (localObject1 != null) {
        break label567;
      }
      cvm.b("Exchange", "Creating new event with clientId: %s", new Object[] { localObject2 });
      parambpi.a(7).b(12, (String)localObject2);
      localObject3 = new ContentValues(2);
      ((ContentValues)localObject3).put("sync_data2", (String)localObject2);
      ((ContentValues)localObject3).put("sync_data4", "0");
      localContentResolver.update(a(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, l), paramAccount), (ContentValues)localObject3, null, null);
      parambpi.a(29);
      a(paramContext, paramAccount, paramEntity, (String)localObject2, paramDouble, parambpi);
      if ((localObject1 != null) && (paramDouble < 16.0D)) {
        a(parambpi, paramContext, paramAccount, paramEntity, localContentValues, (String)localObject1, (String)localObject2, paramString, paramBoolean, paramDouble);
      }
      parambpi.b().b();
      g.add(Long.valueOf(l));
      a(paramContext, paramAccount, paramEntity, localContentValues, paramBoolean, l, (String)localObject2, paramDouble);
      return true;
      i = 0;
      break;
      cvm.b("Exchange", "Unable to compute instanceId but this should not happen.", new Object[0]);
      return false;
    }
    label567:
    if ((bool1) || ((localObject3 != null) && (bool2)))
    {
      if (localObject3 == null)
      {
        cvm.b("Exchange", "Deleting event with serverId: %s", new Object[] { localObject1 });
        parambpi.a(9).b(13, (String)localObject1).a(1133, (String)localObject3);
        parambpi.b();
        if (bool1)
        {
          if (localObject3 != null) {
            break label735;
          }
          f.add(Long.valueOf(l));
        }
        label656:
        if (!paramBoolean) {
          break label784;
        }
        parambpi = bsx.a(paramContext, l, 32, null, paramAccount);
        if (parambpi != null)
        {
          cvm.b("Exchange", "Queueing cancellation to %s", new Object[] { Y });
          h.add(parambpi);
        }
      }
      for (;;)
      {
        return true;
        cvm.b("Exchange", "Deleting exception with serverId: %s, instanceId: %s", new Object[] { localObject1, localObject3 });
        break;
        label735:
        if (bool2) {
          break label656;
        }
        parambpi = new ContentValues(1);
        parambpi.put("eventStatus", Integer.valueOf(2));
        localContentResolver.update(a(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, l), paramAccount), parambpi, null, null);
        break label656;
        label784:
        a(paramContext, paramAccount, paramEntity, (String)localObject2);
      }
    }
    if (localObject3 == null) {
      cvm.b("Exchange", "Upsync change to event with serverId: %s", new Object[] { localObject1 });
    }
    for (;;)
    {
      parambpi.a(8).b(13, (String)localObject1).a(1133, (String)localObject3);
      localObject3 = a(localContentValues);
      localObject4 = new ContentValues(1);
      ((ContentValues)localObject4).put("sync_data4", (String)localObject3);
      localContentResolver.update(a(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, l), paramAccount), (ContentValues)localObject4, null, null);
      localContentValues.put("sync_data4", (String)localObject3);
      break;
      cvm.b("Exchange", "Upsync change to exception with serverId: %s, instanceId: %s", new Object[] { localObject1, localObject3 });
    }
  }
  
  public final int a()
  {
    return 524288;
  }
  
  public final bnx a(Context paramContext, com.android.emailcommon.provider.Account paramAccount, Mailbox paramMailbox, InputStream paramInputStream)
  {
    return new bnz(paramContext, paramContext.getContentResolver(), paramInputStream, paramMailbox, paramAccount, c, d);
  }
  
  public final void a(Context paramContext, bpi parambpi, double paramDouble, com.android.emailcommon.provider.Account paramAccount, Mailbox paramMailbox, boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      paramInt *= 10;
      if (paramInt > 522) {
        throw new IOException("Max window size reached and still no data");
      }
      if (paramInt >= 512) {
        break label59;
      }
    }
    for (;;)
    {
      a(parambpi, "4", paramDouble, paramInt);
      a(paramContext, paramAccount, paramDouble, parambpi);
      return;
      label59:
      paramInt = 512;
    }
  }
  
  public final void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    Object localObject1 = paramContext.getContentResolver();
    Object localObject2;
    Object localObject3;
    long l1;
    if (!g.isEmpty())
    {
      localObject2 = new ContentValues(2);
      ((ContentValues)localObject2).put("dirty", Integer.valueOf(0));
      ((ContentValues)localObject2).put("sync_data8", "0");
      localObject3 = g.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        l1 = ((Long)((Iterator)localObject3).next()).longValue();
        ((ContentResolver)localObject1).update(a(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, l1), paramAccount), (ContentValues)localObject2, null, null);
      }
    }
    if (!f.isEmpty())
    {
      localObject2 = f.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        l1 = ((Long)((Iterator)localObject2).next()).longValue();
        ((ContentResolver)localObject1).delete(a(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, l1), paramAccount), null, null);
      }
    }
    localObject1 = h.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (beb)((Iterator)localObject1).next();
      long l2 = Mailbox.a(paramContext, D, 4);
      l1 = l2;
      if (l2 == -1L)
      {
        cvm.b("Exchange", "No outbox for account %d, creating it", new Object[] { Long.valueOf(D) });
        localObject3 = Mailbox.a(D, 4);
        ((Mailbox)localObject3).h(paramContext);
        l1 = D;
      }
      U = l1;
      V = D;
      ((beb)localObject2).h(paramContext);
      localObject2 = bdv.F;
      localObject3 = Mailbox.a(l1);
      ContentResolver.requestSync(c, (String)localObject2, (Bundle)localObject3);
      cvm.b("Exchange", "requestSync EasServerConnection requestSyncForMailbox %s, %s", new Object[] { c.toString(), ((Bundle)localObject3).toString() });
    }
    f.clear();
    g.clear();
    h.clear();
  }
}

/* Location:
 * Qualified Name:     bqu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */