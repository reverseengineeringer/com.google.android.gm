import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.util.Rfc822Token;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class bim
{
  public bir a;
  public bis b;
  public bja c;
  private final LayoutInflater d;
  private final Context e;
  private int f;
  
  public bim(LayoutInflater paramLayoutInflater, Context paramContext)
  {
    d = paramLayoutInflater;
    e = paramContext;
    f = paramContext.getResources().getDimensionPixelOffset(bjd.f);
  }
  
  private static void a(View paramView, int paramInt)
  {
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
  }
  
  private static void a(CharSequence paramCharSequence, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramCharSequence != null)
    {
      paramTextView.setText(paramCharSequence);
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  protected static int b(int paramInt)
  {
    switch (bip.a[(paramInt - 1)])
    {
    default: 
      return bjh.b;
    case 1: 
      return bjh.a;
    }
    return bjh.b;
  }
  
  private static int c(int paramInt)
  {
    switch (bip.a[(paramInt - 1)])
    {
    default: 
      return bjh.b;
    case 1: 
      return bjh.a;
    }
    return bjh.b;
  }
  
  public final View a(int paramInt)
  {
    return d.inflate(c(paramInt), null);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, bkn parambkn, int paramInt1, int paramInt2, String paramString, StateListDrawable paramStateListDrawable)
  {
    paramString = a(paramString, parambkn);
    CharSequence localCharSequence = paramString[0];
    paramString = paramString[1];
    boolean bool2 = true;
    boolean bool1 = true;
    String str = c.a(e.getResources(), e, f).toString().toUpperCase();
    int j = c(paramInt2);
    int i = j;
    switch (bip.a[(paramInt2 - 1)])
    {
    default: 
      i = j;
    case 1: 
    case 2: 
      label108:
      if (paramView == null) {
        break;
      }
    }
    bit localbit;
    for (View localView = paramView;; localView = d.inflate(i, paramViewGroup, false))
    {
      localbit = new bit(this, localView);
      switch (bip.a[(paramInt2 - 1)])
      {
      default: 
        paramViewGroup = paramString;
        paramView = str;
        paramString = localCharSequence;
        label170:
        a(paramString, b);
        a(paramViewGroup, c);
        a(paramView, d);
        a(bool1, parambkn, f, paramInt2);
        paramView = c;
        paramViewGroup = g;
        if (paramViewGroup != null)
        {
          if (paramStateListDrawable != null) {
            break label588;
          }
          paramViewGroup.setVisibility(8);
        }
        label238:
        paramInt1 = l;
        paramView = m;
        paramViewGroup = e;
        if (paramViewGroup != null)
        {
          if ((paramView == null) && (paramInt1 == 0)) {
            break label652;
          }
          paramViewGroup.setText(paramView);
          paramViewGroup.setVisibility(0);
          if (paramInt1 == 0) {
            break label647;
          }
          paramView = e.getDrawable(paramInt1).mutate();
          paramView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
          label304:
          paramViewGroup.setCompoundDrawablesRelativeWithIntrinsicBounds(paramView, null, null, null);
        }
        label312:
        paramView = l;
        if (paramView != null) {
          paramView.setOnClickListener(new bio(this));
        }
        paramInt1 = a;
        if (paramInt1 != 0) {
          break label661;
        }
        a(a, 0);
        a(k, 8);
        a(j, 8);
        label374:
        return localView;
        i = b(paramInt2);
        break label108;
      }
    }
    if ((TextUtils.isEmpty(localCharSequence)) || (TextUtils.equals(localCharSequence, paramString))) {
      if (b) {
        paramViewGroup = null;
      }
    }
    for (;;)
    {
      if (!b) {
        paramString = null;
      }
      for (bool1 = false;; bool1 = bool2)
      {
        if (h != null)
        {
          paramView = h;
          if (paramInt1 != 0) {
            break label521;
          }
        }
        label521:
        for (paramInt1 = 0;; paramInt1 = 8)
        {
          paramView.setVisibility(paramInt1);
          qa.a((ViewGroup.MarginLayoutParams)h.getLayoutParams(), f);
          if (i == null) {
            break label698;
          }
          qa.a((ViewGroup.MarginLayoutParams)i.getLayoutParams(), f);
          paramView = str;
          break;
        }
        if (paramInt1 == 0) {
          break;
        }
        bool1 = false;
        localCharSequence = null;
        paramViewGroup = paramString;
        paramView = str;
        paramString = localCharSequence;
        break label170;
        if (!biu.a(d)) {
          paramString = android.text.util.Rfc822Tokenizer.tokenize(d)[0].getAddress();
        }
        paramViewGroup = paramString;
        paramView = null;
        paramString = localCharSequence;
        break label170;
        label588:
        paramString = e.getResources();
        paramViewGroup.setImageDrawable(paramStateListDrawable);
        paramViewGroup.setContentDescription(paramString.getString(bji.f, new Object[] { paramView }));
        if (a == null) {
          break label238;
        }
        paramViewGroup.setOnClickListener(new bin(this, paramStateListDrawable));
        break label238;
        label647:
        paramView = null;
        break label304;
        label652:
        paramViewGroup.setVisibility(8);
        break label312;
        label661:
        if (paramInt1 != 1) {
          break label374;
        }
        a(a, 8);
        a(k, 0);
        a(j, 0);
        return localView;
        label698:
        paramView = str;
        break label170;
      }
      paramViewGroup = paramString;
      continue;
      paramViewGroup = paramString;
      paramString = localCharSequence;
    }
  }
  
  public void a(boolean paramBoolean, bkn parambkn, ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      switch (bip.a[(paramInt - 1)])
      {
      }
      for (;;)
      {
        paramImageView.setVisibility(0);
        return;
        parambkn = parambkn.a();
        if ((parambkn != null) && (parambkn.length > 0))
        {
          paramImageView.setImageBitmap(BitmapFactory.decodeByteArray(parambkn, 0, parambkn.length));
        }
        else
        {
          paramImageView.setImageResource(bje.b);
          continue;
          parambkn = j;
          if (parambkn != null) {
            paramImageView.setImageURI(parambkn);
          } else {
            paramImageView.setImageResource(bje.b);
          }
        }
      }
    }
    paramImageView.setVisibility(8);
  }
  
  public CharSequence[] a(String paramString, bkn parambkn)
  {
    int j = 0;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = c;
    arrayOfString[1] = d;
    if (!TextUtils.isEmpty(paramString))
    {
      i = 0;
      if (i < paramString.length()) {
        if (Character.isWhitespace(paramString.charAt(i))) {}
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label74;
      }
      return arrayOfString;
      i += 1;
      break;
    }
    label74:
    parambkn = new CharSequence[2];
    int k = 0;
    i = j;
    j = k;
    if (i < 2)
    {
      Object localObject = arrayOfString[i];
      k = j;
      if (localObject != null)
      {
        if (j != 0) {
          break label196;
        }
        k = ((String)localObject).toLowerCase().indexOf(paramString.toLowerCase());
        if (k == -1) {
          break label196;
        }
        localObject = SpannableStringBuilder.valueOf((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(e.getResources().getColor(bjc.c)), k, paramString.length() + k, 33);
        parambkn[i] = localObject;
      }
      for (k = 1;; k = j)
      {
        i += 1;
        j = k;
        break;
        label196:
        parambkn[i] = localObject;
      }
    }
    return parambkn;
  }
}

/* Location:
 * Qualified Name:     bim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */