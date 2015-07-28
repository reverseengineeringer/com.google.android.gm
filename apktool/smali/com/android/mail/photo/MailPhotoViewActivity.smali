.class public Lcom/android/mail/photo/MailPhotoViewActivity;
.super Lcom/android/ex/photo/PhotoViewActivity;
.source "MailPhotoViewActivity.java"


# instance fields
.field private mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

.field private mMenu:Landroid/view/Menu;

.field private mSaveAllItem:Landroid/view/MenuItem;

.field private mSaveItem:Landroid/view/MenuItem;

.field private mShareAllItem:Landroid/view/MenuItem;

.field private mShareItem:Landroid/view/MenuItem;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/android/ex/photo/PhotoViewActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/photo/MailPhotoViewActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/photo/MailPhotoViewActivity;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->downloadAttachment()V

    return-void
.end method

.method private downloadAttachment()V
    .locals 3

    .prologue
    .line 255
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCurrentAttachment()Lcom/android/mail/providers/Attachment;

    move-result-object v0

    .line 256
    .local v0, "attachment":Lcom/android/mail/providers/Attachment;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->canSave()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 257
    iget-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v1, v0}, Lcom/android/mail/browse/AttachmentActionHandler;->setAttachment(Lcom/android/mail/providers/Attachment;)V

    .line 258
    iget-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/android/mail/browse/AttachmentActionHandler;->startDownloadingAttachment(I)V

    .line 260
    :cond_0
    return-void
.end method

.method private getAllAttachments()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 341
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 343
    .local v0, "cursor":Landroid/database/Cursor;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-nez v2, :cond_1

    .line 344
    :cond_0
    const/4 v1, 0x0

    .line 352
    :goto_0
    return-object v1

    .line 347
    :cond_1
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 349
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    :cond_2
    new-instance v2, Lcom/android/mail/providers/Attachment;

    invoke-direct {v2, v0}, Lcom/android/mail/providers/Attachment;-><init>(Landroid/database/Cursor;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 350
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    if-nez v2, :cond_2

    goto :goto_0
.end method

.method private saveAllAttachments()V
    .locals 3

    .prologue
    .line 277
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCursorAtProperPosition()Landroid/database/Cursor;

    move-result-object v0

    .line 279
    .local v0, "cursor":Landroid/database/Cursor;
    if-nez v0, :cond_1

    .line 287
    :cond_0
    return-void

    .line 283
    :cond_1
    const/4 v1, -0x1

    .line 284
    .local v1, "i":I
    :goto_0
    add-int/lit8 v1, v1, 0x1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 285
    new-instance v2, Lcom/android/mail/providers/Attachment;

    invoke-direct {v2, v0}, Lcom/android/mail/providers/Attachment;-><init>(Landroid/database/Cursor;)V

    invoke-direct {p0, v2}, Lcom/android/mail/photo/MailPhotoViewActivity;->saveAttachment(Lcom/android/mail/providers/Attachment;)V

    goto :goto_0
.end method

.method private saveAttachment()V
    .locals 1

    .prologue
    .line 248
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCurrentAttachment()Lcom/android/mail/providers/Attachment;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/photo/MailPhotoViewActivity;->saveAttachment(Lcom/android/mail/providers/Attachment;)V

    .line 249
    return-void
.end method

.method private saveAttachment(Lcom/android/mail/providers/Attachment;)V
    .locals 2
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 267
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/android/mail/providers/Attachment;->canSave()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 268
    iget-object v0, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/AttachmentActionHandler;->setAttachment(Lcom/android/mail/providers/Attachment;)V

    .line 269
    iget-object v0, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/AttachmentActionHandler;->startDownloadingAttachment(I)V

    .line 271
    :cond_0
    return-void
.end method

.method private shareAllAttachments()V
    .locals 4

    .prologue
    .line 311
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCursorAtProperPosition()Landroid/database/Cursor;

    move-result-object v0

    .line 313
    .local v0, "cursor":Landroid/database/Cursor;
    if-nez v0, :cond_0

    .line 324
    :goto_0
    return-void

    .line 317
    :cond_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 318
    .local v2, "uris":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/os/Parcelable;>;"
    const/4 v1, -0x1

    .line 319
    .local v1, "i":I
    :goto_1
    add-int/lit8 v1, v1, 0x1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 320
    new-instance v3, Lcom/android/mail/providers/Attachment;

    invoke-direct {v3, v0}, Lcom/android/mail/providers/Attachment;-><init>(Landroid/database/Cursor;)V

    iget-object v3, v3, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    invoke-static {v3}, Lcom/android/mail/utils/Utils;->normalizeUri(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 323
    :cond_1
    iget-object v3, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v3, v2}, Lcom/android/mail/browse/AttachmentActionHandler;->shareAttachments(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method private shareAttachment()V
    .locals 1

    .prologue
    .line 293
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCurrentAttachment()Lcom/android/mail/providers/Attachment;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/photo/MailPhotoViewActivity;->shareAttachment(Lcom/android/mail/providers/Attachment;)V

    .line 294
    return-void
.end method

.method private shareAttachment(Lcom/android/mail/providers/Attachment;)V
    .locals 1
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 301
    if-eqz p1, :cond_0

    .line 302
    iget-object v0, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/AttachmentActionHandler;->setAttachment(Lcom/android/mail/providers/Attachment;)V

    .line 303
    iget-object v0, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v0}, Lcom/android/mail/browse/AttachmentActionHandler;->shareAttachment()V

    .line 305
    :cond_0
    return-void
.end method

.method private updateProgressAndEmptyViews(Lcom/android/ex/photo/fragments/PhotoViewFragment;Lcom/android/mail/providers/Attachment;)V
    .locals 6
    .param p1, "fragment"    # Lcom/android/ex/photo/fragments/PhotoViewFragment;
    .param p2, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 212
    invoke-virtual {p1}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getPhotoProgressBar()Lcom/android/ex/photo/views/ProgressBarWrapper;

    move-result-object v1

    .line 213
    .local v1, "progressBar":Lcom/android/ex/photo/views/ProgressBarWrapper;
    invoke-virtual {p1}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getEmptyText()Landroid/widget/TextView;

    move-result-object v0

    .line 214
    .local v0, "emptyText":Landroid/widget/TextView;
    invoke-virtual {p1}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getRetryButton()Landroid/widget/ImageView;

    move-result-object v2

    .line 217
    .local v2, "retryButton":Landroid/widget/ImageView;
    invoke-virtual {p2}, Lcom/android/mail/providers/Attachment;->shouldShowProgress()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 218
    iget v3, p2, Lcom/android/mail/providers/Attachment;->size:I

    invoke-virtual {v1, v3}, Lcom/android/ex/photo/views/ProgressBarWrapper;->setMax(I)V

    .line 219
    iget v3, p2, Lcom/android/mail/providers/Attachment;->downloadedSize:I

    invoke-virtual {v1, v3}, Lcom/android/ex/photo/views/ProgressBarWrapper;->setProgress(I)V

    .line 220
    invoke-virtual {v1, v4}, Lcom/android/ex/photo/views/ProgressBarWrapper;->setIndeterminate(Z)V

    .line 226
    :cond_0
    :goto_0
    invoke-virtual {p2}, Lcom/android/mail/providers/Attachment;->downloadFailed()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 227
    const v3, 0x7f0c00ef

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(I)V

    .line 228
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 229
    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 230
    new-instance v3, Lcom/android/mail/photo/MailPhotoViewActivity$1;

    invoke-direct {v3, p0, v1}, Lcom/android/mail/photo/MailPhotoViewActivity$1;-><init>(Lcom/android/mail/photo/MailPhotoViewActivity;Lcom/android/ex/photo/views/ProgressBarWrapper;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 237
    invoke-virtual {v1, v5}, Lcom/android/ex/photo/views/ProgressBarWrapper;->setVisibility(I)V

    .line 242
    :goto_1
    return-void

    .line 221
    :cond_1
    invoke-virtual {p1}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->isProgressBarNeeded()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 222
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Lcom/android/ex/photo/views/ProgressBarWrapper;->setIndeterminate(Z)V

    goto :goto_0

    .line 239
    :cond_2
    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 240
    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method protected getCurrentAttachment()Lcom/android/mail/providers/Attachment;
    .locals 2

    .prologue
    .line 331
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCursorAtProperPosition()Landroid/database/Cursor;

    move-result-object v0

    .line 333
    .local v0, "cursor":Landroid/database/Cursor;
    if-nez v0, :cond_0

    .line 334
    const/4 v1, 0x0

    .line 337
    :goto_0
    return-object v1

    :cond_0
    new-instance v1, Lcom/android/mail/providers/Attachment;

    invoke-direct {v1, v0}, Lcom/android/mail/providers/Attachment;-><init>(Landroid/database/Cursor;)V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 60
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/android/mail/photo/MailPhotoViewActivity;->requestWindowFeature(I)Z

    .line 61
    invoke-super {p0, p1}, Lcom/android/ex/photo/PhotoViewActivity;->onCreate(Landroid/os/Bundle;)V

    .line 63
    new-instance v0, Lcom/android/mail/browse/AttachmentActionHandler;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/android/mail/browse/AttachmentActionHandler;-><init>(Landroid/content/Context;Lcom/android/mail/browse/AttachmentViewInterface;)V

    iput-object v0, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    .line 64
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 68
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 70
    .local v0, "inflater":Landroid/view/MenuInflater;
    const v1, 0x7f12000b

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 71
    iput-object p1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mMenu:Landroid/view/Menu;

    .line 73
    iget-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mMenu:Landroid/view/Menu;

    const v2, 0x7f10013b

    invoke-interface {v1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mSaveItem:Landroid/view/MenuItem;

    .line 74
    iget-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mMenu:Landroid/view/Menu;

    const v2, 0x7f10013c

    invoke-interface {v1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mSaveAllItem:Landroid/view/MenuItem;

    .line 75
    iget-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mMenu:Landroid/view/Menu;

    const v2, 0x7f10013d

    invoke-interface {v1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mShareItem:Landroid/view/MenuItem;

    .line 76
    iget-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mMenu:Landroid/view/Menu;

    const v2, 0x7f10013e

    invoke-interface {v1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mShareAllItem:Landroid/view/MenuItem;

    .line 78
    const/4 v1, 0x1

    return v1
.end method

.method public onFragmentVisible(Lcom/android/ex/photo/fragments/PhotoViewFragment;)V
    .locals 1
    .param p1, "fragment"    # Lcom/android/ex/photo/fragments/PhotoViewFragment;

    .prologue
    .line 196
    invoke-super {p0, p1}, Lcom/android/ex/photo/PhotoViewActivity;->onFragmentVisible(Lcom/android/ex/photo/fragments/PhotoViewFragment;)V

    .line 198
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCurrentAttachment()Lcom/android/mail/providers/Attachment;

    move-result-object v0

    .line 199
    .local v0, "attachment":Lcom/android/mail/providers/Attachment;
    invoke-direct {p0, p1, v0}, Lcom/android/mail/photo/MailPhotoViewActivity;->updateProgressAndEmptyViews(Lcom/android/ex/photo/fragments/PhotoViewFragment;Lcom/android/mail/providers/Attachment;)V

    .line 200
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v0, 0x1

    .line 140
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 158
    invoke-super {p0, p1}, Lcom/android/ex/photo/PhotoViewActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 143
    :sswitch_0
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->finish()V

    goto :goto_0

    .line 146
    :sswitch_1
    invoke-direct {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->saveAttachment()V

    goto :goto_0

    .line 149
    :sswitch_2
    invoke-direct {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->saveAllAttachments()V

    goto :goto_0

    .line 152
    :sswitch_3
    invoke-direct {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->shareAttachment()V

    goto :goto_0

    .line 155
    :sswitch_4
    invoke-direct {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->shareAllAttachments()V

    goto :goto_0

    .line 140
    nop

    :sswitch_data_0
    .sparse-switch
        0x102002c -> :sswitch_0
        0x7f10013b -> :sswitch_1
        0x7f10013c -> :sswitch_2
        0x7f10013d -> :sswitch_3
        0x7f10013e -> :sswitch_4
    .end sparse-switch
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 83
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->updateActionItems()V

    .line 84
    const/4 v0, 0x1

    return v0
.end method

.method protected updateActionBar(Lcom/android/ex/photo/fragments/PhotoViewFragment;)V
    .locals 6
    .param p1, "fragment"    # Lcom/android/ex/photo/fragments/PhotoViewFragment;

    .prologue
    .line 167
    invoke-super {p0, p1}, Lcom/android/ex/photo/PhotoViewActivity;->updateActionBar(Lcom/android/ex/photo/fragments/PhotoViewFragment;)V

    .line 169
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCurrentAttachment()Lcom/android/mail/providers/Attachment;

    move-result-object v1

    .line 171
    .local v1, "attachment":Lcom/android/mail/providers/Attachment;
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 172
    .local v0, "actionBar":Landroid/app/ActionBar;
    iget v3, v1, Lcom/android/mail/providers/Attachment;->size:I

    int-to-long v3, v3

    invoke-static {p0, v3, v4}, Lcom/android/mail/utils/AttachmentUtils;->convertToHumanReadableSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v2

    .line 181
    .local v2, "subtitle":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/android/mail/providers/Attachment;->isSavedToExternal()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 182
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0c007f

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 191
    :goto_0
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->updateActionItems()V

    .line 192
    return-void

    .line 184
    :cond_0
    invoke-virtual {v1}, Lcom/android/mail/providers/Attachment;->isDownloading()Z

    move-result v3

    if-eqz v3, :cond_1

    iget v3, v1, Lcom/android/mail/providers/Attachment;->destination:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    .line 186
    const v3, 0x7f0c0085

    invoke-virtual {v0, v3}, Landroid/app/ActionBar;->setSubtitle(I)V

    goto :goto_0

    .line 188
    :cond_1
    invoke-virtual {v0, v2}, Landroid/app/ActionBar;->setSubtitle(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method protected updateActionItems()V
    .locals 9

    .prologue
    const/4 v7, 0x0

    .line 94
    invoke-static {}, Lcom/android/mail/utils/Utils;->isRunningJellybeanOrLater()Z

    move-result v5

    .line 95
    .local v5, "runningJellyBeanOrLater":Z
    invoke-virtual {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getCurrentAttachment()Lcom/android/mail/providers/Attachment;

    move-result-object v1

    .line 97
    .local v1, "attachment":Lcom/android/mail/providers/Attachment;
    if-eqz v1, :cond_7

    iget-object v6, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mSaveItem:Landroid/view/MenuItem;

    if-eqz v6, :cond_7

    iget-object v6, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mShareItem:Landroid/view/MenuItem;

    if-eqz v6, :cond_7

    .line 98
    iget-object v8, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mSaveItem:Landroid/view/MenuItem;

    invoke-virtual {v1}, Lcom/android/mail/providers/Attachment;->isDownloading()Z

    move-result v6

    if-nez v6, :cond_6

    invoke-virtual {v1}, Lcom/android/mail/providers/Attachment;->canSave()Z

    move-result v6

    if-eqz v6, :cond_6

    invoke-virtual {v1}, Lcom/android/mail/providers/Attachment;->isSavedToExternal()Z

    move-result v6

    if-nez v6, :cond_6

    const/4 v6, 0x1

    :goto_0
    invoke-interface {v8, v6}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 100
    iget-object v6, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mShareItem:Landroid/view/MenuItem;

    invoke-virtual {v1}, Lcom/android/mail/providers/Attachment;->canShare()Z

    move-result v8

    invoke-interface {v6, v8}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 108
    invoke-direct {p0}, Lcom/android/mail/photo/MailPhotoViewActivity;->getAllAttachments()Ljava/util/List;

    move-result-object v2

    .line 109
    .local v2, "attachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    if-eqz v2, :cond_4

    .line 110
    const/4 v3, 0x0

    .line 111
    .local v3, "enabled":Z
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 113
    .local v0, "a":Lcom/android/mail/providers/Attachment;
    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->isDownloading()Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->canSave()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->isSavedToExternal()Z

    move-result v6

    if-nez v6, :cond_0

    .line 114
    const/4 v3, 0x1

    .line 118
    .end local v0    # "a":Lcom/android/mail/providers/Attachment;
    :cond_1
    iget-object v6, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mSaveAllItem:Landroid/view/MenuItem;

    invoke-interface {v6, v3}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 121
    const/4 v3, 0x1

    .line 122
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 123
    .restart local v0    # "a":Lcom/android/mail/providers/Attachment;
    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->canShare()Z

    move-result v6

    if-nez v6, :cond_2

    .line 124
    const/4 v3, 0x0

    .line 128
    .end local v0    # "a":Lcom/android/mail/providers/Attachment;
    :cond_3
    iget-object v6, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mShareAllItem:Landroid/view/MenuItem;

    invoke-interface {v6, v3}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 132
    .end local v3    # "enabled":Z
    .end local v4    # "i$":Ljava/util/Iterator;
    :cond_4
    if-nez v5, :cond_5

    .line 133
    iget-object v6, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mShareItem:Landroid/view/MenuItem;

    invoke-interface {v6, v7}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 134
    iget-object v6, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mShareAllItem:Landroid/view/MenuItem;

    invoke-interface {v6, v7}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 136
    .end local v2    # "attachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    :cond_5
    :goto_1
    return-void

    :cond_6
    move v6, v7

    .line 98
    goto :goto_0

    .line 102
    :cond_7
    iget-object v6, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mMenu:Landroid/view/Menu;

    if-eqz v6, :cond_5

    .line 103
    iget-object v6, p0, Lcom/android/mail/photo/MailPhotoViewActivity;->mMenu:Landroid/view/Menu;

    const v8, 0x7f10013a

    invoke-interface {v6, v8, v7}, Landroid/view/Menu;->setGroupEnabled(IZ)V

    goto :goto_1
.end method
