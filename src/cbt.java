import com.android.mail.ui.AttachmentTileGrid;
import java.util.List;

final class cbt
  implements Runnable
{
  cbt(cbk paramcbk, List paramList) {}
  
  public final void run()
  {
    long l = b.a(a);
    if (l > 0L)
    {
      b.D = true;
      b.n();
      buo.a().a("send_intent_with_attachments", Integer.toString(b.r.b.size()), null, l);
    }
  }
}

/* Location:
 * Qualified Name:     cbt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */