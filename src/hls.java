import java.io.IOException;

public final class hls
  extends IOException
{
  private static final long serialVersionUID = -1616151763072450476L;
  
  public hls(String paramString)
  {
    super(paramString);
  }
  
  static hls a()
  {
    return new hls("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static hls b()
  {
    return new hls("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  public static hls c()
  {
    return new hls("CodedInputStream encountered a malformed varint.");
  }
  
  static hls d()
  {
    return new hls("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}

/* Location:
 * Qualified Name:     hls
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */