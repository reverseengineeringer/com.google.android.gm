import java.util.Map.Entry;

 enum hhp
{
  hhp() {}
  
  public final Object apply(Map.Entry<?, ?> paramEntry)
  {
    return paramEntry.getValue();
  }
}

/* Location:
 * Qualified Name:     hhp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */