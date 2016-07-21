import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.providers.ListParams;

final class cjj
  extends ccz<ConversationMessage>
{
  private boolean h = false;
  
  public cjj(Context paramContext, Uri paramUri)
  {
    super(paramContext, paramUri, chh.n, ConversationMessage.b);
  }
  
  protected final ccy<ConversationMessage> a(Cursor paramCursor)
  {
    return new byw(paramCursor);
  }
  
  public final void a(ccy<ConversationMessage> paramccy)
  {
    super.a(paramccy);
    if (!h)
    {
      h = true;
      paramccy = b;
      ListParams localListParams = new ListParams(-1, false);
      a(paramccy.buildUpon().appendQueryParameter("listParams", localListParams.a()).build());
    }
  }
}

/* Location:
 * Qualified Name:     cjj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */