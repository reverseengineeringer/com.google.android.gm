.class public abstract Lcom/android/mail/utils/FragmentStatePagerAdapter2;
.super Landroid/support/v4/view/PagerAdapter;
.source "FragmentStatePagerAdapter2.java"


# instance fields
.field private mCurTransaction:Landroid/app/FragmentTransaction;

.field private mCurrentPrimaryItem:Landroid/app/Fragment;

.field private mEnableSavedStates:Z

.field private final mFragmentManager:Landroid/app/FragmentManager;

.field private mFragments:Landroid/support/v4/util/SparseArrayCompat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/SparseArrayCompat",
            "<",
            "Landroid/app/Fragment;",
            ">;"
        }
    .end annotation
.end field

.field private mSavedState:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/app/Fragment$SavedState;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/FragmentManager;Z)V
    .locals 2
    .param p1, "fm"    # Landroid/app/FragmentManager;
    .param p2, "enableSavedStates"    # Z

    .prologue
    const/4 v1, 0x0

    .line 63
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 51
    iput-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    .line 54
    new-instance v0, Landroid/support/v4/util/SparseArrayCompat;

    invoke-direct {v0}, Landroid/support/v4/util/SparseArrayCompat;-><init>()V

    iput-object v0, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    .line 55
    iput-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurrentPrimaryItem:Landroid/app/Fragment;

    .line 64
    iput-object p1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragmentManager:Landroid/app/FragmentManager;

    .line 65
    iput-boolean p2, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mEnableSavedStates:Z

    .line 66
    return-void
.end method


# virtual methods
.method public destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 3
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 111
    move-object v0, p3

    check-cast v0, Landroid/app/Fragment;

    .line 113
    .local v0, "fragment":Landroid/app/Fragment;
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    if-nez v1, :cond_0

    .line 114
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    .line 118
    :cond_0
    iget-boolean v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mEnableSavedStates:Z

    if-eqz v1, :cond_2

    .line 119
    :goto_0
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-gt v1, p2, :cond_1

    .line 120
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 122
    :cond_1
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v2, v0}, Landroid/app/FragmentManager;->saveFragmentInstanceState(Landroid/app/Fragment;)Landroid/app/Fragment$SavedState;

    move-result-object v2

    invoke-virtual {v1, p2, v2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 124
    :cond_2
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v1, p2}, Landroid/support/v4/util/SparseArrayCompat;->delete(I)V

    .line 126
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    invoke-virtual {v1, v0}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 127
    return-void
.end method

.method public finishUpdate(Landroid/view/ViewGroup;)V
    .locals 1
    .param p1, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 145
    iget-object v0, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 147
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    .line 148
    iget-object v0, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v0}, Landroid/app/FragmentManager;->executePendingTransactions()Z

    .line 150
    :cond_0
    return-void
.end method

.method public getFragmentAt(I)Landroid/app/Fragment;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 235
    iget-object v0, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v0, p1}, Landroid/support/v4/util/SparseArrayCompat;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Fragment;

    return-object v0
.end method

.method public abstract getItem(I)Landroid/app/Fragment;
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 5
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I

    .prologue
    .line 83
    iget-object v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v3, p2}, Landroid/support/v4/util/SparseArrayCompat;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Fragment;

    .line 84
    .local v0, "existing":Landroid/app/Fragment;
    if-eqz v0, :cond_0

    .line 106
    .end local v0    # "existing":Landroid/app/Fragment;
    :goto_0
    return-object v0

    .line 88
    .restart local v0    # "existing":Landroid/app/Fragment;
    :cond_0
    iget-object v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    if-nez v3, :cond_1

    .line 89
    iget-object v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v3}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    .line 92
    :cond_1
    invoke-virtual {p0, p2}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->getItem(I)Landroid/app/Fragment;

    move-result-object v1

    .line 94
    .local v1, "fragment":Landroid/app/Fragment;
    iget-boolean v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mEnableSavedStates:Z

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-le v3, p2, :cond_2

    .line 95
    iget-object v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    invoke-virtual {v3, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/Fragment$SavedState;

    .line 96
    .local v2, "fss":Landroid/app/Fragment$SavedState;
    if-eqz v2, :cond_2

    .line 97
    invoke-virtual {v1, v2}, Landroid/app/Fragment;->setInitialSavedState(Landroid/app/Fragment$SavedState;)V

    .line 100
    .end local v2    # "fss":Landroid/app/Fragment$SavedState;
    :cond_2
    iget-object v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurrentPrimaryItem:Landroid/app/Fragment;

    if-eq v1, v3, :cond_3

    .line 101
    const/4 v3, 0x0

    invoke-virtual {p0, v1, v3}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->setItemVisible(Landroid/app/Fragment;Z)V

    .line 103
    :cond_3
    iget-object v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v3, p2, v1}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    .line 104
    iget-object v3, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurTransaction:Landroid/app/FragmentTransaction;

    invoke-virtual {p1}, Landroid/view/ViewGroup;->getId()I

    move-result v4

    invoke-virtual {v3, v4, v1}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-object v0, v1

    .line 106
    goto :goto_0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "object"    # Ljava/lang/Object;

    .prologue
    .line 154
    check-cast p2, Landroid/app/Fragment;

    .end local p2    # "object":Ljava/lang/Object;
    invoke-virtual {p2}, Landroid/app/Fragment;->getView()Landroid/view/View;

    move-result-object v0

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public notifyDataSetChanged()V
    .locals 7

    .prologue
    .line 217
    new-instance v2, Landroid/support/v4/util/SparseArrayCompat;

    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v6}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v6

    invoke-direct {v2, v6}, Landroid/support/v4/util/SparseArrayCompat;-><init>(I)V

    .line 219
    .local v2, "newFragments":Landroid/support/v4/util/SparseArrayCompat;, "Landroid/support/v4/util/SparseArrayCompat<Landroid/app/Fragment;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v6}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v6

    if-ge v1, v6, :cond_2

    .line 220
    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v6, v1}, Landroid/support/v4/util/SparseArrayCompat;->keyAt(I)I

    move-result v4

    .line 221
    .local v4, "oldPos":I
    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v6, v1}, Landroid/support/v4/util/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Fragment;

    .line 222
    .local v0, "f":Landroid/app/Fragment;
    invoke-virtual {p0, v0}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->getItemPosition(Ljava/lang/Object;)I

    move-result v3

    .line 224
    .local v3, "newPos":I
    const/4 v6, -0x2

    if-eq v3, v6, :cond_0

    .line 225
    if-ltz v3, :cond_1

    move v5, v3

    .line 226
    .local v5, "pos":I
    :goto_1
    invoke-virtual {v2, v5, v0}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    .line 219
    .end local v5    # "pos":I
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    move v5, v4

    .line 225
    goto :goto_1

    .line 229
    .end local v0    # "f":Landroid/app/Fragment;
    .end local v3    # "newPos":I
    .end local v4    # "oldPos":I
    :cond_2
    iput-object v2, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    .line 231
    invoke-super {p0}, Landroid/support/v4/view/PagerAdapter;->notifyDataSetChanged()V

    .line 232
    return-void
.end method

.method public restoreState(Landroid/os/Parcelable;Ljava/lang/ClassLoader;)V
    .locals 11
    .param p1, "state"    # Landroid/os/Parcelable;
    .param p2, "loader"    # Ljava/lang/ClassLoader;

    .prologue
    .line 180
    if-eqz p1, :cond_3

    move-object v0, p1

    .line 181
    check-cast v0, Landroid/os/Bundle;

    .line 182
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {v0, p2}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    .line 183
    iget-object v8, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v8}, Landroid/support/v4/util/SparseArrayCompat;->clear()V

    .line 184
    iget-boolean v8, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mEnableSavedStates:Z

    if-eqz v8, :cond_0

    .line 185
    const-string v8, "states"

    invoke-virtual {v0, v8}, Landroid/os/Bundle;->getParcelableArray(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object v2

    .line 186
    .local v2, "fss":[Landroid/os/Parcelable;
    iget-object v8, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->clear()V

    .line 187
    if-eqz v2, :cond_0

    .line 188
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v8, v2

    if-ge v3, v8, :cond_0

    .line 189
    iget-object v9, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    aget-object v8, v2, v3

    check-cast v8, Landroid/app/Fragment$SavedState;

    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 188
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 193
    .end local v2    # "fss":[Landroid/os/Parcelable;
    .end local v3    # "i":I
    :cond_0
    invoke-virtual {v0}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v7

    .line 194
    .local v7, "keys":Ljava/lang/Iterable;, "Ljava/lang/Iterable<Ljava/lang/String;>;"
    invoke-interface {v7}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 195
    .local v6, "key":Ljava/lang/String;
    const-string v8, "f"

    invoke-virtual {v6, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 196
    const/4 v8, 0x1

    invoke-virtual {v6, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    .line 197
    .local v5, "index":I
    iget-object v8, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v8, v0, v6}, Landroid/app/FragmentManager;->getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v1

    .line 198
    .local v1, "f":Landroid/app/Fragment;
    if-eqz v1, :cond_2

    .line 199
    const/4 v8, 0x0

    invoke-virtual {p0, v1, v8}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->setItemVisible(Landroid/app/Fragment;Z)V

    .line 200
    iget-object v8, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v8, v5, v1}, Landroid/support/v4/util/SparseArrayCompat;->put(ILjava/lang/Object;)V

    goto :goto_1

    .line 202
    :cond_2
    const-string v8, "FragmentStatePagerAdapter"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Bad fragment at key "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 207
    .end local v0    # "bundle":Landroid/os/Bundle;
    .end local v1    # "f":Landroid/app/Fragment;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "index":I
    .end local v6    # "key":Ljava/lang/String;
    .end local v7    # "keys":Ljava/lang/Iterable;, "Ljava/lang/Iterable<Ljava/lang/String;>;"
    :cond_3
    return-void
.end method

.method public saveState()Landroid/os/Parcelable;
    .locals 8

    .prologue
    .line 159
    const/4 v5, 0x0

    .line 160
    .local v5, "state":Landroid/os/Bundle;
    iget-boolean v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mEnableSavedStates:Z

    if-eqz v6, :cond_0

    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-lez v6, :cond_0

    .line 161
    new-instance v5, Landroid/os/Bundle;

    .end local v5    # "state":Landroid/os/Bundle;
    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 162
    .restart local v5    # "state":Landroid/os/Bundle;
    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    new-array v1, v6, [Landroid/app/Fragment$SavedState;

    .line 163
    .local v1, "fss":[Landroid/app/Fragment$SavedState;
    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mSavedState:Ljava/util/ArrayList;

    invoke-virtual {v6, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 164
    const-string v6, "states"

    invoke-virtual {v5, v6, v1}, Landroid/os/Bundle;->putParcelableArray(Ljava/lang/String;[Landroid/os/Parcelable;)V

    .line 166
    .end local v1    # "fss":[Landroid/app/Fragment$SavedState;
    :cond_0
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v6}, Landroid/support/v4/util/SparseArrayCompat;->size()I

    move-result v6

    if-ge v2, v6, :cond_2

    .line 167
    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v6, v2}, Landroid/support/v4/util/SparseArrayCompat;->keyAt(I)I

    move-result v4

    .line 168
    .local v4, "pos":I
    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragments:Landroid/support/v4/util/SparseArrayCompat;

    invoke-virtual {v6, v2}, Landroid/support/v4/util/SparseArrayCompat;->valueAt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Fragment;

    .line 169
    .local v0, "f":Landroid/app/Fragment;
    if-nez v5, :cond_1

    .line 170
    new-instance v5, Landroid/os/Bundle;

    .end local v5    # "state":Landroid/os/Bundle;
    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 172
    .restart local v5    # "state":Landroid/os/Bundle;
    :cond_1
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "f"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 173
    .local v3, "key":Ljava/lang/String;
    iget-object v6, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v6, v5, v3, v0}, Landroid/app/FragmentManager;->putFragment(Landroid/os/Bundle;Ljava/lang/String;Landroid/app/Fragment;)V

    .line 166
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 175
    .end local v0    # "f":Landroid/app/Fragment;
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "pos":I
    :cond_2
    return-object v5
.end method

.method public setItemVisible(Landroid/app/Fragment;Z)V
    .locals 0
    .param p1, "item"    # Landroid/app/Fragment;
    .param p2, "visible"    # Z

    .prologue
    .line 210
    invoke-static {p1, p2}, Landroid/support/v13/app/FragmentCompat;->setMenuVisibility(Landroid/app/Fragment;Z)V

    .line 211
    invoke-static {p1, p2}, Landroid/support/v13/app/FragmentCompat;->setUserVisibleHint(Landroid/app/Fragment;Z)V

    .line 212
    return-void
.end method

.method public setPrimaryItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 3
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 131
    move-object v0, p3

    check-cast v0, Landroid/app/Fragment;

    .line 132
    .local v0, "fragment":Landroid/app/Fragment;
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurrentPrimaryItem:Landroid/app/Fragment;

    if-eq v0, v1, :cond_2

    .line 133
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurrentPrimaryItem:Landroid/app/Fragment;

    if-eqz v1, :cond_0

    .line 134
    iget-object v1, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurrentPrimaryItem:Landroid/app/Fragment;

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->setItemVisible(Landroid/app/Fragment;Z)V

    .line 136
    :cond_0
    if-eqz v0, :cond_1

    .line 137
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->setItemVisible(Landroid/app/Fragment;Z)V

    .line 139
    :cond_1
    iput-object v0, p0, Lcom/android/mail/utils/FragmentStatePagerAdapter2;->mCurrentPrimaryItem:Landroid/app/Fragment;

    .line 141
    :cond_2
    return-void
.end method

.method public startUpdate(Landroid/view/ViewGroup;)V
    .locals 0
    .param p1, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 75
    return-void
.end method
