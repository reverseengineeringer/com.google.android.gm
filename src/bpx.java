import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import com.android.emailcommon.provider.Account;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;

public final class bpx
  extends bqc
{
  private bed a;
  private bpy b;
  
  public bpx(Context paramContext, Account paramAccount)
  {
    super(paramContext, paramAccount);
  }
  
  protected final int a(bns parambns)
  {
    if (!parambns.e())
    {
      parambns = new bov(parambns.d());
      parambns.d();
      String str1 = c;
      String str2 = b;
      if (a == 0) {
        cvm.e("Exchange", "Trying to get status for MoveItems, but no status was set", new Object[0]);
      }
      for (int i = 3;; i = a)
      {
        b = new bpy(str1, str2, i);
        return 0;
      }
    }
    return 101;
  }
  
  protected final String b()
  {
    return "MoveItems";
  }
  
  protected final HttpEntity c()
  {
    bpi localbpi = new bpi();
    localbpi.a(325);
    localbpi.a(326);
    localbpi.b(327, a.e);
    localbpi.b(328, a.k);
    localbpi.b(329, a.l);
    localbpi.b();
    localbpi.b().a();
    return a(localbpi);
  }
  
  public final int j()
  {
    Object localObject1 = bed.a(f, g.D);
    if (localObject1 == null)
    {
      i = 100;
      return i;
    }
    int i = ((List)localObject1).size();
    long[][] arrayOfLong = (long[][])Array.newInstance(Long.TYPE, new int[] { 3, i });
    int[] arrayOfInt = new int[3];
    Iterator localIterator = ((List)localObject1).iterator();
    i = 100;
    int j;
    if (localIterator.hasNext())
    {
      a = ((bed)localIterator.next());
      if (i >= 0)
      {
        j = 1;
        label99:
        if (j == 0) {
          break label485;
        }
        i = p_();
      }
    }
    label114:
    label171:
    label205:
    label247:
    label311:
    label363:
    label407:
    label412:
    label417:
    label485:
    for (;;)
    {
      bed localbed;
      bpy localbpy;
      Object localObject2;
      if (i >= 0)
      {
        j = 1;
        if (j == 0) {
          break label412;
        }
        if (i != 0) {
          break label407;
        }
        localbed = a;
        localbpy = b;
        if (a != null) {
          break label311;
        }
        cvm.e("Exchange", "MoveItems response for message %d has no SrcMsgId, using request's server id", new Object[] { Long.valueOf(d) });
        localObject1 = e;
        localObject2 = new ContentValues(1);
        if (c != 2) {
          break label363;
        }
        ((ContentValues)localObject2).put("mailboxKey", Long.valueOf(i));
        if (((ContentValues)localObject2).size() != 0) {
          f.getContentResolver().update(ContentUris.withAppendedId(beb.a, d), (ContentValues)localObject2, null, null);
        }
        j = b.c;
        if (j > 0) {
          break label417;
        }
        cvm.e("Exchange", "MoveItems gave us an invalid status %d", new Object[] { Integer.valueOf(j) });
        j = 2;
      }
      for (;;)
      {
        arrayOfLong[j][arrayOfInt[j]] = a.d;
        arrayOfInt[j] += 1;
        break;
        j = 0;
        break label99;
        j = 0;
        break label114;
        localObject2 = a;
        localObject1 = localObject2;
        if (((String)localObject2).equals(e)) {
          break label171;
        }
        cvm.e("Exchange", "MoveItems response for message %d has SrcMsgId != request's server id", new Object[] { Long.valueOf(d) });
        localObject1 = localObject2;
        break label171;
        if ((c != 1) || (b == null) || (b.equals(localObject1))) {
          break label205;
        }
        ((ContentValues)localObject2).put("syncServerId", b);
        break label205;
        j = 3;
        break label247;
        j = 3;
        break label247;
        j -= 1;
      }
      localObject1 = f.getContentResolver();
      bed.a((ContentResolver)localObject1, arrayOfLong[0], arrayOfInt[0]);
      bed.c((ContentResolver)localObject1, arrayOfLong[1], arrayOfInt[1]);
      bed.b((ContentResolver)localObject1, arrayOfLong[2], arrayOfInt[2]);
      if (i >= 0) {}
      for (j = 1; j != 0; j = 0) {
        return 0;
      }
      break;
    }
  }
}

/* Location:
 * Qualified Name:     bpx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */