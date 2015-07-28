.class public Lcom/android/mail/browse/ConversationItemViewCoordinates;
.super Ljava/lang/Object;
.source "ConversationItemViewCoordinates.java"


# static fields
.field private static COLOR_BLOCK_HEIGHT:I

.field private static COLOR_BLOCK_WIDTH:I

.field private static FOLDER_CELL_WIDTH:I

.field private static TOTAL_FOLDER_WIDTH:I

.field private static TOTAL_FOLDER_WIDTH_WIDE:I

.field private static mCache:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/android/mail/browse/ConversationItemViewCoordinates;",
            ">;"
        }
    .end annotation
.end field

.field private static sConversationHeights:[I

.field private static sPaint:Landroid/text/TextPaint;


# instance fields
.field checkmarkX:I

.field checkmarkY:I

.field dateAscent:I

.field dateFontSize:I

.field dateXEnd:I

.field dateY:I

.field foldersAscent:I

.field foldersFontSize:I

.field foldersHeight:I

.field foldersTopPadding:I

.field foldersXEnd:I

.field foldersY:I

.field paperclipY:I

.field personalLevelX:I

.field personalLevelY:I

.field replyStateX:I

.field replyStateY:I

.field sendersAscent:I

.field sendersFontSize:I

.field sendersLineCount:I

.field sendersLineHeight:I

.field sendersView:Landroid/widget/TextView;

.field sendersWidth:I

.field sendersX:I

.field sendersY:I

.field showColorBlock:Z

.field showFolders:Z

.field showPersonalLevel:Z

.field showReplyState:Z

.field starX:I

.field starY:I

.field subjectAscent:I

.field subjectFontSize:I

.field subjectLineCount:I

.field subjectWidth:I

.field subjectX:I

.field subjectY:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v0, -0x1

    .line 47
    sput v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->TOTAL_FOLDER_WIDTH:I

    .line 48
    sput v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->TOTAL_FOLDER_WIDTH_WIDE:I

    .line 49
    sput v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->FOLDER_CELL_WIDTH:I

    .line 53
    sput v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->COLOR_BLOCK_WIDTH:I

    .line 54
    sput v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->COLOR_BLOCK_HEIGHT:I

    .line 116
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    sput-object v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->mCache:Landroid/util/SparseArray;

    .line 119
    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0}, Landroid/text/TextPaint;-><init>()V

    sput-object v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    .line 122
    sget-object v0, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->setAntiAlias(Z)V

    .line 123
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static displaySendersInline(I)Z
    .locals 3
    .param p0, "mode"    # I

    .prologue
    .line 314
    packed-switch p0, :pswitch_data_0

    .line 320
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown conversation header view mode "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 316
    :pswitch_0
    const/4 v0, 0x0

    .line 318
    :goto_0
    return v0

    :pswitch_1
    const/4 v0, 0x1

    goto :goto_0

    .line 314
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static forWidth(Landroid/content/Context;III)Lcom/android/mail/browse/ConversationItemViewCoordinates;
    .locals 22
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "width"    # I
    .param p2, "mode"    # I
    .param p3, "standardScaledDimen"    # I

    .prologue
    .line 330
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->mCache:Landroid/util/SparseArray;

    xor-int v20, p1, p3

    invoke-virtual/range {v19 .. v20}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;

    .line 331
    .local v6, "coordinates":Lcom/android/mail/browse/ConversationItemViewCoordinates;
    if-nez v6, :cond_2

    .line 332
    new-instance v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;

    .end local v6    # "coordinates":Lcom/android/mail/browse/ConversationItemViewCoordinates;
    invoke-direct {v6}, Lcom/android/mail/browse/ConversationItemViewCoordinates;-><init>()V

    .line 333
    .restart local v6    # "coordinates":Lcom/android/mail/browse/ConversationItemViewCoordinates;
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->mCache:Landroid/util/SparseArray;

    xor-int v20, p1, p3

    move-object/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v0, v1, v6}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 336
    move-object/from16 v0, p0

    move/from16 v1, p2

    invoke-static {v0, v1}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getHeight(Landroid/content/Context;I)I

    move-result v9

    .line 337
    .local v9, "height":I
    invoke-static/range {p0 .. p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v19

    invoke-static/range {p2 .. p2}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getLayoutId(I)I

    move-result v20

    const/16 v21, 0x0

    invoke-virtual/range {v19 .. v21}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v17

    .line 338
    .local v17, "view":Landroid/view/View;
    const/high16 v19, 0x40000000    # 2.0f

    move/from16 v0, p1

    move/from16 v1, v19

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v18

    .line 339
    .local v18, "widthSpec":I
    const/high16 v19, 0x40000000    # 2.0f

    move/from16 v0, v19

    invoke-static {v9, v0}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v10

    .line 340
    .local v10, "heightSpec":I
    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v0, v1, v10}, Landroid/view/View;->measure(II)V

    .line 341
    const/16 v19, 0x0

    const/16 v20, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v19

    move/from16 v2, v20

    move/from16 v3, p1

    invoke-virtual {v0, v1, v2, v3, v9}, Landroid/view/View;->layout(IIII)V

    .line 344
    const v19, 0x7f10005f

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 345
    .local v4, "checkmark":Landroid/view/View;
    invoke-static {v4}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getX(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->checkmarkX:I

    .line 346
    invoke-static {v4}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getY(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->checkmarkY:I

    .line 348
    const v19, 0x7f100060

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v15

    .line 349
    .local v15, "star":Landroid/view/View;
    invoke-static {v15}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getX(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->starX:I

    .line 350
    invoke-static {v15}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getY(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->starY:I

    .line 352
    const v19, 0x7f100001

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    .line 353
    .local v12, "personalLevel":Landroid/view/View;
    if-eqz v12, :cond_3

    .line 354
    const/16 v19, 0x1

    move/from16 v0, v19

    iput-boolean v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showPersonalLevel:Z

    .line 355
    invoke-static {v12}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getX(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->personalLevelX:I

    .line 356
    invoke-static {v12}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getY(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->personalLevelY:I

    .line 361
    :goto_0
    const v19, 0x7f10005c

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    .line 362
    .local v14, "senders":Landroid/widget/TextView;
    iput-object v14, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersView:Landroid/widget/TextView;

    .line 363
    invoke-static {v14}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getX(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersX:I

    .line 364
    invoke-static {v14}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getY(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersY:I

    .line 365
    invoke-virtual {v14}, Landroid/widget/TextView;->getWidth()I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersWidth:I

    .line 366
    invoke-static {v14}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getLineCount(Landroid/widget/TextView;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersLineCount:I

    .line 367
    invoke-virtual {v14}, Landroid/widget/TextView;->getLineHeight()I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersLineHeight:I

    .line 368
    invoke-virtual {v14}, Landroid/widget/TextView;->getTextSize()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersFontSize:I

    .line 369
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    iget v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersFontSize:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 370
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    invoke-virtual/range {v19 .. v19}, Landroid/text/TextPaint;->ascent()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sendersAscent:I

    .line 372
    const v19, 0x7f10004b

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v16

    check-cast v16, Landroid/widget/TextView;

    .line 373
    .local v16, "subject":Landroid/widget/TextView;
    invoke-static/range {v16 .. v16}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getX(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectX:I

    .line 374
    invoke-static/range {v16 .. v16}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getY(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectY:I

    .line 375
    invoke-virtual/range {v16 .. v16}, Landroid/widget/TextView;->getWidth()I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectWidth:I

    .line 376
    invoke-static/range {v16 .. v16}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getLineCount(Landroid/widget/TextView;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectLineCount:I

    .line 377
    invoke-virtual/range {v16 .. v16}, Landroid/widget/TextView;->getTextSize()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectFontSize:I

    .line 378
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    iget v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectFontSize:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 379
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    invoke-virtual/range {v19 .. v19}, Landroid/text/TextPaint;->ascent()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->subjectAscent:I

    .line 381
    const v19, 0x7f10002b

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 382
    .local v8, "folders":Landroid/view/View;
    if-eqz v8, :cond_4

    .line 383
    const/16 v19, 0x1

    move/from16 v0, v19

    iput-boolean v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showFolders:Z

    .line 384
    invoke-static {v8}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getX(Landroid/view/View;)I

    move-result v19

    invoke-virtual {v8}, Landroid/view/View;->getWidth()I

    move-result v20

    add-int v19, v19, v20

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersXEnd:I

    .line 385
    invoke-static {v8}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getY(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersY:I

    .line 386
    invoke-virtual {v8}, Landroid/view/View;->getHeight()I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersHeight:I

    .line 387
    invoke-virtual {v8}, Landroid/view/View;->getPaddingTop()I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersTopPadding:I

    .line 388
    instance-of v0, v8, Landroid/widget/TextView;

    move/from16 v19, v0

    if-eqz v19, :cond_0

    .line 389
    check-cast v8, Landroid/widget/TextView;

    .end local v8    # "folders":Landroid/view/View;
    invoke-virtual {v8}, Landroid/widget/TextView;->getTextSize()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersFontSize:I

    .line 390
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    iget v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersFontSize:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 391
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    invoke-virtual/range {v19 .. v19}, Landroid/text/TextPaint;->ascent()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->foldersAscent:I

    .line 397
    :cond_0
    :goto_1
    const v19, 0x7f1000bc

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 398
    .local v5, "colorBlock":Landroid/view/View;
    if-eqz v5, :cond_1

    .line 399
    const/16 v19, 0x1

    move/from16 v0, v19

    iput-boolean v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showColorBlock:Z

    .line 402
    :cond_1
    const v19, 0x7f100002

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    .line 403
    .local v13, "replyState":Landroid/view/View;
    if-eqz v13, :cond_5

    .line 404
    const/16 v19, 0x1

    move/from16 v0, v19

    iput-boolean v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showReplyState:Z

    .line 405
    invoke-static {v13}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getX(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateX:I

    .line 406
    invoke-static {v13}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getY(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->replyStateY:I

    .line 411
    :goto_2
    const v19, 0x7f10005e

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 412
    .local v7, "date":Landroid/widget/TextView;
    invoke-static {v7}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getX(Landroid/view/View;)I

    move-result v19

    invoke-virtual {v7}, Landroid/widget/TextView;->getWidth()I

    move-result v20

    add-int v19, v19, v20

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateXEnd:I

    .line 413
    invoke-static {v7}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getY(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateY:I

    .line 414
    invoke-virtual {v7}, Landroid/widget/TextView;->getTextSize()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateFontSize:I

    .line 415
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    iget v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateFontSize:I

    move/from16 v20, v0

    move/from16 v0, v20

    int-to-float v0, v0

    move/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 416
    sget-object v19, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sPaint:Landroid/text/TextPaint;

    invoke-virtual/range {v19 .. v19}, Landroid/text/TextPaint;->ascent()F

    move-result v19

    move/from16 v0, v19

    float-to-int v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->dateAscent:I

    .line 418
    const v19, 0x7f10005d

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    .line 419
    .local v11, "paperclip":Landroid/view/View;
    invoke-static {v11}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getY(Landroid/view/View;)I

    move-result v19

    move/from16 v0, v19

    iput v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->paperclipY:I

    .line 421
    .end local v4    # "checkmark":Landroid/view/View;
    .end local v5    # "colorBlock":Landroid/view/View;
    .end local v7    # "date":Landroid/widget/TextView;
    .end local v9    # "height":I
    .end local v10    # "heightSpec":I
    .end local v11    # "paperclip":Landroid/view/View;
    .end local v12    # "personalLevel":Landroid/view/View;
    .end local v13    # "replyState":Landroid/view/View;
    .end local v14    # "senders":Landroid/widget/TextView;
    .end local v15    # "star":Landroid/view/View;
    .end local v16    # "subject":Landroid/widget/TextView;
    .end local v17    # "view":Landroid/view/View;
    .end local v18    # "widthSpec":I
    :cond_2
    return-object v6

    .line 358
    .restart local v4    # "checkmark":Landroid/view/View;
    .restart local v9    # "height":I
    .restart local v10    # "heightSpec":I
    .restart local v12    # "personalLevel":Landroid/view/View;
    .restart local v15    # "star":Landroid/view/View;
    .restart local v17    # "view":Landroid/view/View;
    .restart local v18    # "widthSpec":I
    :cond_3
    const/16 v19, 0x0

    move/from16 v0, v19

    iput-boolean v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showPersonalLevel:Z

    goto/16 :goto_0

    .line 394
    .restart local v8    # "folders":Landroid/view/View;
    .restart local v14    # "senders":Landroid/widget/TextView;
    .restart local v16    # "subject":Landroid/widget/TextView;
    :cond_4
    const/16 v19, 0x0

    move/from16 v0, v19

    iput-boolean v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showFolders:Z

    goto/16 :goto_1

    .line 408
    .end local v8    # "folders":Landroid/view/View;
    .restart local v5    # "colorBlock":Landroid/view/View;
    .restart local v13    # "replyState":Landroid/view/View;
    :cond_5
    const/16 v19, 0x0

    move/from16 v0, v19

    iput-boolean v0, v6, Lcom/android/mail/browse/ConversationItemViewCoordinates;->showReplyState:Z

    goto :goto_2
.end method

.method public static getColorBlockHeight(Landroid/content/Context;)I
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 270
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 271
    .local v0, "res":Landroid/content/res/Resources;
    sget v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->COLOR_BLOCK_HEIGHT:I

    if-gtz v1, :cond_0

    .line 272
    const v1, 0x7f0b001c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->COLOR_BLOCK_HEIGHT:I

    .line 274
    :cond_0
    sget v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->COLOR_BLOCK_HEIGHT:I

    return v1
.end method

.method public static getColorBlockWidth(Landroid/content/Context;)I
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 262
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 263
    .local v0, "res":Landroid/content/res/Resources;
    sget v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->COLOR_BLOCK_WIDTH:I

    if-gtz v1, :cond_0

    .line 264
    const v1, 0x7f0b001b

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->COLOR_BLOCK_WIDTH:I

    .line 266
    :cond_0
    sget v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->COLOR_BLOCK_WIDTH:I

    return v1
.end method

.method public static getDensityDependentArray([IF)[I
    .locals 3
    .param p0, "values"    # [I
    .param p1, "density"    # F

    .prologue
    .line 175
    array-length v2, p0

    new-array v1, v2, [I

    .line 176
    .local v1, "result":[I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v2, p0

    if-ge v0, v2, :cond_0

    .line 177
    aget v2, p0, v0

    int-to-float v2, v2

    mul-float/2addr v2, p1

    float-to-int v2, v2

    aput v2, v1, v0

    .line 176
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 179
    :cond_0
    return-object v1
.end method

.method public static getFolderCellWidth(Landroid/content/Context;II)I
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "mode"    # I
    .param p2, "foldersCount"    # I

    .prologue
    .line 429
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 430
    .local v0, "res":Landroid/content/res/Resources;
    sget v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->FOLDER_CELL_WIDTH:I

    if-gtz v1, :cond_0

    .line 431
    const v1, 0x7f0b0028

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->FOLDER_CELL_WIDTH:I

    .line 433
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 438
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown conversation header view mode "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 436
    :pswitch_0
    sget v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->FOLDER_CELL_WIDTH:I

    return v1

    .line 433
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public static getFoldersWidth(Landroid/content/Context;I)I
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "mode"    # I

    .prologue
    .line 281
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 282
    .local v0, "res":Landroid/content/res/Resources;
    sget v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->TOTAL_FOLDER_WIDTH:I

    if-gtz v1, :cond_0

    .line 283
    const v1, 0x7f0b0019

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->TOTAL_FOLDER_WIDTH:I

    .line 284
    const v1, 0x7f0b001a

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    sput v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->TOTAL_FOLDER_WIDTH_WIDE:I

    .line 286
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 292
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown conversation header view mode "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 288
    :pswitch_0
    sget v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->TOTAL_FOLDER_WIDTH_WIDE:I

    .line 290
    :goto_0
    return v1

    :pswitch_1
    sget v1, Lcom/android/mail/browse/ConversationItemViewCoordinates;->TOTAL_FOLDER_WIDTH:I

    goto :goto_0

    .line 286
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static getHeight(Landroid/content/Context;I)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "mode"    # I

    .prologue
    .line 186
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 187
    .local v1, "res":Landroid/content/res/Resources;
    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v0, v2, Landroid/util/DisplayMetrics;->scaledDensity:F

    .line 188
    .local v0, "density":F
    sget-object v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sConversationHeights:[I

    if-nez v2, :cond_0

    .line 189
    const/high16 v2, 0x7f0e0000

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v2

    invoke-static {v2, v0}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getDensityDependentArray([IF)[I

    move-result-object v2

    sput-object v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sConversationHeights:[I

    .line 192
    :cond_0
    sget-object v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sConversationHeights:[I

    aget v2, v2, p1

    return v2
.end method

.method private static getLayoutId(I)I
    .locals 3
    .param p0, "mode"    # I

    .prologue
    .line 161
    packed-switch p0, :pswitch_data_0

    .line 167
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown conversation header view mode "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 163
    :pswitch_0
    const v0, 0x7f040020

    .line 165
    :goto_0
    return v0

    :pswitch_1
    const v0, 0x7f04001f

    goto :goto_0

    .line 161
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private static getLineCount(Landroid/widget/TextView;)I
    .locals 2
    .param p0, "textView"    # Landroid/widget/TextView;

    .prologue
    .line 235
    invoke-virtual {p0}, Landroid/widget/TextView;->getHeight()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual {p0}, Landroid/widget/TextView;->getLineHeight()I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    return v0
.end method

.method public static getMinHeight(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "viewMode"    # Lcom/android/mail/ui/ViewMode;

    .prologue
    .line 447
    invoke-static {p0, p1}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMode(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I

    move-result v0

    .line 448
    .local v0, "mode":I
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    if-nez v0, :cond_0

    const v1, 0x7f0b0055

    :goto_0
    invoke-virtual {v2, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    return v1

    :cond_0
    const v1, 0x7f0b0054

    goto :goto_0
.end method

.method public static getMode(Landroid/content/Context;I)I
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "viewMode"    # I

    .prologue
    .line 137
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 138
    .local v0, "res":Landroid/content/res/Resources;
    packed-switch p1, :pswitch_data_0

    .line 146
    :pswitch_0
    const v1, 0x7f0a0014

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    :goto_0
    return v1

    .line 140
    :pswitch_1
    const v1, 0x7f0a0013

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    goto :goto_0

    .line 143
    :pswitch_2
    const v1, 0x7f0a0015

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    goto :goto_0

    .line 138
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public static getMode(Landroid/content/Context;Lcom/android/mail/ui/ViewMode;)I
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "viewMode"    # Lcom/android/mail/ui/ViewMode;

    .prologue
    .line 154
    invoke-virtual {p1}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    invoke-static {p0, v0}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getMode(Landroid/content/Context;I)I

    move-result v0

    return v0
.end method

.method public static getSubjectLength(Landroid/content/Context;IZZ)I
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "mode"    # I
    .param p2, "hasVisibleFolders"    # Z
    .param p3, "hasAttachments"    # Z

    .prologue
    .line 243
    if-eqz p2, :cond_1

    .line 244
    if-eqz p3, :cond_0

    .line 245
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e0001

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v0

    aget v0, v0, p1

    .line 256
    :goto_0
    return v0

    .line 248
    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e0002

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v0

    aget v0, v0, p1

    goto :goto_0

    .line 252
    :cond_1
    if-eqz p3, :cond_2

    .line 253
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e0003

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v0

    aget v0, v0, p1

    goto :goto_0

    .line 256
    :cond_2
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e0004

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v0

    aget v0, v0, p1

    goto :goto_0
.end method

.method private static getX(Landroid/view/View;)I
    .locals 3
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 209
    const/4 v1, 0x0

    .line 210
    .local v1, "x":I
    :goto_0
    if-eqz p0, :cond_1

    .line 211
    invoke-virtual {p0}, Landroid/view/View;->getX()F

    move-result v2

    float-to-int v2, v2

    add-int/2addr v1, v2

    .line 212
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 213
    .local v0, "parent":Landroid/view/ViewParent;
    if-eqz v0, :cond_0

    check-cast v0, Landroid/view/View;

    .end local v0    # "parent":Landroid/view/ViewParent;
    move-object p0, v0

    .line 214
    :goto_1
    goto :goto_0

    .line 213
    .restart local v0    # "parent":Landroid/view/ViewParent;
    :cond_0
    const/4 p0, 0x0

    goto :goto_1

    .line 215
    .end local v0    # "parent":Landroid/view/ViewParent;
    :cond_1
    return v1
.end method

.method private static getY(Landroid/view/View;)I
    .locals 3
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 222
    const/4 v1, 0x0

    .line 223
    .local v1, "y":I
    :goto_0
    if-eqz p0, :cond_1

    .line 224
    invoke-virtual {p0}, Landroid/view/View;->getY()F

    move-result v2

    float-to-int v2, v2

    add-int/2addr v1, v2

    .line 225
    invoke-virtual {p0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 226
    .local v0, "parent":Landroid/view/ViewParent;
    if-eqz v0, :cond_0

    check-cast v0, Landroid/view/View;

    .end local v0    # "parent":Landroid/view/ViewParent;
    move-object p0, v0

    .line 227
    :goto_1
    goto :goto_0

    .line 226
    .restart local v0    # "parent":Landroid/view/ViewParent;
    :cond_0
    const/4 p0, 0x0

    goto :goto_1

    .line 228
    .end local v0    # "parent":Landroid/view/ViewParent;
    :cond_1
    return v1
.end method

.method public static isWideMode(I)Z
    .locals 1
    .param p0, "mode"    # I

    .prologue
    .line 443
    if-nez p0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static refreshConversationHeights(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 199
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 200
    .local v1, "res":Landroid/content/res/Resources;
    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v0, v2, Landroid/util/DisplayMetrics;->scaledDensity:F

    .line 201
    .local v0, "density":F
    const/high16 v2, 0x7f0e0000

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v2

    invoke-static {v2, v0}, Lcom/android/mail/browse/ConversationItemViewCoordinates;->getDensityDependentArray([IF)[I

    move-result-object v2

    sput-object v2, Lcom/android/mail/browse/ConversationItemViewCoordinates;->sConversationHeights:[I

    .line 203
    return-void
.end method

.method public static showAttachmentBackground(I)Z
    .locals 1
    .param p0, "mode"    # I

    .prologue
    .line 130
    if-eqz p0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
