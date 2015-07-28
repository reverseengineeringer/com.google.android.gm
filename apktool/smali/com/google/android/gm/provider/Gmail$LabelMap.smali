.class public final Lcom/google/android/gm/provider/Gmail$LabelMap;
.super Ljava/util/Observable;
.source "Gmail.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/Gmail;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "LabelMap"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/Gmail$LabelMap$LabelsContentQueryMap;
    }
.end annotation


# static fields
.field private static final EMPTY_CONTENT_VALUES:Landroid/content/ContentValues;


# instance fields
.field private mCanonicalNameToId:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private mContentQueryMapPopulated:Z

.field private mLabelIdCached:J

.field private mLabelIdChat:J

.field private mLabelIdDraft:J

.field private mLabelIdIgnored:J

.field private mLabelIdImportantImap:J

.field private mLabelIdInbox:J

.field private mLabelIdMarkImportant:J

.field private mLabelIdMarkUnimportant:J

.field private mLabelIdOutbox:J

.field private mLabelIdSent:J

.field private mLabelIdSpam:J

.field private mLabelIdStarred:J

.field private mLabelIdTrash:J

.field private mLabelIdUnread:J

.field private mLabelsSynced:Ljava/lang/Boolean;

.field private mQueryMap:Landroid/content/ContentQueryMap;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 2193
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    sput-object v0, Lcom/google/android/gm/provider/Gmail$LabelMap;->EMPTY_CONTENT_VALUES:Landroid/content/ContentValues;

    return-void
.end method

.method public constructor <init>(Landroid/content/ContentResolver;Landroid/database/Cursor;Z)V
    .locals 1
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "keepUpdated"    # Z

    .prologue
    .line 2230
    invoke-direct {p0}, Ljava/util/Observable;-><init>()V

    .line 2213
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelsSynced:Ljava/lang/Boolean;

    .line 2217
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mContentQueryMapPopulated:Z

    .line 2231
    invoke-direct {p0, p2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->init(Landroid/database/Cursor;)V

    .line 2232
    return-void
.end method

.method public constructor <init>(Landroid/content/ContentResolver;Ljava/lang/String;)V
    .locals 7
    .param p1, "contentResolver"    # Landroid/content/ContentResolver;
    .param p2, "account"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 2219
    invoke-direct {p0}, Ljava/util/Observable;-><init>()V

    .line 2213
    iput-object v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelsSynced:Ljava/lang/Boolean;

    .line 2217
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mContentQueryMapPopulated:Z

    .line 2220
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2221
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v2, "account is empty"

    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2223
    :cond_0
    invoke-static {p2}, Lcom/google/android/gm/provider/Gmail;->getLabelsUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 2224
    .local v1, "queryUri":Landroid/net/Uri;
    const-string v0, "1"

    invoke-static {v1, v0}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 2225
    sget-object v2, Lcom/google/android/gm/provider/Gmail;->LABEL_PROJECTION:[Ljava/lang/String;

    move-object v0, p1

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 2226
    .local v6, "cursor":Landroid/database/Cursor;
    invoke-direct {p0, v6}, Lcom/google/android/gm/provider/Gmail$LabelMap;->init(Landroid/database/Cursor;)V

    .line 2227
    return-void
.end method

.method static synthetic access$1100(Lcom/google/android/gm/provider/Gmail$LabelMap;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/Gmail$LabelMap;

    .prologue
    .line 2192
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->updateDataStructures()V

    return-void
.end method

.method static synthetic access$1200(Lcom/google/android/gm/provider/Gmail$LabelMap;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/Gmail$LabelMap;

    .prologue
    .line 2192
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->setChanged()V

    return-void
.end method

.method private checkLabelsSynced()V
    .locals 2

    .prologue
    .line 2399
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynced()Z

    move-result v0

    if-nez v0, :cond_0

    .line 2400
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "LabelMap not initalized"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2402
    :cond_0
    return-void
.end method

.method private getLabelIdValues(J)Landroid/content/ContentValues;
    .locals 3
    .param p1, "labelId"    # J

    .prologue
    .line 2459
    iget-boolean v1, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mContentQueryMapPopulated:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mQueryMap:Landroid/content/ContentQueryMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/ContentQueryMap;->getValues(Ljava/lang/String;)Landroid/content/ContentValues;

    move-result-object v0

    .line 2461
    .local v0, "values":Landroid/content/ContentValues;
    :goto_0
    if-eqz v0, :cond_1

    .line 2464
    .end local v0    # "values":Landroid/content/ContentValues;
    :goto_1
    return-object v0

    .line 2459
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 2464
    .restart local v0    # "values":Landroid/content/ContentValues;
    :cond_1
    sget-object v0, Lcom/google/android/gm/provider/Gmail$LabelMap;->EMPTY_CONTENT_VALUES:Landroid/content/ContentValues;

    goto :goto_1
.end method

.method private init(Landroid/database/Cursor;)V
    .locals 2
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 2235
    new-instance v0, Lcom/google/android/gm/provider/Gmail$LabelMap$LabelsContentQueryMap;

    const-string v1, "_id"

    invoke-direct {v0, p1, v1}, Lcom/google/android/gm/provider/Gmail$LabelMap$LabelsContentQueryMap;-><init>(Landroid/database/Cursor;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mQueryMap:Landroid/content/ContentQueryMap;

    .line 2236
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mCanonicalNameToId:Ljava/util/Map;

    .line 2237
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mQueryMap:Landroid/content/ContentQueryMap;

    new-instance v1, Lcom/google/android/gm/provider/Gmail$LabelMap$1;

    invoke-direct {v1, p0}, Lcom/google/android/gm/provider/Gmail$LabelMap$1;-><init>(Lcom/google/android/gm/provider/Gmail$LabelMap;)V

    invoke-virtual {v0, v1}, Landroid/content/ContentQueryMap;->addObserver(Ljava/util/Observer;)V

    .line 2244
    return-void
.end method

.method private declared-synchronized updateDataStructures()V
    .locals 12

    .prologue
    const/4 v7, 0x1

    const-wide/16 v10, 0x0

    .line 2267
    monitor-enter p0

    const/4 v6, 0x1

    :try_start_0
    iput-boolean v6, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mContentQueryMapPopulated:Z

    .line 2269
    iget-object v6, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mCanonicalNameToId:Ljava/util/Map;

    invoke-interface {v6}, Ljava/util/Map;->clear()V

    .line 2271
    iget-object v6, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mQueryMap:Landroid/content/ContentQueryMap;

    invoke-virtual {v6}, Landroid/content/ContentQueryMap;->getRows()Ljava/util/Map;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_10

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 2272
    .local v5, "row":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 2273
    .local v2, "key":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 2277
    invoke-static {v2}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    .line 2278
    .local v3, "labelId":J
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/ContentValues;

    const-string v8, "canonicalName"

    invoke-virtual {v6, v8}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2281
    .local v0, "canonicalName":Ljava/lang/String;
    iget-object v6, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mCanonicalNameToId:Ljava/util/Map;

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-interface {v6, v0, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2283
    const-string v6, "^f"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 2284
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdSent:J

    .line 2313
    :cond_1
    :goto_1
    iget-wide v8, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdSent:J

    cmp-long v6, v8, v10

    if-eqz v6, :cond_f

    iget-wide v8, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdInbox:J

    cmp-long v6, v8, v10

    if-eqz v6, :cond_f

    iget-wide v8, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdDraft:J

    cmp-long v6, v8, v10

    if-eqz v6, :cond_f

    iget-wide v8, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdUnread:J

    cmp-long v6, v8, v10

    if-eqz v6, :cond_f

    iget-wide v8, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdTrash:J

    cmp-long v6, v8, v10

    if-eqz v6, :cond_f

    iget-wide v8, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdSpam:J

    cmp-long v6, v8, v10

    if-eqz v6, :cond_f

    iget-wide v8, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdStarred:J

    cmp-long v6, v8, v10

    if-eqz v6, :cond_f

    iget-wide v8, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdChat:J

    cmp-long v6, v8, v10

    if-eqz v6, :cond_f

    iget-wide v8, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdIgnored:J

    cmp-long v6, v8, v10

    if-eqz v6, :cond_f

    move v6, v7

    :goto_2
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    iput-object v6, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelsSynced:Ljava/lang/Boolean;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 2267
    .end local v0    # "canonicalName":Ljava/lang/String;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "labelId":J
    .end local v5    # "row":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 2285
    .restart local v0    # "canonicalName":Ljava/lang/String;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "key":Ljava/lang/String;
    .restart local v3    # "labelId":J
    .restart local v5    # "row":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    :cond_2
    :try_start_1
    const-string v6, "^i"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 2286
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdInbox:J

    goto :goto_1

    .line 2287
    :cond_3
    const-string v6, "^r"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 2288
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdDraft:J

    goto :goto_1

    .line 2289
    :cond_4
    const-string v6, "^u"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 2290
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdUnread:J

    goto :goto_1

    .line 2291
    :cond_5
    const-string v6, "^k"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 2292
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdTrash:J

    goto :goto_1

    .line 2293
    :cond_6
    const-string v6, "^s"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 2294
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdSpam:J

    goto :goto_1

    .line 2295
    :cond_7
    const-string v6, "^t"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 2296
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdStarred:J

    goto/16 :goto_1

    .line 2297
    :cond_8
    const-string v6, "^b"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 2298
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdChat:J

    goto/16 :goto_1

    .line 2299
    :cond_9
    const-string v6, "^g"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_a

    .line 2300
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdIgnored:J

    goto/16 :goto_1

    .line 2301
    :cond_a
    const-string v6, "^^cached"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_b

    .line 2302
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdCached:J

    goto/16 :goto_1

    .line 2303
    :cond_b
    const-string v6, "^^out"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_c

    .line 2304
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdOutbox:J

    goto/16 :goto_1

    .line 2305
    :cond_c
    const-string v6, "^io_im"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_d

    .line 2306
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdImportantImap:J

    goto/16 :goto_1

    .line 2307
    :cond_d
    const-string v6, "^^important"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_e

    .line 2308
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdMarkImportant:J

    goto/16 :goto_1

    .line 2309
    :cond_e
    const-string v6, "^^unimportant"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 2310
    iput-wide v3, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdMarkUnimportant:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_1

    .line 2313
    :cond_f
    const/4 v6, 0x0

    goto/16 :goto_2

    .line 2323
    .end local v0    # "canonicalName":Ljava/lang/String;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "labelId":J
    .end local v5    # "row":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    :cond_10
    monitor-exit p0

    return-void
.end method


# virtual methods
.method public close()V
    .locals 1

    .prologue
    .line 2474
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mQueryMap:Landroid/content/ContentQueryMap;

    invoke-virtual {v0}, Landroid/content/ContentQueryMap;->close()V

    .line 2475
    return-void
.end method

.method public getCanonicalName(J)Ljava/lang/String;
    .locals 2
    .param p1, "labelId"    # J

    .prologue
    .line 2427
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdValues(J)Landroid/content/ContentValues;

    move-result-object v0

    const-string v1, "canonicalName"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getLabelId(Ljava/lang/String;)J
    .locals 3
    .param p1, "canonicalName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 2443
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelPresent(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2444
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mCanonicalNameToId:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v0

    monitor-exit p0

    return-wide v0

    .line 2446
    :cond_0
    :try_start_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown canonical name: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2443
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdCached()J
    .locals 2

    .prologue
    .line 2375
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2376
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdCached:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2375
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdDraft()J
    .locals 2

    .prologue
    .line 2340
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2341
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdDraft:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2340
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdIgnored()J
    .locals 2

    .prologue
    .line 2370
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2371
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdIgnored:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2370
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdImportantImap()J
    .locals 2

    .prologue
    .line 2394
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2395
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdImportantImap:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2394
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdInbox()J
    .locals 2

    .prologue
    .line 2335
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2336
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdInbox:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2335
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdOutbox()J
    .locals 2

    .prologue
    .line 2380
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2381
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdOutbox:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2380
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdSent()J
    .locals 2

    .prologue
    .line 2330
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2331
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdSent:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2330
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdSpam()J
    .locals 2

    .prologue
    .line 2355
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2356
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdSpam:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2355
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdStarred()J
    .locals 2

    .prologue
    .line 2360
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2361
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdStarred:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2360
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdTrash()J
    .locals 2

    .prologue
    .line 2350
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2351
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdTrash:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2350
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelIdUnread()J
    .locals 2

    .prologue
    .line 2345
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->checkLabelsSynced()V

    .line 2346
    iget-wide v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelIdUnread:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 2345
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getName(J)Ljava/lang/String;
    .locals 2
    .param p1, "labelId"    # J

    .prologue
    .line 2434
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdValues(J)Landroid/content/ContentValues;

    move-result-object v0

    const-string v1, "name"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getNumConversations(J)I
    .locals 2
    .param p1, "labelId"    # J

    .prologue
    .line 2406
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdValues(J)Landroid/content/ContentValues;

    move-result-object v0

    const-string v1, "numConversations"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getNumUnreadConversations(J)I
    .locals 4
    .param p1, "labelId"    # J

    .prologue
    .line 2411
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdValues(J)Landroid/content/ContentValues;

    move-result-object v2

    const-string v3, "numUnreadConversations"

    invoke-virtual {v2, v3}, Landroid/content/ContentValues;->getAsInteger(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    .line 2415
    .local v1, "unreadConversations":Ljava/lang/Integer;
    const/4 v0, 0x0

    .line 2416
    .local v0, "result":I
    if-eqz v1, :cond_0

    .line 2417
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    if-gez v2, :cond_1

    const/4 v0, 0x0

    .line 2420
    :cond_0
    :goto_0
    return v0

    .line 2417
    :cond_1
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    goto :goto_0
.end method

.method getQueryMap()Landroid/content/ContentQueryMap;
    .locals 1

    .prologue
    .line 2326
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mQueryMap:Landroid/content/ContentQueryMap;

    return-object v0
.end method

.method public declared-synchronized labelPresent(Ljava/lang/String;)Z
    .locals 1
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 2455
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mCanonicalNameToId:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
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

.method public declared-synchronized labelsSynced()Z
    .locals 1

    .prologue
    .line 2250
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelsSynced:Ljava/lang/Boolean;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelsSynced:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_0

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

.method declared-synchronized labelsSynchronizationStateInitialized()Z
    .locals 1

    .prologue
    .line 2257
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mLabelsSynced:Ljava/lang/Boolean;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

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

.method public requery()V
    .locals 1

    .prologue
    .line 2470
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$LabelMap;->mQueryMap:Landroid/content/ContentQueryMap;

    invoke-virtual {v0}, Landroid/content/ContentQueryMap;->requery()V

    .line 2471
    return-void
.end method
