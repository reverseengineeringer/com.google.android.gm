import java.util.TreeSet;

public final class ime
  extends imw
{
  private static final long serialVersionUID = -5165065768816265385L;
  private imj a;
  private inz b;
  
  final imw a()
  {
    return new ime();
  }
  
  final void a(ikr paramikr)
  {
    a = new imj(paramikr);
    b = new inz(paramikr);
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    a.a(paramikt, null, false);
    b.a(paramikt);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    if (!b.a.isEmpty())
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(b.toString());
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */