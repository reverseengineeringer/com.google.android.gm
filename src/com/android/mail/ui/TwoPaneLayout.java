package com.android.mail.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;

final class TwoPaneLayout
  extends FrameLayout
  implements ViewMode.ModeChangeListener
{
  private AbstractActivityController mController;
  private final double mConversationListWeight;
  private View mConversationView;
  private int mCurrentMode = 0;
  private final double mFolderListWeight;
  private View mFoldersView;
  private boolean mIsSearchResult;
  private final boolean mListCollapsible;
  private ConversationListCopy mListCopyView;
  private Integer mListCopyWidthOnComplete;
  private View mListView;
  private LayoutListener mListener;
  private int mPositionedMode = 0;
  private final TimeInterpolator mSlideInterpolator;
  
  public TwoPaneLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TwoPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = getResources();
    mListCollapsible = paramAttributeSet.getBoolean(2131689472);
    mSlideInterpolator = AnimationUtils.loadInterpolator(paramContext, 17563651);
    int i = paramAttributeSet.getInteger(2131361817);
    int j = paramAttributeSet.getInteger(2131361818);
    int k = paramAttributeSet.getInteger(2131361819);
    mFolderListWeight = (i / (i + j));
    mConversationListWeight = (j / (j + k));
  }
  
  private void animatePanes(int paramInt1, int paramInt2, int paramInt3)
  {
    if (mPositionedMode == 0)
    {
      mConversationView.setX(paramInt3);
      mFoldersView.setX(paramInt1);
      mListView.setX(paramInt2);
      post(new Runnable()
      {
        public void run()
        {
          TwoPaneLayout.this.onTransitionComplete();
        }
      });
      return;
    }
    mListCopyView.bind(mListView);
    mListCopyView.setX(mListView.getX());
    mListCopyView.setAlpha(1.0F);
    mListView.setAlpha(0.0F);
    useHardwareLayer(true);
    mConversationView.animate().x(paramInt3);
    mFoldersView.animate().x(paramInt1);
    mListCopyView.animate().x(paramInt2).alpha(0.0F);
    mListView.animate().x(paramInt2).alpha(1.0F).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        mListCopyView.unbind();
        TwoPaneLayout.this.useHardwareLayer(false);
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        mListCopyView.unbind();
        TwoPaneLayout.this.useHardwareLayer(false);
        TwoPaneLayout.this.fixupListCopyWidth();
        TwoPaneLayout.this.onTransitionComplete();
      }
    });
    configureAnimations(new View[] { mConversationView, mFoldersView, mListView, mListCopyView });
  }
  
  private int computeConversationListWidth(int paramInt)
  {
    switch (mCurrentMode)
    {
    case 3: 
    default: 
      return 0;
    case 2: 
    case 4: 
      return paramInt - computeFolderListWidth(paramInt);
    }
    return (int)(paramInt * mConversationListWeight);
  }
  
  private int computeConversationWidth(int paramInt)
  {
    if (mListCollapsible) {
      return paramInt;
    }
    return paramInt - (int)(paramInt * mConversationListWeight);
  }
  
  private int computeFolderListWidth(int paramInt)
  {
    if (mIsSearchResult) {
      return 0;
    }
    return (int)(paramInt * mFolderListWeight);
  }
  
  private void configureAnimations(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].animate().setInterpolator(mSlideInterpolator).setDuration(300L);
      i += 1;
    }
  }
  
  private void dispatchConversationListVisibilityChange(boolean paramBoolean)
  {
    if (mListener != null) {
      mListener.onConversationListVisibilityChanged(paramBoolean);
    }
  }
  
  private void dispatchConversationVisibilityChanged(boolean paramBoolean)
  {
    if (mListener != null) {
      mListener.onConversationVisibilityChanged(paramBoolean);
    }
  }
  
  private void fixupListCopyWidth()
  {
    if ((mListCopyWidthOnComplete == null) || (getPaneWidth(mListCopyView) == mListCopyWidthOnComplete.intValue()))
    {
      mListCopyWidthOnComplete = null;
      return;
    }
    LogUtils.i("TwoPaneLayout", "onAnimationEnd of list view, setting copy width to %d", new Object[] { mListCopyWidthOnComplete });
    setPaneWidth(mListCopyView, mListCopyWidthOnComplete.intValue());
    mListCopyWidthOnComplete = null;
  }
  
  private int getPaneWidth(View paramView)
  {
    return getLayoutParamswidth;
  }
  
  private void onTransitionComplete()
  {
    boolean bool = true;
    if (mController.isDestroyed())
    {
      LogUtils.i("TwoPaneLayout", "IN TPL.onTransitionComplete, activity destroyed->quitting early", new Object[0]);
      return;
    }
    switch (mCurrentMode)
    {
    case 3: 
    default: 
      return;
    case 1: 
    case 5: 
      dispatchConversationVisibilityChanged(true);
      if (!isConversationListCollapsed()) {}
      for (;;)
      {
        dispatchConversationListVisibilityChange(bool);
        return;
        bool = false;
      }
    }
    dispatchConversationVisibilityChanged(false);
    dispatchConversationListVisibilityChange(true);
  }
  
  private void positionPanes(int paramInt)
  {
    if (mPositionedMode == mCurrentMode) {
      return;
    }
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i = i1;
    int j = i3;
    int k = n;
    int m = i2;
    switch (mCurrentMode)
    {
    default: 
      m = i2;
      k = n;
      j = i3;
      i = i1;
    }
    for (;;)
    {
      if (k != 0) {
        animatePanes(j, m, i);
      }
      mPositionedMode = mCurrentMode;
      return;
      j = getPaneWidth(mFoldersView);
      paramInt = getPaneWidth(mListView);
      if (mListCollapsible)
      {
        i = 0;
        m = -paramInt;
      }
      for (j = m - j;; j = -j)
      {
        k = 1;
        LogUtils.i("TwoPaneLayout", "conversation mode layout, x=%d/%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(i) });
        break;
        i = paramInt;
        m = 0;
      }
      m = getPaneWidth(mFoldersView);
      j = 0;
      k = 1;
      LogUtils.i("TwoPaneLayout", "conv-list mode layout, x=%d/%d/%d", new Object[] { Integer.valueOf(0), Integer.valueOf(m), Integer.valueOf(paramInt) });
      i = paramInt;
    }
  }
  
  private void setPaneWidth(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (width == paramInt) {
      return;
    }
    width = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void setupPaneWidths(int paramInt)
  {
    int k = computeFolderListWidth(paramInt);
    int m = computeConversationWidth(paramInt);
    if (paramInt != getMeasuredWidth())
    {
      LogUtils.i("TwoPaneLayout", "setting up new TPL, w=%d fw=%d cv=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(m) });
      setPaneWidth(mFoldersView, k);
      setPaneWidth(mConversationView, m);
    }
    int j = getPaneWidth(mListView);
    int i = j;
    switch (mCurrentMode)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      LogUtils.d("TwoPaneLayout", "conversation list width change, w=%d", new Object[] { Integer.valueOf(i) });
      setPaneWidth(mListView, i);
      if (((mCurrentMode == mPositionedMode) || (mPositionedMode == 0)) && (mListCopyWidthOnComplete == null)) {
        break;
      }
      mListCopyWidthOnComplete = Integer.valueOf(i);
      return;
      i = j;
      if (!mListCollapsible)
      {
        i = paramInt - m;
        continue;
        i = paramInt - k;
      }
    }
    setPaneWidth(mListCopyView, i);
  }
  
  private void useHardwareLayer(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      mFoldersView.setLayerType(i, null);
      mListView.setLayerType(i, null);
      mListCopyView.setLayerType(i, null);
      mConversationView.setLayerType(i, null);
      if (paramBoolean)
      {
        mFoldersView.buildLayer();
        mListView.buildLayer();
        mListCopyView.buildLayer();
        mConversationView.buildLayer();
      }
      return;
    }
  }
  
  protected int computeConversationListWidth()
  {
    return computeConversationListWidth(getMeasuredWidth());
  }
  
  public boolean isConversationListCollapsed()
  {
    return (!ViewMode.isListMode(mCurrentMode)) && (mListCollapsible);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mFoldersView = findViewById(2131755198);
    mListView = findViewById(2131755260);
    mListCopyView = ((ConversationListCopy)findViewById(2131755261));
    mConversationView = findViewById(2131755179);
    mCurrentMode = 0;
    mFoldersView.setVisibility(8);
    mListView.setVisibility(8);
    mListCopyView.setVisibility(8);
    mConversationView.setVisibility(8);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LogUtils.d("MailBlankFragment", "TPL(%s).onLayout()", new Object[] { this });
    if ((paramBoolean) || (mCurrentMode != mPositionedMode)) {
      positionPanes(getMeasuredWidth());
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    LogUtils.d("MailBlankFragment", "TPL(%s).onMeasure()", new Object[] { this });
    setupPaneWidths(View.MeasureSpec.getSize(paramInt1));
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onViewModeChanged(int paramInt)
  {
    if (mCurrentMode == 0)
    {
      mFoldersView.setVisibility(0);
      mListView.setVisibility(0);
      mListCopyView.setVisibility(0);
      mConversationView.setVisibility(0);
    }
    if (ViewMode.isConversationMode(mCurrentMode)) {
      mController.disablePagerUpdates();
    }
    mCurrentMode = paramInt;
    LogUtils.i("TwoPaneLayout", "onViewModeChanged(%d)", new Object[] { Integer.valueOf(paramInt) });
    requestLayout();
  }
  
  public void requestLayout()
  {
    Utils.checkRequestLayout(this);
    super.requestLayout();
  }
  
  public void setController(AbstractActivityController paramAbstractActivityController, boolean paramBoolean)
  {
    mController = paramAbstractActivityController;
    mListener = paramAbstractActivityController;
    mIsSearchResult = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.TwoPaneLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */