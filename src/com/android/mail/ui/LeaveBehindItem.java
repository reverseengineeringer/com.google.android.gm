package com.android.mail.ui;

import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.browse.ConversationItemViewCoordinates;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.google.common.collect.ImmutableList;

public class LeaveBehindItem
  extends FrameLayout
  implements View.OnClickListener, SwipeableItemView
{
  private static int sFadeInAnimationDuration = -1;
  private static float sScrollSlop;
  private static int sShrinkAnimationDuration = -1;
  private Account mAccount;
  private AnimatedAdapter mAdapter;
  private int mAnimatedHeight = -1;
  private boolean mAnimating;
  private Conversation mData;
  private boolean mFadingInText;
  private View mSwipeableContent;
  private TextView mText;
  private ToastBarOperation mUndoOp;
  private int mWidth;
  public int position;
  
  public LeaveBehindItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LeaveBehindItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public LeaveBehindItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (sShrinkAnimationDuration == -1)
    {
      paramContext = paramContext.getResources();
      sShrinkAnimationDuration = paramContext.getInteger(2131361801);
      sFadeInAnimationDuration = paramContext.getInteger(2131361803);
      sScrollSlop = paramContext.getInteger(2131361822);
    }
  }
  
  public void bindOperations(int paramInt, Account paramAccount, AnimatedAdapter paramAnimatedAdapter, ToastBarOperation paramToastBarOperation, Conversation paramConversation, Folder paramFolder)
  {
    position = paramInt;
    mUndoOp = paramToastBarOperation;
    mAccount = paramAccount;
    mAdapter = paramAnimatedAdapter;
    setData(paramConversation);
    mSwipeableContent = findViewById(2131755251);
    mSwipeableContent.setOnClickListener(this);
    mText = ((TextView)findViewById(2131755252));
    mText.setText(Html.fromHtml(mUndoOp.getSingularDescription(getContext(), paramFolder)));
    mText.setOnClickListener(this);
  }
  
  public boolean canChildBeDismissed()
  {
    return true;
  }
  
  public void commit()
  {
    ConversationCursor localConversationCursor = mAdapter.getConversationCursor();
    if (localConversationCursor != null) {
      localConversationCursor.delete(getContext(), ImmutableList.of(getData()));
    }
  }
  
  public void dismiss()
  {
    if (mAdapter != null)
    {
      mAdapter.fadeOutLeaveBehindItems();
      mAdapter.notifyDataSetChanged();
    }
  }
  
  public long getConversationId()
  {
    return getDataid;
  }
  
  public Conversation getData()
  {
    return mData;
  }
  
  public LeaveBehindData getLeaveBehindData()
  {
    return new LeaveBehindData(getData(), mUndoOp);
  }
  
  public float getMinAllowScrollDistance()
  {
    return sScrollSlop;
  }
  
  public View getSwipeableView()
  {
    return mSwipeableContent;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while (mAccount.undoUri == null);
      mAdapter.clearLeaveBehind(getConversationId());
      mAdapter.setSwipeUndo(true);
      paramView = mAdapter.getConversationCursor();
    } while (paramView == null);
    paramView.undo(getContext(), mAccount.undoUri);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (mAnimatedHeight != -1)
    {
      setMeasuredDimension(mWidth, mAnimatedHeight);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAnimatedHeight(int paramInt)
  {
    mAnimatedHeight = paramInt;
    requestLayout();
  }
  
  public void setData(Conversation paramConversation)
  {
    mData = paramConversation;
  }
  
  public void showTextImmediately()
  {
    mFadingInText = true;
  }
  
  public void startAnimation(ViewMode paramViewMode, Animator.AnimatorListener paramAnimatorListener)
  {
    if (!mAnimating)
    {
      mAnimating = true;
      int i = ConversationItemViewCoordinates.getMinHeight(getContext(), paramViewMode);
      setMinimumHeight(i);
      paramViewMode = ObjectAnimator.ofInt(this, "animatedHeight", new int[] { i, 0 });
      mAnimatedHeight = i;
      mWidth = getMeasuredWidth();
      mSwipeableContent.setVisibility(8);
      paramViewMode.setInterpolator(new DecelerateInterpolator(2.0F));
      paramViewMode.addListener(paramAnimatorListener);
      paramViewMode.setDuration(sShrinkAnimationDuration);
      paramViewMode.start();
    }
  }
  
  public void startFadeInAnimation()
  {
    if (!mFadingInText)
    {
      mFadingInText = true;
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(mText, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setInterpolator(new DecelerateInterpolator(2.0F));
      localObjectAnimator.setDuration(sFadeInAnimationDuration);
      localObjectAnimator.start();
    }
  }
  
  public class LeaveBehindData
    implements Parcelable
  {
    public final Parcelable.Creator<LeaveBehindData> CREATOR = new Parcelable.Creator()
    {
      public LeaveBehindItem.LeaveBehindData createFromParcel(Parcel paramAnonymousParcel)
      {
        return new LeaveBehindItem.LeaveBehindData(LeaveBehindItem.this, paramAnonymousParcel, null);
      }
      
      public LeaveBehindItem.LeaveBehindData[] newArray(int paramAnonymousInt)
      {
        return new LeaveBehindItem.LeaveBehindData[paramAnonymousInt];
      }
    };
    Conversation data;
    ToastBarOperation op;
    
    private LeaveBehindData(Parcel paramParcel)
    {
      this((Conversation)paramParcel.readParcelable(null), (ToastBarOperation)paramParcel.readParcelable(null));
    }
    
    public LeaveBehindData(Conversation paramConversation, ToastBarOperation paramToastBarOperation)
    {
      op = paramToastBarOperation;
      data = paramConversation;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(op, 0);
      paramParcel.writeParcelable(data, 0);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.LeaveBehindItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */