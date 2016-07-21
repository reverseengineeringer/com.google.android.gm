import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ijw
  extends imw
{
  private static final long serialVersionUID = -1348173791712935864L;
  private List a;
  
  static boolean a(int paramInt1, int paramInt2)
  {
    return b(paramInt1, paramInt2);
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 >= 256)) {}
    while (((paramInt1 == 1) && (paramInt2 > 32)) || ((paramInt1 == 2) && (paramInt2 > 128))) {
      return false;
    }
    return true;
  }
  
  final imw a()
  {
    return new ijw();
  }
  
  final void a(ikr paramikr)
  {
    a = new ArrayList(1);
    if (paramikr.a() != 0)
    {
      int j = paramikr.c();
      int i = paramikr.b();
      int k = paramikr.b();
      if ((k & 0x80) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = paramikr.b(k & 0xFF7F);
        if (b(j, i)) {
          break;
        }
        throw new iog("invalid prefix length");
      }
      if ((j == 1) || (j == 2))
      {
        j = ijz.a(j);
        if (localObject.length > j) {
          throw new iog("invalid address length");
        }
        if (localObject.length != j) {}
      }
      label122:
      for (Object localObject = new ijx(bool, InetAddress.getByAddress((byte[])localObject), i);; localObject = new ijx(j, bool, localObject, i, (byte)0))
      {
        a.add(localObject);
        break;
        byte[] arrayOfByte = new byte[j];
        System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
        localObject = arrayOfByte;
        break label122;
      }
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    Iterator localIterator = a.iterator();
    ijx localijx;
    int i;
    if (localIterator.hasNext())
    {
      localijx = (ijx)localIterator.next();
      if ((a == 1) || (a == 2))
      {
        paramikk = ((InetAddress)d).getAddress();
        i = paramikk.length - 1;
        label69:
        if (i >= 0) {
          if (paramikk[i] != 0)
          {
            i += 1;
            label87:
            if (!b) {
              break label170;
            }
          }
        }
      }
    }
    label170:
    for (int j = i | 0x80;; j = i)
    {
      paramikt.b(a);
      paramikt.a(c);
      paramikt.a(j);
      paramikt.a(paramikk, 0, i);
      break;
      i -= 1;
      break label69;
      i = 0;
      break label87;
      paramikk = (byte[])d;
      i = paramikk.length;
      break label87;
      return;
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append((ijx)localIterator.next());
      if (localIterator.hasNext()) {
        localStringBuffer.append(" ");
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ijw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */