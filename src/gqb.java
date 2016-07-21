import android.os.Build.VERSION;
import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

public final class gqb
  extends gsu
{
  public gqb()
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 1;; i = 0)
    {
      int j = Build.VERSION.SDK_INT;
      if (i != 0) {
        break;
      }
      throw new IllegalArgumentException(hbe.a("running on Android SDK level %s but requires minimum %s", new Object[] { Integer.valueOf(j), Integer.valueOf(11) }));
    }
  }
  
  private final gsy a(Reader paramReader)
  {
    return new gqd(this, new JsonReader(paramReader));
  }
  
  public final gsv a(OutputStream paramOutputStream, Charset paramCharset)
  {
    return new gqc(this, new JsonWriter(new OutputStreamWriter(paramOutputStream, paramCharset)));
  }
  
  public final gsy a(InputStream paramInputStream)
  {
    return a(new InputStreamReader(paramInputStream, gtq.a));
  }
  
  public final gsy a(InputStream paramInputStream, Charset paramCharset)
  {
    if (paramCharset == null) {
      return a(paramInputStream);
    }
    return a(new InputStreamReader(paramInputStream, paramCharset));
  }
  
  public final gsy a(String paramString)
  {
    return a(new StringReader(paramString));
  }
}

/* Location:
 * Qualified Name:     gqb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */