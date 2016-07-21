import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.Arrays;

public final class chb
{
  private static final String a = cvl.a;
  private static final String[] b = { "_id", "driveAccount", "messageKey", "resourceId", "uploaded", "placeholder", "blocking" };
  
  public static int a(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return a(paramSQLiteDatabase, "uploaded", paramLong, true);
  }
  
  public static int a(SQLiteDatabase paramSQLiteDatabase, long paramLong, ContentValues paramContentValues)
  {
    return paramSQLiteDatabase.update("save_to_drive", paramContentValues, "messageKey=?", new String[] { Long.toString(paramLong) });
  }
  
  public static int a(SQLiteDatabase paramSQLiteDatabase, long paramLong, String paramString)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("resourceId", paramString);
    return paramSQLiteDatabase.update("save_to_drive", localContentValues, "_id=?", new String[] { Long.toString(paramLong) });
  }
  
  public static int a(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean)
  {
    return a(paramSQLiteDatabase, "placeholder", paramLong, paramBoolean);
  }
  
  private static int a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put(paramString, Boolean.valueOf(paramBoolean));
    return paramSQLiteDatabase.update("save_to_drive", localContentValues, "_id=?", new String[] { Long.toString(paramLong) });
  }
  
  public static long a(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
  {
    return paramSQLiteDatabase.insert("save_to_drive", null, paramContentValues);
  }
  
  public static long a(SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong)
  {
    if (paramArrayOfLong.length == 0) {
      return -1L;
    }
    long l;
    for (;;)
    {
      int i;
      try
      {
        l = d(paramSQLiteDatabase, paramArrayOfLong[0]);
        i = 1;
        if (i >= paramArrayOfLong.length) {
          break;
        }
        if (l != d(paramSQLiteDatabase, paramArrayOfLong[i]))
        {
          cvm.d(a, "Not all the message IDs are the same", new Object[0]);
          return -1L;
        }
      }
      catch (IllegalArgumentException paramSQLiteDatabase)
      {
        cvm.d(a, paramSQLiteDatabase, "Couldn't get message ID for save IDs %s", new Object[] { Arrays.toString(paramArrayOfLong) });
        return -1L;
      }
      i += 1;
    }
    return l;
  }
  
  public static ContentValues a(String paramString, long paramLong)
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("driveAccount", paramString);
    localContentValues.put("messageKey", Long.valueOf(paramLong));
    return localContentValues;
  }
  
  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong)
  {
    paramSQLiteDatabase = i(paramSQLiteDatabase, paramLong);
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramString = paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex(paramString));
        return paramString;
      }
      throw new IllegalArgumentException(36 + "Invalid save id " + paramLong);
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static String a(Iterable<Long> paramIterable)
  {
    return TextUtils.join(",", paramIterable);
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE save_to_drive (_id INTEGER PRIMARY KEY,driveAccount TEXT,messageKey INTEGER,resourceId TEXT,uploaded INTEGER,placeholder INTEGER,blocking INTEGER)");
  }
  
  public static long[] a(String paramString)
  {
    String[] arrayOfString = TextUtils.split(paramString, ",");
    long[] arrayOfLong3 = new long[arrayOfString.length];
    int i = 0;
    for (;;)
    {
      long[] arrayOfLong1 = arrayOfLong3;
      try
      {
        if (i < arrayOfLong3.length)
        {
          arrayOfLong3[i] = Long.parseLong(arrayOfString[i]);
          i += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        cvm.d(a, localNumberFormatException, "Couldn't parse joinedSaveIds %s", new Object[] { paramString });
        long[] arrayOfLong2 = null;
        return arrayOfLong2;
      }
    }
  }
  
  public static int b(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return paramSQLiteDatabase.delete("save_to_drive", "_id=?", new String[] { Long.toString(paramLong) });
  }
  
  public static int b(SQLiteDatabase paramSQLiteDatabase, long paramLong, boolean paramBoolean)
  {
    return a(paramSQLiteDatabase, "blocking", paramLong, paramBoolean);
  }
  
  public static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS save_to_drive");
  }
  
  private static boolean b(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong)
  {
    boolean bool = true;
    paramSQLiteDatabase = i(paramSQLiteDatabase, paramLong);
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        int i = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex(paramString));
        if (i == 1) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      throw new IllegalArgumentException(31 + "Invalid id " + paramLong);
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  /* Error */
  public static boolean c(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 41
    //   3: aconst_null
    //   4: ldc -53
    //   6: iconst_1
    //   7: anewarray 17	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: lload_1
    //   13: invokestatic 49	java/lang/Long:toString	(J)Ljava/lang/String;
    //   16: aastore
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 207	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_0
    //   24: aload_0
    //   25: invokeinterface 211 1 0
    //   30: istore_3
    //   31: iload_3
    //   32: ifle +15 -> 47
    //   35: iconst_1
    //   36: istore 4
    //   38: aload_0
    //   39: invokeinterface 138 1 0
    //   44: iload 4
    //   46: ireturn
    //   47: iconst_0
    //   48: istore 4
    //   50: goto -12 -> 38
    //   53: astore 5
    //   55: aload_0
    //   56: invokeinterface 138 1 0
    //   61: aload 5
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	64	1	paramLong	long
    //   30	2	3	i	int
    //   36	13	4	bool	boolean
    //   53	9	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	31	53	finally
  }
  
  public static long d(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    paramSQLiteDatabase = i(paramSQLiteDatabase, paramLong);
    try
    {
      if (paramSQLiteDatabase.moveToFirst())
      {
        paramLong = paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("messageKey"));
        return paramLong;
      }
      throw new IllegalArgumentException(36 + "Invalid save id " + paramLong);
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static String e(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return a(paramSQLiteDatabase, "resourceId", paramLong);
  }
  
  public static boolean f(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return b(paramSQLiteDatabase, "uploaded", paramLong);
  }
  
  public static boolean g(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return b(paramSQLiteDatabase, "placeholder", paramLong);
  }
  
  public static boolean h(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return b(paramSQLiteDatabase, "blocking", paramLong);
  }
  
  public static Cursor i(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return paramSQLiteDatabase.query("save_to_drive", b, "_id=?", new String[] { Long.toString(paramLong) }, null, null, null);
  }
  
  public static Cursor j(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    return paramSQLiteDatabase.query("save_to_drive", b, "messageKey=?", new String[] { Long.toString(paramLong) }, null, null, null);
  }
}

/* Location:
 * Qualified Name:     chb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */