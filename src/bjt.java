import android.os.Handler;
import android.os.Message;
import android.widget.ListPopupWindow;
import com.android.ex.chips.RecipientEditTextView;

public final class bjt
  extends Handler
{
  public bjt(RecipientEditTextView paramRecipientEditTextView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (what == RecipientEditTextView.a)
    {
      ((ListPopupWindow)obj).dismiss();
      return;
    }
    super.handleMessage(paramMessage);
  }
}

/* Location:
 * Qualified Name:     bjt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */