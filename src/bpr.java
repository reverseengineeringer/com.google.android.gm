import android.content.Context;
import android.os.Bundle;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Policy;
import org.apache.http.HttpEntity;

public final class bpr
  extends bqc
{
  public Bundle a;
  private final boolean b;
  private Policy c;
  private final boolean d;
  
  public bpr(Context paramContext, Account paramAccount, boolean paramBoolean)
  {
    super(paramContext, paramAccount);
    b = false;
    c = null;
    d = false;
  }
  
  /* Error */
  public bpr(Context paramContext, com.android.emailcommon.provider.HostAuth paramHostAuth)
  {
    // Byte code:
    //   0: new 26	com/android/emailcommon/provider/Account
    //   3: dup
    //   4: invokespecial 29	com/android/emailcommon/provider/Account:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_2
    //   10: putfield 33	com/android/emailcommon/provider/Account:t	Lcom/android/emailcommon/provider/HostAuth;
    //   13: aload_3
    //   14: aload_2
    //   15: getfield 39	com/android/emailcommon/provider/HostAuth:f	Ljava/lang/String;
    //   18: putfield 41	com/android/emailcommon/provider/Account:d	Ljava/lang/String;
    //   21: aload_0
    //   22: aload_1
    //   23: aload_3
    //   24: aload_2
    //   25: invokespecial 44	bqc:<init>	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;Lcom/android/emailcommon/provider/HostAuth;)V
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 18	bpr:b	Z
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 22	bpr:d	Z
    //   38: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	bpr
    //   0	39	1	paramContext	Context
    //   0	39	2	paramHostAuth	com.android.emailcommon.provider.HostAuth
    //   7	17	3	localAccount	Account
  }
  
  private final void a(Bundle paramBundle, int paramInt)
  {
    int i = 7;
    switch (paramInt)
    {
    case -11: 
    case -10: 
    default: 
      paramInt = 31;
    }
    for (;;)
    {
      paramBundle.putInt("validate_result_code", paramInt);
      if (j != 200) {
        paramBundle.putInt("validate_result_status", j);
      }
      return;
      paramInt = 1;
      continue;
      paramInt = 1;
      continue;
      paramInt = 30;
      continue;
      paramInt = 1;
      continue;
      paramInt = 14;
      continue;
      paramInt = i;
      if (c != null)
      {
        paramBundle.putParcelable("validate_policy_set", c);
        paramInt = i;
        if (c.w != null)
        {
          paramInt = 8;
          continue;
          paramInt = 5;
          continue;
          paramInt = 16;
          continue;
          paramInt = 9;
          continue;
          paramInt = -1;
          continue;
          paramInt = 21;
        }
      }
    }
  }
  
  protected final int a(bns parambns)
  {
    if (!parambns.e()) {
      new bop(f, f.getContentResolver(), parambns.d(), g, b).d();
    }
    return 0;
  }
  
  protected final String b()
  {
    return "FolderSync";
  }
  
  protected final HttpEntity c()
  {
    if ((g.e == null) || (d)) {}
    for (String str = "0";; str = g.e)
    {
      cvm.b("Exchange", "SyncKey for FolderSync: %s", new Object[] { str });
      bpi localbpi = new bpi();
      localbpi.a(470).a(466).a(str).b().b().a();
      return a(localbpi);
    }
  }
  
  protected final boolean g()
  {
    return b;
  }
  
  protected final boolean h()
  {
    Policy localPolicy = null;
    if (b)
    {
      bqj localbqj = new bqj(this);
      int j = localbqj.j();
      int i = j;
      if (j == 2) {
        i = localbqj.a(true);
      }
      if (i == 1) {
        a.w = null;
      }
      if ((i == 1) || (i == 2)) {
        localPolicy = a;
      }
      for (;;)
      {
        c = localPolicy;
        return false;
        cvm.d("Exchange", "Unable to handle policy: %d", new Object[] { Integer.valueOf(i) });
      }
    }
    return super.h();
  }
  
  public final int p_()
  {
    if (b)
    {
      cvm.b("Exchange", "Performing status only sync for account %d", new Object[] { Long.valueOf(g.D) });
      a = new Bundle(3);
      if (!b)
      {
        a(a, -99);
        return -99;
      }
      cvm.b("Exchange", "Performing validation", new Object[0]);
      if (!h.e())
      {
        a.putInt("validate_result_code", 17);
        return -8;
      }
      int j;
      if ((!h.f) || (this.i.a()))
      {
        i = 1;
        if (i == 0) {
          break label215;
        }
        localObject = new bqe(this);
        j = ((bqe)localObject).p_();
        this.j = j;
        if (j >= 0) {
          break label174;
        }
      }
      label174:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label179;
        }
        a(a, j);
        return j;
        i = 0;
        break;
      }
      label179:
      Object localObject = a;
      cvm.b("Exchange", "EasFolderSync.validate: Protocol version=%s", new Object[] { localObject });
      c((String)localObject);
      a.putString("validate_protocol_version", (String)localObject);
      label215:
      i = super.p_();
      a(a, i);
      return i;
    }
    cvm.b("Exchange", "Performing FolderSync for account %d", new Object[] { Long.valueOf(g.D) });
    return super.p_();
  }
}

/* Location:
 * Qualified Name:     bpr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */