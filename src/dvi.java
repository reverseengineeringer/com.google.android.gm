import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

final class dvi
  extends InflaterInputStream
{
  dvi(InputStream paramInputStream, Inflater paramInflater)
  {
    super(paramInputStream, paramInflater);
  }
  
  public final void close()
  {
    super.close();
    inf.end();
  }
}

/* Location:
 * Qualified Name:     dvi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */