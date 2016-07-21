import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.android.mail.drawer.CurrentFolderDialogState;
import com.android.mail.providers.Folder;

public final class cdf
  extends cot<cdg>
{
  private final String a;
  private final long b;
  private final Uri c;
  
  public cdf(Context paramContext, Bundle paramBundle)
  {
    super(paramContext);
    a = paramBundle.getString("folderName");
    c = ((Uri)paramBundle.getParcelable("createFolderUri"));
    paramContext = (CurrentFolderDialogState)paramBundle.getParcelable("dialogState");
    if ((paramContext != null) && (c != null))
    {
      b = c.a;
      return;
    }
    b = -1L;
  }
}

/* Location:
 * Qualified Name:     cdf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */