import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class axy
  extends axp
{
  static final byte[] c = new byte[0];
  public static final axy d = new axz();
  private static final SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss Z", Locale.US);
  public Date e;
  private boolean g;
  private int h;
  
  private final boolean j()
  {
    if (g) {
      return true;
    }
    try
    {
      h = Integer.parseInt(e());
      g = true;
      return true;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return false;
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return e().equalsIgnoreCase(paramString);
  }
  
  public final boolean b()
  {
    return true;
  }
  
  public abstract String e();
  
  public abstract InputStream f();
  
  public final boolean g()
  {
    return e().length() == 0;
  }
  
  public final int h()
  {
    if (!j()) {
      return 0;
    }
    return h;
  }
  
  public final boolean i()
  {
    if (e != null) {
      return true;
    }
    if (g()) {
      return false;
    }
    try
    {
      e = f.parse(e());
      return true;
    }
    catch (ParseException localParseException)
    {
      cvm.d(bbw.a, String.valueOf(e()).concat(" can't be parsed as a date."), new Object[0]);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     axy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */