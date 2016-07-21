import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.WebChromeClient;
import com.android.mail.ui.ConversationViewFragment;

public final class clr
  extends WebChromeClient
{
  public clr(ConversationViewFragment paramConversationViewFragment) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR)
    {
      cvm.e(ConversationViewFragment.s, "JS: %s (%s:%d) f=%s", new Object[] { paramConsoleMessage.message(), paramConsoleMessage.sourceId(), Integer.valueOf(paramConsoleMessage.lineNumber()), a });
      return true;
    }
    cvm.c(ConversationViewFragment.s, "JS: %s (%s:%d) f=%s", new Object[] { paramConsoleMessage.message(), paramConsoleMessage.sourceId(), Integer.valueOf(paramConsoleMessage.lineNumber()), a });
    return true;
  }
}

/* Location:
 * Qualified Name:     clr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */