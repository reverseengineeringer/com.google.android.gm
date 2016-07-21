import android.content.CursorLoader;
import android.os.Looper;

final class cxp
  extends cua
{
  public cxp(cxo paramcxo, int paramInt)
  {
    super(Looper.myLooper(), paramInt);
  }
  
  protected final void b()
  {
    if (a.a != null) {
      a.a.startLoading();
    }
  }
}

/* Location:
 * Qualified Name:     cxp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */