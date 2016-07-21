package com.android.mail.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import buc;
import bue;
import ccy;
import cnk;
import cns;
import com.android.mail.providers.Folder;
import cox;
import coy;
import cus;
import cvm;
import cxe;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class MiniDrawerView
  extends LinearLayout
{
  public cnk a;
  public View b;
  public final List<coy> c = new ArrayList();
  public List<View> d = new ArrayList();
  private final LayoutInflater e;
  private View f;
  
  public MiniDrawerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MiniDrawerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e = LayoutInflater.from(paramContext);
  }
  
  private final void a(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)f.getLayoutParams();
    int i = bottomMargin;
    int j = topMargin;
    int k = getMeasuredWidth();
    int m = getPaddingLeft();
    int n = getPaddingRight();
    f.measure(View.MeasureSpec.makeMeasureSpec(k - m - n, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(paramInt - i - j, 1073741824));
  }
  
  public final void a()
  {
    if ((a == null) || (!a.isAdded())) {}
    float f1;
    Object localObject1;
    int j;
    int i;
    View localView;
    label334:
    label351:
    do
    {
      return;
      if (c.isEmpty()) {}
      for (f1 = 1.0F;; f1 = c.get(0)).a.getAlpha())
      {
        localObject1 = a.k();
        if (((ListAdapter)localObject1).getCount() > 0)
        {
          localObject2 = getChildAt(0);
          if (localObject2 != null) {
            removeView((View)localObject2);
          }
          b = ((ListAdapter)localObject1).getView(0, (View)localObject2, this);
          b.setClickable(false);
          b.setFocusable(false);
          addView(b, 0);
        }
        j = indexOfChild(f) + 1;
        int k = getChildCount() - j;
        localObject2 = new ArrayDeque(k);
        i = 0;
        while (i < k)
        {
          localView = getChildAt(j);
          ((Queue)localObject2).add(localView);
          removeView(localView);
          i += 1;
        }
      }
      j = Math.min(((ListAdapter)localObject1).getCount(), 3);
      d.clear();
      i = 1;
      while (i < j)
      {
        localView = ((ListAdapter)localObject1).getView(i, (View)((Queue)localObject2).poll(), this);
        addView(localView);
        d.add(localView);
        i += 1;
      }
      for (;;)
      {
        localObject1 = getChildAt(1);
        if (localObject1 == f) {
          break;
        }
        removeView((View)localObject1);
      }
      c.clear();
      localObject1 = a;
      if (m == null) {
        break;
      }
      localObject1 = m.c();
      if ((localObject1 == null) || (((ccy)localObject1).isClosed())) {
        break label516;
      }
      j = -1;
      i = 0;
      j += 1;
    } while (!((ccy)localObject1).moveToPosition(j));
    Object localObject2 = (Folder)((ccy)localObject1).f();
    if (((Folder)localObject2).d(8194))
    {
      localView = e.inflate(bue.W, this, false);
      Object localObject3 = (ImageView)localView.findViewById(buc.cl);
      ((ImageView)localObject3).setTag(new cox(this, (Folder)localObject2, (ImageView)localObject3));
      ((ImageView)localObject3).setContentDescription(d);
      localObject3 = a;
      localView.setActivated(c.equals(i));
      localView.setAlpha(f1);
      addView(localView, i + 1);
      c.add(new coy(localView, Integer.valueOf(a)));
      i += 1;
    }
    for (;;)
    {
      break label351;
      localObject1 = null;
      break label334;
      label516:
      break;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      cxe.c((View)localIterator.next());
    }
    if (paramBoolean) {
      cxe.c(b);
    }
  }
  
  public final int b()
  {
    if (b != null) {
      return b.findViewById(buc.H).getWidth();
    }
    return 0;
  }
  
  public final void c()
  {
    if (b != null) {
      b.setAlpha(1.0F);
    }
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      nexta.setAlpha(1.0F);
    }
    localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      localView.setAlpha(1.0F);
      localView.setTranslationY(0.0F);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    f = findViewById(buc.eT);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    if (i1 == 0) {
      return;
    }
    int n = getMeasuredHeight() - getPaddingBottom() - getPaddingTop();
    int i = 0;
    int j = 0;
    int k = 0;
    View localView;
    int m;
    if (k < i1)
    {
      localView = getChildAt(k);
      if (localView.equals(f))
      {
        m = k;
        j = i;
        i = m;
      }
    }
    for (;;)
    {
      k += 1;
      m = j;
      j = i;
      i = m;
      break;
      if (localView.getVisibility() != 8)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
        m = topMargin;
        m = bottomMargin + m + localView.getMeasuredHeight() + i;
        i = j;
        j = m;
        continue;
        if (i <= n)
        {
          super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
          return;
        }
        k = j + 1;
        if ((i > n) && (k < i1 - 1))
        {
          localView = getChildAt(k);
          if (localView.getVisibility() == 8) {
            break label427;
          }
          localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
          m = topMargin;
          i -= bottomMargin + m + localView.getMeasuredHeight();
          localView.setVisibility(8);
        }
        label424:
        label427:
        for (;;)
        {
          k += 1;
          break;
          if (i <= n)
          {
            a(n - i);
            super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
            return;
          }
          j -= 1;
          if ((i > n) && (j > 0))
          {
            localView = getChildAt(j);
            if (localView.getVisibility() == 8) {
              break label424;
            }
            localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
            k = topMargin;
            i -= bottomMargin + k + localView.getMeasuredHeight();
            localView.setVisibility(8);
          }
          for (;;)
          {
            j -= 1;
            break;
            if (i <= n)
            {
              a(n - i);
              super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
              return;
            }
            cvm.e(cvm.a, "Hiding down to only current account avatar and 1 recent account did not make enough room for the mini-drawer!", new Object[0]);
            return;
          }
        }
      }
      else
      {
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).setVisibility(0);
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    return super.requestFocus(130, paramRect);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MiniDrawerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */