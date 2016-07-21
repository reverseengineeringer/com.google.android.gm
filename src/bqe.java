import java.net.URI;
import java.util.HashSet;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpUriRequest;

public final class bqe
  extends bqc
{
  private static final HashSet<String> b;
  String a = null;
  
  static
  {
    HashSet localHashSet = hio.a(new String[] { "2.5", "12.0", "12.1", "14.0", "14.1" });
    b = localHashSet;
    localHashSet.add("16.0");
  }
  
  public bqe(bqc parambqc)
  {
    super(parambqc);
  }
  
  protected final int a(bns parambns)
  {
    Header localHeader = parambns.a("MS-ASProtocolCommands");
    parambns = parambns.a("ms-asprotocolversions");
    int i;
    if ((localHeader == null) || (parambns == null))
    {
      cvm.e("Exchange", "OPTIONS response without commands or versions", new Object[0]);
      i = 0;
      label38:
      if (i == 0) {
        return -9;
      }
    }
    else
    {
      parambns = parambns.getValue();
      cvm.b("Exchange", "Server supports versions: %s", new Object[] { parambns });
      String[] arrayOfString = parambns.split(",");
      parambns = null;
      int j = arrayOfString.length;
      i = 0;
      label84:
      if (i < j)
      {
        localHeader = arrayOfString[i];
        if (!b.contains(localHeader)) {
          break label135;
        }
        parambns = localHeader;
      }
    }
    label135:
    for (;;)
    {
      i += 1;
      break label84;
      a = parambns;
      if (a == null) {
        break;
      }
      i = 1;
      break label38;
      return 0;
    }
  }
  
  protected final String a()
  {
    return null;
  }
  
  protected final String b()
  {
    return "OPTIONS";
  }
  
  protected final HttpEntity c()
  {
    return null;
  }
  
  protected final HttpUriRequest e()
  {
    brt localbrt = h;
    HttpOptions localHttpOptions = new HttpOptions(URI.create(localbrt.b()));
    localHttpOptions.setHeader("Authorization", localbrt.a());
    localHttpOptions.setHeader("User-Agent", localbrt.c());
    return localHttpOptions;
  }
  
  protected final boolean g()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     bqe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */