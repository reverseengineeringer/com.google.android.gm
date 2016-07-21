import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.Arrays;
import java.util.Locale;

public abstract class ceo<T>
  implements ceh, cej
{
  private static final String a = cvl.a;
  private final Class<T> b;
  
  public ceo(Class<T> paramClass)
  {
    b = paramClass;
  }
  
  private static String b(Spanned paramSpanned)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Text length: ").append(paramSpanned.length()).append("\n");
    Object[] arrayOfObject = paramSpanned.getSpans(0, paramSpanned.length(), Object.class);
    Arrays.sort(arrayOfObject, new cep(paramSpanned));
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      localStringBuilder.append(String.format(Locale.US, "\t%03d..%03d (flag 0x%08x): %s\n", new Object[] { Integer.valueOf(paramSpanned.getSpanStart(localObject)), Integer.valueOf(paramSpanned.getSpanEnd(localObject)), Integer.valueOf(paramSpanned.getSpanFlags(localObject)), localObject.getClass().getName() }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final Spanned a(Spanned paramSpanned)
  {
    a();
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder(paramSpanned);
    int i = 0;
    for (;;)
    {
      int k;
      if (i < localSpannableStringBuilder1.length())
      {
        k = localSpannableStringBuilder1.nextSpanTransition(i, localSpannableStringBuilder1.length(), b);
        Object localObject1 = localSpannableStringBuilder1.getSpans(i, k, b);
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          if ((localObject1.length == 1) && (localSpannableStringBuilder1.getSpanStart(localObject1[0]) == i) && (localSpannableStringBuilder1.getSpanEnd(localObject1[0]) == k))
          {
            localObject1 = localObject1[0];
            localSpannableStringBuilder1.removeSpan(localObject1);
            SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(localSpannableStringBuilder1, i, k);
            Object[] arrayOfObject = localSpannableStringBuilder1.getSpans(i, k, Object.class);
            int m = arrayOfObject.length;
            int j = 0;
            if (j < m)
            {
              Object localObject2 = arrayOfObject[j];
              int n = localSpannableStringBuilder1.getSpanStart(localObject2);
              int i1 = localSpannableStringBuilder1.getSpanEnd(localObject2);
              if ((n <= i) && (k <= i1)) {
                localSpannableStringBuilder2.removeSpan(localObject2);
              }
              for (;;)
              {
                j += 1;
                break;
                if ((i <= n) && (i1 <= k))
                {
                  localSpannableStringBuilder1.removeSpan(localObject2);
                }
                else if (((n < i) && (i1 < k)) || ((i < n) && (k < i1)))
                {
                  if (cvm.a(a, 3)) {
                    cvm.b(a, b(paramSpanned), new Object[0]);
                  }
                  cvm.e(a, "unexpected span overlap", new Object[0]);
                }
              }
            }
            localObject1 = a(localObject1, localSpannableStringBuilder2);
            localSpannableStringBuilder1.replace(i, k, (CharSequence)localObject1);
            i += ((CharSequence)localObject1).length();
            continue;
          }
          if (cvm.a(a, 3)) {
            cvm.b(a, b(paramSpanned), new Object[0]);
          }
          i = localObject1.length;
          throw new IllegalArgumentException(34 + "unexpected span count: " + i);
        }
      }
      else
      {
        return localSpannableStringBuilder1;
      }
      i = k;
    }
  }
  
  public abstract CharSequence a(T paramT, Editable paramEditable);
  
  public void a() {}
}

/* Location:
 * Qualified Name:     ceo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */