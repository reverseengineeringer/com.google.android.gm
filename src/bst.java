import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class bst
{
  public final ReentrantLock a = new ReentrantLock();
  public final nx<bsu> b = new nx();
  final Service c;
  
  public bst(Service paramService)
  {
    c = paramService;
  }
  
  private final void a(long paramLong)
  {
    cvm.c("Exchange", "PSS removing account state for acct:%d", new Object[] { Long.valueOf(paramLong) });
    b.a(paramLong);
    if (b.a() == 0)
    {
      cvm.c("Exchange", "PSS removed last account; stopping service.", new Object[0]);
      c.stopSelf();
    }
  }
  
  final bsu a(long paramLong, boolean paramBoolean)
  {
    bsu localbsu2 = (bsu)b.a(paramLong, null);
    bsu localbsu1 = localbsu2;
    if (localbsu2 == null)
    {
      localbsu1 = localbsu2;
      if (paramBoolean)
      {
        cvm.c("Exchange", "PSS adding account state for acct:%d", new Object[] { Long.valueOf(paramLong) });
        localbsu2 = new bsu(this, a, paramLong);
        b.b(paramLong, localbsu2);
        localbsu1 = localbsu2;
        if (b.a() == 1)
        {
          cvm.c("Exchange", "PSS added first account, starting service", new Object[0]);
          c.startService(new Intent(c, c.getClass()));
          localbsu1 = localbsu2;
        }
      }
    }
    return localbsu1;
  }
  
  public final void a(int paramInt, com.android.emailcommon.provider.Account paramAccount)
  {
    int i = 2;
    a.lock();
    for (;;)
    {
      bsu localbsu;
      Object localObject;
      try
      {
        long l = D;
        cvm.c("Exchange", "PSS syncEnd for account acct:%d", new Object[] { Long.valueOf(D) });
        localbsu = a(l, false);
        if (localbsu == null)
        {
          cvm.d("Exchange", "PSS syncEnd for account %d but no state found", new Object[] { Long.valueOf(l) });
          return;
        }
        c -= 1;
        if (c > 0)
        {
          cvm.c("Exchange", "PSS Signalling a pending sync to proceed acct:%d.", new Object[] { Long.valueOf(D) });
          d.signal();
          paramInt = 0;
          if (paramInt != 0) {
            a(l);
          }
          return;
        }
        localObject = bnq.c;
        if (b == 0)
        {
          cvm.c("Exchange", "PSS push enabled is unknown", new Object[0]);
          if (g) {
            b = 1;
          }
        }
        else
        {
          if (b == 1)
          {
            if ((paramInt != -7) && (paramInt != -8)) {
              break label296;
            }
            cvm.d("Exchange", "PSS last sync had auth error, canceling ping acct:%d.", new Object[] { Long.valueOf(D) });
          }
          cvm.c("Exchange", "PSS no push enabled acct:%d.", new Object[] { Long.valueOf(D) });
          paramInt = 1;
          continue;
        }
        if (brw.a(h.c, paramAccount)) {
          i = 1;
        }
        b = i;
        continue;
        if (paramInt >= 0) {}
      }
      finally
      {
        a.unlock();
      }
      label296:
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          cvm.c("Exchange", "PSS last sync had error %d, scheduling delayed ping acct:%d.", new Object[] { Integer.valueOf(paramInt), Long.valueOf(D) });
          localObject = new android.accounts.Account(d, (String)localObject);
          bsu.a(c, D, (android.accounts.Account)localObject, bsu.a(f));
          paramInt = 1;
          break;
        }
        localObject = new android.accounts.Account(d, (String)localObject);
        if (f == 0L)
        {
          cvm.c("Exchange", "PSS last sync succeeded, starting new ping acct:%d", new Object[] { Long.valueOf(D) });
          a = new bsv(c, paramAccount, (android.accounts.Account)localObject, this);
          a.a();
          break label507;
        }
        cvm.c("Exchange", "PSS last sync succeeded, scheduling delayed ping acct:%d", new Object[] { Long.valueOf(D) });
        bsu.a(h.c, e, (android.accounts.Account)localObject, f);
        break label507;
      }
      label507:
      paramInt = 0;
    }
  }
  
  public final void a(long paramLong, android.accounts.Account paramAccount, int paramInt)
  {
    int i = 1;
    a.lock();
    bsu localbsu;
    try
    {
      cvm.c("Exchange", "PSS pingEnd for account %d", new Object[] { Long.valueOf(paramLong) });
      localbsu = a(paramLong, false);
      if (localbsu == null)
      {
        cvm.d("Exchange", "PSS pingEnd for account %d but no state found", new Object[] { Long.valueOf(paramLong) });
        return;
      }
      a = null;
      if (c > 0)
      {
        cvm.c("Exchange", "PSS pingEnd, syncs still in progress acct:%d.", new Object[] { Long.valueOf(e) });
        d.signal();
        paramInt = 0;
        if (paramInt != 0) {
          a(paramLong);
        }
        return;
      }
      if ((b != 1) && (b != 0)) {
        break label454;
      }
      if (b == 0) {
        cvm.e("Exchange", "PSS pingEnd, with mPushEnabled UNKNOWN?", new Object[0]);
      }
      cvm.c("Exchange", "PSS pingEnd, acct:%d, status %d", new Object[] { Long.valueOf(e), Integer.valueOf(paramInt) });
      if ((paramInt == -4) || (paramInt == -102) || (paramInt == -103))
      {
        long l = bsu.a(f);
        cvm.c("Exchange", "PSS pingEnd delaying ping %d", new Object[] { Long.valueOf(l) });
        bsu.a(h.c, e, paramAccount, l);
      }
      else if (paramInt == -101)
      {
        f = bsu.a(f);
        cvm.c("Exchange", "PSS pingEnd, syncing and delaying ping %d ms", new Object[] { Long.valueOf(f) });
      }
    }
    finally
    {
      a.unlock();
    }
    if (paramInt == 101)
    {
      f = 0L;
      cvm.c("Exchange", "PSS pingEnd starting new ping %d", new Object[] { Integer.valueOf(paramInt) });
      bqi.b(paramAccount, 0L);
    }
    for (;;)
    {
      label375:
      cvm.d("Exchange", "PSS pingEnd authentication error %d, canceling", new Object[] { Integer.valueOf(paramInt) });
      label454:
      label484:
      do
      {
        cvm.d("Exchange", "PSS pingEnd unexpected error %d, delaying %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(f) });
        bsu.a(h.c, e, paramAccount, f);
        break label484;
        cvm.c("Exchange", "PSS pingEnd, no longer need ping acct:%d.", new Object[] { Long.valueOf(e) });
        paramInt = i;
        break;
        paramInt = 0;
        break;
        if (paramInt == -7) {
          break label375;
        }
      } while (paramInt != -8);
    }
  }
  
  public final void a(com.android.emailcommon.provider.Account paramAccount)
  {
    a.lock();
    try
    {
      long l = D;
      cvm.c("Exchange", "PSS resetDelayTime acct:%d", new Object[] { Long.valueOf(l) });
      af = 0L;
      return;
    }
    finally
    {
      a.unlock();
    }
  }
  
  public final void a(com.android.emailcommon.provider.Account paramAccount, long paramLong)
  {
    a.lock();
    for (;;)
    {
      try
      {
        long l = D;
        cvm.c("Exchange", "PSS pushModify acct:%d", new Object[] { Long.valueOf(l) });
        bsu localbsu = a(l, true);
        cvm.c("Exchange", "PSS pushModify acct:%d", new Object[] { Long.valueOf(D) });
        b = 1;
        android.accounts.Account localAccount = new android.accounts.Account(d, bnq.c);
        if (c == 0)
        {
          if (a == null)
          {
            cvm.c("Exchange", "PSS starting ping task acct:%d", new Object[] { Long.valueOf(D) });
            a = new bsv(c, paramAccount, localAccount, this);
            a.a();
            paramAccount = new Bundle(1);
            paramAccount.putBoolean("__push_only__", true);
            ContentResolver.addPeriodicSync(localAccount, bdv.F, paramAccount, 3600L);
            f = paramLong;
            return;
          }
          cvm.c("Exchange", "PSS restarting ping task acct:%d", new Object[] { Long.valueOf(D) });
          a.a.h.a(2);
          continue;
        }
      }
      finally
      {
        a.unlock();
      }
      tmp253_250[0] = Long.valueOf(D);
      cvm.c("Exchange", "PSS syncs still in progress acct:%d", tmp253_250);
    }
  }
}

/* Location:
 * Qualified Name:     bst
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */