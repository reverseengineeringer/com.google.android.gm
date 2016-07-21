import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class hjl
{
  private static final char[][] b = (char[][])Array.newInstance(Character.TYPE, new int[] { 0, 0 });
  final char[][] a;
  
  hjl(char[][] paramArrayOfChar)
  {
    a = paramArrayOfChar;
  }
  
  static char[][] a(Map<Character, String> paramMap)
  {
    hbe.a(paramMap);
    if (paramMap.isEmpty()) {
      return b;
    }
    char[][] arrayOfChar = new char[((Character)Collections.max(paramMap.keySet())).charValue() + '\001'][];
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      char c = ((Character)localIterator.next()).charValue();
      arrayOfChar[c] = ((String)paramMap.get(Character.valueOf(c))).toCharArray();
    }
    return arrayOfChar;
  }
}

/* Location:
 * Qualified Name:     hjl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */