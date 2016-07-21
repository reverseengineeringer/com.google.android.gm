import android.app.Fragment;
import com.android.mail.browse.ConversationWebView;
import com.android.mail.ui.ConversationViewFragment;

public final class cly
  extends cog
{
  public cly(ConversationViewFragment paramConversationViewFragment, String paramString, Fragment paramFragment)
  {
    super(paramString, paramFragment);
  }
  
  public final void a()
  {
    cvm.b(ConversationViewFragment.s, "onProgressDismiss go() - isUserVisible() = %b", new Object[] { Boolean.valueOf(a.b()) });
    if (a.b()) {
      a.p();
    }
    ConversationWebView localConversationWebView = a.B;
    if (b) {
      localConversationWebView.postDelayed(d, a);
    }
  }
}

/* Location:
 * Qualified Name:     cly
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */