public final class bte
{
  final long a;
  final String b;
  final String c;
  final String d;
  
  public bte(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    a = paramLong;
    c = paramString2;
    d = paramString3;
    b = paramString1;
  }
  
  public final String toString()
  {
    return String.format("{id-%d: mailboxId: %s, oldSyncKey: %s, newSyncKey: %s}", new Object[] { Long.valueOf(a), b, c, d });
  }
}

/* Location:
 * Qualified Name:     bte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */