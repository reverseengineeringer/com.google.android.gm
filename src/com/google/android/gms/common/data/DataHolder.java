package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import elj;
import elk;
import ell;
import elm;
import emj;
import enz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataHolder
  implements SafeParcelable
{
  public static final elm CREATOR = new elm();
  private static final elk l = new elj(new String[0]);
  final int a;
  final String[] b;
  public Bundle c;
  public final CursorWindow[] d;
  public final int e;
  public final Bundle f;
  int[] g;
  public int h;
  boolean i = false;
  public Object j;
  private boolean k = true;
  
  public DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    a = paramInt1;
    b = paramArrayOfString;
    d = paramArrayOfCursorWindow;
    e = paramInt2;
    f = paramBundle;
  }
  
  private DataHolder(elk paramelk, int paramInt, Bundle paramBundle)
  {
    this(a, a(paramelk), paramInt, null);
  }
  
  private DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    a = 1;
    b = ((String[])enz.a(paramArrayOfString));
    d = ((CursorWindow[])enz.a(paramArrayOfCursorWindow));
    e = paramInt;
    f = paramBundle;
    a();
  }
  
  private static CursorWindow[] a(elk paramelk)
  {
    int i2 = 0;
    if (a.length == 0) {
      return new CursorWindow[0];
    }
    ArrayList localArrayList2 = b;
    int i3 = localArrayList2.size();
    Object localObject2 = new CursorWindow(false);
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(localObject2);
    ((CursorWindow)localObject2).setNumColumns(a.length);
    int m = 0;
    int n = 0;
    Object localObject1;
    if (m < i3) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      int i1;
      try
      {
        if (!((CursorWindow)localObject2).allocRow())
        {
          new StringBuilder("Allocating additional cursor window for large data set (row ").append(m).append(")");
          localObject2 = new CursorWindow(false);
          ((CursorWindow)localObject2).setStartPosition(m);
          ((CursorWindow)localObject2).setNumColumns(a.length);
          localArrayList1.add(localObject2);
          localObject1 = localObject2;
          if (!((CursorWindow)localObject2).allocRow())
          {
            Log.e("DataHolder", "Unable to allocate row to hold data.");
            localArrayList1.remove(localObject2);
            return (CursorWindow[])localArrayList1.toArray(new CursorWindow[localArrayList1.size()]);
          }
        }
        localObject2 = (Map)localArrayList2.get(m);
        i1 = 0;
        bool = true;
        if ((i1 < a.length) && (bool))
        {
          String str = a[i1];
          Object localObject3 = ((Map)localObject2).get(str);
          if (localObject3 == null)
          {
            bool = ((CursorWindow)localObject1).putNull(m, i1);
            break label654;
          }
          if ((localObject3 instanceof String))
          {
            bool = ((CursorWindow)localObject1).putString((String)localObject3, m, i1);
            break label654;
          }
          if ((localObject3 instanceof Long))
          {
            bool = ((CursorWindow)localObject1).putLong(((Long)localObject3).longValue(), m, i1);
            break label654;
          }
          if ((localObject3 instanceof Integer))
          {
            bool = ((CursorWindow)localObject1).putLong(((Integer)localObject3).intValue(), m, i1);
            break label654;
          }
          if ((localObject3 instanceof Boolean))
          {
            if (!((Boolean)localObject3).booleanValue()) {
              break label661;
            }
            l1 = 1L;
            bool = ((CursorWindow)localObject1).putLong(l1, m, i1);
            break label654;
          }
          if ((localObject3 instanceof byte[]))
          {
            bool = ((CursorWindow)localObject1).putBlob((byte[])localObject3, m, i1);
            break label654;
          }
          if ((localObject3 instanceof Double))
          {
            bool = ((CursorWindow)localObject1).putDouble(((Double)localObject3).doubleValue(), m, i1);
            break label654;
          }
          if ((localObject3 instanceof Float))
          {
            bool = ((CursorWindow)localObject1).putDouble(((Float)localObject3).floatValue(), m, i1);
            break label654;
          }
          throw new IllegalArgumentException("Unsupported object for column " + str + ": " + localObject3);
        }
      }
      catch (RuntimeException paramelk)
      {
        boolean bool;
        n = localArrayList1.size();
        m = i2;
        if (m < n)
        {
          ((CursorWindow)localArrayList1.get(m)).close();
          m += 1;
          continue;
          if (!bool)
          {
            if (n != 0) {
              throw new ell("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
            }
            new StringBuilder("Couldn't populate window data for row ").append(m).append(" - allocating new window.");
            ((CursorWindow)localObject1).freeLastRow();
            localObject1 = new CursorWindow(false);
            ((CursorWindow)localObject1).setStartPosition(m);
            ((CursorWindow)localObject1).setNumColumns(a.length);
            localArrayList1.add(localObject1);
            n = m - 1;
            m = 1;
            i1 = m;
            m = n + 1;
            localObject2 = localObject1;
            n = i1;
            break;
          }
          i1 = 0;
          n = m;
          m = i1;
          continue;
        }
        throw paramelk;
      }
      return (CursorWindow[])localArrayList1.toArray(new CursorWindow[localArrayList1.size()]);
      label654:
      i1 += 1;
      continue;
      label661:
      long l1 = 0L;
    }
  }
  
  public static DataHolder b(int paramInt)
  {
    return new DataHolder(l, paramInt, null);
  }
  
  public final int a(int paramInt)
  {
    int n = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < h))
    {
      bool = true;
      enz.a(bool);
    }
    for (;;)
    {
      int m = n;
      if (n < g.length)
      {
        if (paramInt < g[n]) {
          m = n - 1;
        }
      }
      else
      {
        paramInt = m;
        if (m == g.length) {
          paramInt = m - 1;
        }
        return paramInt;
        bool = false;
        break;
      }
      n += 1;
    }
  }
  
  public final String a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1);
    return d[paramInt2].getString(paramInt1, c.getInt(paramString));
  }
  
  public final void a()
  {
    int n = 0;
    c = new Bundle();
    int m = 0;
    while (m < b.length)
    {
      c.putInt(b[m], m);
      m += 1;
    }
    g = new int[d.length];
    int i1 = 0;
    m = n;
    n = i1;
    while (m < d.length)
    {
      g[m] = n;
      i1 = d[m].getStartPosition();
      n += d[m].getNumRows() - (n - i1);
      m += 1;
    }
    h = n;
  }
  
  public final void a(String paramString, int paramInt)
  {
    if ((c == null) || (!c.containsKey(paramString))) {
      throw new IllegalArgumentException("No such column: " + paramString);
    }
    if (b()) {
      throw new IllegalArgumentException("Buffer is closed.");
    }
    if ((paramInt < 0) || (paramInt >= h)) {
      throw new CursorIndexOutOfBoundsException(paramInt, h);
    }
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = i;
      return bool;
    }
    finally {}
  }
  
  public final void c()
  {
    try
    {
      if (!i)
      {
        i = true;
        int m = 0;
        while (m < d.length)
        {
          d[m].close();
          m += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  /* Error */
  protected final void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/google/android/gms/common/data/DataHolder:k	Z
    //   4: ifeq +79 -> 83
    //   7: aload_0
    //   8: getfield 59	com/google/android/gms/common/data/DataHolder:d	[Landroid/database/CursorWindow;
    //   11: arraylength
    //   12: ifle +71 -> 83
    //   15: aload_0
    //   16: invokevirtual 283	com/google/android/gms/common/data/DataHolder:b	()Z
    //   19: ifne +64 -> 83
    //   22: aload_0
    //   23: getfield 294	com/google/android/gms/common/data/DataHolder:j	Ljava/lang/Object;
    //   26: ifnonnull +62 -> 88
    //   29: new 116	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 296
    //   36: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: invokevirtual 297	java/lang/Object:toString	()Ljava/lang/String;
    //   43: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_1
    //   50: ldc_w 299
    //   53: new 116	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 301
    //   60: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 127
    //   69: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 303	com/google/android/gms/common/data/DataHolder:c	()V
    //   83: aload_0
    //   84: invokespecial 305	java/lang/Object:finalize	()V
    //   87: return
    //   88: aload_0
    //   89: getfield 294	com/google/android/gms/common/data/DataHolder:j	Ljava/lang/Object;
    //   92: invokevirtual 297	java/lang/Object:toString	()Ljava/lang/String;
    //   95: astore_1
    //   96: goto -46 -> 50
    //   99: astore_1
    //   100: aload_0
    //   101: invokespecial 305	java/lang/Object:finalize	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	DataHolder
    //   49	47	1	str	String
    //   99	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	50	99	finally
    //   50	83	99	finally
    //   88	96	99	finally
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, d, paramInt);
    emj.b(paramParcel, 3, e);
    emj.a(paramParcel, 4, f);
    emj.b(paramParcel, m);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.data.DataHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */