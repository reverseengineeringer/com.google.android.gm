.class Lcom/android/mail/compose/AttachmentsView;
.super Landroid/widget/LinearLayout;
.source "AttachmentsView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;,
        Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAttachmentLayout:Landroid/widget/LinearLayout;

.field private mAttachments:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;"
        }
    .end annotation
.end field

.field private mChangeListener:Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;

.field private mTileGrid:Lcom/android/mail/ui/AttachmentTileGrid;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/compose/AttachmentsView;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 59
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/compose/AttachmentsView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 60
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 63
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 64
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachments:Ljava/util/ArrayList;

    .line 65
    return-void
.end method

.method private getOptionalColumn(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 7
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "columnName"    # Ljava/lang/String;

    .prologue
    .line 354
    const/4 v6, 0x0

    .line 356
    .local v6, "result":Landroid/database/Cursor;
    const/4 v0, 0x1

    :try_start_0
    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object p3, v2, v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p1

    move-object v1, p2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 360
    :goto_0
    return-object v6

    .line 357
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public addAttachment(Lcom/android/mail/providers/Account;Landroid/net/Uri;)J
    .locals 2
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "contentUri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;
        }
    .end annotation

    .prologue
    .line 297
    invoke-virtual {p0, p2}, Lcom/android/mail/compose/AttachmentsView;->generateLocalAttachment(Landroid/net/Uri;)Lcom/android/mail/providers/Attachment;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lcom/android/mail/compose/AttachmentsView;->addAttachment(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Attachment;)J

    move-result-wide v0

    return-wide v0
.end method

.method public addAttachment(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Attachment;)J
    .locals 5
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "attachment"    # Lcom/android/mail/providers/Attachment;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;
        }
    .end annotation

    .prologue
    .line 311
    iget-object v1, p1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-virtual {v1}, Lcom/android/mail/providers/Settings;->getMaxAttachmentSize()I

    move-result v0

    .line 314
    .local v0, "maxSize":I
    iget v1, p2, Lcom/android/mail/providers/Attachment;->size:I

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    iget v1, p2, Lcom/android/mail/providers/Attachment;->size:I

    if-le v1, v0, :cond_1

    .line 315
    :cond_0
    new-instance v1, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;

    const-string v2, "Attachment too large to attach"

    const v3, 0x7f0c002d

    invoke-direct {v1, v2, v3}, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;-><init>(Ljava/lang/String;I)V

    throw v1

    .line 317
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/compose/AttachmentsView;->getTotalAttachmentsSize()J

    move-result-wide v1

    iget v3, p2, Lcom/android/mail/providers/Attachment;->size:I

    int-to-long v3, v3

    add-long/2addr v1, v3

    int-to-long v3, v0

    cmp-long v1, v1, v3

    if-lez v1, :cond_2

    .line 319
    new-instance v1, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;

    const-string v2, "Attachment too large to attach"

    const v3, 0x7f0c002f

    invoke-direct {v1, v2, v3}, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;-><init>(Ljava/lang/String;I)V

    throw v1

    .line 322
    :cond_2
    invoke-virtual {p0, p2}, Lcom/android/mail/compose/AttachmentsView;->addAttachment(Lcom/android/mail/providers/Attachment;)V

    .line 325
    iget v1, p2, Lcom/android/mail/providers/Attachment;->size:I

    int-to-long v1, v1

    return-wide v1
.end method

.method public addAttachment(Lcom/android/mail/providers/Attachment;)V
    .locals 5
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    const/4 v4, -0x1

    .line 99
    invoke-virtual {p0}, Lcom/android/mail/compose/AttachmentsView;->isShown()Z

    move-result v2

    if-nez v2, :cond_0

    .line 100
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/android/mail/compose/AttachmentsView;->setVisibility(I)V

    .line 103
    :cond_0
    iget-object v2, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachments:Ljava/util/ArrayList;

    invoke-virtual {v2, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 104
    invoke-virtual {p0}, Lcom/android/mail/compose/AttachmentsView;->expandView()V

    .line 108
    invoke-static {p1}, Lcom/android/mail/ui/AttachmentTile;->isTiledAttachment(Lcom/android/mail/providers/Attachment;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 109
    iget-object v2, p0, Lcom/android/mail/compose/AttachmentsView;->mTileGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v2, p1}, Lcom/android/mail/ui/AttachmentTileGrid;->addComposeTileFromAttachment(Lcom/android/mail/providers/Attachment;)Lcom/android/mail/compose/ComposeAttachmentTile;

    move-result-object v0

    .line 111
    .local v0, "attachmentTile":Lcom/android/mail/compose/ComposeAttachmentTile;
    new-instance v2, Lcom/android/mail/compose/AttachmentsView$1;

    invoke-direct {v2, p0, v0, p1}, Lcom/android/mail/compose/AttachmentsView$1;-><init>(Lcom/android/mail/compose/AttachmentsView;Lcom/android/mail/compose/ComposeAttachmentTile;Lcom/android/mail/providers/Attachment;)V

    invoke-virtual {v0, v2}, Lcom/android/mail/compose/ComposeAttachmentTile;->addDeleteListener(Landroid/view/View$OnClickListener;)V

    .line 135
    .end local v0    # "attachmentTile":Lcom/android/mail/compose/ComposeAttachmentTile;
    :goto_0
    iget-object v2, p0, Lcom/android/mail/compose/AttachmentsView;->mChangeListener:Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;

    if-eqz v2, :cond_1

    .line 136
    iget-object v2, p0, Lcom/android/mail/compose/AttachmentsView;->mChangeListener:Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;

    invoke-interface {v2}, Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;->onAttachmentAdded()V

    .line 138
    :cond_1
    return-void

    .line 120
    :cond_2
    new-instance v1, Lcom/android/mail/compose/AttachmentComposeView;

    invoke-virtual {p0}, Lcom/android/mail/compose/AttachmentsView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Lcom/android/mail/compose/AttachmentComposeView;-><init>(Landroid/content/Context;Lcom/android/mail/providers/Attachment;)V

    .line 123
    .local v1, "attachmentView":Lcom/android/mail/compose/AttachmentComposeView;
    new-instance v2, Lcom/android/mail/compose/AttachmentsView$2;

    invoke-direct {v2, p0, v1, p1}, Lcom/android/mail/compose/AttachmentsView$2;-><init>(Lcom/android/mail/compose/AttachmentsView;Lcom/android/mail/compose/AttachmentComposeView;Lcom/android/mail/providers/Attachment;)V

    invoke-virtual {v1, v2}, Lcom/android/mail/compose/AttachmentComposeView;->addDeleteListener(Landroid/view/View$OnClickListener;)V

    .line 131
    iget-object v2, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachmentLayout:Landroid/widget/LinearLayout;

    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v3, v4, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v1, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0
.end method

.method public deleteAllAttachments()V
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachments:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 178
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mTileGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v0}, Lcom/android/mail/ui/AttachmentTileGrid;->removeAllViews()V

    .line 179
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachmentLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 180
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/AttachmentsView;->setVisibility(I)V

    .line 181
    return-void
.end method

.method protected deleteAttachment(Landroid/view/View;Lcom/android/mail/providers/Attachment;)V
    .locals 1
    .param p1, "attachmentView"    # Landroid/view/View;
    .param p2, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachments:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 144
    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 145
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mChangeListener:Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mChangeListener:Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;

    invoke-interface {v0}, Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;->onAttachmentDeleted()V

    .line 148
    :cond_0
    return-void
.end method

.method public expandView()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 76
    iget-object v1, p0, Lcom/android/mail/compose/AttachmentsView;->mTileGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v1, v3}, Lcom/android/mail/ui/AttachmentTileGrid;->setVisibility(I)V

    .line 77
    iget-object v1, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachmentLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 79
    invoke-virtual {p0}, Lcom/android/mail/compose/AttachmentsView;->getContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 81
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    if-eqz v0, :cond_0

    .line 82
    invoke-virtual {p0}, Lcom/android/mail/compose/AttachmentsView;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 84
    :cond_0
    return-void
.end method

.method public focusLastAttachment()V
    .locals 5

    .prologue
    .line 364
    iget-object v3, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachments:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachments:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Attachment;

    .line 365
    .local v1, "lastAttachment":Lcom/android/mail/providers/Attachment;
    const/4 v2, 0x0

    .line 366
    .local v2, "lastView":Landroid/view/View;
    const/4 v0, 0x0

    .line 367
    .local v0, "last":I
    invoke-static {v1}, Lcom/android/mail/ui/AttachmentTile;->isTiledAttachment(Lcom/android/mail/providers/Attachment;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 368
    iget-object v3, p0, Lcom/android/mail/compose/AttachmentsView;->mTileGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v3}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildCount()I

    move-result v3

    add-int/lit8 v0, v3, -0x1

    .line 369
    if-lez v0, :cond_0

    .line 370
    iget-object v3, p0, Lcom/android/mail/compose/AttachmentsView;->mTileGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v3, v0}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 378
    :cond_0
    :goto_0
    if-eqz v2, :cond_1

    .line 379
    invoke-virtual {v2}, Landroid/view/View;->requestFocus()Z

    .line 381
    :cond_1
    return-void

    .line 373
    :cond_2
    iget-object v3, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachmentLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v3

    add-int/lit8 v0, v3, -0x1

    .line 374
    if-lez v0, :cond_0

    .line 375
    iget-object v3, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachmentLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    goto :goto_0
.end method

.method public generateLocalAttachment(Landroid/net/Uri;)Lcom/android/mail/providers/Attachment;
    .locals 11
    .param p1, "contentUri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 215
    invoke-virtual {p0}, Lcom/android/mail/compose/AttachmentsView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 216
    .local v0, "contentResolver":Landroid/content/ContentResolver;
    invoke-virtual {v0, p1}, Landroid/content/ContentResolver;->getType(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v7

    .line 217
    .local v7, "contentType":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 218
    :cond_0
    new-instance v1, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;

    const-string v2, "Failed to create local attachment"

    invoke-direct {v1, v2}, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 221
    :cond_1
    if-nez v7, :cond_2

    const-string v7, ""

    .line 223
    :cond_2
    new-instance v6, Lcom/android/mail/providers/Attachment;

    invoke-direct {v6}, Lcom/android/mail/providers/Attachment;-><init>()V

    .line 224
    .local v6, "attachment":Lcom/android/mail/providers/Attachment;
    iput-object v3, v6, Lcom/android/mail/providers/Attachment;->uri:Landroid/net/Uri;

    .line 225
    iput-object v3, v6, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    .line 226
    iput-object v7, v6, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    .line 227
    iput v2, v6, Lcom/android/mail/providers/Attachment;->size:I

    .line 228
    iput-object p1, v6, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    .line 230
    const/4 v10, 0x0

    .line 232
    .local v10, "metadataCursor":Landroid/database/Cursor;
    const/4 v1, 0x2

    :try_start_0
    new-array v2, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v3, "_display_name"

    aput-object v3, v2, v1

    const/4 v1, 0x1

    const-string v3, "_size"

    aput-object v3, v2, v1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v10

    .line 235
    if-eqz v10, :cond_4

    .line 237
    :try_start_1
    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 238
    const/4 v1, 0x0

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v6, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    .line 239
    const/4 v1, 0x1

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v6, Lcom/android/mail/providers/Attachment;->size:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 242
    :cond_3
    :try_start_2
    invoke-interface {v10}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_2 .. :try_end_2} :catch_1

    .line 280
    :cond_4
    :goto_0
    iget-object v1, v6, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    if-nez v1, :cond_5

    .line 281
    invoke-virtual {p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v6, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    .line 284
    :cond_5
    return-object v6

    .line 242
    :catchall_0
    move-exception v1

    :try_start_3
    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    throw v1
    :try_end_3
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_3 .. :try_end_3} :catch_1

    .line 245
    :catch_0
    move-exception v9

    .line 254
    .local v9, "ex":Landroid/database/sqlite/SQLiteException;
    :try_start_4
    const-string v1, "_display_name"

    invoke-direct {p0, v0, p1, v1}, Lcom/android/mail/compose/AttachmentsView;->getOptionalColumn(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 256
    if-eqz v10, :cond_6

    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 257
    const/4 v1, 0x0

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v6, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 260
    :cond_6
    if-eqz v10, :cond_7

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    .line 265
    :cond_7
    :try_start_5
    const-string v1, "_size"

    invoke-direct {p0, v0, p1, v1}, Lcom/android/mail/compose/AttachmentsView;->getOptionalColumn(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v10

    .line 267
    if-eqz v10, :cond_9

    invoke-interface {v10}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_9

    .line 268
    const/4 v1, 0x0

    invoke-interface {v10, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v6, Lcom/android/mail/providers/Attachment;->size:I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 274
    :goto_1
    if-eqz v10, :cond_4

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 260
    :catchall_1
    move-exception v1

    if-eqz v10, :cond_8

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    :cond_8
    throw v1

    .line 271
    :cond_9
    :try_start_6
    invoke-virtual {p0, p1, v0}, Lcom/android/mail/compose/AttachmentsView;->getSizeFromFile(Landroid/net/Uri;Landroid/content/ContentResolver;)I

    move-result v1

    iput v1, v6, Lcom/android/mail/providers/Attachment;->size:I
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    goto :goto_1

    .line 274
    :catchall_2
    move-exception v1

    if-eqz v10, :cond_a

    invoke-interface {v10}, Landroid/database/Cursor;->close()V

    :cond_a
    throw v1

    .line 276
    .end local v9    # "ex":Landroid/database/sqlite/SQLiteException;
    :catch_1
    move-exception v8

    .line 277
    .local v8, "e":Ljava/lang/SecurityException;
    new-instance v1, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;

    const-string v2, "Security Exception from attachment uri"

    invoke-direct {v1, v2, v8}, Lcom/android/mail/compose/AttachmentsView$AttachmentFailureException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public getAttachmentPreviews()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;",
            ">;"
        }
    .end annotation

    .prologue
    .line 163
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mTileGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v0}, Lcom/android/mail/ui/AttachmentTileGrid;->getAttachmentPreviews()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public getAttachments()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 155
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachments:Ljava/util/ArrayList;

    return-object v0
.end method

.method protected getSizeFromFile(Landroid/net/Uri;Landroid/content/ContentResolver;)I
    .locals 7
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "contentResolver"    # Landroid/content/ContentResolver;

    .prologue
    const/4 v6, 0x0

    .line 330
    const/4 v2, -0x1

    .line 331
    .local v2, "size":I
    const/4 v1, 0x0

    .line 333
    .local v1, "file":Landroid/os/ParcelFileDescriptor;
    :try_start_0
    const-string v3, "r"

    invoke-virtual {p2, p1, v3}, Landroid/content/ContentResolver;->openFileDescriptor(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;

    move-result-object v1

    .line 334
    invoke-virtual {v1}, Landroid/os/ParcelFileDescriptor;->getStatSize()J
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v3

    long-to-int v2, v3

    .line 339
    if-eqz v1, :cond_0

    .line 340
    :try_start_1
    invoke-virtual {v1}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 346
    :cond_0
    :goto_0
    return v2

    .line 342
    :catch_0
    move-exception v0

    .line 343
    .local v0, "e":Ljava/io/IOException;
    sget-object v3, Lcom/android/mail/compose/AttachmentsView;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Error closing file opened to obtain size."

    new-array v5, v6, [Ljava/lang/Object;

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 335
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 336
    .local v0, "e":Ljava/io/FileNotFoundException;
    :try_start_2
    sget-object v3, Lcom/android/mail/compose/AttachmentsView;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Error opening file to obtain size."

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 339
    if-eqz v1, :cond_0

    .line 340
    :try_start_3
    invoke-virtual {v1}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    goto :goto_0

    .line 342
    :catch_2
    move-exception v0

    .line 343
    .local v0, "e":Ljava/io/IOException;
    sget-object v3, Lcom/android/mail/compose/AttachmentsView;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Error closing file opened to obtain size."

    new-array v5, v6, [Ljava/lang/Object;

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 338
    .end local v0    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v3

    .line 339
    if-eqz v1, :cond_1

    .line 340
    :try_start_4
    invoke-virtual {v1}, Landroid/os/ParcelFileDescriptor;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    .line 344
    :cond_1
    :goto_1
    throw v3

    .line 342
    :catch_3
    move-exception v0

    .line 343
    .restart local v0    # "e":Ljava/io/IOException;
    sget-object v4, Lcom/android/mail/compose/AttachmentsView;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Error closing file opened to obtain size."

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1
.end method

.method public getTotalAttachmentsSize()J
    .locals 6

    .prologue
    .line 187
    const-wide/16 v2, 0x0

    .line 188
    .local v2, "totalSize":J
    iget-object v4, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachments:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 189
    .local v0, "attachment":Lcom/android/mail/providers/Attachment;
    iget v4, v0, Lcom/android/mail/providers/Attachment;->size:I

    int-to-long v4, v4

    add-long/2addr v2, v4

    goto :goto_0

    .line 191
    .end local v0    # "attachment":Lcom/android/mail/providers/Attachment;
    :cond_0
    return-wide v2
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 69
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 71
    const v0, 0x7f100052

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/AttachmentsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/AttachmentTileGrid;

    iput-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mTileGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    .line 72
    const v0, 0x7f100053

    invoke-virtual {p0, v0}, Lcom/android/mail/compose/AttachmentsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mAttachmentLayout:Landroid/widget/LinearLayout;

    .line 73
    return-void
.end method

.method public setAttachmentChangesListener(Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/android/mail/compose/AttachmentsView;->mChangeListener:Lcom/android/mail/compose/AttachmentsView$AttachmentAddedOrDeletedListener;

    .line 92
    return-void
.end method

.method public setAttachmentPreviews(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 170
    .local p1, "previews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;>;"
    iget-object v0, p0, Lcom/android/mail/compose/AttachmentsView;->mTileGrid:Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/AttachmentTileGrid;->setAttachmentPreviews(Ljava/util/ArrayList;)V

    .line 171
    return-void
.end method
