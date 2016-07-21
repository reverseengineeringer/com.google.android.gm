import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;

final class avl
  implements Runnable
{
  avl(avk paramavk) {}
  
  public final void run()
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("_id", Long.valueOf(a.a));
    localContentValues.put("name", a.b);
    a.getActivity().getContentResolver().update(a.d, localContentValues, "accountKey=? AND _id=?", new String[] { String.valueOf(a.c), String.valueOf(a.a) });
  }
}

/* Location:
 * Qualified Name:     avl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */