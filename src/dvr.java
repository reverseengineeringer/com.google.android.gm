import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class dvr
  extends CursorWrapper
{
  static final SparseArray<Integer> a;
  public final String[] b;
  private final Map<String, Integer> c;
  
  static
  {
    SparseArray localSparseArray = new SparseArray(5);
    a = localSparseArray;
    localSparseArray.put(0, Integer.valueOf(2));
    a.put(1, Integer.valueOf(1));
    a.put(4, Integer.valueOf(1));
    a.put(3, Integer.valueOf(4));
    a.put(2, Integer.valueOf(8));
  }
  
  public dvr(Cursor paramCursor, String[] paramArrayOfString)
  {
    super(paramCursor);
    b = paramArrayOfString;
    int j = b.length;
    c = new HashMap(j, 1.0F);
    int i = 0;
    while (i < j)
    {
      c.put(b[i], Integer.valueOf(i));
      i += 1;
    }
  }
  
  protected final String a(int paramInt)
  {
    return hbw.a(super.getString(paramInt));
  }
  
  protected void a() {}
  
  public int getColumnIndex(String paramString)
  {
    paramString = (Integer)c.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    int i = getColumnIndex(paramString);
    if (i == -1)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Column not found: ".concat(paramString);; paramString = new String("Column not found: ")) {
        throw new IllegalArgumentException(paramString);
      }
    }
    return i;
  }
  
  public String getColumnName(int paramInt)
  {
    return b[paramInt];
  }
  
  public String[] getColumnNames()
  {
    return b;
  }
  
  public boolean move(int paramInt)
  {
    return moveToPosition(getPosition() + paramInt);
  }
  
  public boolean moveToFirst()
  {
    return moveToPosition(0);
  }
  
  public boolean moveToLast()
  {
    return moveToPosition(getCount() - 1);
  }
  
  public boolean moveToNext()
  {
    return moveToPosition(getPosition() + 1);
  }
  
  public boolean moveToPosition(int paramInt)
  {
    if (getPosition() != paramInt) {
      a();
    }
    return super.moveToPosition(paramInt);
  }
  
  public boolean moveToPrevious()
  {
    return moveToPosition(getPosition() - 1);
  }
}

/* Location:
 * Qualified Name:     dvr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */