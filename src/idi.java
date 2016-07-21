import java.io.Serializable;

public final class idi
  implements Serializable
{
  private static final long serialVersionUID = 7092611880189329093L;
  
  private final Object readResolve()
  {
    return idh.a;
  }
}

/* Location:
 * Qualified Name:     idi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */