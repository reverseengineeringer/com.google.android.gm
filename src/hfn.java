import java.util.Comparator;

final class hfn
  extends heq
{
  private static final long serialVersionUID = 0L;
  private final Comparator<Object> a;
  
  hfn(hfj<?, ?> paramhfj)
  {
    super(paramhfj);
    a = paramhfj.comparator();
  }
  
  final Object readResolve()
  {
    return a(new hfm(a));
  }
}

/* Location:
 * Qualified Name:     hfn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */