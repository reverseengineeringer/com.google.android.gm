import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.browse.ConversationListFooterView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.ConversationCheckedSet;
import com.android.mail.ui.ConversationListEmptyView;
import com.android.mail.ui.ConversationViewFragment;
import com.android.mail.ui.MailSwipeRefreshLayout;
import com.android.mail.ui.SwipeableListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ckz
  extends cje
  implements View.OnClickListener, View.OnKeyListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, cqm, cqo, crk, yp
{
  private static long N = -1L;
  static int a;
  static int b;
  private static final String n = cvl.a;
  private static int p;
  private View A;
  private cng B;
  private cgm C;
  private DataSetObserver D;
  private ConversationCheckedSet E;
  private final cfx F = new cla(this);
  private cll G;
  private int H;
  private int I;
  private boolean J;
  private int K;
  private boolean L;
  private int M;
  private final Runnable O = new clb(this, "LoadingRunnable", this);
  private boolean P = false;
  private final clk Q = new clg(this);
  final Handler c = new Handler();
  SwipeableListView d;
  Account e;
  Runnable f = null;
  ConversationListEmptyView g;
  View h;
  View i;
  final Runnable j = new clc(this, "CancelLoading", this);
  boolean k;
  boolean l;
  MailSwipeRefreshLayout m;
  private boolean o;
  private ckv q;
  private cky r;
  private View s;
  private TextView t;
  private int u = -1;
  private Folder v;
  private btp w;
  private cjy x;
  private ConversationListFooterView y;
  private TextView z;
  
  static
  {
    b = 0;
  }
  
  public static ckz a(btp parambtp)
  {
    ckz localckz = new ckz();
    Bundle localBundle1 = new Bundle(1);
    Bundle localBundle2 = new Bundle();
    localBundle2.putParcelable("mail_account", a);
    localBundle2.putString("query", c);
    localBundle2.putParcelable("folder", b);
    localBundle1.putBundle("conversation-list", localBundle2);
    localckz.setArguments(localBundle1);
    return localckz;
  }
  
  private final void a(Conversation paramConversation, int paramInt)
  {
    if (!d.c(paramConversation))
    {
      int i1 = d.getFirstVisiblePosition();
      View localView = d.getChildAt(paramInt - i1);
      if (localView == null) {
        break label66;
      }
      d.setSelectionFromTop(paramInt, localView.getTop());
    }
    label66:
    for (d.k = -1;; d.k = paramInt)
    {
      d.b(paramConversation);
      return;
    }
  }
  
  private final void c(int paramInt)
  {
    d.setChoiceMode(paramInt);
  }
  
  private final void d(int paramInt)
  {
    cvm.b(n, "ConversationListFragment.viewConversation(%d)", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = x.getItem(paramInt);
    if ((localObject != null) && ((localObject instanceof bwg)))
    {
      localObject = (bwg)localObject;
      Conversation localConversation = ((bwg)localObject).m();
      buo.a().a("view_conversation", "position", String.valueOf(paramInt), 0L);
      long l1 = (System.currentTimeMillis() - e) / 86400000L;
      buo.a().a("view_conversation", "age", String.valueOf(l1), 0L);
      if (!buo.b())
      {
        String str = String.valueOf(ConversationViewFragment.class.getSimpleName());
        l1 = mb;
        new StringBuilder(String.valueOf(str).length() + 20).append(str).append(l1);
      }
      C = ((bwg)localObject).getPosition();
      c(localConversation);
      r.b(localConversation, false);
      return;
    }
    cvm.e(n, "unable to open conv at cursor pos=%s item=%s getPositionOffset=%s", new Object[] { Integer.valueOf(paramInt), localObject, Integer.valueOf(x.a(paramInt)) });
  }
  
  private final void r()
  {
    b(false);
    d.setVisibility(0);
    g.setVisibility(4);
    i.setVisibility(4);
    h.setVisibility(4);
  }
  
  private final void s()
  {
    if (v != null)
    {
      if ((v.n & 0x7) != 0) {}
      for (int i1 = 1; i1 != 0; i1 = 0)
      {
        cvm.b(n, "CLF.checkSyncStatus still syncing", new Object[0]);
        return;
      }
    }
    cvm.b(n, "CLF.checkSyncStatus done syncing", new Object[0]);
    m.a(false);
  }
  
  private final void t()
  {
    if ((v == null) || (v.h == null) || (x.getCursor() == null)) {
      return;
    }
    Parcelable localParcelable = d.onSaveInstanceState();
    q.w_().a(v.h.toString(), localParcelable);
  }
  
  private final void u()
  {
    if ((!P) && (v != null))
    {
      Object localObject = v.h.toString();
      localObject = q.w_().b((String)localObject);
      if (localObject != null) {
        d.onRestoreInstanceState((Parcelable)localObject);
      }
      P = true;
    }
  }
  
  private final void v()
  {
    if ((d != null) && (K != 0))
    {
      d.setNextFocusLeftId(K);
      d.setNextFocusRightId(K);
    }
  }
  
  public final void a()
  {
    buo.a().a("menu_item", "swipe_refresh", null, 0L);
    q.m().A();
    x.n();
    q.a(x);
  }
  
  public final void a(int paramInt)
  {
    K = paramInt;
    v();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((o) && (crj.a(paramInt2))) {
      j();
    }
  }
  
  final void a(Folder paramFolder)
  {
    int i2 = 1;
    if ((!bwg.a(n())) && (!k))
    {
      c.postDelayed(O, p);
      k = true;
    }
    v = paramFolder;
    q();
    paramFolder = m;
    boolean bool;
    if (!btp.a(w))
    {
      bool = true;
      paramFolder.setEnabled(bool);
      if (v != null) {
        break label87;
      }
    }
    label87:
    label196:
    label234:
    label241:
    label247:
    for (;;)
    {
      return;
      bool = false;
      break;
      x.m = v;
      paramFolder = y;
      Object localObject = v;
      b.setTag(localObject);
      c = t;
      int i3 = v.o & 0xF;
      int i1 = i2;
      Folder localFolder;
      if (i3 != 0)
      {
        if (i3 == 16) {
          i1 = i2;
        }
      }
      else
      {
        if (i1 == 0) {
          B.d(v, false);
        }
        s();
        localFolder = v;
        if (bxd.b == null) {
          break label234;
        }
        paramFolder = bc;
        if (localFolder == null) {
          break label241;
        }
      }
      for (localObject = c;; localObject = cus.a)
      {
        if (paramFolder.equals(localObject)) {
          break label247;
        }
        bxd.b = localFolder;
        bxd.a.evictAll();
        return;
        i1 = 0;
        break;
        paramFolder = cus.a;
        break label196;
      }
    }
  }
  
  public final void a(Collection<Conversation> paramCollection)
  {
    G.a(paramCollection);
  }
  
  public final void a(Collection<Conversation> paramCollection, cmx paramcmx, boolean paramBoolean)
  {
    Object localObject1 = paramCollection.iterator();
    while (((Iterator)localObject1).hasNext()) {
      nextD = true;
    }
    localObject1 = new clf(this, paramcmx);
    Object localObject2 = d;
    int i1 = paramcmx.b();
    if (paramCollection == null) {
      cvm.e(SwipeableListView.c, "SwipeableListView.destroyItems: null conversations.", new Object[0]);
    }
    cjy localcjy;
    for (i1 = 0;; i1 = 0)
    {
      if (i1 == 0)
      {
        cvm.e(n, "ConversationListFragment.requestDelete: listView failed to destroy items.", new Object[0]);
        paramcmx.a();
      }
      return;
      localcjy = (cjy)((SwipeableListView)localObject2).getAdapter();
      if (localcjy != null) {
        break;
      }
      cvm.e(SwipeableListView.c, "SwipeableListView.destroyItems: Cannot destroy: adapter is null.", new Object[0]);
    }
    l = i1;
    b.clear();
    c.clear();
    i1 = n.getFirstVisiblePosition();
    int i2 = n.getLastVisiblePosition();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localObject2 = (Conversation)paramCollection.next();
      if ((C >= i1) && (C <= i2))
      {
        b.add(Long.valueOf(b));
        d.add(Long.valueOf(b));
      }
      else if (paramBoolean)
      {
        b.add(Long.valueOf(b));
        a.add(Long.valueOf(b));
      }
    }
    if ((d.isEmpty()) && (a.isEmpty()))
    {
      ((cqn)localObject1).a();
      localcjy.a(null);
    }
    for (;;)
    {
      localcjy.notifyDataSetChanged();
      i1 = 1;
      break;
      localcjy.a((cqn)localObject1);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (d != null) {
      d.b(paramBoolean);
    }
  }
  
  public final int[] a(Conversation paramConversation)
  {
    int[] arrayOfInt = new int[2];
    long l1 = b;
    paramConversation = (bwg)x.getCursor();
    if (paramConversation == null) {
      return arrayOfInt;
    }
    int i1 = paramConversation.a(l1);
    if (i1 < d.getFirstVisiblePosition())
    {
      arrayOfInt[0] = -1;
      arrayOfInt[1] = 0;
    }
    for (;;)
    {
      return arrayOfInt;
      if (i1 > d.getLastVisiblePosition())
      {
        arrayOfInt[0] = -2;
        arrayOfInt[1] = 0;
      }
      else
      {
        int i2 = d.getChildCount();
        i1 = 0;
        while (i1 < i2)
        {
          paramConversation = d.getChildAt(i1);
          if (((paramConversation instanceof cab)) && (b.c.s.b == l1))
          {
            arrayOfInt[0] = paramConversation.getTop();
            arrayOfInt[1] = paramConversation.getBottom();
            return arrayOfInt;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public final void b(int paramInt)
  {
    if (d.getChoiceMode() == 0) {
      return;
    }
    d.smoothScrollToPosition(paramInt);
    d.setItemChecked(paramInt, true);
  }
  
  public final void b(Conversation paramConversation)
  {
    if ((d.getChoiceMode() == 0) || (paramConversation == null)) {
      return;
    }
    int i1 = C;
    a(paramConversation, i1 + x.a(i1));
  }
  
  public final boolean b()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    cjy localcjy = x;
    if ((localcjy != null) && (localcjy.m())) {
      return bool2;
    }
    if ((d != null) && (d.h)) {}
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      cvm.c(n, "CLF.isAnimating=true due to scrolling", new Object[0]);
      return bool1;
      bool1 = false;
    }
  }
  
  final boolean b(boolean paramBoolean)
  {
    return (r != null) && (r.c(v, paramBoolean));
  }
  
  public final cqp c()
  {
    return x;
  }
  
  public final void c(Conversation paramConversation)
  {
    if ((d.getChoiceMode() == 0) || (paramConversation == null)) {}
    int i1;
    do
    {
      return;
      i1 = x.a(paramConversation);
    } while (i1 == -1);
    b(i1);
    a(paramConversation, i1);
  }
  
  public final void e()
  {
    x.notifyDataSetChanged();
  }
  
  public final void f()
  {
    d.setAdapter(null);
  }
  
  protected final void g()
  {
    m.a(true);
  }
  
  public final void h()
  {
    if (!o) {
      return;
    }
    if (o) {}
    for (int i1 = 1;; i1 = 0)
    {
      c(i1);
      return;
    }
  }
  
  public final void i()
  {
    if (!o) {
      return;
    }
    j();
    c(0);
  }
  
  protected final void j()
  {
    int i1 = d.getCheckedItemPosition();
    if (i1 != -1) {
      d.setItemChecked(i1, false);
    }
  }
  
  public final Folder k()
  {
    return v;
  }
  
  public final void l()
  {
    m.setEnabled(false);
  }
  
  public final void m()
  {
    m.setEnabled(true);
  }
  
  final bwg n()
  {
    if (r != null) {
      return r.e();
    }
    return null;
  }
  
  final void o()
  {
    but localbut1 = null;
    Object localObject = null;
    if ((r == null) || (x == null))
    {
      if ((bwg.a(n())) && (l)) {
        p();
      }
      return;
    }
    bwg localbwg = r.e();
    if ((localbwg == null) && (x.getCursor() != null)) {
      t();
    }
    x.swapCursor(localbwg);
    int i1;
    if (localbwg == null)
    {
      i1 = 0;
      label88:
      if ((H == i1) && (H != 0)) {
        x.notifyDataSetChanged();
      }
      H = i1;
      if (localbwg == null) {
        break label423;
      }
      if (!J) {
        break label367;
      }
      if (bwg.a(n()))
      {
        if (localbwg.getCount() == 0)
        {
          localbut1 = buo.a();
          if (v != null) {
            localObject = v.b();
          }
          localbut1.a("empty_state", "post_label_change", (String)localObject, 0L);
        }
        if (!ba.containsKey("cold_start_to_list")) {
          break label346;
        }
        buq.b.a("cold_start_to_list", true, "cold_start_to_list", "from_launcher");
        label213:
        glh.a.a("Application ready", "Application read threadlist");
        J = false;
      }
      label230:
      I = localbwg.getCount();
      label239:
      if (localbwg != null)
      {
        i1 = localbwg.getCount();
        if ((q != null) && (s != null)) {
          break label431;
        }
      }
    }
    for (;;)
    {
      if (i1 > 0)
      {
        bww.a(c);
        u();
      }
      localObject = r.P();
      boolean bool = r.R();
      if ((localObject == null) || (bool) || (d.getChoiceMode() == 0) || (d.getCheckedItemPosition() != -1)) {
        break;
      }
      c((Conversation)localObject);
      break;
      i1 = localbwg.hashCode();
      break label88;
      label346:
      buq.b.a("open_threadlist", true, "open_folder", l);
      break label213;
      label367:
      if ((localbwg.getCount() != 0) || (I <= 0)) {
        break label230;
      }
      but localbut2 = buo.a();
      localObject = localbut1;
      if (v != null) {
        localObject = v.b();
      }
      localbut2.a("empty_state", "post_delete", (String)localObject, 0L);
      break label230;
      label423:
      I = 0;
      break label239;
      label431:
      if (u != i1)
      {
        u = i1;
        localObject = getResources();
        t.setText(((Resources)localObject).getString(buj.ev, new Object[] { Integer.valueOf(i1) }));
        cxe.a(t, ((Resources)localObject).getString(buj.eu, new Object[] { Integer.valueOf(i1) }));
      }
    }
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    k = false;
    l = true;
    if (N < 0L) {
      N = getResources().getInteger(bud.a);
    }
    cjo localcjo = q.n();
    e = F.a(localcjo);
    r = q.w_();
    B = q.l();
    Object localObject2 = LayoutInflater.from(q.g());
    y = ((ConversationListFooterView)((LayoutInflater)localObject2).inflate(bue.o, null));
    y.d = q;
    bwg localbwg = n();
    LoaderManager localLoaderManager = getLoaderManager();
    Object localObject1 = q.s();
    if (localObject1 != null) {}
    for (localObject1 = hef.a(((csl)localObject1).a(q, e)); localObject1 != null; localObject1 = null)
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext()) {
        ((cso)localIterator.next()).a(localLoaderManager, paramBundle);
      }
    }
    x = new cjy(q.g(), localbwg, q.h(), q, d, (List)localObject1);
    x.k = y;
    if (btp.a(w))
    {
      s = ((LayoutInflater)localObject2).inflate(bue.ae, null);
      t = ((TextView)s.findViewById(buc.ew));
      localObject1 = x;
      localObject2 = s;
      l.add(localObject2);
    }
    d.setAdapter(x);
    d.j = localcjo;
    E = q.h();
    d.d = E;
    x.a(false);
    C = new cld(this);
    C.a(q.m());
    D = new clh(this);
    G = q.k();
    G.i(D);
    o = cxa.a(q.g().getResources());
    M = getResources().getColor(btz.f);
    getView().setBackgroundColor(M);
    d.setOnScrollListener(this);
    a(0, q.v_().a);
    q.v_().a(this);
    if (q.w_().af()) {}
    for (d.b = true; q.isFinishing(); d.b = false) {
      return;
    }
    int i1;
    if (localbwg == null)
    {
      i1 = 0;
      label599:
      H = i1;
      if ((localbwg != null) && (h)) {
        localbwg.k();
      }
      if (!o) {
        break label798;
      }
      i1 = 1;
      label631:
      int i2 = i1;
      if (paramBundle != null)
      {
        i1 = paramBundle.getInt("choice-mode-key", i1);
        i2 = i1;
        if (paramBundle.containsKey("list-state"))
        {
          d.clearChoices();
          i2 = i1;
        }
      }
      c(i2);
      J = true;
      a(q.m().p());
      o();
      paramBundle = w.b;
      if (paramBundle != null) {
        if (l <= 0) {
          break label803;
        }
      }
    }
    label798:
    label803:
    for (long l1 = Math.log10(l);; l1 = 0L)
    {
      buo.a().a("view_folder", paramBundle.b(), Long.toString(l1), l);
      paramBundle = q.B();
      if (paramBundle == null) {
        break;
      }
      q.b(null);
      q.a_(paramBundle);
      return;
      i1 = localbwg.hashCode();
      break label599;
      i1 = 0;
      break label631;
    }
  }
  
  public final void onClick(View paramView)
  {
    if (paramView == A) {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(e.K)));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getResources();
    b = paramBundle.getInteger(bud.H);
    p = paramBundle.getInteger(bud.i);
    a = paramBundle.getInteger(bud.h);
    f = new cle(this);
    w = btp.a(getArguments().getBundle("conversation-list"));
    e = w.a;
    setRetainInstance(false);
    paramBundle = getActivity();
    if (!(paramBundle instanceof ckv)) {
      cvm.e(n, "ConversationListFragment expects only a ControllableActivity tocreate it. Cannot proceed.", new Object[0]);
    }
    q = ((ckv)paramBundle);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(bue.m, null);
    g = ((ConversationListEmptyView)paramLayoutInflater.findViewById(buc.bu));
    h = paramLayoutInflater.findViewById(buc.ez);
    z = ((TextView)paramLayoutInflater.findViewById(buc.ey));
    A = paramLayoutInflater.findViewById(buc.ex);
    A.setOnClickListener(this);
    i = paramLayoutInflater.findViewById(buc.ax);
    d = ((SwipeableListView)paramLayoutInflater.findViewById(buc.aB));
    d.setHeaderDividersEnabled(false);
    d.setOnItemLongClickListener(this);
    d.a = true;
    d.g = this;
    d.i = this;
    d.setOnKeyListener(this);
    d.setOnItemClickListener(this);
    if ((o) && (K == 0)) {
      K = buc.cO;
    }
    v();
    if (cxd.a()) {
      ((ViewGroup)paramLayoutInflater.findViewById(buc.az)).setLayoutTransition(new LayoutTransition());
    }
    r();
    if ((paramBundle != null) && (paramBundle.containsKey("list-state"))) {
      d.onRestoreInstanceState(paramBundle.getParcelable("list-state"));
    }
    m = ((MailSwipeRefreshLayout)paramLayoutInflater.findViewById(buc.fj));
    m.a(new int[] { btz.S, btz.T, btz.U, btz.V });
    m.a = this;
    m.m = d;
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
  }
  
  public final void onDestroyView()
  {
    cjy localcjy = x;
    localcjy.swapCursor(null);
    p.a();
    d.setAdapter(null);
    q.v_().b(this);
    if (C != null)
    {
      C.a();
      C = null;
    }
    if (D != null)
    {
      G.j(D);
      D = null;
    }
    F.a();
    x.s();
    super.onDestroyView();
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i3 = 1;
    if ((paramView instanceof caf))
    {
      if (e.z.d != 1) {
        break label80;
      }
      i1 = 1;
      if (E.b()) {
        break label86;
      }
    }
    label80:
    label86:
    for (int i2 = 1;; i2 = 0)
    {
      if ((i1 != 0) || (i2 == 0)) {
        break label92;
      }
      ((caf)paramView).e();
      a(cxa.a(q.g().getResources()));
      return;
      i1 = 0;
      break;
    }
    label92:
    if (i2 != 0) {
      buo.a().a("peek", null, null, E.c());
    }
    if (gnu.a(paramView) != null) {}
    for (int i1 = i3;; i1 = 0)
    {
      if (i1 != 0) {
        q.a(paramView, 4);
      }
      buq.b.a("open_conv_from_list");
      d(paramInt);
      break;
    }
  }
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!(paramView instanceof ConversationItemView)) {
      return false;
    }
    return ((ConversationItemView)paramView).a("long_press");
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramView instanceof SwipeableListView))
    {
      paramView = (SwipeableListView)paramView;
      if (cvj.a(paramInt, cxe.a(paramView)))
      {
        if (paramKeyEvent.getAction() == 1)
        {
          if (L)
          {
            i1 = paramView.getSelectedItemPosition();
            paramInt = i1;
            if (i1 < 0) {
              paramInt = paramView.getCheckedItemPosition();
            }
            if (paramInt >= 0)
            {
              d(paramInt);
              a(cxa.a(q.g().getResources()));
            }
          }
          L = false;
        }
        while (paramKeyEvent.getAction() != 0)
        {
          int i1;
          return true;
        }
        L = true;
        return true;
      }
      if (((paramInt == 19) || (paramInt == 20)) && (paramKeyEvent.getAction() == 1))
      {
        paramInt = paramView.getSelectedItemPosition();
        if (paramInt >= 0)
        {
          paramView = x.getItem(paramInt);
          if ((paramView != null) && ((paramView instanceof bwg)))
          {
            paramView = ((bwg)paramView).m();
            r.e(paramView);
          }
        }
      }
    }
    return false;
  }
  
  public final void onPause()
  {
    super.onPause();
    E.b(Q);
    t();
  }
  
  public final void onResume()
  {
    super.onResume();
    if (!bwg.a(n()))
    {
      J = true;
      r();
    }
    bwg localbwg = n();
    if (localbwg != null)
    {
      localbwg.p();
      u();
    }
    E.a(Q);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (d != null)
    {
      paramBundle.putParcelable("list-state", d.onSaveInstanceState());
      paramBundle.putInt("choice-mode-key", d.getChoiceMode());
    }
    if (x != null)
    {
      Iterator localIterator = x.q.iterator();
      while (localIterator.hasNext()) {
        ((cso)localIterator.next()).a(paramBundle);
      }
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    d.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    d.onScrollStateChanged(paramAbsListView, paramInt);
    paramAbsListView = getView();
    if (paramAbsListView != null)
    {
      if (paramInt == 0) {
        paramAbsListView.setBackgroundColor(M);
      }
    }
    else {
      return;
    }
    paramAbsListView.setBackgroundResource(0);
  }
  
  public final void onStart()
  {
    super.onStart();
    c.postDelayed(f, b);
    buo.a().a("ConversationListFragment");
  }
  
  public final void onStop()
  {
    super.onStop();
    c.removeCallbacks(f);
  }
  
  final void p()
  {
    Object localObject1 = n();
    Object localObject2 = y;
    boolean bool;
    if (localObject1 == null)
    {
      a.setVisibility(8);
      b.setVisibility(8);
      bool = false;
    }
    Object localObject3;
    int i1;
    int i2;
    for (;;)
    {
      s();
      x.a(bool);
      k = false;
      c.removeCallbacks(O);
      if (e.J == 0) {
        break;
      }
      b(false);
      d.setVisibility(4);
      g.setVisibility(4);
      i.setVisibility(4);
      z.setText(getString(buj.ez, new Object[] { e.a }));
      h.setVisibility(0);
      glh.a.a("Application ready", "Application ready security");
      return;
      localObject3 = ((bwg)localObject1).getExtras();
      i1 = ((Bundle)localObject3).getInt("cursor_status");
      i2 = ((Bundle)localObject3).getInt("cursor_total_count");
      if (chj.a(i1))
      {
        if (((bwg)localObject1).getCount() != 0)
        {
          a.setVisibility(0);
          b.setVisibility(8);
          bool = true;
        }
        else
        {
          bool = false;
        }
      }
      else if ((c != null) && (((bwg)localObject1).getCount() < i2))
      {
        a.setVisibility(8);
        b.setVisibility(0);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
    if (x.getCount() == 0) {
      if (!b(true))
      {
        i1 = 1;
        localObject2 = (bwg)x.getCursor();
        localObject1 = null;
        if (localObject2 == null) {
          break label741;
        }
        localObject1 = ((bwg)localObject2).getExtras();
        i2 = ((Bundle)localObject1).getInt("cursor_status");
        localObject1 = ((Bundle)localObject1).getString("cursor_query_suggestion");
      }
    }
    for (;;)
    {
      if (i2 == 4)
      {
        localObject1 = g;
        if (i1 != 0)
        {
          a.setImageResource(bub.au);
          a.setVisibility(0);
          label372:
          b.setText(buj.fb);
        }
      }
      for (;;)
      {
        g.setVisibility(0);
        d.setVisibility(4);
        i.setVisibility(4);
        h.setVisibility(4);
        return;
        i1 = 0;
        break;
        a.setVisibility(8);
        break label372;
        Object localObject5 = g;
        Object localObject4 = v;
        String str = w.c;
        localObject3 = x.r;
        if (i1 != 0)
        {
          cuj.a(a, (Folder)localObject4);
          a.setVisibility(0);
        }
        TextView localTextView;
        for (;;)
        {
          localTextView = b;
          localObject2 = c;
          localObject5 = ((ConversationListEmptyView)localObject5).getResources();
          if (localObject4 != null) {
            break label537;
          }
          localTextView.setText(buj.bz);
          break;
          a.setVisibility(8);
        }
        label537:
        if (((Folder)localObject4).d(8194))
        {
          localTextView.setText(buj.bA);
        }
        else
        {
          if (((Folder)localObject4).d(4096))
          {
            localTextView.setText(((Resources)localObject5).getString(buj.bB, new Object[] { ((mx)localObject3).a(str) }).toString());
            if (TextUtils.isEmpty((CharSequence)localObject1)) {}
            for (i1 = 8;; i1 = 0)
            {
              ((TextView)localObject2).setVisibility(i1);
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break;
              }
              localObject4 = new cuk((String)localObject1);
              i1 = buj.bi;
              localObject1 = ((mx)localObject3).a((String)localObject1);
              cxe.a((TextView)localObject2, (View.OnClickListener)localObject4, ((TextView)localObject2).getContext().getString(i1), new CharSequence[] { localObject1 });
              break;
            }
          }
          if (((Folder)localObject4).d(64)) {
            localTextView.setText(buj.bF);
          } else if (((Folder)localObject4).d(32)) {
            localTextView.setText(buj.bJ);
          } else {
            localTextView.setText(buj.bz);
          }
        }
      }
      r();
      return;
      label741:
      i2 = 0;
    }
  }
  
  final void q()
  {
    int i2 = 0;
    if ((v != null) && (v.d(8192))) {}
    for (int i1 = cfm.a(getActivity()).b(true); (i1 == 2) || ((v != null) && ((v.d(32)) || (v.d(4)))); i1 = Settings.b(e.z))
    {
      d.a = false;
      d.f = v;
      return;
    }
    d.a = true;
    if (v == null) {
      i1 = buc.dP;
    }
    for (;;)
    {
      d.e = i1;
      break;
      switch (i1)
      {
      }
      do
      {
        do
        {
          d.a = false;
          i1 = i2;
          break;
          if (v.d(8))
          {
            i1 = buc.bb;
            break;
          }
          i1 = buc.aV;
          break;
        } while ((!v.d(8192)) && ((!e.a(4L)) || (v.d(64))));
        if (v.a(2))
        {
          i1 = buc.x;
          break;
        }
      } while (!v.a(1));
      i1 = buc.dP;
    }
  }
  
  public final String toString()
  {
    Object localObject = super.toString();
    if (w == null) {
      return (String)localObject;
    }
    localObject = new StringBuilder((String)localObject);
    ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 1);
    ((StringBuilder)localObject).append(" mListAdapter=");
    ((StringBuilder)localObject).append(x);
    ((StringBuilder)localObject).append(" folder=");
    ((StringBuilder)localObject).append(w.b);
    if (d != null)
    {
      ((StringBuilder)localObject).append(" selectedPos=");
      ((StringBuilder)localObject).append(d.e());
      ((StringBuilder)localObject).append(" listSelectedPos=");
      ((StringBuilder)localObject).append(d.getSelectedItemPosition());
      ((StringBuilder)localObject).append(" isListInTouchMode=");
      ((StringBuilder)localObject).append(d.isInTouchMode());
    }
    ((StringBuilder)localObject).append("}");
    return ((StringBuilder)localObject).toString();
  }
}

/* Location:
 * Qualified Name:     ckz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */