import android.os.Looper;

public final class ekv<L>
{
  public volatile L a;
  private final ekw b;
  
  ekv(Looper paramLooper, L paramL)
  {
    b = new ekw(this, paramLooper);
    a = enz.a(paramL, "Listener must not be null");
  }
  
  public final void a(ekx<? super L> paramekx)
  {
    enz.a(paramekx, "Notifier must not be null");
    paramekx = b.obtainMessage(1, paramekx);
    b.sendMessage(paramekx);
  }
}

/* Location:
 * Qualified Name:     ekv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */