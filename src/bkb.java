import android.os.Handler;
import android.text.Spannable;
import com.android.ex.chips.RecipientEditTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class bkb
  implements bjm
{
  bkb(bka parambka, ArrayList paramArrayList) {}
  
  public final void a(Map<String, bkn> paramMap)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      bkq localbkq = (bkq)localIterator.next();
      if ((bkn.a(gg)) && (b.a.getText().getSpanStart(localbkq) != -1))
      {
        bkn localbkn = b.a.c((bkn)paramMap.get(RecipientEditTextView.a(gd).toLowerCase()));
        if (localbkn != null) {
          b.a.f.post(new bkc(this, localbkq, localbkn));
        }
      }
    }
  }
  
  public final void a(Set<String> paramSet) {}
}

/* Location:
 * Qualified Name:     bkb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */