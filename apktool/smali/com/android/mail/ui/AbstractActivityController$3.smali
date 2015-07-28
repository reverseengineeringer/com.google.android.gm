.class Lcom/android/mail/ui/AbstractActivityController$3;
.super Landroid/database/DataSetObservable;
.source "AbstractActivityController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractActivityController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractActivityController;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$3;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-direct {p0}, Landroid/database/DataSetObservable;-><init>()V

    return-void
.end method


# virtual methods
.method public registerObserver(Landroid/database/DataSetObserver;)V
    .locals 6
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 222
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController$3;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 223
    .local v0, "count":I
    invoke-super {p0, p1}, Landroid/database/DataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 224
    sget-object v1, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v2, "IN AAC.register(RecentFolder)Observer: %s before=%d after=%d"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$3;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 226
    return-void
.end method

.method public bridge synthetic registerObserver(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 219
    check-cast p1, Landroid/database/DataSetObserver;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AbstractActivityController$3;->registerObserver(Landroid/database/DataSetObserver;)V

    return-void
.end method

.method public unregisterObserver(Landroid/database/DataSetObserver;)V
    .locals 6
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 229
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController$3;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 230
    .local v0, "count":I
    invoke-super {p0, p1}, Landroid/database/DataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 231
    sget-object v1, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v2, "IN AAC.unregister(RecentFolder)Observer: %s before=%d after=%d"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$3;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 233
    return-void
.end method

.method public bridge synthetic unregisterObserver(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 219
    check-cast p1, Landroid/database/DataSetObserver;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AbstractActivityController$3;->unregisterObserver(Landroid/database/DataSetObserver;)V

    return-void
.end method
