.class public Lcom/android/mail/providers/UIProvider;
.super Ljava/lang/Object;
.source "UIProvider.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/providers/UIProvider$MessageColumns;,
        Lcom/android/mail/providers/UIProvider$CursorStatus;,
        Lcom/android/mail/providers/UIProvider$ConversationColumns;,
        Lcom/android/mail/providers/UIProvider$FolderColumns;,
        Lcom/android/mail/providers/UIProvider$AccountColumns;,
        Lcom/android/mail/providers/UIProvider$SyncStatus;
    }
.end annotation


# static fields
.field public static final ACCOUNTS_PROJECTION:[Ljava/lang/String;

.field public static final ACCOUNT_COOKIE_PROJECTION:[Ljava/lang/String;

.field public static final ATTACHMENT_PROJECTION:[Ljava/lang/String;

.field public static final CONVERSATION_PROJECTION:[Ljava/lang/String;

.field public static final FOLDERS_PROJECTION:[Ljava/lang/String;

.field public static final MESSAGE_PROJECTION:[Ljava/lang/String;

.field public static final UNDO_PROJECTION:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 127
    const/16 v0, 0x2b

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "name"

    aput-object v1, v0, v4

    const-string v1, "providerVersion"

    aput-object v1, v0, v5

    const-string v1, "accountUri"

    aput-object v1, v0, v6

    const-string v1, "capabilities"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "folderListUri"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "fullFolderListUri"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "searchUri"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "accountFromAddresses"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "saveDraftUri"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "sendMailUri"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "expungeMessageUri"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "undoUri"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->SETTINGS_INTENT_URI:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "syncStatus"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->HELP_INTENT_URI:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->SEND_FEEDBACK_INTENT_URI:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->REAUTHENTICATION_INTENT_URI:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "composeUri"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "mimeType"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "recentFolderListUri"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "color"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "defaultRecentFolderListUri"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "manualSyncUri"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "viewProxyUri"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "accountCookieUri"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "signature"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "auto_advance"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "message_text_size"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "snap_headers"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string v2, "reply_behavior"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string v2, "hide_checkboxes"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string v2, "confirm_delete"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string v2, "confirm_archive"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string v2, "confirm_send"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string v2, "default_inbox"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string v2, "default_inbox_name"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    const-string v2, "force_reply_from_default"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    const-string v2, "max_attachment_size"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    const-string v2, "swipe"

    aput-object v2, v0, v1

    const/16 v1, 0x28

    const-string v2, "priority_inbox_arrows_enabled"

    aput-object v2, v0, v1

    const/16 v1, 0x29

    const-string v2, "setup_intent_uri"

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    const-string v2, "conversation_view_mode"

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    .line 582
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "cookie"

    aput-object v1, v0, v3

    sput-object v0, Lcom/android/mail/providers/UIProvider;->ACCOUNT_COOKIE_PROJECTION:[Ljava/lang/String;

    .line 634
    const/16 v0, 0x13

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "folderUri"

    aput-object v1, v0, v4

    const-string v1, "name"

    aput-object v1, v0, v5

    sget-object v1, Lcom/android/mail/providers/UIProvider$FolderColumns;->HAS_CHILDREN:Ljava/lang/String;

    aput-object v1, v0, v6

    sget-object v1, Lcom/android/mail/providers/UIProvider$FolderColumns;->CAPABILITIES:Ljava/lang/String;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/android/mail/providers/UIProvider$FolderColumns;->SYNC_WINDOW:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "conversationListUri"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "childFoldersListUri"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "unreadCount"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "totalCount"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "refreshUri"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "syncStatus"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "lastSyncResult"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "type"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "iconResId"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "bgColor"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "fgColor"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "loadMoreUri"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "hierarchicalDesc"

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    .line 850
    const/16 v0, 0x19

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "conversationUri"

    aput-object v1, v0, v4

    const-string v1, "messageListUri"

    aput-object v1, v0, v5

    const-string v1, "subject"

    aput-object v1, v0, v6

    const-string v1, "snippet"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "conversationInfo"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "dateReceivedMs"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "hasAttachments"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/android/mail/providers/UIProvider$ConversationColumns;->NUM_MESSAGES:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/android/mail/providers/UIProvider$ConversationColumns;->NUM_DRAFTS:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/android/mail/providers/UIProvider$ConversationColumns;->SENDING_STATE:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/android/mail/providers/UIProvider$ConversationColumns;->PRIORITY:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/android/mail/providers/UIProvider$ConversationColumns;->READ:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/android/mail/providers/UIProvider$ConversationColumns;->STARRED:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "rawFolders"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "conversationFlags"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "personalLevel"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "spam"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "phishing"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "muted"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "color"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "accountUri"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "senderInfo"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "conversationBaseUri"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "remote"

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/mail/providers/UIProvider;->CONVERSATION_PROJECTION:[Ljava/lang/String;

    .line 1206
    const/16 v0, 0x25

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "serverMessageId"

    aput-object v1, v0, v4

    const-string v1, "messageUri"

    aput-object v1, v0, v5

    const-string v1, "conversationId"

    aput-object v1, v0, v6

    const-string v1, "subject"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "snippet"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "fromAddress"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "toAddresses"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "ccAddresses"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "bccAddresses"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "replyToAddress"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "dateReceivedMs"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "bodyHtml"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "bodyText"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "bodyEmbedsExternalResources"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "refMessageId"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "draftType"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "appendRefMessageContent"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "hasAttachments"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "attachmentListUri"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "messageFlags"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "joinedAttachmentInfos"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "saveMessageUri"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "sendMessageUri"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "alwaysShowImages"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/android/mail/providers/UIProvider$MessageColumns;->READ:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/android/mail/providers/UIProvider$MessageColumns;->STARRED:Ljava/lang/String;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "quotedTextStartPos"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "attachments"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "customFrom"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string v2, "messageAccountUri"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string v2, "eventIntentUri"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string v2, "spamWarningString"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string v2, "spamWarningLevel"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string v2, "spamWarningLinkType"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string v2, "viaDomain"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string v2, "isSending"

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/mail/providers/UIProvider;->MESSAGE_PROJECTION:[Ljava/lang/String;

    .line 1543
    const/16 v0, 0xa

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_display_name"

    aput-object v1, v0, v3

    const-string v1, "_size"

    aput-object v1, v0, v4

    const-string v1, "uri"

    aput-object v1, v0, v5

    const-string v1, "contentType"

    aput-object v1, v0, v6

    const-string v1, "state"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "destination"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "downloadedSize"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "contentUri"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "thumbnailUri"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "previewIntentUri"

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/mail/providers/UIProvider;->ATTACHMENT_PROJECTION:[Ljava/lang/String;

    .line 1729
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "messageListUri"

    aput-object v1, v0, v3

    sput-object v0, Lcom/android/mail/providers/UIProvider;->UNDO_PROJECTION:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1857
    return-void
.end method

.method public static incrementRecipientsTimesContacted(Landroid/content/Context;Ljava/lang/String;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "addressString"    # Ljava/lang/String;

    .prologue
    .line 1717
    new-instance v2, Lcom/android/common/contacts/DataUsageStatUpdater;

    invoke-direct {v2, p0}, Lcom/android/common/contacts/DataUsageStatUpdater;-><init>(Landroid/content/Context;)V

    .line 1718
    .local v2, "statsUpdater":Lcom/android/common/contacts/DataUsageStatUpdater;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1719
    .local v1, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1727
    :goto_0
    return-void

    .line 1722
    :cond_0
    invoke-static {p1}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;

    move-result-object v3

    .line 1723
    .local v3, "tokens":[Landroid/text/util/Rfc822Token;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v4, v3

    if-ge v0, v4, :cond_1

    .line 1724
    aget-object v4, v3, v0

    invoke-virtual {v4}, Landroid/text/util/Rfc822Token;->getAddress()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1723
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1726
    :cond_1
    invoke-virtual {v2, v1}, Lcom/android/common/contacts/DataUsageStatUpdater;->updateWithAddress(Ljava/util/Collection;)Z

    goto :goto_0
.end method
