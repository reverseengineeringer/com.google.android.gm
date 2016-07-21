import android.database.Cursor;
import android.database.MatrixCursor;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public final class brj
  extends brl
{
  protected final Cursor a(List<brb> paramList, String[] paramArrayOfString, int paramInt, String paramString)
  {
    paramString = new MatrixCursor(paramArrayOfString);
    paramList = paramList.iterator();
    for (long l = 0L;; l = 1L + l) {
      if (paramList.hasNext())
      {
        brb localbrb = (brb)paramList.next();
        bre localbre = bre.a(localbrb, paramArrayOfString);
        if (!TextUtils.isEmpty(g))
        {
          localbre.a(g);
          localbre.a();
        }
        localbre.a(l);
        localbre.b(l);
        paramString.addRow(a);
        if (paramString.getCount() < paramInt) {}
      }
      else
      {
        return paramString;
      }
    }
  }
}

/* Location:
 * Qualified Name:     brj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */