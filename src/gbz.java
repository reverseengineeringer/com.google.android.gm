import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.search.queries.QueryCall.Request;
import com.google.android.gms.search.queries.QueryCall.Response;
import com.google.android.gms.search.queries.QuerySuggestCall.Request;
import com.google.android.gms.search.queries.QuerySuggestCall.Response;

public final class gbz
  implements gbr
{
  public final ejh<QuerySuggestCall.Response> a()
  {
    QuerySuggestCall.Request localRequest = new QuerySuggestCall.Request();
    String str1;
    a = str1;
    String str2;
    b = str2;
    String[] arrayOfString;
    c = arrayOfString;
    d = 20;
    e = null;
    eiz localeiz;
    return localeiz.a(new gbq(localRequest, localeiz));
  }
  
  public final ejh<QueryCall.Response> a(eiz parameiz, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt1, int paramInt2, QuerySpecification paramQuerySpecification)
  {
    QueryCall.Request localRequest = new QueryCall.Request();
    a = paramString1;
    b = paramString2;
    c = paramArrayOfString;
    d = paramInt1;
    e = paramInt2;
    f = paramQuerySpecification;
    return parameiz.a(new gbp(localRequest, parameiz));
  }
}

/* Location:
 * Qualified Name:     gbz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */