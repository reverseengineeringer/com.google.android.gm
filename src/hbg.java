import java.util.Collection;

public final class hbg
{
  private static final haw a = haw.a(',');
  
  public static <T> hbf<T> a(T paramT)
  {
    if (paramT == null) {
      return hbj.c;
    }
    return new hbi(paramT);
  }
  
  public static <T> hbf<T> a(Collection<? extends T> paramCollection)
  {
    return new hbh(paramCollection);
  }
}

/* Location:
 * Qualified Name:     hbg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */