import android.database.DataSetObserver;
import com.android.mail.browse.ConversationContainer;

public final class bwb
  extends DataSetObserver
{
  public bwb(ConversationContainer paramConversationContainer) {}
  
  public final void onChanged()
  {
    ConversationContainer localConversationContainer = a;
    localConversationContainer.a();
    localConversationContainer.a(d, false);
  }
}

/* Location:
 * Qualified Name:     bwb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */