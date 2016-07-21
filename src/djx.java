import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.gcm.OneoffTask;

public class djx
  extends fjt
{
  private static final String a = cvl.a;
  private djv b = new djv();
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    paramString2 = djv.a(paramString1, paramString2, paramString3);
    paramString1 = djv.a(paramString1, paramLong);
    paramString3 = new fjx();
    d = djx.class.getName();
    e = paramString1;
    i = paramString2;
    a = 0L;
    b = 5L;
    c = 0;
    g = true;
    paramString3.a();
    paramString1 = new OneoffTask(paramString3);
    fjs.a(paramContext).a(paramString1);
  }
  
  public final int a(fkc paramfkc)
  {
    String str = a;
    djw localdjw = djv.b(getApplicationContext(), b);
    if (b != null)
    {
      dri.d(a, "Save to Drive tagged %s succeeded", new Object[] { str });
      djv.b(getApplicationContext(), str, b.fileId);
      djv.a(getApplicationContext(), str, b);
      return 0;
    }
    int i = djv.b(getApplicationContext(), str, b);
    if ((i >= 0) && (i < 5))
    {
      djv.c(getApplicationContext(), str, b);
      dri.d(a, "Save to Drive tagged %s failed, retrying", new Object[] { str });
      return 1;
    }
    dri.d(a, "Save to Drive tagged %s failed", new Object[] { str });
    djv.a(getApplicationContext(), str, b);
    return 2;
  }
  
  public final void a()
  {
    AsyncTask.execute(new djr(this));
  }
}

/* Location:
 * Qualified Name:     djx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */