import android.os.IInterface;
import com.google.android.gms.search.corpora.ClearCorpusCall.Request;
import com.google.android.gms.search.corpora.GetCorpusInfoCall.Request;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Request;
import com.google.android.gms.search.corpora.RequestIndexingCall.Request;

public abstract interface fzg
  extends IInterface
{
  public abstract void a(ClearCorpusCall.Request paramRequest, fzd paramfzd);
  
  public abstract void a(GetCorpusInfoCall.Request paramRequest, fzd paramfzd);
  
  public abstract void a(GetCorpusStatusCall.Request paramRequest, fzd paramfzd);
  
  public abstract void a(RequestIndexingCall.Request paramRequest, fzd paramfzd);
}

/* Location:
 * Qualified Name:     fzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */