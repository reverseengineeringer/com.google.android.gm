import java.security.Provider;

class gnl
  extends Provider
{
  public gnl()
  {
    super("LinuxPRNG", 1.0D, "A Linux-specific random number provider that uses /dev/urandom");
    put("SecureRandom.SHA1PRNG", gnk.class.getName());
    put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
  }
}

/* Location:
 * Qualified Name:     gnl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */