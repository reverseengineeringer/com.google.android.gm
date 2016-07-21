import android.content.Context;

final class dsi
  implements Runnable
{
  dsi(drp paramdrp, Context paramContext) {}
  
  public final void run()
  {
    String[] arrayOfString = a.fileList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.startsWith("gmail"))
      {
        dri.b(drp.b, "Cleaning up old temp file (do we have a leak?): %s", new Object[] { str });
        a.deleteFile(str);
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     dsi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */