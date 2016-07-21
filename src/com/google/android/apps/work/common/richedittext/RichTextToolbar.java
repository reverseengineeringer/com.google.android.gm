package com.google.android.apps.work.common.richedittext;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ToggleButton;
import dcc;
import dce;
import dcf;
import dcg;
import dch;
import dci;
import dcj;
import dck;
import dcm;
import dcs;
import dct;
import dcu;
import dcv;
import dcw;
import dcx;
import dcy;
import dcz;
import ddb;

public class RichTextToolbar
  extends FrameLayout
  implements dcm
{
  public ToggleButton A;
  public boolean B = true;
  private ActionMode C;
  private final ViewTreeObserver.OnGlobalLayoutListener D = new dcs(this);
  private final ViewTreeObserver.OnScrollChangedListener E = new dct(this);
  private int F = 65535;
  private ToggleButton G;
  private ToggleButton H;
  private ToggleButton I;
  private ToggleButton J;
  private Button K;
  private final View.OnLongClickListener L = new dcu(this);
  private final View.OnClickListener M = new dcv(this);
  private final CompoundButton.OnCheckedChangeListener N = new dcw(this);
  private final RadioGroup.OnCheckedChangeListener O = new dcx(this);
  public Context a;
  public ddb b;
  public ViewGroup c;
  public PopupWindow d;
  public View e;
  public View f;
  public View g;
  public RadioGroup h;
  public RadioGroup i;
  public RadioGroup j;
  public View k;
  public Animator l;
  public Animator m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  public int w;
  public ToggleButton x;
  public ToggleButton y;
  public RadioGroup z;
  
  public RichTextToolbar(Context paramContext)
  {
    super(paramContext);
    if (!isInEditMode()) {
      a(paramContext);
    }
  }
  
  public RichTextToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
    if (!isInEditMode()) {
      a(paramContext);
    }
  }
  
  public RichTextToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode()) {
      a(paramContext);
    }
  }
  
  private final void a(int paramInt, Animator paramAnimator)
  {
    if (paramAnimator != null)
    {
      paramAnimator.setTarget(this);
      paramAnimator.addListener(new dcz(this, paramInt));
      paramAnimator.start();
      return;
    }
    setVisibility(paramInt);
  }
  
  private final void a(Context paramContext)
  {
    a = paramContext;
    Resources localResources = getResources();
    n = localResources.getColor(dce.i);
    o = localResources.getColor(dce.f);
    p = localResources.getColor(dce.h);
    q = localResources.getColor(dce.j);
    r = localResources.getColor(dce.g);
    s = localResources.getColor(dce.d);
    t = localResources.getColor(dce.a);
    u = localResources.getColor(dce.c);
    v = localResources.getColor(dce.e);
    w = localResources.getColor(dce.b);
    paramContext = LayoutInflater.from(paramContext);
    paramContext.inflate(dci.d, this, true);
    if (getBackground() == null) {
      setBackgroundDrawable(localResources.getDrawable(dcg.e));
    }
    c = ((ViewGroup)findViewById(dch.G));
    G = ((ToggleButton)findViewById(dch.g));
    H = ((ToggleButton)findViewById(dch.o));
    I = ((ToggleButton)findViewById(dch.s));
    J = ((ToggleButton)findViewById(dch.r));
    x = ((ToggleButton)findViewById(dch.l));
    y = ((ToggleButton)findViewById(dch.e));
    z = ((RadioGroup)findViewById(dch.y));
    A = ((ToggleButton)findViewById(dch.k));
    K = ((Button)findViewById(dch.q));
    e = paramContext.inflate(dci.c, this, false);
    f = paramContext.inflate(dci.a, this, false);
    g = paramContext.inflate(dci.b, this, false);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    e.measure(i1, i1);
    f.measure(i1, i1);
    g.measure(i1, i1);
    d = new PopupWindow();
    d.setBackgroundDrawable(localResources.getDrawable(dcg.d));
    d.setWindowLayoutMode(-2, -2);
    d.setOutsideTouchable(true);
    d.setTouchInterceptor(new dcy(this));
    h = ((RadioGroup)e.findViewById(dch.z));
    h.check(dch.j);
    i = ((RadioGroup)f.findViewById(dch.a));
    i.check(dch.F);
    j = ((RadioGroup)g.findViewById(dch.w));
    j.check(dch.v);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramContext = findViewById(dch.H);
      if (paramContext != null)
      {
        paramContext.setVisibility(8);
        c.getLayoutParams().height = ((int)localResources.getDimension(dcf.d));
      }
      setElevation(localResources.getDimension(dcf.c));
      d.setElevation(localResources.getDimension(dcf.a));
    }
    a(c);
    a(h);
    a(i);
    a(j);
    e();
  }
  
  private final void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, dck.ad, paramInt, 0);
    try
    {
      F = paramContext.getInteger(dck.ae, 65535);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private final void a(View paramView)
  {
    if (!(paramView instanceof ViewGroup))
    {
      paramView.setOnLongClickListener(L);
      if ((paramView instanceof ToggleButton)) {
        ((ToggleButton)paramView).setOnCheckedChangeListener(N);
      }
    }
    for (;;)
    {
      return;
      if ((((paramView instanceof Button)) && (!(paramView instanceof CompoundButton))) || ((paramView instanceof RadioButton)))
      {
        paramView.setOnClickListener(M);
        return;
        if ((paramView instanceof RadioGroup)) {
          ((RadioGroup)paramView).setOnCheckedChangeListener(O);
        }
        int i1 = 0;
        while (i1 < ((ViewGroup)paramView).getChildCount())
        {
          a(((ViewGroup)paramView).getChildAt(i1));
          i1 += 1;
        }
      }
    }
  }
  
  private final void a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      if ((F & paramInt) == 0)
      {
        paramView.setEnabled(false);
        paramView.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    paramView.setVisibility(0);
  }
  
  private final void a(RadioGroup paramRadioGroup, int paramInt)
  {
    boolean bool = B;
    B = false;
    if (paramRadioGroup == h) {
      if (paramInt == n) {
        paramRadioGroup.check(dch.p);
      }
    }
    for (;;)
    {
      B = bool;
      return;
      if (paramInt == o)
      {
        paramRadioGroup.check(dch.f);
      }
      else if (paramInt == p)
      {
        paramRadioGroup.check(dch.n);
      }
      else if (paramInt == q)
      {
        paramRadioGroup.check(dch.t);
      }
      else if (paramInt == r)
      {
        paramRadioGroup.check(dch.m);
      }
      else
      {
        paramRadioGroup.check(dch.j);
        continue;
        if (paramRadioGroup == i) {
          if (paramInt == s) {
            paramRadioGroup.check(dch.D);
          } else if (paramInt == t) {
            paramRadioGroup.check(dch.A);
          } else if (paramInt == u) {
            paramRadioGroup.check(dch.C);
          } else if (paramInt == v) {
            paramRadioGroup.check(dch.E);
          } else if (paramInt == w) {
            paramRadioGroup.check(dch.B);
          } else {
            paramRadioGroup.check(dch.F);
          }
        }
      }
    }
  }
  
  private final void e()
  {
    a(G, 1);
    a(H, 2);
    a(I, 4);
    a(J, 8);
    a(x, 16);
    a(y, 32);
    a(A, 64);
    a(findViewById(dch.c), 1024);
    a(findViewById(dch.b), 2048);
    a(findViewById(dch.d), 4096);
    a(findViewById(dch.h), 8192);
  }
  
  public final void a()
  {
    C = null;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    F = (paramInt1 & paramInt2 | F & (paramInt2 ^ 0xFFFFFFFF));
    e();
  }
  
  public final void a(ActionMode paramActionMode)
  {
    C = paramActionMode;
  }
  
  public final void a(ToggleButton paramToggleButton, int paramInt)
  {
    if (paramToggleButton == x) {
      if (paramInt == n) {
        paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.p));
      }
    }
    while (paramToggleButton != y)
    {
      return;
      if (paramInt == o)
      {
        paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.l));
        return;
      }
      if (paramInt == p)
      {
        paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.o));
        return;
      }
      if (paramInt == q)
      {
        paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.q));
        return;
      }
      if (paramInt == r)
      {
        paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.n));
        return;
      }
      paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.m));
      return;
    }
    if (paramInt == s)
    {
      paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.i));
      return;
    }
    if (paramInt == t)
    {
      paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.f));
      return;
    }
    if (paramInt == u)
    {
      paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.h));
      return;
    }
    if (paramInt == v)
    {
      paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.j));
      return;
    }
    if (paramInt == w)
    {
      paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.g));
      return;
    }
    paramToggleButton.setBackgroundDrawable(getResources().getDrawable(dcg.k));
  }
  
  public final void a(RichTextState paramRichTextState)
  {
    boolean bool1 = B;
    B = false;
    G.setChecked(a);
    H.setChecked(b);
    I.setChecked(c);
    J.setChecked(d);
    int i1 = g;
    a(h, i1);
    a(x, i1);
    i1 = h;
    a(i, i1);
    a(y, i1);
    boolean bool2;
    if (j)
    {
      z.check(dch.h);
      paramRichTextState = i;
      bool2 = B;
      B = false;
      if (!paramRichTextState.equalsIgnoreCase("sans-serif")) {
        break label257;
      }
      j.check(dch.v);
    }
    for (;;)
    {
      B = bool2;
      B = bool1;
      return;
      Layout.Alignment localAlignment = k;
      bool2 = B;
      B = false;
      switch (dda.a[localAlignment.ordinal()])
      {
      default: 
        z.check(dch.c);
      }
      for (;;)
      {
        B = bool2;
        break;
        z.check(dch.b);
        continue;
        z.check(dch.d);
      }
      label257:
      if (paramRichTextState.equalsIgnoreCase("serif")) {
        j.check(dch.x);
      } else if (paramRichTextState.equalsIgnoreCase("sans-serif-condensed")) {
        j.check(dch.u);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    G.setEnabled(paramBoolean);
    H.setEnabled(paramBoolean);
    I.setEnabled(paramBoolean);
    J.setEnabled(paramBoolean);
    x.setEnabled(paramBoolean);
    y.setEnabled(paramBoolean);
    K.setEnabled(paramBoolean);
    z.setEnabled(paramBoolean);
    int i1 = 0;
    while (i1 < z.getChildCount())
    {
      z.getChildAt(i1).setEnabled(paramBoolean);
      i1 += 1;
    }
    A.setEnabled(paramBoolean);
    if (!paramBoolean)
    {
      paramBoolean = B;
      B = false;
      G.setChecked(false);
      H.setChecked(false);
      I.setChecked(false);
      J.setChecked(false);
      x.setBackgroundDrawable(getResources().getDrawable(dcg.m));
      y.setBackgroundDrawable(getResources().getDrawable(dcg.k));
      z.clearCheck();
      h.clearCheck();
      i.clearCheck();
      j.clearCheck();
      B = paramBoolean;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      dcc.a(a, c, getResources().getText(dcj.k));
      a(0, l);
      return;
    }
    dcc.a(a, c, getResources().getText(dcj.e));
    d();
    a(8, m);
  }
  
  public final boolean b()
  {
    return isShown();
  }
  
  public final void c()
  {
    if (b != null) {
      b.A();
    }
  }
  
  public final void d()
  {
    int i1;
    Object localObject1;
    if (d.isShowing())
    {
      if (k == null) {
        break label249;
      }
      i1 = k.getId();
      if (dch.l == i1)
      {
        i1 = dcj.d;
        i2 = i1;
        if ((k instanceof ToggleButton))
        {
          localObject1 = (ToggleButton)k;
          i2 = i1;
          if (((ToggleButton)localObject1).isChecked()) {
            ((ToggleButton)localObject1).setChecked(false);
          }
        }
      }
    }
    label189:
    label244:
    label249:
    for (int i2 = i1;; i2 = -1)
    {
      if (i2 != -1) {
        dcc.a(a, d.getContentView(), getResources().getText(i2));
      }
      Object localObject2;
      if (k != null)
      {
        localObject2 = a;
        localObject1 = k;
        if (localObject1 == null)
        {
          throw new IllegalArgumentException("Must provide a view to focus");
          if (dch.e == i1)
          {
            i1 = dcj.b;
            break;
          }
          if (dch.k != i1) {
            break label244;
          }
          i1 = dcj.c;
          break;
        }
        if (Build.VERSION.SDK_INT < 16) {
          break label189;
        }
        ((View)localObject1).performAccessibilityAction(64, null);
      }
      for (;;)
      {
        k = null;
        d.dismiss();
        return;
        localObject2 = (AccessibilityManager)((Context)localObject2).getSystemService("accessibility");
        if ((localObject2 != null) && (((AccessibilityManager)localObject2).isEnabled()))
        {
          AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
          localAccessibilityEvent.setEventType(32768);
          localAccessibilityEvent.setSource((View)localObject1);
          ((AccessibilityManager)localObject2).sendAccessibilityEvent(localAccessibilityEvent);
        }
      }
      i1 = -1;
      break;
    }
  }
  
  public void onAttachedToWindow()
  {
    getViewTreeObserver().addOnGlobalLayoutListener(D);
    getViewTreeObserver().addOnScrollChangedListener(E);
  }
  
  public void onDetachedFromWindow()
  {
    if (Build.VERSION.SDK_INT < 16) {
      getViewTreeObserver().removeGlobalOnLayoutListener(D);
    }
    for (;;)
    {
      getViewTreeObserver().removeOnScrollChangedListener(E);
      return;
      getViewTreeObserver().removeOnGlobalLayoutListener(D);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (RichTextToolbar.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable != null) {
      b(a);
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    RichTextToolbar.SavedState localSavedState = new RichTextToolbar.SavedState(super.onSaveInstanceState());
    a = isShown();
    return localSavedState;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (C != null) {
      C.invalidate();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.work.common.richedittext.RichTextToolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */