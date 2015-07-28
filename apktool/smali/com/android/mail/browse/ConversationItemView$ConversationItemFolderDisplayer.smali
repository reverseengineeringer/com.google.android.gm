.class Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;
.super Lcom/android/mail/ui/FolderDisplayer;
.source "ConversationItemView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationItemView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ConversationItemFolderDisplayer"
.end annotation


# instance fields
.field private mFoldersCount:I

.field private mHasMoreFolders:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 204
    invoke-direct {p0, p1}, Lcom/android/mail/ui/FolderDisplayer;-><init>(Landroid/content/Context;)V

    .line 205
    return-void
.end method

.method static synthetic access$300(Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;)I
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

    .prologue
    .line 196
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    return v0
.end method

.method private measureFolders(I)I
    .locals 9
    .param p1, "mode"    # I

    .prologue
    .line 221
    iget-object v7, p0, Lcom/android/mail/ui/FolderDisplayer;->mContext:Landroid/content/Context;

    invoke-static {v7, p1}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getFoldersWidth(Landroid/content/Context;I)I

    move-result v0

    .line 222
    .local v0, "availableSpace":I
    iget-object v7, p0, Lcom/android/mail/ui/FolderDisplayer;->mContext:Landroid/content/Context;

    iget v8, p0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    invoke-static {v7, p1, v8}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getFolderCellWidth(Landroid/content/Context;II)I

    move-result v1

    .line 225
    .local v1, "cellSize":I
    const/4 v5, 0x0

    .line 226
    .local v5, "totalWidth":I
    iget-object v7, p0, Lcom/android/mail/ui/FolderDisplayer;->mFoldersSortedSet:Ljava/util/SortedSet;

    invoke-interface {v7}, Ljava/util/SortedSet;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/providers/Folder;

    .line 227
    .local v2, "f":Lcom/android/mail/providers/Folder;
    iget-object v3, v2, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 228
    .local v3, "folderString":Ljava/lang/String;
    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v7

    invoke-virtual {v7, v3}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v7

    float-to-int v7, v7

    add-int v6, v7, v1

    .line 229
    .local v6, "width":I
    rem-int v7, v6, v1

    if-eqz v7, :cond_1

    .line 230
    rem-int v7, v6, v1

    sub-int v7, v1, v7

    add-int/2addr v6, v7

    .line 232
    :cond_1
    add-int/2addr v5, v6

    .line 233
    if-le v5, v0, :cond_0

    .line 238
    .end local v2    # "f":Lcom/android/mail/providers/Folder;
    .end local v3    # "folderString":Ljava/lang/String;
    .end local v6    # "width":I
    :cond_2
    return v5
.end method


# virtual methods
.method public drawFolders(Landroid/graphics/Canvas;Lcom/android/mail/browse/ConversationItemViewCoordinates;II)V
    .locals 32
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "coordinates"    # Lcom/android/mail/browse/ConversationItemViewCoordinates;
    .param p3, "foldersXEnd"    # I
    .param p4, "mode"    # I

    .prologue
    .line 243
    move-object/from16 v0, p0

    iget v4, v0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    if-nez v4, :cond_1

    .line 315
    :cond_0
    :goto_0
    return-void

    .line 247
    :cond_1
    move/from16 v29, p3

    .line 248
    .local v29, "xEnd":I
    move-object/from16 v0, p2

    iget v4, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersY:I

    move-object/from16 v0, p2

    iget v5, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersAscent:I

    sub-int v31, v4, v5

    .line 249
    .local v31, "y":I
    move-object/from16 v0, p2

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersHeight:I

    move/from16 v19, v0

    .line 250
    .local v19, "height":I
    move-object/from16 v0, p2

    iget v0, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersTopPadding:I

    move/from16 v26, v0

    .line 251
    .local v26, "topPadding":I
    move-object/from16 v0, p2

    iget v11, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersAscent:I

    .line 252
    .local v11, "ascent":I
    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v4

    move-object/from16 v0, p2

    iget v5, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersFontSize:I

    int-to-float v5, v5

    invoke-virtual {v4, v5}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 255
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/ui/FolderDisplayer;->mContext:Landroid/content/Context;

    move/from16 v0, p4

    invoke-static {v4, v0}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getFoldersWidth(Landroid/content/Context;I)I

    move-result v12

    .line 256
    .local v12, "availableSpace":I
    move-object/from16 v0, p0

    iget v4, v0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    div-int v13, v12, v4

    .line 257
    .local v13, "averageWidth":I
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/ui/FolderDisplayer;->mContext:Landroid/content/Context;

    move-object/from16 v0, p0

    iget v5, v0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    move/from16 v0, p4

    invoke-static {v4, v0, v5}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getFolderCellWidth(Landroid/content/Context;II)I

    move-result v15

    .line 261
    .local v15, "cellSize":I
    move-object/from16 v0, p0

    move/from16 v1, p4

    invoke-direct {v0, v1}, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->measureFolders(I)I

    move-result v27

    .line 262
    .local v27, "totalWidth":I
    move/from16 v0, v27

    invoke-static {v12, v0}, Ljava/lang/Math;->min(II)I

    move-result v4

    sub-int v30, v29, v4

    .line 265
    .local v30, "xStart":I
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/android/mail/ui/FolderDisplayer;->mFoldersSortedSet:Ljava/util/SortedSet;

    invoke-interface {v4}, Ljava/util/SortedSet;->iterator()Ljava/util/Iterator;

    move-result-object v20

    .local v20, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/android/mail/providers/Folder;

    .line 266
    .local v16, "f":Lcom/android/mail/providers/Folder;
    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    move-object/from16 v18, v0

    .line 267
    .local v18, "folderString":Ljava/lang/String;
    move-object/from16 v0, p0

    iget v4, v0, Lcom/android/mail/ui/FolderDisplayer;->mDefaultFgColor:I

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/android/mail/providers/Folder;->getForegroundColor(I)I

    move-result v17

    .line 268
    .local v17, "fgColor":I
    move-object/from16 v0, p0

    iget v4, v0, Lcom/android/mail/ui/FolderDisplayer;->mDefaultBgColor:I

    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lcom/android/mail/providers/Folder;->getBackgroundColor(I)I

    move-result v14

    .line 269
    .local v14, "bgColor":I
    move/from16 v28, v15

    .line 270
    .local v28, "width":I
    const/16 v22, 0x0

    .line 271
    .local v22, "labelTooLong":Z
    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v4

    move-object/from16 v0, v18

    invoke-virtual {v4, v0}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v4

    float-to-int v4, v4

    add-int v28, v4, v15

    .line 272
    rem-int v4, v28, v15

    if-eqz v4, :cond_3

    .line 273
    rem-int v4, v28, v15

    sub-int v4, v15, v4

    add-int v28, v28, v4

    .line 275
    :cond_3
    move/from16 v0, v27

    if-le v0, v12, :cond_4

    move/from16 v0, v28

    if-le v0, v13, :cond_4

    .line 276
    move/from16 v28, v13

    .line 277
    const/16 v22, 0x1

    .line 281
    :cond_4
    const/16 v21, 0x0

    .line 286
    .local v21, "isMuted":Z
    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v4

    invoke-virtual {v4, v14}, Landroid/text/TextPaint;->setColor(I)V

    .line 287
    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v4

    sget-object v5, Landroid/graphics/Paint$Style;->FILL_AND_STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v4, v5}, Landroid/text/TextPaint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 288
    move/from16 v0, v30

    int-to-float v4, v0

    add-int v5, v31, v11

    int-to-float v5, v5

    add-int v6, v30, v28

    int-to-float v6, v6

    add-int v7, v31, v11

    add-int v7, v7, v19

    int-to-float v7, v7

    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v8

    move-object/from16 v3, p1

    invoke-virtual/range {v3 .. v8}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 292
    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v4

    move-object/from16 v0, v18

    invoke-virtual {v4, v0}, Landroid/text/TextPaint;->measureText(Ljava/lang/String;)F

    move-result v4

    float-to-int v4, v4

    move/from16 v0, v28

    # invokes: Lcom/android/mail/browse/ConversationItemView;->getPadding(II)I
    invoke-static {v0, v4}, Lcom/android/mail/browse/ConversationItemView;->access$100(II)I

    move-result v23

    .line 293
    .local v23, "padding":I
    if-eqz v22, :cond_5

    .line 294
    new-instance v25, Landroid/text/TextPaint;

    invoke-direct/range {v25 .. v25}, Landroid/text/TextPaint;-><init>()V

    .line 295
    .local v25, "shortPaint":Landroid/text/TextPaint;
    move-object/from16 v0, v25

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setColor(I)V

    .line 296
    move-object/from16 v0, p2

    iget v4, v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersFontSize:I

    int-to-float v4, v4

    move-object/from16 v0, v25

    invoke-virtual {v0, v4}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 297
    div-int/lit8 v23, v15, 0x2

    .line 298
    add-int v4, v30, v28

    sub-int v24, v4, v23

    .line 299
    .local v24, "rightBorder":I
    new-instance v3, Landroid/graphics/LinearGradient;

    sub-int v4, v24, v23

    int-to-float v4, v4

    move/from16 v0, v31

    int-to-float v5, v0

    move/from16 v0, v24

    int-to-float v6, v0

    move/from16 v0, v31

    int-to-float v7, v0

    invoke-static/range {v17 .. v17}, Lcom/android/mail/utils/Utils;->getTransparentColor(I)I

    move-result v9

    sget-object v10, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    move/from16 v8, v17

    invoke-direct/range {v3 .. v10}, Landroid/graphics/LinearGradient;-><init>(FFFFIILandroid/graphics/Shader$TileMode;)V

    .line 301
    .local v3, "shader":Landroid/graphics/Shader;
    move-object/from16 v0, v25

    invoke-virtual {v0, v3}, Landroid/text/TextPaint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    .line 302
    add-int v4, v30, v23

    int-to-float v4, v4

    add-int v5, v31, v26

    int-to-float v5, v5

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    move-object/from16 v2, v25

    invoke-virtual {v0, v1, v4, v5, v2}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 308
    .end local v3    # "shader":Landroid/graphics/Shader;
    .end local v24    # "rightBorder":I
    .end local v25    # "shortPaint":Landroid/text/TextPaint;
    :goto_1
    sub-int v12, v12, v28

    .line 309
    add-int v30, v30, v28

    .line 310
    if-gtz v12, :cond_2

    move-object/from16 v0, p0

    iget-boolean v4, v0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mHasMoreFolders:Z

    if-eqz v4, :cond_2

    .line 311
    # getter for: Lcom/android/mail/browse/ConversationItemView;->MORE_FOLDERS:Landroid/graphics/Bitmap;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$200()Landroid/graphics/Bitmap;

    move-result-object v4

    move/from16 v0, v29

    int-to-float v5, v0

    add-int v6, v31, v11

    int-to-float v6, v6

    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v7

    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v5, v6, v7}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 304
    :cond_5
    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v4

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/text/TextPaint;->setColor(I)V

    .line 305
    add-int v4, v30, v23

    int-to-float v4, v4

    add-int v5, v31, v26

    int-to-float v5, v5

    # getter for: Lcom/android/mail/browse/ConversationItemView;->sFoldersPaint:Landroid/text/TextPaint;
    invoke-static {}, Lcom/android/mail/browse/ConversationItemView;->access$000()Landroid/text/TextPaint;

    move-result-object v6

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v4, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_1
.end method

.method public hasVisibleFolders()Z
    .locals 1

    .prologue
    .line 217
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public loadConversationFolders(Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;)V
    .locals 2
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;
    .param p2, "ignoreFolder"    # Lcom/android/mail/providers/Folder;

    .prologue
    const/4 v1, 0x4

    .line 209
    invoke-super {p0, p1, p2}, Lcom/android/mail/ui/FolderDisplayer;->loadConversationFolders(Lcom/android/mail/providers/Conversation;Lcom/android/mail/providers/Folder;)V

    .line 211
    iget-object v0, p0, Lcom/android/mail/ui/FolderDisplayer;->mFoldersSortedSet:Ljava/util/SortedSet;

    invoke-interface {v0}, Ljava/util/SortedSet;->size()I

    move-result v0

    iput v0, p0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    .line 212
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mHasMoreFolders:Z

    .line 213
    iget v0, p0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    iput v0, p0, Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;->mFoldersCount:I

    .line 214
    return-void

    .line 212
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
