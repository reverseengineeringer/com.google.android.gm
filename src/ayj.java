import android.database.Cursor;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public final class ayj
{
  private static final String b = cvl.a;
  final ArrayList<ayl> a = new ArrayList();
  
  public ayj(Cursor paramCursor)
  {
    Object localObject1 = paramCursor.getString(paramCursor.getColumnIndex("threadFromList"));
    Object localObject4 = paramCursor.getString(paramCursor.getColumnIndex("threadReadFlag"));
    Object localObject2 = paramCursor.getString(paramCursor.getColumnIndex("threadTimeStamp"));
    String str = paramCursor.getString(paramCursor.getColumnIndex("threadSnippets"));
    Object localObject3 = paramCursor.getString(paramCursor.getColumnIndex("threadSnippetsLength"));
    long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    if (localObject4 == null)
    {
      cvm.f(b, "id: %d, there's threadReadColumn but it's NULL", new Object[] { Long.valueOf(l) });
      return;
    }
    localObject4 = new StringTokenizer((String)localObject4, ",");
    int k = ((StringTokenizer)localObject4).countTokens();
    Object localObject5;
    int j;
    int i;
    if (localObject1 != null)
    {
      localObject5 = ((String)localObject1).split(",", -1);
      localObject1 = new ArrayList(localObject5.length);
      j = localObject5.length;
      i = 0;
      if (i < j)
      {
        CharSequence localCharSequence = localObject5[i];
        if (TextUtils.isEmpty(localCharSequence)) {
          ((ArrayList)localObject1).add(new Rfc822Token(null, null, null));
        }
        for (;;)
        {
          i += 1;
          break;
          Rfc822Tokenizer.tokenize(localCharSequence, (Collection)localObject1);
        }
      }
      if (k != ((ArrayList)localObject1).size()) {
        cvm.f(b, "id: %d, listSize is %d but fromList has %d tokens", new Object[] { Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(((ArrayList)localObject1).size()) });
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        localObject2 = new StringTokenizer((String)localObject2, ",");
        i = ((StringTokenizer)localObject2).countTokens();
        if (k != i) {
          cvm.f(b, "id: %d, listSize is %d but timestampsParser has %d tokens", new Object[] { Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        if ((str != null) && (localObject3 != null))
        {
          localObject3 = new StringTokenizer((String)localObject3, ",");
          i = ((StringTokenizer)localObject3).countTokens();
          if (k != i) {
            cvm.f(b, "id: %d, listSize is %d but lengthTokenizer has %d tokens", new Object[] { Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(i) });
          }
        }
        for (;;)
        {
          i = 0;
          paramCursor = paramCursor.getString(paramCursor.getColumnIndex("snippet"));
          j = 0;
          if (j < k) {
            for (;;)
            {
              try
              {
                localObject5 = new ayl();
                if ((localObject1 != null) && (j < ((ArrayList)localObject1).size()))
                {
                  a = ((Rfc822Token)((ArrayList)localObject1).get(j)).getName();
                  b = ((Rfc822Token)((ArrayList)localObject1).get(j)).getAddress();
                  if (TextUtils.isEmpty(a)) {
                    a = b;
                  }
                }
                if (!((StringTokenizer)localObject4).hasMoreTokens()) {
                  continue;
                }
                if (Integer.parseInt(((StringTokenizer)localObject4).nextToken()) == 0) {
                  continue;
                }
                bool = true;
                d = bool;
                if ((localObject2 == null) || (!((StringTokenizer)localObject2).hasMoreTokens())) {
                  continue;
                }
                l = Long.parseLong(((StringTokenizer)localObject2).nextToken());
                e = l;
                if ((localObject3 == null) || (!((StringTokenizer)localObject3).hasMoreTokens()) || (i >= str.length())) {
                  continue;
                }
                int m = Integer.parseInt(((StringTokenizer)localObject3).nextToken());
                if (i + m > str.length()) {
                  continue;
                }
                c = str.substring(i, i + m);
                i = m + 1 + i;
              }
              catch (NumberFormatException paramCursor)
              {
                boolean bool;
                cvm.d(b, "Error parsing thread info", new Object[] { paramCursor });
                paramCursor = new ayk(this);
                Collections.sort(a, paramCursor);
                return;
              }
              catch (NoSuchElementException paramCursor)
              {
                continue;
                continue;
              }
              if (c == null) {
                c = paramCursor;
              }
              a.add(localObject5);
              j += 1;
              break;
              bool = false;
              continue;
              bool = false;
              continue;
              l = 0L;
            }
          }
          localObject3 = null;
        }
        localObject2 = null;
      }
      localObject1 = null;
    }
  }
}

/* Location:
 * Qualified Name:     ayj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */