import android.os.Handler.Callback;
import android.os.Message;

final class bw
  implements Handler.Callback
{
  bw(bv parambv) {}
  
  public final boolean handleMessage(Message arg1)
  {
    switch (what)
    {
    default: 
      return false;
    }
    bv localbv = a;
    by localby = (by)obj;
    synchronized (a)
    {
      if ((b == localby) || (c == localby)) {
        localbv.a(localby);
      }
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     bw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */