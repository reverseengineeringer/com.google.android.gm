package com.android.mail.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.Loader.OnLoadCompleteListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Looper;
import android.support.v4.app.TaskStackBuilder;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.CharacterStyle;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.android.mail.browse.SendersView;
import com.android.mail.persistence.Persistence;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.providers.UIProvider;
import com.android.mail.utils.AccountUtils;
import com.android.mail.utils.DelayedTaskHandler;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.google.android.common.html.parser.HtmlParser;
import com.google.android.common.html.parser.HtmlTreeBuilder;

public class WidgetService
  extends RemoteViewsService
{
  private static final String LOG_TAG = LogTag.getLogTag();
  private static Object sWidgetLock = new Object();
  
  public static void configureValidAccountWidget(Context paramContext, RemoteViews paramRemoteViews, int paramInt, com.android.mail.providers.Account paramAccount, Folder paramFolder, String paramString, Class<?> paramClass)
  {
    paramRemoteViews.setViewVisibility(2131755271, 0);
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(name))) {
      LogUtils.e(LOG_TAG, new Error(), "Empty folder or account name.  account: %s, folder: %s", new Object[] { name, paramString });
    }
    if (!TextUtils.isEmpty(paramString)) {
      paramRemoteViews.setTextViewText(2131755271, paramString);
    }
    paramRemoteViews.setViewVisibility(2131755272, 0);
    if (!TextUtils.isEmpty(name)) {
      paramRemoteViews.setTextViewText(2131755272, name);
    }
    paramRemoteViews.setViewVisibility(2131755273, 0);
    paramRemoteViews.setViewVisibility(2131755274, 0);
    paramRemoteViews.setViewVisibility(2131755275, 0);
    paramRemoteViews.setViewVisibility(2131755277, 8);
    configureValidWidgetIntents(paramContext, paramRemoteViews, paramInt, paramAccount, paramFolder, paramString, paramClass);
  }
  
  public static void configureValidWidgetIntents(Context paramContext, RemoteViews paramRemoteViews, int paramInt, com.android.mail.providers.Account paramAccount, Folder paramFolder, String paramString, Class<?> paramClass)
  {
    paramRemoteViews.setViewVisibility(2131755276, 8);
    paramString = new Intent(paramContext, paramClass);
    paramString.putExtra("appWidgetId", paramInt);
    paramString.putExtra("account", paramAccount.serialize());
    paramString.putExtra("folder", Folder.toString(paramFolder));
    paramString.setData(Uri.parse(paramString.toUri(1)));
    paramRemoteViews.setRemoteAdapter(2131755275, paramString);
    paramFolder = Utils.createViewFolderIntent(paramFolder, paramAccount);
    paramRemoteViews.setOnClickPendingIntent(2131755269, PendingIntent.getActivity(paramContext, 0, paramFolder, 134217728));
    paramString = new Intent();
    paramString.setAction("android.intent.action.SEND");
    paramString.putExtra("account", paramAccount.serialize());
    paramString.setData(composeIntentUri);
    paramString.putExtra("fromemail", true);
    if (composeIntentUri != null) {
      paramString.putExtra("composeUri", composeIntentUri);
    }
    paramRemoteViews.setOnClickPendingIntent(2131755274, TaskStackBuilder.create(paramContext).addNextIntent(paramFolder).addNextIntent(paramString).getPendingIntent(0, 134217728));
    paramAccount = new Intent();
    paramAccount.setAction("android.intent.action.VIEW");
    paramRemoteViews.setPendingIntentTemplate(2131755275, PendingIntent.getActivity(paramContext, 0, paramAccount, 134217728));
  }
  
  private static String createWidgetPreferenceValue(com.android.mail.providers.Account paramAccount, Folder paramFolder)
  {
    return uri.toString() + " " + uri.toString();
  }
  
  public static void saveWidgetInformation(Context paramContext, int paramInt, com.android.mail.providers.Account paramAccount, Folder paramFolder)
  {
    paramContext = Persistence.getPreferences(paramContext).edit();
    paramContext.putString("widget-account-" + paramInt, createWidgetPreferenceValue(paramAccount, paramFolder));
    paramContext.apply();
  }
  
  protected void configureValidAccountWidget(Context paramContext, RemoteViews paramRemoteViews, int paramInt, com.android.mail.providers.Account paramAccount, Folder paramFolder, String paramString)
  {
    configureValidAccountWidget(paramContext, paramRemoteViews, paramInt, paramAccount, paramFolder, paramString, WidgetService.class);
  }
  
  protected boolean isAccountValid(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    if (paramAccount != null)
    {
      paramContext = AccountUtils.getSyncingAccounts(paramContext);
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        if ((paramAccount != null) && (localObject != null) && (uri.equals(uri))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean isWidgetConfigured(Context paramContext, int paramInt, com.android.mail.providers.Account paramAccount, Folder paramFolder)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isAccountValid(paramContext, paramAccount))
    {
      bool1 = bool2;
      if (Persistence.getPreferences(paramContext).getString("widget-account-" + paramInt, null) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent paramIntent)
  {
    return new MailFactory(getApplicationContext(), paramIntent, this);
  }
  
  protected static class MailFactory
    implements RemoteViewsService.RemoteViewsFactory, Loader.OnLoadCompleteListener<Cursor>
  {
    private final com.android.mail.providers.Account mAccount;
    private final int mAppWidgetId;
    private final Context mContext;
    private Cursor mConversationCursor;
    private CursorLoader mConversationCursorLoader;
    private String mElidedPaddingToken;
    private Folder mFolder;
    private int mFolderCount;
    private boolean mFolderInformationShown = false;
    private CursorLoader mFolderLoader;
    private FolderUpdateHandler mFolderUpdateHandler;
    private TextAppearanceSpan mReadStyle;
    private String mSendersSplitToken;
    private WidgetService mService;
    private boolean mShouldShowViewMore;
    private TextAppearanceSpan mUnreadStyle;
    private final WidgetConversationViewBuilder mWidgetConversationViewBuilder;
    
    public MailFactory(Context paramContext, Intent paramIntent, WidgetService paramWidgetService)
    {
      mContext = paramContext;
      mAppWidgetId = paramIntent.getIntExtra("appWidgetId", 0);
      mAccount = com.android.mail.providers.Account.newinstance(paramIntent.getStringExtra("account"));
      mFolder = Folder.fromString(paramIntent.getStringExtra("folder"));
      mWidgetConversationViewBuilder = new WidgetConversationViewBuilder(paramContext, mAccount);
      mService = paramWidgetService;
    }
    
    private SpannableString copyStyles(CharacterStyle[] paramArrayOfCharacterStyle, CharSequence paramCharSequence)
    {
      paramCharSequence = new SpannableString(paramCharSequence);
      if ((paramArrayOfCharacterStyle != null) && (paramArrayOfCharacterStyle.length > 0)) {
        paramCharSequence.setSpan(paramArrayOfCharacterStyle[0], 0, paramCharSequence.length(), 0);
      }
      return paramCharSequence;
    }
    
    private SpannableStringBuilder ellipsizeStyledSenders(ConversationInfo paramConversationInfo, int paramInt, SpannableString[] paramArrayOfSpannableString)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      paramConversationInfo = null;
      int i = paramArrayOfSpannableString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        SpannableString localSpannableString = paramArrayOfSpannableString[paramInt];
        if (localSpannableString == null)
        {
          LogUtils.e(WidgetService.LOG_TAG, "null sender while iterating over styledSenders", new Object[0]);
          paramInt += 1;
        }
        else
        {
          CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])localSpannableString.getSpans(0, localSpannableString.length(), CharacterStyle.class);
          if (SendersView.sElidedString.equals(localSpannableString.toString())) {
            paramConversationInfo = copyStyles(arrayOfCharacterStyle, mElidedPaddingToken + localSpannableString + mElidedPaddingToken);
          }
          for (;;)
          {
            localSpannableStringBuilder.append(paramConversationInfo);
            paramConversationInfo = localSpannableString;
            break;
            if ((localSpannableStringBuilder.length() > 0) && ((paramConversationInfo == null) || (!SendersView.sElidedString.equals(paramConversationInfo.toString())))) {
              paramConversationInfo = copyStyles(arrayOfCharacterStyle, mSendersSplitToken + localSpannableString);
            } else {
              paramConversationInfo = localSpannableString;
            }
          }
        }
      }
      return localSpannableStringBuilder;
    }
    
    private static String filterTag(String paramString)
    {
      String str1 = paramString;
      String str2 = str1;
      if (paramString.length() > 0)
      {
        str2 = str1;
        if (paramString.charAt(0) == '[')
        {
          int i = paramString.indexOf(']');
          str2 = str1;
          if (i > 0)
          {
            str1 = paramString.substring(1, i);
            str2 = "[" + Utils.ellipsize(str1, 7) + "]" + paramString.substring(i + 1);
          }
        }
      }
      return str2;
    }
    
    private int getConversationCount()
    {
      for (;;)
      {
        synchronized (WidgetService.sWidgetLock)
        {
          if (mConversationCursor != null)
          {
            i = mConversationCursor.getCount();
            i = Math.min(i, 25);
            return i;
          }
        }
        int i = 0;
      }
    }
    
    private CharacterStyle getReadStyle()
    {
      if (mReadStyle == null) {
        mReadStyle = new TextAppearanceSpan(mContext, 2131558474);
      }
      return CharacterStyle.wrap(mReadStyle);
    }
    
    private CharacterStyle getUnreadStyle()
    {
      if (mUnreadStyle == null) {
        mUnreadStyle = new TextAppearanceSpan(mContext, 2131558475);
      }
      return CharacterStyle.wrap(mUnreadStyle);
    }
    
    private RemoteViews getViewMoreConversationsView()
    {
      RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130968700);
      localRemoteViews.setTextViewText(2131755290, mContext.getText(2131493082));
      localRemoteViews.setOnClickFillInIntent(2131755289, Utils.createViewFolderIntent(mFolder, mAccount));
      return localRemoteViews;
    }
    
    private boolean isDataValid(Cursor paramCursor)
    {
      return (paramCursor != null) && (!paramCursor.isClosed()) && (paramCursor.moveToFirst());
    }
    
    public int getCount()
    {
      int j = 1;
      for (;;)
      {
        synchronized (WidgetService.sWidgetLock)
        {
          int k = getConversationCount();
          if (mConversationCursor == null) {
            break label84;
          }
          i = mConversationCursor.getCount();
          if (k >= i)
          {
            if (k >= mFolderCount) {
              break label89;
            }
            break label78;
            mShouldShowViewMore = bool;
            if (!mShouldShowViewMore) {
              break label95;
            }
            i = j;
            return i + k;
          }
        }
        label78:
        boolean bool = true;
        continue;
        label84:
        int i = 0;
        continue;
        label89:
        bool = false;
        continue;
        label95:
        i = 0;
      }
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public RemoteViews getLoadingView()
    {
      RemoteViews localRemoteViews = new RemoteViews(mContext.getPackageName(), 2130968700);
      localRemoteViews.setTextViewText(2131755290, mContext.getText(2131493083));
      return localRemoteViews;
    }
    
    public RemoteViews getViewAt(int paramInt)
    {
      synchronized (WidgetService.sWidgetLock)
      {
        RemoteViews localRemoteViews;
        if ((mConversationCursor == null) || (mConversationCursor.isClosed()) || ((mShouldShowViewMore) && (paramInt >= getConversationCount())))
        {
          localRemoteViews = getViewMoreConversationsView();
          return localRemoteViews;
        }
        if (!mConversationCursor.moveToPosition(paramInt))
        {
          LogUtils.e(WidgetService.LOG_TAG, "Failed to move to position %d in the cursor.", new Object[] { Integer.valueOf(paramInt) });
          localRemoteViews = getViewMoreConversationsView();
          return localRemoteViews;
        }
      }
      Conversation localConversation = new Conversation(mConversationCursor);
      Object localObject3 = new SpannableStringBuilder();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (conversationInfo != null)
      {
        localObject2 = ellipsizeStyledSenders(conversationInfo, 25, SendersView.format(mContext, conversationInfo, "", 25, new HtmlParser(), new HtmlTreeBuilder()));
        localObject3 = DateUtils.getRelativeTimeSpanString(mContext, dateMs);
        localObject2 = mWidgetConversationViewBuilder.getStyledView(localSpannableStringBuilder, (CharSequence)localObject3, localConversation, mFolder, (SpannableStringBuilder)localObject2, filterTag(subject));
        ((RemoteViews)localObject2).setOnClickFillInIntent(2131755278, Utils.createViewConversationIntent(localConversation, mFolder, mAccount));
        return (RemoteViews)localObject2;
      }
      ((SpannableStringBuilder)localObject3).append(senders);
      if (read) {}
      for (Object localObject2 = getReadStyle();; localObject2 = getUnreadStyle())
      {
        ((SpannableStringBuilder)localObject3).setSpan(localObject2, 0, ((SpannableStringBuilder)localObject3).length(), 0);
        localObject2 = localObject3;
        break;
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public boolean hasStableIds()
    {
      return false;
    }
    
    public void onCreate()
    {
      WidgetService.saveWidgetInformation(mContext, mAppWidgetId, mAccount, mFolder);
      if (!mService.isWidgetConfigured(mContext, mAppWidgetId, mAccount, mFolder)) {
        BaseWidgetProvider.updateWidget(mContext, mAppWidgetId, mAccount, mFolder);
      }
      mFolderInformationShown = false;
      Uri localUri = mFolder.conversationListUri.buildUpon().appendQueryParameter("limit", Integer.toString(25)).appendQueryParameter("use_network", Boolean.FALSE.toString()).appendQueryParameter("all_notifications", Boolean.TRUE.toString()).build();
      Resources localResources = mContext.getResources();
      mConversationCursorLoader = new CursorLoader(mContext, localUri, UIProvider.CONVERSATION_PROJECTION, null, null, null);
      mConversationCursorLoader.registerListener(1, this);
      mConversationCursorLoader.setUpdateThrottle(localResources.getInteger(2131361823));
      mConversationCursorLoader.startLoading();
      mSendersSplitToken = localResources.getString(2131493120);
      mElidedPaddingToken = localResources.getString(2131493123);
      mFolderLoader = new CursorLoader(mContext, mFolder.uri, UIProvider.FOLDERS_PROJECTION, null, null, null);
      mFolderLoader.registerListener(0, this);
      mFolderUpdateHandler = new FolderUpdateHandler(localResources.getInteger(2131361824));
      mFolderUpdateHandler.scheduleTask();
    }
    
    public void onDataSetChanged()
    {
      mFolderUpdateHandler.scheduleTask();
    }
    
    public void onDestroy()
    {
      synchronized (WidgetService.sWidgetLock)
      {
        if (mConversationCursorLoader != null)
        {
          mConversationCursorLoader.reset();
          mConversationCursorLoader.unregisterListener(this);
          mConversationCursorLoader = null;
        }
        mConversationCursor = null;
        if (mFolderLoader != null)
        {
          mFolderLoader.reset();
          mFolderLoader.unregisterListener(this);
          mFolderLoader = null;
        }
        return;
      }
    }
    
    public void onLoadComplete(Loader<Cursor> arg1, Cursor paramCursor)
    {
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(mContext);
      if (??? == mFolderLoader) {
        if (isDataValid(paramCursor)) {}
      }
      while (??? != mConversationCursorLoader)
      {
        return;
        int i = paramCursor.getInt(8);
        ??? = paramCursor.getString(2);
        mFolderCount = paramCursor.getInt(9);
        paramCursor = new RemoteViews(mContext.getPackageName(), 2130968698);
        if ((!mFolderInformationShown) && (!TextUtils.isEmpty(???)) && (!TextUtils.isEmpty(mAccount.name)))
        {
          mService.configureValidAccountWidget(mContext, paramCursor, mAppWidgetId, mAccount, mFolder, ???);
          localAppWidgetManager.updateAppWidget(mAppWidgetId, paramCursor);
          mFolderInformationShown = true;
        }
        if (!TextUtils.isEmpty(???))
        {
          paramCursor.setViewVisibility(2131755271, 0);
          paramCursor.setTextViewText(2131755271, ???);
        }
        for (;;)
        {
          paramCursor.setViewVisibility(2131755273, 0);
          paramCursor.setTextViewText(2131755273, Utils.getUnreadCountString(mContext, i));
          localAppWidgetManager.partiallyUpdateAppWidget(mAppWidgetId, paramCursor);
          return;
          LogUtils.e(WidgetService.LOG_TAG, "Empty folder name", new Object[0]);
        }
      }
      synchronized (WidgetService.sWidgetLock)
      {
        if (!isDataValid(paramCursor))
        {
          mConversationCursor = null;
          localAppWidgetManager.notifyAppWidgetViewDataChanged(mAppWidgetId, 2131755275);
          return;
        }
        mConversationCursor = paramCursor;
      }
    }
    
    private class FolderUpdateHandler
      extends DelayedTaskHandler
    {
      public FolderUpdateHandler(int paramInt)
      {
        super(paramInt);
      }
      
      protected void performTask()
      {
        if (mFolderLoader != null) {
          mFolderLoader.startLoading();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.widget.WidgetService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */