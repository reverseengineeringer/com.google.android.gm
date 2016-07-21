import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;

final class cal
  extends caj
{
  private final CharSequence c;
  
  public cal(cah paramcah, CharSequence paramCharSequence, String paramString)
  {
    super(paramcah, paramString);
    c = paramCharSequence;
  }
  
  public final boolean a()
  {
    ((ClipboardManager)b.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, c));
    return true;
  }
}

/* Location:
 * Qualified Name:     cal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */