package com.android.mail.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.android.mail.utils.Utils;

public class SwipeHelper
{
  public static float ALPHA_FADE_START = 0.0F;
  private static int DEFAULT_ESCAPE_ANIMATION_DURATION;
  private static int DISMISS_ANIMATION_DURATION;
  private static int MAX_DISMISS_VELOCITY;
  private static int MAX_ESCAPE_ANIMATION_DURATION;
  private static float MIN_LOCK;
  private static float MIN_SWIPE;
  private static float MIN_VERT;
  private static int SNAP_ANIM_LEN;
  private static int SWIPE_ESCAPE_VELOCITY;
  private static LinearInterpolator sLinearInterpolator = new LinearInterpolator();
  private Callback mCallback;
  private boolean mCanCurrViewBeDimissed;
  private View mCurrAnimView;
  private SwipeableItemView mCurrView;
  private float mDensityScale;
  private boolean mDragging;
  private float mInitialTouchPosX;
  private float mInitialTouchPosY;
  private float mLastY;
  private float mMinAlpha = 0.5F;
  private float mPagingTouchSlop;
  private int mSwipeDirection;
  private VelocityTracker mVelocityTracker;
  
  static
  {
    SWIPE_ESCAPE_VELOCITY = -1;
  }
  
  public SwipeHelper(Context paramContext, int paramInt, Callback paramCallback, float paramFloat1, float paramFloat2)
  {
    mCallback = paramCallback;
    mSwipeDirection = paramInt;
    mVelocityTracker = VelocityTracker.obtain();
    mDensityScale = paramFloat1;
    mPagingTouchSlop = paramFloat2;
    if (SWIPE_ESCAPE_VELOCITY == -1)
    {
      paramContext = paramContext.getResources();
      SWIPE_ESCAPE_VELOCITY = paramContext.getInteger(2131361804);
      DEFAULT_ESCAPE_ANIMATION_DURATION = paramContext.getInteger(2131361805);
      MAX_ESCAPE_ANIMATION_DURATION = paramContext.getInteger(2131361806);
      MAX_DISMISS_VELOCITY = paramContext.getInteger(2131361807);
      SNAP_ANIM_LEN = paramContext.getInteger(2131361808);
      DISMISS_ANIMATION_DURATION = paramContext.getInteger(2131361809);
      MIN_SWIPE = paramContext.getDimension(2131427336);
      MIN_VERT = paramContext.getDimension(2131427337);
      MIN_LOCK = paramContext.getDimension(2131427338);
    }
  }
  
  private ObjectAnimator createDismissAnimation(View paramView, float paramFloat, int paramInt)
  {
    paramView = createTranslationAnimation(paramView, paramFloat);
    paramView.setInterpolator(sLinearInterpolator);
    paramView.setDuration(paramInt);
    return paramView;
  }
  
  private ObjectAnimator createTranslationAnimation(View paramView, float paramFloat)
  {
    if (mSwipeDirection == 0) {}
    for (String str = "translationX";; str = "translationY") {
      return ObjectAnimator.ofFloat(paramView, str, new float[] { paramFloat });
    }
  }
  
  private int determineDuration(View paramView, float paramFloat1, float paramFloat2)
  {
    int i = MAX_ESCAPE_ANIMATION_DURATION;
    if (paramFloat2 != 0.0F) {
      return Math.min(i, (int)(Math.abs(paramFloat1 - paramView.getTranslationX()) * 1000.0F / Math.abs(paramFloat2)));
    }
    return DEFAULT_ESCAPE_ANIMATION_DURATION;
  }
  
  private float determinePos(View paramView, float paramFloat)
  {
    if ((paramFloat < 0.0F) || ((paramFloat == 0.0F) && (paramView.getTranslationX() < 0.0F)) || ((paramFloat == 0.0F) && (paramView.getTranslationX() == 0.0F) && (mSwipeDirection == 1))) {
      return -getSize(paramView);
    }
    return getSize(paramView);
  }
  
  private void dismissChild(SwipeableItemView paramSwipeableItemView, float paramFloat)
  {
    final View localView = mCurrView.getSwipeableView();
    final boolean bool = mCallback.canChildBeDismissed(paramSwipeableItemView);
    float f = determinePos(localView, paramFloat);
    int i = determineDuration(localView, f, paramFloat);
    Utils.enableHardwareLayer(localView);
    paramSwipeableItemView = createDismissAnimation(localView, f, i);
    paramSwipeableItemView.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        mCallback.onChildDismissed(mCurrView);
        localView.setLayerType(0, null);
      }
    });
    paramSwipeableItemView.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (bool) {
          localView.setAlpha(SwipeHelper.this.getAlphaForOffset(localView));
        }
        SwipeHelper.invalidateGlobalRegion(localView);
      }
    });
    paramSwipeableItemView.start();
  }
  
  private float getAlphaForOffset(View paramView)
  {
    float f2 = getSize(paramView);
    float f3 = 0.7F * f2;
    float f1 = 1.0F;
    float f4 = paramView.getTranslationX();
    if (f4 >= ALPHA_FADE_START * f2) {
      f1 = 1.0F - (f4 - ALPHA_FADE_START * f2) / f3;
    }
    for (;;)
    {
      return Math.max(mMinAlpha, f1);
      if (f4 < (1.0F - ALPHA_FADE_START) * f2) {
        f1 = 1.0F + (ALPHA_FADE_START * f2 + f4) / f3;
      }
    }
  }
  
  private float getPerpendicularVelocity(VelocityTracker paramVelocityTracker)
  {
    if (mSwipeDirection == 0) {
      return paramVelocityTracker.getYVelocity();
    }
    return paramVelocityTracker.getXVelocity();
  }
  
  private float getSize(View paramView)
  {
    if (mSwipeDirection == 0) {
      return paramView.getMeasuredWidth();
    }
    return paramView.getMeasuredHeight();
  }
  
  private float getVelocity(VelocityTracker paramVelocityTracker)
  {
    if (mSwipeDirection == 0) {
      return paramVelocityTracker.getXVelocity();
    }
    return paramVelocityTracker.getYVelocity();
  }
  
  public static void invalidateGlobalRegion(View paramView)
  {
    invalidateGlobalRegion(paramView, new RectF(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()));
  }
  
  public static void invalidateGlobalRegion(View paramView, RectF paramRectF)
  {
    while ((paramView.getParent() != null) && ((paramView.getParent() instanceof View)))
    {
      paramView = (View)paramView.getParent();
      paramView.getMatrix().mapRect(paramRectF);
      paramView.invalidate((int)Math.floor(left), (int)Math.floor(top), (int)Math.ceil(right), (int)Math.ceil(bottom));
    }
  }
  
  private void setTranslation(View paramView, float paramFloat)
  {
    if (mSwipeDirection == 0)
    {
      paramView.setTranslationX(paramFloat);
      return;
    }
    paramView.setTranslationY(paramFloat);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return mDragging;
      mLastY = paramMotionEvent.getY();
      mDragging = false;
      View localView = mCallback.getChildAtPosition(paramMotionEvent);
      if ((localView instanceof SwipeableItemView)) {
        mCurrView = ((SwipeableItemView)localView);
      }
      mVelocityTracker.clear();
      if (mCurrView != null)
      {
        mCurrAnimView = mCurrView.getSwipeableView();
        mCanCurrViewBeDimissed = mCallback.canChildBeDismissed(mCurrView);
        mVelocityTracker.addMovement(paramMotionEvent);
        mInitialTouchPosX = paramMotionEvent.getX();
        mInitialTouchPosY = paramMotionEvent.getY();
        continue;
        if (mCurrView != null)
        {
          if ((mLastY >= 0.0F) && (!mDragging))
          {
            float f2 = paramMotionEvent.getY();
            float f1 = paramMotionEvent.getX();
            f2 = Math.abs(f2 - mInitialTouchPosY);
            f1 = Math.abs(f1 - mInitialTouchPosX);
            if ((f2 > mCurrView.getMinAllowScrollDistance()) && (f2 > 1.2F * f1))
            {
              mLastY = paramMotionEvent.getY();
              mCallback.onScroll();
              return false;
            }
          }
          mVelocityTracker.addMovement(paramMotionEvent);
          if (Math.abs(paramMotionEvent.getX() - mInitialTouchPosX) > mPagingTouchSlop)
          {
            mCallback.onBeginDrag(mCurrView.getSwipeableView());
            mDragging = true;
            mInitialTouchPosX = (paramMotionEvent.getX() - mCurrAnimView.getTranslationX());
            mInitialTouchPosY = paramMotionEvent.getY();
          }
        }
        mLastY = paramMotionEvent.getY();
        continue;
        mDragging = false;
        mCurrView = null;
        mCurrAnimView = null;
        mLastY = -1.0F;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!mDragging) {
      return false;
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (mCurrView != null)
      {
        float f2 = paramMotionEvent.getX() - mInitialTouchPosX;
        float f1 = Math.abs(paramMotionEvent.getY() - mInitialTouchPosY);
        if ((!mDragging) && (f1 > MIN_VERT) && (Math.abs(f2) < MIN_LOCK) && (f1 > 1.2F * Math.abs(f2)))
        {
          mCallback.onScroll();
          return false;
        }
        f1 = MIN_SWIPE;
        if (Math.abs(f2) < f1) {
          return true;
        }
        f1 = f2;
        float f3;
        if (!mCallback.canChildBeDismissed(mCurrView))
        {
          f3 = getSize(mCurrAnimView);
          f1 = 0.15F * f3;
          if (Math.abs(f2) < f3) {
            break label252;
          }
          if (f2 <= 0.0F) {
            break label246;
          }
        }
        for (;;)
        {
          setTranslation(mCurrAnimView, f1);
          if (mCanCurrViewBeDimissed) {
            mCurrAnimView.setAlpha(getAlphaForOffset(mCurrAnimView));
          }
          invalidateGlobalRegion(mCurrView.getSwipeableView());
          break;
          label246:
          f1 = -f1;
          continue;
          label252:
          f1 *= (float)Math.sin(f2 / f3 * 1.5707963267948966D);
        }
        if (mCurrView != null)
        {
          f1 = MAX_DISMISS_VELOCITY;
          f2 = mDensityScale;
          mVelocityTracker.computeCurrentVelocity(1000, f1 * f2);
          f2 = SWIPE_ESCAPE_VELOCITY;
          f3 = mDensityScale;
          f1 = getVelocity(mVelocityTracker);
          float f4 = getPerpendicularVelocity(mVelocityTracker);
          float f5 = Math.abs(mCurrAnimView.getTranslationX());
          float f6 = getSize(mCurrAnimView);
          int i;
          label370:
          int j;
          label404:
          int k;
          if (f5 > 0.4D * f6)
          {
            i = 1;
            if ((Math.abs(f1) <= f2 * f3) || (Math.abs(f1) <= Math.abs(f4))) {
              break label514;
            }
            if (f1 <= 0.0F) {
              break label502;
            }
            j = 1;
            if (mCurrAnimView.getTranslationX() <= 0.0F) {
              break label508;
            }
            k = 1;
            label419:
            if ((j != k) || (f5 <= 0.05D * f6)) {
              break label514;
            }
            j = 1;
            label443:
            if ((!mCallback.canChildBeDismissed(mCurrView)) || ((j == 0) && (i == 0))) {
              break label520;
            }
            i = 1;
            label472:
            if (i == 0) {
              break label531;
            }
            paramMotionEvent = mCurrView;
            if (j == 0) {
              break label526;
            }
          }
          for (;;)
          {
            dismissChild(paramMotionEvent, f1);
            break;
            i = 0;
            break label370;
            label502:
            j = 0;
            break label404;
            label508:
            k = 0;
            break label419;
            label514:
            j = 0;
            break label443;
            label520:
            i = 0;
            break label472;
            label526:
            f1 = 0.0F;
          }
          label531:
          snapChild(mCurrView, f1);
        }
      }
    }
  }
  
  public void setDensityScale(float paramFloat)
  {
    mDensityScale = paramFloat;
  }
  
  public void setPagingTouchSlop(float paramFloat)
  {
    mPagingTouchSlop = paramFloat;
  }
  
  public void snapChild(SwipeableItemView paramSwipeableItemView, float paramFloat)
  {
    final View localView = paramSwipeableItemView.getSwipeableView();
    final boolean bool = mCallback.canChildBeDismissed(paramSwipeableItemView);
    paramSwipeableItemView = createTranslationAnimation(localView, 0.0F);
    paramSwipeableItemView.setDuration(SNAP_ANIM_LEN);
    paramSwipeableItemView.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (bool) {
          localView.setAlpha(SwipeHelper.this.getAlphaForOffset(localView));
        }
        SwipeHelper.invalidateGlobalRegion(localView);
      }
    });
    paramSwipeableItemView.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localView.setAlpha(1.0F);
        mCallback.onDragCancelled(mCurrView);
      }
      
      public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    paramSwipeableItemView.start();
  }
  
  public static abstract interface Callback
  {
    public abstract boolean canChildBeDismissed(SwipeableItemView paramSwipeableItemView);
    
    public abstract View getChildAtPosition(MotionEvent paramMotionEvent);
    
    public abstract void onBeginDrag(View paramView);
    
    public abstract void onChildDismissed(SwipeableItemView paramSwipeableItemView);
    
    public abstract void onDragCancelled(SwipeableItemView paramSwipeableItemView);
    
    public abstract void onScroll();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SwipeHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */