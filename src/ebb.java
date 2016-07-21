import android.os.IInterface;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

public abstract interface ebb
  extends IInterface
{
  public abstract void a();
  
  public abstract void a(Map paramMap, long paramLong, String paramString, List<Command> paramList);
}

/* Location:
 * Qualified Name:     ebb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */