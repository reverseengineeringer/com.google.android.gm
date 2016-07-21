package com.android.mail.compose;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import buc;
import bud;
import bue;

public class CcBccView
  extends RelativeLayout
{
  private final View a;
  private final View b;
  
  public CcBccView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CcBccView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CcBccView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(bue.c, this);
    a = findViewById(buc.S);
    b = findViewById(buc.K);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 8;
    boolean bool = a.isShown();
    Object localObject = a;
    int i;
    if (paramBoolean2)
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = b;
      i = j;
      if (paramBoolean3) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      if (!paramBoolean1) {
        break label191;
      }
      i = getResources().getInteger(bud.n);
      localObject = ObjectAnimator.ofFloat(b, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject).setDuration(i);
      if (bool) {
        break label188;
      }
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setDuration(i);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ((AnimatorSet)localAnimatorSet).playTogether(new Animator[] { localObjectAnimator, localObject });
      localObject = localAnimatorSet;
    }
    label188:
    for (;;)
    {
      ((Animator)localObject).start();
      return;
      i = 8;
      break;
    }
    label191:
    if (paramBoolean2) {
      a.setAlpha(1.0F);
    }
    if (paramBoolean3) {
      b.setAlpha(1.0F);
    }
    requestLayout();
  }
  
  public final boolean a()
  {
    return a.getVisibility() == 0;
  }
  
  public final boolean b()
  {
    return b.getVisibility() == 0;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.CcBccView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */