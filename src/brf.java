import android.database.Cursor;
import android.database.MatrixCursor;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public final class brf
  extends brl
{
  protected final Cursor a(List<brb> paramList, String[] paramArrayOfString, int paramInt, String paramString)
  {
    paramString = new MatrixCursor(paramArrayOfString);
    paramList = paramList.iterator();
    long l = 0L;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      brb localbrb = (brb)paramList.next();
      bre localbre = bre.a(localbrb, paramArrayOfString);
      if (TextUtils.isEmpty(g)) {
        break label119;
      }
      localbre.a(g);
      localbre.a();
      localbre.a(l);
      localbre.b(l);
      paramString.addRow(a);
      l = 1L + l;
    } while (paramString.getCount() < paramInt);
    label119:
    for (;;)
    {
      return paramString;
    }
  }
}

/* Location:
 * Qualified Name:     brf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */