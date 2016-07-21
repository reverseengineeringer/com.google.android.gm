import android.content.Context;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class dql
  extends bbi
{
  private dmo b;
  
  public final void a(bbk parambbk)
  {
    int j = 1;
    dmo localdmo = b;
    int i;
    label59:
    label81:
    label108:
    Object localObject1;
    if (!localdmo.a())
    {
      i = ghz.a(d.getContentResolver(), "snapshot_sample_rate_divisor", 200);
      hkh localhkh;
      if (i <= 0)
      {
        dri.f(dmo.a, "ClearcutApiHelper: Snapshot logging disabled  with sampling divisor: %d", new Object[] { Integer.valueOf(i) });
        i = 0;
        if (i == 0) {
          break label993;
        }
        localhkh = new hkh();
        if (!c) {
          break label376;
        }
        i = 2;
        b = i;
        a |= 0x1;
        if (!b) {
          break label381;
        }
        i = 1;
        c = i;
        a |= 0x2;
        d = p;
        a |= 0x4;
        e = q;
        a |= 0x8;
        f = r;
        a |= 0x10;
        l = f;
        a |= 0x80;
        m = g;
        a |= 0x100;
        long l = s;
        if (l != 0L)
        {
          g = (n - l);
          a |= 0x20;
        }
        localObject1 = new HashSet();
        localObject2 = d.values().iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label401;
        }
        if (nextb)
        {
          ((Set)localObject1).add(Integer.valueOf(1));
          continue;
          dri.a(dmo.a, "Sync metrics sample rate: 1/%d", new Object[] { Integer.valueOf(i) });
          if (dza.a.nextInt(i) != 0) {
            break;
          }
          i = 1;
          break label59;
          label376:
          i = 1;
          break label81;
          label381:
          i = 2;
          break label108;
        }
        ((Set)localObject1).add(Integer.valueOf(2));
      }
      label401:
      Object localObject2 = new int[((Set)localObject1).size()];
      Iterator localIterator = ((Set)localObject1).iterator();
      i = 0;
      while (i < ((Set)localObject1).size())
      {
        localObject2[i] = ((Integer)localIterator.next()).intValue();
        i += 1;
      }
      h = ((int[])localObject2);
      if (c) {
        i = dmo.a(e);
      }
      j = parambbk.f();
      a |= 0x40;
      localObject1 = y;
      if (localObject1 != null)
      {
        n = a;
        a |= 0x200;
        p = c;
        a |= 0x800;
        o = b;
        a |= 0x400;
      }
      k = parambbk.e();
      localObject1 = new hkg();
      b = localhkh;
      c = v;
      a |= 0x1;
      d = w;
      a |= 0x2;
      e = u;
      a |= 0x4;
      parambbk = cui.a(cui.b(m));
      i = -1;
      switch (parambbk.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          j = 18;
        }
        break;
      }
    }
    for (;;)
    {
      f = j;
      a |= 0x8;
      parambbk = new hkn();
      e = ((hkg)localObject1);
      localdmo.a(parambbk, null);
      dri.b(dmo.a, "ClearcutApiHelper: Successfully logged sync data", new Object[0]);
      label993:
      return;
      if (!parambbk.equals("gmail")) {
        break;
      }
      i = 0;
      break;
      if (!parambbk.equals("hotmail")) {
        break;
      }
      i = 1;
      break;
      if (!parambbk.equals("yahoo")) {
        break;
      }
      i = 2;
      break;
      if (!parambbk.equals("aol")) {
        break;
      }
      i = 3;
      break;
      if (!parambbk.equals("apple")) {
        break;
      }
      i = 4;
      break;
      if (!parambbk.equals("mail.ru")) {
        break;
      }
      i = 5;
      break;
      if (!parambbk.equals("qq.com")) {
        break;
      }
      i = 6;
      break;
      if (!parambbk.equals("comcast")) {
        break;
      }
      i = 7;
      break;
      if (!parambbk.equals("rediffmail")) {
        break;
      }
      i = 8;
      break;
      if (!parambbk.equals("docomo")) {
        break;
      }
      i = 9;
      break;
      if (!parambbk.equals("bol.com.br")) {
        break;
      }
      i = 10;
      break;
      if (!parambbk.equals("163.com")) {
        break;
      }
      i = 11;
      break;
      if (!parambbk.equals("ig.com.br")) {
        break;
      }
      i = 12;
      break;
      if (!parambbk.equals("terra.com.br")) {
        break;
      }
      i = 13;
      break;
      if (!parambbk.equals("verizon")) {
        break;
      }
      i = 14;
      break;
      if (!parambbk.equals("uol.com.br")) {
        break;
      }
      i = 15;
      break;
      if (!parambbk.equals("orange")) {
        break;
      }
      i = 16;
      break;
      if (!parambbk.equals("other")) {
        break;
      }
      i = 17;
      break;
      j = 2;
      continue;
      j = 3;
      continue;
      j = 4;
      continue;
      j = 5;
      continue;
      j = 6;
      continue;
      j = 7;
      continue;
      j = 8;
      continue;
      j = 9;
      continue;
      j = 10;
      continue;
      j = 11;
      continue;
      j = 12;
      continue;
      j = 13;
      continue;
      j = 14;
      continue;
      j = 15;
      continue;
      j = 16;
      continue;
      j = 17;
      continue;
      j = 18;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    b = new dmo(this);
  }
}

/* Location:
 * Qualified Name:     dql
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */