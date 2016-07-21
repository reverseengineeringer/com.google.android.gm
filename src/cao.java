import android.app.Activity;
import android.content.Intent;

final class cao
  extends can
{
  public cao(cah paramcah, String paramString1, String paramString2)
  {
    super(paramcah, paramString2);
    paramString2 = new Intent("android.intent.action.SEND");
    paramString2.setType("text/plain");
    paramString2.putExtra("android.intent.extra.TEXT", paramString1);
    paramcah = a;
    int i = cam.c;
    switch (cai.a[(i - 1)])
    {
    default: 
      throw new IllegalStateException("Unexpected MenuType");
    }
    b = Intent.createChooser(paramString2, paramcah.getText(buj.af));
  }
}

/* Location:
 * Qualified Name:     cao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */