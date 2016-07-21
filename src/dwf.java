import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import com.google.android.gm.autoactivation.AutoActivationCertificateRequestor;
import com.google.android.gm.autoactivation.AutoActivationSettingsActivity;
import java.util.Set;

public final class dwf
{
  private static final String c = cvl.a;
  private static dwf d;
  public final Application.ActivityLifecycleCallbacks a = new dvz(e);
  final dwi b = new dwi();
  private final dwc e = new dwg(this);
  
  private dwf()
  {
    dwe localdwe = new dwe();
    dvu localdvu = new dvu();
    while (i < 2)
    {
      dwd localdwd = new dwd[] { localdwe, localdvu }[i];
      b.a.add(localdwd);
      i += 1;
    }
  }
  
  /* Error */
  public static dwf a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 68	cxd:d	()Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +10 -> 18
    //   11: aconst_null
    //   12: astore_1
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: getstatic 70	dwf:d	Ldwf;
    //   21: ifnonnull +13 -> 34
    //   24: new 2	dwf
    //   27: dup
    //   28: invokespecial 71	dwf:<init>	()V
    //   31: putstatic 70	dwf:d	Ldwf;
    //   34: getstatic 70	dwf:d	Ldwf;
    //   37: astore_1
    //   38: goto -25 -> 13
    //   41: astore_1
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   12	26	1	localdwf	dwf
    //   41	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	41	finally
    //   18	34	41	finally
    //   34	38	41	finally
  }
  
  static boolean a(Class<? extends Context> paramClass)
  {
    if (paramClass == null) {}
    while ((paramClass.equals(AutoActivationSettingsActivity.class)) || (paramClass.equals(AutoActivationCertificateRequestor.class))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     dwf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */