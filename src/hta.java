public class hta
  extends hsa
  implements hsz
{
  public static hta a = new hta();
  private static final long serialVersionUID = -4034423507432249165L;
  
  protected hta()
  {
    a("ABBREV", new htb());
    a("ALTREP", new htc());
    a("CN", new htd());
    a("CUTYPE", new hte());
    a("DELEGATED-FROM", new htf());
    a("DELEGATED-TO", new htg());
    a("DIR", new hth());
    a("ENCODING", new hti());
    a("FMTTYPE", new htk());
    a("FBTYPE", new htj());
    a("LANGUAGE", new htl());
    a("MEMBER", new htm());
    a("PARTSTAT", new htn());
    a("RANGE", new hto());
    a("RELATED", new htq());
    a("RELTYPE", new htp());
    a("ROLE", new htr());
    a("RSVP", new hts());
    a("SCHEDULE-AGENT", new htt());
    a("SCHEDULE-STATUS", new htu());
    a("SENT-BY", new htv());
    a("TYPE", new htw());
    a("TZID", new htx());
    a("VALUE", new hty());
    a("VVENUE", new htz());
  }
  
  public final hsy a(String paramString1, String paramString2)
  {
    hsz localhsz = (hsz)a_(paramString1);
    if (localhsz != null) {
      return localhsz.a(paramString1, paramString2);
    }
    if ((paramString1.startsWith("X-")) && (paramString1.length() > 2)) {}
    for (int i = 1; i != 0; i = 0) {
      return new hzo(paramString1, paramString2);
    }
    if (icf.a("ical4j.parsing.relaxed")) {
      return new hzo(paramString1, paramString2);
    }
    paramString1 = String.valueOf(paramString1);
    if (paramString1.length() != 0) {}
    for (paramString1 = "Invalid parameter name: ".concat(paramString1);; paramString1 = new String("Invalid parameter name: ")) {
      throw new IllegalArgumentException(paramString1);
    }
  }
}

/* Location:
 * Qualified Name:     hta
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */