import com.android.mail.providers.Attachment;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.io.InputStream;

final class dto
  implements dds
{
  InputStream a;
  long b;
  private final long d;
  private final GmailAttachment e;
  
  public dto(dtn paramdtn, long paramLong, GmailAttachment paramGmailAttachment)
  {
    d = paramLong;
    e = paramGmailAttachment;
    a = d();
    b = a.available();
  }
  
  private final InputStream d()
  {
    return c.h.a(e);
  }
  
  public final long a()
  {
    return b;
  }
  
  public final String b()
  {
    return e.c;
  }
  
  public final InputStream c()
  {
    if (a != null)
    {
      InputStream localInputStream = a;
      a = null;
      return localInputStream;
    }
    return d();
  }
}

/* Location:
 * Qualified Name:     dto
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */