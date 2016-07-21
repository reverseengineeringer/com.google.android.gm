import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;

public final class big
{
  public static final String[] a = { "android.permission.READ_CONTACTS" };
  
  public static boolean a(Context paramContext, bih parambih)
  {
    String[] arrayOfString = a;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString[i];
      int j;
      if (Build.VERSION.SDK_INT >= 23)
      {
        j = 1;
        if (j == 0) {
          break label84;
        }
        j = paramContext.checkPermission(str, Process.myPid(), Process.myUid());
        label51:
        if (j != 0) {
          break label89;
        }
      }
      label84:
      label89:
      for (boolean bool = true;; bool = false)
      {
        if (parambih != null) {
          parambih.a(str, bool);
        }
        if (bool) {
          break label95;
        }
        return false;
        j = 0;
        break;
        j = 0;
        break label51;
      }
      label95:
      i += 1;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     big
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */