import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.android.mail.providers.Folder;
import java.util.Iterator;
import java.util.Set;

public final class cjx
  extends coe
{
  public cjx(Context paramContext, Cursor paramCursor, Set<String> paramSet, int paramInt)
  {
    super(paramContext, paramCursor, paramSet, paramInt);
  }
  
  public static Cursor a(Cursor paramCursor)
  {
    return a(paramCursor, null, null, true);
  }
  
  public static Cursor a(Cursor paramCursor, Set<Integer> paramSet, Set<String> paramSet1, boolean paramBoolean)
  {
    int i = chh.i.length;
    cvp localcvp = new cvp(chh.i);
    Object[] arrayOfObject = new Object[i];
    int k;
    if (paramCursor.moveToFirst())
    {
      k = paramCursor.getInt(15);
      if (paramSet == null) {
        break label493;
      }
      Iterator localIterator = paramSet.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!Folder.a(k, ((Integer)localIterator.next()).intValue()));
    }
    label493:
    for (i = 1;; i = 0)
    {
      int j = i;
      boolean bool;
      if (paramSet1 != null) {
        bool = i | paramSet1.contains(new cus(Uri.parse(paramCursor.getString(2))).a().toString()) ^ paramBoolean;
      }
      if ((!bool) && ((Folder.a(k, 2)) || (Folder.a(k, 1))))
      {
        arrayOfObject[0] = Long.valueOf(paramCursor.getLong(0));
        arrayOfObject[1] = paramCursor.getString(1);
        arrayOfObject[2] = paramCursor.getString(2);
        arrayOfObject[3] = paramCursor.getString(3);
        arrayOfObject[4] = Integer.valueOf(paramCursor.getInt(4));
        arrayOfObject[5] = Integer.valueOf(paramCursor.getInt(5));
        arrayOfObject[6] = Integer.valueOf(paramCursor.getInt(6));
        arrayOfObject[7] = paramCursor.getString(7);
        arrayOfObject[8] = paramCursor.getString(8);
        arrayOfObject[9] = Integer.valueOf(paramCursor.getInt(9));
        arrayOfObject[10] = Integer.valueOf(paramCursor.getInt(10));
        arrayOfObject[11] = Integer.valueOf(paramCursor.getInt(11));
        arrayOfObject[12] = paramCursor.getString(12);
        arrayOfObject[13] = Integer.valueOf(paramCursor.getInt(13));
        arrayOfObject[14] = Integer.valueOf(paramCursor.getInt(14));
        arrayOfObject[15] = Integer.valueOf(k);
        arrayOfObject[16] = Integer.valueOf(paramCursor.getInt(16));
        arrayOfObject[18] = paramCursor.getString(18);
        arrayOfObject[19] = paramCursor.getString(19);
        arrayOfObject[20] = paramCursor.getString(20);
        arrayOfObject[21] = paramCursor.getString(21);
        arrayOfObject[22] = Long.valueOf(paramCursor.getLong(22));
        arrayOfObject[23] = paramCursor.getString(23);
        localcvp.addRow(arrayOfObject);
      }
      if (paramCursor.moveToNext()) {
        break;
      }
      return localcvp;
    }
  }
}

/* Location:
 * Qualified Name:     cjx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */