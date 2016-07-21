package com.android.mail.ui.teasers;

import android.animation.ObjectAnimator;
import android.app.LoaderManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import bud;
import bwg;
import com.android.mail.providers.Folder;
import cqj;
import cqp;
import cqq;
import csk;
import cso;

public abstract class AbstractSwipeableConversationSpecialItemView
  extends LinearLayout
  implements cqj, cso
{
  public final Context a;
  public int b = -1;
  public cqp c;
  private final int d;
  private final int e;
  
  public AbstractSwipeableConversationSpecialItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AbstractSwipeableConversationSpecialItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbstractSwipeableConversationSpecialItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a = paramContext;
    paramContext = paramContext.getResources();
    d = paramContext.getInteger(bud.E);
    e = paramContext.getInteger(bud.B);
  }
  
  public void a(LoaderManager paramLoaderManager, Bundle paramBundle) {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(Folder paramFolder, bwg parambwg) {}
  
  public void a(cqp paramcqp)
  {
    c = paramcqp;
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return false;
  }
  
  public final void b()
  {
    if (c == null) {}
    for (cqq localcqq = null;; localcqq = c.z())
    {
      if (localcqq != null) {
        localcqq.o();
      }
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public final boolean h()
  {
    return true;
  }
  
  public void i()
  {
    int i = getHeight();
    b = i;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this, "animatedHeight", new int[] { i, 0 });
    localObjectAnimator.setInterpolator(new DecelerateInterpolator(2.0F));
    localObjectAnimator.setDuration(e);
    localObjectAnimator.addListener(new csk(this));
    localObjectAnimator.start();
    b();
  }
  
  public void j() {}
  
  public boolean k()
  {
    return true;
  }
  
  public final float m()
  {
    return d;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (b == -1)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), b);
  }
  
  public void setAnimatedHeight(int paramInt)
  {
    b = paramInt;
    requestLayout();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.teasers.AbstractSwipeableConversationSpecialItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */