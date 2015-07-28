package com.google.android.gm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Gmail.ConversationCursor;
import com.google.android.gm.provider.Gmail.LabelMap;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LabelManager;
import com.google.common.base.Objects;
import java.util.Map;
import java.util.Set;

public class ConversationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ConversationInfo> CREATOR = new Parcelable.Creator()
  {
    public ConversationInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ConversationInfo(paramAnonymousParcel.readLong(), paramAnonymousParcel.readLong(), paramAnonymousParcel.readLong(), paramAnonymousParcel.readLong(), LabelManager.parseLabelQueryResult(paramAnonymousParcel.readString()));
    }
    
    public ConversationInfo[] newArray(int paramAnonymousInt)
    {
      return new ConversationInfo[paramAnonymousInt];
    }
  };
  private final long mConversationId;
  private final boolean mIsImportant;
  private final Map<String, Label> mLabels;
  private final long mLocalMessageId;
  private long mMaxMessageId;
  private final long mServerMessageId;
  
  ConversationInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Map<String, Label> paramMap)
  {
    this(paramLong1, paramLong2, paramLong3, paramLong4, paramMap, Gmail.isImportant(paramMap));
  }
  
  public ConversationInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Map<String, Label> paramMap, Set<Long> paramSet, Gmail.LabelMap paramLabelMap) {}
  
  private ConversationInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4, Map<String, Label> paramMap, boolean paramBoolean)
  {
    mConversationId = paramLong1;
    mLocalMessageId = paramLong2;
    mServerMessageId = paramLong3;
    mLabels = paramMap;
    mMaxMessageId = paramLong4;
    mIsImportant = paramBoolean;
  }
  
  private ConversationInfo(long paramLong1, long paramLong2, Map<String, Label> paramMap, Set<Long> paramSet, Gmail.LabelMap paramLabelMap)
  {
    this(paramLong1, 0L, 0L, paramLong2, paramMap, paramSet, paramLabelMap);
  }
  
  public static ConversationInfo forCursor(Gmail.ConversationCursor paramConversationCursor, Gmail.LabelMap paramLabelMap)
  {
    if (paramConversationCursor.count() == 0) {
      return null;
    }
    return new ConversationInfo(paramConversationCursor.getConversationId(), paramConversationCursor.getMaxServerMessageId(), paramConversationCursor.getLabels(), paramConversationCursor.getLabelIds(), paramLabelMap);
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
    //   18: invokevirtual 109	java/lang/Object:getClass	()Ljava/lang/Class;
    //   21: aload_0
    //   22: invokevirtual 109	java/lang/Object:getClass	()Ljava/lang/Class;
    //   25: if_acmpeq +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_1
    //   33: checkcast 2	com/google/android/gm/ConversationInfo
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 64	com/google/android/gm/ConversationInfo:mConversationId	J
    //   41: aload_1
    //   42: getfield 64	com/google/android/gm/ConversationInfo:mConversationId	J
    //   45: lcmp
    //   46: ifne +72 -> 118
    //   49: aload_0
    //   50: getfield 66	com/google/android/gm/ConversationInfo:mLocalMessageId	J
    //   53: aload_1
    //   54: getfield 66	com/google/android/gm/ConversationInfo:mLocalMessageId	J
    //   57: lcmp
    //   58: ifne +60 -> 118
    //   61: aload_0
    //   62: getfield 68	com/google/android/gm/ConversationInfo:mServerMessageId	J
    //   65: aload_1
    //   66: getfield 68	com/google/android/gm/ConversationInfo:mServerMessageId	J
    //   69: lcmp
    //   70: ifne +48 -> 118
    //   73: aload_0
    //   74: getfield 72	com/google/android/gm/ConversationInfo:mMaxMessageId	J
    //   77: aload_1
    //   78: getfield 72	com/google/android/gm/ConversationInfo:mMaxMessageId	J
    //   81: lcmp
    //   82: ifne +36 -> 118
    //   85: aload_0
    //   86: getfield 70	com/google/android/gm/ConversationInfo:mLabels	Ljava/util/Map;
    //   89: invokeinterface 114 1 0
    //   94: aload_1
    //   95: getfield 70	com/google/android/gm/ConversationInfo:mLabels	Ljava/util/Map;
    //   98: invokeinterface 114 1 0
    //   103: invokevirtual 116	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +12 -> 118
    //   109: aload_0
    //   110: monitorexit
    //   111: iload_2
    //   112: ireturn
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    //   118: iconst_0
    //   119: istore_2
    //   120: goto -11 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	ConversationInfo
    //   0	123	1	paramObject	Object
    //   1	119	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   9	11	113	finally
    //   17	28	113	finally
    //   28	30	113	finally
    //   32	109	113	finally
    //   109	111	113	finally
    //   114	116	113	finally
  }
  
  public long getConversationId()
  {
    return mConversationId;
  }
  
  /* Error */
  public Map<String, Label> getLabels()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/google/android/gm/ConversationInfo:mLabels	Ljava/util/Map;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 70	com/google/android/gm/ConversationInfo:mLabels	Ljava/util/Map;
    //   21: invokestatic 122	com/google/common/collect/ImmutableMap:copyOf	(Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;
    //   24: astore_1
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	ConversationInfo
    //   6	19	1	localObject1	Object
    //   28	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  public long getLocalMessageId()
  {
    return mLocalMessageId;
  }
  
  public long getMaxMessageId()
  {
    return mMaxMessageId;
  }
  
  public long getServerMessageId()
  {
    return mServerMessageId;
  }
  
  public int hashCode()
  {
    try
    {
      int i = Objects.hashCode(new Object[] { Long.valueOf(mConversationId), Long.valueOf(mLocalMessageId), Long.valueOf(mServerMessageId), Long.valueOf(mMaxMessageId), mLabels.keySet() });
      return i;
    }
    finally {}
  }
  
  public boolean isImportant()
  {
    try
    {
      boolean bool = mIsImportant;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(mConversationId);
    paramParcel.writeLong(mLocalMessageId);
    paramParcel.writeLong(mServerMessageId);
    paramParcel.writeLong(mMaxMessageId);
    try
    {
      paramParcel.writeString(LabelManager.serialize(mLabels));
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ConversationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */