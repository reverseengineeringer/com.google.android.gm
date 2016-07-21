package android.support.v7.app;

import aai;
import aak;
import aas;
import aat;
import aau;
import aav;
import aaw;
import aay;
import aaz;
import aba;
import abc;
import abe;
import abg;
import abj;
import abt;
import aca;
import acc;
import acf;
import ach;
import acj;
import ack;
import acz;
import ada;
import adc;
import add;
import ads;
import adu;
import adv;
import age;
import agg;
import agh;
import ago;
import agp;
import agr;
import ags;
import agw;
import agx;
import agz;
import ahi;
import ahv;
import aik;
import amm;
import ana;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import ane;
import gs;
import pq;
import pr;
import pz;
import rg;
import rz;
import tg;
import xl;
import zc;

public class AppCompatDelegateImplV7
  extends aak
  implements adv, pz
{
  private boolean A;
  private ViewGroup B;
  private TextView C;
  private View D;
  private boolean E;
  private boolean F;
  private boolean G;
  private AppCompatDelegateImplV7.PanelFeatureState[] H;
  private AppCompatDelegateImplV7.PanelFeatureState I;
  private boolean J;
  private final Runnable K = new aas(this);
  private boolean L;
  private Rect M;
  private Rect N;
  private abg O;
  private aaz q;
  public ahv r;
  public acz s;
  public ActionBarContextView t;
  public PopupWindow u;
  public Runnable v;
  public tg w = null;
  public boolean x;
  public int y;
  private abe z;
  
  public AppCompatDelegateImplV7(Context paramContext, Window paramWindow, aai paramaai)
  {
    super(paramContext, paramWindow, paramaai);
  }
  
  private final boolean a(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.isSystem()) {}
    while (((!m) && (!a(paramPanelFeatureState, paramKeyEvent))) || (j == null)) {
      return false;
    }
    return j.performShortcut(paramInt, paramKeyEvent, 1);
  }
  
  private final void b(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    int k = -1;
    if ((o) || (p)) {}
    Object localObject1;
    int i;
    label115:
    label120:
    label124:
    label126:
    Object localObject2;
    label266:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (a == 0)
          {
            localObject1 = c;
            if ((getResourcesgetConfigurationscreenLayout & 0xF) != 4) {
              break label115;
            }
            i = 1;
            if (getApplicationInfotargetSdkVersion < 11) {
              break label120;
            }
          }
          for (int j = 1;; j = 0)
          {
            if ((i != 0) && (j != 0)) {
              break label124;
            }
            localObject1 = d.getCallback();
            if ((localObject1 == null) || (((Window.Callback)localObject1).onMenuOpened(a, j))) {
              break label126;
            }
            a(paramPanelFeatureState, true);
            return;
            i = 0;
            break;
          }
        }
        localObject1 = (WindowManager)c.getSystemService("window");
      } while ((localObject1 == null) || (!a(paramPanelFeatureState, paramKeyEvent)));
      if ((g != null) && (!q)) {
        break label757;
      }
      if (g != null) {
        break label581;
      }
      localObject2 = l();
      TypedValue localTypedValue = new TypedValue();
      paramKeyEvent = ((Context)localObject2).getResources().newTheme();
      paramKeyEvent.setTo(((Context)localObject2).getTheme());
      paramKeyEvent.resolveAttribute(aca.a, localTypedValue, true);
      if (resourceId != 0) {
        paramKeyEvent.applyStyle(resourceId, true);
      }
      paramKeyEvent.resolveAttribute(aca.G, localTypedValue, true);
      if (resourceId == 0) {
        break;
      }
      paramKeyEvent.applyStyle(resourceId, true);
      localObject2 = new adc((Context)localObject2, 0);
      ((Context)localObject2).getTheme().setTo(paramKeyEvent);
      l = ((Context)localObject2);
      paramKeyEvent = ((Context)localObject2).obtainStyledAttributes(ack.V);
      b = paramKeyEvent.getResourceId(ack.Y, 0);
      f = paramKeyEvent.getResourceId(ack.W, 0);
      paramKeyEvent.recycle();
      g = new abc(this, l);
      c = 81;
    } while (g == null);
    label359:
    if (i != null)
    {
      h = i;
      i = 1;
      label376:
      if (i == 0) {
        break label730;
      }
      if (h == null) {
        break label752;
      }
      if (i == null) {
        break label732;
      }
      i = 1;
      label396:
      if (i == 0) {
        break label755;
      }
      paramKeyEvent = h.getLayoutParams();
      if (paramKeyEvent != null) {
        break label793;
      }
      paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
    }
    label581:
    label727:
    label730:
    label732:
    label752:
    label755:
    label757:
    label793:
    for (;;)
    {
      i = b;
      g.setBackgroundResource(i);
      localObject2 = h.getParent();
      if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
        ((ViewGroup)localObject2).removeView(h);
      }
      g.addView(h, paramKeyEvent);
      if (!h.hasFocus()) {
        h.requestFocus();
      }
      i = -2;
      for (;;)
      {
        n = false;
        paramKeyEvent = new WindowManager.LayoutParams(i, -2, d, e, 1002, 8519680, -3);
        gravity = c;
        windowAnimations = f;
        ((WindowManager)localObject1).addView(g, paramKeyEvent);
        o = true;
        return;
        paramKeyEvent.applyStyle(acj.b, true);
        break label266;
        if ((!q) || (g.getChildCount() <= 0)) {
          break label359;
        }
        g.removeAllViews();
        break label359;
        if (j != null)
        {
          if (z == null) {
            z = new abe(this);
          }
          paramKeyEvent = z;
          if (j == null) {}
          for (paramKeyEvent = null;; paramKeyEvent = k.a(g))
          {
            h = ((View)paramKeyEvent);
            if (h == null) {
              break label727;
            }
            i = 1;
            break;
            if (k == null)
            {
              k = new ads(l, ach.k);
              k.h = paramKeyEvent;
              j.a(k);
            }
          }
        }
        i = 0;
        break label376;
        break;
        if (k.c().getCount() > 0)
        {
          i = 1;
          break label396;
        }
        i = 0;
        break label396;
        break;
        if (i != null)
        {
          paramKeyEvent = i.getLayoutParams();
          if (paramKeyEvent != null)
          {
            i = k;
            if (width == -1) {
              continue;
            }
          }
        }
        i = -2;
      }
    }
  }
  
  private final void f(int paramInt)
  {
    y |= 1 << paramInt;
    if (!x)
    {
      rg.a(d.getDecorView(), K);
      x = true;
    }
  }
  
  private final void n()
  {
    Object localObject1;
    if (!A)
    {
      localObject1 = c.obtainStyledAttributes(ack.V);
      if (!((TypedArray)localObject1).hasValue(ack.Z))
      {
        ((TypedArray)localObject1).recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      }
      if (((TypedArray)localObject1).getBoolean(ack.ai, false))
      {
        c(1);
        if (((TypedArray)localObject1).getBoolean(ack.aa, false)) {
          c(109);
        }
        if (((TypedArray)localObject1).getBoolean(ack.ab, false)) {
          c(10);
        }
        this.m = ((TypedArray)localObject1).getBoolean(ack.X, false);
        ((TypedArray)localObject1).recycle();
        d.getDecorView();
        localObject1 = LayoutInflater.from(c);
        if (n) {
          break label459;
        }
        if (!this.m) {
          break label288;
        }
        localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(ach.g, null);
        this.k = false;
        this.j = false;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.j + ", windowActionBarOverlay: " + this.k + ", android:windowIsFloating: " + this.m + ", windowActionModeOverlay: " + l + ", windowNoTitle: " + n + " }");
        if (!((TypedArray)localObject1).getBoolean(ack.Z, false)) {
          break;
        }
        c(108);
        break;
        label288:
        if (!this.j) {
          break label1134;
        }
        localObject1 = new TypedValue();
        c.getTheme().resolveAttribute(aca.g, (TypedValue)localObject1, true);
        if (resourceId != 0) {}
        for (localObject1 = new adc(c, resourceId);; localObject1 = c)
        {
          localObject1 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(ach.p, null);
          r = ((ahv)((ViewGroup)localObject1).findViewById(acf.p));
          r.a(d.getCallback());
          if (this.k) {
            r.a(109);
          }
          if (E) {
            r.a(2);
          }
          if (F) {
            r.a(5);
          }
          break;
        }
        label459:
        if (l) {}
        for (localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(ach.o, null);; localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(ach.n, null))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label521;
          }
          rg.a((View)localObject1, new aat(this));
          break;
        }
        label521:
        ((aik)localObject1).a(new aau(this));
        continue;
      }
      if (r == null) {
        C = ((TextView)((ViewGroup)localObject1).findViewById(acf.D));
      }
      ane.b((View)localObject1);
      Object localObject2 = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(acf.b);
      ViewGroup localViewGroup = (ViewGroup)d.findViewById(16908290);
      if (localViewGroup != null)
      {
        while (localViewGroup.getChildCount() > 0)
        {
          View localView = localViewGroup.getChildAt(0);
          localViewGroup.removeViewAt(0);
          ((ContentFrameLayout)localObject2).addView(localView);
        }
        localViewGroup.setId(-1);
        ((ContentFrameLayout)localObject2).setId(16908290);
        if ((localViewGroup instanceof FrameLayout)) {
          ((FrameLayout)localViewGroup).setForeground(null);
        }
      }
      d.setContentView((View)localObject1);
      i = new aav(this);
      B = ((ViewGroup)localObject1);
      if ((e instanceof Activity)) {}
      for (localObject1 = ((Activity)e).getTitle();; localObject1 = o)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          b((CharSequence)localObject1);
        }
        localObject1 = (ContentFrameLayout)B.findViewById(16908290);
        localObject2 = d.getDecorView();
        int i = ((View)localObject2).getPaddingLeft();
        int j = ((View)localObject2).getPaddingTop();
        int k = ((View)localObject2).getPaddingRight();
        int m = ((View)localObject2).getPaddingBottom();
        h.set(i, j, k, m);
        if (rg.w((View)localObject1)) {
          ((ContentFrameLayout)localObject1).requestLayout();
        }
        localObject2 = c.obtainStyledAttributes(ack.V);
        i = ack.ag;
        if (b == null) {
          b = new TypedValue();
        }
        ((TypedArray)localObject2).getValue(i, b);
        i = ack.ah;
        if (c == null) {
          c = new TypedValue();
        }
        ((TypedArray)localObject2).getValue(i, c);
        if (((TypedArray)localObject2).hasValue(ack.ae))
        {
          i = ack.ae;
          if (d == null) {
            d = new TypedValue();
          }
          ((TypedArray)localObject2).getValue(i, d);
        }
        if (((TypedArray)localObject2).hasValue(ack.af))
        {
          i = ack.af;
          if (e == null) {
            e = new TypedValue();
          }
          ((TypedArray)localObject2).getValue(i, e);
        }
        if (((TypedArray)localObject2).hasValue(ack.ac))
        {
          i = ack.ac;
          if (f == null) {
            f = new TypedValue();
          }
          ((TypedArray)localObject2).getValue(i, f);
        }
        if (((TypedArray)localObject2).hasValue(ack.ad))
        {
          i = ack.ad;
          if (g == null) {
            g = new TypedValue();
          }
          ((TypedArray)localObject2).getValue(i, g);
        }
        ((TypedArray)localObject2).recycle();
        ((ContentFrameLayout)localObject1).requestLayout();
        A = true;
        localObject1 = g(0);
        if ((!p) && ((localObject1 == null) || (j == null))) {
          f(108);
        }
        return;
      }
      label1134:
      localObject1 = null;
    }
  }
  
  private final void o()
  {
    if (A) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  public final acz a(ada paramada)
  {
    if (paramada == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (s != null) {
      s.c();
    }
    aba localaba1 = new aba(this, paramada);
    paramada = a();
    if (paramada != null)
    {
      s = paramada.a(localaba1);
      if ((s != null) && (g != null)) {
        g.a(s);
      }
    }
    label338:
    boolean bool;
    if (s == null)
    {
      m();
      if (s != null) {
        s.c();
      }
      aba localaba2 = new aba(this, localaba1);
      Object localObject;
      if (t == null)
      {
        if (!m) {
          break label534;
        }
        localObject = new TypedValue();
        paramada = c.getTheme();
        paramada.resolveAttribute(aca.g, (TypedValue)localObject, true);
        if (resourceId == 0) {
          break label526;
        }
        Resources.Theme localTheme = c.getResources().newTheme();
        localTheme.setTo(paramada);
        localTheme.applyStyle(resourceId, true);
        paramada = new adc(c, 0);
        paramada.getTheme().setTo(localTheme);
        t = new ActionBarContextView(paramada);
        u = new PopupWindow(paramada, null, aca.j);
        xl.a(u, 2);
        u.setContentView(t);
        u.setWidth(-1);
        paramada.getTheme().resolveAttribute(aca.b, (TypedValue)localObject, true);
        int i = TypedValue.complexToDimensionPixelSize(data, paramada.getResources().getDisplayMetrics());
        t.e = i;
        u.setHeight(-2);
        v = new aaw(this);
      }
      if (t != null)
      {
        m();
        t.b();
        paramada = t.getContext();
        localObject = t;
        if (u != null) {
          break label577;
        }
        bool = true;
        label379:
        paramada = new add(paramada, (ActionBarContextView)localObject, localaba2, bool);
        if (!localaba1.a(paramada, paramada.b())) {
          break label582;
        }
        paramada.d();
        t.a(paramada);
        s = paramada;
        rg.c(t, 0.0F);
        w = rg.q(t).a(1.0F);
        w.a(new aay(this));
        if (u != null) {
          d.getDecorView().post(v);
        }
      }
    }
    for (;;)
    {
      if ((s != null) && (g != null)) {
        g.a(s);
      }
      s = s;
      return s;
      label526:
      paramada = c;
      break;
      label534:
      paramada = (ViewStubCompat)B.findViewById(acf.h);
      if (paramada == null) {
        break label338;
      }
      a = LayoutInflater.from(l());
      t = ((ActionBarContextView)paramada.a());
      break label338;
      label577:
      bool = false;
      break label379;
      label582:
      s = null;
    }
  }
  
  public final AppCompatDelegateImplV7.PanelFeatureState a(Menu paramMenu)
  {
    AppCompatDelegateImplV7.PanelFeatureState[] arrayOfPanelFeatureState = H;
    int i;
    int j;
    if (arrayOfPanelFeatureState != null)
    {
      i = arrayOfPanelFeatureState.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label57;
      }
      AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = arrayOfPanelFeatureState[j];
      if ((localPanelFeatureState != null) && (j == paramMenu))
      {
        return localPanelFeatureState;
        i = 0;
        break;
      }
      j += 1;
    }
    label57:
    return null;
  }
  
  public final View a(int paramInt)
  {
    n();
    return d.findViewById(paramInt);
  }
  
  public final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    int j = 0;
    Object localObject1 = a(paramString, paramContext, paramAttributeSet);
    if (localObject1 != null)
    {
      paramString = (String)localObject1;
      return paramString;
    }
    boolean bool1;
    label34:
    int i;
    label79:
    Object localObject2;
    boolean bool2;
    if (Build.VERSION.SDK_INT < 21)
    {
      bool1 = true;
      if (O == null) {
        O = new abg();
      }
      if (!bool1) {
        break label425;
      }
      localObject1 = (ViewParent)paramView;
      if (localObject1 != null) {
        break label361;
      }
      i = 0;
      if (i == 0) {
        break label425;
      }
      i = 1;
      localObject2 = O;
      bool2 = ana.a();
      if ((i == 0) || (paramView == null)) {
        break label845;
      }
    }
    label248:
    label251:
    label320:
    label361:
    label425:
    label845:
    for (paramView = paramView.getContext();; paramView = paramContext)
    {
      paramView = abg.a(paramView, paramAttributeSet, bool1, true);
      localObject1 = paramView;
      if (bool2) {
        localObject1 = amm.a(paramView);
      }
      paramView = null;
      switch (paramString.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          if ((paramView == null) && (paramContext != localObject1)) {
            paramView = ((abg)localObject2).a((Context)localObject1, paramString, paramAttributeSet);
          }
          break;
        }
        break;
      }
      for (;;)
      {
        paramString = paramView;
        if (paramView == null) {
          break;
        }
        abg.a(paramView, paramAttributeSet);
        return paramView;
        bool1 = false;
        break label34;
        localObject2 = d.getDecorView();
        for (;;)
        {
          if (localObject1 == null)
          {
            i = 1;
            break;
          }
          if ((localObject1 == localObject2) || (!(localObject1 instanceof View)) || (rg.y((View)localObject1)))
          {
            i = 0;
            break;
          }
          localObject1 = ((ViewParent)localObject1).getParent();
        }
        i = 0;
        break label79;
        if (!paramString.equals("TextView")) {
          break label248;
        }
        i = j;
        break label251;
        if (!paramString.equals("ImageView")) {
          break label248;
        }
        i = 1;
        break label251;
        if (!paramString.equals("Button")) {
          break label248;
        }
        i = 2;
        break label251;
        if (!paramString.equals("EditText")) {
          break label248;
        }
        i = 3;
        break label251;
        if (!paramString.equals("Spinner")) {
          break label248;
        }
        i = 4;
        break label251;
        if (!paramString.equals("ImageButton")) {
          break label248;
        }
        i = 5;
        break label251;
        if (!paramString.equals("CheckBox")) {
          break label248;
        }
        i = 6;
        break label251;
        if (!paramString.equals("RadioButton")) {
          break label248;
        }
        i = 7;
        break label251;
        if (!paramString.equals("CheckedTextView")) {
          break label248;
        }
        i = 8;
        break label251;
        if (!paramString.equals("AutoCompleteTextView")) {
          break label248;
        }
        i = 9;
        break label251;
        if (!paramString.equals("MultiAutoCompleteTextView")) {
          break label248;
        }
        i = 10;
        break label251;
        if (!paramString.equals("RatingBar")) {
          break label248;
        }
        i = 11;
        break label251;
        if (!paramString.equals("SeekBar")) {
          break label248;
        }
        i = 12;
        break label251;
        paramView = new ahi((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new agr((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new agg((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new ago((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new agz((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new agp((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatCheckBox((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new AppCompatRadioButton((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new agh((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new age((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new ags((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new agw((Context)localObject1, paramAttributeSet);
        break label320;
        paramView = new agx((Context)localObject1, paramAttributeSet);
        break label320;
      }
    }
  }
  
  public View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((e instanceof LayoutInflater.Factory))
    {
      paramString = ((LayoutInflater.Factory)e).onCreateView(paramString, paramContext, paramAttributeSet);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  public final void a(int paramInt, AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, Menu paramMenu)
  {
    Object localObject1 = paramPanelFeatureState;
    Object localObject2 = paramMenu;
    if (paramMenu == null)
    {
      AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = paramPanelFeatureState;
      if (paramPanelFeatureState == null)
      {
        localPanelFeatureState = paramPanelFeatureState;
        if (paramInt >= 0)
        {
          localPanelFeatureState = paramPanelFeatureState;
          if (paramInt < H.length) {
            localPanelFeatureState = H[paramInt];
          }
        }
      }
      localObject1 = localPanelFeatureState;
      localObject2 = paramMenu;
      if (localPanelFeatureState != null)
      {
        localObject2 = j;
        localObject1 = localPanelFeatureState;
      }
    }
    if ((localObject1 != null) && (!o)) {}
    while (p) {
      return;
    }
    e.onPanelClosed(paramInt, (Menu)localObject2);
  }
  
  public final void a(adu paramadu)
  {
    if ((r != null) && (r.d()) && ((!rz.a(ViewConfiguration.get(c))) || (r.f())))
    {
      paramadu = d.getCallback();
      if (!r.e()) {
        if ((paramadu != null) && (!p))
        {
          if ((x) && ((y & 0x1) != 0))
          {
            d.getDecorView().removeCallbacks(K);
            K.run();
          }
          AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = g(0);
          if ((j != null) && (!r) && (paramadu.onPreparePanel(0, i, j)))
          {
            paramadu.onMenuOpened(108, j);
            r.g();
          }
        }
      }
      do
      {
        return;
        r.h();
      } while (p);
      paramadu.onPanelClosed(108, g0j);
      return;
    }
    paramadu = g(0);
    q = true;
    a(paramadu, false);
    b(paramadu, null);
  }
  
  public final void a(Configuration paramConfiguration)
  {
    if ((j) && (A))
    {
      zc localzc = a();
      if (localzc != null) {
        localzc.a(paramConfiguration);
      }
    }
    j();
  }
  
  public void a(Bundle paramBundle)
  {
    if (((e instanceof Activity)) && (gs.b((Activity)e) != null))
    {
      paramBundle = h;
      if (paramBundle == null) {
        L = true;
      }
    }
    else
    {
      return;
    }
    paramBundle.c(true);
  }
  
  public final void a(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, boolean paramBoolean)
  {
    if ((paramBoolean) && (a == 0) && (r != null) && (r.e())) {
      b(j);
    }
    do
    {
      return;
      WindowManager localWindowManager = (WindowManager)c.getSystemService("window");
      if ((localWindowManager != null) && (o) && (g != null))
      {
        localWindowManager.removeView(g);
        if (paramBoolean) {
          a(a, paramPanelFeatureState, null);
        }
      }
      m = false;
      n = false;
      o = false;
      h = null;
      q = true;
    } while (I != paramPanelFeatureState);
    I = null;
  }
  
  public final void a(Toolbar paramToolbar)
  {
    if (!(e instanceof Activity)) {
      return;
    }
    zc localzc = a();
    if ((localzc instanceof abt)) {
      throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }
    i = null;
    if (localzc != null) {
      localzc.p();
    }
    if (paramToolbar != null)
    {
      paramToolbar = new abj(paramToolbar, ((Activity)c).getTitle(), f);
      h = paramToolbar;
      d.setCallback(c);
    }
    for (;;)
    {
      f();
      return;
      h = null;
      d.setCallback(f);
    }
  }
  
  public final void a(View paramView)
  {
    n();
    ViewGroup localViewGroup = (ViewGroup)B.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    e.onContentChanged();
  }
  
  public final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    n();
    ViewGroup localViewGroup = (ViewGroup)B.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    e.onContentChanged();
  }
  
  final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = a();
    if ((localObject != null) && (((zc)localObject).a(paramInt, paramKeyEvent))) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        if ((I == null) || (!a(I, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          break;
        }
      } while (I == null);
      I.n = true;
      return true;
      if (I != null) {
        break;
      }
      localObject = g(0);
      a((AppCompatDelegateImplV7.PanelFeatureState)localObject, paramKeyEvent);
      bool = a((AppCompatDelegateImplV7.PanelFeatureState)localObject, paramKeyEvent.getKeyCode(), paramKeyEvent);
      m = false;
    } while (bool);
    return false;
  }
  
  public final boolean a(adu paramadu, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = d.getCallback();
    if ((localCallback != null) && (!p))
    {
      paramadu = a(paramadu.k());
      if (paramadu != null) {
        return localCallback.onMenuItemSelected(a, paramMenuItem);
      }
    }
    return false;
  }
  
  public final boolean a(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState, KeyEvent paramKeyEvent)
  {
    if (p) {
      return false;
    }
    if (m) {
      return true;
    }
    if ((I != null) && (I != paramPanelFeatureState)) {
      a(I, false);
    }
    Window.Callback localCallback = d.getCallback();
    if (localCallback != null) {
      i = localCallback.onCreatePanelView(a);
    }
    int i;
    label89:
    Context localContext;
    TypedValue localTypedValue;
    Resources.Theme localTheme;
    Object localObject1;
    if ((a == 0) || (a == 108))
    {
      i = 1;
      if ((i != 0) && (r != null)) {
        r.i();
      }
      if ((i != null) || ((i != 0) && ((h instanceof abj)))) {
        break label624;
      }
      if ((j != null) && (!r)) {
        break label494;
      }
      if (j == null)
      {
        localContext = c;
        if (((a != 0) && (a != 108)) || (r == null)) {
          break label652;
        }
        localTypedValue = new TypedValue();
        localTheme = localContext.getTheme();
        localTheme.resolveAttribute(aca.g, localTypedValue, true);
        if (resourceId == 0) {
          break label471;
        }
        localObject1 = localContext.getResources().newTheme();
        ((Resources.Theme)localObject1).setTo(localTheme);
        ((Resources.Theme)localObject1).applyStyle(resourceId, true);
        ((Resources.Theme)localObject1).resolveAttribute(aca.h, localTypedValue, true);
        label256:
        Object localObject2 = localObject1;
        if (resourceId != 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localContext.getResources().newTheme();
            ((Resources.Theme)localObject2).setTo(localTheme);
          }
          ((Resources.Theme)localObject2).applyStyle(resourceId, true);
        }
        if (localObject2 == null) {
          break label652;
        }
        localObject1 = new adc(localContext, 0);
        ((Context)localObject1).getTheme().setTo((Resources.Theme)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new adu((Context)localObject1);
      ((adu)localObject1).a(this);
      paramPanelFeatureState.a((adu)localObject1);
      if (j == null) {
        break;
      }
      if ((i != 0) && (r != null))
      {
        if (q == null) {
          q = new aaz(this);
        }
        r.a(j, q);
      }
      j.d();
      if (!localCallback.onCreatePanelMenu(a, j))
      {
        paramPanelFeatureState.a(null);
        if ((i == 0) || (r == null)) {
          break;
        }
        r.a(null, q);
        return false;
        i = 0;
        break label89;
        label471:
        localTheme.resolveAttribute(aca.h, localTypedValue, true);
        localObject1 = null;
        break label256;
      }
      r = false;
      label494:
      j.d();
      if (s != null)
      {
        j.c(s);
        s = null;
      }
      if (!localCallback.onPreparePanel(0, i, j))
      {
        if ((i != 0) && (r != null)) {
          r.a(null, q);
        }
        j.e();
        return false;
      }
      if (paramKeyEvent != null)
      {
        i = paramKeyEvent.getDeviceId();
        if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
          break label646;
        }
      }
      label624:
      label646:
      for (boolean bool = true;; bool = false)
      {
        p = bool;
        j.setQwertyMode(p);
        j.e();
        m = true;
        n = false;
        I = paramPanelFeatureState;
        return true;
        i = -1;
        break;
      }
      label652:
      localObject1 = localContext;
    }
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 82) && (e.dispatchKeyEvent(paramKeyEvent))) {}
    int i;
    label180:
    do
    {
      int j;
      do
      {
        do
        {
          return true;
          j = paramKeyEvent.getKeyCode();
          if (paramKeyEvent.getAction() == 0) {}
          for (i = 1; i != 0; i = 0) {
            switch (j)
            {
            default: 
              if (Build.VERSION.SDK_INT < 11) {
                a(j, paramKeyEvent);
              }
              return false;
            }
          }
        } while (paramKeyEvent.getRepeatCount() != 0);
        localPanelFeatureState = g(0);
      } while (o);
      a(localPanelFeatureState, paramKeyEvent);
      return true;
      if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
      for (bool = true;; bool = false)
      {
        J = bool;
        break;
      }
      switch (j)
      {
      default: 
        return false;
      }
    } while (s != null);
    AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState = g(0);
    if ((r != null) && (r.d()) && (!rz.a(ViewConfiguration.get(c)))) {
      if (!r.e())
      {
        if ((p) || (!a(localPanelFeatureState, paramKeyEvent))) {
          break label495;
        }
        bool = r.g();
      }
    }
    label268:
    while (bool)
    {
      paramKeyEvent = (AudioManager)c.getSystemService("audio");
      if (paramKeyEvent == null) {
        break label394;
      }
      paramKeyEvent.playSoundEffect(0);
      return true;
      bool = r.h();
      continue;
      if ((!o) && (!n)) {
        break label345;
      }
      bool = o;
      a(localPanelFeatureState, true);
    }
    label345:
    if (m)
    {
      if (!r) {
        break label501;
      }
      m = false;
    }
    label394:
    label495:
    label501:
    for (boolean bool = a(localPanelFeatureState, paramKeyEvent);; bool = true)
    {
      if (bool)
      {
        b(localPanelFeatureState, paramKeyEvent);
        bool = true;
        break label268;
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
        return true;
        bool = J;
        J = false;
        paramKeyEvent = g(0);
        if ((paramKeyEvent != null) && (o))
        {
          if (bool) {
            break;
          }
          a(paramKeyEvent, true);
          return true;
        }
        if (s != null)
        {
          s.c();
          i = 1;
        }
        while (i != 0)
        {
          return true;
          paramKeyEvent = a();
          if ((paramKeyEvent != null) && (paramKeyEvent.n())) {
            i = 1;
          } else {
            i = 0;
          }
        }
        break label180;
      }
      bool = false;
      break label268;
    }
  }
  
  public final void b(int paramInt)
  {
    n();
    ViewGroup localViewGroup = (ViewGroup)B.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(c).inflate(paramInt, localViewGroup);
    e.onContentChanged();
  }
  
  public final void b(adu paramadu)
  {
    if (G) {
      return;
    }
    G = true;
    r.j();
    Window.Callback localCallback = d.getCallback();
    if ((localCallback != null) && (!p)) {
      localCallback.onPanelClosed(108, paramadu);
    }
    G = false;
  }
  
  public final void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    n();
    ((ViewGroup)B.findViewById(16908290)).addView(paramView, paramLayoutParams);
    e.onContentChanged();
  }
  
  final void b(CharSequence paramCharSequence)
  {
    if (r != null) {
      r.a(paramCharSequence);
    }
    do
    {
      return;
      if (h != null)
      {
        h.c(paramCharSequence);
        return;
      }
    } while (C == null);
    C.setText(paramCharSequence);
  }
  
  public final void c()
  {
    n();
  }
  
  public final boolean c(int paramInt)
  {
    int i;
    if (paramInt == 8) {
      i = 108;
    }
    while ((n) && (i == 108))
    {
      return false;
      i = paramInt;
      if (paramInt == 9) {
        i = 109;
      }
    }
    if ((j) && (i == 1)) {
      j = false;
    }
    switch (i)
    {
    default: 
      return d.requestFeature(i);
    case 108: 
      o();
      j = true;
      return true;
    case 109: 
      o();
      k = true;
      return true;
    case 10: 
      o();
      l = true;
      return true;
    case 2: 
      o();
      E = true;
      return true;
    case 5: 
      o();
      F = true;
      return true;
    }
    o();
    n = true;
    return true;
  }
  
  public final void d()
  {
    zc localzc = a();
    if (localzc != null) {
      localzc.d(false);
    }
  }
  
  final void d(int paramInt)
  {
    Object localObject;
    if (paramInt == 108)
    {
      localObject = a();
      if (localObject != null) {
        ((zc)localObject).e(false);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 0);
      localObject = g(paramInt);
    } while (!o);
    a((AppCompatDelegateImplV7.PanelFeatureState)localObject, false);
  }
  
  public final void e()
  {
    zc localzc = a();
    if (localzc != null) {
      localzc.d(true);
    }
  }
  
  final boolean e(int paramInt)
  {
    if (paramInt == 108)
    {
      zc localzc = a();
      if (localzc != null) {
        localzc.e(true);
      }
      return true;
    }
    return false;
  }
  
  public final void f()
  {
    zc localzc = a();
    if ((localzc != null) && (localzc.m())) {
      return;
    }
    f(0);
  }
  
  public final AppCompatDelegateImplV7.PanelFeatureState g(int paramInt)
  {
    Object localObject2 = H;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new AppCompatDelegateImplV7.PanelFeatureState[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      H = ((AppCompatDelegateImplV7.PanelFeatureState[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new AppCompatDelegateImplV7.PanelFeatureState(paramInt);
      localObject1[paramInt] = localObject2;
      return (AppCompatDelegateImplV7.PanelFeatureState)localObject2;
    }
    return (AppCompatDelegateImplV7.PanelFeatureState)localObject2;
  }
  
  public final void g()
  {
    super.g();
    if (h != null) {
      h.p();
    }
  }
  
  public final int h(int paramInt)
  {
    int j = 1;
    int k = 1;
    int m = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if ((t != null) && ((t.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)t.getLayoutParams();
      if (t.isShown())
      {
        if (M == null)
        {
          M = new Rect();
          N = new Rect();
        }
        localObject2 = M;
        Rect localRect = N;
        ((Rect)localObject2).set(0, paramInt, 0, 0);
        ane.a(B, (Rect)localObject2, localRect);
        if (top == 0)
        {
          i = paramInt;
          if (topMargin == i) {
            break label355;
          }
          topMargin = paramInt;
          if (D != null) {
            break label279;
          }
          D = new View(c);
          D.setBackgroundColor(c.getResources().getColor(acc.a));
          B.addView(D, -1, new ViewGroup.LayoutParams(-1, paramInt));
          i = 1;
          label201:
          if (D == null) {
            break label317;
          }
          label208:
          j = paramInt;
          if (!l)
          {
            j = paramInt;
            if (k != 0) {
              j = 0;
            }
          }
          paramInt = j;
          j = i;
          i = k;
          label233:
          if (j != 0) {
            t.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      if (D != null)
      {
        localObject1 = D;
        if (i == 0) {
          break label342;
        }
      }
      label279:
      label317:
      label342:
      for (i = m;; i = 8)
      {
        ((View)localObject1).setVisibility(i);
        return paramInt;
        i = 0;
        break;
        localObject2 = D.getLayoutParams();
        if (height != paramInt)
        {
          height = paramInt;
          D.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        i = 1;
        break label201;
        k = 0;
        break label208;
        if (topMargin == 0) {
          break label348;
        }
        topMargin = 0;
        i = 0;
        break label233;
      }
      label348:
      j = 0;
      i = 0;
      break label233;
      label355:
      i = 0;
      break label201;
      i = 0;
    }
  }
  
  public final void i()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(c);
    if (localLayoutInflater.getFactory() == null)
    {
      pq.a(localLayoutInflater, this);
      return;
    }
    pq.a.a(localLayoutInflater);
  }
  
  public final void k()
  {
    n();
    if ((!j) || (h != null)) {}
    for (;;)
    {
      return;
      if ((e instanceof Activity)) {
        h = new abt((Activity)e, k);
      }
      while (h != null)
      {
        h.c(L);
        return;
        if ((e instanceof Dialog)) {
          h = new abt((Dialog)e);
        }
      }
    }
  }
  
  public final void m()
  {
    if (w != null) {
      w.a();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */