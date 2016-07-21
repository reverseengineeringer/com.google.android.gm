package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fyf;
import java.util.Iterator;
import java.util.Set;

public class LogEvent
  implements SafeParcelable
{
  public static final fyf CREATOR = new fyf();
  public final int a;
  public final long b;
  public final long c;
  public final String d;
  public final byte[] e;
  public final Bundle f;
  
  public LogEvent(int paramInt, long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a = paramInt;
    b = paramLong1;
    c = paramLong2;
    d = paramString;
    e = paramArrayOfByte;
    f = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag=").append(d).append(",");
    localStringBuilder.append("eventTime=").append(b).append(",");
    localStringBuilder.append("eventUptime=").append(c).append(",");
    if ((f != null) && (!f.isEmpty()))
    {
      localStringBuilder.append("keyValues=");
      Iterator localIterator = f.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append("(").append(str).append(",");
        localStringBuilder.append(f.getString(str)).append(")");
        localStringBuilder.append(" ");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, d, false);
    emj.a(paramParcel, 4, e, false);
    emj.a(paramParcel, 5, f);
    emj.a(paramParcel, 6, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.LogEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */