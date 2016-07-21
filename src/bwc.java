import android.view.View;
import com.android.mail.browse.ConversationContainer;

public final class bwc
  implements Runnable
{
  private final View b;
  
  public bwc(ConversationContainer paramConversationContainer, View paramView)
  {
    b = paramView;
  }
  
  public final void run()
  {
    if (b.getParent() != null)
    {
      b.invalidate();
      return;
    }
    a.addView(b, ConversationContainer.a.length, b.getLayoutParams());
  }
}

/* Location:
 * Qualified Name:     bwc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */