import android.text.Spannable;
import com.android.ex.chips.RecipientEditTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class bkk
  implements bjm
{
  bkk(bkj parambkj, ArrayList paramArrayList) {}
  
  public final void a(Map<String, bkn> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.iterator();
    if (localIterator.hasNext())
    {
      localObject = (bkq)localIterator.next();
      if ((localObject == null) || (!bkn.a(gg)) || (b.a.getText().getSpanStart(localObject) == -1)) {
        break label151;
      }
    }
    label151:
    for (Object localObject = b.a.c((bkn)paramMap.get(RecipientEditTextView.a(gd)));; localObject = null)
    {
      if (localObject != null)
      {
        localArrayList.add(b.a((bkn)localObject));
        break;
      }
      localArrayList.add(null);
      break;
      b.a(a, localArrayList);
      return;
    }
  }
  
  public final void a(Set<String> paramSet)
  {
    ArrayList localArrayList = new ArrayList(paramSet.size());
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      bkq localbkq = (bkq)localIterator.next();
      if ((localbkq != null) && (bkn.a(gg)) && (b.a.getText().getSpanStart(localbkq) != -1))
      {
        if (paramSet.contains(gd)) {
          localArrayList.add(b.a(localbkq.g()));
        } else {
          localArrayList.add(null);
        }
      }
      else {
        localArrayList.add(null);
      }
    }
    b.a(a, localArrayList);
  }
}

/* Location:
 * Qualified Name:     bkk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */