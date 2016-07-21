import com.android.mail.providers.Folder;

final class cwf
{
  public final com.android.mail.providers.Account a;
  public final Folder b;
  
  public cwf(com.android.mail.providers.Account paramAccount, Folder paramFolder)
  {
    a = paramAccount;
    b = paramFolder;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof cwf)) {}
    do
    {
      return false;
      paramObject = (cwf)paramObject;
    } while ((!a.c().equals(a.c())) || (!b.equals(b)));
    return true;
  }
  
  public final int hashCode()
  {
    return a.c().hashCode() ^ b.hashCode();
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(a.a);
    String str2 = b.d;
    return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + " " + str2;
  }
}

/* Location:
 * Qualified Name:     cwf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */