import android.database.DataSetObserver;
import android.os.Handler;
import com.android.mail.ui.ConversationViewFragment;

public final class clm
  extends DataSetObserver
{
  public clm(ConversationViewFragment paramConversationViewFragment) {}
  
  public final void onChanged()
  {
    a.l.post(new cln(this, "delayedConversationLoad", a));
  }
}

/* Location:
 * Qualified Name:     clm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */