import android.os.IInterface;
import com.google.android.gms.search.corpora.ClearCorpusCall.Response;
import com.google.android.gms.search.corpora.GetCorpusInfoCall.Response;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Response;
import com.google.android.gms.search.corpora.RequestIndexingCall.Response;

public abstract interface fzd
  extends IInterface
{
  public abstract void a(ClearCorpusCall.Response paramResponse);
  
  public abstract void a(GetCorpusInfoCall.Response paramResponse);
  
  public abstract void a(GetCorpusStatusCall.Response paramResponse);
  
  public abstract void a(RequestIndexingCall.Response paramResponse);
}

/* Location:
 * Qualified Name:     fzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */