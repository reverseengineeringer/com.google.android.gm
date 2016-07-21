import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public abstract interface eiz
{
  public abstract Looper a();
  
  public abstract ConnectionResult a(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract <C extends eit> C a(eiu<C> parameiu);
  
  public abstract <A extends eit, R extends ejk, T extends ejq<R, A>> T a(T paramT);
  
  public abstract <L> ekv<L> a(L paramL);
  
  public abstract void a(ejc paramejc);
  
  public abstract void a(eje parameje);
  
  public abstract void a(String paramString, PrintWriter paramPrintWriter);
  
  public abstract <A extends eit, T extends ejq<? extends ejk, A>> T b(T paramT);
  
  public abstract void b();
  
  public abstract void b(ejc paramejc);
  
  public abstract void b(eje parameje);
  
  public abstract ConnectionResult c();
  
  public abstract void d();
  
  public abstract boolean e();
  
  public abstract boolean f();
}

/* Location:
 * Qualified Name:     eiz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */