.class public Lcom/google/android/gm/provider/uiprovider/UICursorWapper;
.super Landroid/database/CursorWrapper;
.source "UICursorWapper.java"


# instance fields
.field protected final mResultProjection:[Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/database/Cursor;[Ljava/lang/String;)V
    .locals 0
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "resultProjection"    # [Ljava/lang/String;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Landroid/database/CursorWrapper;-><init>(Landroid/database/Cursor;)V

    .line 15
    iput-object p2, p0, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->mResultProjection:[Ljava/lang/String;

    .line 16
    return-void
.end method

.method private static toNonnullString(Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "source"    # Ljava/lang/String;

    .prologue
    .line 93
    if-nez p0, :cond_0

    .line 94
    const-string p0, ""

    .line 96
    .end local p0    # "source":Ljava/lang/String;
    :cond_0
    return-object p0
.end method


# virtual methods
.method public getColumnIndex(Ljava/lang/String;)I
    .locals 2
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 20
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->mResultProjection:[Ljava/lang/String;

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 21
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->mResultProjection:[Ljava/lang/String;

    aget-object v1, v1, v0

    invoke-static {p1, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 26
    .end local v0    # "i":I
    :goto_1
    return v0

    .line 20
    .restart local v0    # "i":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 26
    :cond_1
    const/4 v0, -0x1

    goto :goto_1
.end method

.method public getColumnIndexOrThrow(Ljava/lang/String;)I
    .locals 4
    .param p1, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 31
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 32
    .local v0, "index":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 33
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Column not found: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 35
    :cond_0
    return v0
.end method

.method public getColumnName(I)Ljava/lang/String;
    .locals 1
    .param p1, "columnIndex"    # I

    .prologue
    .line 40
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->mResultProjection:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getColumnNames()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->mResultProjection:[Ljava/lang/String;

    return-object v0
.end method

.method protected getStringInColumn(I)Ljava/lang/String;
    .locals 1
    .param p1, "columnIndex"    # I

    .prologue
    .line 86
    invoke-super {p0, p1}, Landroid/database/CursorWrapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->toNonnullString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public move(I)Z
    .locals 1
    .param p1, "offset"    # I

    .prologue
    .line 56
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->resetCursorRowState()V

    .line 57
    invoke-super {p0, p1}, Landroid/database/CursorWrapper;->move(I)Z

    move-result v0

    return v0
.end method

.method public moveToFirst()Z
    .locals 1

    .prologue
    .line 62
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->resetCursorRowState()V

    .line 63
    invoke-super {p0}, Landroid/database/CursorWrapper;->moveToFirst()Z

    move-result v0

    return v0
.end method

.method public moveToNext()Z
    .locals 1

    .prologue
    .line 68
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->resetCursorRowState()V

    .line 69
    invoke-super {p0}, Landroid/database/CursorWrapper;->moveToNext()Z

    move-result v0

    return v0
.end method

.method public moveToPosition(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->resetCursorRowState()V

    .line 51
    invoke-super {p0, p1}, Landroid/database/CursorWrapper;->moveToPosition(I)Z

    move-result v0

    return v0
.end method

.method public moveToPrevious()Z
    .locals 1

    .prologue
    .line 74
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->resetCursorRowState()V

    .line 75
    invoke-super {p0}, Landroid/database/CursorWrapper;->moveToPrevious()Z

    move-result v0

    return v0
.end method

.method protected resetCursorRowState()V
    .locals 0

    .prologue
    .line 80
    return-void
.end method
