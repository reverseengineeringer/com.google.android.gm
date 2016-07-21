import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.android.ex.editstyledtext.EditStyledText;
import com.android.ex.editstyledtext.EditStyledText.SoftKeyReceiver;
import java.util.ArrayList;
import java.util.Iterator;

public final class bld
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public BackgroundColorSpan m;
  public EditStyledText n;
  public bkv o;
  public EditStyledText.SoftKeyReceiver p;
  public SpannableStringBuilder q;
  
  public static int a(Editable paramEditable, int paramInt)
  {
    int i1 = paramInt;
    while ((i1 > 0) && (paramEditable.charAt(i1 - 1) != '\n')) {
      i1 -= 1;
    }
    int i2 = paramEditable.length();
    new StringBuilder(53).append("--- findLineStart:").append(paramInt).append(",").append(i2).append(",").append(i1);
    return i1;
  }
  
  private static int b(Editable paramEditable, int paramInt)
  {
    int i1 = paramInt;
    for (;;)
    {
      int i2 = i1;
      if (i1 < paramEditable.length())
      {
        if (paramEditable.charAt(i1) == '\n') {
          i2 = i1 + 1;
        }
      }
      else
      {
        i1 = paramEditable.length();
        new StringBuilder(51).append("--- findLineEnd:").append(paramInt).append(",").append(i1).append(",").append(i2);
        return i2;
      }
      i1 += 1;
    }
  }
  
  public final void a()
  {
    if ((g == 1) || (g == 2))
    {
      o.b(5);
      Object localObject = n;
      if (a != null)
      {
        localObject = a.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Iterator)localObject).next();
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((!n.isFocused()) || (b)) {}
    do
    {
      return;
      p.a = Selection.getSelectionStart(n.getText());
      p.b = Selection.getSelectionEnd(n.getText());
    } while ((!((InputMethodManager)r.getContext().getSystemService("input_method")).showSoftInput(n, 0, p)) || (p == null));
    Selection.setSelection(r.getText(), paramInt1, paramInt2);
  }
  
  public final void a(Editable paramEditable, int paramInt1, int paramInt2, int paramInt3)
  {
    new StringBuilder(54).append("updateSpanPrevious:").append(paramInt1).append(",").append(paramInt2).append(",").append(paramInt3);
    int i4 = paramInt1 + paramInt3;
    int i1 = Math.min(paramInt1, i4);
    int i2 = Math.max(paramInt1, i4);
    Object[] arrayOfObject = paramEditable.getSpans(i1, i1, Object.class);
    int i5 = arrayOfObject.length;
    i1 = 0;
    Object localObject;
    int i6;
    int i3;
    if (i1 < i5)
    {
      localObject = arrayOfObject[i1];
      if (((localObject instanceof ForegroundColorSpan)) || ((localObject instanceof AbsoluteSizeSpan)) || ((localObject instanceof blb)) || ((localObject instanceof AlignmentSpan)))
      {
        i6 = paramEditable.getSpanStart(localObject);
        i3 = paramEditable.getSpanEnd(localObject);
        String str = String.valueOf(localObject.getClass());
        new StringBuilder(String.valueOf(str).length() + 21).append("spantype:").append(str).append(",").append(i6);
        if (((localObject instanceof blb)) || ((localObject instanceof AlignmentSpan))) {
          paramInt1 = b(n.getText(), i2);
        }
      }
    }
    for (;;)
    {
      label226:
      if (i3 < paramInt1) {
        paramEditable.setSpan(localObject, i6, paramInt1, 33);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (!c) {
          break label381;
        }
        paramInt1 = i3;
        break label226;
        if ((localObject instanceof bla))
        {
          paramInt1 = paramEditable.getSpanStart(localObject);
          i3 = paramEditable.getSpanEnd(localObject);
          if (paramInt2 > paramInt3)
          {
            paramEditable.replace(paramInt1, i3, "");
            paramEditable.removeSpan(localObject);
          }
          else if ((i3 == i4) && (i4 < paramEditable.length()) && (n.getText().charAt(i4) != '\n'))
          {
            n.getText().insert(i4, "\n");
          }
        }
      }
      return;
      label381:
      paramInt1 = i2;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject;
    if (a)
    {
      localObject = o;
      a11a = null;
      a = 11;
      ((bkv)localObject).b(11);
    }
    if (paramBoolean)
    {
      localObject = n;
      if (a != null)
      {
        localObject = a.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Iterator)localObject).next();
        }
      }
    }
  }
  
  public final void b()
  {
    Editable localEditable = n.getText();
    int i4 = localEditable.length();
    int i3 = n.getWidth();
    bla[] arrayOfbla = (bla[])localEditable.getSpans(0, i4, bla.class);
    int i5 = arrayOfbla.length;
    int i1 = 0;
    Object localObject1;
    if (i1 < i5)
    {
      localObject1 = a;
      if (bkz.b) {
        new StringBuilder(27).append("--- renewBounds:").append(i3);
      }
      if (i3 <= 20) {
        break label393;
      }
    }
    label393:
    for (int i2 = i3 - 20;; i2 = i3)
    {
      a = i2;
      ((bkz)localObject1).setBounds(0, 0, i2, 20);
      i1 += 1;
      break;
      localObject1 = (blb[])localEditable.getSpans(0, i4, blb.class);
      int i6 = localObject1.length;
      i3 = 0;
      if (i3 < i6)
      {
        Object localObject2 = localObject1[i3];
        i4 = n.b.l;
        int i8 = a;
        i5 = Color.alpha(i4);
        i2 = Color.red(i4);
        i1 = Color.green(i4);
        int i7 = Color.blue(i4);
        i4 = i5;
        if (i5 == 0) {
          i4 = 128;
        }
        switch (i8)
        {
        default: 
          Log.e("EditStyledText", "--- getMarqueeColor: got illigal marquee ID.");
          i1 = 16777215;
        }
        for (;;)
        {
          b = i1;
          i3 += 1;
          break;
          if (i2 > 128) {
            i2 /= 2;
          }
          for (;;)
          {
            i1 = Color.argb(i4, i2, i1, i7);
            break;
            i2 = (255 - i2) / 2;
            continue;
            if (i1 > 128) {
              i1 /= 2;
            } else {
              i1 = (255 - i1) / 2;
            }
          }
          i1 = 16777215;
        }
      }
      if (arrayOfbla.length > 0)
      {
        char c1 = localEditable.charAt(0);
        localEditable.replace(0, 1, 1 + c1);
      }
      return;
    }
  }
  
  public final void c()
  {
    if (m != null)
    {
      n.getText().removeSpan(m);
      m = null;
    }
  }
  
  public final void d()
  {
    EditStyledText.a(n.getText());
    int i1 = n.getSelectionStart();
    n.setSelection(i1, i1);
    g = 0;
  }
}

/* Location:
 * Qualified Name:     bld
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */