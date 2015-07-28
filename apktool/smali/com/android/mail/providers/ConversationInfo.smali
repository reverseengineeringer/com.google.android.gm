.class public Lcom/android/mail/providers/ConversationInfo;
.super Ljava/lang/Object;
.source "ConversationInfo.java"


# static fields
.field private static MESSAGE_CONV_SPLITTER_REGEX:Ljava/util/regex/Pattern;

.field private static MESSAGE_SPLITTER_REGEX:Ljava/util/regex/Pattern;

.field public static SPLITTER:Ljava/lang/String;

.field private static SPLITTER_REGEX:Ljava/util/regex/Pattern;


# instance fields
.field public draftCount:I

.field public firstSnippet:Ljava/lang/String;

.field public firstUnreadSnippet:Ljava/lang/String;

.field public lastSnippet:Ljava/lang/String;

.field public messageCount:I

.field public final messageInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/providers/MessageInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-string v0, "^*^"

    sput-object v0, Lcom/android/mail/providers/ConversationInfo;->SPLITTER:Ljava/lang/String;

    .line 27
    const-string v0, "\\^\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/ConversationInfo;->SPLITTER_REGEX:Ljava/util/regex/Pattern;

    .line 29
    const-string v0, "\\^\\*\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/ConversationInfo;->MESSAGE_CONV_SPLITTER_REGEX:Ljava/util/regex/Pattern;

    .line 31
    const-string v0, "\\^\\*\\*\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/ConversationInfo;->MESSAGE_SPLITTER_REGEX:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    .line 42
    return-void
.end method

.method public constructor <init>(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "count"    # I
    .param p2, "draft"    # I
    .param p3, "first"    # Ljava/lang/String;
    .param p4, "firstUnread"    # Ljava/lang/String;
    .param p5, "last"    # Ljava/lang/String;

    .prologue
    .line 44
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 45
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    .line 46
    invoke-virtual/range {p0 .. p5}, Lcom/android/mail/providers/ConversationInfo;->set(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/android/mail/providers/ConversationInfo;
    .locals 4
    .param p0, "inString"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 96
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 107
    :cond_0
    :goto_0
    return-object v1

    .line 99
    :cond_1
    sget-object v2, Lcom/android/mail/providers/ConversationInfo;->MESSAGE_CONV_SPLITTER_REGEX:Ljava/util/regex/Pattern;

    invoke-static {p0, v2}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v0

    .line 100
    .local v0, "convMessageSplit":[Ljava/lang/String;
    array-length v2, v0

    const/4 v3, 0x2

    if-lt v2, v3, :cond_0

    .line 104
    const/4 v2, 0x0

    aget-object v2, v0, v2

    invoke-static {v2}, Lcom/android/mail/providers/ConversationInfo;->parseConversation(Ljava/lang/String;)Lcom/android/mail/providers/ConversationInfo;

    move-result-object v1

    .line 106
    .local v1, "info":Lcom/android/mail/providers/ConversationInfo;
    const/4 v2, 0x1

    aget-object v2, v0, v2

    invoke-static {v1, v2}, Lcom/android/mail/providers/ConversationInfo;->parseMessages(Lcom/android/mail/providers/ConversationInfo;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static getMessageInfoString(Lcom/android/mail/providers/ConversationInfo;)Ljava/lang/String;
    .locals 5
    .param p0, "info"    # Lcom/android/mail/providers/ConversationInfo;

    .prologue
    .line 83
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 84
    .local v0, "builder":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .line 85
    .local v1, "i":I
    iget-object v4, p0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/mail/providers/MessageInfo;

    .line 86
    .local v3, "msg":Lcom/android/mail/providers/MessageInfo;
    invoke-static {v3}, Lcom/android/mail/providers/MessageInfo;->toString(Lcom/android/mail/providers/MessageInfo;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 87
    iget-object v4, p0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-ge v1, v4, :cond_0

    .line 88
    const-string v4, "^***^"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 90
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 92
    .end local v3    # "msg":Lcom/android/mail/providers/MessageInfo;
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method private static parseConversation(Ljava/lang/String;)Lcom/android/mail/providers/ConversationInfo;
    .locals 7
    .param p0, "conv"    # Ljava/lang/String;

    .prologue
    .line 118
    sget-object v0, Lcom/android/mail/providers/ConversationInfo;->SPLITTER_REGEX:Ljava/util/regex/Pattern;

    invoke-static {p0, v0}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v6

    .line 119
    .local v6, "split":[Ljava/lang/String;
    const/4 v0, 0x0

    aget-object v0, v6, v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 120
    .local v1, "messageCount":I
    const/4 v0, 0x1

    aget-object v0, v6, v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 121
    .local v2, "draftCount":I
    const/4 v0, 0x2

    aget-object v3, v6, v0

    .line 122
    .local v3, "first":Ljava/lang/String;
    const/4 v0, 0x3

    aget-object v4, v6, v0

    .line 123
    .local v4, "firstUnread":Ljava/lang/String;
    const/4 v0, 0x4

    aget-object v5, v6, v0

    .line 124
    .local v5, "lastUnread":Ljava/lang/String;
    new-instance v0, Lcom/android/mail/providers/ConversationInfo;

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/providers/ConversationInfo;-><init>(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method private static parseMessages(Lcom/android/mail/providers/ConversationInfo;Ljava/lang/String;)V
    .locals 6
    .param p0, "info"    # Lcom/android/mail/providers/ConversationInfo;
    .param p1, "messagesString"    # Ljava/lang/String;

    .prologue
    .line 111
    sget-object v5, Lcom/android/mail/providers/ConversationInfo;->MESSAGE_SPLITTER_REGEX:Ljava/util/regex/Pattern;

    invoke-static {p1, v5}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v4

    .line 112
    .local v4, "messages":[Ljava/lang/String;
    move-object v0, v4

    .local v0, "arr$":[Ljava/lang/String;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 113
    .local v3, "m":Ljava/lang/String;
    invoke-static {v3}, Lcom/android/mail/providers/MessageInfo;->fromString(Ljava/lang/String;)Lcom/android/mail/providers/MessageInfo;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/android/mail/providers/ConversationInfo;->addMessage(Lcom/android/mail/providers/MessageInfo;)V

    .line 112
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 115
    .end local v3    # "m":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static toString(Lcom/android/mail/providers/ConversationInfo;)Ljava/lang/String;
    .locals 2
    .param p0, "info"    # Lcom/android/mail/providers/ConversationInfo;

    .prologue
    .line 63
    if-nez p0, :cond_0

    .line 64
    const/4 v1, 0x0

    .line 78
    :goto_0
    return-object v1

    .line 66
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 67
    .local v0, "builder":Ljava/lang/StringBuilder;
    iget v1, p0, Lcom/android/mail/providers/ConversationInfo;->messageCount:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 68
    sget-object v1, Lcom/android/mail/providers/ConversationInfo;->SPLITTER:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 69
    iget v1, p0, Lcom/android/mail/providers/ConversationInfo;->draftCount:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 70
    sget-object v1, Lcom/android/mail/providers/ConversationInfo;->SPLITTER:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 71
    iget-object v1, p0, Lcom/android/mail/providers/ConversationInfo;->firstSnippet:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 72
    sget-object v1, Lcom/android/mail/providers/ConversationInfo;->SPLITTER:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 73
    iget-object v1, p0, Lcom/android/mail/providers/ConversationInfo;->firstUnreadSnippet:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 74
    sget-object v1, Lcom/android/mail/providers/ConversationInfo;->SPLITTER:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 75
    iget-object v1, p0, Lcom/android/mail/providers/ConversationInfo;->lastSnippet:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 76
    const-string v1, "^**^"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 77
    invoke-static {p0}, Lcom/android/mail/providers/ConversationInfo;->getMessageInfoString(Lcom/android/mail/providers/ConversationInfo;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 78
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method public addMessage(Lcom/android/mail/providers/MessageInfo;)V
    .locals 1
    .param p1, "info"    # Lcom/android/mail/providers/MessageInfo;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 60
    return-void
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 142
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget v2, p0, Lcom/android/mail/providers/ConversationInfo;->messageCount:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget v2, p0, Lcom/android/mail/providers/ConversationInfo;->draftCount:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/android/mail/providers/ConversationInfo;->firstSnippet:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    iget-object v2, p0, Lcom/android/mail/providers/ConversationInfo;->lastSnippet:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    iget-object v2, p0, Lcom/android/mail/providers/ConversationInfo;->firstUnreadSnippet:Ljava/lang/String;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public markRead(Z)Z
    .locals 4
    .param p1, "read"    # Z

    .prologue
    .line 128
    const/4 v0, 0x0

    .line 129
    .local v0, "changed":Z
    iget-object v3, p0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/providers/MessageInfo;

    .line 130
    .local v2, "msg":Lcom/android/mail/providers/MessageInfo;
    invoke-virtual {v2, p1}, Lcom/android/mail/providers/MessageInfo;->markRead(Z)Z

    move-result v3

    or-int/2addr v0, v3

    goto :goto_0

    .line 132
    .end local v2    # "msg":Lcom/android/mail/providers/MessageInfo;
    :cond_0
    if-eqz p1, :cond_1

    .line 133
    iget-object v3, p0, Lcom/android/mail/providers/ConversationInfo;->lastSnippet:Ljava/lang/String;

    iput-object v3, p0, Lcom/android/mail/providers/ConversationInfo;->firstSnippet:Ljava/lang/String;

    .line 137
    :goto_1
    return v0

    .line 135
    :cond_1
    iget-object v3, p0, Lcom/android/mail/providers/ConversationInfo;->firstUnreadSnippet:Ljava/lang/String;

    iput-object v3, p0, Lcom/android/mail/providers/ConversationInfo;->firstSnippet:Ljava/lang/String;

    goto :goto_1
.end method

.method public set(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "count"    # I
    .param p2, "draft"    # I
    .param p3, "first"    # Ljava/lang/String;
    .param p4, "firstUnread"    # Ljava/lang/String;
    .param p5, "last"    # Ljava/lang/String;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 51
    iput p1, p0, Lcom/android/mail/providers/ConversationInfo;->messageCount:I

    .line 52
    iput p2, p0, Lcom/android/mail/providers/ConversationInfo;->draftCount:I

    .line 53
    iput-object p3, p0, Lcom/android/mail/providers/ConversationInfo;->firstSnippet:Ljava/lang/String;

    .line 54
    iput-object p4, p0, Lcom/android/mail/providers/ConversationInfo;->firstUnreadSnippet:Ljava/lang/String;

    .line 55
    iput-object p5, p0, Lcom/android/mail/providers/ConversationInfo;->lastSnippet:Ljava/lang/String;

    .line 56
    return-void
.end method
