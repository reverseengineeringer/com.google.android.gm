import java.util.HashMap;

public final class imv
{
  static ily a = new ily("DNS Rcode", 2);
  static ily b = new ily("TSIG rcode", 2);
  
  static
  {
    ae = 4095;
    a.a("RESERVED");
    af = true;
    a.a(0, "NOERROR");
    a.a(1, "FORMERR");
    a.a(2, "SERVFAIL");
    a.a(3, "NXDOMAIN");
    a.a(4, "NOTIMP");
    a.b(4, "NOTIMPL");
    a.a(5, "REFUSED");
    a.a(6, "YXDOMAIN");
    a.a(7, "YXRRSET");
    a.a(8, "NXRRSET");
    a.a(9, "NOTAUTH");
    a.a(10, "NOTZONE");
    a.a(16, "BADVERS");
    be = 65535;
    b.a("RESERVED");
    bf = true;
    ily localily1 = b;
    ily localily2 = a;
    if (d != d) {
      throw new IllegalArgumentException(String.valueOf(c).concat(": wordcases do not match"));
    }
    a.putAll(a);
    b.putAll(b);
    b.a(16, "BADSIG");
    b.a(17, "BADKEY");
    b.a(18, "BADTIME");
    b.a(19, "BADMODE");
  }
}

/* Location:
 * Qualified Name:     imv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */