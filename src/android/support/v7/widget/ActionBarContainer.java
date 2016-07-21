package android.support.v7.widget;

import acf;
import ack;
import aet;
import aeu;
import als;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer
  extends FrameLayout
{
  View a;
  public Drawable b;
  public Drawable c;
  public Drawable d;
  public boolean e;
  public boolean f;
  private boolean g;
  private View h;
  private View i;
  private int j;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = new aeu(this);
      setBackgroundDrawable((Drawable)localObject);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ack.b);
      b = paramContext.getDrawable(ack.c);
      c = paramContext.getDrawable(ack.e);
      j = paramContext.getDimensionPixelSize(ack.k, -1);
      if (getId() == acf.B)
      {
        e = true;
        d = paramContext.getDrawable(ack.d);
      }
      paramContext.recycle();
      if (!e) {
        break label143;
      }
      if (d != null) {
        break label138;
      }
      bool = true;
    }
    for (;;)
    {
      setWillNotDraw(bool);
      return;
      localObject = new aet(this);
      break;
      label138:
      bool = false;
      continue;
      label143:
      if ((b == null) && (c == null)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private static boolean a(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  private static int b(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    int k = paramView.getMeasuredHeight();
    int m = topMargin;
    return bottomMargin + (k + m);
  }
  
  public final void a(als paramals)
  {
    if (a != null) {
      removeView(a);
    }
    a = paramals;
    if (paramals != null)
    {
      addView(paramals);
      ViewGroup.LayoutParams localLayoutParams = paramals.getLayoutParams();
      width = -1;
      height = -2;
      c = false;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    g = paramBoolean;
    if (paramBoolean) {}
    for (int k = 393216;; k = 262144)
    {
      setDescendantFocusability(k);
      return;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((b != null) && (b.isStateful())) {
      b.setState(getDrawableState());
    }
    if ((c != null) && (c.isStateful())) {
      c.setState(getDrawableState());
    }
    if ((d != null) && (d.isStateful())) {
      d.setState(getDrawableState());
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.jumpDrawablesToCurrentState();
      if (b != null) {
        b.jumpToCurrentState();
      }
      if (c != null) {
        c.jumpToCurrentState();
      }
      if (d != null) {
        d.jumpToCurrentState();
      }
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    h = findViewById(acf.a);
    i = findViewById(acf.f);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (g) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 1;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = a;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      paramBoolean = true;
      if ((localView != null) && (localView.getVisibility() != 8))
      {
        paramInt2 = getMeasuredHeight();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.layout(paramInt1, paramInt2 - localView.getMeasuredHeight() - bottomMargin, paramInt3, paramInt2 - bottomMargin);
      }
      if (!e) {
        break label143;
      }
      if (d == null) {
        break label323;
      }
      d.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 = k;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        invalidate();
      }
      return;
      paramBoolean = false;
      break;
      label143:
      if (b != null) {
        if (h.getVisibility() == 0) {
          b.setBounds(h.getLeft(), h.getTop(), h.getRight(), h.getBottom());
        }
      }
      label195:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        f = paramBoolean;
        if ((paramBoolean) && (c != null))
        {
          c.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          paramInt1 = k;
          break;
          if ((i != null) && (i.getVisibility() == 0))
          {
            b.setBounds(i.getLeft(), i.getTop(), i.getRight(), i.getBottom());
            break label195;
          }
          b.setBounds(0, 0, 0, 0);
          break label195;
        }
        break;
      }
      label323:
      paramInt1 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = paramInt2;
    if (h == null)
    {
      k = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE)
      {
        k = paramInt2;
        if (j >= 0) {
          k = View.MeasureSpec.makeMeasureSpec(Math.min(j, View.MeasureSpec.getSize(paramInt2)), Integer.MIN_VALUE);
        }
      }
    }
    super.onMeasure(paramInt1, k);
    if (h == null) {}
    do
    {
      return;
      paramInt2 = View.MeasureSpec.getMode(k);
    } while ((a == null) || (a.getVisibility() == 8) || (paramInt2 == 1073741824));
    if (!a(h))
    {
      paramInt1 = b(h);
      if (paramInt2 != Integer.MIN_VALUE) {
        break label167;
      }
    }
    label167:
    for (paramInt2 = View.MeasureSpec.getSize(k);; paramInt2 = Integer.MAX_VALUE)
    {
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + b(a), paramInt2));
      return;
      if (!a(i))
      {
        paramInt1 = b(i);
        break;
      }
      paramInt1 = 0;
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (b != null) {
        b.setVisible(bool, false);
      }
      if (c != null) {
        c.setVisible(bool, false);
      }
      if (d != null) {
        d.setVisible(bool, false);
      }
      return;
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == b) && (!e)) || ((paramDrawable == c) && (f)) || ((paramDrawable == d) && (e)) || (super.verifyDrawable(paramDrawable));
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionBarContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */