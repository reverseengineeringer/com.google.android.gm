package com.android.mail.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import android.text.style.CharacterStyle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.google.android.common.html.parser.HtmlDocument;
import com.google.android.common.html.parser.HtmlParser;
import com.google.android.common.html.parser.HtmlTree;
import com.google.android.common.html.parser.HtmlTreeBuilder;
import com.google.common.collect.Maps;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class Utils
{
  private static final String LOG_TAG;
  public static final Character SENDER_LIST_SEPARATOR;
  private static int sDefaultFolderBackgroundColor;
  private static int sMaxUnreadCount;
  private static final Map<Integer, Integer> sPriorityToLength;
  public static String[] sSenderFragments;
  public static final TextUtils.SimpleStringSplitter sSenderListSplitter;
  private static CharacterStyle sUnreadStyleSpan;
  private static String sUnreadText;
  private static int sUseFolderListFragmentTransition;
  private static String sVersionCode;
  
  static
  {
    if (!Utils.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      sPriorityToLength = Maps.newHashMap();
      SENDER_LIST_SEPARATOR = Character.valueOf('\n');
      sSenderListSplitter = new TextUtils.SimpleStringSplitter(SENDER_LIST_SEPARATOR.charValue());
      sSenderFragments = new String[8];
      sVersionCode = null;
      LOG_TAG = LogTag.getLogTag();
      sUnreadStyleSpan = null;
      sMaxUnreadCount = -1;
      sDefaultFolderBackgroundColor = -1;
      sUseFolderListFragmentTransition = -1;
      return;
    }
  }
  
  private static Uri addParamsToUrl(Context paramContext, String paramString)
  {
    paramString = Uri.parse(replaceLocale(paramString)).buildUpon();
    String str = getVersionCode(paramContext);
    paramContext = paramString;
    if (str != null) {
      paramContext = paramString.appendQueryParameter("version", str);
    }
    return paramContext.build();
  }
  
  public static void checkRequestLayout(View paramView)
  {
    if ((paramView.getRootView() == null) || (paramView.isLayoutRequested())) {}
    label113:
    for (;;)
    {
      return;
      Error localError = new Error();
      StackTraceElement[] arrayOfStackTraceElement = localError.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      if (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if ((!"android.view.ViewGroup".equals(localStackTraceElement.getClassName())) || (!"layout".equals(localStackTraceElement.getMethodName()))) {}
      }
      for (i = 1;; i = 0)
      {
        if ((i == 0) || (paramView.isLayoutRequested())) {
          break label113;
        }
        LogUtils.i("MailBlankFragment", localError, "WARNING: in requestLayout during layout pass, view=%s", new Object[] { paramView });
        return;
        i += 1;
        break;
      }
    }
  }
  
  public static Object cleanUpString(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (paramBoolean) {
        str = paramString.replace("\"\"", "");
      }
      return TextUtils.htmlEncode(str);
    }
    return "";
  }
  
  public static String convertHtmlToPlainText(String paramString)
  {
    return getHtmlTree(paramString, new HtmlParser(), new HtmlTreeBuilder()).getPlainText();
  }
  
  public static String convertHtmlToPlainText(String paramString, HtmlParser paramHtmlParser, HtmlTreeBuilder paramHtmlTreeBuilder)
  {
    return getHtmlTree(paramString, paramHtmlParser, paramHtmlTreeBuilder).getPlainText();
  }
  
  public static Intent createViewConversationIntent(Conversation paramConversation, Folder paramFolder, Account paramAccount)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268484608);
    localIntent.setDataAndType(uri, mimeType);
    localIntent.putExtra("account", paramAccount.serialize());
    localIntent.putExtra("folder", Folder.toString(paramFolder));
    localIntent.putExtra("conversationUri", paramConversation);
    return localIntent;
  }
  
  public static Intent createViewFolderIntent(Folder paramFolder, Account paramAccount)
  {
    if ((paramFolder == null) || (paramAccount == null))
    {
      LogUtils.wtf(LOG_TAG, "Utils.createViewFolderIntent(%s,%s): Bad input", new Object[] { paramFolder, paramAccount });
      return null;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268484608);
    localIntent.setDataAndType(uri, mimeType);
    localIntent.putExtra("account", paramAccount.serialize());
    localIntent.putExtra("folder", Folder.toString(paramFolder));
    return localIntent;
  }
  
  public static Intent createViewInboxIntent(Account paramAccount)
  {
    if (paramAccount == null)
    {
      LogUtils.wtf(LOG_TAG, "Utils.createViewInboxIntent(%s): Bad input", new Object[] { paramAccount });
      return null;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268484608);
    localIntent.setDataAndType(settings.defaultInbox, mimeType);
    localIntent.putExtra("account", paramAccount.serialize());
    return localIntent;
  }
  
  public static boolean disableConversationCursorNetworkAccess(Cursor paramCursor)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("allowNetwork", false);
    return executeConversationCursorCommand(paramCursor, localBundle, "allowNetwork");
  }
  
  public static String ellipsize(String paramString, int paramInt)
  {
    int i = paramString.length();
    if (i < paramInt) {
      return paramString;
    }
    paramInt = Math.min(paramInt, i);
    int j = paramString.lastIndexOf(".");
    String str2 = "…";
    String str1 = str2;
    if (j >= 0)
    {
      str1 = str2;
      if (i - j <= 5) {
        str1 = "…" + paramString.substring(j + 1);
      }
    }
    i = paramInt - str1.length();
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    return paramString.substring(0, paramInt) + str1;
  }
  
  public static boolean enableConversationCursorNetworkAccess(Cursor paramCursor)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("allowNetwork", true);
    return executeConversationCursorCommand(paramCursor, localBundle, "allowNetwork");
  }
  
  public static void enableHardwareLayer(View paramView)
  {
    if ((paramView != null) && (paramView.isHardwareAccelerated()))
    {
      paramView.setLayerType(2, null);
      paramView.buildLayer();
    }
  }
  
  public static String ensureQuotedString(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.matches("^\".*\"$"));
    return "\"" + paramString + "\"";
  }
  
  private static boolean executeConversationCursorCommand(Cursor paramCursor, Bundle paramBundle, String paramString)
  {
    return "ok".equals(paramCursor.respond(paramBundle).getString(paramString, "failed"));
  }
  
  public static void fixSubTreeLayoutIfOrphaned(View paramView, String paramString)
  {
    if (isLayoutSubTreeOrphaned(paramView)) {
      markDirtyTillRoot(paramString, paramView);
    }
  }
  
  public static String formatPlural(Context paramContext, int paramInt1, int paramInt2)
  {
    return String.format(paramContext.getResources().getQuantityText(paramInt1, paramInt2).toString(), new Object[] { Integer.valueOf(paramInt2) });
  }
  
  public static long getConversationId(ConversationCursor paramConversationCursor)
  {
    return paramConversationCursor.getLong(0);
  }
  
  public static int getDefaultFolderBackgroundColor(Context paramContext)
  {
    if (sDefaultFolderBackgroundColor == -1) {
      sDefaultFolderBackgroundColor = paramContext.getResources().getColor(2131296275);
    }
    return sDefaultFolderBackgroundColor;
  }
  
  public static String getFileExtension(String paramString)
  {
    Object localObject2 = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (int i = paramString.lastIndexOf('.');; i = -1)
    {
      Object localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (paramString.length() - i <= 5) {
          localObject1 = paramString.substring(i);
        }
      }
      return (String)localObject1;
    }
  }
  
  public static int getFolderUnreadDisplayCount(Folder paramFolder)
  {
    if (paramFolder != null)
    {
      switch (type)
      {
      case 4: 
      default: 
        return unreadCount;
      }
      return totalCount;
    }
    return 0;
  }
  
  public static HtmlTree getHtmlTree(String paramString)
  {
    return getHtmlTree(paramString, new HtmlParser(), new HtmlTreeBuilder());
  }
  
  public static HtmlTree getHtmlTree(String paramString, HtmlParser paramHtmlParser, HtmlTreeBuilder paramHtmlTreeBuilder)
  {
    paramHtmlParser.parse(paramString).accept(paramHtmlTreeBuilder);
    return paramHtmlTreeBuilder.getTree();
  }
  
  public static CharSequence getSyncStatusText(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getStringArray(2131623943);
    paramInt &= 0xF;
    if (paramInt >= paramContext.length) {
      return "";
    }
    return paramContext[paramInt];
  }
  
  public static int getTransparentColor(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }
  
  public static String getUnreadCountString(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    if (sMaxUnreadCount == -1) {
      sMaxUnreadCount = paramContext.getInteger(2131361820);
    }
    if (paramInt > sMaxUnreadCount)
    {
      if (sUnreadText == null) {
        sUnreadText = paramContext.getString(2131493081);
      }
      return String.format(sUnreadText, new Object[] { Integer.valueOf(sMaxUnreadCount) });
    }
    if (paramInt <= 0) {
      return "";
    }
    return String.valueOf(paramInt);
  }
  
  public static Uri getValidUri(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString == JSONObject.NULL)) {
      return Uri.EMPTY;
    }
    return Uri.parse(paramString);
  }
  
  public static String getVersionCode(Context paramContext)
  {
    if (sVersionCode == null) {}
    try
    {
      sVersionCode = String.valueOf(getPackageManagergetPackageInfogetPackageName0versionCode);
      return sVersionCode;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        LogUtils.e(LOG_TAG, "Error finding package %s", new Object[] { getApplicationInfopackageName });
      }
    }
  }
  
  public static boolean isEmpty(Uri paramUri)
  {
    return (paramUri == null) || (paramUri.equals(Uri.EMPTY));
  }
  
  public static boolean isLayoutSubTreeOrphaned(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return false;
      boolean bool = paramView.isLayoutRequested();
      for (paramView = paramView.getParent(); (bool) && (paramView != null); paramView = paramView.getParent()) {
        if (!paramView.isLayoutRequested()) {
          return true;
        }
      }
    }
  }
  
  public static boolean isRunningJellybeanOrLater()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static void markDirtyTillRoot(String paramString, View paramView) {}
  
  public static int measureViewHeight(View paramView, ViewGroup paramViewGroup)
  {
    paramView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), paramViewGroup.getPaddingLeft() + paramViewGroup.getPaddingRight(), -1), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramView.getMeasuredHeight();
  }
  
  public static String normalizeMimeType(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    String str;
    int i;
    do
    {
      return paramString;
      str = paramString.trim().toLowerCase(Locale.US);
      i = str.indexOf(';');
      paramString = str;
    } while (i == -1);
    return str.substring(0, i);
  }
  
  public static Uri normalizeUri(Uri paramUri)
  {
    String str1 = paramUri.getScheme();
    if (str1 == null) {}
    String str2;
    do
    {
      return paramUri;
      str2 = str1.toLowerCase(Locale.US);
    } while (str1.equals(str2));
    return paramUri.buildUpon().scheme(str2).build();
  }
  
  private static void openUrl(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString())))
    {
      LogUtils.wtf(LOG_TAG, "invalid url in Utils.openUrl(): %s", new Object[] { paramUri });
      return;
    }
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    if (paramBundle != null) {
      paramUri.putExtras(paramBundle);
    }
    paramUri.putExtra("com.android.browser.application_id", paramContext.getPackageName());
    paramUri.addFlags(524288);
    paramContext.startActivity(paramUri);
  }
  
  private static String replaceLocale(String paramString)
  {
    Object localObject = paramString;
    if (paramString.contains("%locale%"))
    {
      localObject = Locale.getDefault();
      localObject = paramString.replace("%locale%", ((Locale)localObject).getLanguage() + "_" + ((Locale)localObject).getCountry().toLowerCase());
    }
    return (String)localObject;
  }
  
  public static void restrictWebView(WebView paramWebView)
  {
    paramWebView = paramWebView.getSettings();
    paramWebView.setSavePassword(false);
    paramWebView.setSaveFormData(false);
    paramWebView.setJavaScriptEnabled(true);
    paramWebView.setSupportZoom(false);
  }
  
  public static void sendFeedback(Context paramContext, Account paramAccount, boolean paramBoolean)
  {
    if ((paramAccount != null) && (sendFeedbackIntentUri != null))
    {
      Bundle localBundle = new Bundle(1);
      localBundle.putBoolean("reporting_problem", paramBoolean);
      openUrl(paramContext, sendFeedbackIntentUri, localBundle);
    }
  }
  
  public static void setConversationCursorVisibility(Cursor paramCursor, boolean paramBoolean1, boolean paramBoolean2)
  {
    new MarkConversationCursorVisibleTask(paramCursor, paramBoolean1, paramBoolean2).execute(new Void[0]);
  }
  
  public static Intent setIntentDataAndTypeAndNormalize(Intent paramIntent, Uri paramUri, String paramString)
  {
    return paramIntent.setDataAndType(normalizeUri(paramUri), normalizeMimeType(paramString));
  }
  
  public static Intent setIntentTypeAndNormalize(Intent paramIntent, String paramString)
  {
    return paramIntent.setType(normalizeMimeType(paramString));
  }
  
  public static void setMenuItemVisibility(Menu paramMenu, int paramInt, boolean paramBoolean)
  {
    paramMenu = paramMenu.findItem(paramInt);
    if (paramMenu == null) {
      return;
    }
    paramMenu.setVisible(paramBoolean);
  }
  
  public static boolean shouldShowDisabledArchiveIcon(Context paramContext)
  {
    return paramContext.getResources().getBoolean(2131689474);
  }
  
  public static void showFolderSettings(Context paramContext, Account paramAccount, Folder paramFolder)
  {
    if ((paramAccount == null) || (paramFolder == null))
    {
      LogUtils.e(LOG_TAG, "Invalid attempt to show folder settings. account: %s folder: %s", new Object[] { paramAccount, paramFolder });
      return;
    }
    Intent localIntent = new Intent("android.intent.action.EDIT", settingsIntentUri);
    localIntent.putExtra("extra_account", paramAccount);
    localIntent.putExtra("extra_folder", paramFolder);
    localIntent.addFlags(524288);
    paramContext.startActivity(localIntent);
  }
  
  public static void showHelp(Context paramContext, Account paramAccount, String paramString)
  {
    if ((paramAccount != null) && (helpIntentUri != null)) {}
    for (Object localObject = helpIntentUri.toString(); TextUtils.isEmpty((CharSequence)localObject); localObject = null)
    {
      LogUtils.e(LOG_TAG, "unable to show help for account: %s", new Object[] { paramAccount });
      return;
    }
    localObject = addParamsToUrl(paramContext, (String)localObject).buildUpon();
    paramAccount = (Account)localObject;
    if (!TextUtils.isEmpty(paramString)) {
      paramAccount = ((Uri.Builder)localObject).appendQueryParameter("p", paramString);
    }
    openUrl(paramContext, paramAccount.build(), null);
  }
  
  public static void showManageFolder(Context paramContext, Account paramAccount)
  {
    if (paramAccount == null)
    {
      LogUtils.e(LOG_TAG, "Invalid attempt to the manage folders screen with null account", new Object[0]);
      return;
    }
    Intent localIntent = new Intent("android.intent.action.EDIT", settingsIntentUri);
    localIntent.putExtra("extra_account", paramAccount);
    localIntent.putExtra("extra_manage_folders", true);
    localIntent.addFlags(524288);
    paramContext.startActivity(localIntent);
  }
  
  public static void showSettings(Context paramContext, Account paramAccount)
  {
    if (paramAccount == null)
    {
      LogUtils.e(LOG_TAG, "Invalid attempt to show setting screen with null account", new Object[0]);
      return;
    }
    paramAccount = new Intent("android.intent.action.EDIT", settingsIntentUri);
    paramAccount.addFlags(524288);
    paramContext.startActivity(paramAccount);
  }
  
  public static boolean showTwoPaneSearchResults(Context paramContext)
  {
    return paramContext.getResources().getBoolean(2131689473);
  }
  
  public static boolean useFolderListFragmentTransition(Context paramContext)
  {
    if (sUseFolderListFragmentTransition == -1) {
      sUseFolderListFragmentTransition = paramContext.getResources().getInteger(2131361838);
    }
    return sUseFolderListFragmentTransition != 0;
  }
  
  public static boolean useTabletUI(Context paramContext)
  {
    return paramContext.getResources().getInteger(2131361810) != 0;
  }
  
  private static class MarkConversationCursorVisibleTask
    extends AsyncTask<Void, Void, Void>
  {
    private final Cursor mCursor;
    private final boolean mIsFirstSeen;
    private final boolean mVisible;
    
    public MarkConversationCursorVisibleTask(Cursor paramCursor, boolean paramBoolean1, boolean paramBoolean2)
    {
      mCursor = paramCursor;
      mVisible = paramBoolean1;
      mIsFirstSeen = paramBoolean2;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      if (mCursor == null) {
        return null;
      }
      paramVarArgs = new Bundle();
      if (mIsFirstSeen) {
        paramVarArgs.putBoolean("enteredFolder", true);
      }
      paramVarArgs.putBoolean("setVisibility", mVisible);
      Utils.executeConversationCursorCommand(mCursor, paramVarArgs, "setVisibility");
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */