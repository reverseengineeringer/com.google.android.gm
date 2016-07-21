import com.google.android.gms.search.corpora.ClearCorpusCall.Response;
import com.google.android.gms.search.corpora.GetCorpusInfoCall.Response;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Response;
import com.google.android.gms.search.corpora.RequestIndexingCall.Response;

public final class fzl<R>
  extends fze
{
  private final ejr<R> a;
  private final Class<R> b;
  
  public fzl(ejr<R> paramejr, Class<R> paramClass)
  {
    a = paramejr;
    b = paramClass;
  }
  
  public final void a(ClearCorpusCall.Response paramResponse)
  {
    a.a(b.cast(paramResponse));
  }
  
  public final void a(GetCorpusInfoCall.Response paramResponse)
  {
    a.a(b.cast(paramResponse));
  }
  
  public final void a(GetCorpusStatusCall.Response paramResponse)
  {
    a.a(b.cast(paramResponse));
  }
  
  public final void a(RequestIndexingCall.Response paramResponse)
  {
    a.a(b.cast(paramResponse));
  }
}

/* Location:
 * Qualified Name:     fzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */