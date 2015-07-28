.class public final Lcom/google/android/gm/provider/MailProvider;
.super Landroid/content/ContentProvider;
.source "MailProvider.java"

# interfaces
.implements Landroid/accounts/OnAccountsUpdateListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    }
.end annotation


# static fields
.field private static volatile sThis:Lcom/google/android/gm/provider/MailProvider;

.field private static final sUrlMatcher:Landroid/content/UriMatcher;


# instance fields
.field private mBoundAccount:Ljava/lang/String;

.field private mBoundEngine:Lcom/google/android/gm/provider/MailEngine;

.field private mContentResolver:Landroid/content/ContentResolver;

.field private mHandler:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 70
    new-instance v0, Landroid/content/UriMatcher;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Landroid/content/UriMatcher;-><init>(I)V

    sput-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    .line 73
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/conversations"

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 76
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/conversations/labels"

    const/16 v3, 0x10

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 79
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/conversations/#/labels"

    const/4 v3, 0x3

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 82
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/conversations/#/labels/*"

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 85
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/conversations/#/attachments"

    const/16 v3, 0x15

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 88
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/conversations/#/messages"

    const/4 v3, 0x5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 91
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/messages"

    const/4 v3, 0x6

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 94
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/messages/#"

    const/4 v3, 0x7

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 97
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/messages/server/#"

    const/16 v3, 0x8

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 100
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/messages/#/labels"

    const/16 v3, 0x9

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 103
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/messages/#/labels/*"

    const/16 v3, 0xa

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 106
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/messages/labels"

    const/16 v3, 0x11

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 110
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/messages/#/attachments/*/*/*"

    const/16 v3, 0xb

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 114
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/messages/#/attachments/*/*/*/download"

    const/16 v3, 0xc

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 121
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/labels/lastTouched"

    const/16 v3, 0x16

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 124
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/labels/*/#"

    const/16 v3, 0x12

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 127
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/labels/*"

    const/16 v3, 0xd

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 130
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/label/#"

    const/16 v3, 0x13

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 133
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/settings"

    const/16 v3, 0xe

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 136
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/unread/*"

    const/16 v3, 0xf

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 139
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    const-string v1, "gmail-ls"

    const-string v2, "*/status"

    const/16 v3, 0x14

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 142
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 150
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailProvider;->mBoundAccount:Ljava/lang/String;

    .line 153
    return-void
.end method

.method static attachmentRequestForUri(Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;)Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    .locals 11
    .param p0, "mailEngine"    # Lcom/google/android/gm/provider/MailEngine;
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v7, 0x0

    const/4 v10, 0x0

    .line 733
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v9, 0x2

    invoke-interface {v8, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 734
    .local v2, "localMessageId":J
    invoke-virtual {p0, v2, v3, v10}, Lcom/google/android/gm/provider/MailEngine;->getLocalMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v4

    .line 735
    .local v4, "message":Lcom/google/android/gm/provider/MailSync$Message;
    if-nez v4, :cond_0

    .line 736
    const-string v8, "Gmail"

    const-string v9, "Message not found"

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v8, v9, v10}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 754
    :goto_0
    return-object v7

    .line 739
    :cond_0
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v9, 0x4

    invoke-interface {v8, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 740
    .local v5, "partId":Ljava/lang/String;
    invoke-virtual {v4, v5}, Lcom/google/android/gm/provider/MailSync$Message;->getAttachmentOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$Attachment;

    move-result-object v0

    .line 741
    .local v0, "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    if-nez v0, :cond_1

    .line 742
    const-string v8, "Gmail"

    const-string v9, "Attachment not found"

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v8, v9, v10}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 745
    :cond_1
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v9, 0x5

    invoke-interface {v8, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->valueOf(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    move-result-object v6

    .line 747
    .local v6, "rendition":Lcom/google/android/gm/provider/Gmail$AttachmentRendition;
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v9, 0x6

    invoke-interface {v8, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    .line 749
    .local v1, "download":Z
    new-instance v7, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;

    invoke-direct {v7}, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;-><init>()V

    .line 750
    .local v7, "request":Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    iput-object v4, v7, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    .line 751
    iput-object v0, v7, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 752
    iput-object v6, v7, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    .line 753
    iput-boolean v1, v7, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->saveToSd:Z

    goto :goto_0
.end method

.method static getMailProvider()Lcom/google/android/gm/provider/MailProvider;
    .locals 1

    .prologue
    .line 161
    sget-object v0, Lcom/google/android/gm/provider/MailProvider;->sThis:Lcom/google/android/gm/provider/MailProvider;

    return-object v0
.end method

.method private notifyDatasetChanged(Ljava/lang/String;)V
    .locals 3
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 787
    iget-object v0, p0, Lcom/google/android/gm/provider/MailProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->getBaseUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 788
    return-void
.end method

.method private sendOrSaveDraft(Lcom/google/android/gm/provider/MailEngine;JLandroid/content/ContentValues;)J
    .locals 7
    .param p1, "mailEngine"    # Lcom/google/android/gm/provider/MailEngine;
    .param p2, "localMessageId"    # J
    .param p4, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 495
    new-instance v6, Landroid/content/ContentValues;

    invoke-direct {v6, p4}, Landroid/content/ContentValues;-><init>(Landroid/content/ContentValues;)V

    .line 496
    .local v6, "valuesWithoutFakes":Landroid/content/ContentValues;
    const-string v0, "save"

    invoke-virtual {v6, v0}, Landroid/content/ContentValues;->getAsBoolean(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    .line 497
    .local v3, "save":Z
    const-string v0, "save"

    invoke-virtual {v6, v0}, Landroid/content/ContentValues;->remove(Ljava/lang/String;)V

    .line 498
    const-string v0, "refMessageId"

    invoke-virtual {v6, v0}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 500
    .local v4, "localRefMessageId":J
    const-string v0, "refMessageId"

    invoke-virtual {v6, v0}, Landroid/content/ContentValues;->remove(Ljava/lang/String;)V

    move-object v0, p1

    move-wide v1, p2

    .line 502
    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gm/provider/MailEngine;->sendOrSaveDraft(JZJLandroid/content/ContentValues;)J

    move-result-wide v0

    return-wide v0
.end method


# virtual methods
.method public bindAccount(Ljava/lang/String;)V
    .locals 1
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 264
    monitor-enter p0

    .line 265
    :try_start_0
    invoke-static {}, Lcom/google/android/gm/provider/MailEngine;->clearMailEngines()V

    .line 266
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailProvider;->mBoundAccount:Ljava/lang/String;

    .line 267
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailProvider;->mBoundEngine:Lcom/google/android/gm/provider/MailEngine;

    .line 268
    iput-object p1, p0, Lcom/google/android/gm/provider/MailProvider;->mBoundAccount:Ljava/lang/String;

    .line 269
    monitor-exit p0

    .line 270
    return-void

    .line 269
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public bulkInsert(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    .locals 7
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "values"    # [Landroid/content/ContentValues;

    .prologue
    const/4 v5, 0x0

    .line 508
    sget-object v6, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v6, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    .line 509
    .local v2, "match":I
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 510
    .local v0, "account":Ljava/lang/String;
    const-string v6, "suppressUINotifications"

    invoke-virtual {p1, v6}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 513
    .local v4, "suppressionParam":Ljava/lang/String;
    if-eqz v4, :cond_0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    if-eqz v6, :cond_0

    const/4 v3, 0x1

    .line 516
    .local v3, "suppressUiNotifications":Z
    :goto_0
    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v1

    .line 517
    .local v1, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    packed-switch v2, :pswitch_data_0

    .line 527
    new-instance v5, Ljava/lang/IllegalArgumentException;

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .end local v1    # "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    .end local v3    # "suppressUiNotifications":Z
    :cond_0
    move v3, v5

    .line 513
    goto :goto_0

    .line 519
    .restart local v1    # "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    .restart local v3    # "suppressUiNotifications":Z
    :pswitch_0
    invoke-virtual {v1, p2, v3}, Lcom/google/android/gm/provider/MailEngine;->setLabelOnConversationsBulk([Landroid/content/ContentValues;Z)V

    .line 524
    :goto_1
    return v5

    .line 523
    :pswitch_1
    invoke-virtual {v1, p2, v3}, Lcom/google/android/gm/provider/MailEngine;->setLabelOnLocalMessageBulk([Landroid/content/ContentValues;Z)V

    goto :goto_1

    .line 517
    nop

    :pswitch_data_0
    .packed-switch 0x10
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 29
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 599
    sget-object v9, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v9, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v23

    .line 600
    .local v23, "match":I
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v9

    const/4 v10, 0x0

    invoke-interface {v9, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/String;

    .line 601
    .local v16, "account":Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v2

    .line 604
    .local v2, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static/range {v16 .. v16}, Lcom/google/android/gm/provider/MailIndexerService;->onContentProviderAccess(Ljava/lang/String;)V

    .line 606
    packed-switch v23, :pswitch_data_0

    .line 677
    :pswitch_0
    new-instance v9, Ljava/lang/IllegalArgumentException;

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 608
    :pswitch_1
    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_0

    .line 609
    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string v10, "selection must be empty"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 612
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v9

    const/4 v10, 0x2

    invoke-interface {v9, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    invoke-static {v9}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v21

    .line 614
    .local v21, "localMessageId":J
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v7

    .line 615
    .local v7, "label":Ljava/lang/String;
    const-string v9, "Gmail"

    const-string v10, "MailProvider.delete(): removing label %s from local message %d"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v7, v11, v12

    const/4 v12, 0x1

    invoke-static/range {v21 .. v22}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v9, v10, v11}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 617
    invoke-static {v7}, Lcom/google/android/gm/provider/Gmail;->isLabelUserSettable(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 618
    new-instance v9, Ljava/lang/IllegalArgumentException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "label is not user-settable: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 620
    :cond_1
    const/4 v9, 0x0

    move-wide/from16 v0, v21

    invoke-virtual {v2, v0, v1, v7, v9}, Lcom/google/android/gm/provider/MailEngine;->setLabelOnLocalMessage(JLjava/lang/String;Z)V

    .line 623
    const/16 v18, 0x1

    .line 672
    .end local v7    # "label":Ljava/lang/String;
    .end local v21    # "localMessageId":J
    :goto_0
    return v18

    .line 626
    :pswitch_2
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v9

    const/4 v10, 0x2

    invoke-interface {v9, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    invoke-static {v9}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    .line 628
    .local v3, "conversationId":J
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v7

    .line 629
    .restart local v7    # "label":Ljava/lang/String;
    const-string v9, "maxMessageId"

    move-object/from16 v0, p2

    invoke-static {v0, v9}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_2

    move-object/from16 v0, p3

    array-length v9, v0

    const/4 v10, 0x1

    if-eq v9, v10, :cond_3

    .line 630
    :cond_2
    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string v10, "selection must be \'maxMessageId\', selection args must contain max message id"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 634
    :cond_3
    const/4 v9, 0x0

    aget-object v9, p3, v9

    invoke-static {v9}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v5

    .line 635
    .local v5, "maxMessageId":J
    const-string v9, "Gmail"

    const-string v10, "MailProvider.delete(): removing label %s from conversation %d"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v7, v11, v12

    const/4 v12, 0x1

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v9, v10, v11}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 637
    invoke-static {v7}, Lcom/google/android/gm/provider/Gmail;->isLabelUserSettable(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_4

    .line 638
    new-instance v9, Ljava/lang/IllegalArgumentException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "label is not user-settable: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 640
    :cond_4
    const/4 v8, 0x0

    invoke-virtual/range {v2 .. v8}, Lcom/google/android/gm/provider/MailEngine;->setLabelOnConversation(JJLjava/lang/String;Z)V

    .line 642
    const/16 v18, 0x1

    goto :goto_0

    .line 645
    .end local v3    # "conversationId":J
    .end local v5    # "maxMessageId":J
    .end local v7    # "label":Ljava/lang/String;
    :pswitch_3
    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_5

    .line 646
    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string v10, "selection must be empty"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 649
    :cond_5
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v25

    .line 650
    .local v25, "messageId":J
    const-string v9, "Gmail"

    const-string v10, "MailProvider.delete(): removing local message %d"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    invoke-static/range {v25 .. v26}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v9, v10, v11}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 651
    move-wide/from16 v0, v25

    invoke-virtual {v2, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->expungeLocalMessage(J)I

    move-result v18

    .line 652
    .local v18, "count":I
    goto/16 :goto_0

    .line 655
    .end local v18    # "count":I
    .end local v25    # "messageId":J
    :pswitch_4
    invoke-static/range {p2 .. p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_6

    .line 656
    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string v10, "selection must be empty"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 658
    :cond_6
    if-nez p3, :cond_7

    .line 659
    new-instance v9, Ljava/lang/IllegalArgumentException;

    const-string v10, "selection Args must be specified"

    invoke-direct {v9, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v9

    .line 661
    :cond_7
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v27

    .line 662
    .local v27, "messageIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    move-object/from16 v17, p3

    .local v17, "arr$":[Ljava/lang/String;
    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v20, v0

    .local v20, "len$":I
    const/16 v19, 0x0

    .local v19, "i$":I
    :goto_1
    move/from16 v0, v19

    move/from16 v1, v20

    if-ge v0, v1, :cond_8

    aget-object v24, v17, v19

    .line 663
    .local v24, "message":Ljava/lang/String;
    invoke-static/range {v24 .. v24}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v9

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    move-object/from16 v0, v27

    invoke-interface {v0, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 662
    add-int/lit8 v19, v19, 0x1

    goto :goto_1

    .line 665
    .end local v24    # "message":Ljava/lang/String;
    :cond_8
    move-object/from16 v0, v27

    invoke-virtual {v2, v0}, Lcom/google/android/gm/provider/MailEngine;->expungeLocalMessages(Ljava/util/List;)I

    move-result v18

    .line 666
    .restart local v18    # "count":I
    goto/16 :goto_0

    .line 669
    .end local v17    # "arr$":[Ljava/lang/String;
    .end local v18    # "count":I
    .end local v19    # "i$":I
    .end local v20    # "len$":I
    .end local v27    # "messageIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    :pswitch_5
    move-object/from16 v0, p1

    invoke-static {v2, v0}, Lcom/google/android/gm/provider/MailProvider;->attachmentRequestForUri(Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;)Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;

    move-result-object v28

    .line 670
    .local v28, "request":Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    if-nez v28, :cond_9

    const/16 v18, 0x0

    goto/16 :goto_0

    .line 671
    :cond_9
    invoke-virtual {v2}, Lcom/google/android/gm/provider/MailEngine;->getAttachmentManager()Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v8

    .line 672
    .local v8, "attachmentManager":Lcom/google/android/gm/provider/AttachmentManager;
    move-object/from16 v0, v28

    iget-object v9, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v9, v9, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    move-object/from16 v0, v28

    iget-object v11, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v11, v11, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-object/from16 v0, v28

    iget-object v13, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    iget-object v13, v13, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    move-object/from16 v0, v28

    iget-object v14, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    move-object/from16 v0, v28

    iget-boolean v15, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->saveToSd:Z

    invoke-virtual/range {v8 .. v15}, Lcom/google/android/gm/provider/AttachmentManager;->cancelDownloadRequest(JJLjava/lang/String;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)I

    move-result v18

    goto/16 :goto_0

    .line 606
    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_2
        :pswitch_0
        :pswitch_4
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_5
    .end packed-switch
.end method

.method getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;
    .locals 2
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 273
    iget-object v0, p0, Lcom/google/android/gm/provider/MailProvider;->mBoundAccount:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 274
    iget-object v0, p0, Lcom/google/android/gm/provider/MailProvider;->mBoundAccount:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 275
    iget-object v0, p0, Lcom/google/android/gm/provider/MailProvider;->mBoundEngine:Lcom/google/android/gm/provider/MailEngine;

    .line 284
    :goto_0
    return-object v0

    .line 277
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Must request bound account"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 281
    :cond_1
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 282
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "account is empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 284
    :cond_2
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailProvider;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngine(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v0

    goto :goto_0
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 7
    .param p1, "url"    # Landroid/net/Uri;

    .prologue
    const/4 v4, 0x0

    .line 478
    sget-object v5, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v5, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    .line 479
    .local v2, "match":I
    sparse-switch v2, :sswitch_data_0

    .line 491
    :cond_0
    :goto_0
    return-object v4

    .line 481
    :sswitch_0
    const-string v4, "com.google.android.gm/conversations"

    goto :goto_0

    .line 483
    :sswitch_1
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v5

    const/4 v6, 0x0

    invoke-interface {v5, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 484
    .local v0, "account":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v1

    .line 486
    .local v1, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static {v1, p1}, Lcom/google/android/gm/provider/MailProvider;->attachmentRequestForUri(Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;)Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;

    move-result-object v3

    .line 487
    .local v3, "request":Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    if-eqz v3, :cond_0

    .line 488
    iget-object v4, v3, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    iget-object v4, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    goto :goto_0

    .line 479
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0xb -> :sswitch_1
    .end sparse-switch
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 17
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 533
    const-string v8, "Gmail"

    const/4 v13, 0x3

    invoke-static {v8, v13}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 534
    const-string v8, "Gmail"

    const-string v13, "MailProvider.insert: %s(%s)"

    const/4 v14, 0x2

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    invoke-static/range {p1 .. p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x1

    aput-object p2, v14, v15

    invoke-static {v8, v13, v14}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 538
    :cond_0
    sget-object v8, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v8, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v12

    .line 539
    .local v12, "match":I
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v13, 0x0

    invoke-interface {v8, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 540
    .local v9, "account":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v2

    .line 543
    .local v2, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static {v9}, Lcom/google/android/gm/provider/MailIndexerService;->onContentProviderAccess(Ljava/lang/String;)V

    .line 545
    sparse-switch v12, :sswitch_data_0

    .line 593
    new-instance v8, Ljava/lang/IllegalArgumentException;

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v8, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 547
    :sswitch_0
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v13, 0x2

    invoke-interface {v8, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v10

    .line 548
    .local v10, "localMessageId":J
    invoke-virtual/range {p2 .. p2}, Landroid/content/ContentValues;->size()I

    move-result v8

    const/4 v13, 0x1

    if-eq v8, v13, :cond_1

    .line 549
    new-instance v8, Ljava/lang/IllegalArgumentException;

    invoke-virtual/range {p2 .. p2}, Landroid/content/ContentValues;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v8, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 551
    :cond_1
    const-string v8, "canonicalName"

    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_2

    .line 552
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v13, "values must have \'canonicalName\'"

    invoke-direct {v8, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 555
    :cond_2
    const-string v8, "canonicalName"

    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 556
    .local v7, "label":Ljava/lang/String;
    const-string v8, "Gmail"

    const-string v13, "MailProvider.insert(): adding label %s to local message %d"

    const/4 v14, 0x2

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object v7, v14, v15

    const/4 v15, 0x1

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v16

    aput-object v16, v14, v15

    invoke-static {v8, v13, v14}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 558
    invoke-static {v7}, Lcom/google/android/gm/provider/Gmail;->isLabelUserSettable(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 559
    new-instance v8, Ljava/lang/IllegalArgumentException;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "label is not user-settable: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v8, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 561
    :cond_3
    const/4 v8, 0x1

    invoke-virtual {v2, v10, v11, v7, v8}, Lcom/google/android/gm/provider/MailEngine;->setLabelOnLocalMessage(JLjava/lang/String;Z)V

    .line 562
    invoke-static {v9, v10, v11, v7}, Lcom/google/android/gm/provider/Gmail;->getMessageLabelUri(Ljava/lang/String;JLjava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    .line 590
    .end local v7    # "label":Ljava/lang/String;
    .end local v10    # "localMessageId":J
    :goto_0
    return-object v8

    .line 565
    :sswitch_1
    const-wide/16 v13, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v2, v13, v14, v1}, Lcom/google/android/gm/provider/MailProvider;->sendOrSaveDraft(Lcom/google/android/gm/provider/MailEngine;JLandroid/content/ContentValues;)J

    move-result-wide v10

    .line 566
    .restart local v10    # "localMessageId":J
    const-string v8, "Gmail"

    const-string v13, "MailProvider.insert(): added local message %d"

    const/4 v14, 0x1

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v16

    aput-object v16, v14, v15

    invoke-static {v8, v13, v14}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 567
    invoke-static {v9, v10, v11}, Lcom/google/android/gm/provider/Gmail;->getMessageByIdUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v8

    goto :goto_0

    .line 570
    .end local v10    # "localMessageId":J
    :sswitch_2
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v8

    const/4 v13, 0x2

    invoke-interface {v8, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    .line 571
    .local v3, "conversationId":J
    const-string v8, "canonicalName"

    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 572
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v13, "values must have \'canonicalName\'"

    invoke-direct {v8, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 575
    :cond_4
    const-string v8, "canonicalName"

    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 576
    .restart local v7    # "label":Ljava/lang/String;
    const-string v8, "maxMessageId"

    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_5

    .line 577
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v13, "values must have \'maxMessageId\'"

    invoke-direct {v8, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 580
    :cond_5
    const-string v8, "maxMessageId"

    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 581
    .local v5, "maxMessageId":J
    invoke-virtual/range {p2 .. p2}, Landroid/content/ContentValues;->size()I

    move-result v8

    const/4 v13, 0x2

    if-eq v8, v13, :cond_6

    .line 582
    new-instance v8, Ljava/lang/IllegalArgumentException;

    invoke-virtual/range {p2 .. p2}, Landroid/content/ContentValues;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v8, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 584
    :cond_6
    const-string v8, "Gmail"

    const-string v13, "MailProvider.insert(): adding label %s to conversation %d,maxMessageId %d"

    const/4 v14, 0x3

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object v7, v14, v15

    const/4 v15, 0x1

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x2

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v16

    aput-object v16, v14, v15

    invoke-static {v8, v13, v14}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 586
    invoke-static {v7}, Lcom/google/android/gm/provider/Gmail;->isLabelUserSettable(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_7

    .line 587
    new-instance v8, Ljava/lang/IllegalArgumentException;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "label is not user-settable: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v8, v13}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 589
    :cond_7
    const/4 v8, 0x1

    invoke-virtual/range {v2 .. v8}, Lcom/google/android/gm/provider/MailEngine;->setLabelOnConversation(JJLjava/lang/String;Z)V

    .line 590
    invoke-static {v9, v3, v4, v7}, Lcom/google/android/gm/provider/Gmail;->getConversationLabelUri(Ljava/lang/String;JLjava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    goto/16 :goto_0

    .line 545
    :sswitch_data_0
    .sparse-switch
        0x3 -> :sswitch_2
        0x6 -> :sswitch_1
        0x9 -> :sswitch_0
    .end sparse-switch
.end method

.method public onAccountsUpdated([Landroid/accounts/Account;)V
    .locals 21
    .param p1, "accounts"    # [Landroid/accounts/Account;

    .prologue
    .line 185
    monitor-enter p0

    .line 186
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/MailProvider;->mBoundAccount:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_0

    .line 189
    monitor-exit p0

    .line 255
    :goto_0
    return-void

    .line 192
    :cond_0
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v15

    .line 193
    .local v15, "validAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    move-object/from16 v4, p1

    .local v4, "arr$":[Landroid/accounts/Account;
    array-length v11, v4

    .local v11, "len$":I
    const/4 v9, 0x0

    .local v9, "i$":I
    :goto_1
    if-ge v9, v11, :cond_2

    aget-object v2, v4, v9

    .line 194
    .local v2, "account":Landroid/accounts/Account;
    iget-object v0, v2, Landroid/accounts/Account;->type:Ljava/lang/String;

    move-object/from16 v17, v0

    const-string v18, "com.google"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_1

    .line 193
    :goto_2
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 197
    :cond_1
    iget-object v0, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v15, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 254
    .end local v2    # "account":Landroid/accounts/Account;
    .end local v4    # "arr$":[Landroid/accounts/Account;
    .end local v9    # "i$":I
    .end local v11    # "len$":I
    .end local v15    # "validAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :catchall_0
    move-exception v17

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v17

    .line 200
    .restart local v4    # "arr$":[Landroid/accounts/Account;
    .restart local v9    # "i$":I
    .restart local v11    # "len$":I
    .restart local v15    # "validAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_2
    :try_start_1
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v16

    .line 201
    .local v16, "validDbs":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v15}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_3

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 202
    .local v3, "accountName":Ljava/lang/String;
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->getDbName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    invoke-interface/range {v16 .. v17}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 203
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->getInternalDbName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    invoke-interface/range {v16 .. v17}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 206
    .end local v3    # "accountName":Ljava/lang/String;
    :cond_3
    const/4 v14, 0x0

    .line 207
    .local v14, "restartGmail":Z
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gm/provider/MailProvider;->getContext()Landroid/content/Context;

    move-result-object v5

    .line 208
    .local v5, "context":Landroid/content/Context;
    invoke-virtual {v5}, Landroid/content/Context;->databaseList()[Ljava/lang/String;

    move-result-object v4

    .local v4, "arr$":[Ljava/lang/String;
    array-length v11, v4

    const/4 v9, 0x0

    .local v9, "i$":I
    :goto_4
    if-ge v9, v11, :cond_6

    aget-object v7, v4, v9

    .line 209
    .local v7, "db":Ljava/lang/String;
    const-string v17, "mailstore"

    move-object/from16 v0, v17

    invoke-virtual {v7, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_5

    const-string v17, ".db"

    move-object/from16 v0, v17

    invoke-virtual {v7, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_5

    const/4 v10, 0x1

    .line 211
    .local v10, "isMailStoreDb":Z
    :goto_5
    if-eqz v10, :cond_4

    move-object/from16 v0, v16

    invoke-interface {v0, v7}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_4

    .line 212
    const-string v17, "Gmail"

    const-string v18, "Deleting mail db %s because there is no account for it"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v7, v19, v20

    invoke-static/range {v17 .. v19}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 214
    invoke-virtual {v5, v7}, Landroid/content/Context;->deleteDatabase(Ljava/lang/String;)Z

    .line 217
    const-string v17, "mailstore"

    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->length()I

    move-result v17

    add-int/lit8 v17, v17, 0x1

    const-string v18, ".db"

    move-object/from16 v0, v18

    invoke-virtual {v7, v0}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v18

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v7, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 220
    .restart local v3    # "accountName":Ljava/lang/String;
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->getMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v12

    .line 221
    .local v12, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    if-eqz v12, :cond_4

    .line 222
    const/4 v14, 0x1

    .line 208
    .end local v3    # "accountName":Ljava/lang/String;
    .end local v12    # "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    :cond_4
    add-int/lit8 v9, v9, 0x1

    goto :goto_4

    .line 209
    .end local v10    # "isMailStoreDb":Z
    :cond_5
    const/4 v10, 0x0

    goto :goto_5

    .line 227
    .end local v7    # "db":Ljava/lang/String;
    :cond_6
    if-eqz v14, :cond_8

    .line 230
    invoke-static {v5}, Lcom/google/android/gm/Utils;->cancelAllNotifications(Landroid/content/Context;)V

    .line 232
    const-string v17, "Gmail"

    const-string v18, "Restarting because we deleted an account."

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    invoke-static/range {v17 .. v19}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 233
    const/16 v17, -0x1

    invoke-static/range {v17 .. v17}, Ljava/lang/System;->exit(I)V

    .line 254
    .end local v9    # "i$":I
    :cond_7
    monitor-exit p0

    goto/16 :goto_0

    .line 239
    .restart local v9    # "i$":I
    :cond_8
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gm/provider/MailProvider;->getContext()Landroid/content/Context;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lcom/google/android/gm/provider/MailEngine;->getMailEngines(Landroid/content/Context;)Ljava/util/List;

    move-result-object v13

    .line 240
    .local v13, "mailEngines":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/MailEngine;>;"
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v6

    .line 241
    .local v6, "currentEngineAccounts":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .local v9, "i$":Ljava/util/Iterator;
    :goto_6
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_9

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/google/android/gm/provider/MailEngine;

    .line 242
    .local v8, "engine":Lcom/google/android/gm/provider/MailEngine;
    invoke-virtual {v8}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-interface {v6, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_6

    .line 245
    .end local v8    # "engine":Lcom/google/android/gm/provider/MailEngine;
    :cond_9
    invoke-interface {v15, v6}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 249
    invoke-interface {v15}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_7
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_7

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 250
    .local v2, "account":Ljava/lang/String;
    const-string v17, "Gmail"

    const-string v18, "Creating mailengine for account %s"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v2, v19, v20

    invoke-static/range {v17 .. v19}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 251
    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_7
.end method

.method public onCreate()Z
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 166
    sput-object p0, Lcom/google/android/gm/provider/MailProvider;->sThis:Lcom/google/android/gm/provider/MailProvider;

    .line 167
    new-instance v0, Landroid/os/HandlerThread;

    const-string v2, "AccountManager Listener"

    const/16 v3, 0xa

    invoke-direct {v0, v2, v3}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;I)V

    .line 169
    .local v0, "handlerThread":Landroid/os/HandlerThread;
    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 170
    new-instance v2, Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v2, p0, Lcom/google/android/gm/provider/MailProvider;->mHandler:Landroid/os/Handler;

    .line 172
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/gm/provider/MailProvider;->mContentResolver:Landroid/content/ContentResolver;

    .line 173
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gm/provider/MailProvider;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, p0, v3, v4}, Landroid/accounts/AccountManager;->addOnAccountsUpdatedListener(Landroid/accounts/OnAccountsUpdateListener;Landroid/os/Handler;Z)V

    .line 175
    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.google.android.gm.intent.ACTION_PROVIDER_CREATED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 176
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 177
    return v4
.end method

.method public openFile(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    .locals 16
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "mode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    .line 759
    const-string v1, "Gmail"

    const/4 v2, 0x3

    invoke-static {v1, v2}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 760
    const-string v1, "Gmail"

    const-string v2, "MailProvider.openFile: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static/range {p1 .. p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 762
    :cond_0
    sget-object v1, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v1, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v13

    .line 763
    .local v13, "match":I
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v15

    .line 764
    .local v15, "segments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v1, 0x0

    invoke-interface {v15, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 765
    .local v10, "account":Ljava/lang/String;
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v12

    .line 766
    .local v12, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    packed-switch v13, :pswitch_data_0

    .line 781
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unsupported uri in openFile: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 768
    :pswitch_0
    move-object/from16 v0, p1

    invoke-static {v12, v0}, Lcom/google/android/gm/provider/MailProvider;->attachmentRequestForUri(Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;)Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;

    move-result-object v14

    .line 769
    .local v14, "request":Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    if-nez v14, :cond_1

    new-instance v1, Ljava/io/FileNotFoundException;

    invoke-direct {v1}, Ljava/io/FileNotFoundException;-><init>()V

    throw v1

    .line 771
    :cond_1
    :try_start_0
    invoke-virtual {v12}, Lcom/google/android/gm/provider/MailEngine;->getAttachmentManager()Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v1

    iget-object v2, v14, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v2, v2, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    iget-object v4, v14, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v4, v4, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    iget-object v6, v14, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    iget-object v7, v14, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    iget-boolean v8, v14, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->saveToSd:Z

    move-object/from16 v9, p2

    invoke-virtual/range {v1 .. v9}, Lcom/google/android/gm/provider/AttachmentManager;->openAttachment(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZLjava/lang/String;)Landroid/os/ParcelFileDescriptor;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 777
    :goto_0
    return-object v1

    .line 774
    :catch_0
    move-exception v11

    .line 777
    .local v11, "e":Ljava/io/FileNotFoundException;
    iget-object v1, v14, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    invoke-virtual {v12, v1}, Lcom/google/android/gm/provider/MailEngine;->openLocalAttachment(Lcom/google/android/gm/provider/Gmail$Attachment;)Landroid/os/ParcelFileDescriptor;

    move-result-object v1

    goto :goto_0

    .line 766
    :pswitch_data_0
    .packed-switch 0xb
        :pswitch_0
    .end packed-switch
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 50
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 290
    const-string v4, "Gmail"

    const/4 v5, 0x3

    invoke-static {v4, v5}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 291
    const-string v4, "Gmail"

    const-string v5, "MailProvider.query: %s(%s, %s)"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static/range {p1 .. p1}, Lcom/google/android/gm/provider/LogUtils;->contentUriToString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v6, v9

    const/4 v9, 0x1

    aput-object p3, v6, v9

    const/4 v9, 0x2

    invoke-static/range {p4 .. p4}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v6, v9

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 295
    :cond_0
    invoke-static/range {p5 .. p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 296
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "sortOrder must be empty"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 299
    :cond_1
    sget-object v4, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v41

    .line 300
    .local v41, "match":I
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Ljava/lang/String;

    .line 304
    .local v24, "account":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider;->mBoundAccount:Ljava/lang/String;

    if-eqz v4, :cond_2

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider;->mBoundAccount:Ljava/lang/String;

    move-object/from16 v0, v24

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 305
    move-object/from16 v0, p0

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/MailProvider;->bindAccount(Ljava/lang/String;)V

    .line 308
    :cond_2
    move-object/from16 v0, p0

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v3

    .line 311
    .local v3, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    const/16 v48, 0x1

    .line 314
    .local v48, "setNotificationUri":Z
    invoke-static/range {v24 .. v24}, Lcom/google/android/gm/provider/MailIndexerService;->onContentProviderAccess(Ljava/lang/String;)V

    .line 316
    packed-switch v41, :pswitch_data_0

    .line 461
    :pswitch_0
    const/16 v45, 0x0

    .line 464
    .local v45, "result":Landroid/database/Cursor;
    :goto_0
    if-eqz v45, :cond_3

    if-eqz v48, :cond_3

    .line 470
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static/range {v24 .. v24}, Lcom/google/android/gm/provider/Gmail;->getBaseUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    move-object/from16 v0, v45

    invoke-interface {v0, v4, v5}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 473
    .end local v45    # "result":Landroid/database/Cursor;
    :cond_3
    :goto_1
    return-object v45

    .line 318
    :pswitch_1
    if-eqz p3, :cond_4

    invoke-virtual/range {p3 .. p3}, Ljava/lang/String;->length()I

    move-result v4

    if-nez v4, :cond_5

    .line 319
    :cond_4
    const-string p3, "label:^i"

    .line 321
    :cond_5
    const-string v4, "limit"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v31

    .line 323
    .local v31, "conversationLimitStr":Ljava/lang/String;
    if-eqz v31, :cond_6

    invoke-static/range {v31 .. v31}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v7

    .line 332
    .local v7, "limit":Ljava/lang/Integer;
    :goto_2
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->isRunningICSOrLater()Z

    move-result v4

    if-nez v4, :cond_7

    invoke-static {}, Landroid/os/Binder;->getCallingPid()I

    move-result v4

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v5

    if-eq v4, v5, :cond_7

    const/4 v8, 0x1

    .local v8, "compatMode":Z
    :goto_3
    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move-object/from16 v6, p4

    .line 334
    invoke-virtual/range {v3 .. v8}, Lcom/google/android/gm/provider/MailEngine;->getConversationCursorForQuery([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Integer;Z)Landroid/database/Cursor;

    move-result-object v45

    .line 336
    .restart local v45    # "result":Landroid/database/Cursor;
    goto :goto_0

    .line 323
    .end local v7    # "limit":Ljava/lang/Integer;
    .end local v8    # "compatMode":Z
    .end local v45    # "result":Landroid/database/Cursor;
    :cond_6
    const/4 v7, 0x0

    goto :goto_2

    .line 332
    .restart local v7    # "limit":Ljava/lang/Integer;
    :cond_7
    const/4 v8, 0x0

    goto :goto_3

    .line 338
    .end local v7    # "limit":Ljava/lang/Integer;
    .end local v31    # "conversationLimitStr":Ljava/lang/String;
    :pswitch_2
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x2

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v11

    .line 339
    .local v11, "conversationId":J
    const-string v4, "1"

    const-string v5, "useCache"

    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    .line 340
    .local v13, "useCache":Z
    const-string v4, "1"

    const-string v5, "useMatrixCursor"

    move-object/from16 v0, p1

    invoke-virtual {v0, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    .local v14, "useMatrixCursor":Z
    move-object v9, v3

    move-object/from16 v10, p2

    .line 342
    invoke-virtual/range {v9 .. v14}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForConversationId([Ljava/lang/String;JZZ)Landroid/database/Cursor;

    move-result-object v45

    .line 344
    .restart local v45    # "result":Landroid/database/Cursor;
    goto :goto_0

    .line 347
    .end local v11    # "conversationId":J
    .end local v13    # "useCache":Z
    .end local v14    # "useMatrixCursor":Z
    .end local v45    # "result":Landroid/database/Cursor;
    :pswitch_3
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x2

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v11

    .line 348
    .restart local v11    # "conversationId":J
    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailEngine;->getAttachmentManager()Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v4

    move-object/from16 v0, p2

    invoke-virtual {v4, v11, v12, v0}, Lcom/google/android/gm/provider/AttachmentManager;->queryForConversation(J[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v45

    .line 350
    .restart local v45    # "result":Landroid/database/Cursor;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider;->mContentResolver:Landroid/content/ContentResolver;

    move-object/from16 v0, v24

    invoke-static {v0, v11, v12}, Lcom/google/android/gm/provider/Gmail;->getAttachmentsForConversationUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v5

    move-object/from16 v0, v45

    invoke-interface {v0, v4, v5}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 352
    const/16 v48, 0x0

    .line 353
    goto/16 :goto_0

    .line 355
    .end local v11    # "conversationId":J
    .end local v45    # "result":Landroid/database/Cursor;
    :pswitch_4
    invoke-static/range {p3 .. p3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v42

    .line 356
    .local v42, "messageId":J
    move-object/from16 v0, p2

    move-wide/from16 v1, v42

    invoke-virtual {v3, v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForMessageId([Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v45

    .line 357
    .restart local v45    # "result":Landroid/database/Cursor;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider;->mContentResolver:Landroid/content/ContentResolver;

    move-object/from16 v0, v45

    move-object/from16 v1, p1

    invoke-interface {v0, v4, v1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 358
    const/16 v48, 0x0

    .line 359
    goto/16 :goto_0

    .line 362
    .end local v42    # "messageId":J
    .end local v45    # "result":Landroid/database/Cursor;
    :pswitch_5
    invoke-static/range {p1 .. p1}, Landroid/content/ContentUris;->parseId(Landroid/net/Uri;)J

    move-result-wide v39

    .line 363
    .local v39, "localMessageId":J
    move-object/from16 v0, p2

    move-wide/from16 v1, v39

    invoke-virtual {v3, v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForLocalMessageId([Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v45

    .line 365
    .restart local v45    # "result":Landroid/database/Cursor;
    goto/16 :goto_0

    .line 368
    .end local v39    # "localMessageId":J
    .end local v45    # "result":Landroid/database/Cursor;
    :pswitch_6
    invoke-static/range {p1 .. p1}, Landroid/content/ContentUris;->parseId(Landroid/net/Uri;)J

    move-result-wide v46

    .line 369
    .local v46, "serverMessageId":J
    move-object/from16 v0, p2

    move-wide/from16 v1, v46

    invoke-virtual {v3, v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForMessageId([Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v45

    .line 371
    .restart local v45    # "result":Landroid/database/Cursor;
    goto/16 :goto_0

    .line 374
    .end local v45    # "result":Landroid/database/Cursor;
    .end local v46    # "serverMessageId":J
    :pswitch_7
    move-object/from16 v0, p1

    invoke-static {v3, v0}, Lcom/google/android/gm/provider/MailProvider;->attachmentRequestForUri(Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;)Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;

    move-result-object v44

    .line 375
    .local v44, "request":Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    if-nez v44, :cond_8

    const/16 v45, 0x0

    goto/16 :goto_1

    .line 376
    :cond_8
    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailEngine;->getAttachmentManager()Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v15

    move-object/from16 v0, v44

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v0, v4, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    move-wide/from16 v16, v0

    move-object/from16 v0, v44

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->message:Lcom/google/android/gm/provider/MailSync$Message;

    iget-wide v0, v4, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-wide/from16 v18, v0

    move-object/from16 v0, v44

    iget-object v0, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    move-object/from16 v20, v0

    move-object/from16 v0, v44

    iget-object v0, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    move-object/from16 v21, v0

    move-object/from16 v0, v44

    iget-boolean v0, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->saveToSd:Z

    move/from16 v22, v0

    move-object/from16 v23, p2

    invoke-virtual/range {v15 .. v23}, Lcom/google/android/gm/provider/AttachmentManager;->queryAndStartDownloadingAttachment(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v45

    .line 379
    .restart local v45    # "result":Landroid/database/Cursor;
    goto/16 :goto_0

    .line 383
    .end local v44    # "request":Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    .end local v45    # "result":Landroid/database/Cursor;
    :pswitch_8
    move-object/from16 v0, p1

    invoke-static {v3, v0}, Lcom/google/android/gm/provider/MailProvider;->attachmentRequestForUri(Lcom/google/android/gm/provider/MailEngine;Landroid/net/Uri;)Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;

    move-result-object v44

    .line 384
    .restart local v44    # "request":Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    if-nez v44, :cond_9

    const/16 v45, 0x0

    goto/16 :goto_1

    .line 387
    :cond_9
    if-eqz p2, :cond_a

    move-object/from16 v26, p2

    .line 391
    .local v26, "attachmentProjection":[Ljava/lang/String;
    :goto_4
    new-instance v32, Landroid/database/MatrixCursor;

    move-object/from16 v0, v32

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    .line 392
    .local v32, "cursor":Landroid/database/MatrixCursor;
    invoke-virtual/range {v32 .. v32}, Landroid/database/MatrixCursor;->newRow()Landroid/database/MatrixCursor$RowBuilder;

    move-result-object v28

    .line 395
    .local v28, "builder":Landroid/database/MatrixCursor$RowBuilder;
    move-object/from16 v25, v26

    .local v25, "arr$":[Ljava/lang/String;
    move-object/from16 v0, v25

    array-length v0, v0

    move/from16 v37, v0

    .local v37, "len$":I
    const/16 v34, 0x0

    .local v34, "i$":I
    :goto_5
    move/from16 v0, v34

    move/from16 v1, v37

    if-ge v0, v1, :cond_d

    aget-object v30, v25, v34

    .line 396
    .local v30, "column":Ljava/lang/String;
    const-string v4, "_display_name"

    move-object/from16 v0, v30

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b

    .line 397
    move-object/from16 v0, v44

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    iget-object v4, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    move-object/from16 v0, v28

    invoke-virtual {v0, v4}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    .line 395
    :goto_6
    add-int/lit8 v34, v34, 0x1

    goto :goto_5

    .line 387
    .end local v25    # "arr$":[Ljava/lang/String;
    .end local v26    # "attachmentProjection":[Ljava/lang/String;
    .end local v28    # "builder":Landroid/database/MatrixCursor$RowBuilder;
    .end local v30    # "column":Ljava/lang/String;
    .end local v32    # "cursor":Landroid/database/MatrixCursor;
    .end local v34    # "i$":I
    .end local v37    # "len$":I
    :cond_a
    const/4 v4, 0x2

    new-array v0, v4, [Ljava/lang/String;

    move-object/from16 v26, v0

    const/4 v4, 0x0

    const-string v5, "_display_name"

    aput-object v5, v26, v4

    const/4 v4, 0x1

    const-string v5, "_size"

    aput-object v5, v26, v4

    goto :goto_4

    .line 398
    .restart local v25    # "arr$":[Ljava/lang/String;
    .restart local v26    # "attachmentProjection":[Ljava/lang/String;
    .restart local v28    # "builder":Landroid/database/MatrixCursor$RowBuilder;
    .restart local v30    # "column":Ljava/lang/String;
    .restart local v32    # "cursor":Landroid/database/MatrixCursor;
    .restart local v34    # "i$":I
    .restart local v37    # "len$":I
    :cond_b
    const-string v4, "_size"

    move-object/from16 v0, v30

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_c

    move-object/from16 v0, v44

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    sget-object v5, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    if-ne v4, v5, :cond_c

    .line 403
    move-object/from16 v0, v44

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;->attachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    iget v4, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    move-object/from16 v0, v28

    invoke-virtual {v0, v4}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_6

    .line 405
    :cond_c
    const/4 v4, 0x0

    move-object/from16 v0, v28

    invoke-virtual {v0, v4}, Landroid/database/MatrixCursor$RowBuilder;->add(Ljava/lang/Object;)Landroid/database/MatrixCursor$RowBuilder;

    goto :goto_6

    .line 408
    .end local v30    # "column":Ljava/lang/String;
    :cond_d
    move-object/from16 v45, v32

    .line 409
    .restart local v45    # "result":Landroid/database/Cursor;
    goto/16 :goto_0

    .line 413
    .end local v25    # "arr$":[Ljava/lang/String;
    .end local v26    # "attachmentProjection":[Ljava/lang/String;
    .end local v28    # "builder":Landroid/database/MatrixCursor$RowBuilder;
    .end local v32    # "cursor":Landroid/database/MatrixCursor;
    .end local v34    # "i$":I
    .end local v37    # "len$":I
    .end local v44    # "request":Lcom/google/android/gm/provider/MailProvider$AttachmentRequest;
    .end local v45    # "result":Landroid/database/Cursor;
    :pswitch_9
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x2

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    const-wide/16 v9, 0x0

    cmp-long v4, v4, v9

    if-eqz v4, :cond_f

    const/16 v49, 0x1

    .line 414
    .local v49, "showHidden":Z
    :goto_7
    const-string v4, "before"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    .line 415
    .local v27, "beforeStr":Ljava/lang/String;
    const-string v4, "limit"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v38

    .line 416
    .local v38, "limitStr":Ljava/lang/String;
    const-string v4, "canonicalName"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/net/Uri;->getQueryParameters(Ljava/lang/String;)Ljava/util/List;

    move-result-object v33

    .line 419
    .local v33, "filterLabels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Lcom/google/android/gm/provider/MailEngine;->getLabelQueryBuilder([Ljava/lang/String;)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    move-object/from16 v0, v33

    invoke-virtual {v4, v0}, Lcom/google/android/gm/provider/LabelQueryBuilder;->filterCanonicalName(Ljava/util/List;)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    move/from16 v0, v49

    invoke-virtual {v4, v0}, Lcom/google/android/gm/provider/LabelQueryBuilder;->showHidden(Z)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v28

    .line 423
    .local v28, "builder":Lcom/google/android/gm/provider/LabelQueryBuilder;
    if-eqz v27, :cond_e

    .line 424
    invoke-static/range {v27 .. v27}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-static/range {v38 .. v38}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    move-object/from16 v0, v28

    invoke-virtual {v0, v4, v5, v6}, Lcom/google/android/gm/provider/LabelQueryBuilder;->setRecent(JI)Lcom/google/android/gm/provider/LabelQueryBuilder;

    .line 427
    :cond_e
    invoke-virtual/range {v28 .. v28}, Lcom/google/android/gm/provider/LabelQueryBuilder;->query()Landroid/database/Cursor;

    move-result-object v45

    .line 428
    .restart local v45    # "result":Landroid/database/Cursor;
    goto/16 :goto_0

    .line 413
    .end local v27    # "beforeStr":Ljava/lang/String;
    .end local v28    # "builder":Lcom/google/android/gm/provider/LabelQueryBuilder;
    .end local v33    # "filterLabels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v38    # "limitStr":Ljava/lang/String;
    .end local v45    # "result":Landroid/database/Cursor;
    .end local v49    # "showHidden":Z
    :cond_f
    const/16 v49, 0x0

    goto :goto_7

    .line 432
    :pswitch_a
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x2

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    .line 433
    .local v29, "canonicalName":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x3

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    const-wide/16 v9, 0x0

    cmp-long v4, v4, v9

    if-eqz v4, :cond_10

    const/16 v49, 0x1

    .line 434
    .restart local v49    # "showHidden":Z
    :goto_8
    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Lcom/google/android/gm/provider/MailEngine;->getLabelQueryBuilder([Ljava/lang/String;)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    invoke-static/range {v29 .. v29}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/google/android/gm/provider/LabelQueryBuilder;->filterCanonicalName(Ljava/util/List;)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    move/from16 v0, v49

    invoke-virtual {v4, v0}, Lcom/google/android/gm/provider/LabelQueryBuilder;->showHidden(Z)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gm/provider/LabelQueryBuilder;->query()Landroid/database/Cursor;

    move-result-object v45

    .line 438
    .restart local v45    # "result":Landroid/database/Cursor;
    goto/16 :goto_0

    .line 433
    .end local v45    # "result":Landroid/database/Cursor;
    .end local v49    # "showHidden":Z
    :cond_10
    const/16 v49, 0x0

    goto :goto_8

    .line 442
    .end local v29    # "canonicalName":Ljava/lang/String;
    :pswitch_b
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x2

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v35

    .line 443
    .local v35, "labelId":J
    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Lcom/google/android/gm/provider/MailEngine;->getLabelQueryBuilder([Ljava/lang/String;)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    move-wide/from16 v0, v35

    invoke-virtual {v4, v0, v1}, Lcom/google/android/gm/provider/LabelQueryBuilder;->labelId(J)Lcom/google/android/gm/provider/LabelQueryBuilder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/google/android/gm/provider/LabelQueryBuilder;->query()Landroid/database/Cursor;

    move-result-object v45

    .line 446
    .restart local v45    # "result":Landroid/database/Cursor;
    goto/16 :goto_0

    .line 450
    .end local v35    # "labelId":J
    .end local v45    # "result":Landroid/database/Cursor;
    :pswitch_c
    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Lcom/google/android/gm/provider/MailEngine;->getPublicSettingsCursor([Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v45

    .line 451
    .restart local v45    # "result":Landroid/database/Cursor;
    goto/16 :goto_0

    .line 454
    .end local v45    # "result":Landroid/database/Cursor;
    :pswitch_d
    move-object/from16 v0, p2

    invoke-virtual {v3, v0}, Lcom/google/android/gm/provider/MailEngine;->getStatusCursor([Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v45

    .line 455
    .restart local v45    # "result":Landroid/database/Cursor;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailProvider;->mContentResolver:Landroid/content/ContentResolver;

    invoke-static/range {v24 .. v24}, Lcom/google/android/gm/provider/Gmail;->getStatusUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    move-object/from16 v0, v45

    invoke-interface {v0, v4, v5}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 456
    const/16 v48, 0x0

    .line 457
    goto/16 :goto_0

    .line 316
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_8
        :pswitch_7
        :pswitch_9
        :pswitch_c
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_a
        :pswitch_b
        :pswitch_d
        :pswitch_3
    .end packed-switch
.end method

.method public shutdown()V
    .locals 0

    .prologue
    .line 725
    invoke-static {}, Lcom/google/android/gm/provider/MailEngine;->clearMailEngines()V

    .line 726
    return-void
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 9
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 684
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 685
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "selection must be empty"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 688
    :cond_0
    const/4 v6, 0x0

    .line 690
    .local v6, "numRowsModified":I
    sget-object v7, Lcom/google/android/gm/provider/MailProvider;->sUrlMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v7, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v5

    .line 691
    .local v5, "match":I
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v7

    const/4 v8, 0x0

    invoke-interface {v7, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 692
    .local v0, "account":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailProvider;->getOrMakeMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v4

    .line 695
    .local v4, "mailEngine":Lcom/google/android/gm/provider/MailEngine;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailIndexerService;->onContentProviderAccess(Ljava/lang/String;)V

    .line 697
    sparse-switch v5, :sswitch_data_0

    .line 717
    new-instance v7, Ljava/lang/IllegalArgumentException;

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 699
    :sswitch_0
    invoke-static {p1}, Landroid/content/ContentUris;->parseId(Landroid/net/Uri;)J

    move-result-wide v2

    .line 700
    .local v2, "localMessageId":J
    invoke-direct {p0, v4, v2, v3, p2}, Lcom/google/android/gm/provider/MailProvider;->sendOrSaveDraft(Lcom/google/android/gm/provider/MailEngine;JLandroid/content/ContentValues;)J

    .line 701
    const/4 v6, 0x1

    .line 720
    .end local v2    # "localMessageId":J
    :cond_1
    :goto_0
    return v6

    .line 705
    :sswitch_1
    invoke-virtual {v4, p2}, Lcom/google/android/gm/provider/MailEngine;->setPublicSettings(Landroid/content/ContentValues;)Z

    move-result v1

    .line 706
    .local v1, "changed":Z
    if-eqz v1, :cond_1

    .line 707
    const/4 v6, 0x1

    .line 708
    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/MailProvider;->notifyDatasetChanged(Ljava/lang/String;)V

    goto :goto_0

    .line 713
    .end local v1    # "changed":Z
    :sswitch_2
    invoke-virtual {v4, p2}, Lcom/google/android/gm/provider/MailEngine;->updateLabelsLastTouched(Landroid/content/ContentValues;)I

    move-result v6

    .line 714
    goto :goto_0

    .line 697
    nop

    :sswitch_data_0
    .sparse-switch
        0x7 -> :sswitch_0
        0xe -> :sswitch_1
        0x16 -> :sswitch_2
    .end sparse-switch
.end method
