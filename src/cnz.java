import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.database.DataSetObservable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.ui.ConversationCheckedSet;
import com.android.mail.ui.ShortcutNameActivity;
import com.android.mail.ui.toastbar.ToastBarOperation;
import java.util.ArrayList;

public class cnz
  extends zh
  implements DialogInterface.OnClickListener, View.OnClickListener, ckv, cod
{
  static final String l = cvl.a;
  Account m;
  public boolean n;
  final DataSetObservable o = new cvo("FolderOrAccount");
  private Folder p;
  private boolean q;
  private int r = 0;
  private int s = -1;
  private final cjo t = new coa(this);
  private Folder u;
  
  private final void C()
  {
    setResult(0);
    finish();
  }
  
  private final void a(Fragment paramFragment)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.replace(buc.aq, paramFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public ArrayList<Integer> A()
  {
    return new ArrayList();
  }
  
  public final ToastBarOperation B()
  {
    return null;
  }
  
  public final bvd a(Context paramContext, anf paramanf)
  {
    return null;
  }
  
  public final bvu a()
  {
    return null;
  }
  
  public final void a(int paramInt, Account paramAccount) {}
  
  public void a(int paramInt, Account paramAccount, Folder paramFolder)
  {
    cxm.a(this, paramInt, paramAccount, p, e, c.b, h, d);
    paramAccount = new Intent();
    paramAccount.putExtra("appWidgetId", paramInt);
    setResult(-1, paramAccount);
    finish();
  }
  
  public final void a(View paramView) {}
  
  public final void a(View paramView, int paramInt) {}
  
  public final void a(Account paramAccount, int paramInt) {}
  
  public final void a(Folder paramFolder) {}
  
  public final void a(cqp paramcqp) {}
  
  public final void a_(ToastBarOperation paramToastBarOperation) {}
  
  public final void b(int paramInt, Account paramAccount) {}
  
  public final void b(Folder paramFolder)
  {
    if ((f) && (!paramFolder.equals(u)))
    {
      u = paramFolder;
      a(cnk.a(paramFolder, i, null));
    }
    do
    {
      do
      {
        return;
      } while (paramFolder.equals(p));
      p = paramFolder;
      paramFolder = new Intent();
      if (q)
      {
        Object localObject = cxa.a(this, p.c.b, m);
        ((Intent)localObject).putExtra("from-shortcut", true);
        paramFolder.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject);
        paramFolder.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, bug.a));
        localObject = p.d;
        paramFolder.putExtra("android.intent.extra.shortcut.NAME", (CharSequence)localObject);
        Intent localIntent = new Intent(this, ShortcutNameActivity.class);
        localIntent.setFlags(1107296256);
        localIntent.putExtra("extra_folder_click_intent", paramFolder);
        localIntent.putExtra("extra_shortcut_name", (CharSequence)localObject);
        startActivity(localIntent);
        finish();
        buo.a().a("shortcut", "shortcut_created", null, 0L);
        return;
      }
    } while (!n);
    a(r, m, p);
    buo.a().a("widget", "widget_created", null, 0L);
  }
  
  public final void b(ToastBarOperation paramToastBarOperation) {}
  
  public final cjw d()
  {
    return null;
  }
  
  public final Activity g()
  {
    return this;
  }
  
  public final ConversationCheckedSet h()
  {
    return null;
  }
  
  public final cod i()
  {
    return this;
  }
  
  public final Folder j()
  {
    return null;
  }
  
  public final cll k()
  {
    return null;
  }
  
  public final cng l()
  {
    return null;
  }
  
  public final cnh m()
  {
    return null;
  }
  
  public final cjo n()
  {
    return t;
  }
  
  public final cpo o()
  {
    return null;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      a(r, m, p);
      return;
    }
    C();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == buc.by) && (s == 0)) {
      C();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(bue.K);
    paramBundle = getIntent();
    String str = paramBundle.getAction();
    q = "android.intent.action.CREATE_SHORTCUT".equals(str);
    n = "android.appwidget.action.APPWIDGET_CONFIGURE".equals(str);
    if ((!q) && (!n)) {
      cvm.f(l, "unexpected intent: %s", new Object[] { paramBundle });
    }
    if ((q) || (n)) {}
    for (s = 0;; s = 1)
    {
      if (n)
      {
        r = paramBundle.getIntExtra("appWidgetId", 0);
        if (r == 0) {
          cvm.f(l, "invalid widgetId", new Object[0]);
        }
      }
      m = ((Account)paramBundle.getParcelableExtra("account-shortcut"));
      paramBundle = (Button)findViewById(buc.by);
      paramBundle.setVisibility(0);
      if (s == 1) {
        paramBundle.setEnabled(false);
      }
      paramBundle.setOnClickListener(this);
      a(cnk.a(null, m.i, A()));
      return;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public final cmz p()
  {
    return null;
  }
  
  public final ckg q()
  {
    return null;
  }
  
  public final cpb r()
  {
    return null;
  }
  
  public final csl s()
  {
    return null;
  }
  
  public final cst t()
  {
    return null;
  }
  
  public final cof u()
  {
    return null;
  }
  
  public final ckt v()
  {
    return null;
  }
  
  public final crj v_()
  {
    return null;
  }
  
  public final anf w()
  {
    return null;
  }
  
  public final cky w_()
  {
    return null;
  }
  
  public final void x() {}
  
  public final cpn y()
  {
    return null;
  }
  
  public final bzn z()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     cnz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */