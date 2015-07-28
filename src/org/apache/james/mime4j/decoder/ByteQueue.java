package org.apache.james.mime4j.decoder;

public class ByteQueue
{
  private UnboundedFifoByteBuffer buf = new UnboundedFifoByteBuffer();
  private int initialCapacity = -1;
  
  public void clear()
  {
    if (initialCapacity != -1)
    {
      buf = new UnboundedFifoByteBuffer(initialCapacity);
      return;
    }
    buf = new UnboundedFifoByteBuffer();
  }
  
  public int count()
  {
    return buf.size();
  }
  
  public byte dequeue()
  {
    return buf.remove();
  }
  
  public void enqueue(byte paramByte)
  {
    buf.add(paramByte);
  }
}

/* Location:
 * Qualified Name:     org.apache.james.mime4j.decoder.ByteQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */