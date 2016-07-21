import android.content.AsyncQueryHandler;
import android.content.Context;
import com.android.mail.browse.MessageInviteView;

public final class bzi
  extends AsyncQueryHandler
{
  public bzi(MessageInviteView paramMessageInviteView)
  {
    super(paramMessageInviteView.getContext().getContentResolver());
  }
}

/* Location:
 * Qualified Name:     bzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */