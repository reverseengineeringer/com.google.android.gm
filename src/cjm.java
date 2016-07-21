import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;

public class cjm
{
  public final Context b;
  public Formatter c;
  public StringBuilder d;
  public boolean e = false;
  
  public cjm(Context paramContext)
  {
    b = paramContext;
  }
  
  public String a()
  {
    String str = c.toString();
    b();
    return str;
  }
  
  public final String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        localInputStreamReader = new InputStreamReader(b.getResources().openRawResource(paramInt), "UTF-8");
        try
        {
          char[] arrayOfChar = new char['က'];
          int i = localInputStreamReader.read(arrayOfChar);
          if (i <= 0) {
            continue;
          }
          localStringBuilder.append(arrayOfChar, 0, i);
          continue;
          if (localInputStreamReader == null) {}
        }
        finally {}
      }
      finally
      {
        InputStreamReader localInputStreamReader;
        String str1;
        String str2 = null;
        continue;
      }
      try
      {
        localInputStreamReader.close();
        throw ((Throwable)localObject1);
      }
      catch (IOException localIOException)
      {
        str1 = String.valueOf(Integer.toHexString(paramInt));
        str2 = String.valueOf(localIOException.getMessage());
        throw new Resources.NotFoundException(String.valueOf(str1).length() + 38 + String.valueOf(str2).length() + "Unable to open template id=" + str1 + " exception=" + str2);
      }
    }
    str1 = str1.toString();
    str2.close();
    return str1;
  }
  
  public final void a(String paramString, Object... paramVarArgs)
  {
    c.format(paramString, paramVarArgs);
  }
  
  public void b()
  {
    c = null;
    d = null;
  }
  
  public void c()
  {
    d = new StringBuilder(65536);
    c = new Formatter(d, null);
  }
}

/* Location:
 * Qualified Name:     cjm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */