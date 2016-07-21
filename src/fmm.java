import java.io.IOException;

public final class fmm<M extends fml<M>, T>
{
  public final int a;
  public final Class<T> b;
  public final int c;
  public final boolean d;
  
  protected final int a(Object paramObject)
  {
    int i = c >>> 3;
    switch (a)
    {
    default: 
      throw new IllegalArgumentException("Unknown type " + a);
    case 10: 
      paramObject = (fmq)paramObject;
      return fmj.b(i) * 2 + ((fmq)paramObject).d();
    }
    return fmj.b(i, (fmq)paramObject);
  }
  
  protected final void a(Object paramObject, fmj paramfmj)
  {
    for (;;)
    {
      try
      {
        paramfmj.c(c);
        switch (a)
        {
        case 10: 
          throw new IllegalArgumentException("Unknown type " + a);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (fmq)paramObject;
      int i = c;
      ((fmq)paramObject).a(paramfmj);
      paramfmj.c(i >>> 3, 4);
      return;
      paramfmj.a((fmq)paramObject);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     fmm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */