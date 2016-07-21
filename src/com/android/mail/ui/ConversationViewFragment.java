package com.android.mail.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.Toast;
import aon;
import aoo;
import aot;
import apv;
import apw;
import apy;
import apz;
import aqb;
import btq;
import bty;
import bua;
import buc;
import bud;
import bue;
import buh;
import buj;
import buo;
import bus;
import but;
import bvk;
import bwa;
import bwe;
import bwx;
import bxh;
import bxn;
import bxp;
import bxq;
import bxr;
import bxt;
import bxu;
import bxv;
import bxw;
import byi;
import byj;
import bym;
import byv;
import byw;
import byy;
import bze;
import bzf;
import bzg;
import bzh;
import bzl;
import bzo;
import caa;
import cah;
import cak;
import car;
import cas;
import cau;
import cav;
import cba;
import cbf;
import cbk;
import cex;
import cfa;
import cfm;
import cfs;
import cft;
import chq;
import cje;
import cjf;
import cjw;
import ckg;
import ckv;
import cky;
import cll;
import clm;
import clo;
import clp;
import clq;
import clr;
import cls;
import clt;
import clv;
import cly;
import clz;
import cma;
import cmb;
import cmc;
import cmd;
import cme;
import cmf;
import cmg;
import cmk;
import cml;
import cmn;
import cmr;
import cmw;
import com;
import com.android.emailcommon.mail.Address;
import com.android.mail.browse.ConversationContainer;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.browse.ConversationViewHeader;
import com.android.mail.browse.ConversationWebView;
import com.android.mail.browse.ScrollIndicatorsView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Event;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Message;
import com.android.mail.providers.Settings;
import com.android.mail.ui.toastbar.ActionableToastBar;
import com.android.mail.ui.toastbar.ToastBarOperation;
import cpb;
import cpf;
import cpl;
import cpn;
import cpy;
import cqp;
import crj;
import cst;
import ctd;
import ctx;
import cub;
import cul;
import cvj;
import cvl;
import cvm;
import cxa;
import cxd;
import cxe;
import glh;
import gnr;
import gnt;
import gnu;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mx;
import ns;
import vq;
import vr;
import zc;

public class ConversationViewFragment
  extends cjf
  implements LoaderManager.LoaderCallbacks<String>, View.OnKeyListener, View.OnLayoutChangeListener, bwx, byv, byy, bzf, bzg, bzh, caa, cak, cba, cbf
{
  private static final String at = String.valueOf(ConversationViewFragment.class.getName()).concat("webview-y-percent");
  public static final String s = cvl.a;
  public ConversationContainer A;
  public ConversationWebView B;
  public cmn C;
  public ActionableToastBar D;
  public com E;
  public bxp F;
  public boolean G;
  String H;
  public int I;
  public int J;
  public int K = 0;
  public boolean L;
  public bym M;
  float N;
  public long O;
  final Map<String, String> P = new HashMap();
  public Long Q;
  public int R;
  public final Object S = new Object();
  public final Map<String, Long> T = new ConcurrentHashMap();
  public String U = null;
  public String V = "gx";
  public boolean W;
  public final DataSetObserver X = new clm(this);
  public final Runnable Y = new cly(this, "onProgressDismiss", this);
  public Map<String, String> Z;
  public final Runnable aa = new clt(this);
  public final Runnable ab = new clv(this);
  private cpb ac;
  private View ad;
  private int ae;
  private int af;
  private Set<bzl> ag = new HashSet();
  private ViewGroup ah;
  private ctd ai;
  private final ConversationViewFragment.MailJsBridge aj = new ConversationViewFragment.MailJsBridge(this);
  private HashSet<gnr> ak = new HashSet();
  private boolean al;
  private boolean am;
  private Attachment an;
  private Message ao;
  private final Object ap = new Object();
  private Long aq;
  private bze ar;
  private final Runnable as = new clz(this, "onHeaderAnimated", this);
  private mx au;
  private cas av;
  public boolean t;
  public boolean u;
  public int v = 0;
  public ViewGroup w;
  public ConversationViewHeader x;
  public AnimatorSet y;
  public int z;
  
  private final Animator D()
  {
    w.setBackgroundColor(getResources().getColor(17170443));
    if (A.getVisibility() == 0)
    {
      if (x != null) {
        x.setVisibility(4);
      }
      w.setAlpha(0.0F);
      w.setVisibility(0);
      cxe.c(w);
      localObject1 = ObjectAnimator.ofFloat(w, "alpha", new float[] { 1.0F });
      ((ObjectAnimator)localObject1).setDuration(93L);
      ((ObjectAnimator)localObject1).setInterpolator(new LinearInterpolator());
      ((ObjectAnimator)localObject1).addListener(new clo(this));
    }
    do
    {
      Object localObject2;
      do
      {
        return (Animator)localObject1;
        localObject2 = null;
        localObject1 = localObject2;
      } while (x == null);
      localObject1 = localObject2;
    } while (x.getVisibility() != 0);
    x.animate().cancel();
    float f = x.getAlpha();
    cxe.c(x);
    Object localObject1 = ObjectAnimator.ofFloat(x, "alpha", new float[] { 0.0F });
    ((Animator)localObject1).setDuration((f * 70.0F));
    ((Animator)localObject1).addListener(new clp(this));
    return (Animator)localObject1;
  }
  
  private final void E()
  {
    View localView = getView();
    if (localView != null) {
      localView.getViewTreeObserver().addOnPreDrawListener(new clq(this));
    }
  }
  
  private final float F()
  {
    if (B == null) {}
    int i;
    int j;
    int k;
    do
    {
      return 0.0F;
      i = B.getScrollY();
      j = B.getHeight();
      k = (int)(B.getContentHeight() * B.getScale());
    } while ((k == 0) || (k <= j));
    if (i + j >= k) {
      return 1.0F;
    }
    return i / k;
  }
  
  private final void G()
  {
    if (K == 1) {
      e().n(X);
    }
    K = 0;
  }
  
  private final bxu H()
  {
    int i = F.getCount();
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      bxh localbxh = F.a(i);
      if ((localbxh instanceof bxu)) {
        return (bxu)localbxh;
      }
    }
    cvm.f(s, "No message header found", new Object[0]);
    return null;
  }
  
  private final void I()
  {
    boolean bool = a(f);
    WebSettings localWebSettings = B.getSettings();
    localWebSettings.setUseWideViewPort(bool);
    localWebSettings.setSupportZoom(bool);
    localWebSettings.setBuiltInZoomControls(bool);
    localWebSettings.setLoadWithOverviewMode(bool);
    if (bool) {
      localWebSettings.setDisplayZoomControls(false);
    }
    for (WebSettings.LayoutAlgorithm localLayoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL;; localLayoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS)
    {
      localWebSettings.setLayoutAlgorithm(localLayoutAlgorithm);
      return;
    }
  }
  
  private final int a(bxh parambxh)
  {
    int i = parambxh.a();
    Object localObject1 = (Deque)A.e.a.get(Integer.valueOf(i));
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((Deque)localObject1).peek())
    {
      Object localObject2 = (View)localObject1;
      localObject1 = F.a(parambxh, (View)localObject2, A, true);
      if (localObject2 == null)
      {
        localObject2 = A;
        e.a(Integer.valueOf(i), localObject1);
        ((ConversationContainer)localObject2).a((View)localObject1, false);
      }
      A.a((View)localObject1);
      i = ((View)localObject1).getMeasuredHeight();
      parambxh.a(i);
      b = false;
      return i;
    }
  }
  
  private final ConversationItemView a(MailActivity paramMailActivity, cje paramcje)
  {
    View localView = w.findViewById(buc.v);
    cqp localcqp = paramcje.c();
    if (localView == null)
    {
      paramcje = new ConversationItemView(paramMailActivity, f, localcqp.y());
      paramcje.setAlpha(0.0F);
      paramcje.setId(buc.v);
      w.addView(paramcje);
    }
    for (;;)
    {
      paramcje.a(d, paramMailActivity, null, n(), localcqp, true);
      return paramcje;
      paramcje = (ConversationItemView)localView;
      paramcje.k();
      paramcje.setAlpha(0.0F);
      paramcje.setVisibility(0);
    }
  }
  
  private final void a(ConversationMessage paramConversationMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = F;
    boolean bool = this.m.a(paramConversationMessage);
    int i = ((bxp)localObject).a(new bxu((bxp)localObject, a, paramConversationMessage, paramBoolean1, bool));
    localObject = (bxu)F.a(i);
    bxp localbxp = F;
    int j = localbxp.a(new bxt(localbxp, q, (bxu)localObject));
    i = e(i);
    j = e(j);
    int k = B.c(i);
    int m = B.c(j);
    E.a(paramConversationMessage, paramBoolean1, paramBoolean2, B.b(i) + k, m + B.b(j));
    c("rendered message");
  }
  
  public static void a(ConversationWebView paramConversationWebView, String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramString.startsWith("javascript:")) {
      localStringBuilder.append("javascript:");
    }
    localStringBuilder.append(String.format(Locale.ENGLISH, paramString, paramVarArgs));
    if (!paramString.endsWith(";")) {
      localStringBuilder.append(";");
    }
    paramConversationWebView.loadUrl(localStringBuilder.toString());
  }
  
  private final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    long l;
    if (paramBoolean)
    {
      x.setAlpha(0.0F);
      x.setVisibility(0);
      ViewPropertyAnimator localViewPropertyAnimator = x.animate().alpha(1.0F);
      if (t)
      {
        l = 75L;
        localViewPropertyAnimator.setDuration(l).setListener(new cmb(this, paramRunnable));
      }
    }
    do
    {
      return;
      l = 70L;
      break;
      x.setVisibility(0);
      b.q().l();
    } while (paramRunnable == null);
    paramRunnable.run();
  }
  
  private final void a(boolean paramBoolean, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramArrayOfString[0]))
    {
      paramArrayOfString = String.valueOf(paramArrayOfString[0]);
      if (paramArrayOfString.length() != 0) {}
      for (paramArrayOfString = "unexpected permission: ".concat(paramArrayOfString);; paramArrayOfString = new String("unexpected permission: ")) {
        throw new IllegalStateException(paramArrayOfString);
      }
    }
    if (paramArrayOfInt[0] == 0)
    {
      if ((an == null) || (ao == null)) {
        cvm.e(cvm.a, "attachment %s or message %s missing in onRequestPermissionResult", new Object[] { an, ao });
      }
      paramArrayOfString = new bvk(getActivity(), null);
      h = getFragmentManager();
      c = an;
      b = ao;
      paramArrayOfInt = paramArrayOfString.b();
      String str = cxa.e(an.l());
      if (paramBoolean) {}
      for (paramArrayOfString = "storage_attachment_eas";; paramArrayOfString = "storage_attachment")
      {
        bus.a(paramArrayOfString, "granted");
        buo.a().a("attachment", paramArrayOfInt, str, an.d);
        return;
      }
    }
    Toast.makeText(getActivity(), buj.eo, 0).show();
    if (paramBoolean) {}
    for (paramArrayOfString = "storage_attachment_eas";; paramArrayOfString = "storage_attachment")
    {
      bus.a(paramArrayOfString, "denied");
      return;
    }
  }
  
  public static boolean a(Account paramAccount)
  {
    boolean bool = false;
    paramAccount = z;
    if (h != -1) {}
    for (int i = h;; i = 0)
    {
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static bwe[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = paramArrayOfInt1.length;
    bwe[] arrayOfbwe = new bwe[j];
    int i = 0;
    while (i < j)
    {
      arrayOfbwe[i] = new bwe(paramArrayOfInt1[i], paramArrayOfInt2[i]);
      i += 1;
    }
    return arrayOfbwe;
  }
  
  private final void c(byw parambyw)
  {
    if ((parambyw == null) || (parambyw.isClosed())) {
      return;
    }
    int i = -1;
    for (;;)
    {
      int j = i + 1;
      if (!parambyw.moveToPosition(j)) {
        break;
      }
      Integer localInteger = parambyw.a().q();
      i = j;
      if (localInteger != null)
      {
        getLoaderManager().destroyLoader(localInteger.intValue());
        i = j;
      }
    }
  }
  
  private final boolean d(Message paramMessage)
  {
    paramMessage = d(j);
    return (paramMessage == null) || (f.b(a));
  }
  
  public boolean A()
  {
    return true;
  }
  
  public void B()
  {
    getLoaderManager().initLoader(0, Bundle.EMPTY, c);
  }
  
  public void C()
  {
    getLoaderManager().destroyLoader(0);
  }
  
  public final WebResourceResponse a(Uri paramUri)
  {
    if ((!"https".equalsIgnoreCase(paramUri.getScheme())) || (TextUtils.isEmpty(f.P)) || (!f.P.equalsIgnoreCase(paramUri.getHost()))) {
      return null;
    }
    synchronized (ap)
    {
      if (U == null) {
        break label214;
      }
      if ((!TextUtils.isEmpty(f.Q)) && (f.Q.equalsIgnoreCase(paramUri.getPath())))
      {
        paramUri = new WebResourceResponse("text/html", "utf-8", new cmw(paramUri.toString(), U));
        return paramUri;
      }
    }
    cvm.e(s, "Url=%s is intercepted, but not matching the expectedPath=%s when OAuth token is valid", new Object[] { paramUri, f.P });
    but localbut = buo.a();
    paramUri = String.valueOf(paramUri.getPath());
    if (paramUri.length() != 0)
    {
      paramUri = "unexpected_path_".concat(paramUri);
      localbut.a("gmail_auth", "inline_images", paramUri, 0L);
    }
    for (;;)
    {
      return null;
      paramUri = new String("unexpected_path_");
      break;
      label214:
      if (!W)
      {
        cvm.d(s, "Both OAuth token and cookie is null. Therefore url=%s cannot be loaded", new Object[] { paramUri });
        buo.a().a("gmail_auth", "inline_images", "unexpected_both_tokens_null", 0L);
      }
    }
  }
  
  public String a(byw parambyw, boolean paramBoolean)
  {
    cvm.b(s, "IN renderMessageBodies, fragment=%s", new Object[] { this });
    A.c = null;
    F.a();
    ConversationViewState localConversationViewState = this.m;
    this.m = new ConversationViewState(localConversationViewState);
    Object localObject1 = F;
    int j = e(((bxp)localObject1).a(new bxr((bxp)localObject1, d)));
    localObject1 = b.t().a(F, d);
    int i = 0;
    if (localObject1 != null) {
      i = e(F.a((bxh)localObject1));
    }
    E.a(B.e, B.b(J), B.b(j), B.b(i));
    i = -1;
    boolean bool2;
    boolean bool1;
    int k;
    boolean bool3;
    label208:
    Object localObject3;
    int i1;
    label255:
    int m;
    Object localObject2;
    label290:
    label316:
    int n;
    label409:
    boolean bool4;
    if ((f != null) && (f.z.q == 0))
    {
      bool2 = true;
      bool1 = false;
      localObject1 = null;
      j = 0;
      k = -1;
      bool3 = bool2;
      k += 1;
      if (!parambyw.moveToPosition(k)) {
        break label768;
      }
      localObject3 = parambyw.a();
      if ((!bool2) && (!A) && (!localConversationViewState.a((Message)localObject3))) {
        break label472;
      }
      i1 = 1;
      m = j | i1;
      localObject2 = (ConversationViewState.MessageViewState)a.get(f);
      if (localObject2 != null) {
        break label478;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label498;
      }
      if ((!cmr.a(((Integer)localObject2).intValue())) || (!parambyw.isLast())) {
        break label488;
      }
      j = 1;
      this.m.b((Message)localObject3, localConversationViewState.a((Message)localObject3));
      this.m.a((Message)localObject3, j);
      this.m.b((Message)localObject3, localConversationViewState.b((Message)localObject3));
      localObject2 = this.m;
      if (!B) {
        break label602;
      }
      ConversationViewState.MessageViewState localMessageViewState = (ConversationViewState.MessageViewState)a.get(f);
      if ((localMessageViewState == null) || (a)) {
        break label596;
      }
      n = 1;
      if (n != 0) {
        break label602;
      }
      bool4 = true;
      label417:
      ((ConversationViewState)localObject2).a((Message)localObject3, bool4);
      if (!cmr.a(j)) {
        break label608;
      }
      if (i >= 0) {
        break label976;
      }
      i = k;
    }
    label472:
    label478:
    label488:
    label498:
    label596:
    label602:
    label608:
    label629:
    label768:
    label841:
    label921:
    label956:
    label962:
    label967:
    label976:
    for (;;)
    {
      d(j);
      localObject1 = localObject3;
      j = m;
      bool3 = i1;
      break label208;
      bool2 = false;
      break;
      i1 = 0;
      break label255;
      localObject2 = b;
      break label290;
      j = ((Integer)localObject2).intValue();
      break label316;
      localObject2 = n();
      if ((D) || (!B) || (parambyw.isLast()) || ((localObject2 != null) && ((((Folder)localObject2).d(16)) || (((Folder)localObject2).d(8))) && (d((Message)localObject3))))
      {
        j = 1;
        break label316;
      }
      if (parambyw.isFirst())
      {
        j = 2;
        break label316;
      }
      bool1 |= ((ConversationMessage)localObject3).p();
      j = 3;
      break label316;
      n = 0;
      break label409;
      bool4 = false;
      break label417;
      if (i >= 0) {
        if (k - i == 1)
        {
          a((ConversationMessage)localObject1, false, bool3);
          bool1 = false;
          localObject1 = null;
          i = -1;
        }
      }
      for (;;)
      {
        if (j == 1) {}
        for (bool4 = true;; bool4 = false)
        {
          a((ConversationMessage)localObject3, bool4, i1);
          j = m;
          break;
          localObject1 = F;
          n = e(((bxp)localObject1).a(new bxv((bxp)localObject1, i, k - 1, bool1)));
          localObject1 = E;
          n = B.b(n);
          if (!e) {
            throw new IllegalStateException("must call startConversation first");
          }
          ((com)localObject1).a(com.f, new Object[] { Integer.valueOf(i), Integer.valueOf(n) });
          break label629;
        }
        parambyw = H();
        localObject1 = F;
        i = e(((bxp)localObject1).a(new bxq((bxp)localObject1, parambyw)));
        parambyw = B.getSettings();
        if (j == 0)
        {
          bool1 = true;
          parambyw.setBlockNetworkImage(bool1);
          if ((f.F <= 0) || (p)) {
            break label956;
          }
          bool1 = true;
          parambyw = E;
          j = B.b(i);
          localObject1 = e;
          localObject2 = d.a(e);
          k = B.e;
          m = B.a(J);
          localObject3 = f.z;
          if (h == -1) {
            break label962;
          }
          i = h;
          if (i != 0) {
            break label967;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          return parambyw.a(j, (String)localObject1, (String)localObject2, k, m, paramBoolean, bool2, bool1, bool1);
          bool1 = false;
          break;
          bool1 = false;
          break label841;
          i = 0;
          break label921;
        }
      }
    }
  }
  
  public final void a(AnimatorSet paramAnimatorSet)
  {
    v();
    Animator localAnimator = D();
    if (localAnimator != null) {
      localAnimator.start();
    }
    paramAnimatorSet.start();
    if (cxd.d()) {
      getView().setTranslationZ(10.0F);
    }
  }
  
  public final void a(View paramView)
  {
    if (b())
    {
      gnr localgnr = gnu.a(paramView);
      if ((localgnr != null) && (!ak.contains(localgnr)))
      {
        ak.add(localgnr);
        paramView.post(new cex(b, paramView, ak));
      }
    }
  }
  
  public final void a(bxu parambxu, int paramInt)
  {
    A.c = null;
    int i = B.b(paramInt);
    cvm.c("ConvLayout", "setting HTML spacer h=%dwebPx (%dscreenPx)", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    a(B, "setMessageHeaderSpacerHeight('%s', %d)", new Object[] { com.a(f), Integer.valueOf(i) });
  }
  
  public final void a(bxu parambxu, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      v = (i * Math.abs(parambxu.e() - paramInt));
      return;
    }
  }
  
  public final void a(bxv parambxv)
  {
    byw localbyw = this.i;
    if ((localbyw == null) || (!G)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    E.c();
    int i;
    int j;
    label68:
    ConversationMessage localConversationMessage;
    Object localObject1;
    Object localObject2;
    label122:
    int m;
    int n;
    int i1;
    int i2;
    com localcom;
    if ((f != null) && (f.z.q == 0))
    {
      i = 1;
      j = e;
      int k = f;
      if (j > k) {
        break label299;
      }
      localbyw.moveToPosition(j);
      localConversationMessage = localbyw.a();
      localObject1 = F;
      localObject2 = F.a;
      if ((i == 0) && (!this.m.a(localConversationMessage))) {
        break label287;
      }
      bool = true;
      localObject1 = bxp.a((bxp)localObject1, (btq)localObject2, localConversationMessage, false, bool);
      localObject2 = new bxt(F, this, (bxu)localObject1);
      m = a((bxh)localObject1);
      n = a((bxh)localObject2);
      i1 = B.c(m);
      i2 = B.c(n);
      localcom = E;
      if ((i == 0) && (!A)) {
        break label293;
      }
    }
    label287:
    label293:
    for (boolean bool = true;; bool = false)
    {
      localcom.a(localConversationMessage, false, bool, B.b(m) + i1, B.b(n) + i2);
      localArrayList.add(localObject1);
      localArrayList.add(localObject2);
      this.m.a(localConversationMessage, 2);
      j += 1;
      break label68;
      i = 0;
      break;
      bool = false;
      break label122;
    }
    label299:
    F.a(parambxv, localArrayList);
    F.notifyDataSetChanged();
    H = E.a();
    a(B, "replaceSuperCollapsedBlock(%d)", new Object[] { Integer.valueOf(e) });
    A.b();
  }
  
  public final void a(byw parambyw)
  {
    parambyw = a(parambyw, L);
    c("rendered conversation");
    if (am) {
      N = F();
    }
    A.setVisibility(0);
    B.loadDataWithBaseURL(e, parambyw, "text/html", "utf-8", null);
    am = true;
    O = SystemClock.uptimeMillis();
  }
  
  public final void a(byw parambyw)
  {
    ;
    Object localObject1;
    int j;
    if ((localbxq != null) && (!localbxq.isClosed()))
    {
      localObject1 = new cmk(this);
      i = -1;
      Object localObject2;
      for (;;)
      {
        j = i + 1;
        if (!parambyw.moveToPosition(j)) {
          break;
        }
        localObject2 = parambyw.a();
        i = j;
        if (!m.a.containsKey(f))
        {
          cvm.c(s, "conversation diff: found new msg: %s", new Object[] { f });
          if (d((Message)localObject2))
          {
            cvm.c(s, "found message from self: %s", new Object[] { f });
            b += 1;
            i = j;
          }
          else
          {
            a += 1;
            i = j;
          }
        }
      }
      if (a > 0)
      {
        cvm.c(s, "CONV RENDER: conversation updated, holding cursor for new incoming message (%s)", new Object[] { this });
        D.a(ai, c.getResources().getQuantityString(buh.q, a, new Object[] { Integer.valueOf(a) }), buj.eN, true, false, null);
        return;
      }
      j = localbxq.a(0);
      if (parambyw.a(0) != j) {
        i = 1;
      }
      while (i == 0)
      {
        localObject1 = new HashSet();
        localObject2 = new ArrayList();
        i = 0;
        for (;;)
        {
          if ((parambyw.moveToPosition(i)) && (localbxq.moveToPosition(i)))
          {
            ConversationMessage localConversationMessage1 = parambyw.a();
            ConversationMessage localConversationMessage2 = localbxq.a();
            if (!localConversationMessage1.a(localConversationMessage2))
            {
              F.a(localConversationMessage1, (List)localObject2);
              cvm.c(s, "msg #%d (%d): detected field(s) change. sendingState=%s", new Object[] { Integer.valueOf(i), Long.valueOf(d), Integer.valueOf(N) });
            }
            if ((!TextUtils.equals(o, o)) || (!TextUtils.equals(p, p)))
            {
              ((Set)localObject1).add(com.a(localConversationMessage1));
              cvm.c(s, "msg #%d (%d): detected body change", new Object[] { Integer.valueOf(i), Long.valueOf(d) });
            }
            i += 1;
            continue;
            i = 0;
            break;
          }
        }
        if (((List)localObject2).isEmpty()) {
          break label824;
        }
        A.a((List)localObject2);
      }
    }
    label750:
    label767:
    label824:
    for (int i = 1;; i = 0)
    {
      parambyw = F.c();
      if (parambyw != null) {
        b = true;
      }
      if (!((Set)localObject1).isEmpty())
      {
        a(B, "replaceMessageBodies(['%s'])", new Object[] { TextUtils.join("','", (Iterable)localObject1) });
        i = 1;
      }
      if (i != 0)
      {
        cvm.c(s, "CONV RENDER: processed update(s) in place (%s)", new Object[] { this });
        return;
      }
      cvm.c(s, "CONV RENDER: uninteresting update, ignoring this conversation update (%s)", new Object[] { this });
      return;
      if (b == 1)
      {
        if (parambyw.a(1) == j)
        {
          i = 1;
          if (i == 0) {
            break label767;
          }
          cvm.c(s, "CONV RENDER: update is a single new message from self (%s)", new Object[] { this });
          parambyw.moveToLast();
          parambyw = parambyw.a();
          localbxq = F.b();
          if (localbxq == null) {
            break label750;
          }
          A.b(c);
        }
        for (;;)
        {
          E.c();
          a(parambyw, true, A);
          H = E.a();
          if (localbxq != null)
          {
            e = H();
            b = true;
            F.a(localbxq);
          }
          m.a(parambyw, 1);
          m.a(parambyw, false);
          A.c = null;
          a(B, "appendMessageHtml()", new Object[0]);
          return;
          i = 0;
          break;
          cvm.c(s, "footer item not found", new Object[0]);
        }
      }
      c(localbxq);
      cvm.c(s, "CONV RENDER: conversation updated, but not due to incoming message. rendering. (%s)", new Object[] { this });
      for (;;)
      {
        b(parambyw);
        return;
        cvm.c(s, "CONV RENDER: initial render. (%s)", new Object[] { this });
        c("message cursor load finished");
      }
    }
  }
  
  public final void a(bze parambze, Event paramEvent, int paramInt)
  {
    cvm.b(cvm.a, "CVF.requestCalendarPermission", new Object[0]);
    Context localContext = getContext();
    String str;
    if (paramInt == 4)
    {
      str = "android.permission.WRITE_CALENDAR";
      if ((!cfm.a(localContext).e(str)) || (shouldShowRequestPermissionRationale(str))) {
        break label171;
      }
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      cfa.a(localContext.getString(buj.co, new Object[] { car.a(localContext, b, d) })).show(b.getFragmentManager(), "permanent-permission-denial-dialog");
      return;
      str = "android.permission.READ_CALENDAR";
      break;
      bus.a("calendar_show_agenda", "permanent_denial");
      continue;
      bus.a("calendar_show_new_time_proposal", "permanent_denial");
      continue;
      bus.a("calendar_accept_new_time_proposal", "permanent_denial");
    }
    label171:
    ar = parambze;
    cfm.a(localContext).f(str);
    requestPermissions(new String[] { str }, paramInt);
  }
  
  public final void a(bzl parambzl)
  {
    ag.add(parambzl);
  }
  
  public final void a(cje paramcje, AnimatorSet paramAnimatorSet, Runnable paramRunnable)
  {
    v();
    MailActivity localMailActivity = (MailActivity)getActivity();
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject1 = new vr();
    View localView = getView();
    Object localObject2 = paramcje.a(d);
    int i;
    Animator localAnimator;
    ObjectAnimator localObjectAnimator1;
    if (localObject2[0] == -1)
    {
      i = localView.getTop();
      localObject2[1] = i;
      localObject2[0] = i;
      E();
      localAnimator = D();
      if (localMailActivity == null) {
        break label438;
      }
      paramcje = a(localMailActivity, paramcje);
      cxe.c(paramcje);
      localObjectAnimator1 = ObjectAnimator.ofFloat(paramcje, "alpha", new float[] { 1.0F }).setDuration(140L);
      localObjectAnimator1.setStartDelay(93L);
      localObjectAnimator1.setInterpolator(new LinearInterpolator());
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofInt(localView, "top", new int[] { w.getTop(), localObject2[0] }).setDuration(280L);
      localObjectAnimator2.setInterpolator((TimeInterpolator)localObject1);
      localObject2 = ObjectAnimator.ofInt(localView, "bottom", new int[] { w.getBottom(), localObject2[1] }).setDuration(280L);
      ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)localObject1);
      localObject1 = localAnimatorSet.play(localObjectAnimator2).with((Animator)localObject2);
      if (localObjectAnimator1 != null) {
        ((AnimatorSet.Builder)localObject1).with(localObjectAnimator1);
      }
      if (localAnimator != null) {
        ((AnimatorSet.Builder)localObject1).with(localAnimator);
      }
      if (cxd.d())
      {
        localView.setTranslationZ(10.0F);
        localObjectAnimator1 = ObjectAnimator.ofFloat(localView, "translationZ", new float[] { 0.0F }).setDuration(140L);
        localObjectAnimator1.setStartDelay(140L);
        localObjectAnimator1.setInterpolator(new LinearInterpolator());
        ((AnimatorSet.Builder)localObject1).with(localObjectAnimator1);
      }
      localAnimatorSet.addListener(new cmf(this, paramRunnable, localMailActivity, paramcje));
      if (localMailActivity != null) {
        l.g(true);
      }
      paramAnimatorSet.start();
      localAnimatorSet.start();
      paramcje = b.y();
      if (paramcje != null) {
        paramcje.a(f, n(), d);
      }
      return;
      if (localObject2[0] != -2) {
        break;
      }
      i = localView.getBottom();
      localObject2[1] = i;
      localObject2[0] = i;
      break;
      label438:
      paramcje = null;
      localObjectAnimator1 = null;
    }
  }
  
  public final void a(Account paramAccount1, Account paramAccount2)
  {
    int k = 1;
    paramAccount1 = z;
    int i;
    if (h != -1)
    {
      i = h;
      if (i != 0) {
        break label85;
      }
      i = 1;
      label27:
      paramAccount1 = z;
      if (h == -1) {
        break label90;
      }
      j = h;
      label46:
      if (j != 0) {
        break label96;
      }
    }
    label85:
    label90:
    label96:
    for (int j = k;; j = 0)
    {
      if (i == j) {
        break label102;
      }
      I();
      paramAccount1 = this.i;
      if (paramAccount1 != null) {
        a(paramAccount1);
      }
      return;
      i = 0;
      break;
      i = 0;
      break label27;
      j = 0;
      break label46;
    }
    label102:
    F.notifyDataSetChanged();
  }
  
  public final void a(Conversation paramConversation)
  {
    Object localObject = (ConversationViewHeader)A.findViewById(buc.au);
    d = paramConversation;
    ViewGroup localViewGroup;
    if (localObject != null)
    {
      d = paramConversation;
      ((ConversationViewHeader)localObject).a(d);
      ((ConversationViewHeader)localObject).a(paramConversation);
      ((ConversationViewHeader)localObject).a(l, false);
      if (c != null)
      {
        c.e = paramConversation;
        localViewGroup = (ViewGroup)((ConversationViewHeader)localObject).getParent();
        if (localViewGroup != null) {
          break label152;
        }
        cvm.e(ConversationViewHeader.a, "Unable to measure height of conversation header", new Object[0]);
      }
    }
    label152:
    for (int i = ((ConversationViewHeader)localObject).getHeight();; i = cxa.a((View)localObject, localViewGroup))
    {
      if ((c.a(i)) && (b != null)) {
        b.d(i);
      }
      localObject = (bxn)A.findViewById(buc.aF);
      if (localObject != null) {
        ((bxn)localObject).a(paramConversation);
      }
      return;
    }
  }
  
  public final void a(Message paramMessage)
  {
    m.b(paramMessage, true);
    B.getSettings().setBlockNetworkImage(false);
    a(B, "unblockImages(['%s'])", new Object[] { com.a(paramMessage) });
  }
  
  public final void a(Message paramMessage, int paramInt)
  {
    m.b(paramMessage, paramInt);
  }
  
  public final void a(gnt paramgnt, View paramView)
  {
    ((MailActivity)b).a(new gnr(paramgnt), paramView);
  }
  
  public final void a(Runnable paramRunnable)
  {
    Object localObject1;
    if (b())
    {
      if (x == null)
      {
        localObject1 = (ViewGroup)getView();
        localObject2 = getActivity();
        localObject3 = LayoutInflater.from((Context)localObject2);
        localObject4 = new bxr(F, d);
        x = ((ConversationViewHeader)((bxr)localObject4).a((Context)localObject2, (LayoutInflater)localObject3, (ViewGroup)localObject1));
        x.a((bxr)localObject4);
        w.addView(x);
      }
      if (!t) {
        break label126;
      }
      w.setVisibility(0);
      a(paramRunnable, u);
      C.a(b(), n());
    }
    label126:
    do
    {
      do
      {
        do
        {
          return;
          y = new AnimatorSet();
          localObject3 = (MailActivity)getActivity();
          localObject1 = (cpf)l;
          localObject4 = ((cpf)localObject1).g();
          if (localObject4 != null) {
            break;
          }
        } while (!isAdded());
        w.setVisibility(0);
        a(paramRunnable, true);
        C.a(b(), n());
        return;
        localObject2 = ((cje)localObject4).a(d);
        localObject5 = a((MailActivity)localObject3, (cje)localObject4);
        ((ConversationItemView)localObject5).setAlpha(1.0F);
        w.setBackgroundColor(getResources().getColor(17170443));
        x.setAlpha(0.0F);
        x.setVisibility(0);
        w.setVisibility(0);
        cxe.c((View)localObject5);
        localObject3 = ObjectAnimator.ofFloat(localObject5, "alpha", new float[] { ((ConversationItemView)localObject5).getAlpha(), 0.0F }).setDuration(140L);
        ((ObjectAnimator)localObject3).setInterpolator(new LinearInterpolator());
        ((ObjectAnimator)localObject3).addListener(new cmc(this, (ConversationItemView)localObject5));
        E();
        localObject4 = ObjectAnimator.ofInt(w, "top", new int[] { localObject2[0], w.getTop() }).setDuration(280L);
        ((ObjectAnimator)localObject4).addListener(new cmd(this, (cpf)localObject1, (ConversationItemView)localObject5, paramRunnable));
        paramRunnable = new vr();
        ((ObjectAnimator)localObject4).setInterpolator(paramRunnable);
        localObject2 = ObjectAnimator.ofInt(w, "bottom", new int[] { localObject2[1], w.getBottom() }).setDuration(280L);
        ((ObjectAnimator)localObject2).setInterpolator(paramRunnable);
        cxe.c(x);
        x.animate().alpha(1.0F).setStartDelay(70L).setDuration(70L).setListener(new cme(this));
        if (cxd.d())
        {
          paramRunnable = ObjectAnimator.ofFloat(w, "translationZ", new float[] { 10.0F }).setDuration(70L);
          paramRunnable.setInterpolator(new LinearInterpolator());
          y.playTogether(new Animator[] { localObject4, localObject2, localObject3, paramRunnable });
        }
        for (;;)
        {
          y.start();
          if (crj.b(o.a)) {
            break;
          }
          cvm.d(cpf.I, "OPC.animateConversationListAway: Tried fading out list when not in conversation mode", new Object[0]);
          return;
          y.playTogether(new Animator[] { localObject4, localObject2, localObject3 });
        }
        paramRunnable = ((cpf)localObject1).g();
      } while (paramRunnable == null);
      paramRunnable = paramRunnable.getView();
    } while (paramRunnable == null);
    Object localObject2 = new vq();
    cxe.c(paramRunnable);
    Object localObject3 = ObjectAnimator.ofFloat(paramRunnable, "alpha", new float[] { 0.0F });
    ((ObjectAnimator)localObject3).setInterpolator(new LinearInterpolator());
    Object localObject4 = ObjectAnimator.ofFloat(paramRunnable, "scaleX", new float[] { 0.95F });
    ((ObjectAnimator)localObject4).setInterpolator((TimeInterpolator)localObject2);
    Object localObject5 = ObjectAnimator.ofFloat(paramRunnable, "scaleY", new float[] { 0.95F });
    ((ObjectAnimator)localObject5).setInterpolator((TimeInterpolator)localObject2);
    X = new AnimatorSet();
    X.playTogether(new Animator[] { localObject3, localObject4, localObject5 });
    X.setDuration(140L);
    X.addListener(new cpl((cpf)localObject1, paramRunnable));
    X.start();
  }
  
  public final void a(String paramString)
  {
    B.getSettings().setBlockNetworkImage(false);
    paramString = d(paramString);
    if (paramString == null) {
      return;
    }
    byw localbyw = this.i;
    ArrayList localArrayList = new ArrayList();
    int i = -1;
    while (localbyw != null)
    {
      int j = i + 1;
      if (!localbyw.moveToPosition(j)) {
        break;
      }
      ConversationMessage localConversationMessage = localbyw.a();
      i = j;
      if (paramString.equals(d(j)))
      {
        A = true;
        m.b(localConversationMessage, true);
        localArrayList.add(com.a(localConversationMessage));
        i = j;
      }
    }
    a(B, "unblockImages(['%s'])", new Object[] { TextUtils.join("','", localArrayList) });
  }
  
  public final void a(boolean paramBoolean, Attachment paramAttachment, Message paramMessage)
  {
    cvm.b(cvm.a, "CVF.requestSavePermission", new Object[0]);
    an = paramAttachment;
    ao = paramMessage;
    if (paramBoolean) {
      try
      {
        paramAttachment = new Intent("android.intent.action.VIEW");
        paramAttachment.setPackage("com.google.android.gm.exchange");
        startActivityForResult(paramAttachment, 1);
        return;
      }
      catch (ActivityNotFoundException paramAttachment)
      {
        cvm.e(s, paramAttachment, "Can't open Exchange to request storage permission.", new Object[0]);
        throw paramAttachment;
      }
    }
    requestPermissions(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 1);
  }
  
  public final ConversationMessage b(String paramString)
  {
    paramString = (String)Z.get(paramString);
    if (paramString == null) {
      return null;
    }
    byw localbyw = i;
    if (localbyw == null) {
      return null;
    }
    return localbyw.a(Long.parseLong(com.a(paramString)));
  }
  
  public final String b(Message paramMessage)
  {
    paramMessage = com.a(paramMessage);
    if (paramMessage == null) {
      return null;
    }
    return (String)P.get(paramMessage);
  }
  
  public final void b(int paramInt)
  {
    paramInt = B.b(paramInt);
    a(B, "setConversationFooterSpacerHeight(%d)", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final void b(View paramView)
  {
    ((MailActivity)b).a(paramView, 4);
  }
  
  public final void b(bxu parambxu, int paramInt)
  {
    int i = 1;
    A.c = null;
    int j = B.b(paramInt);
    cvm.c("ConvLayout", "setting HTML spacer expanded=%s h=%dwebPx (%dscreenPx)", new Object[] { Boolean.valueOf(g), Integer.valueOf(j), Integer.valueOf(paramInt) });
    a(B, "setMessageBodyVisible('%s', %s, %d)", new Object[] { com.a(f), Boolean.valueOf(g), Integer.valueOf(j) });
    ConversationViewState localConversationViewState = m;
    ConversationMessage localConversationMessage = f;
    if (g) {}
    for (paramInt = i;; paramInt = 2)
    {
      localConversationViewState.a(localConversationMessage, paramInt);
      return;
    }
  }
  
  public final void b(byw parambyw)
  {
    if (A.getWidth() == 0)
    {
      al = true;
      A.addOnLayoutChangeListener(this);
      return;
    }
    a(parambyw);
  }
  
  public final void b(bzl parambzl)
  {
    ag.remove(parambzl);
  }
  
  public void b_(View paramView)
  {
    ((MailActivity)b).a(paramView, 4);
  }
  
  public final int c(Message paramMessage)
  {
    return m.b(paramMessage);
  }
  
  public final void c(int paramInt)
  {
    paramInt = B.b(paramInt);
    a(B, "setConversationPromotionSpacerHeight(%d)", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final boolean c()
  {
    return false;
  }
  
  protected final Address d(String paramString)
  {
    return cxa.a(h, paramString);
  }
  
  public final void d(int paramInt)
  {
    paramInt = B.b(paramInt);
    a(B, "setConversationHeaderSpacerHeight(%d)", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final int e(int paramInt)
  {
    return a(F.a(paramInt));
  }
  
  public final void f(int paramInt)
  {
    ConversationViewHeader localConversationViewHeader = (ConversationViewHeader)A.findViewById(buc.au);
    if (localConversationViewHeader != null) {
      localConversationViewHeader.setVisibility(paramInt);
    }
  }
  
  protected final void g()
  {
    super.g();
    Object localObject = (ckv)getActivity();
    if (localObject == null)
    {
      cvm.d(s, "ignoring markUnread for conv=%s", new Object[] { Long.valueOf(d.b) });
      return;
    }
    if (m == null)
    {
      cvm.c(s, "ignoring markUnread for conv with no view state (%d)", new Object[] { Long.valueOf(d.b) });
      return;
    }
    localObject = ((ckv)localObject).k();
    Conversation localConversation = d;
    ConversationViewState localConversationViewState = m;
    HashSet localHashSet = new HashSet();
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      ConversationViewState.MessageViewState localMessageViewState = (ConversationViewState.MessageViewState)a.get(localUri);
      if ((localMessageViewState != null) && (!a)) {
        localHashSet.add(localUri);
      }
    }
    ((cll)localObject).a(localConversation, localHashSet, m.b);
  }
  
  public final void h()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = b();
    cvm.b(s, "ConversationViewFragment#onUserVisibleHintChanged(), userVisible = %b", new Object[] { Boolean.valueOf(bool2) });
    if (!bool2) {
      C.a(null);
    }
    while (!G)
    {
      if (B != null) {
        B.c = bool2;
      }
      return;
    }
    boolean bool1;
    if (b != null)
    {
      bool1 = b.k().Z();
      label89:
      if (this.i == null) {
        break label158;
      }
      cvm.b(s, "Fragment is now user-visible, onConversationSeen: %s", new Object[] { this });
      if (bool1) {
        break label214;
      }
    }
    label127:
    label158:
    label209:
    label212:
    label214:
    for (localObject1 = "preloaded";; localObject1 = null)
    {
      p();
      for (;;)
      {
        if (localObject1 != null)
        {
          buo.a().a("pager_swipe", (String)localObject1, o(), 0L);
          break;
          bool1 = true;
          break label89;
          if (K == 0) {
            break label209;
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label212;
          }
          cvm.b(s, "Fragment is now user-visible, showing conversation: %s", new Object[] { this });
          localObject1 = localObject2;
          if (!bool1) {
            localObject1 = "load_deferred";
          }
          y();
          break label127;
          break;
        }
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    cvm.b(s, "IN CVF.onActivityCreated, this=%s visible=%s", new Object[] { this, Boolean.valueOf(b()) });
    super.onActivityCreated(paramBundle);
    if ((b == null) || (b.isFinishing())) {
      return;
    }
    paramBundle = getActivity();
    E = new com(paramBundle);
    paramBundle = new btq(paramBundle);
    ac = b.r();
    F = new bxp(b, this, getLoaderManager(), this, this, b.a(), k(), this, this, this, e(), this, h, paramBundle, au, this, av);
    F.q = this;
    F.r = this;
    F.s = this;
    F.t = this;
    F.u = this;
    A.a(F);
    paramBundle = getResources();
    t = cxa.a(paramBundle);
    u = paramBundle.getBoolean(bty.c);
    I = paramBundle.getInteger(bud.t);
    J = paramBundle.getDimensionPixelOffset(bua.x);
    z = paramBundle.getDimensionPixelOffset(bua.z);
    Z = new ns();
    paramBundle = byj.a;
    Activity localActivity = getActivity();
    Account localAccount = f;
    if (d != null) {}
    for (long l = d.b;; l = -1L)
    {
      paramBundle = new cah(localActivity, paramBundle.a(localAccount, l));
      b = this;
      B.setOnCreateContextMenuListener(paramBundle);
      I();
      this.l.post(new cma(this, "showConversation", this));
      if (!cxa.b(f.D))
      {
        aq = Long.valueOf(chq.b());
        getLoaderManager().initLoader(3, Bundle.EMPTY, this);
      }
      W = false;
      if ((d != null) && (d.u != null) && (!cxa.b(f.C))) {
        new cml(this, j, d.u.toString(), f.C).execute(new Void[0]);
      }
      paramBundle = new Rect();
      b.getWindow().getDecorView().getWindowVisibleDisplayFrame(paramBundle);
      ae = bottom;
      af = (top + b.e().h());
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent != null)) {
      a(true, paramIntent.getStringArrayExtra("permissions"), paramIntent.getIntArrayExtra("grantResults"));
    }
    Object localObject;
    Uri localUri;
    ContentValues localContentValues;
    do
    {
      do
      {
        do
        {
          return;
          if ((paramInt1 != 5) && (paramInt1 != 6) && (paramInt1 != 7)) {
            break label595;
          }
          localObject = av;
          if (paramInt1 != 5) {
            break;
          }
          switch (paramInt2)
          {
          case 0: 
          default: 
            ((cas)localObject).f().a(b.f, j.c(b));
            return;
          case -1: 
            e = paramIntent.getLongExtra("start_millis", 0L);
            f = paramIntent.getLongExtra("end_millis", 0L);
            ((cas)localObject).e();
            return;
          }
          paramInt1 = paramIntent.getIntExtra("invalid_email_count", 0);
          paramIntent = i.getResources().getQuantityString(buh.u, paramInt1);
          Toast.makeText(i.getActivity(), paramIntent, 1).show();
        } while (m);
        l = true;
        h.postDelayed(n, 1500L);
        m = true;
        return;
        if (paramInt1 != 6) {
          break;
        }
      } while (paramInt2 != -1);
      long l2;
      if (b != null)
      {
        localUri = b.f;
        paramInt1 = j.c(b);
        l2 = e;
      }
      for (long l1 = f;; l1 = c.ak)
      {
        localObject = ((cas)localObject).f();
        paramIntent = paramIntent.getStringExtra("note");
        localContentValues = new ContentValues(4);
        cvm.b(cav.a, "SENDING PROPOSE TIME COMMAND, VALUE=%s", new Object[] { Integer.valueOf(paramInt1) });
        localContentValues.put("respond", Integer.valueOf(paramInt1));
        localContentValues.put("proposedStartTime", Long.valueOf(l2));
        localContentValues.put("proposedEndTime", Long.valueOf(l1));
        localContentValues.put("meetingRequestComment", paramIntent);
        ((cav)localObject).startUpdate(0, null, localUri, localContentValues, null, null);
        return;
        localUri = c.ah;
        paramInt1 = c.ai;
        l2 = c.aj;
      }
    } while ((paramInt1 != 7) || (paramInt2 != -1));
    if (b != null) {
      localUri = b.f;
    }
    for (paramInt1 = j.c(b);; paramInt1 = c.ai)
    {
      localObject = ((cas)localObject).f();
      paramIntent = paramIntent.getStringExtra("note");
      localContentValues = new ContentValues(2);
      cvm.b(cav.a, "SENDING RSVP COMMENT COMMAND, VALUE=%s", new Object[] { Integer.valueOf(paramInt1) });
      localContentValues.put("respond", Integer.valueOf(paramInt1));
      localContentValues.put("meetingRequestComment", paramIntent);
      ((cav)localObject).startUpdate(0, null, localUri, localContentValues, null, null);
      return;
      localUri = c.ah;
    }
    label595:
    throw new IllegalStateException(42 + "unexpected permission request: " + paramInt1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g = w();
    av = new cas(this, this, f, h);
    cas localcas;
    Object localObject1;
    Object localObject2;
    if (paramBundle != null)
    {
      N = paramBundle.getFloat(at);
      an = ((Attachment)paramBundle.getParcelable("attachment_awaiting_permission"));
      ao = ((Message)paramBundle.getParcelable("attachment_message_awaiting_permission"));
      localcas = av;
      if (paramBundle.containsKey("message"))
      {
        b = ((Message)paramBundle.getParcelable("message"));
        e = paramBundle.getLong("proposed_start_time", 0L);
        f = paramBundle.getLong("proposed_end_time", 0L);
        if (paramBundle.containsKey("calendar_in_millis"))
        {
          g = Calendar.getInstance();
          g.setTimeInMillis(paramBundle.getLong("calendar_in_millis", 0L));
        }
        l = paramBundle.getBoolean("to_show_proposed_time_fallback", false);
        localObject1 = (DialogFragment)i.getFragmentManager().findFragmentByTag("ProposeTimeDatePickerDialog");
        if (localObject1 != null)
        {
          localObject2 = new aon(localcas);
          d = true;
          ((aon)localObject2).a((DialogFragment)localObject1);
          if (!(localObject1 instanceof aoo)) {
            break label390;
          }
          a = localcas;
        }
        localObject1 = (DialogFragment)i.getFragmentManager().findFragmentByTag("ProposeTimeTimePickerDialog");
        if (localObject1 != null)
        {
          localObject2 = new apv(localcas);
          if (c != null) {
            c.dismiss();
          }
          if (!(localObject1 instanceof apw)) {
            break label408;
          }
          b = new apy(a);
          label305:
          c = ((DialogFragment)localObject1);
          if (!(localObject1 instanceof apw)) {
            break label437;
          }
          a = localcas;
        }
      }
    }
    for (;;)
    {
      localObject1 = (cul)i.getFragmentManager().findFragmentByTag("MoreOptionsDialog");
      if (localObject1 != null) {
        a = new cau(localcas);
      }
      ak = ((HashSet)paramBundle.getSerializable("state-impressed-message-visual-elements"));
      au = mx.a();
      glh.a.b("Application ready");
      return;
      label390:
      if (!(localObject1 instanceof aot)) {
        break;
      }
      a = localcas;
      break;
      label408:
      if (!(localObject1 instanceof aqb)) {
        break label305;
      }
      b = new apz(a);
      break label305;
      label437:
      if ((localObject1 instanceof aqb)) {
        a = localcas;
      }
    }
  }
  
  public Loader<String> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new cpy(j, f.D);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(bue.x, paramViewGroup, false);
    A = ((ConversationContainer)paramViewGroup.findViewById(buc.as));
    ah = ((ViewGroup)A.findViewById(buc.aJ));
    ah.setOnKeyListener(this);
    paramBundle = ah;
    paramLayoutInflater.inflate(bue.w, paramBundle, true);
    w = ((ViewGroup)paramViewGroup.findViewById(buc.w));
    x();
    C = new cmn(this, l);
    C.a(paramViewGroup);
    B = ((ConversationWebView)A.findViewById(buc.aK));
    B.addJavascriptInterface(aj, "mail");
    boolean bool3 = cxd.a();
    boolean bool2 = b();
    paramLayoutInflater = B;
    if (!bool3)
    {
      bool1 = true;
      b = bool1;
      if ((!bool3) || (!bool2)) {
        break label308;
      }
    }
    label308:
    for (boolean bool1 = true;; bool1 = false)
    {
      L = bool1;
      B.c = bool2;
      B.setWebViewClient(g);
      paramLayoutInflater = new clr(this);
      B.setWebChromeClient(paramLayoutInflater);
      paramLayoutInflater = B.getSettings();
      paramBundle = (ScrollIndicatorsView)paramViewGroup.findViewById(buc.ek);
      a = B;
      a.a(paramBundle);
      paramLayoutInflater.setJavaScriptEnabled(true);
      ctx.a(getResources(), paramLayoutInflater);
      if (cxd.d()) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(B, true);
      }
      G = true;
      am = false;
      return paramViewGroup;
      bool1 = false;
      break;
    }
  }
  
  public void onDestroyView()
  {
    A.a(null);
    F = null;
    G();
    G = false;
    super.onDestroyView();
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      ad = paramView;
    }
    if (ad != null)
    {
      int m = ad.getId();
      boolean bool1 = cxe.a(ad);
      int i;
      int k;
      label73:
      boolean bool3;
      int j;
      label90:
      label99:
      boolean bool4;
      boolean bool2;
      if (paramKeyEvent.getAction() == 1)
      {
        i = 1;
        if (((bool1) || (paramInt != 21)) && ((!bool1) || (paramInt != 22))) {
          break label186;
        }
        k = 1;
        bool3 = cvj.a(paramInt, bool1);
        if (paramInt != 19) {
          break label192;
        }
        j = 1;
        if (paramInt != 20) {
          break label198;
        }
        bool1 = true;
        bool4 = ac.as();
        if ((!bool4) || (k == 0) || ((m != buc.aJ) && (m != buc.fC) && (m != buc.ff) && (m != buc.cJ) && (m != buc.dU))) {
          break label204;
        }
        bool2 = true;
        label163:
        if (!ac.a(paramKeyEvent, bool2)) {
          break label210;
        }
      }
      label186:
      label192:
      label198:
      label204:
      label210:
      label299:
      label422:
      label426:
      label555:
      label583:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return true;
                  i = 0;
                  break;
                  k = 0;
                  break label73;
                  j = 0;
                  break label90;
                  bool1 = false;
                  break label99;
                  bool2 = false;
                  break label163;
                  if ((k != 0) || (bool3))
                  {
                    if ((!bool4) || ((m != buc.aJ) && (m != buc.fC) && (m != buc.ff) && (m != buc.cJ) && ((m != buc.df) || (!bool3)) && ((m != buc.dU) || (k == 0)) && ((m != buc.bH) || (!bool3)))) {
                      break label422;
                    }
                    k = 1;
                    if (k != 0) {
                      break label426;
                    }
                  }
                  if ((j == 0) && (!bool1)) {
                    break label555;
                  }
                } while (m == buc.aJ);
                paramView = A;
                paramKeyEvent = ad;
                HashSet localHashSet = new HashSet();
                e.a(new bwa(paramView, localHashSet));
                paramView = b.a(paramKeyEvent, bool1, localHashSet);
                if (paramView != null)
                {
                  paramKeyEvent = new int[2];
                  paramView.getLocationOnScreen(paramKeyEvent);
                  paramInt = paramKeyEvent[1] + paramView.getHeight();
                  if (paramInt > ae) {
                    B.scrollBy(0, paramInt - ae);
                  }
                  for (;;)
                  {
                    paramView.requestFocus();
                    return true;
                    k = 0;
                    break label299;
                    break;
                    if (paramKeyEvent[1] < af) {
                      B.scrollBy(0, paramKeyEvent[1] - af);
                    }
                  }
                }
              } while (i != 0);
              paramInt = B.getScrollY();
              if ((j != 0) && (paramInt > 0))
              {
                B.scrollBy(0, -Math.min(paramInt, 50));
                return true;
              }
            } while (!bool1);
            i = (int)(B.getContentHeight() * B.getScale());
            paramInt += B.getHeight();
          } while (paramInt >= i);
          B.scrollBy(0, Math.min(i - paramInt, 50));
          return true;
          if ((paramInt != 4) || (m == buc.aJ)) {
            break label583;
          }
        } while (i == 0);
        ah.requestFocus();
        return true;
        if ((paramInt != 66) || (m != buc.aJ)) {
          break label620;
        }
      } while (i == 0);
      B.scrollTo(0, 0);
      A.b();
      return true;
    }
    label620:
    return false;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((al) && (A.getWidth() != 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        al = false;
        A.removeOnLayoutChangeListener(this);
        paramView = i;
        if (paramView != null) {
          a(paramView);
        }
      }
      return;
    }
  }
  
  public void onLoaderReset(Loader<String> paramLoader) {}
  
  public void onPause()
  {
    cas localcas = av;
    localcas.b();
    if (l) {
      h.removeCallbacks(n);
    }
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException(44 + "unexpected permission requestId: " + paramInt);
    case 1: 
      a(false, paramArrayOfString, paramArrayOfInt);
    }
    label252:
    do
    {
      return;
      if ((!"android.permission.READ_CALENDAR".equals(paramArrayOfString[0])) && (!"android.permission.WRITE_CALENDAR".equals(paramArrayOfString[0])))
      {
        paramArrayOfString = String.valueOf(paramArrayOfString[0]);
        if (paramArrayOfString.length() != 0) {}
        for (paramArrayOfString = "unexpected permission: ".concat(paramArrayOfString);; paramArrayOfString = new String("unexpected permission: ")) {
          throw new IllegalStateException(paramArrayOfString);
        }
      }
      switch (paramInt)
      {
      default: 
        cvm.f(s, "Unknown request id: %d", new Object[] { Integer.valueOf(paramInt) });
        paramArrayOfString = null;
      }
      for (;;)
      {
        if (paramArrayOfInt[0] != 0) {
          break label252;
        }
        if (ar != null)
        {
          ar.a(paramInt);
          ar = null;
        }
        if (paramArrayOfString == null) {
          break;
        }
        bus.a(paramArrayOfString, "granted");
        return;
        paramArrayOfString = "calendar_show_agenda";
        continue;
        paramArrayOfString = "calendar_show_new_time_proposal";
        continue;
        paramArrayOfString = "calendar_accept_new_time_proposal";
      }
    } while (paramArrayOfString == null);
    bus.a(paramArrayOfString, "denied");
  }
  
  public void onResume()
  {
    super.onResume();
    cas localcas = av;
    if ((l) && (!m))
    {
      localcas.d();
      l = false;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("state-impressed-message-visual-elements", ak);
    paramBundle.putFloat(at, F());
    paramBundle.putParcelable("attachment_awaiting_permission", an);
    paramBundle.putParcelable("attachment_message_awaiting_permission", ao);
    cas localcas = av;
    if (b != null)
    {
      paramBundle.putParcelable("message", b);
      paramBundle.putLong("proposed_start_time", e);
      paramBundle.putLong("proposed_end_time", f);
      paramBundle.putBoolean("to_show_proposed_time_fallback", l);
      if (g != null) {
        paramBundle.putLong("calendar_in_millis", g.getTimeInMillis());
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (B != null) {
      B.onResume();
    }
  }
  
  public void onStop()
  {
    if (B != null) {
      B.onPause();
    }
    super.onStop();
  }
  
  public void p()
  {
    super.p();
    if (!r)
    {
      localObject = (bxn)A.findViewById(buc.aF);
      if (localObject != null) {
        ((bxn)localObject).a();
      }
    }
    if (!buo.b())
    {
      localObject = String.valueOf(ConversationViewFragment.class.getSimpleName());
      long l = d.b;
      new StringBuilder(String.valueOf(localObject).length() + 20).append((String)localObject).append(l);
    }
    Object localObject = ag.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bzl)((Iterator)localObject).next()).c();
    }
  }
  
  public final boolean q()
  {
    ConversationViewState localConversationViewState = m;
    Iterator localIterator = a.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Uri)localIterator.next();
      localObject = (ConversationViewState.MessageViewState)a.get(localObject);
      if ((localObject != null) && (d != 0))
      {
        i = 1;
        label71:
        if (i == 0) {
          break label106;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (f == null) || (!f.a(34359738368L))) {
        break label113;
      }
      return false;
      i = 0;
      break label71;
      label106:
      break;
    }
    label113:
    return super.q();
  }
  
  public final void r()
  {
    super.r();
    byw localbyw = i;
    if (localbyw != null) {
      a(localbyw);
    }
  }
  
  protected final void s()
  {
    Activity localActivity = b.g();
    byw localbyw = i;
    Map localMap = h;
    String str = d.a(e);
    if (localbyw != null)
    {
      cfs localcfs = new cfs(localActivity);
      btq localbtq = new btq(localActivity);
      if (!localbyw.moveToFirst()) {
        throw new IllegalStateException("trying to print without a conversation");
      }
      Object localObject = localbyw.b();
      localcfs.a(d, t.b);
      localObject = localActivity.getResources();
      do
      {
        cft.a(localActivity, (Resources)localObject, localbyw.a(), localMap, localcfs, localbtq);
      } while (localbyw.moveToNext());
      cft.a(localActivity, localcfs.a(true), str, bd, true);
    }
  }
  
  protected final void t()
  {
    Object localObject = H();
    if (localObject != null)
    {
      localObject = f;
      if (localObject != null) {
        cbk.c(getActivity(), f, (Message)localObject);
      }
    }
  }
  
  public final void t_()
  {
    if (b != null) {
      b.d().a(new ToastBarOperation(0, buc.dp, 0));
    }
  }
  
  protected final void u()
  {
    Object localObject = H();
    if (localObject != null)
    {
      localObject = f;
      if (localObject != null) {
        cbk.d(getActivity(), f, (Message)localObject);
      }
    }
  }
  
  public final void u_()
  {
    ar = null;
  }
  
  public final void v()
  {
    B.stopLoading();
    C();
    cmn localcmn = C;
    a.removeCallbacks(e);
    d.setVisibility(4);
    c = true;
    if (y != null) {
      y.cancel();
    }
    A.animate().cancel();
  }
  
  public cmg w()
  {
    return new cmg(this, f);
  }
  
  public void x()
  {
    D = ((ActionableToastBar)A.findViewById(buc.dd));
    ai = new cls(this);
  }
  
  public final void y()
  {
    G();
    z();
  }
  
  public final void z()
  {
    if ((b()) && (A()))
    {
      a(as);
      return;
    }
    B();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */