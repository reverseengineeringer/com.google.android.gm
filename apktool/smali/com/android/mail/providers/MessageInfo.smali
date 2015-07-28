.class public Lcom/android/mail/providers/MessageInfo;
.super Ljava/lang/Object;
.source "MessageInfo.java"


# static fields
.field private static final MSG_DIVIDER_REGEX:Ljava/util/regex/Pattern;


# instance fields
.field public priority:I

.field public read:Z

.field public sender:Ljava/lang/String;

.field public starred:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-string v0, "\\^\\*\\*\\*\\*\\^"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/MessageInfo;->MSG_DIVIDER_REGEX:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 35
    return-void
.end method

.method public constructor <init>(ZZLjava/lang/String;I)V
    .locals 0
    .param p1, "isRead"    # Z
    .param p2, "isStarred"    # Z
    .param p3, "senderString"    # Ljava/lang/String;
    .param p4, "p"    # I

    .prologue
    .line 37
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 38
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/android/mail/providers/MessageInfo;->set(ZZLjava/lang/String;I)V

    .line 39
    return-void
.end method

.method public static fromString(Ljava/lang/String;)Lcom/android/mail/providers/MessageInfo;
    .locals 9
    .param p0, "inString"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 69
    sget-object v7, Lcom/android/mail/providers/MessageInfo;->MSG_DIVIDER_REGEX:Ljava/util/regex/Pattern;

    invoke-static {p0, v7}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v3

    .line 70
    .local v3, "split":[Ljava/lang/String;
    aget-object v7, v3, v6

    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 71
    .local v1, "read":I
    aget-object v7, v3, v5

    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    .line 72
    .local v4, "starred":I
    const/4 v7, 0x2

    aget-object v2, v3, v7

    .line 73
    .local v2, "senders":Ljava/lang/String;
    const/4 v7, 0x3

    aget-object v7, v3, v7

    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 74
    .local v0, "priority":I
    new-instance v8, Lcom/android/mail/providers/MessageInfo;

    if-eqz v1, :cond_0

    move v7, v5

    :goto_0
    if-eqz v4, :cond_1

    :goto_1
    invoke-direct {v8, v7, v5, v2, v0}, Lcom/android/mail/providers/MessageInfo;-><init>(ZZLjava/lang/String;I)V

    return-object v8

    :cond_0
    move v7, v6

    goto :goto_0

    :cond_1
    move v5, v6

    goto :goto_1
.end method

.method public static toString(Lcom/android/mail/providers/MessageInfo;)Ljava/lang/String;
    .locals 4
    .param p0, "info"    # Lcom/android/mail/providers/MessageInfo;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 57
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 58
    .local v0, "builder":Ljava/lang/StringBuilder;
    iget-boolean v1, p0, Lcom/android/mail/providers/MessageInfo;->read:Z

    if-eqz v1, :cond_0

    move v1, v2

    :goto_0
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 59
    const-string v1, "^****^"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 60
    iget-boolean v1, p0, Lcom/android/mail/providers/MessageInfo;->starred:Z

    if-eqz v1, :cond_1

    :goto_1
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 61
    const-string v1, "^****^"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 62
    iget-object v1, p0, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 63
    const-string v1, "^****^"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 64
    iget v1, p0, Lcom/android/mail/providers/MessageInfo;->priority:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 65
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    :cond_0
    move v1, v3

    .line 58
    goto :goto_0

    :cond_1
    move v2, v3

    .line 60
    goto :goto_1
.end method


# virtual methods
.method public hashCode()I
    .locals 3

    .prologue
    .line 79
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-boolean v2, p0, Lcom/android/mail/providers/MessageInfo;->read:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-boolean v2, p0, Lcom/android/mail/providers/MessageInfo;->starred:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public markRead(Z)Z
    .locals 1
    .param p1, "isRead"    # Z

    .prologue
    .line 49
    iget-boolean v0, p0, Lcom/android/mail/providers/MessageInfo;->read:Z

    if-eq v0, p1, :cond_0

    .line 50
    iput-boolean p1, p0, Lcom/android/mail/providers/MessageInfo;->read:Z

    .line 51
    const/4 v0, 0x1

    .line 53
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public set(ZZLjava/lang/String;I)V
    .locals 0
    .param p1, "isRead"    # Z
    .param p2, "isStarred"    # Z
    .param p3, "senderString"    # Ljava/lang/String;
    .param p4, "p"    # I

    .prologue
    .line 42
    iput-boolean p1, p0, Lcom/android/mail/providers/MessageInfo;->read:Z

    .line 43
    iput-boolean p2, p0, Lcom/android/mail/providers/MessageInfo;->starred:Z

    .line 44
    iput-object p3, p0, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    .line 45
    iput p4, p0, Lcom/android/mail/providers/MessageInfo;->priority:I

    .line 46
    return-void
.end method
