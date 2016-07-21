import android.text.Spanned;
import java.util.Comparator;

final class cep<T>
  implements Comparator<T>
{
  private final Spanned a;
  
  public cep(Spanned paramSpanned)
  {
    a = paramSpanned;
  }
  
  public final int compare(T paramT1, T paramT2)
  {
    int j = a.getSpanStart(paramT1) - a.getSpanStart(paramT2);
    int i = j;
    if (j == 0) {
      i = a.getSpanEnd(paramT1) - a.getSpanEnd(paramT2);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     cep
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */