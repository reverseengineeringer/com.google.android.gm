.class public Lcom/google/android/gm/provider/Label;
.super Ljava/lang/Object;
.source "Label.java"


# static fields
.field private static final LABEL_COMPONENT_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

.field private static sLabelRequeryDelayMs:I

.field private static sSystemLabelCache:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation
.end field

.field private static sSystemLabelCacheLock:Ljava/lang/Object;


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private mCanonicalName:Ljava/lang/String;

.field private mColor:Ljava/lang/String;

.field private mCountsInitialized:Z

.field private final mDataSetObservable:Landroid/database/DataSetObservable;

.field private final mFactorySystemLabelMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation
.end field

.field private final mId:J

.field private final mIsHidden:Z

.field private mIsSystemLabel:Z

.field private mLabelCountBehavior:I

.field private mLabelSyncPolicy:I

.field private mLastTouched:J

.field private mName:Ljava/lang/String;

.field private mNumConversations:I

.field private mNumUnreadConversations:I

.field private mSerializedInfo:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 118
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/google/android/gm/provider/Label;->sSystemLabelCacheLock:Ljava/lang/Object;

    .line 129
    const/4 v0, -0x1

    sput v0, Lcom/google/android/gm/provider/Label;->sLabelRequeryDelayMs:I

    .line 144
    const-string v0, "\\^\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/Label;->LABEL_COMPONENT_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZIIJLjava/util/Map;)V
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "id"    # J
    .param p5, "canonicalName"    # Ljava/lang/String;
    .param p6, "name"    # Ljava/lang/String;
    .param p7, "color"    # Ljava/lang/String;
    .param p8, "numConversations"    # I
    .param p9, "numUnreadConversations"    # I
    .param p10, "isHidden"    # Z
    .param p11, "labelCountBehavior"    # I
    .param p12, "labelSyncPolicy"    # I
    .param p13, "lastTouched"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "J",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "IIZIIJ",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 407
    .local p15, "systemLabelNameMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/CharSequence;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 101
    const/4 v1, 0x0

    iput v1, p0, Lcom/google/android/gm/provider/Label;->mLabelCountBehavior:I

    .line 103
    const/4 v1, 0x0

    iput v1, p0, Lcom/google/android/gm/provider/Label;->mLabelSyncPolicy:I

    .line 119
    new-instance v1, Landroid/database/DataSetObservable;

    invoke-direct {v1}, Landroid/database/DataSetObservable;-><init>()V

    iput-object v1, p0, Lcom/google/android/gm/provider/Label;->mDataSetObservable:Landroid/database/DataSetObservable;

    .line 408
    iput-object p2, p0, Lcom/google/android/gm/provider/Label;->mAccount:Ljava/lang/String;

    .line 409
    iput-wide p3, p0, Lcom/google/android/gm/provider/Label;->mId:J

    .line 410
    move/from16 v0, p10

    iput-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mIsHidden:Z

    .line 411
    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/google/android/gm/provider/Label;->mFactorySystemLabelMap:Ljava/util/Map;

    move-object v1, p0

    move-object v2, p1

    move-object/from16 v3, p5

    move-object/from16 v4, p6

    move-object/from16 v5, p7

    move/from16 v6, p8

    move/from16 v7, p9

    move/from16 v8, p11

    move/from16 v9, p12

    move-wide/from16 v10, p13

    .line 413
    invoke-virtual/range {v1 .. v11}, Lcom/google/android/gm/provider/Label;->loadInternal(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIJ)V

    .line 415
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "id"    # J
    .param p5, "canonicalName"    # Ljava/lang/String;
    .param p6, "name"    # Ljava/lang/String;
    .param p7, "color"    # Ljava/lang/String;
    .param p8, "isHidden"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "J",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p9, "systemLabelNameMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/CharSequence;>;"
    const/4 v1, 0x0

    .line 385
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 101
    iput v1, p0, Lcom/google/android/gm/provider/Label;->mLabelCountBehavior:I

    .line 103
    iput v1, p0, Lcom/google/android/gm/provider/Label;->mLabelSyncPolicy:I

    .line 119
    new-instance v0, Landroid/database/DataSetObservable;

    invoke-direct {v0}, Landroid/database/DataSetObservable;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/Label;->mDataSetObservable:Landroid/database/DataSetObservable;

    .line 386
    iput-object p2, p0, Lcom/google/android/gm/provider/Label;->mAccount:Ljava/lang/String;

    .line 387
    iput-wide p3, p0, Lcom/google/android/gm/provider/Label;->mId:J

    .line 388
    iput-object p5, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    .line 389
    invoke-static {p5}, Lcom/google/android/gm/provider/Gmail;->isSystemLabel(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mIsSystemLabel:Z

    .line 390
    iput-object p9, p0, Lcom/google/android/gm/provider/Label;->mFactorySystemLabelMap:Ljava/util/Map;

    .line 392
    iget-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mIsSystemLabel:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    invoke-virtual {p6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 395
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/Label;->getHumanSystemLabelName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/Label;->mName:Ljava/lang/String;

    .line 399
    :goto_0
    iput-object p7, p0, Lcom/google/android/gm/provider/Label;->mColor:Ljava/lang/String;

    .line 400
    iput-boolean v1, p0, Lcom/google/android/gm/provider/Label;->mCountsInitialized:Z

    .line 401
    iput-boolean p8, p0, Lcom/google/android/gm/provider/Label;->mIsHidden:Z

    .line 402
    return-void

    .line 397
    :cond_0
    iput-object p6, p0, Lcom/google/android/gm/provider/Label;->mName:Ljava/lang/String;

    goto :goto_0
.end method

.method public static getBackgroundColor(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    .locals 3
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "canonicalName"    # Ljava/lang/String;
    .param p2, "colorIndex"    # Ljava/lang/String;

    .prologue
    .line 486
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->isSystemLabel(Ljava/lang/String;)Z

    move-result v0

    .line 487
    .local v0, "isSystemLabel":Z
    const-string v2, "^g"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 488
    invoke-static {}, Lcom/google/android/gm/utils/LabelColorUtils;->getMutedColorInts()[I

    move-result-object v1

    .line 493
    .local v1, "labelColors":[I
    :goto_0
    if-eqz v0, :cond_1

    const v2, 0xffffff

    :goto_1
    return v2

    .line 490
    .end local v1    # "labelColors":[I
    :cond_0
    invoke-static {v0, p2}, Lcom/google/android/gm/provider/Label;->getColor(ZLjava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p0}, Lcom/google/android/gm/utils/LabelColorUtils;->getLabelColorInts(Ljava/lang/String;Ljava/lang/String;)[I

    move-result-object v1

    .restart local v1    # "labelColors":[I
    goto :goto_0

    .line 493
    :cond_1
    const/4 v2, 0x0

    aget v2, v1, v2

    goto :goto_1
.end method

.method static getColor(ZLjava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "isSystemLabel"    # Z
    .param p1, "colorIndex"    # Ljava/lang/String;

    .prologue
    .line 471
    if-eqz p0, :cond_0

    const-string p1, "2147483647"

    .end local p1    # "colorIndex":Ljava/lang/String;
    :cond_0
    return-object p1
.end method

.method private getHumanSystemLabelName(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 302
    const/4 v1, 0x0

    .line 305
    .local v1, "humanReadable":Ljava/lang/CharSequence;
    iget-object v2, p0, Lcom/google/android/gm/provider/Label;->mFactorySystemLabelMap:Ljava/util/Map;

    if-eqz v2, :cond_1

    .line 306
    iget-object v2, p0, Lcom/google/android/gm/provider/Label;->mFactorySystemLabelMap:Ljava/util/Map;

    iget-object v3, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "humanReadable":Ljava/lang/CharSequence;
    check-cast v1, Ljava/lang/CharSequence;

    .line 315
    .restart local v1    # "humanReadable":Ljava/lang/CharSequence;
    :cond_0
    :goto_0
    if-nez v1, :cond_2

    iget-object v2, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    :goto_1
    return-object v2

    .line 307
    :cond_1
    if-eqz p1, :cond_0

    .line 309
    sget-object v3, Lcom/google/android/gm/provider/Label;->sSystemLabelCacheLock:Ljava/lang/Object;

    monitor-enter v3

    .line 310
    :try_start_0
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/Label;->initLabelCache(Landroid/content/Context;)V

    .line 311
    sget-object v2, Lcom/google/android/gm/provider/Label;->sSystemLabelCache:Ljava/util/HashMap;

    iget-object v4, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Ljava/lang/CharSequence;

    move-object v1, v0

    .line 312
    monitor-exit v3

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 315
    :cond_2
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_1
.end method

.method static getLabelUri(Ljava/lang/String;Ljava/lang/Long;)Landroid/net/Uri;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "labelId"    # Ljava/lang/Long;

    .prologue
    .line 828
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->getLabelUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 829
    .local v0, "labelUri":Landroid/net/Uri;
    invoke-virtual {p1}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 830
    return-object v0
.end method

.method static getSystemLabelNameMap(Landroid/content/Context;)Ljava/util/Map;
    .locals 1
    .param p0, "c"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation

    .prologue
    .line 319
    const/4 v0, 0x0

    .line 320
    .local v0, "systemLabelNameMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/CharSequence;>;"
    if-eqz p0, :cond_0

    .line 321
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    .line 322
    invoke-static {p0, v0}, Lcom/google/android/gm/provider/Label;->loadSystemLabelNameMap(Landroid/content/Context;Ljava/util/Map;)V

    .line 325
    :cond_0
    return-object v0
.end method

.method public static getTextColor(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    .locals 3
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "canonicalName"    # Ljava/lang/String;
    .param p2, "colorIndex"    # Ljava/lang/String;

    .prologue
    .line 515
    invoke-static {p1}, Lcom/google/android/gm/provider/Gmail;->isSystemLabel(Ljava/lang/String;)Z

    move-result v0

    .line 516
    .local v0, "isSystemLabel":Z
    const-string v2, "^g"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 517
    invoke-static {}, Lcom/google/android/gm/utils/LabelColorUtils;->getMutedColorInts()[I

    move-result-object v1

    .line 522
    .local v1, "labelColors":[I
    :goto_0
    const/4 v2, 0x1

    aget v2, v1, v2

    return v2

    .line 519
    .end local v1    # "labelColors":[I
    :cond_0
    invoke-static {v0, p2}, Lcom/google/android/gm/provider/Label;->getColor(ZLjava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p0}, Lcom/google/android/gm/utils/LabelColorUtils;->getLabelColorInts(Ljava/lang/String;Ljava/lang/String;)[I

    move-result-object v1

    .restart local v1    # "labelColors":[I
    goto :goto_0
.end method

.method private initLabelCache(Landroid/content/Context;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 350
    sget-object v0, Lcom/google/android/gm/provider/Label;->sSystemLabelCache:Ljava/util/HashMap;

    if-nez v0, :cond_0

    .line 351
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/google/android/gm/provider/Label;->sSystemLabelCache:Ljava/util/HashMap;

    .line 354
    :cond_0
    sget-object v0, Lcom/google/android/gm/provider/Label;->sSystemLabelCache:Ljava/util/HashMap;

    invoke-static {p1, v0}, Lcom/google/android/gm/provider/Label;->loadSystemLabelNameMap(Landroid/content/Context;Ljava/util/Map;)V

    .line 355
    return-void
.end method

.method private static loadSystemLabelNameMap(Landroid/content/Context;Ljava/util/Map;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 334
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/CharSequence;>;"
    const-string v0, "^f"

    const v1, 0x7f0c01ba

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 335
    const-string v0, "^^out"

    const v1, 0x7f0c01bb

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 336
    const-string v0, "^i"

    const v1, 0x7f0c01bc

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 337
    const-string v0, "^r"

    const v1, 0x7f0c01bd

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 338
    const-string v0, "^b"

    const v1, 0x7f0c01be

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 339
    const-string v0, "^all"

    const v1, 0x7f0c01bf

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 340
    const-string v0, "^u"

    const v1, 0x7f0c01c0

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 341
    const-string v0, "^k"

    const v1, 0x7f0c01c1

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 342
    const-string v0, "^s"

    const v1, 0x7f0c01c2

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 343
    const-string v0, "^t"

    const v1, 0x7f0c01c3

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 344
    const-string v0, "^g"

    const v1, 0x7f0c01c4

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 345
    const-string v0, "^io_im"

    const v1, 0x7f0c01c5

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 346
    const-string v0, "^iim"

    const v1, 0x7f0c01c6

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 347
    return-void
.end method

.method public static parseJoinedString(Ljava/lang/String;)Lcom/google/android/gm/provider/Label;
    .locals 1
    .param p0, "joinedString"    # Ljava/lang/String;

    .prologue
    .line 160
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/google/android/gm/provider/Label;->parseJoinedString(Ljava/lang/String;Ljava/util/Map;)Lcom/google/android/gm/provider/Label;

    move-result-object v0

    return-object v0
.end method

.method static parseJoinedString(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lcom/google/android/gm/provider/Label;
    .locals 21
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "joinedString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/google/android/gm/provider/Label;",
            ">;)",
            "Lcom/google/android/gm/provider/Label;"
        }
    .end annotation

    .prologue
    .line 238
    .local p2, "systemLabelNameMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/CharSequence;>;"
    .local p3, "cachedLabels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/google/android/gm/provider/Label;>;"
    const-string v3, "^*^"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v18

    .line 239
    .local v18, "indexOf":I
    const-wide/16 v16, -0x1

    .line 240
    .local v16, "id":J
    const/4 v3, -0x1

    move/from16 v0, v18

    if-eq v0, v3, :cond_0

    .line 242
    const/4 v3, 0x0

    :try_start_0
    move-object/from16 v0, p1

    move/from16 v1, v18

    invoke-virtual {v0, v3, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v16

    .line 243
    if-eqz p3, :cond_1

    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, p3

    invoke-interface {v0, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 244
    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, p3

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/provider/Label;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 292
    :goto_0
    return-object v3

    .line 246
    :catch_0
    move-exception v12

    .line 249
    .local v12, "e":Ljava/lang/NumberFormatException;
    const-string v3, "Gmail"

    const-string v4, "Problem parsing labelId: original string: %s"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/16 v19, 0x0

    aput-object p1, v11, v19

    invoke-static {v3, v4, v11}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 250
    const/4 v3, 0x0

    goto :goto_0

    .line 255
    .end local v12    # "e":Ljava/lang/NumberFormatException;
    :cond_0
    const-string v3, "Gmail"

    const-string v4, "Problem parsing labelId: original string: %s"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/16 v19, 0x0

    aput-object p1, v11, v19

    invoke-static {v3, v4, v11}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 256
    const/4 v3, 0x0

    goto :goto_0

    .line 258
    :cond_1
    sget-object v3, Lcom/google/android/gm/provider/Label;->LABEL_COMPONENT_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    move-object/from16 v0, p1

    invoke-static {v0, v3}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v13

    .line 259
    .local v13, "fragments":[Ljava/lang/String;
    array-length v3, v13

    const/4 v4, 0x5

    if-ge v3, v4, :cond_2

    .line 260
    const/4 v3, 0x0

    goto :goto_0

    .line 263
    :cond_2
    const/4 v14, 0x0

    .line 264
    .local v14, "i":I
    const-wide/16 v5, 0x0

    .line 266
    .local v5, "labelId":J
    move-wide/from16 v5, v16

    .line 267
    add-int/lit8 v14, v14, 0x1

    .line 273
    add-int/lit8 v15, v14, 0x1

    .end local v14    # "i":I
    .local v15, "i":I
    aget-object v7, v13, v14

    .line 276
    .local v7, "canonicalName":Ljava/lang/String;
    add-int/lit8 v14, v15, 0x1

    .end local v15    # "i":I
    .restart local v14    # "i":I
    aget-object v8, v13, v15

    .line 277
    .local v8, "labelName":Ljava/lang/String;
    add-int/lit8 v15, v14, 0x1

    .end local v14    # "i":I
    .restart local v15    # "i":I
    aget-object v9, v13, v14

    .line 278
    .local v9, "color":Ljava/lang/String;
    const/4 v10, 0x0

    .line 280
    .local v10, "isHidden":Z
    add-int/lit8 v14, v15, 0x1

    .end local v15    # "i":I
    .restart local v14    # "i":I
    :try_start_1
    aget-object v3, v13, v15

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v3

    if-lez v3, :cond_4

    const/4 v10, 0x1

    .line 287
    :goto_1
    new-instance v2, Lcom/google/android/gm/provider/Label;

    const/4 v3, 0x0

    move-object/from16 v4, p0

    move-object/from16 v11, p2

    invoke-direct/range {v2 .. v11}, Lcom/google/android/gm/provider/Label;-><init>(Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V

    .line 289
    .local v2, "label":Lcom/google/android/gm/provider/Label;
    if-eqz p3, :cond_3

    .line 290
    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, p3

    invoke-interface {v0, v3, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    move-object v3, v2

    .line 292
    goto :goto_0

    .line 280
    .end local v2    # "label":Lcom/google/android/gm/provider/Label;
    :cond_4
    const/4 v10, 0x0

    goto :goto_1

    .line 281
    :catch_1
    move-exception v12

    .line 282
    .restart local v12    # "e":Ljava/lang/NumberFormatException;
    const-string v3, "Gmail"

    const-string v4, "Problem parsing isHidden: %s original string: %s"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/16 v19, 0x0

    invoke-virtual {v12}, Ljava/lang/NumberFormatException;->getMessage()Ljava/lang/String;

    move-result-object v20

    aput-object v20, v11, v19

    const/16 v19, 0x1

    aput-object p1, v11, v19

    invoke-static {v3, v4, v11}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 284
    const/4 v3, 0x0

    goto/16 :goto_0
.end method

.method static parseJoinedString(Ljava/lang/String;Ljava/util/Map;)Lcom/google/android/gm/provider/Label;
    .locals 20
    .param p0, "joinedString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/CharSequence;",
            ">;)",
            "Lcom/google/android/gm/provider/Label;"
        }
    .end annotation

    .prologue
    .line 176
    .local p1, "systemLabelNameMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/CharSequence;>;"
    sget-object v2, Lcom/google/android/gm/provider/Label;->LABEL_COMPONENT_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    move-object/from16 v0, p0

    invoke-static {v0, v2}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v14

    .line 177
    .local v14, "fragments":[Ljava/lang/String;
    array-length v2, v14

    const/4 v10, 0x6

    if-ge v2, v10, :cond_0

    .line 178
    const/4 v1, 0x0

    .line 220
    :goto_0
    return-object v1

    .line 181
    :cond_0
    const/4 v15, 0x0

    .line 182
    .local v15, "i":I
    add-int/lit8 v16, v15, 0x1

    .end local v15    # "i":I
    .local v16, "i":I
    aget-object v13, v14, v15

    .line 184
    .local v13, "encodedAccount":Ljava/lang/String;
    const-wide/16 v4, 0x0

    .line 186
    .local v4, "labelId":J
    add-int/lit8 v15, v16, 0x1

    .end local v16    # "i":I
    .restart local v15    # "i":I
    :try_start_0
    aget-object v2, v14, v16

    invoke-static {v2}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v4

    .line 192
    add-int/lit8 v16, v15, 0x1

    .end local v15    # "i":I
    .restart local v16    # "i":I
    aget-object v6, v14, v15

    .line 193
    .local v6, "canonicalName":Ljava/lang/String;
    add-int/lit8 v15, v16, 0x1

    .end local v16    # "i":I
    .restart local v15    # "i":I
    aget-object v12, v14, v16

    .line 194
    .local v12, "encodeLabelName":Ljava/lang/String;
    const-string v7, ""

    .line 195
    .local v7, "labelName":Ljava/lang/String;
    const-string v3, ""

    .line 196
    .local v3, "account":Ljava/lang/String;
    const-string v8, ""

    .line 197
    .local v8, "color":Ljava/lang/String;
    const/4 v9, 0x0

    .line 200
    .local v9, "isHidden":Z
    :try_start_1
    const-string v2, "UTF-8"

    invoke-static {v12, v2}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v7

    .line 205
    :goto_1
    :try_start_2
    const-string v2, "UTF-8"

    invoke-static {v13, v2}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v3

    .line 210
    add-int/lit8 v16, v15, 0x1

    .end local v15    # "i":I
    .restart local v16    # "i":I
    aget-object v8, v14, v15

    .line 212
    add-int/lit8 v15, v16, 0x1

    .end local v16    # "i":I
    .restart local v15    # "i":I
    :try_start_3
    aget-object v2, v14, v16

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I
    :try_end_3
    .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_3} :catch_3

    move-result v2

    if-lez v2, :cond_1

    const/4 v9, 0x1

    .line 218
    :goto_2
    new-instance v1, Lcom/google/android/gm/provider/Label;

    const/4 v2, 0x0

    move-object/from16 v10, p1

    invoke-direct/range {v1 .. v10}, Lcom/google/android/gm/provider/Label;-><init>(Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V

    .line 220
    .local v1, "label":Lcom/google/android/gm/provider/Label;
    goto :goto_0

    .line 187
    .end local v1    # "label":Lcom/google/android/gm/provider/Label;
    .end local v3    # "account":Ljava/lang/String;
    .end local v6    # "canonicalName":Ljava/lang/String;
    .end local v7    # "labelName":Ljava/lang/String;
    .end local v8    # "color":Ljava/lang/String;
    .end local v9    # "isHidden":Z
    .end local v12    # "encodeLabelName":Ljava/lang/String;
    :catch_0
    move-exception v11

    .line 188
    .local v11, "e":Ljava/lang/NumberFormatException;
    const-string v2, "Gmail"

    const-string v10, "Problem parsing labelId: %s original string: %s"

    const/16 v17, 0x2

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual {v11}, Ljava/lang/NumberFormatException;->getMessage()Ljava/lang/String;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x1

    aput-object p0, v17, v18

    move-object/from16 v0, v17

    invoke-static {v2, v10, v0}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 190
    const/4 v1, 0x0

    goto :goto_0

    .line 201
    .end local v11    # "e":Ljava/lang/NumberFormatException;
    .restart local v3    # "account":Ljava/lang/String;
    .restart local v6    # "canonicalName":Ljava/lang/String;
    .restart local v7    # "labelName":Ljava/lang/String;
    .restart local v8    # "color":Ljava/lang/String;
    .restart local v9    # "isHidden":Z
    .restart local v12    # "encodeLabelName":Ljava/lang/String;
    :catch_1
    move-exception v11

    .line 202
    .local v11, "e":Ljava/lang/IllegalArgumentException;
    :try_start_4
    const-string v2, "Gmail"

    const-string v10, "illegal argument"

    const/16 v17, 0x0

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-static {v2, v11, v10, v0}, Lcom/google/android/gm/provider/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_4
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_4 .. :try_end_4} :catch_2

    .line 203
    move-object v7, v12

    goto :goto_1

    .line 206
    .end local v11    # "e":Ljava/lang/IllegalArgumentException;
    :catch_2
    move-exception v11

    .line 207
    .local v11, "e":Ljava/io/UnsupportedEncodingException;
    const-string v2, "Gmail"

    const-string v10, "unsupported encoding"

    const/16 v17, 0x0

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-static {v2, v11, v10, v0}, Lcom/google/android/gm/provider/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 208
    const/4 v1, 0x0

    goto/16 :goto_0

    .line 212
    .end local v11    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_1
    const/4 v9, 0x0

    goto :goto_2

    .line 213
    :catch_3
    move-exception v11

    .line 214
    .local v11, "e":Ljava/lang/NumberFormatException;
    const-string v2, "Gmail"

    const-string v10, "Problem parsing isHidden: %s original string: %s"

    const/16 v17, 0x2

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual {v11}, Ljava/lang/NumberFormatException;->getMessage()Ljava/lang/String;

    move-result-object v19

    aput-object v19, v17, v18

    const/16 v18, 0x1

    aput-object p0, v17, v18

    move-object/from16 v0, v17

    invoke-static {v2, v10, v0}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 216
    const/4 v1, 0x0

    goto/16 :goto_0
.end method


# virtual methods
.method public declared-synchronized getBackgroundColor()I
    .locals 3

    .prologue
    .line 481
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mAccount:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/android/gm/provider/Label;->mColor:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/Label;->getBackgroundColor(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCanonicalName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 440
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getColor()Ljava/lang/String;
    .locals 2

    .prologue
    .line 461
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Label;->isSystemLabel()Z

    move-result v0

    iget-object v1, p0, Lcom/google/android/gm/provider/Label;->mColor:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/Label;->getColor(ZLjava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDisplayNoConversationCount()Z
    .locals 2

    .prologue
    .line 563
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/google/android/gm/provider/Label;->mLabelCountBehavior:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDisplayTotalConversationCount()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 553
    monitor-enter p0

    :try_start_0
    iget v1, p0, Lcom/google/android/gm/provider/Label;->mLabelCountBehavior:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v1, v0, :cond_0

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getForceSyncAll()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 604
    monitor-enter p0

    :try_start_0
    iget v1, p0, Lcom/google/android/gm/provider/Label;->mLabelSyncPolicy:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v1, v0, :cond_0

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getForceSyncAllOrPartial()Z
    .locals 2

    .prologue
    .line 624
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/google/android/gm/provider/Label;->mLabelSyncPolicy:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getForceSyncNone()Z
    .locals 2

    .prologue
    .line 614
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/google/android/gm/provider/Label;->mLabelSyncPolicy:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    monitor-exit p0

    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getHidden()Z
    .locals 1

    .prologue
    .line 633
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mIsHidden:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getId()J
    .locals 2

    .prologue
    .line 431
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/google/android/gm/provider/Label;->mId:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLastTouched()J
    .locals 2

    .prologue
    .line 638
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/google/android/gm/provider/Label;->mLastTouched:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 449
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mName:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getNumConversations()I
    .locals 2

    .prologue
    .line 572
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mCountsInitialized:Z

    if-nez v0, :cond_0

    .line 573
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "conversation counts were not initialized"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 572
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 575
    :cond_0
    :try_start_1
    iget v0, p0, Lcom/google/android/gm/provider/Label;->mNumConversations:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return v0
.end method

.method public declared-synchronized getNumUnreadConversations()I
    .locals 2

    .prologue
    .line 584
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mCountsInitialized:Z

    if-nez v0, :cond_0

    .line 585
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "unread conversation counts were not initialized"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 584
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 587
    :cond_0
    :try_start_1
    iget v0, p0, Lcom/google/android/gm/provider/Label;->mNumUnreadConversations:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return v0
.end method

.method public declared-synchronized getTextColor()I
    .locals 3

    .prologue
    .line 510
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mAccount:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/android/gm/provider/Label;->mColor:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/Label;->getTextColor(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized isSystemLabel()Z
    .locals 1

    .prologue
    .line 422
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mIsSystemLabel:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method loadInternal(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIJ)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "canonicalName"    # Ljava/lang/String;
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "color"    # Ljava/lang/String;
    .param p5, "numConversations"    # I
    .param p6, "numUnreadConversations"    # I
    .param p7, "labelCountBehavior"    # I
    .param p8, "labelSyncPolicy"    # I
    .param p9, "lastTouched"    # J

    .prologue
    const/4 v1, 0x0

    .line 733
    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 734
    iput-object p2, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    .line 735
    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail;->isSystemLabel(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mIsSystemLabel:Z

    .line 736
    iput-object v1, p0, Lcom/google/android/gm/provider/Label;->mSerializedInfo:Ljava/lang/String;

    .line 738
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mColor:Ljava/lang/String;

    invoke-static {p4, v0}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 739
    iput-object p4, p0, Lcom/google/android/gm/provider/Label;->mColor:Ljava/lang/String;

    .line 740
    iput-object v1, p0, Lcom/google/android/gm/provider/Label;->mSerializedInfo:Ljava/lang/String;

    .line 746
    :cond_1
    iget-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mIsSystemLabel:Z

    if-eqz v0, :cond_3

    if-eqz p3, :cond_2

    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    invoke-virtual {v0, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_2
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/Label;->getHumanSystemLabelName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object p3

    .line 748
    :cond_3
    iget-object v0, p0, Lcom/google/android/gm/provider/Label;->mName:Ljava/lang/String;

    invoke-static {p3, v0}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 749
    iput-object p3, p0, Lcom/google/android/gm/provider/Label;->mName:Ljava/lang/String;

    .line 750
    iput-object v1, p0, Lcom/google/android/gm/provider/Label;->mSerializedInfo:Ljava/lang/String;

    .line 753
    :cond_4
    iput p5, p0, Lcom/google/android/gm/provider/Label;->mNumConversations:I

    .line 754
    iput p6, p0, Lcom/google/android/gm/provider/Label;->mNumUnreadConversations:I

    .line 755
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/Label;->mCountsInitialized:Z

    .line 756
    iput p7, p0, Lcom/google/android/gm/provider/Label;->mLabelCountBehavior:I

    .line 757
    iput p8, p0, Lcom/google/android/gm/provider/Label;->mLabelSyncPolicy:I

    .line 758
    iput-wide p9, p0, Lcom/google/android/gm/provider/Label;->mLastTouched:J

    .line 759
    return-void
.end method

.method public declared-synchronized serialize()Ljava/lang/String;
    .locals 7

    .prologue
    .line 360
    monitor-enter p0

    :try_start_0
    iget-object v4, p0, Lcom/google/android/gm/provider/Label;->mSerializedInfo:Ljava/lang/String;

    if-eqz v4, :cond_0

    .line 361
    iget-object v4, p0, Lcom/google/android/gm/provider/Label;->mSerializedInfo:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 381
    :goto_0
    monitor-exit p0

    return-object v4

    .line 364
    :cond_0
    :try_start_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 365
    .local v3, "result":Ljava/lang/StringBuilder;
    const-string v1, ""

    .line 366
    .local v1, "encodedAccount":Ljava/lang/String;
    const-string v2, ""
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 368
    .local v2, "encodedLabelName":Ljava/lang/String;
    :try_start_2
    iget-object v4, p0, Lcom/google/android/gm/provider/Label;->mAccount:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 369
    iget-object v4, p0, Lcom/google/android/gm/provider/Label;->mName:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    .line 373
    :goto_1
    :try_start_3
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "^*^"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 374
    iget-wide v4, p0, Lcom/google/android/gm/provider/Label;->mId:J

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "^*^"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 375
    iget-object v4, p0, Lcom/google/android/gm/provider/Label;->mCanonicalName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "^*^"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 376
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "^*^"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 377
    iget-object v4, p0, Lcom/google/android/gm/provider/Label;->mColor:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "^*^"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 378
    iget-boolean v4, p0, Lcom/google/android/gm/provider/Label;->mIsHidden:Z

    if-eqz v4, :cond_1

    const-string v4, "1"

    :goto_2
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 379
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/google/android/gm/provider/Label;->mSerializedInfo:Ljava/lang/String;

    .line 381
    iget-object v4, p0, Lcom/google/android/gm/provider/Label;->mSerializedInfo:Ljava/lang/String;

    goto :goto_0

    .line 370
    :catch_0
    move-exception v0

    .line 371
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    const-string v4, "Gmail"

    const-string v5, "unsupported encoding"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v4, v0, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 360
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    .end local v1    # "encodedAccount":Ljava/lang/String;
    .end local v2    # "encodedLabelName":Ljava/lang/String;
    .end local v3    # "result":Ljava/lang/StringBuilder;
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 378
    .restart local v1    # "encodedAccount":Ljava/lang/String;
    .restart local v2    # "encodedLabelName":Ljava/lang/String;
    .restart local v3    # "result":Ljava/lang/StringBuilder;
    :cond_1
    :try_start_4
    const-string v4, "0"
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_2
.end method
