import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import com.google.android.apps.work.common.richedittext.RichEditText;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class dcq
  extends BaseInputConnection
{
  private final RichEditText a;
  private final InputConnection b;
  private int c = 0;
  private Map<Object, int[]> d;
  private boolean e = false;
  private dcl f = null;
  private dcl g = null;
  
  public dcq(RichEditText paramRichEditText, InputConnection paramInputConnection)
  {
    super(paramRichEditText, true);
    a = paramRichEditText;
    b = paramInputConnection;
  }
  
  private static dcl a(Editable paramEditable)
  {
    int i = getComposingSpanStart(paramEditable);
    int j = getComposingSpanEnd(paramEditable);
    int k;
    if (j < i) {
      k = j;
    }
    for (;;)
    {
      if (k != -1)
      {
        j = i;
        if (i != -1) {}
      }
      else
      {
        j = Selection.getSelectionStart(paramEditable);
        k = Selection.getSelectionEnd(paramEditable);
        i = j;
        if (j < 0) {
          i = 0;
        }
        j = k;
        if (k < 0) {
          j = 0;
        }
        if (j >= i) {
          break label74;
        }
        k = j;
        j = i;
      }
      for (;;)
      {
        return new dcl(k, j);
        label74:
        k = i;
      }
      k = i;
      i = j;
    }
  }
  
  private final boolean a()
  {
    return c > 0;
  }
  
  private final void b()
  {
    Editable localEditable = getEditable();
    int k = f.a;
    int m = f.b;
    d = new HashMap();
    Object[] arrayOfObject = localEditable.getSpans(0, localEditable.length(), Object.class);
    int n = arrayOfObject.length;
    int i = 0;
    if (i < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = localEditable.getSpanFlags(localObject);
      int i2;
      int i3;
      if (((i1 & 0x100) != 256) && (ddd.a(localObject)))
      {
        i2 = localEditable.getSpanStart(localObject);
        i3 = localEditable.getSpanEnd(localObject);
      }
      int j;
      switch (ddd.a(k, m, i2, i3))
      {
      case 2: 
      case 3: 
      default: 
      case 4: 
        label166:
        do
        {
          j = 0;
          if (j != 0) {
            d.put(localObject, new int[] { i2, i3, i1 });
          }
          i += 1;
          break;
        } while ((!(localObject instanceof CharacterStyle)) && ((!(localObject instanceof ParagraphStyle)) || ((i1 & 0x33) != 51) || (i2 != k) || (i3 != m) || (m != localEditable.length())));
      }
      for (;;)
      {
        j = 1;
        break label166;
        if ((localObject instanceof ParagraphStyle)) {
          if ((i1 & 0x33) == 51) {
            break;
          }
        }
      }
    }
  }
  
  private final void c()
  {
    Editable localEditable = getEditable();
    int i = g.a;
    int j = g.b;
    Iterator localIterator = d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getKey();
      int k = ((int[])localEntry.getValue())[0];
      int m = ((int[])localEntry.getValue())[1];
      int n = ((int[])localEntry.getValue())[2];
      switch (ddd.a(i, j, k, m))
      {
      default: 
        localEditable.removeSpan(localObject);
        break;
      case 2: 
      case 3: 
        localEditable.setSpan(localObject, k, j, n);
        break;
      case 1: 
      case 4: 
        if (m == f.b) {
          localEditable.setSpan(localObject, k, j, n);
        } else {
          localEditable.setSpan(localObject, k, m, n);
        }
        break;
      }
    }
    localEditable = getEditable();
    a.onTextChanged(localEditable, f.a, f.a(), g.a());
    a.onSelectionChanged(Selection.getSelectionStart(localEditable), Selection.getSelectionEnd(localEditable));
  }
  
  public final boolean beginBatchEdit()
  {
    c += 1;
    return b.beginBatchEdit();
  }
  
  public final boolean clearMetaKeyStates(int paramInt)
  {
    return b.clearMetaKeyStates(paramInt);
  }
  
  public final boolean commitCompletion(CompletionInfo paramCompletionInfo)
  {
    return b.commitCompletion(paramCompletionInfo);
  }
  
  public final boolean commitCorrection(CorrectionInfo paramCorrectionInfo)
  {
    return b.commitCorrection(paramCorrectionInfo);
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    Editable localEditable = getEditable();
    if (!e)
    {
      e = true;
      f = a(localEditable);
      g = a(localEditable);
      b();
    }
    a.g = true;
    boolean bool = b.commitText(paramCharSequence, paramInt);
    a.g = false;
    g.b = ab;
    if ((!a()) && (e))
    {
      c();
      e = false;
    }
    return bool;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    return b.deleteSurroundingText(paramInt1, paramInt2);
  }
  
  public final boolean endBatchEdit()
  {
    c -= 1;
    if ((c == 0) && (e))
    {
      c();
      e = false;
    }
    return b.endBatchEdit();
  }
  
  public final boolean finishComposingText()
  {
    return b.finishComposingText();
  }
  
  public final int getCursorCapsMode(int paramInt)
  {
    return b.getCursorCapsMode(paramInt);
  }
  
  public final Editable getEditable()
  {
    if (a != null) {
      return a.getEditableText();
    }
    return null;
  }
  
  public final ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    return b.getExtractedText(paramExtractedTextRequest, paramInt);
  }
  
  public final CharSequence getSelectedText(int paramInt)
  {
    return b.getSelectedText(paramInt);
  }
  
  public final CharSequence getTextAfterCursor(int paramInt1, int paramInt2)
  {
    return b.getTextAfterCursor(paramInt1, paramInt2);
  }
  
  public final CharSequence getTextBeforeCursor(int paramInt1, int paramInt2)
  {
    return b.getTextBeforeCursor(paramInt1, paramInt2);
  }
  
  public final boolean performContextMenuAction(int paramInt)
  {
    return b.performContextMenuAction(paramInt);
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    return b.performEditorAction(paramInt);
  }
  
  public final boolean performPrivateCommand(String paramString, Bundle paramBundle)
  {
    return b.performPrivateCommand(paramString, paramBundle);
  }
  
  public final boolean reportFullscreenMode(boolean paramBoolean)
  {
    return b.reportFullscreenMode(paramBoolean);
  }
  
  public final boolean requestCursorUpdates(int paramInt)
  {
    return b.requestCursorUpdates(paramInt);
  }
  
  public final boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    return b.sendKeyEvent(paramKeyEvent);
  }
  
  public final boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    return b.setComposingRegion(paramInt1, paramInt2);
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    if (!e)
    {
      e = true;
      f = a(getEditable());
      b();
    }
    a.g = true;
    boolean bool = b.setComposingText(paramCharSequence, paramInt);
    a.g = false;
    g = a(getEditable());
    if ((!a()) && (e))
    {
      c();
      e = false;
    }
    return bool;
  }
  
  public final boolean setSelection(int paramInt1, int paramInt2)
  {
    return b.setSelection(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     dcq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */