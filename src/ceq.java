import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

public class ceq<T extends Parcelable>
  implements cej
{
  private final Class<T> a;
  private final cek<T> b;
  
  public ceq(Class<T> paramClass, Parcelable.Creator<T> paramCreator)
  {
    a = paramClass;
    b = new cek(paramCreator);
  }
  
  public final Spanned a(Spanned paramSpanned)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpanned);
    Parcelable[] arrayOfParcelable = (Parcelable[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), a);
    int m = arrayOfParcelable.length;
    int i = 0;
    while (i < m)
    {
      Parcelable localParcelable = arrayOfParcelable[i];
      int k = paramSpanned.getSpanStart(localParcelable);
      int n = paramSpanned.getSpanEnd(localParcelable);
      int i1 = paramSpanned.getSpanFlags(localParcelable);
      int j = paramSpanned.nextSpanTransition(k, n, Object.class);
      localSpannableStringBuilder.setSpan(localParcelable, k, j, i1);
      while (j < n)
      {
        k = paramSpanned.nextSpanTransition(j, n, Object.class);
        localSpannableStringBuilder.setSpan(b.a(localParcelable), j, k, i1);
        j = k;
      }
      i += 1;
    }
    return localSpannableStringBuilder;
  }
}

/* Location:
 * Qualified Name:     ceq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */