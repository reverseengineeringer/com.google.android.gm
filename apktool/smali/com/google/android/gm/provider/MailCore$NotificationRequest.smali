.class public final Lcom/google/android/gm/provider/MailCore$NotificationRequest;
.super Ljava/lang/Object;
.source "MailCore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailCore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "NotificationRequest"
.end annotation


# instance fields
.field private final mLabelId:J

.field private final mRequiredAbsentLabelIds:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final mRequiredPresentLabelIds:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final mTagLabelId:J


# direct methods
.method public constructor <init>(JJLjava/util/Set;Ljava/util/Set;)V
    .locals 0
    .param p1, "labelId"    # J
    .param p3, "tagLabelId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 115
    .local p5, "requiredPresentLabelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .local p6, "requiredAbsentLabelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 116
    iput-wide p1, p0, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->mLabelId:J

    .line 117
    iput-wide p3, p0, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->mTagLabelId:J

    .line 118
    iput-object p5, p0, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->mRequiredPresentLabelIds:Ljava/util/Set;

    .line 119
    iput-object p6, p0, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->mRequiredAbsentLabelIds:Ljava/util/Set;

    .line 120
    return-void
.end method


# virtual methods
.method public final conversationMatches(Ljava/util/Set;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, "labels":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    const/4 v2, 0x0

    .line 123
    iget-object v3, p0, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->mRequiredPresentLabelIds:Ljava/util/Set;

    invoke-interface {p1, v3}, Ljava/util/Set;->containsAll(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 127
    :goto_0
    return v2

    .line 124
    :cond_0
    iget-object v3, p0, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->mRequiredAbsentLabelIds:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 125
    .local v1, "requiredAbsentLabel":Ljava/lang/Long;
    invoke-interface {p1, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    goto :goto_0

    .line 127
    .end local v1    # "requiredAbsentLabel":Ljava/lang/Long;
    :cond_2
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public final getLabelId()J
    .locals 2

    .prologue
    .line 131
    iget-wide v0, p0, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->mLabelId:J

    return-wide v0
.end method

.method public final getTagLabelId()J
    .locals 2

    .prologue
    .line 135
    iget-wide v0, p0, Lcom/google/android/gm/provider/MailCore$NotificationRequest;->mTagLabelId:J

    return-wide v0
.end method
