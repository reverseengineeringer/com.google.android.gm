import com.google.android.gms.search.queries.QuerySuggestCall.Request;
import com.google.android.gms.search.queries.QuerySuggestCall.Response;

public final class gbq
  extends fqq<QuerySuggestCall.Response, gby>
{
  private final QuerySuggestCall.Request a;
  
  public gbq(QuerySuggestCall.Request paramRequest, eiz parameiz)
  {
    super(fyg.b, parameiz);
    a = paramRequest;
  }
  
  private final void a(gby paramgby)
  {
    ((gbv)paramgby.m()).a(a, new gca(this, QuerySuggestCall.Response.class));
  }
}

/* Location:
 * Qualified Name:     gbq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */