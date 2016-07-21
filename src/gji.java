import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

public final class gji
  extends WebChromeClient
{
  public gji(gjg paramgjg) {}
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String.valueOf(gjg.a).concat("_JS");
    paramConsoleMessage.message();
    return true;
  }
}

/* Location:
 * Qualified Name:     gji
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */