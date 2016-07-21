package com.android.ex.editstyledtext;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import bkv;
import bkx;
import bla;
import blb;
import blc;
import bld;
import ble;
import blf;
import java.util.ArrayList;
import java.util.Iterator;

public final class EditStyledText
  extends EditText
{
  private static CharSequence c;
  private static CharSequence d;
  private static CharSequence e;
  private static final NoCopySpan.Concrete h = new NoCopySpan.Concrete();
  public ArrayList<bkx> a;
  public bld b;
  private Drawable f;
  private InputConnection g;
  
  public static void a(Spannable paramSpannable)
  {
    paramSpannable.removeSpan(h);
  }
  
  private void c()
  {
    if (a != null)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
  }
  
  private final void d()
  {
    Object localObject = b;
    bkv localbkv = o;
    a20a = null;
    a = 20;
    localbkv.b(20);
    localObject = n;
    if (a != null)
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  private final void e()
  {
    Object localObject = b;
    bkv localbkv = o;
    a1a = null;
    a = 1;
    localbkv.b(1);
    localObject = n;
    if (a != null)
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  private final void f()
  {
    Object localObject = b;
    bkv localbkv = o;
    a7a = null;
    a = 7;
    localbkv.b(7);
    localObject = n;
    if (a != null)
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  public final boolean a()
  {
    if (a != null)
    {
      Iterator localIterator = a.iterator();
      for (boolean bool1 = false;; bool1 = ((bkx)localIterator.next()).a() | bool1)
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  public final void b()
  {
    Object localObject = b;
    bkv localbkv = o;
    a21a = null;
    a = 21;
    localbkv.b(21);
    localObject = n;
    if (a != null)
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Iterator)localObject).next();
      }
    }
  }
  
  protected final void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (b != null) {
      b.b();
    }
  }
  
  protected final void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    super.onCreateContextMenu(paramContextMenu);
    ble localble = new ble(this);
    if (c != null) {
      paramContextMenu.add(0, 16776961, 0, c).setOnMenuItemClickListener(localble);
    }
    Object localObject1 = b;
    Object localObject2 = n.getText();
    int i = ((Editable)localObject2).length();
    if ((((ParagraphStyle[])((Editable)localObject2).getSpans(0, i, ParagraphStyle.class)).length > 0) || (((QuoteSpan[])((Editable)localObject2).getSpans(0, i, QuoteSpan.class)).length > 0) || (((CharacterStyle[])((Editable)localObject2).getSpans(0, i, CharacterStyle.class)).length > 0) || (l != 16777215)) {}
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (d != null)) {
        paramContextMenu.add(0, 16776962, 0, d).setOnMenuItemClickListener(localble);
      }
      localObject1 = b;
      if ((q == null) || (q.length() <= 0)) {
        break label330;
      }
      localObject1 = new SpannableStringBuilder(q);
      localObject2 = (DynamicDrawableSpan[])((SpannableStringBuilder)localObject1).getSpans(0, ((SpannableStringBuilder)localObject1).length(), DynamicDrawableSpan.class);
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if (((localObject3 instanceof bla)) || ((localObject3 instanceof blc))) {
          ((SpannableStringBuilder)localObject1).replace(((SpannableStringBuilder)localObject1).getSpanStart(localObject3), ((SpannableStringBuilder)localObject1).getSpanEnd(localObject3), "");
        }
        i += 1;
      }
    }
    if (((SpannableStringBuilder)localObject1).length() == 0) {}
    label330:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        paramContextMenu.add(0, 16908322, 0, e).setOnMenuItemClickListener(localble).setAlphabeticShortcut('v');
      }
      return;
    }
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    g = new blf(super.onCreateInputConnection(paramEditorInfo), this);
    return g;
  }
  
  protected final void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean) {
      d();
    }
    while (a()) {
      return;
    }
    b();
  }
  
  public final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof EditStyledText.SavedStyledTextState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (EditStyledText.SavedStyledTextState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setBackgroundColor(a);
  }
  
  public final Parcelable onSaveInstanceState()
  {
    EditStyledText.SavedStyledTextState localSavedStyledTextState = new EditStyledText.SavedStyledTextState(super.onSaveInstanceState());
    a = b.l;
    return localSavedStyledTextState;
  }
  
  protected final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    bld localbld;
    Object localObject1;
    int m;
    int k;
    int i;
    Object localObject2;
    int n;
    Object localObject3;
    int i1;
    int i2;
    if (b != null)
    {
      localbld = b;
      localObject1 = getText();
      new StringBuilder(50).append("updateSpanNext:").append(paramInt1).append(",").append(paramInt2).append(",").append(paramInt3);
      m = paramInt1 + paramInt3;
      k = Math.min(paramInt1, m);
      i = Math.max(paramInt1, m);
      localObject2 = ((Editable)localObject1).getSpans(i, i, Object.class);
      n = localObject2.length;
      i = 0;
      if (i < n)
      {
        localObject3 = localObject2[i];
        if (((localObject3 instanceof blb)) || ((localObject3 instanceof AlignmentSpan)))
        {
          i1 = ((Editable)localObject1).getSpanStart(localObject3);
          i2 = ((Editable)localObject1).getSpanEnd(localObject3);
          String str = String.valueOf(localObject3.getClass());
          new StringBuilder(String.valueOf(str).length() + 21).append("spantype:").append(str).append(",").append(i2);
          if ((!(localObject3 instanceof blb)) && (!(localObject3 instanceof AlignmentSpan))) {
            break label1101;
          }
        }
      }
    }
    label668:
    label880:
    label997:
    label1045:
    label1101:
    for (int j = bld.a(n.getText(), k);; j = k)
    {
      if ((j < i1) && (paramInt2 > paramInt3)) {
        ((Editable)localObject1).removeSpan(localObject3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (i1 > k)
        {
          ((Editable)localObject1).setSpan(localObject3, k, i2, 33);
          continue;
          if (((localObject3 instanceof bla)) && (((Editable)localObject1).getSpanStart(localObject3) == m) && (m > 0) && (n.getText().charAt(m - 1) != '\n'))
          {
            n.getText().insert(m, "\n");
            n.setSelection(m);
          }
        }
      }
      b.a(getText(), paramInt1, paramInt2, paramInt3);
      if (paramInt3 > paramInt2)
      {
        localbld = b;
        new StringBuilder(48).append("--- setTextComposingMask:").append(paramInt1).append(",").append(m);
        j = Math.min(paramInt1, m);
        k = Math.max(paramInt1, m);
        if ((d) && (j != 16777215))
        {
          i = j;
          m = n.b.l;
          localObject1 = String.valueOf(Integer.toHexString(i));
          localObject2 = String.valueOf(Integer.toHexString(m));
          boolean bool = d;
          n = f;
          new StringBuilder(String.valueOf(localObject1).length() + 30 + String.valueOf(localObject2).length()).append("--- fg:").append((String)localObject1).append(",bg:").append((String)localObject2).append(",").append(bool).append(",,").append(n);
          if (i == m)
          {
            i = 0x80000000 | (m | 0xFF000000) ^ 0xFFFFFFFF;
            if ((m == null) || (m.getBackgroundColor() != i)) {
              m = new BackgroundColorSpan(i);
            }
            n.getText().setSpan(m, j, k, 33);
          }
          if (b.d)
          {
            if (paramInt3 <= paramInt2) {
              break label1045;
            }
            b.a();
            localbld = b;
            i = h;
            j = i;
            new StringBuilder(42).append("--- handleComplete:").append(i).append(",").append(j);
            if (a)
            {
              if (h != i) {
                break label997;
              }
              i = h;
              new StringBuilder(38).append("--- cancel handle complete:").append(i);
              f = 0;
              g = 0;
              a = false;
              j = 16777215;
              k = 0;
              d = false;
              b = false;
              c = false;
              e = false;
              localbld.d();
              n.setOnClickListener(null);
              b = false;
              a = true;
              n.c();
            }
            n.c();
          }
        }
      }
      for (;;)
      {
        super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        return;
        localObject1 = n;
        if ((j < 0) || (j > ((EditStyledText)localObject1).getText().length()))
        {
          i = -16777216;
          break;
        }
        localObject1 = (ForegroundColorSpan[])((EditStyledText)localObject1).getText().getSpans(j, j, ForegroundColorSpan.class);
        if (localObject1.length > 0)
        {
          i = localObject1[0].getForegroundColor();
          break;
        }
        i = -16777216;
        break;
        if (paramInt2 >= paramInt3) {
          break label668;
        }
        b.c();
        break label668;
        if (g == 2) {
          g = 3;
        }
        o.b(f);
        n.getText().removeSpan(h);
        break label880;
        if (paramInt3 < paramInt2)
        {
          localbld = b;
          localObject1 = o;
          a22a = null;
          a = 22;
          ((bkv)localObject1).b(22);
          n.c();
        }
      }
    }
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    int i;
    if (getSelectionStart() != getSelectionEnd()) {
      i = 1;
    }
    Object localObject;
    label512:
    bkv localbkv;
    switch (paramInt)
    {
    default: 
    case 16908319: 
    case 16908328: 
      for (;;)
      {
        return super.onTextContextMenuItem(paramInt);
        i = 0;
        break;
        b.a(true);
        return true;
        localObject = b;
        f = 5;
        if (g == 0) {
          o.b(5);
        }
        for (;;)
        {
          localObject = n;
          if (a == null) {
            break;
          }
          localObject = a.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((Iterator)localObject).next();
          }
          ((bld)localObject).d();
          o.b(5);
        }
        localObject = b;
        if (n.isFocused())
        {
          p.a = Selection.getSelectionStart(n.getText());
          p.b = Selection.getSelectionEnd(n.getText());
          ((InputMethodManager)n.getContext().getSystemService("input_method")).hideSoftInputFromWindow(n.getWindowToken(), 0, p);
        }
        b = true;
      }
    case 16908329: 
      localObject = b;
      i = h;
      int j = i;
      new StringBuilder(42).append("--- handleComplete:").append(i).append(",").append(j);
      if (a)
      {
        if (h != i) {
          break label512;
        }
        i = h;
        new StringBuilder(38).append("--- cancel handle complete:").append(i);
        f = 0;
        g = 0;
        a = false;
        j = 16777215;
        k = 0;
        d = false;
        b = false;
        c = false;
        e = false;
        ((bld)localObject).d();
        n.setOnClickListener(null);
        b = false;
        a = true;
        n.c();
      }
      for (;;)
      {
        n.c();
        break;
        if (g == 2) {
          g = 3;
        }
        o.b(f);
        n.getText().removeSpan(h);
      }
    case 16908322: 
      localObject = b;
      localbkv = o;
      a2a = null;
      a = 2;
      localbkv.b(2);
      n.c();
      return true;
    case 16908321: 
      if (i != 0) {
        e();
      }
      for (;;)
      {
        return true;
        b.a(false);
        e();
      }
    case 16908320: 
      if (i != 0) {
        f();
      }
      for (;;)
      {
        return true;
        b.a(false);
        f();
      }
    case 16776961: 
      localObject = b;
      localbkv = o;
      a12a = null;
      a = 12;
      localbkv.b(12);
      n.c();
      return true;
    case 16776962: 
      localObject = b.o;
      a14a = null;
      a = 14;
      ((bkv)localObject).b(14);
      return true;
    case 16776963: 
      d();
      return true;
    }
    b();
    return true;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    int j;
    boolean bool1;
    if (paramMotionEvent.getAction() == 1)
    {
      cancelLongPress();
      boolean bool2 = b.a;
      if (!bool2) {
        d();
      }
      i = Selection.getSelectionStart(getText());
      j = Selection.getSelectionEnd(getText());
      bool1 = super.onTouchEvent(paramMotionEvent);
      if ((isFocused()) && (b.g == 0))
      {
        if (bool2) {
          b.a(Selection.getSelectionStart(getText()), Selection.getSelectionEnd(getText()));
        }
      }
      else
      {
        b.a();
        b.c();
      }
    }
    for (;;)
    {
      if (a == null) {
        break label166;
      }
      paramMotionEvent = a.iterator();
      while (paramMotionEvent.hasNext()) {
        paramMotionEvent.next();
      }
      b.a(i, j);
      break;
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    label166:
    return bool1;
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    if (paramInt != 16777215) {
      super.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      b.l = paramInt;
      b.b();
      return;
      setBackgroundDrawable(f);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.editstyledtext.EditStyledText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */