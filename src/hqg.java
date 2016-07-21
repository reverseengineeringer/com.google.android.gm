import java.io.Serializable;

public class hqg
  implements Serializable
{
  @Deprecated
  private static final long serialVersionUID = 7373984872572414699L;
  @Deprecated
  public final hqi f = new hqh();
  
  public String toString()
  {
    Object localObject = f.c();
    StringBuffer localStringBuffer = new StringBuffer().append(super.toString());
    if (localObject == null) {}
    for (localObject = "[Unlocked]";; localObject = "[Locked by thread " + ((Thread)localObject).getName() + "]") {
      return (String)localObject;
    }
  }
}

/* Location:
 * Qualified Name:     hqg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */