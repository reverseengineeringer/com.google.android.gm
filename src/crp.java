import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.List;

final class crp
  extends Filter
{
  crp(cro paramcro) {}
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    paramCharSequence = new Filter.FilterResults();
    values = a.c(((CharSequence)localObject).toString());
    return paramCharSequence;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    if ((paramFilterResults != null) && (values != null))
    {
      a.d = ((List)values);
      a.notifyDataSetChanged();
    }
  }
}

/* Location:
 * Qualified Name:     crp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */