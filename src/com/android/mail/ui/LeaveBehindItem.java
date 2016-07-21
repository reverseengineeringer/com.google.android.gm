package com.android.mail.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import buc;
import bud;
import buo;
import but;
import bwg;
import cjy;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.ui.toastbar.ToastBarOperation;
import cqj;
import cqk;
import hef;
import java.util.ArrayList;
import java.util.HashSet;

public class LeaveBehindItem
  extends FrameLayout
  implements View.OnClickListener, cqj
{
  public static int o = -1;
  private static int q = -1;
  private static float r;
  public ToastBarOperation a;
  public Account b;
  public cjy c;
  public TextView d;
  public View e;
  public ImageView f;
  public int g;
  public Conversation h;
  public int i;
  public int j;
  public boolean k;
  public boolean l;
  public boolean m = false;
  public AnimatorSet n;
  private int p = -1;
  
  public LeaveBehindItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LeaveBehindItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LeaveBehindItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public static AnimatorSet a(View paramView1, View paramView2, int paramInt)
  {
    a(paramView1.getContext());
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F });
    paramView1.setAlpha(0.0F);
    paramView1 = new AnimatorSet();
    if ((paramView2 != null) && (paramView2.getVisibility() != 8))
    {
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 1.0F, 0.0F });
      paramView2.setAlpha(1.0F);
      paramView1.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    }
    for (;;)
    {
      if (paramInt != 0) {
        paramView1.setStartDelay(paramInt);
      }
      paramView1.setInterpolator(new LinearInterpolator());
      paramView1.setDuration(q);
      paramView1.start();
      return paramView1;
      paramView1.play(localObjectAnimator1);
    }
  }
  
  private static void a(Context paramContext)
  {
    if (o == -1)
    {
      paramContext = paramContext.getResources();
      o = paramContext.getInteger(bud.B);
      q = paramContext.getInteger(bud.m);
      r = paramContext.getInteger(bud.r);
    }
  }
  
  public final void a()
  {
    a.b(getContext());
    bwg localbwg = (bwg)c.getCursor();
    if (localbwg != null) {
      localbwg.a(hef.a(h), 0, null);
    }
  }
  
  public final void a(int paramInt)
  {
    if ((!l) && (e.getAlpha() != 1.0F))
    {
      l = true;
      n = a(e, f, paramInt);
    }
  }
  
  public final void b()
  {
    if (n != null)
    {
      l = false;
      n.cancel();
    }
  }
  
  public final boolean h()
  {
    return !m;
  }
  
  public final void i()
  {
    if (c != null)
    {
      buo.a().a("list_swipe", "leave_behind", null, 0L);
      cjy localcjy = c;
      long l1 = h.b;
      if (i == l1) {
        i = -1L;
      }
      localcjy.e();
      c.notifyDataSetChanged();
    }
  }
  
  public final cqk l()
  {
    return cqk.a(e);
  }
  
  public final float m()
  {
    return r;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == buc.fk) && (b.p != null) && (!m))
    {
      paramView = c;
      if (!b.isEmpty())
      {
        e.addAll(b);
        b.clear();
      }
      if (i != -1L)
      {
        e.add(Long.valueOf(i));
        i = -1L;
      }
      paramView.notifyDataSetChanged();
      paramView.a(j);
      c.d(h.b);
      paramView = (bwg)c.getCursor();
      if (paramView != null) {
        paramView.a(getContext(), b.p);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (p != -1)
    {
      setMeasuredDimension(i, p);
      return;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(j, 1073741824));
  }
  
  public void setAnimatedHeight(int paramInt)
  {
    p = paramInt;
    requestLayout();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.LeaveBehindItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */