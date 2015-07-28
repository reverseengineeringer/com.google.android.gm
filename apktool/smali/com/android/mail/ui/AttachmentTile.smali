.class public Lcom/android/mail/ui/AttachmentTile;
.super Landroid/widget/RelativeLayout;
.source "AttachmentTile.java"

# interfaces
.implements Lcom/android/mail/ui/AttachmentBitmapHolder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/AttachmentTile$1;,
        Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;,
        Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field protected mAttachment:Lcom/android/mail/providers/Attachment;

.field private mAttachmentPreviewCache:Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;

.field private mAttachmentSizeText:Ljava/lang/String;

.field private mDefaultIcon:Landroid/widget/ImageView;

.field private mDefaultThumbnailSet:Z

.field private mDisplayType:Ljava/lang/String;

.field private mIcon:Landroid/widget/ImageView;

.field private mSubtitle:Landroid/widget/TextView;

.field private mThumbnailTask:Lcom/android/mail/ui/ThumbnailLoadTask;

.field private mTitle:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 58
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/AttachmentTile;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 74
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/AttachmentTile;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 75
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 78
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 79
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/AttachmentTile;->mDefaultThumbnailSet:Z

    .line 80
    return-void
.end method

.method public static isTiledAttachment(Lcom/android/mail/providers/Attachment;)Z
    .locals 1
    .param p0, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v0}, Lcom/android/ex/photo/util/ImageUtils;->isImageMimeType(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private updateSubtitleText()V
    .locals 3

    .prologue
    .line 137
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 138
    .local v0, "sb":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachmentSizeText:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 139
    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 140
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mDisplayType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 141
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mSubtitle:Landroid/widget/TextView;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 142
    return-void
.end method


# virtual methods
.method public bitmapSetToDefault()Z
    .locals 1

    .prologue
    .line 224
    iget-boolean v0, p0, Lcom/android/mail/ui/AttachmentTile;->mDefaultThumbnailSet:Z

    return v0
.end method

.method public getResolver()Landroid/content/ContentResolver;
    .locals 1

    .prologue
    .line 219
    invoke-virtual {p0}, Lcom/android/mail/ui/AttachmentTile;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    return-object v0
.end method

.method public getThumbnailHeight()I
    .locals 1

    .prologue
    .line 214
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getHeight()I

    move-result v0

    return v0
.end method

.method public getThumbnailWidth()I
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getWidth()I

    move-result v0

    return v0
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 84
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onFinishInflate()V

    .line 86
    const v0, 0x7f100050

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AttachmentTile;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mTitle:Landroid/widget/TextView;

    .line 87
    const v0, 0x7f100051

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AttachmentTile;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mSubtitle:Landroid/widget/TextView;

    .line 88
    const v0, 0x7f100031

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AttachmentTile;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    .line 89
    const v0, 0x7f100032

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AttachmentTile;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mDefaultIcon:Landroid/widget/ImageView;

    .line 90
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 3
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 94
    invoke-super/range {p0 .. p5}, Landroid/widget/RelativeLayout;->onLayout(ZIIII)V

    .line 96
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mThumbnailTask:Lcom/android/mail/ui/ThumbnailLoadTask;

    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    const/4 v2, 0x0

    invoke-static {v0, p0, v1, v2}, Lcom/android/mail/ui/ThumbnailLoadTask;->setupThumbnailPreview(Lcom/android/mail/ui/ThumbnailLoadTask;Lcom/android/mail/ui/AttachmentBitmapHolder;Lcom/android/mail/providers/Attachment;Lcom/android/mail/providers/Attachment;)V

    .line 97
    return-void
.end method

.method public render(Lcom/android/mail/providers/Attachment;Landroid/net/Uri;ILcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;Z)V
    .locals 7
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;
    .param p2, "attachmentsListUri"    # Landroid/net/Uri;
    .param p3, "index"    # I
    .param p4, "attachmentPreviewCache"    # Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;
    .param p5, "loaderResult"    # Z

    .prologue
    const/4 v6, 0x4

    .line 106
    if-nez p1, :cond_0

    .line 107
    invoke-virtual {p0, v6}, Lcom/android/mail/ui/AttachmentTile;->setVisibility(I)V

    .line 132
    :goto_0
    return-void

    .line 111
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    .line 112
    .local v0, "prevAttachment":Lcom/android/mail/providers/Attachment;
    iput-object p1, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    .line 113
    iput-object p4, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachmentPreviewCache:Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;

    .line 115
    sget-object v1, Lcom/android/mail/ui/AttachmentTile;->LOG_TAG:Ljava/lang/String;

    const-string v2, "got attachment list row: name=%s state/dest=%d/%d dled=%d contentUri=%s MIME=%s"

    const/4 v3, 0x6

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p1, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget v5, p1, Lcom/android/mail/providers/Attachment;->state:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    iget v5, p1, Lcom/android/mail/providers/Attachment;->destination:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x3

    iget v5, p1, Lcom/android/mail/providers/Attachment;->downloadedSize:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    iget-object v4, p1, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    aput-object v4, v3, v6

    const/4 v4, 0x5

    iget-object v5, p1, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 120
    if-eqz v0, :cond_1

    iget-object v1, p1, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    iget-object v2, v0, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 121
    :cond_1
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mTitle:Landroid/widget/TextView;

    iget-object v2, p1, Lcom/android/mail/providers/Attachment;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 124
    :cond_2
    if-eqz v0, :cond_3

    iget v1, p1, Lcom/android/mail/providers/Attachment;->size:I

    iget v2, v0, Lcom/android/mail/providers/Attachment;->size:I

    if-eq v1, v2, :cond_4

    .line 125
    :cond_3
    invoke-virtual {p0}, Lcom/android/mail/ui/AttachmentTile;->getContext()Landroid/content/Context;

    move-result-object v1

    iget v2, p1, Lcom/android/mail/providers/Attachment;->size:I

    int-to-long v2, v2

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/AttachmentUtils;->convertToHumanReadableSize(Landroid/content/Context;J)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachmentSizeText:Ljava/lang/String;

    .line 127
    invoke-virtual {p0}, Lcom/android/mail/ui/AttachmentTile;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, p1}, Lcom/android/mail/utils/AttachmentUtils;->getDisplayType(Landroid/content/Context;Lcom/android/mail/providers/Attachment;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mDisplayType:Ljava/lang/String;

    .line 128
    invoke-direct {p0}, Lcom/android/mail/ui/AttachmentTile;->updateSubtitleText()V

    .line 131
    :cond_4
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mThumbnailTask:Lcom/android/mail/ui/ThumbnailLoadTask;

    invoke-static {v1, p0, p1, v0}, Lcom/android/mail/ui/ThumbnailLoadTask;->setupThumbnailPreview(Lcom/android/mail/ui/ThumbnailLoadTask;Lcom/android/mail/ui/AttachmentBitmapHolder;Lcom/android/mail/providers/Attachment;Lcom/android/mail/providers/Attachment;)V

    goto :goto_0
.end method

.method public setThumbnail(Landroid/graphics/Bitmap;)V
    .locals 14
    .param p1, "result"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v8, 0x1

    const/high16 v13, 0x3f000000    # 0.5f

    const/4 v9, 0x0

    .line 157
    if-nez p1, :cond_0

    .line 205
    :goto_0
    return-void

    .line 162
    :cond_0
    iget-object v10, p0, Lcom/android/mail/ui/AttachmentTile;->mDefaultIcon:Landroid/widget/ImageView;

    const/16 v11, 0x8

    invoke-virtual {v10, v11}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 164
    invoke-virtual {p0}, Lcom/android/mail/ui/AttachmentTile;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f0a002d

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v2

    .line 165
    .local v2, "maxSize":I
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v7

    .line 166
    .local v7, "width":I
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    .line 167
    .local v0, "height":I
    invoke-virtual {p0}, Lcom/android/mail/ui/AttachmentTile;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v10

    iget v10, v10, Landroid/util/DisplayMetrics;->densityDpi:I

    mul-int/2addr v10, v7

    div-int/lit16 v5, v10, 0xa0

    .line 169
    .local v5, "scaledWidth":I
    invoke-virtual {p0}, Lcom/android/mail/ui/AttachmentTile;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v10

    iget v10, v10, Landroid/util/DisplayMetrics;->densityDpi:I

    mul-int/2addr v10, v0

    div-int/lit16 v4, v10, 0xa0

    .line 172
    .local v4, "scaledHeight":I
    int-to-float v10, v7

    int-to-float v11, v0

    div-float/2addr v10, v11

    int-to-float v11, v0

    int-to-float v12, v7

    div-float/2addr v11, v12

    invoke-static {v10, v11}, Ljava/lang/Math;->min(FF)F

    move-result v3

    .line 174
    .local v3, "ratio":F
    if-ge v7, v2, :cond_1

    iget-object v10, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v10}, Landroid/widget/ImageView;->getWidth()I

    move-result v10

    if-ge v5, v10, :cond_1

    if-ge v0, v2, :cond_1

    iget-object v10, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v10}, Landroid/widget/ImageView;->getHeight()I

    move-result v10

    if-lt v4, v10, :cond_3

    :cond_1
    move v1, v8

    .line 176
    .local v1, "large":Z
    :goto_1
    cmpg-float v10, v3, v13

    if-gez v10, :cond_4

    int-to-float v10, v5

    iget-object v11, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v11}, Landroid/widget/ImageView;->getHeight()I

    move-result v11

    int-to-float v11, v11

    mul-float/2addr v11, v13

    cmpl-float v10, v10, v11

    if-ltz v10, :cond_2

    int-to-float v10, v4

    iget-object v11, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v11}, Landroid/widget/ImageView;->getWidth()I

    move-result v11

    int-to-float v11, v11

    mul-float/2addr v11, v13

    cmpl-float v10, v10, v11

    if-gez v10, :cond_4

    :cond_2
    move v6, v8

    .line 183
    .local v6, "skinny":Z
    :goto_2
    sget-object v10, Lcom/android/mail/ui/AttachmentTile;->LOG_TAG:Ljava/lang/String;

    const-string v11, "scaledWidth: %d, scaledHeight: %d, large: %b, skinny: %b"

    const/4 v12, 0x4

    new-array v12, v12, [Ljava/lang/Object;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v12, v9

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v12, v8

    const/4 v8, 0x2

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v13

    aput-object v13, v12, v8

    const/4 v8, 0x3

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v13

    aput-object v13, v12, v8

    invoke-static {v10, v11, v12}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 186
    if-eqz v1, :cond_6

    .line 188
    if-eqz v6, :cond_5

    .line 191
    iget-object v8, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    sget-object v10, Landroid/widget/ImageView$ScaleType;->CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v8, v10}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 202
    :goto_3
    iget-object v8, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v8, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 203
    iget-object v8, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachmentPreviewCache:Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;

    iget-object v10, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-interface {v8, v10, p1}, Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;->set(Lcom/android/mail/providers/Attachment;Landroid/graphics/Bitmap;)V

    .line 204
    iput-boolean v9, p0, Lcom/android/mail/ui/AttachmentTile;->mDefaultThumbnailSet:Z

    goto/16 :goto_0

    .end local v1    # "large":Z
    .end local v6    # "skinny":Z
    :cond_3
    move v1, v9

    .line 174
    goto :goto_1

    .restart local v1    # "large":Z
    :cond_4
    move v6, v9

    .line 176
    goto :goto_2

    .line 195
    .restart local v6    # "skinny":Z
    :cond_5
    iget-object v8, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    sget-object v10, Landroid/widget/ImageView$ScaleType;->CENTER_CROP:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v8, v10}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    goto :goto_3

    .line 199
    :cond_6
    iget-object v8, p0, Lcom/android/mail/ui/AttachmentTile;->mIcon:Landroid/widget/ImageView;

    sget-object v10, Landroid/widget/ImageView$ScaleType;->CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v8, v10}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    goto :goto_3
.end method

.method public setThumbnailToDefault()V
    .locals 3

    .prologue
    .line 146
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachmentPreviewCache:Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;

    iget-object v2, p0, Lcom/android/mail/ui/AttachmentTile;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-interface {v1, v2}, Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;->get(Lcom/android/mail/providers/Attachment;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 147
    .local v0, "cachedPreview":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 148
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AttachmentTile;->setThumbnail(Landroid/graphics/Bitmap;)V

    .line 153
    :goto_0
    return-void

    .line 151
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTile;->mDefaultIcon:Landroid/widget/ImageView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 152
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/android/mail/ui/AttachmentTile;->mDefaultThumbnailSet:Z

    goto :goto_0
.end method
