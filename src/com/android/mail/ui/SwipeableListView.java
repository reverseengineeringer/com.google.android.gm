package com.android.mail.ui;

import android.animation.ObjectAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import buc;
import buo;
import but;
import bwg;
import bxd;
import cab;
import cjo;
import cjy;
import ckv;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import com.android.mail.ui.toastbar.ToastBarOperation;
import cqd;
import cqe;
import cqf;
import cqg;
import cqh;
import cqi;
import cqj;
import cqk;
import cql;
import cqm;
import cqo;
import cqq;
import cso;
import ctk;
import cus;
import cvl;
import cvm;
import cwu;
import cxe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nx;

public class SwipeableListView
  extends ListView
  implements AbsListView.OnScrollListener, cqi, cqq
{
  public static final String c = cvl.a;
  public boolean a = false;
  public boolean b = false;
  public ConversationCheckedSet d;
  public int e;
  public Folder f;
  public cqm g;
  public boolean h;
  public cqo i;
  public cjo j;
  public int k = -1;
  public int l = 0;
  private final cqd m;
  private long n = -1L;
  
  public SwipeableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    m = new cqd(paramContext, this, getResourcesgetDisplayMetricsdensity, ViewConfiguration.get(paramContext).getScaledPagingTouchSlop());
    h = false;
  }
  
  public final int a(ConversationItemView paramConversationItemView, Conversation paramConversation)
  {
    long l1 = b;
    int i1;
    try
    {
      i1 = getPositionForView(paramConversationItemView);
      if (i1 == -1)
      {
        i2 = 0;
        if (i2 < getChildCount())
        {
          paramConversationItemView = getChildAt(i2);
          if (((paramConversationItemView instanceof cab)) && (b.c.s.b == l1)) {
            return getFirstVisiblePosition() + i2;
          }
        }
      }
    }
    catch (Exception paramConversationItemView)
    {
      for (;;)
      {
        int i2;
        cvm.d(c, paramConversationItemView, "Exception finding position; using alternate strategy", new Object[0]);
        i1 = -1;
        continue;
        i2 += 1;
      }
    }
    return i1;
  }
  
  public final int a(Conversation paramConversation)
  {
    if ((f.d(8192)) && (e == buc.x) && (!j.a(s).a(4L))) {
      return buc.aV;
    }
    return e;
  }
  
  public final View a(MotionEvent paramMotionEvent)
  {
    int i2 = getChildCount();
    int i3 = (int)paramMotionEvent.getY();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((localView.getVisibility() != 8) && (i3 >= localView.getTop()) && (i3 <= localView.getBottom()))
      {
        paramMotionEvent = localView;
        if ((localView instanceof cab)) {
          paramMotionEvent = b;
        }
        return paramMotionEvent;
      }
      i1 += 1;
    }
    return null;
  }
  
  public final void a()
  {
    cjy localcjy = (cjy)getAdapter();
    if (localcjy != null)
    {
      localcjy.f();
      h.removeCallbacks(g);
    }
  }
  
  public final void a(ckv paramckv, ConversationItemView paramConversationItemView)
  {
    o();
    Conversation localConversation = c.s;
    c.s.C = a(paramConversationItemView, localConversation);
    cjy localcjy = (cjy)getAdapter();
    if (localcjy == null) {
      return;
    }
    int i2 = a(localConversation);
    Object localObject1;
    Object localObject2;
    int i1;
    if ((i2 != buc.ba) && (i2 != buc.bb))
    {
      localObject1 = new cql(this, paramckv.y(), localConversation, i2, localcjy);
      localObject1 = new ToastBarOperation(1, i2, 1, f, (ctk)localObject1);
      localObject2 = paramConversationItemView.getParent();
      if ((localObject2 != null) && ((localObject2 instanceof cab)))
      {
        localObject2 = (cab)localObject2;
        i1 = c;
        ((cab)localObject2).a();
        label147:
        localcjy.a(localConversation, (ToastBarOperation)localObject1, C, paramConversationItemView.getHeight(), i1);
      }
    }
    else
    {
      paramConversationItemView = (bwg)localcjy.getCursor();
      localObject1 = Conversation.a(localConversation);
      buo.a().a("list_swipe", i2, null);
      paramckv.b(i2, j.a(s));
      if (i2 != buc.dP) {
        break label456;
      }
      localObject2 = new FolderOperation(f, Boolean.valueOf(false));
      paramckv = Folder.a(n.a);
      paramckv.remove(b.c.b);
      n = FolderList.a(paramckv.values());
      localObject2 = new ContentValues();
      ArrayList localArrayList1 = new ArrayList();
      localArrayList1.add(f.c.b);
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(Boolean.FALSE);
      bwg.a(localArrayList1, localArrayList2, (ContentValues)localObject2);
      bwg.a(paramckv.values(), (ContentValues)localObject2);
      paramConversationItemView.b(Conversation.a(localConversation), (ContentValues)localObject2);
    }
    for (;;)
    {
      if (g != null) {
        g.a((Collection)localObject1);
      }
      localcjy.notifyDataSetChanged();
      if ((d == null) || (d.b()) || (!d.a(localConversation))) {
        break;
      }
      d.b(localConversation);
      if ((localConversation.b()) || (!d.b())) {
        break;
      }
      b(true);
      return;
      i1 = -1;
      break label147;
      label456:
      if (i2 == buc.x) {
        paramConversationItemView.d((Collection)localObject1);
      } else if (i2 == buc.aV) {
        paramConversationItemView.e((Collection)localObject1);
      } else if (i2 == buc.ba) {
        paramConversationItemView.b((Collection)localObject1);
      } else if (i2 == buc.bb) {
        paramConversationItemView.c((Collection)localObject1);
      }
    }
  }
  
  public final boolean a(cqj paramcqj)
  {
    return (a) && (paramcqj.h());
  }
  
  public final void b()
  {
    b(true);
  }
  
  public final void b(Conversation paramConversation)
  {
    if (paramConversation == null) {
      return;
    }
    n = b;
  }
  
  public final void b(cqj paramcqj)
  {
    if (paramcqj != null) {
      paramcqj.i();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    int i3 = 0;
    cjy localcjy = (cjy)getAdapter();
    Iterator localIterator;
    if (localcjy != null)
    {
      if (!localcjy.c()) {
        break label261;
      }
      localIterator = o.values().iterator();
      while (localIterator.hasNext())
      {
        LeaveBehindItem localLeaveBehindItem = (LeaveBehindItem)localIterator.next();
        if (paramBoolean) {
          f.b(h.b, localLeaveBehindItem);
        } else {
          localLeaveBehindItem.a();
        }
      }
      i = -1L;
      o.clear();
    }
    label258:
    label261:
    for (int i1 = 1;; i1 = 0)
    {
      int i2 = i1;
      if (localcjy.d())
      {
        i2 = i1;
        if (!paramBoolean)
        {
          i1 = i3;
          while (i1 < f.a())
          {
            ((LeaveBehindItem)f.c(i1)).a();
            i1 += 1;
          }
          f.b();
          i2 = 1;
        }
      }
      if (!b.isEmpty())
      {
        b.clear();
        i2 = 1;
      }
      localIterator = q.iterator();
      i1 = i2;
      if (localIterator.hasNext())
      {
        if (!((cso)localIterator.next()).a()) {
          break label258;
        }
        i1 = 1;
      }
      for (;;)
      {
        break;
        if (i1 != 0) {
          localcjy.notifyDataSetChanged();
        }
        return;
      }
    }
  }
  
  public final void c()
  {
    requestDisallowInterceptTouchEvent(true);
    a();
    if (i != null) {
      i.l();
    }
  }
  
  public final boolean c(Conversation paramConversation)
  {
    return (n != -1L) && (paramConversation != null) && (n == b);
  }
  
  public final void d()
  {
    Object localObject = (cjy)getAdapter();
    if (localObject != null)
    {
      ((cjy)localObject).a();
      localObject = ((cjy)localObject).p();
      if (localObject != null)
      {
        e.setAlpha(1.0F);
        f.setAlpha(0.0F);
      }
    }
    if (i != null) {
      i.m();
    }
  }
  
  public final boolean d(Conversation paramConversation)
  {
    cjy localcjy = (cjy)getAdapter();
    return (a) && (localcjy != null) && (!localcjy.b(b));
  }
  
  public final int e()
  {
    int i1 = getFirstVisiblePosition();
    while (i1 < getLastVisiblePosition())
    {
      Object localObject = getItemAtPosition(i1);
      if (((localObject instanceof bwg)) && (mb == n)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public final boolean e(Conversation paramConversation)
  {
    cjy localcjy = (cjy)getAdapter();
    return (localcjy != null) && (localcjy.c(b));
  }
  
  public final int n()
  {
    return cwu.a(l);
  }
  
  public final void o()
  {
    if (g != null) {
      i.m();
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    float f1 = getResourcesgetDisplayMetricsdensity;
    m.s = f1;
    f1 = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
    m.j = f1;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    cvm.b("MailBlankFragment", "START CLF-ListView.onFocusChanged layoutRequested=%s root.layoutRequested=%s", new Object[] { Boolean.valueOf(isLayoutRequested()), Boolean.valueOf(getRootView().isLayoutRequested()) });
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    cvm.b("MailBlankFragment", new Error(), "FINISH CLF-ListView.onFocusChanged layoutRequested=%s root.layoutRequested=%s", new Object[] { Boolean.valueOf(isLayoutRequested()), Boolean.valueOf(getRootView().isLayoutRequested()) });
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (h) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    cqd localcqd;
    if (!b)
    {
      localcqd = m;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      Object localObject;
      for (boolean bool = o;; bool = false)
      {
        if (!bool) {
          if (!super.onInterceptTouchEvent(paramMotionEvent)) {
            break label460;
          }
        }
        return true;
        t = paramMotionEvent.getY();
        o = false;
        localObject = k.a(paramMotionEvent);
        if ((localObject instanceof cqj)) {
          p = ((cqj)localObject);
        }
        m.clear();
        if (p != null)
        {
          q = p.l().a;
          r = k.a(p);
          m.addMovement(paramMotionEvent);
          n = paramMotionEvent.getX();
          u = paramMotionEvent.getY();
        }
        k.a();
        break;
        if (p == null) {
          break label419;
        }
        if ((t < 0.0F) || (o)) {
          break label330;
        }
        float f2 = paramMotionEvent.getY();
        float f1 = paramMotionEvent.getX();
        f2 = Math.abs(f2 - u);
        f1 = Math.abs(f1 - n);
        if ((f2 <= p.m()) || (f2 <= f1 * 1.2F)) {
          break label330;
        }
        t = paramMotionEvent.getY();
        k.b();
      }
      label330:
      m.addMovement(paramMotionEvent);
      if (Math.abs(paramMotionEvent.getX() - n) > j)
      {
        localObject = k;
        p.l();
        ((cqi)localObject).c();
        o = true;
        n = (paramMotionEvent.getX() - q.getTranslationX());
        u = paramMotionEvent.getY();
      }
      label419:
      t = paramMotionEvent.getY();
      continue;
      o = false;
      p = null;
      q = null;
      t = -1.0F;
    }
    label460:
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (k != -1)
    {
      View localView = getChildAt(k - getFirstVisiblePosition());
      if (localView != null)
      {
        setSelectionFromTop(k, localView.getTop());
        k = -1;
      }
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      if (!h)
      {
        paramAbsListView = getContext();
        if (!(paramAbsListView instanceof ckv)) {
          break;
        }
        ((ckv)paramAbsListView).a(null);
      }
      return;
    }
    cvm.f(c, "unexpected context=%s", new Object[] { paramAbsListView });
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    cqd localcqd;
    int i1;
    if (!b)
    {
      localcqd = m;
      if (o) {
        break label39;
      }
      i1 = 0;
      if (i1 != 0) {}
    }
    else
    {
      if (!super.onTouchEvent(paramMotionEvent)) {
        break label884;
      }
    }
    return true;
    label39:
    m.addMovement(paramMotionEvent);
    float f1;
    float f2;
    float f3;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 2: 
    case 4: 
      do
      {
        do
        {
          do
          {
            i1 = 1;
            break;
          } while (p == null);
          f1 = paramMotionEvent.getX() - n;
        } while (n <= 56.0F * s);
        f2 = cqd.g;
      } while (Math.abs(f1) < f2);
      if (!k.a(p))
      {
        f3 = localcqd.a(q);
        f2 = 0.15F * f3;
        if (Math.abs(f1) >= f3) {
          if (f1 > 0.0F) {
            f1 = f2;
          }
        }
      }
      break;
    }
    for (;;)
    {
      label195:
      Object localObject1 = q;
      if (l == 0) {
        ((View)localObject1).setTranslationX(f1);
      }
      for (;;)
      {
        cqd.b(p.l().a);
        break;
        f1 = -f2;
        break label195;
        f1 = f2 * (float)Math.sin(f1 / f3 * 1.5707963267948966D);
        break label195;
        ((View)localObject1).setTranslationY(f1);
      }
      if (p == null) {
        break;
      }
      f1 = cqd.e;
      f2 = s;
      m.computeCurrentVelocity(1000, f1 * f2);
      f3 = cqd.b;
      float f4 = s;
      localObject1 = m;
      label336:
      label357:
      label399:
      int i2;
      label433:
      int i3;
      if (l == 0)
      {
        f1 = ((VelocityTracker)localObject1).getXVelocity();
        localObject1 = m;
        if (l != 0) {
          break label726;
        }
        f2 = ((VelocityTracker)localObject1).getYVelocity();
        float f5 = Math.abs(q.getTranslationX());
        float f6 = localcqd.a(q);
        if (f5 <= 0.4D * f6) {
          break label735;
        }
        i1 = 1;
        if ((Math.abs(f1) <= f3 * f4) || (Math.abs(f1) <= Math.abs(f2))) {
          break label753;
        }
        if (f1 <= 0.0F) {
          break label741;
        }
        i2 = 1;
        if (q.getTranslationX() <= 0.0F) {
          break label747;
        }
        i3 = 1;
        label449:
        if ((i2 != i3) || (f5 <= f6 * 0.05D)) {
          break label753;
        }
        i2 = 1;
        label473:
        if ((!k.a(p)) || ((i2 == 0) && (i1 == 0))) {
          break label759;
        }
        i1 = 1;
        label504:
        if (i1 == 0) {
          break label789;
        }
        localObject1 = p;
        if (i2 == 0) {
          break label765;
        }
        label521:
        localObject2 = la;
        bool = k.a((cqj)localObject1);
        if ((f1 >= 0.0F) && ((f1 != 0.0F) || (((View)localObject2).getTranslationX() >= 0.0F)) && ((f1 != 0.0F) || (((View)localObject2).getTranslationX() != 0.0F) || (l != 1))) {
          break label770;
        }
        f2 = -localcqd.a((View)localObject2);
        label603:
        i1 = cqd.d;
        if (f1 == 0.0F) {
          break label781;
        }
      }
      label726:
      label735:
      label741:
      label747:
      label753:
      label759:
      label765:
      label770:
      label781:
      for (i1 = Math.min(i1, (int)(Math.abs(f2 - ((View)localObject2).getTranslationX()) * 1000.0F / Math.abs(f1)));; i1 = cqd.c)
      {
        cxe.c((View)localObject2);
        ObjectAnimator localObjectAnimator = localcqd.a((View)localObject2, f2);
        localObjectAnimator.setInterpolator(cqd.a);
        localObjectAnimator.setDuration(i1);
        localObjectAnimator.addListener(new cqe(localcqd, (cqj)localObject1, (View)localObject2));
        localObjectAnimator.addUpdateListener(new cqf(localcqd, bool, (View)localObject2));
        localObjectAnimator.start();
        break;
        f1 = ((VelocityTracker)localObject1).getYVelocity();
        break label336;
        f2 = ((VelocityTracker)localObject1).getXVelocity();
        break label357;
        i1 = 0;
        break label399;
        i2 = 0;
        break label433;
        i3 = 0;
        break label449;
        i2 = 0;
        break label473;
        i1 = 0;
        break label504;
        f1 = 0.0F;
        break label521;
        f2 = localcqd.a((View)localObject2);
        break label603;
      }
      label789:
      Object localObject2 = p;
      localObject1 = la;
      boolean bool = k.a((cqj)localObject2);
      localObject2 = localcqd.a((View)localObject1, 0.0F);
      ((ObjectAnimator)localObject2).setDuration(cqd.f);
      ((ObjectAnimator)localObject2).addUpdateListener(new cqg(localcqd, bool, (View)localObject1));
      ((ObjectAnimator)localObject2).addListener(new cqh(localcqd, (View)localObject1));
      ((ObjectAnimator)localObject2).start();
      break;
      label884:
      return false;
    }
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    super.onTouchModeChanged(paramBoolean);
    if (!paramBoolean)
    {
      int i1 = getSelectedItemPosition();
      if (i1 != -1)
      {
        View localView = getChildAt(i1 - getFirstVisiblePosition());
        if (localView != null) {
          localView.invalidate();
        }
      }
    }
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    boolean bool = super.performItemClick(paramView, paramInt, paramLong);
    b(true);
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SwipeableListView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */