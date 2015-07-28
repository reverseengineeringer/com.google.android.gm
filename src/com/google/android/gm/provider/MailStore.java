package com.google.android.gm.provider;

import android.database.Cursor;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface MailStore
{
  public abstract void addOrUpdateMessage(MailSync.Message paramMessage, long paramLong);
  
  public abstract void addSendWithoutSyncConversationInfoToCheck(long paramLong1, long paramLong2);
  
  public abstract void addSyncedConversationInfoToCheck(long paramLong1, long paramLong2);
  
  public abstract void commit();
  
  public abstract void delayConversationSync(long paramLong);
  
  public abstract void deleteCorruptedMessage(long paramLong1, long paramLong2);
  
  public abstract void deleteLabel(MailCore.Label paramLabel);
  
  public abstract void expungeMessages(long paramLong, List<Long> paramList, MailSync.SyncRationale paramSyncRationale);
  
  public abstract String getAccount();
  
  public abstract ArrayList<MailSync.ConversationInfo> getConversationInfosToFetch(MailEngine.SyncInfo paramSyncInfo);
  
  public abstract ArrayList<Long> getDirtyConversations();
  
  public abstract InputStream getInputStreamForUploadedAttachment(long paramLong, Gmail.Attachment paramAttachment)
    throws FileNotFoundException;
  
  public abstract String getLabelCanonicalNameOrNull(MailCore.Label paramLabel);
  
  public abstract MailCore.Label getLabelOrNull(long paramLong);
  
  public abstract Cursor getMessageCursorForConversationId(String[] paramArrayOfString, long paramLong);
  
  public abstract ArrayList<Long> getMessageIdsToFetch();
  
  public abstract MailCore.Label getOrAddLabel(long paramLong);
  
  public abstract MailCore.Label getOrAddLabel(String paramString);
  
  public abstract void handleConversation(MailSync.Conversation paramConversation);
  
  public abstract void markConversationDirty(long paramLong);
  
  public abstract void notifyConversationChanged(long paramLong, MailSync.SyncRationale paramSyncRationale);
  
  public abstract void notifyConversationLoaded(long paramLong, MailSync.SyncRationale paramSyncRationale, MailEngine.SyncInfo paramSyncInfo);
  
  public abstract void notifyLabelChanges(Set<Long> paramSet);
  
  public abstract void notifyMessageDoesNotExist(long paramLong);
  
  public abstract void notifyMessageNotUpdated(long paramLong, String paramString);
  
  public abstract void prepare();
  
  public abstract void provideOperations(OperationSink paramOperationSink, MailEngine.SyncInfo paramSyncInfo, long paramLong);
  
  public abstract void removeCustomFromPreference(String paramString);
  
  public abstract void removeOperationByMessageId(long paramLong);
  
  public abstract void removeOperations(long paramLong);
  
  public abstract void renameLabel(MailCore.Label paramLabel, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void setCustomFromPreference(Map<String, CustomFromPreference> paramMap, boolean paramBoolean);
  
  public abstract void setCustomLabelColorPreference(Map<String, CustomLabelColorPreference> paramMap);
  
  public abstract void setInfoOverloadArrowsOffPreference(String paramString);
  
  public abstract void setInfoOverloadEnabledPreference(String paramString);
  
  public abstract void setLabelCounts(MailCore.Label paramLabel, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void setLabelOnMessages(long paramLong, List<Long> paramList, MailCore.Label paramLabel, boolean paramBoolean, MailSync.SyncRationale paramSyncRationale);
  
  public abstract void setLabels(Map<Long, LabelInfo> paramMap);
  
  public abstract void setServerPreferences(Map<String, String> paramMap);
  
  public abstract void setSettings(Map<String, String> paramMap, boolean paramBoolean);
  
  public abstract void updateNotificationLabels();
  
  public abstract void updateSentOrSavedMessage(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void wipeAndResync(String paramString);
  
  public abstract boolean yieldForContention();
  
  public static class CustomFromPreference
  {
    public String address;
    public String isDefault;
    public String name;
    public String replyTo;
    
    public CustomFromPreference(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      name = paramString1;
      address = paramString2;
      replyTo = paramString4;
      isDefault = paramString3;
    }
  }
  
  public static class CustomLabelColorPreference
  {
    public String backgroundColor;
    public String textColor;
    
    public CustomLabelColorPreference(String paramString1, String paramString2)
    {
      textColor = paramString1;
      backgroundColor = paramString2;
    }
  }
  
  public static class LabelInfo
  {
    public String canonicalName;
    public int color;
    public String name;
    public int numConversations;
    public int numUnreadConversations;
    public String visibility;
    
    public LabelInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
    {
      canonicalName = paramString1;
      name = paramString2;
      numConversations = paramInt1;
      numUnreadConversations = paramInt2;
      color = paramInt3;
      visibility = paramString3;
    }
  }
  
  public static abstract interface OperationSink
  {
    public abstract void conversationLabelAddedOrRemoved(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean);
    
    public abstract void messageExpunged(long paramLong1, long paramLong2);
    
    public abstract void messageLabelAdded(long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void messageLabelRemoved(long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void messageSavedOrSent(long paramLong1, MailSync.Message paramMessage, long paramLong2, long paramLong3, boolean paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */