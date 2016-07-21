import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

final class grp
{
  final gti a;
  final StringBuilder b;
  final gtr c;
  final List<Type> d;
  
  public grp(grn paramgrn, StringBuilder paramStringBuilder)
  {
    Class localClass = paramgrn.getClass();
    d = Arrays.asList(new Type[] { localClass });
    c = gtr.a(localClass, true);
    b = paramStringBuilder;
    a = new gti(paramgrn);
  }
}

/* Location:
 * Qualified Name:     grp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */