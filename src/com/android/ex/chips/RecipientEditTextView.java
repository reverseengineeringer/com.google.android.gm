package com.android.ex.chips;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.QwertyKeyListener;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView.Validator;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import bhx;
import bii;
import bim;
import bir;
import bis;
import biu;
import biv;
import biw;
import bjc;
import bjd;
import bje;
import bjg;
import bjh;
import bji;
import bjj;
import bjk;
import bjl;
import bjn;
import bjo;
import bjp;
import bjq;
import bjr;
import bjs;
import bjt;
import bju;
import bjv;
import bjw;
import bjy;
import bjz;
import bka;
import bkd;
import bke;
import bkf;
import bkg;
import bkh;
import bki;
import bkj;
import bkm;
import bkn;
import bko;
import bkq;
import bkr;
import bks;
import bku;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class RecipientEditTextView
  extends MultiAutoCompleteTextView
  implements ActionMode.Callback, GestureDetector.OnGestureListener, AdapterView.OnItemClickListener, TextView.OnEditorActionListener, bir, bis, bjl
{
  private static final String E;
  public static final int a;
  public bki A;
  public bkf B;
  public bkg C;
  public bke D;
  private int F;
  private int G;
  private Drawable H = null;
  private Drawable I = null;
  private Drawable J;
  private float K;
  private float L;
  private int M;
  private int N;
  private final int O;
  private boolean P;
  private int Q;
  private int R;
  private Paint S = new Paint();
  private AutoCompleteTextView.Validator T;
  private ListPopupWindow U;
  private TextView V;
  private boolean W = false;
  private GestureDetector aa;
  private boolean ab;
  private boolean ac = false;
  private final Runnable ad = new bjn(this);
  private Runnable ae = new bjq(this);
  private Runnable af = new bjr(this);
  public final Rect b = new Rect();
  public final int[] c = new int[2];
  public float d;
  public MultiAutoCompleteTextView.Tokenizer e;
  public Handler f;
  public TextWatcher g;
  public bim h;
  public View i = this;
  public ListPopupWindow j;
  public View k;
  public AdapterView.OnItemClickListener l;
  public bkq m;
  public Bitmap n;
  public bks o;
  public int p;
  final ArrayList<String> q = new ArrayList();
  public int r = 0;
  public int s;
  public boolean t = false;
  public boolean u = true;
  ArrayList<bkq> v;
  public ArrayList<bkq> w;
  public ScrollView x;
  public boolean y;
  public bka z;
  
  static
  {
    String str1 = String.valueOf(",");
    String str2 = String.valueOf(" ");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      E = str1;
      a = "dismiss".hashCode();
      return;
    }
  }
  
  public RecipientEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, bjj.Y, 0, 0);
    Resources localResources = getContext().getResources();
    H = paramAttributeSet.getDrawable(bjj.aa);
    J = paramAttributeSet.getDrawable(bjj.ag);
    I = paramAttributeSet.getDrawable(bjj.ab);
    if (I == null) {
      I = localResources.getDrawable(bje.a);
    }
    int i1 = paramAttributeSet.getDimensionPixelSize(bjj.ae, -1);
    N = i1;
    M = i1;
    if (M == -1)
    {
      i1 = (int)localResources.getDimension(bjd.b);
      N = i1;
      M = i1;
    }
    i1 = (int)localResources.getDimension(bjd.d);
    if (i1 >= 0) {
      M = i1;
    }
    i1 = (int)localResources.getDimension(bjd.c);
    if (i1 >= 0) {
      N = i1;
    }
    n = BitmapFactory.decodeResource(localResources, bje.b);
    V = ((TextView)LayoutInflater.from(getContext()).inflate(bjh.c, null));
    K = paramAttributeSet.getDimensionPixelSize(bjj.ad, -1);
    if (K == -1.0F) {
      K = localResources.getDimension(bjd.a);
    }
    L = paramAttributeSet.getDimensionPixelSize(bjj.ac, -1);
    if (L == -1.0F) {
      L = localResources.getDimension(bjd.e);
    }
    R = paramAttributeSet.getInt(bjj.Z, 1);
    P = paramAttributeSet.getBoolean(bjj.af, false);
    Q = localResources.getInteger(bjg.a);
    d = localResources.getDimensionPixelOffset(bjd.g);
    F = paramAttributeSet.getColor(bjj.ai, localResources.getColor(17170444));
    G = paramAttributeSet.getColor(bjj.ah, localResources.getColor(bjc.a));
    paramAttributeSet.recycle();
    paramAttributeSet = getPaint();
    b.setEmpty();
    paramAttributeSet.getTextBounds("a", 0, 1, b);
    b.left = 0;
    b.right = 0;
    O = b.height();
    j = new ListPopupWindow(paramContext);
    a(j);
    U = new ListPopupWindow(paramContext);
    a(U);
    l = new bjs(this);
    setInputType(getInputType() | 0x80000);
    setOnItemClickListener(this);
    setCustomSelectionActionModeCallback(this);
    f = new bjt(this);
    g = new bkm(this);
    addTextChangedListener(g);
    aa = new GestureDetector(paramContext, this);
    setOnEditorActionListener(this);
    a(new bim(LayoutInflater.from(paramContext), paramContext));
  }
  
  private final int a(float paramFloat1, float paramFloat2)
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 14) {
      i1 = getOffsetForPosition(paramFloat1, paramFloat2);
    }
    Editable localEditable;
    int i2;
    for (;;)
    {
      localEditable = getText();
      i2 = localEditable.length();
      i3 = i2 - 1;
      while ((i3 >= 0) && (localEditable.charAt(i3) == ' '))
      {
        i2 -= 1;
        i3 -= 1;
      }
      if (getLayout() == null)
      {
        i1 = -1;
      }
      else
      {
        paramFloat2 = Math.max(0.0F, paramFloat2 - getTotalPaddingLeft());
        paramFloat2 = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat2);
        float f1 = getScrollY();
        i1 = getLayout().getLineForVertical((int)(paramFloat2 + f1));
        paramFloat1 = Math.max(0.0F, paramFloat1 - getTotalPaddingLeft());
        paramFloat1 = Math.min(getWidth() - getTotalPaddingRight() - 1, paramFloat1);
        paramFloat2 = getScrollX();
        i1 = getLayout().getOffsetForHorizontal(i1, paramFloat1 + paramFloat2);
      }
    }
    int i3 = i1;
    if (i1 < i2)
    {
      localEditable = getText();
      i3 = i1;
      if (i1 >= 0)
      {
        if (localEditable.charAt(i1) != ' ') {}
        for (i2 = i1;; i2 = -1)
        {
          i3 = i1;
          if (i2 != -1) {
            break label266;
          }
          i3 = i1;
          if (d(i1) != null) {
            break label266;
          }
          i1 -= 1;
          break;
        }
      }
    }
    label266:
    return i3;
  }
  
  public static String a(String paramString)
  {
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramString);
    String str = paramString;
    if (arrayOfRfc822Token != null)
    {
      str = paramString;
      if (arrayOfRfc822Token.length > 0) {
        str = arrayOfRfc822Token[0].getAddress();
      }
    }
    return str;
  }
  
  private final void a(ClipData paramClipData)
  {
    if (paramClipData == null) {
      return;
    }
    Object localObject1 = paramClipData.getDescription();
    int i1;
    label35:
    int i3;
    label56:
    label98:
    Object localObject2;
    int i2;
    label155:
    int i5;
    ArrayList localArrayList;
    label212:
    int i4;
    if ((((ClipDescription)localObject1).hasMimeType("text/plain")) || (((ClipDescription)localObject1).hasMimeType("text/html")))
    {
      i1 = 1;
      if (i1 == 0) {
        break label353;
      }
      removeTextChangedListener(g);
      ClipDescription localClipDescription = paramClipData.getDescription();
      i3 = 0;
      if (i3 >= paramClipData.getItemCount()) {
        break label486;
      }
      localObject1 = localClipDescription.getMimeType(i3);
      if ((!"text/plain".equals(localObject1)) && (!"text/html".equals(localObject1))) {
        break label355;
      }
      i1 = 1;
      if (i1 == 0) {
        break label477;
      }
      localObject1 = paramClipData.getItemAt(i3).getText();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label477;
      }
      localObject2 = getText();
      i1 = getSelectionStart();
      i2 = getSelectionEnd();
      if ((i1 >= 0) && (i2 > 0)) {
        break label360;
      }
      ((Editable)localObject2).append((CharSequence)localObject1);
      String str = getText().toString();
      i5 = e.findTokenStart(str, getSelectionEnd());
      localObject2 = str.substring(i5);
      localObject1 = null;
      localArrayList = new ArrayList();
      if (i5 == 0) {
        break label394;
      }
      i2 = 0;
      i1 = i5;
      if ((i1 == 0) || (localObject1 != null) || (i1 == i2)) {
        break label512;
      }
      i4 = e.findTokenStart(str, i1);
      localObject1 = d(i4);
      if ((i4 != i5) || (localObject1 != null)) {
        break label504;
      }
      i2 = i1;
      i1 = i4;
    }
    label353:
    label355:
    label360:
    label394:
    label477:
    label486:
    label499:
    label504:
    label512:
    for (;;)
    {
      if (i1 != i5) {
        if (localObject1 == null) {
          break label499;
        }
      }
      for (;;)
      {
        if (i2 < i5)
        {
          a(i2, g(e.findTokenEnd(getText().toString(), i2)), getText());
          localObject1 = d(i2);
          if (localObject1 != null)
          {
            i2 = getText().getSpanEnd(localObject1) + 1;
            localArrayList.add(localObject1);
            continue;
            i1 = 0;
            break label35;
            break;
            i1 = 0;
            break label98;
            if (i1 == i2)
            {
              ((Editable)localObject2).insert(i1, (CharSequence)localObject1);
              break label155;
            }
            ((Editable)localObject2).append((CharSequence)localObject1, i1, i2);
            break label155;
          }
        }
        if (b((CharSequence)localObject2))
        {
          localObject1 = getText();
          i1 = localObject1.toString().indexOf((String)localObject2, i5);
          a(i1, ((Editable)localObject1).length(), (Editable)localObject1);
          localArrayList.add(d(i1));
        }
        if (localArrayList.size() > 0) {
          new bka(this).execute(new ArrayList[] { localArrayList });
        }
        i3 += 1;
        break label56;
        f.post(ad);
        return;
        i2 = i1;
      }
      i2 = i1;
      i1 = i4;
      break label212;
    }
  }
  
  private final void a(ListPopupWindow paramListPopupWindow)
  {
    paramListPopupWindow.setOnDismissListener(new bju(this));
  }
  
  private final boolean b(int paramInt1, int paramInt2)
  {
    if (t) {
      return true;
    }
    bkq[] arrayOfbkq = (bkq[])getText().getSpans(paramInt1, paramInt2, bkq.class);
    return (arrayOfbkq != null) && (arrayOfbkq.length > 0);
  }
  
  private final boolean b(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    int i1;
    do
    {
      do
      {
        return false;
        i1 = paramCharSequence.length();
        int i2 = e.findTokenStart(paramCharSequence, i1);
        paramCharSequence = paramCharSequence.toString().substring(i2, i1).trim();
      } while (TextUtils.isEmpty(paramCharSequence));
      i1 = paramCharSequence.charAt(paramCharSequence.length() - 1);
    } while ((i1 != 44) && (i1 != 59));
    return true;
  }
  
  private final bkn c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((g()) && (biu.a(paramString))) {
      return new bkn(0, paramString, paramString, -1, null, -1L, null, -1L, null, true, true, null, null);
    }
    Object localObject = Rfc822Tokenizer.tokenize(paramString);
    boolean bool2 = d(paramString);
    if ((bool2) && (localObject != null) && (localObject.length > 0))
    {
      str = localObject[0].getName();
      if (!TextUtils.isEmpty(str)) {
        return bkn.a(str, localObject[0].getAddress(), bool2);
      }
      localObject = localObject[0].getAddress();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return bkn.a((String)localObject, bool2);
      }
    }
    String str = null;
    localObject = str;
    boolean bool1 = bool2;
    if (T != null)
    {
      localObject = str;
      bool1 = bool2;
      if (!bool2)
      {
        str = T.fixText(paramString).toString();
        localObject = str;
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          if (!str.contains(paramString)) {
            break label241;
          }
          Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(str);
          localObject = str;
          bool1 = bool2;
          if (arrayOfRfc822Token.length > 0)
          {
            localObject = arrayOfRfc822Token[0].getAddress();
            bool1 = true;
          }
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return bkn.a((String)localObject, bool1);
      label241:
      localObject = null;
      bool1 = false;
      break;
      localObject = paramString;
    }
  }
  
  private final void c(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      dismissDropDown();
      return;
    }
    Editable localEditable = getText();
    setSelection(paramInt2);
    Object localObject = getText().toString().substring(paramInt1, paramInt2);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bkn.a((String)localObject, d((String)localObject));
      QwertyKeyListener.markAsReplaced(localEditable, paramInt1, paramInt2, "");
      localObject = d((bkn)localObject);
      paramInt2 = getSelectionEnd();
      if ((localObject != null) && (paramInt1 >= 0) && (paramInt2 >= 0)) {
        localEditable.replace(paramInt1, paramInt2, (CharSequence)localObject);
      }
    }
    dismissDropDown();
  }
  
  private final boolean c(int paramInt)
  {
    return getAdapteraa == 0;
  }
  
  private final bkq d(int paramInt)
  {
    Object localObject = getText();
    localObject = (bkq[])((Spannable)localObject).getSpans(0, ((Spannable)localObject).length(), bkq.class);
    int i2 = localObject.length;
    int i1 = 0;
    while (i1 < i2)
    {
      bkq localbkq = localObject[i1];
      int i3 = a(localbkq);
      int i4 = e(localbkq);
      if ((paramInt >= i3) && (paramInt <= i4)) {
        return localbkq;
      }
      i1 += 1;
    }
    return null;
  }
  
  private final CharSequence d(bkn parambkn)
  {
    Object localObject = b(parambkn);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    int i1 = ((String)localObject).length();
    localObject = new SpannableString((CharSequence)localObject);
    if (!t) {}
    try
    {
      bkq localbkq = a(parambkn);
      ((SpannableString)localObject).setSpan(localbkq, 0, i1 - 1, 33);
      localbkq.a(((SpannableString)localObject).toString());
      if (B != null) {
        B.a(parambkn);
      }
      return (CharSequence)localObject;
    }
    catch (NullPointerException parambkn)
    {
      Log.e("RecipientEditTextView", parambkn.getMessage(), parambkn);
    }
    return null;
  }
  
  private final boolean d(String paramString)
  {
    if (T == null) {
      return true;
    }
    return T.isValid(paramString);
  }
  
  private final int e(int paramInt)
  {
    Object localObject = c(((bhx)super.getAdapter()).a(paramInt));
    if (localObject == null) {
      return -1;
    }
    clearComposingText();
    paramInt = getSelectionEnd();
    int i1 = e.findTokenStart(getText(), paramInt);
    Editable localEditable = getText();
    QwertyKeyListener.markAsReplaced(localEditable, i1, paramInt, "");
    localObject = d((bkn)localObject);
    if ((localObject != null) && (i1 >= 0) && (paramInt >= 0)) {
      localEditable.replace(i1, paramInt, (CharSequence)localObject);
    }
    n();
    return paramInt - i1;
  }
  
  private final int e(bkq parambkq)
  {
    return getText().getSpanEnd(parambkq);
  }
  
  private final bkd f(int paramInt)
  {
    Object localObject = String.format(V.getText().toString(), new Object[] { Integer.valueOf(paramInt) });
    S.set(getPaint());
    S.setTextSize(V.getTextSize());
    S.setColor(V.getCurrentTextColor());
    int i2 = (int)S.measureText((String)localObject) + V.getPaddingLeft() + V.getPaddingRight();
    int i1 = (int)K;
    Bitmap localBitmap = Bitmap.createBitmap(i2, i1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Layout localLayout = getLayout();
    if (localLayout != null) {}
    for (paramInt = i1 - localLayout.getLineDescent(0);; paramInt = i1)
    {
      localCanvas.drawText((String)localObject, 0, ((String)localObject).length(), 0.0F, paramInt, S);
      localObject = new BitmapDrawable(getResources(), localBitmap);
      ((Drawable)localObject).setBounds(0, 0, i2, i1);
      return new bkd(this, (Drawable)localObject);
    }
  }
  
  private final void f(bkq parambkq)
  {
    Object localObject2;
    if (g(parambkq))
    {
      localObject1 = parambkq.b();
      localObject2 = getText();
      Editable localEditable = getText();
      int i3 = localEditable.getSpanStart(parambkq);
      int i2 = localEditable.getSpanEnd(parambkq);
      localEditable.removeSpan(parambkq);
      i1 = i2;
      if (i2 - i3 == ((Editable)localObject2).length() - 1) {
        i1 = i2 + 1;
      }
      ((Editable)localObject2).delete(i3, i1);
      setCursorVisible(true);
      setSelection(((Editable)localObject2).length());
      ((Editable)localObject2).append((CharSequence)localObject1);
      m = a(bkn.a((String)localObject1, d(((CharSequence)localObject1).toString())));
      if (C != null) {
        C.b(parambkq.g());
      }
    }
    label192:
    boolean bool;
    label214:
    do
    {
      return;
      if ((parambkq.c() != -2L) && (!((bhx)super.getAdapter()).a())) {
        break;
      }
      i1 = 1;
      if ((i1 != 0) && (t)) {
        break label376;
      }
      if (Build.VERSION.SDK_INT >= 14) {
        break label378;
      }
      bool = false;
      if (bool) {
        break label397;
      }
      m = parambkq;
      setSelection(getText().getSpanEnd(m));
      setCursorVisible(false);
      if (i1 == 0) {
        break label405;
      }
      localObject2 = U;
    } while (!y);
    int i1 = b(getLayout().getLineForOffset(a(parambkq)));
    if (k != null) {}
    for (Object localObject1 = k;; localObject1 = this)
    {
      ((ListPopupWindow)localObject2).setAnchorView((View)localObject1);
      ((ListPopupWindow)localObject2).setVerticalOffset(i1);
      ((ListPopupWindow)localObject2).setAdapter(new bko(getContext(), parambkq.g(), h, o()));
      ((ListPopupWindow)localObject2).setOnItemClickListener(new bjp(this, parambkq));
      ((ListPopupWindow)localObject2).show();
      parambkq = ((ListPopupWindow)localObject2).getListView();
      parambkq.setChoiceMode(1);
      parambkq.setItemChecked(0, true);
      return;
      i1 = 0;
      break label192;
      label376:
      break;
      label378:
      bool = ((AccessibilityManager)getContext().getSystemService("accessibility")).isTouchExplorationEnabled();
      break label214;
      label397:
      break;
    }
    label405:
    new bjy(this, parambkq, j).execute(null);
  }
  
  private final int g(int paramInt)
  {
    if (paramInt >= length()) {}
    int i1;
    do
    {
      do
      {
        return paramInt;
        int i2 = getText().toString().charAt(paramInt);
        if (i2 != 44)
        {
          i1 = paramInt;
          if (i2 != 59) {}
        }
        else
        {
          i1 = paramInt + 1;
        }
        paramInt = i1;
      } while (i1 >= length());
      paramInt = i1;
    } while (getText().toString().charAt(i1) != ' ');
    return i1 + 1;
  }
  
  private final boolean g(bkq parambkq)
  {
    long l1 = parambkq.c();
    return (l1 == -1L) || ((!g()) && (l1 == -2L));
  }
  
  private final void h(bkq parambkq)
  {
    Editable localEditable1 = getText();
    int i4 = localEditable1.getSpanStart(parambkq);
    int i3 = localEditable1.getSpanEnd(parambkq);
    Editable localEditable2 = getText();
    if (parambkq == m) {}
    int i2;
    for (int i1 = 1;; i1 = 0)
    {
      i2 = i3;
      if (i1 != 0)
      {
        m = null;
        i2 = i3;
      }
      while ((i2 >= 0) && (i2 < localEditable2.length()) && (localEditable2.charAt(i2) == ' ')) {
        i2 += 1;
      }
    }
    localEditable1.removeSpan(parambkq);
    if ((i4 >= 0) && (i2 > 0)) {
      localEditable2.delete(i4, i2);
    }
    if (i1 != 0) {
      e();
    }
  }
  
  private final bkq i()
  {
    Object localObject2 = null;
    bkq[] arrayOfbkq = f();
    Object localObject1 = localObject2;
    if (arrayOfbkq != null)
    {
      localObject1 = localObject2;
      if (arrayOfbkq.length > 0) {
        localObject1 = arrayOfbkq[(arrayOfbkq.length - 1)];
      }
    }
    return (bkq)localObject1;
  }
  
  private final boolean j()
  {
    int i1;
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 17) && (getLayoutDirection() == 1))
    {
      i1 = 1;
      if (R != 0) {
        break label42;
      }
      bool = true;
    }
    for (;;)
    {
      if (i1 != 0)
      {
        if (!bool)
        {
          return true;
          i1 = 0;
          break;
          label42:
          bool = false;
          continue;
        }
        return false;
      }
    }
    return bool;
  }
  
  private final void k()
  {
    f.removeCallbacks(ae);
    f.post(ae);
  }
  
  private final boolean l()
  {
    View localView = focusSearch(130);
    if (localView != null)
    {
      localView.requestFocus();
      return true;
    }
    return false;
  }
  
  private final boolean m()
  {
    if (e == null) {}
    Editable localEditable;
    int i1;
    int i2;
    do
    {
      return false;
      localEditable = getText();
      i1 = getSelectionEnd();
      i2 = e.findTokenStart(localEditable, i1);
    } while (!a(i2, i1));
    int i3 = g(e.findTokenEnd(getText(), i2));
    if (i3 != getSelectionEnd())
    {
      c(i2, i3);
      return true;
    }
    return a(i2, i1, localEditable);
  }
  
  private final void n()
  {
    if (r > 0) {}
    for (;;)
    {
      return;
      bkq[] arrayOfbkq = f();
      if ((arrayOfbkq != null) && (arrayOfbkq.length > 0))
      {
        bkq localbkq = arrayOfbkq[(arrayOfbkq.length - 1)];
        Object localObject = null;
        if (arrayOfbkq.length > 1) {
          localObject = arrayOfbkq[(arrayOfbkq.length - 2)];
        }
        int i3 = getText().getSpanStart(localbkq);
        int i2;
        if (localObject != null)
        {
          i2 = getText().getSpanEnd(localObject);
          localObject = getText();
          if ((i2 == -1) || (i2 > ((Editable)localObject).length() - 1)) {
            continue;
          }
          i1 = i2;
          if (((Editable)localObject).charAt(i2) != ' ') {}
        }
        for (int i1 = i2 + 1; (i1 >= 0) && (i3 >= 0) && (i1 < i3); i1 = 0)
        {
          getText().delete(i1, i3);
          return;
        }
      }
    }
  }
  
  private final StateListDrawable o()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    if (!P)
    {
      Drawable localDrawable = I;
      localStateListDrawable.addState(new int[] { 16843518 }, localDrawable);
    }
    localStateListDrawable.addState(new int[0], null);
    return localStateListDrawable;
  }
  
  private final void p()
  {
    Object localObject1;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    Object localObject2;
    Object localObject3;
    if (t)
    {
      localObject1 = getText();
      i1 = 0;
      i2 = 0;
      i3 = 0;
      while (i1 < 2)
      {
        i3 = g(e.findTokenEnd((CharSequence)localObject1, i3));
        i1 += 1;
        i2 = i3;
      }
      i3 = 0;
      i1 = 0;
      do
      {
        i4 = i1;
        if (i3 >= ((Editable)localObject1).length()) {
          break;
        }
        i5 = g(e.findTokenEnd((CharSequence)localObject1, i3));
        i4 = i1 + 1;
        i3 = i5;
        i1 = i4;
      } while (i5 < ((Editable)localObject1).length());
      localObject2 = f(i4 - 2);
      localObject3 = new SpannableString(((Editable)localObject1).subSequence(i2, ((Editable)localObject1).length()));
      ((SpannableString)localObject3).setSpan(localObject2, 0, ((SpannableString)localObject3).length(), 33);
      ((Editable)localObject1).replace(i2, ((Editable)localObject1).length(), (CharSequence)localObject3);
      o = ((bks)localObject2);
    }
    do
    {
      do
      {
        return;
      } while (!u);
      localObject1 = (bks[])getText().getSpans(0, getText().length(), bkd.class);
      if (localObject1.length > 0) {
        getText().removeSpan(localObject1[0]);
      }
      localObject3 = f();
      if ((localObject3 == null) || (localObject3.length <= 2))
      {
        o = null;
        return;
      }
      Editable localEditable = getText();
      i4 = localObject3.length;
      i5 = i4 - 2;
      localObject1 = f(i5);
      w = new ArrayList();
      localObject2 = getText();
      i2 = i4 - i5;
      i1 = 0;
      i3 = 0;
      while (i2 < localObject3.length)
      {
        w.add(localObject3[i2]);
        if (i2 == i4 - i5) {
          i3 = localEditable.getSpanStart(localObject3[i2]);
        }
        if (i2 == localObject3.length - 1) {
          i1 = localEditable.getSpanEnd(localObject3[i2]);
        }
        if ((v == null) || (!v.contains(localObject3[i2])))
        {
          int i6 = localEditable.getSpanStart(localObject3[i2]);
          int i7 = localEditable.getSpanEnd(localObject3[i2]);
          localObject3[i2].a(localObject2.toString().substring(i6, i7));
        }
        localEditable.removeSpan(localObject3[i2]);
        i2 += 1;
      }
      i2 = i1;
      if (i1 < ((Editable)localObject2).length()) {
        i2 = ((Editable)localObject2).length();
      }
      i1 = Math.max(i3, i2);
      i2 = Math.min(i3, i2);
      localObject3 = new SpannableString(((Editable)localObject2).subSequence(i2, i1));
      ((SpannableString)localObject3).setSpan(localObject1, 0, ((SpannableString)localObject3).length(), 33);
      ((Editable)localObject2).replace(i2, i1, (CharSequence)localObject3);
      o = ((bks)localObject1);
    } while ((g()) || (getLineCount() <= Q));
    setMaxLines(getLineCount());
  }
  
  private final void q()
  {
    if ((j != null) && (j.isShowing())) {
      j.dismiss();
    }
    if ((U != null) && (U.isShowing())) {
      U.dismiss();
    }
    setSelection(getText().length());
  }
  
  public final int a(bkq parambkq)
  {
    return getText().getSpanStart(parambkq);
  }
  
  public final bkq a(bkn parambkn)
  {
    TextPaint localTextPaint = getPaint();
    float f1 = localTextPaint.getTextSize();
    int i5 = localTextPaint.getColor();
    int i1;
    Object localObject2;
    label52:
    int i2;
    label65:
    bjz localbjz;
    Drawable localDrawable;
    int i3;
    if (k)
    {
      i1 = F;
      localTextPaint.setColor(i1);
      if (!k) {
        break label824;
      }
      localObject2 = H;
      if (!k) {
        break label833;
      }
      i2 = G;
      localbjz = new bjz();
      if (l == 0) {
        break label1072;
      }
      localDrawable = getContext().getDrawable(l);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      i3 = localDrawable.getBounds().width() + N;
    }
    for (;;)
    {
      Rect localRect = new Rect();
      if (localObject2 != null) {
        ((Drawable)localObject2).getPadding(localRect);
      }
      int i6 = (int)K;
      label178:
      Object localObject3;
      Object localObject1;
      label238:
      float f2;
      int i7;
      int i4;
      label380:
      label469:
      label491:
      label548:
      label608:
      long l1;
      if (k)
      {
        i1 = i6 - top - bottom;
        float[] arrayOfFloat = new float[1];
        localTextPaint.getTextWidths(" ", arrayOfFloat);
        String str = c;
        localObject3 = d;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = str;
          if (!TextUtils.equals(str, (CharSequence)localObject3)) {}
        }
        else
        {
          localObject1 = null;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label854;
        }
        f2 = getWidth() - getPaddingLeft() - getPaddingRight() - M - N - i1 - arrayOfFloat[0] - left - right - i3;
        localTextPaint.setTextSize(L);
        if ((f2 <= 0.0F) && (Log.isLoggable("RecipientEditTextView", 3))) {
          new StringBuilder(38).append("Max width is negative: ").append(f2);
        }
        localObject1 = TextUtils.ellipsize((CharSequence)localObject1, localTextPaint, f2, TextUtils.TruncateAt.END);
        i7 = (int)localTextPaint.measureText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length());
        if (!k) {
          break label889;
        }
        i4 = M;
        i4 = Math.max(i1 * 2, i4 + i7 + N + i1 + left + right + i3);
        a = Bitmap.createBitmap(i4, i6, Bitmap.Config.ARGB_8888);
        localObject3 = new Canvas(a);
        if (localObject2 == null) {
          break label898;
        }
        ((Drawable)localObject2).setBounds(0, 0, i4, i6);
        ((Drawable)localObject2).draw((Canvas)localObject3);
        if (!j()) {
          break label957;
        }
        i2 = N + left + i3;
        ((Canvas)localObject3).drawText((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), i2, i6 - (i6 - O) / 2, localTextPaint);
        if (localDrawable != null)
        {
          if (!j()) {
            break label981;
          }
          i2 = left + N;
          i3 = i6 / 2;
          i7 = localDrawable.getBounds().height() / 2;
          localDrawable.getBounds().offsetTo(i2, i3 - i7);
          localDrawable.draw((Canvas)localObject3);
        }
        if (!j()) {
          break label1008;
        }
        i2 = i4 - right - i1;
        c = i2;
        d = top;
        e = (i2 + i1);
        f = (i6 - bottom);
        if (b)
        {
          l1 = g;
          if (!g()) {
            break label1024;
          }
          if (l1 == -1L) {
            break label1018;
          }
          i1 = 1;
          label685:
          if (i1 != 0)
          {
            localObject1 = parambkn.a();
            if (localObject1 != null) {
              break label1054;
            }
            localObject1 = (bhx)super.getAdapter();
            localObject2 = new bjw(this, parambkn, localbjz);
            m.a(parambkn, (biw)localObject2);
          }
        }
      }
      for (;;)
      {
        localObject1 = a;
        localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
        ((Drawable)localObject2).setBounds(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
        parambkn = new bku((Drawable)localObject2, parambkn);
        d = d;
        localTextPaint.setTextSize(f1);
        localTextPaint.setColor(i5);
        return parambkn;
        i1 = getResources().getColor(17170444);
        break;
        label824:
        localObject2 = J;
        break label52;
        label833:
        i2 = getResources().getColor(bjc.b);
        break label65;
        i1 = 0;
        break label178;
        label854:
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = localObject3;
          break label238;
        }
        localObject1 = new Rfc822Token((String)localObject1, (String)localObject3, null).toString();
        break label238;
        label889:
        i4 = N;
        break label380;
        label898:
        S.reset();
        S.setColor(i2);
        S.setAntiAlias(true);
        f2 = i6 / 2;
        ((Canvas)localObject3).drawRoundRect(new RectF(0.0F, 0.0F, i4, i6), f2, f2, S);
        break label469;
        label957:
        i2 = i4 - right - N - i7 - i3;
        break label491;
        label981:
        i2 = i4 - right - localDrawable.getBounds().width() - N;
        break label548;
        label1008:
        i2 = left;
        break label608;
        label1018:
        i1 = 0;
        break label685;
        label1024:
        if ((l1 != -1L) && (l1 != -2L))
        {
          i1 = 1;
          break label685;
        }
        i1 = 0;
        break label685;
        label1054:
        a(localbjz, BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length));
      }
      label1072:
      i3 = 0;
      localDrawable = null;
    }
  }
  
  public final void a()
  {
    if (m != null)
    {
      if (C != null) {
        C.b(m.g());
      }
      h(m);
    }
    q();
  }
  
  public final void a(int paramInt)
  {
    ListView localListView = j.getListView();
    if ((localListView != null) && (localListView.getCheckedItemCount() == 0)) {
      localListView.setItemChecked(paramInt, true);
    }
    s = paramInt;
  }
  
  public final void a(bim parambim)
  {
    h = parambim;
    h.a = this;
    h.b = this;
  }
  
  public final void a(bjz parambjz, Bitmap paramBitmap)
  {
    Canvas localCanvas = new Canvas(a);
    RectF localRectF = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    parambjz = new RectF(c, d, e, f);
    Matrix localMatrix = new Matrix();
    paramBitmap = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    localMatrix.reset();
    localMatrix.setRectToRect(localRectF, parambjz, Matrix.ScaleToFit.FILL);
    paramBitmap.setLocalMatrix(localMatrix);
    S.reset();
    S.setShader(paramBitmap);
    S.setAntiAlias(true);
    S.setFilterBitmap(true);
    S.setDither(true);
    localCanvas.drawCircle(parambjz.centerX(), parambjz.centerY(), parambjz.width() / 2.0F, S);
    S.reset();
    S.setColor(0);
    S.setStyle(Paint.Style.STROKE);
    S.setStrokeWidth(1.0F);
    S.setAntiAlias(true);
    localCanvas.drawCircle(parambjz.centerX(), parambjz.centerY(), parambjz.width() / 2.0F - 0.5F, S);
    S.reset();
  }
  
  public final void a(bkq parambkq, bkn parambkn)
  {
    int i1;
    int i3;
    int i2;
    if (parambkq == m)
    {
      i1 = 1;
      if (i1 != 0) {
        m = null;
      }
      i3 = a(parambkq);
      i2 = e(parambkq);
      getText().removeSpan(parambkq);
      parambkq = getText();
      parambkn = d(parambkn);
      if (parambkn != null)
      {
        if ((i3 != -1) && (i2 != -1)) {
          break label108;
        }
        Log.e("RecipientEditTextView", "The chip to replace does not exist but should.");
        parambkq.insert(0, parambkn);
      }
    }
    for (;;)
    {
      setCursorVisible(true);
      if (i1 != 0) {
        e();
      }
      return;
      i1 = 0;
      break;
      label108:
      if (!TextUtils.isEmpty(parambkn))
      {
        while ((i2 >= 0) && (i2 < parambkq.length()) && (parambkq.charAt(i2) == ' ')) {
          i2 += 1;
        }
        parambkq.replace(i3, i2, parambkn);
      }
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    return (!t) && (hasFocus()) && (enoughToFilter()) && (!b(paramInt1, paramInt2));
  }
  
  public final boolean a(int paramInt1, int paramInt2, Editable paramEditable)
  {
    boolean bool2 = false;
    Object localObject = (bhx)super.getAdapter();
    int i2;
    int i1;
    label29:
    label45:
    label117:
    boolean bool1;
    if (localObject != null)
    {
      i2 = ((ListAdapter)localObject).getCount();
      i1 = 0;
      if (i1 >= i2) {
        break label142;
      }
      if (!c(i1)) {
        break label133;
      }
      if ((i1 == -1) || (!enoughToFilter()) || (paramInt2 != getSelectionEnd()) || (g())) {
        break label157;
      }
      if (!b(paramEditable.toString().substring(paramInt1, paramInt2).trim()))
      {
        paramInt1 = getListSelection();
        if ((paramInt1 != -1) && (c(paramInt1))) {
          break label148;
        }
        e(i1);
      }
      dismissDropDown();
      bool1 = true;
    }
    label133:
    label142:
    label148:
    label157:
    do
    {
      do
      {
        return bool1;
        i2 = 0;
        break;
        i1 += 1;
        break label29;
        i1 = -1;
        break label45;
        e(paramInt1);
        break label117;
        i2 = e.findTokenEnd(paramEditable, paramInt1);
        i1 = i2;
        if (paramEditable.length() > i2 + 1)
        {
          int i3 = paramEditable.charAt(i2 + 1);
          if (i3 != 44)
          {
            i1 = i2;
            if (i3 != 59) {}
          }
          else
          {
            i1 = i2 + 1;
          }
        }
        localObject = paramEditable.toString().substring(paramInt1, i1).trim();
        clearComposingText();
        bool1 = bool2;
      } while (((String)localObject).length() <= 0);
      bool1 = bool2;
    } while (((String)localObject).equals(" "));
    localObject = c((String)localObject);
    if (localObject != null)
    {
      QwertyKeyListener.markAsReplaced(paramEditable, paramInt1, paramInt2, "");
      localObject = d((bkn)localObject);
      if ((localObject != null) && (paramInt1 >= 0) && (paramInt2 >= 0)) {
        paramEditable.replace(paramInt1, paramInt2, (CharSequence)localObject);
      }
    }
    if (paramInt2 == getSelectionEnd()) {
      dismissDropDown();
    }
    n();
    return true;
  }
  
  public final boolean a(CharSequence paramCharSequence)
  {
    boolean bool = false;
    int i2;
    if (getSelectionEnd() == 0)
    {
      i1 = 0;
      i2 = length() - 1;
      if (i1 == i2) {
        break label60;
      }
    }
    label60:
    for (int i1 = paramCharSequence.charAt(i1);; i1 = paramCharSequence.charAt(i2))
    {
      if ((i1 == 44) || (i1 == 59)) {
        bool = true;
      }
      return bool;
      i1 = getSelectionEnd() - 1;
      break;
    }
  }
  
  public void append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (g != null) {
      removeTextChangedListener(g);
    }
    super.append(paramCharSequence, paramInt1, paramInt2);
    String str;
    if ((!TextUtils.isEmpty(paramCharSequence)) && (TextUtils.getTrimmedLength(paramCharSequence) > 0))
    {
      str = paramCharSequence.toString();
      paramCharSequence = str;
      if (!str.trim().endsWith(","))
      {
        super.append(E, 0, E.length());
        paramCharSequence = String.valueOf(str);
        str = String.valueOf(E);
        if (str.length() == 0) {
          break label160;
        }
      }
    }
    label160:
    for (paramCharSequence = paramCharSequence.concat(str);; paramCharSequence = new String(paramCharSequence))
    {
      if ((!TextUtils.isEmpty(paramCharSequence)) && (TextUtils.getTrimmedLength(paramCharSequence) > 0))
      {
        r += 1;
        q.add(paramCharSequence);
      }
      if (r > 0) {
        k();
      }
      f.post(ad);
      return;
    }
  }
  
  public final int b(int paramInt)
  {
    return -(int)((K + 2.0F * d) * Math.abs(getLineCount() - paramInt) + getPaddingBottom());
  }
  
  public final ListAdapter b(bkq parambkq)
  {
    return new bjk(getContext(), parambkq.c(), parambkq.d(), parambkq.e(), parambkq.f(), getAdapterb, this, h, o(), getAdaptero);
  }
  
  public final String b(bkn parambkn)
  {
    Object localObject = c;
    String str = d;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      parambkn = (bkn)localObject;
      if (!TextUtils.equals((CharSequence)localObject, str)) {}
    }
    else
    {
      parambkn = null;
    }
    if ((g()) && (biu.a(str))) {}
    for (parambkn = str.trim();; parambkn = new Rfc822Token(parambkn, (String)localObject, null).toString().trim())
    {
      int i1 = parambkn.indexOf(",");
      localObject = parambkn;
      if (e != null)
      {
        localObject = parambkn;
        if (!TextUtils.isEmpty(parambkn))
        {
          localObject = parambkn;
          if (i1 < parambkn.length() - 1) {
            localObject = (String)e.terminateToken(parambkn);
          }
        }
      }
      return (String)localObject;
      localObject = str;
      if (str != null)
      {
        Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(str);
        localObject = str;
        if (arrayOfRfc822Token != null)
        {
          localObject = str;
          if (arrayOfRfc822Token.length > 0) {
            localObject = arrayOfRfc822Token[0].getAddress();
          }
        }
      }
    }
  }
  
  public final void b()
  {
    if (D != null) {
      D.B_();
    }
    dismissDropDown();
  }
  
  public final boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (T != null) && (T.isValid(paramString));
  }
  
  public final bkn c(bkn parambkn)
  {
    bkn localbkn;
    if (parambkn == null) {
      localbkn = null;
    }
    String str;
    do
    {
      do
      {
        do
        {
          return localbkn;
          str = d;
          if ((!g()) && (g == -2L)) {
            return bkn.a(c, str, k);
          }
          localbkn = parambkn;
        } while (!bkn.a(g));
        if ((TextUtils.isEmpty(c)) || (TextUtils.equals(c, str))) {
          break;
        }
        localbkn = parambkn;
      } while (T == null);
      localbkn = parambkn;
    } while (T.isValid(str));
    return bkn.a(str, k);
  }
  
  public final void c()
  {
    if (e == null) {
      return;
    }
    if (m != null) {}
    for (long l1 = m.g().g; (m != null) && (l1 != -1L) && (!g()) && (l1 != -2L); l1 = -1L)
    {
      e();
      p();
      return;
    }
    if (getWidth() <= 0)
    {
      f.removeCallbacks(af);
      if (getVisibility() == 8)
      {
        W = true;
        return;
      }
      f.post(af);
      return;
    }
    if (r > 0) {
      k();
    }
    for (;;)
    {
      f.post(ad);
      break;
      Editable localEditable = getText();
      int i3 = getSelectionEnd();
      int i4 = e.findTokenStart(localEditable, i3);
      Object localObject = (bkq[])getText().getSpans(i4, i3, bkq.class);
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = getText();
        int i2 = e.findTokenEnd((CharSequence)localObject, i4);
        int i1 = i2;
        if (i2 < ((Editable)localObject).length())
        {
          i1 = i2;
          if (((Editable)localObject).charAt(i2) == ',') {
            i1 = g(i2);
          }
        }
        if (i1 != getSelectionEnd()) {
          c(i4, i1);
        } else {
          a(i4, i3, localEditable);
        }
      }
    }
  }
  
  public final void c(bkq parambkq)
  {
    int i1 = a(parambkq);
    int i2 = e(parambkq);
    Editable localEditable = getText();
    m = null;
    if ((i1 == -1) || (i2 == -1))
    {
      Log.w("RecipientEditTextView", "The chip doesn't exist or may be a chip a user was editing");
      setSelection(localEditable.length());
      m();
    }
    for (;;)
    {
      setCursorVisible(true);
      setSelection(localEditable.length());
      q();
      return;
      getText().removeSpan(parambkq);
      QwertyKeyListener.markAsReplaced(localEditable, i1, i2, "");
      localEditable.removeSpan(parambkq);
      try
      {
        if (!t) {
          localEditable.setSpan(a(parambkq.g()), i1, i2, 33);
        }
      }
      catch (NullPointerException parambkq)
      {
        Log.e("RecipientEditTextView", parambkq.getMessage(), parambkq);
      }
    }
  }
  
  public final void d()
  {
    Object localObject6 = null;
    if (getWidth() <= 0) {}
    while (r <= 0) {
      return;
    }
    for (;;)
    {
      synchronized (q)
      {
        Object localObject7 = getText();
        if (r > 50) {
          break label650;
        }
        i1 = 0;
        int i2;
        if (i1 < q.size())
        {
          Object localObject1 = (String)q.get(i1);
          int i4 = localObject7.toString().indexOf((String)localObject1);
          i2 = ((String)localObject1).length() + i4 - 1;
          if (i4 >= 0)
          {
            if ((i2 >= ((Editable)localObject7).length() - 2) || (((Editable)localObject7).charAt(i2) != ',')) {
              break label768;
            }
            i2 += 1;
            if (i1 < 2) {
              break label771;
            }
            if (u) {
              continue;
            }
            break label771;
            if (!b(i4, i2))
            {
              localObject5 = localObject7.toString().substring(i4, i2);
              localObject1 = ((String)localObject5).trim();
              int i5 = ((String)localObject1).lastIndexOf(',');
              if ((i5 == -1) || (i5 != ((String)localObject1).length() - 1)) {
                break label765;
              }
              localObject5 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
              localObject1 = c((String)localObject5);
              if (localObject1 == null) {}
            }
          }
          try
          {
            if (t) {
              break label776;
            }
            if (i3 != 0)
            {
              localObject1 = a((bkn)localObject1);
              ((Editable)localObject7).setSpan(localObject1, i4, i2, 33);
              if (localObject1 != null)
              {
                if (v == null) {
                  v = new ArrayList();
                }
                ((bkq)localObject1).a((String)localObject5);
                v.add(localObject1);
              }
              r -= 1;
              i1 += 1;
              continue;
              i3 = 0;
              continue;
            }
            localObject1 = new bkr((bkn)localObject1);
            continue;
            if (r > 0) {
              continue;
            }
          }
          catch (NullPointerException localNullPointerException)
          {
            Log.e("RecipientEditTextView", localNullPointerException.getMessage(), localNullPointerException);
          }
        }
        Object localObject2 = f();
        Object localObject5 = getText();
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          localObject7 = (bkd[])getText().getSpans(0, getText().length(), bkd.class);
          localObject2 = localObject6;
          if (localObject7 != null)
          {
            localObject2 = localObject6;
            if (localObject7.length > 0) {
              localObject2 = localObject7[0];
            }
          }
          o = ((bks)localObject2);
          if (o == null) {
            break label633;
          }
          i1 = ((Spannable)localObject5).getSpanEnd(o);
          localObject2 = getText();
          i2 = ((Editable)localObject2).length();
          if (i2 > i1)
          {
            if (Log.isLoggable("RecipientEditTextView", 3))
            {
              localObject5 = String.valueOf(localObject2);
              new StringBuilder(String.valueOf(localObject5).length() + 61).append("There were extra characters after the last tokenizable entry.").append((String)localObject5);
            }
            ((Editable)localObject2).delete(i1 + 1, i2);
          }
        }
        if ((v == null) || (v.size() <= 0) || (v.size() > 50)) {
          break label753;
        }
        if ((!hasFocus()) && (v.size() >= 2)) {
          break label658;
        }
        new bkj(this).execute(new Void[0]);
        v = null;
        r = 0;
        q.clear();
        return;
      }
      label633:
      int i1 = getText().getSpanEnd(i());
      continue;
      label650:
      t = true;
      continue;
      label658:
      z = new bka(this);
      z.execute(new ArrayList[] { new ArrayList(v.subList(0, 2)) });
      if (v.size() > 2) {}
      for (v = new ArrayList(v.subList(2, v.size()));; v = null)
      {
        p();
        break;
      }
      label753:
      v = null;
      p();
      continue;
      label765:
      continue;
      label768:
      continue;
      label771:
      int i3 = 1;
      continue;
      label776:
      Object localObject4 = null;
    }
  }
  
  public final boolean d(bkq parambkq)
  {
    long l1 = parambkq.c();
    return (l1 == -1L) || ((!g()) && (l1 == -2L));
  }
  
  public final void e()
  {
    if (m != null)
    {
      c(m);
      m = null;
    }
    setCursorVisible(true);
    setSelection(getText().length());
  }
  
  public final bkq[] f()
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList((bkq[])getText().getSpans(0, getText().length(), bkq.class)));
    Collections.sort(localArrayList, new bjo(this, getText()));
    return (bkq[])localArrayList.toArray(new bkq[localArrayList.size()]);
  }
  
  public final boolean g()
  {
    return ((bhx)super.getAdapter() != null) && (getAdapterb == 1);
  }
  
  public final bhx h()
  {
    return (bhx)super.getAdapter();
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    y = true;
    int i1 = getDropDownAnchor();
    if (i1 != -1) {
      i = getRootView().findViewById(i1);
    }
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    int i1 = imeOptions & 0xFF;
    if ((i1 & 0x6) != 0)
    {
      imeOptions = (i1 ^ imeOptions);
      imeOptions |= 0x6;
    }
    if ((imeOptions & 0x40000000) != 0) {
      imeOptions &= 0xBFFFFFFF;
    }
    actionId = 6;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (String str = null;; str = getContext().getString(bji.c))
    {
      actionLabel = str;
      return localInputConnection;
    }
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    y = false;
    q();
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    case 2: 
    case 4: 
    default: 
      return false;
    case 1: 
      return paramDragEvent.getClipDescription().hasMimeType("text/plain");
    case 5: 
      requestFocus();
      return true;
    }
    a(paramDragEvent.getClipData());
    return true;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (m()) {}
      do
      {
        return true;
        if (m != null)
        {
          e();
          return true;
        }
      } while ((hasFocus()) && (l()));
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
    {
      c();
      return;
    }
    if (u) {
      setMaxLines(Integer.MAX_VALUE);
    }
    Object localObject;
    if (o != null)
    {
      paramRect = getText();
      paramRect.removeSpan(o);
      o = null;
      if ((w != null) && (w.size() > 0))
      {
        localObject = f();
        if ((localObject != null) && (localObject.length != 0)) {
          break label165;
        }
      }
    }
    label91:
    setCursorVisible(true);
    paramRect = getText();
    if ((paramRect != null) && (paramRect.length() > 0)) {}
    for (paramInt = paramRect.length();; paramInt = 0)
    {
      setSelection(paramInt);
      if ((v == null) || (v.size() <= 0)) {
        break;
      }
      new bkj(this).execute(new Void[0]);
      v = null;
      return;
      label165:
      paramInt = paramRect.getSpanEnd(localObject[(localObject.length - 1)]);
      paramRect = getText();
      localObject = w.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkq localbkq = (bkq)((Iterator)localObject).next();
        String str = (String)localbkq.h();
        int i1 = paramRect.toString().indexOf(str, paramInt);
        paramInt = Math.min(paramRect.length(), str.length() + i1);
        if (i1 != -1) {
          paramRect.setSpan(localbkq, i1, paramInt, 33);
        }
      }
      w.clear();
      break label91;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < 0) {}
    int i1;
    do
    {
      do
      {
        return;
        paramAdapterView = ((bhx)super.getAdapter()).a(paramInt);
        if (a != 1) {
          break;
        }
      } while (D == null);
      D.a(this, o);
      return;
      i1 = e(paramInt);
    } while ((i1 < 0) || (A == null));
    A.a(i1, paramInt);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((m != null) && (paramInt == 67))
    {
      if ((j != null) && (j.isShowing())) {
        j.dismiss();
      }
      h(m);
    }
    switch (paramInt)
    {
    }
    do
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      do
      {
        return bool;
        if (!paramKeyEvent.hasNoModifiers()) {
          break;
        }
      } while (m());
      if (m != null)
      {
        e();
        return true;
      }
    } while (!l());
    return true;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (m != null))
    {
      e();
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.onKeyUp(paramInt, paramKeyEvent);
      if (paramKeyEvent.hasNoModifiers()) {
        if (m != null) {
          e();
        } else {
          m();
        }
      }
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (m != null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        paramMotionEvent = d(a(paramMotionEvent.getX(), paramMotionEvent.getY()));
      } while (paramMotionEvent == null);
      if (ac)
      {
        localObject = gd;
        startDrag(ClipData.newPlainText((CharSequence)localObject, String.valueOf(localObject).length() + 1 + (String)localObject + ','), new bkh(this, paramMotionEvent), null, 0);
        h(paramMotionEvent);
        return;
      }
      paramMotionEvent = gd;
      localObject = getContext();
    } while ((!y) || (localObject == null) || (!(localObject instanceof Activity)));
    bii localbii = new bii();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("text", paramMotionEvent);
    localbii.setArguments(localBundle);
    localbii.show(((Activity)localObject).getFragmentManager(), "chips-copy-dialog");
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!TextUtils.isEmpty(getText()))
    {
      super.onRestoreInstanceState(null);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    e();
    return super.onSaveInstanceState();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onSelectionChanged(int paramInt1, int paramInt2)
  {
    bkq localbkq = i();
    if ((m == null) && (localbkq != null) && (paramInt1 < getText().getSpanEnd(localbkq))) {
      setSelection(Math.min(getText().getSpanEnd(localbkq) + 1, getText().length()));
    }
    super.onSelectionChanged(paramInt1, paramInt2);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if (r <= 0) {
        break label73;
      }
      k();
    }
    while ((x == null) && (!ab))
    {
      Object localObject = getParent();
      for (;;)
      {
        if ((localObject != null) && (!(localObject instanceof ScrollView)))
        {
          localObject = ((ViewParent)localObject).getParent();
          continue;
          label73:
          localObject = f();
          if (localObject == null) {
            break;
          }
          paramInt2 = localObject.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            bkq localbkq = localObject[paramInt1];
            Rect localRect = localbkq.i();
            if ((getWidth() > 0) && (right - left > getWidth() - getPaddingLeft() - getPaddingRight())) {
              a(localbkq, localbkq.g());
            }
            paramInt1 += 1;
          }
          break;
        }
      }
      if (localObject != null) {
        x = ((ScrollView)localObject);
      }
      ab = true;
    }
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt == 16908322)
    {
      a(((ClipboardManager)getContext().getSystemService("clipboard")).getPrimaryClip());
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!isFocused())
    {
      bool2 = super.onTouchEvent(paramMotionEvent);
      return bool2;
    }
    boolean bool1 = super.onTouchEvent(paramMotionEvent);
    int i2 = paramMotionEvent.getAction();
    if (m == null) {
      aa.onTouchEvent(paramMotionEvent);
    }
    label95:
    int i1;
    if (i2 == 1)
    {
      paramMotionEvent = d(a(paramMotionEvent.getX(), paramMotionEvent.getY()));
      if (paramMotionEvent != null) {
        if ((m != null) && (m != paramMotionEvent))
        {
          e();
          f(paramMotionEvent);
          i1 = 1;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (i2 != 1) {
        break;
      }
      bool2 = bool1;
      if (i1 != 0) {
        break;
      }
      e();
      return bool1;
      if (m == null)
      {
        m();
        f(paramMotionEvent);
        break label95;
      }
      if (!m.a()) {
        break label95;
      }
      e();
      break label95;
      if ((m != null) && (g(m))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
  }
  
  public void performFiltering(CharSequence paramCharSequence, int paramInt)
  {
    boolean bool = b(paramCharSequence);
    if ((enoughToFilter()) && (!bool))
    {
      int i1 = getSelectionEnd();
      int i2 = e.findTokenStart(paramCharSequence, i1);
      bkq[] arrayOfbkq = (bkq[])getText().getSpans(i2, i1, bkq.class);
      if ((arrayOfbkq != null) && (arrayOfbkq.length > 0)) {
        dismissDropDown();
      }
    }
    else if (bool)
    {
      dismissDropDown();
      return;
    }
    super.performFiltering(paramCharSequence, paramInt);
  }
  
  public void performValidation() {}
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    g = null;
    super.removeTextChangedListener(paramTextWatcher);
  }
  
  protected void replaceText(CharSequence paramCharSequence) {}
  
  public <T extends ListAdapter,  extends Filterable> void setAdapter(T paramT)
  {
    super.setAdapter(paramT);
    paramT = (bhx)paramT;
    q = new bjv(this);
    f = h;
    f.c = a;
  }
  
  public void setDropDownAnchor(int paramInt)
  {
    super.setDropDownAnchor(paramInt);
    if (paramInt != -1) {
      i = getRootView().findViewById(paramInt);
    }
  }
  
  public void setTokenizer(MultiAutoCompleteTextView.Tokenizer paramTokenizer)
  {
    e = paramTokenizer;
    super.setTokenizer(e);
  }
  
  public void setValidator(AutoCompleteTextView.Validator paramValidator)
  {
    T = paramValidator;
    super.setValidator(paramValidator);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt != 8) && (W))
    {
      W = false;
      f.post(af);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */