package com.google.android.gm.provider;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class CompressedMessageCursor
  extends CursorWrapper
  implements CrossProcessCursor
{
  private final int bodyIndex;
  private final CrossProcessCursor mCursor;
  
  public CompressedMessageCursor(Cursor paramCursor)
  {
    super(paramCursor);
    mCursor = ((CrossProcessCursor)paramCursor);
    bodyIndex = super.getColumnIndex("body");
  }
  
  /* Error */
  private String getMessageBody()
  {
    // Byte code:
    //   0: new 36	android/util/TimingLogger
    //   3: dup
    //   4: ldc 38
    //   6: ldc 39
    //   8: invokespecial 42	android/util/TimingLogger:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: astore 5
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 27	com/google/android/gm/provider/CompressedMessageCursor:bodyIndex	I
    //   18: invokespecial 46	android/database/CursorWrapper:getBlob	(I)[B
    //   21: astore 6
    //   23: aload 6
    //   25: ifnonnull +10 -> 35
    //   28: aload 5
    //   30: invokevirtual 50	android/util/TimingLogger:dumpToLog	()V
    //   33: aconst_null
    //   34: areturn
    //   35: aload 6
    //   37: iconst_0
    //   38: baload
    //   39: bipush 48
    //   41: if_icmpne +43 -> 84
    //   44: aload 6
    //   46: arraylength
    //   47: iconst_1
    //   48: isub
    //   49: istore_2
    //   50: iload_2
    //   51: istore_1
    //   52: aload 6
    //   54: iload_2
    //   55: baload
    //   56: ifne +7 -> 63
    //   59: iload_2
    //   60: iconst_1
    //   61: isub
    //   62: istore_1
    //   63: new 52	java/lang/String
    //   66: dup
    //   67: aload 6
    //   69: iconst_1
    //   70: iload_1
    //   71: invokespecial 55	java/lang/String:<init>	([BII)V
    //   74: astore 6
    //   76: aload 5
    //   78: invokevirtual 50	android/util/TimingLogger:dumpToLog	()V
    //   81: aload 6
    //   83: areturn
    //   84: aload 6
    //   86: iconst_1
    //   87: aload 6
    //   89: arraylength
    //   90: iconst_1
    //   91: isub
    //   92: invokestatic 61	com/google/android/gm/provider/ZipUtils:inflateToUTF8	([BII)Ljava/lang/String;
    //   95: astore 6
    //   97: aload 5
    //   99: invokevirtual 50	android/util/TimingLogger:dumpToLog	()V
    //   102: aload 6
    //   104: areturn
    //   105: astore 6
    //   107: aload_0
    //   108: ldc 63
    //   110: invokevirtual 64	com/google/android/gm/provider/CompressedMessageCursor:getColumnIndex	(Ljava/lang/String;)I
    //   113: istore_1
    //   114: iload_1
    //   115: ifge +29 -> 144
    //   118: ldc2_w 65
    //   121: lstore_3
    //   122: new 8	com/google/android/gm/provider/CompressedMessageCursor$CorruptedMessageException
    //   125: dup
    //   126: aload_0
    //   127: lload_3
    //   128: aload 6
    //   130: invokespecial 69	com/google/android/gm/provider/CompressedMessageCursor$CorruptedMessageException:<init>	(Lcom/google/android/gm/provider/CompressedMessageCursor;JLjava/lang/Throwable;)V
    //   133: athrow
    //   134: astore 6
    //   136: aload 5
    //   138: invokevirtual 50	android/util/TimingLogger:dumpToLog	()V
    //   141: aload 6
    //   143: athrow
    //   144: aload_0
    //   145: iload_1
    //   146: invokevirtual 73	com/google/android/gm/provider/CompressedMessageCursor:getLong	(I)J
    //   149: lstore_3
    //   150: goto -28 -> 122
    //   153: astore 6
    //   155: new 75	java/lang/IllegalStateException
    //   158: dup
    //   159: ldc 77
    //   161: invokespecial 80	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	CompressedMessageCursor
    //   51	95	1	i	int
    //   49	13	2	j	int
    //   121	29	3	l	long
    //   11	126	5	localTimingLogger	android.util.TimingLogger
    //   21	82	6	localObject1	Object
    //   105	24	6	localDataFormatException	java.util.zip.DataFormatException
    //   134	8	6	localObject2	Object
    //   153	1	6	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   84	97	105	java/util/zip/DataFormatException
    //   13	23	134	finally
    //   44	50	134	finally
    //   63	76	134	finally
    //   84	97	134	finally
    //   107	114	134	finally
    //   122	134	134	finally
    //   144	150	134	finally
    //   155	165	134	finally
    //   84	97	153	java/io/UnsupportedEncodingException
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    mCursor.fillWindow(paramInt, paramCursorWindow);
    if ((paramInt < 0) || (paramInt > getCount()) || (bodyIndex == -1)) {
      return;
    }
    paramCursorWindow.acquireReference();
    try
    {
      int i = getPosition();
      moveToPosition(paramInt - 1);
      while (moveToNext()) {
        paramCursorWindow.putString(getMessageBody(), getPosition(), bodyIndex);
      }
      moveToPosition(i);
    }
    finally
    {
      paramCursorWindow.releaseReference();
    }
    paramCursorWindow.releaseReference();
  }
  
  public String getString(int paramInt)
  {
    if (paramInt != bodyIndex) {
      return super.getString(paramInt);
    }
    return getMessageBody();
  }
  
  public CursorWindow getWindow()
  {
    return null;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return mCursor.onMove(paramInt1, paramInt2);
  }
  
  public class CorruptedMessageException
    extends RuntimeException
  {
    private final long mMessageId;
    
    public CorruptedMessageException(long paramLong, Throwable paramThrowable) {}
    
    public long getMessageId()
    {
      return mMessageId;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.CompressedMessageCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */