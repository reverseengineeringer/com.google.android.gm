import com.google.android.gms.search.corpora.GetCorpusStatusCall.Request;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Response;
import com.google.android.gms.search.corpora.RequestIndexingCall.Request;
import com.google.android.gms.search.corpora.RequestIndexingCall.Response;

public final class fzk
  implements fzc
{
  public final ejh<GetCorpusStatusCall.Response> a(eiz parameiz, String paramString1, String paramString2)
  {
    GetCorpusStatusCall.Request localRequest = new GetCorpusStatusCall.Request();
    a = paramString1;
    b = paramString2;
    return parameiz.a(new fyw(localRequest, parameiz));
  }
  
  public final ejh<RequestIndexingCall.Response> a(eiz parameiz, String paramString1, String paramString2, long paramLong)
  {
    RequestIndexingCall.Request localRequest = new RequestIndexingCall.Request();
    a = paramString1;
    b = paramString2;
    c = paramLong;
    return parameiz.a(new fyz(localRequest, parameiz));
  }
}

/* Location:
 * Qualified Name:     fzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */