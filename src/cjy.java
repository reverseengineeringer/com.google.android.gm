import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.Space;
import android.widget.TextView;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.ConversationCheckedSet;
import com.android.mail.ui.LeaveBehindData;
import com.android.mail.ui.LeaveBehindItem;
import com.android.mail.ui.MailActivity;
import com.android.mail.ui.SwipeableListView;
import com.android.mail.ui.toastbar.ToastBarOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class cjy
  extends SimpleCursorAdapter
  implements cqp
{
  private static final String N = cvl.a;
  private HashSet<cso> A;
  private HashSet<cso> B;
  private nx<Integer> C = new nx();
  private final Space D;
  private boolean E;
  private boolean F;
  private HashSet<gnr> G = new HashSet();
  private boolean H;
  private boolean I;
  private final ckv J;
  private final SparseArray<cso> K;
  private final bxb L = new bxb();
  private final bzn M;
  private final anf O;
  private final bvd P;
  private final Animator.AnimatorListener Q = new ckc(this);
  final HashSet<Long> a = new HashSet();
  public final ArrayList<Long> b = new ArrayList();
  final HashSet<Long> c = new HashSet();
  final HashSet<Long> d = new HashSet();
  public final HashSet<Long> e = new HashSet();
  public final nx<LeaveBehindItem> f = new nx();
  public Runnable g;
  public final Handler h;
  public long i = -1L;
  public final cqn j = new cjz(this);
  View k;
  final List<View> l = new ArrayList();
  Folder m;
  final SwipeableListView n;
  public final Map<Long, LeaveBehindItem> o = new HashMap();
  final cfx p = new cka(this);
  public final List<cso> q;
  final mx r = mx.a();
  private final int s;
  private final int t;
  private final nx<cab> u = new nx();
  private Account v;
  private final Context w;
  private final ConversationCheckedSet x;
  private cqn y;
  private Runnable z;
  
  public cjy(Context paramContext, bwg parambwg, ConversationCheckedSet paramConversationCheckedSet, ckv paramckv, SwipeableListView paramSwipeableListView, List<cso> paramList)
  {
    super(paramContext, -1, parambwg, chh.k, null, 0);
    w = paramContext;
    M = paramckv.z();
    x = paramConversationCheckedSet;
    a(p.a(paramckv.n()));
    J = paramckv;
    D = ((Space)LayoutInflater.from(paramContext).inflate(bue.n, paramSwipeableListView, false));
    E = false;
    n = paramSwipeableListView;
    F = cxf.a((MailActivity)J);
    O = J.w();
    P = J.a(w, O);
    h = new Handler();
    paramContext = paramContext.getResources();
    s = paramContext.getInteger(bud.k);
    t = paramContext.getInteger(bud.j);
    if (paramList != null) {}
    for (q = new ArrayList(paramList);; q = new ArrayList(0))
    {
      K = new SparseArray(q.size());
      A = new HashSet();
      B = new HashSet();
      paramContext = q.iterator();
      while (paramContext.hasNext()) {
        ((cso)paramContext.next()).a(this);
      }
    }
    A();
  }
  
  private final void A()
  {
    K.clear();
    label20:
    Iterator localIterator;
    if (!bwg.a((bwg)getCursor())) {
      return;
    } else {
      localIterator = q.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label20;
      }
      Object localObject = (cso)localIterator.next();
      ((cso)localObject).a(m, (bwg)getCursor());
      if ((((cso)localObject).o()) && (!B.contains(localObject))) {
        A.add(localObject);
      }
      if (!((cso)localObject).n()) {
        break;
      }
      int i1 = ((cso)localObject).q();
      while (localObject != null)
      {
        cso localcso = (cso)K.get(i1);
        K.put(i1, localObject);
        i1 += 1;
        localObject = localcso;
      }
    }
  }
  
  private final View a(int paramInt, Conversation paramConversation, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    C = paramInt;
    Object localObject2 = (cab)u.a(b, null);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = a(paramInt, paramViewGroup, paramConversation);
      paramViewGroup = Q;
      if (!paramBoolean) {
        break label86;
      }
      paramConversation = b;
      paramConversation = ConversationItemView.a(true, paramConversation.j(), b.N, paramConversation);
    }
    for (;;)
    {
      paramConversation.addListener(paramViewGroup);
      paramConversation.start();
      return (View)localObject1;
      label86:
      localObject2 = b;
      ObjectAnimator localObjectAnimator1 = ((ConversationItemView)localObject2).a(true);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator2.setDuration(b.M);
      localObjectAnimator2.setInterpolator(new DecelerateInterpolator(2.0F));
      paramConversation = new AnimatorSet();
      paramConversation.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      paramConversation.addListener(new cuv((View)localObject2));
    }
  }
  
  private final cab a(int paramInt, ViewGroup paramViewGroup, Conversation paramConversation)
  {
    paramViewGroup = (cab)super.getView(paramInt, null, paramViewGroup);
    b.k();
    paramViewGroup.a(paramConversation, J, x, m, this);
    u.b(b, paramViewGroup);
    return paramViewGroup;
  }
  
  private final cab a(cab paramcab, Context paramContext, Conversation paramConversation, int paramInt)
  {
    if (paramcab == null) {
      paramcab = new cab(paramContext, v, M);
    }
    for (;;)
    {
      paramcab.a(paramConversation, J, x, m, this);
      gnu.a(b, new cet(hlh.d, b, paramInt - a(paramInt)));
      return paramcab;
    }
  }
  
  private final int b(int paramInt)
  {
    return paramInt - l.size();
  }
  
  private final boolean f(long paramLong)
  {
    bwg localbwg = (bwg)getCursor();
    if ((localbwg != null) && (c.a(paramLong) >= 0))
    {
      c.add(Long.valueOf(paramLong));
      return true;
    }
    return false;
  }
  
  private final boolean g(long paramLong)
  {
    return c.contains(Long.valueOf(paramLong));
  }
  
  public final int a(int paramInt)
  {
    int i4 = l.size();
    int i5 = K.size();
    int i2 = i4;
    int i1 = 0;
    while (i1 < i5)
    {
      int i3 = i2;
      if (K.keyAt(i1) <= paramInt - i4) {
        i3 = i2 + 1;
      }
      i1 += 1;
      i2 = i3;
    }
    return i2;
  }
  
  public final int a(Conversation paramConversation)
  {
    return ((Integer)C.a(b, Integer.valueOf(-1))).intValue();
  }
  
  public final int a(cso paramcso)
  {
    return K.indexOfValue(paramcso);
  }
  
  public final LeaveBehindItem a(Conversation paramConversation, ToastBarOperation paramToastBarOperation, int paramInt1, int paramInt2, int paramInt3)
  {
    f();
    i = b;
    if (g == null) {
      g = new ckb(this);
    }
    for (;;)
    {
      localObject1 = o.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LeaveBehindItem)((Map.Entry)((Iterator)localObject1).next()).getValue();
        localObject3 = h;
        if ((i == -1L) || (b != i))
        {
          ((LeaveBehindItem)localObject2).b();
          if (n != null) {
            n.cancel();
          }
          e.setVisibility(8);
          f.setVisibility(8);
          m = true;
        }
      }
      h.removeCallbacks(g);
    }
    a();
    Object localObject1 = (LeaveBehindItem)LayoutInflater.from(w).inflate(bue.ak, n, false);
    Object localObject2 = J.n().a(s);
    Object localObject3 = m;
    g = paramInt1;
    a = paramToastBarOperation;
    b = ((Account)localObject2);
    c = this;
    j = paramInt2;
    h = paramConversation;
    paramInt1 = b;
    ((LeaveBehindItem)localObject1).setBackgroundResource(cwu.a(paramInt1));
    e = ((LeaveBehindItem)localObject1).findViewById(buc.fk);
    e.setOnClickListener((View.OnClickListener)localObject1);
    e.setAlpha(0.0F);
    f = ((ImageView)((LeaveBehindItem)localObject1).findViewById(buc.fi));
    Context localContext;
    if (paramInt3 == -1)
    {
      f.setVisibility(8);
      d = ((TextView)((LeaveBehindItem)localObject1).findViewById(buc.fw));
      localObject2 = d;
      paramToastBarOperation = a;
      localContext = ((LeaveBehindItem)localObject1).getContext();
      if (b != buc.dP) {
        break label515;
      }
      paramToastBarOperation = localContext.getString(buj.bU, new Object[] { d });
    }
    for (;;)
    {
      ((TextView)localObject2).setText(cxa.b(paramToastBarOperation));
      d.setOnClickListener((View.OnClickListener)localObject1);
      o.put(Long.valueOf(b), localObject1);
      b.add(Long.valueOf(b));
      return (LeaveBehindItem)localObject1;
      f.setAlpha(1.0F);
      f.setImageResource(cwu.b(paramInt1));
      paramToastBarOperation = (FrameLayout.LayoutParams)f.getLayoutParams();
      gravity = paramInt3;
      f.setLayoutParams(paramToastBarOperation);
      break;
      label515:
      if (b == buc.aV) {
        paramInt1 = buj.aX;
      }
      for (;;)
      {
        if (paramInt1 != -1) {
          break label563;
        }
        paramToastBarOperation = "";
        break;
        if (b == buc.x) {
          paramInt1 = buj.r;
        } else {
          paramInt1 = -1;
        }
      }
      label563:
      paramToastBarOperation = localContext.getString(paramInt1);
    }
  }
  
  public final void a()
  {
    if (o.size() > 2)
    {
      h.postDelayed(g, t);
      return;
    }
    h.postDelayed(g, s);
  }
  
  final void a(long paramLong, HashSet<Long> paramHashSet)
  {
    paramHashSet.remove(Long.valueOf(paramLong));
    u.a(paramLong);
    if (paramHashSet.isEmpty())
    {
      a(null);
      notifyDataSetChanged();
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    Object localObject = new long[b.size()];
    int i1 = 0;
    while (i1 < localObject.length)
    {
      localObject[i1] = ((Long)b.get(i1)).longValue();
      i1 += 1;
    }
    paramBundle.putLongArray("last_deleting_items", (long[])localObject);
    if (c())
    {
      if (i != -1L)
      {
        localObject = (LeaveBehindItem)o.get(Long.valueOf(i));
        paramBundle.putParcelable("leave_behind_item_data", new LeaveBehindData(h, a, j));
        paramBundle.putLong("leave_behind_item_id", i);
      }
      localObject = o.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LeaveBehindItem localLeaveBehindItem = (LeaveBehindItem)((Iterator)localObject).next();
        if ((i == -1L) || (h.b != i)) {
          localLeaveBehindItem.a();
        }
      }
    }
    paramBundle.putSerializable("state-impressed-conversation-visual-elements", G);
  }
  
  public final void a(cqn paramcqn)
  {
    if (y != null) {
      y.a();
    }
    y = paramcqn;
  }
  
  public final void a(Runnable paramRunnable)
  {
    if (A.isEmpty())
    {
      paramRunnable.run();
      return;
    }
    z = paramRunnable;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (E != paramBoolean)
    {
      E = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public final boolean a(long paramLong)
  {
    return a.contains(Long.valueOf(paramLong));
  }
  
  final boolean a(Account paramAccount)
  {
    boolean bool2 = true;
    boolean bool1;
    Object localObject;
    if ((v == null) || (!v.g.equals(g)) || (v.z.n != z.n) || (v.z.d != z.d))
    {
      bool1 = true;
      v = paramAccount;
      H = v.z.n;
      I = v.z.o;
      localObject = buo.a();
      if (z.d != 1) {
        break label221;
      }
      label117:
      ((but)localObject).a(3, Boolean.toString(bool2));
      but localbut = buo.a();
      if (z.c != 0) {
        break label226;
      }
      localObject = "reply";
      label149:
      localbut.a(7, (String)localObject);
      localObject = buo.a();
      switch (z.b())
      {
      default: 
        paramAccount = "unset";
      }
    }
    for (;;)
    {
      ((but)localObject).a(8, paramAccount);
      return bool1;
      bool1 = false;
      break;
      label221:
      bool2 = false;
      break label117;
      label226:
      localObject = "reply_all";
      break label149;
      paramAccount = "older";
      continue;
      paramAccount = "newer";
      continue;
      paramAccount = "list";
    }
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void b()
  {
    boolean bool1;
    if (!b.isEmpty())
    {
      Iterator localIterator = b.iterator();
      for (bool1 = false; localIterator.hasNext(); bool1 = f(((Long)localIterator.next()).longValue()) | bool1) {}
      b.clear();
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (i != -1L)
      {
        bool2 = bool1 | f(i);
        i = -1L;
      }
      if (bool2)
      {
        notifyDataSetChanged();
        a(j);
      }
      return;
      bool1 = false;
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle.containsKey("last_deleting_items"))
    {
      localObject = paramBundle.getLongArray("last_deleting_items");
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        long l1 = localObject[i1];
        b.add(Long.valueOf(l1));
        i1 += 1;
      }
    }
    if (paramBundle.containsKey("leave_behind_item_data"))
    {
      localObject = (LeaveBehindData)paramBundle.getParcelable("leave_behind_item_data");
      o.put(Long.valueOf(paramBundle.getLong("leave_behind_item_id")), a(a, b, a.C, c, -1));
    }
    G = ((HashSet)paramBundle.getSerializable("state-impressed-conversation-visual-elements"));
  }
  
  public final void b(cso paramcso)
  {
    B.add(paramcso);
    A.remove(paramcso);
    if ((z != null) && (A.isEmpty()))
    {
      h.post(z);
      z = null;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext()) {
      ((cso)localIterator.next()).a(paramBoolean);
    }
  }
  
  public final boolean b(long paramLong)
  {
    return d.contains(Long.valueOf(paramLong));
  }
  
  public final void bindView(View paramView, Context paramContext, Cursor paramCursor) {}
  
  public final boolean c()
  {
    return !o.isEmpty();
  }
  
  public final boolean c(long paramLong)
  {
    return e.contains(Long.valueOf(paramLong));
  }
  
  public final void changeCursor(Cursor paramCursor)
  {
    super.changeCursor(paramCursor);
    A();
  }
  
  public final void changeCursorAndColumns(Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.changeCursorAndColumns(paramCursor, paramArrayOfString, paramArrayOfInt);
    A();
  }
  
  public final void d(long paramLong)
  {
    if ((c()) && (o.containsKey(Long.valueOf(paramLong)))) {
      o.remove(Long.valueOf(paramLong));
    }
    for (;;)
    {
      if (i == paramLong) {
        i = -1L;
      }
      return;
      if (d()) {
        f.a(paramLong);
      } else {
        cvm.b(N, "Trying to clear a non-existant leave behind", new Object[0]);
      }
    }
  }
  
  public final boolean d()
  {
    return f.a() > 0;
  }
  
  public final void e()
  {
    int i1 = n.getFirstVisiblePosition();
    int i2 = n.getLastVisiblePosition();
    if (c())
    {
      Iterator localIterator = o.entrySet().iterator();
      while (localIterator.hasNext())
      {
        LeaveBehindItem localLeaveBehindItem = (LeaveBehindItem)((Map.Entry)localIterator.next()).getValue();
        Conversation localConversation = h;
        if ((i == -1L) || (b != i))
        {
          if ((C >= i1) && (C <= i2)) {
            f.b(b, localLeaveBehindItem);
          }
          for (;;)
          {
            localIterator.remove();
            break;
            localLeaveBehindItem.a();
          }
        }
      }
      f();
    }
    if (!b.isEmpty()) {
      b.clear();
    }
    notifyDataSetChanged();
  }
  
  public final void e(long paramLong)
  {
    if (!a.isEmpty()) {
      a(paramLong, a);
    }
    x();
  }
  
  public final void f()
  {
    LeaveBehindItem localLeaveBehindItem = p();
    if (localLeaveBehindItem != null) {
      localLeaveBehindItem.b();
    }
  }
  
  public final bxb g()
  {
    return L;
  }
  
  public final int getCount()
  {
    int i1 = K.size();
    int i2 = super.getCount() + i1;
    if (i2 == 0)
    {
      if (E) {}
      for (i1 = 1;; i1 = 0) {
        return i1 + i2;
      }
    }
    return l.size() + 1 + i2;
  }
  
  public final Object getItem(int paramInt)
  {
    Object localObject;
    if (paramInt < 0) {
      localObject = null;
    }
    cso localcso;
    do
    {
      return localObject;
      localcso = (cso)K.get(b(paramInt));
      if (l.size() > paramInt) {
        return l.get(paramInt);
      }
      if (paramInt == getCount() - 1)
      {
        if (E) {
          return k;
        }
        return D;
      }
      localObject = localcso;
    } while (localcso != null);
    return super.getItem(paramInt - a(paramInt));
  }
  
  public final long getItemId(int paramInt)
  {
    if ((l.size() > paramInt) || (paramInt == getCount() - 1)) {
      return -1L;
    }
    Object localObject = (cso)K.get(b(paramInt));
    if (localObject != null) {
      return localObject.hashCode();
    }
    paramInt -= a(paramInt);
    localObject = (bwg)getCursor();
    if ((localObject != null) && (((bwg)localObject).moveToPosition(paramInt)))
    {
      localObject = ((bwg)localObject).n();
      if (localObject != null) {
        return b;
      }
    }
    return super.getItemId(paramInt);
  }
  
  public final int getItemViewType(int paramInt)
  {
    int i2 = -1;
    int i1;
    if (l.size() > paramInt) {
      i1 = 2;
    }
    do
    {
      do
      {
        do
        {
          return i1;
          if (paramInt == getCount() - 1) {
            return 1;
          }
          i1 = i2;
        } while (c());
        i1 = i2;
      } while (m());
      i1 = i2;
    } while (K.get(b(paramInt)) != null);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (l.size() > paramInt) {
      paramView = (View)l.get(paramInt);
    }
    do
    {
      do
      {
        return paramView;
        if (paramInt == getCount() - 1)
        {
          if (E) {
            return k;
          }
          return D;
        }
        localObject1 = (cso)K.get(b(paramInt));
        if (localObject1 != null)
        {
          ((cso)localObject1).d();
          return (View)localObject1;
        }
        cxa.g("AA.getView");
        localObject1 = (bwg)getItem(paramInt);
        localObject2 = ((bwg)localObject1).m();
        C.b(b, Integer.valueOf(paramInt));
        ((bwg)localObject1).o();
        if (g(b)) {
          return a(paramInt - a(paramInt), (Conversation)localObject2, paramViewGroup, false);
        }
        if (c(b)) {
          return a(paramInt - a(paramInt), (Conversation)localObject2, paramViewGroup, true);
        }
        if (!a(b)) {
          break;
        }
        paramInt -= a(paramInt);
        C = paramInt;
        localObject1 = (cab)u.a(b, null);
        paramView = (View)localObject1;
      } while (localObject1 != null);
      paramView = a(paramInt, paramViewGroup, (Conversation)localObject2);
      b.setAnimatedHeightFraction(0.0F);
      return paramView;
      if (!b(b)) {
        break;
      }
      paramInt -= a(paramInt);
      C = paramInt;
      localObject1 = (cab)u.a(b, null);
      paramView = (View)localObject1;
    } while (localObject1 != null);
    paramView = a(paramInt, paramViewGroup, (Conversation)localObject2);
    paramViewGroup = Q;
    Object localObject2 = b;
    Object localObject1 = ConversationItemView.a(false, ((ConversationItemView)localObject2).j(), b.N, localObject2);
    localObject2 = ((ConversationItemView)localObject2).a(false);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localObject1, localObject2 });
    localAnimatorSet.addListener(paramViewGroup);
    localAnimatorSet.start();
    return paramView;
    int i1;
    if (d())
    {
      if ((d()) && (f.a(b, null) != null) && (((Conversation)localObject2).b())) {}
      for (i1 = 1; i1 != 0; i1 = 0)
      {
        paramView = (LeaveBehindItem)f.a(b, null);
        paramViewGroup = Q;
        if (!k)
        {
          k = true;
          localObject1 = ObjectAnimator.ofInt(paramView, "animatedHeight", new int[] { j, 0 });
          paramView.setMinimumHeight(j);
          i = paramView.getWidth();
          ((ObjectAnimator)localObject1).setInterpolator(new DecelerateInterpolator(1.75F));
          ((ObjectAnimator)localObject1).setDuration(LeaveBehindItem.o);
          ((ObjectAnimator)localObject1).addListener(paramViewGroup);
          ((ObjectAnimator)localObject1).start();
        }
        cxa.a();
        return paramView;
      }
    }
    if (c())
    {
      long l1;
      if ((c()) && (o.containsKey(Long.valueOf(b))) && (((Conversation)localObject2).b()))
      {
        i1 = 1;
        if (i1 == 0) {
          break label793;
        }
        paramView = (LeaveBehindItem)o.get(Long.valueOf(b));
        if (b == i)
        {
          if (o.size() <= 2) {
            break label782;
          }
          if (!l) {
            break label771;
          }
          paramInt = t;
          if ((!l) && (e.getAlpha() != 1.0F))
          {
            l = true;
            l1 = n.getStartDelay();
            if ((paramInt != l1) && (!n.isRunning())) {
              break label742;
            }
          }
        }
      }
      for (;;)
      {
        cxa.a();
        return paramView;
        i1 = 0;
        break;
        label742:
        n.cancel();
        n.setStartDelay(paramInt - l1);
        n.start();
        continue;
        label771:
        paramView.a(t);
        continue;
        label782:
        paramView.a(s);
      }
    }
    label793:
    if ((paramView != null) && (!(paramView instanceof cab)))
    {
      cvm.d(N, "Incorrect convert view received; nulling it out", new Object[0]);
      paramView = newView(w, (Cursor)localObject1, paramViewGroup);
    }
    for (;;)
    {
      paramView = a((cab)paramView, w, (Conversation)localObject2, paramInt);
      if (F)
      {
        paramViewGroup = b;
        localObject1 = gnu.a(paramViewGroup);
        if ((localObject1 != null) && (!G.contains(localObject1)))
        {
          G.add(localObject1);
          paramViewGroup.post(new cex(J, paramViewGroup, G));
        }
      }
      cxa.a();
      return paramView;
      if (paramView != null) {
        b.k();
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 5;
  }
  
  public final boolean h()
  {
    return (v == null) || (v.z.d == 1);
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
  
  public final boolean i()
  {
    return H;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    cso localcso = (cso)K.get(paramInt);
    if (localcso != null)
    {
      boolean bool = localcso.k();
      cvm.b(N, "AA.isEnabled(%d) = %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      return bool;
    }
    return (!a(paramInt)) && (!g(paramInt)) && ((paramInt != getCount() - 1) || (E));
  }
  
  public final boolean j()
  {
    return I;
  }
  
  public final mx k()
  {
    return r;
  }
  
  public final Folder l()
  {
    return m;
  }
  
  public final boolean m()
  {
    return (!c.isEmpty()) || (!e.isEmpty()) || (d()) || (!a.isEmpty()) || (!d.isEmpty());
  }
  
  public final void n()
  {
    if (!m()) {
      return;
    }
    c.clear();
    e.clear();
    f.b();
    a.clear();
    d.clear();
    u.b();
    cvm.d(N, "AA.clearAnimationState forcibly cleared state, this=%s", new Object[] { this });
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return new cab(paramContext, v, M);
  }
  
  public final void notifyDataSetChanged()
  {
    if (Looper.getMainLooper() != Looper.myLooper()) {
      cvm.f(N, "notifyDataSetChanged() called off the main thread", new Object[0]);
    }
    F = cxf.a((MailActivity)J);
    A();
    super.notifyDataSetChanged();
  }
  
  public final bwg o()
  {
    return (bwg)getCursor();
  }
  
  public final LeaveBehindItem p()
  {
    if (i != -1L) {
      return (LeaveBehindItem)o.get(Long.valueOf(i));
    }
    return null;
  }
  
  public final anf q()
  {
    return O;
  }
  
  public final bvd r()
  {
    return P;
  }
  
  public final void s()
  {
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext()) {
      ((cso)localIterator.next()).e();
    }
    A.clear();
    B.clear();
  }
  
  public final Cursor swapCursor(Cursor paramCursor)
  {
    paramCursor = super.swapCursor(paramCursor);
    A();
    return paramCursor;
  }
  
  public final void t()
  {
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext()) {
      ((cso)localIterator.next()).f();
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mUndoingItems=");
    localStringBuilder.append(c);
    localStringBuilder.append(" mSwipeUndoingItems=");
    localStringBuilder.append(e);
    localStringBuilder.append(" mDeletedItems=");
    localStringBuilder.append(a);
    localStringBuilder.append(" mSwipeDeletingItems=");
    localStringBuilder.append(d);
    localStringBuilder.append(" mLeaveBehindItems=");
    localStringBuilder.append(o);
    localStringBuilder.append(" mFadeLeaveBehindItems=");
    localStringBuilder.append(f);
    localStringBuilder.append(" mLastDeletingItems=");
    localStringBuilder.append(b);
    localStringBuilder.append(" mAnimatingViews=");
    localStringBuilder.append(u);
    localStringBuilder.append(" mPendingDestruction=");
    localStringBuilder.append(y);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void u()
  {
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext()) {
      ((cso)localIterator.next()).g();
    }
  }
  
  public final void v()
  {
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext()) {
      ((cso)localIterator.next()).j();
    }
  }
  
  public final boolean w()
  {
    return !x.b();
  }
  
  final void x()
  {
    if (!m()) {
      J.a(this);
    }
    n.l = 0;
  }
  
  public final bzn y()
  {
    return M;
  }
}

/* Location:
 * Qualified Name:     cjy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */