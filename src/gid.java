public enum gid
{
  private gid() {}
  
  public static gid a(String paramString)
  {
    return (gid)Enum.valueOf(gid.class, paramString);
  }
}

/* Location:
 * Qualified Name:     gid
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */