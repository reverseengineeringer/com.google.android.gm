import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

final class ijs
{
  private static final char[] e = new char[0];
  private static final ijs[] f = new ijs[0];
  final boolean a;
  final int b;
  private final char[] c;
  private final ijs[] d;
  
  private ijs()
  {
    this(localList, 0, 0, localList.size());
  }
  
  private ijs(List<Map.Entry<String, Integer>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == ((String)((Map.Entry)paramList.get(paramInt2)).getKey()).length()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      if (!a) {
        break label186;
      }
      b = ((Integer)((Map.Entry)paramList.get(paramInt2)).getValue()).intValue();
      if (paramInt2 + 1 != paramInt3) {
        break;
      }
      c = e;
      d = f;
      return;
    }
    paramInt2 += 1;
    int m = -1;
    int n = paramInt2;
    int k = 0;
    label112:
    int i1;
    if (n < paramInt3)
    {
      i1 = ((String)((Map.Entry)paramList.get(n)).getKey()).charAt(paramInt1);
      if (i1 == m) {
        break label404;
      }
      m = k + 1;
      k = i1;
    }
    for (;;)
    {
      i1 = n + 1;
      n = m;
      m = k;
      k = n;
      n = i1;
      break label112;
      label186:
      b = Integer.MAX_VALUE;
      break;
      c = new char[k];
      d = new ijs[k];
      int i = ((String)((Map.Entry)paramList.get(paramInt2)).getKey()).charAt(paramInt1);
      n = paramInt2 + 1;
      m = 0;
      k = paramInt2;
      paramInt2 = n;
      if (paramInt2 < paramInt3)
      {
        int j = ((String)((Map.Entry)paramList.get(paramInt2)).getKey()).charAt(paramInt1);
        if (j == i) {
          break label389;
        }
        c[m] = i;
        ijs[] arrayOfijs = d;
        n = m + 1;
        arrayOfijs[m] = new ijs(paramList, paramInt1 + 1, k, paramInt2);
        m = paramInt2;
        k = n;
        i = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        n = m;
        m = k;
        k = n;
        break;
        c[m] = i;
        d[m] = new ijs(paramList, paramInt1 + 1, k, paramInt3);
        return;
        label389:
        n = k;
        k = m;
        m = n;
      }
      label404:
      i1 = k;
      k = m;
      m = i1;
    }
  }
  
  public ijs(Map<String, Integer> paramMap)
  {
    this(new ArrayList(new TreeMap(paramMap).entrySet()));
  }
  
  private final void a(int paramInt, StringBuilder paramStringBuilder)
  {
    String str;
    int j;
    if (a)
    {
      str = "terminal";
      paramStringBuilder.append(str);
      j = paramInt + 1;
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= c.length) {
        return;
      }
      paramStringBuilder.append('\n');
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramStringBuilder.append('\t');
          i += 1;
          continue;
          str = "nonterminal";
          break;
        }
      }
      paramStringBuilder.append('\'').append(c[paramInt]).append("' ");
      d[paramInt].a(j, paramStringBuilder);
      paramInt += 1;
    }
  }
  
  public final ijs a(char paramChar)
  {
    int i = Arrays.binarySearch(c, paramChar);
    if (i >= 0) {
      return d[i];
    }
    return null;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    a(0, localStringBuilder);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     ijs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */