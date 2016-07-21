import java.io.File;
import java.io.FilterInputStream;
import java.io.InputStream;

final class bch
  extends FilterInputStream
{
  public bch(bcg parambcg, InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final void close()
  {
    super.close();
    a.a.delete();
  }
}

/* Location:
 * Qualified Name:     bch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */