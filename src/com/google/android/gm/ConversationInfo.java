package com.google.android.gm;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils.StringSplitter;
import deu;
import dpy;
import dqa;
import dqc;
import dqf;
import dqz;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class ConversationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ConversationInfo> CREATOR = new deu();
  public final long a;
  public final long b;
  public final long c;
  public long d;
  private final boolean e;
  
  public ConversationInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    a = paramLong1;
    b = paramLong2;
    c = paramLong3;
    d = paramLong4;
    e = paramBoolean;
  }
  
  private ConversationInfo(long paramLong, Map<String, dqz> paramMap, Set<Long> paramSet, dqc paramdqc) {}
  
  private ConversationInfo(long paramLong1, long paramLong2, Map<String, dqz> paramMap, Set<Long> paramSet, dqc paramdqc, byte paramByte)
  {
    this(paramLong1, paramLong2, paramMap, paramSet, paramdqc);
  }
  
  public static ConversationInfo a(dqa paramdqa, dqc paramdqc)
  {
    if (r != null) {}
    for (int i = r.getCount(); i == 0; i = 0) {
      return null;
    }
    long l1 = paramdqa.b();
    long l2 = r.getLong(paramdqa.i);
    Map localMap = paramdqa.c();
    if (l != -1)
    {
      String str2 = r.getString(l);
      TextUtils.StringSplitter localStringSplitter = q;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localStringSplitter.setString(str1);
    }
    for (paramdqa = dpy.a(q);; paramdqa = dpy.b(paramdqa.c())) {
      return new ConversationInfo(l1, l2, localMap, paramdqa, paramdqc, (byte)0);
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  /* Error */
  public boolean equals(Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: aload_0
    //   6: if_acmpne +7 -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: iconst_1
    //   12: ireturn
    //   13: aload_1
    //   14: ifnull +14 -> 28
    //   17: aload_1
    //   18: invokevirtual 133	java/lang/Object:getClass	()Ljava/lang/Class;
    //   21: aload_0
    //   22: invokevirtual 133	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: if_acmpeq +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_1
    //   33: checkcast 2	com/google/android/gm/ConversationInfo
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 30	com/google/android/gm/ConversationInfo:a	J
    //   41: aload_1
    //   42: getfield 30	com/google/android/gm/ConversationInfo:a	J
    //   45: lcmp
    //   46: ifne +59 -> 105
    //   49: aload_0
    //   50: getfield 32	com/google/android/gm/ConversationInfo:b	J
    //   53: aload_1
    //   54: getfield 32	com/google/android/gm/ConversationInfo:b	J
    //   57: lcmp
    //   58: ifne +47 -> 105
    //   61: aload_0
    //   62: getfield 34	com/google/android/gm/ConversationInfo:c	J
    //   65: aload_1
    //   66: getfield 34	com/google/android/gm/ConversationInfo:c	J
    //   69: lcmp
    //   70: ifne +35 -> 105
    //   73: aload_0
    //   74: getfield 36	com/google/android/gm/ConversationInfo:d	J
    //   77: aload_1
    //   78: getfield 36	com/google/android/gm/ConversationInfo:d	J
    //   81: lcmp
    //   82: ifne +23 -> 105
    //   85: aload_0
    //   86: getfield 38	com/google/android/gm/ConversationInfo:e	Z
    //   89: aload_1
    //   90: getfield 38	com/google/android/gm/ConversationInfo:e	Z
    //   93: if_icmpne +12 -> 105
    //   96: aload_0
    //   97: monitorexit
    //   98: iload_2
    //   99: ireturn
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: iconst_0
    //   106: istore_2
    //   107: goto -11 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	ConversationInfo
    //   0	110	1	paramObject	Object
    //   1	106	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	11	100	finally
    //   17	28	100	finally
    //   28	30	100	finally
    //   32	96	100	finally
    //   96	98	100	finally
    //   101	103	100	finally
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(new Object[] { Long.valueOf(a), Long.valueOf(b), Long.valueOf(c), Long.valueOf(d), Boolean.valueOf(e) });
      return i;
    }
    finally {}
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(a);
    paramParcel.writeLong(b);
    paramParcel.writeLong(c);
    paramParcel.writeLong(d);
    if (e) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ConversationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */