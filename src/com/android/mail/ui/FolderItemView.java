package com.android.mail.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.mail.providers.Folder;
import com.android.mail.utils.Utils;

public class FolderItemView
  extends RelativeLayout
{
  private static Drawable DRAG_STEADY_STATE_BACKGROUND;
  private static Drawable DROPPABLE_HOVER_BACKGROUND;
  private static int NON_DROPPABLE_TARGET_TEXT_COLOR;
  private static Bitmap SHORTCUT_ICON;
  private Drawable mBackground;
  private DropHandler mDropHandler;
  private Folder mFolder;
  private ImageView mFolderParentIcon;
  private TextView mFolderTextView;
  private ColorStateList mInitialFolderTextColor;
  private ColorStateList mInitialUnreadCountTextColor;
  private TextView mUnreadCountTextView;
  
  public FolderItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FolderItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FolderItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean isDroppableTarget(DragEvent paramDragEvent)
  {
    return (mDropHandler != null) && (mDropHandler.supportsDrag(paramDragEvent, mFolder));
  }
  
  public void bind(Folder paramFolder, DropHandler paramDropHandler)
  {
    int j = 0;
    mFolder = paramFolder;
    mDropHandler = paramDropHandler;
    mFolderTextView.setText(name);
    paramFolder = mFolderParentIcon;
    int k;
    if (mFolder.hasChildren)
    {
      i = 0;
      paramFolder.setVisibility(i);
      k = Utils.getFolderUnreadDisplayCount(mFolder);
      paramFolder = mUnreadCountTextView;
      if (k <= 0) {
        break label101;
      }
    }
    label101:
    for (int i = j;; i = 8)
    {
      paramFolder.setVisibility(i);
      if (k > 0) {
        mUnreadCountTextView.setText(Utils.getUnreadCountString(getContext(), k));
      }
      return;
      i = 8;
      break;
    }
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
            mInitialFolderTextColor = mFolderTextView.getTextColors();
            mInitialUnreadCountTextColor = mUnreadCountTextView.getTextColors();
            mFolderTextView.setTextColor(NON_DROPPABLE_TARGET_TEXT_COLOR);
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
        mFolderTextView.setTextColor(mInitialFolderTextColor);
        mUnreadCountTextView.setTextColor(mInitialUnreadCountTextColor);
      }
      setBackgroundDrawable(mBackground);
      return true;
    }
    if (mDropHandler == null) {
      return false;
    }
    mDropHandler.handleDrop(paramDragEvent, mFolder);
    return true;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (SHORTCUT_ICON == null)
    {
      Resources localResources = getResources();
      SHORTCUT_ICON = BitmapFactory.decodeResource(localResources, 2130903041);
      DROPPABLE_HOVER_BACKGROUND = localResources.getDrawable(2130837534);
      DRAG_STEADY_STATE_BACKGROUND = localResources.getDrawable(2130837536);
      NON_DROPPABLE_TARGET_TEXT_COLOR = localResources.getColor(2131296290);
    }
    mFolderTextView = ((TextView)findViewById(2131755069));
    mUnreadCountTextView = ((TextView)findViewById(2131755068));
    mBackground = getBackground();
    mInitialFolderTextColor = mFolderTextView.getTextColors();
    mInitialUnreadCountTextColor = mUnreadCountTextView.getTextColors();
    mFolderParentIcon = ((ImageView)findViewById(2131755066));
  }
  
  public static abstract interface DropHandler
  {
    public abstract void handleDrop(DragEvent paramDragEvent, Folder paramFolder);
    
    public abstract boolean supportsDrag(DragEvent paramDragEvent, Folder paramFolder);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */