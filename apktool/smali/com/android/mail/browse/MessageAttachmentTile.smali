.class public Lcom/android/mail/browse/MessageAttachmentTile;
.super Lcom/android/mail/ui/AttachmentTile;
.source "MessageAttachmentTile.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/android/mail/browse/AttachmentViewInterface;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

.field private mAttachmentsListUri:Landroid/net/Uri;

.field private mPhotoIndex:I

.field private mProgress:Landroid/widget/ProgressBar;

.field private mTextContainer:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 63
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/MessageAttachmentTile;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 66
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/MessageAttachmentTile;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 67
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 70
    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/AttachmentTile;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 72
    new-instance v0, Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-direct {v0, p1, p0}, Lcom/android/mail/browse/AttachmentActionHandler;-><init>(Landroid/content/Context;Lcom/android/mail/browse/AttachmentViewInterface;)V

    iput-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    .line 73
    return-void
.end method

.method public static inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/android/mail/browse/MessageAttachmentTile;
    .locals 3
    .param p0, "inflater"    # Landroid/view/LayoutInflater;
    .param p1, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 97
    const v1, 0x7f040027

    const/4 v2, 0x0

    invoke-virtual {p0, v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/MessageAttachmentTile;

    .line 99
    .local v0, "view":Lcom/android/mail/browse/MessageAttachmentTile;
    return-object v0
.end method

.method private onClick(ILandroid/view/View;)Z
    .locals 1
    .param p1, "res"    # I
    .param p2, "v"    # Landroid/view/View;

    .prologue
    .line 119
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v0}, Lcom/android/mail/browse/AttachmentActionHandler;->showAndDownloadAttachments()V

    .line 121
    const/4 v0, 0x1

    return v0
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
    .line 181
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentTile;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/AttachmentTileGrid;

    invoke-virtual {v0}, Lcom/android/mail/ui/AttachmentTileGrid;->getAttachments()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public initialize(Landroid/app/FragmentManager;)V
    .locals 1
    .param p1, "fragmentManager"    # Landroid/app/FragmentManager;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/AttachmentActionHandler;->initialize(Landroid/app/FragmentManager;)V

    .line 77
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 115
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    invoke-direct {p0, v0, p1}, Lcom/android/mail/browse/MessageAttachmentTile;->onClick(ILandroid/view/View;)Z

    .line 116
    return-void
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 105
    invoke-super {p0}, Lcom/android/mail/ui/AttachmentTile;->onFinishInflate()V

    .line 107
    const v0, 0x7f100072

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageAttachmentTile;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mTextContainer:Landroid/view/View;

    .line 108
    const v0, 0x7f10006e

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageAttachmentTile;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mProgress:Landroid/widget/ProgressBar;

    .line 110
    invoke-virtual {p0, p0}, Lcom/android/mail/browse/MessageAttachmentTile;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 111
    return-void
.end method

.method public onUpdateStatus()V
    .locals 0

    .prologue
    .line 165
    return-void
.end method

.method public render(Lcom/android/mail/providers/Attachment;Landroid/net/Uri;ILcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;Z)V
    .locals 2
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;
    .param p2, "attachmentsListUri"    # Landroid/net/Uri;
    .param p3, "index"    # I
    .param p4, "attachmentPreviewCache"    # Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;
    .param p5, "loaderResult"    # Z

    .prologue
    .line 87
    invoke-super/range {p0 .. p5}, Lcom/android/mail/ui/AttachmentTile;->render(Lcom/android/mail/providers/Attachment;Landroid/net/Uri;ILcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;Z)V

    .line 89
    iput-object p2, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mAttachmentsListUri:Landroid/net/Uri;

    .line 90
    iput p3, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mPhotoIndex:I

    .line 92
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/AttachmentActionHandler;->setAttachment(Lcom/android/mail/providers/Attachment;)V

    .line 93
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mActionHandler:Lcom/android/mail/browse/AttachmentActionHandler;

    invoke-virtual {v0, p5}, Lcom/android/mail/browse/AttachmentActionHandler;->updateStatus(Z)V

    .line 94
    return-void
.end method

.method public setThumbnail(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "result"    # Landroid/graphics/Bitmap;

    .prologue
    .line 175
    invoke-super {p0, p1}, Lcom/android/mail/ui/AttachmentTile;->setThumbnail(Landroid/graphics/Bitmap;)V

    .line 176
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mTextContainer:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 177
    return-void
.end method

.method public setThumbnailToDefault()V
    .locals 2

    .prologue
    .line 169
    invoke-super {p0}, Lcom/android/mail/ui/AttachmentTile;->setThumbnailToDefault()V

    .line 170
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mTextContainer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 171
    return-void
.end method

.method public updateProgress(Z)V
    .locals 3
    .param p1, "showDeterminateProgress"    # Z

    .prologue
    const/4 v1, 0x0

    .line 153
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->isDownloading()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 154
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mProgress:Landroid/widget/ProgressBar;

    iget-object v2, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v2, v2, Lcom/android/mail/providers/Attachment;->size:I

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setMax(I)V

    .line 155
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mProgress:Landroid/widget/ProgressBar;

    iget-object v2, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v2, v2, Lcom/android/mail/providers/Attachment;->downloadedSize:I

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 156
    iget-object v2, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mProgress:Landroid/widget/ProgressBar;

    if-nez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v2, v0}, Landroid/widget/ProgressBar;->setIndeterminate(Z)V

    .line 157
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 161
    :goto_1
    return-void

    :cond_0
    move v0, v1

    .line 156
    goto :goto_0

    .line 159
    :cond_1
    iget-object v0, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mProgress:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_1
.end method

.method public viewAttachment()V
    .locals 5

    .prologue
    .line 126
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v0, v0, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->normalizeMimeType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/ex/photo/util/ImageUtils;->isImageMimeType(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 127
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentTile;->getContext()Landroid/content/Context;

    move-result-object v0

    const-class v1, Lcom/android/mail/photo/MailPhotoViewActivity;

    invoke-static {v0, v1}, Lcom/android/ex/photo/Intents;->newPhotoViewIntentBuilder(Landroid/content/Context;Ljava/lang/Class;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;

    move-result-object v0

    .line 129
    iget-object v1, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mAttachmentsListUri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->setPhotosUri(Ljava/lang/String;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;

    move-result-object v1

    sget-object v2, Lcom/android/mail/providers/UIProvider;->ATTACHMENT_PROJECTION:[Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->setProjection([Ljava/lang/String;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;

    move-result-object v1

    iget v2, p0, Lcom/android/mail/browse/MessageAttachmentTile;->mPhotoIndex:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->setPhotoIndex(Ljava/lang/Integer;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;

    .line 134
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentTile;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0}, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 149
    :goto_0
    return-void

    .line 138
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 139
    const v1, 0x80001

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 141
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v1, v1, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    iget-object v2, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v2, v2, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/Utils;->setIntentDataAndTypeAndNormalize(Landroid/content/Intent;Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 144
    :try_start_0
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageAttachmentTile;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 145
    :catch_0
    move-exception v0

    .line 147
    sget-object v1, Lcom/android/mail/browse/MessageAttachmentTile;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Coun\'t find Activity for intent"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method
