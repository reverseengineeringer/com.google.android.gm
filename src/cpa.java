import android.app.LoaderManager;
import android.os.Bundle;
import com.android.mail.providers.Folder;
import com.android.mail.ui.FolderOperation;
import java.util.ArrayList;

public final class cpa
  extends cpz
{
  protected final void a(int paramInt)
  {
    Object localObject = a.getItem(paramInt);
    if ((localObject instanceof cuq))
    {
      localObject = a;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new FolderOperation(e, Boolean.valueOf(false)));
      localArrayList.add(new FolderOperation((Folder)localObject, Boolean.valueOf(true)));
      a().a(localArrayList, b, c, true);
      dismiss();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    f = buj.di;
    getLoaderManager().initLoader(0, null, this);
  }
}

/* Location:
 * Qualified Name:     cpa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */