.class public Lcom/android/mail/browse/MessageAttachmentBar;
.super Landroid/widget/FrameLayout;
.source "MessageAttachmentBar.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/PopupMenu$OnMenuItemClickListener;
.implements Lcom/android/mail/browse/AttachmentViewInterface;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

.field private mAttachment:Lcom/android/mail/providers/Attachment;

.field private mAttachmentSizeText:Ljava/lang/String;

.field private mCancelButton:Landroid/widget/ImageButton;

.field private mDisplayType:Ljava/lang/String;

.field private mOverflowButton:Landroid/widget/ImageView;

.field private mPopup:Landroid/widget/PopupMenu;

.field private mProgress:Landroid/widget/ProgressBar;

.field private mSaveClicked:Z

.field private mSubTitle:Landroid/widget/TextView;

.field private mTitle:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/MessageAttachmentBar;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 76
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/MessageAttachmentBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 77
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 80
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 82
    new-instance v0, Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-direct {v0, p1, p0}, Lcom/android/mail/browse/AttachmentActionHandler;-><init>(Landroid/content/Context;Lcom/android/mail/browse/AttachmentViewInterface;)V

    iput-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    .line 83
    return-void
.end method

.method public static inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/android/mail/browse/MessageAttachmentBar;
    .locals 3
    .param p0, "inflater"    # Landroid/view/LayoutInflater;
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 90
    const v1, 0x7f040026

    const/4 v2, 0x0

    invoke-virtual {p0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/MessageAttachmentBar;

    .line 92
    .local v0, "view":Lcom/android/mail/browse/MessageAttachmentBar;
    return-object v0
.end method

.method private onClick(ILandroid/view/View;)Z
    .locals 10
    .param p1, "res"    # I
    .param p2, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x0

    const/4 v6, 0x1

    .line 158
    sparse-switch p1, :sswitch_data_0

    .line 211
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v7, v7, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v7}, Lcom/android/mail/utils/MimeType;->isInstallable(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 212
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v7, v6}, Lcom/android/mail/browse/AttachmentActionHandler;->showAttachment(I)V

    .line 236
    :cond_0
    :goto_0
    return v6

    .line 160
    :sswitch_0
    invoke-direct {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->previewAttachment()V

    goto :goto_0

    .line 163
    :sswitch_1
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->canSave()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 164
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v7, v6}, Lcom/android/mail/browse/AttachmentActionHandler;->startDownloadingAttachment(I)V

    .line 165
    iput-boolean v6, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSaveClicked:Z

    goto :goto_0

    .line 169
    :sswitch_2
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->isPresentLocally()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 170
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    iget-object v8, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7, v8}, Lcom/android/mail/browse/AttachmentActionHandler;->startRedownloadingAttachment(Lcom/android/mail/providers/Attachment;)V

    goto :goto_0

    .line 174
    :sswitch_3
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v7}, Lcom/android/mail/browse/AttachmentActionHandler;->cancelAttachment()V

    .line 175
    iput-boolean v3, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSaveClicked:Z

    goto :goto_0

    .line 178
    :sswitch_4
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->canSave()Z

    move-result v7

    if-eqz v7, :cond_1

    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->isDownloading()Z

    move-result v7

    if-nez v7, :cond_1

    move v3, v6

    .line 179
    .local v3, "canSave":Z
    :cond_1
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->canPreview()Z

    move-result v2

    .line 180
    .local v2, "canPreview":Z
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->isPresentLocally()Z

    move-result v1

    .line 185
    .local v1, "canDownloadAgain":Z
    if-nez v3, :cond_2

    if-nez v2, :cond_2

    if-eqz v1, :cond_0

    .line 189
    :cond_2
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mPopup:Landroid/widget/PopupMenu;

    if-nez v7, :cond_3

    .line 190
    new-instance v7, Landroid/widget/PopupMenu;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-direct {v7, v8, p2}, Landroid/widget/PopupMenu;-><init>(Landroid/content/Context;Landroid/view/View;)V

    iput-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mPopup:Landroid/widget/PopupMenu;

    .line 191
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v7}, Landroid/widget/PopupMenu;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v7

    const v8, 0x7f120009

    iget-object v9, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v9}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 193
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v7, p0}, Landroid/widget/PopupMenu;->setOnMenuItemClickListener(Landroid/widget/PopupMenu$OnMenuItemClickListener;)V

    .line 196
    :cond_3
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v7}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v5

    .line 197
    .local v5, "menu":Landroid/view/Menu;
    const v7, 0x7f100137

    invoke-interface {v5, v7}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v7

    invoke-interface {v7, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 198
    const v7, 0x7f100138

    invoke-interface {v5, v7}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v7

    invoke-interface {v7, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 199
    const v7, 0x7f100139

    invoke-interface {v5, v7}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v7

    invoke-interface {v7, v1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 201
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v7}, Landroid/widget/PopupMenu;->show()V

    goto/16 :goto_0

    .line 216
    .end local v1    # "canDownloadAgain":Z
    .end local v2    # "canPreview":Z
    .end local v3    # "canSave":Z
    .end local v5    # "menu":Landroid/view/Menu;
    :cond_4
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getContext()Landroid/content/Context;

    move-result-object v7

    iget-object v8, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v8, v8, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    iget-object v9, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v9, v9, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v7, v8, v9}, Lcom/android/mail/utils/MimeType;->isViewable(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 218
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v7, v3}, Lcom/android/mail/browse/AttachmentActionHandler;->showAttachment(I)V

    goto/16 :goto_0

    .line 221
    :cond_5
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->canPreview()Z

    move-result v7

    if-eqz v7, :cond_6

    .line 222
    invoke-direct {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->previewAttachment()V

    goto/16 :goto_0

    .line 226
    :cond_6
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-direct {v0, v7}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 227
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v7, v7, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v7}, Lcom/android/mail/utils/MimeType;->isBlocked(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    const v4, 0x7f0c007b

    .line 229
    .local v4, "dialogMessage":I
    :goto_1
    const v7, 0x7f0c007a

    invoke-virtual {v0, v7}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v7

    invoke-virtual {v7, v4}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v7

    invoke-virtual {v7}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto/16 :goto_0

    .line 227
    .end local v4    # "dialogMessage":I
    :cond_7
    const v4, 0x7f0c007c

    goto :goto_1

    .line 158
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f10006f -> :sswitch_4
        0x7f100070 -> :sswitch_3
        0x7f100137 -> :sswitch_0
        0x7f100138 -> :sswitch_1
        0x7f100139 -> :sswitch_2
    .end sparse-switch
.end method

.method private previewAttachment()V
    .locals 3

    .prologue
    .line 259
    iget-object v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v1}, Lcom/android/mail/providers/Attachment;->canPreview()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 260
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    iget-object v2, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v2, v2, Lcom/android/mail/providers/Attachment;->previewIntentUri:Landroid/net/Uri;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 262
    .local v0, "previewIntent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 264
    .end local v0    # "previewIntent":Landroid/content/Intent;
    :cond_0
    return-void
.end method

.method private setButtonVisible(Landroid/view/View;Z)V
    .locals 1
    .param p1, "button"    # Landroid/view/View;
    .param p2, "visible"    # Z

    .prologue
    .line 267
    if-eqz p2, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 268
    return-void

    .line 267
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method

.method private updateActions()V
    .locals 10

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 275
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v7}, Lcom/android/mail/browse/AttachmentActionHandler;->isProgressDialogVisible()Z

    move-result v7

    if-nez v7, :cond_0

    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v7}, Lcom/android/mail/browse/AttachmentActionHandler;->dialogJustClosed()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 301
    :cond_0
    :goto_0
    return-void

    .line 282
    :cond_1
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->isDownloading()Z

    move-result v3

    .line 283
    .local v3, "isDownloading":Z
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->canSave()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getContext()Landroid/content/Context;

    move-result-object v7

    iget-object v8, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v8, v8, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    iget-object v9, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v9, v9, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v7, v8, v9}, Lcom/android/mail/utils/MimeType;->isViewable(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    move v2, v5

    .line 286
    .local v2, "canSave":Z
    :goto_1
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->canPreview()Z

    move-result v1

    .line 287
    .local v1, "canPreview":Z
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v7, v7, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v7}, Lcom/android/mail/utils/MimeType;->isInstallable(Ljava/lang/String;)Z

    move-result v4

    .line 288
    .local v4, "isInstallable":Z
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v7}, Lcom/android/mail/providers/Attachment;->isPresentLocally()Z

    move-result v0

    .line 290
    .local v0, "canDownloadAgain":Z
    iget-object v8, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mCancelButton:Landroid/widget/ImageButton;

    if-eqz v3, :cond_3

    iget-boolean v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSaveClicked:Z

    if-eqz v7, :cond_3

    move v7, v5

    :goto_2
    invoke-direct {p0, v8, v7}, Lcom/android/mail/browse/MessageAttachmentBar;->setButtonVisible(Landroid/view/View;Z)V

    .line 292
    if-eqz v3, :cond_4

    .line 293
    iget-object v5, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mOverflowButton:Landroid/widget/ImageView;

    invoke-direct {p0, v5, v6}, Lcom/android/mail/browse/MessageAttachmentBar;->setButtonVisible(Landroid/view/View;Z)V

    goto :goto_0

    .end local v0    # "canDownloadAgain":Z
    .end local v1    # "canPreview":Z
    .end local v2    # "canSave":Z
    .end local v4    # "isInstallable":Z
    :cond_2
    move v2, v6

    .line 283
    goto :goto_1

    .restart local v0    # "canDownloadAgain":Z
    .restart local v1    # "canPreview":Z
    .restart local v2    # "canSave":Z
    .restart local v4    # "isInstallable":Z
    :cond_3
    move v7, v6

    .line 290
    goto :goto_2

    .line 294
    :cond_4
    if-eqz v2, :cond_5

    iget-boolean v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSaveClicked:Z

    if-eqz v7, :cond_5

    .line 295
    iget-object v5, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mOverflowButton:Landroid/widget/ImageView;

    invoke-direct {p0, v5, v6}, Lcom/android/mail/browse/MessageAttachmentBar;->setButtonVisible(Landroid/view/View;Z)V

    goto :goto_0

    .line 296
    :cond_5
    if-eqz v4, :cond_6

    if-nez v0, :cond_6

    .line 297
    iget-object v5, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mOverflowButton:Landroid/widget/ImageView;

    invoke-direct {p0, v5, v6}, Lcom/android/mail/browse/MessageAttachmentBar;->setButtonVisible(Landroid/view/View;Z)V

    goto :goto_0

    .line 299
    :cond_6
    iget-object v7, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mOverflowButton:Landroid/widget/ImageView;

    if-nez v2, :cond_7

    if-nez v1, :cond_7

    if-eqz v0, :cond_8

    :cond_7
    move v6, v5

    :cond_8
    invoke-direct {p0, v7, v6}, Lcom/android/mail/browse/MessageAttachmentBar;->setButtonVisible(Landroid/view/View;Z)V

    goto :goto_0
.end method

.method private updateSubtitleText(Ljava/lang/String;)V
    .locals 3
    .param p1, "prefix"    # Ljava/lang/String;

    .prologue
    .line 328
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 329
    .local v0, "sb":Ljava/lang/StringBuilder;
    if-eqz p1, :cond_0

    .line 330
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 332
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachmentSizeText:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 333
    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 334
    iget-object v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mDisplayType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 335
    iget-object v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSubTitle:Landroid/widget/TextView;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 336
    return-void
.end method


# virtual methods
.method public getAttachments()Ljava/util/List;
    .locals 1
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
    .line 340
    const/4 v0, 0x0

    return-object v0
.end method

.method public initialize(Landroid/app/FragmentManager;)V
    .locals 1
    .param p1, "fragmentManager"    # Landroid/app/FragmentManager;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/AttachmentActionHandler;->initialize(Landroid/app/FragmentManager;)V

    .line 87
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 148
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    invoke-direct {p0, v0, p1}, Lcom/android/mail/browse/MessageAttachmentBar;->onClick(ILandroid/view/View;)Z

    .line 149
    return-void
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 133
    invoke-super {p0}, Landroid/widget/FrameLayout;->onFinishInflate()V

    .line 135
    const v0, 0x7f10006c

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageAttachmentBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mTitle:Landroid/widget/TextView;

    .line 136
    const v0, 0x7f10006d

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageAttachmentBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSubTitle:Landroid/widget/TextView;

    .line 137
    const v0, 0x7f10006e

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageAttachmentBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mProgress:Landroid/widget/ProgressBar;

    .line 138
    const v0, 0x7f10006f

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageAttachmentBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mOverflowButton:Landroid/widget/ImageView;

    .line 139
    const v0, 0x7f100070

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageAttachmentBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mCancelButton:Landroid/widget/ImageButton;

    .line 141
    invoke-virtual {p0, p0}, Lcom/android/mail/browse/MessageAttachmentBar;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mOverflowButton:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 143
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mCancelButton:Landroid/widget/ImageButton;

    invoke-virtual {v0, p0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    return-void
.end method

.method public onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 153
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mPopup:Landroid/widget/PopupMenu;

    invoke-virtual {v0}, Landroid/widget/PopupMenu;->dismiss()V

    .line 154
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/android/mail/browse/MessageAttachmentBar;->onClick(ILandroid/view/View;)Z

    move-result v0

    return v0
.end method

.method public onUpdateStatus()V
    .locals 3

    .prologue
    .line 304
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v0, v0, Lcom/android/mail/providers/Attachment;->state:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 305
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSubTitle:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0080

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 310
    :goto_0
    return-void

    .line 307
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->isSavedToExternal()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0c007f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_1
    invoke-direct {p0, v0}, Lcom/android/mail/browse/MessageAttachmentBar;->updateSubtitleText(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public render(Lcom/android/mail/providers/Attachment;Z)V
    .locals 6
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;
    .param p2, "loaderResult"    # Z

    .prologue
    const/4 v2, 0x0

    .line 102
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    .line 103
    .local v0, "prevAttachment":Lcom/android/mail/providers/Attachment;
    iput-object p1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    .line 104
    iget-object v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    iget-object v3, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v1, v3}, Lcom/android/mail/browse/AttachmentActionHandler;->setAttachment(Lcom/android/mail/providers/Attachment;)V

    .line 109
    invoke-virtual {p1}, Lcom/android/mail/providers/Attachment;->isDownloading()Z

    move-result v1

    if-nez v1, :cond_4

    move v1, v2

    :goto_0
    iput-boolean v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSaveClicked:Z

    .line 111
    sget-object v1, Lcom/android/mail/browse/MessageAttachmentBar;->LOG_TAG:Ljava/lang/String;

    const-string v3, "got attachment list row: name=%s state/dest=%d/%d dled=%d contentUri=%s MIME=%s"

    const/4 v4, 0x6

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p1, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    aput-object v5, v4, v2

    const/4 v2, 0x1

    iget v5, p1, Lcom/android/mail/providers/Attachment;->state:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v2

    const/4 v2, 0x2

    iget v5, p1, Lcom/android/mail/providers/Attachment;->destination:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v2

    const/4 v2, 0x3

    iget v5, p1, Lcom/android/mail/providers/Attachment;->downloadedSize:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v2

    const/4 v2, 0x4

    iget-object v5, p1, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    aput-object v5, v4, v2

    const/4 v2, 0x5

    iget-object v5, p1, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    aput-object v5, v4, v2

    invoke-static {v1, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 116
    if-eqz v0, :cond_0

    iget-object v1, p1, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    iget-object v2, v0, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 117
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mTitle:Landroid/widget/TextView;

    iget-object v2, p1, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 120
    :cond_1
    if-eqz v0, :cond_2

    iget v1, p1, Lcom/android/mail/providers/Attachment;->size:I

    iget v2, v0, Lcom/android/mail/providers/Attachment;->size:I

    if-eq v1, v2, :cond_3

    .line 121
    :cond_2
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getContext()Landroid/content/Context;

    move-result-object v1

    iget v2, p1, Lcom/android/mail/providers/Attachment;->size:I

    int-to-long v2, v2

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/AttachmentUtils;->convertToHumanReadableSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachmentSizeText:Ljava/lang/String;

    .line 123
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, p1}, Lcom/android/mail/utils/AttachmentUtils;->getDisplayType(Landroid/content/Context;Lcom/android/mail/providers/Attachment;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mDisplayType:Ljava/lang/String;

    .line 124
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Lcom/android/mail/browse/MessageAttachmentBar;->updateSubtitleText(Ljava/lang/String;)V

    .line 127
    :cond_3
    invoke-direct {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->updateActions()V

    .line 128
    iget-object v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v1, p2}, Lcom/android/mail/browse/AttachmentActionHandler;->updateStatus(Z)V

    .line 129
    return-void

    .line 109
    :cond_4
    iget-boolean v1, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSaveClicked:Z

    goto :goto_0
.end method

.method public updateProgress(Z)V
    .locals 4
    .param p1, "showProgress"    # Z

    .prologue
    const/4 v3, 0x4

    const/4 v1, 0x0

    .line 313
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->isDownloading()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 314
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mProgress:Landroid/widget/ProgressBar;

    iget-object v2, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v2, v2, Lcom/android/mail/providers/Attachment;->size:I

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 315
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mProgress:Landroid/widget/ProgressBar;

    iget-object v2, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v2, v2, Lcom/android/mail/providers/Attachment;->downloadedSize:I

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 316
    iget-object v2, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mProgress:Landroid/widget/ProgressBar;

    if-nez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v2, v0}, Landroid/widget/ProgressBar;->setIndeterminate(Z)V

    .line 317
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 318
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSubTitle:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 323
    :goto_1
    return-void

    :cond_0
    move v0, v1

    .line 316
    goto :goto_0

    .line 320
    :cond_1
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 321
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mSubTitle:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method public viewAttachment()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 240
    iget-object v2, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v2, v2, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    if-nez v2, :cond_0

    .line 241
    sget-object v2, Lcom/android/mail/browse/MessageAttachmentBar;->LOG_TAG:Ljava/lang/String;

    const-string v3, "viewAttachment with null content uri"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 256
    :goto_0
    return-void

    .line 245
    :cond_0
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 246
    .local v1, "intent":Landroid/content/Intent;
    const v2, 0x80001

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 248
    iget-object v2, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v2, v2, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    iget-object v3, p0, Lcom/android/mail/browse/MessageAttachmentBar;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v3, v3, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/Utils;->setIntentDataAndTypeAndNormalize(Landroid/content/Intent;Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 251
    :try_start_0
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentBar;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 252
    :catch_0
    move-exception v0

    .line 254
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    sget-object v2, Lcom/android/mail/browse/MessageAttachmentBar;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Couldn\'t find Activity for intent"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method
