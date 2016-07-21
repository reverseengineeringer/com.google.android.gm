import android.content.Context;
import android.text.TextUtils;

public final class bbo
{
  public static int a(bdi parambdi)
  {
    switch (d)
    {
    default: 
      return 0;
    case 5: 
    case 11: 
      return 1;
    }
    return 2;
  }
  
  public static String a(Context paramContext, bdi parambdi)
  {
    Object localObject2 = parambdi.getMessage();
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    int i;
    switch (d)
    {
    case 6: 
    case 7: 
    case 12: 
    case 15: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = arh.Y;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label354;
        }
      }
      break;
    }
    label354:
    for (localObject1 = paramContext.getString(i);; localObject1 = paramContext.getString(i, new Object[] { localObject1 }))
    {
      localObject2 = localObject1;
      if (f != null)
      {
        localObject1 = String.valueOf(localObject1);
        paramContext = String.valueOf(paramContext.getString(arh.aB, new Object[] { f }));
        localObject2 = String.valueOf(localObject1).length() + 1 + String.valueOf(paramContext).length() + (String)localObject1 + " " + paramContext;
      }
      return (String)localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = arh.V;
        break;
      }
      i = arh.W;
      break;
      i = arh.U;
      break;
      i = arh.u;
      break;
      i = arh.T;
      break;
      i = arh.ab;
      break;
      i = arh.ag;
      break;
      i = arh.Q;
      break;
      return bbn.a(paramContext, (String[])e);
      i = arh.P;
      break;
      i = arh.ac;
      break;
      i = arh.ad;
      break;
      i = arh.S;
      break;
      i = arh.R;
      break;
      i = arh.af;
      break;
      i = arh.Z;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     bbo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */