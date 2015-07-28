.class public Lcom/google/android/gm/provider/Gmail$MailCursor;
.super Landroid/database/ContentObserver;
.source "Gmail.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/Gmail;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MailCursor"
.end annotation


# instance fields
.field protected mAccount:Ljava/lang/String;

.field protected mCursor:Landroid/database/Cursor;

.field private final mObservers:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/google/android/gm/provider/Gmail$MailCursorObserver;",
            ">;"
        }
    .end annotation
.end field

.field private mUpdateValues:Landroid/content/ContentValues;


# direct methods
.method protected constructor <init>(Landroid/os/Handler;Ljava/lang/String;Landroid/database/Cursor;)V
    .locals 1
    .param p1, "handler"    # Landroid/os/Handler;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 1952
    invoke-direct {p0, p1}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 1953
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mObservers:Ljava/util/Set;

    .line 1954
    iput-object p3, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    .line 1955
    iput-object p2, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mAccount:Ljava/lang/String;

    .line 1956
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0, p0}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 1957
    :cond_0
    return-void
.end method


# virtual methods
.method protected checkCursor()V
    .locals 2

    .prologue
    .line 2160
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    if-nez v0, :cond_0

    .line 2161
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "cannot read from an insertion cursor"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2164
    :cond_0
    return-void
.end method

.method protected checkThread()V
    .locals 0

    .prologue
    .line 1978
    return-void
.end method

.method public close()V
    .locals 1

    .prologue
    .line 2094
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->release()V

    .line 2095
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 2096
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 2098
    :cond_0
    return-void
.end method

.method public final count()I
    .locals 1

    .prologue
    .line 2013
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 2014
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    .line 2016
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final deactivate()V
    .locals 1

    .prologue
    .line 2077
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 2078
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->deactivate()V

    .line 2080
    :cond_0
    return-void
.end method

.method public final deliverSelfNotifications()Z
    .locals 1

    .prologue
    .line 2146
    const/4 v0, 0x0

    return v0
.end method

.method public getAccount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1968
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mAccount:Ljava/lang/String;

    return-object v0
.end method

.method protected getStringInColumn(I)Ljava/lang/String;
    .locals 1
    .param p1, "columnIndex"    # I

    .prologue
    .line 2170
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->checkCursor()V

    .line 2171
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    # invokes: Lcom/google/android/gm/provider/Gmail;->toNonnullString(Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail;->access$1000(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getUpdateValues()Landroid/content/ContentValues;
    .locals 1

    .prologue
    .line 1988
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mUpdateValues:Landroid/content/ContentValues;

    if-nez v0, :cond_0

    .line 1989
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mUpdateValues:Landroid/content/ContentValues;

    .line 1991
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mUpdateValues:Landroid/content/ContentValues;

    return-object v0
.end method

.method public final isLast()Z
    .locals 1

    .prologue
    .line 2034
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isLast()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final moveTo(I)Z
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 2052
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->checkCursor()V

    .line 2053
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->checkThread()V

    .line 2054
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v1, p1}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v0

    .line 2055
    .local v0, "moved":Z
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->onCursorPositionChanged()V

    .line 2056
    :cond_0
    return v0
.end method

.method public final next()Z
    .locals 2

    .prologue
    .line 2068
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->checkCursor()V

    .line 2069
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->checkThread()V

    .line 2070
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    .line 2071
    .local v0, "moved":Z
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->onCursorPositionChanged()V

    .line 2072
    :cond_0
    return v0
.end method

.method public onChange(Z)V
    .locals 3
    .param p1, "selfChange"    # Z

    .prologue
    .line 2154
    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mObservers:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/Gmail$MailCursorObserver;

    .line 2155
    .local v1, "o":Lcom/google/android/gm/provider/Gmail$MailCursorObserver;
    invoke-interface {v1, p0}, Lcom/google/android/gm/provider/Gmail$MailCursorObserver;->onCursorChanged(Lcom/google/android/gm/provider/Gmail$MailCursor;)V

    goto :goto_0

    .line 2157
    .end local v1    # "o":Lcom/google/android/gm/provider/Gmail$MailCursorObserver;
    :cond_0
    return-void
.end method

.method protected onCursorPositionChanged()V
    .locals 1

    .prologue
    .line 2002
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mUpdateValues:Landroid/content/ContentValues;

    .line 2003
    return-void
.end method

.method public final position()I
    .locals 1

    .prologue
    .line 2025
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 2026
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getPosition()I

    move-result v0

    .line 2028
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public final release()V
    .locals 1

    .prologue
    .line 2087
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 2088
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0, p0}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 2089
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->deactivate()V

    .line 2091
    :cond_0
    return-void
.end method

.method public requery()V
    .locals 1

    .prologue
    .line 2106
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->requery()Z

    .line 2107
    return-void
.end method
