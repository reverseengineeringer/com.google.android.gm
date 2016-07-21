import android.util.Log;
import java.util.Iterator;
import java.util.List;

public final class gnc
  implements Runnable
{
  public gnc(gnf paramgnf, gnh paramgnh, gnd paramgnd) {}
  
  public final void run()
  {
    try
    {
      gna localgna1 = a.a();
      gol.a(localgna1);
      gnh localgnh = b;
      synchronized (a)
      {
        if (d) {
          return;
        }
        try
        {
          Iterator localIterator = b.a.iterator();
          while (localIterator.hasNext())
          {
            localgna1.a((hri)localIterator.next());
            continue;
            localObject2 = finally;
          }
        }
        catch (Exception localException2)
        {
          localgnh.a();
          throw localException2;
        }
        finally
        {
          b = null;
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      b.a();
      if (c != null)
      {
        c.a(localException1);
        return;
        c = localgna2;
        b = null;
        return;
      }
      Log.e("TransmitterFactory", "provider failed, but no callback", localException1);
    }
  }
}

/* Location:
 * Qualified Name:     gnc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */