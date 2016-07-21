import android.app.Fragment;
import com.android.mail.ui.ConversationViewFragment;
import com.android.mail.ui.ConversationViewFragment.MailJsBridge;
import java.util.Map;

public final class cmj
  extends cog
{
  public cmj(ConversationViewFragment.MailJsBridge paramMailJsBridge, String paramString, Fragment paramFragment, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    super(paramString, paramFragment);
  }
  
  public final void a()
  {
    try
    {
      int j = a.length;
      int i = 0;
      while (i < j)
      {
        c.a.Z.put(a[i], b[i]);
        i += 1;
      }
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      cvm.e(ConversationViewFragment.s, localArrayIndexOutOfBoundsException, "Number of urls does not match number of message ids - %s:%s", new Object[] { Integer.valueOf(a.length), Integer.valueOf(b.length) });
      ConversationViewFragment.a(c.a.B, "unblockAllTemporarilyHiddenImages()", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     cmj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */