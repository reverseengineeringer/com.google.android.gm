.class public abstract Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;
.super Landroid/support/v4/view/PagerAdapter;
.source "BaseFragmentPagerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter$FragmentCache;
    }
.end annotation


# instance fields
.field private mCurTransaction:Landroid/app/FragmentTransaction;

.field private mCurrentPrimaryItem:Landroid/app/Fragment;

.field private mFragmentCache:Landroid/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/LruCache",
            "<",
            "Ljava/lang/String;",
            "Landroid/app/Fragment;",
            ">;"
        }
    .end annotation
.end field

.field private final mFragmentManager:Landroid/app/FragmentManager;


# direct methods
.method public constructor <init>(Landroid/app/FragmentManager;)V
    .locals 2
    .param p1, "fm"    # Landroid/app/FragmentManager;

    .prologue
    const/4 v0, 0x0

    .line 58
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 53
    iput-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    .line 54
    iput-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurrentPrimaryItem:Landroid/app/Fragment;

    .line 56
    new-instance v0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter$FragmentCache;

    const/4 v1, 0x5

    invoke-direct {v0, p0, v1}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter$FragmentCache;-><init>(Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;I)V

    iput-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mFragmentCache:Landroid/util/LruCache;

    .line 59
    iput-object p1, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mFragmentManager:Landroid/app/FragmentManager;

    .line 60
    return-void
.end method

.method static synthetic access$000(Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;)Landroid/app/FragmentTransaction;
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    return-object v0
.end method


# virtual methods
.method public destroyItem(Landroid/view/View;ILjava/lang/Object;)V
    .locals 3
    .param p1, "container"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 102
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    if-nez v2, :cond_0

    .line 103
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    :cond_0
    move-object v0, p3

    .line 108
    check-cast v0, Landroid/app/Fragment;

    .line 109
    .local v0, "fragment":Landroid/app/Fragment;
    invoke-virtual {v0}, Landroid/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v1

    .line 110
    .local v1, "name":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 114
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    invoke-virtual {p0, v2, p2}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->makeFragmentName(II)Ljava/lang/String;

    move-result-object v1

    .line 117
    :cond_1
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mFragmentCache:Landroid/util/LruCache;

    invoke-virtual {v2, v1, v0}, Landroid/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 118
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    invoke-virtual {v2, v0}, Landroid/app/FragmentTransaction;->detach(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 119
    return-void
.end method

.method public finishUpdate(Landroid/view/View;)V
    .locals 1
    .param p1, "container"    # Landroid/view/View;

    .prologue
    .line 138
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    if-eqz v0, :cond_0

    .line 139
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 140
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    .line 141
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v0}, Landroid/app/FragmentManager;->executePendingTransactions()Z

    .line 143
    :cond_0
    return-void
.end method

.method public abstract getItem(I)Landroid/app/Fragment;
.end method

.method public instantiateItem(Landroid/view/View;I)Ljava/lang/Object;
    .locals 5
    .param p1, "container"    # Landroid/view/View;
    .param p2, "position"    # I

    .prologue
    .line 73
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    if-nez v2, :cond_0

    .line 74
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    iput-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    .line 78
    :cond_0
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    invoke-virtual {p0, v2, p2}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->makeFragmentName(II)Ljava/lang/String;

    move-result-object v1

    .line 81
    .local v1, "name":Ljava/lang/String;
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mFragmentCache:Landroid/util/LruCache;

    invoke-virtual {v2, v1}, Landroid/util/LruCache;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v2, v1}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    .line 84
    .local v0, "fragment":Landroid/app/Fragment;
    if-eqz v0, :cond_2

    .line 86
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    invoke-virtual {v2, v0}, Landroid/app/FragmentTransaction;->attach(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 93
    :goto_0
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurrentPrimaryItem:Landroid/app/Fragment;

    if-eq v0, v2, :cond_1

    .line 94
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/app/Fragment;->setMenuVisibility(Z)V

    .line 97
    :cond_1
    return-object v0

    .line 88
    :cond_2
    invoke-virtual {p0, p2}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->getItem(I)Landroid/app/Fragment;

    move-result-object v0

    .line 90
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurTransaction:Landroid/app/FragmentTransaction;

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v4

    invoke-virtual {p0, v4, p2}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->makeFragmentName(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v0, v4}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    goto :goto_0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "object"    # Ljava/lang/Object;

    .prologue
    .line 148
    check-cast p2, Landroid/app/Fragment;

    .end local p2    # "object":Ljava/lang/Object;
    invoke-virtual {p2}, Landroid/app/Fragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 149
    .local v0, "root":Landroid/view/View;
    move-object v1, p1

    :goto_0
    instance-of v2, v1, Landroid/view/View;

    if-eqz v2, :cond_1

    .line 150
    if-ne v1, v0, :cond_0

    .line 151
    const/4 v2, 0x1

    .line 154
    :goto_1
    return v2

    .line 149
    :cond_0
    check-cast v1, Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    .local v1, "v":Landroid/view/ViewParent;
    goto :goto_0

    .line 154
    .end local v1    # "v":Landroid/view/ViewParent;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method protected makeFragmentName(II)Ljava/lang/String;
    .locals 2
    .param p1, "viewId"    # I
    .param p2, "index"    # I

    .prologue
    .line 168
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "android:switcher:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public restoreState(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V
    .locals 0
    .param p1, "state"    # Landroid/os/Parcelable;
    .param p2, "loader"    # Ljava/lang/ClassLoader;

    .prologue
    .line 164
    return-void
.end method

.method public saveState()Landroid/os/Parcelable;
    .locals 1

    .prologue
    .line 159
    const/4 v0, 0x0

    return-object v0
.end method

.method public setPrimaryItem(Landroid/view/View;ILjava/lang/Object;)V
    .locals 3
    .param p1, "container"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 123
    move-object v0, p3

    check-cast v0, Landroid/app/Fragment;

    .line 124
    .local v0, "fragment":Landroid/app/Fragment;
    iget-object v1, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurrentPrimaryItem:Landroid/app/Fragment;

    if-eq v0, v1, :cond_2

    .line 125
    iget-object v1, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurrentPrimaryItem:Landroid/app/Fragment;

    if-eqz v1, :cond_0

    .line 126
    iget-object v1, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurrentPrimaryItem:Landroid/app/Fragment;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/app/Fragment;->setMenuVisibility(Z)V

    .line 128
    :cond_0
    if-eqz v0, :cond_1

    .line 129
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/Fragment;->setMenuVisibility(Z)V

    .line 131
    :cond_1
    iput-object v0, p0, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->mCurrentPrimaryItem:Landroid/app/Fragment;

    .line 134
    :cond_2
    return-void
.end method

.method public startUpdate(Landroid/view/View;)V
    .locals 0
    .param p1, "container"    # Landroid/view/View;

    .prologue
    .line 69
    return-void
.end method
