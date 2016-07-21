import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Policy;
import com.android.emailcommon.provider.RecipientAvailability;
import com.android.emailcommon.service.HostAuthCompat;
import com.android.emailcommon.service.SearchParams;
import java.io.IOException;
import java.util.List;

public class bfn
  extends bgj
  implements ber, bey
{
  private final boolean a;
  Object c = null;
  bey d;
  
  public bfn(Context paramContext, Intent paramIntent)
  {
    super(paramContext, paramIntent);
    try
    {
      bbt.a(paramContext);
      bce.a = paramContext.getCacheDir();
      a = true;
      return;
    }
    catch (IOException paramIntent)
    {
      for (;;) {}
    }
  }
  
  public bfn(Context paramContext, Class<?> paramClass)
  {
    super(paramContext, new Intent(paramContext, paramClass));
    bce.a = paramContext.getCacheDir();
    a = false;
  }
  
  public final int a()
  {
    if (cuh.a()) {
      return 7;
    }
    a(new bfy(this), "getApiVersion");
    c();
    if (c == null)
    {
      cvm.f("EmailServiceProxy", "failed to get api version", new Object[0]);
      return -1;
    }
    return ((Integer)c).intValue();
  }
  
  public final int a(long paramLong, Bundle paramBundle)
  {
    a(new bfv(this, paramLong, paramBundle), "sync");
    c();
    if (c == null) {
      return 35;
    }
    return ((Integer)c).intValue();
  }
  
  public Bundle a(long paramLong1, SearchParams paramSearchParams, long paramLong2)
  {
    a(new bfr(this, paramLong1, paramSearchParams, paramLong2), "searchMessages");
    c();
    if (c == null)
    {
      cvm.d("EmailServiceProxy", "No result returned in searchMessages", new Object[0]);
      return bes.a(21, 0);
    }
    if ((c instanceof Bundle)) {
      return (Bundle)c;
    }
    return bes.a(0, ((Integer)c).intValue());
  }
  
  public final Bundle a(HostAuthCompat paramHostAuthCompat)
  {
    a(new bga(this, paramHostAuthCompat), "validate");
    c();
    if (c == null)
    {
      paramHostAuthCompat = new Bundle();
      paramHostAuthCompat.putInt("validate_result_code", 29);
      return paramHostAuthCompat;
    }
    paramHostAuthCompat = (Bundle)c;
    paramHostAuthCompat.setClassLoader(Policy.class.getClassLoader());
    int i = paramHostAuthCompat.getInt("validate_result_code");
    cvm.a("EmailServiceProxy", 28 + "validate returns " + i, new Object[0]);
    return paramHostAuthCompat;
  }
  
  public final Bundle a(String paramString1, String paramString2)
  {
    a(new bgd(this, paramString1, paramString2), "autoDiscover");
    c();
    if (c == null) {
      return null;
    }
    paramString1 = (Bundle)c;
    paramString1.setClassLoader(HostAuth.class.getClassLoader());
    int i = paramString1.getInt("autodiscover_error_code");
    cvm.a("EmailServiceProxy", 32 + "autoDiscover returns " + i, new Object[0]);
    return paramString1;
  }
  
  public final Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    a(new bge(this, paramString1, paramString2, paramBundle), "continueAutodiscover");
    c();
    if (c == null) {
      return null;
    }
    paramString1 = (Bundle)c;
    paramString1.setClassLoader(HostAuth.class.getClassLoader());
    int i = paramString1.getInt("autodiscover_error_code");
    cvm.a("EmailServiceProxy", 40 + "continueAutodiscover returns " + i, new Object[0]);
    return paramString1;
  }
  
  public final List<RecipientAvailability> a(String paramString, List<String> paramList, long paramLong1, long paramLong2)
  {
    a(new bfw(this, paramString, paramList, paramLong1, paramLong2), "retrieveRecipientAvailabilities");
    c();
    if (c == null) {
      return null;
    }
    return (List)c;
  }
  
  public final void a(int paramInt)
  {
    cvm.e("EmailServiceProxy", new Throwable(), "call to deprecated setLogging", new Object[0]);
  }
  
  public void a(long paramLong)
  {
    a(new bgg(this, paramLong), "updateFolderList");
  }
  
  public final void a(long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString)
  {
    a(new bfp(this, paramLong1, paramInt, paramLong2, paramLong3, paramString), "sendMeetingResponse");
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    a(new bfu(this, paramLong1, paramLong2), "pushModifyWithBackoff");
  }
  
  public final void a(long paramLong, ExchangeOofSettings paramExchangeOofSettings)
  {
    a(new bgf(this, paramLong, paramExchangeOofSettings), "syncEasOofSettings");
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2)
  {
    a(new bgb(this, paramLong1, paramString, paramLong2), "createFolder");
  }
  
  public final void a(IBinder paramIBinder)
  {
    d = bez.a(paramIBinder);
  }
  
  public void a(bfb parambfb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    a(new bfo(this, parambfb, paramLong1, paramLong2, paramBoolean), "loadAttachment");
  }
  
  public final void a(String paramString)
  {
    a(new bfq(this, paramString), "deleteAccountPIMData");
    c();
  }
  
  public IBinder asBinder()
  {
    return null;
  }
  
  public final String b(String paramString)
  {
    a(new bfx(this, paramString), "getProtocolVersion");
    c();
    if (c == null) {
      return null;
    }
    return (String)c;
  }
  
  public final void b(long paramLong)
  {
    a(new bft(this, paramLong), "pushModify");
  }
  
  public final void b(long paramLong1, long paramLong2)
  {
    a(new bgc(this, paramLong1, paramLong2), "markFolderForDeletion");
  }
  
  public void c(long paramLong)
  {
    a(new bfs(this, paramLong), "sendMail");
  }
  
  public final void c(long paramLong1, long paramLong2)
  {
    a(new bfz(this, paramLong1, paramLong2), "loadMeetingResponse");
  }
}

/* Location:
 * Qualified Name:     bfn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */