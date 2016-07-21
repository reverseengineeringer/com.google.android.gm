package android.support.design.widget;

import ab;
import ac;
import ad;
import ae;
import af;
import ag;
import ah;
import aj;
import ak;
import al;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import cl;
import cw;
import i;
import j;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pg;
import qk;
import qs;
import qt;
import rg;
import rt;
import tz;

public class CoordinatorLayout
  extends ViewGroup
  implements qs
{
  static final String a;
  static final Class<?>[] b;
  static final ThreadLocal<Map<String, Constructor<ad>>> c;
  static final Comparator<View> e;
  static final ak f;
  final Comparator<View> d = new ab(this);
  public final List<View> g = new ArrayList();
  final Rect h = new Rect();
  final Rect i = new Rect();
  public tz j;
  public boolean k;
  public ViewGroup.OnHierarchyChangeListener l;
  private final List<View> m = new ArrayList();
  private final List<View> n = new ArrayList();
  private final Rect o = new Rect();
  private final int[] p = new int[2];
  private boolean q;
  private boolean r;
  private int[] s;
  private View t;
  private View u;
  private View v;
  private ah w;
  private boolean x;
  private Drawable y;
  private final qt z = new qt(this);
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      a = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label80;
      }
      e = new aj();
    }
    for (f = new al();; f = null)
    {
      b = new Class[] { Context.class, AttributeSet.class };
      c = new ThreadLocal();
      return;
      localObject = null;
      break;
      label80:
      e = null;
    }
  }
  
  public CoordinatorLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cl.a(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, j.B, paramInt, i.b);
    paramInt = paramAttributeSet.getResourceId(j.C, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getResources();
      s = paramContext.getIntArray(paramInt);
      float f1 = getDisplayMetricsdensity;
      int i2 = s.length;
      paramInt = i1;
      while (paramInt < i2)
      {
        paramContext = s;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f1));
        paramInt += 1;
      }
    }
    y = paramAttributeSet.getDrawable(j.D);
    paramAttributeSet.recycle();
    if (f != null) {
      f.a(this, new ac(this));
    }
    super.setOnHierarchyChangeListener(new af(this));
  }
  
  private final int a(int paramInt)
  {
    if (s == null)
    {
      Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + paramInt);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= s.length))
    {
      Log.e("CoordinatorLayout", "Keyline index " + paramInt + " out of range for " + this);
      return 0;
    }
    return s[paramInt];
  }
  
  public static ad a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramString.startsWith(".")) {
      str = paramContext.getPackageName() + paramString;
    }
    label225:
    for (;;)
    {
      try
      {
        paramString = (Map)c.get();
        if (paramString != null) {
          break label225;
        }
        paramString = new HashMap();
        c.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = Class.forName(str, true, paramContext.getClassLoader()).getConstructor(b);
          localConstructor1.setAccessible(true);
          paramString.put(str, localConstructor1);
        }
        paramContext = (ad)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
        return paramContext;
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException("Could not inflate Behavior subclass " + str, paramContext);
      }
      str = paramString;
      if (paramString.indexOf('.') < 0)
      {
        str = paramString;
        if (!TextUtils.isEmpty(a)) {
          str = a + '.' + paramString;
        }
      }
    }
  }
  
  private final void a()
  {
    if (t != null)
    {
      ad localad = t.getLayoutParams()).a;
      if (localad != null)
      {
        long l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        localad.b(this, t, localMotionEvent);
        localMotionEvent.recycle();
      }
      t = null;
    }
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      getChildAtgetLayoutParamsi = false;
      i1 += 1;
    }
    q = false;
  }
  
  private final void a(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    ag localag = (ag)paramView.getLayoutParams();
    int i2 = c;
    int i1 = i2;
    if (i2 == 0) {
      i1 = 17;
    }
    int i5 = pg.a(i1, paramInt);
    i1 = pg.a(b(d), paramInt);
    int i3 = paramView.getMeasuredWidth();
    int i4 = paramView.getMeasuredHeight();
    switch (i1 & 0x7)
    {
    default: 
      paramInt = left;
      switch (i1 & 0x70)
      {
      default: 
        i1 = top;
        label138:
        i2 = paramInt;
        switch (i5 & 0x7)
        {
        default: 
          i2 = paramInt - i3;
        case 5: 
          label178:
          paramInt = i1;
          switch (i5 & 0x70)
          {
          }
          break;
        }
        break;
      }
      break;
    }
    for (paramInt = i1 - i4;; paramInt = i1 - i4 / 2)
    {
      i5 = getWidth();
      i1 = getHeight();
      i2 = Math.max(getPaddingLeft() + leftMargin, Math.min(i2, i5 - getPaddingRight() - i3 - rightMargin));
      paramInt = Math.max(getPaddingTop() + topMargin, Math.min(paramInt, i1 - getPaddingBottom() - i4 - bottomMargin));
      paramRect2.set(i2, paramInt, i2 + i3, paramInt + i4);
      return;
      paramInt = right;
      break;
      paramInt = left;
      paramInt = paramRect1.width() / 2 + paramInt;
      break;
      i1 = bottom;
      break label138;
      i1 = top + paramRect1.height() / 2;
      break label138;
      i2 = paramInt - i3 / 2;
      break label178;
    }
  }
  
  private static void a(List<View> paramList, Comparator<View> paramComparator)
  {
    if ((paramList == null) || (paramList.size() < 2)) {}
    for (;;)
    {
      return;
      View[] arrayOfView = new View[paramList.size()];
      paramList.toArray(arrayOfView);
      int i5 = arrayOfView.length;
      int i1 = 0;
      while (i1 < i5)
      {
        int i2 = i1 + 1;
        int i4;
        for (int i3 = i1; i2 < i5; i3 = i4)
        {
          i4 = i3;
          if (paramComparator.compare(arrayOfView[i2], arrayOfView[i3]) < 0) {
            i4 = i2;
          }
          i2 += 1;
        }
        if (i1 != i3)
        {
          View localView = arrayOfView[i3];
          arrayOfView[i3] = arrayOfView[i1];
          arrayOfView[i1] = localView;
        }
        i1 += 1;
      }
      paramList.clear();
      i1 = 0;
      while (i1 < i5)
      {
        paramList.add(arrayOfView[i1]);
        i1 += 1;
      }
    }
  }
  
  private final boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool1 = false;
    int i3 = 0;
    int i4 = qk.a(paramMotionEvent);
    List localList = m;
    localList.clear();
    boolean bool2 = isChildrenDrawingOrderEnabled();
    int i5 = getChildCount();
    int i1 = i5 - 1;
    if (i1 >= 0)
    {
      if (bool2) {}
      for (i2 = getChildDrawingOrder(i5, i1);; i2 = i1)
      {
        localList.add(getChildAt(i2));
        i1 -= 1;
        break;
      }
    }
    if (e != null) {
      Collections.sort(localList, e);
    }
    i5 = localList.size();
    int i2 = 0;
    MotionEvent localMotionEvent = null;
    i1 = i3;
    View localView;
    ag localag;
    ad localad;
    if (i2 < i5)
    {
      localView = (View)localList.get(i2);
      localag = (ag)localView.getLayoutParams();
      localad = a;
      if (((bool1) || (i1 != 0)) && (i4 != 0))
      {
        if (localad == null) {
          break label456;
        }
        if (localMotionEvent != null) {
          break label453;
        }
        long l1 = SystemClock.uptimeMillis();
        localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        label199:
        switch (paramInt)
        {
        }
      }
    }
    label304:
    label359:
    label434:
    label443:
    label453:
    label456:
    for (;;)
    {
      i2 += 1;
      break;
      localad.a(this, localView, localMotionEvent);
      continue;
      localad.b(this, localView, localMotionEvent);
      continue;
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (localad == null) {}
      }
      switch (paramInt)
      {
      default: 
        bool2 = bool1;
        if (bool1)
        {
          t = localView;
          bool2 = bool1;
        }
        bool1 = bool2;
        if (a == null) {
          i = false;
        }
        boolean bool3 = i;
        if (i)
        {
          bool2 = true;
          if ((!bool2) || (bool3)) {
            break label434;
          }
        }
        break;
      }
      for (i1 = 1;; i1 = 0)
      {
        if (bool2)
        {
          bool2 = bool1;
          if (i1 == 0) {
            break label443;
          }
        }
        break;
        bool1 = localad.a(this, localView, paramMotionEvent);
        break label304;
        bool1 = localad.b(this, localView, paramMotionEvent);
        break label304;
        bool2 = i | false;
        i = bool2;
        break label359;
      }
      bool2 = bool1;
      localList.clear();
      return bool2;
      break label199;
    }
  }
  
  private static int b(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 8388659;
    }
    return i1;
  }
  
  private static ag b(View paramView)
  {
    ag localag = (ag)paramView.getLayoutParams();
    View localView;
    if (!b)
    {
      Class localClass = paramView.getClass();
      paramView = null;
      for (;;)
      {
        localView = paramView;
        if (localClass == null) {
          break;
        }
        paramView = (ae)localClass.getAnnotation(ae.class);
        localView = paramView;
        if (paramView != null) {
          break;
        }
        localClass = localClass.getSuperclass();
      }
      if (localView == null) {}
    }
    try
    {
      localag.a((ad)localView.a().newInstance());
      b = true;
      return localag;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.e("CoordinatorLayout", "Default behavior class " + localView.a().getName() + " could not be instantiated. Did you forget a default constructor?", paramView);
      }
    }
  }
  
  private final void b()
  {
    int i3 = getChildCount();
    int i2 = 0;
    View localView1;
    ag localag;
    int i1;
    if (i2 < i3)
    {
      localView1 = getChildAt(i2);
      localag = (ag)localView1.getLayoutParams();
      if (g != null)
      {
        i1 = 1;
        label39:
        if (i1 == 0) {
          break label161;
        }
      }
    }
    for (int i5 = 1;; i5 = 0)
    {
      if (i5 != x)
      {
        if (i5 != 0)
        {
          if (r)
          {
            if (w == null) {
              w = new ah(this);
            }
            getViewTreeObserver().addOnPreDrawListener(w);
          }
          x = true;
        }
      }
      else
      {
        return;
        int i4 = getChildCount();
        i1 = 0;
        for (;;)
        {
          if (i1 >= i4) {
            break label156;
          }
          View localView2 = getChildAt(i1);
          if ((localView2 != localView1) && (localag.a(this, localView1, localView2)))
          {
            i1 = 1;
            break;
          }
          i1 += 1;
        }
        label156:
        i1 = 0;
        break label39;
        label161:
        i2 += 1;
        break;
      }
      if ((r) && (w != null)) {
        getViewTreeObserver().removeOnPreDrawListener(w);
      }
      x = false;
      return;
    }
  }
  
  private static int c(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 8388661;
    }
    return i1;
  }
  
  public final List<View> a(View paramView)
  {
    ag localag = (ag)paramView.getLayoutParams();
    List localList = n;
    localList.clear();
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((localView != paramView) && (localag.a(this, paramView, localView))) {
        localList.add(localView);
      }
      i1 += 1;
    }
    return localList;
  }
  
  public final void a(View paramView, int paramInt)
  {
    Object localObject = (ag)paramView.getLayoutParams();
    if ((g == null) && (f != -1)) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }
    if (g != null)
    {
      localObject = g;
      paramView.getLayoutParams();
      localRect1 = h;
      localRect2 = i;
      cw.a(this, (View)localObject, localRect1);
      a(paramView, paramInt, localRect1, localRect2);
      paramView.layout(left, top, right, bottom);
      return;
    }
    if (e >= 0)
    {
      int i2 = e;
      localObject = (ag)paramView.getLayoutParams();
      int i7 = pg.a(c(c), paramInt);
      int i6 = getWidth();
      int i5 = getHeight();
      int i3 = paramView.getMeasuredWidth();
      int i4 = paramView.getMeasuredHeight();
      i1 = i2;
      if (paramInt == 1) {
        i1 = i6 - i2;
      }
      paramInt = a(i1) - i3;
      switch (i7 & 0x7)
      {
      default: 
        switch (i7 & 0x70)
        {
        default: 
          i1 = 0;
        }
        break;
      }
      for (;;)
      {
        paramInt = Math.max(getPaddingLeft() + leftMargin, Math.min(paramInt, i6 - getPaddingRight() - i3 - rightMargin));
        i1 = Math.max(getPaddingTop() + topMargin, Math.min(i1, i5 - getPaddingBottom() - i4 - bottomMargin));
        paramView.layout(paramInt, i1, paramInt + i3, i1 + i4);
        return;
        paramInt += i3;
        break;
        paramInt += i3 / 2;
        break;
        i1 = i4 + 0;
        continue;
        i1 = i4 / 2 + 0;
      }
    }
    localObject = (ag)paramView.getLayoutParams();
    Rect localRect1 = h;
    localRect1.set(getPaddingLeft() + leftMargin, getPaddingTop() + topMargin, getWidth() - getPaddingRight() - rightMargin, getHeight() - getPaddingBottom() - bottomMargin);
    if ((j != null) && (rg.t(this)) && (!rg.t(paramView)))
    {
      left += j.a();
      top += j.b();
      right -= j.c();
      bottom -= j.d();
    }
    Rect localRect2 = i;
    pg.apply(b(c), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(left, top, right, bottom);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  final void a(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((paramView.isLayoutRequested()) || (paramView.getVisibility() == 8))
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (paramBoolean)
    {
      cw.a(this, paramView, paramRect);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i3 = rg.g(this);
    int i4 = g.size();
    int i1 = 0;
    while (i1 < i4)
    {
      View localView = (View)g.get(i1);
      Object localObject1 = (ag)localView.getLayoutParams();
      int i2 = 0;
      Object localObject3;
      while (i2 < i1)
      {
        localObject2 = (View)g.get(i2);
        if (h == localObject2)
        {
          localObject2 = (ag)localView.getLayoutParams();
          if (g != null)
          {
            localObject3 = h;
            Rect localRect1 = i;
            Rect localRect2 = o;
            cw.a(this, g, (Rect)localObject3);
            a(localView, false, localRect1);
            a(localView, i3, (Rect)localObject3, localRect2);
            int i5 = left - left;
            int i6 = top - top;
            if (i5 != 0) {
              localView.offsetLeftAndRight(i5);
            }
            if (i6 != 0) {
              localView.offsetTopAndBottom(i6);
            }
            if ((i5 != 0) || (i6 != 0))
            {
              localObject3 = a;
              if (localObject3 != null) {
                ((ad)localObject3).b(this, localView, g);
              }
            }
          }
        }
        i2 += 1;
      }
      localObject1 = h;
      Object localObject2 = i;
      ((Rect)localObject1).set(getLayoutParamsl);
      a(localView, true, (Rect)localObject2);
      if (!((Rect)localObject1).equals(localObject2))
      {
        getLayoutParamsl.set((Rect)localObject2);
        i2 = i1 + 1;
        if (i2 < i4)
        {
          localObject1 = (View)g.get(i2);
          localObject2 = (ag)((View)localObject1).getLayoutParams();
          localObject3 = a;
          if ((localObject3 != null) && (((ad)localObject3).a_(localView)))
          {
            if ((paramBoolean) || (!k)) {
              break label388;
            }
            k = false;
          }
          for (;;)
          {
            i2 += 1;
            break;
            label388:
            ((ad)localObject3).b(this, (View)localObject1, localView);
            if (paramBoolean) {
              k = false;
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = h;
    cw.a(this, paramView, localRect);
    return localRect.contains(paramInt1, paramInt2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ag)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    paramView.getLayoutParams();
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = y;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public int getNestedScrollAxes()
  {
    return z.a;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
    if (x)
    {
      if (w == null) {
        w = new ah(this);
      }
      getViewTreeObserver().addOnPreDrawListener(w);
    }
    if ((j == null) && (rg.t(this))) {
      rg.s(this);
    }
    r = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
    if ((x) && (w != null)) {
      getViewTreeObserver().removeOnPreDrawListener(w);
    }
    if (v != null) {
      onStopNestedScroll(v);
    }
    r = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((k) && (y != null)) {
      if (j == null) {
        break label61;
      }
    }
    label61:
    for (int i1 = j.b();; i1 = 0)
    {
      if (i1 > 0)
      {
        y.setBounds(0, 0, getWidth(), i1);
        y.draw(paramCanvas);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = qk.a(paramMotionEvent);
    if (i1 == 0) {
      a();
    }
    boolean bool = a(paramMotionEvent, 0);
    if ((i1 == 1) || (i1 == 3)) {
      a();
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = rg.g(this);
    paramInt3 = g.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)g.get(paramInt1);
      ad localad = getLayoutParamsa;
      if ((localad == null) || (!localad.a(this, localView, paramInt2))) {
        a(localView, paramInt2);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    g.clear();
    int i3 = getChildCount();
    int i2 = 0;
    Object localObject3;
    int i1;
    label165:
    Object localObject2;
    Object localObject1;
    if (i2 < i3)
    {
      localObject3 = getChildAt(i2);
      ag localag = b((View)localObject3);
      if (f == -1)
      {
        h = null;
        g = null;
      }
      for (;;)
      {
        g.add(localObject3);
        i2 += 1;
        break;
        if (g != null)
        {
          if (g.getId() == f) {
            break label165;
          }
          i1 = 0;
        }
        for (;;)
        {
          if (i1 != 0) {
            break label254;
          }
          g = findViewById(f);
          if (g == null) {
            break label372;
          }
          if (g != this) {
            break label267;
          }
          if (!isInEditMode()) {
            break label256;
          }
          h = null;
          g = null;
          break;
          localObject2 = g;
          for (localObject1 = g.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
          {
            if (localObject1 == this) {
              break label244;
            }
            if ((localObject1 == null) || (localObject1 == localObject3))
            {
              h = null;
              g = null;
              i1 = 0;
              break;
            }
            if ((localObject1 instanceof View)) {
              localObject2 = (View)localObject1;
            }
          }
          label244:
          h = ((View)localObject2);
          i1 = 1;
        }
        label254:
        continue;
        label256:
        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        label267:
        localObject2 = g;
        for (localObject1 = g.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
        {
          if ((localObject1 == this) || (localObject1 == null)) {
            break label362;
          }
          if (localObject1 == localObject3)
          {
            if (isInEditMode())
            {
              h = null;
              g = null;
              break;
            }
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
          }
          if ((localObject1 instanceof View)) {
            localObject2 = (View)localObject1;
          }
        }
        label362:
        h = ((View)localObject2);
        continue;
        label372:
        if (!isInEditMode()) {
          break label394;
        }
        h = null;
        g = null;
      }
      label394:
      throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(f) + " to anchor view " + localObject3);
    }
    a(g, d);
    b();
    int i10 = getPaddingLeft();
    int i11 = getPaddingTop();
    int i12 = getPaddingRight();
    int i13 = getPaddingBottom();
    int i14 = rg.g(this);
    int i7;
    int i6;
    label548:
    int i4;
    int i5;
    label565:
    int i8;
    int i9;
    int i20;
    if (i14 == 1)
    {
      i2 = 1;
      int i15 = View.MeasureSpec.getMode(paramInt1);
      int i16 = View.MeasureSpec.getSize(paramInt1);
      int i17 = View.MeasureSpec.getMode(paramInt2);
      int i18 = View.MeasureSpec.getSize(paramInt2);
      i7 = getSuggestedMinimumWidth();
      i6 = getSuggestedMinimumHeight();
      if ((j == null) || (!rg.t(this))) {
        break label898;
      }
      i3 = 1;
      int i19 = g.size();
      i4 = 0;
      i5 = 0;
      if (i4 >= i19) {
        break label945;
      }
      localObject1 = (View)g.get(i4);
      localObject2 = (ag)((View)localObject1).getLayoutParams();
      i8 = 0;
      i1 = i8;
      if (e >= 0)
      {
        i1 = i8;
        if (i15 != 0)
        {
          i9 = a(e);
          i20 = pg.a(c(c), i14) & 0x7;
          if (((i20 != 3) || (i2 != 0)) && ((i20 != 5) || (i2 == 0))) {
            break label904;
          }
          i1 = Math.max(0, i16 - i12 - i9);
        }
      }
      label684:
      if ((i3 == 0) || (rg.t((View)localObject1))) {
        break label973;
      }
      i8 = j.a();
      int i21 = j.c();
      i9 = j.b();
      i20 = j.d();
      i8 = View.MeasureSpec.makeMeasureSpec(i16 - (i8 + i21), i15);
      i9 = View.MeasureSpec.makeMeasureSpec(i18 - (i9 + i20), i17);
    }
    for (;;)
    {
      localObject3 = a;
      if ((localObject3 == null) || (!((ad)localObject3).a(this, (View)localObject1, i8, i1, i9, 0))) {
        a((View)localObject1, i8, i1, i9, 0);
      }
      i7 = Math.max(i7, ((View)localObject1).getMeasuredWidth() + (i10 + i12) + leftMargin + rightMargin);
      i6 = Math.max(i6, ((View)localObject1).getMeasuredHeight() + (i11 + i13) + topMargin + bottomMargin);
      i1 = rg.i((View)localObject1);
      i5 = rg.a.a(i5, i1);
      i4 += 1;
      break label565;
      i2 = 0;
      break;
      label898:
      i3 = 0;
      break label548;
      label904:
      if ((i20 != 5) || (i2 != 0))
      {
        i1 = i8;
        if (i20 != 3) {
          break label684;
        }
        i1 = i8;
        if (i2 == 0) {
          break label684;
        }
      }
      i1 = Math.max(0, i9 - i10);
      break label684;
      label945:
      setMeasuredDimension(rg.a(i7, paramInt1, 0xFF000000 & i5), rg.a(i6, paramInt2, i5 << 16));
      return;
      label973:
      i9 = paramInt2;
      i8 = paramInt1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    boolean bool = false;
    if (i1 < i2)
    {
      paramView = getChildAt(i1);
      Object localObject = (ag)paramView.getLayoutParams();
      if (!j) {
        break label92;
      }
      localObject = a;
      if (localObject == null) {
        break label92;
      }
      bool = ((ad)localObject).a(this, paramView, paramFloat2, paramBoolean) | bool;
    }
    label92:
    for (;;)
    {
      i1 += 1;
      break;
      if (bool) {
        a(true);
      }
      return bool;
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int i2 = getChildCount();
    int i1 = 0;
    boolean bool = false;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      Object localObject = (ag)localView.getLayoutParams();
      if (!j) {
        break label85;
      }
      localObject = a;
      if (localObject == null) {
        break label85;
      }
      bool = ((ad)localObject).a(this, localView, paramView, paramFloat1, paramFloat2) | bool;
    }
    label85:
    for (;;)
    {
      i1 += 1;
      break;
      return bool;
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i2 = 0;
    int i1 = 0;
    int i3 = 0;
    int i6 = getChildCount();
    int i4 = 0;
    label112:
    label129:
    int i5;
    if (i4 < i6)
    {
      View localView = getChildAt(i4);
      Object localObject = (ag)localView.getLayoutParams();
      if (!j) {
        break label220;
      }
      localObject = a;
      if (localObject == null) {
        break label220;
      }
      int[] arrayOfInt = p;
      p[1] = 0;
      arrayOfInt[0] = 0;
      ((ad)localObject).a(this, localView, paramView, paramInt2, p);
      if (paramInt1 > 0)
      {
        i2 = Math.max(i2, p[0]);
        if (paramInt2 <= 0) {
          break label181;
        }
        i1 = Math.max(i1, p[1]);
        i5 = 1;
        i3 = i1;
        i1 = i5;
      }
    }
    for (;;)
    {
      i5 = i4 + 1;
      i4 = i3;
      i3 = i1;
      i1 = i4;
      i4 = i5;
      break;
      i2 = Math.min(i2, p[0]);
      break label112;
      label181:
      i1 = Math.min(i1, p[1]);
      break label129;
      paramArrayOfInt[0] = i2;
      paramArrayOfInt[1] = i1;
      if (i3 != 0) {
        a(true);
      }
      return;
      label220:
      i5 = i1;
      i1 = i3;
      i3 = i5;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = getChildCount();
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt2 < paramInt3)
    {
      paramView = getChildAt(paramInt2);
      Object localObject = (ag)paramView.getLayoutParams();
      if (!j) {
        break label79;
      }
      localObject = a;
      if (localObject == null) {
        break label79;
      }
      ((ad)localObject).b(this, paramView, paramInt4);
      paramInt1 = 1;
    }
    label79:
    for (;;)
    {
      paramInt2 += 1;
      break;
      if (paramInt1 != 0) {
        a(true);
      }
      return;
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    z.a = paramInt;
    u = paramView1;
    v = paramView2;
    int i1 = getChildCount();
    paramInt = 0;
    while (paramInt < i1)
    {
      getChildAt(paramInt).getLayoutParams();
      paramInt += 1;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof CoordinatorLayout.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (CoordinatorLayout.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      paramParcelable = a;
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = getChildAt(i1);
        int i3 = localView.getId();
        ad localad = ba;
        if ((i3 != -1) && (localad != null))
        {
          Parcelable localParcelable = (Parcelable)paramParcelable.get(i3);
          if (localParcelable != null) {
            localad.a(this, localView, localParcelable);
          }
        }
        i1 += 1;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    CoordinatorLayout.SavedState localSavedState = new CoordinatorLayout.SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = getChildAt(i1);
      int i3 = ((View)localObject).getId();
      ad localad = getLayoutParamsa;
      if ((i3 != -1) && (localad != null))
      {
        localObject = localad.b(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(i3, localObject);
        }
      }
      i1 += 1;
    }
    a = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    int i2 = getChildCount();
    int i1 = 0;
    boolean bool1 = false;
    if (i1 < i2)
    {
      paramView2 = getChildAt(i1);
      ag localag = (ag)paramView2.getLayoutParams();
      ad localad = a;
      if (localad != null)
      {
        boolean bool2 = localad.a(this, paramView2, paramView1, paramInt);
        j = bool2;
        bool1 |= bool2;
      }
      for (;;)
      {
        i1 += 1;
        break;
        j = false;
      }
    }
    return bool1;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    z.a = 0;
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      ag localag = (ag)localView.getLayoutParams();
      if (j)
      {
        ad localad = a;
        if (localad != null) {
          localad.a(this, localView, paramView);
        }
        j = false;
        k = false;
      }
      i1 += 1;
    }
    u = null;
    v = null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = qk.a(paramMotionEvent);
    boolean bool2;
    if (t == null)
    {
      bool2 = a(paramMotionEvent, 1);
      if (!bool2) {}
    }
    for (;;)
    {
      ad localad = t.getLayoutParams()).a;
      boolean bool1;
      if (localad != null) {
        bool1 = localad.b(this, t, paramMotionEvent);
      }
      for (;;)
      {
        if (t == null)
        {
          bool1 |= super.onTouchEvent(paramMotionEvent);
          paramMotionEvent = null;
        }
        for (;;)
        {
          if (paramMotionEvent != null) {
            paramMotionEvent.recycle();
          }
          if ((i1 == 1) || (i1 == 3)) {
            a();
          }
          return bool1;
          if (bool2)
          {
            long l1 = SystemClock.uptimeMillis();
            paramMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
            super.onTouchEvent(paramMotionEvent);
          }
          else
          {
            paramMotionEvent = null;
          }
        }
        bool1 = false;
        continue;
        bool1 = false;
      }
      bool2 = false;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!q))
    {
      a();
      q = true;
    }
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    l = paramOnHierarchyChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((y != null) && (y.isVisible() != bool)) {
        y.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == y);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CoordinatorLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */