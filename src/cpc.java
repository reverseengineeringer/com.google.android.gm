import android.app.Activity;
import android.app.LoaderManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.android.mail.drawer.CurrentFolderDialogState;
import com.android.mail.providers.Folder;

public final class cpc
  extends cpz
{
  private CurrentFolderDialogState h;
  private cpe i;
  
  protected final void a(int paramInt)
  {
    Object localObject = a.getItem(paramInt);
    if ((localObject instanceof cuq))
    {
      localObject = (cuq)localObject;
      Folder localFolder = a;
      if (h != null)
      {
        h.b = c;
        h.c = localFolder;
        h.d = true;
      }
      dismiss();
    }
  }
  
  public final void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      i = ((cpe)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(String.valueOf(paramActivity.toString()).concat(" must implement NestUnderFolderListener"));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f = buj.cO;
    h = ((CurrentFolderDialogState)g);
    getLoaderManager().initLoader(0, Bundle.EMPTY, this);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    i.a(d, h);
    super.onDismiss(paramDialogInterface);
  }
}

/* Location:
 * Qualified Name:     cpc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */