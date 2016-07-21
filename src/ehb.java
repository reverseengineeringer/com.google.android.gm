import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.widget.ImageView;

public final class ehb
  extends bim
{
  public ehb(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    super(paramLayoutInflater, paramContext);
  }
  
  private static SpannableStringBuilder a(CharSequence paramCharSequence, eha[] paramArrayOfeha)
  {
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int j = paramArrayOfeha.length;
    int i = 0;
    while (i < j)
    {
      eha localeha = paramArrayOfeha[i];
      StyleSpan localStyleSpan = new StyleSpan(3);
      int k = localeha.a();
      int m = localeha.a();
      paramCharSequence.setSpan(localStyleSpan, k, localeha.b() + m, 33);
      i += 1;
    }
    return paramCharSequence;
  }
  
  protected final void a(boolean paramBoolean, bkn parambkn, ImageView paramImageView, int paramInt)
  {
    if ((paramInt == biq.c) && (paramBoolean))
    {
      parambkn = parambkn.a();
      if ((parambkn != null) && (parambkn.length > 0))
      {
        paramImageView.setImageBitmap(BitmapFactory.decodeByteArray(parambkn, 0, parambkn.length));
        return;
      }
      paramImageView.setImageResource(bje.b);
      return;
    }
    super.a(paramBoolean, parambkn, paramImageView, paramInt);
  }
  
  protected final CharSequence[] a(String paramString, bkn parambkn)
  {
    int k = 0;
    if (!(parambkn instanceof ehh))
    {
      paramString = super.a(paramString, parambkn);
      return paramString;
    }
    egw localegw = r;
    if (localegw == null) {
      return super.a(paramString, parambkn);
    }
    CharSequence[] arrayOfCharSequence = new CharSequence[2];
    paramString = localegw.a();
    int j = paramString.length;
    int i = 0;
    label60:
    if (i < j)
    {
      Object localObject = paramString[i];
      if (((egx)localObject).a() == 1) {
        arrayOfCharSequence[0] = a(((egx)localObject).b(), ((egx)localObject).c());
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        arrayOfCharSequence[0] = c;
      }
      paramString = localegw.a();
      int m = paramString.length;
      i = 0;
      for (;;)
      {
        j = k;
        if (i < m)
        {
          localegw = paramString[i];
          if (localegw.a() == 2)
          {
            arrayOfCharSequence[1] = a(localegw.b(), localegw.c());
            j = 1;
          }
        }
        else
        {
          paramString = arrayOfCharSequence;
          if (j != 0) {
            break;
          }
          arrayOfCharSequence[1] = d;
          return arrayOfCharSequence;
          i += 1;
          break label60;
        }
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     ehb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */