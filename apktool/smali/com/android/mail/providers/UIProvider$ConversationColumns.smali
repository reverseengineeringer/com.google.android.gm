.class public final Lcom/android/mail/providers/UIProvider$ConversationColumns;
.super Ljava/lang/Object;
.source "UIProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/providers/UIProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ConversationColumns"
.end annotation


# static fields
.field public static NUM_DRAFTS:Ljava/lang/String;

.field public static NUM_MESSAGES:Ljava/lang/String;

.field public static PRIORITY:Ljava/lang/String;

.field public static READ:Ljava/lang/String;

.field public static SENDING_STATE:Ljava/lang/String;

.field public static STARRED:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 984
    const-string v0, "numMessages"

    sput-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->NUM_MESSAGES:Ljava/lang/String;

    .line 990
    const-string v0, "numDrafts"

    sput-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->NUM_DRAFTS:Ljava/lang/String;

    .line 997
    const-string v0, "sendingState"

    sput-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->SENDING_STATE:Ljava/lang/String;

    .line 1003
    const-string v0, "priority"

    sput-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->PRIORITY:Ljava/lang/String;

    .line 1008
    const-string v0, "read"

    sput-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->READ:Ljava/lang/String;

    .line 1012
    const-string v0, "starred"

    sput-object v0, Lcom/android/mail/providers/UIProvider$ConversationColumns;->STARRED:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 1072
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1073
    return-void
.end method
