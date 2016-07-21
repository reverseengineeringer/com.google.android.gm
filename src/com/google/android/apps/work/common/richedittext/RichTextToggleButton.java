package com.google.android.apps.work.common.richedittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.ToggleButton;
import java.util.List;

public class RichTextToggleButton
  extends ToggleButton
{
  private boolean a = true;
  
  public RichTextToggleButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public RichTextToggleButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RichTextToggleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public RichTextToggleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
    if (!a) {
      paramAccessibilityEvent.setChecked(false);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
    paramAccessibilityNodeInfo.setCheckable(a);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ("".equals(getText())) {
      paramAccessibilityEvent.getText().add(getContentDescription());
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.work.common.richedittext.RichTextToggleButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */