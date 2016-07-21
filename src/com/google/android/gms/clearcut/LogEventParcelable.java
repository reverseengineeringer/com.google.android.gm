package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import ehl;
import eho;
import emj;
import enw;
import enx;
import fmy;
import java.util.Arrays;
import java.util.List;

public class LogEventParcelable
  implements SafeParcelable
{
  public static final eho CREATOR = new eho();
  public final int a;
  public PlayLoggerContext b;
  public byte[] c;
  public int[] d;
  public final fmy e;
  public final ehl f;
  public final ehl g;
  
  public LogEventParcelable(int paramInt, PlayLoggerContext paramPlayLoggerContext, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    a = paramInt;
    b = paramPlayLoggerContext;
    c = paramArrayOfByte;
    d = paramArrayOfInt;
    e = null;
    f = null;
    g = null;
  }
  
  public LogEventParcelable(PlayLoggerContext paramPlayLoggerContext, fmy paramfmy, ehl paramehl1, ehl paramehl2, int[] paramArrayOfInt)
  {
    a = 1;
    b = paramPlayLoggerContext;
    e = paramfmy;
    f = paramehl1;
    g = paramehl2;
    d = paramArrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LogEventParcelable)) {
        break;
      }
      paramObject = (LogEventParcelable)paramObject;
    } while ((a == a) && (enx.a(b, b)) && (Arrays.equals(c, c)) && (Arrays.equals(d, d)) && (enx.a(e, e)) && (enx.a(f, f)) && (enx.a(g, g)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(a), b, c, d, e, f, g });
  }
  
  public String toString()
  {
    List localList = null;
    StringBuilder localStringBuilder = new StringBuilder("LogEventParcelable[");
    localStringBuilder.append(a);
    localStringBuilder.append(", ");
    localStringBuilder.append(b);
    localStringBuilder.append(", ");
    if (c == null)
    {
      localObject = null;
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", ");
      if (d != null) {
        break label156;
      }
    }
    for (Object localObject = localList;; localObject = ((enw)localObject).a(new StringBuilder(), localList).toString())
    {
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(e);
      localStringBuilder.append(", ");
      localStringBuilder.append(f);
      localStringBuilder.append(", ");
      localStringBuilder.append(g);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localObject = new String(c);
      break;
      label156:
      localObject = new enw(", ");
      localList = Arrays.asList(new int[][] { d });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.clearcut.LogEventParcelable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */