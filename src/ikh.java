import java.io.PrintStream;
import java.net.SocketTimeoutException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

class ikh
{
  private static imq c = null;
  public long a;
  public SelectionKey b;
  
  protected ikh(SelectableChannel paramSelectableChannel, long paramLong)
  {
    Object localObject1 = null;
    a = paramLong;
    try
    {
      Selector localSelector = Selector.open();
      localObject1 = localSelector;
      paramSelectableChannel.configureBlocking(false);
      localObject1 = localSelector;
      b = paramSelectableChannel.register(localSelector, 1);
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((Selector)localObject1).close();
      }
      paramSelectableChannel.close();
    }
  }
  
  protected static void a(String paramString, byte[] paramArrayOfByte)
  {
    if (imn.a("verbosemsg")) {
      System.err.println(ior.a(paramString, paramArrayOfByte));
    }
  }
  
  protected static void a(SelectionKey paramSelectionKey, long paramLong)
  {
    paramLong -= System.currentTimeMillis();
    int i = 0;
    if (paramLong > 0L) {
      i = paramSelectionKey.selector().select(paramLong);
    }
    while (i == 0)
    {
      throw new SocketTimeoutException();
      if (paramLong == 0L) {
        i = paramSelectionKey.selector().selectNow();
      }
    }
  }
  
  final void a()
  {
    b.selector().close();
    b.channel().close();
  }
}

/* Location:
 * Qualified Name:     ikh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */