import java.util.ArrayList;
import java.util.Iterator;

public final class bcx
  extends ArrayList<bcz>
{
  public final bdn a()
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      bcz localbcz = (bcz)localIterator.next();
      if ((localbcz instanceof bdn)) {
        return (bdn)localbcz;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bcx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */