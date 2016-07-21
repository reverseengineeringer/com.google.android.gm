import java.util.Arrays;

class hap
  extends gzx
{
  private final String o;
  private final char[] p;
  private final char[] q;
  
  hap(String paramString, char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    o = paramString;
    p = paramArrayOfChar1;
    q = paramArrayOfChar2;
    int i;
    if (paramArrayOfChar1.length == paramArrayOfChar2.length)
    {
      bool = true;
      hbe.a(bool);
      i = 0;
      label37:
      if (i >= paramArrayOfChar1.length) {
        return;
      }
      if (paramArrayOfChar1[i] > paramArrayOfChar2[i]) {
        break label108;
      }
      bool = true;
      label58:
      hbe.a(bool);
      if (i + 1 < paramArrayOfChar1.length) {
        if (paramArrayOfChar2[i] >= paramArrayOfChar1[(i + 1)]) {
          break label114;
        }
      }
    }
    label108:
    label114:
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool);
      i += 1;
      break label37;
      bool = false;
      break;
      bool = false;
      break label58;
    }
  }
  
  public final boolean b(char paramChar)
  {
    int i = Arrays.binarySearch(p, paramChar);
    if (i >= 0) {}
    do
    {
      return true;
      i = (i ^ 0xFFFFFFFF) - 1;
    } while ((i >= 0) && (paramChar <= q[i]));
    return false;
  }
  
  public String toString()
  {
    return o;
  }
}

/* Location:
 * Qualified Name:     hap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */