.class public Lcom/android/mail/providers/SuggestionsProvider;
.super Lcom/android/mail/providers/SearchRecentSuggestionsProvider;
.source "SuggestionsProvider.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/providers/SuggestionsProvider$ContactsCursor;
    }
.end annotation


# static fields
.field private static final CONTACTS_COLUMNS:[Ljava/lang/String;

.field private static final sContract:[Ljava/lang/String;


# instance fields
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

.field private final mTermsLock:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 51
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v3

    const-string v1, "suggest_text_1"

    aput-object v1, v0, v4

    const-string v1, "suggest_intent_query"

    aput-object v1, v0, v5

    const/4 v1, 0x3

    const-string v2, "suggest_icon_1"

    aput-object v2, v0, v1

    sput-object v0, Lcom/android/mail/providers/SuggestionsProvider;->CONTACTS_COLUMNS:[Ljava/lang/String;

    .line 59
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "data4"

    aput-object v1, v0, v3

    const-string v1, "data1"

    aput-object v1, v0, v4

    sput-object v0, Lcom/android/mail/providers/SuggestionsProvider;->sContract:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;-><init>()V

    .line 58
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/android/mail/providers/SuggestionsProvider;->mTermsLock:Ljava/lang/Object;

    .line 70
    return-void
.end method

.method static synthetic access$000()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    sget-object v0, Lcom/android/mail/providers/SuggestionsProvider;->CONTACTS_COLUMNS:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    sget-object v0, Lcom/android/mail/providers/SuggestionsProvider;->sContract:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/mail/providers/SuggestionsProvider;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/providers/SuggestionsProvider;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lcom/android/mail/providers/SuggestionsProvider;->createQuery(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private createQuery(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "inMatch"    # Ljava/lang/String;

    .prologue
    .line 170
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 171
    .local v1, "query":Ljava/lang/StringBuilder;
    iget-object v3, p0, Lcom/android/mail/providers/SuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    if-eqz v3, :cond_1

    .line 172
    iget-object v4, p0, Lcom/android/mail/providers/SuggestionsProvider;->mTermsLock:Ljava/lang/Object;

    monitor-enter v4

    .line 173
    const/4 v0, 0x0

    .local v0, "i":I
    :try_start_0
    iget-object v3, p0, Lcom/android/mail/providers/SuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v2

    .local v2, "size":I
    :goto_0
    if-ge v0, v2, :cond_0

    .line 174
    iget-object v3, p0, Lcom/android/mail/providers/SuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, " "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 173
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 176
    :cond_0
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 179
    .end local v0    # "i":I
    .end local v2    # "size":I
    :cond_1
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 189
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 176
    .restart local v0    # "i":I
    :catchall_0
    move-exception v3

    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v3
.end method


# virtual methods
.method public onCreate()Z
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 74
    invoke-virtual {p0}, Lcom/android/mail/providers/SuggestionsProvider;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0c0012

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 75
    .local v0, "authority":Ljava/lang/String;
    invoke-virtual {p0, v0, v3}, Lcom/android/mail/providers/SuggestionsProvider;->setupSuggestions(Ljava/lang/String;I)V

    .line 76
    invoke-super {p0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->onCreate()Z

    .line 77
    return v3
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 12
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 83
    const/4 v0, 0x0

    aget-object v9, p4, v0

    .line 84
    .local v9, "query":Ljava/lang/String;
    const/4 v8, 0x0

    .line 86
    .local v8, "mergeCursor":Landroid/database/MergeCursor;
    iget-object v1, p0, Lcom/android/mail/providers/SuggestionsProvider;->mTermsLock:Ljava/lang/Object;

    monitor-enter v1

    .line 87
    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/android/mail/providers/SuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    .line 88
    iget-object v0, p0, Lcom/android/mail/providers/SuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    invoke-super {p0, v0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->setFullQueryTerms(Ljava/util/ArrayList;)V

    .line 89
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 91
    if-eqz v9, :cond_2

    .line 93
    const-string v0, " "

    invoke-static {v9, v0}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 96
    .local v11, "tokens":[Ljava/lang/String;
    if-eqz v11, :cond_3

    array-length v0, v11

    const/4 v1, 0x1

    if-le v0, v1, :cond_3

    .line 97
    array-length v0, v11

    add-int/lit8 v0, v0, -0x1

    aget-object v9, v11, v0

    .line 99
    iget-object v1, p0, Lcom/android/mail/providers/SuggestionsProvider;->mTermsLock:Ljava/lang/Object;

    monitor-enter v1

    .line 100
    :try_start_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/providers/SuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    .line 101
    const/4 v7, 0x0

    .local v7, "i":I
    array-length v0, v11

    add-int/lit8 v10, v0, -0x1

    .local v10, "size":I
    :goto_0
    if-ge v7, v10, :cond_0

    .line 102
    iget-object v0, p0, Lcom/android/mail/providers/SuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    aget-object v2, v11, v7

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 101
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 89
    .end local v7    # "i":I
    .end local v10    # "size":I
    .end local v11    # "tokens":[Ljava/lang/String;
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 104
    .restart local v7    # "i":I
    .restart local v10    # "size":I
    .restart local v11    # "tokens":[Ljava/lang/String;
    :cond_0
    :try_start_3
    iget-object v0, p0, Lcom/android/mail/providers/SuggestionsProvider;->mFullQueryTerms:Ljava/util/ArrayList;

    invoke-super {p0, v0}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->setFullQueryTerms(Ljava/util/ArrayList;)V

    .line 105
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 110
    .end local v7    # "i":I
    .end local v10    # "size":I
    :goto_1
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 113
    .local v6, "cursors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/database/Cursor;>;"
    const/4 v0, 0x1

    new-array v4, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    aput-object v9, v4, v0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object/from16 v5, p5

    invoke-super/range {v0 .. v5}, Lcom/android/mail/providers/SearchRecentSuggestionsProvider;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 115
    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x2

    if-lt v0, v1, :cond_1

    .line 116
    new-instance v0, Lcom/android/mail/providers/SuggestionsProvider$ContactsCursor;

    invoke-direct {v0, p0}, Lcom/android/mail/providers/SuggestionsProvider$ContactsCursor;-><init>(Lcom/android/mail/providers/SuggestionsProvider;)V

    invoke-virtual {v0, v9}, Lcom/android/mail/providers/SuggestionsProvider$ContactsCursor;->query(Ljava/lang/String;)Lcom/android/mail/providers/SuggestionsProvider$ContactsCursor;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 118
    :cond_1
    new-instance v8, Landroid/database/MergeCursor;

    .end local v8    # "mergeCursor":Landroid/database/MergeCursor;
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [Landroid/database/Cursor;

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/database/Cursor;

    invoke-direct {v8, v0}, Landroid/database/MergeCursor;-><init>([Landroid/database/Cursor;)V

    .line 120
    .end local v6    # "cursors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/database/Cursor;>;"
    .end local v11    # "tokens":[Ljava/lang/String;
    .restart local v8    # "mergeCursor":Landroid/database/MergeCursor;
    :cond_2
    return-object v8

    .line 105
    .restart local v11    # "tokens":[Ljava/lang/String;
    :catchall_1
    move-exception v0

    :try_start_4
    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v0

    .line 108
    :cond_3
    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    goto :goto_1
.end method
