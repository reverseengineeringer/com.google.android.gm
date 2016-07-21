import android.database.Cursor;
import android.database.MatrixCursor;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public final class brn
  extends brl
{
  protected final Cursor a(List<brb> paramList, String[] paramArrayOfString, int paramInt, String paramString)
  {
    MatrixCursor localMatrixCursor = new MatrixCursor(paramArrayOfString);
    if (TextUtils.isEmpty(paramString)) {
      return localMatrixCursor;
    }
    paramList = paramList.iterator();
    long l = 0L;
    if (paramList.hasNext())
    {
      Object localObject = (brb)paramList.next();
      bre localbre = bre.a((brb)localObject, paramArrayOfString);
      localObject = h.iterator();
      while (((Iterator)localObject).hasNext())
      {
        brc localbrc = (brc)((Iterator)localObject).next();
        if (paramString.equals(a))
        {
          localbre.a(l);
          localbre.b(l);
          localbre.b(a);
          localbre.a(b);
          localMatrixCursor.addRow(a);
          l = 1L + l;
        }
      }
    }
    for (;;)
    {
      if (localMatrixCursor.getCount() >= paramInt) {
        return localMatrixCursor;
      }
      break;
    }
  }
}

/* Location:
 * Qualified Name:     brn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */