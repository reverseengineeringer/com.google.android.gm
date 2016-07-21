import com.android.mail.providers.Conversation;
import com.android.mail.ui.ConversationCheckedSet;
import java.util.Collection;
import java.util.Iterator;

final class chy
  implements Runnable
{
  chy(cht paramcht, Collection paramCollection, cmx paramcmx, boolean paramBoolean) {}
  
  public final void run()
  {
    cht localcht = d;
    Collection localCollection = a;
    cmx localcmx = b;
    if (!c)
    {
      localObject = localCollection.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Conversation localConversation = (Conversation)((Iterator)localObject).next();
        if (B.a(localConversation)) {
          B.b(localConversation);
        }
      }
    }
    Object localObject = localcht.g();
    if (localObject != null)
    {
      cvm.c(cht.I, "AAC.doDelete: ListFragment is handling delete", new Object[0]);
      ((cje)localObject).a(localCollection, localcmx, localcht.al());
      return;
    }
    cvm.c(cht.I, "ACC.doDelete: performing remove action ourselves", new Object[0]);
    localcmx.a();
  }
}

/* Location:
 * Qualified Name:     chy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */