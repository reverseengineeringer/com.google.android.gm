import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

public final class cxk
{
  static int a;
  static int b;
  static int c;
  static int d;
  static int e;
  cxl f;
  
  public cxk(Context paramContext)
  {
    paramContext = paramContext.getResources();
    a = paramContext.getColor(btz.Q);
    b = paramContext.getColor(btz.R);
    c = paramContext.getColor(btz.M);
    d = paramContext.getColor(btz.k);
    e = paramContext.getColor(btz.l);
  }
  
  static SpannableStringBuilder a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(paramInt1), 0, paramCharSequence.length(), 33);
    if (paramInt2 != 0) {
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt2), 0, paramCharSequence.length(), 33);
    }
    return localSpannableStringBuilder;
  }
}

/* Location:
 * Qualified Name:     cxk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */