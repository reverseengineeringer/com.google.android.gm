import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;

public final class bmq
  extends bmn
{
  public oi<String, Integer> g = new oi(bmy.a.length);
  public final float h;
  public boolean i;
  
  public bmq(Context paramContext, fq paramfq, Cursor paramCursor, float paramFloat, boolean paramBoolean)
  {
    super(paramContext, paramfq, null);
    h = paramFloat;
    i = paramBoolean;
  }
  
  public final Cursor a(Cursor paramCursor)
  {
    int k = 0;
    g.clear();
    if (paramCursor != null)
    {
      String[] arrayOfString = bmy.a;
      int m = arrayOfString.length;
      int j = 0;
      String str;
      while (j < m)
      {
        str = arrayOfString[j];
        g.put(str, Integer.valueOf(paramCursor.getColumnIndexOrThrow(str)));
        j += 1;
      }
      arrayOfString = bmy.b;
      m = arrayOfString.length;
      j = k;
      while (j < m)
      {
        str = arrayOfString[j];
        k = paramCursor.getColumnIndex(str);
        if (k != -1) {
          g.put(str, Integer.valueOf(k));
        }
        j += 1;
      }
    }
    return super.a(paramCursor);
  }
  
  public final Fragment a(Cursor paramCursor, int paramInt)
  {
    boolean bool3 = false;
    Object localObject = a(paramCursor, "contentUri");
    String str1 = a(paramCursor, "thumbnailUri");
    String str2 = a(paramCursor, "_display_name");
    paramCursor = a(paramCursor, "loadingIndicator");
    if (paramCursor == null) {}
    for (boolean bool1 = false;; bool1 = Boolean.valueOf(paramCursor).booleanValue())
    {
      boolean bool2 = bool3;
      if (localObject == null)
      {
        bool2 = bool3;
        if (bool1) {
          bool2 = true;
        }
      }
      paramCursor = new bll(a, bmr.class);
      d = ((String)localObject);
      f = str1;
      g = str2;
      i = i;
      h = Float.valueOf(h);
      paramCursor = paramCursor.a();
      localObject = new bmr();
      bmr.a(paramCursor, paramInt, bool2, (bmr)localObject);
      return (Fragment)localObject;
    }
  }
  
  public final String a(Cursor paramCursor, String paramString)
  {
    if (g.containsKey(paramString)) {
      return paramCursor.getString(((Integer)g.get(paramString)).intValue());
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bmq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */