.class public Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;
.super Ljava/lang/Object;
.source "AbstractConversationViewFragment.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Lcom/android/mail/ContactInfoSource;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "ContactLoaderCallbacks"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/android/mail/ContactInfoSource;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Lcom/google/common/collect/ImmutableMap",
        "<",
        "Ljava/lang/String;",
        "Lcom/android/mail/ContactInfo;",
        ">;>;"
    }
.end annotation


# instance fields
.field private mContactInfoMap:Lcom/google/common/collect/ImmutableMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/ContactInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mObservable:Landroid/database/DataSetObservable;

.field private mSenders:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;


# direct methods
.method protected constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;)V
    .locals 1

    .prologue
    .line 636
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 641
    new-instance v0, Landroid/database/DataSetObservable;

    invoke-direct {v0}, Landroid/database/DataSetObservable;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->mObservable:Landroid/database/DataSetObservable;

    return-void
.end method


# virtual methods
.method public getContactInfo(Ljava/lang/String;)Lcom/android/mail/ContactInfo;
    .locals 1
    .param p1, "email"    # Ljava/lang/String;

    .prologue
    .line 665
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->mContactInfoMap:Lcom/google/common/collect/ImmutableMap;

    if-nez v0, :cond_0

    .line 666
    const/4 v0, 0x0

    .line 668
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->mContactInfoMap:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v0, p1}, Lcom/google/common/collect/ImmutableMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ContactInfo;

    goto :goto_0
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 3
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Lcom/google/common/collect/ImmutableMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/ContactInfo;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 649
    new-instance v0, Lcom/android/mail/SenderInfoLoader;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v1, v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->mSenders:Ljava/util/Set;

    invoke-direct {v0, v1, v2}, Lcom/android/mail/SenderInfoLoader;-><init>(Landroid/content/Context;Ljava/util/Set;)V

    return-object v0
.end method

.method public onLoadFinished(Landroid/content/Loader;Lcom/google/common/collect/ImmutableMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Lcom/google/common/collect/ImmutableMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/ContactInfo;",
            ">;>;",
            "Lcom/google/common/collect/ImmutableMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/ContactInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 655
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Lcom/google/common/collect/ImmutableMap<Ljava/lang/String;Lcom/android/mail/ContactInfo;>;>;"
    .local p2, "data":Lcom/google/common/collect/ImmutableMap;, "Lcom/google/common/collect/ImmutableMap<Ljava/lang/String;Lcom/android/mail/ContactInfo;>;"
    iput-object p2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->mContactInfoMap:Lcom/google/common/collect/ImmutableMap;

    .line 656
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->mObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyChanged()V

    .line 657
    return-void
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 636
    check-cast p2, Lcom/google/common/collect/ImmutableMap;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->onLoadFinished(Landroid/content/Loader;Lcom/google/common/collect/ImmutableMap;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Lcom/google/common/collect/ImmutableMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/ContactInfo;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 661
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Lcom/google/common/collect/ImmutableMap<Ljava/lang/String;Lcom/android/mail/ContactInfo;>;>;"
    return-void
.end method

.method public registerObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 673
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->mObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 674
    return-void
.end method

.method public setSenders(Ljava/util/Set;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 644
    .local p1, "emailAddresses":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->mSenders:Ljava/util/Set;

    .line 645
    return-void
.end method

.method public unregisterObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 678
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->mObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 679
    return-void
.end method
