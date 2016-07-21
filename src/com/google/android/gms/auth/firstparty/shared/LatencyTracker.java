package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import egk;
import emj;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class LatencyTracker
  implements SafeParcelable
{
  public static final egk CREATOR = new egk();
  final int a;
  final String b;
  final long c;
  public final LatencyTracker d;
  
  public LatencyTracker(int paramInt, String paramString, long paramLong, LatencyTracker paramLatencyTracker)
  {
    a = paramInt;
    b = paramString;
    c = paramLong;
    d = paramLatencyTracker;
    a(paramString, "constructed");
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if (Log.isLoggable("GLSLogging", 2))
    {
      long l1 = SystemClock.elapsedRealtime();
      LinkedList localLinkedList = new LinkedList();
      for (Object localObject = this; localObject != null; localObject = d)
      {
        long l2 = l1 - c;
        long l3 = TimeUnit.MILLISECONDS.toSeconds(l2);
        long l4 = TimeUnit.SECONDS.toMillis(l3);
        localLinkedList.addFirst(String.format("[%s, %,d.%03ds]", new Object[] { b, Long.valueOf(l3), Long.valueOf(l2 - l4) }));
      }
      localObject = TextUtils.join(" > ", localLinkedList);
      Log.println(2, "GLSLogging", paramString1 + " " + (String)localObject + " > " + paramString2);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a(b, "writing to parcel");
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.LatencyTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */