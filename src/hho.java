import java.util.Map.Entry;

 enum hho
{
  hho() {}
  
  public final Object apply(Map.Entry<?, ?> paramEntry)
  {
    return paramEntry.getKey();
  }
}

/* Location:
 * Qualified Name:     hho
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */