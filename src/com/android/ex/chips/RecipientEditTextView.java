package com.android.ex.chips;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
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
import android.text.style.ImageSpan;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Patterns;
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
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView.Validator;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView.Tokenizer;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecipientEditTextView
  extends MultiAutoCompleteTextView
  implements DialogInterface.OnDismissListener, ActionMode.Callback, GestureDetector.OnGestureListener, View.OnClickListener, AdapterView.OnItemClickListener, TextView.OnEditorActionListener, RecipientAlternatesAdapter.OnCheckedItemChangedListener
{
  private static int DISMISS = "dismiss".hashCode();
  private static int sSelectedTextColor = -1;
  private final Runnable mAddTextWatcher = new Runnable()
  {
    public void run()
    {
      if (mTextWatcher == null)
      {
        RecipientEditTextView.access$002(RecipientEditTextView.this, new RecipientEditTextView.RecipientTextWatcher(RecipientEditTextView.this, null));
        addTextChangedListener(mTextWatcher);
      }
    }
  };
  private ListPopupWindow mAddressPopup;
  private int mAlternatesLayout;
  private AdapterView.OnItemClickListener mAlternatesListener;
  private ListPopupWindow mAlternatesPopup;
  private int mCheckedItem;
  private Drawable mChipBackground = null;
  private Drawable mChipBackgroundPressed;
  private Drawable mChipDelete = null;
  private float mChipFontSize;
  private float mChipHeight;
  private int mChipPadding;
  private String mCopyAddress;
  private Dialog mCopyDialog;
  private Bitmap mDefaultContactPhoto;
  private Runnable mDelayedShrink = new Runnable()
  {
    public void run()
    {
      RecipientEditTextView.this.shrink();
    }
  };
  private boolean mDragEnabled = false;
  private GestureDetector mGestureDetector;
  private Runnable mHandlePendingChips = new Runnable()
  {
    public void run()
    {
      handlePendingChips();
    }
  };
  private Handler mHandler;
  private IndividualReplacementTask mIndividualReplacements;
  private Drawable mInvalidChipBackground;
  private float mLineSpacingExtra;
  private int mMaxLines;
  private ImageSpan mMoreChip;
  private TextView mMoreItem;
  private boolean mNoChips = false;
  private final ArrayList<String> mPendingChips = new ArrayList();
  private int mPendingChipsCount = 0;
  private ArrayList<RecipientChip> mRemovedSpans;
  private ScrollView mScrollView;
  private RecipientChip mSelectedChip;
  private boolean mShouldShrink = true;
  private ArrayList<RecipientChip> mTemporaryRecipients;
  private TextWatcher mTextWatcher;
  private MultiAutoCompleteTextView.Tokenizer mTokenizer;
  private boolean mTriedGettingScrollView;
  private AutoCompleteTextView.Validator mValidator;
  
  public RecipientEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setChipDimensions(paramContext, paramAttributeSet);
    if (sSelectedTextColor == -1) {
      sSelectedTextColor = paramContext.getResources().getColor(17170443);
    }
    mAlternatesPopup = new ListPopupWindow(paramContext);
    mAddressPopup = new ListPopupWindow(paramContext);
    mCopyDialog = new Dialog(paramContext);
    mAlternatesListener = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        mAlternatesPopup.setOnItemClickListener(null);
        replaceChip(mSelectedChip, ((RecipientAlternatesAdapter)paramAnonymousAdapterView.getAdapter()).getRecipientEntry(paramAnonymousInt));
        paramAnonymousAdapterView = Message.obtain(mHandler, RecipientEditTextView.DISMISS);
        obj = mAlternatesPopup;
        mHandler.sendMessageDelayed(paramAnonymousAdapterView, 300L);
        clearComposingText();
      }
    };
    setInputType(getInputType() | 0x80000);
    setOnItemClickListener(this);
    setCustomSelectionActionModeCallback(this);
    mHandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (what == RecipientEditTextView.DISMISS)
        {
          ((ListPopupWindow)obj).dismiss();
          return;
        }
        super.handleMessage(paramAnonymousMessage);
      }
    };
    mTextWatcher = new RecipientTextWatcher(null);
    addTextChangedListener(mTextWatcher);
    mGestureDetector = new GestureDetector(paramContext, this);
    setOnEditorActionListener(this);
    mMaxLines = getLineCount();
  }
  
  private boolean alreadyHasChip(int paramInt1, int paramInt2)
  {
    if (mNoChips) {
      return true;
    }
    RecipientChip[] arrayOfRecipientChip = (RecipientChip[])getSpannable().getSpans(paramInt1, paramInt2, RecipientChip.class);
    return (arrayOfRecipientChip != null) && (arrayOfRecipientChip.length != 0);
  }
  
  private float calculateAvailableWidth(boolean paramBoolean)
  {
    return getWidth() - getPaddingLeft() - getPaddingRight() - mChipPadding * 2;
  }
  
  private int calculateOffsetFromBottom(int paramInt)
  {
    int i = getLineCount();
    return -((int)mChipHeight * (i - (paramInt + 1)) + getPaddingBottom() + getPaddingTop()) + getDropDownVerticalOffset();
  }
  
  private void checkChipWidths()
  {
    RecipientChip[] arrayOfRecipientChip = getSortedRecipients();
    if (arrayOfRecipientChip != null)
    {
      int j = arrayOfRecipientChip.length;
      int i = 0;
      while (i < j)
      {
        RecipientChip localRecipientChip = arrayOfRecipientChip[i];
        Rect localRect = localRecipientChip.getDrawable().getBounds();
        if ((getWidth() > 0) && (right - left > getWidth())) {
          replaceChip(localRecipientChip, localRecipientChip.getEntry());
        }
        i += 1;
      }
    }
  }
  
  private boolean chipsPending()
  {
    return (mPendingChipsCount > 0) || ((mRemovedSpans != null) && (mRemovedSpans.size() > 0));
  }
  
  private void clearSelectedChip()
  {
    if (mSelectedChip != null)
    {
      unselectChip(mSelectedChip);
      mSelectedChip = null;
    }
    setCursorVisible(true);
  }
  
  private void commitByCharacter()
  {
    if (mTokenizer == null) {
      return;
    }
    Editable localEditable = getText();
    int i = getSelectionEnd();
    int j = mTokenizer.findTokenStart(localEditable, i);
    if (shouldCreateChip(j, i)) {
      commitChip(j, i, localEditable);
    }
    setSelection(getText().length());
  }
  
  private boolean commitChip(int paramInt1, int paramInt2, Editable paramEditable)
  {
    Object localObject = getAdapter();
    if ((localObject != null) && (((ListAdapter)localObject).getCount() > 0) && (enoughToFilter()) && (paramInt2 == getSelectionEnd()) && (!isPhoneQuery()))
    {
      submitItemAtPosition(0);
      dismissDropDown();
      return true;
    }
    int j = mTokenizer.findTokenEnd(paramEditable, paramInt1);
    int i = j;
    if (paramEditable.length() > j + 1)
    {
      int k = paramEditable.charAt(j + 1);
      if (k != 44)
      {
        i = j;
        if (k != 59) {}
      }
      else
      {
        i = j + 1;
      }
    }
    localObject = paramEditable.toString().substring(paramInt1, i).trim();
    clearComposingText();
    if ((localObject != null) && (((String)localObject).length() > 0) && (!((String)localObject).equals(" ")))
    {
      localObject = createTokenizedEntry((String)localObject);
      if (localObject != null)
      {
        QwertyKeyListener.markAsReplaced(paramEditable, paramInt1, paramInt2, "");
        localObject = createChip((RecipientEntry)localObject, false);
        if ((localObject != null) && (paramInt1 > -1) && (paramInt2 > -1)) {
          paramEditable.replace(paramInt1, paramInt2, (CharSequence)localObject);
        }
      }
      if (paramInt2 == getSelectionEnd()) {
        dismissDropDown();
      }
      sanitizeBetween();
      return true;
    }
    return false;
  }
  
  private boolean commitDefault()
  {
    if (mTokenizer == null) {}
    Editable localEditable;
    int i;
    int j;
    do
    {
      return false;
      localEditable = getText();
      i = getSelectionEnd();
      j = mTokenizer.findTokenStart(localEditable, i);
    } while (!shouldCreateChip(j, i));
    int k = mTokenizer.findTokenEnd(getText(), j);
    if (k != getSelectionEnd())
    {
      handleEdit(j, k);
      return true;
    }
    return commitChip(j, i, localEditable);
  }
  
  private RecipientChip constructChipSpan(RecipientEntry paramRecipientEntry, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws NullPointerException
  {
    if (mChipBackground == null) {
      throw new NullPointerException("Unable to render any chips as setChipDimensions was not called.");
    }
    Object localObject = getLayout();
    TextPaint localTextPaint = getPaint();
    float f = localTextPaint.getTextSize();
    int i = localTextPaint.getColor();
    if (paramBoolean1) {}
    for (localObject = createSelectedChip(paramRecipientEntry, localTextPaint, (Layout)localObject);; localObject = createUnselectedChip(paramRecipientEntry, localTextPaint, (Layout)localObject, paramBoolean2))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), (Bitmap)localObject);
      localBitmapDrawable.setBounds(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      paramRecipientEntry = new RecipientChip(localBitmapDrawable, paramRecipientEntry, paramInt);
      localTextPaint.setTextSize(f);
      localTextPaint.setColor(i);
      return paramRecipientEntry;
    }
  }
  
  private ListAdapter createAlternatesAdapter(RecipientChip paramRecipientChip)
  {
    return new RecipientAlternatesAdapter(getContext(), paramRecipientChip.getContactId(), paramRecipientChip.getDataId(), mAlternatesLayout, ((BaseRecipientAdapter)getAdapter()).getQueryType(), this);
  }
  
  private CharSequence createChip(RecipientEntry paramRecipientEntry, boolean paramBoolean)
  {
    Object localObject = createAddressText(paramRecipientEntry);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = null;
    }
    int i;
    int j;
    SpannableString localSpannableString;
    do
    {
      return (CharSequence)localObject;
      i = getSelectionEnd();
      i = mTokenizer.findTokenStart(getText(), i);
      j = ((String)localObject).length();
      localSpannableString = new SpannableString((CharSequence)localObject);
      localObject = localSpannableString;
    } while (mNoChips);
    try
    {
      paramRecipientEntry = constructChipSpan(paramRecipientEntry, i, paramBoolean, false);
      localSpannableString.setSpan(paramRecipientEntry, 0, j - 1, 33);
      paramRecipientEntry.setOriginalText(localSpannableString.toString());
      return localSpannableString;
    }
    catch (NullPointerException paramRecipientEntry)
    {
      Log.e("RecipientEditTextView", paramRecipientEntry.getMessage(), paramRecipientEntry);
    }
    return null;
  }
  
  private MoreImageSpan createMoreSpan(int paramInt)
  {
    Object localObject = String.format(mMoreItem.getText().toString(), new Object[] { Integer.valueOf(paramInt) });
    TextPaint localTextPaint = new TextPaint(getPaint());
    localTextPaint.setTextSize(mMoreItem.getTextSize());
    localTextPaint.setColor(mMoreItem.getCurrentTextColor());
    int k = (int)localTextPaint.measureText((String)localObject) + mMoreItem.getPaddingLeft() + mMoreItem.getPaddingRight();
    int j = getLineHeight();
    Bitmap localBitmap = Bitmap.createBitmap(k, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramInt = j;
    Layout localLayout = getLayout();
    int i = paramInt;
    if (localLayout != null) {
      i = paramInt - localLayout.getLineDescent(0);
    }
    localCanvas.drawText((String)localObject, 0, ((String)localObject).length(), 0.0F, i, localTextPaint);
    localObject = new BitmapDrawable(getResources(), localBitmap);
    ((BitmapDrawable)localObject).setBounds(0, 0, k, j);
    return new MoreImageSpan((Drawable)localObject);
  }
  
  private void createReplacementChip(int paramInt1, int paramInt2, Editable paramEditable)
  {
    if (alreadyHasChip(paramInt1, paramInt2)) {}
    Object localObject2;
    RecipientEntry localRecipientEntry;
    do
    {
      return;
      localObject2 = paramEditable.toString().substring(paramInt1, paramInt2);
      localObject1 = localObject2;
      if (((String)localObject2).trim().lastIndexOf(',') == ((String)localObject2).length() - 1) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
      }
      localRecipientEntry = createTokenizedEntry((String)localObject1);
    } while (localRecipientEntry == null);
    localObject1 = createAddressText(localRecipientEntry);
    int j = ((String)localObject1).length();
    SpannableString localSpannableString = new SpannableString((CharSequence)localObject1);
    int i = getSelectionEnd();
    label129:
    Object localObject4;
    if (mTokenizer != null)
    {
      i = mTokenizer.findTokenStart(getText(), i);
      localObject4 = null;
      localObject2 = null;
      localObject1 = localObject4;
    }
    for (;;)
    {
      try
      {
        if (mNoChips) {
          continue;
        }
        localObject1 = localObject4;
        if (TextUtils.isEmpty(localRecipientEntry.getDisplayName())) {
          continue;
        }
        localObject1 = localObject4;
        if (!TextUtils.equals(localRecipientEntry.getDisplayName(), localRecipientEntry.getDestination())) {
          continue;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.e("RecipientEditTextView", localNullPointerException.getMessage(), localNullPointerException);
        Object localObject3 = localObject1;
        continue;
        boolean bool = true;
        continue;
      }
      localObject1 = localObject4;
      localObject2 = constructChipSpan(localRecipientEntry, i, false, bool);
      localObject1 = localObject2;
      localSpannableString.setSpan(localObject2, 0, j - 1, 33);
      paramEditable.replace(paramInt1, paramInt2, localSpannableString);
      if (localObject2 == null) {
        break;
      }
      if (mTemporaryRecipients == null) {
        mTemporaryRecipients = new ArrayList();
      }
      ((RecipientChip)localObject2).setOriginalText(localSpannableString.toString());
      mTemporaryRecipients.add(localObject2);
      return;
      i = 0;
      break label129;
      bool = false;
    }
  }
  
  private Bitmap createSelectedChip(RecipientEntry paramRecipientEntry, TextPaint paramTextPaint, Layout paramLayout)
  {
    int i = (int)mChipHeight;
    paramLayout = new float[1];
    paramTextPaint.getTextWidths(" ", paramLayout);
    CharSequence localCharSequence = ellipsizeText(createChipDisplayText(paramRecipientEntry), paramTextPaint, calculateAvailableWidth(true) - i - paramLayout[0]);
    int j = Math.max(i * 2, (int)Math.floor(paramTextPaint.measureText(localCharSequence, 0, localCharSequence.length())) + mChipPadding * 2 + i);
    paramRecipientEntry = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
    paramLayout = new Canvas(paramRecipientEntry);
    if (mChipBackgroundPressed != null)
    {
      mChipBackgroundPressed.setBounds(0, 0, j, i);
      mChipBackgroundPressed.draw(paramLayout);
      paramTextPaint.setColor(sSelectedTextColor);
      paramLayout.drawText(localCharSequence, 0, localCharSequence.length(), mChipPadding, getTextYOffset((String)localCharSequence, paramTextPaint, i), paramTextPaint);
      paramTextPaint = new Rect();
      mChipBackgroundPressed.getPadding(paramTextPaint);
      mChipDelete.setBounds(j - i + left, top + 0, j - right, i - bottom);
      mChipDelete.draw(paramLayout);
      return paramRecipientEntry;
    }
    Log.w("RecipientEditTextView", "Unable to draw a background for the chips as it was never set");
    return paramRecipientEntry;
  }
  
  private ListAdapter createSingleAddressAdapter(RecipientChip paramRecipientChip)
  {
    return new SingleRecipientArrayAdapter(getContext(), mAlternatesLayout, paramRecipientChip.getEntry());
  }
  
  private RecipientEntry createTokenizedEntry(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ((isPhoneQuery()) && (isPhoneNumber(paramString))) {
      return RecipientEntry.constructFakeEntry(paramString);
    }
    Object localObject1 = Rfc822Tokenizer.tokenize(paramString);
    Object localObject3;
    if ((isValid(paramString)) && (localObject1 != null) && (localObject1.length > 0))
    {
      localObject3 = localObject1[0].getName();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = paramString;
        if (!isPhoneQuery())
        {
          localObject1 = paramString;
          if (!TextUtils.isEmpty(paramString)) {
            localObject1 = paramString.trim();
          }
          int i = ((String)localObject1).charAt(((String)localObject1).length() - 1);
          if (i != 44)
          {
            localObject2 = localObject1;
            if (i != 59) {}
          }
          else
          {
            localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
          }
        }
        return RecipientEntry.constructGeneratedEntry((String)localObject3, (String)localObject2);
      }
      localObject1 = localObject1[0].getAddress();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        return RecipientEntry.constructFakeEntry((String)localObject1);
      }
    }
    Object localObject2 = null;
    localObject1 = localObject2;
    if (mValidator != null)
    {
      localObject1 = localObject2;
      if (!mValidator.isValid(paramString))
      {
        localObject2 = mValidator.fixText(paramString).toString();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (!((String)localObject2).contains(paramString)) {
            break label256;
          }
          localObject3 = Rfc822Tokenizer.tokenize((CharSequence)localObject2);
          localObject1 = localObject2;
          if (localObject3.length > 0) {
            localObject1 = localObject3[0].getAddress();
          }
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      return RecipientEntry.constructFakeEntry((String)localObject1);
      label256:
      localObject1 = null;
      break;
      localObject1 = paramString;
    }
  }
  
  private Bitmap createUnselectedChip(RecipientEntry paramRecipientEntry, TextPaint paramTextPaint, Layout paramLayout, boolean paramBoolean)
  {
    int j = (int)mChipHeight;
    paramLayout = new float[1];
    paramTextPaint.getTextWidths(" ", paramLayout);
    CharSequence localCharSequence = ellipsizeText(createChipDisplayText(paramRecipientEntry), paramTextPaint, calculateAvailableWidth(false) - j - paramLayout[0]);
    int k = Math.max(j * 2, (int)Math.floor(paramTextPaint.measureText(localCharSequence, 0, localCharSequence.length())) + mChipPadding * 2 + j);
    Bitmap localBitmap = Bitmap.createBitmap(k, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramLayout = getChipBackground(paramRecipientEntry);
    if (paramLayout != null)
    {
      paramLayout.setBounds(0, 0, k, j);
      paramLayout.draw(localCanvas);
      long l = paramRecipientEntry.getContactId();
      int i;
      if (isPhoneQuery()) {
        if (l != -1L)
        {
          i = 1;
          if (i == 0) {
            break label445;
          }
          Object localObject = paramRecipientEntry.getPhotoBytes();
          paramLayout = (Layout)localObject;
          if (localObject == null)
          {
            paramLayout = (Layout)localObject;
            if (paramRecipientEntry.getPhotoThumbnailUri() != null)
            {
              ((BaseRecipientAdapter)getAdapter()).fetchPhoto(paramRecipientEntry, paramRecipientEntry.getPhotoThumbnailUri());
              paramLayout = paramRecipientEntry.getPhotoBytes();
            }
          }
          if (paramLayout == null) {
            break label437;
          }
          paramRecipientEntry = BitmapFactory.decodeByteArray(paramLayout, 0, paramLayout.length);
          label218:
          if (paramRecipientEntry != null)
          {
            paramLayout = new RectF(0.0F, 0.0F, paramRecipientEntry.getWidth(), paramRecipientEntry.getHeight());
            localObject = new Rect();
            mChipBackground.getPadding((Rect)localObject);
            localObject = new RectF(k - j + left, top + 0, k - right, j - bottom);
            Matrix localMatrix = new Matrix();
            localMatrix.setRectToRect(paramLayout, (RectF)localObject, Matrix.ScaleToFit.FILL);
            localCanvas.drawBitmap(paramRecipientEntry, localMatrix, paramTextPaint);
          }
        }
      }
      for (;;)
      {
        paramTextPaint.setColor(getContext().getResources().getColor(17170444));
        localCanvas.drawText(localCharSequence, 0, localCharSequence.length(), mChipPadding, getTextYOffset((String)localCharSequence, paramTextPaint, j), paramTextPaint);
        return localBitmap;
        i = 0;
        break;
        if ((l != -1L) && (l != -2L) && (!TextUtils.isEmpty(paramRecipientEntry.getDisplayName())))
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        label437:
        paramRecipientEntry = mDefaultContactPhoto;
        break label218;
        label445:
        if ((paramBoolean) && (!isPhoneQuery())) {}
      }
    }
    Log.w("RecipientEditTextView", "Unable to draw a background for the chips as it was never set");
    return localBitmap;
  }
  
  private RecipientEntry createValidatedEntry(RecipientEntry paramRecipientEntry)
  {
    if (paramRecipientEntry == null) {
      return null;
    }
    String str = paramRecipientEntry.getDestination();
    if ((!isPhoneQuery()) && (paramRecipientEntry.getContactId() == -2L)) {
      return RecipientEntry.constructGeneratedEntry(paramRecipientEntry.getDisplayName(), str);
    }
    if ((RecipientEntry.isCreatedRecipient(paramRecipientEntry.getContactId())) && ((TextUtils.isEmpty(paramRecipientEntry.getDisplayName())) || (TextUtils.equals(paramRecipientEntry.getDisplayName(), str)) || ((mValidator != null) && (!mValidator.isValid(str))))) {
      return RecipientEntry.constructFakeEntry(str);
    }
    return paramRecipientEntry;
  }
  
  private CharSequence ellipsizeText(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat)
  {
    paramTextPaint.setTextSize(mChipFontSize);
    if ((paramFloat <= 0.0F) && (Log.isLoggable("RecipientEditTextView", 3))) {
      Log.d("RecipientEditTextView", "Max width is negative: " + paramFloat);
    }
    return TextUtils.ellipsize(paramCharSequence, paramTextPaint, paramFloat, TextUtils.TruncateAt.END);
  }
  
  private void expand()
  {
    if (mShouldShrink) {
      setMaxLines(Integer.MAX_VALUE);
    }
    removeMoreChip();
    setCursorVisible(true);
    Editable localEditable = getText();
    if ((localEditable != null) && (localEditable.length() > 0)) {}
    for (int i = localEditable.length();; i = 0)
    {
      setSelection(i);
      if ((mTemporaryRecipients != null) && (mTemporaryRecipients.size() > 0))
      {
        new RecipientReplacementTask(null).execute(new Void[0]);
        mTemporaryRecipients = null;
      }
      return;
    }
  }
  
  private RecipientChip findChip(int paramInt)
  {
    int i = 0;
    RecipientChip[] arrayOfRecipientChip = (RecipientChip[])getSpannable().getSpans(0, getText().length(), RecipientChip.class);
    while (i < arrayOfRecipientChip.length)
    {
      RecipientChip localRecipientChip = arrayOfRecipientChip[i];
      int j = getChipStart(localRecipientChip);
      int k = getChipEnd(localRecipientChip);
      if ((paramInt >= j) && (paramInt <= k)) {
        return localRecipientChip;
      }
      i += 1;
    }
    return null;
  }
  
  private int findText(Editable paramEditable, int paramInt)
  {
    if (paramEditable.charAt(paramInt) != ' ') {
      return paramInt;
    }
    return -1;
  }
  
  private boolean focusNext()
  {
    View localView = focusSearch(130);
    if (localView != null)
    {
      localView.requestFocus();
      return true;
    }
    return false;
  }
  
  private int getChipEnd(RecipientChip paramRecipientChip)
  {
    return getSpannable().getSpanEnd(paramRecipientChip);
  }
  
  private int getChipStart(RecipientChip paramRecipientChip)
  {
    return getSpannable().getSpanStart(paramRecipientChip);
  }
  
  private float getTextYOffset(String paramString, TextPaint paramTextPaint, int paramInt)
  {
    Rect localRect = new Rect();
    paramTextPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return paramInt - (paramInt - (bottom - top)) / 2 - (int)paramTextPaint.descent();
  }
  
  private void handleEdit(int paramInt1, int paramInt2)
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
      localObject = RecipientEntry.constructFakeEntry((String)localObject);
      QwertyKeyListener.markAsReplaced(localEditable, paramInt1, paramInt2, "");
      localObject = createChip((RecipientEntry)localObject, false);
      paramInt2 = getSelectionEnd();
      if ((localObject != null) && (paramInt1 > -1) && (paramInt2 > -1)) {
        localEditable.replace(paramInt1, paramInt2, (CharSequence)localObject);
      }
    }
    dismissDropDown();
  }
  
  private void handlePasteAndReplace()
  {
    ArrayList localArrayList = handlePaste();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      new IndividualReplacementTask(null).execute(new Object[] { localArrayList });
    }
  }
  
  private void handlePasteClip(ClipData paramClipData)
  {
    removeTextChangedListener(mTextWatcher);
    if ((paramClipData != null) && (paramClipData.getDescription().hasMimeType("text/plain")))
    {
      int i = 0;
      if (i < paramClipData.getItemCount())
      {
        CharSequence localCharSequence = paramClipData.getItemAt(i).getText();
        int k;
        Editable localEditable;
        if (localCharSequence != null)
        {
          int j = getSelectionStart();
          k = getSelectionEnd();
          localEditable = getText();
          if ((j < 0) || (k < 0) || (j == k)) {
            break label106;
          }
          localEditable.append(localCharSequence, j, k);
        }
        for (;;)
        {
          handlePasteAndReplace();
          i += 1;
          break;
          label106:
          localEditable.insert(k, localCharSequence);
        }
      }
    }
    mHandler.post(mAddTextWatcher);
  }
  
  private boolean isInDelete(RecipientChip paramRecipientChip, int paramInt, float paramFloat1, float paramFloat2)
  {
    return (paramRecipientChip.isSelected()) && (paramInt == getChipEnd(paramRecipientChip));
  }
  
  private static boolean isPhoneNumber(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Patterns.PHONE.matcher(paramString).matches();
  }
  
  private boolean isValid(String paramString)
  {
    if (mValidator == null) {
      return true;
    }
    return mValidator.isValid(paramString);
  }
  
  private void postHandlePendingChips()
  {
    mHandler.removeCallbacks(mHandlePendingChips);
    mHandler.post(mHandlePendingChips);
  }
  
  private int putOffsetInRange(int paramInt)
  {
    Editable localEditable = getText();
    int j = localEditable.length();
    int i = j;
    int k = j - 1;
    j = i;
    i = k;
    while ((i >= 0) && (localEditable.charAt(i) == ' '))
    {
      j -= 1;
      i -= 1;
    }
    if (paramInt >= j) {
      return paramInt;
    }
    localEditable = getText();
    while ((paramInt >= 0) && (findText(localEditable, paramInt) == -1) && (findChip(paramInt) == null)) {
      paramInt -= 1;
    }
    return paramInt;
  }
  
  private void scrollBottomIntoView()
  {
    if (mScrollView != null) {
      mScrollView.scrollBy(0, (int)(getLineCount() * mChipHeight));
    }
  }
  
  private void scrollLineIntoView(int paramInt)
  {
    if (mScrollView != null) {
      mScrollView.scrollBy(0, calculateOffsetFromBottom(paramInt));
    }
  }
  
  private RecipientChip selectChip(RecipientChip paramRecipientChip)
  {
    Object localObject;
    if (shouldShowEditableText(paramRecipientChip))
    {
      localObject = paramRecipientChip.getValue();
      Editable localEditable = getText();
      removeChip(paramRecipientChip);
      localEditable.append((CharSequence)localObject);
      setCursorVisible(true);
      setSelection(localEditable.length());
      return new RecipientChip(null, RecipientEntry.constructFakeEntry((String)localObject), -1);
    }
    if (paramRecipientChip.getContactId() == -2L)
    {
      i = getChipStart(paramRecipientChip);
      j = getChipEnd(paramRecipientChip);
      getSpannable().removeSpan(paramRecipientChip);
      for (;;)
      {
        try
        {
          if (mNoChips) {
            return null;
          }
          paramRecipientChip = constructChipSpan(paramRecipientChip.getEntry(), i, true, false);
          localObject = getText();
          QwertyKeyListener.markAsReplaced((Spannable)localObject, i, j, "");
          if ((i == -1) || (j == -1))
          {
            Log.d("RecipientEditTextView", "The chip being selected no longer exists but should.");
            paramRecipientChip.setSelected(true);
            if (shouldShowEditableText(paramRecipientChip)) {
              scrollLineIntoView(getLayout().getLineForOffset(getChipStart(paramRecipientChip)));
            }
            showAddress(paramRecipientChip, mAddressPopup, getWidth(), getContext());
            setCursorVisible(false);
            return paramRecipientChip;
          }
        }
        catch (NullPointerException paramRecipientChip)
        {
          Log.e("RecipientEditTextView", paramRecipientChip.getMessage(), paramRecipientChip);
          return null;
        }
        ((Editable)localObject).setSpan(paramRecipientChip, i, j, 33);
      }
    }
    int i = getChipStart(paramRecipientChip);
    int j = getChipEnd(paramRecipientChip);
    getSpannable().removeSpan(paramRecipientChip);
    for (;;)
    {
      try
      {
        paramRecipientChip = constructChipSpan(paramRecipientChip.getEntry(), i, true, false);
        localObject = getText();
        QwertyKeyListener.markAsReplaced((Spannable)localObject, i, j, "");
        if ((i == -1) || (j == -1))
        {
          Log.d("RecipientEditTextView", "The chip being selected no longer exists but should.");
          paramRecipientChip.setSelected(true);
          if (shouldShowEditableText(paramRecipientChip)) {
            scrollLineIntoView(getLayout().getLineForOffset(getChipStart(paramRecipientChip)));
          }
          showAlternates(paramRecipientChip, mAlternatesPopup, getWidth(), getContext());
          setCursorVisible(false);
          return paramRecipientChip;
        }
      }
      catch (NullPointerException paramRecipientChip)
      {
        Log.e("RecipientEditTextView", paramRecipientChip.getMessage(), paramRecipientChip);
        return null;
      }
      ((Editable)localObject).setSpan(paramRecipientChip, i, j, 33);
    }
  }
  
  private void setChipDimensions(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecipientEditTextView, 0, 0);
    Resources localResources = getContext().getResources();
    mChipBackground = paramAttributeSet.getDrawable(1);
    if (mChipBackground == null) {
      mChipBackground = localResources.getDrawable(R.drawable.chip_background);
    }
    mChipBackgroundPressed = paramAttributeSet.getDrawable(2);
    if (mChipBackgroundPressed == null) {
      mChipBackgroundPressed = localResources.getDrawable(R.drawable.chip_background_selected);
    }
    mChipDelete = paramAttributeSet.getDrawable(3);
    if (mChipDelete == null) {
      mChipDelete = localResources.getDrawable(R.drawable.chip_delete);
    }
    mChipPadding = paramAttributeSet.getDimensionPixelSize(5, -1);
    if (mChipPadding == -1) {
      mChipPadding = ((int)localResources.getDimension(R.dimen.chip_padding));
    }
    mAlternatesLayout = paramAttributeSet.getResourceId(4, -1);
    if (mAlternatesLayout == -1) {
      mAlternatesLayout = R.layout.chips_alternate_item;
    }
    mDefaultContactPhoto = BitmapFactory.decodeResource(localResources, R.drawable.ic_contact_picture);
    mMoreItem = ((TextView)LayoutInflater.from(getContext()).inflate(R.layout.more_item, null));
    mChipHeight = paramAttributeSet.getDimensionPixelSize(6, -1);
    if (mChipHeight == -1.0F) {
      mChipHeight = localResources.getDimension(R.dimen.chip_height);
    }
    mChipFontSize = paramAttributeSet.getDimensionPixelSize(7, -1);
    if (mChipFontSize == -1.0F) {
      mChipFontSize = localResources.getDimension(R.dimen.chip_text_size);
    }
    mInvalidChipBackground = paramAttributeSet.getDrawable(0);
    if (mInvalidChipBackground == null) {
      mInvalidChipBackground = localResources.getDrawable(R.drawable.chip_background_invalid);
    }
    mLineSpacingExtra = paramContext.getResources().getDimension(R.dimen.line_spacing_extra);
    paramAttributeSet.recycle();
  }
  
  private boolean shouldCreateChip(int paramInt1, int paramInt2)
  {
    return (!mNoChips) && (hasFocus()) && (enoughToFilter()) && (!alreadyHasChip(paramInt1, paramInt2));
  }
  
  private boolean shouldShowEditableText(RecipientChip paramRecipientChip)
  {
    long l = paramRecipientChip.getContactId();
    return (l == -1L) || ((!isPhoneQuery()) && (l == -2L));
  }
  
  private void showAddress(final RecipientChip paramRecipientChip, final ListPopupWindow paramListPopupWindow, int paramInt, Context paramContext)
  {
    int i = calculateOffsetFromBottom(getLayout().getLineForOffset(getChipStart(paramRecipientChip)));
    paramListPopupWindow.setWidth(paramInt);
    paramListPopupWindow.setAnchorView(this);
    paramListPopupWindow.setVerticalOffset(i);
    paramListPopupWindow.setAdapter(createSingleAddressAdapter(paramRecipientChip));
    paramListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        RecipientEditTextView.this.unselectChip(paramRecipientChip);
        paramListPopupWindow.dismiss();
      }
    });
    paramListPopupWindow.show();
    paramRecipientChip = paramListPopupWindow.getListView();
    paramRecipientChip.setChoiceMode(1);
    paramRecipientChip.setItemChecked(0, true);
  }
  
  private void showAlternates(RecipientChip paramRecipientChip, ListPopupWindow paramListPopupWindow, int paramInt, Context paramContext)
  {
    int i = getLayout().getLineForOffset(getChipStart(paramRecipientChip));
    if (i == getLineCount() - 1) {}
    for (i = 0;; i = -(int)((mChipHeight + 2.0F * mLineSpacingExtra) * Math.abs(getLineCount() - 1 - i)))
    {
      paramListPopupWindow.setWidth(paramInt);
      paramListPopupWindow.setAnchorView(this);
      paramListPopupWindow.setVerticalOffset(i);
      paramListPopupWindow.setAdapter(createAlternatesAdapter(paramRecipientChip));
      paramListPopupWindow.setOnItemClickListener(mAlternatesListener);
      mCheckedItem = -1;
      paramListPopupWindow.show();
      paramRecipientChip = paramListPopupWindow.getListView();
      paramRecipientChip.setChoiceMode(1);
      if (mCheckedItem != -1)
      {
        paramRecipientChip.setItemChecked(mCheckedItem, true);
        mCheckedItem = -1;
      }
      return;
    }
  }
  
  private void showCopyDialog(String paramString)
  {
    mCopyAddress = paramString;
    mCopyDialog.setTitle(paramString);
    mCopyDialog.setContentView(R.layout.copy_chip_dialog_layout);
    mCopyDialog.setCancelable(true);
    mCopyDialog.setCanceledOnTouchOutside(true);
    paramString = (Button)mCopyDialog.findViewById(16908313);
    paramString.setOnClickListener(this);
    if (isPhoneQuery()) {}
    for (int i = R.string.copy_number;; i = R.string.copy_email)
    {
      paramString.setText(getContext().getResources().getString(i));
      mCopyDialog.setOnDismissListener(this);
      mCopyDialog.show();
      return;
    }
  }
  
  private void shrink()
  {
    if (mTokenizer == null) {
      return;
    }
    if (mSelectedChip != null) {}
    for (long l = mSelectedChip.getEntry().getContactId(); (mSelectedChip != null) && (l != -1L) && (!isPhoneQuery()) && (l != -2L); l = -1L)
    {
      clearSelectedChip();
      createMoreChip();
      return;
    }
    if (getWidth() <= 0)
    {
      mHandler.removeCallbacks(mDelayedShrink);
      mHandler.post(mDelayedShrink);
      return;
    }
    if (mPendingChipsCount > 0) {
      postHandlePendingChips();
    }
    for (;;)
    {
      mHandler.post(mAddTextWatcher);
      break;
      Editable localEditable = getText();
      int k = getSelectionEnd();
      int m = mTokenizer.findTokenStart(localEditable, k);
      Object localObject = (RecipientChip[])getSpannable().getSpans(m, k, RecipientChip.class);
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = getText();
        int j = mTokenizer.findTokenEnd((CharSequence)localObject, m);
        int i = j;
        if (j < ((Editable)localObject).length())
        {
          i = j;
          if (((Editable)localObject).charAt(j) == ',') {
            i = j + 1;
          }
        }
        if (i != getSelectionEnd()) {
          handleEdit(m, i);
        } else {
          commitChip(m, k, localEditable);
        }
      }
    }
  }
  
  private void startDrag(RecipientChip paramRecipientChip)
  {
    String str = paramRecipientChip.getEntry().getDestination();
    startDrag(ClipData.newPlainText(str, str + ','), new RecipientChipShadow(paramRecipientChip), null, 0);
    removeChip(paramRecipientChip);
  }
  
  private void submitItemAtPosition(int paramInt)
  {
    Object localObject = createValidatedEntry((RecipientEntry)getAdapter().getItem(paramInt));
    if (localObject == null) {
      return;
    }
    clearComposingText();
    paramInt = getSelectionEnd();
    int i = mTokenizer.findTokenStart(getText(), paramInt);
    Editable localEditable = getText();
    QwertyKeyListener.markAsReplaced(localEditable, i, paramInt, "");
    localObject = createChip((RecipientEntry)localObject, false);
    if ((localObject != null) && (i >= 0) && (paramInt >= 0)) {
      localEditable.replace(i, paramInt, (CharSequence)localObject);
    }
    sanitizeBetween();
  }
  
  private String tokenizeAddress(String paramString)
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
  
  private void unselectChip(RecipientChip paramRecipientChip)
  {
    int i = getChipStart(paramRecipientChip);
    int j = getChipEnd(paramRecipientChip);
    Editable localEditable = getText();
    mSelectedChip = null;
    if ((i == -1) || (j == -1))
    {
      Log.w("RecipientEditTextView", "The chip doesn't exist or may be a chip a user was editing");
      setSelection(localEditable.length());
      commitDefault();
    }
    for (;;)
    {
      setCursorVisible(true);
      setSelection(localEditable.length());
      if ((mAlternatesPopup != null) && (mAlternatesPopup.isShowing())) {
        mAlternatesPopup.dismiss();
      }
      return;
      getSpannable().removeSpan(paramRecipientChip);
      QwertyKeyListener.markAsReplaced(localEditable, i, j, "");
      localEditable.removeSpan(paramRecipientChip);
      try
      {
        if (!mNoChips) {
          localEditable.setSpan(constructChipSpan(paramRecipientChip.getEntry(), i, false, false), i, j, 33);
        }
      }
      catch (NullPointerException paramRecipientChip)
      {
        Log.e("RecipientEditTextView", paramRecipientChip.getMessage(), paramRecipientChip);
      }
    }
  }
  
  public void append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (mTextWatcher != null) {
      removeTextChangedListener(mTextWatcher);
    }
    super.append(paramCharSequence, paramInt1, paramInt2);
    if ((!TextUtils.isEmpty(paramCharSequence)) && (TextUtils.getTrimmedLength(paramCharSequence) > 0))
    {
      String str1 = paramCharSequence.toString();
      paramInt1 = str1.lastIndexOf(',');
      if (paramInt1 > -1)
      {
        String str2 = str1.substring(paramInt1);
        paramInt2 = str2.indexOf('"');
        if (paramInt2 > paramInt1) {
          str2.lastIndexOf(',', paramInt2);
        }
      }
      if ((!TextUtils.isEmpty(str1)) && (TextUtils.getTrimmedLength(str1) > 0))
      {
        mPendingChipsCount += 1;
        mPendingChips.add(paramCharSequence.toString());
      }
    }
    if (mPendingChipsCount > 0) {
      postHandlePendingChips();
    }
    mHandler.post(mAddTextWatcher);
  }
  
  int countTokens(Editable paramEditable)
  {
    int i = 0;
    int j = 0;
    int k;
    int m;
    do
    {
      k = i;
      if (j >= paramEditable.length()) {
        break;
      }
      m = movePastTerminators(mTokenizer.findTokenEnd(paramEditable, j));
      k = i + 1;
      j = m;
      i = k;
    } while (m < paramEditable.length());
    return k;
  }
  
  String createAddressText(RecipientEntry paramRecipientEntry)
  {
    Object localObject = paramRecipientEntry.getDisplayName();
    String str = paramRecipientEntry.getDestination();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramRecipientEntry = (RecipientEntry)localObject;
      if (!TextUtils.equals((CharSequence)localObject, str)) {}
    }
    else
    {
      paramRecipientEntry = null;
    }
    if ((isPhoneQuery()) && (isPhoneNumber(str))) {}
    for (paramRecipientEntry = str.trim();; paramRecipientEntry = new Rfc822Token(paramRecipientEntry, (String)localObject, null).toString().trim())
    {
      int i = paramRecipientEntry.indexOf(",");
      localObject = paramRecipientEntry;
      if (mTokenizer != null)
      {
        localObject = paramRecipientEntry;
        if (!TextUtils.isEmpty(paramRecipientEntry))
        {
          localObject = paramRecipientEntry;
          if (i < paramRecipientEntry.length() - 1) {
            localObject = (String)mTokenizer.terminateToken(paramRecipientEntry);
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
  
  String createChipDisplayText(RecipientEntry paramRecipientEntry)
  {
    Object localObject = paramRecipientEntry.getDisplayName();
    String str = paramRecipientEntry.getDestination();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramRecipientEntry = (RecipientEntry)localObject;
      if (!TextUtils.equals((CharSequence)localObject, str)) {}
    }
    else
    {
      paramRecipientEntry = null;
    }
    localObject = str;
    if (str != null) {
      if (isPhoneQuery())
      {
        localObject = str;
        if (isPhoneNumber(str)) {}
      }
      else
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
    if (!TextUtils.isEmpty(paramRecipientEntry)) {
      return paramRecipientEntry;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return (String)localObject;
    }
    return new Rfc822Token(paramRecipientEntry, (String)localObject, null).toString();
  }
  
  void createMoreChip()
  {
    if (mNoChips) {
      createMoreChipPlainText();
    }
    do
    {
      do
      {
        return;
      } while (!mShouldShrink);
      Object localObject1 = (ImageSpan[])getSpannable().getSpans(0, getText().length(), MoreImageSpan.class);
      if (localObject1.length > 0) {
        getSpannable().removeSpan(localObject1[0]);
      }
      Object localObject2 = getSortedRecipients();
      if ((localObject2 == null) || (localObject2.length <= 2))
      {
        mMoreChip = null;
        return;
      }
      Spannable localSpannable = getSpannable();
      int m = localObject2.length;
      int n = m - 2;
      localObject1 = createMoreSpan(n);
      mRemovedSpans = new ArrayList();
      Editable localEditable = getText();
      int j = m - n;
      int i = 0;
      int k = 0;
      while (j < localObject2.length)
      {
        mRemovedSpans.add(localObject2[j]);
        if (j == m - n) {
          k = localSpannable.getSpanStart(localObject2[j]);
        }
        if (j == localObject2.length - 1) {
          i = localSpannable.getSpanEnd(localObject2[j]);
        }
        if ((mTemporaryRecipients == null) || (!mTemporaryRecipients.contains(localObject2[j])))
        {
          int i1 = localSpannable.getSpanStart(localObject2[j]);
          int i2 = localSpannable.getSpanEnd(localObject2[j]);
          localObject2[j].setOriginalText(localEditable.toString().substring(i1, i2));
        }
        localSpannable.removeSpan(localObject2[j]);
        j += 1;
      }
      j = i;
      if (i < localEditable.length()) {
        j = localEditable.length();
      }
      i = Math.max(k, j);
      j = Math.min(k, j);
      localObject2 = new SpannableString(localEditable.subSequence(j, i));
      ((SpannableString)localObject2).setSpan(localObject1, 0, ((SpannableString)localObject2).length(), 33);
      localEditable.replace(j, i, (CharSequence)localObject2);
      mMoreChip = ((ImageSpan)localObject1);
    } while ((isPhoneQuery()) || (getLineCount() <= mMaxLines));
    setMaxLines(getLineCount());
  }
  
  void createMoreChipPlainText()
  {
    Editable localEditable = getText();
    int k = 0;
    int j = 0;
    int i = 0;
    while (i < 2)
    {
      j = movePastTerminators(mTokenizer.findTokenEnd(localEditable, k));
      k = j;
      i += 1;
    }
    MoreImageSpan localMoreImageSpan = createMoreSpan(countTokens(localEditable) - 2);
    SpannableString localSpannableString = new SpannableString(localEditable.subSequence(j, localEditable.length()));
    localSpannableString.setSpan(localMoreImageSpan, 0, localSpannableString.length(), 33);
    localEditable.replace(j, localEditable.length(), localSpannableString);
    mMoreChip = localMoreImageSpan;
  }
  
  Drawable getChipBackground(RecipientEntry paramRecipientEntry)
  {
    if ((mValidator != null) && (mValidator.isValid(paramRecipientEntry.getDestination()))) {
      return mChipBackground;
    }
    return mInvalidChipBackground;
  }
  
  RecipientChip getLastChip()
  {
    Object localObject2 = null;
    RecipientChip[] arrayOfRecipientChip = getSortedRecipients();
    Object localObject1 = localObject2;
    if (arrayOfRecipientChip != null)
    {
      localObject1 = localObject2;
      if (arrayOfRecipientChip.length > 0) {
        localObject1 = arrayOfRecipientChip[(arrayOfRecipientChip.length - 1)];
      }
    }
    return (RecipientChip)localObject1;
  }
  
  ImageSpan getMoreChip()
  {
    MoreImageSpan[] arrayOfMoreImageSpan = (MoreImageSpan[])getSpannable().getSpans(0, getText().length(), MoreImageSpan.class);
    if ((arrayOfMoreImageSpan != null) && (arrayOfMoreImageSpan.length > 0)) {
      return arrayOfMoreImageSpan[0];
    }
    return null;
  }
  
  RecipientChip[] getSortedRecipients()
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList((RecipientChip[])getSpannable().getSpans(0, getText().length(), RecipientChip.class)));
    Collections.sort(localArrayList, new Comparator()
    {
      public int compare(RecipientChip paramAnonymousRecipientChip1, RecipientChip paramAnonymousRecipientChip2)
      {
        int i = val$spannable.getSpanStart(paramAnonymousRecipientChip1);
        int j = val$spannable.getSpanStart(paramAnonymousRecipientChip2);
        if (i < j) {
          return -1;
        }
        if (i > j) {
          return 1;
        }
        return 0;
      }
    });
    return (RecipientChip[])localArrayList.toArray(new RecipientChip[localArrayList.size()]);
  }
  
  Spannable getSpannable()
  {
    return getText();
  }
  
  int getViewWidth()
  {
    return getWidth();
  }
  
  ArrayList<RecipientChip> handlePaste()
  {
    String str2 = getText().toString();
    int k = mTokenizer.findTokenStart(str2, getSelectionEnd());
    String str1 = str2.substring(k);
    int i = k;
    int j = i;
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    if (i != 0)
    {
      while ((i != 0) && (localObject == null))
      {
        j = i;
        i = mTokenizer.findTokenStart(str2, i);
        localObject = findChip(i);
      }
      if (i != k) {
        if (localObject != null) {
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i < k)
      {
        commitChip(i, movePastTerminators(mTokenizer.findTokenEnd(getText().toString(), i)), getText());
        localObject = findChip(i);
        if (localObject != null) {}
      }
      else
      {
        if (isCompletedToken(str1))
        {
          localObject = getText();
          i = localObject.toString().indexOf(str1, k);
          commitChip(i, ((Editable)localObject).length(), (Editable)localObject);
          localArrayList.add(findChip(i));
        }
        return localArrayList;
      }
      i = getSpannable().getSpanEnd(localObject) + 1;
      localArrayList.add(localObject);
    }
  }
  
  void handlePendingChips()
  {
    if (getViewWidth() <= 0) {}
    while (mPendingChipsCount <= 0) {
      return;
    }
    for (;;)
    {
      synchronized (mPendingChips)
      {
        Editable localEditable = getText();
        if (mPendingChipsCount <= 50)
        {
          int i = 0;
          if (i < mPendingChips.size())
          {
            String str = (String)mPendingChips.get(i);
            int m = localEditable.toString().indexOf(str);
            int k = m + str.length();
            if (m >= 0)
            {
              int j = k;
              if (k < localEditable.length() - 2)
              {
                j = k;
                if (localEditable.charAt(k) == ',') {
                  j = k + 1;
                }
              }
              createReplacementChip(m, j, localEditable);
            }
            mPendingChipsCount -= 1;
            i += 1;
            continue;
          }
          sanitizeEnd();
          if ((mTemporaryRecipients == null) || (mTemporaryRecipients.size() <= 0) || (mTemporaryRecipients.size() > 50)) {
            break label352;
          }
          if ((!hasFocus()) && (mTemporaryRecipients.size() >= 2)) {
            break label256;
          }
          new RecipientReplacementTask(null).execute(new Void[0]);
          mTemporaryRecipients = null;
          mPendingChipsCount = 0;
          mPendingChips.clear();
          return;
        }
      }
      mNoChips = true;
      continue;
      label256:
      mIndividualReplacements = new IndividualReplacementTask(null);
      mIndividualReplacements.execute(new Object[] { new ArrayList(mTemporaryRecipients.subList(0, 2)) });
      if (mTemporaryRecipients.size() > 2) {}
      for (mTemporaryRecipients = new ArrayList(mTemporaryRecipients.subList(2, mTemporaryRecipients.size()));; mTemporaryRecipients = null)
      {
        createMoreChip();
        break;
      }
      label352:
      mTemporaryRecipients = null;
      createMoreChip();
    }
  }
  
  boolean isCompletedToken(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    int i;
    do
    {
      do
      {
        return false;
        i = paramCharSequence.length();
        int j = mTokenizer.findTokenStart(paramCharSequence, i);
        paramCharSequence = paramCharSequence.toString().substring(j, i).trim();
      } while (TextUtils.isEmpty(paramCharSequence));
      i = paramCharSequence.charAt(paramCharSequence.length() - 1);
    } while ((i != 44) && (i != 59));
    return true;
  }
  
  protected boolean isPhoneQuery()
  {
    return (getAdapter() != null) && (((BaseRecipientAdapter)getAdapter()).getQueryType() == 1);
  }
  
  int movePastTerminators(int paramInt)
  {
    if (paramInt >= length()) {
      return paramInt;
    }
    int j = getText().toString().charAt(paramInt);
    int i;
    if (j != 44)
    {
      i = paramInt;
      if (j != 59) {}
    }
    else
    {
      i = paramInt + 1;
    }
    paramInt = i;
    if (i < length())
    {
      paramInt = i;
      if (getText().toString().charAt(i) == ' ') {
        paramInt = i + 1;
      }
    }
    return paramInt;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onCheckedItemChanged(int paramInt)
  {
    ListView localListView = mAlternatesPopup.getListView();
    if ((localListView != null) && (localListView.getCheckedItemCount() == 0)) {
      localListView.setItemChecked(paramInt, true);
    }
    mCheckedItem = paramInt;
  }
  
  public void onClick(View paramView)
  {
    ((ClipboardManager)getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", mCopyAddress));
    mCopyDialog.dismiss();
  }
  
  public void onClick(RecipientChip paramRecipientChip, int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramRecipientChip.isSelected())
    {
      if (isInDelete(paramRecipientChip, paramInt, paramFloat1, paramFloat2)) {
        removeChip(paramRecipientChip);
      }
    }
    else {
      return;
    }
    clearSelectedChip();
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    int i = imeOptions & 0xFF;
    if ((i & 0x6) != 0)
    {
      imeOptions ^= i;
      imeOptions |= 0x6;
    }
    if ((imeOptions & 0x40000000) != 0) {
      imeOptions &= 0xBFFFFFFF;
    }
    actionLabel = getContext().getString(R.string.done);
    return localInputConnection;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    mCopyAddress = null;
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
    handlePasteClip(paramDragEvent.getClipData());
    return true;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (commitDefault()) {}
      do
      {
        return true;
        if (mSelectedChip != null)
        {
          clearSelectedChip();
          return true;
        }
      } while (focusNext());
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
      shrink();
      return;
    }
    expand();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    submitItemAtPosition(paramInt);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((mSelectedChip != null) && (paramInt == 67))
    {
      if ((mAlternatesPopup != null) && (mAlternatesPopup.isShowing())) {
        mAlternatesPopup.dismiss();
      }
      removeChip(mSelectedChip);
    }
    if ((paramInt == 66) && (paramKeyEvent.hasNoModifiers())) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (mSelectedChip != null))
    {
      clearSelectedChip();
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      do
      {
        return bool;
        if (!paramKeyEvent.hasNoModifiers()) {
          break;
        }
      } while (commitDefault());
      if (mSelectedChip != null)
      {
        clearSelectedChip();
        return true;
      }
      if (focusNext())
      {
        return true;
        if (paramKeyEvent.hasNoModifiers())
        {
          if (mSelectedChip != null) {
            clearSelectedChip();
          }
          while (focusNext())
          {
            return true;
            commitDefault();
          }
        }
      }
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (mSelectedChip != null) {}
    do
    {
      return;
      paramMotionEvent = findChip(putOffsetInRange(getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY())));
    } while (paramMotionEvent == null);
    if (mDragEnabled)
    {
      startDrag(paramMotionEvent);
      return;
    }
    showCopyDialog(paramMotionEvent.getEntry().getDestination());
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
    clearSelectedChip();
    return super.onSaveInstanceState();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onSelectionChanged(int paramInt1, int paramInt2)
  {
    RecipientChip localRecipientChip = getLastChip();
    if ((localRecipientChip != null) && (paramInt1 < getSpannable().getSpanEnd(localRecipientChip))) {
      setSelection(Math.min(getSpannable().getSpanEnd(localRecipientChip) + 1, getText().length()));
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
      if (mPendingChipsCount <= 0) {
        break label73;
      }
      postHandlePendingChips();
    }
    while ((mScrollView == null) && (!mTriedGettingScrollView))
    {
      ViewParent localViewParent = getParent();
      for (;;)
      {
        if ((localViewParent != null) && (!(localViewParent instanceof ScrollView)))
        {
          localViewParent = localViewParent.getParent();
          continue;
          label73:
          checkChipWidths();
          break;
        }
      }
      if (localViewParent != null) {
        mScrollView = ((ScrollView)localViewParent);
      }
      mTriedGettingScrollView = true;
    }
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    if (paramInt == 16908322)
    {
      handlePasteClip(((ClipboardManager)getContext().getSystemService("clipboard")).getPrimaryClip());
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isFocused())
    {
      bool2 = super.onTouchEvent(paramMotionEvent);
      return bool2;
    }
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    int k = paramMotionEvent.getAction();
    int j = 0;
    if (mSelectedChip == null) {
      mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    int i = j;
    boolean bool1 = bool2;
    float f1;
    float f2;
    if (mCopyAddress == null)
    {
      i = j;
      bool1 = bool2;
      if (k == 1)
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = putOffsetInRange(getOffsetForPosition(f1, f2));
        paramMotionEvent = findChip(i);
        if (paramMotionEvent == null) {
          break label229;
        }
        if (k == 1)
        {
          if ((mSelectedChip == null) || (mSelectedChip == paramMotionEvent)) {
            break label177;
          }
          clearSelectedChip();
          mSelectedChip = selectChip(paramMotionEvent);
        }
        label145:
        i = 1;
        bool1 = true;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (k != 1) {
        break;
      }
      bool2 = bool1;
      if (i != 0) {
        break;
      }
      clearSelectedChip();
      return bool1;
      label177:
      if (mSelectedChip == null)
      {
        setSelection(getText().length());
        commitDefault();
        mSelectedChip = selectChip(paramMotionEvent);
        break label145;
      }
      onClick(mSelectedChip, i, f1, f2);
      break label145;
      label229:
      i = j;
      bool1 = bool2;
      if (mSelectedChip != null)
      {
        i = j;
        bool1 = bool2;
        if (shouldShowEditableText(mSelectedChip))
        {
          i = 1;
          bool1 = bool2;
        }
      }
    }
  }
  
  protected void performFiltering(CharSequence paramCharSequence, int paramInt)
  {
    if ((enoughToFilter()) && (!isCompletedToken(paramCharSequence)))
    {
      int i = getSelectionEnd();
      int j = mTokenizer.findTokenStart(paramCharSequence, i);
      RecipientChip[] arrayOfRecipientChip = (RecipientChip[])getSpannable().getSpans(j, i, RecipientChip.class);
      if ((arrayOfRecipientChip != null) && (arrayOfRecipientChip.length > 0)) {
        return;
      }
    }
    super.performFiltering(paramCharSequence, paramInt);
  }
  
  public void performValidation() {}
  
  void removeChip(RecipientChip paramRecipientChip)
  {
    Spannable localSpannable = getSpannable();
    int m = localSpannable.getSpanStart(paramRecipientChip);
    int i = localSpannable.getSpanEnd(paramRecipientChip);
    Editable localEditable = getText();
    if (paramRecipientChip == mSelectedChip) {}
    int k;
    for (int j = 1;; j = 0)
    {
      k = i;
      if (j != 0)
      {
        mSelectedChip = null;
        k = i;
      }
      while ((k >= 0) && (k < localEditable.length()) && (localEditable.charAt(k) == ' ')) {
        k += 1;
      }
    }
    localSpannable.removeSpan(paramRecipientChip);
    if ((m >= 0) && (k > 0)) {
      localEditable.delete(m, k);
    }
    if (j != 0) {
      clearSelectedChip();
    }
  }
  
  void removeMoreChip()
  {
    if (mMoreChip != null)
    {
      localObject1 = getSpannable();
      ((Spannable)localObject1).removeSpan(mMoreChip);
      mMoreChip = null;
      if ((mRemovedSpans != null) && (mRemovedSpans.size() > 0))
      {
        localObject2 = getSortedRecipients();
        if ((localObject2 != null) && (localObject2.length != 0)) {
          break label64;
        }
      }
    }
    return;
    label64:
    int i = ((Spannable)localObject1).getSpanEnd(localObject2[(localObject2.length - 1)]);
    Object localObject1 = getText();
    Object localObject2 = mRemovedSpans.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RecipientChip localRecipientChip = (RecipientChip)((Iterator)localObject2).next();
      String str = (String)localRecipientChip.getOriginalText();
      int m = localObject1.toString().indexOf(str, i);
      int k = Math.min(((Editable)localObject1).length(), str.length() + m);
      int j = k;
      i = j;
      if (m != -1)
      {
        ((Editable)localObject1).setSpan(localRecipientChip, m, k, 33);
        i = j;
      }
    }
    mRemovedSpans.clear();
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    mTextWatcher = null;
    super.removeTextChangedListener(paramTextWatcher);
  }
  
  void replaceChip(RecipientChip paramRecipientChip, RecipientEntry paramRecipientEntry)
  {
    int i;
    int k;
    int j;
    if (paramRecipientChip == mSelectedChip)
    {
      i = 1;
      if (i != 0) {
        mSelectedChip = null;
      }
      k = getChipStart(paramRecipientChip);
      j = getChipEnd(paramRecipientChip);
      getSpannable().removeSpan(paramRecipientChip);
      paramRecipientChip = getText();
      paramRecipientEntry = createChip(paramRecipientEntry, false);
      if (paramRecipientEntry != null)
      {
        if ((k != -1) && (j != -1)) {
          break label109;
        }
        Log.e("RecipientEditTextView", "The chip to replace does not exist but should.");
        paramRecipientChip.insert(0, paramRecipientEntry);
      }
    }
    for (;;)
    {
      setCursorVisible(true);
      if (i != 0) {
        clearSelectedChip();
      }
      return;
      i = 0;
      break;
      label109:
      if (!TextUtils.isEmpty(paramRecipientEntry))
      {
        while ((j >= 0) && (j < paramRecipientChip.length()) && (paramRecipientChip.charAt(j) == ' ')) {
          j += 1;
        }
        paramRecipientChip.replace(k, j, paramRecipientEntry);
      }
    }
  }
  
  protected void replaceText(CharSequence paramCharSequence) {}
  
  void sanitizeBetween()
  {
    if (mPendingChipsCount > 0) {}
    int i;
    int k;
    do
    {
      Object localObject;
      int j;
      do
      {
        RecipientChip[] arrayOfRecipientChip;
        do
        {
          return;
          arrayOfRecipientChip = getSortedRecipients();
        } while ((arrayOfRecipientChip == null) || (arrayOfRecipientChip.length <= 0));
        RecipientChip localRecipientChip = arrayOfRecipientChip[(arrayOfRecipientChip.length - 1)];
        localObject = null;
        if (arrayOfRecipientChip.length > 1) {
          localObject = arrayOfRecipientChip[(arrayOfRecipientChip.length - 2)];
        }
        i = 0;
        k = getSpannable().getSpanStart(localRecipientChip);
        if (localObject == null) {
          break;
        }
        j = getSpannable().getSpanEnd(localObject);
        localObject = getText();
      } while ((j == -1) || (j > ((Editable)localObject).length() - 1));
      i = j;
      if (((Editable)localObject).charAt(j) == ' ') {
        i = j + 1;
      }
    } while ((i < 0) || (k < 0) || (i >= k));
    getText().delete(i, k);
  }
  
  void sanitizeEnd()
  {
    if (mPendingChipsCount > 0) {}
    do
    {
      return;
      localObject = getSortedRecipients();
    } while ((localObject == null) || (localObject.length <= 0));
    mMoreChip = getMoreChip();
    if (mMoreChip != null) {}
    for (Object localObject = mMoreChip;; localObject = getLastChip())
    {
      int i = getSpannable().getSpanEnd(localObject);
      localObject = getText();
      int j = ((Editable)localObject).length();
      if (j <= i) {
        break;
      }
      if (Log.isLoggable("RecipientEditTextView", 3)) {
        Log.d("RecipientEditTextView", "There were extra characters after the last tokenizable entry." + localObject);
      }
      ((Editable)localObject).delete(i + 1, j);
      return;
    }
  }
  
  public void setTokenizer(MultiAutoCompleteTextView.Tokenizer paramTokenizer)
  {
    mTokenizer = paramTokenizer;
    super.setTokenizer(mTokenizer);
  }
  
  public void setValidator(AutoCompleteTextView.Validator paramValidator)
  {
    mValidator = paramValidator;
    super.setValidator(paramValidator);
  }
  
  private class IndividualReplacementTask
    extends AsyncTask<Object, Void, Void>
  {
    private IndividualReplacementTask() {}
    
    protected Void doInBackground(final Object... paramVarArgs)
    {
      paramVarArgs = (ArrayList)paramVarArgs[0];
      Object localObject1 = new ArrayList();
      int i = 0;
      while (i < paramVarArgs.size())
      {
        localObject2 = (RecipientChip)paramVarArgs.get(i);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(createAddressText(((RecipientChip)localObject2).getEntry()));
        }
        i += 1;
      }
      Object localObject2 = RecipientAlternatesAdapter.getMatchingRecipients(getContext(), (ArrayList)localObject1);
      Iterator localIterator = paramVarArgs.iterator();
      while (localIterator.hasNext())
      {
        final RecipientChip localRecipientChip = (RecipientChip)localIterator.next();
        if ((RecipientEntry.isCreatedRecipient(localRecipientChip.getEntry().getContactId())) && (getSpannable().getSpanStart(localRecipientChip) != -1))
        {
          localObject1 = RecipientEditTextView.this.createValidatedEntry((RecipientEntry)((HashMap)localObject2).get(RecipientEditTextView.access$2200(RecipientEditTextView.this, localRecipientChip.getEntry().getDestination()).toLowerCase()));
          paramVarArgs = (Object[])localObject1;
          if (localObject1 == null)
          {
            paramVarArgs = (Object[])localObject1;
            if (!isPhoneQuery()) {
              paramVarArgs = localRecipientChip.getEntry();
            }
          }
          if (paramVarArgs != null) {
            mHandler.post(new Runnable()
            {
              public void run()
              {
                replaceChip(localRecipientChip, paramVarArgs);
              }
            });
          }
        }
      }
      return null;
    }
  }
  
  private class MoreImageSpan
    extends ImageSpan
  {
    public MoreImageSpan(Drawable paramDrawable)
    {
      super();
    }
  }
  
  private final class RecipientChipShadow
    extends View.DragShadowBuilder
  {
    private final RecipientChip mChip;
    
    public RecipientChipShadow(RecipientChip paramRecipientChip)
    {
      mChip = paramRecipientChip;
    }
    
    public void onDrawShadow(Canvas paramCanvas)
    {
      mChip.getDrawable().draw(paramCanvas);
    }
    
    public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
    {
      Rect localRect = mChip.getDrawable().getBounds();
      paramPoint1.set(localRect.width(), localRect.height());
      paramPoint2.set(localRect.centerX(), localRect.centerY());
    }
  }
  
  private class RecipientReplacementTask
    extends AsyncTask<Void, Void, Void>
  {
    private RecipientReplacementTask() {}
    
    private RecipientChip createFreeChip(RecipientEntry paramRecipientEntry)
    {
      try
      {
        if (mNoChips) {
          return null;
        }
        paramRecipientEntry = RecipientEditTextView.this.constructChipSpan(paramRecipientEntry, -1, false, false);
        return paramRecipientEntry;
      }
      catch (NullPointerException paramRecipientEntry)
      {
        Log.e("RecipientEditTextView", paramRecipientEntry.getMessage(), paramRecipientEntry);
      }
      return null;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      if (mIndividualReplacements != null) {
        mIndividualReplacements.cancel(true);
      }
      final ArrayList localArrayList1 = new ArrayList();
      paramVarArgs = getSortedRecipients();
      int i = 0;
      while (i < paramVarArgs.length)
      {
        localArrayList1.add(paramVarArgs[i]);
        i += 1;
      }
      if (mRemovedSpans != null) {
        localArrayList1.addAll(mRemovedSpans);
      }
      paramVarArgs = new ArrayList();
      i = 0;
      RecipientChip localRecipientChip1;
      while (i < localArrayList1.size())
      {
        localRecipientChip1 = (RecipientChip)localArrayList1.get(i);
        if (localRecipientChip1 != null) {
          paramVarArgs.add(createAddressText(localRecipientChip1.getEntry()));
        }
        i += 1;
      }
      HashMap localHashMap = RecipientAlternatesAdapter.getMatchingRecipients(getContext(), paramVarArgs);
      final ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        RecipientChip localRecipientChip2 = (RecipientChip)localIterator.next();
        localRecipientChip1 = null;
        paramVarArgs = localRecipientChip1;
        if (RecipientEntry.isCreatedRecipient(localRecipientChip2.getEntry().getContactId()))
        {
          paramVarArgs = localRecipientChip1;
          if (getSpannable().getSpanStart(localRecipientChip2) != -1) {
            paramVarArgs = RecipientEditTextView.this.createValidatedEntry((RecipientEntry)localHashMap.get(RecipientEditTextView.access$2200(RecipientEditTextView.this, localRecipientChip2.getEntry().getDestination())));
          }
        }
        if (paramVarArgs != null) {
          localArrayList2.add(createFreeChip(paramVarArgs));
        } else {
          localArrayList2.add(localRecipientChip2);
        }
      }
      if ((localArrayList2 != null) && (localArrayList2.size() > 0)) {
        mHandler.post(new Runnable()
        {
          public void run()
          {
            Editable localEditable = getText();
            int i = 0;
            Iterator localIterator = localArrayList1.iterator();
            while (localIterator.hasNext())
            {
              RecipientChip localRecipientChip = (RecipientChip)localIterator.next();
              int j = localEditable.getSpanStart(localRecipientChip);
              if (j != -1)
              {
                int k = localEditable.getSpanEnd(localRecipientChip);
                localEditable.removeSpan(localRecipientChip);
                localRecipientChip = (RecipientChip)localArrayList2.get(i);
                SpannableString localSpannableString = new SpannableString(createAddressText(localRecipientChip.getEntry()).trim());
                localSpannableString.setSpan(localRecipientChip, 0, localSpannableString.length(), 33);
                localEditable.replace(j, k, localSpannableString);
                localRecipientChip.setOriginalText(localSpannableString.toString());
              }
              i += 1;
            }
            localArrayList1.clear();
          }
        });
      }
      return null;
    }
  }
  
  private class RecipientTextWatcher
    implements TextWatcher
  {
    private RecipientTextWatcher() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      int j;
      if (TextUtils.isEmpty(paramEditable))
      {
        paramEditable = getSpannable();
        RecipientChip[] arrayOfRecipientChip = (RecipientChip[])paramEditable.getSpans(0, getText().length(), RecipientChip.class);
        j = arrayOfRecipientChip.length;
        while (i < j)
        {
          paramEditable.removeSpan(arrayOfRecipientChip[i]);
          i += 1;
        }
        if (mMoreChip != null) {
          paramEditable.removeSpan(mMoreChip);
        }
      }
      label92:
      label242:
      label253:
      do
      {
        do
        {
          do
          {
            break label92;
            do
            {
              return;
            } while (RecipientEditTextView.this.chipsPending());
            if ((mSelectedChip != null) && (RecipientEditTextView.this.shouldShowEditableText(mSelectedChip)))
            {
              setCursorVisible(true);
              setSelection(getText().length());
              RecipientEditTextView.this.clearSelectedChip();
            }
          } while (paramEditable.length() <= 1);
          if (getSelectionEnd() == 0)
          {
            i = 0;
            j = length() - 1;
            if (i == j) {
              break label242;
            }
          }
          for (i = paramEditable.charAt(i);; i = paramEditable.charAt(j))
          {
            if ((i != 59) && (i != 44)) {
              break label253;
            }
            RecipientEditTextView.this.commitByCharacter();
            return;
            i = getSelectionEnd() - 1;
            break;
          }
        } while ((i != 32) || (isPhoneQuery()));
        paramEditable = getText().toString();
        i = mTokenizer.findTokenStart(paramEditable, getSelectionEnd());
        paramEditable = paramEditable.substring(i, mTokenizer.findTokenEnd(paramEditable, i));
      } while ((TextUtils.isEmpty(paramEditable)) || (mValidator == null) || (!mValidator.isValid(paramEditable)));
      RecipientEditTextView.this.commitByCharacter();
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt2 > paramInt3)
      {
        paramInt1 = getSelectionStart();
        paramCharSequence = (RecipientChip[])getSpannable().getSpans(paramInt1, paramInt1, RecipientChip.class);
        if (paramCharSequence.length > 0)
        {
          localEditable = getText();
          paramInt3 = mTokenizer.findTokenStart(localEditable, paramInt1);
          paramInt2 = mTokenizer.findTokenEnd(localEditable, paramInt3) + 1;
          paramInt1 = paramInt2;
          if (paramInt2 > localEditable.length()) {
            paramInt1 = localEditable.length();
          }
          localEditable.delete(paramInt3, paramInt1);
          getSpannable().removeSpan(paramCharSequence[0]);
        }
      }
      while (paramInt3 <= paramInt2)
      {
        Editable localEditable;
        return;
      }
      RecipientEditTextView.this.scrollBottomIntoView();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */