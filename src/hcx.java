import java.util.Collection;

public final class hcx
{
  static final haw a = haw.a(", ").b("null");
  
  static StringBuilder a(int paramInt)
  {
    hcw.a(paramInt, "size");
    return new StringBuilder((int)Math.min(paramInt * 8L, 1073741824L));
  }
  
  static <T> Collection<T> a(Iterable<T> paramIterable)
  {
    return (Collection)paramIterable;
  }
  
  static boolean a(Collection<?> paramCollection, Object paramObject)
  {
    hbe.a(paramCollection);
    try
    {
      boolean bool = paramCollection.contains(paramObject);
      return bool;
    }
    catch (ClassCastException paramCollection)
    {
      return false;
    }
    catch (NullPointerException paramCollection) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     hcx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */