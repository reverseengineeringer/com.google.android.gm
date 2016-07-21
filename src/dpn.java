import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gm.provider.CombinedAccountsProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dpn
  extends cvp
{
  private static final String a = cvl.a;
  private final List<Cursor> b;
  private final String c;
  private final String d;
  
  public dpn(List<Cursor> paramList, String[] paramArrayOfString, String paramString1, String paramString2)
  {
    super(paramArrayOfString, 1);
    b = new ArrayList(paramList);
    c = paramString1;
    d = paramString2;
    a();
  }
  
  private final Uri a(Uri paramUri, String paramString)
  {
    paramUri = paramUri.buildUpon().appendQueryParameter("query", c).appendQueryParameter("query_identifier", d);
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Cursor localCursor = (Cursor)localIterator.next();
      if ((localCursor != null) && (localCursor.moveToFirst())) {
        paramUri.appendQueryParameter("inner-uri", localCursor.getString(localCursor.getColumnIndex(paramString)));
      }
    }
    return paramUri.build();
  }
  
  private final void a()
  {
    String[] arrayOfString = getColumnNames();
    Object[] arrayOfObject = new Object[arrayOfString.length];
    int j = 0;
    Object localObject;
    label236:
    int i;
    label238:
    label830:
    Cursor localCursor;
    if (j < arrayOfString.length)
    {
      localObject = arrayOfString[j];
      switch (((String)localObject).hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          dri.f(a, "Unknown column: {0}", new Object[] { arrayOfString[j] });
          arrayOfObject[j] = null;
        }
        break;
      }
      for (;;)
      {
        j += 1;
        break;
        if (!((String)localObject).equals("_id")) {
          break label236;
        }
        i = 0;
        break label238;
        if (!((String)localObject).equals("persistentId")) {
          break label236;
        }
        i = 1;
        break label238;
        if (!((String)localObject).equals("folderUri")) {
          break label236;
        }
        i = 2;
        break label238;
        if (!((String)localObject).equals("name")) {
          break label236;
        }
        i = 3;
        break label238;
        if (!((String)localObject).equals("hasChildren")) {
          break label236;
        }
        i = 4;
        break label238;
        if (!((String)localObject).equals("capabilities")) {
          break label236;
        }
        i = 5;
        break label238;
        if (!((String)localObject).equals("syncWindow")) {
          break label236;
        }
        i = 6;
        break label238;
        if (!((String)localObject).equals("conversationListUri")) {
          break label236;
        }
        i = 7;
        break label238;
        if (!((String)localObject).equals("childFoldersListUri")) {
          break label236;
        }
        i = 8;
        break label238;
        if (!((String)localObject).equals("unseenCount")) {
          break label236;
        }
        i = 9;
        break label238;
        if (!((String)localObject).equals("unreadCount")) {
          break label236;
        }
        i = 10;
        break label238;
        if (!((String)localObject).equals("totalCount")) {
          break label236;
        }
        i = 11;
        break label238;
        if (!((String)localObject).equals("refreshUri")) {
          break label236;
        }
        i = 12;
        break label238;
        if (!((String)localObject).equals("syncStatus")) {
          break label236;
        }
        i = 13;
        break label238;
        if (!((String)localObject).equals("lastSyncResult")) {
          break label236;
        }
        i = 14;
        break label238;
        if (!((String)localObject).equals("type")) {
          break label236;
        }
        i = 15;
        break label238;
        if (!((String)localObject).equals("iconResId")) {
          break label236;
        }
        i = 16;
        break label238;
        if (!((String)localObject).equals("notificationIconResId")) {
          break label236;
        }
        i = 17;
        break label238;
        if (!((String)localObject).equals("bgColor")) {
          break label236;
        }
        i = 18;
        break label238;
        if (!((String)localObject).equals("fgColor")) {
          break label236;
        }
        i = 19;
        break label238;
        if (!((String)localObject).equals("loadMoreUri")) {
          break label236;
        }
        i = 20;
        break label238;
        if (!((String)localObject).equals("hierarchicalDesc")) {
          break label236;
        }
        i = 21;
        break label238;
        if (!((String)localObject).equals("lastMessageTimestamp")) {
          break label236;
        }
        i = 22;
        break label238;
        if (!((String)localObject).equals("parentUri")) {
          break label236;
        }
        i = 23;
        break label238;
        arrayOfObject[j] = Integer.valueOf("search".hashCode());
        continue;
        arrayOfObject[j] = null;
        continue;
        arrayOfObject[j] = a(CombinedAccountsProvider.d, "folderUri");
        continue;
        arrayOfObject[j] = "search";
        continue;
        arrayOfObject[j] = Integer.valueOf(0);
      }
      localObject = b.iterator();
      i = -1;
      if (((Iterator)localObject).hasNext())
      {
        localCursor = (Cursor)((Iterator)localObject).next();
        if ((localCursor == null) || (!localCursor.moveToFirst())) {
          break label1152;
        }
        i &= localCursor.getInt(localCursor.getColumnIndex("capabilities"));
      }
    }
    label982:
    label1149:
    label1152:
    for (;;)
    {
      break label830;
      int k = i;
      if (i == -1) {
        k = 0;
      }
      arrayOfObject[j] = Integer.valueOf(0x10000 | k);
      break;
      arrayOfObject[j] = Integer.valueOf(0);
      break;
      arrayOfObject[j] = a(CombinedAccountsProvider.e, "conversationListUri");
      break;
      arrayOfObject[j] = null;
      break;
      arrayOfObject[j] = Integer.valueOf(0);
      break;
      arrayOfObject[j] = Integer.valueOf(0);
      break;
      localObject = b.iterator();
      i = 0;
      if (((Iterator)localObject).hasNext())
      {
        localCursor = (Cursor)((Iterator)localObject).next();
        if ((localCursor == null) || (!localCursor.moveToFirst())) {
          break label1149;
        }
        i += localCursor.getInt(localCursor.getColumnIndex("totalCount"));
      }
      for (;;)
      {
        break label982;
        arrayOfObject[j] = Integer.valueOf(i);
        break;
        arrayOfObject[j] = null;
        break;
        arrayOfObject[j] = Integer.valueOf(0);
        break;
        arrayOfObject[j] = Integer.valueOf(4097);
        break;
        arrayOfObject[j] = Integer.valueOf(0);
        break;
        arrayOfObject[j] = Integer.valueOf(0);
        break;
        arrayOfObject[j] = null;
        break;
        arrayOfObject[j] = "search";
        break;
        arrayOfObject[j] = Long.valueOf(0L);
        break;
        arrayOfObject[j] = null;
        break;
        addRow(arrayOfObject);
        return;
      }
    }
  }
  
  public final void close()
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Cursor localCursor = (Cursor)localIterator.next();
      if ((localCursor != null) && (!localCursor.isClosed())) {
        localCursor.close();
      }
    }
    super.close();
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Cursor localCursor = (Cursor)localIterator.next();
      if (localCursor != null) {
        localCursor.registerContentObserver(paramContentObserver);
      }
    }
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Cursor localCursor = (Cursor)localIterator.next();
      if (localCursor != null) {
        localCursor.registerDataSetObserver(paramDataSetObserver);
      }
    }
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Cursor localCursor = (Cursor)localIterator.next();
      if (localCursor != null) {
        localCursor.unregisterContentObserver(paramContentObserver);
      }
    }
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      Cursor localCursor = (Cursor)localIterator.next();
      if (localCursor != null) {
        localCursor.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
}

/* Location:
 * Qualified Name:     dpn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */