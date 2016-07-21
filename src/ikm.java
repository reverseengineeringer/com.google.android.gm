public final class ikm
{
  public static ily a;
  
  static
  {
    ikn localikn = new ikn();
    a = localikn;
    localikn.a(1, "IN");
    a.a(3, "CH");
    a.b(3, "CHAOS");
    a.a(4, "HS");
    a.b(4, "HESIOD");
    a.a(254, "NONE");
    a.a(255, "ANY");
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new ili(paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     ikm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */