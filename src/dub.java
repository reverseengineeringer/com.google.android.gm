import android.database.AbstractCursor;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class dub
  extends AbstractCursor
  implements bwv
{
  private static final String b = cvl.a;
  final Cursor[] a;
  private final int[] c;
  private Cursor d;
  private DataSetObserver e = new duc(this);
  
  public dub(List<Cursor> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Cursor localCursor = (Cursor)localIterator.next();
      if (localCursor != null) {
        localArrayList.add(localCursor);
      }
    }
    a = ((Cursor[])localArrayList.toArray(new Cursor[localArrayList.size()]));
    int i = paramList.size() - a.length;
    if (i > 0) {
      dri.d(b, "MergedConversationsCursor dropped %d input cursors", new Object[] { Integer.valueOf(i) });
    }
    c = new int[a.length];
    c();
    paramList = a;
    int j = paramList.length;
    i = 0;
    while (i < j)
    {
      paramList[i].registerDataSetObserver(e);
      i += 1;
    }
  }
  
  private final void a(Bundle paramBundle1, Bundle paramBundle2, String paramString)
  {
    int j = 1;
    Cursor[] arrayOfCursor = a;
    int k = arrayOfCursor.length;
    int i = 0;
    while (i < k)
    {
      if (!"ok".equals(arrayOfCursor[i].respond(paramBundle2).getString(paramString))) {
        j = 0;
      }
      i += 1;
    }
    if (j != 0) {}
    for (paramBundle2 = "ok";; paramBundle2 = "failed")
    {
      paramBundle1.putString(paramString, paramBundle2);
      return;
    }
  }
  
  private final boolean d()
  {
    Cursor localCursor1 = null;
    int j = -1;
    int[] arrayOfInt = c;
    int i = 0;
    for (;;)
    {
      Cursor localCursor2;
      try
      {
        if (i < a.length)
        {
          localCursor2 = a[i];
          k = j;
          localObject3 = localCursor1;
          if (!localCursor2.moveToPosition(c[i] + 1)) {
            break label224;
          }
          if (localCursor1 == null) {
            break label218;
          }
          k = j;
          localObject3 = localCursor1;
          if (localCursor2.getLong(6) <= localCursor1.getLong(6)) {
            break label224;
          }
          break label218;
        }
        if (j >= 0)
        {
          localObject3 = c;
          localObject3[j] += 1;
          mPos += 1;
        }
        d = localCursor1;
        if ((localCursor1 != null) && (dri.a(b, 2))) {
          dri.a(b, "MergedConversationsCursor: Next cursor -> %s \"%s\" received at %tc", new Object[] { localCursor1.getString(1), localCursor1.getString(3), new Date(localCursor1.getLong(6)) });
        }
        if (localCursor1 != null) {
          return true;
        }
      }
      finally {}
      return false;
      label218:
      int k = i;
      Object localObject3 = localCursor2;
      label224:
      i += 1;
      j = k;
      Object localObject2 = localObject3;
    }
  }
  
  private final int e()
  {
    Cursor[] arrayOfCursor = a;
    int m = arrayOfCursor.length;
    int j = 0;
    int i = 8;
    int k = i;
    if (j < m)
    {
      Bundle localBundle2 = arrayOfCursor[j].getExtras();
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null) {
        localBundle1 = Bundle.EMPTY;
      }
      switch (localBundle1.getInt("cursor_status", 1))
      {
      case 3: 
      default: 
      case 1: 
      case 2: 
        for (;;)
        {
          j += 1;
          break;
          i = 1;
          continue;
          if (i == 8) {
            i = 2;
          }
        }
      }
      k = 4;
    }
    return k;
  }
  
  private final Cursor f()
  {
    Object localObject = d;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('[');
      Cursor[] arrayOfCursor = a;
      int k = arrayOfCursor.length;
      int i = 0;
      int j = 0;
      if (i < k)
      {
        Cursor localCursor = arrayOfCursor[i];
        if (j != 0) {
          ((StringBuilder)localObject).append(", ");
        }
        for (;;)
        {
          ((StringBuilder)localObject).append(localCursor.getPosition()).append('/').append(localCursor.getCount());
          i += 1;
          break;
          j = 1;
        }
      }
      ((StringBuilder)localObject).append(']');
      dri.e(b, "The underlying cursors are positioned %s %s", new Object[] { ((StringBuilder)localObject).toString(), Arrays.toString(c) });
      i = getPosition();
      j = getCount();
      throw new dud(62 + "There is no current cursor at position " + i + "/" + j);
    }
    return (Cursor)localObject;
  }
  
  public final void a()
  {
    Cursor[] arrayOfCursor = a;
    int j = arrayOfCursor.length;
    int i = 0;
    while (i < j)
    {
      bww.a(arrayOfCursor[i]);
      i += 1;
    }
  }
  
  public final void b()
  {
    dri.f(b, "All inbox cannot be emptied", new Object[0]);
  }
  
  final void c()
  {
    Arrays.fill(c, -1);
  }
  
  public final void close()
  {
    Cursor[] arrayOfCursor = a;
    int j = arrayOfCursor.length;
    int i = 0;
    while (i < j)
    {
      Cursor localCursor = arrayOfCursor[i];
      if (localCursor != null) {
        localCursor.close();
      }
      i += 1;
    }
    super.close();
  }
  
  public final void deactivate()
  {
    super.deactivate();
  }
  
  public final byte[] getBlob(int paramInt)
  {
    return f().getBlob(paramInt);
  }
  
  public final String[] getColumnNames()
  {
    if (d != null) {
      return d.getColumnNames();
    }
    return chh.k;
  }
  
  public final int getCount()
  {
    int j = 0;
    Cursor[] arrayOfCursor = a;
    int m = arrayOfCursor.length;
    int i = 0;
    while (i < m)
    {
      Cursor localCursor = arrayOfCursor[i];
      int k = j;
      if (localCursor != null) {
        k = j + localCursor.getCount();
      }
      i += 1;
      j = k;
    }
    return Math.min(j, 1500);
  }
  
  public final double getDouble(int paramInt)
  {
    return f().getDouble(paramInt);
  }
  
  public final Bundle getExtras()
  {
    Bundle localBundle = super.getExtras();
    if (localBundle == null) {}
    for (localBundle = new Bundle(1);; localBundle = new Bundle(localBundle))
    {
      localBundle.putInt("cursor_status", e());
      return localBundle;
    }
  }
  
  public final float getFloat(int paramInt)
  {
    return f().getFloat(paramInt);
  }
  
  public final int getInt(int paramInt)
  {
    return f().getInt(paramInt);
  }
  
  public final long getLong(int paramInt)
  {
    return f().getLong(paramInt);
  }
  
  public final short getShort(int paramInt)
  {
    return f().getShort(paramInt);
  }
  
  public final String getString(int paramInt)
  {
    return f().getString(paramInt);
  }
  
  public final int getType(int paramInt)
  {
    return f().getType(paramInt);
  }
  
  public final boolean isNull(int paramInt)
  {
    return f().isNull(paramInt);
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    paramInt1 = i;
    if (i < 0) {}
    for (;;)
    {
      synchronized (c)
      {
        Cursor[] arrayOfCursor = a;
        i = arrayOfCursor.length;
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          arrayOfCursor[paramInt1].moveToPosition(-1);
          paramInt1 += 1;
          continue;
        }
        c();
        mPos = -1;
        paramInt1 = paramInt2 + 1;
        paramInt2 = 0;
        if (paramInt2 >= paramInt1) {
          break;
        }
        if (!d()) {
          return false;
        }
      }
      paramInt2 += 1;
    }
    return true;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    Cursor[] arrayOfCursor = a;
    int j = arrayOfCursor.length;
    int i = 0;
    while (i < j)
    {
      Cursor localCursor = arrayOfCursor[i];
      if (localCursor != null) {
        localCursor.registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    super.registerContentObserver(paramContentObserver);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    Cursor[] arrayOfCursor = a;
    int j = arrayOfCursor.length;
    int i = 0;
    while (i < j)
    {
      Cursor localCursor = arrayOfCursor[i];
      if (localCursor != null) {
        localCursor.registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    super.registerDataSetObserver(paramDataSetObserver);
  }
  
  public final Bundle respond(Bundle paramBundle)
  {
    Bundle localBundle1 = new Bundle();
    if (paramBundle.containsKey("setVisibility"))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("setVisibility", paramBundle.getBoolean("setVisibility"));
      if (paramBundle.containsKey("enteredFolder")) {
        ((Bundle)localObject).putBoolean("enteredFolder", paramBundle.getBoolean("enteredFolder"));
      }
      a(localBundle1, (Bundle)localObject, "setVisibility");
    }
    Object localObject = d;
    if (localObject == null)
    {
      dri.e(b, "MergedConversationsCursor could not respond to %s", new Object[] { paramBundle });
      paramBundle = Bundle.EMPTY;
    }
    do
    {
      return paramBundle;
      Bundle localBundle2 = new Bundle();
      if (paramBundle.containsKey("uiPositionChange")) {
        localBundle2.putInt("uiPositionChange", ((Cursor)localObject).getPosition());
      }
      if (paramBundle.containsKey("conversationInfo")) {
        localBundle2.putBoolean("conversationInfo", true);
      }
      if (paramBundle.containsKey("rawFolders")) {
        localBundle2.putBoolean("rawFolders", true);
      }
      localObject = ((Cursor)localObject).respond(localBundle2);
      if (((Bundle)localObject).containsKey("conversationInfo")) {
        localBundle1.putParcelable("conversationInfo", ((Bundle)localObject).getParcelable("conversationInfo"));
      }
      paramBundle = localBundle1;
    } while (!((Bundle)localObject).containsKey("rawFolders"));
    localBundle1.putParcelable("rawFolders", ((Bundle)localObject).getParcelable("rawFolders"));
    return localBundle1;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    Cursor[] arrayOfCursor = a;
    int j = arrayOfCursor.length;
    int i = 0;
    while (i < j)
    {
      Cursor localCursor = arrayOfCursor[i];
      if (localCursor != null) {
        localCursor.unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    super.unregisterContentObserver(paramContentObserver);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    Cursor[] arrayOfCursor = a;
    int j = arrayOfCursor.length;
    int i = 0;
    while (i < j)
    {
      Cursor localCursor = arrayOfCursor[i];
      if (localCursor != null) {
        localCursor.unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    super.unregisterDataSetObserver(paramDataSetObserver);
  }
}

/* Location:
 * Qualified Name:     dub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */