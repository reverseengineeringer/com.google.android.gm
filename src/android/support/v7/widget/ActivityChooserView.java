package android.support.v7.widget;

import acd;
import acf;
import ach;
import aci;
import ack;
import afo;
import afv;
import afw;
import afx;
import afy;
import afz;
import aga;
import ajh;
import ajn;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import oy;

public final class ActivityChooserView
  extends ViewGroup
{
  public final afz a;
  public final ajh b;
  public final Drawable c;
  public final FrameLayout d;
  final ImageView e;
  public final FrameLayout f;
  public final ImageView g;
  public oy h;
  final DataSetObserver i = new afv(this);
  public PopupWindow.OnDismissListener j;
  public boolean k;
  public int l = 4;
  public int m;
  private final aga n;
  private final int o;
  private final ViewTreeObserver.OnGlobalLayoutListener p = new afw(this);
  private ajn q;
  private boolean r;
  
  public ActivityChooserView(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private ActivityChooserView(Context paramContext, byte paramByte)
  {
    this(paramContext, null);
  }
  
  private ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, null, 0);
    Object localObject = paramContext.obtainStyledAttributes(null, ack.F, 0, 0);
    l = ((TypedArray)localObject).getInt(ack.H, 4);
    paramAttributeSet = ((TypedArray)localObject).getDrawable(ack.G);
    ((TypedArray)localObject).recycle();
    LayoutInflater.from(getContext()).inflate(ach.e, this, true);
    n = new aga(this);
    b = ((ajh)findViewById(acf.j));
    c = b.getBackground();
    f = ((FrameLayout)findViewById(acf.q));
    f.setOnClickListener(n);
    f.setOnLongClickListener(n);
    g = ((ImageView)f.findViewById(acf.t));
    localObject = (FrameLayout)findViewById(acf.r);
    ((FrameLayout)localObject).setOnClickListener(n);
    ((FrameLayout)localObject).setOnTouchListener(new afx(this, (View)localObject));
    d = ((FrameLayout)localObject);
    e = ((ImageView)((FrameLayout)localObject).findViewById(acf.t));
    e.setImageDrawable(paramAttributeSet);
    a = new afz(this);
    a.registerDataSetObserver(new afy(this));
    paramContext = paramContext.getResources();
    o = Math.max(getDisplayMetricswidthPixels / 2, paramContext.getDimensionPixelSize(acd.c));
  }
  
  public final void a(int paramInt)
  {
    if (a.a == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(p);
    boolean bool;
    int i1;
    label62:
    label93:
    ajn localajn;
    if (f.getVisibility() == 0)
    {
      bool = true;
      int i2 = a.a.a();
      if (!bool) {
        break label196;
      }
      i1 = 1;
      if ((paramInt == Integer.MAX_VALUE) || (i2 <= i1 + paramInt)) {
        break label201;
      }
      a.a(true);
      a.a(paramInt - 1);
      localajn = d();
      if (!e.isShowing())
      {
        if ((!k) && (bool)) {
          break label220;
        }
        a.a(true, bool);
      }
    }
    for (;;)
    {
      localajn.a(Math.min(a.a(), o));
      localajn.b();
      if (h != null) {
        h.a(true);
      }
      f.setContentDescription(getContext().getString(aci.c));
      return;
      bool = false;
      break;
      label196:
      i1 = 0;
      break label62;
      label201:
      a.a(false);
      a.a(paramInt);
      break label93;
      label220:
      a.a(false, false);
    }
  }
  
  public final boolean a()
  {
    if ((de.isShowing()) || (!r)) {
      return false;
    }
    k = false;
    a(l);
    return true;
  }
  
  public final boolean b()
  {
    if (de.isShowing())
    {
      d().d();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(p);
      }
    }
    return true;
  }
  
  public final boolean c()
  {
    return de.isShowing();
  }
  
  public final ajn d()
  {
    if (q == null)
    {
      q = new ajn(getContext());
      q.a(a);
      q.n = this;
      q.c();
      q.o = n;
      q.a(n);
    }
    return q;
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    afo localafo = a.a;
    if (localafo != null) {
      localafo.registerObserver(i);
    }
    r = true;
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = a.a;
    if (localObject != null) {
      ((afo)localObject).unregisterObserver(i);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(p);
    }
    if (c()) {
      b();
    }
    r = false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!c()) {
      b();
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    ajh localajh = b;
    int i1 = paramInt2;
    if (f.getVisibility() != 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localajh, paramInt1, i1);
    setMeasuredDimension(localajh.getMeasuredWidth(), localajh.getMeasuredHeight());
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActivityChooserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */