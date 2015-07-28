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

public class CcBccView
  extends RelativeLayout
{
  private final View mBcc;
  private final View mCc;
  
  public CcBccView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CcBccView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public CcBccView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2130968594, this);
    mCc = findViewById(2131755060);
    mBcc = findViewById(2131755063);
  }
  
  private void animate(Boolean paramBoolean, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = getResources().getInteger(2131361797);
    paramBoolean = ObjectAnimator.ofFloat(mBcc, "alpha", new float[] { 0.0F, 1.0F });
    paramBoolean.setDuration(i);
    if (!paramBoolean2)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(mCc, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setDuration(i);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ((AnimatorSet)localAnimatorSet).playTogether(new Animator[] { localObjectAnimator, paramBoolean });
      paramBoolean = localAnimatorSet;
    }
    for (;;)
    {
      paramBoolean.start();
      return;
    }
  }
  
  public boolean isBccVisible()
  {
    return mBcc.getVisibility() == 0;
  }
  
  public boolean isCcVisible()
  {
    return mCc.getVisibility() == 0;
  }
  
  public void show(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 0;
    boolean bool = mCc.isShown();
    View localView = mCc;
    if (paramBoolean2)
    {
      i = 0;
      localView.setVisibility(i);
      localView = mBcc;
      if (!paramBoolean3) {
        break label76;
      }
    }
    label76:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if (!paramBoolean1) {
        break label83;
      }
      animate(Boolean.valueOf(paramBoolean2), paramBoolean3, bool);
      return;
      i = 8;
      break;
    }
    label83:
    if (paramBoolean2) {
      mCc.setAlpha(1.0F);
    }
    if (paramBoolean3) {
      mBcc.setAlpha(1.0F);
    }
    requestLayout();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.CcBccView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */