.class public Lcom/google/android/gm/ConversationInfo;
.super Ljava/lang/Object;
.source "ConversationInfo.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/google/android/gm/ConversationInfo;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mConversationId:J

.field private final mIsImportant:Z

.field private final mLabels:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;"
        }
    .end annotation
.end field

.field private final mLocalMessageId:J

.field private mMaxMessageId:J

.field private final mServerMessageId:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 99
    new-instance v0, Lcom/google/android/gm/ConversationInfo$1;

    invoke-direct {v0}, Lcom/google/android/gm/ConversationInfo$1;-><init>()V

    sput-object v0, Lcom/google/android/gm/ConversationInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(JJJJLjava/util/Map;)V
    .locals 11
    .param p1, "conversationId"    # J
    .param p3, "localMessageId"    # J
    .param p5, "serverMessageId"    # J
    .param p7, "maxMessageId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJJJ",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 48
    .local p9, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    invoke-static/range {p9 .. p9}, Lcom/google/android/gm/provider/Gmail;->isImportant(Ljava/util/Map;)Z

    move-result v10

    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p3

    move-wide/from16 v5, p5

    move-wide/from16 v7, p7

    move-object/from16 v9, p9

    invoke-direct/range {v0 .. v10}, Lcom/google/android/gm/ConversationInfo;-><init>(JJJJLjava/util/Map;Z)V

    .line 50
    return-void
.end method

.method public constructor <init>(JJJJLjava/util/Map;Ljava/util/Set;Lcom/google/android/gm/provider/Gmail$LabelMap;)V
    .locals 12
    .param p1, "conversationId"    # J
    .param p3, "localMessageId"    # J
    .param p5, "serverMessageId"    # J
    .param p7, "maxMessageId"    # J
    .param p11, "labelMap"    # Lcom/google/android/gm/provider/Gmail$LabelMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJJJ",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Lcom/google/android/gm/provider/Gmail$LabelMap;",
            ")V"
        }
    .end annotation

    .prologue
    .line 39
    .local p9, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    .local p10, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-static/range {p9 .. p9}, Lcom/google/android/gm/provider/Gmail;->isImportant(Ljava/util/Map;)Z

    move-result v1

    if-nez v1, :cond_0

    if-eqz p11, :cond_1

    if-eqz p10, :cond_1

    invoke-virtual/range {p11 .. p11}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdImportantImap()J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    move-object/from16 v0, p10

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v11, 0x1

    :goto_0
    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p3

    move-wide/from16 v6, p5

    move-wide/from16 v8, p7

    move-object/from16 v10, p9

    invoke-direct/range {v1 .. v11}, Lcom/google/android/gm/ConversationInfo;-><init>(JJJJLjava/util/Map;Z)V

    .line 43
    return-void

    .line 39
    :cond_1
    const/4 v11, 0x0

    goto :goto_0
.end method

.method private constructor <init>(JJJJLjava/util/Map;Z)V
    .locals 0
    .param p1, "conversationId"    # J
    .param p3, "localMessageId"    # J
    .param p5, "serverMessageId"    # J
    .param p7, "maxMessageId"    # J
    .param p10, "isImportant"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJJJ",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 53
    .local p9, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-wide p1, p0, Lcom/google/android/gm/ConversationInfo;->mConversationId:J

    .line 55
    iput-wide p3, p0, Lcom/google/android/gm/ConversationInfo;->mLocalMessageId:J

    .line 56
    iput-wide p5, p0, Lcom/google/android/gm/ConversationInfo;->mServerMessageId:J

    .line 57
    iput-object p9, p0, Lcom/google/android/gm/ConversationInfo;->mLabels:Ljava/util/Map;

    .line 58
    iput-wide p7, p0, Lcom/google/android/gm/ConversationInfo;->mMaxMessageId:J

    .line 59
    iput-boolean p10, p0, Lcom/google/android/gm/ConversationInfo;->mIsImportant:Z

    .line 60
    return-void
.end method

.method private constructor <init>(JJLjava/util/Map;Ljava/util/Set;Lcom/google/android/gm/provider/Gmail$LabelMap;)V
    .locals 12
    .param p1, "conversationId"    # J
    .param p3, "maxMessageId"    # J
    .param p7, "labelMap"    # Lcom/google/android/gm/provider/Gmail$LabelMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Lcom/google/android/gm/provider/Gmail$LabelMap;",
            ")V"
        }
    .end annotation

    .prologue
    .line 64
    .local p5, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    .local p6, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    const-wide/16 v3, 0x0

    const-wide/16 v5, 0x0

    move-object v0, p0

    move-wide v1, p1

    move-wide v7, p3

    move-object/from16 v9, p5

    move-object/from16 v10, p6

    move-object/from16 v11, p7

    invoke-direct/range {v0 .. v11}, Lcom/google/android/gm/ConversationInfo;-><init>(JJJJLjava/util/Map;Ljava/util/Set;Lcom/google/android/gm/provider/Gmail$LabelMap;)V

    .line 65
    return-void
.end method

.method public static forCursor(Lcom/google/android/gm/provider/Gmail$ConversationCursor;Lcom/google/android/gm/provider/Gmail$LabelMap;)Lcom/google/android/gm/ConversationInfo;
    .locals 8
    .param p0, "cursor"    # Lcom/google/android/gm/provider/Gmail$ConversationCursor;
    .param p1, "labelMap"    # Lcom/google/android/gm/provider/Gmail$LabelMap;

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->count()I

    move-result v0

    if-nez v0, :cond_0

    .line 73
    const/4 v0, 0x0

    .line 75
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/google/android/gm/ConversationInfo;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getConversationId()J

    move-result-wide v1

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getMaxServerMessageId()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v5

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabelIds()Ljava/util/Set;

    move-result-object v6

    move-object v7, p1

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gm/ConversationInfo;-><init>(JJLjava/util/Map;Ljava/util/Set;Lcom/google/android/gm/provider/Gmail$LabelMap;)V

    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 85
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 156
    monitor-enter p0

    .line 157
    if-ne p1, p0, :cond_0

    .line 158
    :try_start_0
    monitor-exit p0

    .line 166
    :goto_0
    return v2

    .line 161
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    if-eq v4, v5, :cond_2

    .line 162
    :cond_1
    monitor-exit p0

    move v2, v3

    goto :goto_0

    .line 165
    :cond_2
    move-object v0, p1

    check-cast v0, Lcom/google/android/gm/ConversationInfo;

    move-object v1, v0

    .line 166
    .local v1, "other":Lcom/google/android/gm/ConversationInfo;
    iget-wide v4, p0, Lcom/google/android/gm/ConversationInfo;->mConversationId:J

    iget-wide v6, v1, Lcom/google/android/gm/ConversationInfo;->mConversationId:J

    cmp-long v4, v4, v6

    if-nez v4, :cond_3

    iget-wide v4, p0, Lcom/google/android/gm/ConversationInfo;->mLocalMessageId:J

    iget-wide v6, v1, Lcom/google/android/gm/ConversationInfo;->mLocalMessageId:J

    cmp-long v4, v4, v6

    if-nez v4, :cond_3

    iget-wide v4, p0, Lcom/google/android/gm/ConversationInfo;->mServerMessageId:J

    iget-wide v6, v1, Lcom/google/android/gm/ConversationInfo;->mServerMessageId:J

    cmp-long v4, v4, v6

    if-nez v4, :cond_3

    iget-wide v4, p0, Lcom/google/android/gm/ConversationInfo;->mMaxMessageId:J

    iget-wide v6, v1, Lcom/google/android/gm/ConversationInfo;->mMaxMessageId:J

    cmp-long v4, v4, v6

    if-nez v4, :cond_3

    iget-object v4, p0, Lcom/google/android/gm/ConversationInfo;->mLabels:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    iget-object v5, v1, Lcom/google/android/gm/ConversationInfo;->mLabels:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    :goto_1
    monitor-exit p0

    goto :goto_0

    .line 171
    .end local v1    # "other":Lcom/google/android/gm/ConversationInfo;
    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v1    # "other":Lcom/google/android/gm/ConversationInfo;
    :cond_3
    move v2, v3

    .line 166
    goto :goto_1
.end method

.method public getConversationId()J
    .locals 2

    .prologue
    .line 124
    iget-wide v0, p0, Lcom/google/android/gm/ConversationInfo;->mConversationId:J

    return-wide v0
.end method

.method public declared-synchronized getLabels()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;"
        }
    .end annotation

    .prologue
    .line 143
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/ConversationInfo;->mLabels:Ljava/util/Map;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    monitor-exit p0

    return-object v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gm/ConversationInfo;->mLabels:Ljava/util/Map;

    invoke-static {v0}, Lcom/google/common/collect/ImmutableMap;->copyOf(Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getLocalMessageId()J
    .locals 2

    .prologue
    .line 128
    iget-wide v0, p0, Lcom/google/android/gm/ConversationInfo;->mLocalMessageId:J

    return-wide v0
.end method

.method public getMaxMessageId()J
    .locals 2

    .prologue
    .line 136
    iget-wide v0, p0, Lcom/google/android/gm/ConversationInfo;->mMaxMessageId:J

    return-wide v0
.end method

.method public getServerMessageId()J
    .locals 2

    .prologue
    .line 132
    iget-wide v0, p0, Lcom/google/android/gm/ConversationInfo;->mServerMessageId:J

    return-wide v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 176
    monitor-enter p0

    .line 177
    const/4 v0, 0x5

    :try_start_0
    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-wide v2, p0, Lcom/google/android/gm/ConversationInfo;->mConversationId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-wide v2, p0, Lcom/google/android/gm/ConversationInfo;->mLocalMessageId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-wide v2, p0, Lcom/google/android/gm/ConversationInfo;->mServerMessageId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-wide v2, p0, Lcom/google/android/gm/ConversationInfo;->mMaxMessageId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x4

    iget-object v2, p0, Lcom/google/android/gm/ConversationInfo;->mLabels:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    monitor-exit p0

    return v0

    .line 179
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public declared-synchronized isImportant()Z
    .locals 1

    .prologue
    .line 151
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/google/android/gm/ConversationInfo;->mIsImportant:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 90
    iget-wide v0, p0, Lcom/google/android/gm/ConversationInfo;->mConversationId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 91
    iget-wide v0, p0, Lcom/google/android/gm/ConversationInfo;->mLocalMessageId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 92
    iget-wide v0, p0, Lcom/google/android/gm/ConversationInfo;->mServerMessageId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 93
    iget-wide v0, p0, Lcom/google/android/gm/ConversationInfo;->mMaxMessageId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 94
    monitor-enter p0

    .line 95
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/ConversationInfo;->mLabels:Ljava/util/Map;

    invoke-static {v0}, Lcom/google/android/gm/provider/LabelManager;->serialize(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 96
    monitor-exit p0

    .line 97
    return-void

    .line 96
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
