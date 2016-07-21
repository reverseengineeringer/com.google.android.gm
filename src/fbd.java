import android.os.Looper;
import java.util.concurrent.CountDownLatch;

final class fbd
  extends Thread
{
  fbd(fbc paramfbc, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    try
    {
      Looper.prepare();
      b.d = new fbe(b);
      b.e = false;
      a.countDown();
      ffg.a("DriveEventService", "Bound and starting loop");
      Looper.loop();
      ffg.a("DriveEventService", "Finished loop");
      return;
    }
    finally
    {
      if (b.c != null) {
        b.c.countDown();
      }
    }
  }
}

/* Location:
 * Qualified Name:     fbd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */