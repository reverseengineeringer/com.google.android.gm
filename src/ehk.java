import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.TimeZone;

public final class ehk
{
  public String a = ehi.c(b);
  private int c = ehi.a(b);
  private String d = ehi.b(b);
  private String e = ehi.d(b);
  private int f = ehi.e(b);
  private final ehl g;
  private ehl h;
  private ArrayList<Integer> i = null;
  private final fmy j = new fmy();
  private boolean k = false;
  
  public ehk(ehi paramehi, ehl paramehl)
  {
    this(paramehi, null, paramehl);
  }
  
  public ehk(ehi paramehi, byte[] paramArrayOfByte)
  {
    this(paramehi, paramArrayOfByte, null);
  }
  
  private ehk(ehi paramehi, byte[] paramArrayOfByte, ehl paramehl)
  {
    a = ehi.c(paramehi);
    e = ehi.d(paramehi);
    j.a = ehi.f(paramehi).a();
    j.b = ehi.f(paramehi).b();
    fmy localfmy = j;
    ehi.g(paramehi);
    long l = j.a;
    p = (TimeZone.getDefault().getOffset(l) / 1000);
    if (paramArrayOfByte != null) {
      j.k = paramArrayOfByte;
    }
    g = paramehl;
  }
  
  public final ejh<Status> a()
  {
    if (k) {
      throw new IllegalStateException("do not reuse LogEventBuilder");
    }
    k = true;
    return ehi.k(b).a(ehi.l(b), new LogEventParcelable(new PlayLoggerContext(ehi.i(b), ehi.j(b), c, d, a, e, ehi.h(b), f), j, g, h, ehi.a(i)));
  }
}

/* Location:
 * Qualified Name:     ehk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */