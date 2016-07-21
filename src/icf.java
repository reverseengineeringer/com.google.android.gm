import java.util.Map;

public final class icf
{
  private static final Map a = new hpl((byte)0);
  
  static
  {
    a("ical4j.unfolding.relaxed", "true".equals(icg.a("ical4j.unfolding.relaxed")));
    a("ical4j.parsing.relaxed", "true".equals(icg.a("ical4j.parsing.relaxed")));
    a("ical4j.validation.relaxed", "true".equals(icg.a("ical4j.validation.relaxed")));
    a("ical4j.compatibility.outlook", "true".equals(icg.a("ical4j.compatibility.outlook")));
    a("ical4j.compatibility.notes", "true".equals(icg.a("ical4j.compatibility.notes")));
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    a.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static boolean a(String paramString)
  {
    if (a.get(paramString) != null) {
      return ((Boolean)a.get(paramString)).booleanValue();
    }
    return "true".equals(icg.a(paramString));
  }
}

/* Location:
 * Qualified Name:     icf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */