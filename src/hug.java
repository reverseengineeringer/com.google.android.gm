public class hug
  extends hsa
  implements huf
{
  public static hug a = new hug();
  private static final long serialVersionUID = -7174232004486979641L;
  
  protected hug()
  {
    a("ACTION", new huh());
    a("ATTACH", new hui());
    a("ATTENDEE", new huj());
    a("CALSCALE", new huk());
    a("CATEGORIES", new hul());
    a("CLASS", new hum());
    a("COMMENT", new hun());
    a("COMPLETED", new huo());
    a("CONTACT", new hup());
    a("COUNTRY", new huq());
    a("CREATED", new hur());
    a("DESCRIPTION", new hus());
    a("DTEND", new hut());
    a("DTSTAMP", new huu());
    a("DTSTART", new huv());
    a("DUE", new huw());
    a("DURATION", new hux());
    a("EXDATE", new huy());
    a("EXRULE", new huz());
    a("EXTENDED-ADDRESS", new hva());
    a("FREEBUSY", new hvb());
    a("GEO", new hvc());
    a("LAST-MODIFIED", new hvd());
    a("LOCALITY", new hve());
    a("LOCATION", new hvf());
    a("LOCATION-TYPE", new hvg());
    a("METHOD", new hvh());
    a("NAME", new hvi());
    a("ORGANIZER", new hvj());
    a("PERCENT-COMPLETE", new hvk());
    a("POSTAL-CODE", new hvl());
    a("PRIORITY", new hvm());
    a("PRODID", new hvn());
    a("RDATE", new hvo());
    a("RECURRENCE-ID", new hvq());
    a("REGION", new hvr());
    a("RELATED-TO", new hvs());
    a("REPEAT", new hvt());
    a("REQUEST-STATUS", new hvu());
    a("RESOURCES", new hvv());
    a("RRULE", new hvp());
    a("SEQUENCE", new hvw());
    a("STATUS", new hvx());
    a("STREET-ADDRESS", new hvy());
    a("SUMMARY", new hvz());
    a("TEL", new hwa());
    a("TRANSP", new hwb());
    a("TRIGGER", new hwc());
    a("TZID", new hwd());
    a("TZNAME", new hwe());
    a("TZOFFSETFROM", new hwf());
    a("TZOFFSETTO", new hwg());
    a("TZURL", new hwh());
    a("UID", new hwi());
    a("URL", new hwj());
    a("VERSION", new hwk());
  }
  
  public final hue a(String paramString)
  {
    huf localhuf = (huf)a_(paramString);
    if (localhuf != null) {
      return localhuf.a(paramString);
    }
    if ((paramString.startsWith("X-")) && (paramString.length() > 2)) {}
    for (int i = 1; i != 0; i = 0) {
      return new ice(paramString);
    }
    if (icf.a("ical4j.parsing.relaxed")) {
      return new ice(paramString);
    }
    throw new IllegalArgumentException(String.valueOf(paramString).length() + 19 + "Illegal property [" + paramString + "]");
  }
}

/* Location:
 * Qualified Name:     hug
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */