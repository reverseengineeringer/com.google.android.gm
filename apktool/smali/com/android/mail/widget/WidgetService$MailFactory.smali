.class public Lcom/android/mail/widget/WidgetService$MailFactory;
.super Ljava/lang/Object;
.source "WidgetService.java"

# interfaces
.implements Landroid/content/Loader$OnLoadCompleteListener;
.implements Landroid/widget/RemoteViewsService$RemoteViewsFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/widget/WidgetService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "MailFactory"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/widget/WidgetService$MailFactory$FolderUpdateHandler;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/RemoteViewsService$RemoteViewsFactory;",
        "Landroid/content/Loader$OnLoadCompleteListener",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# instance fields
.field private final mAccount:Lcom/android/mail/providers/Account;

.field private final mAppWidgetId:I

.field private final mContext:Landroid/content/Context;

.field private mConversationCursor:Landroid/database/Cursor;

.field private mConversationCursorLoader:Landroid/content/CursorLoader;

.field private mElidedPaddingToken:Ljava/lang/String;

.field private mFolder:Lcom/android/mail/providers/Folder;

.field private mFolderCount:I

.field private mFolderInformationShown:Z

.field private mFolderLoader:Landroid/content/CursorLoader;

.field private mFolderUpdateHandler:Lcom/android/mail/widget/WidgetService$MailFactory$FolderUpdateHandler;

.field private mReadStyle:Landroid/text/style/TextAppearanceSpan;

.field private mSendersSplitToken:Ljava/lang/String;

.field private mService:Lcom/android/mail/widget/WidgetService;

.field private mShouldShowViewMore:Z

.field private mUnreadStyle:Landroid/text/style/TextAppearanceSpan;

.field private final mWidgetConversationViewBuilder:Lcom/android/mail/widget/WidgetConversationViewBuilder;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/content/Intent;Lcom/android/mail/widget/WidgetService;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;
    .param p3, "service"    # Lcom/android/mail/widget/WidgetService;

    .prologue
    const/4 v1, 0x0

    .line 228
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 221
    iput-boolean v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderInformationShown:Z

    .line 229
    iput-object p1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    .line 230
    const-string v0, "appWidgetId"

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAppWidgetId:I

    .line 232
    const-string v0, "account"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/providers/Account;->newinstance(Ljava/lang/String;)Lcom/android/mail/providers/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAccount:Lcom/android/mail/providers/Account;

    .line 233
    const-string v0, "folder"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/providers/Folder;->fromString(Ljava/lang/String;)Lcom/android/mail/providers/Folder;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    .line 234
    new-instance v0, Lcom/android/mail/widget/WidgetConversationViewBuilder;

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAccount:Lcom/android/mail/providers/Account;

    invoke-direct {v0, p1, v1}, Lcom/android/mail/widget/WidgetConversationViewBuilder;-><init>(Landroid/content/Context;Lcom/android/mail/providers/Account;)V

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mWidgetConversationViewBuilder:Lcom/android/mail/widget/WidgetConversationViewBuilder;

    .line 236
    iput-object p3, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mService:Lcom/android/mail/widget/WidgetService;

    .line 237
    return-void
.end method

.method static synthetic access$200(Lcom/android/mail/widget/WidgetService$MailFactory;)Landroid/content/CursorLoader;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/widget/WidgetService$MailFactory;

    .prologue
    .line 202
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderLoader:Landroid/content/CursorLoader;

    return-object v0
.end method

.method private copyStyles([Landroid/text/style/CharacterStyle;Ljava/lang/CharSequence;)Landroid/text/SpannableString;
    .locals 4
    .param p1, "spans"    # [Landroid/text/style/CharacterStyle;
    .param p2, "newText"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v3, 0x0

    .line 444
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 445
    .local v0, "s":Landroid/text/SpannableString;
    if-eqz p1, :cond_0

    array-length v1, p1

    if-lez v1, :cond_0

    .line 446
    aget-object v1, p1, v3

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    invoke-virtual {v0, v1, v3, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 448
    :cond_0
    return-object v0
.end method

.method private ellipsizeStyledSenders(Lcom/android/mail/providers/ConversationInfo;I[Landroid/text/SpannableString;)Landroid/text/SpannableStringBuilder;
    .locals 9

    .prologue
    const/4 v4, 0x0

    .line 419
    new-instance v5, Landroid/text/SpannableStringBuilder;

    invoke-direct {v5}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 420
    const/4 v2, 0x0

    .line 421
    array-length v6, p3

    move v3, v4

    :goto_0
    if-ge v3, v6, :cond_4

    aget-object v1, p3, v3

    .line 422
    if-nez v1, :cond_0

    .line 423
    # getter for: Lcom/android/mail/widget/WidgetService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/widget/WidgetService;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string v1, "null sender while iterating over styledSenders"

    new-array v7, v4, [Ljava/lang/Object;

    invoke-static {v0, v1, v7}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    move-object v1, v2

    .line 421
    :goto_1
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    move-object v2, v1

    goto :goto_0

    .line 426
    :cond_0
    invoke-virtual {v1}, Landroid/text/SpannableString;->length()I

    move-result v0

    const-class v7, Landroid/text/style/CharacterStyle;

    invoke-virtual {v1, v4, v0, v7}, Landroid/text/SpannableString;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/style/CharacterStyle;

    .line 427
    sget-object v7, Lcom/android/mail/browse/SendersView;->sElidedString:Ljava/lang/CharSequence;

    invoke-virtual {v1}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 429
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mElidedPaddingToken:Ljava/lang/String;

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v7, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mElidedPaddingToken:Ljava/lang/String;

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v0, v2}, Lcom/android/mail/widget/WidgetService$MailFactory;->copyStyles([Landroid/text/style/CharacterStyle;Ljava/lang/CharSequence;)Landroid/text/SpannableString;

    move-result-object v0

    .line 438
    :goto_2
    invoke-virtual {v5, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_1

    .line 430
    :cond_1
    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v7

    if-lez v7, :cond_3

    if-eqz v2, :cond_2

    sget-object v7, Lcom/android/mail/browse/SendersView;->sElidedString:Ljava/lang/CharSequence;

    invoke-virtual {v2}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v7, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 434
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mSendersSplitToken:Ljava/lang/String;

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v0, v2}, Lcom/android/mail/widget/WidgetService$MailFactory;->copyStyles([Landroid/text/style/CharacterStyle;Ljava/lang/CharSequence;)Landroid/text/SpannableString;

    move-result-object v0

    goto :goto_2

    :cond_3
    move-object v0, v1

    .line 436
    goto :goto_2

    .line 440
    :cond_4
    return-object v5
.end method

.method private static filterTag(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "subject"    # Ljava/lang/String;

    .prologue
    .line 554
    move-object v1, p0

    .line 555
    .local v1, "result":Ljava/lang/String;
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_0

    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x5b

    if-ne v3, v4, :cond_0

    .line 556
    const/16 v3, 0x5d

    invoke-virtual {p0, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 557
    .local v0, "end":I
    if-lez v0, :cond_0

    .line 558
    const/4 v3, 0x1

    invoke-virtual {p0, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 559
    .local v2, "tag":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x7

    invoke-static {v2, v4}, Lcom/android/mail/utils/Utils;->ellipsize(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    add-int/lit8 v4, v0, 0x1

    invoke-virtual {p0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 563
    .end local v0    # "end":I
    .end local v2    # "tag":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method private getConversationCount()I
    .locals 3

    .prologue
    .line 343
    # getter for: Lcom/android/mail/widget/WidgetService;->sWidgetLock:Ljava/lang/Object;
    invoke-static {}, Lcom/android/mail/widget/WidgetService;->access$000()Ljava/lang/Object;

    move-result-object v2

    monitor-enter v2

    .line 344
    :try_start_0
    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    .line 346
    .local v0, "cursorCount":I
    :goto_0
    const/16 v1, 0x19

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    monitor-exit v2

    return v1

    .line 344
    .end local v0    # "cursorCount":I
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 347
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private getReadStyle()Landroid/text/style/CharacterStyle;
    .locals 3

    .prologue
    .line 411
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mReadStyle:Landroid/text/style/TextAppearanceSpan;

    if-nez v0, :cond_0

    .line 412
    new-instance v0, Landroid/text/style/TextAppearanceSpan;

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    const v2, 0x7f0d004a

    invoke-direct {v0, v1, v2}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mReadStyle:Landroid/text/style/TextAppearanceSpan;

    .line 414
    :cond_0
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mReadStyle:Landroid/text/style/TextAppearanceSpan;

    invoke-static {v0}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v0

    return-object v0
.end method

.method private getUnreadStyle()Landroid/text/style/CharacterStyle;
    .locals 3

    .prologue
    .line 403
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mUnreadStyle:Landroid/text/style/TextAppearanceSpan;

    if-nez v0, :cond_0

    .line 404
    new-instance v0, Landroid/text/style/TextAppearanceSpan;

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    const v2, 0x7f0d004b

    invoke-direct {v0, v1, v2}, Landroid/text/style/TextAppearanceSpan;-><init>(Landroid/content/Context;I)V

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mUnreadStyle:Landroid/text/style/TextAppearanceSpan;

    .line 407
    :cond_0
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mUnreadStyle:Landroid/text/style/TextAppearanceSpan;

    invoke-static {v0}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object v0

    return-object v0
.end method

.method private getViewMoreConversationsView()Landroid/widget/RemoteViews;
    .locals 4

    .prologue
    .line 455
    new-instance v0, Landroid/widget/RemoteViews;

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f04007c

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 456
    .local v0, "view":Landroid/widget/RemoteViews;
    const v1, 0x7f10011a

    iget-object v2, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    const v3, 0x7f0c00da

    invoke-virtual {v2, v3}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 458
    const v1, 0x7f100119

    iget-object v2, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v3, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v2, v3}, Lcom/android/mail/utils/Utils;->createViewFolderIntent(Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setOnClickFillInIntent(ILandroid/content/Intent;)V

    .line 460
    return-object v0
.end method

.method private isDataValid(Landroid/database/Cursor;)Z
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 546
    if-eqz p1, :cond_0

    invoke-interface {p1}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-interface {p1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getCount()I
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 327
    # getter for: Lcom/android/mail/widget/WidgetService;->sWidgetLock:Ljava/lang/Object;
    invoke-static {}, Lcom/android/mail/widget/WidgetService;->access$000()Ljava/lang/Object;

    move-result-object v5

    monitor-enter v5

    .line 328
    :try_start_0
    invoke-direct {p0}, Lcom/android/mail/widget/WidgetService$MailFactory;->getConversationCount()I

    move-result v0

    .line 329
    .local v0, "count":I
    iget-object v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    invoke-interface {v4}, Landroid/database/Cursor;->getCount()I

    move-result v1

    .line 331
    .local v1, "cursorCount":I
    :goto_0
    if-lt v0, v1, :cond_0

    iget v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderCount:I

    if-ge v0, v4, :cond_2

    :cond_0
    move v4, v2

    :goto_1
    iput-boolean v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mShouldShowViewMore:Z

    .line 332
    iget-boolean v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mShouldShowViewMore:Z

    if-eqz v4, :cond_3

    :goto_2
    add-int/2addr v2, v0

    monitor-exit v5

    return v2

    .end local v1    # "cursorCount":I
    :cond_1
    move v1, v3

    .line 329
    goto :goto_0

    .restart local v1    # "cursorCount":I
    :cond_2
    move v4, v3

    .line 331
    goto :goto_1

    :cond_3
    move v2, v3

    .line 332
    goto :goto_2

    .line 333
    .end local v0    # "count":I
    .end local v1    # "cursorCount":I
    :catchall_0
    move-exception v2

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 478
    int-to-long v0, p1

    return-wide v0
.end method

.method public getLoadingView()Landroid/widget/RemoteViews;
    .locals 4

    .prologue
    .line 465
    new-instance v0, Landroid/widget/RemoteViews;

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const v2, 0x7f04007c

    invoke-direct {v0, v1, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 466
    .local v0, "view":Landroid/widget/RemoteViews;
    const v1, 0x7f10011a

    iget-object v2, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    const v3, 0x7f0c00db

    invoke-virtual {v2, v3}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 468
    return-object v0
.end method

.method public getViewAt(I)Landroid/widget/RemoteViews;
    .locals 12
    .param p1, "position"    # I

    .prologue
    .line 355
    # getter for: Lcom/android/mail/widget/WidgetService;->sWidgetLock:Ljava/lang/Object;
    invoke-static {}, Lcom/android/mail/widget/WidgetService;->access$000()Ljava/lang/Object;

    move-result-object v10

    monitor-enter v10

    .line 357
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mShouldShowViewMore:Z

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/android/mail/widget/WidgetService$MailFactory;->getConversationCount()I

    move-result v0

    if-lt p1, v0, :cond_1

    .line 359
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/widget/WidgetService$MailFactory;->getViewMoreConversationsView()Landroid/widget/RemoteViews;

    move-result-object v8

    monitor-exit v10

    .line 398
    :goto_0
    return-object v8

    .line 362
    :cond_1
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    if-nez v0, :cond_2

    .line 366
    # getter for: Lcom/android/mail/widget/WidgetService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/widget/WidgetService;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Failed to move to position %d in the cursor."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-static {v0, v1, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 367
    invoke-direct {p0}, Lcom/android/mail/widget/WidgetService$MailFactory;->getViewMoreConversationsView()Landroid/widget/RemoteViews;

    move-result-object v8

    monitor-exit v10

    goto :goto_0

    .line 399
    :catchall_0
    move-exception v0

    monitor-exit v10
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 370
    :cond_2
    :try_start_1
    new-instance v7, Lcom/android/mail/providers/Conversation;

    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    invoke-direct {v7, v0}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    .line 372
    .local v7, "conversation":Lcom/android/mail/providers/Conversation;
    new-instance v5, Landroid/text/SpannableStringBuilder;

    invoke-direct {v5}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 373
    .local v5, "senderBuilder":Landroid/text/SpannableStringBuilder;
    new-instance v9, Landroid/text/SpannableStringBuilder;

    invoke-direct {v9}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 375
    .local v9, "statusBuilder":Landroid/text/SpannableStringBuilder;
    iget-object v0, v7, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    if-eqz v0, :cond_3

    .line 376
    iget-object v6, v7, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    const/16 v11, 0x19

    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    iget-object v1, v7, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    const-string v2, ""

    const/16 v3, 0x19

    new-instance v4, Lcom/google/android/common/html/parser/HtmlParser;

    invoke-direct {v4}, Lcom/google/android/common/html/parser/HtmlParser;-><init>()V

    new-instance v5, Lcom/google/android/common/html/parser/HtmlTreeBuilder;

    .end local v5    # "senderBuilder":Landroid/text/SpannableStringBuilder;
    invoke-direct {v5}, Lcom/google/android/common/html/parser/HtmlTreeBuilder;-><init>()V

    invoke-static/range {v0 .. v5}, Lcom/android/mail/browse/SendersView;->format(Landroid/content/Context;Lcom/android/mail/providers/ConversationInfo;Ljava/lang/String;ILcom/google/android/common/html/parser/HtmlParser;Lcom/google/android/common/html/parser/HtmlTreeBuilder;)[Landroid/text/SpannableString;

    move-result-object v0

    invoke-direct {p0, v6, v11, v0}, Lcom/android/mail/widget/WidgetService$MailFactory;->ellipsizeStyledSenders(Lcom/android/mail/providers/ConversationInfo;I[Landroid/text/SpannableString;)Landroid/text/SpannableStringBuilder;

    move-result-object v5

    .line 386
    .restart local v5    # "senderBuilder":Landroid/text/SpannableStringBuilder;
    :goto_1
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    iget-wide v3, v7, Lcom/android/mail/providers/Conversation;->dateMs:J

    invoke-static {v0, v3, v4}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;J)Ljava/lang/CharSequence;

    move-result-object v2

    .line 390
    .local v2, "date":Ljava/lang/CharSequence;
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mWidgetConversationViewBuilder:Lcom/android/mail/widget/WidgetConversationViewBuilder;

    iget-object v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v1, v7, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-static {v1}, Lcom/android/mail/widget/WidgetService$MailFactory;->filterTag(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    move-object v1, v9

    move-object v3, v7

    invoke-virtual/range {v0 .. v6}, Lcom/android/mail/widget/WidgetConversationViewBuilder;->getStyledView(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;Landroid/text/SpannableStringBuilder;Ljava/lang/String;)Landroid/widget/RemoteViews;

    move-result-object v8

    .line 395
    .local v8, "remoteViews":Landroid/widget/RemoteViews;
    const v0, 0x7f10010e

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v3, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v7, v1, v3}, Lcom/android/mail/utils/Utils;->createViewConversationIntent(Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v8, v0, v1}, Landroid/widget/RemoteViews;->setOnClickFillInIntent(ILandroid/content/Intent;)V

    .line 398
    monitor-exit v10

    goto :goto_0

    .line 381
    .end local v2    # "date":Ljava/lang/CharSequence;
    .end local v8    # "remoteViews":Landroid/widget/RemoteViews;
    :cond_3
    iget-object v0, v7, Lcom/android/mail/providers/Conversation;->senders:Ljava/lang/String;

    invoke-virtual {v5, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 382
    iget-boolean v0, v7, Lcom/android/mail/providers/Conversation;->read:Z

    if-eqz v0, :cond_4

    invoke-direct {p0}, Lcom/android/mail/widget/WidgetService$MailFactory;->getReadStyle()Landroid/text/style/CharacterStyle;

    move-result-object v0

    :goto_2
    const/4 v1, 0x0

    invoke-virtual {v5}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    const/4 v4, 0x0

    invoke-virtual {v5, v0, v1, v3, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_1

    :cond_4
    invoke-direct {p0}, Lcom/android/mail/widget/WidgetService$MailFactory;->getUnreadStyle()Landroid/text/style/CharacterStyle;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_2
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 473
    const/4 v0, 0x2

    return v0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 483
    const/4 v0, 0x0

    return v0
.end method

.method public onCreate()V
    .locals 13

    .prologue
    .line 243
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    iget v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAppWidgetId:I

    iget-object v3, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v0, v1, v3, v4}, Lcom/android/mail/widget/WidgetService;->saveWidgetInformation(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 247
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mService:Lcom/android/mail/widget/WidgetService;

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    iget v3, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAppWidgetId:I

    iget-object v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v5, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0, v1, v3, v4, v5}, Lcom/android/mail/widget/WidgetService;->isWidgetConfigured(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 248
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    iget v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAppWidgetId:I

    iget-object v3, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v0, v1, v3, v4}, Lcom/android/mail/widget/BaseWidgetProvider;->updateWidget(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 251
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderInformationShown:Z

    .line 259
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v0, v0, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v10

    .line 260
    .local v10, "builder":Landroid/net/Uri$Builder;
    const/16 v0, 0x19

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v11

    .line 261
    .local v11, "maxConversations":Ljava/lang/String;
    const-string v0, "limit"

    invoke-virtual {v10, v0, v11}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "use_network"

    sget-object v3, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v1, "all_notifications"

    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 268
    .local v2, "widgetConversationQueryUri":Landroid/net/Uri;
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    .line 269
    .local v12, "res":Landroid/content/res/Resources;
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->CONVERSATION_PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursorLoader:Landroid/content/CursorLoader;

    .line 271
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursorLoader:Landroid/content/CursorLoader;

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p0}, Landroid/content/CursorLoader;->registerListener(ILandroid/content/Loader$OnLoadCompleteListener;)V

    .line 272
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursorLoader:Landroid/content/CursorLoader;

    const v1, 0x7f0a001f

    invoke-virtual {v12, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    int-to-long v3, v1

    invoke-virtual {v0, v3, v4}, Landroid/content/CursorLoader;->setUpdateThrottle(J)V

    .line 274
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursorLoader:Landroid/content/CursorLoader;

    invoke-virtual {v0}, Landroid/content/CursorLoader;->startLoading()V

    .line 275
    const v0, 0x7f0c0100

    invoke-virtual {v12, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mSendersSplitToken:Ljava/lang/String;

    .line 276
    const v0, 0x7f0c0103

    invoke-virtual {v12, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mElidedPaddingToken:Ljava/lang/String;

    .line 277
    new-instance v3, Landroid/content/CursorLoader;

    iget-object v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v5, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    sget-object v6, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-direct/range {v3 .. v9}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderLoader:Landroid/content/CursorLoader;

    .line 279
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderLoader:Landroid/content/CursorLoader;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p0}, Landroid/content/CursorLoader;->registerListener(ILandroid/content/Loader$OnLoadCompleteListener;)V

    .line 280
    new-instance v0, Lcom/android/mail/widget/WidgetService$MailFactory$FolderUpdateHandler;

    const v1, 0x7f0a0020

    invoke-virtual {v12, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    invoke-direct {v0, p0, v1}, Lcom/android/mail/widget/WidgetService$MailFactory$FolderUpdateHandler;-><init>(Lcom/android/mail/widget/WidgetService$MailFactory;I)V

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderUpdateHandler:Lcom/android/mail/widget/WidgetService$MailFactory$FolderUpdateHandler;

    .line 282
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderUpdateHandler:Lcom/android/mail/widget/WidgetService$MailFactory$FolderUpdateHandler;

    invoke-virtual {v0}, Lcom/android/mail/widget/WidgetService$MailFactory$FolderUpdateHandler;->scheduleTask()V

    .line 284
    return-void
.end method

.method public onDataSetChanged()V
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderUpdateHandler:Lcom/android/mail/widget/WidgetService$MailFactory$FolderUpdateHandler;

    invoke-virtual {v0}, Lcom/android/mail/widget/WidgetService$MailFactory$FolderUpdateHandler;->scheduleTask()V

    .line 318
    return-void
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 288
    # getter for: Lcom/android/mail/widget/WidgetService;->sWidgetLock:Ljava/lang/Object;
    invoke-static {}, Lcom/android/mail/widget/WidgetService;->access$000()Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 289
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursorLoader:Landroid/content/CursorLoader;

    if-eqz v0, :cond_0

    .line 290
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursorLoader:Landroid/content/CursorLoader;

    invoke-virtual {v0}, Landroid/content/CursorLoader;->reset()V

    .line 291
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursorLoader:Landroid/content/CursorLoader;

    invoke-virtual {v0, p0}, Landroid/content/CursorLoader;->unregisterListener(Landroid/content/Loader$OnLoadCompleteListener;)V

    .line 292
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursorLoader:Landroid/content/CursorLoader;

    .line 297
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    .line 298
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 300
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderLoader:Landroid/content/CursorLoader;

    if-eqz v0, :cond_1

    .line 301
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderLoader:Landroid/content/CursorLoader;

    invoke-virtual {v0}, Landroid/content/CursorLoader;->reset()V

    .line 302
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderLoader:Landroid/content/CursorLoader;

    invoke-virtual {v0, p0}, Landroid/content/CursorLoader;->unregisterListener(Landroid/content/Loader$OnLoadCompleteListener;)V

    .line 303
    iput-object v2, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderLoader:Landroid/content/CursorLoader;

    .line 305
    :cond_1
    return-void

    .line 298
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public onLoadComplete(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 12
    .param p2, "data"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    const v11, 0x7f100109

    const v10, 0x7f100107

    const/4 v9, 0x0

    .line 488
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/appwidget/AppWidgetManager;->getInstance(Landroid/content/Context;)Landroid/appwidget/AppWidgetManager;

    move-result-object v7

    .line 490
    .local v7, "appWidgetManager":Landroid/appwidget/AppWidgetManager;
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderLoader:Landroid/content/CursorLoader;

    if-ne p1, v0, :cond_4

    .line 491
    invoke-direct {p0, p2}, Lcom/android/mail/widget/WidgetService$MailFactory;->isDataValid(Landroid/database/Cursor;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 539
    :cond_0
    :goto_0
    return-void

    .line 495
    :cond_1
    const/16 v0, 0x8

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v8

    .line 496
    .local v8, "unreadCount":I
    const/4 v0, 0x2

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 497
    .local v6, "folderName":Ljava/lang/String;
    const/16 v0, 0x9

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderCount:I

    .line 499
    new-instance v2, Landroid/widget/RemoteViews;

    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f04007a

    invoke-direct {v2, v0, v1}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 502
    .local v2, "remoteViews":Landroid/widget/RemoteViews;
    iget-boolean v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderInformationShown:Z

    if-nez v0, :cond_2

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 508
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mService:Lcom/android/mail/widget/WidgetService;

    iget-object v1, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    iget v3, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAppWidgetId:I

    iget-object v4, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v5, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual/range {v0 .. v6}, Lcom/android/mail/widget/WidgetService;->configureValidAccountWidget(Landroid/content/Context;Landroid/widget/RemoteViews;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)V

    .line 510
    iget v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAppWidgetId:I

    invoke-virtual {v7, v0, v2}, Landroid/appwidget/AppWidgetManager;->updateAppWidget(ILandroid/widget/RemoteViews;)V

    .line 511
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mFolderInformationShown:Z

    .line 515
    :cond_2
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 516
    invoke-virtual {v2, v10, v9}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 517
    invoke-virtual {v2, v10, v6}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 521
    :goto_1
    invoke-virtual {v2, v11, v9}, Landroid/widget/RemoteViews;->setViewVisibility(II)V

    .line 522
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mContext:Landroid/content/Context;

    invoke-static {v0, v8}, Lcom/android/mail/utils/Utils;->getUnreadCountString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v11, v0}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 525
    iget v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAppWidgetId:I

    invoke-virtual {v7, v0, v2}, Landroid/appwidget/AppWidgetManager;->partiallyUpdateAppWidget(ILandroid/widget/RemoteViews;)V

    goto :goto_0

    .line 519
    :cond_3
    # getter for: Lcom/android/mail/widget/WidgetService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/widget/WidgetService;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Empty folder name"

    new-array v3, v9, [Ljava/lang/Object;

    invoke-static {v0, v1, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1

    .line 526
    .end local v2    # "remoteViews":Landroid/widget/RemoteViews;
    .end local v6    # "folderName":Ljava/lang/String;
    .end local v8    # "unreadCount":I
    :cond_4
    iget-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursorLoader:Landroid/content/CursorLoader;

    if-ne p1, v0, :cond_0

    .line 529
    # getter for: Lcom/android/mail/widget/WidgetService;->sWidgetLock:Ljava/lang/Object;
    invoke-static {}, Lcom/android/mail/widget/WidgetService;->access$000()Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 530
    :try_start_0
    invoke-direct {p0, p2}, Lcom/android/mail/widget/WidgetService$MailFactory;->isDataValid(Landroid/database/Cursor;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 531
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    .line 535
    :goto_2
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 536
    iget v0, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mAppWidgetId:I

    const v1, 0x7f10010b

    invoke-virtual {v7, v0, v1}, Landroid/appwidget/AppWidgetManager;->notifyAppWidgetViewDataChanged(II)V

    goto/16 :goto_0

    .line 533
    :cond_5
    :try_start_1
    iput-object p2, p0, Lcom/android/mail/widget/WidgetService$MailFactory;->mConversationCursor:Landroid/database/Cursor;

    goto :goto_2

    .line 535
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public bridge synthetic onLoadComplete(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 202
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/widget/WidgetService$MailFactory;->onLoadComplete(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method
