.class Lcom/android/mail/ui/ConversationViewState;
.super Ljava/lang/Object;
.source "ConversationViewState.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/ConversationViewState$MessageViewState;,
        Lcom/android/mail/ui/ConversationViewState$ExpansionState;
    }
.end annotation


# static fields
.field public static CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/mail/ui/ConversationViewState;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mConversationInfo:Ljava/lang/String;

.field private final mMessageViewStates:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Landroid/net/Uri;",
            "Lcom/android/mail/ui/ConversationViewState$MessageViewState;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 158
    new-instance v0, Lcom/android/mail/ui/ConversationViewState$1;

    invoke-direct {v0}, Lcom/android/mail/ui/ConversationViewState$1;-><init>()V

    sput-object v0, Lcom/android/mail/ui/ConversationViewState;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 61
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 42
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    .line 61
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 5

    .prologue
    .line 149
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 42
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    .line 150
    const-class v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readBundle(Ljava/lang/ClassLoader;)Landroid/os/Bundle;

    move-result-object v2

    .line 151
    invoke-virtual {v2}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 152
    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    .line 153
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-interface {v4, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 155
    :cond_0
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewState;->mConversationInfo:Ljava/lang/String;

    .line 156
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/android/mail/ui/ConversationViewState$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lcom/android/mail/ui/ConversationViewState$1;

    .prologue
    .line 38
    invoke-direct {p0, p1}, Lcom/android/mail/ui/ConversationViewState;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/ui/ConversationViewState;)V
    .locals 1
    .param p1, "other"    # Lcom/android/mail/ui/ConversationViewState;

    .prologue
    .line 66
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 42
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    .line 67
    iget-object v0, p1, Lcom/android/mail/ui/ConversationViewState;->mConversationInfo:Ljava/lang/String;

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewState;->mConversationInfo:Ljava/lang/String;

    .line 68
    return-void
.end method


# virtual methods
.method public contains(Lcom/android/mail/providers/Message;)Z
    .locals 2
    .param p1, "m"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 130
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    iget-object v1, p1, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 135
    const/4 v0, 0x0

    return v0
.end method

.method public getConversationInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewState;->mConversationInfo:Ljava/lang/String;

    return-object v0
.end method

.method public getExpansionState(Lcom/android/mail/providers/Message;)Ljava/lang/Integer;
    .locals 3
    .param p1, "m"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 92
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    iget-object v2, p1, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    .line 93
    .local v0, "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    if-nez v0, :cond_0

    const/4 v1, 0x0

    :goto_0
    return-object v1

    :cond_0
    iget-object v1, v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;->expansionState:Ljava/lang/Integer;

    goto :goto_0
.end method

.method public getUnreadMessageUris()Ljava/util/Set;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation

    .prologue
    .line 119
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v2

    .line 120
    .local v2, "result":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/net/Uri;

    .line 121
    .local v3, "uri":Landroid/net/Uri;
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    invoke-interface {v4, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    .line 122
    .local v1, "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    if-eqz v1, :cond_0

    iget-boolean v4, v1, Lcom/android/mail/ui/ConversationViewState$MessageViewState;->read:Z

    if-nez v4, :cond_0

    .line 123
    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 126
    .end local v1    # "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    .end local v3    # "uri":Landroid/net/Uri;
    :cond_1
    return-object v2
.end method

.method public isUnread(Lcom/android/mail/providers/Message;)Z
    .locals 3
    .param p1, "m"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 71
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    iget-object v2, p1, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    .line 72
    .local v0, "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    if-eqz v0, :cond_0

    iget-boolean v1, v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;->read:Z

    if-nez v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setExpansionState(Lcom/android/mail/providers/Message;I)V
    .locals 3
    .param p1, "m"    # Lcom/android/mail/providers/Message;
    .param p2, "expansionState"    # I

    .prologue
    .line 97
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    iget-object v2, p1, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    .line 98
    .local v0, "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    if-nez v0, :cond_0

    .line 99
    new-instance v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    .end local v0    # "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    invoke-direct {v0}, Lcom/android/mail/ui/ConversationViewState$MessageViewState;-><init>()V

    .line 101
    .restart local v0    # "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    :cond_0
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;->expansionState:Ljava/lang/Integer;

    .line 102
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    iget-object v2, p1, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 103
    return-void
.end method

.method public setInfoForConversation(Lcom/android/mail/providers/Conversation;)V
    .locals 1
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 110
    iget-object v0, p1, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    invoke-static {v0}, Lcom/android/mail/providers/ConversationInfo;->toString(Lcom/android/mail/providers/ConversationInfo;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationViewState;->mConversationInfo:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public setReadState(Lcom/android/mail/providers/Message;Z)V
    .locals 3
    .param p1, "m"    # Lcom/android/mail/providers/Message;
    .param p2, "read"    # Z

    .prologue
    .line 76
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    iget-object v2, p1, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    .line 77
    .local v0, "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    if-nez v0, :cond_0

    .line 78
    new-instance v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    .end local v0    # "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    invoke-direct {v0}, Lcom/android/mail/ui/ConversationViewState$MessageViewState;-><init>()V

    .line 80
    .restart local v0    # "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    :cond_0
    iput-boolean p2, v0, Lcom/android/mail/ui/ConversationViewState$MessageViewState;->read:Z

    .line 81
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    iget-object v2, p1, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 5
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 140
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 141
    .local v2, "states":Landroid/os/Bundle;
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/net/Uri;

    .line 142
    .local v3, "uri":Landroid/net/Uri;
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewState;->mMessageViewStates:Ljava/util/Map;

    invoke-interface {v4, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/ConversationViewState$MessageViewState;

    .line 143
    .local v1, "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto :goto_0

    .line 145
    .end local v1    # "mvs":Lcom/android/mail/ui/ConversationViewState$MessageViewState;
    .end local v3    # "uri":Landroid/net/Uri;
    :cond_0
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeBundle(Landroid/os/Bundle;)V

    .line 146
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewState;->mConversationInfo:Ljava/lang/String;

    invoke-virtual {p1, v4}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 147
    return-void
.end method
