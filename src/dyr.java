import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class dyr
{
  public static String a = "name";
  public static String b = "address";
  public static String c = "reply_to";
  public static String d = "is_default";
  public static String e = "bx_rf";
  public static int f = 2;
  public static int g = 0;
  public static int h = 1;
  public static ConcurrentHashMap<Uri, ArrayList<cha>> i = new ConcurrentHashMap();
  public static ConcurrentHashMap<Uri, Boolean> j = new ConcurrentHashMap();
  
  public static List<cha> a(Uri paramUri)
  {
    if (i != null)
    {
      paramUri = (List)i.get(paramUri);
      if (paramUri != null) {
        try
        {
          hef localhef = hef.a(paramUri);
          return localhef;
        }
        finally {}
      }
    }
    return null;
  }
  
  public static void a(Uri paramUri, Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        int k = paramCursor.getColumnIndexOrThrow(b);
        int m = paramCursor.getColumnIndexOrThrow(a);
        int n = paramCursor.getColumnIndexOrThrow(c);
        int i1 = paramCursor.getColumnIndexOrThrow(d);
        do
        {
          localArrayList.add(new cha(null, paramCursor.getString(k), paramCursor.getString(m), paramCursor.getString(n), Boolean.parseBoolean(paramCursor.getString(i1)), true));
        } while (paramCursor.moveToNext());
        i.put(paramUri, localArrayList);
      }
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public static void a(Uri paramUri, String paramString)
  {
    boolean bool = true;
    if ((paramString.equals("true")) || (paramString.equals("1"))) {
      bool = false;
    }
    j.put(paramUri, Boolean.valueOf(bool));
  }
  
  public static void b(Uri paramUri, Cursor paramCursor)
  {
    try
    {
      if (paramCursor.moveToFirst()) {
        a(paramUri, paramCursor.getString(paramCursor.getColumnIndexOrThrow("value")));
      }
      return;
    }
    finally
    {
      paramCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     dyr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */