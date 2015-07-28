.class public Lcom/google/android/gm/provider/SenderInstructions;
.super Ljava/lang/Object;
.source "SenderInstructions.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/SenderInstructions$Sender;,
        Lcom/google/android/gm/provider/SenderInstructions$Visibility;
    }
.end annotation


# instance fields
.field private numDrafts:I

.field private numVisible:I

.field private final seen:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final senders:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/SenderInstructions$Sender;",
            ">;"
        }
    .end annotation
.end field

.field private state:I

.field private final unreadAuthors:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final unreadSeen:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 20
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 40
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    .line 41
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->seen:Ljava/util/Set;

    .line 42
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->unreadSeen:Ljava/util/Set;

    .line 43
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->unreadAuthors:Ljava/util/Set;

    .line 44
    iput v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->state:I

    .line 45
    iput v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->numVisible:I

    .line 46
    iput v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->numDrafts:I

    return-void
.end method

.method private addNextSender()V
    .locals 5

    .prologue
    const/4 v3, 0x2

    .line 128
    iget v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->state:I

    packed-switch v2, :pswitch_data_0

    .line 145
    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    iget v3, p0, Lcom/google/android/gm/provider/SenderInstructions;->state:I

    add-int/lit8 v3, v3, -0x2

    sub-int v0, v2, v3

    .line 146
    .local v0, "pos":I
    iget v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->state:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->state:I

    .line 151
    :goto_0
    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    .line 152
    .local v1, "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    iget-object v2, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    sget-object v3, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->VISIBLE:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    if-eq v2, v3, :cond_2

    .line 153
    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->seen:Ljava/util/Set;

    iget-object v3, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-boolean v2, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    if-eqz v2, :cond_7

    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->unreadSeen:Ljava/util/Set;

    iget-object v3, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_7

    .line 155
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->seen:Ljava/util/Set;

    iget-object v3, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 156
    iget-boolean v2, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    if-eqz v2, :cond_1

    .line 157
    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->unreadSeen:Ljava/util/Set;

    iget-object v3, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 159
    :cond_1
    sget-object v2, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->VISIBLE:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    iput-object v2, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    .line 160
    iget v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->numVisible:I

    iput v2, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->priority:I

    .line 161
    iget v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->numVisible:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->numVisible:I

    .line 166
    :cond_2
    :goto_1
    return-void

    .line 130
    .end local v0    # "pos":I
    .end local v1    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    :pswitch_0
    const/4 v0, 0x0

    .line 131
    .restart local v0    # "pos":I
    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    const/4 v4, 0x0

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    iget-boolean v2, v2, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    if-nez v2, :cond_3

    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->unreadAuthors:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v2

    if-nez v2, :cond_4

    :cond_3
    move v2, v3

    :goto_2
    iput v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->state:I

    goto :goto_0

    :cond_4
    const/4 v2, 0x1

    goto :goto_2

    .line 136
    .end local v0    # "pos":I
    :pswitch_1
    const/4 v0, 0x1

    .restart local v0    # "pos":I
    :goto_3
    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_5

    .line 137
    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    iget-boolean v2, v2, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    if-eqz v2, :cond_6

    .line 141
    :cond_5
    iput v3, p0, Lcom/google/android/gm/provider/SenderInstructions;->state:I

    goto :goto_0

    .line 136
    :cond_6
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 163
    .restart local v1    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    :cond_7
    sget-object v2, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->SKIPPED:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    iput-object v2, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    goto :goto_1

    .line 128
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public addMessage(Ljava/lang/String;ZZZI)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "draft"    # Z
    .param p3, "unread"    # Z
    .param p4, "sentByMe"    # Z
    .param p5, "priority"    # I

    .prologue
    .line 69
    if-eqz p2, :cond_1

    .line 70
    iget v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->numDrafts:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->numDrafts:I

    .line 82
    .end local p1    # "name":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 72
    .restart local p1    # "name":Ljava/lang/String;
    :cond_1
    new-instance v0, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    invoke-direct {v0}, Lcom/google/android/gm/provider/SenderInstructions$Sender;-><init>()V

    .line 73
    .local v0, "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    if-eqz p4, :cond_2

    const-string p1, ""

    .end local p1    # "name":Ljava/lang/String;
    :cond_2
    iput-object p1, v0, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    .line 74
    iput-boolean p3, v0, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    .line 75
    sget-object v1, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->HIDDEN:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    iput-object v1, v0, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    .line 76
    iput p5, v0, Lcom/google/android/gm/provider/SenderInstructions$Sender;->priority:I

    .line 77
    iget-object v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 78
    iget-boolean v1, v0, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    if-eqz v1, :cond_0

    .line 79
    iget-object v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->unreadAuthors:Ljava/util/Set;

    iget-object v2, v0, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method protected calculateVisibility(I)V
    .locals 4
    .param p1, "maxVisibleSenders"    # I

    .prologue
    .line 88
    :goto_0
    invoke-virtual {p0}, Lcom/google/android/gm/provider/SenderInstructions;->canAddMore()Z

    move-result v2

    if-eqz v2, :cond_0

    iget v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->numVisible:I

    if-ge v2, p1, :cond_0

    .line 89
    invoke-direct {p0}, Lcom/google/android/gm/provider/SenderInstructions;->addNextSender()V

    goto :goto_0

    .line 93
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    .line 94
    .local v1, "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    iget-object v2, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    sget-object v3, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->HIDDEN:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Lcom/google/android/gm/provider/SenderInstructions;->seen:Ljava/util/Set;

    iget-object v3, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 96
    sget-object v2, Lcom/google/android/gm/provider/SenderInstructions$Visibility;->SKIPPED:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    iput-object v2, v1, Lcom/google/android/gm/provider/SenderInstructions$Sender;->visibility:Lcom/google/android/gm/provider/SenderInstructions$Visibility;

    goto :goto_1

    .line 99
    .end local v1    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    :cond_2
    return-void
.end method

.method public canAddMore()Z
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->state:I

    iget-object v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x2

    add-int/lit8 v1, v1, -0x1

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getNumDrafts()I
    .locals 1

    .prologue
    .line 102
    iget v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->numDrafts:I

    return v0
.end method

.method public getNumVisible()I
    .locals 1

    .prologue
    .line 114
    iget v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->numVisible:I

    return v0
.end method

.method public getSenders()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gm/provider/SenderInstructions$Sender;",
            ">;"
        }
    .end annotation

    .prologue
    .line 110
    iget-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    return-object v0
.end method

.method public reset()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 49
    iget-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->senders:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 50
    iget-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->seen:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 51
    iget-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->unreadSeen:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 52
    iget-object v0, p0, Lcom/google/android/gm/provider/SenderInstructions;->unreadAuthors:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 53
    iput v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->state:I

    .line 54
    iput v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->numDrafts:I

    .line 55
    iput v1, p0, Lcom/google/android/gm/provider/SenderInstructions;->numVisible:I

    .line 56
    return-void
.end method

.method setNumDrafts(I)V
    .locals 0
    .param p1, "nDrafts"    # I

    .prologue
    .line 106
    iput p1, p0, Lcom/google/android/gm/provider/SenderInstructions;->numDrafts:I

    .line 107
    return-void
.end method
