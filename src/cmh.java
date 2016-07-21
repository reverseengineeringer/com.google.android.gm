import android.app.Fragment;
import com.android.mail.browse.ConversationContainer;
import com.android.mail.browse.ConversationWebView;
import com.android.mail.ui.ConversationViewFragment;
import com.android.mail.ui.ConversationViewFragment.MailJsBridge;

public final class cmh
  extends cog
{
  public cmh(ConversationViewFragment.MailJsBridge paramMailJsBridge, String paramString, Fragment paramFragment, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    super(paramString, paramFragment);
  }
  
  public final void a()
  {
    if (!c.a.G) {
      cvm.b(ConversationViewFragment.s, "ignoring webContentGeometryChange because views are gone, %s", new Object[] { c.a });
    }
    do
    {
      return;
      ConversationContainer localConversationContainer = c.a.A;
      bwe[] arrayOfbwe = ConversationViewFragment.a(a, b);
      localConversationContainer.a("*** got overlay spacer positions:", new Object[0]);
      int j = arrayOfbwe.length;
      i = 0;
      while (i < j)
      {
        bwe localbwe = arrayOfbwe[i];
        localConversationContainer.a("top=%d bottom=%d", new Object[] { Integer.valueOf(a), Integer.valueOf(b) });
        i += 1;
      }
      c = arrayOfbwe;
      localConversationContainer.a(d, false);
    } while (c.a.v == 0);
    int i = (int)(c.a.B.getScale() / c.a.B.b());
    if (i > 1) {
      c.a.B.scrollBy(0, (i - 1) * c.a.v);
    }
    c.a.v = 0;
  }
}

/* Location:
 * Qualified Name:     cmh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */