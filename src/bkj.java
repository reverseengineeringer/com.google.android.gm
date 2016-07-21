import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.util.Log;
import com.android.ex.chips.RecipientEditTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class bkj
  extends AsyncTask<Void, Void, Void>
{
  public bkj(RecipientEditTextView paramRecipientEditTextView) {}
  
  final bkq a(bkn parambkn)
  {
    try
    {
      if (a.t) {
        return null;
      }
      parambkn = a.a(parambkn);
      return parambkn;
    }
    catch (NullPointerException parambkn)
    {
      Log.e("RecipientEditTextView", parambkn.getMessage(), parambkn);
    }
    return null;
  }
  
  final void a(List<bkq> paramList1, List<bkq> paramList2)
  {
    if (paramList2.size() > 0)
    {
      paramList1 = new bkl(this, paramList1, paramList2);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        paramList1.run();
      }
    }
    else
    {
      return;
    }
    a.f.post(paramList1);
  }
  
  protected final void onPreExecute()
  {
    ArrayList localArrayList1 = new ArrayList();
    Collections.addAll(localArrayList1, a.f());
    if (a.w != null) {
      localArrayList1.addAll(a.w);
    }
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      bkq localbkq = (bkq)localIterator.next();
      if ((bkn.a(gg)) && (a.getText().getSpanStart(localbkq) != -1)) {
        localArrayList2.add(a(localbkq.g()));
      } else {
        localArrayList2.add(null);
      }
    }
    a(localArrayList1, localArrayList2);
  }
}

/* Location:
 * Qualified Name:     bkj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */