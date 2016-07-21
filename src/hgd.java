import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public final class hgd
{
  public static int a(int paramInt)
  {
    hcw.a(paramInt, "arraySize");
    return hks.a(5L + paramInt + paramInt / 10);
  }
  
  public static <E> ArrayList<E> a()
  {
    return new ArrayList();
  }
  
  public static <E> ArrayList<E> a(Iterable<? extends E> paramIterable)
  {
    hbe.a(paramIterable);
    if ((paramIterable instanceof Collection)) {
      return new ArrayList(hcx.a(paramIterable));
    }
    return a(paramIterable.iterator());
  }
  
  public static <E> ArrayList<E> a(Iterator<? extends E> paramIterator)
  {
    ArrayList localArrayList = new ArrayList();
    hfu.a(localArrayList, paramIterator);
    return localArrayList;
  }
  
  public static <E> ArrayList<E> a(E... paramVarArgs)
  {
    hbe.a(paramVarArgs);
    ArrayList localArrayList = new ArrayList(a(paramVarArgs.length));
    Collections.addAll(localArrayList, paramVarArgs);
    return localArrayList;
  }
  
  public static <F, T> List<T> a(List<F> paramList, hav<? super F, ? extends T> paramhav)
  {
    if ((paramList instanceof RandomAccess)) {
      return new hge(paramList, paramhav);
    }
    return new hgg(paramList, paramhav);
  }
  
  public static <E> ArrayList<E> b(int paramInt)
  {
    hcw.a(paramInt, "initialArraySize");
    return new ArrayList(paramInt);
  }
  
  public static <E> LinkedList<E> b()
  {
    return new LinkedList();
  }
}

/* Location:
 * Qualified Name:     hgd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */