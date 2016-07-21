import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class cel<T extends Parcelable>
  implements cej
{
  private final Class<T> a;
  private final cek<T> b;
  
  public cel(Class<T> paramClass, Parcelable.Creator<T> paramCreator)
  {
    a = paramClass;
    b = new cek(paramCreator);
  }
  
  private final Spanned a(Spannable paramSpannable, T[] paramArrayOfT)
  {
    int j = 0;
    int k = paramArrayOfT.length;
    if (k == 0) {}
    for (;;)
    {
      return paramSpannable;
      Object localObject1 = new int[k];
      Object localObject2 = new int[k];
      int[] arrayOfInt = new int[k];
      TreeSet localTreeSet = new TreeSet(cem.a);
      int i = 0;
      Object localObject3;
      while (i < k)
      {
        localObject3 = paramArrayOfT[i];
        localObject1[i] = paramSpannable.getSpanStart(localObject3);
        localObject2[i] = paramSpannable.getSpanEnd(localObject3);
        arrayOfInt[i] = paramSpannable.getSpanFlags(localObject3);
        localTreeSet.add(new cem(localObject1[i]));
        localTreeSet.add(new cem(localObject2[i]));
        if (localObject1[i] != localObject2[i]) {
          paramSpannable.removeSpan(localObject3);
        }
        i += 1;
      }
      i = 0;
      int m;
      int n;
      while (i < k)
      {
        m = localObject1[i];
        n = localObject2[i];
        if (m != n)
        {
          localObject3 = localTreeSet.subSet(new cem(m), new cem(n)).iterator();
          while (((Iterator)localObject3).hasNext()) {
            nextc = i;
          }
        }
        i += 1;
      }
      k = localTreeSet.size();
      localObject1 = (cem[])localTreeSet.toArray(new cem[k]);
      i = j;
      while (i < k - 1)
      {
        localObject2 = localObject1[i];
        j = c;
        if (j != -1)
        {
          m = b;
          n = 1b;
          localObject2 = paramArrayOfT[j];
          paramArrayOfT[j] = b.a((Parcelable)localObject2);
          paramSpannable.setSpan(localObject2, m, n, arrayOfInt[j]);
        }
        i += 1;
      }
    }
  }
  
  public final Spanned a(Spanned paramSpanned)
  {
    return a(new SpannableString(paramSpanned), (Parcelable[])paramSpanned.getSpans(0, paramSpanned.length(), a));
  }
}

/* Location:
 * Qualified Name:     cel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */