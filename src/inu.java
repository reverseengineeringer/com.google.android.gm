import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class inu
  extends imw
{
  private static final long serialVersionUID = -4319510507246305931L;
  public List a;
  
  final void a(ikr paramikr)
  {
    a = new ArrayList(2);
    while (paramikr.a() > 0)
    {
      byte[] arrayOfByte = paramikr.f();
      a.add(arrayOfByte);
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikk = a.iterator();
    while (paramikk.hasNext()) {
      paramikt.b((byte[])paramikk.next());
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(a((byte[])localIterator.next(), true));
      if (localIterator.hasNext()) {
        localStringBuffer.append(" ");
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     inu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */