import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class beg
  extends bec
{
  public static Uri g;
  public final long h;
  private final int i;
  private int j;
  private final int k;
  private int l;
  private final int m;
  private int n;
  private final int o;
  private int p;
  
  private beg(long paramLong1, String paramString, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong3)
  {
    super(paramLong1, paramString, paramLong2);
    i = paramInt1;
    j = paramInt2;
    k = paramInt3;
    l = paramInt4;
    m = paramInt5;
    n = paramInt6;
    o = paramInt7;
    p = paramInt8;
    h = paramLong3;
  }
  
  public static List<beg> a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    paramContext = paramContext.getContentResolver();
    Object localObject1 = a(paramContext, g, beh.a, paramLong);
    if (localObject1 == null) {
      return null;
    }
    nx localnx = new nx();
    for (;;)
    {
      long l1;
      Object localObject2;
      int i5;
      int i2;
      int i1;
      int i6;
      int i3;
      int i7;
      int i4;
      int i8;
      beg localbeg;
      try
      {
        if (!((Cursor)localObject1).moveToNext()) {
          break label409;
        }
        paramLong = ((Cursor)localObject1).getLong(0);
        l1 = ((Cursor)localObject1).getLong(1);
        localObject2 = ((Cursor)localObject1).getString(2);
        i5 = ((Cursor)localObject1).getInt(3);
        i2 = ((Cursor)localObject1).getInt(4);
        i1 = i2;
        if (i2 == -1) {
          i1 = i5;
        }
        i6 = ((Cursor)localObject1).getInt(5);
        i3 = ((Cursor)localObject1).getInt(6);
        if (paramBoolean) {
          break label605;
        }
        i2 = i3;
        if (i3 == -1) {
          break label605;
        }
        i7 = ((Cursor)localObject1).getInt(7);
        i4 = ((Cursor)localObject1).getInt(8);
        i3 = i4;
        if (i4 == -1) {
          i3 = i7;
        }
        i8 = ((Cursor)localObject1).getInt(9);
        int i9 = ((Cursor)localObject1).getInt(10);
        i4 = i9;
        if (i9 == -1) {
          i4 = i8;
        }
        localbeg = (beg)localnx.a(l1, null);
        if (localbeg != null)
        {
          if (f >= paramLong) {
            cvm.d("MessageStateChange", "Changes were not in ascending id order", new Object[0]);
          }
          if ((j != i5) || (l != i6)) {
            cvm.d("MessageStateChange", "existing change inconsistent with new change", new Object[0]);
          }
          j = i1;
          l = i2;
          n = i3;
          f = paramLong;
          continue;
        }
        l2 = bed.a(paramContext, l1);
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      long l2;
      if (l2 == -1L)
      {
        cvm.e("MessageStateChange", "No mailbox id for message %d", new Object[] { Long.valueOf(l1) });
      }
      else
      {
        localnx.b(l1, new beg(l1, (String)localObject2, paramLong, i5, i1, i6, i2, i7, i3, i8, i4, l2));
        continue;
        label409:
        ((Cursor)localObject1).close();
        i1 = localnx.a();
        localObject1 = new long[i1];
        localObject2 = new ArrayList(i1);
        i2 = 0;
        i1 = 0;
        if (i1 < localnx.a())
        {
          localbeg = (beg)localnx.c(i1);
          if ((e == null) || (e.length() == 0) || ((i == j) && (k == l) && (m == n) && (o == p)))
          {
            localObject1[i2] = d;
            i2 += 1;
          }
          for (;;)
          {
            i1 += 1;
            break;
            ((ArrayList)localObject2).add(localbeg);
          }
        }
        if (i2 != 0) {
          a(paramContext, g, (long[])localObject1, i2);
        }
        if (((ArrayList)localObject2).isEmpty()) {
          return null;
        }
        return (List<beg>)localObject2;
        label605:
        i2 = i6;
      }
    }
  }
  
  public static Set<Long> a(ContentResolver paramContentResolver, long paramLong)
  {
    Cursor localCursor = paramContentResolver.query(g, beh.a, "accountKey=?", new String[] { Long.toString(paramLong) }, null);
    HashSet localHashSet = new HashSet();
    for (;;)
    {
      if (localCursor != null) {}
      try
      {
        if (localCursor.moveToNext()) {
          localHashSet.add(Long.valueOf(bed.a(paramContentResolver, localCursor.getLong(1))));
        }
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    return localHashSet;
  }
  
  public static void a(ContentResolver paramContentResolver, long[] paramArrayOfLong, int paramInt)
  {
    a(paramContentResolver, g, paramArrayOfLong, paramInt);
  }
  
  public static void b(ContentResolver paramContentResolver, long[] paramArrayOfLong, int paramInt)
  {
    b(paramContentResolver, g, paramArrayOfLong, paramInt);
  }
  
  public final int a()
  {
    if (i == j) {
      return -1;
    }
    return j;
  }
  
  public final int b()
  {
    if (k == l) {
      return -1;
    }
    return l;
  }
  
  public final int c()
  {
    if (m == n) {
      return -1;
    }
    return n;
  }
  
  public final int d()
  {
    if (o == p) {
      return -1;
    }
    return p;
  }
}

/* Location:
 * Qualified Name:     beg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */