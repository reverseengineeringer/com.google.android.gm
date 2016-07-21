import android.app.FragmentManager;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;

public final class dii
  extends bvm
{
  private static final String a = cvl.a;
  
  public final void a(String paramString, Message paramMessage, Attachment paramAttachment, FragmentManager paramFragmentManager)
  {
    paramMessage = e;
    paramAttachment = m;
    dij localdij = new dij();
    localdij.setArguments(djv.a(paramString, paramMessage, paramAttachment));
    localdij.setCancelable(false);
    try
    {
      localdij.show(paramFragmentManager, "drive-progress-dialog");
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      dri.d(a, paramString, "GmailAttachmentSaveHandler cannot show progress dialog", new Object[0]);
    }
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    return ("com.google".equals(paramString1)) && (!"application/ics".equals(paramString2)) && (!"text/calendar".equals(paramString2));
  }
}

/* Location:
 * Qualified Name:     dii
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */