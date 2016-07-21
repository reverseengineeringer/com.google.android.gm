import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.android.ex.chips.RecipientEditTextView;
import java.util.Iterator;
import java.util.List;

final class bkl
  implements Runnable
{
  bkl(bkj parambkj, List paramList1, List paramList2) {}
  
  public final void run()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(c.a.getText());
    Iterator localIterator = a.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (bkq)localIterator.next();
      bkq localbkq = (bkq)b.get(i);
      if (localbkq != null)
      {
        bkn localbkn1 = ((bkq)localObject).g();
        bkn localbkn2 = localbkq.g();
        if (bjk.a(localbkn1, localbkn2) != localbkn2) {
          break label266;
        }
      }
      label266:
      for (int j = 1;; j = 0)
      {
        if (j != 0)
        {
          j = localSpannableStringBuilder.getSpanStart(localObject);
          if (j != -1)
          {
            int k = Math.min(localSpannableStringBuilder.getSpanEnd(localObject) + 1, localSpannableStringBuilder.length());
            localSpannableStringBuilder.removeSpan(localObject);
            localObject = new SpannableString(String.valueOf(c.a.b(localbkq.g()).trim()).concat(" "));
            ((SpannableString)localObject).setSpan(localbkq, 0, ((SpannableString)localObject).length() - 1, 33);
            localSpannableStringBuilder.replace(j, k, (CharSequence)localObject);
            localbkq.a(((SpannableString)localObject).toString());
            b.set(i, null);
            a.set(i, localbkq);
          }
        }
        i += 1;
        break;
      }
    }
    c.a.setText(localSpannableStringBuilder);
  }
}

/* Location:
 * Qualified Name:     bkl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */