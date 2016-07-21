import android.text.SpanWatcher;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.inputmethod.BaseInputConnection;

final class cbh
{
  final String a;
  final Spanned b;
  final cbi c;
  
  public cbh(cbi paramcbi, Spanned paramSpanned) {}
  
  public cbh(String paramString) {}
  
  private cbh(String paramString, cbi paramcbi, Spanned paramSpanned)
  {
    if ((paramString != null) && (paramSpanned != null)) {
      throw new IllegalArgumentException("Only one body allowed");
    }
    if ((paramSpanned != null) && (paramcbi == null)) {
      throw new IllegalArgumentException("SpannedToHtmlConverter required for Spanned body");
    }
    a = paramString;
    if (paramSpanned == null) {
      paramString = null;
    }
    for (;;)
    {
      b = paramString;
      c = paramcbi;
      return;
      paramString = new SpannableString(paramSpanned);
      BaseInputConnection.removeComposingSpans(paramString);
      a(paramString, SpanWatcher.class);
      a(paramString, TextWatcher.class);
    }
  }
  
  private static void a(SpannableString paramSpannableString, Class<?> paramClass)
  {
    int i = 0;
    paramClass = paramSpannableString.getSpans(0, paramSpannableString.length(), paramClass);
    int j = paramClass.length;
    while (i < j)
    {
      paramSpannableString.removeSpan(paramClass[i]);
      i += 1;
    }
  }
  
  public final String toString()
  {
    if (b != null) {
      return b.toString();
    }
    return a;
  }
}

/* Location:
 * Qualified Name:     cbh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */