public final class oh<T>
  implements og<T>
{
  private final Object[] a;
  private int b;
  
  public oh(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    a = new Object[paramInt];
  }
  
  public final T a()
  {
    if (b > 0)
    {
      int i = b - 1;
      Object localObject = a[i];
      a[i] = null;
      b -= 1;
      return (T)localObject;
    }
    return null;
  }
  
  public final boolean a(T paramT)
  {
    boolean bool = false;
    int i = 0;
    if (i < b) {
      if (a[i] != paramT) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label50;
      }
      throw new IllegalStateException("Already in the pool!");
      i += 1;
      break;
    }
    label50:
    if (b < a.length)
    {
      a[b] = paramT;
      b += 1;
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     oh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */