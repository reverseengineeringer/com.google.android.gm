import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.FolderList;
import com.android.mail.ui.FolderOperation;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class ckr
  extends cob
{
  private boolean h;
  private final HashMap<Uri, FolderOperation> i = new HashMap();
  
  protected final void a(int paramInt)
  {
    Object localObject1 = a.getItem(paramInt);
    if ((localObject1 instanceof cuq))
    {
      localObject1 = (cuq)localObject1;
      if (!b) {}
      for (boolean bool = true; h; bool = false)
      {
        if (!bool) {
          return;
        }
        int j = a.getCount();
        paramInt = 0;
        while (paramInt < j)
        {
          Object localObject2 = a.getItem(paramInt);
          if ((localObject2 instanceof cuq))
          {
            b = false;
            localObject2 = a;
            i.put(c.b, new FolderOperation((Folder)localObject2, Boolean.valueOf(false)));
          }
          paramInt += 1;
        }
      }
      b = bool;
      a.notifyDataSetChanged();
      localObject1 = a;
      i.put(c.b, new FolderOperation((Folder)localObject1, Boolean.valueOf(bool)));
    }
  }
  
  protected final void a(Context paramContext, Cursor paramCursor)
  {
    HashSet localHashSet = new HashSet();
    Object localObject1 = b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = nextn.a;
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        localHashSet.addAll(Arrays.asList(Folder.b((List)localObject2)));
      } else {
        localHashSet.add(e.c.b.toString());
      }
    }
    localObject1 = hfd.a(localHashSet);
    Object localObject2 = i.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (getValuec) {
        localHashSet.add(((Uri)localEntry.getKey()).toString());
      } else {
        localHashSet.remove(((Uri)localEntry.getKey()).toString());
      }
    }
    localObject2 = cjx.a(paramCursor, hfd.b(Integer.valueOf(1024)), (Set)localObject1, true);
    if (((Cursor)localObject2).getCount() > 0) {
      a.a(new cjx(paramContext, (Cursor)localObject2, localHashSet, bue.Y));
    }
    paramCursor = cjx.a(paramCursor, hfd.b(Integer.valueOf(1024)), (Set)localObject1, false);
    if (paramCursor.getCount() > 0) {
      a.a(new cjx(paramContext, paramCursor, localHashSet, bue.Y));
    }
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a().a(i.values(), b, c, false);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!d.a(16384L)) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      f = buj.ae;
      if (paramBundle == null) {
        break;
      }
      paramBundle = (FolderOperation[])cwl.a(paramBundle, "operations", FolderOperation.class);
      int k = paramBundle.length;
      int j = 0;
      while (j < k)
      {
        Object localObject = paramBundle[j];
        i.put(b.c.b, localObject);
        j += 1;
      }
    }
    getLoaderManager().initLoader(0, null, this);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArray("operations", (Parcelable[])i.values().toArray(new FolderOperation[i.size()]));
  }
}

/* Location:
 * Qualified Name:     ckr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */