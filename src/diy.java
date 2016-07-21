import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;

public final class diy
  implements TextWatcher
{
  private cdt[] a;
  private boolean b;
  
  public final void afterTextChanged(Editable paramEditable)
  {
    int i = 0;
    if (a != null)
    {
      Object localObject1;
      int j;
      if ((!b) || (a.length > 1))
      {
        localObject1 = a;
        j = localObject1.length;
      }
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        ((cdt)localObject2).a();
        paramEditable.removeSpan(localObject2);
        i += 1;
        continue;
        localObject1 = a[0];
        ((cdt)localObject1).a();
        i = paramEditable.getSpanStart(localObject1);
        j = paramEditable.getSpanEnd(localObject1);
        if ((i >= 0) && (j >= 0)) {
          paramEditable.replace(paramEditable.getSpanStart(localObject1), paramEditable.getSpanEnd(localObject1), "");
        }
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    a = null;
    if (!(paramCharSequence instanceof Spanned)) {}
    do
    {
      return;
      paramCharSequence = (cdt[])((Spanned)paramCharSequence).getSpans(paramInt1, paramInt1 + paramInt2, cdt.class);
    } while ((paramCharSequence == null) || (paramCharSequence.length == 0) || (paramInt2 <= 0));
    a = paramCharSequence;
    if (paramInt3 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      return;
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     diy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */