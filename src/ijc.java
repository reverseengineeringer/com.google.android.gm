public enum ijc
{
  private static final hel<String, ijc> g = hel.f().b("iframe", b).b("listing", c).b("xmp", b).b("comment", c).b("plaintext", e).b("script", b).b("style", b).b("textarea", d).b("title", d).b("area", f).b("base", f).b("br", f).b("col", f).b("command", f).b("embed", f).b("hr", f).b("img", f).b("input", f).b("keygen", f).b("link", f).b("meta", f).b("param", f).b("source", f).b("track", f).b("wbr", f).b("basefont", f).b("isindex", f).b();
  
  private ijc() {}
  
  public static ijc a(String paramString)
  {
    paramString = (ijc)g.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return a;
  }
  
  public static boolean b(String paramString)
  {
    return ("style".equals(paramString)) || ("script".equals(paramString)) || ("noembed".equals(paramString)) || ("noscript".equals(paramString)) || ("noframes".equals(paramString));
  }
  
  public static boolean c(String paramString)
  {
    paramString = a(paramString);
    return (paramString != a) && (paramString != f);
  }
  
  public static boolean d(String paramString)
  {
    return a(paramString) == f;
  }
}

/* Location:
 * Qualified Name:     ijc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */