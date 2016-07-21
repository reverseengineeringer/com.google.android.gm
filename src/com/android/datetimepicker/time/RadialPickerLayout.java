package com.android.datetimepicker.time;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import aod;
import aog;
import aol;
import apm;
import apn;
import apo;
import app;
import apq;
import apr;
import apt;
import java.text.DateFormatSymbols;
import java.util.List;

public class RadialPickerLayout
  extends FrameLayout
  implements View.OnTouchListener
{
  private float A;
  private AccessibilityManager B;
  private Handler C = new Handler();
  public int a;
  public apq b;
  public int c;
  public int d;
  public int e;
  public apn f;
  public apm g;
  public apt h;
  public apt i;
  public apr j;
  public apr k;
  public int l = -1;
  public boolean m;
  public int n;
  public AnimatorSet o;
  private final int p;
  private final int q;
  private aod r;
  private boolean s;
  private boolean t;
  private boolean u;
  private View v;
  private int[] w;
  private boolean x;
  private boolean y;
  private float z;
  
  public RadialPickerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnTouchListener(this);
    p = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    q = ViewConfiguration.getTapTimeout();
    m = false;
    f = new apn(paramContext);
    addView(f);
    g = new apm(paramContext);
    addView(g);
    h = new apt(paramContext);
    addView(h);
    i = new apt(paramContext);
    addView(i);
    j = new apr(paramContext);
    addView(j);
    k = new apr(paramContext);
    addView(k);
    c();
    a = -1;
    x = true;
    v = new View(paramContext);
    v.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    v.setBackgroundColor(getResources().getColor(aog.n));
    v.setVisibility(4);
    addView(v);
    B = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    s = false;
  }
  
  private final int a(float paramFloat1, float paramFloat2, boolean paramBoolean, Boolean[] paramArrayOfBoolean)
  {
    int i1 = b();
    if (i1 == 0) {
      return j.a(paramFloat1, paramFloat2, paramBoolean, paramArrayOfBoolean);
    }
    if (i1 == 1) {
      return k.a(paramFloat1, paramFloat2, paramBoolean, paramArrayOfBoolean);
    }
    return -1;
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      c = paramInt2;
    }
    do
    {
      do
      {
        return;
        if (paramInt1 == 1)
        {
          d = paramInt2;
          return;
        }
      } while (paramInt1 != 2);
      if (paramInt2 == 0)
      {
        c %= 12;
        return;
      }
    } while (paramInt2 != 1);
    c = (c % 12 + 12);
  }
  
  private final boolean b(int paramInt)
  {
    return (t) && (paramInt <= 12) && (paramInt != 0);
  }
  
  private static int c(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 / 30 * 30;
    int i2 = i1 + 30;
    if (paramInt2 != 1)
    {
      if (paramInt2 == -1)
      {
        paramInt2 = i1;
        if (paramInt1 == i1) {
          paramInt2 = i1 - 30;
        }
      }
      do
      {
        return paramInt2;
        paramInt2 = i1;
      } while (paramInt1 - i1 < i2 - paramInt1);
    }
    return i2;
  }
  
  private final void c()
  {
    w = new int['ũ'];
    int i3 = 0;
    int i1 = 0;
    int i5 = 8;
    int i2 = 1;
    if (i3 < 361)
    {
      w[i3] = i1;
      int i4;
      if (i2 == i5)
      {
        i4 = i1 + 6;
        if (i4 == 360)
        {
          i1 = 7;
          label56:
          i2 = 1;
          i5 = i1;
        }
      }
      for (;;)
      {
        i3 += 1;
        i1 = i4;
        break;
        if (i4 % 30 == 0)
        {
          i1 = 14;
          break label56;
        }
        i1 = 4;
        break label56;
        i2 += 1;
        i4 = i1;
      }
    }
  }
  
  public final int a()
  {
    if (c < 12) {
      return 0;
    }
    if (c < 24) {
      return 1;
    }
    return -1;
  }
  
  public final int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i2 = -1;
    if (paramInt == -1) {
      return -1;
    }
    int i3 = b();
    int i1;
    label44:
    apr localapr;
    if ((!paramBoolean2) && (i3 == 1))
    {
      i1 = 1;
      if (i1 == 0) {
        break label145;
      }
      if (w != null) {
        break label135;
      }
      paramInt = i2;
      if (i3 != 0) {
        break label154;
      }
      localapr = j;
      i1 = 30;
      label59:
      localapr.a(paramInt, paramBoolean1, paramBoolean3);
      localapr.invalidate();
      if (i3 != 0) {
        break label194;
      }
      if (!t) {
        break label183;
      }
      if ((paramInt != 0) || (!paramBoolean1)) {
        break label167;
      }
      paramInt = 360;
    }
    label135:
    label145:
    label154:
    label167:
    label183:
    label194:
    label215:
    for (;;)
    {
      i1 = paramInt / i1;
      if ((i3 == 0) && (t) && (!paramBoolean1) && (paramInt != 0))
      {
        return i1 + 12;
        i1 = 0;
        break;
        paramInt = w[paramInt];
        break label44;
        paramInt = c(paramInt, 0);
        break label44;
        localapr = k;
        i1 = 6;
        break label59;
        if ((paramInt != 360) || (paramBoolean1)) {
          break label215;
        }
        paramInt = 0;
        continue;
        if (paramInt != 0) {
          break label215;
        }
        paramInt = 360;
        continue;
        if ((paramInt != 360) || (i3 != 1)) {
          break label215;
        }
        paramInt = 0;
        continue;
      }
      return i1;
    }
  }
  
  public final void a(int paramInt)
  {
    g.k = paramInt;
    g.invalidate();
    b(2, paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      b(0, paramInt2);
      j.a(paramInt2 % 12 * 30, b(paramInt2), false);
      j.invalidate();
    }
    while (paramInt1 != 1) {
      return;
    }
    b(1, paramInt2);
    k.a(paramInt2 * 6, false, false);
    k.invalidate();
  }
  
  public final void a(Context paramContext, aod paramaod, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (s)
    {
      Log.e("RadialPickerLayout", "Time has already been initialized.");
      return;
    }
    r = paramaod;
    t = paramBoolean;
    boolean bool;
    int i1;
    label100:
    label115:
    Object localObject2;
    String[] arrayOfString1;
    Object localObject1;
    String[] arrayOfString2;
    if (B.isTouchExplorationEnabled())
    {
      bool = true;
      u = bool;
      paramaod = f;
      bool = u;
      if (!f) {
        break label462;
      }
      Log.e("CircleView", "CircleView may only be initialized once.");
      f.invalidate();
      if (!u)
      {
        paramaod = g;
        if (paramInt1 >= 12) {
          break label535;
        }
        i1 = 0;
        if (!j) {
          break label541;
        }
        Log.e("AmPmCirclesView", "AmPmCirclesView may only be initialized once.");
        g.invalidate();
      }
      localObject2 = paramContext.getResources();
      localObject3 = new int[12];
      Object tmp136_134 = localObject3;
      tmp136_134[0] = 12;
      Object tmp141_136 = tmp136_134;
      tmp141_136[1] = 1;
      Object tmp145_141 = tmp141_136;
      tmp145_141[2] = 2;
      Object tmp149_145 = tmp145_141;
      tmp149_145[3] = 3;
      Object tmp153_149 = tmp149_145;
      tmp153_149[4] = 4;
      Object tmp157_153 = tmp153_149;
      tmp157_153[5] = 5;
      Object tmp161_157 = tmp157_153;
      tmp161_157[6] = 6;
      Object tmp167_161 = tmp161_157;
      tmp167_161[7] = 7;
      Object tmp173_167 = tmp167_161;
      tmp173_167[8] = 8;
      Object tmp179_173 = tmp173_167;
      tmp179_173[9] = 9;
      Object tmp185_179 = tmp179_173;
      tmp185_179[10] = 10;
      Object tmp191_185 = tmp185_179;
      tmp191_185[11] = 11;
      tmp191_185;
      arrayOfString1 = new String[12];
      localObject1 = new String[12];
      arrayOfString2 = new String[12];
      i1 = 0;
      label222:
      if (i1 >= 12) {
        break label732;
      }
      if (!paramBoolean) {
        break label708;
      }
    }
    label462:
    label535:
    label541:
    label708:
    for (paramaod = String.format("%02d", new Object[] { Integer.valueOf(new int[] { 0, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 }[i1]) });; paramaod = String.format("%d", new Object[] { Integer.valueOf(localObject3[i1]) }))
    {
      arrayOfString1[i1] = paramaod;
      localObject1[i1] = String.format("%d", new Object[] { Integer.valueOf(localObject3[i1]) });
      arrayOfString2[i1] = String.format("%02d", new Object[] { Integer.valueOf(new int[] { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55 }[i1]) });
      i1 += 1;
      break label222;
      bool = t;
      break;
      localObject1 = paramContext.getResources();
      a = bool;
      if (bool) {
        d = Float.parseFloat(((Resources)localObject1).getString(aol.c));
      }
      for (;;)
      {
        f = true;
        break;
        d = Float.parseFloat(((Resources)localObject1).getString(aol.b));
        e = Float.parseFloat(((Resources)localObject1).getString(aol.a));
      }
      i1 = 1;
      break label100;
      localObject1 = paramContext.getResources();
      c = ((Resources)localObject1).getColor(17170443);
      e = ((Resources)localObject1).getColor(aog.b);
      d = ((Resources)localObject1).getColor(aog.a);
      b = 51;
      localObject2 = Typeface.create(((Resources)localObject1).getString(aol.n), 0);
      a.setTypeface((Typeface)localObject2);
      a.setAntiAlias(true);
      a.setTextAlign(Paint.Align.CENTER);
      f = Float.parseFloat(((Resources)localObject1).getString(aol.b));
      g = Float.parseFloat(((Resources)localObject1).getString(aol.a));
      localObject1 = new DateFormatSymbols().getAmPmStrings();
      h = localObject1[0];
      i = localObject1[1];
      k = i1;
      l = -1;
      j = true;
      break label115;
    }
    label732:
    Object localObject3 = h;
    if (paramBoolean) {}
    for (paramaod = (aod)localObject1;; paramaod = null)
    {
      ((apt)localObject3).a((Resources)localObject2, arrayOfString1, paramaod, u, true);
      h.invalidate();
      i.a((Resources)localObject2, arrayOfString2, null, u, false);
      i.invalidate();
      b(0, paramInt1);
      b(1, paramInt2);
      j.a(paramContext, u, paramBoolean, true, paramInt1 % 12 * 30, b(paramInt1));
      k.a(paramContext, u, false, false, paramInt2 * 6, false);
      s = true;
      return;
    }
  }
  
  public final boolean a(boolean paramBoolean)
  {
    int i1 = 0;
    if ((y) && (!paramBoolean)) {
      return false;
    }
    x = paramBoolean;
    View localView = v;
    if (paramBoolean) {
      i1 = 4;
    }
    localView.setVisibility(i1);
    return true;
  }
  
  public final int b()
  {
    if ((e != 0) && (e != 1))
    {
      int i1 = e;
      Log.e("RadialPickerLayout", 57 + "Current item showing was unfortunately set to " + i1);
      return -1;
    }
    return e;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    Object localObject;
    long l1;
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.getText().clear();
      localObject = new Time();
      hour = c;
      minute = d;
      l1 = ((Time)localObject).normalize(true);
      if (!t) {
        break label94;
      }
    }
    label94:
    for (int i1 = 129;; i1 = 1)
    {
      localObject = DateUtils.formatDateTime(getContext(), l1, i1);
      paramAccessibilityEvent.getText().add(localObject);
      return true;
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.addAction(4096);
    paramAccessibilityNodeInfo.addAction(8192);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    i1 = Math.min(i1, i2);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i1, paramInt1), View.MeasureSpec.makeMeasureSpec(i1, paramInt2));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramView = new Boolean[1];
    paramView[0] = Boolean.valueOf(false);
    switch (paramMotionEvent.getAction())
    {
    }
    boolean bool1;
    int i1;
    for (;;)
    {
      bool1 = false;
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!x);
            z = f1;
            A = f2;
            a = -1;
            m = false;
            y = true;
            if (!u) {}
            for (l = g.a(f1, f2); (l == 0) || (l == 1); l = -1)
            {
              r.c();
              n = -1;
              C.postDelayed(new apo(this), q);
              return true;
            }
            n = a(f1, f2, B.isTouchExplorationEnabled(), paramView);
            bool1 = bool2;
          } while (n == -1);
          r.c();
          C.postDelayed(new app(this, paramView), q);
          return true;
          if (!x)
          {
            Log.e("RadialPickerLayout", "Input was disabled, but received ACTION_MOVE.");
            return true;
          }
          float f3 = Math.abs(f2 - A);
          float f4 = Math.abs(f1 - z);
          if ((!m) && (f4 <= p) && (f3 <= p)) {
            break;
          }
          if ((l == 0) || (l == 1))
          {
            C.removeCallbacksAndMessages(null);
            if (g.a(f1, f2) == l) {
              break;
            }
            g.l = -1;
            g.invalidate();
            l = -1;
            break;
          }
          if (n == -1) {
            break;
          }
          m = true;
          C.removeCallbacksAndMessages(null);
          i1 = a(f1, f2, true, paramView);
          bool1 = bool2;
        } while (i1 == -1);
        i1 = a(i1, paramView[0].booleanValue(), false, true);
        bool1 = bool2;
      } while (i1 == a);
      r.c();
      a = i1;
      b.a(b(), i1, false);
      return true;
      if (!x)
      {
        b.a(3, 1, false);
        return true;
      }
      C.removeCallbacksAndMessages(null);
      y = false;
      if ((l != 0) && (l != 1)) {
        break;
      }
      i1 = g.a(f1, f2);
      g.l = -1;
      g.invalidate();
      if (i1 == l)
      {
        g.k = i1;
        if (a() != i1)
        {
          b.a(2, l, false);
          b(2, i1);
        }
      }
      l = -1;
    }
    int i2;
    int i3;
    if (n != -1)
    {
      i1 = a(f1, f2, m, paramView);
      if (i1 != -1)
      {
        bool2 = paramView[0].booleanValue();
        if (m) {
          break label743;
        }
        bool1 = true;
        i2 = a(i1, bool2, bool1, false);
        i1 = i2;
        if (b() == 0)
        {
          i1 = i2;
          if (!t)
          {
            i3 = a();
            if ((i3 != 0) || (i2 != 12)) {
              break label749;
            }
            i1 = 0;
          }
        }
      }
    }
    for (;;)
    {
      b(b(), i1);
      b.a(b(), i1, true);
      m = false;
      return true;
      label743:
      bool1 = false;
      break;
      label749:
      i1 = i2;
      if (i3 == 1)
      {
        i1 = i2;
        if (i2 != 12) {
          i1 = i2 + 12;
        }
      }
    }
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    int i2 = -1;
    boolean bool = false;
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      int i1;
      if (paramInt == 4096) {
        i1 = 1;
      }
      while (i1 != 0)
      {
        int i3 = b();
        if (i3 == 0)
        {
          paramInt = c;
          label50:
          i3 = b();
          if (i3 != 0) {
            break label156;
          }
          i2 = paramInt % 12;
          paramInt = 30;
        }
        for (;;)
        {
          label70:
          i2 = c(i2 * paramInt, i1) / paramInt;
          if (i3 == 0) {
            if (t)
            {
              i1 = 23;
              paramInt = 0;
              label99:
              if (i2 <= i1) {
                break label187;
              }
            }
          }
          for (;;)
          {
            a(i3, paramInt);
            b.a(i3, paramInt, false);
            return true;
            if (paramInt != 8192) {
              break label212;
            }
            i1 = -1;
            break;
            paramInt = i2;
            if (i3 != 1) {
              break label50;
            }
            paramInt = d;
            break label50;
            label156:
            if (i3 != 1) {
              break label204;
            }
            i2 = paramInt;
            paramInt = 6;
            break label70;
            i1 = 12;
            paramInt = 1;
            break label99;
            i1 = 55;
            paramInt = 0;
            break label99;
            label187:
            if (i2 < paramInt) {
              paramInt = i1;
            } else {
              paramInt = i2;
            }
          }
          label204:
          i2 = paramInt;
          paramInt = 0;
        }
        label212:
        i1 = 0;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.datetimepicker.time.RadialPickerLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */