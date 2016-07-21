import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;

final class fdi
  extends fdx
{
  private final ejr<fak> a;
  private final fao b;
  
  fdi(ejr<fak> paramejr, fao paramfao)
  {
    a = paramejr;
    b = paramfao;
  }
  
  public final void a(Status paramStatus)
  {
    a.a(new fen(paramStatus, null));
  }
  
  public final void a(OnContentsResponse paramOnContentsResponse)
  {
    if (c) {}
    for (Status localStatus = new Status(-1);; localStatus = Status.a)
    {
      a.a(new fen(localStatus, new few(b)));
      return;
    }
  }
  
  public final void a(OnDownloadProgressResponse paramOnDownloadProgressResponse)
  {
    if (b != null) {
      b.a(b, c);
    }
  }
}

/* Location:
 * Qualified Name:     fdi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */