import android.os.Handler;
import android.os.Message;

final class bia
  extends Handler
{
  bia(bhx parambhx) {}
  
  public final void a()
  {
    sendMessageDelayed(obtainMessage(1, 0, 0, null), 1000L);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (a.k > 0) {
      a.a(a.b());
    }
  }
}

/* Location:
 * Qualified Name:     bia
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */