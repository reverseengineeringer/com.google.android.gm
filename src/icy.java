import java.util.Arrays;

final class icy
{
  int a;
  long b;
  byte[] c;
  int d;
  int e;
  boolean f;
  int g;
  int h;
  
  public final String toString()
  {
    return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[] { getClass().getSimpleName(), Arrays.toString(c), Integer.valueOf(g), Boolean.valueOf(f), Integer.valueOf(a), Long.valueOf(b), Integer.valueOf(h), Integer.valueOf(d), Integer.valueOf(e) });
  }
}

/* Location:
 * Qualified Name:     icy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */