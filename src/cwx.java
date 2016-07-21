import android.os.Handler;
import java.util.TimerTask;

public final class cwx
  extends TimerTask
{
  boolean a;
  
  public cwx(cww paramcww) {}
  
  public final boolean cancel()
  {
    a = true;
    return super.cancel();
  }
  
  public final void run()
  {
    b.b.post(new cwy(this));
  }
}

/* Location:
 * Qualified Name:     cwx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */