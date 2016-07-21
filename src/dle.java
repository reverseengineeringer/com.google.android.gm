final class dle<R extends hlt>
{
  final R a;
  final Exception b;
  
  dle(R paramR)
  {
    a = paramR;
    b = null;
  }
  
  dle(Exception paramException)
  {
    a = null;
    b = paramException;
  }
}

/* Location:
 * Qualified Name:     dle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */