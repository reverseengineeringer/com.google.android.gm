package com.android.mail.browse;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import bzj;
import bzk;
import chq;
import cvl;
import cvm;
import cww;
import cwx;
import java.util.Timer;

public class MessageWebView
  extends WebView
  implements bzj
{
  private static final String a = cvl.a;
  private boolean b;
  private final cww c = new cww("MessageWebView", new bzk(this), new Handler());
  private int d;
  private int e;
  private boolean f;
  private long g = -1L;
  
  public MessageWebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    super.onSizeChanged(d, e, paramInt1, paramInt2);
    g = chq.a();
  }
  
  public final boolean a()
  {
    return b;
  }
  
  public final void b()
  {
    b = false;
  }
  
  public final void c()
  {
    f = true;
    a(getWidth(), getHeight());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 1;
    d = paramInt1;
    e = paramInt2;
    if (chq.a() - g < 200L)
    {
      paramInt1 = 1;
      if (!f) {
        break label65;
      }
      f = false;
      if (paramInt1 == 0) {
        break label65;
      }
      cvm.d(a, "Suppressing size change in MessageWebView", new Object[0]);
    }
    label65:
    label199:
    label202:
    for (;;)
    {
      return;
      paramInt1 = 0;
      break;
      if (paramInt1 == 0) {
        break label204;
      }
      cww localcww = c;
      long l = chq.a();
      if (l - g <= 500L)
      {
        f *= 2;
        if (f >= e) {
          f = e;
        }
        g = l;
        if (h == null) {
          break label199;
        }
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label202;
        }
        h = new cwx(localcww);
        a.schedule(h, f);
        return;
        f = d;
        break;
      }
    }
    label204:
    a(paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b = true;
    boolean bool = super.onTouchEvent(paramMotionEvent);
    cvm.b("MsgScroller", "OUT WebView.onTouch, returning handled=%s ev=%s", new Object[] { Boolean.valueOf(bool), paramMotionEvent });
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageWebView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */