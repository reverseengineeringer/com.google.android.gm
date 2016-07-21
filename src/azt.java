import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public final class azt
{
  static String a = cvl.a;
  private static final Object b = new Object();
  private final azj c;
  
  public azt(azj paramazj)
  {
    c = paramazj;
  }
  
  final String a(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT group_concat(_id), _id, min(timeStamp) FROM Message WHERE serverThreadId is NOT NULL GROUP BY accountKey, serverThreadId", null);
    StringBuffer localStringBuffer = new StringBuffer();
    while (localCursor != null) {
      try
      {
        if (localCursor.moveToNext())
        {
          String str1 = localCursor.getString(0);
          long l = localCursor.getLong(1);
          cvm.b(a, "threadingForExchange found %s belong to thread %d", new Object[] { str1, Long.valueOf(l) });
          localStringBuffer.append(str1).append(',');
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("threadId", Long.valueOf(l));
          String str2 = String.valueOf("_id IN (");
          String str3 = String.valueOf("threadId");
          String str4 = String.valueOf("threadId");
          str1 = String.valueOf(str2).length() + 44 + String.valueOf(str1).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + str2 + str1 + ") AND (" + str3 + " IS NULL OR " + str4 + " != " + l + ")";
          int i = paramSQLiteDatabase.update("Message", localContentValues, str1, null);
          if (i > 0) {
            c.a(l);
          }
          cvm.b(a, "threadingForExchange SQL: %s updates %d messages' threadId", new Object[] { str1, Integer.valueOf(i) });
        }
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    cvm.b(a, "threadingForExchange updates these messages: %s", new Object[] { localStringBuffer.toString() });
    return localStringBuffer.toString();
  }
  
  public final void a(Context paramContext, ContentValues paramContentValues, long paramLong, SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject6 = paramContentValues.getAsString("androidMessageId");
    Object localObject5 = paramContentValues.getAsString("messageId");
    Object localObject4 = paramContext.getContentResolver();
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (localObject6 != null) {
      localObject1 = localObject3;
    }
    int i;
    long l1;
    try
    {
      if (!((String)localObject6).equals(localObject5))
      {
        localObject1 = localObject3;
        localObject3 = paramSQLiteDatabase.rawQuery("SELECT _id,threadId FROM Message WHERE messageId=?", new String[] { localObject6 });
        localObject2 = localObject3;
        if (localObject3 != null)
        {
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (((Cursor)localObject3).moveToFirst())
          {
            localObject1 = localObject3;
            cvm.b(a, "Case 1: Found %d dup messages", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()) });
            localObject1 = localObject3;
            localObject2 = ContentUris.withAppendedId(beb.c, ((Cursor)localObject3).getLong(0));
            localObject1 = localObject3;
            i = paramContext.getContentResolver().delete((Uri)localObject2, null, null);
            localObject1 = localObject3;
            cvm.c(a, "Delete %d duplicate local message: %d", new Object[] { Integer.valueOf(i), Long.valueOf(((Cursor)localObject3).getLong(0)) });
            localObject1 = localObject3;
            paramContentValues.put("threadId", Long.valueOf(((Cursor)localObject3).getLong(1)));
            localObject2 = localObject3;
          }
        }
      }
      for (;;)
      {
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
        l1 = SystemClock.elapsedRealtime();
        if (paramContentValues.getAsString("serverThreadId") == null) {
          break;
        }
        localObject1 = new StringTokenizer(a(paramSQLiteDatabase));
        do
        {
          if (!((StringTokenizer)localObject1).hasMoreTokens()) {
            break;
          }
        } while (!((StringTokenizer)localObject1).nextToken().equals(String.valueOf(paramLong)));
        return;
        if (localObject5 != null)
        {
          localObject1 = localObject3;
          localObject3 = paramSQLiteDatabase.rawQuery("SELECT _id FROM Message WHERE androidMessageId=? AND androidMessageId!=messageId", new String[] { localObject5 });
          localObject2 = localObject3;
          if (localObject3 != null)
          {
            localObject2 = localObject3;
            localObject1 = localObject3;
            if (((Cursor)localObject3).moveToNext())
            {
              localObject1 = localObject3;
              ((ContentResolver)localObject4).delete(ContentUris.withAppendedId(beb.c, paramLong), null, null);
              localObject1 = localObject3;
              cvm.b(a, "Case 2: Found %d dup messages", new Object[] { Integer.valueOf(((Cursor)localObject3).getCount()) });
              localObject2 = localObject3;
            }
          }
        }
      }
      localObject1 = paramContentValues.getAsString("mailReferences");
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
    localObject6 = new HashSet();
    localObject2 = paramContentValues.getAsString("inReplyTo");
    if (localObject2 != null) {
      ((Set)localObject6).add(localObject2);
    }
    if (localObject1 != null)
    {
      localObject3 = new StringTokenizer((String)localObject1, ",\n\r ");
      while (((StringTokenizer)localObject3).hasMoreTokens()) {
        ((Set)localObject6).add(((StringTokenizer)localObject3).nextToken());
      }
    }
    localObject3 = paramContentValues.getAsString("messageId");
    if ((localObject3 == null) && (((Set)localObject6).isEmpty()))
    {
      paramContext = beb.a(paramContext, paramLong);
      if (paramContext == null)
      {
        cvm.d(a, "message#%d not found in MessageThreader.doThreading", new Object[] { Long.valueOf(paramLong) });
        return;
      }
      if (T > 0L)
      {
        cvm.b(a, "message#%d w/o threading headers already has threadId set:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(T) });
        return;
      }
    }
    localObject4 = new HashSet();
    paramContext = paramContentValues.getAsLong("threadId");
    if ((paramContext == null) || (paramContext.longValue() == 0L)) {
      paramContext = Long.valueOf(paramLong);
    }
    for (;;)
    {
      ((Set)localObject4).add(paramContext);
      Object localObject7 = paramContentValues.getAsLong("accountKey");
      localObject5 = b;
      paramContentValues = paramContext;
      String str1;
      for (;;)
      {
        try
        {
          if (((Set)localObject6).isEmpty()) {
            break label872;
          }
          paramContentValues = paramContext;
          if (localObject7 == null) {
            break label872;
          }
          paramContentValues = new StringBuilder();
          paramContentValues.append("SELECT _id,threadId").append(" FROM Message WHERE accountKey").append('=').append(localObject7).append(" AND messageId IN (");
          i = 0;
          localObject6 = ((Set)localObject6).iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          str1 = (String)((Iterator)localObject6).next();
          if (i != 0)
          {
            paramContentValues.append(',');
            paramContentValues.append(DatabaseUtils.sqlEscapeString(str1));
          }
          else
          {
            i = 1;
          }
        }
        finally {}
      }
      paramContentValues.append(") ORDER BY timeStamp DESC");
      localObject6 = paramSQLiteDatabase.rawQuery(paramContentValues.toString(), null);
      paramContentValues = paramContext;
      long l2;
      for (;;)
      {
        paramContext = paramContentValues;
        if (localObject6 != null) {
          paramContext = paramContentValues;
        }
        try
        {
          if (((Cursor)localObject6).moveToNext())
          {
            l2 = ((Cursor)localObject6).getLong(0);
            long l3 = ((Cursor)localObject6).getInt(1);
            if (l3 > 0L) {
              paramContext = Long.valueOf(l3);
            }
          }
          else
          {
            paramContentValues = paramContext;
            if (localObject6 != null)
            {
              ((Cursor)localObject6).close();
              paramContentValues = paramContext;
            }
            label872:
            if ((localObject3 == null) || (localObject7 == null)) {
              break label1002;
            }
            paramContext = paramSQLiteDatabase.rawQuery("SELECT _id FROM Message WHERE accountKey=? AND threadId IN (SELECT threadId FROM Message WHERE inReplyTo=?)", new String[] { String.valueOf(localObject7), localObject3 });
          }
          for (;;)
          {
            if (paramContext == null) {
              break label992;
            }
            try
            {
              if (!paramContext.moveToNext()) {
                break label992;
              }
              ((Set)localObject4).add(Long.valueOf(paramContext.getLong(0)));
            }
            finally
            {
              if (paramContext != null) {
                paramContext.close();
              }
            }
          }
        }
        finally
        {
          if (localObject6 != null) {
            ((Cursor)localObject6).close();
          }
        }
      }
      label992:
      if (paramContext != null) {
        paramContext.close();
      }
      label1002:
      localObject6 = new ContentValues(1);
      ((ContentValues)localObject6).put("threadId", paramContentValues);
      if (((Set)localObject4).size() > 1)
      {
        paramContext = String.valueOf("_id");
        localObject7 = String.valueOf(TextUtils.join(",", (Iterable)localObject4));
      }
      for (paramContext = String.valueOf(paramContext).length() + 6 + String.valueOf(localObject7).length() + paramContext + " IN (" + (String)localObject7 + ")";; paramContext = String.valueOf(paramContext).length() + 23 + paramContext + " = " + paramLong)
      {
        paramContext = String.valueOf(paramContext);
        localObject7 = String.valueOf(" AND (threadId != ");
        str1 = String.valueOf(paramContentValues);
        String str2 = String.valueOf("threadId");
        i = paramSQLiteDatabase.update("Message", (ContentValues)localObject6, String.valueOf(paramContext).length() + 13 + String.valueOf(localObject7).length() + String.valueOf(str1).length() + String.valueOf(str2).length() + paramContext + (String)localObject7 + str1 + " OR " + str2 + " IS NULL)", null);
        if (i > 0) {
          c.a(paramContentValues.longValue());
        }
        l2 = SystemClock.elapsedRealtime();
        cvm.b(a, "Threading message#%d, msgid: %s, inReplyTo: %s, references: %s", new Object[] { Long.valueOf(paramLong), localObject3, localObject2, localObject1 });
        cvm.b(a, "total %dms spent on threading, thread size: %d, update count: %d", new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(((Set)localObject4).size()), Integer.valueOf(i) });
        return;
        paramContext = String.valueOf("_id");
      }
    }
  }
  
  public final void a(Handler paramHandler, Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    paramHandler.post(new azu(this, paramSQLiteDatabase, paramContext));
  }
}

/* Location:
 * Qualified Name:     azt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */