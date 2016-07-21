package android.support.v7.view.menu;

import acb;
import ack;
import adn;
import ado;
import adw;
import ady;
import aem;
import afj;
import ahi;
import ajr;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import rg;

public class ActionMenuItemView
  extends ahi
  implements aem, afj, View.OnClickListener, View.OnLongClickListener
{
  public ady a;
  public adw b;
  public ado c;
  private CharSequence d;
  private Drawable e;
  private ajr f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  
  public ActionMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    g = localResources.getBoolean(acb.c);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ack.w, paramInt, 0);
    i = paramContext.getDimensionPixelSize(ack.x, 0);
    paramContext.recycle();
    k = ((int)(getDisplayMetricsdensity * 32.0F + 0.5F));
    setOnClickListener(this);
    setOnLongClickListener(this);
    j = -1;
  }
  
  private final void h()
  {
    int i2 = 0;
    int m;
    int n;
    if (!TextUtils.isEmpty(d))
    {
      m = 1;
      if (e != null)
      {
        if ((a.c & 0x4) != 4) {
          break label87;
        }
        n = 1;
        label37:
        i1 = i2;
        if (n == 0) {
          break label63;
        }
        if (!g)
        {
          i1 = i2;
          if (!h) {
            break label63;
          }
        }
      }
      int i1 = 1;
      label63:
      if ((m & i1) == 0) {
        break label92;
      }
    }
    label87:
    label92:
    for (CharSequence localCharSequence = d;; localCharSequence = null)
    {
      setText(localCharSequence);
      return;
      m = 0;
      break;
      n = 0;
      break label37;
    }
  }
  
  public final ady a()
  {
    return a;
  }
  
  public final void a(ady paramady)
  {
    a = paramady;
    Drawable localDrawable = paramady.getIcon();
    e = localDrawable;
    if (localDrawable != null)
    {
      int i2 = localDrawable.getIntrinsicWidth();
      int i1 = localDrawable.getIntrinsicHeight();
      int n = i1;
      m = i2;
      float f1;
      if (i2 > k)
      {
        f1 = k / i2;
        m = k;
        n = (int)(i1 * f1);
      }
      i2 = n;
      i1 = m;
      if (n > k)
      {
        f1 = k / n;
        i2 = k;
        i1 = (int)(m * f1);
      }
      localDrawable.setBounds(0, 0, i1, i2);
    }
    setCompoundDrawables(localDrawable, null, null, null);
    h();
    d = paramady.a(this);
    setContentDescription(d);
    h();
    setId(paramady.getItemId());
    if (paramady.isVisible()) {}
    for (int m = 0;; m = 8)
    {
      setVisibility(m);
      setEnabled(paramady.isEnabled());
      if ((paramady.hasSubMenu()) && (f == null)) {
        f = new adn(this);
      }
      return;
    }
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public final boolean e()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public final boolean f()
  {
    return (e()) && (a.getIcon() == null);
  }
  
  public final boolean g()
  {
    return e();
  }
  
  public void onClick(View paramView)
  {
    if (b != null) {
      b.a(a);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    g = getContext().getResources().getBoolean(acb.c);
    h();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (e()) {
      return false;
    }
    int[] arrayOfInt = new int[2];
    Rect localRect = new Rect();
    getLocationOnScreen(arrayOfInt);
    getWindowVisibleDisplayFrame(localRect);
    Context localContext = getContext();
    int m = getWidth();
    int i1 = getHeight();
    int i2 = arrayOfInt[1];
    int i3 = i1 / 2;
    int n = arrayOfInt[0];
    n = m / 2 + n;
    m = n;
    if (rg.g(paramView) == 0) {
      m = getResourcesgetDisplayMetricswidthPixels - n;
    }
    paramView = Toast.makeText(localContext, a.getTitle(), 0);
    if (i2 + i3 < localRect.height()) {
      paramView.setGravity(8388661, m, arrayOfInt[1] + i1 - top);
    }
    for (;;)
    {
      paramView.show();
      return true;
      paramView.setGravity(81, 0, i1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = e();
    if ((bool) && (j >= 0)) {
      super.setPadding(j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int n = getMeasuredWidth();
    if (m == Integer.MIN_VALUE) {}
    for (paramInt1 = Math.min(paramInt1, i);; paramInt1 = i)
    {
      if ((m != 1073741824) && (i > 0) && (n < paramInt1)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
      }
      if ((!bool) && (e != null)) {
        super.setPadding((getMeasuredWidth() - e.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((a.hasSubMenu()) && (f != null) && (f.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    j = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */