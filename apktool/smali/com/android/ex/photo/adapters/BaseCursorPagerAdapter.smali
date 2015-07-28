.class public abstract Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;
.super Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;
.source "BaseCursorPagerAdapter.java"


# instance fields
.field mContext:Landroid/content/Context;

.field private mCursor:Landroid/database/Cursor;

.field private mDataValid:Z

.field private mItemPosition:Landroid/util/SparseIntArray;

.field private mObjectRowMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Object;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mRowIDColumn:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/FragmentManager;Landroid/database/Cursor;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "fm"    # Landroid/app/FragmentManager;
    .param p3, "c"    # Landroid/database/Cursor;

    .prologue
    .line 56
    invoke-direct {p0, p2}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;-><init>(Landroid/app/FragmentManager;)V

    .line 47
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mObjectRowMap:Ljava/util/HashMap;

    .line 57
    invoke-direct {p0, p1, p3}, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->init(Landroid/content/Context;Landroid/database/Cursor;)V

    .line 58
    return-void
.end method

.method private init(Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "c"    # Landroid/database/Cursor;

    .prologue
    .line 232
    if-eqz p2, :cond_0

    const/4 v0, 0x1

    .line 233
    .local v0, "cursorPresent":Z
    :goto_0
    iput-object p2, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    .line 234
    iput-boolean v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mDataValid:Z

    .line 235
    iput-object p1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mContext:Landroid/content/Context;

    .line 236
    if-eqz v0, :cond_1

    iget-object v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    const-string v2, "uri"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    :goto_1
    iput v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mRowIDColumn:I

    .line 238
    return-void

    .line 232
    .end local v0    # "cursorPresent":Z
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 236
    .restart local v0    # "cursorPresent":Z
    :cond_1
    const/4 v1, -0x1

    goto :goto_1
.end method

.method private moveCursorTo(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 222
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    .line 225
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setItemPosition()V
    .locals 5

    .prologue
    .line 245
    iget-boolean v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mDataValid:Z

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->isClosed()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 246
    :cond_0
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mItemPosition:Landroid/util/SparseIntArray;

    .line 260
    :goto_0
    return-void

    .line 250
    :cond_1
    new-instance v0, Landroid/util/SparseIntArray;

    iget-object v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->getCount()I

    move-result v3

    invoke-direct {v0, v3}, Landroid/util/SparseIntArray;-><init>(I)V

    .line 252
    .local v0, "itemPosition":Landroid/util/SparseIntArray;
    iget-object v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    const/4 v4, -0x1

    invoke-interface {v3, v4}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 253
    :goto_1
    iget-object v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 254
    iget-object v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    iget v4, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mRowIDColumn:I

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v2

    .line 255
    .local v2, "rowId":I
    iget-object v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->getPosition()I

    move-result v1

    .line 257
    .local v1, "position":I
    invoke-virtual {v0, v2, v1}, Landroid/util/SparseIntArray;->append(II)V

    goto :goto_1

    .line 259
    .end local v1    # "position":I
    .end local v2    # "rowId":I
    :cond_2
    iput-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mItemPosition:Landroid/util/SparseIntArray;

    goto :goto_0
.end method


# virtual methods
.method public destroyItem(Landroid/view/View;ILjava/lang/Object;)V
    .locals 1
    .param p1, "container"    # Landroid/view/View;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 110
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mObjectRowMap:Ljava/util/HashMap;

    invoke-virtual {v0, p3}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    invoke-super {p0, p1, p2, p3}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->destroyItem(Landroid/view/View;ILjava/lang/Object;)V

    .line 113
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 80
    iget-boolean v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mDataValid:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 81
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    .line 83
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCursor()Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    return-object v0
.end method

.method public getItem(I)Landroid/app/Fragment;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 72
    iget-boolean v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mDataValid:Z

    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->moveCursorTo(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-virtual {p0, v0, v1, p1}, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->getItem(Landroid/content/Context;Landroid/database/Cursor;I)Landroid/app/Fragment;

    move-result-object v0

    .line 75
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public abstract getItem(Landroid/content/Context;Landroid/database/Cursor;I)Landroid/app/Fragment;
.end method

.method public getItemPosition(Ljava/lang/Object;)I
    .locals 4
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    const/4 v0, -0x2

    .line 117
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mObjectRowMap:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 118
    .local v1, "rowId":Ljava/lang/Integer;
    if-eqz v1, :cond_0

    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mItemPosition:Landroid/util/SparseIntArray;

    if-nez v2, :cond_1

    .line 123
    :cond_0
    :goto_0
    return v0

    .line 122
    :cond_1
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mItemPosition:Landroid/util/SparseIntArray;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v2, v3, v0}, Landroid/util/SparseIntArray;->get(II)I

    move-result v0

    .line 123
    .local v0, "position":I
    goto :goto_0
.end method

.method public instantiateItem(Landroid/view/View;I)Ljava/lang/Object;
    .locals 4
    .param p1, "container"    # Landroid/view/View;
    .param p2, "position"    # I

    .prologue
    .line 89
    iget-boolean v2, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mDataValid:Z

    if-nez v2, :cond_0

    .line 90
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "this should only be called when the cursor is valid"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 94
    :cond_0
    invoke-direct {p0, p2}, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->moveCursorTo(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 95
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    iget v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mRowIDColumn:I

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    .line 101
    .local v1, "rowId":Ljava/lang/Integer;
    :goto_0
    invoke-super {p0, p1, p2}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->instantiateItem(Landroid/view/View;I)Ljava/lang/Object;

    move-result-object v0

    .line 102
    .local v0, "obj":Ljava/lang/Object;
    if-eqz v0, :cond_1

    .line 103
    iget-object v2, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mObjectRowMap:Ljava/util/HashMap;

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    :cond_1
    return-object v0

    .line 97
    .end local v0    # "obj":Ljava/lang/Object;
    .end local v1    # "rowId":Ljava/lang/Integer;
    :cond_2
    const/4 v1, 0x0

    .restart local v1    # "rowId":Ljava/lang/Integer;
    goto :goto_0
.end method

.method protected makeFragmentName(II)Ljava/lang/String;
    .locals 3
    .param p1, "viewId"    # I
    .param p2, "index"    # I

    .prologue
    .line 209
    invoke-direct {p0, p2}, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->moveCursorTo(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 210
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "android:pager:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    iget v2, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mRowIDColumn:I

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 212
    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2}, Lcom/android/ex/photo/adapters/BaseFragmentPagerAdapter;->makeFragmentName(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;
    .locals 5
    .param p1, "newCursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v2, -0x1

    .line 171
    const-string v1, "BaseCursorPagerAdapter"

    const/4 v3, 0x2

    invoke-static {v1, v3}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 172
    const-string v3, "BaseCursorPagerAdapter"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "swapCursor old="

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    if-nez v1, :cond_1

    move v1, v2

    :goto_0
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "; new="

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    if-nez p1, :cond_2

    move v1, v2

    :goto_1
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 176
    :cond_0
    iget-object v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    if-ne p1, v1, :cond_3

    .line 177
    const/4 v0, 0x0

    .line 191
    :goto_2
    return-object v0

    .line 172
    :cond_1
    iget-object v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    goto :goto_0

    :cond_2
    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    goto :goto_1

    .line 179
    :cond_3
    iget-object v0, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    .line 180
    .local v0, "oldCursor":Landroid/database/Cursor;
    iput-object p1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mCursor:Landroid/database/Cursor;

    .line 181
    if-eqz p1, :cond_4

    .line 182
    const-string v1, "uri"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mRowIDColumn:I

    .line 183
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mDataValid:Z

    .line 189
    :goto_3
    invoke-direct {p0}, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->setItemPosition()V

    .line 190
    invoke-virtual {p0}, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->notifyDataSetChanged()V

    goto :goto_2

    .line 185
    :cond_4
    iput v2, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mRowIDColumn:I

    .line 186
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mDataValid:Z

    goto :goto_3
.end method
