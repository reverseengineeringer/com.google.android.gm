import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.util.Log;

public final class dbr
  implements grm, gru, gsb
{
  public String a = null;
  public String b;
  private final Context c;
  private final String d;
  private final String e;
  private final String f;
  private int g = 0;
  private int h = 0;
  private String i;
  
  public dbr(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, (byte)0);
  }
  
  private dbr(Context paramContext, String paramString1, String paramString2, byte paramByte)
  {
    c = paramContext;
    d = paramString1;
    e = paramString2;
    f = null;
  }
  
  /* Error */
  private final String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	dbr:a	Ljava/lang/String;
    //   4: ifnonnull +33 -> 37
    //   7: aload_0
    //   8: getfield 45	dbr:f	Ljava/lang/String;
    //   11: ifnull +31 -> 42
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 39	dbr:c	Landroid/content/Context;
    //   19: aload_0
    //   20: getfield 52	dbr:b	Ljava/lang/String;
    //   23: aload_0
    //   24: getfield 41	dbr:d	Ljava/lang/String;
    //   27: aload_0
    //   28: getfield 45	dbr:f	Ljava/lang/String;
    //   31: invokestatic 57	ecy:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   34: putfield 33	dbr:a	Ljava/lang/String;
    //   37: aload_0
    //   38: getfield 33	dbr:a	Ljava/lang/String;
    //   41: areturn
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 39	dbr:c	Landroid/content/Context;
    //   47: aload_0
    //   48: getfield 52	dbr:b	Ljava/lang/String;
    //   51: aload_0
    //   52: getfield 41	dbr:d	Ljava/lang/String;
    //   55: invokestatic 60	ecy:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: putfield 33	dbr:a	Ljava/lang/String;
    //   61: goto -24 -> 37
    //   64: astore_1
    //   65: new 62	dbq
    //   68: dup
    //   69: ldc 64
    //   71: aload_1
    //   72: invokespecial 67	dbq:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: athrow
    //   76: astore_1
    //   77: new 62	dbq
    //   80: dup
    //   81: ldc 64
    //   83: aload_1
    //   84: invokespecial 67	dbq:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	dbr
    //   64	8	1	localIOException	java.io.IOException
    //   76	8	1	localecx	ecx
    // Exception table:
    //   from	to	target	type
    //   7	37	64	java/io/IOException
    //   42	61	64	java/io/IOException
    //   7	37	76	ecx
    //   42	61	76	ecx
  }
  
  public final void a(grs paramgrs)
  {
    a = this;
    k = this;
    hbe.a(true);
    d = 1;
    if (g > 0) {
      paramgrs.a(g);
    }
    if (h > 0) {
      paramgrs.b(h);
    }
  }
  
  public final boolean a(grs paramgrs, grv paramgrv, boolean paramBoolean)
  {
    if (c == 401)
    {
      ecy.a(c, a);
      a = null;
      return true;
    }
    return false;
  }
  
  public final void b(grs paramgrs)
  {
    String str1 = a();
    grn localgrn = b;
    Object localObject1 = String.valueOf("OAuth ");
    str1 = String.valueOf(str1);
    if (str1.length() != 0) {}
    Object localObject2;
    String str2;
    for (localObject1 = ((String)localObject1).concat(str1);; localObject1 = new String((String)localObject1))
    {
      localgrn.a((String)localObject1);
      localObject1 = j;
      str1 = ((gri)localObject1).c();
      localObject2 = c.getContentResolver();
      localObject2 = ddx.a.a((ContentResolver)localObject2).a(str1);
      str2 = ((ddt)localObject2).apply(str1);
      if (str2 != null) {
        break;
      }
      paramgrs = e;
      localObject1 = String.valueOf(b);
      Log.w(paramgrs, String.valueOf(localObject1).length() + 13 + String.valueOf(str1).length() + "Blocked by " + (String)localObject1 + ": " + str1);
      throw new dbs((ddt)localObject2);
    }
    if (!str2.equals(str1))
    {
      if (Log.isLoggable(e, 2))
      {
        localObject1 = String.valueOf(b);
        new StringBuilder(String.valueOf(localObject1).length() + 11 + String.valueOf(str1).length() + String.valueOf(str2).length()).append("Rule ").append((String)localObject1).append(": ").append(str1).append(" -> ").append(str2);
      }
      localObject1 = new gri(str2);
      paramgrs.a((gri)localObject1);
    }
    for (paramgrs = (grs)localObject1;; paramgrs = (grs)localObject1)
    {
      localObject1 = (String)paramgrs.b("ifmatch");
      if (localObject1 != null)
      {
        localgrn.e((String)localObject1);
        paramgrs.remove("ifmatch");
      }
      localObject1 = new StringBuilder(Build.FINGERPRINT).append(":");
      if (i != null) {
        ((StringBuilder)localObject1).append(i);
      }
      for (;;)
      {
        str1 = (String)paramgrs.b("userAgentPackage");
        if (str1 != null)
        {
          ((StringBuilder)localObject1).append(":").append(str1);
          paramgrs.remove("userAgentPackage");
        }
        localgrn.f(((StringBuilder)localObject1).toString());
        return;
        ((StringBuilder)localObject1).append(e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     dbr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */