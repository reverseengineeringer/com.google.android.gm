import android.os.IInterface;
import com.google.android.gms.search.queries.GetDocumentsCall.Request;
import com.google.android.gms.search.queries.GetPhraseAffinityCall.Request;
import com.google.android.gms.search.queries.GlobalQueryCall.Request;
import com.google.android.gms.search.queries.QueryCall.Request;
import com.google.android.gms.search.queries.QuerySuggestCall.Request;

public abstract interface gbv
  extends IInterface
{
  public abstract void a(GetDocumentsCall.Request paramRequest, gbs paramgbs);
  
  public abstract void a(GetPhraseAffinityCall.Request paramRequest, gbs paramgbs);
  
  public abstract void a(GlobalQueryCall.Request paramRequest, gbs paramgbs);
  
  public abstract void a(QueryCall.Request paramRequest, gbs paramgbs);
  
  public abstract void a(QuerySuggestCall.Request paramRequest, gbs paramgbs);
}

/* Location:
 * Qualified Name:     gbv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */