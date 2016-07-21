package android.support.v7.widget;

import aca;
import ack;
import adv;
import ady;
import aek;
import afn;
import agj;
import ahw;
import alq;
import amp;
import amq;
import amr;
import amt;
import amu;
import amv;
import amx;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import ane;
import java.util.ArrayList;
import java.util.List;
import pg;
import qa;
import qb;
import qe;
import qk;
import rg;
import zd;

public class Toolbar
  extends ViewGroup
{
  private int A;
  private int B;
  private int C;
  private int D = 8388627;
  private int E;
  private int F;
  private boolean G;
  private boolean H;
  private final ArrayList<View> I = new ArrayList();
  private final int[] J = new int[2];
  private final afn K = new amq(this);
  private amx L;
  private final Runnable M = new amr(this);
  private final agj N;
  public ActionMenuView a;
  public TextView b;
  public Drawable c;
  public CharSequence d;
  public ImageButton e;
  public View f;
  public Context g;
  public int h;
  public int i;
  public int j;
  public final alq k = new alq();
  public CharSequence l;
  public CharSequence m;
  public final ArrayList<View> n = new ArrayList();
  public amv o;
  public ActionMenuPresenter p;
  public amt q;
  public aek r;
  public adv s;
  public boolean t;
  private TextView u;
  private ImageButton v;
  private ImageView w;
  private int x;
  private int y;
  private int z;
  
  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, aca.P);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = amp.a(getContext(), paramAttributeSet, ack.cX, paramInt);
    x = paramContext.e(ack.du, 0);
    i = paramContext.e(ack.dm, 0);
    paramInt = ack.cY;
    int i1 = D;
    D = a.getInteger(paramInt, i1);
    j = 48;
    paramInt = paramContext.b(ack.dt, 0);
    C = paramInt;
    B = paramInt;
    A = paramInt;
    z = paramInt;
    paramInt = paramContext.b(ack.dr, -1);
    if (paramInt >= 0) {
      z = paramInt;
    }
    paramInt = paramContext.b(ack.dq, -1);
    if (paramInt >= 0) {
      A = paramInt;
    }
    paramInt = paramContext.b(ack.ds, -1);
    if (paramInt >= 0) {
      B = paramInt;
    }
    paramInt = paramContext.b(ack.dp, -1);
    if (paramInt >= 0) {
      C = paramInt;
    }
    y = paramContext.c(ack.dh, -1);
    paramInt = paramContext.b(ack.de, Integer.MIN_VALUE);
    i1 = paramContext.b(ack.db, Integer.MIN_VALUE);
    int i2 = paramContext.c(ack.dc, 0);
    int i3 = paramContext.c(ack.dd, 0);
    paramAttributeSet = k;
    h = false;
    if (i2 != Integer.MIN_VALUE)
    {
      e = i2;
      a = i2;
    }
    if (i3 != Integer.MIN_VALUE)
    {
      f = i3;
      b = i3;
    }
    if ((paramInt != Integer.MIN_VALUE) || (i1 != Integer.MIN_VALUE)) {
      k.a(paramInt, i1);
    }
    c = paramContext.a(ack.da);
    d = paramContext.c(ack.cZ);
    paramAttributeSet = paramContext.c(ack.do);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      a(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(ack.dl);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      b(paramAttributeSet);
    }
    g = getContext();
    a(paramContext.e(ack.dk, 0));
    paramAttributeSet = paramContext.a(ack.dj);
    if (paramAttributeSet != null) {
      b(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(ack.di);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      c(paramAttributeSet);
    }
    paramAttributeSet = paramContext.a(ack.df);
    if (paramAttributeSet != null) {
      a(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(ack.dg);
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      if (!TextUtils.isEmpty(paramAttributeSet)) {
        i();
      }
      if (w != null) {
        w.setContentDescription(paramAttributeSet);
      }
    }
    if (paramContext.e(ack.dv)) {
      b(paramContext.d(ack.dv));
    }
    if (paramContext.e(ack.dn))
    {
      paramInt = paramContext.d(ack.dn);
      F = paramInt;
      if (b != null) {
        b.setTextColor(paramInt);
      }
    }
    a.recycle();
    N = agj.a();
  }
  
  private final int a(View paramView, int paramInt)
  {
    amu localamu = (amu)paramView.getLayoutParams();
    int i3 = paramView.getMeasuredHeight();
    int i2;
    int i1;
    int i4;
    if (paramInt > 0)
    {
      paramInt = (i3 - paramInt) / 2;
      i2 = a & 0x70;
      i1 = i2;
      switch (i2)
      {
      default: 
        i1 = D & 0x70;
      }
      switch (i1)
      {
      default: 
        i1 = getPaddingTop();
        i2 = getPaddingBottom();
        i4 = getHeight();
        paramInt = (i4 - i1 - i2 - i3) / 2;
        if (paramInt < topMargin) {
          paramInt = topMargin;
        }
        break;
      }
    }
    for (;;)
    {
      return paramInt + i1;
      paramInt = 0;
      break;
      return getPaddingTop() - paramInt;
      return getHeight() - getPaddingBottom() - i3 - bottomMargin - paramInt;
      i2 = i4 - i2 - i3 - paramInt - i1;
      if (i2 < bottomMargin) {
        paramInt = Math.max(0, paramInt - (bottomMargin - i2));
      }
    }
  }
  
  private final int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = leftMargin - paramArrayOfInt[0];
    int i2 = rightMargin - paramArrayOfInt[1];
    int i3 = Math.max(0, i1) + Math.max(0, i2);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramArrayOfInt[1] = Math.max(0, -i2);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + i3 + paramInt2, width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin + paramInt4, height));
    return paramView.getMeasuredWidth() + i3;
  }
  
  private final int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    amu localamu = (amu)paramView.getLayoutParams();
    int i1 = leftMargin - paramArrayOfInt[0];
    paramInt1 = Math.max(0, i1) + paramInt1;
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i1, paramView.getMeasuredHeight() + paramInt2);
    return rightMargin + i1 + paramInt1;
  }
  
  private static amu a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof amu)) {
      return new amu((amu)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof zd)) {
      return new amu((zd)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new amu((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new amu(paramLayoutParams);
  }
  
  private final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin + paramInt2, width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin + 0, height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt4 >= 0)
      {
        paramInt1 = paramInt4;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt4);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i1, paramInt1);
  }
  
  private final void a(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = new amu();
    }
    for (;;)
    {
      b = 1;
      if ((!paramBoolean) || (f == null)) {
        break;
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      n.add(paramView);
      return;
      if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
        localObject = a((ViewGroup.LayoutParams)localObject);
      } else {
        localObject = (amu)localObject;
      }
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private final void a(List<View> paramList, int paramInt)
  {
    int i1 = 1;
    int i2 = 0;
    if (rg.g(this) == 1) {}
    int i4;
    int i3;
    View localView;
    amu localamu;
    for (;;)
    {
      i4 = getChildCount();
      i3 = pg.a(paramInt, rg.g(this));
      paramList.clear();
      paramInt = i2;
      if (i1 == 0) {
        break;
      }
      paramInt = i4 - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localamu = (amu)localView.getLayoutParams();
        if ((b == 0) && (a(localView)) && (c(a) == i3)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      i1 = 0;
    }
    while (paramInt < i4)
    {
      localView = getChildAt(paramInt);
      localamu = (amu)localView.getLayoutParams();
      if ((b == 0) && (a(localView)) && (c(a) == i3)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private final boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private static int b(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = qa.a.a(paramView);
    return qa.a.b(paramView) + i1;
  }
  
  private final int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    amu localamu = (amu)paramView.getLayoutParams();
    int i1 = rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i1);
    paramArrayOfInt[1] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i1, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (leftMargin + i1);
  }
  
  private final int c(int paramInt)
  {
    int i2 = rg.g(this);
    int i1 = pg.a(paramInt, i2) & 0x7;
    paramInt = i1;
    switch (i1)
    {
    case 2: 
    case 4: 
    default: 
      if (i2 == 1) {
        paramInt = 5;
      }
      break;
    case 1: 
    case 3: 
    case 5: 
      return paramInt;
    }
    return 3;
  }
  
  private static int c(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = topMargin;
    return bottomMargin + i1;
  }
  
  private final boolean d(View paramView)
  {
    return (paramView.getParent() == this) || (n.contains(paramView));
  }
  
  private final void i()
  {
    if (w == null) {
      w = new ImageView(getContext());
    }
  }
  
  private final void j()
  {
    if (v == null)
    {
      v = new ImageButton(getContext(), null, aca.O);
      amu localamu = new amu();
      a = (0x800003 | j & 0x70);
      v.setLayoutParams(localamu);
    }
  }
  
  public final void a(int paramInt)
  {
    if (h != paramInt)
    {
      h = paramInt;
      if (paramInt == 0) {
        g = getContext();
      }
    }
    else
    {
      return;
    }
    g = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    x = paramInt;
    if (u != null) {
      u.setTextAppearance(paramContext, paramInt);
    }
  }
  
  public final void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      i();
      if (!d(w)) {
        a(w, true);
      }
    }
    for (;;)
    {
      if (w != null) {
        w.setImageDrawable(paramDrawable);
      }
      return;
      if ((w != null) && (d(w)))
      {
        removeView(w);
        n.remove(w);
      }
    }
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    j();
    v.setOnClickListener(paramOnClickListener);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (u == null)
      {
        Context localContext = getContext();
        u = new TextView(localContext);
        u.setSingleLine();
        u.setEllipsize(TextUtils.TruncateAt.END);
        if (x != 0) {
          u.setTextAppearance(localContext, x);
        }
        if (E != 0) {
          u.setTextColor(E);
        }
      }
      if (!d(u)) {
        a(u, true);
      }
    }
    for (;;)
    {
      if (u != null) {
        u.setText(paramCharSequence);
      }
      l = paramCharSequence;
      return;
      if ((u != null) && (d(u)))
      {
        removeView(u);
        n.remove(u);
      }
    }
  }
  
  public final boolean a()
  {
    if (a != null)
    {
      ActionMenuView localActionMenuView = a;
      if ((c != null) && (c.i())) {}
      for (int i1 = 1; i1 != 0; i1 = 0) {
        return true;
      }
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    E = paramInt;
    if (u != null) {
      u.setTextColor(paramInt);
    }
  }
  
  public final void b(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      j();
      if (!d(v)) {
        a(v, true);
      }
    }
    for (;;)
    {
      if (v != null) {
        v.setImageDrawable(paramDrawable);
      }
      return;
      if ((v != null) && (d(v)))
      {
        removeView(v);
        n.remove(v);
      }
    }
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (b == null)
      {
        Context localContext = getContext();
        b = new TextView(localContext);
        b.setSingleLine();
        b.setEllipsize(TextUtils.TruncateAt.END);
        if (i != 0) {
          b.setTextAppearance(localContext, i);
        }
        if (F != 0) {
          b.setTextColor(F);
        }
      }
      if (!d(b)) {
        a(b, true);
      }
    }
    for (;;)
    {
      if (b != null) {
        b.setText(paramCharSequence);
      }
      m = paramCharSequence;
      return;
      if ((b != null) && (d(b)))
      {
        removeView(b);
        n.remove(b);
      }
    }
  }
  
  public final boolean b()
  {
    if (a != null)
    {
      ActionMenuView localActionMenuView = a;
      if ((c != null) && (c.e())) {}
      for (int i1 = 1; i1 != 0; i1 = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void c()
  {
    if (q == null) {}
    for (ady localady = null;; localady = q.b)
    {
      if (localady != null) {
        localady.collapseActionView();
      }
      return;
    }
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      j();
    }
    if (v != null) {
      v.setContentDescription(paramCharSequence);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof amu));
  }
  
  public final CharSequence d()
  {
    if (v != null) {
      return v.getContentDescription();
    }
    return null;
  }
  
  public final Drawable e()
  {
    if (v != null) {
      return v.getDrawable();
    }
    return null;
  }
  
  public final void f()
  {
    if (a == null)
    {
      a = new ActionMenuView(getContext());
      a.a(h);
      a.e = K;
      a.a(r, s);
      amu localamu = new amu();
      a = (0x800005 | j & 0x70);
      a.setLayoutParams(localamu);
      a(a, false);
    }
  }
  
  public final ahw g()
  {
    if (L == null) {
      L = new amx(this, true);
    }
    return L;
  }
  
  public final void h()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = getChildAt(i1);
      if ((getLayoutParamsb != 2) && (localView != a))
      {
        removeViewAt(i1);
        n.add(localView);
      }
      i1 -= 1;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(M);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i1 = qk.a(paramMotionEvent);
    if (i1 == 9) {
      H = false;
    }
    if (!H)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i1 == 9) && (!bool)) {
        H = true;
      }
    }
    if ((i1 == 10) || (i1 == 3)) {
      H = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i3;
    int i6;
    int i9;
    int i1;
    int i7;
    int i8;
    int i10;
    int[] arrayOfInt;
    int i5;
    if (rg.g(this) == 1)
    {
      i3 = 1;
      i6 = getWidth();
      i9 = getHeight();
      i1 = getPaddingLeft();
      i7 = getPaddingRight();
      i8 = getPaddingTop();
      i10 = getPaddingBottom();
      paramInt4 = i6 - i7;
      arrayOfInt = J;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      i5 = rg.p(this);
      if (!a(v)) {
        break label1721;
      }
      if (i3 == 0) {
        break label888;
      }
      paramInt4 = b(v, paramInt4, arrayOfInt, i5);
      paramInt1 = i1;
    }
    for (;;)
    {
      label111:
      paramInt2 = paramInt4;
      paramInt3 = paramInt1;
      if (a(e))
      {
        if (i3 != 0)
        {
          paramInt2 = b(e, paramInt4, arrayOfInt, i5);
          paramInt3 = paramInt1;
        }
      }
      else
      {
        label151:
        paramInt1 = paramInt2;
        paramInt4 = paramInt3;
        if (a(a))
        {
          if (i3 == 0) {
            break label927;
          }
          paramInt4 = a(a, paramInt3, arrayOfInt, i5);
          paramInt1 = paramInt2;
        }
        label191:
        arrayOfInt[0] = Math.max(0, k.a - paramInt4);
        arrayOfInt[1] = Math.max(0, k.b - (i6 - i7 - paramInt1));
        paramInt3 = Math.max(paramInt4, k.a);
        paramInt4 = Math.min(paramInt1, i6 - i7 - k.b);
        paramInt2 = paramInt4;
        paramInt1 = paramInt3;
        if (a(f))
        {
          if (i3 == 0) {
            break label948;
          }
          paramInt2 = b(f, paramInt4, arrayOfInt, i5);
          paramInt1 = paramInt3;
        }
        label305:
        if (!a(w)) {
          break label1715;
        }
        if (i3 == 0) {
          break label969;
        }
        paramInt2 = b(w, paramInt2, arrayOfInt, i5);
        paramInt3 = paramInt1;
      }
      for (;;)
      {
        label338:
        paramBoolean = a(u);
        boolean bool = a(b);
        paramInt1 = 0;
        Object localObject1;
        if (paramBoolean)
        {
          localObject1 = (amu)u.getLayoutParams();
          paramInt1 = topMargin;
          paramInt4 = u.getMeasuredHeight();
          paramInt1 = bottomMargin + (paramInt1 + paramInt4) + 0;
        }
        int i2;
        if (bool)
        {
          localObject1 = (amu)b.getLayoutParams();
          paramInt4 = topMargin;
          i2 = b.getMeasuredHeight();
        }
        for (int i4 = bottomMargin + (paramInt4 + i2) + paramInt1;; i4 = paramInt1)
        {
          label476:
          Object localObject2;
          if (!paramBoolean)
          {
            paramInt4 = paramInt2;
            paramInt1 = paramInt3;
            if (!bool) {}
          }
          else
          {
            if (!paramBoolean) {
              break label987;
            }
            localObject1 = u;
            if (!bool) {
              break label996;
            }
            localObject2 = b;
            label487:
            localObject1 = (amu)((View)localObject1).getLayoutParams();
            localObject2 = (amu)((View)localObject2).getLayoutParams();
            if (((!paramBoolean) || (u.getMeasuredWidth() <= 0)) && ((!bool) || (b.getMeasuredWidth() <= 0))) {
              break label1005;
            }
            i2 = 1;
            label539:
            switch (D & 0x70)
            {
            default: 
              paramInt1 = (i9 - i8 - i10 - i4) / 2;
              if (paramInt1 < topMargin + B) {
                paramInt1 = topMargin + B;
              }
              break;
            }
          }
          label611:
          label616:
          label632:
          label888:
          label927:
          label948:
          label969:
          label987:
          label996:
          label1005:
          label1125:
          label1683:
          label1700:
          label1706:
          for (;;)
          {
            paramInt1 = i8 + paramInt1;
            if (i3 != 0) {
              if (i2 != 0)
              {
                paramInt4 = z;
                paramInt4 -= arrayOfInt[1];
                paramInt2 -= Math.max(0, paramInt4);
                arrayOfInt[1] = Math.max(0, -paramInt4);
                if (!paramBoolean) {
                  break label1700;
                }
                localObject1 = (amu)u.getLayoutParams();
                paramInt4 = paramInt2 - u.getMeasuredWidth();
                i3 = u.getMeasuredHeight() + paramInt1;
                u.layout(paramInt4, paramInt1, paramInt2, i3);
                i4 = A;
                paramInt1 = i3 + bottomMargin;
                paramInt4 -= i4;
              }
            }
            for (;;)
            {
              if (bool)
              {
                localObject1 = (amu)b.getLayoutParams();
                paramInt1 = topMargin + paramInt1;
                i3 = b.getMeasuredWidth();
                i4 = b.getMeasuredHeight();
                b.layout(paramInt2 - i3, paramInt1, paramInt2, i4 + paramInt1);
                paramInt1 = A;
                i3 = bottomMargin;
              }
              for (paramInt1 = paramInt2 - paramInt1;; paramInt1 = paramInt2)
              {
                if (i2 != 0) {}
                for (paramInt1 = Math.min(paramInt4, paramInt1);; paramInt1 = paramInt2)
                {
                  paramInt4 = paramInt1;
                  paramInt1 = paramInt3;
                  a(I, 3);
                  paramInt3 = I.size();
                  paramInt2 = 0;
                  for (;;)
                  {
                    if (paramInt2 < paramInt3)
                    {
                      paramInt1 = a((View)I.get(paramInt2), paramInt1, arrayOfInt, i5);
                      paramInt2 += 1;
                      continue;
                      i3 = 0;
                      break;
                      paramInt1 = a(v, i1, arrayOfInt, i5);
                      break label111;
                      paramInt3 = a(e, paramInt1, arrayOfInt, i5);
                      paramInt2 = paramInt4;
                      break label151;
                      paramInt1 = b(a, paramInt2, arrayOfInt, i5);
                      paramInt4 = paramInt3;
                      break label191;
                      paramInt1 = a(f, paramInt3, arrayOfInt, i5);
                      paramInt2 = paramInt4;
                      break label305;
                      paramInt3 = a(w, paramInt1, arrayOfInt, i5);
                      break label338;
                      localObject1 = b;
                      break label476;
                      localObject2 = u;
                      break label487;
                      i2 = 0;
                      break label539;
                      paramInt1 = getPaddingTop();
                      paramInt1 = topMargin + paramInt1 + B;
                      break label616;
                      paramInt4 = i9 - i10 - i4 - paramInt1 - i8;
                      if (paramInt4 >= bottomMargin + C) {
                        break label1706;
                      }
                      paramInt1 = Math.max(0, paramInt1 - (bottomMargin + C - paramInt4));
                      break label611;
                      paramInt1 = i9 - i10 - bottomMargin - C - i4;
                      break label616;
                      paramInt4 = 0;
                      break label632;
                      if (i2 != 0)
                      {
                        paramInt4 = z;
                        paramInt4 -= arrayOfInt[0];
                        paramInt3 += Math.max(0, paramInt4);
                        arrayOfInt[0] = Math.max(0, -paramInt4);
                        if (!paramBoolean) {
                          break label1683;
                        }
                        localObject1 = (amu)u.getLayoutParams();
                        i3 = u.getMeasuredWidth() + paramInt3;
                        paramInt4 = u.getMeasuredHeight() + paramInt1;
                        u.layout(paramInt3, paramInt1, i3, paramInt4);
                        i4 = A;
                        paramInt1 = bottomMargin;
                        i3 += i4;
                        paramInt1 += paramInt4;
                      }
                    }
                  }
                  for (;;)
                  {
                    if (bool)
                    {
                      localObject1 = (amu)b.getLayoutParams();
                      paramInt4 = paramInt1 + topMargin;
                      paramInt1 = b.getMeasuredWidth() + paramInt3;
                      i4 = b.getMeasuredHeight();
                      b.layout(paramInt3, paramInt4, paramInt1, i4 + paramInt4);
                      paramInt4 = A;
                      i4 = bottomMargin;
                    }
                    for (i4 = paramInt4 + paramInt1;; i4 = paramInt3)
                    {
                      paramInt4 = paramInt2;
                      paramInt1 = paramInt3;
                      if (i2 == 0) {
                        break;
                      }
                      paramInt1 = Math.max(i3, i4);
                      paramInt4 = paramInt2;
                      break;
                      paramInt4 = 0;
                      break label1125;
                      a(I, 5);
                      i2 = I.size();
                      paramInt3 = 0;
                      paramInt2 = paramInt4;
                      while (paramInt3 < i2)
                      {
                        paramInt2 = b((View)I.get(paramInt3), paramInt2, arrayOfInt, i5);
                        paramInt3 += 1;
                      }
                      a(I, 1);
                      localObject1 = I;
                      i3 = arrayOfInt[0];
                      i2 = arrayOfInt[1];
                      i4 = ((List)localObject1).size();
                      paramInt4 = 0;
                      paramInt3 = 0;
                      while (paramInt4 < i4)
                      {
                        localObject2 = (View)((List)localObject1).get(paramInt4);
                        amu localamu = (amu)((View)localObject2).getLayoutParams();
                        i3 = leftMargin - i3;
                        i2 = rightMargin - i2;
                        i8 = Math.max(0, i3);
                        i9 = Math.max(0, i2);
                        i3 = Math.max(0, -i3);
                        i2 = Math.max(0, -i2);
                        i10 = ((View)localObject2).getMeasuredWidth();
                        paramInt4 += 1;
                        paramInt3 += i10 + i8 + i9;
                      }
                      paramInt4 = (i6 - i1 - i7) / 2 + i1 - paramInt3 / 2;
                      paramInt3 = paramInt4 + paramInt3;
                      if (paramInt4 < paramInt1) {}
                      for (;;)
                      {
                        paramInt4 = I.size();
                        paramInt3 = 0;
                        paramInt2 = paramInt1;
                        paramInt1 = paramInt3;
                        while (paramInt1 < paramInt4)
                        {
                          paramInt2 = a((View)I.get(paramInt1), paramInt2, arrayOfInt, i5);
                          paramInt1 += 1;
                        }
                        paramInt1 = paramInt4;
                        if (paramInt3 > paramInt2) {
                          paramInt1 = paramInt4 - (paramInt3 - paramInt2);
                        }
                      }
                      I.clear();
                      return;
                    }
                    i3 = paramInt3;
                  }
                }
              }
              paramInt4 = paramInt2;
            }
          }
        }
        label1715:
        paramInt3 = paramInt1;
      }
      label1721:
      paramInt1 = i1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject1 = J;
    int i5;
    int i6;
    int i1;
    int i4;
    int i3;
    if (ane.a(this))
    {
      i5 = 0;
      i6 = 1;
      i1 = 0;
      if (!a(v)) {
        break label1057;
      }
      a(v, paramInt1, 0, paramInt2, y);
      i1 = v.getMeasuredWidth() + b(v);
      i4 = Math.max(0, v.getMeasuredHeight() + c(v));
      i3 = ane.a(0, rg.i(v));
    }
    for (;;)
    {
      int i7 = i1;
      i1 = i3;
      int i2 = i4;
      if (a(e))
      {
        a(e, paramInt1, 0, paramInt2, y);
        i7 = e.getMeasuredWidth() + b(e);
        i2 = Math.max(i4, e.getMeasuredHeight() + c(e));
        i1 = ane.a(i3, rg.i(e));
      }
      Object localObject2 = k;
      label206:
      int i8;
      if (g)
      {
        i3 = b;
        i8 = Math.max(i3, i7) + 0;
        localObject1[i6] = Math.max(0, i3 - i7);
        i6 = 0;
        i3 = i1;
        i4 = i2;
        if (a(a))
        {
          a(a, paramInt1, i8, paramInt2, y);
          i6 = a.getMeasuredWidth() + b(a);
          i4 = Math.max(i2, a.getMeasuredHeight() + c(a));
          i3 = ane.a(i1, rg.i(a));
        }
        localObject2 = k;
        if (!g) {
          break label668;
        }
        i1 = a;
        label340:
        i7 = i8 + Math.max(i1, i6);
        localObject1[i5] = Math.max(0, i1 - i6);
        i5 = i7;
        i1 = i3;
        i2 = i4;
        if (a(f))
        {
          i5 = i7 + a(f, paramInt1, i7, paramInt2, 0, (int[])localObject1);
          i2 = Math.max(i4, f.getMeasuredHeight() + c(f));
          i1 = ane.a(i3, rg.i(f));
        }
        i3 = i5;
        i6 = i1;
        i4 = i2;
        if (a(w))
        {
          i3 = i5 + a(w, paramInt1, i5, paramInt2, 0, (int[])localObject1);
          i4 = Math.max(i2, w.getMeasuredHeight() + c(w));
          i6 = ane.a(i1, rg.i(w));
        }
        i7 = getChildCount();
        i5 = 0;
        i1 = i6;
        i2 = i4;
        i4 = i5;
        i6 = i3;
        label542:
        if (i4 >= i7) {
          break label677;
        }
        localObject2 = getChildAt(i4);
        if ((getLayoutParamsb != 0) || (!a((View)localObject2))) {
          break label1044;
        }
        i6 += a((View)localObject2, paramInt1, i6, paramInt2, 0, (int[])localObject1);
        i3 = Math.max(i2, ((View)localObject2).getMeasuredHeight() + c((View)localObject2));
        i2 = ane.a(i1, rg.i((View)localObject2));
      }
      for (i1 = i3;; i1 = i3)
      {
        i4 += 1;
        i3 = i1;
        i1 = i2;
        i2 = i3;
        break label542;
        i5 = 1;
        i6 = 0;
        break;
        i3 = a;
        break label206;
        label668:
        i1 = b;
        break label340;
        label677:
        i5 = 0;
        i4 = 0;
        int i9 = B + C;
        int i10 = z + A;
        i3 = i1;
        if (a(u))
        {
          a(u, paramInt1, i6 + i10, paramInt2, i9, (int[])localObject1);
          i3 = u.getMeasuredWidth();
          i5 = b(u) + i3;
          i4 = u.getMeasuredHeight() + c(u);
          i3 = ane.a(i1, rg.i(u));
        }
        i8 = i4;
        i7 = i5;
        i1 = i3;
        if (a(b))
        {
          i7 = Math.max(i5, a(b, paramInt1, i6 + i10, paramInt2, i9 + i4, (int[])localObject1));
          i8 = i4 + (b.getMeasuredHeight() + c(b));
          i1 = ane.a(i3, rg.i(b));
        }
        i3 = Math.max(i2, i8);
        i2 = getPaddingLeft();
        i8 = getPaddingRight();
        i4 = getPaddingTop();
        i5 = getPaddingBottom();
        i2 = rg.a(Math.max(i7 + i6 + (i2 + i8), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i1);
        paramInt2 = rg.a(Math.max(i3 + (i4 + i5), getSuggestedMinimumHeight()), paramInt2, i1 << 16);
        if (!t) {
          paramInt1 = 0;
        }
        for (;;)
        {
          if (paramInt1 != 0) {
            paramInt2 = 0;
          }
          setMeasuredDimension(i2, paramInt2);
          return;
          i1 = getChildCount();
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= i1) {
              break label1039;
            }
            localObject1 = getChildAt(paramInt1);
            if ((a((View)localObject1)) && (((View)localObject1).getMeasuredWidth() > 0) && (((View)localObject1).getMeasuredHeight() > 0))
            {
              paramInt1 = 0;
              break;
            }
            paramInt1 += 1;
          }
          label1039:
          paramInt1 = 1;
        }
        label1044:
        i3 = i2;
        i2 = i1;
      }
      label1057:
      i3 = 0;
      i4 = 0;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof Toolbar.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    Toolbar.SavedState localSavedState = (Toolbar.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (a != null) {}
    for (paramParcelable = a.a;; paramParcelable = null)
    {
      if ((a != 0) && (q != null) && (paramParcelable != null))
      {
        paramParcelable = paramParcelable.findItem(a);
        if (paramParcelable != null) {
          qe.b(paramParcelable);
        }
      }
      if (!b) {
        break;
      }
      removeCallbacks(M);
      post(M);
      return;
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    alq localalq = k;
    if (paramInt == 1) {
      if (bool != g)
      {
        g = bool;
        if (!h) {
          break label164;
        }
        if (!bool) {
          break label109;
        }
        if (d == Integer.MIN_VALUE) {
          break label93;
        }
        paramInt = d;
        label63:
        a = paramInt;
        if (c == Integer.MIN_VALUE) {
          break label101;
        }
      }
    }
    label93:
    label101:
    for (paramInt = c;; paramInt = f)
    {
      b = paramInt;
      return;
      bool = false;
      break;
      paramInt = e;
      break label63;
    }
    label109:
    if (c != Integer.MIN_VALUE)
    {
      paramInt = c;
      a = paramInt;
      if (d == Integer.MIN_VALUE) {
        break label156;
      }
    }
    label156:
    for (paramInt = d;; paramInt = f)
    {
      b = paramInt;
      return;
      paramInt = e;
      break;
    }
    label164:
    a = e;
    b = f;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Toolbar.SavedState localSavedState = new Toolbar.SavedState(super.onSaveInstanceState());
    if ((q != null) && (q.b != null)) {
      a = q.b.getItemId();
    }
    b = a();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = qk.a(paramMotionEvent);
    if (i1 == 0) {
      G = false;
    }
    if (!G)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i1 == 0) && (!bool)) {
        G = true;
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      G = false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.Toolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */