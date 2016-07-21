import android.database.Cursor;
import android.database.MatrixCursor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class brm
  extends brl
{
  protected final Cursor a(List<brb> paramList, String[] paramArrayOfString, int paramInt, String paramString)
  {
    paramString = new MatrixCursor(paramArrayOfString);
    paramList = paramList.iterator();
    long l3 = 0L;
    long l4 = 0L;
    if (paramList.hasNext())
    {
      Object localObject = (brb)paramList.next();
      HashSet localHashSet = new HashSet();
      bre localbre = bre.a((brb)localObject, paramArrayOfString);
      int i = 0;
      localObject = h.iterator();
      long l2 = l3;
      long l1 = l4;
      for (;;)
      {
        l4 = l1;
        l3 = l2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        brc localbrc = (brc)((Iterator)localObject).next();
        if (localHashSet.add(a))
        {
          int j = i;
          l3 = l1;
          if (i == 0)
          {
            localbre.b(l1);
            j = 1;
            l3 = 1L + l1;
          }
          localbre.a(l2);
          localbre.b(a);
          localbre.a(b);
          paramString.addRow(a);
          if (paramString.getCount() >= paramInt) {
            return paramString;
          }
          l2 = 1L + l2;
          i = j;
          l1 = l3;
        }
      }
    }
    return paramString;
  }
}

/* Location:
 * Qualified Name:     brm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */