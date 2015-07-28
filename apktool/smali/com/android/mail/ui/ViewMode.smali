.class public Lcom/android/mail/ui/ViewMode;
.super Ljava/lang/Object;
.source "ViewMode.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/ViewMode$ModeChangeListener;
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field private final mListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/ViewMode$ModeChangeListener;",
            ">;"
        }
    .end annotation
.end field

.field private mMode:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/android/mail/ui/ViewMode;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 82
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 75
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ViewMode;->mListeners:Ljava/util/ArrayList;

    .line 80
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/ui/ViewMode;->mMode:I

    .line 84
    return-void
.end method

.method private dispatchModeChange()V
    .locals 4

    .prologue
    .line 99
    new-instance v1, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/android/mail/ui/ViewMode;->mListeners:Ljava/util/ArrayList;

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 100
    .local v1, "list":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ViewMode$ModeChangeListener;>;"
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/ui/ViewMode$ModeChangeListener;

    .line 101
    .local v2, "listener":Lcom/android/mail/ui/ViewMode$ModeChangeListener;
    sget-boolean v3, Lcom/android/mail/ui/ViewMode;->$assertionsDisabled:Z

    if-nez v3, :cond_0

    if-nez v2, :cond_0

    new-instance v3, Ljava/lang/AssertionError;

    invoke-direct {v3}, Ljava/lang/AssertionError;-><init>()V

    throw v3

    .line 102
    :cond_0
    iget v3, p0, Lcom/android/mail/ui/ViewMode;->mMode:I

    invoke-interface {v2, v3}, Lcom/android/mail/ui/ViewMode$ModeChangeListener;->onViewModeChanged(I)V

    goto :goto_0

    .line 104
    .end local v2    # "listener":Lcom/android/mail/ui/ViewMode$ModeChangeListener;
    :cond_1
    return-void
.end method

.method public static final isConversationMode(I)Z
    .locals 2
    .param p0, "mode"    # I

    .prologue
    const/4 v0, 0x1

    .line 182
    if-eq p0, v0, :cond_0

    const/4 v1, 0x5

    if-ne p0, v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static final isListMode(I)Z
    .locals 1
    .param p0, "mode"    # I

    .prologue
    .line 174
    const/4 v0, 0x2

    if-eq p0, v0, :cond_0

    const/4 v0, 0x4

    if-ne p0, v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setModeInternal(I)Z
    .locals 1
    .param p1, "mode"    # I

    .prologue
    .line 225
    iget v0, p0, Lcom/android/mail/ui/ViewMode;->mMode:I

    if-ne v0, p1, :cond_0

    .line 226
    const/4 v0, 0x0

    .line 230
    :goto_0
    return v0

    .line 228
    :cond_0
    iput p1, p0, Lcom/android/mail/ui/ViewMode;->mMode:I

    .line 229
    invoke-direct {p0}, Lcom/android/mail/ui/ViewMode;->dispatchModeChange()V

    .line 230
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public addListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/android/mail/ui/ViewMode$ModeChangeListener;

    .prologue
    .line 91
    iget-object v0, p0, Lcom/android/mail/ui/ViewMode;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 92
    return-void
.end method

.method public enterConversationListMode()Z
    .locals 1

    .prologue
    .line 111
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ViewMode;->setModeInternal(I)Z

    move-result v0

    return v0
.end method

.method public enterConversationMode()Z
    .locals 1

    .prologue
    .line 119
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ViewMode;->setModeInternal(I)Z

    move-result v0

    return v0
.end method

.method public enterFolderListMode()Z
    .locals 1

    .prologue
    .line 127
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ViewMode;->setModeInternal(I)Z

    move-result v0

    return v0
.end method

.method public enterSearchResultsConversationMode()Z
    .locals 1

    .prologue
    .line 147
    const/4 v0, 0x5

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ViewMode;->setModeInternal(I)Z

    move-result v0

    return v0
.end method

.method public enterSearchResultsListMode()Z
    .locals 1

    .prologue
    .line 137
    const/4 v0, 0x4

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ViewMode;->setModeInternal(I)Z

    move-result v0

    return v0
.end method

.method public enterWaitingForInitializationMode()Z
    .locals 1

    .prologue
    .line 156
    const/4 v0, 0x6

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ViewMode;->setModeInternal(I)Z

    move-result v0

    return v0
.end method

.method public getMode()I
    .locals 1

    .prologue
    .line 163
    iget v0, p0, Lcom/android/mail/ui/ViewMode;->mMode:I

    return v0
.end method

.method public handleRestore(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "inState"    # Landroid/os/Bundle;

    .prologue
    .line 191
    if-nez p1, :cond_1

    .line 199
    :cond_0
    :goto_0
    return-void

    .line 195
    :cond_1
    const-string v1, "view-mode"

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 196
    .local v0, "newMode":I
    if-eqz v0, :cond_0

    .line 197
    invoke-direct {p0, v0}, Lcom/android/mail/ui/ViewMode;->setModeInternal(I)Z

    goto :goto_0
.end method

.method public handleSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 206
    if-nez p1, :cond_0

    .line 210
    :goto_0
    return-void

    .line 209
    :cond_0
    const-string v0, "view-mode"

    iget v1, p0, Lcom/android/mail/ui/ViewMode;->mMode:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public isConversationMode()Z
    .locals 1

    .prologue
    .line 178
    iget v0, p0, Lcom/android/mail/ui/ViewMode;->mMode:I

    invoke-static {v0}, Lcom/android/mail/ui/ViewMode;->isConversationMode(I)Z

    move-result v0

    return v0
.end method

.method public isListMode()Z
    .locals 1

    .prologue
    .line 170
    iget v0, p0, Lcom/android/mail/ui/ViewMode;->mMode:I

    invoke-static {v0}, Lcom/android/mail/ui/ViewMode;->isListMode(I)Z

    move-result v0

    return v0
.end method

.method public removeListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/android/mail/ui/ViewMode$ModeChangeListener;

    .prologue
    .line 217
    iget-object v0, p0, Lcom/android/mail/ui/ViewMode;->mListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 218
    return-void
.end method
