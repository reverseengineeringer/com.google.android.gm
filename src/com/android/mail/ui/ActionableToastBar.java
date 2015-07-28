package com.android.mail.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionableToastBar
  extends LinearLayout
{
  private View mActionButton;
  private ImageView mActionDescriptionIcon;
  private TextView mActionDescriptionView;
  private View mActionIcon;
  private TextView mActionText;
  private final int mBottomMarginSizeInConversation;
  private boolean mHidden = false;
  private Animator mHideAnimation;
  private ToastBarOperation mOperation;
  private Animator mShowAnimation;
  
  public ActionableToastBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionableToastBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionableToastBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mBottomMarginSizeInConversation = paramContext.getResources().getDimensionPixelSize(2131427423);
    LayoutInflater.from(paramContext).inflate(2130968585, this, true);
  }
  
  private Animator getHideAnimation()
  {
    if (mHideAnimation == null)
    {
      mHideAnimation = AnimatorInflater.loadAnimator(getContext(), 2131034117);
      mHideAnimation.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          setVisibility(8);
        }
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      mHideAnimation.setTarget(this);
    }
    return mHideAnimation;
  }
  
  private Animator getShowAnimation()
  {
    if (mShowAnimation == null)
    {
      mShowAnimation = AnimatorInflater.loadAnimator(getContext(), 2131034116);
      mShowAnimation.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public void onAnimationEnd(Animator paramAnonymousAnimator) {}
        
        public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          setVisibility(0);
        }
      });
      mShowAnimation.setTarget(this);
    }
    return mShowAnimation;
  }
  
  public ToastBarOperation getOperation()
  {
    return mOperation;
  }
  
  public void hide(boolean paramBoolean)
  {
    mHidden = true;
    if (getVisibility() == 0)
    {
      mActionDescriptionView.setText("");
      mActionButton.setOnClickListener(null);
      if (paramBoolean) {
        getHideAnimation().start();
      }
    }
    else
    {
      return;
    }
    setAlpha(0.0F);
    setVisibility(8);
  }
  
  public boolean isEventInToastBar(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!isShown()) {
      return false;
    }
    int[] arrayOfInt = new int[2];
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    getLocationOnScreen(arrayOfInt);
    if ((f1 > arrayOfInt[0]) && (f1 < arrayOfInt[0] + getWidth()) && (f2 > arrayOfInt[1]) && (f2 < arrayOfInt[1] + getHeight())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mActionDescriptionIcon = ((ImageView)findViewById(2131755044));
    mActionDescriptionView = ((TextView)findViewById(2131755045));
    mActionButton = findViewById(2131755046);
    mActionIcon = findViewById(2131755048);
    mActionText = ((TextView)findViewById(2131755049));
  }
  
  public void setConversationMode(boolean paramBoolean)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    if (paramBoolean) {}
    for (int i = mBottomMarginSizeInConversation;; i = 0)
    {
      bottomMargin = i;
      setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void show(final ActionClickedListener paramActionClickedListener, int paramInt1, CharSequence paramCharSequence, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, ToastBarOperation paramToastBarOperation)
  {
    int i = 8;
    if ((!mHidden) && (!paramBoolean2)) {
      return;
    }
    mOperation = paramToastBarOperation;
    mActionButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramActionClickedListener.onActionClicked();
        hide(true);
      }
    });
    if (paramInt1 == 0) {
      mActionDescriptionIcon.setVisibility(8);
    }
    for (;;)
    {
      mActionDescriptionView.setText(paramCharSequence);
      paramActionClickedListener = mActionIcon;
      paramInt1 = i;
      if (paramBoolean1) {
        paramInt1 = 0;
      }
      paramActionClickedListener.setVisibility(paramInt1);
      mActionText.setText(paramInt2);
      mHidden = false;
      getShowAnimation().start();
      return;
      mActionDescriptionIcon.setVisibility(0);
      mActionDescriptionIcon.setImageResource(paramInt1);
    }
  }
  
  public static abstract interface ActionClickedListener
  {
    public abstract void onActionClicked();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ActionableToastBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */