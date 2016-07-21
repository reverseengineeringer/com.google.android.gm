import android.os.IInterface;
import com.google.android.gms.search.queries.GetDocumentsCall.Response;
import com.google.android.gms.search.queries.GetPhraseAffinityCall.Response;
import com.google.android.gms.search.queries.GlobalQueryCall.Response;
import com.google.android.gms.search.queries.QueryCall.Response;
import com.google.android.gms.search.queries.QuerySuggestCall.Response;

public abstract interface gbs
  extends IInterface
{
  public abstract void a(GetDocumentsCall.Response paramResponse);
  
  public abstract void a(GetPhraseAffinityCall.Response paramResponse);
  
  public abstract void a(GlobalQueryCall.Response paramResponse);
  
  public abstract void a(QueryCall.Response paramResponse);
  
  public abstract void a(QuerySuggestCall.Response paramResponse);
}

/* Location:
 * Qualified Name:     gbs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */