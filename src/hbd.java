import java.io.Serializable;

public final class hbd<A, B>
  implements Serializable
{
  private static final long serialVersionUID = 747826592375603043L;
  public final A a;
  public final B b;
  
  public hbd(A paramA, B paramB)
  {
    a = paramA;
    b = paramB;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof hbd))
    {
      paramObject = (hbd)paramObject;
      bool1 = bool2;
      if (hbc.a(a, a))
      {
        bool1 = bool2;
        if (hbc.a(b, b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int i;
    if (a == null)
    {
      i = 0;
      if (b != null) {
        break label36;
      }
    }
    for (;;)
    {
      return i * 31 + j;
      i = a.hashCode();
      break;
      label36:
      j = b.hashCode();
    }
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(a);
    String str2 = String.valueOf(b);
    return String.valueOf(str1).length() + 4 + String.valueOf(str2).length() + "(" + str1 + ", " + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     hbd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */