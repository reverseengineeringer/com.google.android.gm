import java.io.IOException;

public final class hlm
  extends IOException
{
  private static final long serialVersionUID = -6947486886997889499L;
  
  hlm(int paramInt1, int paramInt2)
  {
    super(108 + "CodedOutputStream was writing to a flat byte array and ran out of space (pos " + paramInt1 + " limit " + paramInt2 + ").");
  }
}

/* Location:
 * Qualified Name:     hlm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */