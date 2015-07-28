.class public Lcom/android/mail/providers/Folder;
.super Ljava/lang/Object;
.source "Folder.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable;",
        "Ljava/lang/Comparable",
        "<",
        "Lcom/android/mail/providers/Folder;",
        ">;"
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation
.end field

.field public static final EMPTY:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation
.end field

.field private static final FOLDERS_SPLIT_REGEX:Ljava/util/regex/Pattern;

.field private static final SPLITTER_REGEX:Ljava/util/regex/Pattern;


# instance fields
.field public bgColor:Ljava/lang/String;

.field public capabilities:I

.field public childFoldersListUri:Landroid/net/Uri;

.field public conversationListUri:Landroid/net/Uri;

.field public fgColor:Ljava/lang/String;

.field public hasChildren:Z

.field public hierarchicalDesc:Ljava/lang/String;

.field public iconResId:J

.field public id:I

.field public lastSyncResult:I

.field public loadMoreUri:Landroid/net/Uri;

.field public name:Ljava/lang/String;

.field public parent:Lcom/android/mail/providers/Folder;

.field public refreshUri:Landroid/net/Uri;

.field public syncStatus:I

.field public syncWindow:I

.field public totalCount:I

.field public type:I

.field public unreadCount:I

.field public uri:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 162
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Folder;->EMPTY:Ljava/util/Collection;

    .line 165
    const-string v0, "\\^\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Folder;->SPLITTER_REGEX:Ljava/util/regex/Pattern;

    .line 167
    const-string v0, "\\^\\*\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/Folder;->FOLDERS_SPLIT_REGEX:Ljava/util/regex/Pattern;

    .line 295
    new-instance v0, Lcom/android/mail/providers/Folder$1;

    invoke-direct {v0}, Lcom/android/mail/providers/Folder$1;-><init>()V

    sput-object v0, Lcom/android/mail/providers/Folder;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 280
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 281
    const-string v0, "Uninitialized!"

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 282
    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 8
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v6, 0x0

    .line 193
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 194
    invoke-interface {p1, v5}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    iput v7, p0, Lcom/android/mail/providers/Folder;->id:I

    .line 195
    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    iput-object v7, p0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    .line 196
    const/4 v7, 0x2

    invoke-interface {p1, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 197
    const/4 v7, 0x4

    invoke-interface {p1, v7}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    iput v7, p0, Lcom/android/mail/providers/Folder;->capabilities:I

    .line 199
    const/4 v7, 0x3

    invoke-interface {p1, v7}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    if-ne v7, v4, :cond_0

    :goto_0
    iput-boolean v4, p0, Lcom/android/mail/providers/Folder;->hasChildren:Z

    .line 200
    const/4 v4, 0x5

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Folder;->syncWindow:I

    .line 201
    const/4 v4, 0x6

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 202
    .local v1, "convList":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    :goto_1
    iput-object v4, p0, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    .line 203
    const/4 v4, 0x7

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 204
    .local v0, "childList":Ljava/lang/String;
    iget-boolean v4, p0, Lcom/android/mail/providers/Folder;->hasChildren:Z

    if-eqz v4, :cond_2

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    :goto_2
    iput-object v4, p0, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    .line 206
    const/16 v4, 0x8

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Folder;->unreadCount:I

    .line 207
    const/16 v4, 0x9

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Folder;->totalCount:I

    .line 208
    const/16 v4, 0xa

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 209
    .local v3, "refresh":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    :goto_3
    iput-object v4, p0, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    .line 210
    const/16 v4, 0xb

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Folder;->syncStatus:I

    .line 211
    const/16 v4, 0xc

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Folder;->lastSyncResult:I

    .line 212
    const/16 v4, 0xd

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/providers/Folder;->type:I

    .line 213
    const/16 v4, 0xe

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/android/mail/providers/Folder;->iconResId:J

    .line 214
    const/16 v4, 0xf

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    .line 215
    const/16 v4, 0x10

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Folder;->fgColor:Ljava/lang/String;

    .line 216
    const/16 v4, 0x11

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 217
    .local v2, "loadMore":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_4

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    :goto_4
    iput-object v4, p0, Lcom/android/mail/providers/Folder;->loadMoreUri:Landroid/net/Uri;

    .line 218
    const/16 v4, 0x12

    invoke-interface {p1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/providers/Folder;->hierarchicalDesc:Ljava/lang/String;

    .line 219
    iput-object v6, p0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    .line 220
    return-void

    .end local v0    # "childList":Ljava/lang/String;
    .end local v1    # "convList":Ljava/lang/String;
    .end local v2    # "loadMore":Ljava/lang/String;
    .end local v3    # "refresh":Ljava/lang/String;
    :cond_0
    move v4, v5

    .line 199
    goto/16 :goto_0

    .restart local v1    # "convList":Ljava/lang/String;
    :cond_1
    move-object v4, v6

    .line 202
    goto/16 :goto_1

    .restart local v0    # "childList":Ljava/lang/String;
    :cond_2
    move-object v4, v6

    .line 204
    goto :goto_2

    .restart local v3    # "refresh":Ljava/lang/String;
    :cond_3
    move-object v4, v6

    .line 209
    goto :goto_3

    .restart local v2    # "loadMore":Ljava/lang/String;
    :cond_4
    move-object v4, v6

    .line 217
    goto :goto_4
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 3
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 169
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 170
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Folder;->id:I

    .line 171
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    .line 172
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 173
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Folder;->capabilities:I

    .line 175
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lcom/android/mail/providers/Folder;->hasChildren:Z

    .line 176
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Folder;->syncWindow:I

    .line 177
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    .line 178
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    .line 179
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Folder;->unreadCount:I

    .line 180
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Folder;->totalCount:I

    .line 181
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    .line 182
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Folder;->syncStatus:I

    .line 183
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Folder;->lastSyncResult:I

    .line 184
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/providers/Folder;->type:I

    .line 185
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/mail/providers/Folder;->iconResId:J

    .line 186
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    .line 187
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->fgColor:Ljava/lang/String;

    .line 188
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->loadMoreUri:Landroid/net/Uri;

    .line 189
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->hierarchicalDesc:Ljava/lang/String;

    .line 190
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    iput-object v0, p0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    .line 191
    return-void

    .line 175
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static forSearchResults(Lcom/android/mail/providers/Account;Ljava/lang/String;Landroid/content/Context;)Landroid/content/CursorLoader;
    .locals 8
    .param p0, "account"    # Lcom/android/mail/providers/Account;
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/4 v4, 0x0

    .line 252
    iget-object v0, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    if-eqz v0, :cond_0

    .line 253
    iget-object v0, p0, Lcom/android/mail/providers/Account;->searchUri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v7

    .line 254
    .local v7, "searchBuilder":Landroid/net/Uri$Builder;
    const-string v0, "query"

    invoke-virtual {v7, v0, p1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 255
    invoke-virtual {v7}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 256
    .local v2, "searchUri":Landroid/net/Uri;
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    move-object v1, p2

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    .end local v2    # "searchUri":Landroid/net/Uri;
    .end local v7    # "searchBuilder":Landroid/net/Uri$Builder;
    :goto_0
    return-object v0

    :cond_0
    move-object v0, v4

    goto :goto_0
.end method

.method public static fromString(Ljava/lang/String;)Lcom/android/mail/providers/Folder;
    .locals 7
    .param p0, "inString"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 436
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_0

    move-object v0, v4

    .line 464
    :goto_0
    return-object v0

    .line 439
    :cond_0
    new-instance v0, Lcom/android/mail/providers/Folder;

    invoke-direct {v0}, Lcom/android/mail/providers/Folder;-><init>()V

    .line 440
    .local v0, "f":Lcom/android/mail/providers/Folder;
    sget-object v5, Lcom/android/mail/providers/Folder;->SPLITTER_REGEX:Ljava/util/regex/Pattern;

    invoke-static {p0, v5}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v1

    .line 441
    .local v1, "split":[Ljava/lang/String;
    array-length v5, v1

    const/16 v6, 0x14

    if-ge v5, v6, :cond_1

    move-object v0, v4

    .line 442
    goto :goto_0

    .line 444
    :cond_1
    aget-object v4, v1, v3

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v0, Lcom/android/mail/providers/Folder;->id:I

    .line 445
    aget-object v4, v1, v2

    invoke-static {v4}, Lcom/android/mail/providers/Folder;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    iput-object v4, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    .line 446
    const/4 v4, 0x2

    aget-object v4, v1, v4

    iput-object v4, v0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 447
    const/4 v4, 0x3

    aget-object v4, v1, v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    if-eqz v4, :cond_2

    :goto_1
    iput-boolean v2, v0, Lcom/android/mail/providers/Folder;->hasChildren:Z

    .line 448
    const/4 v2, 0x4

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v0, Lcom/android/mail/providers/Folder;->capabilities:I

    .line 449
    const/4 v2, 0x5

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v0, Lcom/android/mail/providers/Folder;->syncWindow:I

    .line 450
    const/4 v2, 0x6

    aget-object v2, v1, v2

    invoke-static {v2}, Lcom/android/mail/providers/Folder;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, v0, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    .line 451
    const/4 v2, 0x7

    aget-object v2, v1, v2

    invoke-static {v2}, Lcom/android/mail/providers/Folder;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, v0, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    .line 452
    const/16 v2, 0x8

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v0, Lcom/android/mail/providers/Folder;->unreadCount:I

    .line 453
    const/16 v2, 0x9

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v0, Lcom/android/mail/providers/Folder;->totalCount:I

    .line 454
    const/16 v2, 0xa

    aget-object v2, v1, v2

    invoke-static {v2}, Lcom/android/mail/providers/Folder;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, v0, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    .line 455
    const/16 v2, 0xb

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v0, Lcom/android/mail/providers/Folder;->syncStatus:I

    .line 456
    const/16 v2, 0xc

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v0, Lcom/android/mail/providers/Folder;->lastSyncResult:I

    .line 457
    const/16 v2, 0xd

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    iput v2, v0, Lcom/android/mail/providers/Folder;->type:I

    .line 458
    const/16 v2, 0xe

    aget-object v2, v1, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    int-to-long v2, v2

    iput-wide v2, v0, Lcom/android/mail/providers/Folder;->iconResId:J

    .line 459
    const/16 v2, 0xf

    aget-object v2, v1, v2

    iput-object v2, v0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    .line 460
    const/16 v2, 0x10

    aget-object v2, v1, v2

    iput-object v2, v0, Lcom/android/mail/providers/Folder;->fgColor:Ljava/lang/String;

    .line 461
    const/16 v2, 0x11

    aget-object v2, v1, v2

    invoke-static {v2}, Lcom/android/mail/providers/Folder;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, v0, Lcom/android/mail/providers/Folder;->loadMoreUri:Landroid/net/Uri;

    .line 462
    const/16 v2, 0x12

    aget-object v2, v1, v2

    iput-object v2, v0, Lcom/android/mail/providers/Folder;->hierarchicalDesc:Ljava/lang/String;

    .line 463
    const/16 v2, 0x13

    aget-object v2, v1, v2

    invoke-static {v2}, Lcom/android/mail/providers/Folder;->fromString(Ljava/lang/String;)Lcom/android/mail/providers/Folder;

    move-result-object v2

    iput-object v2, v0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    goto/16 :goto_0

    :cond_2
    move v2, v3

    .line 447
    goto/16 :goto_1
.end method

.method public static getDeficientDisplayOnlyFolder(Landroid/database/Cursor;)Lcom/android/mail/providers/Folder;
    .locals 2
    .param p0, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 677
    invoke-static {}, Lcom/android/mail/providers/Folder;->newUnsafeInstance()Lcom/android/mail/providers/Folder;

    move-result-object v0

    .line 678
    .local v0, "f":Lcom/android/mail/providers/Folder;
    const/4 v1, 0x0

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lcom/android/mail/providers/Folder;->id:I

    .line 679
    const/4 v1, 0x1

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    iput-object v1, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    .line 680
    const/16 v1, 0x8

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lcom/android/mail/providers/Folder;->unreadCount:I

    .line 681
    const/4 v1, 0x6

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    iput-object v1, v0, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    .line 683
    const/16 v1, 0xd

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lcom/android/mail/providers/Folder;->type:I

    .line 684
    const/4 v1, 0x4

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lcom/android/mail/providers/Folder;->capabilities:I

    .line 685
    const/16 v1, 0xf

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    .line 686
    const/4 v1, 0x2

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 687
    return-object v0
.end method

.method public static getFoldersArray(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 8
    .param p0, "rawFolders"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation

    .prologue
    .line 541
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 542
    const/4 v3, 0x0

    .line 553
    :cond_0
    return-object v3

    .line 544
    :cond_1
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 545
    .local v3, "folders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Folder;>;"
    sget-object v7, Lcom/android/mail/providers/Folder;->FOLDERS_SPLIT_REGEX:Ljava/util/regex/Pattern;

    invoke-static {p0, v7}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v6

    .line 547
    .local v6, "split":[Ljava/lang/String;
    move-object v0, v6

    .local v0, "arr$":[Ljava/lang/String;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_0

    aget-object v2, v0, v4

    .line 548
    .local v2, "folder":Ljava/lang/String;
    invoke-static {v2}, Lcom/android/mail/providers/Folder;->fromString(Ljava/lang/String;)Lcom/android/mail/providers/Folder;

    move-result-object v1

    .line 549
    .local v1, "f":Lcom/android/mail/providers/Folder;
    if-eqz v1, :cond_2

    .line 550
    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 547
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_0
.end method

.method public static getSerializedFolderString(Ljava/util/Collection;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 422
    .local p0, "folders":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Folder;>;"
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 423
    .local v1, "folderList":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .line 424
    .local v2, "i":I
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 425
    .local v0, "folderEntry":Lcom/android/mail/providers/Folder;
    invoke-static {v0}, Lcom/android/mail/providers/Folder;->toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 426
    invoke-interface {p0}, Ljava/util/Collection;->size()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 427
    const-string v4, "^**^"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 429
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 431
    .end local v0    # "folderEntry":Lcom/android/mail/providers/Folder;
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method public static final getUriArray(Ljava/util/ArrayList;)[Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;)[",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 560
    .local p0, "folders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Folder;>;"
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-nez v4, :cond_2

    .line 561
    :cond_0
    const/4 v4, 0x0

    new-array v1, v4, [Ljava/lang/String;

    .line 569
    :cond_1
    return-object v1

    .line 563
    :cond_2
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v4

    new-array v1, v4, [Ljava/lang/String;

    .line 564
    .local v1, "folderUris":[Ljava/lang/String;
    const/4 v2, 0x0

    .line 565
    .local v2, "i":I
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 566
    .local v0, "folder":Lcom/android/mail/providers/Folder;
    iget-object v4, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v4}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v1, v2

    .line 567
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private static getValidUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 1
    .param p0, "uri"    # Ljava/lang/String;

    .prologue
    .line 271
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 272
    const/4 v0, 0x0

    .line 274
    :goto_0
    return-object v0

    :cond_0
    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0
.end method

.method public static hashMapForFolders(Ljava/util/ArrayList;)Ljava/util/HashMap;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;)",
            "Ljava/util/HashMap",
            "<",
            "Landroid/net/Uri;",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation

    .prologue
    .line 263
    .local p0, "rawFolders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Folder;>;"
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 264
    .local v1, "folders":Ljava/util/HashMap;, "Ljava/util/HashMap<Landroid/net/Uri;Lcom/android/mail/providers/Folder;>;"
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 265
    .local v0, "f":Lcom/android/mail/providers/Folder;
    iget-object v3, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v1, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 267
    .end local v0    # "f":Lcom/android/mail/providers/Folder;
    :cond_0
    return-object v1
.end method

.method public static newUnsafeInstance()Lcom/android/mail/providers/Folder;
    .locals 1

    .prologue
    .line 291
    new-instance v0, Lcom/android/mail/providers/Folder;

    invoke-direct {v0}, Lcom/android/mail/providers/Folder;-><init>()V

    return-object v0
.end method

.method public static setFolderBlockColor(Lcom/android/mail/providers/Folder;Landroid/view/View;)V
    .locals 5
    .param p0, "folder"    # Lcom/android/mail/providers/Folder;
    .param p1, "colorBlock"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x0

    .line 374
    if-nez p1, :cond_0

    .line 391
    :goto_0
    return-void

    .line 377
    :cond_0
    iget-object v4, p0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    const/4 v2, 0x1

    .line 378
    .local v2, "showBg":Z
    :goto_1
    if-eqz v2, :cond_3

    iget-object v4, p0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 379
    .local v0, "backgroundColor":I
    :goto_2
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/android/mail/utils/Utils;->getDefaultFolderBackgroundColor(Landroid/content/Context;)I

    move-result v4

    if-ne v0, v4, :cond_1

    .line 380
    const/4 v2, 0x0

    .line 382
    :cond_1
    if-nez v2, :cond_4

    .line 383
    const/4 v3, 0x0

    invoke-virtual {p1, v3}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 384
    const/16 v3, 0x8

    invoke-virtual {p1, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .end local v0    # "backgroundColor":I
    .end local v2    # "showBg":Z
    :cond_2
    move v2, v3

    .line 377
    goto :goto_1

    .restart local v2    # "showBg":Z
    :cond_3
    move v0, v3

    .line 378
    goto :goto_2

    .line 386
    .restart local v0    # "backgroundColor":I
    :cond_4
    new-instance v1, Landroid/graphics/drawable/PaintDrawable;

    invoke-direct {v1}, Landroid/graphics/drawable/PaintDrawable;-><init>()V

    .line 387
    .local v1, "paintDrawable":Landroid/graphics/drawable/PaintDrawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/PaintDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v4

    invoke-virtual {v4, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 388
    invoke-virtual {p1, v1}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 389
    invoke-virtual {p1, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public static setIcon(Lcom/android/mail/providers/Folder;Landroid/widget/ImageView;)V
    .locals 4
    .param p0, "folder"    # Lcom/android/mail/providers/Folder;
    .param p1, "iconView"    # Landroid/widget/ImageView;

    .prologue
    .line 394
    if-nez p1, :cond_0

    .line 404
    :goto_0
    return-void

    .line 397
    :cond_0
    iget-wide v0, p0, Lcom/android/mail/providers/Folder;->iconResId:J

    .line 398
    .local v0, "icon":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-lez v2, :cond_1

    .line 399
    long-to-int v2, v0

    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 400
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 402
    :cond_1
    const/4 v2, 0x4

    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public static toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;
    .locals 5
    .param p0, "folderEntry"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 468
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 469
    .local v1, "builder":Ljava/lang/StringBuilder;
    iget v3, p0, Lcom/android/mail/providers/Folder;->id:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 470
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 471
    iget-object v3, p0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 472
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 473
    iget-object v3, p0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 474
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 475
    iget-boolean v3, p0, Lcom/android/mail/providers/Folder;->hasChildren:Z

    if-eqz v3, :cond_0

    const/4 v3, 0x1

    :goto_0
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 476
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 477
    iget v3, p0, Lcom/android/mail/providers/Folder;->capabilities:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 478
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 479
    iget v3, p0, Lcom/android/mail/providers/Folder;->syncWindow:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 480
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 481
    iget-object v3, p0, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 482
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 483
    iget-object v3, p0, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 484
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 485
    iget v3, p0, Lcom/android/mail/providers/Folder;->unreadCount:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 486
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 487
    iget v3, p0, Lcom/android/mail/providers/Folder;->totalCount:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 488
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 489
    iget-object v3, p0, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 490
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 491
    iget v3, p0, Lcom/android/mail/providers/Folder;->syncStatus:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 492
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 493
    iget v3, p0, Lcom/android/mail/providers/Folder;->lastSyncResult:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 494
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 495
    iget v3, p0, Lcom/android/mail/providers/Folder;->type:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 496
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 497
    iget-wide v3, p0, Lcom/android/mail/providers/Folder;->iconResId:J

    invoke-virtual {v1, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 498
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 499
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    .line 500
    .local v0, "bgColor":Ljava/lang/String;
    if-eqz v0, :cond_1

    .end local v0    # "bgColor":Ljava/lang/String;
    :goto_1
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 501
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 502
    iget-object v2, p0, Lcom/android/mail/providers/Folder;->fgColor:Ljava/lang/String;

    .line 503
    .local v2, "fgColor":Ljava/lang/String;
    if-eqz v2, :cond_2

    .end local v2    # "fgColor":Ljava/lang/String;
    :goto_2
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 504
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 505
    iget-object v3, p0, Lcom/android/mail/providers/Folder;->loadMoreUri:Landroid/net/Uri;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 506
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 507
    iget-object v3, p0, Lcom/android/mail/providers/Folder;->hierarchicalDesc:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 508
    const-string v3, "^*^"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 509
    iget-object v3, p0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    if-eqz v3, :cond_3

    .line 510
    iget-object v3, p0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    invoke-static {v3}, Lcom/android/mail/providers/Folder;->toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 514
    :goto_3
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 475
    :cond_0
    const/4 v3, 0x0

    goto/16 :goto_0

    .line 500
    .restart local v0    # "bgColor":Ljava/lang/String;
    :cond_1
    const-string v0, ""

    goto :goto_1

    .line 503
    .end local v0    # "bgColor":Ljava/lang/String;
    .restart local v2    # "fgColor":Ljava/lang/String;
    :cond_2
    const-string v2, ""

    goto :goto_2

    .line 512
    .end local v2    # "fgColor":Ljava/lang/String;
    :cond_3
    const-string v3, ""

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3
.end method


# virtual methods
.method public compareTo(Lcom/android/mail/providers/Folder;)I
    .locals 2
    .param p1, "other"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 328
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    iget-object v1, p1, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 48
    check-cast p1, Lcom/android/mail/providers/Folder;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/providers/Folder;->compareTo(Lcom/android/mail/providers/Folder;)I

    move-result v0

    return v0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 310
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .line 315
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/android/mail/providers/Folder;

    if-nez v0, :cond_1

    .line 316
    :cond_0
    const/4 v0, 0x0

    .line 318
    .end local p1    # "o":Ljava/lang/Object;
    :goto_0
    return v0

    .restart local p1    # "o":Ljava/lang/Object;
    :cond_1
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    check-cast p1, Lcom/android/mail/providers/Folder;

    .end local p1    # "o":Ljava/lang/Object;
    iget-object v1, p1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-static {v0, v1}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public getBackgroundColor(I)I
    .locals 1
    .param p1, "defaultColor"    # I

    .prologue
    .line 414
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .end local p1    # "defaultColor":I
    :goto_0
    return p1

    .restart local p1    # "defaultColor":I
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p1

    goto :goto_0
.end method

.method public getForegroundColor(I)I
    .locals 1
    .param p1, "defaultColor"    # I

    .prologue
    .line 418
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->fgColor:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .end local p1    # "defaultColor":I
    :goto_0
    return p1

    .restart local p1    # "defaultColor":I
    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->fgColor:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p1

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 323
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public isDraft()Z
    .locals 2

    .prologue
    .line 646
    iget v0, p0, Lcom/android/mail/providers/Folder;->type:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isImportantOnly()Z
    .locals 1

    .prologue
    .line 653
    const/16 v0, 0x400

    invoke-virtual {p0, v0}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v0

    return v0
.end method

.method public isInitialized()Z
    .locals 2

    .prologue
    .line 620
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    const-string v1, "Uninitialized!"

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    if-eqz v0, :cond_0

    const-string v0, "null"

    iget-object v1, p0, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isProviderFolder()Z
    .locals 1

    .prologue
    .line 410
    iget v0, p0, Lcom/android/mail/providers/Folder;->type:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSyncInProgress()Z
    .locals 1

    .prologue
    .line 355
    iget v0, p0, Lcom/android/mail/providers/Folder;->syncStatus:I

    invoke-static {v0}, Lcom/android/mail/providers/UIProvider$SyncStatus;->isSyncInProgress(I)Z

    move-result v0

    return v0
.end method

.method public isTrash()Z
    .locals 2

    .prologue
    .line 639
    iget v0, p0, Lcom/android/mail/providers/Folder;->type:I

    const/4 v1, 0x5

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isViewAll()Z
    .locals 2

    .prologue
    .line 661
    iget v0, p0, Lcom/android/mail/providers/Folder;->type:I

    const/16 v1, 0x9

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public supportsCapability(I)Z
    .locals 1
    .param p1, "capability"    # I

    .prologue
    .line 368
    iget v0, p0, Lcom/android/mail/providers/Folder;->capabilities:I

    and-int/2addr v0, p1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final wasSyncSuccessful()Z
    .locals 1

    .prologue
    .line 669
    iget v0, p0, Lcom/android/mail/providers/Folder;->lastSyncResult:I

    and-int/lit8 v0, v0, 0xf

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 4
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v1, 0x0

    .line 224
    iget v0, p0, Lcom/android/mail/providers/Folder;->id:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 225
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 226
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 227
    iget v0, p0, Lcom/android/mail/providers/Folder;->capabilities:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 229
    iget-boolean v0, p0, Lcom/android/mail/providers/Folder;->hasChildren:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 230
    iget v0, p0, Lcom/android/mail/providers/Folder;->syncWindow:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 231
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 232
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 233
    iget v0, p0, Lcom/android/mail/providers/Folder;->unreadCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 234
    iget v0, p0, Lcom/android/mail/providers/Folder;->totalCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 235
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 236
    iget v0, p0, Lcom/android/mail/providers/Folder;->syncStatus:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 237
    iget v0, p0, Lcom/android/mail/providers/Folder;->lastSyncResult:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 238
    iget v0, p0, Lcom/android/mail/providers/Folder;->type:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 239
    iget-wide v2, p0, Lcom/android/mail/providers/Folder;->iconResId:J

    invoke-virtual {p1, v2, v3}, Landroid/os/Parcel;->writeLong(J)V

    .line 240
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->bgColor:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 241
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->fgColor:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 242
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->loadMoreUri:Landroid/net/Uri;

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 243
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->hierarchicalDesc:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 244
    iget-object v0, p0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 245
    return-void

    :cond_0
    move v0, v1

    .line 229
    goto :goto_0
.end method
