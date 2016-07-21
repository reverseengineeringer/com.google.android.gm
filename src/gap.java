import android.os.IInterface;
import com.google.android.gms.search.ime.GetCorpusHandlesRegisteredForIMECall.Request;
import com.google.android.gms.search.ime.GetIMEUpdatesCall.Request;

public abstract interface gap
  extends IInterface
{
  public abstract void a(GetCorpusHandlesRegisteredForIMECall.Request paramRequest, gam paramgam);
  
  public abstract void a(GetIMEUpdatesCall.Request paramRequest, gam paramgam);
}

/* Location:
 * Qualified Name:     gap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */