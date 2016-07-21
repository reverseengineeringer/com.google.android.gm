import android.database.Cursor;
import android.graphics.Color;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class dyx
{
  public static String a = "background_color";
  public static String b = "color_index";
  public static String c = "text_color";
  public static int d = -1;
  public static ConcurrentHashMap<String, ConcurrentHashMap<String, String[]>> e = new ConcurrentHashMap();
  public static final int[] f = { -2236963, -8947849 };
  private static final String[] g = { "#dddddd", "#777777" };
  private static final String[][] h;
  private static final int i = h.length;
  
  static
  {
    String[] arrayOfString1 = g;
    String[] arrayOfString2 = { "#e0ecff", "#206cff" };
    String[] arrayOfString3 = { "#dfe2ff", "#0000cc" };
    String[] arrayOfString4 = { "#f3e7b3", "#ab8b00" };
    String[] arrayOfString5 = { "#f1f5ec", "#006633" };
    String[] arrayOfString6 = { "#5a6986", "#dee5f2" };
    h = new String[][] { arrayOfString1, { "#dee5f2", "#5a6986" }, arrayOfString2, arrayOfString3, { "#e0d5f9", "#5229a3" }, { "#fde9f4", "#854f61" }, { "#ffe3e3", "#cc0000" }, { "#fff0e1", "#ec7000" }, { "#fadcb3", "#b36d00" }, arrayOfString4, { "#ffffd4", "#636330" }, { "#f9ffef", "#64992c" }, arrayOfString5, arrayOfString6, { "#206cff", "#e0ecff" }, { "#0000cc", "#dfe2ff" }, { "#5229a3", "#e0d5f9" }, { "#854f61", "#fde9f4" }, { "#cc0000", "#ffe3e3" }, { "#ec7000", "#fff0e1" }, { "#b36d00", "#fadcb3" }, { "#ab8b00", "#f3e7b3" }, { "#636330", "#ffffd4" }, { "#64992c", "#f9ffef" }, { "#006633", "#f1f5ec" } };
  }
  
  public static int a()
  {
    return Color.parseColor(h[0][0]);
  }
  
  public static void a(String paramString, Cursor paramCursor)
  {
    if (paramCursor.moveToFirst())
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      int j = paramCursor.getColumnIndexOrThrow(b);
      int k = paramCursor.getColumnIndexOrThrow(a);
      int m = paramCursor.getColumnIndexOrThrow(c);
      do
      {
        localConcurrentHashMap.put(paramCursor.getString(j), new String[] { paramCursor.getString(k), paramCursor.getString(m) });
      } while (paramCursor.moveToNext());
      e.put(paramString, localConcurrentHashMap);
    }
    paramCursor.close();
  }
  
  public static int[] a(String paramString1, String paramString2)
  {
    try
    {
      int j = Integer.parseInt(paramString1);
      if (j == d) {
        paramString1 = g;
      }
      for (;;)
      {
        return new int[] { Color.parseColor(paramString1[0]), Color.parseColor(paramString1[1]) };
        if (j < 0)
        {
          paramString1 = (Map)e.get(paramString2);
          if (paramString1 != null) {}
          for (paramString2 = (String[])paramString1.get(11 + j);; paramString2 = g)
          {
            paramString1 = paramString2;
            if (paramString2 != null) {
              break;
            }
            paramString1 = g;
            break;
          }
        }
        if (j >= i) {
          paramString1 = g;
        } else {
          paramString1 = h[j];
        }
      }
      return null;
    }
    catch (NumberFormatException paramString1) {}
  }
}

/* Location:
 * Qualified Name:     dyx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */