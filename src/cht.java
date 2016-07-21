import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import com.android.mail.MailLogService;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.ConversationCheckedSet;
import com.android.mail.ui.FolderOperation;
import com.android.mail.ui.MailActivity;
import com.android.mail.ui.search.MaterialSearchActionView;
import com.android.mail.ui.search.MaterialSearchSuggestionsList;
import com.android.mail.ui.toastbar.ActionableToastBar;
import com.android.mail.ui.toastbar.ToastBarOperation;
import com.android.mail.utils.NotificationActionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class cht
  implements View.OnClickListener, cjw, cnf
{
  public static final String I = cvl.a;
  public final DataSetObservable A = new cvo("FolderOrAccount");
  final ConversationCheckedSet B = new ConversationCheckedSet();
  final int C;
  public final cli D;
  bzq E;
  public ActionableToastBar F;
  public bxl G;
  public final ciw H = new ciw(this);
  public cja J;
  public ckh K;
  Folder L;
  final int M;
  boolean N;
  crl O;
  public boolean P = false;
  Conversation Q = null;
  public View R;
  public boolean S;
  public boolean T;
  public long U;
  final cjd V = new cjd(this);
  final cue W = new cue();
  private final String X = "ignore-initial-conversation-limit";
  private boolean Y = false;
  private Uri Z;
  public final String a = "account";
  private final Bundle aa = new Bundle();
  private cqb ab = null;
  private ckh ac;
  private Runnable ad = null;
  private Account[] ae = new Account[0];
  private cgn af;
  private boolean ag;
  private final DataSetObservable ah = new cvo("AllAccounts");
  private final ciy ai = new ciy(this);
  private final cit aj = new cit(this);
  private cmx ak;
  private DialogInterface.OnClickListener al;
  private int am = -1;
  private boolean an;
  private boolean ao;
  private boolean ap;
  private Conversation aq;
  private Runnable ar = null;
  private final DataSetObserver as = new chu(this);
  private final cjb at = new cjb(this);
  public final String b = "folder";
  public Account c;
  public Folder d;
  public Folder e;
  public cjs f;
  public final MailActivity g;
  public final Context h;
  final FragmentManager i;
  public final cpp j;
  public btp k;
  public Conversation l;
  public crr m;
  public final Handler n = new Handler();
  public final crj o;
  public ContentResolver p;
  public boolean q = false;
  public boolean r;
  final boolean s;
  final Set<Uri> t = new HashSet();
  public bwg u;
  final DataSetObservable v = new cvo("List");
  final ArrayList<cjc> w = new ArrayList();
  final DataSetObservable x = new cvo("Account");
  final DataSetObservable y = new cvo("RecentFolder");
  final DataSetObservable z = new cvo("CurrentFolder");
  
  public cht(MailActivity paramMailActivity, crj paramcrj)
  {
    g = paramMailActivity;
    i = g.getFragmentManager();
    o = paramcrj;
    h = paramMailActivity.getApplicationContext();
    j = new cpp(h);
    D = new cli(this);
    B.a(this);
    paramMailActivity = paramMailActivity.getResources();
    C = paramMailActivity.getInteger(bud.p);
    M = paramMailActivity.getInteger(bud.A);
    s = cxa.a(paramMailActivity);
    T = false;
  }
  
  private final cag a(int paramInt, Conversation paramConversation)
  {
    int i1 = 1;
    Collection localCollection = Conversation.a(paramConversation);
    if ((c != null) && (c.z != null) && (D != null) && (D.a(c.z.b(), localCollection) != null) && (b(localCollection))) {
      if ((paramInt == buc.x) || (paramInt == buc.aV) || (paramInt == buc.bb) || (paramInt == buc.dP) || (paramInt == buc.ea) || (paramInt == buc.cT))
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label132;
        }
      }
    }
    label132:
    for (paramInt = i1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label137;
      }
      return new cio(this, paramConversation);
      paramInt = 0;
      break;
    }
    label137:
    return null;
  }
  
  private final cmx a(int paramInt, Collection<Conversation> paramCollection, boolean paramBoolean, cag paramcag)
  {
    paramCollection = new ciu(this, paramInt, paramCollection, paramBoolean);
    c = paramcag;
    return paramCollection;
  }
  
  private final cmx a(Collection<Conversation> paramCollection, Collection<FolderOperation> paramCollection1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Folder paramFolder, cag paramcag)
  {
    if (paramBoolean4) {}
    for (int i1 = buc.cS;; i1 = buc.ac)
    {
      paramCollection = new cix(this, paramCollection, paramCollection1, paramBoolean1, paramBoolean2, true, i1, paramFolder, (byte)0);
      paramCollection.a(paramcag);
      return paramCollection;
    }
  }
  
  private final void a(int paramInt1, Collection<Conversation> paramCollection, boolean paramBoolean, int paramInt2, cag paramcag)
  {
    if (paramBoolean)
    {
      if (g.u)
      {
        a(paramInt1, false, paramcag);
        bvy.a(cxa.a(h, paramInt2, paramCollection.size())).show(g.getFragmentManager(), "confirm-dialog");
      }
      return;
    }
    a(paramCollection, a(paramInt1, paramCollection, false, paramcag), false);
  }
  
  private final void a(Folder paramFolder, String paramString)
  {
    d(paramFolder);
    if (paramString != null)
    {
      k = btp.a(c, d, paramString);
      return;
    }
    k = new btp(c, null, d);
  }
  
  private final void a(Collection<Conversation> paramCollection, Runnable paramRunnable)
  {
    if (b(paramCollection))
    {
      int i2 = c.z.b();
      int i1 = i2;
      if (i2 == 0) {
        i1 = 3;
      }
      if ((i1 == 3) && (z())) {
        ar = paramRunnable;
      }
      a(paramCollection, i1);
    }
    if ((paramRunnable != null) && (ar == null)) {
      paramRunnable.run();
    }
  }
  
  private final void au()
  {
    if (ar != null)
    {
      ar.run();
      ar = null;
    }
  }
  
  private final void av()
  {
    g.a(13, c);
  }
  
  private static boolean b(Fragment paramFragment)
  {
    return (paramFragment != null) && (paramFragment.getActivity() != null) && (paramFragment.getView() != null);
  }
  
  private final boolean b(Collection<Conversation> paramCollection)
  {
    int i1 = o.a;
    return ((i1 == 1) || (i1 == 4)) && (Conversation.a(paramCollection, l));
  }
  
  private final void c(Account paramAccount)
  {
    if (paramAccount != null) {
      g.a(c, paramAccount);
    }
    d(paramAccount);
  }
  
  private final void d(Account paramAccount)
  {
    if (paramAccount == null)
    {
      cvm.d(I, new Error(), "AAC ignoring null (presumably invalid) account restoration", new Object[0]);
      return;
    }
    cvm.b(I, "AbstractActivityController.setAccount(): account = %s", new Object[] { g });
    c = paramAccount;
    buo.a().a(c, e);
    a(31, ai, Bundle.EMPTY);
    g.invalidateOptionsMenu();
    a(1, aj, Bundle.EMPTY);
    Object localObject = cgr.b;
    if (localObject != null)
    {
      String str = c.g.toString();
      localObject = ((cgr)localObject).d().edit();
      ((SharedPreferences.Editor)localObject).putString("lastViewedAccount", str);
      ((SharedPreferences.Editor)localObject).apply();
    }
    if (z == null)
    {
      cvm.d(I, new Error(), "AAC ignoring account with null settings.", new Object[0]);
      return;
    }
    x.notifyChanged();
    j();
  }
  
  private final ctd e(int paramInt)
  {
    return new cig(this, paramInt);
  }
  
  public final void A()
  {
    if (d == null) {}
    cje localcje;
    do
    {
      return;
      localcje = g();
    } while (localcje == null);
    localcje.g();
    g.a(12, c);
    if (ac != null) {
      ac.cancel(true);
    }
    ac = new ckh(h, d.m);
    ac.execute(new Void[0]);
  }
  
  public final void A_()
  {
    String str = I;
    if (d != null) {}
    for (Object localObject = Integer.valueOf(d.a);; localObject = "-1")
    {
      cvm.b(str, "Received refresh ready callback for folder %s", new Object[] { localObject });
      if (!r) {
        break;
      }
      cvm.c(I, "ignoring onRefreshReady on destroyed AAC", new Object[0]);
      return;
    }
    if (!S())
    {
      u.k();
      D.b = true;
      aa();
      return;
    }
    localObject = g();
    str = I;
    bwg localbwg = u;
    if (localObject == null) {}
    for (localObject = "null list fragment";; localObject = ((cje)localObject).c())
    {
      cvm.d(str, "AAC.onRefreshReady suppressing sync() due to animation. cursor=%s aa=%s", new Object[] { localbwg, localObject });
      break;
    }
  }
  
  public void B()
  {
    q = false;
    cqb localcqb = ab;
    if (a != null)
    {
      localcqb.a();
      c.clear();
      a = null;
    }
  }
  
  public void C()
  {
    Object localObject = ab;
    Context localContext = h;
    Account[] arrayOfAccount = ae;
    a = localContext;
    b = this;
    ((cqb)localObject).a(arrayOfAccount);
    new cqc((cqb)localObject).a(b);
    localObject = (cnd)g.getFragmentManager().findFragmentByTag("EmptyFolderDialogFragment");
    if (localObject != null) {
      ((cnd)localObject).a(this);
    }
    g.invalidateOptionsMenu();
  }
  
  public final void D()
  {
    G.e = null;
    DataSetObserver localDataSetObserver = as;
    ae.unregisterObserver(localDataSetObserver);
  }
  
  public void E()
  {
    if (u != null) {
      u.a(this);
    }
    W.a(null);
    W.a(null);
    G.b();
    Object localObject = f;
    if (k != null)
    {
      k.a();
      k = null;
    }
    l.a();
    j.d.a();
    r = true;
    n.removeCallbacks(ad);
    ad = null;
    localObject = m;
    k = j;
    if (!j) {
      c.a();
    }
    a.m.b((crk)localObject);
    if (f != null) {
      f.a();
    }
    g.clear();
  }
  
  public final void F()
  {
    Object localObject = G;
    if (b != null)
    {
      localObject = b;
      if (!h)
      {
        if (c != null)
        {
          c.j(a);
          b.a();
        }
        i = ((bxi)localObject).a();
        h = true;
        cvm.b("ConvPager", "CPA.stopListening, this=%s", new Object[] { localObject });
      }
    }
  }
  
  public final boolean G()
  {
    return r;
  }
  
  protected final boolean H()
  {
    return (P) && (aq());
  }
  
  protected final boolean I()
  {
    return (crj.b(o.a)) && (ao) && (l != null);
  }
  
  protected final boolean J()
  {
    boolean bool = I();
    if (bool)
    {
      ao = false;
      a(l);
    }
    return bool;
  }
  
  protected void K()
  {
    o.f(5);
    O = crl.a(c, true);
  }
  
  protected void L()
  {
    O = null;
  }
  
  protected final crl M()
  {
    crl localcrl = (crl)g.getFragmentManager().findFragmentByTag("wait-fragment");
    if (localcrl != null) {
      O = localcrl;
    }
    return O;
  }
  
  public final void N()
  {
    cje localcje = g();
    if ((localcje != null) && (localcje.c() != null)) {
      localcje.c().u();
    }
  }
  
  public final void O()
  {
    cje localcje = g();
    if ((localcje != null) && (localcje.c() != null)) {
      localcje.c().v();
    }
  }
  
  public final Conversation P()
  {
    return l;
  }
  
  public abstract boolean Q();
  
  public final boolean R()
  {
    return ao;
  }
  
  public boolean S()
  {
    boolean bool = false;
    cje localcje = g();
    if (localcje != null) {
      bool = localcje.b();
    }
    return bool;
  }
  
  public final ConversationCheckedSet T()
  {
    return B;
  }
  
  protected final void U()
  {
    e(true);
    if (E != null) {
      E.b();
    }
  }
  
  protected abstract void V();
  
  public final void W()
  {
    if (c == null)
    {
      cvm.b(I, "AbstractActivityController.startSearch(): null account", new Object[0]);
      return;
    }
    if (X())
    {
      m.a(1, true);
      return;
    }
    Toast.makeText(g, g.getString(buj.ex), 0).show();
  }
  
  public final boolean X()
  {
    boolean bool2 = false;
    if (c != null)
    {
      Account localAccount = c;
      if ((!localAccount.a(4096L)) && (!localAccount.a(32L)) && (!localAccount.a(64L))) {
        break label82;
      }
    }
    label82:
    for (int i1 = 1;; i1 = 0)
    {
      boolean bool1;
      if (i1 == 0)
      {
        bool1 = bool2;
        if (d != null)
        {
          bool1 = bool2;
          if (!d.d(8192)) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public final void Y()
  {
    bxl localbxl = G;
    if (b != null)
    {
      if (b.f)
      {
        cvm.c("ConvPager", "IN pager adapter, finished loading primary conversation, switching to cursor mode to load other conversations", new Object[0]);
        b.f();
      }
      if (c)
      {
        c = false;
        d.notifyChanged();
      }
      glh.a.a(e, "ConversationPagerController.show");
      e = null;
    }
  }
  
  public final boolean Z()
  {
    return G.c;
  }
  
  public final cmx a(boolean paramBoolean, cag paramcag)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FolderOperation(paramcag, Boolean.valueOf(false)));
    boolean bool;
    paramBoolean = new cix(this, paramBoolean, localArrayList, true, bool, true, buc.dP, d, (byte)0);
    cag localcag;
    paramBoolean.a(localcag);
    return paramBoolean;
  }
  
  public final Account a()
  {
    return c;
  }
  
  public final Account a(Uri paramUri)
  {
    Object localObject;
    if ((c != null) && (paramUri.equals(c.g)))
    {
      localObject = c;
      return (Account)localObject;
    }
    Account[] arrayOfAccount = ae;
    int i2 = arrayOfAccount.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label76;
      }
      Account localAccount = arrayOfAccount[i1];
      localObject = localAccount;
      if (paramUri.equals(g)) {
        break;
      }
      i1 += 1;
    }
    label76:
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!crj.b(paramInt2)) {
      c(null);
    }
    if (paramInt2 != 0) {
      if (paramInt1 == 0) {
        break label32;
      }
    }
    label32:
    for (boolean bool = true;; bool = false)
    {
      d(bool);
      o();
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (paramInt2 == -1)
              {
                g.getLoaderManager().initLoader(0, Bundle.EMPTY, aj);
                return;
              }
              g.finish();
              return;
              if (paramInt2 == -1)
              {
                if (d != null) {}
                for (paramIntent = d.m; paramIntent != null; paramIntent = null)
                {
                  b(paramIntent);
                  return;
                }
              }
            }
            if (crj.c(o.a))
            {
              g.setResult(paramInt2, paramIntent);
              g.finish();
              return;
            }
          } while ((paramInt2 != -1) || (paramIntent == null));
          Folder localFolder = (Folder)paramIntent.getParcelableExtra("extra-folder");
          paramIntent = (Account)paramIntent.getParcelableExtra("extra-account");
          if (localFolder != null)
          {
            b(localFolder);
            o.f(2);
            return;
          }
        } while (paramIntent == null);
        a(paramIntent);
        o.f(2);
        return;
      } while (paramInt2 != -1);
      paramIntent = paramIntent.getStringArrayListExtra("android.speech.extra.RESULTS");
    } while (paramIntent.isEmpty());
    m.a((String)paramIntent.get(0), "voice");
  }
  
  protected final void a(int paramInt, Fragment paramFragment)
  {
    FragmentTransaction localFragmentTransaction = g.getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4097);
    localFragmentTransaction.replace(paramInt, paramFragment, "wait-fragment");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  final void a(int paramInt, LoaderManager.LoaderCallbacks<?> paramLoaderCallbacks, Bundle paramBundle)
  {
    LoaderManager localLoaderManager = g.getLoaderManager();
    localLoaderManager.destroyLoader(paramInt);
    localLoaderManager.restartLoader(paramInt, paramBundle, paramLoaderCallbacks);
  }
  
  public final void a(int paramInt, boolean paramBoolean, cag paramcag)
  {
    if (paramBoolean) {}
    for (Collection localCollection = B.d();; localCollection = Conversation.a(l))
    {
      an = paramBoolean;
      if (paramInt != buc.fA) {
        break;
      }
      a(new cih(this, localCollection), paramInt);
      return;
      cvm.b(I, "Will act upon %s", new Object[] { l });
    }
    if (paramInt == buc.ee)
    {
      a(new cii(this, localCollection, paramBoolean, paramcag), paramInt);
      return;
    }
    if (paramInt == buc.ed)
    {
      a(new cij(this, localCollection, paramBoolean, paramcag), paramInt);
      return;
    }
    a(new cik(this, localCollection, a(paramInt, localCollection, paramBoolean, paramcag), paramBoolean), paramInt);
  }
  
  final void a(DialogInterface.OnClickListener paramOnClickListener, int paramInt)
  {
    al = paramOnClickListener;
    am = paramInt;
  }
  
  public final void a(DataSetObserver paramDataSetObserver)
  {
    x.registerObserver(paramDataSetObserver);
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject1 = g.f().a();
    Object localObject3;
    if (localObject1 != null)
    {
      f = new cjs(g);
      localObject2 = f;
      localObject3 = g;
      a = ((zc)localObject1);
      c = this;
      b = ((ckv)localObject3);
      k = new cju((cjs)localObject2);
      k.a(c);
      ((cjs)localObject2).a(l.a(((ckv)localObject3).n()));
      ((zc)localObject1).d(false);
      localObject1 = f;
      if (a != null) {
        a.a(6, 6);
      }
    }
    if (MailLogService.a)
    {
      ad = new cin(this);
      n.post(ad);
    }
    g.setDefaultKeyMode(2);
    p = g.getContentResolver();
    ab = new cqb();
    localObject1 = j;
    Object localObject2 = g;
    ((cpp)localObject1).a(d.a(((ckv)localObject2).n()));
    localObject1 = g.findViewById(buc.aj);
    ((View)localObject1).setOnClickListener(this);
    gnu.a((View)localObject1, new gnr(hlh.a));
    o.a(this);
    G = new bxl(g, this);
    F = ((ActionableToastBar)g.findViewById(buc.fr));
    localObject1 = g.f().a();
    if (localObject1 != null)
    {
      ((zc)localObject1).a(10, 10);
      localObject1 = f;
      d = o;
      d.a((crk)localObject1);
    }
    W.a(g.getWindow().getDecorView());
    localObject1 = g.getIntent();
    m = new crr(g, this, (Intent)localObject1, paramBundle);
    m.a(this);
    a(m);
    int i1;
    boolean bool1;
    if (g.getLoaderManager().getLoader(34) == null)
    {
      i1 = 1;
      if ((i1 == 0) || (paramBundle == null)) {
        break label697;
      }
      bool1 = paramBundle.containsKey("saved-account");
      bool2 = paramBundle.containsKey("saved-folder");
      if (bool1) {
        d((Account)paramBundle.getParcelable("saved-account"));
      }
      if (bool2) {
        a((Folder)paramBundle.getParcelable("saved-folder"), paramBundle.getString("saved-query", null));
      }
      if (paramBundle.containsKey("saved-all-accounts"))
      {
        localObject1 = (Account[])cwl.a(paramBundle, "saved-all-accounts", Account.class);
        if ((localObject1 != null) && (localObject1.length > 0)) {
          a((Account[])localObject1);
        }
      }
      if (paramBundle.containsKey("saved-action")) {
        am = paramBundle.getInt("saved-action");
      }
      an = paramBundle.getBoolean("saved-action-from-selected", false);
      localObject1 = o;
      if (paramBundle != null)
      {
        i1 = paramBundle.getInt("view-mode", 0);
        if (i1 != 0) {
          ((crj)localObject1).f(i1);
        }
      }
      if ((!bool2) && (bool1) && (o.a == 0)) {
        a(32, ai, Bundle.EMPTY);
      }
      ap = paramBundle.getBoolean("saved-peeking", false);
      aq = ((Conversation)paramBundle.getParcelable("saved-peeking-conv"));
    }
    label697:
    while (localObject1 == null)
    {
      boolean bool2;
      g.getLoaderManager().initLoader(0, Bundle.EMPTY, aj);
      return;
      i1 = 0;
      break;
    }
    cvm.b(I, "IN AAC.handleIntent. action=%s", new Object[] { ((Intent)localObject1).getAction() });
    if ("android.intent.action.VIEW".equals(((Intent)localObject1).getAction())) {
      if (((Intent)localObject1).hasExtra("mail_account")) {
        paramBundle = ((Intent)localObject1).getStringExtra("mail_account");
      }
    }
    for (;;)
    {
      label758:
      if (paramBundle != null) {
        c(Account.a(paramBundle));
      }
      if (c == null) {
        break;
      }
      bool1 = ((Intent)localObject1).hasExtra("conversationUri");
      if (((Intent)localObject1).getBooleanExtra("notification", false))
      {
        localObject2 = buo.a();
        if (bool1)
        {
          paramBundle = "conversation";
          label811:
          ((but)localObject2).a("notification_click", paramBundle, null, 0L);
          if (cxf.a(h, c)) {
            g.a(new gnr(hli.a));
          }
          label855:
          if (s)
          {
            if ((!bool1) || (o.a != 0)) {
              break label1095;
            }
            o.f(1);
          }
          label885:
          localObject2 = new Bundle();
          if (!((Intent)localObject1).hasExtra("folderUri")) {
            break label1107;
          }
          paramBundle = (Uri)((Intent)localObject1).getParcelableExtra("folderUri");
          label917:
          ag = ((Intent)localObject1).getBooleanExtra("ignore-initial-conversation-limit", false);
          ((Bundle)localObject2).putParcelable("folderUri", paramBundle);
          ((Bundle)localObject2).putParcelable("conversationUri", ((Intent)localObject1).getParcelableExtra("conversationUri"));
          a(34, ai, (Bundle)localObject2);
        }
      }
      for (;;)
      {
        if (c == null) {
          break label1367;
        }
        a(1, aj, Bundle.EMPTY);
        break;
        if (!((Intent)localObject1).hasExtra("account")) {
          break label1369;
        }
        paramBundle = ((Intent)localObject1).getStringExtra("account");
        break label758;
        paramBundle = "conversation_list";
        break label811;
        if (((Intent)localObject1).getBooleanExtra("from-widget", false))
        {
          localObject2 = buo.a();
          if (bool1) {}
          for (paramBundle = "conversation_tapped";; paramBundle = "folder_tapped")
          {
            ((but)localObject2).a("widget", paramBundle, null, 0L);
            break;
          }
        }
        if (!((Intent)localObject1).getBooleanExtra("from-shortcut", false)) {
          break label855;
        }
        buo.a().a("shortcut", "shortcut_tapped", null, 0L);
        break label855;
        label1095:
        o.f(2);
        break label885;
        label1107:
        if (((Intent)localObject1).hasExtra("folder"))
        {
          paramBundle = agetStringExtra"folder"c.b;
          break label917;
        }
        paramBundle = ((Intent)localObject1).getExtras();
        localObject3 = I;
        if (paramBundle == null) {}
        for (paramBundle = "null";; paramBundle = paramBundle.toString())
        {
          cvm.b((String)localObject3, "Couldn't find a folder URI in the extras: %s", new Object[] { paramBundle });
          paramBundle = c.z.i;
          break;
        }
        if ("android.intent.action.SEARCH".equals(((Intent)localObject1).getAction())) {
          if (((Intent)localObject1).hasExtra("mail_account"))
          {
            P = false;
            paramBundle = ((Intent)localObject1).getStringExtra("query");
            new crt(m).execute(new String[] { paramBundle });
            c((Account)((Intent)localObject1).getParcelableExtra("mail_account"));
            paramBundle = new Bundle(1);
            paramBundle.putString("query", ((Intent)localObject1).getStringExtra("query"));
            g.getLoaderManager().restartLoader(33, paramBundle, ai);
            if (H()) {
              o.f(4);
            } else {
              o.f(3);
            }
          }
          else
          {
            cvm.e(I, "Missing account extra from search intent.  Finishing", new Object[0]);
            g.finish();
          }
        }
      }
      label1367:
      break;
      label1369:
      paramBundle = null;
    }
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    ActionableToastBar.a(F, paramMotionEvent);
  }
  
  protected abstract void a(btp parambtp);
  
  public final void a(cgn paramcgn)
  {
    af = paramcgn;
  }
  
  final void a(cmx paramcmx)
  {
    if (ak != null) {
      ak.a();
    }
    ak = paramcmx;
  }
  
  public final void a(ConversationMessage paramConversationMessage, boolean paramBoolean)
  {
    int i2 = 1;
    if (D == paramBoolean) {
      return;
    }
    D = paramBoolean;
    Object localObject = a.f();
    if (localObject != null) {
      ad).D = paramBoolean;
    }
    label100:
    boolean bool;
    if (!paramBoolean)
    {
      localObject = a.f();
      if (localObject != null)
      {
        i1 = -1;
        do
        {
          i1 += 1;
          if (!((byw)localObject).moveToPosition(i1)) {
            break;
          }
        } while (!aD);
        i1 = 1;
        if (i1 != 0)
        {
          i1 = 1;
          if (i1 == 0) {
            break label213;
          }
        }
      }
    }
    else
    {
      bool = true;
      label107:
      localObject = paramConversationMessage.a();
      if (bool != l)
      {
        l = bool;
        u.a(c, "starred", Boolean.valueOf(bool));
      }
      localObject = new ContentValues(1);
      if (!paramBoolean) {
        break label219;
      }
    }
    label213:
    label219:
    for (int i1 = i2;; i1 = 0)
    {
      ((ContentValues)localObject).put("starred", Integer.valueOf(i1));
      new chw(this).a(p, f, (ContentValues)localObject, null, null);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label100;
      bool = false;
      break label107;
    }
  }
  
  public void a(Account paramAccount)
  {
    int i2 = 1;
    cvm.b(I, "AAC.switchToDefaultAccount(%s)", new Object[] { paramAccount });
    if (crj.c(o.a))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra-account", paramAccount);
      g.setResult(-1, localIntent);
      g.finish();
      return;
    }
    if (c == null)
    {
      i1 = 1;
      if ((i1 != 0) || (!g.equals(c.g))) {
        break label116;
      }
    }
    label116:
    for (int i1 = i2;; i1 = 0)
    {
      if (i1 == 0) {
        break label121;
      }
      n();
      return;
      i1 = 0;
      break;
    }
    label121:
    b(paramAccount);
  }
  
  public final void a(Conversation paramConversation, Set<Uri> paramSet, byte[] paramArrayOfByte)
  {
    if (Q())
    {
      ao = true;
      g.f().f();
    }
    for (;;)
    {
      j = false;
      if (u != null) {
        break;
      }
      cvm.b(I, "markConversationMessagesUnread(id=%d), deferring", new Object[] { Long.valueOf(b) });
      w.add(new ciq(this, paramConversation, paramSet, paramArrayOfByte));
      return;
      b(null);
    }
    cvm.b(I, "markConversationMessagesUnread(id=%d), performing", new Object[] { Long.valueOf(b) });
    b(paramConversation, paramSet, paramArrayOfByte);
  }
  
  protected void a(Conversation paramConversation, boolean paramBoolean)
  {
    paramBoolean = Q() & paramBoolean;
    if ((!paramBoolean) && (paramConversation != null) && (paramConversation.equals(l)) && (J()))
    {
      cvm.c(I, "peek->normal: marking current CV seen. conv=%s", new Object[] { l });
      return;
    }
    ao = paramBoolean;
    if (paramConversation != null)
    {
      localObject = cxa.b;
      long l1 = SystemClock.uptimeMillis();
      b = l1;
      a = l1;
      if (!TextUtils.isEmpty(c)) {
        break label136;
      }
    }
    label136:
    for (Object localObject = "SimpleTimer";; localObject = c)
    {
      cvm.b((String)localObject, "timer START", new Object[0]);
      if ((MailLogService.a) && (cvm.a(MailLogService.b, 3))) {
        break;
      }
      c(paramConversation);
      return;
    }
    String str = String.format("showConversation(%s)", new Object[] { paramConversation });
    if (MailLogService.c.containsKey("AbstractActivityController")) {
      localObject = (btt)MailLogService.c.get("AbstractActivityController");
    }
    for (;;)
    {
      ((btt)localObject).a(str);
      break;
      localObject = new btt();
      MailLogService.c.put("AbstractActivityController", localObject);
    }
  }
  
  public final void a(Folder paramFolder)
  {
    buo.a().a("load_more", c.e, null, 0L);
    if ((paramFolder != null) && (t != null)) {
      b(t);
    }
  }
  
  protected void a(Folder paramFolder, boolean paramBoolean)
  {
    if ((d == null) || (!d.equals(paramFolder))) {
      B.a();
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramFolder != null) && (paramFolder.d(4096)))
    {
      localObject1 = k.c;
      if (!hbc.a(d, paramFolder)) {
        e(false);
      }
      if (((paramFolder != null) && ((!paramFolder.equals(d)) || (paramBoolean))) || (o.a != 2))
      {
        a(paramFolder, (String)localObject1);
        if ((s) || (Q == null)) {
          a(k);
        }
        if (d != null)
        {
          localObject1 = j;
          localObject2 = d;
          localObject3 = c;
          if ((b == null) || (!b.equals(localObject3)))
          {
            if (localObject3 == null) {
              break label345;
            }
            ((cpp)localObject1).a((Account)localObject3);
          }
          if ((!((Folder)localObject2).a()) && (!((Folder)localObject2).d(4096))) {
            break label362;
          }
          cvm.b("RecentFolderList", "Not touching recent folder because it's provider or search folder", new Object[0]);
        }
      }
    }
    for (;;)
    {
      d(true);
      if ((paramFolder != null) && (paramFolder.d(2)))
      {
        localObject1 = cfk.a(h, c.c, paramFolder);
        if (g != 0) {
          break label418;
        }
        if (d.getLong("inbox-sync-off", 0L) <= System.currentTimeMillis())
        {
          localObject2 = h.getString(buj.cG, new Object[] { d });
          buo.a().a("settings", "inbox_sync_off", d, 0L);
          F.a(new cim(this, paramFolder), (CharSequence)localObject2, buj.fl, false, true, null);
          ((cfk)localObject1).d(false);
        }
      }
      return;
      localObject1 = null;
      break;
      label345:
      cvm.d("RecentFolderList", "No account set for setting recent folders?", new Object[0]);
      continue;
      label362:
      localObject3 = new cps((Folder)localObject2);
      c.a(c.b.toString(), localObject3);
      new cpt((cpp)localObject1, b, (Folder)localObject2).execute(new Void[0]);
    }
    label418:
    ((cfk)localObject1).d(true);
  }
  
  public void a(ConversationCheckedSet paramConversationCheckedSet)
  {
    E = new bzq(g, this, paramConversationCheckedSet, d);
    if ((crj.a(o.a)) || ((s) && (crj.b(o.a)))) {
      V();
    }
  }
  
  public final void a(ToastBarOperation paramToastBarOperation)
  {
    n.post(new chz(this, paramToastBarOperation));
  }
  
  public final void a(cqp paramcqp)
  {
    if (paramcqp != null) {
      cvm.c(I, "AAC.onAnimationEnd. cursor=%s adapter=%s", new Object[] { u, paramcqp });
    }
    if (u == null) {
      cvm.e(I, "null ConversationCursor in onAnimationEnd", new Object[0]);
    }
    do
    {
      return;
      if (u.h)
      {
        cvm.c("ConversationCursor", "Stopped animating: try sync", new Object[0]);
        A_();
      }
      if (u.i)
      {
        cvm.c("ConversationCursor", "Stopped animating: refresh", new Object[0]);
        u.l();
      }
    } while (!N);
    N = false;
    y.notifyChanged();
  }
  
  protected abstract void a(Runnable paramRunnable);
  
  public final void a(String paramString)
  {
    buq.b.a("open_threadlist");
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.SEARCH");
    localIntent.putExtra("query", paramString);
    localIntent.putExtra("mail_account", c);
    if ((d != null) && (d.a(65536))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("multipleAccounts", bool);
      localIntent.setComponent(g.getComponentName());
      m.a(0, true);
      g.startActivityForResult(localIntent, 3);
      return;
    }
  }
  
  public final void a(String paramString, Parcelable paramParcelable)
  {
    aa.putParcelable(paramString, paramParcelable);
  }
  
  protected void a(StringBuilder paramStringBuilder) {}
  
  public final void a(Collection<Conversation> paramCollection)
  {
    a(paramCollection, null);
  }
  
  protected void a(Collection<Conversation> paramCollection, int paramInt)
  {
    paramCollection = D.a(paramInt, paramCollection);
    if ((paramInt != 3) && (paramCollection != null)) {
      buq.b.a("open_conv_from_list");
    }
    cvm.b(I, "showNextConversation: showing %s next.", new Object[] { paramCollection });
    b(paramCollection);
  }
  
  public final void a(Collection<Conversation> paramCollection, ContentValues paramContentValues)
  {
    av();
    bwg localbwg = u;
    localbwg.apply(localbwg.a(paramCollection, 2, paramContentValues, null));
    ab();
  }
  
  public final void a(Collection<Conversation> paramCollection, cmx paramcmx, boolean paramBoolean)
  {
    a(paramCollection, new chy(this, paramCollection, paramcmx, paramBoolean));
  }
  
  public final void a(Collection<Conversation> paramCollection, String paramString, int paramInt)
  {
    av();
    u.a(paramCollection, paramString, paramInt);
    ab();
  }
  
  public final void a(Collection<Conversation> paramCollection, String paramString, boolean paramBoolean)
  {
    av();
    u.a(paramCollection, paramString, paramBoolean);
    ab();
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((d.a(1024)) && (FolderOperation.a(paramBoolean, d))) {}
    Collection localCollection;
    Object localObject;
    for (boolean bool3 = true;; bool3 = false)
    {
      cvm.b(I, "onFolderChangesCommit: isDestructive = %b", new Object[] { Boolean.valueOf(bool3) });
      if (!bool3) {
        break;
      }
      localObject = localCollection.iterator();
      while (((Iterator)localObject).hasNext()) {
        nextD = true;
      }
    }
    boolean bool2;
    cag localcag;
    Iterator localIterator;
    int i1;
    if (bool2)
    {
      localcag = a(buc.cT, l);
      if (!bool3) {
        break label235;
      }
      if (paramBoolean.size() == 2)
      {
        localIterator = paramBoolean.iterator();
        localObject = null;
        i1 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label194;
        }
        FolderOperation localFolderOperation = (FolderOperation)localIterator.next();
        if (c)
        {
          localObject = b;
          continue;
          localcag = null;
          break;
        }
        i1 = 1;
      }
      label194:
      if ((i1 == 0) || (localObject == null)) {}
    }
    boolean bool1;
    for (;;)
    {
      a(localCollection, a(localCollection, paramBoolean, true, bool1, true, bool2, (Folder)localObject, localcag), bool1);
      return;
      localObject = d;
    }
    label235:
    paramBoolean = a(localCollection, paramBoolean, false, bool1, true, false, d, localcag);
    a(paramBoolean);
    paramBoolean.a();
    ab();
  }
  
  public final void a(Collection<Conversation> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    cvm.b(I, "markConversationsRead(targets=%s)", paramCollection.toArray());
    if (u == null)
    {
      if (cvm.a(I, 3)) {
        cvm.b(I, "markConversationsRead(targets=%s), deferring", paramCollection.toArray());
      }
      w.add(new cis(this, paramCollection, paramBoolean1, paramBoolean2));
      return;
    }
    b(paramCollection, paramBoolean1, paramBoolean2);
  }
  
  protected final void a(boolean paramBoolean)
  {
    try
    {
      if (u != null)
      {
        cxa.a(u, paramBoolean, Y);
        Y = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void a(Account[] paramArrayOfAccount)
  {
    Account[] arrayOfAccount = paramArrayOfAccount;
    if (paramArrayOfAccount == null)
    {
      cvm.f(I, "AbstractActivityController.setAllAccount(null) is not allowed", new Object[0]);
      arrayOfAccount = new Account[0];
    }
    ae = arrayOfAccount;
    ah.notifyChanged();
  }
  
  public abstract boolean a(int paramInt);
  
  final boolean a(Fragment paramFragment)
  {
    return (paramFragment != null) && (paramFragment.isVisible()) && (g.hasWindowFocus());
  }
  
  public final boolean a(Menu paramMenu)
  {
    if (crj.e(o.a)) {
      return false;
    }
    Object localObject = g.getMenuInflater();
    int i1;
    switch (f.a())
    {
    default: 
      cvm.f(cjs.j, "Menu requested for unknown view mode", new Object[0]);
      i1 = buf.d;
    }
    for (;;)
    {
      ((MenuInflater)localObject).inflate(i1, paramMenu);
      localObject = f;
      f = paramMenu.findItem(buc.em);
      g = paramMenu.findItem(buc.br);
      h = paramMenu.findItem(buc.bp);
      ((cjs)localObject).a();
      paramMenu = paramMenu.findItem(buc.ai);
      if ((paramMenu != null) && ((i1 != buf.c) || (as())) && (((AccessibilityManager)g.getSystemService("accessibility")).isTouchExplorationEnabled())) {
        paramMenu.setVisible(true);
      }
      return true;
      i1 = buf.d;
      continue;
      i1 = buf.c;
      continue;
      i1 = buf.d;
      continue;
      i1 = buf.e;
      continue;
      i1 = buf.c;
      continue;
      i1 = buf.o;
    }
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    int i2 = paramMenuItem.getItemId();
    cvm.b(I, "AbstractController.onOptionsItemSelected(%d) called.", new Object[] { Integer.valueOf(i2) });
    Object localObject2 = buo.a();
    Object localObject1 = String.valueOf(o.a());
    label107:
    boolean bool1;
    label118:
    cag localcag;
    if (((String)localObject1).length() != 0)
    {
      localObject1 = "action_bar/".concat((String)localObject1);
      ((but)localObject2).a("menu_item", i2, (String)localObject1);
      g.b(i2, c);
      localObject2 = Conversation.a(l);
      if (c != null) {
        break label269;
      }
      localObject1 = null;
      if (a(i2)) {
        break label281;
      }
      bool1 = true;
      e(bool1);
      localcag = a(i2, l);
      if ((((Collection)localObject2).size() <= 0) || (!bwg.a(u))) {
        break label1183;
      }
      if (i2 != buc.x) {
        break label293;
      }
      if ((localObject1 == null) || (!f)) {
        break label287;
      }
      bool1 = true;
      label178:
      a(i2, (Collection)localObject2, bool1, buh.b, localcag);
      bool1 = true;
    }
    for (;;)
    {
      label195:
      boolean bool2 = bool1;
      if (!bool1)
      {
        if (i2 != 16908332) {
          break label1003;
        }
        y();
        bool2 = true;
      }
      for (;;)
      {
        if ((bool2) || (E == null) || (!E.c) || (!E.a(paramMenuItem))) {
          break label1174;
        }
        return true;
        localObject1 = new String("action_bar/");
        break;
        label269:
        localObject1 = c.z;
        break label107;
        label281:
        bool1 = false;
        break label118;
        label287:
        bool1 = false;
        break label178;
        label293:
        if (i2 == buc.dP)
        {
          a((Collection)localObject2, a((Collection)localObject2, d, false, localcag), false);
          bool1 = true;
          break label195;
        }
        if (i2 == buc.aV)
        {
          if ((localObject1 != null) && (e)) {}
          for (bool1 = true;; bool1 = false)
          {
            a(i2, (Collection)localObject2, bool1, buh.c, localcag);
            bool1 = true;
            break;
          }
        }
        if (i2 == buc.ba)
        {
          a(i2, (Collection)localObject2, true, buh.d, localcag);
          bool1 = true;
          break label195;
        }
        if (i2 == buc.bb)
        {
          a((Collection)localObject2, a(i2, (Collection)localObject2, false, localcag), false);
          bool1 = true;
          break label195;
        }
        if (i2 == buc.cA)
        {
          a(Conversation.a(l), "importance", 1);
          bool1 = true;
          break label195;
        }
        if (i2 == buc.cB)
        {
          if ((d != null) && (d.a(128)))
          {
            a((Collection)localObject2, a(i2, (Collection)localObject2, false, localcag), false);
            bool1 = true;
            break label195;
          }
          a((Collection)localObject2, "importance", 0);
          bool1 = true;
          break label195;
        }
        if (i2 == buc.cX)
        {
          a((Collection)localObject2, a(buc.cX, (Collection)localObject2, false, localcag), false);
          bool1 = true;
          break label195;
        }
        if (i2 == buc.fA)
        {
          a(buc.fA, false, null);
          localObject1 = h.getString(buj.av, new Object[] { l.y });
          bvy.a(h.getString(buj.ft), (CharSequence)localObject1, buj.ft).show(g.getFragmentManager(), "confirm-dialog");
          bool1 = true;
          break label195;
        }
        if (i2 == buc.ea)
        {
          int i1;
          if ((l.A == 1) && (c != null) && (c.a(8388608L)) && (l.f())) {
            i1 = 1;
          }
          for (;;)
          {
            if (i1 != 1) {
              break label807;
            }
            a(buc.ee, false, localcag);
            cpv.a(new String[] { l.y }).show(g.getFragmentManager(), "report-spam-unsubscribe-dialog");
            bool1 = true;
            break;
            if ((l.A == 2) && (c != null) && (c.a(16L)) && (d != null) && (d.a(32)) && (!l.r)) {
              i1 = 2;
            } else {
              i1 = 0;
            }
          }
          label807:
          if (i1 == 2)
          {
            a(buc.ed, false, localcag);
            new cpu().show(g.getFragmentManager(), "report-spam-mute-dialog");
            bool1 = true;
            break label195;
          }
          a((Collection)localObject2, a(buc.ea, (Collection)localObject2, false, localcag), false);
          bool1 = true;
          break label195;
        }
        if (i2 == buc.cC)
        {
          a((Collection)localObject2, a(buc.cC, (Collection)localObject2, false, localcag), false);
          bool1 = true;
          break label195;
        }
        if ((i2 == buc.cT) || (i2 == buc.ac))
        {
          if (!g.u) {
            break label1177;
          }
          cob.a(a(l.s), (Collection)localObject2, false, d, i2, null).show(g.getFragmentManager(), null);
          bool1 = true;
          break label195;
        }
        if (i2 == buc.cU)
        {
          new cip(this, (Collection)localObject2).execute(null);
          bool1 = true;
          break label195;
        }
        bool1 = false;
        break label195;
        label1003:
        if (i2 == buc.ai)
        {
          cbk.a(g, c);
          bool2 = true;
        }
        else if (i2 == buc.dO)
        {
          A();
          bool2 = true;
        }
        else if (i2 == buc.fs)
        {
          a(null);
          bool2 = true;
        }
        else if (i2 == buc.eG)
        {
          cxa.a(g, c);
          bool2 = true;
        }
        else if (i2 == buc.bO)
        {
          g.a(c, o.a);
          bool2 = true;
        }
        else if (i2 == buc.br)
        {
          t();
          bool2 = true;
        }
        else if (i2 == buc.bp)
        {
          t();
          bool2 = true;
        }
        else if (i2 == buc.em)
        {
          W();
          bool2 = true;
        }
        else
        {
          bool2 = false;
        }
      }
      label1174:
      return bool2;
      label1177:
      bool1 = true;
      continue;
      label1183:
      bool1 = false;
    }
  }
  
  public final boolean a(Conversation paramConversation)
  {
    if (ao)
    {
      cvm.c(I, "AAC is in peek mode, not marking seen. conv=%s", new Object[] { paramConversation });
      return false;
    }
    g.a(a(s));
    a(Arrays.asList(new Conversation[] { paramConversation }), true, true);
    return true;
  }
  
  final void aa()
  {
    boolean bool;
    Conversation localConversation;
    if (("android.intent.action.SEARCH".equals(g.getIntent().getAction())) && (u.getCount() > 0))
    {
      bool = true;
      P = bool;
      if ((!crj.e(o.a)) && (l == null) && (Q()) && (u.getCount() > 0))
      {
        if ((!ao) || (aq == null)) {
          break label127;
        }
        localConversation = aq;
        aq = null;
        cvm.c(I, "peeking at saved conv=%s", new Object[] { localConversation });
      }
    }
    for (;;)
    {
      a(localConversation, true);
      return;
      bool = false;
      break;
      label127:
      u.moveToPosition(0);
      localConversation = u.m();
      C = 0;
      cvm.c(I, "peeking at default/zeroth conv=%s", new Object[] { localConversation });
    }
  }
  
  public final void ab()
  {
    cje localcje = g();
    if (localcje == null) {
      return;
    }
    localcje.e();
  }
  
  public final void ac()
  {
    bxd.a.evictAll();
    Object localObject = g();
    if (localObject != null)
    {
      localObject = ((cje)localObject).c();
      if (localObject != null) {
        ((cqp)localObject).notifyDataSetInvalidated();
      }
    }
  }
  
  public final DialogInterface.OnClickListener ad()
  {
    return al;
  }
  
  public final void ae()
  {
    Object localObject = g();
    if (localObject != null)
    {
      ((cje)localObject).i();
      if (l == null) {
        break label58;
      }
    }
    label58:
    for (localObject = l.c;; localObject = null)
    {
      Z = ((Uri)localObject);
      return;
      if (!s) {
        break;
      }
      cvm.e(I, "AAC.setDetachedMode(): CLF = null!", new Object[0]);
      break;
    }
  }
  
  public boolean af()
  {
    return false;
  }
  
  public final cmz ag()
  {
    return V;
  }
  
  protected abstract boolean ah();
  
  public final boolean ai()
  {
    return true;
  }
  
  protected final void aj()
  {
    new cil(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
  }
  
  public final View.OnClickListener ak()
  {
    return at;
  }
  
  protected abstract boolean al();
  
  public final long am()
  {
    return U;
  }
  
  public final Parcelable b(String paramString)
  {
    return aa.getParcelable(paramString);
  }
  
  public final cmx b(int paramInt)
  {
    ciu localciu = new ciu(this, paramInt, B.d(), true);
    a(localciu);
    return localciu;
  }
  
  protected final ctd b(cqp paramcqp)
  {
    return new cia(this, paramcqp);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i1 = 4;
    Object localObject;
    if ((cxd.c()) && (g.o))
    {
      localObject = g();
      if (localObject != null)
      {
        localObject = ((cje)localObject).d();
        if (localObject != null)
        {
          if (paramInt2 != 1) {
            break label84;
          }
          paramInt1 = 4;
          ((View)localObject).setImportantForAccessibility(paramInt1);
        }
      }
      localObject = g.findViewById(buc.cw);
      if (localObject != null) {
        if (paramInt2 == 0) {
          break label89;
        }
      }
    }
    label84:
    label89:
    for (paramInt1 = i1;; paramInt1 = 0)
    {
      ((View)localObject).setImportantForAccessibility(paramInt1);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public final void b(DataSetObserver paramDataSetObserver)
  {
    x.unregisterObserver(paramDataSetObserver);
  }
  
  final void b(Uri paramUri)
  {
    if (K != null) {
      K.cancel(true);
    }
    K = new ckh(g, paramUri);
    K.execute(new Void[0]);
  }
  
  public void b(Bundle paramBundle)
  {
    Object localObject = o;
    if (paramBundle != null) {
      paramBundle.putInt("view-mode", a);
    }
    if (ae.length > 0) {
      paramBundle.putParcelableArray("saved-all-accounts", ae);
    }
    if (c != null) {
      paramBundle.putParcelable("saved-account", c);
    }
    if (d != null) {
      paramBundle.putParcelable("saved-folder", d);
    }
    if (btp.a(k)) {
      paramBundle.putString("saved-query", k.c);
    }
    if ((l != null) && (crj.b(o.a))) {
      paramBundle.putParcelable("saved-conversation", l);
    }
    if (!B.b()) {
      paramBundle.putParcelable("saved-selected-set", B);
    }
    if (!F.g()) {
      paramBundle.putParcelable("saved-toast-bar-op", F.b);
    }
    localObject = g();
    if (localObject != null) {
      ((cje)localObject).c().a(paramBundle);
    }
    if (am != -1)
    {
      paramBundle.putInt("saved-action", am);
      paramBundle.putBoolean("saved-action-from-selected", an);
    }
    if (Z != null) {
      paramBundle.putParcelable("saved-detached-conv-uri", Z);
    }
    paramBundle.putParcelable("saved-hierarchical-folder", L);
    paramBundle.putParcelable("m-inbox", e);
    paramBundle.putBundle("saved-conversation-list-scroll-positions", aa);
    paramBundle.putBoolean("saved-peeking", ao);
    paramBundle.putParcelable("saved-peeking-conv", aq);
    localObject = m;
    paramBundle.putInt("extraSearchViewControllerViewState", i);
    if (f != null) {
      f.a(paramBundle);
    }
  }
  
  public void b(Menu paramMenu)
  {
    boolean bool2 = true;
    cjs localcjs = f;
    paramMenu.setQwertyMode(true);
    cvm.b(cjs.j, "ActionBarView.onPrepareOptionsMenu().", new Object[0]);
    localcjs.b();
    switch (localcjs.a())
    {
    }
    do
    {
      return;
    } while (i == null);
    Account localAccount = b.n().a(i.s);
    int i1;
    if (!i.a())
    {
      i1 = 1;
      int i2 = buc.cA;
      if ((i1 == 0) || (localAccount == null) || (!localAccount.a(131072L))) {
        break label892;
      }
      bool1 = true;
      label146:
      cxa.a(paramMenu, i2, bool1);
      i2 = buc.cB;
      if ((i1 != 0) || (localAccount == null) || (!localAccount.a(131072L))) {
        break label898;
      }
      bool1 = true;
      label180:
      cxa.a(paramMenu, i2, bool1);
      if ((e == null) || (!e.d(8))) {
        break label904;
      }
      i1 = 1;
      label210:
      if ((e == null) || (i1 == 0)) {
        break label909;
      }
      bool1 = true;
      label225:
      cxa.a(paramMenu, buc.bb, bool1);
      if ((i1 != 0) || (e == null) || (!e.a(4))) {
        break label915;
      }
      bool1 = true;
      label261:
      cxa.a(paramMenu, buc.aV, bool1);
      if ((bool1) || (e == null) || (!e.d(4)) || (localAccount == null) || (!localAccount.a(1048576L))) {
        break label921;
      }
      bool1 = true;
      label314:
      cxa.a(paramMenu, buc.ba, bool1);
      if ((localAccount == null) || (!localAccount.a(4L)) || (e == null) || (!e.a(2)) || (e.d(32))) {
        break label927;
      }
      bool1 = true;
      label375:
      cxa.a(paramMenu, buc.x, bool1);
      i1 = buc.dP;
      if ((bool1) || (e == null) || (!e.a(1)) || (e.a()) || (localAccount == null) || (!localAccount.a(4L))) {
        break label933;
      }
      bool1 = true;
      label443:
      cxa.a(paramMenu, i1, bool1);
      i1 = buc.cT;
      if ((e == null) || (!e.a(1024)) || (localAccount == null) || (!localAccount.a(8L))) {
        break label939;
      }
      bool1 = true;
      label495:
      cxa.a(paramMenu, i1, bool1);
      i1 = buc.cU;
      if ((e == null) || (!e.a(4096)) || (localAccount == null) || (!localAccount.a(8L))) {
        break label945;
      }
      bool1 = true;
      label547:
      cxa.a(paramMenu, i1, bool1);
      i1 = buc.ac;
      if ((localAccount == null) || (!localAccount.a(16384L)) || (!localAccount.a(8L))) {
        break label951;
      }
      bool1 = true;
      label588:
      cxa.a(paramMenu, i1, bool1);
      MenuItem localMenuItem = paramMenu.findItem(buc.dP);
      if ((e != null) && (localMenuItem != null)) {
        localMenuItem.setTitle(b.getApplicationContext().getString(buj.ed, new Object[] { e.d }));
      }
      i1 = buc.ea;
      if ((localAccount == null) || (!localAccount.a(2L)) || (e == null) || (!e.a(8)) || (i.q)) {
        break label957;
      }
      bool1 = true;
      label713:
      cxa.a(paramMenu, i1, bool1);
      i1 = buc.cC;
      if ((localAccount == null) || (!localAccount.a(2L)) || (e == null) || (!e.a(16)) || (!i.q)) {
        break label963;
      }
      bool1 = true;
      label775:
      cxa.a(paramMenu, i1, bool1);
      i1 = buc.cX;
      if ((localAccount == null) || (!localAccount.a(16L)) || (e == null) || (!e.a(32)) || (i.r)) {
        break label969;
      }
      bool1 = true;
      label837:
      cxa.a(paramMenu, i1, bool1);
      i1 = buc.fA;
      if ((localAccount == null) || (!localAccount.a(8388608L)) || (!i.f())) {
        break label975;
      }
    }
    label892:
    label898:
    label904:
    label909:
    label915:
    label921:
    label927:
    label933:
    label939:
    label945:
    label951:
    label957:
    label963:
    label969:
    label975:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      cxa.a(paramMenu, i1, bool1);
      return;
      i1 = 0;
      break;
      bool1 = false;
      break label146;
      bool1 = false;
      break label180;
      i1 = 0;
      break label210;
      bool1 = false;
      break label225;
      bool1 = false;
      break label261;
      bool1 = false;
      break label314;
      bool1 = false;
      break label375;
      bool1 = false;
      break label443;
      bool1 = false;
      break label495;
      bool1 = false;
      break label547;
      bool1 = false;
      break label588;
      bool1 = false;
      break label713;
      bool1 = false;
      break label775;
      bool1 = false;
      break label837;
    }
  }
  
  public final void b(ConversationMessage paramConversationMessage, boolean paramBoolean)
  {
    int i1 = 1;
    if (R == paramBoolean) {
      return;
    }
    ContentValues localContentValues = new ContentValues(1);
    if (paramBoolean) {}
    for (;;)
    {
      localContentValues.put("senderBlocked", Integer.valueOf(i1));
      new chx(this).a(p, f, localContentValues, null, null);
      return;
      i1 = 0;
    }
  }
  
  public void b(Account paramAccount)
  {
    int i3 = 1;
    cvm.b(I, "AAC.changeAccount(%s)", new Object[] { paramAccount });
    if (paramAccount == null) {
      cvm.e(I, "AAC.changeAccount(null) called.", new Object[0]);
    }
    label49:
    label215:
    label218:
    for (;;)
    {
      return;
      int i1;
      if (c == null)
      {
        i1 = 1;
        i2 = i3;
        if (i1 == 0) {
          if (g.equals(c.g)) {
            break label215;
          }
        }
      }
      for (int i2 = i3;; i2 = 0)
      {
        if ((i2 == 0) && (!paramAccount.a(c))) {
          break label218;
        }
        String str = c;
        n.post(new cif(this, str));
        if (i2 != 0) {
          e(false);
        }
        d(paramAccount);
        if (i2 != 0) {
          n();
        }
        if ((c == null) || (Uri.EMPTY.equals(c.z.p))) {
          break;
        }
        paramAccount = new Intent("android.intent.action.EDIT");
        paramAccount.setPackage(h.getPackageName());
        paramAccount.setData(c.z.p);
        g.startActivity(paramAccount);
        return;
        i1 = 0;
        break label49;
      }
    }
  }
  
  protected void b(Conversation paramConversation)
  {
    a(paramConversation, false);
  }
  
  final void b(Conversation paramConversation, Set<Uri> paramSet, byte[] paramArrayOfByte)
  {
    int i1;
    int i2;
    if (paramSet == null)
    {
      i1 = 0;
      i2 = t.b;
      if ((i2 <= 1) || (i1 <= 0) || (i1 >= i2)) {
        break label120;
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      cvm.b(I, "markConversationMessagesUnread(conv=%s), numMessages=%d, unreadCount=%d, subsetIsUnread=%b", new Object[] { paramConversation, Integer.valueOf(i2), Integer.valueOf(i1), Boolean.valueOf(bool) });
      if (bool) {
        break label126;
      }
      cvm.b(I, ". . doing full mark unread", new Object[0]);
      b(Collections.singletonList(paramConversation), false, false);
      return;
      i1 = paramSet.size();
      break;
    }
    label126:
    if (cvm.a(I, 3))
    {
      localObject = ConversationInfo.a(paramArrayOfByte);
      cvm.b(I, ". . doing subset mark unread, originalConversationInfo = %s", new Object[] { localObject });
    }
    u.a(c, "read", Integer.valueOf(0));
    if (paramArrayOfByte != null) {
      u.a(c, "conversationInfo", paramArrayOfByte);
    }
    paramArrayOfByte = new ArrayList();
    paramConversation = null;
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Uri localUri = (Uri)((Iterator)localObject).next();
      paramSet = paramConversation;
      if (paramConversation == null) {
        paramSet = localUri.getAuthority();
      }
      paramArrayOfByte.add(ContentProviderOperation.newUpdate(localUri).withValue("read", Integer.valueOf(0)).build());
      cvm.b(I, ". . Adding op: read=0, uri=%s", new Object[] { localUri });
      paramConversation = paramSet;
    }
    cvm.b(I, ". . operations = %s", new Object[] { paramArrayOfByte });
    new cir(this).a(p, paramConversation, paramArrayOfByte);
  }
  
  public void b(Conversation paramConversation, boolean paramBoolean)
  {
    Object localObject = g();
    if ((localObject != null) && (((cje)localObject).c() != null))
    {
      localObject = ((cje)localObject).c();
      ((cqp)localObject).t();
      cpn localcpn = g.r;
      if ((paramConversation != null) && (localcpn != null))
      {
        int i1 = ((cqp)localObject).a(paramConversation);
        int i2 = ((cqp)localObject).a(i1);
        localcpn.a(c, d, paramConversation, i1 - i2);
      }
    }
    e(s);
    b(paramConversation);
  }
  
  public void b(Folder paramFolder)
  {
    if (J != null) {
      J.a(paramFolder);
    }
    a(paramFolder, false);
  }
  
  /* Error */
  protected final void b(Folder paramFolder, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 581	cht:g	()Lcje;
    //   4: invokevirtual 2267	cje:k	()Lcom/android/mail/providers/Folder;
    //   7: astore 8
    //   9: aload_1
    //   10: aload 8
    //   12: invokevirtual 1505	com/android/mail/providers/Folder:equals	(Ljava/lang/Object;)Z
    //   15: ifne +53 -> 68
    //   18: getstatic 134	cht:I	Ljava/lang/String;
    //   21: astore 6
    //   23: aload_1
    //   24: getfield 1302	com/android/mail/providers/Folder:c	Lcus;
    //   27: astore 7
    //   29: aload 8
    //   31: ifnonnull +28 -> 59
    //   34: aconst_null
    //   35: astore_1
    //   36: aload 6
    //   38: ldc_w 2269
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload 7
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_1
    //   53: aastore
    //   54: invokestatic 509	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   57: pop
    //   58: return
    //   59: aload 8
    //   61: getfield 1302	com/android/mail/providers/Folder:c	Lcus;
    //   64: astore_1
    //   65: goto -29 -> 36
    //   68: aload_1
    //   69: getfield 2270	com/android/mail/providers/Folder:o	I
    //   72: istore_3
    //   73: iload_3
    //   74: invokestatic 2274	chh:b	(I)I
    //   77: istore 4
    //   79: iload 4
    //   81: tableswitch	default:+87->168, 1:+188->269, 2:+501->582, 3:+518->599, 4:+619->700, 5:+87->168, 6:+684->765, 7:+684->765, 8:+684->765, 9:+684->765, 10:+87->168, 11:+87->168, 12:+668->749, 13:+636->717, 14:+652->733, 15:+501->582, 16:+87->168, 17:+87->168, 18:+684->765
    //   168: iload 4
    //   170: invokestatic 2278	chk:a	(I)Ljava/lang/String;
    //   173: astore 6
    //   175: getstatic 2284	java/util/Locale:US	Ljava/util/Locale;
    //   178: ldc_w 2286
    //   181: iconst_2
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   191: getfield 518	com/android/mail/providers/Account:e	Ljava/lang/String;
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload_1
    //   198: invokevirtual 2288	com/android/mail/providers/Folder:b	()Ljava/lang/String;
    //   201: aastore
    //   202: invokestatic 2291	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: astore_1
    //   206: getstatic 134	cht:I	Ljava/lang/String;
    //   209: ldc_w 2293
    //   212: iconst_3
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: iload 4
    //   220: invokestatic 614	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: aload 6
    //   228: aastore
    //   229: dup
    //   230: iconst_2
    //   231: aload_1
    //   232: aastore
    //   233: invokestatic 622	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   236: pop
    //   237: invokestatic 514	buo:a	()Lbut;
    //   240: aload_0
    //   241: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   244: getfield 516	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   247: invokeinterface 2295 2 0
    //   252: pop
    //   253: invokestatic 514	buo:a	()Lbut;
    //   256: ldc_w 2297
    //   259: aload 6
    //   261: aload_1
    //   262: lconst_0
    //   263: invokeinterface 1261 6 0
    //   268: return
    //   269: iload_3
    //   270: invokestatic 2299	chh:c	(I)I
    //   273: istore 5
    //   275: iload 5
    //   277: iconst_1
    //   278: iand
    //   279: ifeq +132 -> 411
    //   282: iconst_1
    //   283: istore_3
    //   284: iload_3
    //   285: ifne +131 -> 416
    //   288: aload_1
    //   289: getfield 1530	com/android/mail/providers/Folder:g	I
    //   292: istore_3
    //   293: iload_3
    //   294: ifgt +10 -> 304
    //   297: iload 5
    //   299: iconst_4
    //   300: iand
    //   301: ifeq +115 -> 416
    //   304: iconst_1
    //   305: istore_3
    //   306: iload_3
    //   307: ifeq +114 -> 421
    //   310: iload 4
    //   312: invokestatic 2278	chk:a	(I)Ljava/lang/String;
    //   315: astore 6
    //   317: getstatic 2284	java/util/Locale:US	Ljava/util/Locale;
    //   320: ldc_w 2286
    //   323: iconst_2
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_0
    //   330: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   333: getfield 518	com/android/mail/providers/Account:e	Ljava/lang/String;
    //   336: aastore
    //   337: dup
    //   338: iconst_1
    //   339: aload_1
    //   340: invokevirtual 2288	com/android/mail/providers/Folder:b	()Ljava/lang/String;
    //   343: aastore
    //   344: invokestatic 2291	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   347: astore_1
    //   348: getstatic 134	cht:I	Ljava/lang/String;
    //   351: ldc_w 2293
    //   354: iconst_3
    //   355: anewarray 4	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: iload 4
    //   362: invokestatic 614	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: aload 6
    //   370: aastore
    //   371: dup
    //   372: iconst_2
    //   373: aload_1
    //   374: aastore
    //   375: invokestatic 622	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   378: pop
    //   379: invokestatic 514	buo:a	()Lbut;
    //   382: aload_0
    //   383: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   386: getfield 516	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   389: invokeinterface 2295 2 0
    //   394: pop
    //   395: invokestatic 514	buo:a	()Lbut;
    //   398: ldc_w 2297
    //   401: aload 6
    //   403: aload_1
    //   404: lconst_0
    //   405: invokeinterface 1261 6 0
    //   410: return
    //   411: iconst_0
    //   412: istore_3
    //   413: goto -129 -> 284
    //   416: iconst_0
    //   417: istore_3
    //   418: goto -112 -> 306
    //   421: new 2301	cic
    //   424: dup
    //   425: aload_0
    //   426: aload_1
    //   427: invokespecial 2302	cic:<init>	(Lcht;Lcom/android/mail/providers/Folder;)V
    //   430: astore 6
    //   432: getstatic 2305	buj:cQ	I
    //   435: istore_3
    //   436: aload_0
    //   437: getfield 263	cht:g	Lcom/android/mail/ui/MailActivity;
    //   440: iload 4
    //   442: invokestatic 2308	cxa:c	(Landroid/content/Context;I)Ljava/lang/CharSequence;
    //   445: astore 7
    //   447: aload 7
    //   449: invokestatic 1465	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   452: ifne +29 -> 481
    //   455: aload_0
    //   456: getfield 1145	cht:F	Lcom/android/mail/ui/toastbar/ActionableToastBar;
    //   459: aload 6
    //   461: aload 7
    //   463: iload_3
    //   464: iload_2
    //   465: iconst_1
    //   466: new 2310	com/android/mail/ui/toastbar/ToastBarOperation
    //   469: dup
    //   470: iconst_2
    //   471: iconst_0
    //   472: iconst_1
    //   473: aload_1
    //   474: aconst_null
    //   475: invokespecial 2313	com/android/mail/ui/toastbar/ToastBarOperation:<init>	(IIILcom/android/mail/providers/Folder;Lctk;)V
    //   478: invokevirtual 1571	com/android/mail/ui/toastbar/ActionableToastBar:a	(Lctd;Ljava/lang/CharSequence;IZZLcom/android/mail/ui/toastbar/ToastBarOperation;)V
    //   481: iload 4
    //   483: invokestatic 2278	chk:a	(I)Ljava/lang/String;
    //   486: astore 6
    //   488: getstatic 2284	java/util/Locale:US	Ljava/util/Locale;
    //   491: ldc_w 2286
    //   494: iconst_2
    //   495: anewarray 4	java/lang/Object
    //   498: dup
    //   499: iconst_0
    //   500: aload_0
    //   501: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   504: getfield 518	com/android/mail/providers/Account:e	Ljava/lang/String;
    //   507: aastore
    //   508: dup
    //   509: iconst_1
    //   510: aload_1
    //   511: invokevirtual 2288	com/android/mail/providers/Folder:b	()Ljava/lang/String;
    //   514: aastore
    //   515: invokestatic 2291	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   518: astore_1
    //   519: getstatic 134	cht:I	Ljava/lang/String;
    //   522: ldc_w 2293
    //   525: iconst_3
    //   526: anewarray 4	java/lang/Object
    //   529: dup
    //   530: iconst_0
    //   531: iload 4
    //   533: invokestatic 614	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   536: aastore
    //   537: dup
    //   538: iconst_1
    //   539: aload 6
    //   541: aastore
    //   542: dup
    //   543: iconst_2
    //   544: aload_1
    //   545: aastore
    //   546: invokestatic 622	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   549: pop
    //   550: invokestatic 514	buo:a	()Lbut;
    //   553: aload_0
    //   554: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   557: getfield 516	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   560: invokeinterface 2295 2 0
    //   565: pop
    //   566: invokestatic 514	buo:a	()Lbut;
    //   569: ldc_w 2297
    //   572: aload 6
    //   574: aload_1
    //   575: lconst_0
    //   576: invokeinterface 1261 6 0
    //   581: return
    //   582: new 2315	cid
    //   585: dup
    //   586: aload_0
    //   587: invokespecial 2316	cid:<init>	(Lcht;)V
    //   590: astore 6
    //   592: getstatic 2319	buj:eS	I
    //   595: istore_3
    //   596: goto -160 -> 436
    //   599: iload 4
    //   601: invokestatic 2278	chk:a	(I)Ljava/lang/String;
    //   604: astore 6
    //   606: getstatic 2284	java/util/Locale:US	Ljava/util/Locale;
    //   609: ldc_w 2286
    //   612: iconst_2
    //   613: anewarray 4	java/lang/Object
    //   616: dup
    //   617: iconst_0
    //   618: aload_0
    //   619: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   622: getfield 518	com/android/mail/providers/Account:e	Ljava/lang/String;
    //   625: aastore
    //   626: dup
    //   627: iconst_1
    //   628: aload_1
    //   629: invokevirtual 2288	com/android/mail/providers/Folder:b	()Ljava/lang/String;
    //   632: aastore
    //   633: invokestatic 2291	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   636: astore_1
    //   637: getstatic 134	cht:I	Ljava/lang/String;
    //   640: ldc_w 2293
    //   643: iconst_3
    //   644: anewarray 4	java/lang/Object
    //   647: dup
    //   648: iconst_0
    //   649: iload 4
    //   651: invokestatic 614	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   654: aastore
    //   655: dup
    //   656: iconst_1
    //   657: aload 6
    //   659: aastore
    //   660: dup
    //   661: iconst_2
    //   662: aload_1
    //   663: aastore
    //   664: invokestatic 622	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   667: pop
    //   668: invokestatic 514	buo:a	()Lbut;
    //   671: aload_0
    //   672: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   675: getfield 516	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   678: invokeinterface 2295 2 0
    //   683: pop
    //   684: invokestatic 514	buo:a	()Lbut;
    //   687: ldc_w 2297
    //   690: aload 6
    //   692: aload_1
    //   693: lconst_0
    //   694: invokeinterface 1261 6 0
    //   699: return
    //   700: new 2321	cie
    //   703: dup
    //   704: aload_0
    //   705: invokespecial 2322	cie:<init>	(Lcht;)V
    //   708: astore 6
    //   710: getstatic 2325	buj:cH	I
    //   713: istore_3
    //   714: goto -278 -> 436
    //   717: aload_0
    //   718: getstatic 2328	buj:eZ	I
    //   721: invokespecial 2330	cht:e	(I)Lctd;
    //   724: astore 6
    //   726: getstatic 2333	buj:cP	I
    //   729: istore_3
    //   730: goto -294 -> 436
    //   733: aload_0
    //   734: getstatic 2335	buj:W	I
    //   737: invokespecial 2330	cht:e	(I)Lctd;
    //   740: astore 6
    //   742: getstatic 2333	buj:cP	I
    //   745: istore_3
    //   746: goto -310 -> 436
    //   749: aload_0
    //   750: getstatic 2338	buj:do	I
    //   753: invokespecial 2330	cht:e	(I)Lctd;
    //   756: astore 6
    //   758: getstatic 2333	buj:cP	I
    //   761: istore_3
    //   762: goto -326 -> 436
    //   765: aload_0
    //   766: getstatic 2341	buj:cI	I
    //   769: invokespecial 2330	cht:e	(I)Lctd;
    //   772: astore 6
    //   774: getstatic 2333	buj:cP	I
    //   777: istore_3
    //   778: goto -342 -> 436
    //   781: astore 6
    //   783: iload 4
    //   785: invokestatic 2278	chk:a	(I)Ljava/lang/String;
    //   788: astore 7
    //   790: getstatic 2284	java/util/Locale:US	Ljava/util/Locale;
    //   793: ldc_w 2286
    //   796: iconst_2
    //   797: anewarray 4	java/lang/Object
    //   800: dup
    //   801: iconst_0
    //   802: aload_0
    //   803: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   806: getfield 518	com/android/mail/providers/Account:e	Ljava/lang/String;
    //   809: aastore
    //   810: dup
    //   811: iconst_1
    //   812: aload_1
    //   813: invokevirtual 2288	com/android/mail/providers/Folder:b	()Ljava/lang/String;
    //   816: aastore
    //   817: invokestatic 2291	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   820: astore_1
    //   821: getstatic 134	cht:I	Ljava/lang/String;
    //   824: ldc_w 2293
    //   827: iconst_3
    //   828: anewarray 4	java/lang/Object
    //   831: dup
    //   832: iconst_0
    //   833: iload 4
    //   835: invokestatic 614	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   838: aastore
    //   839: dup
    //   840: iconst_1
    //   841: aload 7
    //   843: aastore
    //   844: dup
    //   845: iconst_2
    //   846: aload_1
    //   847: aastore
    //   848: invokestatic 622	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   851: pop
    //   852: invokestatic 514	buo:a	()Lbut;
    //   855: aload_0
    //   856: getfield 333	cht:c	Lcom/android/mail/providers/Account;
    //   859: getfield 516	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   862: invokeinterface 2295 2 0
    //   867: pop
    //   868: invokestatic 514	buo:a	()Lbut;
    //   871: ldc_w 2297
    //   874: aload 7
    //   876: aload_1
    //   877: lconst_0
    //   878: invokeinterface 1261 6 0
    //   883: aload 6
    //   885: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	886	0	this	cht
    //   0	886	1	paramFolder	Folder
    //   0	886	2	paramBoolean	boolean
    //   72	706	3	i1	int
    //   77	757	4	i2	int
    //   273	28	5	i3	int
    //   21	752	6	localObject1	Object
    //   781	103	6	localObject2	Object
    //   27	848	7	localObject3	Object
    //   7	53	8	localFolder	Folder
    // Exception table:
    //   from	to	target	type
    //   269	275	781	finally
    //   288	293	781	finally
    //   421	436	781	finally
    //   436	481	781	finally
    //   582	596	781	finally
    //   700	714	781	finally
    //   717	730	781	finally
    //   733	746	781	finally
    //   749	762	781	finally
    //   765	778	781	finally
  }
  
  public final void b(ConversationCheckedSet paramConversationCheckedSet) {}
  
  final void b(Collection<Conversation> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    cvm.b(I, "performing changeConversationsReadState", new Object[0]);
    if ((z()) && (!paramBoolean1))
    {
      ar = new chv(this, paramCollection, paramBoolean1, paramBoolean2);
      return;
    }
    c(paramCollection, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((!crj.c(o.a)) && (paramBoolean)) {
      F.i();
    }
    for (;;)
    {
      a(paramBoolean);
      au();
      Object localObject = g();
      if ((localObject != null) && (((cje)localObject).c() != null)) {
        ((cje)localObject).c().b(paramBoolean);
      }
      return;
      localObject = F;
      d = true;
      ((cte)localObject).c(true);
    }
  }
  
  public final cmx c(int paramInt)
  {
    return a(paramInt, B.d(), true, null);
  }
  
  public final void c(DataSetObserver paramDataSetObserver)
  {
    ah.registerObserver(paramDataSetObserver);
  }
  
  public void c(Bundle paramBundle)
  {
    Z = ((Uri)paramBundle.getParcelable("saved-detached-conv-uri"));
    Object localObject2;
    bxi localbxi;
    Object localObject1;
    if (paramBundle.containsKey("saved-conversation"))
    {
      localObject2 = (Conversation)paramBundle.getParcelable("saved-conversation");
      if ((!ap) || (Q()) || (!crj.b(o.a))) {
        break label448;
      }
      cvm.c(I, "restoring peek to port orientation", new Object[0]);
      G.a(c, d, (Conversation)localObject2, false);
      localbxi = G.b;
      if (j != null)
      {
        Iterator localIterator = j.keySet().iterator();
        localObject1 = null;
        while (localIterator.hasNext())
        {
          Object localObject3 = (String)localIterator.next();
          if (((String)localObject3).startsWith("f"))
          {
            localObject3 = k.getFragment(j, (String)localObject3);
            if (localObject3 == null) {
              break label628;
            }
            if (localObject1 != null) {
              break label625;
            }
            localObject1 = k.beginTransaction();
            label197:
            ((FragmentTransaction)localObject1).remove((Fragment)localObject3);
          }
        }
      }
    }
    label324:
    label448:
    label625:
    label628:
    for (;;)
    {
      break;
      if (localObject1 != null)
      {
        ((FragmentTransaction)localObject1).commitAllowingStateLoss();
        k.executePendingTransactions();
      }
      j = null;
      G.a(false);
      aq = ((Conversation)localObject2);
      if (crj.c(o.a))
      {
        o.f(3);
        if (paramBundle.containsKey("saved-toast-bar-op"))
        {
          localObject1 = (ToastBarOperation)paramBundle.getParcelable("saved-toast-bar-op");
          if (localObject1 == null) {}
        }
        switch (c)
        {
        default: 
          L = ((Folder)paramBundle.getParcelable("saved-hierarchical-folder"));
          localObject1 = g();
          if (localObject1 != null) {
            ((cje)localObject1).c().b(paramBundle);
          }
          if (paramBundle == null) {
            B.a();
          }
          break;
        }
      }
      for (;;)
      {
        if (am != -1) {
          a(am, an, a(am, l));
        }
        e = ((Folder)paramBundle.getParcelable("m-inbox"));
        aa.clear();
        aa.putAll(paramBundle.getBundle("saved-conversation-list-scroll-positions"));
        return;
        o.f(2);
        break;
        if ((ap) && (Q()))
        {
          a((Conversation)localObject2, true);
          break;
        }
        if ((localObject2 != null) && (C < 0)) {
          C = 0;
        }
        b((Conversation)localObject2);
        break;
        a((ToastBarOperation)localObject1);
        break label324;
        a_((ToastBarOperation)localObject1);
        break label324;
        d(d, true);
        break label324;
        localObject2 = (ConversationCheckedSet)paramBundle.getParcelable("saved-selected-set");
        if ((localObject2 == null) || (((ConversationCheckedSet)localObject2).b()))
        {
          B.a();
        }
        else
        {
          localObject1 = B;
          if (localObject2 != null)
          {
            boolean bool = b.isEmpty();
            b.putAll(b);
            localObject2 = new ArrayList(d);
            ((ConversationCheckedSet)localObject1).b((ArrayList)localObject2);
            if (bool) {
              ((ConversationCheckedSet)localObject1).a((ArrayList)localObject2);
            }
          }
        }
      }
      break label197;
    }
  }
  
  public void c(Conversation paramConversation)
  {
    Object localObject;
    if ((Z != null) && ((paramConversation == null) || (!Z.equals(c))))
    {
      localObject = g();
      if (localObject == null) {
        break label150;
      }
      ((cje)localObject).h();
    }
    for (;;)
    {
      Z = null;
      localObject = D;
      c = paramConversation;
      b = true;
      ((cli)localObject).a();
      l = paramConversation;
      if (l != null)
      {
        paramConversation = f;
        localObject = l;
        if ((localObject != null) && (s != null) && ((i == null) || (!s.equals(i.s)))) {
          paramConversation.a(c.a(s));
        }
        i = ((Conversation)localObject);
        g.invalidateOptionsMenu();
      }
      return;
      label150:
      if (s) {
        cvm.e(I, "AAC.clearDetachedMode(): CLF = null on tablet!", new Object[0]);
      }
    }
  }
  
  final void c(Folder paramFolder)
  {
    if (paramFolder == null) {}
    while ((d != null) && (paramFolder.equals(d))) {
      return;
    }
    Y = true;
  }
  
  final void c(Collection<Conversation> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Conversation localConversation = (Conversation)paramCollection.next();
      ContentValues localContentValues = new ContentValues(4);
      localContentValues.put("read", Boolean.valueOf(paramBoolean1));
      if ((paramBoolean1) || (paramBoolean2)) {
        localContentValues.put("seen", Boolean.TRUE);
      }
      localContentValues.put("suppress_undo", Boolean.valueOf(true));
      if (paramBoolean2) {
        localContentValues.put("viewed", Boolean.valueOf(true));
      }
      ConversationInfo localConversationInfo = t;
      if (localConversationInfo.a(paramBoolean1)) {
        localContentValues.put("conversationInfo", localConversationInfo.a());
      }
      localArrayList.add(u.a(localConversation, 2, localContentValues, null));
      j = paramBoolean1;
      if (paramBoolean2) {
        E = true;
      }
    }
    u.apply(localArrayList);
  }
  
  public void c(boolean paramBoolean)
  {
    au();
  }
  
  public boolean c(Folder paramFolder, boolean paramBoolean)
  {
    return false;
  }
  
  public final void d()
  {
    Object localObject1 = g();
    if (localObject1 != null)
    {
      ab();
      if (a((Fragment)localObject1)) {
        a(true);
      }
    }
    v.notifyChanged();
    ConversationCheckedSet localConversationCheckedSet = B;
    localObject1 = u;
    synchronized (a)
    {
      if (localConversationCheckedSet.b()) {
        return;
      }
      if (localObject1 == null)
      {
        localConversationCheckedSet.a();
        return;
      }
    }
    Object localObject4 = ((bwg)localObject2).f();
    HashSet localHashSet = new HashSet();
    localObject4 = ((Set)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = (String)((Iterator)localObject4).next();
      localObject5 = (Long)c.get(localObject5);
      if (localObject5 != null) {
        localHashSet.add(localObject5);
      }
    }
    localObject4 = new HashSet(localConversationCheckedSet.e());
    ((Set)localObject4).removeAll(localHashSet);
    if (c != null) {}
    for (Set localSet = c.f.keySet();; localSet = null)
    {
      if ((!((Set)localObject4).isEmpty()) && (localSet != null)) {
        ((Set)localObject4).removeAll(localSet);
      }
      localHashSet.addAll((Collection)localObject4);
      localConversationCheckedSet.a(localHashSet);
      return;
    }
  }
  
  public final void d(DataSetObserver paramDataSetObserver)
  {
    ah.unregisterObserver(paramDataSetObserver);
  }
  
  public final void d(Conversation paramConversation)
  {
    if (!hbc.a(paramConversation, l))
    {
      cvm.c(I, "CPA reported a page change. resetting peek to false. new conv=%s", new Object[] { paramConversation });
      ao = false;
    }
    c(paramConversation);
  }
  
  final void d(Folder paramFolder)
  {
    if (paramFolder != null) {
      if ((d.equals("Uninitialized!")) || (h == null) || ("null".equals(h.toString()))) {
        break label72;
      }
    }
    label72:
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      cvm.e(I, new Error(), "AAC.setFolder(%s): Bad input", new Object[] { paramFolder });
      return;
    }
    if (paramFolder.equals(d))
    {
      cvm.b(I, "AAC.setFolder(%s): Input matches mFolder", new Object[] { paramFolder });
      return;
    }
    LoaderManager localLoaderManager;
    if (d == null)
    {
      i1 = 1;
      cvm.b(I, "AbstractActivityController.setFolder(%s)", new Object[] { d });
      localLoaderManager = g.getLoaderManager();
      c(paramFolder);
      d = paramFolder;
      o();
      paramFolder = f;
      e = d;
      paramFolder.c();
      if (localLoaderManager.getLoader(30) != null) {
        break label280;
      }
      localLoaderManager.initLoader(30, Bundle.EMPTY, ai);
    }
    for (;;)
    {
      if ((i1 == 0) && (localLoaderManager.getLoader(10) != null)) {
        localLoaderManager.destroyLoader(10);
      }
      paramFolder = new Bundle(2);
      paramFolder.putParcelable("account", c);
      paramFolder.putParcelable("folder", d);
      paramFolder.putBoolean("ignore-initial-conversation-limit", ag);
      ag = false;
      localLoaderManager.initLoader(10, paramFolder, H);
      return;
      i1 = 0;
      break;
      label280:
      localLoaderManager.restartLoader(30, Bundle.EMPTY, ai);
    }
  }
  
  protected abstract void d(boolean paramBoolean);
  
  public final bwg e()
  {
    return u;
  }
  
  public final void e(DataSetObserver paramDataSetObserver)
  {
    A.registerObserver(paramDataSetObserver);
  }
  
  public final void e(boolean paramBoolean)
  {
    cje localcje = g();
    if (localcje != null) {
      localcje.a(paramBoolean);
    }
  }
  
  public void f()
  {
    a(null, -1);
  }
  
  public final void f(DataSetObserver paramDataSetObserver)
  {
    A.unregisterObserver(paramDataSetObserver);
  }
  
  public void f(boolean paramBoolean)
  {
    cje localcje = g();
    if ((paramBoolean) && (localcje != null) && (localcje.isVisible())) {
      a(true);
    }
  }
  
  public final cje g()
  {
    Fragment localFragment = i.findFragmentByTag("tag-conversation-list");
    if (b(localFragment)) {
      return (cje)localFragment;
    }
    return null;
  }
  
  public final void g(DataSetObserver paramDataSetObserver)
  {
    y.registerObserver(paramDataSetObserver);
  }
  
  public final void g(boolean paramBoolean)
  {
    G.a.i = paramBoolean;
  }
  
  public final cnk h()
  {
    Object localObject = g.getString(buj.br);
    localObject = i.findFragmentByTag((String)localObject);
    if (b((Fragment)localObject)) {
      return (cnk)localObject;
    }
    return null;
  }
  
  public final void h(DataSetObserver paramDataSetObserver)
  {
    y.unregisterObserver(paramDataSetObserver);
  }
  
  public final void i(DataSetObserver paramDataSetObserver)
  {
    v.registerObserver(paramDataSetObserver);
  }
  
  protected boolean i()
  {
    return (crj.d(o.a)) || (crj.a(o.a));
  }
  
  final void j()
  {
    int i2 = 0;
    if (c.e()) {
      K();
    }
    int i1;
    label122:
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = M();
        i1 = i2;
        if (localObject != null)
        {
          localObject = a;
          i1 = i2;
          if (localObject != null)
          {
            i1 = i2;
            if (g.equals(c.g))
            {
              i1 = i2;
              if (o.a == 5) {
                i1 = 1;
              }
            }
          }
        }
        if (!c.d()) {
          break label122;
        }
        if (i1 == 0) {
          break;
        }
        localObject = (crl)g.getFragmentManager().findFragmentByTag("wait-fragment");
      } while (localObject == null);
      ((crl)localObject).a(c);
      return;
      K();
      return;
    } while (i1 == 0);
    L();
  }
  
  public final void j(DataSetObserver paramDataSetObserver)
  {
    try
    {
      v.unregisterObserver(paramDataSetObserver);
      return;
    }
    catch (IllegalStateException paramDataSetObserver)
    {
      cvm.e(I, paramDataSetObserver, "unregisterConversationListObserver called for an observer that hasn't been registered", new Object[0]);
    }
  }
  
  public final void k(DataSetObserver paramDataSetObserver)
  {
    z.registerObserver(paramDataSetObserver);
  }
  
  public final Account[] k()
  {
    return ae;
  }
  
  public void l() {}
  
  public final void l(DataSetObserver paramDataSetObserver)
  {
    try
    {
      z.unregisterObserver(paramDataSetObserver);
      return;
    }
    catch (IllegalStateException paramDataSetObserver)
    {
      cvm.e(I, paramDataSetObserver, "unregisterFolderObserver called for an observer that hasn't been registered", new Object[0]);
    }
  }
  
  public final cpp m()
  {
    return j;
  }
  
  public final void m(DataSetObserver paramDataSetObserver)
  {
    G.d.registerObserver(paramDataSetObserver);
  }
  
  protected final void n()
  {
    Object localObject;
    if (af != null)
    {
      localObject = af.a(c);
      if (localObject != null)
      {
        a((Folder)localObject, false);
        int i1 = o.a;
        if ((i1 == 0) || (i1 == 5)) {
          o.f(2);
        }
      }
    }
    do
    {
      return;
      d = null;
      cvm.b(I, "Starting a LOADER_ACCOUNT_INBOX for %s", new Object[] { c });
      a(32, ai, Bundle.EMPTY);
      localObject = g.getLoaderManager();
    } while (((LoaderManager)localObject).getLoader(10) == null);
    ((LoaderManager)localObject).destroyLoader(10);
  }
  
  public final void n(DataSetObserver paramDataSetObserver)
  {
    try
    {
      G.d.unregisterObserver(paramDataSetObserver);
      return;
    }
    catch (IllegalStateException paramDataSetObserver)
    {
      cvm.e(I, paramDataSetObserver, "unregisterConversationLoadedObserver called for an observer that hasn't been registered", new Object[0]);
    }
  }
  
  protected final void o()
  {
    cvm.a(I, "VisualElement content tag update: mViewMode=%s", new Object[] { Integer.valueOf(o.a) });
    View localView = g.getWindow().getDecorView();
    localView.setTag(gnq.a, null);
    if (crj.a(o.a))
    {
      localgnt = g.b(d);
      if (localgnt != null)
      {
        gnu.a(localView, new gnr(localgnt));
        cvm.a(I, "VisualElement: Attached FolderPage=(%s)", new Object[] { localgnt });
      }
    }
    while ((!crj.b(o.a)) || (l == null))
    {
      gnt localgnt;
      return;
    }
    long l1 = l.b;
    gnu.a(localView, new cet(hlg.p, l1, -1));
    cvm.a(I, "VisualElement: Attached ConversationPage=(%s)", new Object[] { Long.valueOf(l1) });
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == buc.aj)
    {
      g.a(paramView, 4);
      cbk.a(g, c);
    }
    while (i1 != 16908332) {
      return;
    }
    y();
  }
  
  public final Folder p()
  {
    return d;
  }
  
  public final Folder q()
  {
    return L;
  }
  
  public final void r()
  {
    Object localObject = as;
    ae.registerObserver(localObject);
    but localbut;
    if (o.a != 0)
    {
      localbut = buo.a();
      localObject = String.valueOf(o.toString());
      if (((String)localObject).length() == 0) {
        break label63;
      }
    }
    label63:
    for (localObject = "MainActivity".concat((String)localObject);; localObject = new String("MainActivity"))
    {
      localbut.a((String)localObject);
      return;
    }
  }
  
  public final void s()
  {
    DialogFragment localDialogFragment = (DialogFragment)i.findFragmentByTag("SyncErrorDialogFragment");
    if (localDialogFragment != null) {
      localDialogFragment.dismiss();
    }
    if (F != null) {
      F.a(false, false);
    }
  }
  
  public final void t()
  {
    if (d != null)
    {
      int i1 = d.l;
      int i2 = d.p;
      cnd localcnd = new cnd();
      Bundle localBundle = new Bundle(2);
      localBundle.putInt("numConversations", i1);
      localBundle.putInt("folderType", i2);
      localcnd.setArguments(localBundle);
      localcnd.a(this);
      localcnd.show(g.getFragmentManager(), "EmptyFolderDialogFragment");
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("{");
    localStringBuilder.append("mCurrentConversation=");
    localStringBuilder.append(l);
    localStringBuilder.append("mPeeking=");
    localStringBuilder.append(ao);
    localStringBuilder.append("mSavedPeekConv=");
    localStringBuilder.append(aq);
    a(localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void u()
  {
    if (u != null)
    {
      bww.b(u.c);
      b(null);
    }
  }
  
  protected abstract boolean v();
  
  public boolean w()
  {
    crr localcrr = m;
    boolean bool = b.d(h);
    int i1;
    if ((bool) && (e.isShown()))
    {
      localcrr.a(2, true);
      i1 = 1;
    }
    while (i1 != 0)
    {
      return true;
      if ((!bool) && (d.isShown()))
      {
        localcrr.a(0, true);
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
    }
    if ((E != null) && (E.c)) {
      return false;
    }
    return x();
  }
  
  protected abstract boolean x();
  
  protected final boolean y()
  {
    int i1 = o.a;
    if (i1 == 3) {
      g.finish();
    }
    for (;;)
    {
      return true;
      if (i())
      {
        if (Folder.a(d)) {
          a(null);
        } else {
          aj();
        }
      }
      else if ((crj.b(i1)) || (crj.e(i1))) {
        x();
      }
    }
  }
  
  protected abstract boolean z();
  
  public final void z_()
  {
    if (S())
    {
      localObject = g();
      localbwg = u;
      if (localObject != null)
      {
        localObject = ((cje)localObject).c();
        cvm.d("ConversationCursor", "onRefreshRequired: delay until animating done. cursor=%s adapter=%s", new Object[] { localbwg, localObject });
      }
    }
    while (!u.i) {
      for (;;)
      {
        bwg localbwg;
        return;
        Object localObject = null;
      }
    }
    u.l();
  }
}

/* Location:
 * Qualified Name:     cht
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */