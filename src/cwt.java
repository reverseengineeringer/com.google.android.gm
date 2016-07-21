import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.URLSpan;
import android.view.View.OnClickListener;
import com.android.mail.text.NoUnderlineUrlSpan;

public final class cwt
{
  public static SpannableString a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    int i = paramString1.indexOf(paramString2);
    paramString1 = new SpannableString(paramString1);
    if (i >= 0) {
      paramString1.setSpan(new TextAppearanceSpan(paramContext, paramInt), i, paramString2.length() + i, 0);
    }
    return paramString1;
  }
  
  public static SpannableString a(String paramString, mx parammx)
  {
    paramString = new SpannableString(parammx.a(paramString));
    paramString.setSpan(new StyleSpan(1), 0, paramString.length(), 33);
    return paramString;
  }
  
  public static void a(Spannable paramSpannable)
  {
    int i = 0;
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    int j = arrayOfURLSpan.length;
    while (i < j)
    {
      URLSpan localURLSpan = arrayOfURLSpan[i];
      int k = paramSpannable.getSpanStart(localURLSpan);
      int m = paramSpannable.getSpanEnd(localURLSpan);
      paramSpannable.removeSpan(localURLSpan);
      paramSpannable.setSpan(new NoUnderlineUrlSpan(localURLSpan.getURL()), k, m, 33);
      i += 1;
    }
  }
  
  public static void a(Spannable paramSpannable, View.OnClickListener paramOnClickListener)
  {
    int i = 0;
    paramOnClickListener = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    int j = paramOnClickListener.length;
    while (i < j)
    {
      Object localObject = paramOnClickListener[i];
      int k = paramSpannable.getSpanStart(localObject);
      int m = paramSpannable.getSpanEnd(localObject);
      paramSpannable.removeSpan(localObject);
      paramSpannable.setSpan(new chp(null), k, m, 33);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     cwt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */