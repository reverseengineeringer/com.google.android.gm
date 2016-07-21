import java.io.InputStream;

public class iei
  extends InputStream
{
  private static idy c = new idy();
  ieg a = new ieg();
  ieg b = new ieg();
  private InputStream d;
  private byte e = 0;
  
  public iei(InputStream paramInputStream)
  {
    d = paramInputStream;
  }
  
  private static byte a(byte paramByte)
  {
    if ((paramByte >= 48) && (paramByte <= 57)) {
      return (byte)(paramByte - 48);
    }
    if ((paramByte >= 65) && (paramByte <= 90)) {
      return (byte)(paramByte - 65 + 10);
    }
    if ((paramByte >= 97) && (paramByte <= 122)) {
      return (byte)(paramByte - 97 + 10);
    }
    char c1 = (char)paramByte;
    throw new IllegalArgumentException(28 + c1 + " is not a hexadecimal digit");
  }
  
  public void close()
  {
    d.close();
  }
  
  public int read()
  {
    byte b1 = 0;
    label2:
    label41:
    int i;
    int j;
    while (a.a.a() == 0)
    {
      if (b.a.a() == 0) {
        if (b.a.a() == 0)
        {
          i = d.read();
          switch (i)
          {
          default: 
            b.a((byte)i);
          }
        }
      }
      byte b2;
      for (;;)
      {
        if (b.a.a() == 0) {
          break label636;
        }
        b2 = b.a();
        switch (e)
        {
        default: 
          i = e;
          idy.b(19 + "Illegal state: " + i);
          e = 0;
          a.a(b2);
          break label2;
          b.b();
          continue;
          b.a((byte)i);
          break label41;
          b.b();
          b.a((byte)i);
        }
      }
      if (b2 != 61)
      {
        a.a(b2);
      }
      else
      {
        e = 1;
        continue;
        if (b2 == 13)
        {
          e = 2;
        }
        else if (((b2 >= 48) && (b2 <= 57)) || ((b2 >= 65) && (b2 <= 70)) || ((b2 >= 97) && (b2 <= 102)))
        {
          e = 3;
          b1 = b2;
        }
        else if (b2 == 61)
        {
          idy.b();
          idy.a("Malformed MIME; got ==");
          a.a((byte)61);
        }
        else
        {
          idy.b();
          idy.a(49 + "Malformed MIME; expected \\r or [0-9A-Z], got " + b2);
          e = 0;
          a.a((byte)61);
          a.a(b2);
          continue;
          if (b2 == 10)
          {
            e = 0;
          }
          else
          {
            idy.b();
            String str = String.valueOf("Malformed MIME; expected 10, got ");
            idy.a(String.valueOf(str).length() + 4 + str + b2);
            e = 0;
            a.a((byte)61);
            a.a((byte)13);
            a.a(b2);
            continue;
            if (((b2 >= 48) && (b2 <= 57)) || ((b2 >= 65) && (b2 <= 70)) || ((b2 >= 97) && (b2 <= 102)))
            {
              i = a(b1);
              j = a(b2);
              e = 0;
              a.a((byte)(j | i << 4));
            }
            else
            {
              idy.b();
              idy.a(43 + "Malformed MIME; expected [0-9A-Z], got " + b2);
              e = 0;
              a.a((byte)61);
              a.a(b1);
              a.a(b2);
            }
          }
        }
      }
    }
    label636:
    if (a.a.a() == 0) {
      i = -1;
    }
    do
    {
      return i;
      j = a.a();
      i = j;
    } while (j >= 0);
    return j & 0xFF;
  }
}

/* Location:
 * Qualified Name:     iei
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */