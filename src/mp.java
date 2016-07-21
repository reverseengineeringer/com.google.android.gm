import android.content.Context;
import android.net.Uri;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintManager;

final class mp
  implements mr
{
  private final ms a;
  
  mp(Context paramContext)
  {
    a = new ms(paramContext);
  }
  
  public final void a(int paramInt)
  {
    a.d = 1;
  }
  
  public final void a(String paramString, Uri paramUri)
  {
    ms localms = a;
    paramUri = new mt(localms, paramString, paramUri, null, d);
    PrintManager localPrintManager = (PrintManager)a.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(e);
    if (f == 1) {
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    for (;;)
    {
      localPrintManager.print(paramString, paramUri, localBuilder.build());
      return;
      if (f == 2) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
  }
}

/* Location:
 * Qualified Name:     mp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */