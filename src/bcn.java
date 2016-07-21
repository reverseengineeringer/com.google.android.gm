import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class bcn
  extends bdj
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public bcn()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("----");
    int i = 0;
    while (i < 30)
    {
      localStringBuffer.append(Integer.toString((int)(Math.random() * 35.0D), 36));
      i += 1;
    }
    c = localStringBuffer.toString().toUpperCase();
    a("mixed");
  }
  
  public bcn(String paramString)
  {
    b = paramString;
    for (;;)
    {
      try
      {
        d = bco.a(paramString, null).split("/")[1];
        c = bco.a(paramString, "boundary");
        if (c != null) {
          break;
        }
        String str1 = String.valueOf(paramString);
        if (str1.length() != 0)
        {
          str1 = "MultiPart does not contain boundary: ".concat(str1);
          throw new bdi(28, str1);
        }
      }
      catch (Exception localException)
      {
        throw new bdi(28, String.valueOf(paramString).length() + 69 + "Invalid MultiPart Content-Type; must contain subtype and boundary. (" + paramString + ")", localException);
      }
      String str2 = new String("MultiPart does not contain boundary: ");
    }
  }
  
  public final String a()
  {
    return b;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(paramOutputStream), 1024);
    if (a != null) {
      localBufferedWriter.write(String.valueOf(a).concat("\r\n"));
    }
    int j = f.size();
    int i = 0;
    while (i < j)
    {
      bcv localbcv = (bcv)f.get(i);
      String str = c;
      localBufferedWriter.write(String.valueOf(str).length() + 4 + "--" + str + "\r\n");
      localBufferedWriter.flush();
      localbcv.a(paramOutputStream);
      localBufferedWriter.write("\r\n");
      i += 1;
    }
    paramOutputStream = c;
    localBufferedWriter.write(String.valueOf(paramOutputStream).length() + 6 + "--" + paramOutputStream + "--\r\n");
    localBufferedWriter.flush();
  }
  
  public final void a(String paramString)
  {
    d = paramString;
    b = String.format("multipart/%s; boundary=\"%s\"", new Object[] { paramString, c });
  }
  
  public final InputStream g_()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     bcn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */