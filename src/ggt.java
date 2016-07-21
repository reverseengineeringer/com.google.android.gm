import com.google.android.gms.wearable.internal.PutDataResponse;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

final class ggt
  extends ggp<gdo>
{
  private final List<FutureTask<Boolean>> a;
  
  ggt(ejr<gdo> paramejr, List<FutureTask<Boolean>> paramList)
  {
    super(paramejr);
    a = paramList;
  }
  
  public final void a(PutDataResponse paramPutDataResponse)
  {
    a(new ghr(ggl.a(b), c));
    if (b != 0)
    {
      paramPutDataResponse = a.iterator();
      while (paramPutDataResponse.hasNext()) {
        ((FutureTask)paramPutDataResponse.next()).cancel(true);
      }
    }
  }
}

/* Location:
 * Qualified Name:     ggt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */