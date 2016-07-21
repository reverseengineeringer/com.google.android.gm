import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ajn
{
  private static Method a;
  private static Method b;
  private final ajw A = new ajw(this);
  private final aju B = new aju(this);
  private Runnable C;
  private Rect D = new Rect();
  private boolean E;
  private int F;
  private Context c;
  private ListAdapter d;
  public PopupWindow e;
  public ajq f;
  int g = -2;
  int h;
  int i;
  boolean j;
  public int k = 0;
  int l = Integer.MAX_VALUE;
  int m = 0;
  public View n;
  public AdapterView.OnItemClickListener o;
  final ajy p = new ajy(this);
  final Handler q;
  private int r = -2;
  private int s = 1002;
  private boolean t = false;
  private boolean u = false;
  private View v;
  private DataSetObserver w;
  private Drawable x;
  private AdapterView.OnItemSelectedListener y;
  private final ajx z = new ajx(this);
  
  static
  {
    try
    {
      a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
      try
      {
        b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException1) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      for (;;) {}
    }
  }
  
  public ajn(Context paramContext)
  {
    this(paramContext, null, aca.F);
  }
  
  public ajn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ajn(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    c = paramContext;
    q = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, ack.bj, paramInt1, paramInt2);
    h = localTypedArray.getDimensionPixelOffset(ack.bk, 0);
    i = localTypedArray.getDimensionPixelOffset(ack.bl, 0);
    if (i != 0) {
      j = true;
    }
    localTypedArray.recycle();
    e = new agt(paramContext, paramAttributeSet, paramInt1);
    e.setInputMethodMode(1);
    paramContext = c.getResources().getConfiguration().locale;
    F = np.a.a(paramContext);
  }
  
  private final int a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (b != null) {
      try
      {
        int i1 = ((Integer)b.invoke(e, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        return i1;
      }
      catch (Exception localException) {}
    }
    return e.getMaxAvailableHeight(paramView, paramInt);
  }
  
  public final void a(int paramInt)
  {
    Drawable localDrawable = e.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(D);
      g = (D.left + D.right + paramInt);
      return;
    }
    g = paramInt;
  }
  
  public final void a(Drawable paramDrawable)
  {
    e.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(ListAdapter paramListAdapter)
  {
    if (w == null) {
      w = new ajv(this);
    }
    for (;;)
    {
      d = paramListAdapter;
      if (d != null) {
        paramListAdapter.registerDataSetObserver(w);
      }
      if (f != null) {
        f.setAdapter(d);
      }
      return;
      if (d != null) {
        d.unregisterDataSetObserver(w);
      }
    }
  }
  
  public final void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    e.setOnDismissListener(paramOnDismissListener);
  }
  
  public void b()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    Object localObject2;
    boolean bool1;
    Object localObject1;
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    label255:
    int i2;
    int i1;
    if (f == null)
    {
      localObject2 = c;
      C = new ajo(this);
      if (!E)
      {
        bool1 = true;
        f = new ajq((Context)localObject2, bool1);
        if (x != null) {
          f.setSelector(x);
        }
        f.setAdapter(d);
        f.setOnItemClickListener(o);
        f.setFocusable(true);
        f.setFocusableInTouchMode(true);
        f.setOnItemSelectedListener(new ajp(this));
        f.setOnScrollListener(A);
        if (y != null) {
          f.setOnItemSelectedListener(y);
        }
        localObject1 = f;
        localView = v;
        if (localView == null) {
          break label1242;
        }
        localObject2 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject2).setOrientation(1);
        localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (m)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + m);
          if (g >= 0)
          {
            i2 = g;
            i1 = Integer.MIN_VALUE;
            label271:
            localView.measure(View.MeasureSpec.makeMeasureSpec(i2, i1), 0);
            localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            i1 = localView.getMeasuredHeight();
            i2 = topMargin;
            i1 = bottomMargin + (i1 + i2);
            localObject1 = localObject2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      e.setContentView((View)localObject1);
      for (;;)
      {
        label327:
        localObject1 = e.getBackground();
        int i3;
        label390:
        label404:
        int i4;
        if (localObject1 != null)
        {
          ((Drawable)localObject1).getPadding(D);
          i2 = D.top + D.bottom;
          i3 = i2;
          if (!j)
          {
            i = (-D.top);
            i3 = i2;
          }
          if (e.getInputMethodMode() != 2) {
            break label727;
          }
          bool1 = true;
          i4 = a(n, i, bool1);
          if ((!t) && (r != -1)) {
            break label733;
          }
          i1 = i4 + i3;
          bool1 = g();
          xl.a(e, s);
          if (!e.isShowing()) {
            break label984;
          }
          if (g != -1) {
            break label882;
          }
          i2 = -1;
          label477:
          if (r != -1) {
            break label958;
          }
          if (!bool1) {
            break label910;
          }
          label490:
          if (!bool1) {
            break label920;
          }
          localObject1 = e;
          if (g != -1) {
            break label915;
          }
          i3 = -1;
          label511:
          ((PopupWindow)localObject1).setWidth(i3);
          e.setHeight(0);
          label525:
          localObject1 = e;
          if ((u) || (t)) {
            break label978;
          }
          bool1 = bool2;
          label549:
          ((PopupWindow)localObject1).setOutsideTouchable(bool1);
          localObject1 = e;
          localObject2 = n;
          i4 = h;
          int i5 = i;
          i3 = i2;
          if (i2 < 0) {
            i3 = -1;
          }
          i2 = i1;
          if (i1 < 0) {
            i2 = -1;
          }
          ((PopupWindow)localObject1).update((View)localObject2, i4, i5, i3, i2);
        }
        for (;;)
        {
          return;
          bool1 = false;
          break;
          ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
          ((LinearLayout)localObject2).addView(localView);
          break label255;
          ((LinearLayout)localObject2).addView(localView);
          ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
          break label255;
          i1 = 0;
          i2 = 0;
          break label271;
          e.getContentView();
          localObject1 = v;
          if (localObject1 != null)
          {
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            i1 = ((View)localObject1).getMeasuredHeight();
            i2 = topMargin;
            i1 = bottomMargin + (i1 + i2);
            break label327;
            D.setEmpty();
            i3 = 0;
            break label390;
            label727:
            bool1 = false;
            break label404;
            label733:
            switch (g)
            {
            default: 
              i2 = View.MeasureSpec.makeMeasureSpec(g, 1073741824);
            }
            for (;;)
            {
              i4 = f.a(i2, i4 - i1);
              i2 = i1;
              if (i4 > 0) {
                i2 = i1 + i3;
              }
              i1 = i2 + i4;
              break;
              i2 = View.MeasureSpec.makeMeasureSpec(c.getResources().getDisplayMetrics().widthPixels - (D.left + D.right), Integer.MIN_VALUE);
              continue;
              i2 = View.MeasureSpec.makeMeasureSpec(c.getResources().getDisplayMetrics().widthPixels - (D.left + D.right), 1073741824);
            }
            label882:
            if (g == -2)
            {
              i2 = n.getWidth();
              break label477;
            }
            i2 = g;
            break label477;
            label910:
            i1 = -1;
            break label490;
            label915:
            i3 = 0;
            break label511;
            label920:
            localObject1 = e;
            if (g == -1) {}
            for (i3 = -1;; i3 = 0)
            {
              ((PopupWindow)localObject1).setWidth(i3);
              e.setHeight(-1);
              break;
            }
            label958:
            if (r == -2) {
              break label525;
            }
            i1 = r;
            break label525;
            label978:
            bool1 = false;
            break label549;
            label984:
            if (g == -1)
            {
              i2 = -1;
              label994:
              if (r != -1) {
                break label1209;
              }
              i1 = -1;
              label1004:
              e.setWidth(i2);
              e.setHeight(i1);
              if (a == null) {}
            }
            try
            {
              a.invoke(e, new Object[] { Boolean.valueOf(true) });
              localObject1 = e;
              if ((!u) && (!t)) {}
              for (bool1 = bool3;; bool1 = false)
              {
                ((PopupWindow)localObject1).setOutsideTouchable(bool1);
                e.setTouchInterceptor(z);
                localObject1 = e;
                localObject2 = n;
                i1 = h;
                i2 = i;
                i3 = k;
                xl.a.a((PopupWindow)localObject1, (View)localObject2, i1, i2, i3);
                f.setSelection(-1);
                if ((!E) || (f.isInTouchMode())) {
                  f();
                }
                if (E) {
                  break;
                }
                q.post(B);
                return;
                if (g == -2)
                {
                  i2 = n.getWidth();
                  break label994;
                }
                i2 = g;
                break label994;
                label1209:
                if (r == -2) {
                  break label1004;
                }
                i1 = r;
                break label1004;
              }
            }
            catch (Exception localException)
            {
              for (;;) {}
            }
          }
        }
        i1 = 0;
      }
      label1242:
      i1 = 0;
    }
  }
  
  public final void c()
  {
    E = true;
    e.setFocusable(true);
  }
  
  public final void d()
  {
    e.dismiss();
    if (v != null)
    {
      ViewParent localViewParent = v.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(v);
      }
    }
    e.setContentView(null);
    f = null;
    q.removeCallbacks(p);
  }
  
  public final void e()
  {
    e.setInputMethodMode(2);
  }
  
  public final void f()
  {
    ajq localajq = f;
    if (localajq != null)
    {
      a = true;
      localajq.requestLayout();
    }
  }
  
  public final boolean g()
  {
    return e.getInputMethodMode() == 2;
  }
}

/* Location:
 * Qualified Name:     ajn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */