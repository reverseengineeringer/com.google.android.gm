import com.android.emailcommon.provider.Account;
import java.util.concurrent.locks.ReentrantLock;

final class bso
  extends bsq<Void>
{
  bso(brw parambrw, long paramLong1, long paramLong2)
  {
    super(parambrw, (byte)0);
  }
  
  private final Void c()
  {
    Object localObject1 = Account.a(c.c, a);
    if (brw.a(c.c, (Account)localObject1)) {
      c.d.a((Account)localObject1, b);
    }
    for (;;)
    {
      return null;
      localObject1 = c.d;
      long l = a;
      a.lock();
      try
      {
        cvm.c("Exchange", "PSS pushStop acct:%d", new Object[] { Long.valueOf(l) });
        bsu localbsu = ((bst)localObject1).a(l, false);
        if (localbsu != null) {
          localbsu.a();
        }
        a.unlock();
      }
      finally
      {
        a.unlock();
      }
    }
  }
}

/* Location:
 * Qualified Name:     bso
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */