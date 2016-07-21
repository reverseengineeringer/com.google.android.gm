import java.util.Arrays;
import java.util.logging.Logger;

public abstract class gsa
{
  static final Logger a = Logger.getLogger(gsa.class.getName());
  private static final String[] b;
  
  static
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "DELETE";
    arrayOfString[1] = "GET";
    arrayOfString[2] = "POST";
    arrayOfString[3] = "PUT";
    b = arrayOfString;
    Arrays.sort(arrayOfString);
  }
  
  public final grt a(gru paramgru)
  {
    return new grt(this, paramgru);
  }
  
  public abstract gsd a(String paramString1, String paramString2);
  
  public boolean a(String paramString)
  {
    return Arrays.binarySearch(b, paramString) >= 0;
  }
}

/* Location:
 * Qualified Name:     gsa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */