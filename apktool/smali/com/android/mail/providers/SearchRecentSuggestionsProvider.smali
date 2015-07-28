.class public Lcom/android/mail/providers/SearchRecentSuggestionsProvider;
.super Landroid/content/ContentProvider;
.source "SearchRecentSuggestionsProvider.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/providers/SearchRecentSuggestionsProvider$DatabaseHelper;
    }
.end annotation


# instance fields
.field private mAuthority:Ljava/lang/String;

.field private mFullQueryTerms:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mMode:I

.field private mOpenHelper:Landroid/database/sqlite/SQLiteOpenHelper;

.field private mSuggestSuggestionClause:Ljava/lang/String;

.field private mSuggestionProjection:[Ljava/lang/String;

.field private mSuggestionsUri:Landroid/net/Uri;

.field private mUriMatcher:Landroid/content/UriMatcher;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    .line 84
    return-void
.end method

.method private createProjection([Ljava/lang/String;)[Ljava/lang/String;
    .locals 7
    .param p1, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 249
    iget-object v5, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mSuggestionProjection:[Ljava/lang/String;

    array-length v5, v5

    new-array v2, v5, [Ljava/lang/String;

    .line 251
    .local v2, "newProjection":[Ljava/lang/String;
    iget-object v5, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    if-eqz v5, :cond_1

    iget-object v5, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 252
    .local v0, "fullSize":I
    :goto_0
    if-lez v0, :cond_3

    .line 253
    const-string v4, "\'"

    .line 254
    .local v4, "realQuery":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v0, :cond_2

    .line 255
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v5, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 256
    add-int/lit8 v5, v0, -0x1

    if-ge v1, v5, :cond_0

    .line 257
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 254
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 251
    .end local v0    # "fullSize":I
    .end local v1    # "i":I
    .end local v4    # "realQuery":Ljava/lang/String;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 260
    .restart local v0    # "fullSize":I
    .restart local v1    # "i":I
    .restart local v4    # "realQuery":Ljava/lang/String;
    :cond_2
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " \' || query AS "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "suggest_intent_query"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 264
    .end local v1    # "i":I
    .end local v4    # "realQuery":Ljava/lang/String;
    .local v3, "queryAs":Ljava/lang/String;
    :goto_2
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_3
    iget-object v5, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mSuggestionProjection:[Ljava/lang/String;

    array-length v5, v5

    if-ge v1, v5, :cond_4

    .line 265
    iget-object v5, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mSuggestionProjection:[Ljava/lang/String;

    aget-object v5, v5, v1

    aput-object v5, v2, v1

    .line 264
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 262
    .end local v1    # "i":I
    .end local v3    # "queryAs":Ljava/lang/String;
    :cond_3
    const-string v3, "query AS suggest_intent_query"

    .restart local v3    # "queryAs":Ljava/lang/String;
    goto :goto_2

    .line 268
    .restart local v1    # "i":I
    :cond_4
    iget-object v5, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mSuggestionProjection:[Ljava/lang/String;

    array-length v5, v5

    add-int/lit8 v5, v5, -0x2

    aput-object v3, v2, v5

    .line 269
    return-object v2
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 6
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 154
    iget-object v4, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mOpenHelper:Landroid/database/sqlite/SQLiteOpenHelper;

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v2

    .line 156
    .local v2, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v3

    .line 157
    .local v3, "length":I
    const/4 v4, 0x1

    if-eq v3, v4, :cond_0

    .line 158
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Unknown Uri"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 161
    :cond_0
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 162
    .local v0, "base":Ljava/lang/String;
    const/4 v1, 0x0

    .line 163
    .local v1, "count":I
    const-string v4, "suggestions"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 164
    const-string v4, "suggestions"

    invoke-virtual {v2, v4, p2, p3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 168
    invoke-virtual {p0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, p1, v5}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 169
    return v1

    .line 166
    :cond_1
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Unknown Uri"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 5
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v4, 0x1

    .line 178
    iget-object v2, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mUriMatcher:Landroid/content/UriMatcher;

    invoke-virtual {v2, p1}, Landroid/content/UriMatcher;->match(Landroid/net/Uri;)I

    move-result v2

    if-ne v2, v4, :cond_0

    .line 179
    const-string v2, "vnd.android.cursor.dir/vnd.android.search.suggest"

    .line 188
    :goto_0
    return-object v2

    .line 181
    :cond_0
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v1

    .line 182
    .local v1, "length":I
    if-lt v1, v4, :cond_2

    .line 183
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 184
    .local v0, "base":Ljava/lang/String;
    const-string v2, "suggestions"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 185
    if-ne v1, v4, :cond_1

    .line 186
    const-string v2, "vnd.android.cursor.dir/suggestion"

    goto :goto_0

    .line 187
    :cond_1
    const/4 v2, 0x2

    if-ne v1, v2, :cond_2

    .line 188
    const-string v2, "vnd.android.cursor.item/suggestion"

    goto :goto_0

    .line 192
    .end local v0    # "base":Ljava/lang/String;
    :cond_2
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Unknown Uri"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 11
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    const-wide/16 v9, 0x0

    const/4 v8, 0x1

    .line 201
    iget-object v6, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mOpenHelper:Landroid/database/sqlite/SQLiteOpenHelper;

    invoke-virtual {v6}, Landroid/database/sqlite/SQLiteOpenHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    .line 203
    .local v1, "db":Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v2

    .line 204
    .local v2, "length":I
    if-ge v2, v8, :cond_0

    .line 205
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "Unknown Uri"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 208
    :cond_0
    const-wide/16 v4, -0x1

    .line 209
    .local v4, "rowID":J
    invoke-virtual {p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v6

    const/4 v7, 0x0

    invoke-interface {v6, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 210
    .local v0, "base":Ljava/lang/String;
    const/4 v3, 0x0

    .line 211
    .local v3, "newUri":Landroid/net/Uri;
    const-string v6, "suggestions"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 212
    if-ne v2, v8, :cond_1

    .line 213
    const-string v6, "suggestions"

    const-string v7, "query"

    invoke-virtual {v1, v6, v7, p2}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    .line 214
    cmp-long v6, v4, v9

    if-lez v6, :cond_1

    .line 215
    iget-object v6, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mSuggestionsUri:Landroid/net/Uri;

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 219
    :cond_1
    cmp-long v6, v4, v9

    if-gez v6, :cond_2

    .line 220
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "Unknown Uri"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 222
    :cond_2
    invoke-virtual {p0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v6, v3, v7}, Landroid/content/ContentResolver;->notifyChange(Landroid/net/Uri;Landroid/database/ContentObserver;)V

    .line 223
    return-object v3
.end method

.method public onCreate()Z
    .locals 3

    .prologue
    .line 232
    iget-object v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mAuthority:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mMode:I

    if-nez v1, :cond_1

    .line 233
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Provider not configured"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 235
    :cond_1
    iget v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mMode:I

    add-int/lit16 v0, v1, 0x200

    .line 236
    .local v0, "mWorkingDbVersion":I
    new-instance v1, Lcom/android/mail/providers/SearchRecentSuggestionsProvider$DatabaseHelper;

    invoke-virtual {p0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider$DatabaseHelper;-><init>(Landroid/content/Context;I)V

    iput-object v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mOpenHelper:Landroid/database/sqlite/SQLiteOpenHelper;

    .line 238
    const/4 v1, 0x1

    return v1
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 11
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 289
    iget-object v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mOpenHelper:Landroid/database/sqlite/SQLiteOpenHelper;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteOpenHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v0

    .line 294
    .local v0, "db":Landroid/database/sqlite/SQLiteDatabase;
    const/4 v1, 0x0

    aget-object v1, p4, v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 295
    const/4 v3, 0x0

    .line 296
    .local v3, "suggestSelection":Ljava/lang/String;
    const/4 v4, 0x0

    .line 307
    .local v4, "myArgs":[Ljava/lang/String;
    :goto_0
    const-string v1, "suggestions"

    invoke-direct {p0, p4}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->createProjection([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    const/4 v5, 0x0

    const/4 v6, 0x0

    const-string v7, "date DESC"

    const/4 v8, 0x0

    invoke-virtual/range {v0 .. v8}, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v9

    .line 309
    .local v9, "c":Landroid/database/Cursor;
    invoke-virtual {p0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-interface {v9, v1, p1}, Landroid/database/Cursor;->setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V

    .line 310
    return-object v9

    .line 298
    .end local v3    # "suggestSelection":Ljava/lang/String;
    .end local v4    # "myArgs":[Ljava/lang/String;
    .end local v9    # "c":Landroid/database/Cursor;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "%"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x0

    aget-object v2, p4, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "%"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 299
    .local v10, "like":Ljava/lang/String;
    const/4 v1, 0x1

    new-array v4, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object v10, v4, v1

    .line 300
    .restart local v4    # "myArgs":[Ljava/lang/String;
    iget-object v3, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mSuggestSuggestionClause:Ljava/lang/String;

    .restart local v3    # "suggestSelection":Ljava/lang/String;
    goto :goto_0
.end method

.method public setFullQueryTerms(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 278
    .local p1, "terms":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    .line 279
    return-void
.end method

.method protected setupSuggestions(Ljava/lang/String;I)V
    .locals 5
    .param p1, "authority"    # Ljava/lang/String;
    .param p2, "mode"    # I

    .prologue
    const/4 v4, 0x1

    .line 121
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    and-int/lit8 v1, p2, 0x1

    if-nez v1, :cond_1

    .line 123
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 127
    :cond_1
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, p1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mAuthority:Ljava/lang/String;

    .line 128
    iput p2, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mMode:I

    .line 131
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "content://"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mAuthority:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/suggestions"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mSuggestionsUri:Landroid/net/Uri;

    .line 132
    new-instance v1, Landroid/content/UriMatcher;

    const/4 v2, -0x1

    invoke-direct {v1, v2}, Landroid/content/UriMatcher;-><init>(I)V

    iput-object v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mUriMatcher:Landroid/content/UriMatcher;

    .line 133
    iget-object v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mUriMatcher:Landroid/content/UriMatcher;

    iget-object v2, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mAuthority:Ljava/lang/String;

    const-string v3, "search_suggest_query"

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/UriMatcher;->addURI(Ljava/lang/String;Ljava/lang/String;I)V

    .line 136
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "android.resource://"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f02004c

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 139
    .local v0, "historicalIcon":Ljava/lang/String;
    const-string v1, "display1 LIKE ?"

    iput-object v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mSuggestSuggestionClause:Ljava/lang/String;

    .line 140
    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "_id"

    aput-object v3, v1, v2

    const-string v2, "display1 AS suggest_text_1"

    aput-object v2, v1, v4

    const/4 v2, 0x2

    const-string v3, "query AS suggest_intent_query"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\' AS "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "suggest_icon_1"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    iput-object v1, p0, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->mSuggestionProjection:[Ljava/lang/String;

    .line 146
    return-void
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 319
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Not implemented"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
