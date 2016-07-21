package com.android.datetimepicker.date;

import android.content.Context;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ViewAnimator;
import java.util.List;

public class AccessibleDateAnimator
  extends ViewAnimator
{
  public long a;
  
  public AccessibleDateAnimator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.getText().clear();
      String str = DateUtils.formatDateTime(getContext(), a, 22);
      paramAccessibilityEvent.getText().add(str);
      return true;
    }
    return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
}

/* Location:
 * Qualified Name:     com.android.datetimepicker.date.AccessibleDateAnimator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */