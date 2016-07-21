public final class hsk
{
  public static hsk a = new hsk();
  
  public final hsj a(String paramString)
  {
    hwm localhwm = new hwm();
    if ("VALARM".equals(paramString)) {
      return new hxe(localhwm);
    }
    if ("VEVENT".equals(paramString)) {
      return new hxl(localhwm);
    }
    if ("VFREEBUSY".equals(paramString)) {
      return new hxu(localhwm);
    }
    if ("VJOURNAL".equals(paramString)) {
      return new hxy(localhwm);
    }
    if ("VTODO".equals(paramString)) {
      return new hye(localhwm);
    }
    if ("STANDARD".equals(paramString)) {
      return new hxd(localhwm);
    }
    if ("DAYLIGHT".equals(paramString)) {
      return new hxb(localhwm);
    }
    if ("VTIMEZONE".equals(paramString)) {
      return new hyc(localhwm);
    }
    if ("VVENUE".equals(paramString)) {
      return new hyn(localhwm);
    }
    if ("VAVAILABILITY".equals(paramString)) {
      return new hxk(localhwm);
    }
    if ("AVAILABLE".equals(paramString)) {
      return new hwy(localhwm);
    }
    if ((paramString.startsWith("X-")) && (paramString.length() > 2)) {}
    for (int i = 1; i != 0; i = 0) {
      return new hyo(paramString, localhwm);
    }
    if (icf.a("ical4j.parsing.relaxed")) {
      return new hyo(paramString, localhwm);
    }
    throw new IllegalArgumentException(String.valueOf(paramString).length() + 20 + "Illegal component [" + paramString + "]");
  }
}

/* Location:
 * Qualified Name:     hsk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */