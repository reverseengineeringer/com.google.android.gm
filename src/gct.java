import com.google.android.gms.common.api.Scope;
import java.util.List;
import java.util.concurrent.ExecutorService;

final class gct
  extends gcj
{
  final gcd a;
  private final ExecutorService b;
  
  public gct(gcd paramgcd, ExecutorService paramExecutorService)
  {
    a = paramgcd;
    b = paramExecutorService;
  }
  
  public final void a(String paramString1, String paramString2, gcn paramgcn)
  {
    b.submit(new gcv(this, paramString1, paramString2, paramgcn));
  }
  
  public final void a(String paramString, List<Scope> paramList, gcn paramgcn)
  {
    b.submit(new gcu(this, paramList, paramString, paramgcn));
  }
}

/* Location:
 * Qualified Name:     gct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */