package com.google.android.gm.utils;

import java.util.concurrent.ConcurrentHashMap;

public class OutgoingMsgPrefs
{
  public static ConcurrentHashMap<String, String[]> ACCOUNT_OUTGOING_PREFS = new ConcurrentHashMap();
  private static String VALUE_COL = "value";
  
  public static void addOrUpdateDisplayName(String paramString1, String paramString2)
  {
    String[] arrayOfString = ensurePrefs(paramString1);
    arrayOfString[1] = paramString2;
    ACCOUNT_OUTGOING_PREFS.put(paramString1, arrayOfString);
  }
  
  public static void addOrUpdateReplyTo(String paramString1, String paramString2)
  {
    String[] arrayOfString = ensurePrefs(paramString1);
    arrayOfString[0] = paramString2;
    ACCOUNT_OUTGOING_PREFS.put(paramString1, arrayOfString);
  }
  
  private static String[] ensurePrefs(String paramString)
  {
    if (ACCOUNT_OUTGOING_PREFS == null) {}
    for (paramString = null;; paramString = (String[])ACCOUNT_OUTGOING_PREFS.get(paramString))
    {
      Object localObject = paramString;
      if (paramString == null) {
        localObject = new String[2];
      }
      return (String[])localObject;
    }
  }
  
  /* Error */
  public static void instantiateOutgoingPrefs(String paramString, android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 37	java/lang/String
    //   4: astore 6
    //   6: aload_1
    //   7: invokeinterface 51 1 0
    //   12: ifeq +81 -> 93
    //   15: aload_1
    //   16: getstatic 15	com/google/android/gm/utils/OutgoingMsgPrefs:VALUE_COL	Ljava/lang/String;
    //   19: invokeinterface 55 2 0
    //   24: istore_3
    //   25: aload_1
    //   26: ldc 57
    //   28: invokeinterface 55 2 0
    //   33: istore 4
    //   35: aload_1
    //   36: iload 4
    //   38: invokeinterface 61 2 0
    //   43: astore 7
    //   45: iconst_m1
    //   46: istore_2
    //   47: aload 7
    //   49: ldc 63
    //   51: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifeq +46 -> 100
    //   57: iconst_0
    //   58: istore_2
    //   59: iload_2
    //   60: iflt +14 -> 74
    //   63: aload 6
    //   65: iload_2
    //   66: aload_1
    //   67: iload_3
    //   68: invokeinterface 61 2 0
    //   73: aastore
    //   74: aload_1
    //   75: invokeinterface 70 1 0
    //   80: ifne -45 -> 35
    //   83: getstatic 22	com/google/android/gm/utils/OutgoingMsgPrefs:ACCOUNT_OUTGOING_PREFS	Ljava/util/concurrent/ConcurrentHashMap;
    //   86: aload_0
    //   87: aload 6
    //   89: invokevirtual 34	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: pop
    //   93: aload_1
    //   94: invokeinterface 73 1 0
    //   99: return
    //   100: aload 7
    //   102: ldc 75
    //   104: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: istore 5
    //   109: iload 5
    //   111: ifeq -52 -> 59
    //   114: iconst_1
    //   115: istore_2
    //   116: goto -57 -> 59
    //   119: astore_0
    //   120: aload_1
    //   121: invokeinterface 73 1 0
    //   126: aload_0
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   0	128	1	paramCursor	android.database.Cursor
    //   46	70	2	i	int
    //   24	44	3	j	int
    //   33	4	4	k	int
    //   107	3	5	bool	boolean
    //   4	84	6	arrayOfString	String[]
    //   43	58	7	str	String
    // Exception table:
    //   from	to	target	type
    //   6	35	119	finally
    //   35	45	119	finally
    //   47	57	119	finally
    //   63	74	119	finally
    //   74	93	119	finally
    //   100	109	119	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.utils.OutgoingMsgPrefs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */