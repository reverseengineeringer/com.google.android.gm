import java.util.SortedSet;
import java.util.TreeSet;

final class dam
{
  static final dam a = new dam();
  private SortedSet<dan> b = new TreeSet();
  private StringBuilder c = new StringBuilder();
  private boolean d = false;
  
  public final String a()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      int j = 6;
      int i = 0;
      while (b.size() > 0)
      {
        dan localdan = (dan)b.first();
        b.remove(localdan);
        int k = localdan.ordinal();
        while (k >= j)
        {
          ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
          j += 6;
          i = 0;
        }
        i += (1 << localdan.ordinal() % 6);
      }
      if ((i > 0) || (((StringBuilder)localObject1).length() == 0)) {
        ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
      }
      b.clear();
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally {}
  }
  
  public final void a(dan paramdan)
  {
    try
    {
      if (!d)
      {
        b.add(paramdan);
        c.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(paramdan.ordinal()));
      }
      return;
    }
    finally
    {
      paramdan = finally;
      throw paramdan;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      d = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String b()
  {
    try
    {
      if (c.length() > 0) {
        c.insert(0, ".");
      }
      String str = c.toString();
      c = new StringBuilder();
      return str;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     dam
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */