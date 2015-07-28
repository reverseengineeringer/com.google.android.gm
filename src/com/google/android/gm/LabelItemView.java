package com.google.android.gm;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gm.provider.Label;

public class LabelItemView
  extends RelativeLayout
{
  private static Drawable DRAG_STEADY_STATE_BACKGROUND;
  private static Drawable DROPPABLE_HOVER_BACKGROUND;
  private static int NON_DROPPABLE_TARGET_TEXT_COLOR;
  private static Bitmap SHORTCUT_ICON;
  private Drawable mBackground;
  private DropHandler mDropHandler;
  private ColorStateList mInitialLabelTextColor;
  private ColorStateList mInitialUnreadCountTextColor;
  private Label mLabel;
  private TextView mLabelTextView;
  private TextView mUnreadCountTextView;
  
  public LabelItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LabelItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LabelItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean isDroppableTarget(DragEvent paramDragEvent)
  {
    return (mDropHandler != null) && (mDropHandler.supportsDrag(paramDragEvent, mLabel));
  }
  
  public void bind(String paramString, Label paramLabel, DropHandler paramDropHandler)
  {
    mLabel = paramLabel;
    mDropHandler = paramDropHandler;
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    boolean bool = true;
    switch (paramDragEvent.getAction())
    {
    default: 
    case 2: 
    case 1: 
    case 5: 
    case 6: 
      do
      {
        do
        {
          bool = false;
          return bool;
          if (!isDroppableTarget(paramDragEvent))
          {
            mInitialLabelTextColor = mLabelTextView.getTextColors();
            mInitialUnreadCountTextColor = mUnreadCountTextView.getTextColors();
            mLabelTextView.setTextColor(NON_DROPPABLE_TARGET_TEXT_COLOR);
            mUnreadCountTextView.setTextColor(NON_DROPPABLE_TARGET_TEXT_COLOR);
          }
          setBackgroundDrawable(DRAG_STEADY_STATE_BACKGROUND);
          return true;
        } while (!isDroppableTarget(paramDragEvent));
        setBackgroundDrawable(DROPPABLE_HOVER_BACKGROUND);
        return true;
      } while (!isDroppableTarget(paramDragEvent));
      setBackgroundDrawable(DRAG_STEADY_STATE_BACKGROUND);
      return true;
    case 4: 
      if (!isDroppableTarget(paramDragEvent))
      {
        mLabelTextView.setTextColor(mInitialLabelTextColor);
        mUnreadCountTextView.setTextColor(mInitialUnreadCountTextColor);
      }
      setBackgroundDrawable(mBackground);
      return true;
    }
    if (mDropHandler == null) {
      return false;
    }
    mDropHandler.handleDrop(paramDragEvent, mLabel);
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (SHORTCUT_ICON == null)
    {
      Resources localResources = getResources();
      SHORTCUT_ICON = BitmapFactory.decodeResource(localResources, 2130903042);
      DROPPABLE_HOVER_BACKGROUND = localResources.getDrawable(2130837612);
      DRAG_STEADY_STATE_BACKGROUND = localResources.getDrawable(2130837614);
      NON_DROPPABLE_TARGET_TEXT_COLOR = localResources.getColor(2131296300);
    }
    mLabelTextView = ((TextView)findViewById(2131755069));
    mUnreadCountTextView = ((TextView)findViewById(2131755068));
    mBackground = getBackground();
    mInitialLabelTextColor = mLabelTextView.getTextColors();
    mInitialUnreadCountTextColor = mUnreadCountTextView.getTextColors();
  }
  
  public static abstract interface DropHandler
  {
    public abstract void handleDrop(DragEvent paramDragEvent, Label paramLabel);
    
    public abstract boolean supportsDrag(DragEvent paramDragEvent, Label paramLabel);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */