import com.google.android.gms.appdatasearch.SuggestionResults;
import java.util.Iterator;

public final class ecq
  implements Iterator<ecp>
{
  private int b = 0;
  
  public ecq(SuggestionResults paramSuggestionResults) {}
  
  public final boolean hasNext()
  {
    return b < a.c.length;
  }
  
  public final void remove()
  {
    throw new IllegalStateException("remove not supported");
  }
}

/* Location:
 * Qualified Name:     ecq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */