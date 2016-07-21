import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

final class dbh
  extends SQLiteOpenHelper
{
  private boolean b;
  private long c = 0L;
  
  dbh(dbe paramdbe, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  /* Error */
  private static boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ldc 25
    //   5: iconst_1
    //   6: anewarray 27	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: ldc 29
    //   13: aastore
    //   14: ldc 31
    //   16: iconst_1
    //   17: anewarray 27	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: invokevirtual 37	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 43 1 0
    //   37: istore_2
    //   38: aload_1
    //   39: ifnull +9 -> 48
    //   42: aload_1
    //   43: invokeinterface 47 1 0
    //   48: iload_2
    //   49: ireturn
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_1
    //   53: new 49	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 51
    //   59: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 68	dav:f	(Ljava/lang/String;)I
    //   72: pop
    //   73: aload_1
    //   74: ifnull +9 -> 83
    //   77: aload_1
    //   78: invokeinterface 47 1 0
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_0
    //   86: aload_3
    //   87: astore_1
    //   88: aload_1
    //   89: ifnull +9 -> 98
    //   92: aload_1
    //   93: invokeinterface 47 1 0
    //   98: aload_0
    //   99: athrow
    //   100: astore_0
    //   101: goto -13 -> 88
    //   104: astore_0
    //   105: goto -17 -> 88
    //   108: astore_3
    //   109: goto -56 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramString	String
    //   0	112	1	paramSQLiteDatabase	SQLiteDatabase
    //   37	12	2	bool	boolean
    //   1	86	3	localObject	Object
    //   108	1	3	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   2	31	50	android/database/sqlite/SQLiteException
    //   2	31	85	finally
    //   31	38	100	finally
    //   53	73	104	finally
    //   31	38	108	android/database/sqlite/SQLiteException
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    if ((b) && (c + 3600000L > a.d.a())) {
      throw new SQLiteException("Database creation failed");
    }
    Object localObject1 = null;
    b = true;
    c = a.d.a();
    try
    {
      localObject2 = super.getWritableDatabase();
      localObject1 = localObject2;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        Object localObject2;
        a.b.getDatabasePath(a.c).delete();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = super.getWritableDatabase();
    }
    b = false;
    return (SQLiteDatabase)localObject2;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.getPath();
    if (czt.a() >= 9)
    {
      paramSQLiteDatabase = new File(paramSQLiteDatabase);
      paramSQLiteDatabase.setReadable(false, false);
      paramSQLiteDatabase.setWritable(false, false);
      paramSQLiteDatabase.setReadable(true, true);
      paramSQLiteDatabase.setWritable(true, true);
    }
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    int j = 0;
    Cursor localCursor;
    if (Build.VERSION.SDK_INT < 15) {
      localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
    }
    int i;
    do
    {
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        if (!a("hits2", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(dbe.a);
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = localCursor.getColumnNames();
        i = 0;
        while (i < arrayOfString.length)
        {
          localHashSet.add(arrayOfString[i]);
          i += 1;
        }
        localCursor.close();
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_string")) || (!localHashSet.remove("hit_time"))) {
          throw new SQLiteException("Database column missing");
        }
      }
      finally
      {
        localCursor.close();
      }
      i = j;
      if (!localHashSet.remove("hit_app_id")) {
        i = 1;
      }
      if (!localHashSet.isEmpty()) {
        throw new SQLiteException("Database has extra columns");
      }
    } while (i == 0);
    paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}

/* Location:
 * Qualified Name:     dbh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */