import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ScrollView;
import com.android.ex.chips.RecipientEditTextView;
import java.util.List;

public final class bjv
  implements bie
{
  public bjv(RecipientEditTextView paramRecipientEditTextView) {}
  
  public final void a(List<bkn> paramList)
  {
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      RecipientEditTextView localRecipientEditTextView;
      String str;
      ViewParent localViewParent;
      AccessibilityEvent localAccessibilityEvent;
      if ((paramList != null) && (paramList.size() > 0))
      {
        localRecipientEditTextView = a;
        if ((x != null) && (u))
        {
          localRecipientEditTextView.getLocationInWindow(c);
          int k = localRecipientEditTextView.getHeight();
          int j = c[1] + k;
          x.getLocationInWindow(c);
          int m = c[1];
          k = k / localRecipientEditTextView.getLineCount() + m;
          if (j > k) {
            x.scrollBy(0, j - k);
          }
        }
        if (a.p == 0)
        {
          localRecipientEditTextView = a;
          str = a.getResources().getString(bji.b);
          if ((((AccessibilityManager)localRecipientEditTextView.getContext().getSystemService("accessibility")).isEnabled()) && (Build.VERSION.SDK_INT >= 16))
          {
            localViewParent = localRecipientEditTextView.getParent();
            if (localViewParent != null)
            {
              localAccessibilityEvent = AccessibilityEvent.obtain(16384);
              localRecipientEditTextView.onInitializeAccessibilityEvent(localAccessibilityEvent);
              localAccessibilityEvent.getText().add(str);
              localAccessibilityEvent.setContentDescription(null);
              localViewParent.requestSendAccessibilityEvent(localRecipientEditTextView, localAccessibilityEvent);
            }
          }
        }
      }
      if (((paramList == null) || (paramList.size() == 0)) && (a.p != 0) && (a.getText().length() > 0))
      {
        localRecipientEditTextView = a;
        str = a.getResources().getString(bji.a);
        if ((((AccessibilityManager)localRecipientEditTextView.getContext().getSystemService("accessibility")).isEnabled()) && (Build.VERSION.SDK_INT >= 16))
        {
          localViewParent = localRecipientEditTextView.getParent();
          if (localViewParent != null)
          {
            localAccessibilityEvent = AccessibilityEvent.obtain(16384);
            localRecipientEditTextView.onInitializeAccessibilityEvent(localAccessibilityEvent);
            localAccessibilityEvent.getText().add(str);
            localAccessibilityEvent.setContentDescription(null);
            localViewParent.requestSendAccessibilityEvent(localRecipientEditTextView, localAccessibilityEvent);
          }
        }
      }
      if ((paramList == null) || (paramList.size() != 1) || (get0a != 1))
      {
        a.i.getLocationInWindow(a.c);
        a.getWindowVisibleDisplayFrame(a.b);
        a.setDropDownHeight(a.b.bottom - a.c[1] - a.i.getHeight() - a.getDropDownVerticalOffset());
      }
      a.p = i;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     bjv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */