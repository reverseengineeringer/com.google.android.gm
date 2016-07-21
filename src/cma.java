import android.app.Fragment;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.ui.ConversationViewFragment;

public final class cma
  extends cog
{
  public cma(ConversationViewFragment paramConversationViewFragment, String paramString, Fragment paramFragment)
  {
    super(paramString, paramFragment);
  }
  
  public final void a()
  {
    int j = 0;
    ConversationViewFragment localConversationViewFragment = a;
    int i;
    if (localConversationViewFragment.b())
    {
      cvm.c(ConversationViewFragment.s, "SHOWCONV: CVF is user-visible, immediately loading conversation (%s)", new Object[] { localConversationViewFragment });
      localConversationViewFragment.c("CVF.showConversation");
      i = j;
    }
    for (;;)
    {
      K = i;
      if (K == 0) {
        localConversationViewFragment.z();
      }
      return;
      if ((cud.a(j)) || ((d != null) && ((d.v) || (d.t.b > I)))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label133;
        }
        cvm.c(ConversationViewFragment.s, "SHOWCONV: CVF waiting until visible to load (%s)", new Object[] { localConversationViewFragment });
        i = 2;
        break;
      }
      label133:
      if (localConversationViewFragment.e().Z())
      {
        cvm.c(ConversationViewFragment.s, "SHOWCONV: CVF waiting for initial to finish (%s)", new Object[] { localConversationViewFragment });
        localConversationViewFragment.e().m(X);
        i = 1;
      }
      else
      {
        cvm.c(ConversationViewFragment.s, "SHOWCONV: CVF is not visible, but no reason to wait. loading now. (%s)", new Object[] { localConversationViewFragment });
        i = j;
      }
    }
  }
}

/* Location:
 * Qualified Name:     cma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */