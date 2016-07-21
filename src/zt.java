import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

final class zt
  implements View.OnClickListener
{
  zt(zs paramzs) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView == a.n) && (a.p != null)) {
      paramView = Message.obtain(a.p);
    }
    for (;;)
    {
      if (paramView != null) {
        paramView.sendToTarget();
      }
      a.M.obtainMessage(1, a.b).sendToTarget();
      return;
      if ((paramView == a.q) && (a.s != null)) {
        paramView = Message.obtain(a.s);
      } else if ((paramView == a.t) && (a.v != null)) {
        paramView = Message.obtain(a.v);
      } else {
        paramView = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     zt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */