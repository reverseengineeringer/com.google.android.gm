package com.google.android.apps.work.common.richedittext;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import dck;
import dcm;
import dco;
import dcp;
import dcq;
import ddd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RichEditText
  extends EditText
{
  private int a = -1;
  public dcm b = null;
  public boolean c = true;
  public ActionMode d = null;
  public boolean e = false;
  public RichTextState f = null;
  public boolean g = false;
  private List<CharacterStyle> h = null;
  
  public RichEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public RichEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0, 0);
  }
  
  public RichEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public RichEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private static Spannable a(Spannable paramSpannable, int paramInt1, int paramInt2, Class<?> paramClass, Object paramObject)
  {
    if ((paramObject != null) && (!paramObject.getClass().equals(paramClass))) {
      throw new IllegalArgumentException("Reference span object must be an instance of the kind parameter");
    }
    paramClass = paramSpannable.getSpans(paramInt1, paramInt2, paramClass);
    int j = paramClass.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramClass[i];
      int k = paramSpannable.getSpanStart(localObject);
      int m = paramSpannable.getSpanEnd(localObject);
      if (((paramSpannable.getSpanFlags(localObject) & 0x100) != 256) && (ddd.a(localObject)) && ((paramObject == null) || (ddd.a(localObject, paramObject))))
      {
        if (!(localObject instanceof ParagraphStyle)) {
          break label184;
        }
        switch (ddd.a(paramInt1, paramInt2, k, m))
        {
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramSpannable.removeSpan(localObject);
        continue;
        label184:
        if ((localObject instanceof CharacterStyle)) {
          a(paramSpannable, paramInt1, paramInt2, new CharacterStyle[] { (CharacterStyle)localObject });
        }
      }
    }
    return paramSpannable;
  }
  
  private static Spannable a(Spannable paramSpannable, int paramInt1, int paramInt2, Object paramObject, int paramInt3)
  {
    paramInt3 = 1;
    Object[] arrayOfObject = paramSpannable.getSpans(0, paramSpannable.length(), paramObject.getClass());
    int i2 = arrayOfObject.length;
    int m = 0;
    int i = paramInt2;
    int j = paramInt1;
    Object localObject;
    int i1;
    int n;
    if (m < i2)
    {
      localObject = arrayOfObject[m];
      if (((paramSpannable.getSpanFlags(localObject) & 0x100) != 256) && (ddd.a(localObject, paramObject)))
      {
        i1 = paramSpannable.getSpanStart(localObject);
        n = paramSpannable.getSpanEnd(localObject);
      }
      switch (ddd.a(paramInt1, paramInt2, i1, n))
      {
      case 0: 
      default: 
      case -1: 
        for (;;)
        {
          m += 1;
          break;
        }
      case 1: 
        if (i1 < j) {
          j = i1;
        }
        break;
      }
    }
    for (;;)
    {
      paramSpannable.removeSpan(localObject);
      break;
      if (n > i) {
        i = n;
      }
      for (;;)
      {
        paramSpannable.removeSpan(localObject);
        break;
        paramInt3 = 0;
        break;
        paramSpannable.removeSpan(localObject);
        break;
        if ((localObject instanceof ParagraphStyle)) {
          break;
        }
        int k = j;
        if (i1 < j) {
          k = i1;
        }
        if (n > i) {
          i = n;
        }
        for (;;)
        {
          paramSpannable.removeSpan(localObject);
          j = k;
          break;
          if (paramInt3 != 0) {
            paramSpannable.setSpan(paramObject, j, i, 34);
          }
          return paramSpannable;
        }
      }
    }
  }
  
  private final void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, dck.ab, paramInt1, paramInt2);
    try
    {
      e = paramContext.getBoolean(dck.ac, false);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private static void a(Spannable paramSpannable)
  {
    int i = 0;
    ParagraphStyle[] arrayOfParagraphStyle = (ParagraphStyle[])paramSpannable.getSpans(0, paramSpannable.length(), ParagraphStyle.class);
    int j = arrayOfParagraphStyle.length;
    while (i < j)
    {
      ParagraphStyle localParagraphStyle = arrayOfParagraphStyle[i];
      if (paramSpannable.getSpanStart(localParagraphStyle) == paramSpannable.getSpanEnd(localParagraphStyle)) {
        paramSpannable.removeSpan(localParagraphStyle);
      }
      i += 1;
    }
  }
  
  private static void a(Spannable paramSpannable, int paramInt)
  {
    ParagraphStyle[] arrayOfParagraphStyle = (ParagraphStyle[])paramSpannable.getSpans(paramInt, paramInt, ParagraphStyle.class);
    int j = arrayOfParagraphStyle.length;
    int i = 0;
    while (i < j)
    {
      ParagraphStyle localParagraphStyle = arrayOfParagraphStyle[i];
      int k = paramSpannable.getSpanStart(localParagraphStyle);
      int m = paramSpannable.getSpanEnd(localParagraphStyle);
      int n = paramSpannable.getSpanFlags(localParagraphStyle);
      paramSpannable.setSpan(localParagraphStyle, k, paramInt, n);
      paramSpannable.setSpan(ddd.b(localParagraphStyle), paramInt, m, n);
      i += 1;
    }
  }
  
  private static void a(Spannable paramSpannable, int paramInt1, int paramInt2, CharacterStyle... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramVarArgs[i];
      int k = paramSpannable.getSpanStart(localObject);
      int m = paramSpannable.getSpanEnd(localObject);
      int n = paramSpannable.getSpanFlags(localObject);
      switch (ddd.a(paramInt1, paramInt2, k, m))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramSpannable.setSpan(localObject, k, paramInt1, n);
        continue;
        paramSpannable.setSpan(localObject, paramInt2, m, n);
        continue;
        paramSpannable.setSpan(localObject, k, paramInt1, n);
        localObject = ddd.b(localObject);
        if (localObject != null)
        {
          paramSpannable.setSpan(localObject, paramInt2, m, n);
          continue;
          paramSpannable.removeSpan(localObject);
        }
      }
    }
  }
  
  private final void b(ActionMode paramActionMode)
  {
    if (paramActionMode != null)
    {
      d = paramActionMode;
      if (b != null) {
        b.a(paramActionMode);
      }
      if (Build.VERSION.SDK_INT >= 22) {
        paramActionMode.invalidate();
      }
    }
  }
  
  private final RichTextState g()
  {
    return new RichTextState(getText(), a(), b());
  }
  
  private final boolean h()
  {
    return (!hasSelection()) && (a != a());
  }
  
  private final void i()
  {
    if (!hasSelection()) {
      a = a();
    }
  }
  
  public final int a()
  {
    return Math.min(getSelectionStart(), getSelectionEnd());
  }
  
  public final void a(int paramInt1, int paramInt2, Class<?>... paramVarArgs)
  {
    Editable localEditable = getEditableText();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      a(localEditable, paramInt1, paramInt2, paramVarArgs[i], null);
      i += 1;
    }
  }
  
  public final void a(ActionMode paramActionMode)
  {
    if (paramActionMode == null) {
      return;
    }
    int i = getSelectionStart();
    int j = getSelectionEnd();
    paramActionMode.finish();
    g = true;
    setSelection(i, j);
    g = false;
  }
  
  public final void a(Object paramObject, boolean paramBoolean)
  {
    int i = a();
    int j = b();
    if ((i < 0) || (j < 0) || (i == j)) {}
    for (;;)
    {
      a(d);
      return;
      Editable localEditable = getEditableText();
      if (paramBoolean) {
        a(localEditable, i, j, paramObject, 34);
      } else {
        a(localEditable, i, j, paramObject.getClass(), paramObject);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    d();
    i();
    f.a = paramBoolean;
  }
  
  public final int b()
  {
    return Math.max(getSelectionStart(), getSelectionEnd());
  }
  
  public final void b(boolean paramBoolean)
  {
    d();
    f.b = paramBoolean;
  }
  
  public final void c()
  {
    if ((c) && (isFocused())) {}
    for (boolean bool = true;; bool = false)
    {
      if (b != null)
      {
        b.a(bool);
        if (bool)
        {
          RichTextState localRichTextState = g();
          dcm localdcm = b;
          getSelectionStart();
          getSelectionEnd();
          localdcm.a(localRichTextState);
        }
      }
      return;
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    d();
    f.c = paramBoolean;
  }
  
  public final void d()
  {
    if ((f == null) || (h()) || (hasSelection()))
    {
      i();
      f = g();
    }
  }
  
  public final void d(boolean paramBoolean)
  {
    d();
    f.d = paramBoolean;
  }
  
  public final void e()
  {
    Object localObject;
    if (hasSelection())
    {
      localObject = getText();
      int j = b();
      int i = j;
      if (j != ((CharSequence)localObject).length())
      {
        i = j;
        if (((CharSequence)localObject).charAt(j) == '\n') {
          i = j + 1;
        }
      }
      a(a(), i, ddd.a);
    }
    a = -1;
    f = null;
    if (b != null)
    {
      localObject = g();
      dcm localdcm = b;
      getSelectionStart();
      getSelectionEnd();
      localdcm.a((RichTextState)localObject);
    }
    a(d);
  }
  
  public final void e(boolean paramBoolean)
  {
    a(new StyleSpan(1), paramBoolean);
  }
  
  public final void f()
  {
    a(d);
  }
  
  public final void f(boolean paramBoolean)
  {
    a(new StyleSpan(2), paramBoolean);
  }
  
  public final void g(boolean paramBoolean)
  {
    a(new UnderlineSpan(), paramBoolean);
  }
  
  public final void h(boolean paramBoolean)
  {
    a(new StrikethroughSpan(), paramBoolean);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return new dcq(this, super.onCreateInputConnection(paramEditorInfo));
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    c();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    int j = 0;
    int i = j;
    RichTextState localRichTextState;
    if (c)
    {
      localRichTextState = g();
      if (!paramKeyEvent.isCtrlPressed()) {
        break label403;
      }
      switch (paramInt)
      {
      default: 
        i = j;
      }
    }
    while (i != 0)
    {
      if ((f != null) && (b != null))
      {
        paramKeyEvent = b;
        getSelectionStart();
        getSelectionEnd();
        paramKeyEvent.a(f);
      }
      return true;
      if (hasSelection())
      {
        if (!a) {
          bool1 = true;
        }
        e(bool1);
        i = 1;
      }
      else
      {
        if (f != null)
        {
          bool1 = bool2;
          if (!f.a) {
            bool1 = true;
          }
        }
        for (;;)
        {
          a(bool1);
          i = 1;
          break;
          bool1 = bool2;
          if (!a) {
            bool1 = true;
          }
        }
        if (hasSelection())
        {
          bool1 = bool3;
          if (!b) {
            bool1 = true;
          }
          f(bool1);
          i = 1;
        }
        else
        {
          if (f != null)
          {
            bool1 = bool4;
            if (!f.b) {
              bool1 = true;
            }
          }
          for (;;)
          {
            b(bool1);
            i = 1;
            break;
            bool1 = bool4;
            if (!b) {
              bool1 = true;
            }
          }
          if (hasSelection())
          {
            bool1 = bool5;
            if (!c) {
              bool1 = true;
            }
            g(bool1);
            i = 1;
          }
          else
          {
            if (f != null)
            {
              bool1 = bool6;
              if (!f.c) {
                bool1 = true;
              }
            }
            for (;;)
            {
              c(bool1);
              i = 1;
              break;
              bool1 = bool6;
              if (!c) {
                bool1 = true;
              }
            }
            e();
            i = 1;
            continue;
            label403:
            i = j;
            if (paramKeyEvent.isAltPressed())
            {
              i = j;
              if (paramKeyEvent.isShiftPressed()) {
                switch (paramInt)
                {
                default: 
                  i = j;
                  break;
                case 12: 
                  if (hasSelection())
                  {
                    bool1 = bool7;
                    if (!d) {
                      bool1 = true;
                    }
                    h(bool1);
                    i = 1;
                  }
                  else
                  {
                    if (f != null)
                    {
                      bool1 = bool8;
                      if (!f.d) {
                        bool1 = true;
                      }
                    }
                    for (;;)
                    {
                      d(bool1);
                      i = 1;
                      break;
                      bool1 = bool8;
                      if (!d) {
                        bool1 = true;
                      }
                    }
                  }
                  break;
                }
              }
            }
          }
        }
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4) {
      paramKeyEvent.getAction();
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (RichEditText.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable != null)
    {
      c = a;
      a = b;
      f = c;
      if (b != null)
      {
        b.a(c);
        if (f != null)
        {
          paramParcelable = b;
          getSelectionStart();
          getSelectionEnd();
          paramParcelable.a(f);
        }
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    RichEditText.SavedState localSavedState = new RichEditText.SavedState(super.onSaveInstanceState());
    a = c;
    b = a;
    c = f;
    return localSavedState;
  }
  
  public void onSelectionChanged(int paramInt1, int paramInt2)
  {
    if (!g)
    {
      if (b != null)
      {
        RichTextState localRichTextState = g();
        b.a(localRichTextState);
      }
      if (h())
      {
        a = -1;
        f = null;
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Editable localEditable;
    if (!g)
    {
      localEditable = getEditableText();
      if (h == null) {
        break label116;
      }
      a(localEditable, paramInt1, paramInt1 + paramInt3, (CharacterStyle[])h.toArray(new CharacterStyle[h.size()]));
      h = null;
    }
    while ((paramCharSequence instanceof Spannable))
    {
      paramCharSequence = (Spannable)paramCharSequence;
      if (paramInt3 > 0)
      {
        paramInt2 = TextUtils.indexOf(paramCharSequence, '\n', paramInt1);
        for (;;)
        {
          if ((paramInt2 >= 0) && (paramInt2 < paramInt1 + paramInt3))
          {
            a(paramCharSequence, paramInt2 + 1);
            paramInt2 = TextUtils.indexOf(paramCharSequence, '\n', paramInt2 + 1);
            continue;
            label116:
            if ((a == -1) || (f == null)) {
              break;
            }
            if (a < paramInt1 + paramInt3)
            {
              Object localObject1 = new RichTextState(localEditable, a, a);
              Object localObject2 = f;
              Object localObject3 = new ArrayList();
              if ((!a) && (a)) {
                ((ArrayList)localObject3).add(new StyleSpan(1));
              }
              if ((!b) && (b)) {
                ((ArrayList)localObject3).add(new StyleSpan(2));
              }
              if ((!c) && (c)) {
                ((ArrayList)localObject3).add(new UnderlineSpan());
              }
              if ((!d) && (d)) {
                ((ArrayList)localObject3).add(new StrikethroughSpan());
              }
              if ((!e) && (e)) {
                ((ArrayList)localObject3).add(new SubscriptSpan());
              }
              if ((!f) && (f)) {
                ((ArrayList)localObject3).add(new SuperscriptSpan());
              }
              if ((g != g) && (g != -16777216)) {
                ((ArrayList)localObject3).add(new ForegroundColorSpan(g));
              }
              if ((h != h) && (h != -1)) {
                ((ArrayList)localObject3).add(new BackgroundColorSpan(h));
              }
              if ((!i.equalsIgnoreCase(i)) && (!i.equalsIgnoreCase("sans-serif"))) {
                ((ArrayList)localObject3).add(new TypefaceSpan(i));
              }
              if ((!j) && (j)) {
                ((ArrayList)localObject3).add(new BulletSpan());
              }
              if ((!k.equals(k)) && (!k.equals(Layout.Alignment.ALIGN_NORMAL))) {
                ((ArrayList)localObject3).add(new AlignmentSpan.Standard(k));
              }
              localObject2 = ((List)localObject3).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = ((Iterator)localObject2).next();
                a(localEditable, a, paramInt1 + paramInt3, localObject3.getClass(), localObject3);
              }
              localObject2 = f;
              localObject3 = new ArrayList();
              if ((a) && (!a)) {
                ((ArrayList)localObject3).add(new StyleSpan(1));
              }
              if ((b) && (!b)) {
                ((ArrayList)localObject3).add(new StyleSpan(2));
              }
              if ((c) && (!c)) {
                ((ArrayList)localObject3).add(new UnderlineSpan());
              }
              if ((d) && (!d)) {
                ((ArrayList)localObject3).add(new StrikethroughSpan());
              }
              if ((e) && (!e)) {
                ((ArrayList)localObject3).add(new SubscriptSpan());
              }
              if ((f) && (!f)) {
                ((ArrayList)localObject3).add(new SuperscriptSpan());
              }
              if ((g != g) && (g != -16777216)) {
                ((ArrayList)localObject3).add(new ForegroundColorSpan(g));
              }
              if ((h != h) && (h != -1)) {
                ((ArrayList)localObject3).add(new BackgroundColorSpan(h));
              }
              if ((!i.equalsIgnoreCase(i)) && (!i.equalsIgnoreCase("sans-serif"))) {
                ((ArrayList)localObject3).add(new TypefaceSpan(i));
              }
              if ((j) && (!j)) {
                ((ArrayList)localObject3).add(new BulletSpan());
              }
              if ((k != k) && (k != Layout.Alignment.ALIGN_NORMAL)) {
                ((ArrayList)localObject3).add(new AlignmentSpan.Standard(k));
              }
              localObject1 = ((List)localObject3).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = ((Iterator)localObject1).next();
                a(localEditable, a, paramInt1 + paramInt3, localObject2, 34);
              }
            }
            if (a == paramInt1 + paramInt3) {
              break;
            }
            a = -1;
            f = null;
            break;
          }
        }
      }
      a(paramCharSequence);
    }
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    switch (paramInt)
    {
    }
    Editable localEditable;
    int m;
    int n;
    CharacterStyle[] arrayOfCharacterStyle;
    int i1;
    int i;
    do
    {
      return super.onTextContextMenuItem(paramInt);
      h = new ArrayList();
      localEditable = getEditableText();
      m = a();
      n = b();
      arrayOfCharacterStyle = (CharacterStyle[])localEditable.getSpans(m, n, CharacterStyle.class);
      i1 = arrayOfCharacterStyle.length;
      i = 0;
    } while (i >= i1);
    CharacterStyle localCharacterStyle = arrayOfCharacterStyle[i];
    int i2 = localEditable.getSpanStart(localCharacterStyle);
    int i3 = localEditable.getSpanEnd(localCharacterStyle);
    switch (ddd.a(m, n, i2, i3))
    {
    }
    label215:
    label281:
    label285:
    for (;;)
    {
      i += 1;
      break;
      h.add(localCharacterStyle);
      continue;
      int k = localEditable.getSpanFlags(localCharacterStyle);
      int j;
      if (((k & 0x11) == 17) || ((k & 0x12) == 18))
      {
        j = 1;
        if (((k & 0x22) != 34) && ((k & 0x12) != 18)) {
          break label281;
        }
      }
      for (k = 1;; k = 0)
      {
        if (((i2 != n) || (j == 0)) && ((i3 != m) || (k == 0))) {
          break label285;
        }
        h.add(localCharacterStyle);
        break;
        j = 0;
        break label215;
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    d();
    f.h = paramInt;
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    if (!c) {
      return super.startActionMode(paramCallback);
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramCallback = super.startActionMode(new dcp(this, paramCallback));; paramCallback = super.startActionMode(new dco(this, paramCallback)))
    {
      b(paramCallback);
      return paramCallback;
    }
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    if (!c) {
      return super.startActionMode(paramCallback, paramInt);
    }
    paramCallback = super.startActionMode(new dcp(this, paramCallback), paramInt);
    b(paramCallback);
    return paramCallback;
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.work.common.richedittext.RichEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */