import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class chf
  extends chc
{
  static final String[] d = { "_id", "suggest_text_1", "suggest_intent_query", "suggest_icon_1" };
  static final String[] e = { "data4", "data1" };
  private ArrayList<String> f;
  private final Object g = new Object();
  
  public chf(Context paramContext)
  {
    super(paramContext);
  }
  
  public Cursor a(String paramString)
  {
    synchronized (g)
    {
      f = null;
      c = f;
      if (paramString == null) {
        break label228;
      }
      ??? = TextUtils.split(paramString, " ");
      if ((??? != null) && (???.length > 1)) {
        paramString = ???[(???.length - 1)];
      }
    }
    for (;;)
    {
      synchronized (g)
      {
        f = new ArrayList();
        int i = 0;
        int j = ???.length;
        if (i < j - 1)
        {
          f.add(???[i]);
          i += 1;
          continue;
          paramString = finally;
          throw paramString;
        }
        c = f;
        ??? = new ArrayList();
        ??? = super.a(paramString);
        if (??? != null) {
          ((ArrayList)???).add(???);
        }
        if (paramString.length() >= 2) {
          ((ArrayList)???).add(new chg(this).a(paramString));
        }
        if (((ArrayList)???).size() <= 0) {
          break;
        }
        return new MergeCursor((Cursor[])((ArrayList)???).toArray(new Cursor[((ArrayList)???).size()]));
      }
      paramString = paramString.trim();
    }
    label228:
    return null;
  }
  
  final String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (f != null) {
      synchronized (g)
      {
        Iterator localIterator = f.iterator();
        if (localIterator.hasNext()) {
          localStringBuilder.append((String)localIterator.next()).append(" ");
        }
      }
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     chf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */