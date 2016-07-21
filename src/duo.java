import android.content.Context;
import android.content.res.Resources;
import java.util.Arrays;
import java.util.List;

final class duo
{
  public static String[] a(Context paramContext, String... paramVarArgs)
  {
    paramContext = paramContext.getResources();
    paramContext = hgd.a(new String[] { paramContext.getString(dge.dY), paramContext.getString(dge.dX), paramContext.getString(dge.dD), paramContext.getString(dge.dA), paramContext.getString(dge.dy), paramContext.getString(dge.dx), paramContext.getString(dge.ed), paramContext.getString(dge.ec), paramContext.getString(dge.ea), paramContext.getString(dge.eb), paramContext.getString(dge.dB), paramContext.getString(dge.dC), paramContext.getString(dge.dJ), paramContext.getString(dge.dG), paramContext.getString(dge.dI), paramContext.getString(dge.dH), paramContext.getString(dge.dF), paramContext.getString(dge.dE) });
    paramContext.addAll(Arrays.asList(paramVarArgs));
    return (String[])paramContext.toArray(new String[paramContext.size()]);
  }
  
  public static String[] a(Context paramContext, String[] paramArrayOfString1, String paramString, String... paramVarArgs)
  {
    int k = 0;
    int i;
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length == 0))
    {
      i = 1;
      paramArrayOfString1 = paramVarArgs;
      if (i != 0) {
        paramArrayOfString1 = a(paramContext, paramVarArgs);
      }
      return paramArrayOfString1;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= paramArrayOfString1.length) {
        break;
      }
      if (paramString.equals(paramArrayOfString1[j]))
      {
        i = 1;
        break;
      }
      j += 1;
    }
  }
}

/* Location:
 * Qualified Name:     duo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */