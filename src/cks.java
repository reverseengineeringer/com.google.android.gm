import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.android.mail.compose.ComposeAttachmentTile;
import com.android.mail.providers.Attachment;
import com.android.mail.ui.ComposeAttachmentTileGrid;
import java.util.List;

public final class cks
  implements View.OnClickListener
{
  public cks(ComposeAttachmentTileGrid paramComposeAttachmentTileGrid, ComposeAttachmentTile paramComposeAttachmentTile, Attachment paramAttachment) {}
  
  public final void onClick(View paramView)
  {
    paramView = c;
    ComposeAttachmentTile localComposeAttachmentTile = a;
    Attachment localAttachment = b;
    b.remove(localAttachment);
    if (localAttachment.j()) {
      i -= 1;
    }
    ((ViewGroup)localComposeAttachmentTile.getParent()).removeView(localComposeAttachmentTile);
    if (j != null) {
      j.s();
    }
  }
}

/* Location:
 * Qualified Name:     cks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */