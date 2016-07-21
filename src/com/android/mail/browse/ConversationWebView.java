package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import bud;
import bxy;
import byl;
import bzo;
import bzp;
import cvl;
import cvm;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConversationWebView
  extends byl
  implements bzo
{
  private static final String m = cvl.a;
  public final int a;
  public boolean b;
  public boolean c;
  public final Runnable d = new bxy(this);
  public final int e;
  boolean f;
  private Bitmap h;
  private Canvas i;
  private final float j;
  private final Set<bzp> k = new CopyOnWriteArraySet();
  private boolean l;
  
  public ConversationWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    e = paramContext.getInteger(bud.g);
    a = paramContext.getInteger(bud.J);
    j = getDisplayMetricsdensity;
  }
  
  public final int a(int paramInt)
  {
    return (int)((getWidth() - paramInt * 2) / j);
  }
  
  public final void a()
  {
    if (h != null)
    {
      h = null;
      i = null;
    }
  }
  
  public final void a(bzp parambzp)
  {
    k.add(parambzp);
  }
  
  public final float b()
  {
    if (getSettings().getLoadWithOverviewMode()) {
      return getWidth() / e;
    }
    return j;
  }
  
  public final int b(int paramInt)
  {
    return (int)(paramInt / b());
  }
  
  public final int c(int paramInt)
  {
    return (int)Math.ceil(paramInt / b() - b(paramInt));
  }
  
  public void destroy()
  {
    a();
    removeCallbacks(d);
    super.destroy();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!b) || (!c) || (getWidth() <= 0) || (getHeight() <= 0) || (h == null)) {}
    try
    {
      h = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
      i = new Canvas(h);
      if (h != null)
      {
        int n = getScrollX();
        int i1 = getScrollY();
        i.save();
        i.translate(-n, -i1);
        super.onDraw(i);
        i.restore();
        paramCanvas.drawBitmap(h, n, i1, null);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        h = null;
        i = null;
        b = false;
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = k.iterator();
    while (localIterator.hasNext()) {
      ((bzp)localIterator.next()).a(paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if ((l) || (super.onTouchEvent(paramMotionEvent))) {
        bool = true;
      }
      return bool;
      f = true;
      continue;
      cvm.b(m, "WebView disabling intercepts: POINTER_DOWN", new Object[0]);
      requestDisallowInterceptTouchEvent(true);
      continue;
      f = false;
      l = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationWebView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */