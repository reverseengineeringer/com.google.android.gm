import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;

public final class cjs
  implements crk
{
  static final String j = cvl.a;
  zc a;
  ckv b;
  cjw c;
  crj d;
  Folder e;
  MenuItem f;
  MenuItem g;
  MenuItem h;
  Conversation i;
  cgm k;
  final cfx l = new cjt(this);
  private final Context m;
  private Account n;
  private final boolean o;
  
  public cjs(Context paramContext)
  {
    m = paramContext;
    o = cxa.a(paramContext.getResources());
  }
  
  private final void a(int paramInt)
  {
    a.a(paramInt, 24);
  }
  
  private final void a(String paramString)
  {
    if (!TextUtils.equals(paramString, a.f())) {
      a.a(paramString);
    }
  }
  
  private final void d()
  {
    a(8);
    c();
  }
  
  final int a()
  {
    if (d != null) {
      return d.a;
    }
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    boolean bool = m.getResources().getBoolean(bty.c);
    b.C_();
    switch (a())
    {
    case 0: 
    case 3: 
    default: 
      return;
    case 2: 
      d();
      return;
    case 4: 
      a.b(true);
      a(0);
      return;
    case 1: 
      if (bool) {
        a.b(true);
      }
      break;
    case 5: 
      d();
      return;
    }
    a.b(true);
    a(0);
  }
  
  final void a(Account paramAccount)
  {
    if (paramAccount == null) {
      return;
    }
    if ((n == null) || (!n.g.equals(g))) {}
    for (int i1 = 1;; i1 = 0)
    {
      n = paramAccount;
      if (i1 == 0) {
        break;
      }
      ContentResolver localContentResolver = b.g().getContentResolver();
      Bundle localBundle = new Bundle(1);
      localBundle.putParcelable("account", paramAccount);
      new cjv(this, n.g, localContentResolver).execute(new Bundle[] { localBundle });
      c();
      return;
    }
  }
  
  final void b()
  {
    boolean bool2 = false;
    cxa.a(g, false);
    cxa.a(h, false);
    switch (a())
    {
    default: 
      return;
    }
    MenuItem localMenuItem = f;
    boolean bool1 = bool2;
    if (c.X())
    {
      bool1 = bool2;
      if (!o) {
        bool1 = true;
      }
    }
    cxa.a(localMenuItem, bool1);
  }
  
  final void c()
  {
    if ((a == null) || (b == null)) {}
    for (;;)
    {
      return;
      if (crj.d(a()))
      {
        a("");
        return;
      }
      if ((o) || (crj.a(a()))) {}
      for (int i1 = 1; i1 != 0; i1 = 0)
      {
        if (e != null) {
          break label74;
        }
        a("");
        return;
      }
    }
    label74:
    a(e.d);
  }
}

/* Location:
 * Qualified Name:     cjs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */