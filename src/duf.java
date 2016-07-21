import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class duf
{
  static final String a = cvl.a;
  static final String[] b = { "_id", "action", "message_messageId", "value1", "value2", "value3", "value4", "value5", "value6", "value7", "value8", "value9", "value10", "value11", "value12", "numAttempts", "nextTimeToAttempt", "delay" };
  static final String e;
  static final String f;
  public final SQLiteDatabase c;
  Context d;
  
  static
  {
    String str = String.valueOf(TextUtils.join("', '", new String[] { "messageLabelAdded", "messageLabelRemoved", "conversationLabelAdded", "conversationLabelRemoved" }));
    e = String.valueOf(str).length() + 2 + "'" + str + "'";
    str = String.valueOf(TextUtils.join("', '", new String[] { "messageSaved", "messageSent" }));
    f = String.valueOf(str).length() + 2 + "'" + str + "'";
  }
  
  public duf(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    c = paramSQLiteDatabase;
    d = paramContext;
  }
  
  /* Error */
  private final long a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 115	duf:c	Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc 120
    //   9: aconst_null
    //   10: invokevirtual 126	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnull +39 -> 56
    //   20: aload 4
    //   22: invokeinterface 132 1 0
    //   27: ifeq +29 -> 56
    //   30: aload 4
    //   32: iconst_0
    //   33: invokeinterface 136 2 0
    //   38: istore_1
    //   39: iload_1
    //   40: i2l
    //   41: lstore_2
    //   42: aload 4
    //   44: ifnull +10 -> 54
    //   47: aload 4
    //   49: invokeinterface 139 1 0
    //   54: lload_2
    //   55: lreturn
    //   56: aload 4
    //   58: ifnull +10 -> 68
    //   61: aload 4
    //   63: invokeinterface 139 1 0
    //   68: ldc2_w 140
    //   71: lreturn
    //   72: astore 4
    //   74: aload 5
    //   76: ifnull +10 -> 86
    //   79: aload 5
    //   81: invokeinterface 139 1 0
    //   86: aload 4
    //   88: athrow
    //   89: astore 6
    //   91: aload 4
    //   93: astore 5
    //   95: aload 6
    //   97: astore 4
    //   99: goto -25 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	duf
    //   38	2	1	i	int
    //   41	14	2	l	long
    //   13	49	4	localCursor	Cursor
    //   72	20	4	localObject1	Object
    //   97	1	4	localObject2	Object
    //   1	93	5	localObject3	Object
    //   89	7	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	72	finally
    //   20	39	89	finally
  }
  
  private final long a(long paramLong, dug paramdug, dtd paramdtd)
  {
    if (a) {
      c.execSQL("DELETE FROM operations where _id = ?", new String[] { Long.toString(paramLong) });
    }
    for (long l = b(paramdug);; l = a(paramdug))
    {
      dri.c(a, "Moving delayed operation %d (%s) to end of list with newAttempts %d, delay %d, newBackOffTime %d, newOpId %d", new Object[] { Long.valueOf(paramLong), m, Integer.valueOf(o), Integer.valueOf(p), Long.valueOf(q), Long.valueOf(l) });
      return l;
      c.execSQL("DELETE FROM operations where _id = ?", new String[] { Long.toString(paramLong) });
    }
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    String str1 = Long.toString(paramLong2);
    String str2 = Long.toString(paramLong1);
    String str3 = e;
    paramSQLiteDatabase.execSQL(String.valueOf(str3).length() + 66 + "UPDATE operations SET value1 = ? WHERE action IN (" + str3 + ") AND value1 = ?", new String[] { str1, str2 });
  }
  
  private final long b(dug paramdug)
  {
    return a(m, l, n, a, b, c, d, e, o, p, q);
  }
  
  public final int a(dtl paramdtl, drp paramdrp, dtd paramdtd, long paramLong)
  {
    Cursor localCursor = c.rawQuery("SELECT \n  _id,\n  action,\n  numAttempts,\n  nextTimeToAttempt,\n  value1,\n  value2,\n  delay\nFROM\n operations\nWHERE\n  message_messageId = ? AND value2 = ?\n", new String[] { Long.toString(f), Long.toString(e) });
    for (;;)
    {
      int i8;
      int i9;
      int k;
      int i10;
      int i1;
      long l1;
      Object localObject1;
      long l2;
      try
      {
        int i3 = localCursor.getColumnIndexOrThrow("_id");
        int i4 = localCursor.getColumnIndexOrThrow("action");
        int i5 = localCursor.getColumnIndexOrThrow("numAttempts");
        int i6 = localCursor.getColumnIndexOrThrow("nextTimeToAttempt");
        int i7 = localCursor.getColumnIndexOrThrow("delay");
        i8 = localCursor.getColumnIndexOrThrow("value1");
        i9 = localCursor.getColumnIndexOrThrow("value2");
        i = 0;
        k = 0;
        m = 0;
        j = 0;
        i10 = ghz.a(d.getContentResolver(), "gmail_max_attachment_size_bytes", 20971520);
        i1 = 0;
        if (!localCursor.moveToNext()) {
          break label635;
        }
        l1 = localCursor.getLong(i3);
        localObject1 = localCursor.getString(i4);
        n = localCursor.getInt(i5);
        l2 = localCursor.getLong(i6);
        i2 = localCursor.getInt(i7);
        localObject2 = new dug((String)localObject1, f, 0L, e, null, null, null, null, null, null, null, null, null, null, n, i2, l2);
        if (((!"messageSent".equals(localObject1)) && (!"emptySpam".equals(localObject1)) && (!"emptyTrash".equals(localObject1))) || (!a(paramLong, l1, (dug)localObject2, paramdtd, f, (String)localObject1, paramdrp))) {
          continue;
        }
        if (!"messageSent".equals(localObject1)) {
          break label522;
        }
        localObject1 = paramdrp.b(f, true);
        if (localObject1 == null)
        {
          dri.e(a, "Cannot find message with id = %d for operations!", new Object[] { Long.valueOf(f) });
          c.delete("operations", 27 + "_id == " + l1, null);
          continue;
        }
        paramdrp.a(c, X.o());
      }
      finally
      {
        localCursor.close();
      }
      int n = m + s.length();
      Object localObject2 = ((dtu)localObject1).a();
      int m = n;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          m = n;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          n += nextd;
        }
      }
      for (;;)
      {
        paramdtl.a(l1, (dtu)localObject1, f, e, false);
        n = 1;
        j = m;
        m = i;
        i = n;
        break;
        label522:
        l2 = localCursor.getLong(i8);
        n = localCursor.getInt(i9);
        if ("emptySpam".equals(localObject1))
        {
          if (i == 0)
          {
            paramdtl.a(l1, 0, l2, n);
            n = 1;
            i = j;
            j = m;
            m = n;
            break;
          }
        }
        else if (k == 0)
        {
          paramdtl.a(l1, 1, l2, n);
          k = m;
          n = 1;
          m = i;
          i = j;
          j = k;
          k = n;
          break;
        }
        label635:
        do
        {
          localCursor.close();
          return i1;
          n = i;
          i = j;
          j = m;
          m = n;
          break label679;
          if (j == 0) {
            break;
          }
        } while (m > i10);
      }
      label679:
      n = j;
      int i2 = m;
      i1 += 1;
      int j = i;
      m = n;
      int i = i2;
    }
  }
  
  public final long a(long paramLong1, long paramLong2, String paramString)
  {
    return a(paramString, paramLong2, 0L, paramLong1, null, null, null, null, 0L, 0, 0L);
  }
  
  public final long a(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return a(paramString, paramLong2, paramLong3, paramLong1, null, null, null, null, 0L, 0, 0L);
  }
  
  public final long a(dug paramdug)
  {
    c.beginTransactionNonExclusive();
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Object localObject = new SQLiteQueryBuilder();
      ((SQLiteQueryBuilder)localObject).setTables("operations");
      localObject = ((SQLiteQueryBuilder)localObject).query(c, b, null, null, null, null, "_id");
      int i = ((Cursor)localObject).getColumnIndexOrThrow("action");
      int j = ((Cursor)localObject).getColumnIndexOrThrow("message_messageId");
      int k = ((Cursor)localObject).getColumnIndexOrThrow("value1");
      int m = ((Cursor)localObject).getColumnIndexOrThrow("value2");
      int n = ((Cursor)localObject).getColumnIndexOrThrow("value3");
      int i1 = ((Cursor)localObject).getColumnIndexOrThrow("value4");
      int i2 = ((Cursor)localObject).getColumnIndexOrThrow("value5");
      int i3 = ((Cursor)localObject).getColumnIndexOrThrow("value6");
      int i4 = ((Cursor)localObject).getColumnIndexOrThrow("value7");
      int i5 = ((Cursor)localObject).getColumnIndexOrThrow("value8");
      int i6 = ((Cursor)localObject).getColumnIndexOrThrow("value9");
      int i7 = ((Cursor)localObject).getColumnIndexOrThrow("value10");
      int i8 = ((Cursor)localObject).getColumnIndexOrThrow("value11");
      int i9 = ((Cursor)localObject).getColumnIndexOrThrow("value12");
      int i10 = ((Cursor)localObject).getColumnIndexOrThrow("numAttempts");
      int i11 = ((Cursor)localObject).getColumnIndexOrThrow("nextTimeToAttempt");
      int i12 = ((Cursor)localObject).getColumnIndexOrThrow("delay");
      while (((Cursor)localObject).moveToNext())
      {
        String str = ((Cursor)localObject).getString(i);
        l1 = ((Cursor)localObject).getLong(j);
        int i13 = ((Cursor)localObject).getInt(i10);
        long l2 = ((Cursor)localObject).getLong(i11);
        int i14 = ((Cursor)localObject).getInt(i12);
        localArrayList.add(new dug(str, l1, ((Cursor)localObject).getLong(k), ((Cursor)localObject).getLong(m), ((Cursor)localObject).getString(n), ((Cursor)localObject).getString(i1), ((Cursor)localObject).getString(i2), ((Cursor)localObject).getString(i3), ((Cursor)localObject).getString(i4), ((Cursor)localObject).getString(i5), ((Cursor)localObject).getString(i6), ((Cursor)localObject).getString(i7), ((Cursor)localObject).getString(i8), ((Cursor)localObject).getString(i9), i13, i14, l2));
      }
      ((Cursor)localObject).close();
    }
    finally
    {
      c.endTransaction();
    }
    c.execSQL("DELETE FROM operations");
    long l1 = b(paramdug);
    paramdug = localArrayList.iterator();
    while (paramdug.hasNext()) {
      b((dug)paramdug.next());
    }
    c.setTransactionSuccessful();
    c.endTransaction();
    return l1;
  }
  
  public final long a(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong4, int paramInt, long paramLong5)
  {
    ContentValues localContentValues = new ContentValues(11);
    localContentValues.put("action", paramString1);
    localContentValues.put("message_messageId", Long.valueOf(paramLong1));
    localContentValues.put("value1", Long.valueOf(paramLong2));
    localContentValues.put("value2", Long.valueOf(paramLong3));
    localContentValues.put("value3", paramString2);
    localContentValues.put("value4", paramString3);
    localContentValues.put("value5", paramString4);
    localContentValues.put("value6", paramString5);
    if ((paramLong4 > 0L) && (paramLong5 > 0L))
    {
      localContentValues.put("numAttempts", Long.valueOf(paramLong4));
      localContentValues.put("nextTimeToAttempt", Long.valueOf(paramLong5));
      localContentValues.put("delay", Integer.valueOf(paramInt));
    }
    paramLong1 = c.insert("operations", null, localContentValues);
    if (dri.a(a, 2)) {
      dri.a(a, "Recorded new operation (%s), pending ops count: %d", new Object[] { paramString1, Long.valueOf(a()) });
    }
    return paramLong1;
  }
  
  public final long a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("Preference name is invalid");
    }
    ContentValues localContentValues = new ContentValues(5);
    localContentValues.put("action", "prefChange");
    localContentValues.put("message_messageId", Integer.valueOf(0));
    localContentValues.put("value3", paramString1);
    localContentValues.put("value1", Integer.valueOf(0));
    localContentValues.put("value4", paramString2);
    return c.insert("operations", null, localContentValues);
  }
  
  public final void a(long paramLong)
  {
    c.delete("operations", "message_messageId = ?", new String[] { Long.toString(paramLong) });
  }
  
  final boolean a(long paramLong1, long paramLong2, dug paramdug, dtd paramdtd, long paramLong3, String paramString, drp paramdrp)
  {
    if (c)
    {
      dri.b(a, "manual sync, skipping calculateAndUpdateOpDelay", new Object[0]);
      return true;
    }
    dri.b(a, "calculateAndUpdateOpDelay: currentTime = %d, nextTimeToAttempt = %d, numAttempts = %d delay=%d %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(q), Integer.valueOf(o), Integer.valueOf(p), paramdtd });
    if (q > paramLong1)
    {
      paramLong1 = a(paramLong2, paramdug, paramdtd);
      dri.c(a, "Not retrying backed off operation id %d as the next retry attempt is in the future. newOpId %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return false;
    }
    if ((!g) && (o > 0))
    {
      m.a("unackedSentOperations", true);
      m.g();
      paramLong1 = a(paramLong2, paramdug, paramdtd);
      dri.c(a, "Not retrying this operation id %d as we have not received what client operations the server has handled. newOpId %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return false;
    }
    if ((("messageSaved".equals(paramString)) || ("messageSent".equals(paramString))) && (o > 12))
    {
      dri.c(a, "Operation %d exceeded number of times for retry", new Object[] { Long.valueOf(paramLong2) });
      paramdrp.a(paramLong3, "max_retry_reached");
      c.delete("operations", 27 + "_id == " + paramLong2, null);
      return false;
    }
    if (o >= 3) {
      if (p != 0) {
        break label506;
      }
    }
    label506:
    for (int i = 30;; i = Math.min(75600, p * 2))
    {
      p = i;
      q = (p + paramLong1);
      if (o > 0) {
        dri.c(a, "Attempt[%d] operation %d with new delay: %d nextTimeToAttempt: %d", new Object[] { Integer.valueOf(o), Long.valueOf(paramLong2), Integer.valueOf(p), Long.valueOf(q) });
      }
      o += 1;
      paramdtd = new ContentValues(3);
      paramdtd.put("numAttempts", Integer.valueOf(o));
      paramdtd.put("delay", Integer.valueOf(p));
      paramdtd.put("nextTimeToAttempt", Long.valueOf(q));
      c.update("operations", paramdtd, "_id = ?", new String[] { Long.toString(paramLong2) });
      return true;
    }
  }
  
  public final int b(long paramLong)
  {
    Object localObject1;
    try
    {
      localObject1 = c;
      String str = Long.toString(paramLong);
      localObject1 = ((SQLiteDatabase)localObject1).query("operations", new String[] { "numAttempts" }, "action = ? AND message_messageId = ?", new String[] { "messageSent", str }, null, null, null);
      int i;
      if (localObject1 == null) {
        break label115;
      }
    }
    finally
    {
      try
      {
        if (((Cursor)localObject1).moveToFirst())
        {
          i = ((Cursor)localObject1).getInt(0);
          if (localObject1 != null) {
            ((Cursor)localObject1).close();
          }
          return i;
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        return -1;
      }
      finally {}
      localObject2 = finally;
      localObject1 = null;
    }
    ((Cursor)localObject1).close();
    label115:
    throw ((Throwable)localObject2);
  }
}

/* Location:
 * Qualified Name:     duf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */