import java.io.PrintStream;

public final class ikk
{
  ikl[] a = new ikl[17];
  boolean b = imn.a("verbosecompression");
  
  public final int a(imj paramimj)
  {
    int i = paramimj.hashCode();
    Object localObject = a[((i & 0x7FFFFFFF) % 17)];
    i = -1;
    while (localObject != null)
    {
      if (a.equals(paramimj)) {
        i = b;
      }
      localObject = c;
    }
    if (b)
    {
      localObject = System.err;
      paramimj = String.valueOf(paramimj);
      ((PrintStream)localObject).println(String.valueOf(paramimj).length() + 31 + "Looking for " + paramimj + ", found " + i);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     ikk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */