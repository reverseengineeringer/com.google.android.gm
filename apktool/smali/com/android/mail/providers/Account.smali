.class public Lcom/android/mail/providers/Account;
.super Landroid/accounts/Account;
.source "Account.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field static final synthetic $assertionsDisabled:Z

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/mail/providers/Account;",
            ">;"
        }
    .end annotation
.end field

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field public accountFromAddresses:Ljava/lang/String;

.field public final accoutCookieQueryUri:Landroid/net/Uri;

.field public final capabilities:I

.field public final color:I

.field public final composeIntentUri:Landroid/net/Uri;

.field public final defaultRecentFolderListUri:Landroid/net/Uri;

.field public final expungeMessageUri:Landroid/net/Uri;

.field public final folderListUri:Landroid/net/Uri;

.field public fullFolderListUri:Landroid/net/Uri;

.field public final helpIntentUri:Landroid/net/Uri;

.field private transient mReplyFroms:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/ReplyFromAccount;",
            ">;"
        }
    .end annotation
.end field

.field public final manualSyncUri:Landroid/net/Uri;

.field public final mimeType:Ljava/lang/String;

.field public final providerVersion:I

.field public final reauthenticationIntentUri:Landroid/net/Uri;

.field public final recentFolderListUri:Landroid/net/Uri;

.field public final saveDraftUri:Landroid/net/Uri;

.field public final searchUri:Landroid/net/Uri;

.field public final sendFeedbackIntentUri:Landroid/net/Uri;

.field public final sendMessageUri:Landroid/net/Uri;

.field public final settings:Lcom/android/mail/providers/Settings;

.field public final settingsIntentUri:Landroid/net/Uri;

.field public final syncStatus:I

.field public final undoUri:Landroid/net/Uri;

.field public final uri:Landroid/net/Uri;

.field public final viewIntentProxyUri:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const-class v0, Lcom/android/mail/providers/Account;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/android/mail/providers/Account;->$assertionsDisabled:Z

    .line 181
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Account;->LOG_TAG:Ljava/lang/String;

    .line 634
    new-instance v0, Lcom/android/mail/providers/Account$1;

    invoke-direct {v0}, Lcom/android/mail/providers/Account$1;-><init>()V

    sput-object v0, Lcom/android/mail/providers/Account;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void

    .line 39
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 2
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 354
    const/4 v0, 0x1

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v1, "unknown"

    invoke-direct {p0, v0, v1}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 355
    const/16 v0, 0x8

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    .line 356
    const/4 v0, 0x4

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Account;->capabilities:I

    .line 357
    const/4 v0, 0x2

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Account;->providerVersion:I

    .line 358
    const/4 v0, 0x3

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    .line 359
    const/4 v0, 0x5

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    .line 360
    const/4 v0, 0x6

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    .line 362
    const/4 v0, 0x7

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    .line 363
    const/16 v0, 0x9

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    .line 365
    const/16 v0, 0xa

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    .line 367
    const/16 v0, 0xb

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    .line 369
    const/16 v0, 0xc

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    .line 370
    const/16 v0, 0xd

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    .line 372
    const/16 v0, 0xf

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    .line 374
    const/16 v0, 0x10

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    .line 376
    const/16 v0, 0x11

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    .line 378
    const/16 v0, 0xe

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    .line 379
    const/16 v0, 0x12

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    .line 381
    const/16 v0, 0x13

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    .line 382
    const/16 v0, 0x14

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    .line 384
    const/16 v0, 0x15

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Account;->color:I

    .line 385
    const/16 v0, 0x16

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    .line 387
    const/16 v0, 0x17

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->manualSyncUri:Landroid/net/Uri;

    .line 389
    const/16 v0, 0x18

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    .line 391
    const/16 v0, 0x19

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    .line 393
    new-instance v0, Lcom/android/mail/providers/Settings;

    invoke-direct {v0, p1}, Lcom/android/mail/providers/Settings;-><init>(Landroid/database/Cursor;)V

    iput-object v0, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    .line 394
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 6
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v3, 0x0

    .line 318
    invoke-direct {p0, p1}, Landroid/accounts/Account;-><init>(Landroid/os/Parcel;)V

    .line 319
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    iput v2, p0, Lcom/android/mail/providers/Account;->providerVersion:I

    .line 320
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    .line 321
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    iput v2, p0, Lcom/android/mail/providers/Account;->capabilities:I

    .line 322
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    .line 323
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    .line 324
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    .line 325
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    .line 326
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    .line 327
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    .line 328
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    .line 329
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    .line 330
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    .line 331
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    .line 332
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    .line 333
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    .line 334
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    iput v2, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    .line 335
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    .line 336
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    .line 337
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    .line 338
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    iput v2, p0, Lcom/android/mail/providers/Account;->color:I

    .line 339
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    .line 340
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->manualSyncUri:Landroid/net/Uri;

    .line 341
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    .line 342
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    .line 343
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 344
    .local v1, "serializedSettings":Ljava/lang/String;
    invoke-static {v1}, Lcom/android/mail/providers/Settings;->newInstance(Ljava/lang/String;)Lcom/android/mail/providers/Settings;

    move-result-object v0

    .line 345
    .local v0, "parcelSettings":Lcom/android/mail/providers/Settings;
    if-eqz v0, :cond_0

    .line 346
    iput-object v0, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    .line 351
    :goto_0
    return-void

    .line 348
    :cond_0
    sget-object v2, Lcom/android/mail/providers/Account;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/Throwable;

    invoke-direct {v3}, Ljava/lang/Throwable;-><init>()V

    const-string v4, "Unexpected null settings in Account(Parcel)"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2, v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 349
    sget-object v2, Lcom/android/mail/providers/Settings;->EMPTY_SETTINGS:Lcom/android/mail/providers/Settings;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    goto :goto_0
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "jsonAccount"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 267
    invoke-direct {p0, p1, p2}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 268
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 269
    .local v0, "json":Lorg/json/JSONObject;
    const-string v2, "providerVersion"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/android/mail/providers/Account;->providerVersion:I

    .line 270
    const-string v2, "accountUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    .line 271
    const-string v2, "capabilities"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/android/mail/providers/Account;->capabilities:I

    .line 272
    const-string v2, "folderListUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    .line 274
    const-string v2, "fullFolderListUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    .line 276
    const-string v2, "searchUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    .line 277
    const-string v2, "accountFromAddresses"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    .line 279
    const-string v2, "saveDraftUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    .line 280
    const-string v2, "sendMailUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    .line 281
    const-string v2, "expungeMessageUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    .line 283
    const-string v2, "undoUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    .line 284
    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->SETTINGS_INTENT_URI:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    .line 286
    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->HELP_INTENT_URI:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    .line 288
    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->SEND_FEEDBACK_INTENT_URI:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    .line 290
    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->REAUTHENTICATION_INTENT_URI:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    .line 292
    const-string v2, "syncStatus"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    .line 293
    const-string v2, "composeUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    .line 294
    const-string v2, "mimeType"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    .line 295
    const-string v2, "recentFolderListUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    .line 297
    const-string v2, "color"

    invoke-virtual {v0, v2, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, p0, Lcom/android/mail/providers/Account;->color:I

    .line 298
    const-string v2, "defaultRecentFolderListUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    .line 300
    const-string v2, "manualSyncUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->manualSyncUri:Landroid/net/Uri;

    .line 302
    const-string v2, "viewProxyUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    .line 304
    const-string v2, "accountCookieUri"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    .line 307
    const-string v2, "settings"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/providers/Settings;->newInstance(Lorg/json/JSONObject;)Lcom/android/mail/providers/Settings;

    move-result-object v1

    .line 308
    .local v1, "jsonSettings":Lcom/android/mail/providers/Settings;
    if-eqz v1, :cond_0

    .line 309
    iput-object v1, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    .line 315
    :goto_0
    return-void

    .line 311
    :cond_0
    sget-object v2, Lcom/android/mail/providers/Account;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/Throwable;

    invoke-direct {v3}, Ljava/lang/Throwable;-><init>()V

    const-string v4, "Unexpected null settings in Account(name, type, jsonAccount)"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v2, v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 313
    sget-object v2, Lcom/android/mail/providers/Settings;->EMPTY_SETTINGS:Lcom/android/mail/providers/Settings;

    iput-object v2, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    goto :goto_0
.end method

.method public static findPosition([Lcom/android/mail/providers/Account;Landroid/net/Uri;)I
    .locals 7
    .param p0, "haystack"    # [Lcom/android/mail/providers/Account;
    .param p1, "needle"    # Landroid/net/Uri;

    .prologue
    .line 653
    if-eqz p0, :cond_1

    array-length v2, p0

    if-lez v2, :cond_1

    if-eqz p1, :cond_1

    .line 656
    const/4 v0, 0x0

    .local v0, "i":I
    array-length v1, p0

    .local v1, "size":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 657
    aget-object v2, p0, v0

    iget-object v2, v2, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v2, p1}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 658
    sget-object v2, Lcom/android/mail/providers/Account;->LOG_TAG:Ljava/lang/String;

    const-string v3, "findPositionOfAccount: Found needle at position %d"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 663
    .end local v0    # "i":I
    .end local v1    # "size":I
    :goto_1
    return v0

    .line 656
    .restart local v0    # "i":I
    .restart local v1    # "size":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 663
    .end local v0    # "i":I
    .end local v1    # "size":I
    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method

.method public static getAllAccounts(Landroid/database/Cursor;)[Lcom/android/mail/providers/Account;
    .locals 5
    .param p0, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 403
    invoke-interface {p0}, Landroid/database/Cursor;->getCount()I

    move-result v3

    .line 404
    .local v3, "initialLength":I
    if-lez v3, :cond_0

    invoke-interface {p0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-nez v4, :cond_2

    .line 406
    :cond_0
    const/4 v4, 0x0

    new-array v0, v4, [Lcom/android/mail/providers/Account;

    .line 416
    :cond_1
    return-object v0

    .line 409
    :cond_2
    new-array v0, v3, [Lcom/android/mail/providers/Account;

    .line 410
    .local v0, "allAccounts":[Lcom/android/mail/providers/Account;
    const/4 v1, 0x0

    .line 412
    .local v1, "i":I
    :goto_0
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "i":I
    .local v2, "i":I
    new-instance v4, Lcom/android/mail/providers/Account;

    invoke-direct {v4, p0}, Lcom/android/mail/providers/Account;-><init>(Landroid/database/Cursor;)V

    aput-object v4, v0, v1

    .line 413
    invoke-interface {p0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-nez v4, :cond_3

    .line 415
    sget-boolean v4, Lcom/android/mail/providers/Account;->$assertionsDisabled:Z

    if-nez v4, :cond_1

    if-eq v2, v3, :cond_1

    new-instance v4, Ljava/lang/AssertionError;

    invoke-direct {v4}, Ljava/lang/AssertionError;-><init>()V

    throw v4

    :cond_3
    move v1, v2

    .end local v2    # "i":I
    .restart local v1    # "i":I
    goto :goto_0
.end method

.method public static newinstance(Ljava/lang/String;)Lcom/android/mail/providers/Account;
    .locals 9
    .param p0, "serializedAccount"    # Ljava/lang/String;

    .prologue
    .line 240
    const/4 v1, 0x0

    .line 242
    .local v1, "json":Lorg/json/JSONObject;
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 243
    .end local v1    # "json":Lorg/json/JSONObject;
    .local v2, "json":Lorg/json/JSONObject;
    :try_start_1
    const-string v5, "name"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 244
    .local v3, "name":Ljava/lang/String;
    const-string v5, "type"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 245
    .local v4, "type":Ljava/lang/String;
    new-instance v5, Lcom/android/mail/providers/Account;

    invoke-direct {v5, v3, v4, p0}, Lcom/android/mail/providers/Account;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v1, v2

    .line 249
    .end local v2    # "json":Lorg/json/JSONObject;
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "type":Ljava/lang/String;
    .restart local v1    # "json":Lorg/json/JSONObject;
    :goto_0
    return-object v5

    .line 246
    :catch_0
    move-exception v0

    .line 247
    .local v0, "e":Lorg/json/JSONException;
    :goto_1
    sget-object v5, Lcom/android/mail/providers/Account;->LOG_TAG:Ljava/lang/String;

    const-string v6, "Could not create an account from this input: \"%s\""

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p0, v7, v8

    invoke-static {v5, v0, v6, v7}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 249
    const/4 v5, 0x0

    goto :goto_0

    .line 246
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v1    # "json":Lorg/json/JSONObject;
    .restart local v2    # "json":Lorg/json/JSONObject;
    :catch_1
    move-exception v0

    move-object v1, v2

    .end local v2    # "json":Lorg/json/JSONObject;
    .restart local v1    # "json":Lorg/json/JSONObject;
    goto :goto_1
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 529
    if-ne p1, p0, :cond_1

    .line 538
    :cond_0
    :goto_0
    return v1

    .line 533
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 534
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 537
    check-cast v0, Lcom/android/mail/providers/Account;

    .line 538
    .local v0, "other":Lcom/android/mail/providers/Account;
    iget-object v3, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v4, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Landroid/accounts/Account;->type:Ljava/lang/String;

    iget-object v4, v0, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget v3, p0, Lcom/android/mail/providers/Account;->capabilities:I

    iget v4, v0, Lcom/android/mail/providers/Account;->capabilities:I

    if-ne v3, v4, :cond_4

    iget v3, p0, Lcom/android/mail/providers/Account;->providerVersion:I

    iget v4, v0, Lcom/android/mail/providers/Account;->providerVersion:I

    if-ne v3, v4, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget v3, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    iget v4, v0, Lcom/android/mail/providers/Account;->syncStatus:I

    if-ne v3, v4, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget v3, p0, Lcom/android/mail/providers/Account;->color:I

    iget v4, v0, Lcom/android/mail/providers/Account;->color:I

    if-ne v3, v4, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v4, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-static {v3, v4}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto/16 :goto_0
.end method

.method public getReplyFroms()Ljava/util/List;
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/ReplyFromAccount;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 586
    iget-object v0, p0, Lcom/android/mail/providers/Account;->mReplyFroms:Ljava/util/List;

    if-nez v0, :cond_2

    .line 587
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Account;->mReplyFroms:Ljava/util/List;

    .line 590
    const/high16 v0, 0x80000

    invoke-virtual {p0, v0}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 591
    iget-object v0, p0, Lcom/android/mail/providers/Account;->mReplyFroms:Ljava/util/List;

    .line 615
    :goto_0
    return-object v0

    .line 595
    :cond_0
    iget-object v13, p0, Lcom/android/mail/providers/Account;->mReplyFroms:Ljava/util/List;

    new-instance v0, Lcom/android/mail/providers/ReplyFromAccount;

    iget-object v2, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v3, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v4, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v5, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    move-object v1, p0

    move v7, v6

    invoke-direct/range {v0 .. v7}, Lcom/android/mail/providers/ReplyFromAccount;-><init>(Lcom/android/mail/providers/Account;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    invoke-interface {v13, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 598
    iget-object v0, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 600
    :try_start_0
    new-instance v9, Lorg/json/JSONArray;

    iget-object v0, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    invoke-direct {v9, v0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 602
    .local v9, "accounts":Lorg/json/JSONArray;
    const/4 v11, 0x0

    .local v11, "i":I
    invoke-virtual {v9}, Lorg/json/JSONArray;->length()I

    move-result v12

    .local v12, "len":I
    :goto_1
    if-ge v11, v12, :cond_2

    .line 603
    invoke-virtual {v9, v11}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/android/mail/providers/ReplyFromAccount;->deserialize(Lcom/android/mail/providers/Account;Lorg/json/JSONObject;)Lcom/android/mail/providers/ReplyFromAccount;

    move-result-object v8

    .line 605
    .local v8, "a":Lcom/android/mail/providers/ReplyFromAccount;
    if-eqz v8, :cond_1

    .line 606
    iget-object v0, p0, Lcom/android/mail/providers/Account;->mReplyFroms:Ljava/util/List;

    invoke-interface {v0, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 602
    :cond_1
    add-int/lit8 v11, v11, 0x1

    goto :goto_1

    .line 610
    .end local v8    # "a":Lcom/android/mail/providers/ReplyFromAccount;
    .end local v9    # "accounts":Lorg/json/JSONArray;
    .end local v11    # "i":I
    .end local v12    # "len":I
    :catch_0
    move-exception v10

    .line 611
    .local v10, "e":Lorg/json/JSONException;
    sget-object v0, Lcom/android/mail/providers/Account;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Unable to parse accountFromAddresses. name=%s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    aput-object v3, v2, v6

    invoke-static {v0, v10, v1, v2}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 615
    .end local v10    # "e":Lorg/json/JSONException;
    :cond_2
    iget-object v0, p0, Lcom/android/mail/providers/Account;->mReplyFroms:Ljava/util/List;

    goto :goto_0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 566
    invoke-super {p0}, Landroid/accounts/Account;->hashCode()I

    move-result v0

    const/16 v1, 0x19

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-object v3, p0, Landroid/accounts/Account;->type:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget v3, p0, Lcom/android/mail/providers/Account;->capabilities:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget v3, p0, Lcom/android/mail/providers/Account;->providerVersion:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x4

    iget-object v3, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/4 v2, 0x5

    iget-object v3, p0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/4 v2, 0x6

    iget-object v3, p0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/4 v2, 0x7

    iget-object v3, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0x8

    iget-object v3, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    aput-object v3, v1, v2

    const/16 v2, 0x9

    iget-object v3, p0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0xa

    iget-object v3, p0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0xb

    iget-object v3, p0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0xc

    iget-object v3, p0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0xd

    iget-object v3, p0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0xe

    iget-object v3, p0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0xf

    iget-object v3, p0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0x10

    iget-object v3, p0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0x11

    iget v3, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/16 v2, 0x12

    iget-object v3, p0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0x13

    iget-object v3, p0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    aput-object v3, v1, v2

    const/16 v2, 0x14

    iget-object v3, p0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0x15

    iget v3, p0, Lcom/android/mail/providers/Account;->color:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/16 v2, 0x16

    iget-object v3, p0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0x17

    iget-object v3, p0, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    const/16 v2, 0x18

    iget-object v3, p0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v1

    xor-int/2addr v0, v1

    return v0
.end method

.method public isAccountInitializationRequired()Z
    .locals 2

    .prologue
    .line 428
    iget v0, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    and-int/lit8 v0, v0, 0x20

    const/16 v1, 0x20

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAccountReady()Z
    .locals 1

    .prologue
    .line 437
    invoke-virtual {p0}, Lcom/android/mail/providers/Account;->isAccountInitializationRequired()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/android/mail/providers/Account;->isAccountSyncRequired()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAccountSyncRequired()Z
    .locals 2

    .prologue
    .line 424
    iget v0, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    and-int/lit8 v0, v0, 0x8

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public matches(Lcom/android/mail/providers/Account;)Z
    .locals 2
    .param p1, "other"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 581
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v1, p1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-static {v0, v1}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public ownsFromAddress(Ljava/lang/String;)Z
    .locals 3
    .param p1, "fromAddress"    # Ljava/lang/String;

    .prologue
    .line 624
    invoke-virtual {p0}, Lcom/android/mail/providers/Account;->getReplyFroms()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/ReplyFromAccount;

    .line 625
    .local v1, "replyFrom":Lcom/android/mail/providers/ReplyFromAccount;
    iget-object v2, v1, Lcom/android/mail/providers/ReplyFromAccount;->address:Ljava/lang/String;

    invoke-static {v2, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 626
    const/4 v2, 0x1

    .line 630
    .end local v1    # "replyFrom":Lcom/android/mail/providers/ReplyFromAccount;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public declared-synchronized serialize()Ljava/lang/String;
    .locals 7

    .prologue
    .line 187
    monitor-enter p0

    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 189
    .local v1, "json":Lorg/json/JSONObject;
    :try_start_1
    const-string v2, "name"

    iget-object v3, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 190
    const-string v2, "type"

    iget-object v3, p0, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 191
    const-string v2, "providerVersion"

    iget v3, p0, Lcom/android/mail/providers/Account;->providerVersion:I

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 192
    const-string v2, "accountUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 193
    const-string v2, "capabilities"

    iget v3, p0, Lcom/android/mail/providers/Account;->capabilities:I

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 194
    const-string v2, "folderListUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 195
    const-string v2, "fullFolderListUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 196
    const-string v2, "searchUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 197
    const-string v2, "accountFromAddresses"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 198
    const-string v2, "saveDraftUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 199
    const-string v2, "sendMailUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 200
    const-string v2, "expungeMessageUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 201
    const-string v2, "undoUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 202
    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->SETTINGS_INTENT_URI:Ljava/lang/String;

    iget-object v3, p0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 203
    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->HELP_INTENT_URI:Ljava/lang/String;

    iget-object v3, p0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 204
    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->SEND_FEEDBACK_INTENT_URI:Ljava/lang/String;

    iget-object v3, p0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 205
    sget-object v2, Lcom/android/mail/providers/UIProvider$AccountColumns;->REAUTHENTICATION_INTENT_URI:Ljava/lang/String;

    iget-object v3, p0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 207
    const-string v2, "syncStatus"

    iget v3, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 208
    const-string v2, "composeUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 209
    const-string v2, "mimeType"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 210
    const-string v2, "recentFolderListUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 211
    const-string v2, "color"

    iget v3, p0, Lcom/android/mail/providers/Account;->color:I

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 212
    const-string v2, "defaultRecentFolderListUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 214
    const-string v2, "manualSyncUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->manualSyncUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 216
    const-string v2, "viewProxyUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 218
    const-string v2, "accountCookieUri"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 219
    iget-object v2, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    if-eqz v2, :cond_0

    .line 220
    const-string v2, "settings"

    iget-object v3, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-virtual {v3}, Lcom/android/mail/providers/Settings;->toJSON()Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 225
    :cond_0
    :goto_0
    :try_start_2
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    monitor-exit p0

    return-object v2

    .line 222
    :catch_0
    move-exception v0

    .line 223
    .local v0, "e":Lorg/json/JSONException;
    :try_start_3
    sget-object v2, Lcom/android/mail/providers/Account;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Could not serialize account with name %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 187
    .end local v0    # "e":Lorg/json/JSONException;
    .end local v1    # "json":Lorg/json/JSONObject;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public supportsCapability(I)Z
    .locals 1
    .param p1, "capability"    # I

    .prologue
    .line 420
    iget v0, p0, Lcom/android/mail/providers/Account;->capabilities:I

    and-int/2addr v0, p1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 475
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 477
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string v1, "name="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 478
    iget-object v1, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 479
    const-string v1, ",type="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 480
    iget-object v1, p0, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 481
    const-string v1, ",accountFromAddressUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 482
    iget-object v1, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 483
    const-string v1, ",capabilities="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 484
    iget v1, p0, Lcom/android/mail/providers/Account;->capabilities:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 485
    const-string v1, ",providerVersion="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 486
    iget v1, p0, Lcom/android/mail/providers/Account;->providerVersion:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 487
    const-string v1, ",folderListUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 488
    iget-object v1, p0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 489
    const-string v1, ",fullFolderListUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 490
    iget-object v1, p0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 491
    const-string v1, ",searchUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 492
    iget-object v1, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 493
    const-string v1, ",saveDraftUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 494
    iget-object v1, p0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 495
    const-string v1, ",sendMessageUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 496
    iget-object v1, p0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 497
    const-string v1, ",expungeMessageUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 498
    iget-object v1, p0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 499
    const-string v1, ",undoUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 500
    iget-object v1, p0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 501
    const-string v1, ",settingsIntentUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 502
    iget-object v1, p0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 503
    const-string v1, ",helpIntentUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 504
    iget-object v1, p0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 505
    const-string v1, ",sendFeedbackIntentUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 506
    iget-object v1, p0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 507
    const-string v1, ",reauthenticationIntentUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 508
    iget-object v1, p0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 509
    const-string v1, ",syncStatus="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 510
    iget v1, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 511
    const-string v1, ",composeIntentUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 512
    iget-object v1, p0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 513
    const-string v1, ",mimeType="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 514
    iget-object v1, p0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 515
    const-string v1, ",recentFoldersUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 516
    iget-object v1, p0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 517
    const-string v1, ",color="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 518
    iget v1, p0, Lcom/android/mail/providers/Account;->color:I

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 519
    const-string v1, ",defaultRecentFoldersUri="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 520
    iget-object v1, p0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 521
    const-string v1, ",settings="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 522
    iget-object v1, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-virtual {v1}, Lcom/android/mail/providers/Settings;->serialize()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 524
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 3
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v2, 0x0

    .line 442
    invoke-super {p0, p1, p2}, Landroid/accounts/Account;->writeToParcel(Landroid/os/Parcel;I)V

    .line 443
    iget v0, p0, Lcom/android/mail/providers/Account;->providerVersion:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 444
    iget-object v0, p0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 445
    iget v0, p0, Lcom/android/mail/providers/Account;->capabilities:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 446
    iget-object v0, p0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 447
    iget-object v0, p0, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 448
    iget-object v0, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 449
    iget-object v0, p0, Lcom/android/mail/providers/Account;->accountFromAddresses:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 450
    iget-object v0, p0, Lcom/android/mail/providers/Account;->saveDraftUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 451
    iget-object v0, p0, Lcom/android/mail/providers/Account;->sendMessageUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 452
    iget-object v0, p0, Lcom/android/mail/providers/Account;->expungeMessageUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 453
    iget-object v0, p0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 454
    iget-object v0, p0, Lcom/android/mail/providers/Account;->settingsIntentUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 455
    iget-object v0, p0, Lcom/android/mail/providers/Account;->helpIntentUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 456
    iget-object v0, p0, Lcom/android/mail/providers/Account;->sendFeedbackIntentUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 457
    iget-object v0, p0, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 458
    iget v0, p0, Lcom/android/mail/providers/Account;->syncStatus:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 459
    iget-object v0, p0, Lcom/android/mail/providers/Account;->composeIntentUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 460
    iget-object v0, p0, Lcom/android/mail/providers/Account;->mimeType:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 461
    iget-object v0, p0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 462
    iget v0, p0, Lcom/android/mail/providers/Account;->color:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 463
    iget-object v0, p0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 464
    iget-object v0, p0, Lcom/android/mail/providers/Account;->manualSyncUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 465
    iget-object v0, p0, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 466
    iget-object v0, p0, Lcom/android/mail/providers/Account;->accoutCookieQueryUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 467
    iget-object v0, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    if-nez v0, :cond_0

    .line 468
    sget-object v0, Lcom/android/mail/providers/Account;->LOG_TAG:Ljava/lang/String;

    const-string v1, "unexpected null settings object in writeToParcel"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 470
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-virtual {v0}, Lcom/android/mail/providers/Settings;->serialize()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 471
    return-void

    .line 470
    :cond_1
    const-string v0, ""

    goto :goto_0
.end method
