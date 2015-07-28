package org.apache.james.mime4j.decoder;

class UnboundedFifoByteBuffer
{
  protected byte[] buffer;
  protected int head;
  protected int tail;
  
  public UnboundedFifoByteBuffer()
  {
    this(32);
  }
  
  public UnboundedFifoByteBuffer(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The size must be greater than 0");
    }
    buffer = new byte[paramInt + 1];
    head = 0;
    tail = 0;
  }
  
  public boolean add(byte paramByte)
  {
    if (size() + 1 >= buffer.length)
    {
      byte[] arrayOfByte = new byte[(buffer.length - 1) * 2 + 1];
      int j = 0;
      int i = head;
      while (i != tail)
      {
        arrayOfByte[j] = buffer[i];
        buffer[i] = 0;
        int k = j + 1;
        int m = i + 1;
        i = m;
        j = k;
        if (m == buffer.length)
        {
          i = 0;
          j = k;
        }
      }
      buffer = arrayOfByte;
      head = 0;
      tail = j;
    }
    buffer[tail] = paramByte;
    tail += 1;
    if (tail >= buffer.length) {
      tail = 0;
    }
    return true;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public byte remove()
  {
    if (isEmpty()) {
      throw new IllegalStateException("The buffer is already empty");
    }
    byte b = buffer[head];
    head += 1;
    if (head >= buffer.length) {
      head = 0;
    }
    return b;
  }
  
  public int size()
  {
    if (tail < head) {
      return buffer.length - head + tail;
    }
    return tail - head;
  }
}

/* Location:
 * Qualified Name:     org.apache.james.mime4j.decoder.UnboundedFifoByteBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */