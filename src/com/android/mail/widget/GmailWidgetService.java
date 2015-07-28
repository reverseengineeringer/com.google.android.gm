package com.android.mail.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import com.android.mail.providers.Folder;
import com.google.android.gm.LabelSynchronizationActivity;
import com.google.android.gm.Utils;
import com.google.android.gm.comm.longshadow.LongShadowUtils;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Gmail.Settings;
import com.google.common.collect.Sets;
import java.util.Set;

public class GmailWidgetService
  extends WidgetService
{
  public static void configureValidAccountWidget(Context paramContext, RemoteViews paramRemoteViews, int paramInt, com.android.mail.providers.Account paramAccount, Folder paramFolder, String paramString, Class<?> paramClass)
  {
    if (isFolderSynchronized(paramContext, paramAccount, paramFolder))
    {
      paramRemoteViews.setViewVisibility(2131755275, 0);
      paramRemoteViews.setViewVisibility(2131755277, 8);
      WidgetService.configureValidAccountWidget(paramContext, paramRemoteViews, paramInt, paramAccount, paramFolder, paramString, GmailWidgetService.class);
      return;
    }
    paramRemoteViews.setViewVisibility(2131755275, 8);
    paramRemoteViews.setViewVisibility(2131755277, 0);
    paramRemoteViews.setViewVisibility(2131755275, 8);
    paramRemoteViews.setViewVisibility(2131755277, 0);
    paramClass = new Intent(paramContext, LabelSynchronizationActivity.class);
    paramClass.putExtra("account", paramAccount);
    paramClass.putExtra("folder", paramFolder);
    paramClass.putExtra("update-widgetid-on-sync-change", paramInt);
    paramClass.putExtra("perform-actions-internally", true);
    paramClass.setData(Uri.parse(paramClass.toUri(1)));
    paramClass.setFlags(1476427776);
    paramRemoteViews.setOnClickPendingIntent(2131755277, PendingIntent.getActivity(paramContext, 0, paramClass, 134217728));
    configureValidWidgetIntents(paramContext, paramRemoteViews, paramInt, paramAccount, paramFolder, paramString, GmailWidgetService.class);
  }
  
  private static boolean isFolderSynchronized(Context paramContext, com.android.mail.providers.Account paramAccount, Folder paramFolder)
  {
    paramFolder = uri.getLastPathSegment();
    paramContext = LongShadowUtils.getContentProviderMailAccess(paramContext.getContentResolver()).getSettings(paramContext, name);
    paramAccount = Sets.newHashSet();
    paramAccount.addAll(paramContext.getLabelsIncluded());
    paramAccount.addAll(paramContext.getLabelsPartial());
    return paramAccount.contains(paramFolder);
  }
  
  protected void configureValidAccountWidget(Context paramContext, RemoteViews paramRemoteViews, int paramInt, com.android.mail.providers.Account paramAccount, Folder paramFolder, String paramString)
  {
    configureValidAccountWidget(paramContext, paramRemoteViews, paramInt, paramAccount, paramFolder, paramString, GmailWidgetService.class);
  }
  
  protected boolean isAccountValid(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    return Utils.isAccountValid(paramContext, paramAccount);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.widget.GmailWidgetService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */