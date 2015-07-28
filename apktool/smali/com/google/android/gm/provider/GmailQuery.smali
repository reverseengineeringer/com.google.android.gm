.class public Lcom/google/android/gm/provider/GmailQuery;
.super Ljava/lang/Object;
.source "GmailQuery.java"


# static fields
.field static final ALL_MAIL_SEARCH_NAME:Ljava/lang/String; = "all"

.field public static final ATTACHMENT_QUERY_PATTERN:Ljava/util/regex/Pattern;

.field private static final CANONICAL_NAME_LABEL_OPERATION_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static final CHAT_PATTERN:Ljava/util/regex/Pattern;

.field static final CHAT_SEARCH_NAME:Ljava/lang/String; = "chats"

.field static final DRAFT_SEARCH_NAME:Ljava/lang/String; = "drafts"

.field private static final FROM_PATTERN:Ljava/util/regex/Pattern;

.field public static final IMPORTANT_PATTERN:Ljava/util/regex/Pattern;

.field static final IMPORTANT_SEARCH_NAME:Ljava/lang/String; = "imp"

.field static final INBOX_SEARCH_NAME:Ljava/lang/String; = "inbox"

.field private static final IS_READ_PATTERN:Ljava/util/regex/Pattern;

.field private static final LABEL_OPERATION_CANONICAL_NAME_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final LABEL_PATTERN:Ljava/util/regex/Pattern;

.field static final LOCAL_CONVERSATION_SEARCH_COLUMNS:[Ljava/lang/String;

.field static final LOCAL_MESSAGE_SEARCH_COLUMNS:[Ljava/lang/String;

.field static final PRIORITY_INBOX_SEARCH_NAME:Ljava/lang/String; = "^iim"

.field private static final QUOTED_TEXT_PATTERN:Ljava/util/regex/Pattern;

.field static final SENT_MAIL_SEARCH_NAME:Ljava/lang/String; = "sent"

.field static final SPAM_SEARCH_NAME:Ljava/lang/String; = "spam"

.field private static final SPECIAL_LABEL_PATTERN:Ljava/util/regex/Pattern;

.field static final STARRED_SEARCH_NAME:Ljava/lang/String; = "starred"

.field public static final STAR_PATTERN:Ljava/util/regex/Pattern;

.field private static final SUBJECT_PATTERN:Ljava/util/regex/Pattern;

.field private static final TO_PATTERN:Ljava/util/regex/Pattern;

.field static final TRASH_SEARCH_NAME:Ljava/lang/String; = "trash"

.field public static final UNREAD_PATTERN:Ljava/util/regex/Pattern;


# instance fields
.field private final mAccount:Ljava/lang/String;

.field mAttachmentQuery:Z

.field private final mFoundOperations:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final mFromFilters:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mFtsEnabled:Z

.field mIsReadQuery:Z

.field private final mLabelAccess:Lcom/google/android/gm/provider/MailCoreLabelAccess;

.field final mLabelFilters:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final mQueryString:Ljava/lang/String;

.field private mRemainingQuery:Ljava/lang/String;

.field final mSubjectFilters:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final mToFilters:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 28
    const-string v0, "\\b(is|in|label):\\s*unread\\b"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->UNREAD_PATTERN:Ljava/util/regex/Pattern;

    .line 30
    const-string v0, "\\b(is|in|label):\\s*starred\\b"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->STAR_PATTERN:Ljava/util/regex/Pattern;

    .line 32
    const-string v0, "\\b(is|in|label):\\s*chat\\b"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->CHAT_PATTERN:Ljava/util/regex/Pattern;

    .line 34
    const-string v0, "\\b(is|in|label):\\s*important\\b"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->IMPORTANT_PATTERN:Ljava/util/regex/Pattern;

    .line 36
    const-string v0, "\\bhas:attachment\\b"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->ATTACHMENT_QUERY_PATTERN:Ljava/util/regex/Pattern;

    .line 48
    const-string v0, "(^|\\s+)to:\\s*(\\S+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->TO_PATTERN:Ljava/util/regex/Pattern;

    .line 51
    const-string v0, "(^|\\s+)from:\\s*(\\S+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->FROM_PATTERN:Ljava/util/regex/Pattern;

    .line 56
    const-string v0, "\\b(in|label):\\s*(\\S+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->LABEL_PATTERN:Ljava/util/regex/Pattern;

    .line 60
    const-string v0, "\\bsubject:\\s*(\\S+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->SUBJECT_PATTERN:Ljava/util/regex/Pattern;

    .line 64
    const-string v0, "\\bis:\\s*(starred|chat|important|unread|muted)\\b"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->SPECIAL_LABEL_PATTERN:Ljava/util/regex/Pattern;

    .line 68
    const-string v0, "\\bis:read\\b"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->IS_READ_PATTERN:Ljava/util/regex/Pattern;

    .line 70
    const-string v0, "\\\"(.*)\\\""

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->QUOTED_TEXT_PATTERN:Ljava/util/regex/Pattern;

    .line 99
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "conversations.subject"

    aput-object v1, v0, v2

    const-string v1, "conversations.snippet"

    aput-object v1, v0, v3

    const-string v1, "conversations.fromAddress"

    aput-object v1, v0, v4

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->LOCAL_CONVERSATION_SEARCH_COLUMNS:[Ljava/lang/String;

    .line 103
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "subject"

    aput-object v1, v0, v2

    const-string v1, "snippet"

    aput-object v1, v0, v3

    const-string v1, "body"

    aput-object v1, v0, v4

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->LOCAL_MESSAGE_SEARCH_COLUMNS:[Ljava/lang/String;

    .line 110
    new-instance v0, Lcom/google/common/collect/ImmutableMap$Builder;

    invoke-direct {v0}, Lcom/google/common/collect/ImmutableMap$Builder;-><init>()V

    const-string v1, "starred"

    const-string v2, "^t"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "chat"

    const-string v2, "^b"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "chats"

    const-string v2, "^b"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "important"

    const-string v2, "^io_im"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "unread"

    const-string v2, "^u"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "muted"

    const-string v2, "^g"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^iim"

    const-string v2, "^iim"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "inbox"

    const-string v2, "^i"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "all"

    const-string v2, "^all"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "sent"

    const-string v2, "^f"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "drafts"

    const-string v2, "^r"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "imp"

    const-string v2, "^io_im"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "spam"

    const-string v2, "^s"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "trash"

    const-string v2, "^k"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableMap$Builder;->build()Lcom/google/common/collect/ImmutableMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->LABEL_OPERATION_CANONICAL_NAME_MAP:Ljava/util/Map;

    .line 130
    new-instance v0, Lcom/google/common/collect/ImmutableMap$Builder;

    invoke-direct {v0}, Lcom/google/common/collect/ImmutableMap$Builder;-><init>()V

    const-string v1, "^iim"

    const-string v2, "^iim"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^i"

    const-string v2, "inbox"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^all"

    const-string v2, "all"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^f"

    const-string v2, "sent"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^r"

    const-string v2, "drafts"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^t"

    const-string v2, "starred"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^im"

    const-string v2, "imp"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^io_im"

    const-string v2, "imp"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^b"

    const-string v2, "chats"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^s"

    const-string v2, "spam"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    const-string v1, "^k"

    const-string v2, "trash"

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableMap$Builder;->build()Lcom/google/common/collect/ImmutableMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/GmailQuery;->CANONICAL_NAME_LABEL_OPERATION_MAP:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gm/provider/MailCoreLabelAccess;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "labelAccess"    # Lcom/google/android/gm/provider/MailCoreLabelAccess;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "query"    # Ljava/lang/String;
    .param p4, "useFullTextSearch"    # Z

    .prologue
    const/4 v1, 0x0

    .line 276
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 277
    iput-object p1, p0, Lcom/google/android/gm/provider/GmailQuery;->mLabelAccess:Lcom/google/android/gm/provider/MailCoreLabelAccess;

    .line 278
    iput-object p2, p0, Lcom/google/android/gm/provider/GmailQuery;->mAccount:Ljava/lang/String;

    .line 280
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/GmailQuery;->mToFilters:Ljava/util/Set;

    .line 281
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/GmailQuery;->mFromFilters:Ljava/util/Set;

    .line 282
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/GmailQuery;->mLabelFilters:Ljava/util/Set;

    .line 283
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/GmailQuery;->mSubjectFilters:Ljava/util/Set;

    .line 284
    iput-boolean v1, p0, Lcom/google/android/gm/provider/GmailQuery;->mAttachmentQuery:Z

    .line 285
    iput-boolean v1, p0, Lcom/google/android/gm/provider/GmailQuery;->mIsReadQuery:Z

    .line 286
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/GmailQuery;->mFoundOperations:Ljava/util/Set;

    .line 287
    iput-object p3, p0, Lcom/google/android/gm/provider/GmailQuery;->mQueryString:Ljava/lang/String;

    .line 288
    iput-boolean p4, p0, Lcom/google/android/gm/provider/GmailQuery;->mFtsEnabled:Z

    .line 290
    invoke-direct {p0}, Lcom/google/android/gm/provider/GmailQuery;->parse()V

    .line 291
    return-void
.end method

.method private addFullTextSearchClauses([Ljava/lang/String;)Ljava/util/List;
    .locals 5
    .param p1, "queryTokens"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 389
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 390
    .local v0, "clauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 391
    .local v2, "sb":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v4, p1

    if-ge v1, v4, :cond_0

    .line 392
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v3

    .line 395
    .local v3, "subClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v4, "conversations._id IN (SELECT docid FROM conversation_fts_table WHERE conversation_fts_table MATCH ? )"

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 402
    const-string v4, "conversations._id IN (SELECT conversation FROM message_fts_table WHERE message_fts_table MATCH ? )"

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 408
    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 409
    const/16 v4, 0x28

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 410
    const-string v4, " OR "

    invoke-static {v4, v3}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 411
    const/16 v4, 0x29

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 412
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 391
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 414
    .end local v3    # "subClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_0
    return-object v0
.end method

.method private addFullTextSearchToArgList(Ljava/util/Collection;ILjava/util/List;)V
    .locals 6
    .param p2, "numIndexes"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 511
    .local p1, "queryTokens":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    .local p3, "argList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 515
    .local v2, "token":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "\""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 516
    .local v3, "tokenArg":Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p2, :cond_0

    .line 517
    invoke-interface {p3, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 516
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 520
    .end local v0    # "i":I
    .end local v2    # "token":Ljava/lang/String;
    .end local v3    # "tokenArg":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private addLabelQueryOperation(Ljava/util/regex/MatchResult;Ljava/lang/String;)V
    .locals 6
    .param p1, "result"    # Ljava/util/regex/MatchResult;
    .param p2, "operation"    # Ljava/lang/String;

    .prologue
    .line 656
    iget-object v3, p0, Lcom/google/android/gm/provider/GmailQuery;->mLabelAccess:Lcom/google/android/gm/provider/MailCoreLabelAccess;

    invoke-interface {v3, p2}, Lcom/google/android/gm/provider/MailCoreLabelAccess;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v2

    .line 658
    .local v2, "label":Lcom/google/android/gm/provider/MailCore$Label;
    if-nez v2, :cond_0

    .line 661
    sget-object v3, Lcom/google/android/gm/provider/GmailQuery;->LABEL_OPERATION_CANONICAL_NAME_MAP:Ljava/util/Map;

    invoke-interface {v3, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 662
    .local v0, "canonicalName":Ljava/lang/String;
    iget-object v3, p0, Lcom/google/android/gm/provider/GmailQuery;->mLabelAccess:Lcom/google/android/gm/provider/MailCoreLabelAccess;

    invoke-interface {v3, v0}, Lcom/google/android/gm/provider/MailCoreLabelAccess;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v2

    .line 665
    .end local v0    # "canonicalName":Ljava/lang/String;
    :cond_0
    if-eqz v2, :cond_1

    .line 666
    invoke-interface {p1}, Ljava/util/regex/MatchResult;->group()Ljava/lang/String;

    move-result-object v1

    .line 667
    .local v1, "fullGroup":Ljava/lang/String;
    iget-object v3, p0, Lcom/google/android/gm/provider/GmailQuery;->mLabelFilters:Ljava/util/Set;

    iget-wide v4, v2, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 668
    iget-object v3, p0, Lcom/google/android/gm/provider/GmailQuery;->mFoundOperations:Ljava/util/Set;

    invoke-interface {v3, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 670
    .end local v1    # "fullGroup":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private addLikeSearchClauses([Ljava/lang/String;)Ljava/util/List;
    .locals 14
    .param p1, "queryTokens"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/16 v13, 0x29

    const/4 v12, 0x0

    .line 418
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 419
    .local v1, "clauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 420
    .local v8, "sb":Ljava/lang/StringBuilder;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v10, p1

    if-ge v3, v10, :cond_2

    .line 422
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v9

    .line 423
    .local v9, "subClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->LOCAL_CONVERSATION_SEARCH_COLUMNS:[Ljava/lang/String;

    .local v0, "arr$":[Ljava/lang/String;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_1
    if-ge v4, v5, :cond_0

    aget-object v2, v0, v4

    .line 424
    .local v2, "column":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " LIKE ?"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 423
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 429
    .end local v2    # "column":Ljava/lang/String;
    :cond_0
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v6

    .line 430
    .local v6, "messageClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->LOCAL_MESSAGE_SEARCH_COLUMNS:[Ljava/lang/String;

    array-length v5, v0

    const/4 v4, 0x0

    :goto_2
    if-ge v4, v5, :cond_1

    aget-object v7, v0, v4

    .line 431
    .local v7, "messageColumn":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " LIKE ?"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 430
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 433
    .end local v7    # "messageColumn":Ljava/lang/String;
    :cond_1
    invoke-virtual {v8, v12}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 434
    const-string v10, "conversations._id IN (SELECT conversation FROM messages WHERE "

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 435
    const-string v10, " OR "

    invoke-static {v10, v6}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 436
    invoke-virtual {v8, v13}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 437
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 440
    invoke-virtual {v8, v12}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 441
    const/16 v10, 0x28

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 442
    const-string v10, " OR "

    invoke-static {v10, v9}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 443
    invoke-virtual {v8, v13}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 444
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 420
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0

    .line 446
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v4    # "i$":I
    .end local v5    # "len$":I
    .end local v6    # "messageClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v9    # "subClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_2
    return-object v1
.end method

.method private addTokensToArgList(Ljava/util/Collection;ILjava/util/List;)V
    .locals 5
    .param p2, "numColumns"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 528
    .local p1, "queryTokens":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    .local p3, "argList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 529
    .local v2, "token":Ljava/lang/String;
    invoke-direct {p0, v2}, Lcom/google/android/gm/provider/GmailQuery;->createLikeParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 530
    .local v3, "tokenArg":Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p2, :cond_0

    .line 531
    invoke-interface {p3, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 530
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 534
    .end local v0    # "i":I
    .end local v2    # "token":Ljava/lang/String;
    .end local v3    # "tokenArg":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method private createLikeParameter(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "param"    # Ljava/lang/String;

    .prologue
    .line 537
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "%"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "%"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private findMatches(Ljava/util/regex/Pattern;)Ljava/util/List;
    .locals 1
    .param p1, "pattern"    # Ljava/util/regex/Pattern;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/regex/Pattern;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/util/regex/MatchResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 676
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailQuery;->mQueryString:Ljava/lang/String;

    invoke-static {p1, v0}, Lcom/google/android/gm/provider/GmailQuery;->findMatches(Ljava/util/regex/Pattern;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private static findMatches(Ljava/util/regex/Pattern;Ljava/lang/String;)Ljava/util/List;
    .locals 4
    .param p0, "pattern"    # Ljava/util/regex/Pattern;
    .param p1, "query"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/regex/Pattern;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/util/regex/MatchResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 680
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 682
    .local v1, "results":Ljava/util/List;, "Ljava/util/List<Ljava/util/regex/MatchResult;>;"
    invoke-virtual {p0, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 684
    .local v0, "matcher":Ljava/util/regex/Matcher;
    const/4 v2, 0x0

    .line 685
    .local v2, "start":I
    :goto_0
    invoke-virtual {v0, v2}, Ljava/util/regex/Matcher;->find(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 686
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->toMatchResult()Ljava/util/regex/MatchResult;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 690
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->end()I

    move-result v2

    goto :goto_0

    .line 692
    :cond_0
    return-object v1
.end method

.method public static getCanonicalNameForLabelOperation(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "operation"    # Ljava/lang/String;

    .prologue
    .line 221
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->LABEL_OPERATION_CANONICAL_NAME_MAP:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public static getLabelQueryOperationString(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "label"    # Ljava/lang/String;

    .prologue
    .line 211
    sget-object v1, Lcom/google/android/gm/provider/GmailQuery;->CANONICAL_NAME_LABEL_OPERATION_MAP:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/google/android/gm/provider/GmailQuery;->CANONICAL_NAME_LABEL_OPERATION_MAP:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    move-object v0, v1

    .line 213
    .local v0, "operation":Ljava/lang/String;
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "label:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .end local v0    # "operation":Ljava/lang/String;
    :cond_0
    move-object v0, p0

    .line 211
    goto :goto_0
.end method

.method public static getLabelSearchString(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 181
    invoke-static {p0}, Lcom/google/android/gm/provider/Gmail;->isSystemLabel(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 182
    invoke-static {p0}, Lcom/google/android/gm/provider/GmailQuery;->getSearchName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 186
    .local v0, "labelSearchString":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 184
    .end local v0    # "labelSearchString":Ljava/lang/String;
    :cond_0
    move-object v0, p0

    .restart local v0    # "labelSearchString":Ljava/lang/String;
    goto :goto_0
.end method

.method public static getMatchingLabelOperation(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "query"    # Ljava/lang/String;
    .param p1, "labelOperation"    # Ljava/lang/String;

    .prologue
    .line 195
    sget-object v4, Lcom/google/android/gm/provider/GmailQuery;->LABEL_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v4, p0}, Lcom/google/android/gm/provider/GmailQuery;->findMatches(Ljava/util/regex/Pattern;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 196
    .local v3, "results":Ljava/util/List;, "Ljava/util/List<Ljava/util/regex/MatchResult;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/regex/MatchResult;

    .line 197
    .local v2, "result":Ljava/util/regex/MatchResult;
    const/4 v4, 0x2

    invoke-interface {v2, v4}, Ljava/util/regex/MatchResult;->group(I)Ljava/lang/String;

    move-result-object v1

    .line 198
    .local v1, "matchString":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-static {v1, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 199
    invoke-interface {v2}, Ljava/util/regex/MatchResult;->group()Ljava/lang/String;

    move-result-object v4

    .line 202
    .end local v1    # "matchString":Ljava/lang/String;
    .end local v2    # "result":Ljava/util/regex/MatchResult;
    :goto_0
    return-object v4

    :cond_1
    const/4 v4, 0x0

    goto :goto_0
.end method

.method private getMessageTableQueryClauses([Ljava/lang/String;I)Ljava/util/ArrayList;
    .locals 10
    .param p1, "messageColumns"    # [Ljava/lang/String;
    .param p2, "numFilters"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "I)",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 450
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v4

    .line 451
    .local v4, "messageClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 452
    .local v7, "sb":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, p2, :cond_1

    .line 453
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v6

    .line 454
    .local v6, "messageSubClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v3, :cond_0

    aget-object v5, v0, v2

    .line 455
    .local v5, "messageColumn":Ljava/lang/String;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " LIKE ?"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 454
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 457
    .end local v5    # "messageColumn":Ljava/lang/String;
    :cond_0
    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 458
    const-string v8, "conversations._id IN (SELECT conversation FROM messages WHERE "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 460
    const-string v8, " OR "

    invoke-static {v8, v6}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 461
    const/16 v8, 0x29

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 463
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 452
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 465
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v6    # "messageSubClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_1
    return-object v4
.end method

.method private static getSearchName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 270
    sget-object v1, Lcom/google/android/gm/provider/GmailQuery;->CANONICAL_NAME_LABEL_OPERATION_MAP:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 271
    .local v0, "searchName":Ljava/lang/String;
    if-eqz v0, :cond_0

    .end local v0    # "searchName":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "searchName":Ljava/lang/String;
    :cond_0
    move-object v0, p0

    goto :goto_0
.end method

.method public static isAttachmentQuery(Ljava/lang/String;)Z
    .locals 1
    .param p0, "query"    # Ljava/lang/String;

    .prologue
    .line 254
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->ATTACHMENT_QUERY_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    return v0
.end method

.method public static isChatQuery(Ljava/lang/String;)Z
    .locals 1
    .param p0, "query"    # Ljava/lang/String;

    .prologue
    .line 237
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->CHAT_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    return v0
.end method

.method public static isImportantQuery(Ljava/lang/String;)Z
    .locals 1
    .param p0, "query"    # Ljava/lang/String;

    .prologue
    .line 245
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->IMPORTANT_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    return v0
.end method

.method public static isStarQuery(Ljava/lang/String;)Z
    .locals 1
    .param p0, "query"    # Ljava/lang/String;

    .prologue
    .line 262
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->STAR_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    return v0
.end method

.method public static isUnreadQuery(Ljava/lang/String;)Z
    .locals 1
    .param p0, "query"    # Ljava/lang/String;

    .prologue
    .line 229
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->UNREAD_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    return v0
.end method

.method private parse()V
    .locals 3

    .prologue
    const/4 v2, 0x2

    .line 295
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->TO_PATTERN:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/google/android/gm/provider/GmailQuery;->mToFilters:Ljava/util/Set;

    invoke-direct {p0, v0, v2, v1}, Lcom/google/android/gm/provider/GmailQuery;->parseAddressOperations(Ljava/util/regex/Pattern;ILjava/util/Set;)V

    .line 298
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->FROM_PATTERN:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/google/android/gm/provider/GmailQuery;->mFromFilters:Ljava/util/Set;

    invoke-direct {p0, v0, v2, v1}, Lcom/google/android/gm/provider/GmailQuery;->parseAddressOperations(Ljava/util/regex/Pattern;ILjava/util/Set;)V

    .line 301
    invoke-direct {p0}, Lcom/google/android/gm/provider/GmailQuery;->parselabelOperations()V

    .line 304
    sget-object v0, Lcom/google/android/gm/provider/GmailQuery;->SUBJECT_PATTERN:Ljava/util/regex/Pattern;

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/google/android/gm/provider/GmailQuery;->mSubjectFilters:Ljava/util/Set;

    invoke-direct {p0, v0, v1, v2}, Lcom/google/android/gm/provider/GmailQuery;->parseQueryOperations(Ljava/util/regex/Pattern;ILjava/util/Set;)V

    .line 307
    invoke-direct {p0}, Lcom/google/android/gm/provider/GmailQuery;->parseAttachmentQueries()V

    .line 310
    invoke-virtual {p0}, Lcom/google/android/gm/provider/GmailQuery;->getRemaingSearchQuery()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/GmailQuery;->mRemainingQuery:Ljava/lang/String;

    .line 311
    return-void
.end method

.method private parseAddressOperations(Ljava/util/regex/Pattern;ILjava/util/Set;)V
    .locals 7
    .param p1, "pattern"    # Ljava/util/regex/Pattern;
    .param p2, "groupNum"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/regex/Pattern;",
            "I",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 581
    .local p3, "addressFilters":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/GmailQuery;->findMatches(Ljava/util/regex/Pattern;)Ljava/util/List;

    move-result-object v5

    .line 582
    .local v5, "results":Ljava/util/List;, "Ljava/util/List<Ljava/util/regex/MatchResult;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/regex/MatchResult;

    .line 583
    .local v4, "result":Ljava/util/regex/MatchResult;
    invoke-interface {v4, p2}, Ljava/util/regex/MatchResult;->group(I)Ljava/lang/String;

    move-result-object v3

    .line 584
    .local v3, "matchString":Ljava/lang/String;
    invoke-interface {v4}, Ljava/util/regex/MatchResult;->group()Ljava/lang/String;

    move-result-object v1

    .line 587
    .local v1, "fullGroup":Ljava/lang/String;
    const-string v6, "me"

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/GmailQuery;->mAccount:Ljava/lang/String;

    .line 589
    .local v0, "address":Ljava/lang/String;
    :goto_1
    invoke-interface {p3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 590
    iget-object v6, p0, Lcom/google/android/gm/provider/GmailQuery;->mFoundOperations:Ljava/util/Set;

    invoke-interface {v6, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .end local v0    # "address":Ljava/lang/String;
    :cond_0
    move-object v0, v3

    .line 587
    goto :goto_1

    .line 592
    .end local v1    # "fullGroup":Ljava/lang/String;
    .end local v3    # "matchString":Ljava/lang/String;
    .end local v4    # "result":Ljava/util/regex/MatchResult;
    :cond_1
    return-void
.end method

.method private parseAttachmentQueries()V
    .locals 5

    .prologue
    .line 645
    sget-object v3, Lcom/google/android/gm/provider/GmailQuery;->ATTACHMENT_QUERY_PATTERN:Ljava/util/regex/Pattern;

    invoke-direct {p0, v3}, Lcom/google/android/gm/provider/GmailQuery;->findMatches(Ljava/util/regex/Pattern;)Ljava/util/List;

    move-result-object v2

    .line 646
    .local v2, "results":Ljava/util/List;, "Ljava/util/List<Ljava/util/regex/MatchResult;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/regex/MatchResult;

    .line 647
    .local v1, "result":Ljava/util/regex/MatchResult;
    iget-object v3, p0, Lcom/google/android/gm/provider/GmailQuery;->mFoundOperations:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/regex/MatchResult;->group()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 648
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/google/android/gm/provider/GmailQuery;->mAttachmentQuery:Z

    goto :goto_0

    .line 650
    .end local v1    # "result":Ljava/util/regex/MatchResult;
    :cond_0
    return-void
.end method

.method private parseQueryOperations(Ljava/util/regex/Pattern;ILjava/util/Set;)V
    .locals 6
    .param p1, "pattern"    # Ljava/util/regex/Pattern;
    .param p2, "groupNum"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/regex/Pattern;",
            "I",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 601
    .local p3, "operationFilters":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/GmailQuery;->findMatches(Ljava/util/regex/Pattern;)Ljava/util/List;

    move-result-object v4

    .line 602
    .local v4, "results":Ljava/util/List;, "Ljava/util/List<Ljava/util/regex/MatchResult;>;"
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/regex/MatchResult;

    .line 603
    .local v3, "result":Ljava/util/regex/MatchResult;
    invoke-interface {v3, p2}, Ljava/util/regex/MatchResult;->group(I)Ljava/lang/String;

    move-result-object v2

    .line 604
    .local v2, "matchString":Ljava/lang/String;
    invoke-interface {v3}, Ljava/util/regex/MatchResult;->group()Ljava/lang/String;

    move-result-object v0

    .line 606
    .local v0, "fullGroup":Ljava/lang/String;
    invoke-interface {p3, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 607
    iget-object v5, p0, Lcom/google/android/gm/provider/GmailQuery;->mFoundOperations:Ljava/util/Set;

    invoke-interface {v5, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 609
    .end local v0    # "fullGroup":Ljava/lang/String;
    .end local v2    # "matchString":Ljava/lang/String;
    .end local v3    # "result":Ljava/util/regex/MatchResult;
    :cond_0
    return-void
.end method

.method private parselabelOperations()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 618
    sget-object v5, Lcom/google/android/gm/provider/GmailQuery;->LABEL_PATTERN:Ljava/util/regex/Pattern;

    invoke-direct {p0, v5}, Lcom/google/android/gm/provider/GmailQuery;->findMatches(Ljava/util/regex/Pattern;)Ljava/util/List;

    move-result-object v4

    .line 619
    .local v4, "results":Ljava/util/List;, "Ljava/util/List<Ljava/util/regex/MatchResult;>;"
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/regex/MatchResult;

    .line 620
    .local v3, "result":Ljava/util/regex/MatchResult;
    const/4 v5, 0x2

    invoke-interface {v3, v5}, Ljava/util/regex/MatchResult;->group(I)Ljava/lang/String;

    move-result-object v0

    .line 621
    .local v0, "canonicalName":Ljava/lang/String;
    invoke-direct {p0, v3, v0}, Lcom/google/android/gm/provider/GmailQuery;->addLabelQueryOperation(Ljava/util/regex/MatchResult;Ljava/lang/String;)V

    goto :goto_0

    .line 625
    .end local v0    # "canonicalName":Ljava/lang/String;
    .end local v3    # "result":Ljava/util/regex/MatchResult;
    :cond_0
    sget-object v5, Lcom/google/android/gm/provider/GmailQuery;->SPECIAL_LABEL_PATTERN:Ljava/util/regex/Pattern;

    invoke-direct {p0, v5}, Lcom/google/android/gm/provider/GmailQuery;->findMatches(Ljava/util/regex/Pattern;)Ljava/util/List;

    move-result-object v4

    .line 626
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/regex/MatchResult;

    .line 627
    .restart local v3    # "result":Ljava/util/regex/MatchResult;
    invoke-interface {v3, v7}, Ljava/util/regex/MatchResult;->group(I)Ljava/lang/String;

    move-result-object v2

    .line 629
    .local v2, "labelKeyword":Ljava/lang/String;
    sget-object v5, Lcom/google/android/gm/provider/GmailQuery;->LABEL_OPERATION_CANONICAL_NAME_MAP:Ljava/util/Map;

    invoke-interface {v5, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 631
    .restart local v0    # "canonicalName":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 632
    invoke-direct {p0, v3, v0}, Lcom/google/android/gm/provider/GmailQuery;->addLabelQueryOperation(Ljava/util/regex/MatchResult;Ljava/lang/String;)V

    goto :goto_1

    .line 636
    .end local v0    # "canonicalName":Ljava/lang/String;
    .end local v2    # "labelKeyword":Ljava/lang/String;
    .end local v3    # "result":Ljava/util/regex/MatchResult;
    :cond_2
    sget-object v5, Lcom/google/android/gm/provider/GmailQuery;->IS_READ_PATTERN:Ljava/util/regex/Pattern;

    invoke-direct {p0, v5}, Lcom/google/android/gm/provider/GmailQuery;->findMatches(Ljava/util/regex/Pattern;)Ljava/util/List;

    move-result-object v4

    .line 637
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/regex/MatchResult;

    .line 638
    .restart local v3    # "result":Ljava/util/regex/MatchResult;
    iget-object v5, p0, Lcom/google/android/gm/provider/GmailQuery;->mFoundOperations:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/regex/MatchResult;->group()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 639
    iput-boolean v7, p0, Lcom/google/android/gm/provider/GmailQuery;->mIsReadQuery:Z

    goto :goto_2

    .line 642
    .end local v3    # "result":Ljava/util/regex/MatchResult;
    :cond_3
    return-void
.end method


# virtual methods
.method getQueryBindArgs()Ljava/util/List;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 472
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 474
    .local v0, "argList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/google/android/gm/provider/GmailQuery;->getQueryTokens()[Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v6

    .line 476
    .local v6, "queryTokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-boolean v7, p0, Lcom/google/android/gm/provider/GmailQuery;->mFtsEnabled:Z

    if-eqz v7, :cond_0

    .line 477
    sget-object v7, Lcom/google/android/gm/provider/MailEngine;->FULL_TEXT_SEARCH_TABLES:[Ljava/lang/String;

    array-length v5, v7

    .line 478
    .local v5, "numFtsIndexes":I
    invoke-direct {p0, v6, v5, v0}, Lcom/google/android/gm/provider/GmailQuery;->addFullTextSearchToArgList(Ljava/util/Collection;ILjava/util/List;)V

    .line 487
    .end local v5    # "numFtsIndexes":I
    :goto_0
    iget-object v7, p0, Lcom/google/android/gm/provider/GmailQuery;->mToFilters:Ljava/util/Set;

    sget-object v8, Lcom/google/android/gm/provider/MailEngine;->LOCAL_MESSAGE_TO_SEARCH_COLUMNS:[Ljava/lang/String;

    array-length v8, v8

    invoke-direct {p0, v7, v8, v0}, Lcom/google/android/gm/provider/GmailQuery;->addTokensToArgList(Ljava/util/Collection;ILjava/util/List;)V

    .line 490
    iget-object v7, p0, Lcom/google/android/gm/provider/GmailQuery;->mFromFilters:Ljava/util/Set;

    sget-object v8, Lcom/google/android/gm/provider/MailEngine;->LOCAL_MESSAGE_FROM_SEARCH_COLUMNS:[Ljava/lang/String;

    array-length v8, v8

    invoke-direct {p0, v7, v8, v0}, Lcom/google/android/gm/provider/GmailQuery;->addTokensToArgList(Ljava/util/Collection;ILjava/util/List;)V

    .line 494
    iget-object v7, p0, Lcom/google/android/gm/provider/GmailQuery;->mLabelFilters:Ljava/util/Set;

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    .line 495
    .local v2, "labelId":Ljava/lang/Long;
    invoke-virtual {v2}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v3

    .line 496
    .local v3, "labelIdString":Ljava/lang/String;
    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 497
    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 480
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "labelId":Ljava/lang/Long;
    .end local v3    # "labelIdString":Ljava/lang/String;
    :cond_0
    sget-object v7, Lcom/google/android/gm/provider/GmailQuery;->LOCAL_CONVERSATION_SEARCH_COLUMNS:[Ljava/lang/String;

    array-length v7, v7

    sget-object v8, Lcom/google/android/gm/provider/GmailQuery;->LOCAL_MESSAGE_SEARCH_COLUMNS:[Ljava/lang/String;

    array-length v8, v8

    add-int v4, v7, v8

    .line 483
    .local v4, "numColumns":I
    invoke-direct {p0, v6, v4, v0}, Lcom/google/android/gm/provider/GmailQuery;->addTokensToArgList(Ljava/util/Collection;ILjava/util/List;)V

    goto :goto_0

    .line 501
    .end local v4    # "numColumns":I
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    iget-object v7, p0, Lcom/google/android/gm/provider/GmailQuery;->mSubjectFilters:Ljava/util/Set;

    const/4 v8, 0x1

    invoke-direct {p0, v7, v8, v0}, Lcom/google/android/gm/provider/GmailQuery;->addTokensToArgList(Ljava/util/Collection;ILjava/util/List;)V

    .line 503
    return-object v0
.end method

.method getQueryLikeClause()Ljava/lang/String;
    .locals 8

    .prologue
    .line 336
    invoke-virtual {p0}, Lcom/google/android/gm/provider/GmailQuery;->getQueryTokens()[Ljava/lang/String;

    move-result-object v1

    .line 337
    .local v1, "queryTokens":[Ljava/lang/String;
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v2

    .line 339
    .local v2, "tokenClauses":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-boolean v6, p0, Lcom/google/android/gm/provider/GmailQuery;->mFtsEnabled:Z

    if-eqz v6, :cond_0

    .line 340
    invoke-direct {p0, v1}, Lcom/google/android/gm/provider/GmailQuery;->addFullTextSearchClauses([Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 346
    :goto_0
    sget-object v6, Lcom/google/android/gm/provider/MailEngine;->LOCAL_MESSAGE_TO_SEARCH_COLUMNS:[Ljava/lang/String;

    iget-object v7, p0, Lcom/google/android/gm/provider/GmailQuery;->mToFilters:Ljava/util/Set;

    invoke-interface {v7}, Ljava/util/Set;->size()I

    move-result v7

    invoke-direct {p0, v6, v7}, Lcom/google/android/gm/provider/GmailQuery;->getMessageTableQueryClauses([Ljava/lang/String;I)Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 350
    sget-object v6, Lcom/google/android/gm/provider/MailEngine;->LOCAL_MESSAGE_FROM_SEARCH_COLUMNS:[Ljava/lang/String;

    iget-object v7, p0, Lcom/google/android/gm/provider/GmailQuery;->mFromFilters:Ljava/util/Set;

    invoke-interface {v7}, Ljava/util/Set;->size()I

    move-result v7

    invoke-direct {p0, v6, v7}, Lcom/google/android/gm/provider/GmailQuery;->getMessageTableQueryClauses([Ljava/lang/String;I)Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 354
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget-object v6, p0, Lcom/google/android/gm/provider/GmailQuery;->mLabelFilters:Ljava/util/Set;

    invoke-interface {v6}, Ljava/util/Set;->size()I

    move-result v6

    if-ge v0, v6, :cond_1

    .line 355
    const-string v6, "conversation_labels.conversation_id IN\n(SELECT conversation_labels.conversation_id\n   FROM conversation_labels\n   LEFT OUTER JOIN conversations\n     ON conversation_labels.conversation_id = conversations._id\n     AND conversation_labels.queryId = conversations.queryId\n WHERE conversation_labels.labels_id = ?)\n   AND conversation_labels.labels_id = ? "

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 354
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 342
    .end local v0    # "i":I
    :cond_0
    invoke-direct {p0, v1}, Lcom/google/android/gm/provider/GmailQuery;->addLikeSearchClauses([Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_0

    .line 366
    .restart local v0    # "i":I
    :cond_1
    iget-boolean v6, p0, Lcom/google/android/gm/provider/GmailQuery;->mIsReadQuery:Z

    if-eqz v6, :cond_2

    .line 370
    iget-object v6, p0, Lcom/google/android/gm/provider/GmailQuery;->mLabelAccess:Lcom/google/android/gm/provider/MailCoreLabelAccess;

    const-string v7, "^u"

    invoke-interface {v6, v7}, Lcom/google/android/gm/provider/MailCoreLabelAccess;->getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v6

    iget-wide v3, v6, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    .line 371
    .local v3, "unreadLabelId":J
    invoke-static {v3, v4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    .line 372
    .local v5, "unreadLabelIdStr":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "conversations.labelIds NOT LIKE \'%,"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ",%\'"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 376
    .end local v3    # "unreadLabelId":J
    .end local v5    # "unreadLabelIdStr":Ljava/lang/String;
    :cond_2
    const/4 v0, 0x0

    :goto_2
    iget-object v6, p0, Lcom/google/android/gm/provider/GmailQuery;->mSubjectFilters:Ljava/util/Set;

    invoke-interface {v6}, Ljava/util/Set;->size()I

    move-result v6

    if-ge v0, v6, :cond_3

    .line 377
    const-string v6, "conversations.subject LIKE ?"

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 376
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 381
    :cond_3
    iget-boolean v6, p0, Lcom/google/android/gm/provider/GmailQuery;->mAttachmentQuery:Z

    if-eqz v6, :cond_4

    .line 382
    const-string v6, "conversations.hasAttachments != 0"

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 385
    :cond_4
    const-string v6, " AND "

    invoke-static {v6, v2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method getQueryTokens()[Ljava/lang/String;
    .locals 17

    .prologue
    .line 545
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v8

    .line 547
    .local v8, "queryTokens":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v2

    .line 550
    .local v2, "foundQuotedTokens":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    sget-object v15, Lcom/google/android/gm/provider/GmailQuery;->QUOTED_TEXT_PATTERN:Ljava/util/regex/Pattern;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/GmailQuery;->mRemainingQuery:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-static/range {v15 .. v16}, Lcom/google/android/gm/provider/GmailQuery;->findMatches(Ljava/util/regex/Pattern;Ljava/lang/String;)Ljava/util/List;

    move-result-object v10

    .line 552
    .local v10, "quotedTextMatches":Ljava/util/List;, "Ljava/util/List<Ljava/util/regex/MatchResult;>;"
    invoke-interface {v10}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/regex/MatchResult;

    .line 553
    .local v12, "result":Ljava/util/regex/MatchResult;
    const/4 v15, 0x1

    invoke-interface {v12, v15}, Ljava/util/regex/MatchResult;->group(I)Ljava/lang/String;

    move-result-object v6

    .line 554
    .local v6, "matchString":Ljava/lang/String;
    invoke-interface {v12}, Ljava/util/regex/MatchResult;->group()Ljava/lang/String;

    move-result-object v3

    .line 556
    .local v3, "fullGroup":Ljava/lang/String;
    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 557
    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v15

    invoke-interface {v8, v15}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 561
    .end local v3    # "fullGroup":Ljava/lang/String;
    .end local v6    # "matchString":Ljava/lang/String;
    .end local v12    # "result":Ljava/util/regex/MatchResult;
    :cond_0
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/google/android/gm/provider/GmailQuery;->mRemainingQuery:Ljava/lang/String;

    .line 562
    .local v11, "remainingQuery":Ljava/lang/String;
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 564
    .local v9, "quotedText":Ljava/lang/String;
    const-string v15, " "

    invoke-virtual {v11, v9, v15}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    goto :goto_1

    .line 568
    .end local v9    # "quotedText":Ljava/lang/String;
    :cond_1
    const-string v15, " "

    invoke-static {v11, v15}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v14

    .line 569
    .local v14, "tokens":[Ljava/lang/String;
    move-object v1, v14

    .local v1, "arr$":[Ljava/lang/String;
    array-length v5, v1

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_2
    if-ge v4, v5, :cond_4

    aget-object v13, v1, v4

    .line 571
    .local v13, "token":Ljava/lang/String;
    invoke-static {v13}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-nez v15, :cond_3

    const-string v15, "\""

    const-string v16, ""

    move-object/from16 v0, v16

    invoke-virtual {v13, v15, v0}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v7

    .line 572
    .local v7, "queryToken":Ljava/lang/String;
    :goto_3
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v15

    if-nez v15, :cond_2

    .line 573
    invoke-interface {v8, v7}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 569
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 571
    .end local v7    # "queryToken":Ljava/lang/String;
    :cond_3
    const/4 v7, 0x0

    goto :goto_3

    .line 577
    .end local v13    # "token":Ljava/lang/String;
    :cond_4
    invoke-interface {v8}, Ljava/util/Set;->size()I

    move-result v15

    new-array v15, v15, [Ljava/lang/String;

    invoke-interface {v8, v15}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v15

    check-cast v15, [Ljava/lang/String;

    return-object v15
.end method

.method getRemaingSearchQuery()Ljava/lang/String;
    .locals 4

    .prologue
    .line 700
    iget-object v2, p0, Lcom/google/android/gm/provider/GmailQuery;->mQueryString:Ljava/lang/String;

    .line 701
    .local v2, "remainingQuery":Ljava/lang/String;
    iget-object v3, p0, Lcom/google/android/gm/provider/GmailQuery;->mFoundOperations:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 703
    .local v1, "operation":Ljava/lang/String;
    const-string v3, ""

    invoke-virtual {v2, v1, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 705
    .end local v1    # "operation":Ljava/lang/String;
    :cond_0
    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
