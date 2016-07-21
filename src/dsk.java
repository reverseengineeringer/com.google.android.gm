import android.database.MatrixCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;

final class dsk
  extends dsy
  implements Cloneable
{
  public dsk(drp paramdrp, SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery, dsz paramdsz)
  {
    super(paramdrp, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery, paramdsz);
  }
  
  public final Object clone()
  {
    cvq localcvq = new cvq(getColumnNames(), getCount(), new Bundle(getExtras()));
    int j = super.getColumnCount();
    int k = getColumnIndexOrThrow("body");
    moveToPosition(-1);
    while (moveToNext())
    {
      Object[] arrayOfObject = new Object[j];
      int i = 0;
      if (i < j)
      {
        if (i == k) {
          arrayOfObject[i] = getBlob(k);
        }
        for (;;)
        {
          i += 1;
          break;
          switch (getType(i))
          {
          default: 
            arrayOfObject[i] = null;
            break;
          case 4: 
            arrayOfObject[i] = getBlob(i);
            break;
          case 2: 
            arrayOfObject[i] = Double.valueOf(getDouble(i));
            break;
          case 1: 
            arrayOfObject[i] = Long.valueOf(getLong(i));
            break;
          case 3: 
            arrayOfObject[i] = getString(i);
          }
        }
      }
      localcvq.addRow(arrayOfObject);
    }
    return localcvq;
  }
}

/* Location:
 * Qualified Name:     dsk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */