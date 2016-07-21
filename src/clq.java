import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import com.android.mail.ui.ConversationViewFragment;

public final class clq
  implements ViewTreeObserver.OnPreDrawListener
{
  public clq(ConversationViewFragment paramConversationViewFragment) {}
  
  public final boolean onPreDraw()
  {
    Object localObject = a.b.getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null) {
        ((View)localObject).getViewTreeObserver().removeOnPreDrawListener(this);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     clq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */