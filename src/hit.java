import java.util.Comparator;

abstract interface hit<T>
  extends Iterable<T>
{
  public abstract Comparator<? super T> comparator();
}

/* Location:
 * Qualified Name:     hit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */