import android.text.Editable;
import android.text.TextWatcher;
import com.android.ex.chips.RecipientEditTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class ccd
  implements TextWatcher
{
  private final HashMap<String, Integer> b = new HashMap();
  private final RecipientEditTextView c;
  private final TextWatcher d;
  
  public ccd(cbk paramcbk, RecipientEditTextView paramRecipientEditTextView, TextWatcher paramTextWatcher)
  {
    c = paramRecipientEditTextView;
    d = paramTextWatcher;
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    int j = 0;
    Object localObject1 = cbk.b(cbk.a(c));
    int k = ((ArrayList)localObject1).size();
    Object localObject2 = b.entrySet().iterator();
    for (int i = 0; ((Iterator)localObject2).hasNext(); i = ((Integer)((Map.Entry)((Iterator)localObject2).next()).getValue()).intValue() + i) {}
    if (k != i)
    {
      i = 1;
      if (i != 0) {
        d.afterTextChanged(paramEditable);
      }
      return;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    for (;;)
    {
      i = j;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      if (!b.containsKey(localObject2))
      {
        i = 1;
        break;
      }
      i = ((Integer)b.get(localObject2)).intValue() - 1;
      if (i < 0)
      {
        i = 1;
        break;
      }
      b.put(localObject2, Integer.valueOf(i));
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = cbk.b(cbk.a(c)).iterator();
    while (paramCharSequence.hasNext())
    {
      String str = (String)paramCharSequence.next();
      if (!b.containsKey(str)) {
        b.put(str, Integer.valueOf(1));
      } else {
        b.put(str, Integer.valueOf(((Integer)b.get(str)).intValue() + 1));
      }
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     ccd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */