import com.google.android.gms.search.queries.GetDocumentsCall.Response;
import com.google.android.gms.search.queries.GetPhraseAffinityCall.Response;
import com.google.android.gms.search.queries.GlobalQueryCall.Response;
import com.google.android.gms.search.queries.QueryCall.Response;
import com.google.android.gms.search.queries.QuerySuggestCall.Response;

public final class gca<R>
  extends gbt
{
  private final ejr<R> a;
  private final Class<R> b;
  
  public gca(ejr<R> paramejr, Class<R> paramClass)
  {
    a = paramejr;
    b = paramClass;
  }
  
  public final void a(GetDocumentsCall.Response paramResponse)
  {
    a.a(b.cast(paramResponse));
  }
  
  public final void a(GetPhraseAffinityCall.Response paramResponse)
  {
    a.a(b.cast(paramResponse));
  }
  
  public final void a(GlobalQueryCall.Response paramResponse)
  {
    a.a(b.cast(paramResponse));
  }
  
  public final void a(QueryCall.Response paramResponse)
  {
    a.a(b.cast(paramResponse));
  }
  
  public final void a(QuerySuggestCall.Response paramResponse)
  {
    a.a(b.cast(paramResponse));
  }
}

/* Location:
 * Qualified Name:     gca
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */