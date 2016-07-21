import java.net.Socket;
import java.security.Principal;
import javax.net.ssl.X509ExtendedKeyManager;

abstract class bhi
  extends X509ExtendedKeyManager
{
  public final String chooseServerAlias(String paramString, Principal[] paramArrayOfPrincipal, Socket paramSocket)
  {
    throw new UnsupportedOperationException();
  }
  
  public final String[] getClientAliases(String paramString, Principal[] paramArrayOfPrincipal)
  {
    throw new UnsupportedOperationException();
  }
  
  public final String[] getServerAliases(String paramString, Principal[] paramArrayOfPrincipal)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     bhi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */