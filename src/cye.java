import android.text.Spannable;

public final class cye
{
  public static void a(Spannable paramSpannable, Object paramObject1, Object paramObject2)
  {
    int i = paramSpannable.getSpanStart(paramObject1);
    int j = paramSpannable.getSpanEnd(paramObject1);
    paramSpannable.removeSpan(paramObject1);
    paramSpannable.setSpan(paramObject2, i, j, 0);
  }
}

/* Location:
 * Qualified Name:     cye
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */