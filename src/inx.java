public final class inx
{
  public static iny a;
  
  static
  {
    iny localiny = new iny();
    a = localiny;
    localiny.a(1, "A", new ijy());
    a.a(2, "NS", new img());
    a.a(3, "MD", new ilr());
    a.a(4, "MF", new ils());
    a.a(5, "CNAME", new ikb());
    a.a(6, "SOA", new ine());
    a.a(7, "MB", new ilq());
    a.a(8, "MG", new ilt());
    a.a(9, "MR", new ilv());
    a.a(10, "NULL", new imh());
    a.a(11, "WKS", new iof());
    a.a(12, "PTR", new imo());
    a.a(13, "HINFO", new ile());
    a.a(14, "MINFO", new ilu());
    a.a(15, "MX", new ilw());
    a.a(16, "TXT", new inv());
    a.a(17, "RP", new imr());
    a.a(18, "AFSDB", new ijv());
    a.a(19, "X25", new ioh());
    a.a(20, "ISDN", new ilh());
    a.a(21, "RT", new imu());
    a.a(22, "NSAP", new ima());
    a.a(23, "NSAP-PTR", new imb());
    a.a(24, "SIG", new ind());
    a.a(25, "KEY", new ilm());
    a.a(26, "PX", new imp());
    a.a(27, "GPOS", new ilc());
    a.a(28, "AAAA", new iju());
    a.a(29, "LOC", new ilo());
    a.a(30, "NXT", new imi());
    a.a(31, "EID");
    a.a(32, "NIMLOC");
    a.a(33, "SRV", new ing());
    a.a(34, "ATMA");
    a.a(35, "NAPTR", new ilz());
    a.a(36, "KX", new iln());
    a.a(37, "CERT", new ika());
    a.a(38, "A6", new ijt());
    a.a(39, "DNAME", new ikq());
    a.a(41, "OPT", new iml());
    a.a(42, "APL", new ijw());
    a.a(43, "DS", new iku());
    a.a(44, "SSHFP", new inh());
    a.a(45, "IPSECKEY", new ilg());
    a.a(46, "RRSIG", new ims());
    a.a(47, "NSEC", new ime());
    a.a(48, "DNSKEY", new iks());
    a.a(49, "DHCID", new iko());
    a.a(50, "NSEC3", new imd());
    a.a(51, "NSEC3PARAM", new imc());
    a.a(52, "TLSA", new inp());
    a.a(99, "SPF", new inf());
    a.a(249, "TKEY", new ino());
    a.a(250, "TSIG", new ins());
    a.a(251, "IXFR");
    a.a(252, "AXFR");
    a.a(253, "MAILB");
    a.a(254, "MAILA");
    a.a(255, "ANY");
    a.a(256, "URI", new ioe());
    a.a(32769, "DLV", new ikp());
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new ilk(paramInt);
    }
  }
  
  public static boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     inx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */