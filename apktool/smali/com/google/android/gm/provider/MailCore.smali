.class Lcom/google/android/gm/provider/MailCore;
.super Ljava/lang/Object;
.source "MailCore.java"

# interfaces
.implements Lcom/google/android/gm/provider/MailCoreLabelAccess;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/MailCore$Label;,
        Lcom/google/android/gm/provider/MailCore$NotificationRequest;,
        Lcom/google/android/gm/provider/MailCore$Listener;
    }
.end annotation


# static fields
.field private static final FORCED_INCLUDED_OR_PARTIAL_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final FORCED_SYNCED_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final FORCED_UNSYNCED_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static NO_COUNT_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static TOTAL_COUNT_LABELS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static sDefaultSystemLabelOrder:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mCanonicalNameToLabel:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/MailCore$Label;",
            ">;"
        }
    .end annotation
.end field

.field private final mConversationHelper:Lcom/google/android/gm/provider/ConversationUtil;

.field private final mDb:Landroid/database/sqlite/SQLiteDatabase;

.field private final mIdToLabel:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/google/android/gm/provider/MailCore$Label;",
            ">;"
        }
    .end annotation
.end field

.field mLabelIdsIncludedOrPartial:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field final mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

.field final mListener:Lcom/google/android/gm/provider/MailCore$Listener;

.field private mNextLocalLabelId:J

.field private mNextServerLabelId:J

.field mNotificationRequests:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gm/provider/MailCore$NotificationRequest;",
            ">;"
        }
    .end annotation
.end field

.field private final mOperations:Lcom/google/android/gm/provider/Operations;

.field mServerVersion:J

.field private final mUserGmailPrefs:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 633
    const/4 v0, 0x0

    sput-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    .line 653
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "^r"

    aput-object v1, v0, v3

    const-string v1, "^^out"

    aput-object v1, v0, v4

    const-string v1, "^s"

    aput-object v1, v0, v5

    invoke-static {v0}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailCore;->TOTAL_COUNT_LABELS:Ljava/util/Set;

    .line 657
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "^f"

    aput-object v1, v0, v3

    const-string v1, "^t"

    aput-object v1, v0, v4

    const-string v1, "^b"

    aput-object v1, v0, v5

    const-string v1, "^all"

    aput-object v1, v0, v6

    const-string v1, "^k"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "^io_im"

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailCore;->NO_COUNT_LABELS:Ljava/util/Set;

    .line 662
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "^^out"

    aput-object v1, v0, v3

    const-string v1, "^r"

    aput-object v1, v0, v4

    invoke-static {v0}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailCore;->FORCED_SYNCED_LABELS:Ljava/util/Set;

    .line 665
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "^f"

    aput-object v1, v0, v3

    invoke-static {v0}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailCore;->FORCED_INCLUDED_OR_PARTIAL_LABELS:Ljava/util/Set;

    .line 668
    new-array v0, v7, [Ljava/lang/String;

    const-string v1, "^all"

    aput-object v1, v0, v3

    const-string v1, "^b"

    aput-object v1, v0, v4

    const-string v1, "^s"

    aput-object v1, v0, v5

    const-string v1, "^k"

    aput-object v1, v0, v6

    invoke-static {v0}, Lcom/google/common/collect/Sets;->newHashSet([Ljava/lang/Object;)Ljava/util/HashSet;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailCore;->FORCED_UNSYNCED_LABELS:Ljava/util/Set;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;Lcom/google/android/gm/provider/Operations;Lcom/google/android/gm/provider/MailCore$Listener;)V
    .locals 10
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p3, "operations"    # Lcom/google/android/gm/provider/Operations;
    .param p4, "listener"    # Lcom/google/android/gm/provider/MailCore$Listener;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v9, 0x0

    const/4 v3, 0x0

    .line 171
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 81
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mUserGmailPrefs:Ljava/util/Map;

    .line 536
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mIdToLabel:Ljava/util/Map;

    .line 537
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mCanonicalNameToLabel:Ljava/util/Map;

    .line 538
    iput-wide v4, p0, Lcom/google/android/gm/provider/MailCore;->mNextServerLabelId:J

    .line 539
    iput-wide v4, p0, Lcom/google/android/gm/provider/MailCore;->mNextLocalLabelId:J

    .line 172
    iput-object p2, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 173
    iput-object p3, p0, Lcom/google/android/gm/provider/MailCore;->mOperations:Lcom/google/android/gm/provider/Operations;

    .line 174
    iput-object v3, p0, Lcom/google/android/gm/provider/MailCore;->mNotificationRequests:Ljava/util/Collection;

    .line 175
    iput-object p4, p0, Lcom/google/android/gm/provider/MailCore;->mListener:Lcom/google/android/gm/provider/MailCore$Listener;

    .line 178
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailCore;->loadGmailPreferences()V

    .line 180
    const/4 v0, 0x6

    new-array v2, v0, [Ljava/lang/String;

    const-string v0, "_id"

    aput-object v0, v2, v9

    const/4 v0, 0x1

    const-string v1, "canonicalName"

    aput-object v1, v2, v0

    const/4 v0, 0x2

    const-string v1, "name"

    aput-object v1, v2, v0

    const/4 v0, 0x3

    const-string v1, "numConversations"

    aput-object v1, v2, v0

    const/4 v0, 0x4

    const-string v1, "numUnreadConversations"

    aput-object v1, v2, v0

    const/4 v0, 0x5

    const-string v1, "color"

    aput-object v1, v2, v0

    .line 188
    .local v2, "labelsProjection":[Ljava/lang/String;
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "labels"

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 191
    .local v8, "labelsCursor":Landroid/database/Cursor;
    new-instance v0, Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-direct {v0, v1, v8, v9}, Lcom/google/android/gm/provider/Gmail$LabelMap;-><init>(Landroid/content/ContentResolver;Landroid/database/Cursor;Z)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    .line 196
    new-instance v0, Lcom/google/android/gm/provider/ConversationUtil;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-direct {v0, v1, p0}, Lcom/google/android/gm/provider/ConversationUtil;-><init>(Landroid/database/sqlite/SQLiteDatabase;Lcom/google/android/gm/provider/MailCore;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mConversationHelper:Lcom/google/android/gm/provider/ConversationUtil;

    .line 197
    return-void
.end method

.method private addLabel(J)V
    .locals 6
    .param p1, "labelId"    # J

    .prologue
    const/4 v5, 0x0

    .line 792
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v1

    if-nez v1, :cond_0

    .line 793
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Must be in transaction"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 795
    :cond_0
    iget-wide v1, p0, Lcom/google/android/gm/provider/MailCore;->mNextServerLabelId:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-nez v1, :cond_1

    .line 796
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "onLabelsChanged not yet called"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 799
    :cond_1
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 800
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "canonicalName"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 801
    const-string v1, "name"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 802
    const-string v1, "numConversations"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 803
    const-string v1, "numUnreadConversations"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 804
    const-string v1, "color"

    const v2, 0x7fffffff

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 805
    const-string v1, "visibility"

    const-string v2, "SHOW"

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 806
    const-string v1, "_id"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 807
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "labels"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 808
    return-void
.end method

.method private addLabel(Ljava/lang/String;)V
    .locals 11
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    const-wide/16 v9, 0x1

    const/4 v8, 0x0

    .line 755
    iget-object v4, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v4

    if-nez v4, :cond_0

    .line 756
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "Must be in transaction"

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 758
    :cond_0
    iget-wide v4, p0, Lcom/google/android/gm/provider/MailCore;->mNextServerLabelId:J

    const-wide/16 v6, 0x0

    cmp-long v4, v4, v6

    if-nez v4, :cond_1

    .line 759
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "onLabelsChanged not yet called"

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 762
    :cond_1
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 763
    .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "canonicalName"

    invoke-virtual {v3, v4, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 764
    const-string v4, "name"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 765
    const-string v4, "numConversations"

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 766
    const-string v4, "numUnreadConversations"

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 767
    const-string v4, "color"

    const v5, 0x7fffffff

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 768
    const-string v4, "visibility"

    const-string v5, "SHOW"

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 770
    invoke-direct {p0, p1, v3}, Lcom/google/android/gm/provider/MailCore;->adjustContentValuesForSystemLabel(Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 773
    invoke-static {p1}, Lcom/google/android/gm/provider/MailCore;->isCanonicalLabelNameLocal(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 774
    iget-wide v4, p0, Lcom/google/android/gm/provider/MailCore;->mNextLocalLabelId:J

    sub-long v6, v4, v9

    iput-wide v6, p0, Lcom/google/android/gm/provider/MailCore;->mNextLocalLabelId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .line 780
    .local v2, "labelId":Ljava/lang/Long;
    :goto_0
    const-string v4, "_id"

    invoke-virtual {v3, v4, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 781
    iget-object v4, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "labels"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6, v3}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v0

    .line 782
    .local v0, "id":J
    const-wide/16 v4, -0x1

    cmp-long v4, v0, v4

    if-nez v4, :cond_4

    .line 783
    new-instance v4, Ljava/lang/IllegalStateException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed to insert row for label: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 775
    .end local v0    # "id":J
    .end local v2    # "labelId":Ljava/lang/Long;
    :cond_2
    sget-object v4, Lcom/google/android/gm/provider/Gmail;->PRIORITY_MARKERS:Ljava/util/Set;

    invoke-interface {v4, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 776
    sget-object v4, Lcom/google/android/gm/provider/Gmail;->LOCAL_PRIORITY_LABELS:Lcom/google/common/collect/BiMap;

    invoke-interface {v4}, Lcom/google/common/collect/BiMap;->inverse()Lcom/google/common/collect/BiMap;

    move-result-object v4

    invoke-interface {v4, p1}, Lcom/google/common/collect/BiMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    .restart local v2    # "labelId":Ljava/lang/Long;
    goto :goto_0

    .line 778
    .end local v2    # "labelId":Ljava/lang/Long;
    :cond_3
    iget-wide v4, p0, Lcom/google/android/gm/provider/MailCore;->mNextServerLabelId:J

    add-long v6, v4, v9

    iput-wide v6, p0, Lcom/google/android/gm/provider/MailCore;->mNextServerLabelId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    .restart local v2    # "labelId":Ljava/lang/Long;
    goto :goto_0

    .line 785
    .restart local v0    # "id":J
    :cond_4
    return-void
.end method

.method private adjustContentValuesForSystemLabel(Ljava/lang/String;Landroid/content/ContentValues;)V
    .locals 6
    .param p1, "canonicalName"    # Ljava/lang/String;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const/4 v5, 0x2

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 675
    const-string v1, "^"

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    .line 676
    .local v0, "isSystemLabel":Z
    const-string v4, "systemLabel"

    if-eqz v0, :cond_a

    move v1, v2

    :goto_0
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p2, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 678
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailCore;->initSystemLabelMap()V

    .line 680
    sget-object v1, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 681
    const-string v4, "systemLabelOrder"

    sget-object v1, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {p2, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 685
    :cond_0
    if-eqz v0, :cond_1

    .line 687
    const-string v4, "hidden"

    invoke-static {}, Lcom/google/android/gm/provider/LabelManager;->getSortedUserMeaningfulSystemLabels()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_b

    move v1, v2

    :goto_1
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p2, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 691
    :cond_1
    const-string v1, "^io_im"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "^iim"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 695
    :cond_2
    const-string v1, "hidden"

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailCore;->getInfoOverloadEnabled()Z

    move-result v4

    if-nez v4, :cond_3

    move v3, v2

    :cond_3
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {p2, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 699
    :cond_4
    sget-object v1, Lcom/google/android/gm/provider/MailCore;->NO_COUNT_LABELS:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 704
    const-string v1, "labelCountDisplayBehavior"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {p2, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 708
    :cond_5
    sget-object v1, Lcom/google/android/gm/provider/MailCore;->TOTAL_COUNT_LABELS:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 713
    const-string v1, "labelCountDisplayBehavior"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {p2, v1, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 717
    :cond_6
    sget-object v1, Lcom/google/android/gm/provider/MailCore;->FORCED_SYNCED_LABELS:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 722
    const-string v1, "labelSyncPolicy"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p2, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 726
    :cond_7
    sget-object v1, Lcom/google/android/gm/provider/MailCore;->FORCED_UNSYNCED_LABELS:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 731
    const-string v1, "labelSyncPolicy"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p2, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 735
    :cond_8
    sget-object v1, Lcom/google/android/gm/provider/MailCore;->FORCED_INCLUDED_OR_PARTIAL_LABELS:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 741
    const-string v1, "labelSyncPolicy"

    const/4 v2, 0x3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p2, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 744
    :cond_9
    return-void

    :cond_a
    move v1, v3

    .line 676
    goto/16 :goto_0

    :cond_b
    move v1, v3

    .line 687
    goto/16 :goto_1
.end method

.method static changeLabelId(Landroid/database/sqlite/SQLiteDatabase;JJ)V
    .locals 3

    .prologue
    .line 1220
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    invoke-static {p3, p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    .line 1221
    const-string v1, "UPDATE labels SET _id = ? WHERE _id = ?"

    invoke-virtual {p0, v1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1222
    const-string v1, "UPDATE message_labels SET labels_id = ? WHERE labels_id = ?"

    invoke-virtual {p0, v1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1223
    const-string v1, "UPDATE conversation_labels SET labels_id = ? WHERE labels_id = ?"

    invoke-virtual {p0, v1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1224
    invoke-static {p0, p1, p2, p3, p4}, Lcom/google/android/gm/provider/Operations;->updateLabelId(Landroid/database/sqlite/SQLiteDatabase;JJ)V

    .line 1225
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "UPDATE conversations SET labelIds = REPLACE(labelIds, \',"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",\', \',"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",\')"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 1228
    return-void
.end method

.method public static correctLocalLabelIds(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 14
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    const/4 v4, 0x1

    const/4 v1, 0x0

    const/4 v3, 0x0

    .line 1184
    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    const-string v0, "_id"

    aput-object v0, v2, v1

    const-string v0, "canonicalName"

    aput-object v0, v2, v4

    .line 1187
    .local v2, "labelsProjection":[Ljava/lang/String;
    const-string v1, "labels"

    move-object v0, p0

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v11

    .line 1190
    .local v11, "labelsCursor":Landroid/database/Cursor;
    const-wide/16 v12, -0x1

    .line 1191
    .local v12, "lowestLocalLabelId":J
    :cond_0
    :goto_0
    :try_start_0
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1192
    const/4 v0, 0x0

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    .line 1193
    .local v9, "labelId":J
    invoke-static {v9, v10}, Lcom/google/android/gm/provider/MailCore;->isLabelIdLocal(J)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1194
    invoke-static {v12, v13, v9, v10}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v12

    goto :goto_0

    .line 1198
    .end local v9    # "labelId":J
    :cond_1
    const/4 v0, -0x1

    invoke-interface {v11, v0}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 1200
    :cond_2
    :goto_1
    invoke-interface {v11}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1201
    const/4 v0, 0x0

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v9

    .line 1202
    .restart local v9    # "labelId":J
    const/4 v0, 0x1

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 1203
    .local v8, "canonicalLabelName":Ljava/lang/String;
    invoke-static {v8}, Lcom/google/android/gm/provider/MailCore;->isCanonicalLabelNameLocal(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-static {v9, v10}, Lcom/google/android/gm/provider/MailCore;->isLabelIdLocal(J)Z

    move-result v0

    if-nez v0, :cond_2

    .line 1204
    const-wide/16 v0, 0x1

    sub-long/2addr v12, v0

    invoke-static {p0, v9, v10, v12, v13}, Lcom/google/android/gm/provider/MailCore;->changeLabelId(Landroid/database/sqlite/SQLiteDatabase;JJ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 1208
    .end local v8    # "canonicalLabelName":Ljava/lang/String;
    .end local v9    # "labelId":J
    :catchall_0
    move-exception v0

    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    throw v0

    :cond_3
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 1210
    return-void
.end method

.method private initSystemLabelMap()V
    .locals 3

    .prologue
    .line 636
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 637
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    .line 638
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^i"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 639
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^iim"

    const/4 v2, 0x2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 640
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^t"

    const/4 v2, 0x3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 641
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^io_im"

    const/4 v2, 0x4

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 642
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^b"

    const/4 v2, 0x5

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 643
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^f"

    const/4 v2, 0x6

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 644
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^^out"

    const/4 v2, 0x7

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 645
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^r"

    const/16 v2, 0x8

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 646
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^all"

    const/16 v2, 0x9

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 647
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^s"

    const/16 v2, 0xa

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 648
    sget-object v0, Lcom/google/android/gm/provider/MailCore;->sDefaultSystemLabelOrder:Ljava/util/Map;

    const-string v1, "^k"

    const/16 v2, 0xb

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 650
    :cond_0
    return-void
.end method

.method public static isCanonicalLabelNameLocal(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 1238
    if-eqz p0, :cond_0

    const-string v0, "^^"

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isLabelIdLocal(J)Z
    .locals 2
    .param p0, "labelId"    # J

    .prologue
    .line 1231
    const-wide/16 v0, -0x1

    cmp-long v0, p0, v0

    if-gez v0, :cond_0

    const-wide/16 v0, -0x3e8

    cmp-long v0, p0, v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private loadGmailPreferences()V
    .locals 15

    .prologue
    const/4 v8, 0x1

    const/4 v14, 0x0

    const/4 v3, 0x0

    .line 332
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "info_overload"

    new-array v2, v8, [Ljava/lang/String;

    const-string v4, "enabled_pref"

    aput-object v4, v2, v14

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v12

    .line 336
    .local v12, "preferenceCursor":Landroid/database/Cursor;
    if-eqz v12, :cond_1

    .line 337
    invoke-interface {v12}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 338
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mUserGmailPrefs:Ljava/util/Map;

    const-string v1, "sx_ioe"

    invoke-interface {v12, v14}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 341
    :cond_0
    invoke-interface {v12}, Landroid/database/Cursor;->close()V

    .line 344
    :cond_1
    iget-object v4, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "server_preferences"

    new-array v6, v8, [Ljava/lang/String;

    const-string v0, "value"

    aput-object v0, v6, v14

    const-string v7, "name = ?"

    new-array v8, v8, [Ljava/lang/String;

    const-string v0, "bx_ioao"

    aput-object v0, v8, v14

    move-object v9, v3

    move-object v10, v3

    move-object v11, v3

    invoke-virtual/range {v4 .. v11}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v13

    .line 347
    .local v13, "priorityMarkers":Landroid/database/Cursor;
    if-eqz v13, :cond_3

    .line 348
    invoke-interface {v13}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 349
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mUserGmailPrefs:Ljava/util/Map;

    const-string v1, "bx_ioao"

    invoke-interface {v13, v14}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 352
    :cond_2
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 354
    :cond_3
    return-void
.end method

.method private setLabelOnConversation(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;)V
    .locals 10
    .param p1, "conversationId"    # J
    .param p3, "maxMessageId"    # J
    .param p5, "labelId"    # J
    .param p7, "on"    # Z
    .param p8, "recordHistory"    # Lcom/google/android/gm/provider/Operations$RecordHistory;

    .prologue
    .line 380
    const/4 v9, 0x1

    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p3

    move-wide v5, p5

    move/from16 v7, p7

    move-object/from16 v8, p8

    invoke-direct/range {v0 .. v9}, Lcom/google/android/gm/provider/MailCore;->setLabelOnConversation(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V

    .line 382
    return-void
.end method

.method private setLabelOnConversation(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V
    .locals 19
    .param p1, "conversationId"    # J
    .param p3, "maxMessageId"    # J
    .param p5, "labelId"    # J
    .param p7, "on"    # Z
    .param p8, "recordHistory"    # Lcom/google/android/gm/provider/Operations$RecordHistory;
    .param p9, "updateMessageIfNecessary"    # Z

    .prologue
    .line 390
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdUnread()J

    move-result-wide v15

    .line 391
    .local v15, "labelIdUnread":J
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdStarred()J

    move-result-wide v13

    .line 393
    .local v13, "labelIdStarred":J
    if-eqz p7, :cond_5

    .line 399
    cmp-long v2, v15, p5

    if-nez v2, :cond_1

    const-string v18, "UPDATE conversations SET labelIds = ? || REPLACE(labelIds, ?, ?), forceAllUnread = 1 WHERE queryId != 0 AND _id = ?"

    .line 403
    .local v18, "statement":Ljava/lang/String;
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, p5

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, p5

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    const-string v5, ","

    aput-object v5, v3, v4

    const/4 v4, 0x3

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    move-object/from16 v0, v18

    invoke-virtual {v2, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 407
    cmp-long v2, v13, p5

    if-nez v2, :cond_2

    .line 408
    if-eqz p9, :cond_0

    .line 409
    const/4 v7, 0x1

    const/4 v9, 0x0

    move-object/from16 v2, p0

    move-wide/from16 v3, p3

    move-wide/from16 v5, p5

    move-object/from16 v8, p8

    invoke-direct/range {v2 .. v9}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V

    .line 461
    :cond_0
    :goto_1
    return-void

    .line 399
    .end local v18    # "statement":Ljava/lang/String;
    :cond_1
    const-string v18, "UPDATE conversations SET labelIds = ? || REPLACE(labelIds, ?, ?) WHERE queryId != 0 AND _id = ?"

    goto :goto_0

    .line 416
    .restart local v18    # "statement":Ljava/lang/String;
    :cond_2
    const-string v17, "SELECT messageId, ?, ? FROM messages WHERE conversation = ? AND messageId <= ?"

    .line 418
    .local v17, "selectStatement":Ljava/lang/String;
    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    .line 419
    .local v12, "conversationIdArg":Ljava/lang/String;
    const/4 v2, 0x4

    new-array v11, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static/range {p5 .. p6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v11, v2

    const/4 v2, 0x1

    aput-object v12, v11, v2

    const/4 v2, 0x2

    aput-object v12, v11, v2

    const/4 v2, 0x3

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v11, v2

    .line 421
    .local v11, "bindArgs":[Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "INSERT or REPLACE INTO message_labels (message_messageId, labels_id, message_conversation) SELECT messageId, ?, ? FROM messages WHERE conversation = ? AND messageId <= ?"

    invoke-virtual {v2, v3, v11}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 425
    sget-object v2, Lcom/google/android/gm/provider/Operations$RecordHistory;->TRUE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    move-object/from16 v0, p8

    if-ne v0, v2, :cond_3

    .line 426
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mOperations:Lcom/google/android/gm/provider/Operations;

    const-string v7, "conversationLabelAdded"

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move-wide/from16 v8, p5

    invoke-virtual/range {v2 .. v9}, Lcom/google/android/gm/provider/Operations;->recordOperationWithLabelId(JJLjava/lang/String;J)J

    .line 431
    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdInbox()J

    move-result-wide v2

    cmp-long v2, v2, p5

    if-nez v2, :cond_4

    .line 432
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdIgnored()J

    move-result-wide v7

    const/4 v9, 0x0

    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move-object/from16 v10, p8

    invoke-direct/range {v2 .. v10}, Lcom/google/android/gm/provider/MailCore;->setLabelOnConversation(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    goto :goto_1

    .line 435
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdIgnored()J

    move-result-wide v2

    cmp-long v2, v2, p5

    if-nez v2, :cond_0

    .line 436
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdInbox()J

    move-result-wide v7

    const/4 v9, 0x0

    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move-object/from16 v10, p8

    invoke-direct/range {v2 .. v10}, Lcom/google/android/gm/provider/MailCore;->setLabelOnConversation(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    goto :goto_1

    .line 441
    .end local v11    # "bindArgs":[Ljava/lang/String;
    .end local v12    # "conversationIdArg":Ljava/lang/String;
    .end local v17    # "selectStatement":Ljava/lang/String;
    .end local v18    # "statement":Ljava/lang/String;
    :cond_5
    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    .line 443
    .restart local v12    # "conversationIdArg":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "message_labels"

    const-string v4, "labels_id = ? AND message_labels.message_conversation = ? AND message_labels.message_messageId <= ?"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static/range {p5 .. p6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object v12, v5, v6

    const/4 v6, 0x2

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v2, v3, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 449
    sget-object v2, Lcom/google/android/gm/provider/Operations$RecordHistory;->TRUE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    move-object/from16 v0, p8

    if-ne v0, v2, :cond_6

    .line 450
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mOperations:Lcom/google/android/gm/provider/Operations;

    const-string v7, "conversationLabelRemoved"

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move-wide/from16 v8, p5

    invoke-virtual/range {v2 .. v9}, Lcom/google/android/gm/provider/Operations;->recordOperationWithLabelId(JJLjava/lang/String;J)J

    .line 455
    :cond_6
    cmp-long v2, v15, p5

    if-nez v2, :cond_7

    const-string v18, "UPDATE conversations SET labelIds = REPLACE(labelIds, ?, ?), forceAllUnread = 0 WHERE queryId != 0 AND _id = ?"

    .line 459
    .restart local v18    # "statement":Ljava/lang/String;
    :goto_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-wide/from16 v0, p5

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string v5, ","

    aput-object v5, v3, v4

    const/4 v4, 0x2

    aput-object v12, v3, v4

    move-object/from16 v0, v18

    invoke-virtual {v2, v0, v3}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 455
    .end local v18    # "statement":Ljava/lang/String;
    :cond_7
    const-string v18, "UPDATE conversations SET labelIds = REPLACE(labelIds, ?, ?) WHERE queryId != 0 AND _id = ?"

    goto :goto_2
.end method

.method private setLabelOnMessage(JJZLcom/google/android/gm/provider/Operations$RecordHistory;)V
    .locals 8
    .param p1, "messageId"    # J
    .param p3, "labelId"    # J
    .param p5, "on"    # Z
    .param p6, "recordHistory"    # Lcom/google/android/gm/provider/Operations$RecordHistory;

    .prologue
    .line 246
    const/4 v7, 0x1

    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p3

    move v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V

    .line 248
    return-void
.end method

.method private setLabelOnMessage(JJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V
    .locals 21
    .param p1, "messageId"    # J
    .param p3, "labelId"    # J
    .param p5, "on"    # Z
    .param p6, "recordHistory"    # Lcom/google/android/gm/provider/Operations$RecordHistory;
    .param p7, "updateConversationIfNecessary"    # Z

    .prologue
    .line 253
    invoke-virtual/range {p0 .. p2}, Lcom/google/android/gm/provider/MailCore;->queryConversationIdForMessageId(J)J

    move-result-wide v4

    .line 255
    .local v4, "conversationId":J
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdStarred()J

    move-result-wide v16

    .line 257
    .local v16, "labelIdStarred":J
    if-eqz p5, :cond_2

    .line 260
    new-instance v20, Landroid/content/ContentValues;

    invoke-direct/range {v20 .. v20}, Landroid/content/ContentValues;-><init>()V

    .line 261
    .local v20, "values":Landroid/content/ContentValues;
    const-string v3, "labels_id"

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v0, v20

    invoke-virtual {v0, v3, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 262
    const-string v3, "message_messageId"

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v0, v20

    invoke-virtual {v0, v3, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 263
    const-string v3, "message_conversation"

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    move-object/from16 v0, v20

    invoke-virtual {v0, v3, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 264
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v8, "message_labels"

    const/4 v9, 0x0

    move-object/from16 v0, v20

    invoke-virtual {v3, v8, v9, v0}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 266
    sget-object v3, Lcom/google/android/gm/provider/Operations$RecordHistory;->TRUE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    move-object/from16 v0, p6

    if-ne v0, v3, :cond_0

    .line 267
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailCore;->mOperations:Lcom/google/android/gm/provider/Operations;

    const-string v8, "messageLabelAdded"

    move-wide/from16 v6, p1

    move-wide/from16 v9, p3

    invoke-virtual/range {v3 .. v10}, Lcom/google/android/gm/provider/Operations;->recordOperationWithLabelId(JJLjava/lang/String;J)J

    .line 281
    .end local v20    # "values":Landroid/content/ContentValues;
    :cond_0
    :goto_0
    cmp-long v3, v16, p3

    if-nez v3, :cond_1

    if-eqz p7, :cond_1

    .line 283
    const-wide/16 v6, 0x0

    .line 284
    .local v6, "maxMessageId":J
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v8, "SELECT maxMessageId FROM conversations WHERE _id = ? AND queryId = 0 LIMIT 1"

    invoke-virtual {v3, v8}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v19

    .line 287
    .local v19, "statement":Landroid/database/sqlite/SQLiteStatement;
    const/4 v3, 0x1

    :try_start_0
    move-object/from16 v0, v19

    invoke-virtual {v0, v3, v4, v5}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 289
    invoke-virtual/range {v19 .. v19}, Landroid/database/sqlite/SQLiteStatement;->simpleQueryForLong()J
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteDoneException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v6

    .line 296
    invoke-virtual/range {v19 .. v19}, Landroid/database/sqlite/SQLiteStatement;->close()V

    .line 299
    if-eqz p5, :cond_3

    .line 301
    const/4 v12, 0x0

    move-object/from16 v3, p0

    move-wide/from16 v8, p3

    move/from16 v10, p5

    move-object/from16 v11, p6

    invoke-direct/range {v3 .. v12}, Lcom/google/android/gm/provider/MailCore;->setLabelOnConversation(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V

    .line 324
    .end local v6    # "maxMessageId":J
    .end local v19    # "statement":Landroid/database/sqlite/SQLiteStatement;
    :cond_1
    :goto_1
    return-void

    .line 271
    :cond_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v8, "message_labels"

    const-string v9, "labels_id = ? AND message_messageId = ?"

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/String;

    const/4 v11, 0x0

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v3, v8, v9, v10}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 274
    sget-object v3, Lcom/google/android/gm/provider/Operations$RecordHistory;->TRUE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    move-object/from16 v0, p6

    if-ne v0, v3, :cond_0

    .line 275
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailCore;->mOperations:Lcom/google/android/gm/provider/Operations;

    const-string v8, "messageLabelRemoved"

    move-wide/from16 v6, p1

    move-wide/from16 v9, p3

    invoke-virtual/range {v3 .. v10}, Lcom/google/android/gm/provider/Operations;->recordOperationWithLabelId(JJLjava/lang/String;J)J

    goto :goto_0

    .line 290
    .restart local v6    # "maxMessageId":J
    .restart local v19    # "statement":Landroid/database/sqlite/SQLiteStatement;
    :catch_0
    move-exception v15

    .line 296
    .local v15, "e":Landroid/database/sqlite/SQLiteDoneException;
    invoke-virtual/range {v19 .. v19}, Landroid/database/sqlite/SQLiteStatement;->close()V

    goto :goto_1

    .end local v15    # "e":Landroid/database/sqlite/SQLiteDoneException;
    :catchall_0
    move-exception v3

    invoke-virtual/range {v19 .. v19}, Landroid/database/sqlite/SQLiteStatement;->close()V

    throw v3

    .line 305
    :cond_3
    const-wide/16 v13, 0x0

    .line 306
    .local v13, "countMessage":J
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v8, "SELECT COUNT(*) FROM message_labels WHERE labels_id = ? AND message_conversation = ?"

    invoke-virtual {v3, v8}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v18

    .line 310
    .local v18, "messageLabelCount":Landroid/database/sqlite/SQLiteStatement;
    const/4 v3, 0x1

    :try_start_1
    move-object/from16 v0, v18

    move-wide/from16 v1, p3

    invoke-virtual {v0, v3, v1, v2}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 311
    const/4 v3, 0x2

    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v4, v5}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 312
    invoke-virtual/range {v18 .. v18}, Landroid/database/sqlite/SQLiteStatement;->simpleQueryForLong()J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-wide v13

    .line 314
    invoke-virtual/range {v18 .. v18}, Landroid/database/sqlite/SQLiteStatement;->close()V

    .line 317
    const-wide/16 v8, 0x0

    cmp-long v3, v13, v8

    if-nez v3, :cond_1

    .line 319
    const/4 v12, 0x0

    move-object/from16 v3, p0

    move-wide/from16 v8, p3

    move/from16 v10, p5

    move-object/from16 v11, p6

    invoke-direct/range {v3 .. v12}, Lcom/google/android/gm/provider/MailCore;->setLabelOnConversation(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V

    goto :goto_1

    .line 314
    :catchall_1
    move-exception v3

    invoke-virtual/range {v18 .. v18}, Landroid/database/sqlite/SQLiteStatement;->close()V

    throw v3
.end method


# virtual methods
.method public deleteLabel(Lcom/google/android/gm/provider/MailCore$Label;)V
    .locals 4
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    .line 834
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Must be in transaction"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 836
    :cond_0
    const/4 v1, 0x1

    new-array v0, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    iget-wide v2, p1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    .line 839
    .local v0, "labelIdSelectionArgs":[Ljava/lang/String;
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "message_labels"

    const-string v3, "labels_id = ?"

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 840
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "labels"

    const-string v3, "_id = ?"

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 841
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "conversation_labels"

    const-string v3, "labels_id = ?"

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 842
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mOperations:Lcom/google/android/gm/provider/Operations;

    iget-wide v2, p1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-virtual {v1, v2, v3}, Lcom/google/android/gm/provider/Operations;->deleteOperationsForLabelId(J)V

    .line 843
    return-void
.end method

.method public expungeMessagesWithoutWritingOperations(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 226
    .local p1, "messageIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    const-string v2, ", "

    invoke-static {v2, p1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v1

    .line 227
    .local v1, "joinedMessageIds":Ljava/lang/String;
    const/4 v2, 0x1

    new-array v0, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    .line 228
    .local v0, "bindArgs":[Ljava/lang/String;
    iget-object v2, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "message_labels"

    const-string v4, "message_messageId IN (?)"

    invoke-virtual {v2, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 230
    iget-object v2, p0, Lcom/google/android/gm/provider/MailCore;->mOperations:Lcom/google/android/gm/provider/Operations;

    invoke-virtual {v2, p1}, Lcom/google/android/gm/provider/Operations;->deleteOperationsForMessageIds(Ljava/util/List;)V

    .line 232
    iget-object v2, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "messages"

    const-string v4, "messageId IN (?)"

    invoke-virtual {v2, v3, v4, v0}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 237
    return-void
.end method

.method public declared-synchronized getAllLabels()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gm/provider/MailCore$Label;",
            ">;"
        }
    .end annotation

    .prologue
    .line 616
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mCanonicalNameToLabel:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;
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

.method public getCursorForCustomFrom()Landroid/database/Cursor;
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 1013
    new-instance v0, Landroid/database/sqlite/SQLiteQueryBuilder;

    invoke-direct {v0}, Landroid/database/sqlite/SQLiteQueryBuilder;-><init>()V

    .line 1014
    .local v0, "qb":Landroid/database/sqlite/SQLiteQueryBuilder;
    const-string v1, "custom_from_prefs"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteQueryBuilder;->setTables(Ljava/lang/String;)V

    .line 1015
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/google/android/gm/utils/CustomFromUtils;->REPLY_TO:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " ASC"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    move-object v6, v2

    invoke-virtual/range {v0 .. v7}, Landroid/database/sqlite/SQLiteQueryBuilder;->query(Landroid/database/sqlite/SQLiteDatabase;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    return-object v1
.end method

.method public getInfoOverloadArrowsEnabled()Z
    .locals 2

    .prologue
    .line 1136
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mUserGmailPrefs:Ljava/util/Map;

    const-string v1, "bx_ioao"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1138
    const-string v1, "1"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getInfoOverloadEnabled()Z
    .locals 2

    .prologue
    .line 1127
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mUserGmailPrefs:Ljava/util/Map;

    const-string v1, "sx_ioe"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1129
    const-string v1, "on"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public getLabelCanonicalNameOrNull(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;
    .locals 1
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    .line 627
    if-nez p1, :cond_0

    const/4 v0, 0x0

    .line 628
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p1, Lcom/google/android/gm/provider/MailCore$Label;->canonicalName:Ljava/lang/String;

    goto :goto_0
.end method

.method public getLabelCanonicalNameOrThrow(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;
    .locals 2
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    .line 621
    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "null label"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 622
    :cond_0
    iget-object v0, p1, Lcom/google/android/gm/provider/MailCore$Label;->canonicalName:Ljava/lang/String;

    return-object v0
.end method

.method public getLabelMap()Lcom/google/android/gm/provider/Gmail$LabelMap;
    .locals 1

    .prologue
    .line 542
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    return-object v0
.end method

.method public declared-synchronized getLabelOrNull(J)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 2
    .param p1, "labelId"    # J

    .prologue
    .line 552
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mIdToLabel:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailCore$Label;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 1
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 547
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mCanonicalNameToLabel:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailCore$Label;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLabelOrThrow(J)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 4
    .param p1, "labelId"    # J

    .prologue
    .line 609
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mIdToLabel:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailCore$Label;

    .line 610
    .local v0, "label":Lcom/google/android/gm/provider/MailCore$Label;
    if-nez v0, :cond_0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown label id: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 609
    .end local v0    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 611
    .restart local v0    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    :cond_0
    monitor-exit p0

    return-object v0
.end method

.method public declared-synchronized getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 4
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 557
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mCanonicalNameToLabel:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/MailCore$Label;

    .line 558
    .local v0, "label":Lcom/google/android/gm/provider/MailCore$Label;
    if-nez v0, :cond_0

    .line 559
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not find label with canonical name: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 557
    .end local v0    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 562
    .restart local v0    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    :cond_0
    monitor-exit p0

    return-object v0
.end method

.method public getNotificationRequests()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gm/provider/MailCore$NotificationRequest;",
            ">;"
        }
    .end annotation

    .prologue
    .line 208
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mNotificationRequests:Ljava/util/Collection;

    return-object v0
.end method

.method public getOrAddLabel(J)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 3
    .param p1, "labelId"    # J

    .prologue
    .line 592
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(J)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v0

    .line 593
    .local v0, "label":Lcom/google/android/gm/provider/MailCore$Label;
    if-nez v0, :cond_0

    .line 594
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 596
    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailCore;->addLabel(J)V

    .line 597
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 598
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailCore;->onLabelsChanged()V

    .line 599
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(J)Lcom/google/android/gm/provider/MailCore$Label;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 601
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 604
    :cond_0
    return-object v0

    .line 601
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
.end method

.method public getOrAddLabel(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 3
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 571
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v0

    .line 572
    .local v0, "label":Lcom/google/android/gm/provider/MailCore$Label;
    if-nez v0, :cond_0

    .line 573
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 575
    :try_start_0
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailCore;->addLabel(Ljava/lang/String;)V

    .line 576
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 577
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailCore;->onLabelsChanged()V

    .line 578
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 580
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 583
    :cond_0
    return-object v0

    .line 580
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
.end method

.method public onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;)V
    .locals 1
    .param p1, "conversationId"    # J
    .param p3, "rationale"    # Lcom/google/android/gm/provider/MailSync$SyncRationale;

    .prologue
    .line 485
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mConversationHelper:Lcom/google/android/gm/provider/ConversationUtil;

    invoke-virtual {v0, p1, p2, p3}, Lcom/google/android/gm/provider/ConversationUtil;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;)V

    .line 486
    return-void
.end method

.method onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    .locals 6
    .param p1, "conversationId"    # J
    .param p3, "rationale"    # Lcom/google/android/gm/provider/MailSync$SyncRationale;
    .param p4, "updateSynced"    # Z
    .param p5, "messageLabelChange"    # Z

    .prologue
    .line 502
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mConversationHelper:Lcom/google/android/gm/provider/ConversationUtil;

    move-wide v1, p1

    move-object v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/ConversationUtil;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 504
    return-void
.end method

.method public declared-synchronized onLabelsChanged()V
    .locals 13

    .prologue
    const-wide/16 v11, 0x1

    .line 1142
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Must be in transaction"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 1144
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mIdToLabel:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 1145
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mCanonicalNameToLabel:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 1146
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->requery()V

    .line 1148
    const-wide/16 v4, 0x0

    .line 1149
    const-wide/16 v2, -0x1

    .line 1151
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getQueryMap()Landroid/content/ContentQueryMap;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/ContentQueryMap;->getRows()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 1152
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v7

    .line 1153
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "canonicalName"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1154
    if-nez v0, :cond_1

    .line 1155
    const-string v0, "Gmail"

    const-string v1, "Null canonical name in onLabelsChanged"

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v0, v1, v7}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 1158
    :cond_1
    new-instance v9, Lcom/google/android/gm/provider/MailCore$Label;

    invoke-direct {v9, v7, v8, v0}, Lcom/google/android/gm/provider/MailCore$Label;-><init>(JLjava/lang/String;)V

    .line 1159
    invoke-static {v7, v8}, Lcom/google/android/gm/provider/MailCore;->isLabelIdLocal(J)Z

    move-result v1

    invoke-static {v0}, Lcom/google/android/gm/provider/MailCore;->isCanonicalLabelNameLocal(Ljava/lang/String;)Z

    move-result v10

    if-eq v1, v10, :cond_2

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Lcom/google/android/gm/provider/Gmail;->LOCAL_PRIORITY_LABELS:Lcom/google/common/collect/BiMap;

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/google/common/collect/BiMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 1162
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Not clear whether label is local: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1164
    :cond_2
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mIdToLabel:Ljava/util/Map;

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1165
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mCanonicalNameToLabel:Ljava/util/Map;

    iget-object v1, v9, Lcom/google/android/gm/provider/MailCore$Label;->canonicalName:Ljava/lang/String;

    invoke-interface {v0, v1, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1166
    cmp-long v0, v7, v4

    if-lez v0, :cond_3

    iget-wide v0, v9, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    move-wide v4, v0

    .line 1167
    :cond_3
    invoke-static {v7, v8}, Lcom/google/android/gm/provider/MailCore;->isLabelIdLocal(J)Z

    move-result v0

    if-eqz v0, :cond_5

    cmp-long v0, v7, v2

    if-gez v0, :cond_5

    .line 1168
    iget-wide v0, v9, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    :goto_1
    move-wide v2, v0

    .line 1170
    goto/16 :goto_0

    .line 1172
    :cond_4
    add-long v0, v4, v11

    iput-wide v0, p0, Lcom/google/android/gm/provider/MailCore;->mNextServerLabelId:J

    .line 1173
    sub-long v0, v2, v11

    iput-wide v0, p0, Lcom/google/android/gm/provider/MailCore;->mNextLocalLabelId:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1174
    monitor-exit p0

    return-void

    :cond_5
    move-wide v0, v2

    goto :goto_1
.end method

.method public purgeConversation(J)Z
    .locals 9
    .param p1, "conversationId"    # J

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 516
    new-array v1, v3, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v4

    .line 517
    .local v1, "queryArgs":[Ljava/lang/String;
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "conversation_labels"

    const-string v7, "conversation_id = ? AND queryId = 0"

    invoke-virtual {v5, v6, v7, v1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 519
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "conversations"

    const-string v7, "_id = ? AND queryId = 0"

    invoke-virtual {v5, v6, v7, v1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 521
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "message_labels"

    const-string v7, "message_conversation = ?"

    invoke-virtual {v5, v6, v7, v1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 523
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "messages"

    const-string v7, "conversation = ? AND queryId = 0"

    invoke-virtual {v5, v6, v7, v1}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 524
    .local v0, "count":I
    const-string v5, "Gmail"

    const-string v6, "Purged %d messages in conversation %d"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v4

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v7, v3

    invoke-static {v5, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 527
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 528
    .local v2, "values":Landroid/content/ContentValues;
    const-string v5, "status"

    const/4 v6, -0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 529
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "attachments"

    const-string v7, "messages_conversation = ?"

    invoke-virtual {v5, v6, v2, v7, v1}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 531
    if-eqz v0, :cond_0

    :goto_0
    return v3

    :cond_0
    move v3, v4

    goto :goto_0
.end method

.method public queryConversationIdForMessageId(J)J
    .locals 4
    .param p1, "messageId"    # J

    .prologue
    .line 465
    const/4 v2, 0x1

    :try_start_0
    new-array v0, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v2

    .line 466
    .local v0, "bindArgs":[Ljava/lang/String;
    iget-object v2, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "select conversation from messages where messageId = ?"

    invoke-static {v2, v3, v0}, Landroid/database/DatabaseUtils;->longForQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    :try_end_0
    .catch Landroid/database/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    .line 470
    .end local v0    # "bindArgs":[Ljava/lang/String;
    :goto_0
    return-wide v2

    .line 468
    :catch_0
    move-exception v1

    .line 470
    .local v1, "e":Landroid/database/SQLException;
    const-wide/16 v2, 0x0

    goto :goto_0
.end method

.method public removeCustomFromPreference(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "linkedAccount"    # Ljava/lang/String;
    .param p2, "preferenceName"    # Ljava/lang/String;

    .prologue
    .line 1024
    const-string v1, "/customfrom/"

    const-string v2, ""

    invoke-virtual {p2, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 1025
    .local v0, "account":Ljava/lang/String;
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/google/android/gm/utils/CustomFromUtils;->removeCustomFrom(Landroid/net/Uri;Ljava/lang/String;)V

    .line 1028
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 1031
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1034
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "custom_from_prefs"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "_id="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1037
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1039
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1041
    return-void

    .line 1039
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
.end method

.method public renameLabel(Lcom/google/android/gm/provider/MailCore$Label;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    .locals 8
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;
    .param p2, "canonicalName"    # Ljava/lang/String;
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "color"    # I
    .param p5, "visibility"    # Ljava/lang/String;

    .prologue
    .line 816
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Must be in transaction"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 818
    :cond_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 819
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "canonicalName"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 820
    const-string v1, "name"

    invoke-virtual {v0, v1, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 821
    const-string v1, "color"

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 822
    const-string v1, "visibility"

    invoke-virtual {v0, v1, p5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 824
    invoke-direct {p0, p2, v0}, Lcom/google/android/gm/provider/MailCore;->adjustContentValuesForSystemLabel(Ljava/lang/String;Landroid/content/ContentValues;)V

    .line 826
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "labels"

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-wide v6, p1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 827
    return-void
.end method

.method public setConfig([Lcom/google/android/gm/provider/MailCore$Label;[Lcom/google/android/gm/provider/MailCore$Label;)V
    .locals 7
    .param p1, "labelsIncluded"    # [Lcom/google/android/gm/provider/MailCore$Label;
    .param p2, "labelsPartial"    # [Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    .line 212
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v4

    iput-object v4, p0, Lcom/google/android/gm/provider/MailCore;->mLabelIdsIncludedOrPartial:Ljava/util/Map;

    .line 213
    move-object v0, p1

    .local v0, "arr$":[Lcom/google/android/gm/provider/MailCore$Label;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v2, v0, v1

    .line 214
    .local v2, "label":Lcom/google/android/gm/provider/MailCore$Label;
    if-eqz v2, :cond_0

    .line 215
    iget-object v4, p0, Lcom/google/android/gm/provider/MailCore;->mLabelIdsIncludedOrPartial:Ljava/util/Map;

    iget-wide v5, v2, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    const/4 v6, 0x1

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 213
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 218
    .end local v2    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    :cond_1
    move-object v0, p2

    array-length v3, v0

    const/4 v1, 0x0

    :goto_1
    if-ge v1, v3, :cond_3

    aget-object v2, v0, v1

    .line 219
    .restart local v2    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    if-eqz v2, :cond_2

    .line 220
    iget-object v4, p0, Lcom/google/android/gm/provider/MailCore;->mLabelIdsIncludedOrPartial:Ljava/util/Map;

    iget-wide v5, v2, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    const/4 v6, 0x0

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 218
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 223
    .end local v2    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    :cond_3
    return-void
.end method

.method public setCustomFromPreference(Ljava/lang/String;Ljava/util/Map;Z)V
    .locals 9
    .param p1, "account"    # Ljava/lang/String;
    .param p3, "isStartSync"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/MailStore$CustomFromPreference;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 977
    .local p2, "fromPreferences":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomFromPreference;>;"
    :try_start_0
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 979
    if-eqz p3, :cond_0

    .line 982
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "custom_from_prefs"

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual {v5, v6, v7, v8}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 983
    invoke-static {p1}, Lcom/google/android/gm/utils/CustomFromUtils;->clearCustomFrom(Ljava/lang/String;)V

    .line 987
    :cond_0
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 988
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomFromPreference;>;"
    new-instance v4, Landroid/content/ContentValues;

    invoke-direct {v4}, Landroid/content/ContentValues;-><init>()V

    .line 989
    .local v4, "values":Landroid/content/ContentValues;
    const-string v6, "name"

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;

    iget-object v5, v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;->name:Ljava/lang/String;

    invoke-virtual {v4, v6, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 990
    const-string v6, "is_default"

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;

    iget-object v5, v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;->isDefault:Ljava/lang/String;

    invoke-virtual {v4, v6, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 991
    const-string v6, "reply_to"

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;

    iget-object v5, v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;->replyTo:Ljava/lang/String;

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    :goto_1
    invoke-virtual {v4, v6, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 993
    const-string v6, "address"

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;

    iget-object v5, v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;->address:Ljava/lang/String;

    invoke-virtual {v4, v6, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 994
    const-string v6, "_id"

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v4, v6, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 995
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "custom_from_prefs"

    const/4 v7, 0x0

    const/4 v8, 0x5

    invoke-virtual {v5, v6, v7, v4, v8}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1004
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomFromPreference;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v5

    iget-object v6, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v6}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v5

    .line 991
    .restart local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomFromPreference;>;"
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "values":Landroid/content/ContentValues;
    :cond_1
    :try_start_1
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;

    iget-object v5, v5, Lcom/google/android/gm/provider/MailStore$CustomFromPreference;->replyTo:Ljava/lang/String;

    goto :goto_1

    .line 998
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomFromPreference;>;"
    .end local v4    # "values":Landroid/content/ContentValues;
    :cond_2
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 1000
    invoke-static {p1}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 1001
    .local v0, "accountUri":Landroid/net/Uri;
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailCore;->getCursorForCustomFrom()Landroid/database/Cursor;

    move-result-object v1

    .line 1002
    .local v1, "cursor":Landroid/database/Cursor;
    invoke-static {v0, v1}, Lcom/google/android/gm/utils/CustomFromUtils;->instantiateCustomFrom(Landroid/net/Uri;Landroid/database/Cursor;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1004
    iget-object v5, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1006
    return-void
.end method

.method public setCustomLabelColorPreference(Ljava/lang/String;Ljava/util/Map;)V
    .locals 7
    .param p1, "account"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 943
    .local p2, "colorPreferences":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;>;"
    :try_start_0
    iget-object v3, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 947
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 948
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;>;"
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 949
    .local v2, "values":Landroid/content/ContentValues;
    sget-object v4, Lcom/google/android/gm/utils/LabelColorUtils;->CUSTOM_COLOR_INDEX:Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v2, v4, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 950
    sget-object v4, Lcom/google/android/gm/utils/LabelColorUtils;->CUSTOM_TEXT_COLOR:Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;->textColor:Ljava/lang/String;

    invoke-virtual {v2, v4, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 951
    sget-object v4, Lcom/google/android/gm/utils/LabelColorUtils;->CUSTOM_BACKGROUND_COLOR:Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;->backgroundColor:Ljava/lang/String;

    invoke-virtual {v2, v4, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 953
    const-string v4, "_id"

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v4, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 954
    iget-object v3, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "custom_label_color_prefs"

    const/4 v5, 0x0

    const/4 v6, 0x5

    invoke-virtual {v3, v4, v5, v2, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    .line 959
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;

    invoke-static {p1, v3, v4}, Lcom/google/android/gm/utils/LabelColorUtils;->addOrUpdateCustomLabelColor(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 964
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v3

    iget-object v4, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v3

    .line 962
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    iget-object v3, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 964
    iget-object v3, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 966
    return-void
.end method

.method public setInfoOverloadArrowsOffPreference(Ljava/lang/String;)V
    .locals 3
    .param p1, "infoOverloadArrowsOffPref"    # Ljava/lang/String;

    .prologue
    .line 1115
    const-string v1, "bx_ioao"

    invoke-static {v1, p1}, Lcom/google/common/collect/ImmutableMap;->of(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap;

    move-result-object v0

    .line 1118
    .local v0, "serverPreferences":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Lcom/google/android/gm/provider/MailCore;->setServerPreferences(Ljava/lang/String;Ljava/util/Map;)V

    .line 1120
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mUserGmailPrefs:Ljava/util/Map;

    const-string v2, "bx_ioao"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1121
    return-void
.end method

.method public setInfoOverloadEnabledPreference(Ljava/lang/String;)V
    .locals 5
    .param p1, "infoOverloadEnabledPref"    # Ljava/lang/String;

    .prologue
    .line 1090
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 1091
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1092
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "enabled_pref"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1095
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "info_overload"

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 1097
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "info_overload"

    const/4 v3, 0x0

    const/4 v4, 0x5

    invoke-virtual {v1, v2, v3, v0, v4}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    .line 1101
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mUserGmailPrefs:Ljava/util/Map;

    const-string v2, "sx_ioe"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1102
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1104
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1106
    return-void

    .line 1104
    .end local v0    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
.end method

.method public setLabelCounts(Lcom/google/android/gm/provider/MailCore$Label;IIILjava/lang/String;)V
    .locals 8
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;
    .param p2, "conversations"    # I
    .param p3, "unreadConversations"    # I
    .param p4, "color"    # I
    .param p5, "visibility"    # Ljava/lang/String;

    .prologue
    .line 847
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 848
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "numConversations"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 849
    const-string v1, "numUnreadConversations"

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 851
    const-string v1, "color"

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 852
    const-string v1, "visibility"

    invoke-virtual {v0, v1, p5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 853
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 855
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v2, "labels"

    const-string v3, "_id = ?"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    iget-wide v6, p1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 856
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 857
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailCore;->onLabelsChanged()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 859
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 861
    return-void

    .line 859
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v1
.end method

.method public setLabelOnConversation(JJLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V
    .locals 9
    .param p1, "conversationId"    # J
    .param p3, "maxMessageId"    # J
    .param p5, "label"    # Lcom/google/android/gm/provider/MailCore$Label;
    .param p6, "on"    # Z
    .param p7, "recordHistory"    # Lcom/google/android/gm/provider/Operations$RecordHistory;

    .prologue
    .line 374
    iget-wide v5, p5, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p3

    move v7, p6

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lcom/google/android/gm/provider/MailCore;->setLabelOnConversation(JJJZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 375
    return-void
.end method

.method public setLabelOnMessage(JLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V
    .locals 7
    .param p1, "messageId"    # J
    .param p3, "label"    # Lcom/google/android/gm/provider/MailCore$Label;
    .param p4, "on"    # Z
    .param p5, "recordHistory"    # Lcom/google/android/gm/provider/Operations$RecordHistory;

    .prologue
    .line 241
    iget-wide v3, p3, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    move-object v0, p0

    move-wide v1, p1

    move v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JJZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 242
    return-void
.end method

.method public setLabelsOnMessageWithoutWritingOperations(JLjava/util/Set;)V
    .locals 10
    .param p1, "messageId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 360
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "message_labels"

    const-string v2, "message_messageId = ?"

    new-array v6, v5, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v6, v7

    invoke-virtual {v0, v1, v2, v6}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 363
    invoke-interface {p3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    .line 366
    .local v3, "labelId":J
    sget-object v6, Lcom/google/android/gm/provider/Operations$RecordHistory;->FALSE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    move-object v0, p0

    move-wide v1, p1

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JJZLcom/google/android/gm/provider/Operations$RecordHistory;Z)V

    goto :goto_0

    .line 369
    .end local v3    # "labelId":J
    :cond_0
    return-void
.end method

.method public setNotificationRequests(Ljava/util/Collection;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gm/provider/MailCore$NotificationRequest;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 204
    .local p1, "notificationRequests":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/MailCore$NotificationRequest;>;"
    iput-object p1, p0, Lcom/google/android/gm/provider/MailCore;->mNotificationRequests:Ljava/util/Collection;

    .line 205
    return-void
.end method

.method public setServerPreferences(Ljava/lang/String;Ljava/util/Map;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1052
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 1056
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 1057
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 1058
    const-string v4, "name"

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v3, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1059
    const-string v4, "value"

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v3, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1061
    const-string v4, "_id"

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v3, v4, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1062
    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "server_preferences"

    const/4 v5, 0x0

    const/4 v6, 0x5

    invoke-virtual {v1, v4, v5, v3, v6}, Landroid/database/sqlite/SQLiteDatabase;->insertWithOnConflict(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;I)J

    .line 1064
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    sget-object v3, Lcom/google/android/gm/utils/CustomFromUtils;->REPLY_FROM_DEFAULT_SETTING:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1068
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string v3, "sx_rt"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1069
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/google/android/gm/utils/OutgoingMsgPrefs;->addOrUpdateReplyTo(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 1076
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v0

    .line 1070
    :cond_1
    :try_start_1
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string v3, "sx_dn"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1071
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/google/android/gm/utils/OutgoingMsgPrefs;->addOrUpdateDisplayName(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1074
    :cond_2
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1076
    iget-object v0, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 1078
    return-void
.end method

.method public setServerVersion(J)V
    .locals 0
    .param p1, "serverVersion"    # J

    .prologue
    .line 200
    iput-wide p1, p0, Lcom/google/android/gm/provider/MailCore;->mServerVersion:J

    .line 201
    return-void
.end method

.method updateLabelsLastTouched(Landroid/content/ContentValues;)I
    .locals 12
    .param p1, "lastTouchedMap"    # Landroid/content/ContentValues;

    .prologue
    const/4 v8, 0x0

    .line 871
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/content/ContentValues;->size()I

    move-result v9

    if-nez v9, :cond_1

    .line 872
    :cond_0
    const-string v9, "Gmail"

    const-string v10, "Attempting to update recent labels with empty or null map: %s"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    aput-object p1, v11, v8

    invoke-static {v9, v10, v11}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 931
    :goto_0
    return v8

    .line 884
    :cond_1
    invoke-virtual {p1}, Landroid/content/ContentValues;->size()I

    move-result v9

    mul-int/lit8 v9, v9, 0x3

    new-array v0, v9, [Ljava/lang/String;

    .line 885
    .local v0, "args":[Ljava/lang/String;
    const/4 v8, 0x0

    .line 886
    .local v8, "rows":I
    const/4 v5, 0x0

    .line 887
    .local v5, "nArgs":I
    const/4 v3, 0x1

    .line 892
    .local v3, "first":Z
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v9, "UPDATE labels SET "

    invoke-direct {v7, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 893
    .local v7, "query":Ljava/lang/StringBuilder;
    const-string v9, "lastTouched"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 894
    const-string v9, " = (CASE "

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 895
    const-string v9, "canonicalName"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 897
    invoke-virtual {p1}, Landroid/content/ContentValues;->keySet()Ljava/util/Set;

    move-result-object v2

    .line 899
    .local v2, "canonicalNameSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 900
    .local v1, "canonicalName":Ljava/lang/String;
    const-string v9, " WHEN ?"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 901
    add-int/lit8 v6, v5, 0x1

    .end local v5    # "nArgs":I
    .local v6, "nArgs":I
    aput-object v1, v0, v5

    .line 902
    const-string v9, " THEN ?"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 903
    add-int/lit8 v5, v6, 0x1

    .end local v6    # "nArgs":I
    .restart local v5    # "nArgs":I
    invoke-virtual {p1, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v0, v6

    goto :goto_1

    .line 905
    .end local v1    # "canonicalName":Ljava/lang/String;
    :cond_2
    const-string v9, " END)"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 908
    const-string v9, " WHERE "

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 909
    const-string v9, "canonicalName"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 910
    const-string v9, " IN ("

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 911
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 912
    .restart local v1    # "canonicalName":Ljava/lang/String;
    if-eqz v3, :cond_3

    .line 913
    const/4 v3, 0x0

    .line 917
    :goto_3
    const-string v9, "?"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 918
    add-int/lit8 v6, v5, 0x1

    .end local v5    # "nArgs":I
    .restart local v6    # "nArgs":I
    aput-object v1, v0, v5

    move v5, v6

    .end local v6    # "nArgs":I
    .restart local v5    # "nArgs":I
    goto :goto_2

    .line 915
    :cond_3
    const-string v9, ", "

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 920
    .end local v1    # "canonicalName":Ljava/lang/String;
    :cond_4
    const-string v9, ")"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 922
    iget-object v9, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v9}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 924
    :try_start_0
    iget-object v9, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 925
    iget-object v9, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v9}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 926
    const/4 v8, 0x1

    .line 929
    iget-object v9, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v9}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    goto/16 :goto_0

    :catchall_0
    move-exception v9

    iget-object v10, p0, Lcom/google/android/gm/provider/MailCore;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v10}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v9
.end method
