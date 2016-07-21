import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

public final class dpq
  extends CursorWrapper
  implements CrossProcessCursor
{
  private final int a = super.getColumnIndex(paramString2);
  
  public dpq(Cursor paramCursor, String paramString)
  {
    super(paramCursor);
  }
  
  public dpq(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString1, SQLiteQuery paramSQLiteQuery, String paramString2)
  {
    super(new SQLiteCursor(paramSQLiteDatabase, paramSQLiteCursorDriver, paramString1, paramSQLiteQuery));
  }
  
  /* Error */
  private final String a()
  {
    // Byte code:
    //   0: new 33	android/util/TimingLogger
    //   3: dup
    //   4: ldc 35
    //   6: ldc 37
    //   8: invokespecial 40	android/util/TimingLogger:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: astore 5
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 19	dpq:a	I
    //   18: invokespecial 44	android/database/CursorWrapper:getBlob	(I)[B
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +15 -> 40
    //   28: ldc 46
    //   30: astore 4
    //   32: aload 5
    //   34: invokevirtual 50	android/util/TimingLogger:dumpToLog	()V
    //   37: aload 4
    //   39: areturn
    //   40: aload 4
    //   42: iconst_0
    //   43: baload
    //   44: bipush 48
    //   46: if_icmpne +75 -> 121
    //   49: aload 4
    //   51: arraylength
    //   52: iconst_1
    //   53: isub
    //   54: istore_1
    //   55: aload 4
    //   57: iload_1
    //   58: baload
    //   59: ifne +117 -> 176
    //   62: iload_1
    //   63: iconst_1
    //   64: isub
    //   65: istore_1
    //   66: new 52	java/lang/String
    //   69: dup
    //   70: aload 4
    //   72: iconst_1
    //   73: iload_1
    //   74: invokespecial 55	java/lang/String:<init>	([BII)V
    //   77: astore 4
    //   79: goto -47 -> 32
    //   82: astore 4
    //   84: aload_0
    //   85: ldc 57
    //   87: invokevirtual 58	dpq:getColumnIndex	(Ljava/lang/String;)I
    //   90: istore_1
    //   91: iload_1
    //   92: ifge +75 -> 167
    //   95: ldc2_w 59
    //   98: lstore_2
    //   99: new 62	dpr
    //   102: dup
    //   103: aload_0
    //   104: lload_2
    //   105: aload 4
    //   107: invokespecial 65	dpr:<init>	(Ldpq;JLjava/lang/Throwable;)V
    //   110: athrow
    //   111: astore 4
    //   113: aload 5
    //   115: invokevirtual 50	android/util/TimingLogger:dumpToLog	()V
    //   118: aload 4
    //   120: athrow
    //   121: aload 4
    //   123: iconst_0
    //   124: baload
    //   125: bipush 49
    //   127: if_icmpne +18 -> 145
    //   130: aload 4
    //   132: aload 4
    //   134: arraylength
    //   135: iconst_1
    //   136: isub
    //   137: invokestatic 70	dvg:a	([BI)Ljava/lang/String;
    //   140: astore 4
    //   142: goto -110 -> 32
    //   145: new 29	java/util/zip/DataFormatException
    //   148: dup
    //   149: ldc 72
    //   151: invokespecial 75	java/util/zip/DataFormatException:<init>	(Ljava/lang/String;)V
    //   154: athrow
    //   155: astore 4
    //   157: new 77	java/lang/IllegalStateException
    //   160: dup
    //   161: ldc 79
    //   163: invokespecial 80	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   166: athrow
    //   167: aload_0
    //   168: iload_1
    //   169: invokevirtual 84	dpq:getLong	(I)J
    //   172: lstore_2
    //   173: goto -74 -> 99
    //   176: goto -110 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	dpq
    //   54	115	1	i	int
    //   98	75	2	l	long
    //   21	57	4	localObject	Object
    //   82	24	4	localDataFormatException	java.util.zip.DataFormatException
    //   111	22	4	arrayOfByte	byte[]
    //   140	1	4	str	String
    //   155	1	4	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   11	103	5	localTimingLogger	android.util.TimingLogger
    // Exception table:
    //   from	to	target	type
    //   13	23	82	java/util/zip/DataFormatException
    //   49	55	82	java/util/zip/DataFormatException
    //   66	79	82	java/util/zip/DataFormatException
    //   130	142	82	java/util/zip/DataFormatException
    //   145	155	82	java/util/zip/DataFormatException
    //   13	23	111	finally
    //   49	55	111	finally
    //   66	79	111	finally
    //   84	91	111	finally
    //   99	111	111	finally
    //   130	142	111	finally
    //   145	155	111	finally
    //   157	167	111	finally
    //   167	173	111	finally
    //   13	23	155	java/io/UnsupportedEncodingException
    //   49	55	155	java/io/UnsupportedEncodingException
    //   66	79	155	java/io/UnsupportedEncodingException
    //   130	142	155	java/io/UnsupportedEncodingException
    //   145	155	155	java/io/UnsupportedEncodingException
  }
  
  public final void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    ((SQLiteCursor)getWrappedCursor()).fillWindow(paramInt, paramCursorWindow);
    if ((paramInt < 0) || (paramInt > getCount()) || (a == -1)) {
      return;
    }
    paramCursorWindow.acquireReference();
    try
    {
      int i = getPosition();
      moveToPosition(paramInt - 1);
      while (moveToNext()) {
        paramCursorWindow.putString(a(), getPosition(), a);
      }
      moveToPosition(i);
    }
    finally
    {
      paramCursorWindow.releaseReference();
    }
    paramCursorWindow.releaseReference();
  }
  
  public final String getString(int paramInt)
  {
    if (paramInt != a) {
      return super.getString(paramInt);
    }
    return a();
  }
  
  public final CursorWindow getWindow()
  {
    return null;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    return ((SQLiteCursor)getWrappedCursor()).onMove(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     dpq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */