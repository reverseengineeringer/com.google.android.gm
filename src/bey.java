import android.os.Bundle;
import android.os.IInterface;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.emailcommon.provider.RecipientAvailability;
import com.android.emailcommon.service.HostAuthCompat;
import com.android.emailcommon.service.SearchParams;
import java.util.List;

public abstract interface bey
  extends IInterface
{
  public abstract int a();
  
  public abstract int a(long paramLong, Bundle paramBundle);
  
  public abstract Bundle a(long paramLong1, SearchParams paramSearchParams, long paramLong2);
  
  public abstract Bundle a(HostAuthCompat paramHostAuthCompat);
  
  public abstract Bundle a(String paramString1, String paramString2);
  
  public abstract Bundle a(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract List<RecipientAvailability> a(String paramString, List<String> paramList, long paramLong1, long paramLong2);
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong, ExchangeOofSettings paramExchangeOofSettings);
  
  public abstract void a(long paramLong1, String paramString, long paramLong2);
  
  public abstract void a(bfb parambfb, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(String paramString);
  
  public abstract String b(String paramString);
  
  public abstract void b(long paramLong);
  
  public abstract void b(long paramLong1, long paramLong2);
  
  public abstract void c(long paramLong);
  
  public abstract void c(long paramLong1, long paramLong2);
}

/* Location:
 * Qualified Name:     bey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */