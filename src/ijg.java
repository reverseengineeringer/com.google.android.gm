import java.util.List;

final class ijg
  implements ihu
{
  final ihu c;
  final ihu d;
  
  ijg(ihu paramihu1, ihu paramihu2)
  {
    c = paramihu1;
    d = paramihu2;
  }
  
  public final String apply(String paramString, List<String> paramList)
  {
    paramString = c.apply(paramString, paramList);
    if (paramString != null) {
      return d.apply(paramString, paramList);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     ijg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */