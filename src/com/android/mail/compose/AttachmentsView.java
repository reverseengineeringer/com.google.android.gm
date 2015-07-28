package com.android.mail.compose;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.android.mail.providers.Account;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Settings;
import com.android.mail.ui.AttachmentTile;
import com.android.mail.ui.AttachmentTile.AttachmentPreview;
import com.android.mail.ui.AttachmentTileGrid;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.google.common.collect.Lists;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class AttachmentsView
  extends LinearLayout
{
  private static final String LOG_TAG = ;
  private LinearLayout mAttachmentLayout;
  private ArrayList<Attachment> mAttachments = Lists.newArrayList();
  private AttachmentAddedOrDeletedListener mChangeListener;
  private AttachmentTileGrid mTileGrid;
  
  public AttachmentsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AttachmentsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Cursor getOptionalColumn(ContentResolver paramContentResolver, Uri paramUri, String paramString)
  {
    try
    {
      paramContentResolver = paramContentResolver.query(paramUri, new String[] { paramString }, null, null, null);
      return paramContentResolver;
    }
    catch (SQLiteException paramContentResolver) {}
    return null;
  }
  
  public long addAttachment(Account paramAccount, Uri paramUri)
    throws AttachmentsView.AttachmentFailureException
  {
    return addAttachment(paramAccount, generateLocalAttachment(paramUri));
  }
  
  public long addAttachment(Account paramAccount, Attachment paramAttachment)
    throws AttachmentsView.AttachmentFailureException
  {
    int i = settings.getMaxAttachmentSize();
    if ((size == -1) || (size > i)) {
      throw new AttachmentFailureException("Attachment too large to attach", 2131492909);
    }
    if (getTotalAttachmentsSize() + size > i) {
      throw new AttachmentFailureException("Attachment too large to attach", 2131492911);
    }
    addAttachment(paramAttachment);
    return size;
  }
  
  public void addAttachment(final Attachment paramAttachment)
  {
    if (!isShown()) {
      setVisibility(0);
    }
    mAttachments.add(paramAttachment);
    expandView();
    final Object localObject;
    if (AttachmentTile.isTiledAttachment(paramAttachment))
    {
      localObject = mTileGrid.addComposeTileFromAttachment(paramAttachment);
      ((ComposeAttachmentTile)localObject).addDeleteListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          deleteAttachment(localObject, paramAttachment);
        }
      });
    }
    for (;;)
    {
      if (mChangeListener != null) {
        mChangeListener.onAttachmentAdded();
      }
      return;
      localObject = new AttachmentComposeView(getContext(), paramAttachment);
      ((AttachmentComposeView)localObject).addDeleteListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          deleteAttachment(localObject, paramAttachment);
        }
      });
      mAttachmentLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -1));
    }
  }
  
  public void deleteAllAttachments()
  {
    mAttachments.clear();
    mTileGrid.removeAllViews();
    mAttachmentLayout.removeAllViews();
    setVisibility(8);
  }
  
  protected void deleteAttachment(View paramView, Attachment paramAttachment)
  {
    mAttachments.remove(paramAttachment);
    ((ViewGroup)paramView.getParent()).removeView(paramView);
    if (mChangeListener != null) {
      mChangeListener.onAttachmentDeleted();
    }
  }
  
  public void expandView()
  {
    mTileGrid.setVisibility(0);
    mAttachmentLayout.setVisibility(0);
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  public void focusLastAttachment()
  {
    Attachment localAttachment = (Attachment)mAttachments.get(mAttachments.size() - 1);
    View localView = null;
    int i;
    if (AttachmentTile.isTiledAttachment(localAttachment))
    {
      i = mTileGrid.getChildCount() - 1;
      if (i > 0) {
        localView = mTileGrid.getChildAt(i);
      }
    }
    for (;;)
    {
      if (localView != null) {
        localView.requestFocus();
      }
      return;
      i = mAttachmentLayout.getChildCount() - 1;
      if (i > 0) {
        localView = mAttachmentLayout.getChildAt(i);
      }
    }
  }
  
  /* Error */
  public Attachment generateLocalAttachment(Uri paramUri)
    throws AttachmentsView.AttachmentFailureException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 155	com/android/mail/compose/AttachmentsView:getContext	()Landroid/content/Context;
    //   4: invokevirtual 246	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: invokevirtual 250	android/content/ContentResolver:getType	(Landroid/net/Uri;)Ljava/lang/String;
    //   15: astore_3
    //   16: aload_1
    //   17: ifnull +13 -> 30
    //   20: aload_1
    //   21: invokevirtual 255	android/net/Uri:getPath	()Ljava/lang/String;
    //   24: invokestatic 261	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +14 -> 41
    //   30: new 13	com/android/mail/compose/AttachmentsView$AttachmentFailureException
    //   33: dup
    //   34: ldc_w 263
    //   37: invokespecial 266	com/android/mail/compose/AttachmentsView$AttachmentFailureException:<init>	(Ljava/lang/String;)V
    //   40: athrow
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: ifnonnull +7 -> 51
    //   47: ldc_w 268
    //   50: astore_2
    //   51: new 86	com/android/mail/providers/Attachment
    //   54: dup
    //   55: invokespecial 270	com/android/mail/providers/Attachment:<init>	()V
    //   58: astore 5
    //   60: aload 5
    //   62: aconst_null
    //   63: putfield 274	com/android/mail/providers/Attachment:uri	Landroid/net/Uri;
    //   66: aload 5
    //   68: aconst_null
    //   69: putfield 277	com/android/mail/providers/Attachment:name	Ljava/lang/String;
    //   72: aload 5
    //   74: aload_2
    //   75: putfield 280	com/android/mail/providers/Attachment:contentType	Ljava/lang/String;
    //   78: aload 5
    //   80: iconst_0
    //   81: putfield 90	com/android/mail/providers/Attachment:size	I
    //   84: aload 5
    //   86: aload_1
    //   87: putfield 283	com/android/mail/providers/Attachment:contentUri	Landroid/net/Uri;
    //   90: aconst_null
    //   91: astore_2
    //   92: aload 4
    //   94: aload_1
    //   95: iconst_2
    //   96: anewarray 56	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: ldc_w 285
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: ldc_w 287
    //   110: aastore
    //   111: aconst_null
    //   112: aconst_null
    //   113: aconst_null
    //   114: invokevirtual 62	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   117: astore_3
    //   118: aload_3
    //   119: ifnull +44 -> 163
    //   122: aload_3
    //   123: invokeinterface 292 1 0
    //   128: ifeq +27 -> 155
    //   131: aload 5
    //   133: aload_3
    //   134: iconst_0
    //   135: invokeinterface 296 2 0
    //   140: putfield 277	com/android/mail/providers/Attachment:name	Ljava/lang/String;
    //   143: aload 5
    //   145: aload_3
    //   146: iconst_1
    //   147: invokeinterface 300 2 0
    //   152: putfield 90	com/android/mail/providers/Attachment:size	I
    //   155: aload_3
    //   156: astore_2
    //   157: aload_3
    //   158: invokeinterface 303 1 0
    //   163: aload 5
    //   165: getfield 277	com/android/mail/providers/Attachment:name	Ljava/lang/String;
    //   168: ifnonnull +12 -> 180
    //   171: aload 5
    //   173: aload_1
    //   174: invokevirtual 306	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   177: putfield 277	com/android/mail/providers/Attachment:name	Ljava/lang/String;
    //   180: aload 5
    //   182: areturn
    //   183: astore 6
    //   185: aload_3
    //   186: astore_2
    //   187: aload_3
    //   188: invokeinterface 303 1 0
    //   193: aload_3
    //   194: astore_2
    //   195: aload 6
    //   197: athrow
    //   198: astore_3
    //   199: aload_0
    //   200: aload 4
    //   202: aload_1
    //   203: ldc_w 285
    //   206: invokespecial 308	com/android/mail/compose/AttachmentsView:getOptionalColumn	(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)Landroid/database/Cursor;
    //   209: astore_3
    //   210: aload_3
    //   211: ifnull +28 -> 239
    //   214: aload_3
    //   215: astore_2
    //   216: aload_3
    //   217: invokeinterface 292 1 0
    //   222: ifeq +17 -> 239
    //   225: aload_3
    //   226: astore_2
    //   227: aload 5
    //   229: aload_3
    //   230: iconst_0
    //   231: invokeinterface 296 2 0
    //   236: putfield 277	com/android/mail/providers/Attachment:name	Ljava/lang/String;
    //   239: aload_3
    //   240: ifnull +9 -> 249
    //   243: aload_3
    //   244: invokeinterface 303 1 0
    //   249: aload_3
    //   250: astore_2
    //   251: aload_0
    //   252: aload 4
    //   254: aload_1
    //   255: ldc_w 287
    //   258: invokespecial 308	com/android/mail/compose/AttachmentsView:getOptionalColumn	(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)Landroid/database/Cursor;
    //   261: astore_3
    //   262: aload_3
    //   263: ifnull +54 -> 317
    //   266: aload_3
    //   267: astore_2
    //   268: aload_3
    //   269: invokeinterface 292 1 0
    //   274: ifeq +43 -> 317
    //   277: aload_3
    //   278: astore_2
    //   279: aload 5
    //   281: aload_3
    //   282: iconst_0
    //   283: invokeinterface 300 2 0
    //   288: putfield 90	com/android/mail/providers/Attachment:size	I
    //   291: aload_3
    //   292: ifnull -129 -> 163
    //   295: aload_3
    //   296: invokeinterface 303 1 0
    //   301: goto -138 -> 163
    //   304: astore_1
    //   305: aload_2
    //   306: ifnull +9 -> 315
    //   309: aload_2
    //   310: invokeinterface 303 1 0
    //   315: aload_1
    //   316: athrow
    //   317: aload_3
    //   318: astore_2
    //   319: aload 5
    //   321: aload_0
    //   322: aload_1
    //   323: aload 4
    //   325: invokevirtual 312	com/android/mail/compose/AttachmentsView:getSizeFromFile	(Landroid/net/Uri;Landroid/content/ContentResolver;)I
    //   328: putfield 90	com/android/mail/providers/Attachment:size	I
    //   331: goto -40 -> 291
    //   334: astore_1
    //   335: aload_2
    //   336: ifnull +9 -> 345
    //   339: aload_2
    //   340: invokeinterface 303 1 0
    //   345: aload_1
    //   346: athrow
    //   347: astore_1
    //   348: new 13	com/android/mail/compose/AttachmentsView$AttachmentFailureException
    //   351: dup
    //   352: ldc_w 314
    //   355: aload_1
    //   356: invokespecial 317	com/android/mail/compose/AttachmentsView$AttachmentFailureException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   359: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	AttachmentsView
    //   0	360	1	paramUri	Uri
    //   42	298	2	localObject1	Object
    //   15	179	3	localObject2	Object
    //   198	1	3	localSQLiteException	SQLiteException
    //   209	109	3	localCursor	Cursor
    //   7	317	4	localContentResolver	ContentResolver
    //   58	262	5	localAttachment	Attachment
    //   183	13	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   122	155	183	finally
    //   92	118	198	android/database/sqlite/SQLiteException
    //   157	163	198	android/database/sqlite/SQLiteException
    //   187	193	198	android/database/sqlite/SQLiteException
    //   195	198	198	android/database/sqlite/SQLiteException
    //   199	210	304	finally
    //   216	225	304	finally
    //   227	239	304	finally
    //   251	262	334	finally
    //   268	277	334	finally
    //   279	291	334	finally
    //   319	331	334	finally
    //   92	118	347	java/lang/SecurityException
    //   157	163	347	java/lang/SecurityException
    //   187	193	347	java/lang/SecurityException
    //   195	198	347	java/lang/SecurityException
  }
  
  public ArrayList<AttachmentTile.AttachmentPreview> getAttachmentPreviews()
  {
    return mTileGrid.getAttachmentPreviews();
  }
  
  public ArrayList<Attachment> getAttachments()
  {
    return mAttachments;
  }
  
  protected int getSizeFromFile(Uri paramUri, ContentResolver paramContentResolver)
  {
    int i = -1;
    Object localObject = null;
    Uri localUri = null;
    for (;;)
    {
      try
      {
        paramUri = paramContentResolver.openFileDescriptor(paramUri, "r");
        localUri = paramUri;
        localObject = paramUri;
        long l = paramUri.getStatSize();
        j = (int)l;
        i = j;
      }
      catch (FileNotFoundException paramUri)
      {
        int j;
        localObject = localUri;
        LogUtils.w(LOG_TAG, "Error opening file to obtain size.", new Object[0]);
        if (localUri == null) {
          continue;
        }
        try
        {
          localUri.close();
          return -1;
        }
        catch (IOException paramUri)
        {
          LogUtils.w(LOG_TAG, "Error closing file opened to obtain size.", new Object[0]);
          return -1;
        }
      }
      finally
      {
        if (localObject == null) {
          break label127;
        }
      }
      try
      {
        paramUri.close();
        i = j;
        return i;
      }
      catch (IOException paramUri)
      {
        LogUtils.w(LOG_TAG, "Error closing file opened to obtain size.", new Object[0]);
        return j;
      }
    }
    try
    {
      ((ParcelFileDescriptor)localObject).close();
      label127:
      throw paramUri;
    }
    catch (IOException paramContentResolver)
    {
      for (;;)
      {
        LogUtils.w(LOG_TAG, "Error closing file opened to obtain size.", new Object[0]);
      }
    }
  }
  
  public long getTotalAttachmentsSize()
  {
    long l = 0L;
    Iterator localIterator = mAttachments.iterator();
    while (localIterator.hasNext()) {
      l += nextsize;
    }
    return l;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mTileGrid = ((AttachmentTileGrid)findViewById(2131755090));
    mAttachmentLayout = ((LinearLayout)findViewById(2131755091));
  }
  
  public void setAttachmentChangesListener(AttachmentAddedOrDeletedListener paramAttachmentAddedOrDeletedListener)
  {
    mChangeListener = paramAttachmentAddedOrDeletedListener;
  }
  
  public void setAttachmentPreviews(ArrayList<AttachmentTile.AttachmentPreview> paramArrayList)
  {
    mTileGrid.setAttachmentPreviews(paramArrayList);
  }
  
  public static abstract interface AttachmentAddedOrDeletedListener
  {
    public abstract void onAttachmentAdded();
    
    public abstract void onAttachmentDeleted();
  }
  
  static class AttachmentFailureException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    private final int errorRes;
    
    public AttachmentFailureException(String paramString)
    {
      super();
      errorRes = 2131492912;
    }
    
    public AttachmentFailureException(String paramString, int paramInt)
    {
      super();
      errorRes = paramInt;
    }
    
    public AttachmentFailureException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
      errorRes = 2131492912;
    }
    
    public int getErrorRes()
    {
      return errorRes;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.AttachmentsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */