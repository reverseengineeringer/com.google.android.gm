.class public Lcom/android/mail/ui/AttachmentTileGrid;
.super Landroid/widget/FrameLayout;
.source "AttachmentTileGrid.java"

# interfaces
.implements Lcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;


# instance fields
.field private mAttachmentPreviews:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;",
            ">;"
        }
    .end annotation
.end field

.field private mAttachments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;"
        }
    .end annotation
.end field

.field private mAttachmentsListUri:Landroid/net/Uri;

.field private mColumnCount:I

.field private mFragmentManager:Landroid/app/FragmentManager;

.field private mInflater:Landroid/view/LayoutInflater;

.field private final mTileMinSize:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 57
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mInflater:Landroid/view/LayoutInflater;

    .line 58
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b005d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mTileMinSize:I

    .line 60
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mAttachmentPreviews:Ljava/util/HashMap;

    .line 61
    return-void
.end method

.method private addMessageTileFromAttachment(Lcom/android/mail/providers/Attachment;IZ)V
    .locals 6
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;
    .param p2, "index"    # I
    .param p3, "loaderResult"    # Z

    .prologue
    .line 82
    invoke-virtual {p0}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildCount()I

    move-result v1

    if-gt v1, p2, :cond_0

    .line 83
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mInflater:Landroid/view/LayoutInflater;

    invoke-static {v1, p0}, Lcom/android/mail/browse/MessageAttachmentTile;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/android/mail/browse/MessageAttachmentTile;

    move-result-object v0

    .line 84
    .local v0, "attachmentTile":Lcom/android/mail/browse/MessageAttachmentTile;
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/MessageAttachmentTile;->initialize(Landroid/app/FragmentManager;)V

    .line 85
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AttachmentTileGrid;->addView(Landroid/view/View;)V

    .line 90
    :goto_0
    iget-object v2, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mAttachmentsListUri:Landroid/net/Uri;

    move-object v1, p1

    move v3, p2

    move-object v4, p0

    move v5, p3

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/browse/MessageAttachmentTile;->render(Lcom/android/mail/providers/Attachment;Landroid/net/Uri;ILcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;Z)V

    .line 91
    return-void

    .line 87
    .end local v0    # "attachmentTile":Lcom/android/mail/browse/MessageAttachmentTile;
    :cond_0
    invoke-virtual {p0, p2}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/MessageAttachmentTile;

    .restart local v0    # "attachmentTile":Lcom/android/mail/browse/MessageAttachmentTile;
    goto :goto_0
.end method

.method private onLayoutForTiles()V
    .locals 10

    .prologue
    .line 165
    invoke-virtual {p0}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildCount()I

    move-result v5

    .line 166
    .local v5, "count":I
    const/4 v2, 0x0

    .line 167
    .local v2, "childLeft":I
    const/4 v3, 0x0

    .line 168
    .local v3, "childTop":I
    const/4 v7, 0x1

    .line 171
    .local v7, "skipBeginningOfRowFirstTime":Z
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    if-ge v6, v5, :cond_1

    .line 172
    invoke-virtual {p0, v6}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 175
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v4

    .line 176
    .local v4, "childWidth":I
    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v1

    .line 181
    .local v1, "childHeight":I
    if-nez v7, :cond_0

    iget v8, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mColumnCount:I

    rem-int v8, v6, v8

    if-nez v8, :cond_0

    .line 182
    const/4 v2, 0x0

    .line 183
    add-int/2addr v3, v1

    .line 188
    :goto_1
    add-int v8, v2, v4

    add-int v9, v3, v1

    invoke-virtual {v0, v2, v3, v8, v9}, Landroid/view/View;->layout(IIII)V

    .line 190
    add-int/2addr v2, v4

    .line 171
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 185
    :cond_0
    const/4 v7, 0x0

    goto :goto_1

    .line 192
    .end local v0    # "child":Landroid/view/View;
    .end local v1    # "childHeight":I
    .end local v4    # "childWidth":I
    :cond_1
    return-void
.end method

.method private onMeasureForTiles(I)V
    .locals 13
    .param p1, "widthMeasureSpec"    # I

    .prologue
    const/high16 v12, 0x40000000    # 2.0f

    const/4 v9, 0x1

    const/4 v10, 0x0

    .line 109
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v7

    .line 111
    .local v7, "width":I
    invoke-virtual {p0}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildCount()I

    move-result v1

    .line 112
    .local v1, "childCount":I
    if-nez v1, :cond_0

    .line 114
    invoke-virtual {p0, v7, v10}, Lcom/android/mail/ui/AttachmentTileGrid;->setMeasuredDimension(II)V

    .line 157
    :goto_0
    return-void

    .line 121
    :cond_0
    iget v8, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mTileMinSize:I

    div-int v8, v7, v8

    iput v8, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mColumnCount:I

    .line 124
    iget v8, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mColumnCount:I

    if-nez v8, :cond_1

    .line 125
    iput v9, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mColumnCount:I

    .line 139
    :cond_1
    iget v8, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mColumnCount:I

    div-int v4, v7, v8

    .line 140
    .local v4, "imageSize":I
    iget v8, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mColumnCount:I

    mul-int/2addr v8, v4

    sub-int v6, v7, v8

    .line 142
    .local v6, "remainder":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    if-ge v3, v1, :cond_3

    .line 143
    invoke-virtual {p0, v3}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 145
    .local v0, "child":Landroid/view/View;
    if-ge v3, v6, :cond_2

    move v8, v9

    :goto_2
    add-int v2, v4, v8

    .line 146
    .local v2, "childWidth":I
    invoke-static {v2, v12}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v8

    invoke-static {v4, v12}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v11

    invoke-virtual {v0, v8, v11}, Landroid/view/View;->measure(II)V

    .line 142
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .end local v2    # "childWidth":I
    :cond_2
    move v8, v10

    .line 145
    goto :goto_2

    .line 154
    .end local v0    # "child":Landroid/view/View;
    :cond_3
    add-int/lit8 v8, v1, -0x1

    iget v9, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mColumnCount:I

    div-int/2addr v8, v9

    add-int/lit8 v5, v8, 0x1

    .line 155
    .local v5, "numRows":I
    invoke-virtual {p0, v10}, Lcom/android/mail/ui/AttachmentTileGrid;->getChildAt(I)Landroid/view/View;

    move-result-object v8

    invoke-virtual {v8}, Landroid/view/View;->getPaddingBottom()I

    move-result v8

    add-int/2addr v8, v4

    mul-int/2addr v8, v5

    invoke-virtual {p0, v7, v8}, Lcom/android/mail/ui/AttachmentTileGrid;->setMeasuredDimension(II)V

    goto :goto_0
.end method


# virtual methods
.method public addComposeTileFromAttachment(Lcom/android/mail/providers/Attachment;)Lcom/android/mail/compose/ComposeAttachmentTile;
    .locals 6
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 94
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mInflater:Landroid/view/LayoutInflater;

    invoke-static {v1, p0}, Lcom/android/mail/compose/ComposeAttachmentTile;->inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/android/mail/compose/ComposeAttachmentTile;

    move-result-object v0

    .line 97
    .local v0, "attachmentTile":Lcom/android/mail/compose/ComposeAttachmentTile;
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AttachmentTileGrid;->addView(Landroid/view/View;)V

    .line 98
    const/4 v2, 0x0

    const/4 v3, -0x1

    const/4 v5, 0x0

    move-object v1, p1

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/compose/ComposeAttachmentTile;->render(Lcom/android/mail/providers/Attachment;Landroid/net/Uri;ILcom/android/mail/ui/AttachmentTile$AttachmentPreviewCache;Z)V

    .line 100
    return-object v0
.end method

.method public configureGrid(Landroid/app/FragmentManager;Landroid/net/Uri;Ljava/util/List;Z)V
    .locals 5
    .param p1, "fragmentManager"    # Landroid/app/FragmentManager;
    .param p2, "attachmentsListUri"    # Landroid/net/Uri;
    .param p4, "loaderResult"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/FragmentManager;",
            "Landroid/net/Uri;",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 68
    .local p3, "list":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    iput-object p1, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mFragmentManager:Landroid/app/FragmentManager;

    .line 69
    iput-object p2, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mAttachmentsListUri:Landroid/net/Uri;

    .line 70
    iput-object p3, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mAttachments:Ljava/util/List;

    .line 72
    const/4 v2, 0x0

    .line 73
    .local v2, "index":I
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 74
    .local v0, "attachment":Lcom/android/mail/providers/Attachment;
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "index":I
    .local v3, "index":I
    invoke-direct {p0, v0, v2, p4}, Lcom/android/mail/ui/AttachmentTileGrid;->addMessageTileFromAttachment(Lcom/android/mail/providers/Attachment;IZ)V

    move v2, v3

    .end local v3    # "index":I
    .restart local v2    # "index":I
    goto :goto_0

    .line 76
    .end local v0    # "attachment":Lcom/android/mail/providers/Attachment;
    :cond_0
    return-void
.end method

.method public get(Lcom/android/mail/providers/Attachment;)Landroid/graphics/Bitmap;
    .locals 3
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 235
    invoke-static {p1}, Lcom/android/mail/utils/AttachmentUtils;->getIdentifier(Lcom/android/mail/providers/Attachment;)Ljava/lang/String;

    move-result-object v0

    .line 236
    .local v0, "attachmentIdentifier":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 237
    iget-object v2, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mAttachmentPreviews:Ljava/util/HashMap;

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;

    .line 239
    .local v1, "attachmentPreview":Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;
    if-eqz v1, :cond_0

    .line 240
    iget-object v2, v1, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;->preview:Landroid/graphics/Bitmap;

    .line 243
    .end local v1    # "attachmentPreview":Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
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
    .line 207
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mAttachmentPreviews:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-static {v0}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

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
    .line 203
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mAttachments:Ljava/util/List;

    return-object v0
.end method

.method protected onLayout(ZIIII)V
    .locals 0
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 161
    invoke-direct {p0}, Lcom/android/mail/ui/AttachmentTileGrid;->onLayoutForTiles()V

    .line 162
    return-void
.end method

.method protected onMeasure(II)V
    .locals 0
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 105
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AttachmentTileGrid;->onMeasureForTiles(I)V

    .line 106
    return-void
.end method

.method public sendAccessibilityEvent(I)V
    .locals 0
    .param p1, "eventType"    # I

    .prologue
    .line 200
    return-void
.end method

.method public set(Lcom/android/mail/providers/Attachment;Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;
    .param p2, "preview"    # Landroid/graphics/Bitmap;

    .prologue
    .line 223
    invoke-static {p1}, Lcom/android/mail/utils/AttachmentUtils;->getIdentifier(Lcom/android/mail/providers/Attachment;)Ljava/lang/String;

    move-result-object v0

    .line 224
    .local v0, "attachmentIdentifier":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 225
    iget-object v1, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mAttachmentPreviews:Ljava/util/HashMap;

    new-instance v2, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;

    invoke-direct {v2, p1, p2}, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;-><init>(Lcom/android/mail/providers/Attachment;Landroid/graphics/Bitmap;)V

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 228
    :cond_0
    return-void
.end method

.method public setAttachmentPreviews(Ljava/util/ArrayList;)V
    .locals 4
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
    .line 211
    .local p1, "previews":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;>;"
    if-eqz p1, :cond_0

    .line 212
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;

    .line 213
    .local v1, "preview":Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;
    iget-object v2, p0, Lcom/android/mail/ui/AttachmentTileGrid;->mAttachmentPreviews:Ljava/util/HashMap;

    iget-object v3, v1, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;->attachmentIdentifier:Ljava/lang/String;

    invoke-virtual {v2, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 216
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "preview":Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;
    :cond_0
    return-void
.end method
