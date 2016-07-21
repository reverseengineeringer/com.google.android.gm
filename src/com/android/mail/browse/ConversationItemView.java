package com.android.mail.browse;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.format.DateUtils;
import android.text.style.CharacterStyle;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bty;
import btz;
import bua;
import bub;
import bud;
import buj;
import buo;
import but;
import buu;
import buw;
import bva;
import bvi;
import bvs;
import bvt;
import bwg;
import bwy;
import bwz;
import bxa;
import bxb;
import bxc;
import bxd;
import bxe;
import bzn;
import bzt;
import cab;
import caf;
import cer;
import cez;
import cjo;
import ckv;
import clk;
import cni;
import cnj;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import com.android.mail.ui.ConversationCheckedSet;
import com.android.mail.ui.SwipeableListView;
import cqj;
import cqk;
import cqp;
import cqq;
import crj;
import cus;
import cvl;
import cvm;
import cwu;
import cxa;
import cxd;
import cxe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import jr;
import mx;
import np;
import nq;
import rg;
import xa;

public class ConversationItemView
  extends View
  implements bvt, caf, clk, cqj
{
  private static int j = 0;
  private static cez k;
  private static final String l = cvl.a;
  private static final Typeface m = Typeface.create("sans-serif", 1);
  private static final Typeface n = Typeface.create("sans-serif-light", 0);
  private static final int[] o = { 16842912 };
  private bxa A;
  private boolean B;
  private boolean C = false;
  private ConversationCheckedSet D;
  private Folder E;
  private float F = 1.0F;
  private final Account G;
  private ckv H;
  private final TextView I;
  private final TextView J;
  private final TextView K;
  private int L;
  private final buw M;
  private xa N;
  private boolean O;
  public final Context a;
  public final bzn b;
  public bxd c;
  public boolean d;
  public cqp e;
  public boolean f;
  public final Rect g = new Rect();
  public final Rect h = new Rect();
  final Rect i = new Rect();
  private final SparseArray<Drawable> p = new SparseArray();
  private int q = -1;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private final boolean x;
  private final boolean y;
  private bwz z;
  
  public ConversationItemView(Context paramContext, Account paramAccount, bzn parambzn)
  {
    super(paramContext);
    cxa.g("CIVC constructor");
    setClickable(true);
    setLongClickable(true);
    a = paramContext.getApplicationContext();
    paramContext = paramContext.getResources();
    x = cxa.a(paramContext);
    boolean bool;
    if (!paramContext.getBoolean(bty.c))
    {
      bool = true;
      y = bool;
      G = paramAccount;
      b = parambzn;
      paramAccount = Locale.getDefault();
      int i1 = np.a.a(paramAccount);
      I = new TextView(a);
      I.setIncludeFontPadding(false);
      J = new TextView(a);
      J.setEllipsize(TextUtils.TruncateAt.END);
      J.setIncludeFontPadding(false);
      rg.d(J, i1);
      cxe.b(J);
      K = new TextView(a);
      K.setEllipsize(TextUtils.TruncateAt.END);
      K.setIncludeFontPadding(false);
      K.setTypeface(n);
      K.setTextColor(getResources().getColor(btz.M));
      rg.d(K, i1);
      cxe.b(K);
      if ((cxd.b()) && (i1 != 1)) {
        break label375;
      }
      J.setMaxLines(1);
      K.setMaxLines(1);
    }
    for (;;)
    {
      M = new buw(paramContext, b.O);
      M.setCallback(this);
      N = new bxc(this);
      rg.a(this, N);
      cxa.a();
      return;
      bool = false;
      break;
      label375:
      J.setSingleLine();
      K.setSingleLine();
    }
  }
  
  public static ObjectAnimator a(boolean paramBoolean, cqq paramcqq, long paramLong, Object paramObject)
  {
    float f2 = 0.0F;
    int i1;
    float f1;
    if (paramcqq != null)
    {
      i1 = paramcqq.getMeasuredWidth();
      if (!paramBoolean) {
        break label76;
      }
      f1 = i1;
      label24:
      if (!paramBoolean) {
        break label82;
      }
    }
    for (;;)
    {
      paramcqq = ObjectAnimator.ofFloat(paramObject, "translationX", new float[] { f1, f2 });
      paramcqq.setInterpolator(new DecelerateInterpolator(2.0F));
      paramcqq.setDuration(paramLong);
      return paramcqq;
      i1 = 0;
      break;
      label76:
      f1 = 0.0F;
      break label24;
      label82:
      f2 = i1;
    }
  }
  
  private static SpannableString a(CharacterStyle[] paramArrayOfCharacterStyle, CharSequence paramCharSequence)
  {
    paramCharSequence = new SpannableString(paramCharSequence);
    if ((paramArrayOfCharacterStyle != null) && (paramArrayOfCharacterStyle.length > 0)) {
      paramCharSequence.setSpan(paramArrayOfCharacterStyle[0], 0, paramCharSequence.length(), 0);
    }
    return paramCharSequence;
  }
  
  private final SpannableStringBuilder a(List<SpannableString> paramList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject1;
    Object localObject2;
    float f1;
    if ((E != null) && (E.a(8192)) && (!paramList.isEmpty()))
    {
      localObject1 = bzt.a(b);
      localObject2 = (CharacterStyle[])((SpannableString)localObject1).getSpans(0, ((SpannableString)localObject1).length(), CharacterStyle.class);
      if (localObject2.length > 0) {
        localObject2[0].updateDrawState(b.P);
      }
      f1 = b.P.measureText(((SpannableString)localObject1).toString());
      localSpannableStringBuilder.append((CharSequence)localObject1);
      f1 += 0.0F;
    }
    for (int i1 = 1;; i1 = 0)
    {
      localObject2 = c.x;
      float f2 = f1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = (CharacterStyle[])((SpannableStringBuilder)localObject2).getSpans(0, ((SpannableStringBuilder)localObject2).length(), CharacterStyle.class);
        if (localObject1.length > 0) {
          localObject1[0].updateDrawState(b.P);
        }
        f2 = f1 + b.P.measureText(((SpannableStringBuilder)localObject2).toString());
      }
      Iterator localIterator = paramList.iterator();
      int i3 = 0;
      f1 = f2;
      paramList = null;
      int i2 = i1;
      i1 = i3;
      while (localIterator.hasNext())
      {
        localObject1 = (SpannableString)localIterator.next();
        if (localObject1 != null) {
          if (i1 == 0)
          {
            CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])((SpannableString)localObject1).getSpans(0, ((SpannableString)localObject1).length(), CharacterStyle.class);
            if (arrayOfCharacterStyle.length > 0) {
              arrayOfCharacterStyle[0].updateDrawState(b.P);
            }
            if (b.D.equals(((SpannableString)localObject1).toString()))
            {
              paramList = b.s;
              localObject1 = String.valueOf(localObject1);
              String str = b.s;
              paramList = a(arrayOfCharacterStyle, String.valueOf(paramList).length() + 0 + String.valueOf(localObject1).length() + String.valueOf(str).length() + paramList + (String)localObject1 + str);
              label386:
              if (arrayOfCharacterStyle.length > 0) {
                arrayOfCharacterStyle[0].updateDrawState(b.P);
              }
              f2 = (int)b.P.measureText(paramList.toString());
              if (f2 + f1 <= w) {
                break label610;
              }
              f2 = w;
              localObject1 = a(arrayOfCharacterStyle, TextUtils.ellipsize(paramList, b.P, f2 - f1, TextUtils.TruncateAt.END));
              f2 = (int)b.P.measureText(((SpannableString)localObject1).toString());
              i1 = 1;
              label486:
              if (localObject1 == null) {
                break label616;
              }
            }
            for (;;)
            {
              localSpannableStringBuilder.append((CharSequence)localObject1);
              f1 = f2 + f1;
              break;
              if ((i2 == 0) && (localSpannableStringBuilder.length() > 0) && ((paramList == null) || (!b.D.equals(paramList.toString()))))
              {
                paramList = b.r;
                localObject1 = String.valueOf(localObject1);
                paramList = a(arrayOfCharacterStyle, String.valueOf(paramList).length() + 0 + String.valueOf(localObject1).length() + paramList + (String)localObject1);
                break label386;
              }
              i2 = 0;
              paramList = (List<SpannableString>)localObject1;
              break label386;
              label610:
              localObject1 = null;
              break label486;
              label616:
              localObject1 = paramList;
            }
          }
        }
      }
      c.y = localSpannableStringBuilder.length();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localSpannableStringBuilder.append((CharSequence)localObject2);
      }
      return localSpannableStringBuilder;
      f1 = 0.0F;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = paramContext.getResources().getString(buj.bT);
    paramContext = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramContext = paramString;
      if (paramString.charAt(0) == '[')
      {
        int i1 = paramString.indexOf(']');
        paramContext = paramString;
        if (i1 > 0) {
          paramContext = String.format(str, new Object[] { cxa.a(paramString.substring(1, i1)), paramString.substring(i1 + 1) });
        }
      }
    }
    return paramContext;
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
    paramView.layout(0, 0, paramInt1, paramInt2);
  }
  
  private final void b(boolean paramBoolean)
  {
    C = paramBoolean;
    refreshDrawableState();
  }
  
  private final boolean b(float paramFloat)
  {
    return (d) && (paramFloat >= i.left) && (paramFloat < i.right);
  }
  
  private static void n()
  {
    if (k != null) {
      cez.a();
    }
  }
  
  private static void o()
  {
    if (k != null) {
      cez.b();
    }
  }
  
  private final void p()
  {
    if ((L != 1) || (TextUtils.isEmpty(c.A.a))) {
      return;
    }
    if ((z.M <= 0) || (z.L <= 0))
    {
      cvm.d(l, "Contact image width(%d) or height(%d) is 0", new Object[] { Integer.valueOf(z.M), Integer.valueOf(z.L) });
      return;
    }
    M.setBounds(0, 0, z.M, z.L);
    cxa.g("load sender image");
    bva localbva = M.a;
    localbva.a(z.M, z.L);
    bxe localbxe = c.A;
    localbva.a(b, a);
    e = c;
    cxa.a();
  }
  
  private final boolean q()
  {
    return (x) && (!y);
  }
  
  private final Bitmap r()
  {
    if (f)
    {
      if (c.s.l) {
        return b.d;
      }
      return b.c;
    }
    if (c.s.l) {
      return b.b;
    }
    return b.a;
  }
  
  private final int s()
  {
    if (cxe.a(this)) {
      return z.N - b.L;
    }
    return z.N + z.M + b.L;
  }
  
  public final int a()
  {
    return b.U;
  }
  
  public final ObjectAnimator a(boolean paramBoolean)
  {
    float f2 = 1.0F;
    float f1;
    if (paramBoolean)
    {
      f1 = 0.0F;
      if (!paramBoolean) {
        break label67;
      }
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "animatedHeightFraction", new float[] { f1, f2 });
      localObjectAnimator.setInterpolator(new DecelerateInterpolator(2.0F));
      localObjectAnimator.setDuration(b.M);
      return localObjectAnimator;
      f1 = 1.0F;
      break;
      label67:
      f2 = 0.0F;
    }
  }
  
  public final void a(Conversation paramConversation, ckv paramckv, ConversationCheckedSet paramConversationCheckedSet, Folder paramFolder, cqp paramcqp, boolean paramBoolean)
  {
    cxa.g("CIVC.bind");
    O = paramBoolean;
    bxd localbxd = bxd.a(G.c, paramConversation);
    int i1;
    label122:
    label228:
    label302:
    label349:
    label375:
    label408:
    label462:
    label503:
    int i4;
    label577:
    int i3;
    label596:
    int i2;
    if (c != null)
    {
      cxa.g("unbind");
      if (s.b != c.s.b)
      {
        i1 = 1;
        if ((i1 != 0) || (!c.B.equals(B)))
        {
          bva localbva = M.a;
          e = 0;
          localbva.a(null);
        }
        if (i1 != 0)
        {
          if (C) {
            break label723;
          }
          paramBoolean = true;
          M.a(paramBoolean);
        }
        cxa.a();
      }
    }
    else
    {
      z = null;
      c = localbxd;
      H = paramckv;
      paramConversation = H.n().a(s);
      if (paramConversation != null) {
        f = paramConversation.a(2147483648L);
      }
      D = paramConversationCheckedSet;
      if (D != null) {
        D.a(this);
      }
      E = paramFolder;
      if ((paramFolder == null) || (paramFolder.d(32))) {
        break label729;
      }
      paramBoolean = true;
      d = paramBoolean;
      e = paramcqp;
      cxa.g("drawables");
      M.a.b = e.q();
      M.a.c = e.r();
      cxa.a();
      if (!paramcqp.h()) {
        break label735;
      }
      L = 1;
      cxa.g("folder displayer");
      if (c.t != null) {
        break label743;
      }
      c.t = new bwy(a, b, e.k());
      cxa.a();
      if ((E == null) || (!E.d(8194))) {
        break label756;
      }
      i1 = 2;
      cxa.g("load folders");
      paramckv = c.t;
      paramConversationCheckedSet = c.s;
      if (E != null) {
        break label762;
      }
      paramConversation = cus.a;
      paramckv.a(paramConversationCheckedSet, paramConversation, i1);
      cxa.a();
      if (!c.g) {
        break label773;
      }
      cxa.g("relative time");
      c.f = DateUtils.getRelativeTimeSpanString(a, c.s.e);
      cxa.a();
      cxa.g("config setup");
      paramConversation = new bxa();
      b = L;
      A = paramConversation;
      if (t.c <= 0) {
        break label786;
      }
      i1 = 1;
      if (i1 != 0) {
        A.d = true;
      }
      if ((u) || (v)) {
        A.e = true;
      }
      c.h = null;
      i4 = c.s.p;
      if (c.s.i != 1) {
        break label792;
      }
      i1 = 1;
      if ((paramFolder == null) || (!paramFolder.d(8192))) {
        break label798;
      }
      i3 = 1;
      if ((!paramcqp.j()) || (i3 != 0)) {
        break label804;
      }
      i2 = 1;
      label614:
      if ((i1 == 0) || (!paramcqp.i()) || (i3 != 0)) {
        break label810;
      }
      i1 = 1;
      label637:
      if ((i2 == 0) || (i4 != 2)) {
        break label827;
      }
      paramckv = c;
      if (i1 == 0) {
        break label816;
      }
      paramConversation = b.j;
      label666:
      h = paramConversation;
    }
    for (;;)
    {
      if (c.h != null) {
        A.f = true;
      }
      A.g = c.s.m;
      cxa.a();
      requestLayout();
      cxa.a();
      return;
      i1 = 0;
      break;
      label723:
      paramBoolean = false;
      break label122;
      label729:
      paramBoolean = false;
      break label228;
      label735:
      L = 0;
      break label302;
      label743:
      c.t.b();
      break label349;
      label756:
      i1 = -1;
      break label375;
      label762:
      paramConversation = E.c;
      break label408;
      label773:
      c.f = "";
      break label462;
      label786:
      i1 = 0;
      break label503;
      label792:
      i1 = 0;
      break label577;
      label798:
      i3 = 0;
      break label596;
      label804:
      i2 = 0;
      break label614;
      label810:
      i1 = 0;
      break label637;
      label816:
      paramConversation = b.h;
      break label666;
      label827:
      if ((i2 != 0) && (i4 == 1))
      {
        paramckv = c;
        if (i1 != 0) {}
        for (paramConversation = b.k;; paramConversation = b.i)
        {
          h = paramConversation;
          break;
        }
      }
      if (i1 != 0) {
        c.h = b.l;
      }
    }
  }
  
  public final void a(ConversationCheckedSet paramConversationCheckedSet) {}
  
  public final boolean a(float paramFloat)
  {
    boolean bool = cxe.a(this);
    int i1 = s();
    float f1;
    if ((D == null) || (D.b()))
    {
      f1 = 0.0F;
      if (c.r != 1) {
        break label84;
      }
      if (!bool) {
        break label75;
      }
      if (paramFloat <= i1 - f1) {
        break label84;
      }
    }
    label75:
    while (paramFloat < f1 + i1)
    {
      return true;
      f1 = TypedValue.applyDimension(1, 16.0F, getResources().getDisplayMetrics());
      break;
    }
    label84:
    return false;
  }
  
  public final boolean a(String paramString)
  {
    boolean bool;
    Conversation localConversation;
    cqq localcqq;
    if ((c != null) && (c.s != null) && (D != null)) {
      if (!C)
      {
        bool = true;
        b(bool);
        localConversation = c.s;
        localcqq = j();
      }
    }
    try
    {
      if ((!C) || (localcqq == null)) {
        break label205;
      }
      i1 = localcqq.getPositionForView(this);
      label74:
      C = i1;
    }
    catch (NullPointerException localNullPointerException)
    {
      int i1;
      label94:
      label144:
      for (;;) {}
    }
    if (D.b())
    {
      if (paramString != null) {
        buo.a().a("enter_cab_mode", paramString, null, 0L);
      }
    }
    else
    {
      D.b(localConversation);
      if (D.b()) {
        localcqq.b(true);
      }
      if (C) {
        break label217;
      }
      bool = true;
      M.b(bool);
      requestLayout();
      paramString = a;
      if (!C) {
        break label222;
      }
    }
    label205:
    label217:
    label222:
    for (i1 = buj.dz;; i1 = buj.dy)
    {
      cxe.a(this, paramString.getString(i1, new Object[] { c.s.d }));
      return true;
      bool = false;
      break;
      i1 = -1;
      break label74;
      paramString = "checkbox";
      break label94;
      bool = false;
      break label144;
    }
    return false;
  }
  
  public final float b()
  {
    return b.V;
  }
  
  public final void b(ConversationCheckedSet paramConversationCheckedSet) {}
  
  public final CharSequence c()
  {
    if (c == null) {
      return null;
    }
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (c.t != null)
    {
      localObject3 = c.t;
      if ((e != null) && (!e.isEmpty()))
      {
        localObject1 = new StringBuilder();
        localObject2 = d.getString(buj.bL);
        localObject3 = e.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((StringBuilder)localObject1).append(nextd).append((String)localObject2);
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    for (;;)
    {
      c.z = null;
      localObject2 = c;
      localObject3 = a;
      bzn localbzn = b;
      if ((E != null) && (E.a(8192))) {}
      for (boolean bool = true;; bool = false)
      {
        return ((bxd)localObject2).a((Context)localObject3, localbzn, bool, (String)localObject1);
        localObject1 = null;
        break;
      }
      localObject1 = null;
    }
  }
  
  public final CharSequence d()
  {
    Context localContext = a;
    if (C) {}
    for (int i1 = buj.ay;; i1 = buj.az) {
      return localContext.getString(i1);
    }
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    return ((N != null) && (N.a(paramMotionEvent))) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public final boolean e()
  {
    return a(null);
  }
  
  public final void f()
  {
    M.b(true);
  }
  
  public final void g()
  {
    Object localObject = c.s;
    if (!c.s.l) {}
    for (boolean bool = true;; bool = false)
    {
      l = bool;
      localObject = r();
      int i1 = z.b;
      int i2 = z.c;
      int i3 = z.b;
      int i4 = ((Bitmap)localObject).getWidth();
      int i5 = z.c;
      postInvalidate(i1, i2, i3 + i4, ((Bitmap)localObject).getHeight() + i5);
      localObject = (bwg)e.getCursor();
      if (localObject != null)
      {
        Conversation localConversation = c.s;
        bool = c.s.l;
        ((bwg)localObject).a(Arrays.asList(new Conversation[] { localConversation }), "starred", bool);
      }
      return;
    }
  }
  
  public final boolean h()
  {
    return true;
  }
  
  public final void i()
  {
    cqq localcqq = j();
    if (localcqq != null) {
      localcqq.a(H, this);
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    int i2 = 0;
    int i1 = i2;
    if (z != null)
    {
      i1 = i2;
      if (M.equals(paramDrawable))
      {
        Rect localRect = new Rect(paramDrawable.getBounds());
        localRect.offset(z.N, z.O);
        invalidate(left, top, right, bottom);
        i1 = 1;
      }
    }
    if (i1 == 0) {
      super.invalidateDrawable(paramDrawable);
    }
  }
  
  public final cqq j()
  {
    Object localObject1 = getParent();
    if ((localObject1 == null) || (!(localObject1 instanceof View)))
    {
      localObject1 = null;
      if ((localObject1 == null) || (!(localObject1 instanceof cab))) {
        break label66;
      }
    }
    label66:
    for (localObject1 = (SwipeableListView)((cab)localObject1).getParent();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = e.z();
      }
      return (cqq)localObject2;
      localObject1 = (View)localObject1;
      break;
    }
  }
  
  public final void k()
  {
    cxa.g("reset");
    setAlpha(1.0F);
    setTranslationX(0.0F);
    setAnimatedHeightFraction(1.0F);
    cxa.a();
  }
  
  public final cqk l()
  {
    return cqk.a(this);
  }
  
  public final float m()
  {
    return b.J;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (C) {
      mergeDrawableStates(arrayOfInt, o);
    }
    return arrayOfInt;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (D != null) {
      D.b(this);
    }
    if (N != null)
    {
      setAccessibilityDelegate(null);
      N = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (z == null)
    {
      cvm.e(l, "null coordinates in ConversationItemView#onDraw", new Object[0]);
      return;
    }
    cxa.g("CIVC.draw");
    boolean bool1;
    label227:
    int i2;
    label320:
    Object localObject1;
    boolean bool2;
    Object localObject2;
    int i5;
    Object localObject4;
    int i7;
    int i8;
    if (L == 1)
    {
      paramCanvas.save();
      cxa.g("draw senders image");
      if (!M.g.isStarted())
      {
        if (!C)
        {
          bool1 = true;
          M.a(bool1);
        }
      }
      else
      {
        paramCanvas.translate(z.N, z.O);
        M.draw(paramCanvas);
        cxa.a();
        paramCanvas.restore();
      }
    }
    else
    {
      bool1 = c.e;
      paramCanvas.save();
      if (c.n == null) {
        break label740;
      }
      b.P.setTextSize(z.j);
      b.P.setTypeface(bzt.a(bool1));
      b.P.setColor(b.E);
      paramCanvas.translate(v, z.f + c.n.getTopPadding());
      c.n.draw(paramCanvas);
      paramCanvas.restore();
      b.P.setTypeface(Typeface.DEFAULT);
      paramCanvas.save();
      paramCanvas.translate(z.k, z.l);
      J.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.save();
      i1 = z.r - K.getWidth();
      i2 = z.p;
      if (!cxe.a(this)) {
        break label768;
      }
      paramCanvas.translate(i1 + i2, z.q);
      K.draw(paramCanvas);
      paramCanvas.restore();
      if (!A.d) {
        break label791;
      }
      localObject1 = c.t;
      Object localObject3 = z;
      bool2 = cxe.a(this);
      if (c == 0) {
        break label791;
      }
      localObject2 = bwy.a(e, v, u, f.f, f.e, a.T, a.Q);
      i1 = w;
      i5 = x;
      a.Q.setTextSize(z);
      a.Q.setTypeface(y);
      localObject4 = a.Q.getFontMetricsInt();
      int i6 = localObject2.length;
      i2 = ((bwy)localObject1).a((int[])localObject2);
      i7 = bottom;
      i8 = top;
      if (!bool2) {
        break label774;
      }
      i1 = p + i2;
      label544:
      localObject3 = e.iterator();
      i2 = 0;
      label559:
      if (!((Iterator)localObject3).hasNext()) {
        break label791;
      }
      localObject4 = (Folder)((Iterator)localObject3).next();
      if (i2 > i6 - 1) {
        break label791;
      }
      if (!bool2) {
        break label784;
      }
    }
    label740:
    label768:
    label774:
    label784:
    for (int i3 = i1 - localObject2[i2];; i3 = i1)
    {
      float f1 = i3;
      float f2 = i5;
      i3 = localObject2[i2];
      cnj localcnj = f;
      mx localmx = b;
      TextPaint localTextPaint = a.Q;
      cni.a(paramCanvas, f1, f2, i3, i7 - i8, d, ((Folder)localObject4).c(a), ((Folder)localObject4).b(b), localcnj, localmx, localTextPaint);
      int i4 = localObject2[i2] + f.f;
      i3 = i4;
      if (bool2) {
        i3 = -i4;
      }
      i2 += 1;
      i1 = i3 + i1;
      break label559;
      bool1 = false;
      break;
      paramCanvas.translate(v, z.f);
      I.draw(paramCanvas);
      break label227;
      i1 = 0;
      break label320;
      i1 -= i2;
      break label544;
    }
    label791:
    if (A.e)
    {
      if ((c.v) && (c.u)) {
        paramCanvas.drawBitmap(b.o, z.H, z.I, null);
      }
    }
    else
    {
      if (A.f) {
        paramCanvas.drawBitmap(c.h, z.J, z.K, null);
      }
      switch (c.s.m)
      {
      case 1: 
      default: 
        label924:
        b.P.setTextSize(z.B);
        localObject2 = b.P;
        if (bool1)
        {
          localObject1 = m;
          label960:
          ((TextPaint)localObject2).setTypeface((Typeface)localObject1);
          localObject1 = b.P;
          if (!bool1) {
            break label1497;
          }
          i1 = b.G;
          label991:
          ((TextPaint)localObject1).setColor(i1);
          localObject1 = c.f;
          i1 = s;
          i2 = z.C;
          localObject2 = b.P;
          paramCanvas.drawText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), i1, i2, (Paint)localObject2);
          if (!c.w) {
            break label1521;
          }
          b.p.setBounds(u, z.D, u + b.p.getIntrinsicWidth(), z.D + b.p.getIntrinsicHeight());
          localObject1 = b.p;
          if (!bool1) {
            break label1509;
          }
          i1 = b.I;
          label1140:
          ((Drawable)localObject1).setColorFilter(i1, PorterDuff.Mode.SRC_IN);
          b.p.draw(paramCanvas);
          label1161:
          if (d) {
            paramCanvas.drawBitmap(r(), z.b, z.c, b.P);
          }
          i1 = getHeight();
          paramCanvas.drawRect(0.0F, i1 - b.S, getWidth(), i1, b.R);
          localObject1 = j();
          if ((localObject1 != null) && (((cqq)localObject1).c(c.s)))
          {
            i2 = b.q.getIntrinsicWidth();
            bool1 = cxe.a(this);
            localObject1 = b.q;
            if (!bool1) {
              break label1568;
            }
          }
        }
        break;
      }
    }
    label1497:
    label1509:
    label1521:
    label1568:
    for (int i1 = getWidth() - i2;; i1 = 0)
    {
      if (bool1) {
        i2 = getWidth();
      }
      ((Drawable)localObject1).setBounds(i1, 0, i2, getHeight());
      b.q.draw(paramCanvas);
      cxa.a();
      return;
      if (c.v)
      {
        paramCanvas.drawBitmap(b.m, z.H, z.I, null);
        break;
      }
      if (!c.u) {
        break;
      }
      paramCanvas.drawBitmap(b.n, z.H, z.I, null);
      break;
      paramCanvas.drawBitmap(b.f, z.F, z.G, null);
      break label924;
      paramCanvas.drawBitmap(b.g, z.F, z.G, null);
      break label924;
      localObject1 = n;
      break label960;
      i1 = b.F;
      break label991;
      i1 = b.H;
      break label1140;
      if (!c.s.f) {
        break label1161;
      }
      paramCanvas.drawBitmap(b.e, u, z.D, b.P);
      break label1161;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    n();
    cxa.g("CIVC.layout");
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    cxa.g("text and bitmaps");
    n();
    if (D != null) {
      b(D.a(c.s));
    }
    c.r = L;
    setBackgroundResource(bub.c);
    Object localObject1 = c;
    boolean bool;
    label139:
    label214:
    label233:
    label240:
    Object localObject2;
    label322:
    label347:
    label375:
    label432:
    label455:
    label465:
    label597:
    Object localObject3;
    label679:
    label772:
    int i1;
    if (c.s.t.c > 0)
    {
      bool = true;
      o = bool;
      if (!c.k) {
        break label1306;
      }
      c.m = new SpannableStringBuilder(c.l);
      p();
      localObject1 = c;
      if (c != bxd.a(f, s.t, s.n.a, s.l, s.j, s.i, s.h)) {
        break label1574;
      }
      paramInt1 = 1;
      if ((paramInt1 == 0) || (d != ((bxd)localObject1).a())) {
        break label1579;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label1584;
      }
      o();
      cxa.a();
      cxa.g("coordinates");
      n();
      b.P.setTextSize(z.B);
      b.P.setTypeface(Typeface.DEFAULT);
      bool = cxe.a(this);
      localObject2 = b.P;
      if (c.f == null) {
        break label1602;
      }
      localObject1 = c.f.toString();
      t = ((int)((TextPaint)localObject2).measureText((String)localObject1));
      if (!bool) {
        break label1610;
      }
      paramInt1 = z.e;
      s = paramInt1;
      if (!bool) {
        break label1634;
      }
      paramInt1 = s + t + z.A;
      u = paramInt1;
      if ((!c.w) && (!c.s.f)) {
        break label1677;
      }
      if (!bool) {
        break label1661;
      }
      paramInt1 = u + b.e.getWidth() + z.E;
      if (!bool) {
        break label1706;
      }
      paramInt2 = z.g + z.e - paramInt1;
      w = paramInt2;
      if (!bool) {
        break label1719;
      }
      v = paramInt1;
      b.P.setTextSize(z.j);
      b.P.setTypeface(Typeface.DEFAULT);
      if (w < 0) {
        w = 0;
      }
      if (!c.k) {
        break label1730;
      }
      c.n = new StaticLayout(c.m, b.P, w, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      o();
      cxa.a();
      cxa.g("subject");
      bool = c.e;
      if (c.i != null) {
        break label1873;
      }
      localObject1 = "";
      localObject3 = a(getContext(), c.s.d);
      localObject2 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = e.k().a((String)localObject3);
      }
      localObject2 = Conversation.a(a, (String)localObject1, (String)localObject2);
      localObject3 = new SpannableString((CharSequence)localObject2);
      if (localObject1 == null) {
        break label1885;
      }
      paramInt1 = ((String)localObject1).length();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((Spannable)localObject3).setSpan(TextAppearanceSpan.wrap(b.Y), 0, paramInt1, 33);
        ((Spannable)localObject3).setSpan(TextAppearanceSpan.wrap(b.Z), 0, paramInt1, 33);
        ((Spannable)localObject3).setSpan(new bvs((Spanned)localObject3, this), 0, paramInt1, 33);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!bool) {
          break label1890;
        }
        localObject1 = b.W;
        ((Spannable)localObject3).setSpan(TextAppearanceSpan.wrap((CharacterStyle)localObject1), paramInt1, ((String)localObject2).length(), 33);
      }
      if ((isActivated()) && (q())) {
        ((Spannable)localObject3).setSpan(b.aa, paramInt1, ((Spannable)localObject3).length(), 18);
      }
      paramInt1 = z.m;
      paramInt2 = z.n;
      J.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
      J.setTextSize(0, z.o);
      a(J, paramInt1, paramInt2);
      J.setText((CharSequence)localObject3);
      localObject1 = new SpannableString(c.s.d());
      localObject2 = c.t;
      localObject3 = z;
      paramInt1 = ((bwy)localObject2).a(bwy.a(e, v, u, f.f, f.e, a.T, a.Q));
      paramInt1 = z.r - paramInt1;
      paramInt2 = z.s;
      K.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
      K.setTextSize(0, z.t);
      a(K, paramInt1, paramInt2);
      K.setText((CharSequence)localObject1);
      localObject1 = c;
      c = bxd.a(f, s.t, s.n.a, s.l, s.j, s.i, s.h);
      d = ((bxd)localObject1).a();
      cxa.a();
      o();
      if (k != null)
      {
        paramInt1 = j + 1;
        j = paramInt1;
        if (paramInt1 >= 50)
        {
          cez.c();
          k = new cez();
          j = 0;
        }
      }
      cxa.a();
      if ((paramBoolean) && (N != null)) {
        N.a();
      }
      paramInt1 = getHeight();
      paramInt2 = getWidth();
      if ((paramInt2 > 0) && (paramInt1 > 0))
      {
        paramBoolean = cxe.a(this);
        paramInt3 = s();
        if (!paramBoolean) {
          break label1902;
        }
        paramInt4 = z.b;
        i1 = z.d;
        int i2 = b.K;
        h.set(paramInt3, 0, paramInt2, paramInt1);
        i.set(0, 0, paramInt4 + i1 + i2, paramInt1);
      }
    }
    for (;;)
    {
      g.set(0, 0, paramInt2, paramInt1);
      return;
      bool = false;
      break;
      label1306:
      if (c.s.t != null)
      {
        localObject1 = getContext();
        c.x = bzt.a(b, c.s);
        bool = c.s.f;
        localObject1 = ((Context)localObject1).getResources();
        label1379:
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        bxe localbxe;
        Account localAccount;
        if (bool)
        {
          paramInt1 = ((Resources)localObject1).getInteger(bud.z);
          localObject1 = c.A;
          b = null;
          a = null;
          c = 0;
          c.B.clear();
          c.C.clear();
          localObject1 = b;
          localObject2 = c.s.t;
          localObject3 = c.x.toString();
          localArrayList1 = c.C;
          localArrayList2 = c.B;
          localbxe = c.A;
          localAccount = G;
          if ((E == null) || (!E.a(8192))) {
            break label1551;
          }
        }
        label1551:
        for (bool = true;; bool = false)
        {
          bzt.a((bzn)localObject1, (ConversationInfo)localObject2, (String)localObject3, paramInt1, localArrayList1, localArrayList2, localbxe, localAccount, bool);
          p();
          break;
          paramInt1 = ((Resources)localObject1).getInteger(bud.y);
          break label1379;
        }
      }
      cvm.f(l, "Null conversationInfo", new Object[0]);
      break label139;
      label1574:
      paramInt1 = 0;
      break label214;
      label1579:
      paramInt1 = 0;
      break label233;
      label1584:
      n();
      o();
      n();
      o();
      o();
      break label240;
      label1602:
      localObject1 = "";
      break label322;
      label1610:
      paramInt1 = z.e + z.g - t;
      break label347;
      label1634:
      paramInt1 = s - b.e.getWidth() - z.A;
      break label375;
      label1661:
      paramInt1 = u - z.E;
      break label432;
      label1677:
      if (bool) {}
      for (paramInt1 = u;; paramInt1 = s - z.A) {
        break;
      }
      label1706:
      paramInt2 = paramInt1 - z.e;
      break label455;
      label1719:
      paramInt1 = z.e;
      break label465;
      label1730:
      localObject1 = a(c.C);
      if ((isActivated()) && (q())) {
        ((SpannableStringBuilder)localObject1).setSpan(b.aa, 0, c.y, 33);
      }
      for (;;)
      {
        paramInt1 = w;
        paramInt2 = z.h;
        I.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
        I.setMaxLines(z.i);
        I.setTextSize(0, z.j);
        a(I, paramInt1, paramInt2);
        I.setText((CharSequence)localObject1);
        break;
        ((SpannableStringBuilder)localObject1).removeSpan(b.aa);
      }
      label1873:
      localObject1 = c.i;
      break label597;
      label1885:
      paramInt1 = 0;
      break label679;
      label1890:
      localObject1 = b.X;
      break label772;
      label1902:
      paramInt4 = z.b;
      i1 = b.K;
      h.set(0, 0, paramInt3, paramInt1);
      i.set(paramInt4 - i1, 0, paramInt2, paramInt1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    cxa.g("CIVC.measure");
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = H.v_().a;
    if ((paramInt1 != q) || (r != paramInt2))
    {
      q = paramInt1;
      r = paramInt2;
    }
    c.p = q;
    Object localObject = A;
    a = paramInt1;
    c = rg.g(this);
    localObject = getResources();
    c.q = ((Resources)localObject).getDimensionPixelOffset(bua.W);
    Context localContext = a;
    bxa localbxa = A;
    bxb localbxb = e.g();
    paramInt1 = Arrays.hashCode(new Object[] { Integer.valueOf(a), Integer.valueOf(b), Boolean.valueOf(d), Boolean.valueOf(e), Boolean.valueOf(f), Integer.valueOf(c), Integer.valueOf(g) });
    localObject = (bwz)a.get(paramInt1);
    if (localObject != null)
    {
      z = ((bwz)localObject);
      if (F == 1.0F) {
        break label299;
      }
    }
    label299:
    for (paramInt1 = Math.round(F * z.a);; paramInt1 = z.a)
    {
      setMeasuredDimension(A.a, paramInt1);
      cxa.a();
      return;
      localObject = new bwz(localContext, localbxa, localbxb);
      a.put(paramInt1, localObject);
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (O) {
      return true;
    }
    cxa.g("on touch event");
    int i1 = (int)paramMotionEvent.getX();
    switch (paramMotionEvent.getAction())
    {
    }
    boolean bool1;
    do
    {
      bool1 = false;
      for (;;)
      {
        boolean bool2 = bool1;
        if (!bool1)
        {
          bool2 = super.onTouchEvent(paramMotionEvent);
          if (paramMotionEvent.getAction() == 0) {
            bool2 = true;
          }
        }
        cxa.a();
        return bool2;
        if ((z == null) || ((!a(i1)) && (!b(i1)))) {
          break;
        }
        B = true;
        bool1 = true;
        continue;
        B = false;
        bool1 = false;
      }
    } while ((!B) || (z == null));
    if (a(i1)) {
      a(null);
    }
    while (!b(i1))
    {
      B = false;
      bool1 = true;
      break;
    }
    g();
    if (f) {}
    for (String str = "flag_";; str = "star_")
    {
      cer.a(str, "civ", c.s.l);
      break;
    }
  }
  
  public boolean performClick()
  {
    boolean bool1;
    if (O) {
      bool1 = false;
    }
    boolean bool2;
    cqq localcqq;
    do
    {
      do
      {
        do
        {
          return bool1;
          bool2 = super.performClick();
          localcqq = j();
          bool1 = bool2;
        } while (bool2);
        bool1 = bool2;
      } while (localcqq == null);
      bool1 = bool2;
    } while (localcqq.m() == null);
    localcqq.performItemClick(this, localcqq.a(this, c.s), c.s.b);
    return bool2;
  }
  
  public void setAnimatedHeightFraction(float paramFloat)
  {
    F = paramFloat;
    requestLayout();
  }
  
  public void setBackgroundResource(int paramInt)
  {
    cxa.g("set background resource");
    Drawable localDrawable = (Drawable)p.get(paramInt);
    Object localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = jr.a(getContext(), paramInt);
      int i1 = c.j;
      if (i1 <= 0) {
        break label84;
      }
      localObject = new InsetDrawable((Drawable)localObject, i1);
    }
    label84:
    for (;;)
    {
      p.put(paramInt, localObject);
      if (getBackground() != localObject) {
        super.setBackgroundDrawable((Drawable)localObject);
      }
      cxa.a();
      return;
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      cqq localcqq = j();
      if (localcqq != null) {
        localcqq.b(c.s);
      }
    }
    super.setSelected(paramBoolean);
  }
  
  public void setTranslationX(float paramFloat)
  {
    super.setTranslationX(paramFloat);
    View localView = (View)getParent();
    if (localView == null) {
      cvm.d(l, "CIV.setTranslationX null ConversationItemView parent x=%s", new Object[] { Float.valueOf(paramFloat) });
    }
    Object localObject1;
    int i2;
    if ((localView instanceof cab))
    {
      if (paramFloat == 0.0F) {
        break label218;
      }
      localObject1 = j();
      Object localObject2 = c.s;
      if (!((cqq)localObject1).d((Conversation)localObject2)) {
        break label207;
      }
      i1 = ((cqq)localObject1).a((Conversation)localObject2);
      i2 = cwu.a(i1);
      if (!((cqq)localObject1).e((Conversation)localObject2))
      {
        localObject1 = (cab)localView;
        a.setVisibility(0);
        a.setImageResource(cwu.b(i1));
        if (paramFloat <= 0.0F) {
          break label202;
        }
        i1 = 3;
        i1 |= 0x10;
        if (i1 != c)
        {
          localObject2 = (FrameLayout.LayoutParams)a.getLayoutParams();
          c = i1;
          gravity = i1;
          a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
    }
    label202:
    label207:
    for (int i1 = i2;; i1 = ((cqq)localObject1).n())
    {
      localView.setBackgroundResource(i1);
      return;
      i1 = 5;
      break;
    }
    label218:
    localView.setBackgroundResource(0);
    ((cab)localView).a();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */