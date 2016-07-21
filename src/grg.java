import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public final class grg
  implements grk
{
  public final String a()
  {
    return "gzip";
  }
  
  public final void a(guq paramguq, OutputStream paramOutputStream)
  {
    paramOutputStream = new GZIPOutputStream(new grh(this, paramOutputStream));
    paramguq.a(paramOutputStream);
    paramOutputStream.close();
  }
}

/* Location:
 * Qualified Name:     grg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */