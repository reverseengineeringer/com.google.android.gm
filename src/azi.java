import android.accounts.Account;

public final class azi
{
  final String a;
  final Account b;
  final long c;
  
  public azi(String paramString, Account paramAccount, long paramLong)
  {
    a = paramString;
    b = paramAccount;
    c = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (azi)paramObject;
    } while ((b.equals(b)) && (c == c) && (a.equals(a)));
    return false;
  }
  
  public final int hashCode()
  {
    return (a.hashCode() * 31 + b.hashCode()) * 31 + (int)(c ^ c >>> 32);
  }
}

/* Location:
 * Qualified Name:     azi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */