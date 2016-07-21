import android.app.Fragment;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.android.mail.browse.ConversationContainer;
import com.android.mail.ui.ConversationViewFragment;
import com.android.mail.ui.ConversationViewFragment.MailJsBridge;

public final class cmi
  extends cog
{
  public cmi(ConversationViewFragment.MailJsBridge paramMailJsBridge, String paramString, Fragment paramFragment)
  {
    super(paramString, paramFragment);
  }
  
  public final void a()
  {
    try
    {
      if (a.a.O != 0L) {
        cvm.c(ConversationViewFragment.s, "IN CVF.onContentReady, f=%s vis=%s t=%sms", new Object[] { a.a, Boolean.valueOf(a.a.b()), Long.valueOf(SystemClock.uptimeMillis() - a.a.O) });
      }
      Object localObject1 = a.a;
      ((ConversationViewFragment)localObject1).c("revealing conversation");
      if ((!r) && (((ConversationViewFragment)localObject1).b()) && (((ConversationViewFragment)localObject1).A()))
      {
        if ((t) && (x == null)) {
          ((ConversationViewFragment)localObject1).a(null);
        }
        localcmn = C;
        if (t) {}
        for (localObject1 = ab;; localObject1 = aa)
        {
          localcmn.a((Runnable)localObject1);
          return;
        }
      }
      ((ConversationViewFragment)localObject1).f(0);
      w.setVisibility(4);
      A.setVisibility(0);
      C.a(Y);
      return;
    }
    catch (Throwable localThrowable)
    {
      cmn localcmn;
      cvm.e(ConversationViewFragment.s, localThrowable, "Error in MailJsBridge.onContentReady", new Object[0]);
      Object localObject2 = a.a;
      ((ConversationViewFragment)localObject2).c("revealing conversation");
      if ((!r) && (((ConversationViewFragment)localObject2).b()) && (((ConversationViewFragment)localObject2).A()))
      {
        if ((t) && (x == null)) {
          ((ConversationViewFragment)localObject2).a(null);
        }
        localcmn = C;
        if (t) {}
        for (localObject2 = ab;; localObject2 = aa)
        {
          localcmn.a((Runnable)localObject2);
          return;
        }
      }
      ((ConversationViewFragment)localObject2).f(0);
      w.setVisibility(4);
      A.setVisibility(0);
      C.a(Y);
    }
  }
}

/* Location:
 * Qualified Name:     cmi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */