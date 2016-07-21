package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ebh;
import emj;
import enx;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CorpusStatus
  implements SafeParcelable
{
  public static final ebh CREATOR = new ebh();
  final int a;
  public final boolean b;
  final long c;
  public final long d;
  final long e;
  final Bundle f;
  final String g;
  
  CorpusStatus()
  {
    this(2, false, 0L, 0L, 0L, null, null);
  }
  
  public CorpusStatus(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, Bundle paramBundle, String paramString)
  {
    a = paramInt;
    b = paramBoolean;
    c = paramLong1;
    d = paramLong2;
    e = paramLong3;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    f = localBundle;
    g = paramString;
  }
  
  private final Map<String, Integer> a()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = f.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = f.getInt(str, -1);
      if (i != -1) {
        localHashMap.put(str, Integer.valueOf(i));
      }
    }
    return localHashMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof CorpusStatus))
    {
      paramObject = (CorpusStatus)paramObject;
      bool1 = bool2;
      if (enx.a(Boolean.valueOf(b), Boolean.valueOf(b)))
      {
        bool1 = bool2;
        if (enx.a(Long.valueOf(c), Long.valueOf(c)))
        {
          bool1 = bool2;
          if (enx.a(Long.valueOf(d), Long.valueOf(d)))
          {
            bool1 = bool2;
            if (enx.a(Long.valueOf(e), Long.valueOf(e)))
            {
              bool1 = bool2;
              if (enx.a(a(), ((CorpusStatus)paramObject).a())) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Boolean.valueOf(b), Long.valueOf(c), Long.valueOf(d), Long.valueOf(e), a() });
  }
  
  public String toString()
  {
    return "CorpusStatus{found=" + b + ", lastIndexedSeqno=" + c + ", lastCommittedSeqno=" + d + ", committedNumDocuments=" + e + ", counters=" + f + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.a(paramParcel, 3, d);
    emj.a(paramParcel, 4, e);
    emj.a(paramParcel, 5, f);
    emj.a(paramParcel, 6, g, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.CorpusStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */