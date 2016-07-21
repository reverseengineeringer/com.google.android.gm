import android.content.Context;
import com.android.emailcommon.provider.Policy;
import java.io.IOException;
import org.apache.http.HttpEntity;

public final class bqj
  extends bqc
{
  Policy a = null;
  String b = null;
  int c = 0;
  private String d = null;
  
  public bqj(bqc parambqc)
  {
    super(parambqc);
  }
  
  protected final int a(bns parambns)
  {
    parambns = new bpe(f, parambns.d());
    if (c == 2) {}
    do
    {
      return 3;
      if (!parambns.d()) {
        throw new IOException("Error while parsing response");
      }
      if (c != 0) {
        break;
      }
    } while (c);
    a = a;
    if (a == null)
    {
      cvm.d("Exchange", "No policy from Provision Parser. Protocol: %f", new Object[] { Double.valueOf(h.e) });
      if (!e) {
        break label281;
      }
      if (!f)
      {
        cvm.d("Exchange", "<Policy> does not exist. Setting empty policy", new Object[0]);
        a = new Policy();
        buo.a().a("invalid_provision", "no_policy", String.valueOf(h.e), 0L);
      }
    }
    else
    {
      b = b;
      if ((a == null) || (!d)) {
        break label330;
      }
    }
    label281:
    label330:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label335;
      }
      return 1;
      if (!g)
      {
        cvm.d("Exchange", "<Data> does not exist. Setting empty policy", new Object[0]);
        a = new Policy();
        buo.a().a("invalid_provision", "no_data", String.valueOf(h.e), 0L);
        break;
      }
      cvm.d("Exchange", "<Data> exists, but still null policy", new Object[0]);
      buo.a().a("invalid_provision", "unknown", String.valueOf(h.e), 0L);
      break;
      cvm.d("Exchange", "<Policies> does not exist. Setting empty policy", new Object[0]);
      a = new Policy();
      buo.a().a("invalid_provision", "no_policies", String.valueOf(h.e), 0L);
      break;
    }
    label335:
    return 2;
    if (c == 1)
    {
      b = b;
      if (b != null) {
        return 1;
      }
      return 2;
    }
    return 2;
  }
  
  final int a(boolean paramBoolean)
  {
    c = 1;
    if (paramBoolean) {}
    for (String str = "2";; str = "1")
    {
      d = str;
      return p_();
    }
  }
  
  protected final String b()
  {
    return "Provision";
  }
  
  protected final HttpEntity c()
  {
    String str1;
    String str3;
    String str4;
    int i;
    bpi localbpi;
    if (h.e >= 12.0D)
    {
      str1 = "MS-EAS-Provisioning-WBXML";
      String str2 = h.c();
      double d1 = h.e;
      Context localContext = f;
      str3 = b;
      str4 = d;
      i = c;
      localbpi = new bpi();
      localbpi.a(901);
      if ((i == 0) && (d1 >= 14.1D)) {
        a(localbpi, localContext, str2);
      }
      if (i != 2) {
        break label149;
      }
      localbpi.a(908);
      localbpi.b(907, "1");
      localbpi.b();
    }
    for (;;)
    {
      localbpi.b().a();
      return a(localbpi);
      str1 = "MS-WAP-Provisioning-XML";
      break;
      label149:
      localbpi.a(902);
      localbpi.a(903);
      localbpi.b(904, str1);
      if (i == 1)
      {
        localbpi.b(905, str3);
        localbpi.b(907, str4);
      }
      localbpi.b().b();
    }
  }
  
  protected final boolean h()
  {
    return false;
  }
  
  final int j()
  {
    c = 0;
    return p_();
  }
}

/* Location:
 * Qualified Name:     bqj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */